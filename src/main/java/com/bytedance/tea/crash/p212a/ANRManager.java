package com.bytedance.tea.crash.p212a;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.bytedance.tea.crash.CrashType;
import com.bytedance.tea.crash.ICrashCallback;
import com.bytedance.tea.crash.NpthBus;
import com.bytedance.tea.crash.p221g.IoUtil;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONObject;

/* renamed from: com.bytedance.tea.crash.a.c */
public class ANRManager {
    /* renamed from: a */
    static volatile boolean f9205a = true;
    /* renamed from: b */
    private ANRFileObserver f9206b;
    /* renamed from: c */
    private ANRThread f9207c;
    /* renamed from: d */
    private final Context f9208d;
    /* renamed from: e */
    private volatile long f9209e;
    /* renamed from: f */
    private volatile boolean f9210f = false;
    /* renamed from: g */
    private final SharedPreferences f9211g;

    public ANRManager(Context context) {
        if (context == null || !(context instanceof Application)) {
            throw new IllegalArgumentException("context must not be null or not application");
        }
        this.f9208d = context;
        this.f9211g = this.f9208d.getSharedPreferences("anr_monitor_table", 0);
        this.f9209e = this.f9211g.getLong("trace_anr_happen_time", 0);
        LooperMonitor.m12295a(100, 100);
    }

    /* renamed from: a */
    public void mo16961a() {
        if (!this.f9210f) {
            if (VERSION.SDK_INT < 21) {
                this.f9206b = new ANRFileObserver(this, "/data/anr/", 8);
                this.f9206b.startWatching();
            } else {
                this.f9207c = new ANRThread(this);
            }
            this.f9210f = true;
        }
    }

