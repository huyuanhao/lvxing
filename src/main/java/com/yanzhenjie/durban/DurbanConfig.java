package com.yanzhenjie.durban;

import android.content.Context;
import java.util.Locale;

/* renamed from: com.yanzhenjie.durban.a */
public class DurbanConfig {
    /* renamed from: a */
    private Locale f26450a;

    /* compiled from: DurbanConfig */
    /* renamed from: com.yanzhenjie.durban.a$a */
    public static final class C7789a {
        /* access modifiers changed from: private */
        /* renamed from: a */
        public Locale f26451a;

        private C7789a(Context context) {
        }

        /* renamed from: a */
        public C7789a mo37808a(Locale locale) {
            this.f26451a = locale;
            return this;
        }

        /* renamed from: a */
        public DurbanConfig mo37809a() {
            return new DurbanConfig(this);
        }
    }

    /* renamed from: a */
    public static C7789a m33796a(Context context) {
        return new C7789a(context);
    }

    private DurbanConfig(C7789a aVar) {
        this.f26450a = aVar.f26451a;
    }

    /* renamed from: a */
    public Locale mo37807a() {
        return this.f26450a;
    }
}
