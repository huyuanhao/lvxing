package com.tencent.android.tpush.common;

import android.content.ContentValues;
import android.content.Context;
import com.tencent.android.tpush.SettingsContentProvider;
import com.tencent.android.tpush.p579a.C6862b;
import com.tencent.android.tpush.p580b.C6864a;

/* compiled from: ProGuard */
/* renamed from: com.tencent.android.tpush.common.j */
public class C6910j {
    /* renamed from: a */
    public static volatile C6910j f22982a;
    /* renamed from: b */
    private Context f22983b;

    /* compiled from: ProGuard */
    /* renamed from: com.tencent.android.tpush.common.j$a */
    public static class C6912a {
        /* renamed from: a */
        Context f22984a;
        /* renamed from: b */
        private ContentValues f22985b;

        private C6912a(Context context) {
            this.f22985b = new ContentValues();
            this.f22984a = context;
        }

        /* renamed from: a */
        public void mo33116a() {
            try {
                C6862b.m29274a(this.f22984a, SettingsContentProvider.getContentUri(this.f22984a, SettingsContentProvider.KEY, "type"), this.f22985b);
            } catch (Throwable th) {
                C6864a.m29302d("SettingsPreferences", "apply", th);
            }
        }

        /* renamed from: b */
        public void mo33118b() {
            mo33116a();
        }

        /* renamed from: a */
        public C6912a mo33115a(String str, String str2) {
            this.f22985b.put(str, str2);
            return this;
        }

        /* renamed from: a */
        public C6912a mo33114a(String str, long j) {
            this.f22985b.put(str, Long.valueOf(j));
            return this;
        }

        /* renamed from: a */
        public C6912a mo33113a(String str, int i) {
            this.f22985b.put(str, Integer.valueOf(i));
            return this;
        }

        /* renamed from: a */
        public void mo33117a(String str) {
            this.f22985b.putNull(str);
        }
    }

    /* renamed from: a */
    public static C6910j m29490a(Context context) {
        if (f22982a == null) {
            synchronized (C6910j.class) {
                if (f22982a == null) {
                    f22982a = new C6910j(context);
                }
            }
        }
        return f22982a;
    }

    private C6910j(Context context) {
        this.f22983b = context.getApplicationContext();
    }

    /* renamed from: a */
    public C6912a mo33111a() {
        return new C6912a(this.f22983b);
    }

    /* renamed from: a */
    public String mo33112a(String str, String str2) {
        try {
            return SettingsContentProvider.getStringValue(C6862b.m29273a(this.f22983b, SettingsContentProvider.getContentUri(this.f22983b, str, SettingsContentProvider.STRING_TYPE), null, null, null, null), str2);
        } catch (Throwable th) {
            C6864a.m29302d("SettingsPreferences", "error = ", th);
            return "";
        }
    }

    /* renamed from: a */
    public long mo33110a(String str, long j) {
        try {
            return SettingsContentProvider.getLongValue(C6862b.m29273a(this.f22983b, SettingsContentProvider.getContentUri(this.f22983b, str, SettingsContentProvider.LONG_TYPE), null, null, null, null), j);
        } catch (Throwable th) {
            C6864a.m29302d("SettingsPreferences", "error = ", th);
            return 0;
        }
    }

    /* renamed from: a */
    public int mo33109a(String str, int i) {
        try {
            return SettingsContentProvider.getIntValue(C6862b.m29273a(this.f22983b, SettingsContentProvider.getContentUri(this.f22983b, str, SettingsContentProvider.INT_TYPE), null, null, null, null), i);
        } catch (Throwable th) {
            C6864a.m29302d("SettingsPreferences", "error = ", th);
            return 0;
        }
    }
}
