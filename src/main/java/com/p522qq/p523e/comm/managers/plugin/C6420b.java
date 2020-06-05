package com.p522qq.p523e.comm.managers.plugin;

import android.content.Context;
import com.p522qq.p523e.comm.managers.plugin.C6413PM.C6416a.C6418b;
import com.p522qq.p523e.comm.net.NetworkCallBack;
import com.p522qq.p523e.comm.net.NetworkClient.Priority;
import com.p522qq.p523e.comm.net.NetworkClientImpl;
import com.p522qq.p523e.comm.net.p524rr.PlainRequest;
import com.p522qq.p523e.comm.net.p524rr.Request.Method;
import com.p522qq.p523e.comm.net.p524rr.Response;
import com.p522qq.p523e.comm.util.FileUtil;
import com.p522qq.p523e.comm.util.GDTLogger;
import com.p522qq.p523e.comm.util.Md5Util;
import com.p522qq.p523e.comm.util.StringUtil;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.concurrent.Executor;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* renamed from: com.qq.e.comm.managers.plugin.b */
public final class C6420b {
    /* renamed from: a */
    private static final Pattern f20207a = Pattern.compile(".*plugin\\.dex-(\\d+)\\.jar.*");
    /* access modifiers changed from: private|final */
    /* renamed from: b */
    public final Context f20208b;
    /* access modifiers changed from: private */
    /* renamed from: c */
    public C6418b f20209c;
    /* renamed from: d */
    private Executor f20210d;

    /* renamed from: com.qq.e.comm.managers.plugin.b$a */
    class C6421a implements NetworkCallBack {
        /* renamed from: a */
        private final String f20211a;
        /* renamed from: b */
        private final int f20212b;

        public C6421a(String str, int i) {
            this.f20211a = str;
            this.f20212b = i;
        }

        /* renamed from: a */
        private static String m25204a(Response response, File file) {
            InputStream inputStream;
            FileOutputStream fileOutputStream;
            String str;
            try {
                MessageDigest instance = MessageDigest.getInstance("MD5");
                inputStream = response.getStreamContent();
                try {
                    fileOutputStream = new FileOutputStream(file);
                } catch (IOException e) {
                    e = e;
                    fileOutputStream = null;
                    str = "IOException While Update Plugin";
                    try {
                        GDTLogger.m25261e(str, e);
                        FileUtil.tryClose(inputStream);
                        FileUtil.tryClose((OutputStream) fileOutputStream);
                        return null;
                    } catch (Throwable th) {
                        th = th;
                        FileUtil.tryClose(inputStream);
                        FileUtil.tryClose((OutputStream) fileOutputStream);
                        throw th;
                    }
                } catch (NoSuchAlgorithmException e2) {
                    e = e2;
                    fileOutputStream = null;
                    str = "MD5SUMException While Update Plugin";
                    GDTLogger.m25261e(str, e);
                    FileUtil.tryClose(inputStream);
                    FileUtil.tryClose((OutputStream) fileOutputStream);
                    return null;
                } catch (Throwable th2) {
                    th = th2;
                    fileOutputStream = null;
                    FileUtil.tryClose(inputStream);
                    FileUtil.tryClose((OutputStream) fileOutputStream);
                    throw th;
                }
                try {
                    byte[] bArr = new byte[1024];
                    while (true) {
                        int read = inputStream.read(bArr);
                        if (read > 0) {
                            instance.update(bArr, 0, read);
                            fileOutputStream.write(bArr, 0, read);
                        } else {
                            FileUtil.tryClose(inputStream);
                            FileUtil.tryClose((OutputStream) fileOutputStream);
                            String byteArrayToHexString = Md5Util.byteArrayToHexString(instance.digest());
                            FileUtil.tryClose(inputStream);
                            FileUtil.tryClose((OutputStream) fileOutputStream);
                            return byteArrayToHexString;
                        }
                    }
                } catch (IOException e3) {
                    e = e3;
                    str = "IOException While Update Plugin";
                    GDTLogger.m25261e(str, e);
                    FileUtil.tryClose(inputStream);
                    FileUtil.tryClose((OutputStream) fileOutputStream);
                    return null;
                } catch (NoSuchAlgorithmException e4) {
                    e = e4;
                    str = "MD5SUMException While Update Plugin";
                    GDTLogger.m25261e(str, e);
                    FileUtil.tryClose(inputStream);
                    FileUtil.tryClose((OutputStream) fileOutputStream);
                    return null;
                }
            } catch (IOException e5) {
                e = e5;
                inputStream = null;
                fileOutputStream = null;
                str = "IOException While Update Plugin";
                GDTLogger.m25261e(str, e);
                FileUtil.tryClose(inputStream);
                FileUtil.tryClose((OutputStream) fileOutputStream);
                return null;
            } catch (NoSuchAlgorithmException e6) {
                e = e6;
                inputStream = null;
                fileOutputStream = null;
                str = "MD5SUMException While Update Plugin";
                GDTLogger.m25261e(str, e);
                FileUtil.tryClose(inputStream);
                FileUtil.tryClose((OutputStream) fileOutputStream);
                return null;
            } catch (Throwable th3) {
                th = th3;
                inputStream = null;
                fileOutputStream = null;
                FileUtil.tryClose(inputStream);
                FileUtil.tryClose((OutputStream) fileOutputStream);
                throw th;
            }
        }

