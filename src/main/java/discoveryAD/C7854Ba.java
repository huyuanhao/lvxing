package discoveryAD;

import android.text.TextUtils;
import com.tencent.qqpim.discovery.internal.model.C7491f;

/* renamed from: discoveryAD.Ba */
public class C7854Ba {
    private static final String TAG = "StringCache";
    /* renamed from: sg */
    public static final String f26727sg = "qqse_extStr";
    /* renamed from: tg */
    public static final String f26728tg = "qqse_categoryId";
    /* renamed from: ug */
    public static final String f26729ug = "gdt_qt";

    /* renamed from: a */
    public static String m34158a(int i, String str, String str2) {
        String[] strArr;
        StringBuilder sb = new StringBuilder();
        String str3 = ";;";
        if (TextUtils.isEmpty(str2)) {
            strArr = new String[(i + 1)];
            strArr[i] = str;
        } else {
            strArr = str2.split(str3);
            if (strArr == null || strArr.length == 0) {
                strArr = new String[(i + 1)];
                strArr[i] = str;
            } else if (i < strArr.length) {
                strArr[i] = str;
            } else {
                String[] strArr2 = new String[(i + 1)];
                for (int i2 = 0; i2 < strArr.length; i2++) {
                    strArr2[i2] = strArr[i2];
                }
                strArr2[i] = str;
                strArr = strArr2;
            }
        }
        for (String append : strArr) {
            sb.append(append);
            sb.append(str3);
        }
        C7852Aa.m34154d(TAG, String.format("index=%d\t\tvalue=%s\t\tcontent=%s\t\tre=%s", new Object[]{Integer.valueOf(i), str, str2, sb.toString()}));
        return sb.toString();
    }

    /* renamed from: b */
    public static String m34159b(int i, String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String[] split = str.split(";;");
        if (split == null || i >= split.length || TextUtils.isEmpty(split[i]) || split[i].equalsIgnoreCase("null")) {
            return null;
        }
        return split[i];
    }

    /* renamed from: h */
    public static String m34160h(C7491f fVar) {
        StringBuilder sb = new StringBuilder(fVar.f25087Oa);
        String a = m34158a(3, fVar.uniqueKey, m34158a(2, String.valueOf(fVar.positionId), m34158a(1, fVar.packageName, m34158a(0, f26729ug, null))));
        String str = "?";
        if (fVar.f25087Oa.indexOf(str) < 0) {
            sb.append(str);
        }
        String str2 = "&";
        sb.append(str2);
        sb.append(f26727sg);
        String str3 = "=";
        sb.append(str3);
        sb.append(a);
        sb.append(str2);
        sb.append(f26728tg);
        sb.append(str3);
        sb.append("3021001");
        StringBuilder sb2 = new StringBuilder();
        sb2.append("buildGdtUrl=");
        sb2.append(sb.toString());
        C7852Aa.m34154d(TAG, sb2.toString());
        return sb.toString();
    }
}
