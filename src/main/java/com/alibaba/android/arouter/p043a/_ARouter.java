package com.alibaba.android.arouter.p043a;

import android.app.Activity;
import android.app.Application;
import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.widget.Toast;
import androidx.core.app.ActivityCompat;
import com.alibaba.android.arouter.core.LogisticsCenter;
import com.alibaba.android.arouter.exception.HandlerException;
import com.alibaba.android.arouter.exception.InitException;
import com.alibaba.android.arouter.exception.NoRouteFoundException;
import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.callback.InterceptorCallback;
import com.alibaba.android.arouter.facade.callback.NavigationCallback;
import com.alibaba.android.arouter.facade.enums.RouteType;
import com.alibaba.android.arouter.facade.service.AutowiredService;
import com.alibaba.android.arouter.facade.service.DegradeService;
import com.alibaba.android.arouter.facade.service.InterceptorService;
import com.alibaba.android.arouter.facade.service.PathReplaceService;
import com.alibaba.android.arouter.facade.template.ILogger;
import com.alibaba.android.arouter.p044b.DefaultPoolExecutor;
import com.alibaba.android.arouter.p045c.DefaultLogger;
import com.alibaba.android.arouter.p045c.TextUtils;
import java.util.concurrent.ThreadPoolExecutor;

/* renamed from: com.alibaba.android.arouter.a.b */
final class _ARouter {
    /* renamed from: a */
    static ILogger f2239a = new DefaultLogger(ILogger.defaultTag);
    /* renamed from: b */
    private static volatile boolean f2240b = false;
    /* renamed from: c */
    private static volatile boolean f2241c = false;
    /* renamed from: d */
    private static volatile boolean f2242d = false;
    /* renamed from: e */
    private static volatile _ARouter f2243e = null;
    /* renamed from: f */
    private static volatile boolean f2244f = false;
    /* renamed from: g */
    private static volatile ThreadPoolExecutor f2245g = DefaultPoolExecutor.m2151a();
    /* renamed from: h */
    private static Handler f2246h;
    /* access modifiers changed from: private|static */
    /* renamed from: i */
    public static Context f2247i;
    /* renamed from: j */
    private static InterceptorService f2248j;

