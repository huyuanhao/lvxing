package com.qiyukf.unicorn.analytics;

import android.support.p000v4.media.session.PlaybackStateCompat;
import android.text.TextUtils;
import android.util.Log;
import com.qiyukf.basesdk.p393a.C5264a;
import com.qiyukf.basesdk.p393a.C5268c;
import com.qiyukf.basesdk.p412c.C5366b;
import com.qiyukf.unicorn.p503f.C6168c;
import com.tencent.p605ep.commonbase.software.AppEntity;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import org.json.JSONObject;

/* renamed from: com.qiyukf.unicorn.analytics.c */
final class C5979c {
    /* renamed from: a */
    private static String m23905a(File file) {
        return m23906a(file, file.length());
    }

    /* renamed from: a */
    private static String m23906a(File file, long j) {
        FileInputStream fileInputStream;
        if (file == null || !file.exists()) {
            return null;
        }
        try {
            fileInputStream = new FileInputStream(file);
            try {
                long length = file.length() - j;
                long j2 = 0;
                if (length >= 0) {
                    j2 = length;
                }
                byte[] bArr = new byte[((int) (file.length() - j2))];
                fileInputStream.skip(j2);
                fileInputStream.read(bArr);
                String str = new String(bArr, "UTF-8");
                m23908a((Closeable) fileInputStream);
                return str;
            } catch (IOException e) {
                e = e;
                try {
                    C5264a.m21621b("AnalyticsUtils", "getTextFromFile is error", e);
                    m23908a((Closeable) fileInputStream);
                    return null;
                } catch (Throwable th) {
                    th = th;
                    m23908a((Closeable) fileInputStream);
                    throw th;
                }
            }
        } catch (IOException e2) {
            e = e2;
            fileInputStream = null;
            C5264a.m21621b("AnalyticsUtils", "getTextFromFile is error", e);
            m23908a((Closeable) fileInputStream);
            return null;
        } catch (Throwable th2) {
            th = th2;
            fileInputStream = null;
            m23908a((Closeable) fileInputStream);
            throw th;
        }
    }

    /* renamed from: a */
    public static void m23907a() {
        C5268c a = C5264a.m21615a();
        if (a != null) {
            StringBuilder sb = new StringBuilder();
            sb.append(a.mo27108a());
            sb.append("analytics/");
            File file = new File(sb.toString());
            if (file.exists()) {
                File[] listFiles = file.listFiles();
                if (!(listFiles == null || listFiles.length == 0)) {
                    C5264a.m21617a(C5973a.f18807a, "auto upload log start");
                    int i = 0;
                    for (File file2 : listFiles) {
                        if (C5978b.m23899a(file2.getName())) {
                            if (file2.isDirectory()) {
                                StringBuilder sb2 = new StringBuilder();
                                sb2.append(file2.getPath());
                                sb2.append("/msg.log");
                                File file3 = new File(sb2.toString());
                                if (file3.exists()) {
                                    JSONObject a2 = C5366b.m22027a(m23905a(file3));
                                    long c = C5366b.m22037c(a2, "time");
                                    String e = C5366b.m22039e(a2, "stack");
                                    String e2 = C5366b.m22039e(a2, "type");
                                    String e3 = C5366b.m22039e(a2, AppEntity.KEY_VERSION_STR);
                                    int b = C5366b.m22034b(a2, "count");
                                    if (!TextUtils.isEmpty(e)) {
                                        StringBuilder sb3 = new StringBuilder();
                                        sb3.append(file2.getPath());
                                        sb3.append("/log.log");
                                        if (C6168c.m24474a(e3, e2, e, m23905a(new File(sb3.toString())), b, c) == 200) {
                                            i++;
                                            m23911b(file2);
                                            C5978b.m23897a(file2.getName(), System.currentTimeMillis());
                                        }
                                    }
                                }
                            }
                            m23911b(file2);
                        }
                    }
                    String str = C5973a.f18807a;
                    StringBuilder sb4 = new StringBuilder("auto upload ");
                    sb4.append(i);
                    sb4.append(" logs");
                    C5264a.m21617a(str, sb4.toString());
                }
            }
        }
    }

