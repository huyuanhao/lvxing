package com.kwad.sdk.core.diskcache.p322b;

import android.content.Context;
import android.text.TextUtils;
import com.kwad.sdk.core.diskcache.p321a.C4070a;
import com.kwad.sdk.core.p319c.C4065b;
import java.io.File;
import java.io.IOException;

/* renamed from: com.kwad.sdk.core.diskcache.b.a */
public class C4079a {
    /* renamed from: a */
    private static C4079a f13720a;
    /* renamed from: b */
    private C4070a f13721b;
    /* renamed from: c */
    private Context f13722c;

    private C4079a() {
    }

    /* renamed from: a */
    public static C4079a m16947a() {
        if (f13720a == null) {
            synchronized (C4079a.class) {
                if (f13720a == null) {
                    f13720a = new C4079a();
                }
            }
        }
        return f13720a;
    }

    /* renamed from: d */
    private boolean m16948d() {
        if (this.f13721b != null) {
            return false;
        }
        C4065b.m16869d("DiskCache", "diskLruCache should be init before use");
        return true;
    }

    /* renamed from: a */
    public void mo23758a(C4080b bVar) {
        if (this.f13721b == null) {
            try {
                this.f13722c = bVar.f13723a;
                if (!bVar.f13726d.exists()) {
                    bVar.f13726d.mkdirs();
                }
                this.f13721b = C4070a.m16895a(bVar.f13726d, bVar.f13724b, 1, bVar.f13725c * 1024 * 1024);
            } catch (IOException e) {
                C4065b.m16865a(e);
            }
        }
    }

    /* renamed from: a */
    public void mo23759a(String str) {
        if (!m16948d() && !TextUtils.isEmpty(str)) {
            C4083c.m16959a(this.f13721b, str, C4085d.m16963a(str));
        }
    }

    /* renamed from: b */
    public File mo23760b() {
        return this.f13721b.mo23736a();
    }

    /* renamed from: b */
    public boolean mo23761b(String str) {
        if (m16948d() || TextUtils.isEmpty(str) || !C4083c.m16961b(this.f13721b, str, C4085d.m16963a(str))) {
            return false;
        }
        File c = mo23762c(str);
        return c != null && c.exists();
    }

    /* renamed from: c */
    public File mo23762c(String str) {
        if (m16948d() || TextUtils.isEmpty(str)) {
            return null;
        }
        return new File(mo23760b(), C4085d.m16963a(str));
    }

    /* renamed from: c */
    public void mo23763c() {
        try {
            this.f13721b.mo23739c();
        } catch (IOException e) {
            C4065b.m16865a(e);
        }
    }
}
