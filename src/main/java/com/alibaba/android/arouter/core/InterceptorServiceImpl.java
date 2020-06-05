package com.alibaba.android.arouter.core;

import android.content.Context;
import com.alibaba.android.arouter.exception.HandlerException;
import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.callback.InterceptorCallback;
import com.alibaba.android.arouter.facade.service.InterceptorService;
import com.alibaba.android.arouter.facade.template.IInterceptor;
import com.alibaba.android.arouter.facade.template.ILogger;
import com.alibaba.android.arouter.p043a.ARouter;
import com.alibaba.android.arouter.p044b.CancelableCountDownLatch;
import com.alibaba.android.arouter.p045c.MapUtils;
import java.util.Map.Entry;
import java.util.concurrent.TimeUnit;

public class InterceptorServiceImpl implements InterceptorService {
    /* access modifiers changed from: private|static */
    /* renamed from: a */
    public static boolean f2285a;
    /* access modifiers changed from: private|static|final */
    /* renamed from: b */
    public static final Object f2286b = new Object();

    public void doInterceptions(final Postcard postcard, final InterceptorCallback interceptorCallback) {
        if (Warehouse.f2304f == null || Warehouse.f2304f.size() <= 0) {
            interceptorCallback.onContinue(postcard);
        } else {
            m2170b();
            if (!f2285a) {
                interceptorCallback.onInterrupt(new HandlerException("Interceptors initialization takes too much time."));
                return;
            }
            LogisticsCenter.f2295a.execute(new Runnable() {
                public void run() {
                    CancelableCountDownLatch aVar = new CancelableCountDownLatch(Warehouse.f2304f.size());
                    try {
                        InterceptorServiceImpl.m2171b(0, aVar, postcard);
                        aVar.await((long) postcard.getTimeout(), TimeUnit.SECONDS);
                        if (aVar.getCount() > 0) {
                            interceptorCallback.onInterrupt(new HandlerException("The interceptor processing timed out."));
                        } else if (postcard.getTag() != null) {
                            interceptorCallback.onInterrupt(new HandlerException(postcard.getTag().toString()));
                        } else {
                            interceptorCallback.onContinue(postcard);
                        }
                    } catch (Exception e) {
                        interceptorCallback.onInterrupt(e);
                    }
                }
            });
        }
    }

    /* access modifiers changed from: private|static */
    /* renamed from: b */
    public static void m2171b(final int i, final CancelableCountDownLatch aVar, final Postcard postcard) {
        if (i < Warehouse.f2304f.size()) {
            ((IInterceptor) Warehouse.f2304f.get(i)).process(postcard, new InterceptorCallback() {
                public void onContinue(Postcard postcard) {
                    aVar.countDown();
                    InterceptorServiceImpl.m2171b(i + 1, aVar, postcard);
                }

                public void onInterrupt(Throwable th) {
                    postcard.setTag(th == null ? new HandlerException("No message.") : th.getMessage());
                    aVar.mo10498a();
                }
            });
        }
    }

    public void init(final Context context) {
        LogisticsCenter.f2295a.execute(new Runnable() {
            public void run() {
                if (MapUtils.m2159a(Warehouse.f2303e)) {
                    for (Entry value : Warehouse.f2303e.entrySet()) {
                        Class cls = (Class) value.getValue();
                        try {
                            IInterceptor iInterceptor = (IInterceptor) cls.getConstructor(new Class[0]).newInstance(new Object[0]);
                            iInterceptor.init(context);
                            Warehouse.f2304f.add(iInterceptor);
                        } catch (Exception e) {
                            StringBuilder sb = new StringBuilder();
                            sb.append("ARouter::ARouter init interceptor error! name = [");
                            sb.append(cls.getName());
                            sb.append("], reason = [");
                            sb.append(e.getMessage());
                            sb.append("]");
                            throw new HandlerException(sb.toString());
                        }
                    }
                    InterceptorServiceImpl.f2285a = true;
                    ARouter.f2236a.info(ILogger.defaultTag, "ARouter interceptors init over.");
                    synchronized (InterceptorServiceImpl.f2286b) {
                        InterceptorServiceImpl.f2286b.notifyAll();
                    }
                }
            }
        });
    }

    /* renamed from: b */
    private static void m2170b() {
        synchronized (f2286b) {
            while (!f2285a) {
                try {
                    f2286b.wait(10000);
                } catch (InterruptedException e) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("ARouter::Interceptor init cost too much time error! reason = [");
                    sb.append(e.getMessage());
                    sb.append("]");
                    throw new HandlerException(sb.toString());
                }
            }
        }
    }
}
