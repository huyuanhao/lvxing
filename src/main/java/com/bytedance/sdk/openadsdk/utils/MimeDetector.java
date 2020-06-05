package com.bytedance.sdk.openadsdk.utils;

import android.content.Context;
import android.text.TextUtils;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* renamed from: com.bytedance.sdk.openadsdk.utils.v */
public class MimeDetector {
    /* renamed from: c */
    private static volatile MimeDetector f9189c;
    /* renamed from: a */
    private Map<String, String> f9190a;
    /* renamed from: b */
    private volatile boolean f9191b = false;
    /* access modifiers changed from: private */
    /* renamed from: d */
    public Context f9192d;

    /* renamed from: a */
    public static String m12230a(Context context, String str) {
        if (str != null) {
            try {
                if (str.startsWith("http") && str.contains("?")) {
                    str = str.split("\\?")[0];
                    if (str.endsWith("/")) {
                        str = str.substring(0, str.length() - 1);
                    }
                }
            } catch (Throwable unused) {
            }
        }
        return m12229a(context).mo16950a(str);
    }

    /* renamed from: a */
    static MimeDetector m12229a(Context context) {
        if (f9189c == null) {
            synchronized (MimeDetector.class) {
                if (f9189c == null) {
                    f9189c = new MimeDetector(context);
                }
            }
        }
        return f9189c;
    }

    private MimeDetector(Context context) {
        if (context != null && this.f9192d == null) {
            this.f9192d = context.getApplicationContext();
            m12231a();
        }
        this.f9192d = context;
    }

    /* renamed from: a */
    public final String mo16950a(String str) {
        String str2 = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String d = m12236d(str);
        if (!TextUtils.isEmpty(d)) {
            str2 = m12234b(d);
        }
        return str2;
    }

    /* renamed from: b */
    private static String m12234b(String str) {
        String str2;
        int indexOf = str.indexOf(47);
        int indexOf2 = str.indexOf(59);
        if (indexOf < 0) {
            return null;
        }
        String lowerCase = str.substring(0, indexOf).trim().toLowerCase(Locale.ENGLISH);
        if (!m12235c(lowerCase)) {
            return null;
        }
        int i = indexOf + 1;
        if (indexOf2 < 0) {
            str2 = str.substring(i);
        } else {
            str2 = str.substring(i, indexOf2);
        }
        String lowerCase2 = str2.trim().toLowerCase(Locale.ENGLISH);
        if (!m12235c(lowerCase2)) {
            return null;
        }
        StringBuilder sb = new StringBuilder(lowerCase.length() + lowerCase2.length() + 1);
        sb.append(lowerCase);
        sb.append('/');
        sb.append(lowerCase2);
        return sb.toString();
    }

    /* renamed from: a */
    private static boolean m12233a(char c) {
        return c > ' ' && c < 127 && "()<>@,;:/[]?=\\\"".indexOf(c) < 0;
    }

