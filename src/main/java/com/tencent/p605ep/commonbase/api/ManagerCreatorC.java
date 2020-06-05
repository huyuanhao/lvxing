package com.tencent.p605ep.commonbase.api;

import android.content.Context;
import java.lang.ref.WeakReference;
import java.util.HashMap;

/* renamed from: com.tencent.ep.commonbase.api.ManagerCreatorC */
public final class ManagerCreatorC {
    /* renamed from: e */
    private static volatile ManagerCreatorC f24718e;
    /* renamed from: a */
    private HashMap<Class<? extends BaseManager>, BaseManager> f24719a = new HashMap<>();
    /* renamed from: b */
    private HashMap<Class<? extends BaseManager>, WeakReference<? extends BaseManager>> f24720b = new HashMap<>();
    /* renamed from: c */
    private Context f24721c;
    /* renamed from: d */
    private final Object f24722d = new Object();

    private ManagerCreatorC(Context context) {
        this.f24721c = context.getApplicationContext();
    }

    /* renamed from: a */
    private <T extends BaseManagerC> T m31489a(Class<T> cls) {
        T t;
        if (cls != null) {
            synchronized (this.f24722d) {
                t = (BaseManagerC) cls.cast(this.f24719a.get(cls));
                if (t == null) {
                    WeakReference weakReference = (WeakReference) this.f24720b.get(cls);
                    if (weakReference != null) {
                        t = (BaseManagerC) cls.cast(weakReference.get());
                    }
                }
                if (t == null) {
                    try {
                        t = (BaseManagerC) cls.newInstance();
                        t.onCreate(this.f24721c);
                        if (t.getSingletonType() == 1) {
                            this.f24719a.put(cls, t);
                        } else if (t.getSingletonType() == 0) {
                            this.f24720b.put(cls, new WeakReference(t));
                        }
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                }
            }
            return t;
        }
        throw new NullPointerException("the param of getManager can't be null.");
    }

    /* renamed from: a */
    static ManagerCreatorC m31490a() {
        if (f24718e == null) {
            synchronized (ManagerCreatorC.class) {
                if (f24718e == null) {
                    f24718e = new ManagerCreatorC(AppContext.context);
                }
            }
        }
        return f24718e;
    }

    public static <T extends BaseManagerC> T getManager(Class<T> cls) {
        return m31490a().m31489a(cls);
    }
}
