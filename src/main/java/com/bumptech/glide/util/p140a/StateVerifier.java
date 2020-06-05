package com.bumptech.glide.util.p140a;

/* renamed from: com.bumptech.glide.util.a.c */
public abstract class StateVerifier {

    /* compiled from: StateVerifier */
    /* renamed from: com.bumptech.glide.util.a.c$a */
    private static class C1769a extends StateVerifier {
        /* renamed from: a */
        private volatile boolean f4904a;

        C1769a() {
            super();
        }

        /* renamed from: b */
        public void mo13207b() {
            if (this.f4904a) {
                throw new IllegalStateException("Already released");
            }
        }

        /* renamed from: a */
        public void mo13206a(boolean z) {
            this.f4904a = z;
        }
    }

    /* renamed from: a */
    public abstract void mo13206a(boolean z);

    /* renamed from: b */
    public abstract void mo13207b();

    /* renamed from: a */
    public static StateVerifier m6111a() {
        return new C1769a();
    }

    private StateVerifier() {
    }
}
