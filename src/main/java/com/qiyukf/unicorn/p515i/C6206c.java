package com.qiyukf.unicorn.p515i;

import android.text.TextUtils;
import android.util.Base64;
import com.qiyukf.basesdk.p393a.C5264a;
import com.qiyukf.nimlib.p488k.p491c.C5946c;
import com.qiyukf.unicorn.C6029d;
import com.qiyukf.unicorn.p499b.C6014b;
import com.qiyukf.unicorn.p503f.C6168c;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Locale;
import org.json.JSONObject;

/* renamed from: com.qiyukf.unicorn.i.c */
final class C6206c {
    /* renamed from: a */
    static String m24625a(String str, CharSequence charSequence, String str2, int i, long j, String str3, JSONObject jSONObject) {
        String str4;
        String d = C6029d.m24043d();
        String g = C6014b.m23958g();
        if (TextUtils.isEmpty(g)) {
            g = C6014b.m23948d();
        }
        String valueOf = String.valueOf(j);
        String charSequence2 = charSequence.toString();
        String str5 = i == 0 ? "0" : "1";
        if (jSONObject != null) {
            str4 = String.format(Locale.getDefault(), "ak=%s&dv=%s&cup=%s&tm=%s&ct=%s&lt=%s&tp=%s&desc=%s&u=%s", new Object[]{d, g, str, valueOf, charSequence2, str5, str3, jSONObject.toString(), str2});
        } else {
            str4 = String.format(Locale.getDefault(), "ak=%s&dv=%s&cup=%s&tm=%s&ct=%s&lt=%s&tp=%s&u=%s", new Object[]{d, g, str, valueOf, charSequence2, str5, str3, str2});
        }
        StringBuilder sb = new StringBuilder("track record: ");
        sb.append(str4);
        C5264a.m21617a("StatisticsManager", sb.toString());
        return Base64.encodeToString(str4.getBytes(), 2);
    }