    /* compiled from: _ARouter */
    /* renamed from: com.alibaba.android.arouter.a.b$4 */
    static /* synthetic */ class C10984 {
        /* renamed from: a */
        static final /* synthetic */ int[] f2262a = new int[RouteType.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(14:0|1|2|3|4|5|6|7|8|9|10|11|12|(3:13|14|16)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(16:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|16) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0040 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x004b */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x002a */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0035 */
        static {
            /*
            com.alibaba.android.arouter.facade.enums.RouteType[] r0 = com.alibaba.android.arouter.facade.enums.RouteType.values()
            int r0 = r0.length
            int[] r0 = new int[r0]
            f2262a = r0
            int[] r0 = f2262a     // Catch:{ NoSuchFieldError -> 0x0014 }
            com.alibaba.android.arouter.facade.enums.RouteType r1 = com.alibaba.android.arouter.facade.enums.RouteType.ACTIVITY     // Catch:{ NoSuchFieldError -> 0x0014 }
            int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
            r2 = 1
            r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0014 }
        L_0x0014:
            int[] r0 = f2262a     // Catch:{ NoSuchFieldError -> 0x001f }
            com.alibaba.android.arouter.facade.enums.RouteType r1 = com.alibaba.android.arouter.facade.enums.RouteType.PROVIDER     // Catch:{ NoSuchFieldError -> 0x001f }
            int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
            r2 = 2
            r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001f }
        L_0x001f:
            int[] r0 = f2262a     // Catch:{ NoSuchFieldError -> 0x002a }
            com.alibaba.android.arouter.facade.enums.RouteType r1 = com.alibaba.android.arouter.facade.enums.RouteType.BOARDCAST     // Catch:{ NoSuchFieldError -> 0x002a }
            int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002a }
            r2 = 3
            r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002a }
        L_0x002a:
            int[] r0 = f2262a     // Catch:{ NoSuchFieldError -> 0x0035 }
            com.alibaba.android.arouter.facade.enums.RouteType r1 = com.alibaba.android.arouter.facade.enums.RouteType.CONTENT_PROVIDER     // Catch:{ NoSuchFieldError -> 0x0035 }
            int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0035 }
            r2 = 4
            r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0035 }
        L_0x0035:
            int[] r0 = f2262a     // Catch:{ NoSuchFieldError -> 0x0040 }
            com.alibaba.android.arouter.facade.enums.RouteType r1 = com.alibaba.android.arouter.facade.enums.RouteType.FRAGMENT     // Catch:{ NoSuchFieldError -> 0x0040 }
            int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0040 }
            r2 = 5
            r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0040 }
        L_0x0040:
            int[] r0 = f2262a     // Catch:{ NoSuchFieldError -> 0x004b }
            com.alibaba.android.arouter.facade.enums.RouteType r1 = com.alibaba.android.arouter.facade.enums.RouteType.METHOD     // Catch:{ NoSuchFieldError -> 0x004b }
            int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x004b }
            r2 = 6
            r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x004b }
        L_0x004b:
            int[] r0 = f2262a     // Catch:{ NoSuchFieldError -> 0x0056 }
            com.alibaba.android.arouter.facade.enums.RouteType r1 = com.alibaba.android.arouter.facade.enums.RouteType.SERVICE     // Catch:{ NoSuchFieldError -> 0x0056 }
            int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0056 }
            r2 = 7
            r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0056 }
        L_0x0056:
            return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.alibaba.android.arouter.p043a._ARouter.C10984.m41308clinit():void");
        }
    }

    private _ARouter() {
    }

    /* renamed from: a */
    protected static synchronized boolean m2140a(Application application) {
        synchronized (_ARouter.class) {
            f2247i = application;
            LogisticsCenter.m2174a(f2247i, f2245g);
            f2239a.info(ILogger.defaultTag, "ARouter init success!");
            f2244f = true;
            f2246h = new Handler(Looper.getMainLooper());
        }
        return true;
    }

    /* renamed from: a */
    protected static _ARouter m2134a() {
        if (f2244f) {
            if (f2243e == null) {
                synchronized (_ARouter.class) {
                    if (f2243e == null) {
                        f2243e = new _ARouter();
                    }
                }
            }
            return f2243e;
        }
        throw new InitException("ARouterCore::Init::Invoke init(context) first!");
    }

    /* renamed from: b */
    static boolean m2143b() {
        return f2241c;
    }

    /* renamed from: a */
    static void m2138a(Object obj) {
        AutowiredService autowiredService = (AutowiredService) ARouter.m2127a().mo10486a("/arouter/service/autowired").navigation();
        if (autowiredService != null) {
            autowiredService.autowire(obj);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public Postcard mo10490a(String str) {
        if (!TextUtils.m2166a((CharSequence) str)) {
            PathReplaceService pathReplaceService = (PathReplaceService) ARouter.m2127a().mo10488a(PathReplaceService.class);
            if (pathReplaceService != null) {
                str = pathReplaceService.forString(str);
            }
            return mo10491a(str, m2142b(str));
        }
        throw new HandlerException("ARouter::Parameter is invalid!");
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public Postcard mo10491a(String str, String str2) {
        if (TextUtils.m2166a((CharSequence) str) || TextUtils.m2166a((CharSequence) str2)) {
            throw new HandlerException("ARouter::Parameter is invalid!");
        }
        PathReplaceService pathReplaceService = (PathReplaceService) ARouter.m2127a().mo10488a(PathReplaceService.class);
        if (pathReplaceService != null) {
            str = pathReplaceService.forString(str);
        }
        return new Postcard(str, str2);
    }

    /* renamed from: b */
    private String m2142b(String str) {
        if (!TextUtils.m2166a((CharSequence) str)) {
            String str2 = "/";
            if (str.startsWith(str2)) {
                try {
                    String substring = str.substring(1, str.indexOf(str2, 1));
                    if (!TextUtils.m2166a((CharSequence) substring)) {
                        return substring;
                    }
                    throw new HandlerException("ARouter::Extract the default group failed! There's nothing between 2 '/'!");
                } catch (Exception e) {
                    ILogger iLogger = f2239a;
                    StringBuilder sb = new StringBuilder();
                    sb.append("Failed to extract default group! ");
                    sb.append(e.getMessage());
                    iLogger.warning(ILogger.defaultTag, sb.toString());
                    return null;
                }
            }
        }
        throw new HandlerException("ARouter::Extract the default group failed, the path must be start with '/' and contain more than 2 '/'!");
    }

    /* renamed from: c */
    static void m2144c() {
        f2248j = (InterceptorService) ARouter.m2127a().mo10486a("/arouter/service/interceptor").navigation();
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public <T> T mo10493a(Class<? extends T> cls) {
        try {
            Postcard a = LogisticsCenter.m2172a(cls.getName());
            if (a == null) {
                a = LogisticsCenter.m2172a(cls.getSimpleName());
            }
            if (a == null) {
                return null;
            }
            LogisticsCenter.m2175a(a);
            return a.getProvider();
        } catch (NoRouteFoundException e) {
            f2239a.warning(ILogger.defaultTag, e.getMessage());
            return null;
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public Object mo10492a(Context context, final Postcard postcard, int i, NavigationCallback navigationCallback) {
        try {
            LogisticsCenter.m2175a(postcard);
            if (navigationCallback != null) {
                navigationCallback.onFound(postcard);
            }
            if (postcard.isGreenChannel()) {
                return m2141b(context, postcard, i, navigationCallback);
            }
            InterceptorService interceptorService = f2248j;
            final Context context2 = context;
            final int i2 = i;
            final NavigationCallback navigationCallback2 = navigationCallback;
            final Postcard postcard2 = postcard;
            C10962 r2 = new InterceptorCallback() {
                public void onContinue(Postcard postcard) {
                    _ARouter.this.m2141b(context2, postcard, i2, navigationCallback2);
                }

                public void onInterrupt(Throwable th) {
                    NavigationCallback navigationCallback = navigationCallback2;
                    if (navigationCallback != null) {
                        navigationCallback.onInterrupt(postcard2);
                    }
                    ILogger iLogger = _ARouter.f2239a;
                    StringBuilder sb = new StringBuilder();
                    sb.append("Navigation failed, termination by interceptor : ");
                    sb.append(th.getMessage());
                    iLogger.info(ILogger.defaultTag, sb.toString());
                }
            };
            interceptorService.doInterceptions(postcard, r2);
            return null;
        } catch (NoRouteFoundException e) {
            f2239a.warning(ILogger.defaultTag, e.getMessage());
            if (m2143b()) {
                m2139a((Runnable) new Runnable() {
                    public void run() {
                        Context d = _ARouter.f2247i;
                        StringBuilder sb = new StringBuilder();
                        sb.append("There's no route matched!\n Path = [");
                        sb.append(postcard.getPath());
                        sb.append("]\n Group = [");
                        sb.append(postcard.getGroup());
                        sb.append("]");
                        Toast.makeText(d, sb.toString(), 1).show();
                    }
                });
            }
            if (navigationCallback != null) {
                navigationCallback.onLost(postcard);
            } else {
                DegradeService degradeService = (DegradeService) ARouter.m2127a().mo10488a(DegradeService.class);
                if (degradeService != null) {
                    degradeService.onLost(context, postcard);
                }
            }
            return null;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public Object m2141b(Context context, Postcard postcard, int i, NavigationCallback navigationCallback) {
        if (context == null) {
            context = f2247i;
        }
        final Context context2 = context;
        int i2 = C10984.f2262a[postcard.getType().ordinal()];
        if (i2 == 1) {
            final Intent intent = new Intent(context2, postcard.getDestination());
            intent.putExtras(postcard.getExtras());
            int flags = postcard.getFlags();
            if (-1 != flags) {
                intent.setFlags(flags);
            } else if (!(context2 instanceof Activity)) {
                intent.setFlags(268435456);
            }
            String action = postcard.getAction();
            if (!TextUtils.m2166a((CharSequence) action)) {
                intent.setAction(action);
            }
            final int i3 = i;
            final Postcard postcard2 = postcard;
            final NavigationCallback navigationCallback2 = navigationCallback;
            C10973 r0 = new Runnable() {
                public void run() {
                    _ARouter.this.m2136a(i3, context2, intent, postcard2, navigationCallback2);
                }
            };
            m2139a((Runnable) r0);
            return null;
        } else if (i2 == 2) {
            return postcard.getProvider();
        } else {
            if (i2 == 3 || i2 == 4 || i2 == 5) {
                try {
                    Object newInstance = postcard.getDestination().getConstructor(new Class[0]).newInstance(new Object[0]);
                    if (newInstance instanceof Fragment) {
                        ((Fragment) newInstance).setArguments(postcard.getExtras());
                    } else if (newInstance instanceof androidx.fragment.app.Fragment) {
                        ((androidx.fragment.app.Fragment) newInstance).setArguments(postcard.getExtras());
                    }
                    return newInstance;
                } catch (Exception e) {
                    ILogger iLogger = f2239a;
                    StringBuilder sb = new StringBuilder();
                    sb.append("Fetch fragment instance error, ");
                    sb.append(TextUtils.m2164a(e.getStackTrace()));
                    iLogger.error(ILogger.defaultTag, sb.toString());
                }
            }
            return null;
        }
    }

    /* renamed from: a */
    private void m2139a(Runnable runnable) {
        if (Looper.getMainLooper().getThread() != Thread.currentThread()) {
            f2246h.post(runnable);
        } else {
            runnable.run();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m2136a(int i, Context context, Intent intent, Postcard postcard, NavigationCallback navigationCallback) {
        if (i < 0) {
            ActivityCompat.startActivity(context, intent, postcard.getOptionsBundle());
        } else if (context instanceof Activity) {
            ActivityCompat.startActivityForResult((Activity) context, intent, i, postcard.getOptionsBundle());
        } else {
            f2239a.warning(ILogger.defaultTag, "Must use [navigation(activity, ...)] to support [startActivityForResult]");
        }
        if (!(-1 == postcard.getEnterAnim() || -1 == postcard.getExitAnim() || !(context instanceof Activity))) {
            ((Activity) context).overridePendingTransition(postcard.getEnterAnim(), postcard.getExitAnim());
        }
        if (navigationCallback != null) {
            navigationCallback.onArrival(postcard);
        }
    }
}
