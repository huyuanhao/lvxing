package com.p530ss.android.socialbase.downloader.p569m;

/* renamed from: com.ss.android.socialbase.downloader.m.j */
public class SqlUtils {
    /* renamed from: a */
    public static StringBuilder m28947a(StringBuilder sb, String str) {
        sb.append('\"');
        sb.append(str);
        sb.append('\"');
        return sb;
    }

    /* renamed from: a */
    public static StringBuilder m28948a(StringBuilder sb, String str, String str2) {
        sb.append(str);
        sb.append(".\"");
        sb.append(str2);
        sb.append('\"');
        return sb;
    }

    /* renamed from: a */
    public static StringBuilder m28950a(StringBuilder sb, String[] strArr) {
        int length = strArr.length;
        for (int i = 0; i < length; i++) {
            sb.append('\"');
            sb.append(strArr[i]);
            sb.append('\"');
            if (i < length - 1) {
                sb.append(',');
            }
        }
        return sb;
    }

    /* renamed from: a */
    public static StringBuilder m28946a(StringBuilder sb, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            if (i2 < i - 1) {
                sb.append("?,");
            } else {
                sb.append('?');
            }
        }
        return sb;
    }

    /* renamed from: b */
    public static StringBuilder m28951b(StringBuilder sb, String[] strArr) {
        for (int i = 0; i < strArr.length; i++) {
            m28947a(sb, strArr[i]).append("=?");
            if (i < strArr.length - 1) {
                sb.append(',');
            }
        }
        return sb;
    }

    /* renamed from: a */
    public static StringBuilder m28949a(StringBuilder sb, String str, String[] strArr) {
        for (int i = 0; i < strArr.length; i++) {
            m28948a(sb, str, strArr[i]).append("=?");
            if (i < strArr.length - 1) {
                sb.append(',');
            }
        }
        return sb;
    }

    /* renamed from: a */
    public static String m28943a(String str, String str2, String[] strArr) {
        StringBuilder sb = new StringBuilder(str);
        sb.append('\"');
        sb.append(str2);
        sb.append('\"');
        sb.append(" (");
        m28950a(sb, strArr);
        sb.append(") VALUES (");
        m28946a(sb, strArr.length);
        sb.append(')');
        return sb.toString();
    }

    /* renamed from: a */
    public static String m28944a(String str, String[] strArr) {
        StringBuilder sb = new StringBuilder();
        sb.append('\"');
        sb.append(str);
        sb.append('\"');
        String sb2 = sb.toString();
        StringBuilder sb3 = new StringBuilder("DELETE FROM ");
        sb3.append(sb2);
        if (strArr != null && strArr.length > 0) {
            sb3.append(" WHERE ");
            m28949a(sb3, sb2, strArr);
        }
        return sb3.toString();
    }

    /* renamed from: a */
    public static String m28945a(String str, String[] strArr, String[] strArr2) {
        StringBuilder sb = new StringBuilder();
        sb.append('\"');
        sb.append(str);
        sb.append('\"');
        String sb2 = sb.toString();
        StringBuilder sb3 = new StringBuilder("UPDATE ");
        sb3.append(sb2);
        sb3.append(" SET ");
        m28951b(sb3, strArr);
        if (strArr2 != null && strArr2.length > 0) {
            sb3.append(" WHERE ");
            m28949a(sb3, sb2, strArr2);
        }
        return sb3.toString();
    }
}