    /* renamed from: c */
    private static boolean m12235c(String str) {
        int length = str.length();
        if (length == 0) {
            return false;
        }
        for (int i = 0; i < length; i++) {
            if (!m12233a(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: d */
    private String m12236d(String str) {
        String str2;
        String e = m12237e(str);
        if (e.isEmpty()) {
            return null;
        }
        m12231a();
        Map<String, String> map = this.f9190a;
        if (map == null || map.isEmpty()) {
            return null;
        }
        do {
            str2 = (String) this.f9190a.get(e);
            if (str2 == null) {
                e = m12237e(e);
            }
            if (str2 != null) {
                break;
            }
        } while (!e.isEmpty());
        return str2;
    }

    /* renamed from: e */
    private static String m12237e(String str) {
        if (str != null && !str.isEmpty()) {
            int indexOf = str.indexOf(46);
            if (indexOf >= 0 && indexOf < str.length() - 1) {
                return str.substring(indexOf + 1);
            }
        }
        return "";
    }

    /* renamed from: a */
    private void m12231a() {
        if (this.f9192d != null && !this.f9191b) {
            synchronized (this) {
                if (!this.f9191b) {
                    List<String> list = (List) AccessController.doPrivileged(new PrivilegedAction<List<String>>() {
                        /* JADX WARNING: Failed to process nested try/catch */
                        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0035 */
                        /* JADX WARNING: Removed duplicated region for block: B:28:0x0043 A[SYNTHETIC, Splitter:B:28:0x0043] */
                        /* JADX WARNING: Removed duplicated region for block: B:32:0x004a A[SYNTHETIC, Splitter:B:32:0x004a] */
                        /* renamed from: a */
                        public java.util.List<java.lang.String> run() {
                            /*
                            r5 = this;
                            r0 = 0
                            java.util.ArrayList r1 = new java.util.ArrayList     // Catch:{ all -> 0x003c }
                            r1.<init>()     // Catch:{ all -> 0x003c }
                            com.bytedance.sdk.openadsdk.utils.v r2 = com.bytedance.sdk.openadsdk.utils.MimeDetector.this     // Catch:{ all -> 0x003c }
                            android.content.Context r2 = r2.f9192d     // Catch:{ all -> 0x003c }
                            android.content.res.AssetManager r2 = r2.getAssets()     // Catch:{ all -> 0x003c }
                            java.lang.String r3 = "tt_mime_type.pro"
                            java.io.InputStream r2 = r2.open(r3)     // Catch:{ all -> 0x003c }
                            java.io.BufferedReader r3 = new java.io.BufferedReader     // Catch:{ all -> 0x0039 }
                            java.io.InputStreamReader r4 = new java.io.InputStreamReader     // Catch:{ all -> 0x0039 }
                            r4.<init>(r2)     // Catch:{ all -> 0x0039 }
                            r3.<init>(r4)     // Catch:{ all -> 0x0039 }
                        L_0x0020:
                            java.lang.String r0 = r3.readLine()     // Catch:{ all -> 0x003a }
                            if (r0 == 0) goto L_0x0030
                            boolean r4 = android.text.TextUtils.isEmpty(r0)     // Catch:{ all -> 0x003a }
                            if (r4 != 0) goto L_0x0020
                            r1.add(r0)     // Catch:{ all -> 0x003a }
                            goto L_0x0020
                        L_0x0030:
                            if (r2 == 0) goto L_0x0035
                            r2.close()     // Catch:{ all -> 0x0035 }
                        L_0x0035:
                            r3.close()     // Catch:{ all -> 0x0038 }
                        L_0x0038:
                            return r1
                        L_0x0039:
                            r3 = r0
                        L_0x003a:
                            r0 = r2
                            goto L_0x003d
                        L_0x003c:
                            r3 = r0
                        L_0x003d:
                            java.util.List r1 = java.util.Collections.emptyList()     // Catch:{ all -> 0x004e }
                            if (r0 == 0) goto L_0x0048
                            r0.close()     // Catch:{ all -> 0x0047 }
                            goto L_0x0048
                        L_0x0048:
                            if (r3 == 0) goto L_0x004d
                            r3.close()     // Catch:{ all -> 0x004d }
                        L_0x004d:
                            return r1
                        L_0x004e:
                            r1 = move-exception
                            if (r0 == 0) goto L_0x0056
                            r0.close()     // Catch:{ all -> 0x0055 }
                            goto L_0x0056
                        L_0x0056:
                            if (r3 == 0) goto L_0x005b
                            r3.close()     // Catch:{ all -> 0x005b }
                        L_0x005b:
                            throw r1
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.utils.MimeDetector.C25651.run():java.util.List");
                        }
                    });
                    this.f9190a = new HashMap(list.size());
                    String str = "";
                    for (String str2 : list) {
                        StringBuilder sb = new StringBuilder();
                        sb.append(str);
                        sb.append(str2);
                        String sb2 = sb.toString();
                        if (sb2.endsWith("\\")) {
                            str = sb2.substring(0, sb2.length() - 1);
                        } else {
                            m12238f(sb2);
                            str = "";
                        }
                    }
                    if (!str.isEmpty()) {
                        m12238f(str);
                    }
                    this.f9191b = true;
                }
            }
        }
    }

    /* renamed from: f */
    private void m12238f(String str) {
        String trim = str.trim();
        if (!trim.isEmpty()) {
            if (trim.charAt(0) != '#') {
                String replaceAll = trim.replaceAll("\\s*#.*", "");
                int i = 1;
                if (replaceAll.indexOf(61) > 0) {
                    Matcher matcher = Pattern.compile("\\btype=(\"\\p{Graph}+?/\\p{Graph}+?\"|\\p{Graph}+/\\p{Graph}+\\b)").matcher(replaceAll);
                    if (matcher.find()) {
                        String substring = matcher.group().substring(5);
                        if (substring.charAt(0) == '\"') {
                            substring = substring.substring(1, substring.length() - 1);
                        }
                        Matcher matcher2 = Pattern.compile("\\bexts=(\"[\\p{Graph}|\\p{Blank}]+?\"|\\p{Graph}+\\b)").matcher(replaceAll);
                        if (matcher2.find()) {
                            String substring2 = matcher2.group().substring(5);
                            if (substring2.charAt(0) == '\"') {
                                substring2 = substring2.substring(1, substring2.length() - 1);
                            }
                            for (String a : substring2.split("[\\p{Blank}|\\p{Punct}]+")) {
                                m12232a(a, substring);
                            }
                            return;
                        }
                        return;
                    }
                    return;
                }
                String[] split = replaceAll.split("\\s+");
                while (i < split.length) {
                    int i2 = i + 1;
                    m12232a(split[i], split[0]);
                    i = i2;
                }
            }
        }
    }

    /* renamed from: a */
    private void m12232a(String str, String str2) {
        if (str != null && !str.isEmpty() && str2 != null && !str2.isEmpty() && !this.f9190a.containsKey(str)) {
            this.f9190a.put(str, str2);
        }
    }
}
