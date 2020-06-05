package com.p368pw.inner.base.stat;

import android.content.Context;
import android.os.Build.VERSION;
import com.p368pw.inner.C5237f;
import com.p368pw.inner.C5238g;
import com.p368pw.inner.base.p384a.C5125f;
import com.p368pw.inner.base.p387d.C5191i;
import com.p368pw.inner.base.p387d.C5204n;
import com.p368pw.inner.base.p387d.C5205o;
import com.p368pw.inner.base.p387d.C5207q;
import com.p368pw.inner.base.p387d.C5208r;
import com.p368pw.inner.base.p387d.C5213t;
import iko.dmaz.lloq.C8058a;
import iko.dmaz.lloq.C8063c;
import iko.dmaz.lloq.C8064d;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;
import org.json.JSONObject;
import org.p703a.C8553c;

/* renamed from: com.pw.inner.base.stat.b */
public class C5218b {

    /* renamed from: com.pw.inner.base.stat.b$a */
    private static class C5221a {
        /* access modifiers changed from: private|static */
        /* renamed from: a */
        public static C5218b f16972a = new C5218b();
    }

    /* renamed from: a */
    public static C5218b m21492a() {
        return C5221a.f16972a;
    }

    /* renamed from: a */
    private static String m21493a(Context context, String str) {
        if (context != null && !C5207q.m21476a((CharSequence) str)) {
            try {
                return context.getPackageManager().getInstallerPackageName(str);
            } catch (Throwable th) {
                C5205o.m21464a(th);
            }
        }
        return null;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m21495a(Context context, CmmBean cmmBean) {
        try {
            ArrayList arrayList = new ArrayList();
            arrayList.add(cmmBean);
            C8058a aVar = new C8058a("djkg*6H#wr21K9G", "http://stat.zhizh.com", "/http/v1/send/hide/ip", new C8063c() {
                /* renamed from: a */
                public String mo26893a(Object obj) {
                    return C8553c.m36952b(obj);
                }
            }, true);
            new C8064d(CmmBean.class, "d1c80c50-3ef5-46cb-bccf-691d27ee1ee7", aVar, false).mo38807a((List<T>) arrayList);
        } catch (Throwable th) {
            C5205o.m21464a(th);
        }
    }

    /* renamed from: b */
    private String m21497b(Context context) {
        String str = "";
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("cpu", str);
            jSONObject.put("men", str);
            str = jSONObject.toString();
            return str;
        } catch (Throwable unused) {
            return str;
        }
    }

    /* access modifiers changed from: private|static */
    /* renamed from: b */
    public static String m21498b(CmmBean cmmBean) {
        return C5204n.m21460a(cmmBean);
    }

    /* renamed from: a */
    public CmmBean mo26888a(Context context, int i, int i2, String str, int i3, String str2, String str3, int i4, int i5, int i6, int i7, int i8, String str4, String str5, int i9, int i10, String str6, String str7, String str8) {
        String str9 = "GMT+08";
        String str10 = "";
        CmmBean cmmBean = new CmmBean();
        try {
            cmmBean.setService_version(Integer.valueOf(13));
            cmmBean.setData_version(Integer.valueOf(13));
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            simpleDateFormat.setTimeZone(TimeZone.getTimeZone(str9));
            cmmBean.setCreate_date(String.valueOf(simpleDateFormat.format(new Date())));
            cmmBean.setAndroid_id(C5191i.m21387a(context));
            SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            simpleDateFormat2.setTimeZone(TimeZone.getTimeZone(str9));
            cmmBean.setLog_time(String.valueOf(simpleDateFormat2.format(new Date())));
            cmmBean.setAppkey(C5238g.m21604a(context));
            cmmBean.setChannel_code(C5237f.m21578b(context));
            cmmBean.setCountry_code_client(C5191i.m21399d(context));
            cmmBean.setLanguage(C5191i.m21409l(context));
            cmmBean.setOs_version_code(String.valueOf(VERSION.SDK_INT));
            cmmBean.setOs_version_name(VERSION.RELEASE);
            cmmBean.setProduct_version_code(String.valueOf(C5191i.m21402f(context)));
            cmmBean.setProduct_version_name(C5191i.m21404g(context));
            cmmBean.setSdk_version_code(String.valueOf(30132));
            cmmBean.setSdk_version_name("win_2.7.2");
            cmmBean.setDynamic_info(m21497b(context));
            cmmBean.setImei_id(C5191i.m21416s(context));
            cmmBean.setProvince(str10);
            cmmBean.setCity(str10);
            cmmBean.setLongitude(C5191i.m21414q(context));
            cmmBean.setLatitude(C5191i.m21413p(context));
            cmmBean.setEvent_type(Integer.valueOf(i));
            cmmBean.setResult(Integer.valueOf(i2));
            String str11 = str;
            cmmBean.setRemark(str);
            cmmBean.setAds_source(Integer.valueOf(i3));
            String str12 = str2;
            cmmBean.setPlacement_id(str2);
            String str13 = str3;
            cmmBean.setInter_placement_id(str3);
            cmmBean.setBusiness_id(Integer.valueOf(i4));
            cmmBean.setGroup_id(Integer.valueOf(i5));
            cmmBean.setPlan_id(Integer.valueOf(i6));
            cmmBean.setConf_id(Integer.valueOf(i7));
            cmmBean.setUk(str10);
            cmmBean.setVf_time(Integer.valueOf(i8));
            cmmBean.setRequest_id(str4);
            cmmBean.setPlacement_type(str5);
            cmmBean.setAd_template_type(Integer.valueOf(i9));
            cmmBean.setAds_purpose(String.valueOf(i10));
            cmmBean.setOa_id(C5191i.m21387a(context));
            cmmBean.setOrder_id(str6);
            cmmBean.setEnd_template_type(str7);
            cmmBean.setRetention_template_type(str8);
            cmmBean.setTask_source(Integer.valueOf(-1));
            cmmBean.setAward_amount(Double.valueOf(0.0d));
        } catch (Throwable th) {
            C5205o.m21464a(th);
        }
        return cmmBean;
    }

