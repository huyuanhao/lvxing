package com.qiyukf.basesdk.p394b.p395a.p404c;

import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.qiyukf.basesdk.C5263a;

/* renamed from: com.qiyukf.basesdk.b.a.c.c */
public final class C5317c {

    /* renamed from: com.qiyukf.basesdk.b.a.c.c$1 */
    static /* synthetic */ class C53181 {
        /* renamed from: a */
        static final /* synthetic */ int[] f17219a = new int[C5319d.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|8) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        static {
            /*
            com.qiyukf.basesdk.b.a.c.d[] r0 = com.qiyukf.basesdk.p394b.p395a.p404c.C5319d.values()
            int r0 = r0.length
            int[] r0 = new int[r0]
            f17219a = r0
            int[] r0 = f17219a     // Catch:{ NoSuchFieldError -> 0x0014 }
            com.qiyukf.basesdk.b.a.c.d r1 = com.qiyukf.basesdk.p394b.p395a.p404c.C5319d.Internal     // Catch:{ NoSuchFieldError -> 0x0014 }
            int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
            r2 = 1
            r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0014 }
        L_0x0014:
            int[] r0 = f17219a     // Catch:{ NoSuchFieldError -> 0x001f }
            com.qiyukf.basesdk.b.a.c.d r1 = com.qiyukf.basesdk.p394b.p395a.p404c.C5319d.Crop     // Catch:{ NoSuchFieldError -> 0x001f }
            int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
            r2 = 2
            r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001f }
        L_0x001f:
            int[] r0 = f17219a     // Catch:{ NoSuchFieldError -> 0x002a }
            com.qiyukf.basesdk.b.a.c.d r1 = com.qiyukf.basesdk.p394b.p395a.p404c.C5319d.External     // Catch:{ NoSuchFieldError -> 0x002a }
            int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002a }
            r2 = 3
            r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002a }
        L_0x002a:
            return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.qiyukf.basesdk.p394b.p395a.p404c.C5317c.C53181.m49440clinit():void");
        }
    }

    /* renamed from: a */
    private static String m21854a() {
        StringBuilder sb = new StringBuilder();
        sb.append("vframe=");
        sb.append(1);
        return sb.toString();
    }

    /* renamed from: a */
    public static final String m21855a(String str) {
        if (TextUtils.isEmpty(null) || C5263a.m21611d() == null || TextUtils.isEmpty(C5263a.m21611d().nosDownload)) {
            return str;
        }
        try {
            String substring = str.substring(0, str.indexOf("/", str.indexOf("://") + 3));
            return substring.endsWith(C5263a.m21611d().nosDownload) ? str.replace(substring, null) : str;
        } catch (Exception unused) {
            return str;
        }
    }

    /* renamed from: a */
    public static final String m21856a(String str, int i, int i2) {
        String str2;
        C5319d dVar = C5319d.Internal;
        if (i2 > 0 && i > 0) {
            dVar = (i > i2 ? i / i2 : i2 / i) > 4 ? C5319d.External : C5319d.Internal;
        }
        int c = C5263a.m21610c();
        if (c <= 0) {
            DisplayMetrics displayMetrics = C5263a.m21607a().getResources().getDisplayMetrics();
            c = Math.min(displayMetrics.widthPixels, displayMetrics.heightPixels) / 2;
        }
        boolean z = false;
        if (c >= 0 && c >= 0) {
            int i3 = C53181.f17219a[dVar.ordinal()];
            if (i3 == 1 ? c > 0 || c > 0 : (i3 == 2 || i3 == 3) && c > 0 && c > 0) {
                z = true;
            }
        }
        if (z) {
            StringBuilder sb = new StringBuilder();
            sb.append("thumbnail=");
            sb.append(c);
            int i4 = C53181.f17219a[dVar.ordinal()];
            if (i4 == 1) {
                str2 = "x";
            } else if (i4 == 2) {
                str2 = "y";
            } else if (i4 == 3) {
                str2 = "z";
            } else {
                StringBuilder sb2 = new StringBuilder("thumb: ");
                sb2.append(dVar);
                throw new IllegalArgumentException(sb2.toString());
            }
            sb.append(str2);
            sb.append(c);
            sb.append("&imageView&type=jpg");
            String str3 = "?";
            if (str.contains(str3)) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append(str);
                sb3.append("&");
                sb3.append(sb.toString());
                return sb3.toString();
            }
            StringBuilder sb4 = new StringBuilder();
            sb4.append(str);
            sb4.append(str3);
            sb4.append(sb.toString());
            return sb4.toString();
        }
        StringBuilder sb5 = new StringBuilder("width=");
        sb5.append(c);
        sb5.append(", height=");
        sb5.append(c);
        throw new IllegalArgumentException(sb5.toString());
    }

    /* renamed from: b */
    public static final String m21857b(String str) {
        String str2 = "?";
        if (str.contains(str2)) {
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append("&");
            sb.append(m21854a());
            return sb.toString();
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(str);
        sb2.append(str2);
        sb2.append(m21854a());
        return sb2.toString();
    }
}