    /* access modifiers changed from: 0000 */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0045, code lost:
            if (r8.length() > 0) goto L_0x0049;
     */
    /* renamed from: a */
    public boolean mo16962a(int r8, java.lang.String r9, int r10) {
        /*
        r7 = this;
        org.json.JSONArray r0 = com.bytedance.tea.crash.p212a.LooperMonitor.m12300b()
        long r1 = android.os.SystemClock.uptimeMillis()
        org.json.JSONObject r3 = com.bytedance.tea.crash.p212a.LooperMonitor.m12292a(r1)
        r4 = 100
        org.json.JSONArray r1 = com.bytedance.tea.crash.p212a.LooperMonitor.m12291a(r4, r1)
        r2 = 0
        boolean r4 = f9205a     // Catch:{ JSONException -> 0x001a }
        org.json.JSONObject r4 = com.bytedance.tea.crash.p212a.ANRUtils.m12284a(r4)     // Catch:{ JSONException -> 0x001a }
        goto L_0x001f
    L_0x001a:
        r4 = move-exception
        r4.printStackTrace()
        r4 = r2
    L_0x001f:
        android.content.Context r5 = r7.f9208d
        java.lang.String r10 = com.bytedance.tea.crash.p212a.ANRUtils.m12283a(r5, r10)
        boolean r5 = android.text.TextUtils.isEmpty(r10)
        r6 = 0
        if (r5 == 0) goto L_0x002d
        return r6
    L_0x002d:
        r5 = 200(0xc8, float:2.8E-43)
        if (r8 != r5) goto L_0x0048
        int r8 = android.os.Process.myPid()
        android.content.Context r5 = r7.f9208d
        java.lang.String r5 = r5.getPackageName()
        org.json.JSONObject r8 = r7.mo16960a(r9, r8, r5)
        if (r8 == 0) goto L_0x0048
        int r9 = r8.length()
        if (r9 <= 0) goto L_0x0048
        goto L_0x0049
    L_0x0048:
        r8 = r4
    L_0x0049:
        r9 = 1
        if (r8 == 0) goto L_0x00fa
        int r4 = r8.length()
        if (r4 <= 0) goto L_0x00fa
        java.lang.String r4 = "pid"
        int r5 = android.os.Process.myPid()     // Catch:{ all -> 0x00f6 }
        r8.put(r4, r5)     // Catch:{ all -> 0x00f6 }
        java.lang.String r4 = "package"
        android.content.Context r5 = r7.f9208d     // Catch:{ all -> 0x00f6 }
        java.lang.String r5 = r5.getPackageName()     // Catch:{ all -> 0x00f6 }
        r8.put(r4, r5)     // Catch:{ all -> 0x00f6 }
        java.lang.String r4 = "is_remote_process"
        r8.put(r4, r6)     // Catch:{ all -> 0x00f6 }
        com.bytedance.tea.crash.c.a r4 = new com.bytedance.tea.crash.c.a     // Catch:{ all -> 0x00f6 }
        org.json.JSONObject r5 = new org.json.JSONObject     // Catch:{ all -> 0x00f6 }
        r5.<init>()     // Catch:{ all -> 0x00f6 }
        r4.m44284init(r5)     // Catch:{ all -> 0x00f6 }
        java.lang.String r5 = "data"
        java.lang.String r8 = r8.toString()     // Catch:{ all -> 0x00f6 }
        r4.mo16998a(r5, r8)     // Catch:{ all -> 0x00f6 }
        java.lang.String r8 = "is_anr"
        java.lang.Integer r5 = java.lang.Integer.valueOf(r9)     // Catch:{ all -> 0x00f6 }
        r4.mo16998a(r8, r5)     // Catch:{ all -> 0x00f6 }
        java.lang.String r8 = "timestamp"
        long r5 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x00f6 }
        java.lang.Long r5 = java.lang.Long.valueOf(r5)     // Catch:{ all -> 0x00f6 }
        r4.mo16998a(r8, r5)     // Catch:{ all -> 0x00f6 }
        java.lang.String r8 = "event_type"
        java.lang.String r5 = "anr"
        r4.mo16998a(r8, r5)     // Catch:{ all -> 0x00f6 }
        java.lang.String r8 = "history_message"
        r4.mo16998a(r8, r0)     // Catch:{ all -> 0x00f6 }
        java.lang.String r8 = "current_message"
        r4.mo16998a(r8, r3)     // Catch:{ all -> 0x00f6 }
        java.lang.String r8 = "pending_messages"
        r4.mo16998a(r8, r1)     // Catch:{ all -> 0x00f6 }
        java.lang.String r8 = "anr_time"
        long r0 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x00f6 }
        java.lang.Long r0 = java.lang.Long.valueOf(r0)     // Catch:{ all -> 0x00f6 }
        r4.mo16998a(r8, r0)     // Catch:{ all -> 0x00f6 }
        java.lang.String r8 = "crash_time"
        long r0 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x00f6 }
        java.lang.Long r0 = java.lang.Long.valueOf(r0)     // Catch:{ all -> 0x00f6 }
        r4.mo16998a(r8, r0)     // Catch:{ all -> 0x00f6 }
        java.lang.String r8 = "anr_info"
        r4.mo16998a(r8, r10)     // Catch:{ all -> 0x00f6 }
        java.lang.String r8 = "all_thread_stacks"
        org.json.JSONObject r0 = com.bytedance.tea.crash.p221g.Stack.m12572a(r2)     // Catch:{ all -> 0x00f6 }
        r4.mo16998a(r8, r0)     // Catch:{ all -> 0x00f6 }
        com.bytedance.tea.crash.e.a.e r8 = com.bytedance.tea.crash.p218e.p219a.CrashContextAssembly.m12442a()     // Catch:{ all -> 0x00f6 }
        com.bytedance.tea.crash.c r0 = com.bytedance.tea.crash.CrashType.ANR     // Catch:{ all -> 0x00f6 }
        com.bytedance.tea.crash.c.a r8 = r8.mo17041a(r0, r4)     // Catch:{ all -> 0x00f6 }
        android.content.Context r0 = r7.f9208d     // Catch:{ all -> 0x00f6 }
        com.bytedance.tea.crash.c r1 = com.bytedance.tea.crash.CrashType.ANR     // Catch:{ all -> 0x00f6 }
        java.lang.String r1 = r1.mo16988a()     // Catch:{ all -> 0x00f6 }
        com.bytedance.tea.crash.p221g.C2593d.m12526a(r0, r1, r2)     // Catch:{ all -> 0x00f6 }
        com.bytedance.tea.crash.upload.a r0 = com.bytedance.tea.crash.upload.CrashUploadManager.m12604a()     // Catch:{ all -> 0x00f6 }
        org.json.JSONObject r8 = r8.mo16997a()     // Catch:{ all -> 0x00f6 }
        r0.mo17077b(r8)     // Catch:{ all -> 0x00f6 }
        m12275a(r10)     // Catch:{ all -> 0x00f6 }
        goto L_0x00fa
    L_0x00f6:
        r8 = move-exception
        com.bytedance.tea.crash.p221g.NpthLog.m12550b(r8)
    L_0x00fa:
        return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.tea.crash.p212a.ANRManager.mo16962a(int, java.lang.String, int):boolean");
    }

    /* renamed from: a */
    private static void m12275a(String str) {
        for (ICrashCallback a : NpthBus.m12593b().mo16974c()) {
            a.mo17018a(CrashType.ANR, str, null);
        }
    }

    /* renamed from: a */
    public JSONObject mo16960a(String str, int i, String str2) {
        BufferedReader bufferedReader;
        int i2;
        String str3 = "\\s";
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        File file = new File(str);
        if (!file.exists() || !file.canRead()) {
            return null;
        }
        try {
            bufferedReader = new BufferedReader(new FileReader(file));
            try {
                Pattern compile = Pattern.compile("-{5}\\spid\\s\\d+\\sat\\s\\d+-\\d+-\\d+\\s\\d{2}:\\d{2}:\\d{2}\\s-{5}");
                Pattern compile2 = Pattern.compile("-{5}\\send\\s\\d+\\s-{5}");
                Pattern compile3 = Pattern.compile("Cmd\\sline:\\s(\\S+)");
                Pattern compile4 = Pattern.compile("\".+\"\\s(daemon\\s){0,1}prio=\\d+\\stid=\\d+\\s.*");
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US);
                boolean z = false;
                Object[] a = m12276a(bufferedReader, compile);
                if (a == null) {
                    IoUtil.m12535a(bufferedReader);
                    return null;
                }
                long parseLong = Long.parseLong(a[1].toString().split(str3)[2]);
                StringBuilder sb = new StringBuilder();
                sb.append(a[1].toString().split(str3)[4]);
                sb.append(" ");
                sb.append(a[1].toString().split(str3)[5]);
                long j = parseLong;
                long time = simpleDateFormat.parse(sb.toString()).getTime();
                Object[] a2 = m12276a(bufferedReader, compile3);
                if (a2 == null) {
                    IoUtil.m12535a(bufferedReader);
                    return null;
                }
                String str4 = a2[1].toString().split(str3)[2];
                if (j == ((long) i)) {
                    if (str4.equalsIgnoreCase(str2)) {
                        if (this.f9209e == 0 || Math.abs(this.f9209e - time) >= 20000) {
                            this.f9209e = time;
                            if (this.f9211g != null) {
                                this.f9211g.edit().putLong("trace_anr_happen_time", this.f9209e).apply();
                            }
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("anrTime", time);
                            while (true) {
                                Object[] a3 = m12276a(bufferedReader, compile2, compile4);
                                if (a3 == null || a3[0] != compile4) {
                                    break;
                                }
                                String str5 = "";
                                Matcher matcher = Pattern.compile("\".+\"").matcher(a3[1].toString());
                                if (matcher.find()) {
                                    str5 = matcher.group().substring(1, matcher.group().length() - 1);
                                }
                                Matcher matcher2 = Pattern.compile("tid=\\d+").matcher(a3[1].toString());
                                if (matcher2.find()) {
                                    String group = matcher2.group();
                                    i2 = Integer.parseInt(group.substring(group.indexOf("=") + 1));
                                } else {
                                    i2 = -1;
                                }
                                String a4 = m12274a(bufferedReader);
                                if (i2 != -1 && !TextUtils.isEmpty(str5)) {
                                    if (!TextUtils.isEmpty(a4)) {
                                        if (str5.equalsIgnoreCase("main")) {
                                            jSONObject.put("mainStackFromTrace", a4);
                                            z = true;
                                            break;
                                        }
                                    }
                                }
                            }
                            if (!z) {
                                IoUtil.m12535a(bufferedReader);
                                return null;
                            }
                            jSONObject.put("thread_number", 1);
                            IoUtil.m12535a(bufferedReader);
                            return jSONObject;
                        }
                        IoUtil.m12535a(bufferedReader);
                        return null;
                    }
                }
                IoUtil.m12535a(bufferedReader);
                return null;
            } catch (Exception e) {
                e = e;
                try {
                    e.printStackTrace();
                    IoUtil.m12535a(bufferedReader);
                    return null;
                } catch (Throwable th) {
                    th = th;
                    IoUtil.m12535a(bufferedReader);
                    throw th;
                }
            }
        } catch (Exception e2) {
            e = e2;
            bufferedReader = null;
            e.printStackTrace();
            IoUtil.m12535a(bufferedReader);
            return null;
        } catch (Throwable th2) {
            th = th2;
            bufferedReader = null;
            IoUtil.m12535a(bufferedReader);
            throw th;
        }
    }

    /* renamed from: a */
    private Object[] m12276a(BufferedReader bufferedReader, Pattern... patternArr) throws IOException {
        if (bufferedReader != null && patternArr != null && patternArr.length > 0) {
            while (true) {
                try {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    }
                    int length = patternArr.length;
                    int i = 0;
                    while (true) {
                        if (i < length) {
                            Pattern pattern = patternArr[i];
                            if (pattern.matcher(readLine).matches()) {
                                return new Object[]{pattern, readLine};
                            }
                            i++;
                        }
                    }
                } catch (Throwable unused) {
                }
            }
        }
        return null;
    }

    /* renamed from: a */
    private String m12274a(BufferedReader bufferedReader) throws IOException {
        if (bufferedReader == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        while (true) {
            String readLine = bufferedReader.readLine();
            if (readLine != null && readLine.trim().length() > 0) {
                sb.append(readLine);
                sb.append("\n");
            }
        }
        return sb.toString();
    }
}
