package com.kwad.sdk.p306a;

import android.text.TextUtils;
import com.kwad.sdk.KsAdSDK;
import com.kwad.sdk.core.p319c.C4065b;
import com.kwad.sdk.core.p330f.C4111a;
import com.tencent.mid.sotrage.StorageInterface;

/* renamed from: com.kwad.sdk.a.g */
public final class C3803g {

    /* renamed from: com.kwad.sdk.a.g$a */
    public static class C3804a {
        /* renamed from: a */
        private int f12917a = -1;
        /* renamed from: b */
        private int f12918b = -1;
        /* renamed from: c */
        private int f12919c = -1;
        /* renamed from: d */
        private int f12920d = -1;
        /* renamed from: e */
        private int f12921e = -1;
        /* renamed from: f */
        private int f12922f = -1;

        public C3804a() {
        }

        public C3804a(int i, int i2) {
            this.f12917a = i;
            this.f12918b = i2;
        }

        /* renamed from: a */
        public int mo23196a() {
            return this.f12917a;
        }

        /* renamed from: a */
        public void mo23197a(float f, float f2) {
            this.f12919c = (int) f;
            this.f12920d = (int) f2;
        }

        /* renamed from: a */
        public void mo23198a(int i, int i2) {
            this.f12917a = i;
            this.f12918b = i2;
        }

        /* renamed from: b */
        public int mo23199b() {
            return this.f12918b;
        }

        /* renamed from: b */
        public void mo23200b(float f, float f2) {
            this.f12921e = (int) f;
            this.f12922f = (int) f2;
        }

        /* renamed from: c */
        public int mo23201c() {
            return this.f12919c;
        }

        /* renamed from: d */
        public int mo23202d() {
            return this.f12920d;
        }

        /* renamed from: e */
        public int mo23203e() {
            return this.f12921e;
        }

        /* renamed from: f */
        public int mo23204f() {
            return this.f12922f;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("[");
            sb.append(this.f12917a);
            String str = StorageInterface.KEY_SPLITER;
            sb.append(str);
            sb.append(this.f12918b);
            sb.append(str);
            sb.append(this.f12919c);
            sb.append(str);
            sb.append(this.f12920d);
            sb.append(str);
            sb.append(this.f12921e);
            sb.append(str);
            sb.append(this.f12922f);
            sb.append("]");
            return sb.toString();
        }
    }

    /* renamed from: a */
    private static String m15761a(int i) {
        return i > -1 ? String.valueOf(i) : "-999";
    }

    /* renamed from: a */
    public static String m15762a(String str, C3804a aVar) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        String str2 = "[";
        sb.append(str2);
        sb.append(Thread.currentThread().getName());
        sb.append("]replaceUrlMacro originalUrl = ");
        sb.append(str);
        String str3 = "MacroReplaceUtils";
        C4065b.m16863a(str3, sb.toString());
        String b = m15763b(str, aVar);
        String j = C3812o.m15842j(KsAdSDK.getContext());
        if (!TextUtils.isEmpty(j)) {
            String str4 = "__MAC3__";
            b = b.replace("__MAC__", j).replace("__MAC2__", C3805h.m15773a(j)).replace(str4, C3805h.m15773a(j.replace(":", "")));
        }
        String d = C3812o.m15830d(KsAdSDK.getContext());
        if (!TextUtils.isEmpty(d)) {
            String str5 = "__IMEI3__";
            b = b.replace("__IMEI__", d).replace("__IMEI2__", C3805h.m15773a(d)).replace(str5, C3805h.m15775b(d));
        }
        String a = C4111a.m17072a();
        if (!TextUtils.isEmpty(a)) {
            b = b.replace("__OAID__", a).replace("__OAID2__", C3805h.m15773a(a));
        }
        String i = C3812o.m15840i(KsAdSDK.getContext());
        if (!TextUtils.isEmpty(i)) {
            String str6 = "__ANDROIDID3__";
            b = b.replace("__ANDROIDID2__", C3805h.m15773a(i)).replace(str6, C3805h.m15775b(i)).replace("__ANDROIDID__", i);
        }
        String replace = b.replace("__TS__", String.valueOf(System.currentTimeMillis()));
        StringBuilder sb2 = new StringBuilder();
        sb2.append(str2);
        sb2.append(Thread.currentThread().getName());
        sb2.append("]replaceUrlMacro replaceUrl = ");
        sb2.append(replace);
        C4065b.m16863a(str3, sb2.toString());
        return replace;
    }

    /* renamed from: b */
    public static String m15763b(String str, C3804a aVar) {
        if (TextUtils.isEmpty(str) || aVar == null) {
            return str;
        }
        return str.replace("__WIDTH__", m15761a(aVar.mo23196a())).replace("__HEIGHT__", m15761a(aVar.mo23199b())).replace("__DOWN_X__", m15761a(aVar.mo23201c())).replace("__DOWN_Y__", m15761a(aVar.mo23202d())).replace("__UP_X__", m15761a(aVar.mo23203e())).replace("__UP_Y__", m15761a(aVar.mo23204f()));
    }
}
