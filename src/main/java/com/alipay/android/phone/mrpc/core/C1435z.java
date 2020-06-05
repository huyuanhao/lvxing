package com.alipay.android.phone.mrpc.core;

import android.os.Looper;
import com.alipay.android.phone.mrpc.core.p102a.C1401d;
import com.alipay.android.phone.mrpc.core.p102a.C1402e;
import com.alipay.mobile.framework.service.annotation.OperationType;
import com.alipay.mobile.framework.service.annotation.ResetCookie;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: com.alipay.android.phone.mrpc.core.z */
public final class C1435z {
    /* renamed from: a */
    private static final ThreadLocal<Object> f3687a = new ThreadLocal<>();
    /* renamed from: b */
    private static final ThreadLocal<Map<String, Object>> f3688b = new ThreadLocal<>();
    /* renamed from: c */
    private byte f3689c = 0;
    /* renamed from: d */
    private AtomicInteger f3690d;
    /* renamed from: e */
    private C1433x f3691e;

    public C1435z(C1433x xVar) {
        this.f3691e = xVar;
        this.f3690d = new AtomicInteger();
    }

    /* renamed from: a */
    public final Object mo12002a(Method method, Object[] objArr) {
        boolean z = Looper.myLooper() != null && Looper.myLooper() == Looper.getMainLooper();
        if (!z) {
            OperationType operationType = (OperationType) method.getAnnotation(OperationType.class);
            boolean z2 = method.getAnnotation(ResetCookie.class) != null;
            Type genericReturnType = method.getGenericReturnType();
            method.getAnnotations();
            f3687a.set(null);
            f3688b.set(null);
            if (operationType != null) {
                String value = operationType.value();
                int incrementAndGet = this.f3690d.incrementAndGet();
                try {
                    if (this.f3689c == 0) {
                        C1402e eVar = new C1402e(incrementAndGet, value, objArr);
                        if (f3688b.get() != null) {
                            eVar.mo11935a(f3688b.get());
                        }
                        C1418j jVar = new C1418j(this.f3691e.mo11999a(), method, incrementAndGet, value, eVar.mo11936a(), z2);
                        byte[] bArr = (byte[]) jVar.mo11967a();
                        f3688b.set(null);
                        Object a = new C1401d(genericReturnType, bArr).mo11934a();
                        if (genericReturnType != Void.TYPE) {
                            f3687a.set(a);
                        }
                    }
                    return f3687a.get();
                } catch (RpcException e) {
                    e.setOperationType(value);
                    throw e;
                }
            } else {
                throw new IllegalStateException("OperationType must be set.");
            }
        } else {
            throw new IllegalThreadStateException("can't in main thread call rpc .");
        }
    }
}
