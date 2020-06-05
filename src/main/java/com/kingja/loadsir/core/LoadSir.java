package com.kingja.loadsir.core;

import com.kingja.loadsir.LoadSirUtil;
import com.kingja.loadsir.callback.Callback;
import com.kingja.loadsir.callback.Callback.OnReloadListener;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.kingja.loadsir.core.c */
public class LoadSir {
    /* renamed from: a */
    private static volatile LoadSir f12353a;
    /* renamed from: b */
    private C3599a f12354b = new C3599a();

    /* compiled from: LoadSir */
    /* renamed from: com.kingja.loadsir.core.c$a */
    public static class C3599a {
        /* renamed from: a */
        private List<Callback> f12355a = new ArrayList();
        /* renamed from: b */
        private Class<? extends Callback> f12356b;

        /* renamed from: a */
        public C3599a mo22633a(Callback callback) {
            this.f12355a.add(callback);
            return this;
        }

        /* renamed from: a */
        public C3599a mo22634a(Class<? extends Callback> cls) {
            this.f12356b = cls;
            return this;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public List<Callback> mo22635a() {
            return this.f12355a;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: b */
        public Class<? extends Callback> mo22636b() {
            return this.f12356b;
        }

        /* renamed from: c */
        public void mo22637c() {
            LoadSir.m14996a().m14997a(this);
        }
    }

    /* renamed from: a */
    public static LoadSir m14996a() {
        if (f12353a == null) {
            synchronized (LoadSir.class) {
                if (f12353a == null) {
                    f12353a = new LoadSir();
                }
            }
        }
        return f12353a;
    }

    private LoadSir() {
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m14997a(C3599a aVar) {
        this.f12354b = aVar;
    }

    /* renamed from: a */
    public LoadService mo22631a(Object obj, OnReloadListener onReloadListener) {
        return mo22632a(obj, onReloadListener, null);
    }

    /* renamed from: a */
    public <T> LoadService mo22632a(Object obj, OnReloadListener onReloadListener, Convertor<T> aVar) {
        return new LoadService(aVar, LoadSirUtil.m14975a(obj), onReloadListener, this.f12354b);
    }

    /* renamed from: b */
    public static C3599a m14999b() {
        return new C3599a();
    }
}