    /* renamed from: a */
    private static void m23908a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
                C5264a.m21621b("AnalyticsUtils", "close is error", e);
            }
        }
    }

    /* renamed from: a */
    public static void m23909a(String str, Throwable th, C5977b bVar) {
        BufferedWriter bufferedWriter;
        JSONObject jSONObject;
        BufferedWriter bufferedWriter2;
        BufferedWriter bufferedWriter3 = null;
        try {
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append("msg.log");
            File file = new File(sb.toString());
            String str2 = "count";
            if (file.exists()) {
                jSONObject = C5366b.m22027a(m23905a(file));
                C5366b.m22029a(jSONObject, str2, C5366b.m22034b(jSONObject, str2) + 1);
            } else {
                jSONObject = null;
            }
            if (jSONObject == null) {
                jSONObject = new JSONObject();
                C5366b.m22030a(jSONObject, "time", System.currentTimeMillis());
                C5366b.m22032a(jSONObject, "stack", Log.getStackTraceString(th).trim());
                C5366b.m22032a(jSONObject, "type", bVar.toString());
                C5366b.m22032a(jSONObject, AppEntity.KEY_VERSION_STR, "4.10.0");
                C5366b.m22029a(jSONObject, str2, 1);
            }
            BufferedWriter bufferedWriter4 = new BufferedWriter(new FileWriter(file));
            try {
                bufferedWriter4.write(jSONObject.toString());
                bufferedWriter4.flush();
                StringBuilder sb2 = new StringBuilder();
                sb2.append(str);
                sb2.append("log.log");
                File file2 = new File(sb2.toString());
                if (!file2.exists()) {
                    String a = m23906a(new File(C5264a.m21615a().mo27111b()), 51200);
                    bufferedWriter = new BufferedWriter(new FileWriter(file2));
                    try {
                        bufferedWriter.write(a);
                        bufferedWriter.flush();
                        bufferedWriter3 = bufferedWriter;
                    } catch (IOException e) {
                        e = e;
                        bufferedWriter3 = bufferedWriter4;
                        try {
                            C5264a.m21621b("AnalyticsUtils", "saveErrorLog is error", e);
                            m23908a((Closeable) bufferedWriter3);
                            m23908a((Closeable) bufferedWriter);
                        } catch (Throwable th2) {
                            th = th2;
                            m23908a((Closeable) bufferedWriter3);
                            m23908a((Closeable) bufferedWriter);
                            throw th;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        bufferedWriter3 = bufferedWriter4;
                        m23908a((Closeable) bufferedWriter3);
                        m23908a((Closeable) bufferedWriter);
                        throw th;
                    }
                }
                String str3 = C5973a.f18807a;
                StringBuilder sb3 = new StringBuilder("save error log: ");
                sb3.append(th.getMessage());
                C5264a.m21617a(str3, sb3.toString());
                m23908a((Closeable) bufferedWriter4);
                m23908a((Closeable) bufferedWriter3);
            } catch (IOException e2) {
                e = e2;
                bufferedWriter = bufferedWriter2;
                bufferedWriter3 = bufferedWriter4;
                C5264a.m21621b("AnalyticsUtils", "saveErrorLog is error", e);
                m23908a((Closeable) bufferedWriter3);
                m23908a((Closeable) bufferedWriter);
            } catch (Throwable th4) {
                th = th4;
                bufferedWriter = bufferedWriter3;
                bufferedWriter3 = bufferedWriter4;
                m23908a((Closeable) bufferedWriter3);
                m23908a((Closeable) bufferedWriter);
                throw th;
            }
        } catch (IOException e3) {
            e = e3;
            bufferedWriter = null;
            C5264a.m21621b("AnalyticsUtils", "saveErrorLog is error", e);
            m23908a((Closeable) bufferedWriter3);
            m23908a((Closeable) bufferedWriter);
        } catch (Throwable th5) {
            th = th5;
            bufferedWriter = null;
            m23908a((Closeable) bufferedWriter3);
            m23908a((Closeable) bufferedWriter);
            throw th;
        }
    }

    /* renamed from: b */
    public static void m23910b() {
        C5268c a = C5264a.m21615a();
        if (a != null) {
            C5264a.m21617a(C5973a.f18807a, "invite upload log start");
            File file = new File(a.mo27111b());
            if (!file.exists()) {
                C5264a.m21617a(C5973a.f18807a, "invite upload log cancel because log file not exist");
                return;
            }
            int a2 = C6168c.m24474a("4.10.0", C5977b.invite.toString(), "INVITE", m23906a(file, PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED), 0, System.currentTimeMillis());
            String str = C5973a.f18807a;
            StringBuilder sb = new StringBuilder("invite upload log ");
            sb.append(a2 == 200 ? "success" : "fail");
            C5264a.m21617a(str, sb.toString());
        }
    }

    /* renamed from: b */
    private static void m23911b(File file) {
        if (file.exists()) {
            if (file.isDirectory()) {
                File[] listFiles = file.listFiles();
                if (listFiles != null) {
                    for (File b : listFiles) {
                        m23911b(b);
                    }
                }
                file.delete();
                return;
            }
            file.delete();
        }
    }
}