    /* renamed from: a */
    public void mo26889a(Context context) {
    }

    /* renamed from: a */
    public void mo26890a(Context context, int i, int i2, String str, int i3, String str2, String str3, int i4, int i5, int i6, int i7, int i8, String str4, String str5, int i9, int i10, String str6, String str7, String str8, int i11, double d, String str9, String str10, String str11, int i12, int i13, String str12) {
        final Context context2 = context;
        final int i14 = i;
        final int i15 = i2;
        final String str13 = str;
        final int i16 = i3;
        final String str14 = str2;
        final String str15 = str3;
        final int i17 = i4;
        final int i18 = i5;
        final int i19 = i6;
        final int i20 = i7;
        final int i21 = i8;
        final String str16 = str4;
        final String str17 = str5;
        final int i22 = i9;
        final int i23 = i10;
        final String str18 = str6;
        final String str19 = str7;
        final String str20 = str8;
        final int i24 = i11;
        final double d2 = d;
        final String str21 = str9;
        final String str22 = str10;
        final String str23 = str11;
        final int i25 = i12;
        final int i26 = i13;
        final String str24 = str12;
        C52191 r0 = new Runnable(this) {
            /* renamed from: B */
            final /* synthetic */ C5218b f16944B;

            {
                this.f16944B = r4;
            }

            public void run() {
                C5218b bVar = this.f16944B;
                Context context = context2;
                C5218b bVar2 = bVar;
                Context context2 = context;
                CmmBean b = bVar2.mo26891b(context2, i14, i15, str13, i16, str14, str15, i17, i18, i19, i20, i21, str16, str17, i22, i23, str18, str19, str20, i24, d2, str21, str22, str23, i25, i26, str24);
                StringBuilder sb = new StringBuilder();
                sb.append("大数据：");
                sb.append(C5218b.m21498b(b));
                C5205o.m21462a(sb.toString());
                this.f16944B.m21495a(context2, b);
            }
        };
        C5208r.m21482b(r0);
    }

    /* renamed from: b */
    public CmmBean mo26891b(Context context, int i, int i2, String str, int i3, String str2, String str3, int i4, int i5, int i6, int i7, int i8, String str4, String str5, int i9, int i10, String str6, String str7, String str8, int i11, double d, String str9, String str10, String str11, int i12, int i13, String str12) {
        String str13 = str5;
        String str14 = str9;
        CmmBean a = mo26888a(context, i, i2, str, i3, str2, str3, i4, i5, i6, i7, i8, str4, str5, i9, i10, str6, str7, str8);
        a.setTask_source(Integer.valueOf(i11));
        a.setAward_amount(Double.valueOf(d));
        a.setAd_package(str14);
        a.setAd_package_name(str10);
        a.setImage_url(str11);
        a.setInstall_source_name("");
        a.setInstall_source_type(Integer.valueOf(-1));
        a.setTask_type(Integer.valueOf(i12));
        a.setRetention_status(Integer.valueOf(i13));
        a.setEvent_info(str12);
        if (C5213t.m21487a(str13, "5")) {
            a.setAd_template_url(C5125f.m21216a().mo26727d().mo26707k());
        }
        if (C5213t.m21487a(str13, "2") || C5213t.m21487a(str13, "4")) {
            a.setAd_template_url(C5125f.m21216a().mo26727d().mo26704h());
        }
        if (i == 7) {
            int i14 = 1;
            if (i2 == 1 && C5207q.m21478b((CharSequence) str9)) {
                Context context2 = context;
                String a2 = m21493a(context, str14);
                if (C5207q.m21478b((CharSequence) a2)) {
                    a.setInstall_source_name(a2);
                    if (!a2.contains("installer") && !a2.equals(str14)) {
                        i14 = 0;
                    }
                    a.setInstall_source_type(Integer.valueOf(i14));
                }
            }
        }
        return a;
    }
}
