package com.tmsdk.module.coin;

import android.content.Context;
import java.lang.ref.WeakReference;
import java.util.HashMap;

public class ManagerCreator {
    /* renamed from: O */
    private static volatile ManagerCreator f25888O;
    /* renamed from: P */
    private HashMap<Class<? extends BaseManager>, BaseManager> f25889P = new HashMap<>();
    /* renamed from: Q */
    private HashMap<Class<? extends BaseManager>, WeakReference<? extends BaseManager>> f25890Q = new HashMap<>();
    /* renamed from: R */
    private final Object f25891R = new Object();
    private Context mContext;

    private ManagerCreator(Context context) {
        this.mContext = context.getApplicationContext();
    }

    /* renamed from: B */
    static ManagerCreator m32926B() {
        if (f25888O == null) {
            synchronized (ManagerCreator.class) {
                if (f25888O == null) {
                    f25888O = new ManagerCreator(TMSDKContext.getApplicationContext());
                }
            }
        }
        return f25888O;
    }

    /* renamed from: a */
    private <T extends BaseManager> T m32927a(Class<T> cls) {
        BaseManager baseManager;
        if (!TMSDKContext.isInitialized() || cls == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("_getManager, clazz:[");
            sb.append(cls);
            sb.append("]or maybe tms not initialized");
            TmsLog.m32945w("ManagerCreator", sb.toString());
            return null;
        }
        synchronized (this.f25891R) {
            baseManager = (BaseManager) cls.cast(this.f25889P.get(cls));
            if (baseManager == null) {
                WeakReference weakReference = (WeakReference) this.f25890Q.get(cls);
                if (weakReference != null) {
                    baseManager = (BaseManager) cls.cast(weakReference.get());
                }
            }
            if (baseManager == null) {
                try {
                    BaseManager baseManager2 = (BaseManager) cls.newInstance();
                    try {
                        baseManager2.mo37252h(this.mContext);
                        if (baseManager2.mo37251A() == 1) {
                            this.f25889P.put(cls, baseManager2);
                        } else if (baseManager2.mo37251A() == 0) {
                            this.f25890Q.put(cls, new WeakReference(baseManager2));
                        }
                        baseManager = baseManager2;
                    } catch (Throwable th) {
                        th = th;
                        baseManager = baseManager2;
                        TmsLog.m32940e("ManagerCreator", th.toString());
                        return baseManager;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    TmsLog.m32940e("ManagerCreator", th.toString());
                    return baseManager;
                }
            }
        }
        return baseManager;
    }

    public static <T extends BaseManager> T getManager(Class<T> cls) {
        return m32926B().m32927a(cls);
    }
}
