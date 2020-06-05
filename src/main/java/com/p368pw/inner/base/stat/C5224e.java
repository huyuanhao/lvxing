package com.p368pw.inner.base.stat;

import android.content.Context;
import android.text.TextUtils;
import com.p368pw.inner.C5233e;
import com.p368pw.inner.base.p384a.C5125f;
import com.p368pw.inner.base.p387d.C5191i;
import com.p368pw.inner.base.p387d.C5208r;
import com.p368pw.inner.p369a.p370a.p371a.C4823c;
import org.json.JSONObject;

/* renamed from: com.pw.inner.base.stat.e */
public class C5224e {

    /* renamed from: com.pw.inner.base.stat.e$a */
    private static class C5226a {
        /* access modifiers changed from: private|static */
        /* renamed from: a */
        public static C5224e f17018a = new C5224e();
    }

    /* renamed from: a */
    public static C5224e m21525a() {
        return C5226a.f17018a;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public String m21526a(Context context, int i, int i2, String str, int i3, int i4, String str2, boolean z) {
        JSONObject jSONObject = new JSONObject();
        if (i2 == 1) {
            try {
                String a = C5215a.m21489a().mo26887a(context);
                if (!TextUtils.isEmpty(a)) {
                    jSONObject.put("app_list", a);
                }
                jSONObject.put("device_type", C5191i.m21407j(context));
                jSONObject.put("device_brand", C5191i.m21396c());
                jSONObject.put("model", C5191i.m21393b());
            } catch (Throwable unused) {
            }
        }
        if (i2 == 3002) {
            jSONObject.put("video_time", i3);
            jSONObject.put("video_play_time", i4);
        }
        if (!TextUtils.isEmpty(str)) {
            jSONObject.put("offer_id", str);
        }
        if (i2 == 4 && Integer.parseInt(str2) == 3 && !z) {
            jSONObject.put("play_template_type", C5125f.m21216a().mo26727d().mo26690R());
        }
        return jSONObject.toString();
    }

    /* renamed from: a */
    private void m21528a(int i, int i2, String str, int i3, String str2, String str3, int i4, int i5, int i6, int i7, int i8, String str4, String str5, int i9, int i10, String str6, String str7, String str8, int i11, double d, String str9, String str10, String str11, int i12, int i13, String str12, int i14, int i15, boolean z) {
        final int i16 = i;
        final int i17 = i2;
        final String str13 = str;
        final int i18 = i3;
        final String str14 = str2;
        final String str15 = str3;
        final int i19 = i4;
        final int i20 = i5;
        final int i21 = i6;
        final int i22 = i7;
        final int i23 = i8;
        final String str16 = str4;
        final String str17 = str5;
        final int i24 = i9;
        final int i25 = i10;
        final String str18 = str6;
        final String str19 = str7;
        final String str20 = str8;
        final int i26 = i11;
        final double d2 = d;
        final String str21 = str9;
        final String str22 = str10;
        final String str23 = str11;
        final int i27 = i12;
        final int i28 = i13;
        final String str24 = str12;
        final int i29 = i14;
        final int i30 = i15;
        final boolean z2 = z;
        C52251 r0 = new Runnable(this) {
            /* renamed from: D */
            final /* synthetic */ C5224e f16991D;

            {
                this.f16991D = r4;
            }

            public void run() {
                C5218b.m21492a().mo26890a(C5233e.m21559b(), i16, i17, str13, i18, str14, str15, i19, i20, i21, i22, i23, str16, str17, i24, i25, str18, str19, str20, i26, d2, str21, str22, str23, i27, i28, this.f16991D.m21526a(C5233e.m21559b(), i18, i16, str24, i29, i30, str17, z2));
            }
        };
        C5208r.m21482b(r0);
        C4823c.m19722a().mo25768a(C5233e.m21559b(), str3, i3, str9, i, str4, str12);
    }

    /* renamed from: a */
    public void mo26908a(int i, int i2, String str, int i3, String str2, String str3, int i4, int i5, int i6, int i7, int i8, String str4, String str5, int i9, int i10, String str6, String str7, String str8, int i11, double d, String str9, String str10, int i12, int i13, String str11) {
        m21528a(i, i2, str, i3, str2, str3, i4, i5, i6, i7, i8, str4, str5, i9, i10, str6, str7, str8, i11, d, str9, str10, null, i12, i13, str11, 0, 0, true);
    }

    /* renamed from: a */
    public void mo26909a(int i, int i2, String str, int i3, String str2, String str3, int i4, int i5, int i6, int i7, int i8, String str4, String str5, int i9, int i10, String str6, String str7, String str8, int i11, String str9, String str10, String str11, String str12, int i12, int i13) {
        m21528a(i, i2, str, i3, str2, str3, i4, i5, i6, i7, i8, str4, str5, i9, i10, str6, str7, str8, i11, 0.0d, str9, str10, str11, 0, 0, str12, i12, i13, false);
    }

    /* renamed from: a */
    public void mo26910a(Context context) {
        C5218b.m21492a().mo26889a(context);
    }
}