        /* renamed from: a */
        private void m25205a() {
            if (C6420b.this.f20209c != null) {
                C6420b.this.f20209c.mo30127b();
            }
        }

        /* renamed from: a */
        private boolean m25206a(File file) {
            StringBuilder sb = new StringBuilder();
            sb.append(this.f20212b);
            sb.append("#####");
            sb.append(this.f20211a);
            try {
                StringUtil.writeTo(sb.toString(), file);
                return true;
            } catch (IOException e) {
                GDTLogger.m25261e("IOException While Update Plugin", e);
                return false;
            }
        }

        public final void onException(Exception exc) {
            GDTLogger.m25264w("Exception While Update Plugin", exc);
            m25205a();
        }

        /* JADX WARNING: Removed duplicated region for block: B:18:0x0078 A[Catch:{ all -> 0x00a0, all -> 0x00c5 }] */
        public final void onResponse(com.p522qq.p523e.comm.net.p524rr.Request r7, com.p522qq.p523e.comm.net.p524rr.Response r8) {
            /*
            r6 = this;
            java.lang.String r7 = ";sig="
            java.lang.String r0 = "TIMESTAMP_AFTER_DOWNPLUGIN:"
            int r1 = r8.getStatusCode()
            r2 = 200(0xc8, float:2.8E-43)
            if (r1 != r2) goto L_0x00e2
            com.qq.e.comm.managers.plugin.b r1 = com.p522qq.p523e.comm.managers.plugin.C6420b.this     // Catch:{ all -> 0x00a0 }
            android.content.Context r1 = r1.f20208b     // Catch:{ all -> 0x00a0 }
            java.io.File r1 = com.p522qq.p523e.comm.managers.plugin.C6423d.m25209c(r1)     // Catch:{ all -> 0x00a0 }
            com.qq.e.comm.managers.plugin.b r2 = com.p522qq.p523e.comm.managers.plugin.C6420b.this     // Catch:{ all -> 0x00a0 }
            android.content.Context r2 = r2.f20208b     // Catch:{ all -> 0x00a0 }
            java.io.File r2 = com.p522qq.p523e.comm.managers.plugin.C6423d.m25212f(r2)     // Catch:{ all -> 0x00a0 }
            java.lang.String r8 = m25204a(r8, r1)     // Catch:{ all -> 0x00a0 }
            com.qq.e.comm.util.a r3 = com.p522qq.p523e.comm.util.C6439a.m25265a()     // Catch:{ all -> 0x00a0 }
            java.lang.String r4 = r6.f20211a     // Catch:{ all -> 0x00a0 }
            boolean r3 = r3.mo30393b(r4, r8)     // Catch:{ all -> 0x00a0 }
            r4 = 1
            r5 = 0
            if (r3 == 0) goto L_0x0082
            boolean r8 = r6.m25206a(r2)     // Catch:{ all -> 0x00a0 }
            if (r8 == 0) goto L_0x005e
            com.qq.e.comm.managers.plugin.b r8 = com.p522qq.p523e.comm.managers.plugin.C6420b.this     // Catch:{ all -> 0x00a0 }
            android.content.Context r8 = r8.f20208b     // Catch:{ all -> 0x00a0 }
            java.io.File r8 = com.p522qq.p523e.comm.managers.plugin.C6423d.m25210d(r8)     // Catch:{ all -> 0x00a0 }
            boolean r8 = com.p522qq.p523e.comm.util.FileUtil.renameTo(r1, r8)     // Catch:{ all -> 0x00a0 }
            if (r8 == 0) goto L_0x005a
            com.qq.e.comm.managers.plugin.b r8 = com.p522qq.p523e.comm.managers.plugin.C6420b.this     // Catch:{ all -> 0x00a0 }
            android.content.Context r8 = r8.f20208b     // Catch:{ all -> 0x00a0 }
            java.io.File r8 = com.p522qq.p523e.comm.managers.plugin.C6423d.m25213g(r8)     // Catch:{ all -> 0x00a0 }
            boolean r8 = com.p522qq.p523e.comm.util.FileUtil.renameTo(r2, r8)     // Catch:{ all -> 0x00a0 }
            if (r8 == 0) goto L_0x005a
            r8 = 1
            goto L_0x005b
        L_0x005a:
            r8 = 0
        L_0x005b:
            if (r8 == 0) goto L_0x005e
            goto L_0x005f
        L_0x005e:
            r4 = 0
        L_0x005f:
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ all -> 0x00a0 }
            java.lang.String r1 = "PluginUpdateSucc:"
            r8.<init>(r1)     // Catch:{ all -> 0x00a0 }
            r8.append(r4)     // Catch:{ all -> 0x00a0 }
            java.lang.String r8 = r8.toString()     // Catch:{ all -> 0x00a0 }
            com.p522qq.p523e.comm.util.GDTLogger.m25258d(r8)     // Catch:{ all -> 0x00a0 }
            com.qq.e.comm.managers.plugin.b r8 = com.p522qq.p523e.comm.managers.plugin.C6420b.this     // Catch:{ all -> 0x00a0 }
            com.qq.e.comm.managers.plugin.PM$a$b r8 = r8.f20209c     // Catch:{ all -> 0x00a0 }
            if (r8 == 0) goto L_0x009a
            com.qq.e.comm.managers.plugin.b r8 = com.p522qq.p523e.comm.managers.plugin.C6420b.this     // Catch:{ all -> 0x00a0 }
            com.qq.e.comm.managers.plugin.PM$a$b r8 = r8.f20209c     // Catch:{ all -> 0x00a0 }
            r8.mo30126a()     // Catch:{ all -> 0x00a0 }
            goto L_0x009a
        L_0x0082:
            r1.delete()     // Catch:{ all -> 0x00a0 }
            java.lang.String r1 = "Fail to update plugin while verifying,sig=%s,md5=%s"
            r2 = 2
            java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch:{ all -> 0x00a0 }
            java.lang.String r3 = r6.f20211a     // Catch:{ all -> 0x00a0 }
            r2[r5] = r3     // Catch:{ all -> 0x00a0 }
            r2[r4] = r8     // Catch:{ all -> 0x00a0 }
            java.lang.String r8 = java.lang.String.format(r1, r2)     // Catch:{ all -> 0x00a0 }
            com.p522qq.p523e.comm.util.GDTLogger.report(r8)     // Catch:{ all -> 0x00a0 }
            r6.m25205a()     // Catch:{ all -> 0x00a0 }
        L_0x009a:
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>(r0)
            goto L_0x00ae
        L_0x00a0:
            r8 = move-exception
            java.lang.String r1 = "UnknownException While Update Plugin"
            com.p522qq.p523e.comm.util.GDTLogger.m25261e(r1, r8)     // Catch:{ all -> 0x00c5 }
            r6.m25205a()     // Catch:{ all -> 0x00c5 }
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>(r0)
        L_0x00ae:
            long r0 = java.lang.System.nanoTime()
            r8.append(r0)
            r8.append(r7)
            java.lang.String r7 = r6.f20211a
            r8.append(r7)
            java.lang.String r7 = r8.toString()
            com.p522qq.p523e.comm.util.GDTLogger.m25258d(r7)
            goto L_0x00fa
        L_0x00c5:
            r8 = move-exception
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>(r0)
            long r2 = java.lang.System.nanoTime()
            r1.append(r2)
            r1.append(r7)
            java.lang.String r7 = r6.f20211a
            r1.append(r7)
            java.lang.String r7 = r1.toString()
            com.p522qq.p523e.comm.util.GDTLogger.m25258d(r7)
            throw r8
        L_0x00e2:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            java.lang.String r0 = "DownLoad Plugin Jar Status error,response status code="
            r7.<init>(r0)
            int r8 = r8.getStatusCode()
            r7.append(r8)
            java.lang.String r7 = r7.toString()
            com.p522qq.p523e.comm.util.GDTLogger.report(r7)
            r6.m25205a()
        L_0x00fa:
            return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.p522qq.p523e.comm.managers.plugin.C6420b.C6421a.onResponse(com.qq.e.comm.net.rr.Request, com.qq.e.comm.net.rr.Response):void");
        }
    }

    public C6420b(Context context, Executor executor) {
        this.f20208b = context.getApplicationContext();
        this.f20210d = executor;
    }

    /* renamed from: a */
    public final void mo30132a(C6418b bVar) {
        this.f20209c = bVar;
    }

    /* renamed from: a */
    public final void mo30133a(String str, String str2) {
        if (!StringUtil.isEmpty(str) && !StringUtil.isEmpty(str2)) {
            Matcher matcher = f20207a.matcher(str2);
            boolean z = false;
            int parseInteger = StringUtil.parseInteger(matcher.matches() ? matcher.group(1) : "0", 0);
            if (parseInteger < 1081) {
                StringBuilder sb = new StringBuilder("online plugin version is smaller than asset plugin version");
                sb.append(parseInteger);
                sb.append(",1081");
                sb.append(".download give up");
                GDTLogger.m25262i(sb.toString());
            } else {
                z = true;
            }
            if (z) {
                StringBuilder sb2 = new StringBuilder("TIMESTAP_BEFORE_OWN_PLUGIN:");
                sb2.append(System.nanoTime());
                GDTLogger.m25258d(sb2.toString());
                NetworkClientImpl.getInstance().submit(new PlainRequest(str2, Method.GET, (byte[]) null), Priority.High, new C6421a(str, parseInteger), this.f20210d);
            }
        }
    }
}