    /* renamed from: a */
    private static void m24626a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /* renamed from: a */
    static void m24627a(String str, String str2) {
        if (m24628a(str)) {
            int a = C6168c.m24473a(str2);
            if (a != 200) {
                StringBuilder sb = new StringBuilder("upload error");
                sb.append(a);
                C5264a.m21617a("StatisticsUtils", sb.toString());
            }
            return;
        }
        m24629b(str, str2);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0068, code lost:
            if (r7.length() <= 0) goto L_0x0087;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x006a, code lost:
            r7.deleteCharAt(r7.length() - 1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x007a, code lost:
            if (com.qiyukf.unicorn.p503f.C6168c.m24473a(r7.toString()) != 200) goto L_0x0083;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x007c, code lost:
            r0.delete();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x007f, code lost:
            m24626a((java.io.Closeable) r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0082, code lost:
            return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0083, code lost:
            m24626a((java.io.Closeable) r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0086, code lost:
            return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0087, code lost:
            m24626a((java.io.Closeable) r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x008a, code lost:
            return true;
     */
    /* renamed from: a */
    static boolean m24628a(java.lang.String r7) {
        /*
        boolean r0 = android.text.TextUtils.isEmpty(r7)
        r1 = 1
        if (r0 == 0) goto L_0x0008
        return r1
    L_0x0008:
        java.io.File r0 = new java.io.File
        r0.<init>(r7)
        boolean r7 = r0.exists()
        if (r7 == 0) goto L_0x009f
        long r2 = r0.length()
        r4 = 0
        int r7 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
        if (r7 != 0) goto L_0x001f
        goto L_0x009f
    L_0x001f:
        java.lang.StringBuilder r7 = new java.lang.StringBuilder
        r7.<init>()
        r2 = 0
        r3 = 0
        java.io.BufferedReader r4 = new java.io.BufferedReader     // Catch:{ IOException -> 0x0093 }
        java.io.FileReader r5 = new java.io.FileReader     // Catch:{ IOException -> 0x0093 }
        r5.<init>(r0)     // Catch:{ IOException -> 0x0093 }
        r4.<init>(r5)     // Catch:{ IOException -> 0x0093 }
    L_0x0030:
        java.lang.String r2 = r4.readLine()     // Catch:{ IOException -> 0x008d, all -> 0x008b }
        r5 = 200(0xc8, float:2.8E-43)
        if (r2 == 0) goto L_0x0064
        r7.append(r2)     // Catch:{ IOException -> 0x008d, all -> 0x008b }
        java.lang.String r2 = ","
        r7.append(r2)     // Catch:{ IOException -> 0x008d, all -> 0x008b }
        int r2 = r7.length()     // Catch:{ IOException -> 0x008d, all -> 0x008b }
        r6 = 6000(0x1770, float:8.408E-42)
        if (r2 < r6) goto L_0x0030
        int r2 = r7.length()     // Catch:{ IOException -> 0x008d, all -> 0x008b }
        int r2 = r2 - r1
        r7.deleteCharAt(r2)     // Catch:{ IOException -> 0x008d, all -> 0x008b }
        java.lang.String r7 = r7.toString()     // Catch:{ IOException -> 0x008d, all -> 0x008b }
        int r7 = com.qiyukf.unicorn.p503f.C6168c.m24473a(r7)     // Catch:{ IOException -> 0x008d, all -> 0x008b }
        if (r7 != r5) goto L_0x0060
        java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x008d, all -> 0x008b }
        r7.<init>()     // Catch:{ IOException -> 0x008d, all -> 0x008b }
        goto L_0x0030
    L_0x0060:
        m24626a(r4)
        return r3
    L_0x0064:
        int r2 = r7.length()     // Catch:{ IOException -> 0x008d, all -> 0x008b }
        if (r2 <= 0) goto L_0x0087
        int r2 = r7.length()     // Catch:{ IOException -> 0x008d, all -> 0x008b }
        int r2 = r2 - r1
        r7.deleteCharAt(r2)     // Catch:{ IOException -> 0x008d, all -> 0x008b }
        java.lang.String r7 = r7.toString()     // Catch:{ IOException -> 0x008d, all -> 0x008b }
        int r7 = com.qiyukf.unicorn.p503f.C6168c.m24473a(r7)     // Catch:{ IOException -> 0x008d, all -> 0x008b }
        if (r7 != r5) goto L_0x0083
        r0.delete()     // Catch:{ IOException -> 0x008d, all -> 0x008b }
        m24626a(r4)
        return r1
    L_0x0083:
        m24626a(r4)
        return r3
    L_0x0087:
        m24626a(r4)
        return r1
    L_0x008b:
        r7 = move-exception
        goto L_0x009b
    L_0x008d:
        r7 = move-exception
        r2 = r4
        goto L_0x0094
    L_0x0090:
        r7 = move-exception
        r4 = r2
        goto L_0x009b
    L_0x0093:
        r7 = move-exception
    L_0x0094:
        r7.printStackTrace()     // Catch:{ all -> 0x0090 }
        m24626a(r2)
        return r3
    L_0x009b:
        m24626a(r4)
        throw r7
    L_0x009f:
        return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qiyukf.unicorn.p515i.C6206c.m24628a(java.lang.String):boolean");
    }

    /* renamed from: b */
    static void m24629b(String str, String str2) {
        if (!TextUtils.isEmpty(str)) {
            File file = new File(str);
            if (!file.exists()) {
                file.getParentFile().mkdirs();
            } else if (!file.isFile()) {
                C5946c.m23836a(file);
            }
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file, true));
            if (file.length() > 0) {
                bufferedWriter.append("\n");
            }
            bufferedWriter.append(str2);
            bufferedWriter.flush();
            bufferedWriter.close();
            if (file.length() >= 6000) {
                m24628a(str);
            }
        }
    }
}
