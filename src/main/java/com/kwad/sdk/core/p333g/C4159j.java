package com.kwad.sdk.core.p333g;

import android.content.Context;
import com.kwad.sdk.C3794a;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

/* renamed from: com.kwad.sdk.core.g.j */
public class C4159j implements C4154g {
    /* renamed from: a */
    private static File f13878a;
    /* renamed from: b */
    private static C4159j f13879b = new C4159j();

    private C4159j() {
    }

    /* renamed from: a */
    public static C4159j m17216a(Context context) {
        f13878a = new File(C3794a.m15726b(context), "rep.log");
        if (!f13878a.exists()) {
            try {
                f13878a.createNewFile();
            } catch (IOException unused) {
            }
        }
        return f13879b;
    }

    /* renamed from: a */
    private void m17217a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }

    /* renamed from: c */
    private synchronized void m17218c() {
        FileWriter fileWriter = null;
        try {
            if (!f13878a.exists()) {
                f13878a.createNewFile();
            }
            FileWriter fileWriter2 = new FileWriter(f13878a);
            try {
                fileWriter2.write("");
                fileWriter2.flush();
                m17217a((Closeable) fileWriter2);
            } catch (IOException unused) {
                fileWriter = fileWriter2;
                m17217a((Closeable) fileWriter);
            } catch (Exception unused2) {
                fileWriter = fileWriter2;
                m17217a((Closeable) fileWriter);
            } catch (Throwable th) {
                FileWriter fileWriter3 = fileWriter2;
                th = th;
                fileWriter = fileWriter3;
                m17217a((Closeable) fileWriter);
                throw th;
            }
        } catch (IOException | Exception unused3) {
            m17217a((Closeable) fileWriter);
        } catch (Throwable th2) {
            th = th2;
            m17217a((Closeable) fileWriter);
            throw th;
        }
    }

    /* renamed from: a */
    public synchronized long mo23853a() {
        long j;
        InputStreamReader inputStreamReader;
        FileInputStream fileInputStream;
        InputStreamReader inputStreamReader2;
        j = 0;
        BufferedReader bufferedReader = null;
        try {
            fileInputStream = new FileInputStream(f13878a);
            try {
                inputStreamReader2 = new InputStreamReader(fileInputStream);
            } catch (IOException unused) {
                inputStreamReader = null;
                m17217a((Closeable) r2);
                m17217a((Closeable) inputStreamReader);
                m17217a((Closeable) fileInputStream);
                return j;
            } catch (Exception unused2) {
                inputStreamReader2 = null;
                m17217a((Closeable) bufferedReader);
                m17217a((Closeable) inputStreamReader2);
                m17217a((Closeable) fileInputStream);
                return j;
            } catch (Throwable th) {
                th = th;
                inputStreamReader2 = null;
                m17217a((Closeable) bufferedReader);
                m17217a((Closeable) inputStreamReader2);
                m17217a((Closeable) fileInputStream);
                throw th;
            }
            try {
                BufferedReader bufferedReader2 = new BufferedReader(inputStreamReader2);
                while (bufferedReader2.readLine() != null) {
                    try {
                        j++;
                    } catch (IOException unused3) {
                        BufferedReader bufferedReader3 = bufferedReader2;
                        m17217a((Closeable) bufferedReader3);
                        m17217a((Closeable) inputStreamReader);
                        m17217a((Closeable) fileInputStream);
                        return j;
                    } catch (Exception unused4) {
                        bufferedReader = bufferedReader2;
                        m17217a((Closeable) bufferedReader);
                        m17217a((Closeable) inputStreamReader2);
                        m17217a((Closeable) fileInputStream);
                        return j;
                    } catch (Throwable th2) {
                        th = th2;
                        bufferedReader = bufferedReader2;
                        m17217a((Closeable) bufferedReader);
                        m17217a((Closeable) inputStreamReader2);
                        m17217a((Closeable) fileInputStream);
                        throw th;
                    }
                }
                m17217a((Closeable) bufferedReader2);
                m17217a((Closeable) inputStreamReader2);
            } catch (IOException unused5) {
                m17217a((Closeable) bufferedReader3);
                m17217a((Closeable) inputStreamReader);
                m17217a((Closeable) fileInputStream);
                return j;
            } catch (Exception unused6) {
                m17217a((Closeable) bufferedReader);
                m17217a((Closeable) inputStreamReader2);
                m17217a((Closeable) fileInputStream);
                return j;
            } catch (Throwable th3) {
                th = th3;
                m17217a((Closeable) bufferedReader);
                m17217a((Closeable) inputStreamReader2);
                m17217a((Closeable) fileInputStream);
                throw th;
            }
        } catch (IOException unused7) {
            FileInputStream fileInputStream2 = null;
            inputStreamReader = null;
            m17217a((Closeable) bufferedReader3);
            m17217a((Closeable) inputStreamReader);
            m17217a((Closeable) fileInputStream);
            return j;
        } catch (Exception unused8) {
            FileInputStream fileInputStream3 = null;
            inputStreamReader2 = null;
            m17217a((Closeable) bufferedReader);
            m17217a((Closeable) inputStreamReader2);
            m17217a((Closeable) fileInputStream);
            return j;
        } catch (Throwable th4) {
            th = th4;
            fileInputStream = null;
            inputStreamReader2 = null;
            m17217a((Closeable) bufferedReader);
            m17217a((Closeable) inputStreamReader2);
            m17217a((Closeable) fileInputStream);
            throw th;
        }
        m17217a((Closeable) fileInputStream);
        return j;
    }

    /* JADX WARNING: type inference failed for: r3v0, types: [java.io.Closeable] */
    /* JADX WARNING: type inference failed for: r2v0, types: [java.io.Closeable] */
    /* JADX WARNING: type inference failed for: r2v1 */
    /* JADX WARNING: type inference failed for: r2v2 */
    /* JADX WARNING: type inference failed for: r3v2, types: [java.io.Closeable] */
    /* JADX WARNING: type inference failed for: r2v3, types: [java.io.Closeable] */
    /* JADX WARNING: type inference failed for: r2v4 */
    /* JADX WARNING: type inference failed for: r2v5 */
    /* JADX WARNING: type inference failed for: r3v4, types: [java.io.Closeable] */
    /* JADX WARNING: type inference failed for: r2v6, types: [java.io.Closeable] */
    /* JADX WARNING: type inference failed for: r2v7 */
    /* JADX WARNING: type inference failed for: r3v5 */
    /* JADX WARNING: type inference failed for: r2v8 */
    /* JADX WARNING: type inference failed for: r2v10 */
    /* JADX WARNING: type inference failed for: r2v11 */
    /* JADX WARNING: type inference failed for: r2v12 */
    /* JADX WARNING: type inference failed for: r2v13, types: [java.io.Closeable, java.io.Writer, java.io.OutputStreamWriter] */
    /* JADX WARNING: type inference failed for: r3v10 */
    /* JADX WARNING: type inference failed for: r2v14 */
    /* JADX WARNING: type inference failed for: r2v15 */
    /* JADX WARNING: type inference failed for: r2v16 */
    /* JADX WARNING: type inference failed for: r2v17 */
    /* JADX WARNING: type inference failed for: r3v12 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 7 */
    /* renamed from: a */
    public synchronized void mo23854a(com.kwad.sdk.core.p333g.C4156i r6) {
        /*
        r5 = this;
        monitor-enter(r5)
        r0 = 0
        java.io.FileOutputStream r1 = new java.io.FileOutputStream     // Catch:{ IOException -> 0x007d, Exception -> 0x0073, all -> 0x0065 }
        java.io.File r2 = f13878a     // Catch:{ IOException -> 0x007d, Exception -> 0x0073, all -> 0x0065 }
        r3 = 1
        r1.<init>(r2, r3)     // Catch:{ IOException -> 0x007d, Exception -> 0x0073, all -> 0x0065 }
        java.io.OutputStreamWriter r2 = new java.io.OutputStreamWriter     // Catch:{ IOException -> 0x0063, Exception -> 0x0061, all -> 0x005e }
        java.lang.String r3 = "UTF-8"
        r2.<init>(r1, r3)     // Catch:{ IOException -> 0x0063, Exception -> 0x0061, all -> 0x005e }
        java.io.BufferedWriter r3 = new java.io.BufferedWriter     // Catch:{ IOException -> 0x005c, Exception -> 0x005a, all -> 0x0057 }
        r3.<init>(r2)     // Catch:{ IOException -> 0x005c, Exception -> 0x005a, all -> 0x0057 }
        org.json.JSONObject r6 = r6.toJson()     // Catch:{ IOException -> 0x0080, Exception -> 0x0076, all -> 0x0055 }
        java.lang.String r6 = r6.toString()     // Catch:{ IOException -> 0x0080, Exception -> 0x0076, all -> 0x0055 }
        boolean r0 = android.text.TextUtils.isEmpty(r6)     // Catch:{ IOException -> 0x0080, Exception -> 0x0076, all -> 0x0055 }
        if (r0 != 0) goto L_0x004b
        com.kwad.sdk.core.b.a$b r0 = com.kwad.sdk.core.p318b.C4059a.m16840a()     // Catch:{ IOException -> 0x0080, Exception -> 0x0076, all -> 0x0055 }
        byte[] r6 = r6.getBytes()     // Catch:{ IOException -> 0x0080, Exception -> 0x0076, all -> 0x0055 }
        byte[] r6 = r0.mo23722a(r6)     // Catch:{ IOException -> 0x0080, Exception -> 0x0076, all -> 0x0055 }
        java.lang.String r0 = new java.lang.String     // Catch:{ IOException -> 0x0080, Exception -> 0x0076, all -> 0x0055 }
        java.lang.String r4 = "UTF-8"
        r0.<init>(r6, r4)     // Catch:{ IOException -> 0x0080, Exception -> 0x0076, all -> 0x0055 }
        java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0080, Exception -> 0x0076, all -> 0x0055 }
        r6.<init>()     // Catch:{ IOException -> 0x0080, Exception -> 0x0076, all -> 0x0055 }
        r6.append(r0)     // Catch:{ IOException -> 0x0080, Exception -> 0x0076, all -> 0x0055 }
        java.lang.String r0 = "\n"
        r6.append(r0)     // Catch:{ IOException -> 0x0080, Exception -> 0x0076, all -> 0x0055 }
        java.lang.String r6 = r6.toString()     // Catch:{ IOException -> 0x0080, Exception -> 0x0076, all -> 0x0055 }
        r3.write(r6)     // Catch:{ IOException -> 0x0080, Exception -> 0x0076, all -> 0x0055 }
    L_0x004b:
        r5.m17217a(r3)     // Catch:{ all -> 0x0089 }
        r5.m17217a(r2)     // Catch:{ all -> 0x0089 }
    L_0x0051:
        r5.m17217a(r1)     // Catch:{ all -> 0x0089 }
        goto L_0x0087
    L_0x0055:
        r6 = move-exception
        goto L_0x0069
    L_0x0057:
        r6 = move-exception
        r3 = r0
        goto L_0x0069
    L_0x005a:
        r3 = r0
        goto L_0x0076
    L_0x005c:
        r3 = r0
        goto L_0x0080
    L_0x005e:
        r6 = move-exception
        r2 = r0
        goto L_0x0068
    L_0x0061:
        r2 = r0
        goto L_0x0075
    L_0x0063:
        r2 = r0
        goto L_0x007f
    L_0x0065:
        r6 = move-exception
        r1 = r0
        r2 = r1
    L_0x0068:
        r3 = r2
    L_0x0069:
        r5.m17217a(r3)     // Catch:{ all -> 0x0089 }
        r5.m17217a(r2)     // Catch:{ all -> 0x0089 }
        r5.m17217a(r1)     // Catch:{ all -> 0x0089 }
        throw r6     // Catch:{ all -> 0x0089 }
    L_0x0073:
        r1 = r0
        r2 = r1
    L_0x0075:
        r3 = r2
    L_0x0076:
        r5.m17217a(r3)     // Catch:{ all -> 0x0089 }
        r5.m17217a(r2)     // Catch:{ all -> 0x0089 }
        goto L_0x0051
    L_0x007d:
        r1 = r0
        r2 = r1
    L_0x007f:
        r3 = r2
    L_0x0080:
        r5.m17217a(r3)     // Catch:{ all -> 0x0089 }
        r5.m17217a(r2)     // Catch:{ all -> 0x0089 }
        goto L_0x0051
    L_0x0087:
        monitor-exit(r5)
        return
    L_0x0089:
        r6 = move-exception
        monitor-exit(r5)
        throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.sdk.core.p333g.C4159j.mo23854a(com.kwad.sdk.core.g.i):void");
    }

    /* JADX WARNING: type inference failed for: r3v0, types: [java.io.Closeable] */
    /* JADX WARNING: type inference failed for: r2v0, types: [java.io.Closeable] */
    /* JADX WARNING: type inference failed for: r2v1 */
    /* JADX WARNING: type inference failed for: r2v2 */
    /* JADX WARNING: type inference failed for: r3v2, types: [java.io.Closeable] */
    /* JADX WARNING: type inference failed for: r2v3, types: [java.io.Closeable] */
    /* JADX WARNING: type inference failed for: r2v4 */
    /* JADX WARNING: type inference failed for: r3v3 */
    /* JADX WARNING: type inference failed for: r2v5 */
    /* JADX WARNING: type inference failed for: r2v7 */
    /* JADX WARNING: type inference failed for: r2v8 */
    /* JADX WARNING: type inference failed for: r2v9, types: [java.io.Closeable, java.io.Writer, java.io.OutputStreamWriter] */
    /* JADX WARNING: type inference failed for: r3v7 */
    /* JADX WARNING: type inference failed for: r2v10 */
    /* JADX WARNING: type inference failed for: r2v11 */
    /* JADX WARNING: type inference failed for: r2v12 */
    /* JADX WARNING: type inference failed for: r3v9 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 5 */
    /* renamed from: a */
    public synchronized void mo23855a(java.util.List<com.kwad.sdk.core.p333g.C4156i> r8) {
        /*
        r7 = this;
        monitor-enter(r7)
        r0 = 0
        java.io.FileOutputStream r1 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x008b, all -> 0x007d }
        java.io.File r2 = f13878a     // Catch:{ Exception -> 0x008b, all -> 0x007d }
        r3 = 1
        r1.<init>(r2, r3)     // Catch:{ Exception -> 0x008b, all -> 0x007d }
        java.io.OutputStreamWriter r2 = new java.io.OutputStreamWriter     // Catch:{ Exception -> 0x007b, all -> 0x0078 }
        java.lang.String r3 = "UTF-8"
        r2.<init>(r1, r3)     // Catch:{ Exception -> 0x007b, all -> 0x0078 }
        java.io.BufferedWriter r3 = new java.io.BufferedWriter     // Catch:{ Exception -> 0x0076, all -> 0x0073 }
        r3.<init>(r2)     // Catch:{ Exception -> 0x0076, all -> 0x0073 }
        java.util.Iterator r8 = r8.iterator()     // Catch:{ Exception -> 0x008e, all -> 0x0071 }
    L_0x001a:
        boolean r4 = r8.hasNext()     // Catch:{ Exception -> 0x008e, all -> 0x0071 }
        if (r4 == 0) goto L_0x0067
        java.lang.Object r4 = r8.next()     // Catch:{ Exception -> 0x008e, all -> 0x0071 }
        com.kwad.sdk.core.g.i r4 = (com.kwad.sdk.core.p333g.C4156i) r4     // Catch:{ Exception -> 0x008e, all -> 0x0071 }
        org.json.JSONObject r4 = r4.toJson()     // Catch:{ Exception -> 0x008e, all -> 0x0071 }
        java.lang.String r4 = r4.toString()     // Catch:{ Exception -> 0x008e, all -> 0x0071 }
        boolean r5 = android.text.TextUtils.isEmpty(r4)     // Catch:{ Exception -> 0x008e, all -> 0x0071 }
        if (r5 != 0) goto L_0x001a
        com.kwad.sdk.core.b.a$b r5 = com.kwad.sdk.core.p318b.C4059a.m16840a()     // Catch:{ Exception -> 0x008e, all -> 0x0071 }
        byte[] r4 = r4.getBytes()     // Catch:{ Exception -> 0x008e, all -> 0x0071 }
        byte[] r4 = r5.mo23722a(r4)     // Catch:{ Exception -> 0x008e, all -> 0x0071 }
        java.lang.String r5 = new java.lang.String     // Catch:{ UnsupportedEncodingException -> 0x0048 }
        java.lang.String r6 = "UTF-8"
        r5.<init>(r4, r6)     // Catch:{ UnsupportedEncodingException -> 0x0048 }
        goto L_0x004d
    L_0x0048:
        r4 = move-exception
        com.kwad.sdk.core.p319c.C4065b.m16865a(r4)     // Catch:{ Exception -> 0x008e, all -> 0x0071 }
        r5 = r0
    L_0x004d:
        java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0062 }
        r4.<init>()     // Catch:{ IOException -> 0x0062 }
        r4.append(r5)     // Catch:{ IOException -> 0x0062 }
        java.lang.String r5 = "\n"
        r4.append(r5)     // Catch:{ IOException -> 0x0062 }
        java.lang.String r4 = r4.toString()     // Catch:{ IOException -> 0x0062 }
        r3.write(r4)     // Catch:{ IOException -> 0x0062 }
        goto L_0x001a
    L_0x0062:
        r4 = move-exception
        com.kwad.sdk.core.p319c.C4065b.m16865a(r4)     // Catch:{ Exception -> 0x008e, all -> 0x0071 }
        goto L_0x001a
    L_0x0067:
        r7.m17217a(r3)     // Catch:{ all -> 0x0097 }
        r7.m17217a(r2)     // Catch:{ all -> 0x0097 }
    L_0x006d:
        r7.m17217a(r1)     // Catch:{ all -> 0x0097 }
        goto L_0x0095
    L_0x0071:
        r8 = move-exception
        goto L_0x0081
    L_0x0073:
        r8 = move-exception
        r3 = r0
        goto L_0x0081
    L_0x0076:
        r3 = r0
        goto L_0x008e
    L_0x0078:
        r8 = move-exception
        r2 = r0
        goto L_0x0080
    L_0x007b:
        r2 = r0
        goto L_0x008d
    L_0x007d:
        r8 = move-exception
        r1 = r0
        r2 = r1
    L_0x0080:
        r3 = r2
    L_0x0081:
        r7.m17217a(r3)     // Catch:{ all -> 0x0097 }
        r7.m17217a(r2)     // Catch:{ all -> 0x0097 }
        r7.m17217a(r1)     // Catch:{ all -> 0x0097 }
        throw r8     // Catch:{ all -> 0x0097 }
    L_0x008b:
        r1 = r0
        r2 = r1
    L_0x008d:
        r3 = r2
    L_0x008e:
        r7.m17217a(r3)     // Catch:{ all -> 0x0097 }
        r7.m17217a(r2)     // Catch:{ all -> 0x0097 }
        goto L_0x006d
    L_0x0095:
        monitor-exit(r7)
        return
    L_0x0097:
        r8 = move-exception
        monitor-exit(r7)
        throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.sdk.core.p333g.C4159j.mo23855a(java.util.List):void");
    }

    /* JADX WARNING: type inference failed for: r4v0, types: [java.io.Closeable] */
    /* JADX WARNING: type inference failed for: r3v1, types: [java.io.Closeable] */
    /* JADX WARNING: type inference failed for: r3v2 */
    /* JADX WARNING: type inference failed for: r3v3 */
    /* JADX WARNING: type inference failed for: r4v2, types: [java.io.Closeable] */
    /* JADX WARNING: type inference failed for: r3v4, types: [java.io.Closeable] */
    /* JADX WARNING: type inference failed for: r3v5 */
    /* JADX WARNING: type inference failed for: r4v3 */
    /* JADX WARNING: type inference failed for: r3v6 */
    /* JADX WARNING: type inference failed for: r3v8 */
    /* JADX WARNING: type inference failed for: r3v9 */
    /* JADX WARNING: type inference failed for: r3v10, types: [java.io.Closeable, java.io.Reader, java.io.InputStreamReader] */
    /* JADX WARNING: type inference failed for: r4v6 */
    /* JADX WARNING: type inference failed for: r3v11 */
    /* JADX WARNING: type inference failed for: r3v12 */
    /* JADX WARNING: type inference failed for: r3v13 */
    /* JADX WARNING: type inference failed for: r4v8 */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x008f, code lost:
            return r0;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 5 */
    /* renamed from: b */
    public synchronized java.util.List<com.kwad.sdk.core.p333g.C4156i> mo23856b() {
        /*
        r9 = this;
        monitor-enter(r9)
        java.util.ArrayList r0 = new java.util.ArrayList     // Catch:{ all -> 0x0090 }
        r0.<init>()     // Catch:{ all -> 0x0090 }
        java.io.File r1 = f13878a     // Catch:{ all -> 0x0090 }
        boolean r1 = r1.exists()     // Catch:{ all -> 0x0090 }
        if (r1 == 0) goto L_0x008e
        java.io.File r1 = f13878a     // Catch:{ all -> 0x0090 }
        long r1 = r1.length()     // Catch:{ all -> 0x0090 }
        r3 = 0
        int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
        if (r5 != 0) goto L_0x001c
        goto L_0x008e
    L_0x001c:
        r1 = 0
        java.io.FileInputStream r2 = new java.io.FileInputStream     // Catch:{ Exception -> 0x0082, all -> 0x0074 }
        java.io.File r3 = f13878a     // Catch:{ Exception -> 0x0082, all -> 0x0074 }
        r2.<init>(r3)     // Catch:{ Exception -> 0x0082, all -> 0x0074 }
        java.io.InputStreamReader r3 = new java.io.InputStreamReader     // Catch:{ Exception -> 0x0072, all -> 0x006f }
        java.lang.String r4 = "UTF-8"
        r3.<init>(r2, r4)     // Catch:{ Exception -> 0x0072, all -> 0x006f }
        java.io.BufferedReader r4 = new java.io.BufferedReader     // Catch:{ Exception -> 0x006d, all -> 0x006a }
        r4.<init>(r3)     // Catch:{ Exception -> 0x006d, all -> 0x006a }
        r5 = r1
    L_0x0031:
        java.lang.String r5 = r4.readLine()     // Catch:{ IOException -> 0x0038 }
        goto L_0x0039
    L_0x0036:
        r0 = move-exception
        goto L_0x0078
    L_0x0039:
        if (r5 != 0) goto L_0x0048
        r9.m17218c()     // Catch:{ Exception -> 0x0085, all -> 0x0036 }
        r9.m17217a(r4)     // Catch:{ all -> 0x0090 }
        r9.m17217a(r3)     // Catch:{ all -> 0x0090 }
    L_0x0044:
        r9.m17217a(r2)     // Catch:{ all -> 0x0090 }
        goto L_0x008c
    L_0x0048:
        java.lang.String r6 = new java.lang.String     // Catch:{ UnsupportedEncodingException -> 0x005c }
        com.kwad.sdk.core.b.a$a r7 = com.kwad.sdk.core.p318b.C4059a.m16841b()     // Catch:{ UnsupportedEncodingException -> 0x005c }
        byte[] r8 = r5.getBytes()     // Catch:{ UnsupportedEncodingException -> 0x005c }
        byte[] r7 = r7.mo23721a(r8)     // Catch:{ UnsupportedEncodingException -> 0x005c }
        java.lang.String r8 = "UTF-8"
        r6.<init>(r7, r8)     // Catch:{ UnsupportedEncodingException -> 0x005c }
        goto L_0x0061
    L_0x005c:
        r6 = move-exception
        com.kwad.sdk.core.p319c.C4065b.m16865a(r6)     // Catch:{ Exception -> 0x0085, all -> 0x0036 }
        r6 = r1
    L_0x0061:
        com.kwad.sdk.core.g.i r7 = new com.kwad.sdk.core.g.i     // Catch:{ Exception -> 0x0085, all -> 0x0036 }
        r7.m47962init(r6)     // Catch:{ Exception -> 0x0085, all -> 0x0036 }
        r0.add(r7)     // Catch:{ Exception -> 0x0085, all -> 0x0036 }
        goto L_0x0031
    L_0x006a:
        r0 = move-exception
        r4 = r1
        goto L_0x0078
    L_0x006d:
        r4 = r1
        goto L_0x0085
    L_0x006f:
        r0 = move-exception
        r3 = r1
        goto L_0x0077
    L_0x0072:
        r3 = r1
        goto L_0x0084
    L_0x0074:
        r0 = move-exception
        r2 = r1
        r3 = r2
    L_0x0077:
        r4 = r3
    L_0x0078:
        r9.m17217a(r4)     // Catch:{ all -> 0x0090 }
        r9.m17217a(r3)     // Catch:{ all -> 0x0090 }
        r9.m17217a(r2)     // Catch:{ all -> 0x0090 }
        throw r0     // Catch:{ all -> 0x0090 }
    L_0x0082:
        r2 = r1
        r3 = r2
    L_0x0084:
        r4 = r3
    L_0x0085:
        r9.m17217a(r4)     // Catch:{ all -> 0x0090 }
        r9.m17217a(r3)     // Catch:{ all -> 0x0090 }
        goto L_0x0044
    L_0x008c:
        monitor-exit(r9)
        return r0
    L_0x008e:
        monitor-exit(r9)
        return r0
    L_0x0090:
        r0 = move-exception
        monitor-exit(r9)
        throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.sdk.core.p333g.C4159j.mo23856b():java.util.List");
    }
}
