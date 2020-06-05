package com.p530ss.android.socialbase.appdownloader;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.provider.Settings.Secure;
import android.text.TextUtils;
import com.p530ss.android.socialbase.appdownloader.p550a.AbsDevicePlan;
import com.p530ss.android.socialbase.appdownloader.p550a.AndroidUnknownSourcePlan;
import com.p530ss.android.socialbase.appdownloader.p550a.DevicePlans;
import com.p530ss.android.socialbase.appdownloader.p550a.XiaoMiUnknownSourcePlan;
import com.p530ss.android.socialbase.appdownloader.view.JumpUnknownSourceActivity;
import com.p530ss.android.socialbase.downloader.downloader.C6694b;
import com.p530ss.android.socialbase.downloader.p556a.AppStatusManager;
import com.p530ss.android.socialbase.downloader.p556a.AppStatusManager.C6638a;
import com.p530ss.android.socialbase.downloader.p561f.C6704a;
import com.p530ss.android.socialbase.downloader.p562g.DownloadInfo;
import com.p530ss.android.socialbase.downloader.p567k.DownloadSetting;
import com.p530ss.android.socialbase.downloader.p568l.WeakDownloadHandler;
import com.p530ss.android.socialbase.downloader.p568l.WeakDownloadHandler.C6749a;
import com.p530ss.android.socialbase.downloader.p569m.AppUtils;
import com.p530ss.android.socialbase.downloader.p569m.AppUtils.C6750a;
import com.p530ss.android.socialbase.downloader.p569m.C6792i;
import com.tencent.mid.sotrage.StorageInterface;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: AntiHijackUtils */
/* renamed from: com.ss.android.socialbase.appdownloader.b */
public class C6604b {
    /* renamed from: a */
    private static C6609c f21485a;
    /* renamed from: b */
    private static final HashMap<String, C6750a> f21486b = new HashMap<>();
    /* access modifiers changed from: private|static */
    /* renamed from: c */
    public static C6607a f21487c;

    /* compiled from: AntiHijackUtils */
    /* renamed from: com.ss.android.socialbase.appdownloader.b$a */
    private static class C6607a implements C6638a {
        /* renamed from: a */
        private final C6611e f21488a;
        /* renamed from: b */
        private final int f21489b;
        /* renamed from: c */
        private JSONObject f21490c;

        public C6607a(Context context, Intent intent, JSONObject jSONObject, C6608b bVar) {
            this.f21490c = jSONObject;
            this.f21489b = jSONObject.optInt("query_interval", 1000);
            C6611e eVar = new C6611e(context, intent, bVar, (long) this.f21489b);
            this.f21488a = eVar;
        }

        /* renamed from: b */
        public void mo31235b() {
            if (!this.f21488a.f21501g) {
                Message obtain = Message.obtain();
                obtain.what = 2;
                this.f21488a.f21498d.sendMessage(obtain);
            }
            AppStatusManager.m26964a().mo31647b((C6638a) this);
            C6604b.f21487c = null;
        }

        /* renamed from: c */
        public void mo31237c() {
            if (VERSION.SDK_INT < 29) {
                int optInt = this.f21490c.optInt("time_out_second", 10);
                Message obtain = Message.obtain();
                obtain.what = 1;
                this.f21488a.f21498d.sendMessage(obtain);
                if (optInt > 0 && optInt < 60) {
                    Message obtain2 = Message.obtain();
                    obtain2.what = 2;
                    this.f21488a.f21498d.sendMessageDelayed(obtain2, (long) (optInt * 1000));
                }
            }
        }
    }

    /* compiled from: AntiHijackUtils */
    /* renamed from: com.ss.android.socialbase.appdownloader.b$b */
    interface C6608b {
        /* renamed from: a */
        boolean mo31457a(Context context);
    }

    /* compiled from: AntiHijackUtils */
    /* renamed from: com.ss.android.socialbase.appdownloader.b$c */
    public interface C6609c {
        /* renamed from: a */
        void mo31231a(DownloadInfo cVar, AntiHijackAttempt aVar);
    }

    /* compiled from: AntiHijackUtils */
    /* renamed from: com.ss.android.socialbase.appdownloader.b$d */
    private static class C6610d implements Callable<Boolean> {
        /* renamed from: a */
        private final Context f21491a;
        /* renamed from: b */
        private final C6608b f21492b;
        /* renamed from: c */
        private final Handler f21493c;
        /* renamed from: d */
        private final long f21494d;

        public C6610d(Handler handler, Context context, C6608b bVar, long j) {
            this.f21491a = context;
            this.f21492b = bVar;
            this.f21493c = handler;
            this.f21494d = j;
        }

        /* renamed from: a */
        public Boolean call() throws Exception {
            try {
                if (this.f21492b != null && this.f21494d > 0) {
                    if (this.f21494d <= 10000) {
                        Context context = this.f21491a;
                        boolean a = context != null ? this.f21492b.mo31457a(context) : false;
                        Message obtain = Message.obtain();
                        if (a) {
                            obtain.what = 2;
                            this.f21493c.sendMessage(obtain);
                        } else {
                            obtain.what = 1;
                            this.f21493c.sendMessageDelayed(obtain, this.f21494d);
                        }
                        return Boolean.valueOf(false);
                    }
                }
                return Boolean.valueOf(false);
            } catch (Throwable unused) {
            }
        }
    }

    /* compiled from: AntiHijackUtils */
    /* renamed from: com.ss.android.socialbase.appdownloader.b$e */
    private static class C6611e implements C6749a {
        /* renamed from: a */
        private final Context f21495a;
        /* renamed from: b */
        private final Intent f21496b;
        /* renamed from: c */
        private final C6608b f21497c;
        /* access modifiers changed from: private|final */
        /* renamed from: d */
        public final Handler f21498d;
        /* renamed from: e */
        private final long f21499e;
        /* renamed from: f */
        private Future<Boolean> f21500f;
        /* access modifiers changed from: private */
        /* renamed from: g */
        public boolean f21501g = false;

        public C6611e(Context context, Intent intent, C6608b bVar, long j) {
            this.f21495a = context;
            this.f21496b = intent;
            this.f21497c = bVar;
            this.f21498d = new WeakDownloadHandler(Looper.getMainLooper(), this);
            this.f21499e = j;
        }

        /* renamed from: a */
        public void mo31460a(Message message) {
            if (message != null) {
                if (message.what == 1) {
                    long j = this.f21499e;
                    if (j > 0 && j <= 10000) {
                        ExecutorService j2 = C6694b.m27378j();
                        C6610d dVar = new C6610d(this.f21498d, this.f21495a, this.f21497c, this.f21499e);
                        this.f21500f = j2.submit(dVar);
                    }
                } else if (message.what == 2) {
                    this.f21498d.removeMessages(2);
                    this.f21498d.removeMessages(1);
                    Future<Boolean> future = this.f21500f;
                    if (future != null) {
                        future.cancel(true);
                    }
                    if (!this.f21501g) {
                        C6604b.m26628b(this.f21495a, this.f21496b);
                        this.f21501g = true;
                    }
                }
            }
        }
    }

    /* renamed from: a */
    protected static boolean m26618a(Context context, DownloadInfo cVar, Intent intent, boolean z) {
        JSONArray e = DownloadSetting.m28610a(cVar.mo32283g()).mo32556e("anti_plans");
        if (e == null) {
            return false;
        }
        int length = e.length();
        for (int i = 0; i < length; i++) {
            JSONObject optJSONObject = e.optJSONObject(i);
            if (optJSONObject != null && m26624a(optJSONObject) && m26617a(context, cVar, intent, optJSONObject, z)) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x0068  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00c6  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x00e6  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x00f7  */
    /* renamed from: a */
    private static boolean m26617a(android.content.Context r9, com.p530ss.android.socialbase.downloader.p562g.DownloadInfo r10, android.content.Intent r11, org.json.JSONObject r12, boolean r13) {
        /*
        r0 = 0
        if (r12 == 0) goto L_0x00fa
        if (r10 != 0) goto L_0x0007
        goto L_0x00fa
    L_0x0007:
        com.ss.android.socialbase.appdownloader.a r1 = new com.ss.android.socialbase.appdownloader.a
        r1.m51359init()
        java.lang.String r2 = "type"
        java.lang.String r2 = r12.optString(r2)
        java.lang.StringBuilder r3 = new java.lang.StringBuilder
        r3.<init>()
        java.lang.String r4 = "runAntiHijack type = "
        r3.append(r4)
        r3.append(r2)
        java.lang.String r3 = r3.toString()
        java.lang.String r4 = "AntiHijackUtils"
        com.p530ss.android.socialbase.downloader.p561f.C6704a.m27758b(r4, r3)
        boolean r3 = android.text.TextUtils.isEmpty(r2)
        if (r3 != 0) goto L_0x00fa
        r1.f21477a = r2
        int r3 = r2.hashCode()
        r5 = -2097307557(0xffffffff82fda05b, float:-3.7267048E-37)
        r6 = 2
        r7 = -1
        r8 = 1
        if (r3 == r5) goto L_0x005b
        r5 = -1870668843(0xffffffff907fdbd5, float:-5.0459235E-29)
        if (r3 == r5) goto L_0x0051
        r5 = 778176993(0x2e6209e1, float:5.1395225E-11)
        if (r3 == r5) goto L_0x0047
        goto L_0x0065
    L_0x0047:
        java.lang.String r3 = "jump_unknown_source"
        boolean r2 = r2.equals(r3)
        if (r2 == 0) goto L_0x0065
        r2 = 0
        goto L_0x0066
    L_0x0051:
        java.lang.String r3 = "jump_file_manager_custom"
        boolean r2 = r2.equals(r3)
        if (r2 == 0) goto L_0x0065
        r2 = 2
        goto L_0x0066
    L_0x005b:
        java.lang.String r3 = "jump_file_manager"
        boolean r2 = r2.equals(r3)
        if (r2 == 0) goto L_0x0065
        r2 = 1
        goto L_0x0066
    L_0x0065:
        r2 = -1
    L_0x0066:
        if (r2 == 0) goto L_0x00c6
        if (r2 == r8) goto L_0x0089
        if (r2 == r6) goto L_0x006e
        goto L_0x00e4
    L_0x006e:
        com.ss.android.socialbase.appdownloader.a r11 = m26625b(r12)
        int r13 = r11.f21478b
        if (r13 == 0) goto L_0x0077
        goto L_0x00a7
    L_0x0077:
        boolean r11 = r10.mo32259be()
        if (r11 != 0) goto L_0x0084
        int r9 = r10.mo32294j(r7)
        r1.f21478b = r9
        goto L_0x00e4
    L_0x0084:
        boolean r9 = m26629b(r9, r10, r12, r1)
        goto L_0x00c4
    L_0x0089:
        com.ss.android.socialbase.appdownloader.a r11 = m26625b(r12)
        int r13 = r11.f21478b
        if (r13 == 0) goto L_0x00a9
        java.lang.StringBuilder r9 = new java.lang.StringBuilder
        r9.<init>()
        java.lang.String r12 = "runAntiHijack jump_file_manager break, error_code = "
        r9.append(r12)
        int r12 = r11.f21478b
        r9.append(r12)
        java.lang.String r9 = r9.toString()
        com.p530ss.android.socialbase.downloader.p561f.C6704a.m27758b(r4, r9)
    L_0x00a7:
        r1 = r11
        goto L_0x00e4
    L_0x00a9:
        boolean r11 = r10.mo32259be()
        if (r11 != 0) goto L_0x00bb
        java.lang.String r9 = "runAntiHijack jump_file_manager savePathRedirected error"
        com.p530ss.android.socialbase.downloader.p561f.C6704a.m27758b(r4, r9)
        int r9 = r10.mo32294j(r7)
        r1.f21478b = r9
        goto L_0x00e4
    L_0x00bb:
        java.lang.String r11 = "runAntiHijack jump_file_manager start jumpFileManagerPage"
        com.p530ss.android.socialbase.downloader.p561f.C6704a.m27758b(r4, r11)
        boolean r9 = m26619a(r9, r10, r12, r1)
    L_0x00c4:
        r0 = r9
        goto L_0x00e4
    L_0x00c6:
        int r2 = android.os.Build.VERSION.SDK_INT
        r3 = 26
        if (r2 >= r3) goto L_0x00d2
        boolean r2 = com.p530ss.android.socialbase.downloader.p569m.C6792i.m28932b()
        if (r2 == 0) goto L_0x00e4
    L_0x00d2:
        java.lang.String r2 = "enable_for_all"
        int r2 = r12.optInt(r2, r0)
        if (r2 != r8) goto L_0x00db
        goto L_0x00dc
    L_0x00db:
        r8 = 0
    L_0x00dc:
        if (r8 != 0) goto L_0x00e0
        if (r13 == 0) goto L_0x00e4
    L_0x00e0:
        boolean r0 = m26615a(r9, r11, r12, r1)
    L_0x00e4:
        if (r0 == 0) goto L_0x00f3
        android.os.Bundle r9 = r10.mo32261bg()
        java.lang.String r11 = r1.mo31451a()
        java.lang.String r12 = "anti_hijack_attempt"
        r9.putString(r12, r11)
    L_0x00f3:
        com.ss.android.socialbase.appdownloader.b$c r9 = f21485a
        if (r9 == 0) goto L_0x00fa
        r9.mo31231a(r10, r1)
    L_0x00fa:
        return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.p530ss.android.socialbase.appdownloader.C6604b.m26617a(android.content.Context, com.ss.android.socialbase.downloader.g.c, android.content.Intent, org.json.JSONObject, boolean):boolean");
    }

    /* renamed from: a */
    private static boolean m26624a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return true;
        }
        String optString = jSONObject.optString("device_rom");
        if (TextUtils.isEmpty(optString)) {
            return true;
        }
        String f = C6792i.m28936f();
        if (!TextUtils.isEmpty(f) && optString.toLowerCase().contains(f.toLowerCase())) {
            return true;
        }
        return false;
    }

    /* renamed from: a */
    private static boolean m26619a(Context context, DownloadInfo cVar, JSONObject jSONObject, AntiHijackAttempt aVar) {
        boolean z;
        String str;
        Context context2 = context;
        DownloadInfo cVar2 = cVar;
        JSONObject jSONObject2 = jSONObject;
        AntiHijackAttempt aVar2 = aVar;
        if (!(context2 == null || jSONObject2 == null)) {
            String optString = jSONObject2.optString("device_plans");
            aVar2.f21481e = optString;
            StringBuilder sb = new StringBuilder();
            sb.append("jumpFileManagerPage devicePlans = ");
            sb.append(optString);
            String str2 = "AntiHijackUtils";
            C6704a.m27758b(str2, sb.toString());
            if (!TextUtils.isEmpty(optString)) {
                String[] split = optString.split(StorageInterface.KEY_SPLITER);
                String k = cVar.mo32297k();
                if (TextUtils.isEmpty(k)) {
                    return false;
                }
                File file = new File(k);
                StringBuilder sb2 = new StringBuilder();
                int length = split.length;
                int i = 0;
                while (true) {
                    z = true;
                    if (i >= length) {
                        z = false;
                        str = null;
                        break;
                    }
                    str = split[i];
                    AbsDevicePlan a = DevicePlans.m26597a(context2, str, jSONObject2, cVar2);
                    if (a != null) {
                        Intent b = a.mo31456b();
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append("try startActivity : ");
                        sb3.append(str);
                        C6704a.m27758b(str2, sb3.toString());
                        if (b == null) {
                            m26610a(aVar2, 3);
                            sb2.append(str);
                            sb2.append(" resolveActivity failed! ");
                        } else if (m26620a(file, cVar2, jSONObject2)) {
                            try {
                                StringBuilder sb4 = new StringBuilder();
                                sb4.append("using jumpFileManagerPage plan : ");
                                sb4.append(str);
                                C6704a.m27758b(str2, sb4.toString());
                                m26616a(context2, b, false);
                                break;
                            } catch (Throwable th) {
                                C6704a.m27755a(str2, "try startActivity failed : ", th);
                                sb2.append(str);
                                sb2.append(" startActivity failed : ");
                                sb2.append(m26608a(th));
                                m26610a(aVar2, 1);
                            }
                        } else {
                            m26610a(aVar2, 6);
                            sb2.append(str);
                            sb2.append(" createDescFile failed! ");
                        }
                    }
                    sb2.append("  ");
                    i++;
                }
                if (!z) {
                    aVar2.f21479c = sb2.toString();
                } else {
                    aVar2.f21480d = str;
                    aVar2.f21478b = 0;
                }
                return z;
            }
        }
        return false;
    }

    /* renamed from: b */
    private static boolean m26629b(Context context, DownloadInfo cVar, JSONObject jSONObject, AntiHijackAttempt aVar) {
        if (!(context == null || jSONObject == null)) {
            String k = cVar.mo32297k();
            if (TextUtils.isEmpty(k)) {
                return false;
            }
            String str = "custom";
            aVar.f21480d = str;
            AbsDevicePlan a = DevicePlans.m26597a(context, str, jSONObject, cVar);
            if (a == null || !a.mo31455a()) {
                aVar.f21478b = 3;
            } else {
                Intent b = a.mo31456b();
                if (b == null) {
                    return false;
                }
                if (!m26620a(new File(k), cVar, jSONObject)) {
                    aVar.f21478b = 6;
                } else if (m26628b(context, b)) {
                    aVar.f21478b = 0;
                    return true;
                } else {
                    aVar.f21478b = 1;
                }
                return false;
            }
        }
        return false;
    }

    /* renamed from: a */
    public static int m26605a(DownloadSetting aVar) {
        JSONObject d = aVar.mo32555d("anti_hijack_dir");
        if (!(d != null ? !TextUtils.isEmpty(d.optString("dir_name")) : false)) {
            return 5;
        }
        String str = "get_download_info_by_list";
        if (!DownloadSetting.m28617b().mo32550a(str)) {
            if (!aVar.mo32550a("force_enable_get_download_info_by_list")) {
                return 4;
            }
            DownloadSetting.m28616a(str, true);
        }
        JSONArray e = aVar.mo32556e("anti_plans");
        int i = -1;
        if (e != null) {
            int length = e.length();
            int i2 = -1;
            for (int i3 = 0; i3 < length; i3++) {
                JSONObject optJSONObject = e.optJSONObject(i3);
                if (optJSONObject != null && m26624a(optJSONObject)) {
                    String optString = optJSONObject.optString("type");
                    if ("jump_file_manager".equals(optString) || "jump_file_manager_custom".equals(optString)) {
                        AntiHijackAttempt b = m26625b(optJSONObject);
                        int i4 = b.f21478b;
                        if (b.f21478b == 0) {
                            return 0;
                        }
                        i2 = i4;
                    }
                }
            }
            i = i2;
        }
        return i;
    }

    /* renamed from: b */
    private static AntiHijackAttempt m26625b(JSONObject jSONObject) {
        AntiHijackAttempt aVar = new AntiHijackAttempt();
        if (jSONObject == null) {
            return aVar;
        }
        String optString = jSONObject.optString("type");
        aVar.f21477a = optString;
        try {
            if (!m26621a(jSONObject.optJSONArray("device_requirements"))) {
                m26610a(aVar, 2);
                return aVar;
            }
            if ("jump_file_manager_custom".equals(optString)) {
                String str = "custom";
                aVar.f21481e = str;
                if (DevicePlans.m26598a(C6694b.m27342B(), str, jSONObject)) {
                    aVar.f21478b = 0;
                    return aVar;
                }
                m26610a(aVar, 3);
            } else {
                String optString2 = jSONObject.optString("device_plans");
                aVar.f21481e = optString2;
                if (!TextUtils.isEmpty(optString2)) {
                    for (String a : optString2.split(StorageInterface.KEY_SPLITER)) {
                        if (DevicePlans.m26598a(C6694b.m27342B(), a, jSONObject)) {
                            aVar.f21478b = 0;
                            return aVar;
                        }
                        m26610a(aVar, 3);
                    }
                }
            }
            return aVar;
        } catch (Throwable th) {
            StringBuilder sb = new StringBuilder();
            sb.append("checkJumpFileManagerConfig");
            sb.append(m26608a(th));
            aVar.f21479c = sb.toString();
            m26610a(aVar, 4);
            return aVar;
        }
    }

    /* renamed from: a */
    private static void m26610a(AntiHijackAttempt aVar, int i) {
        if (aVar.f21478b != -1) {
            aVar.f21478b = (aVar.f21478b * 10) + i;
        } else {
            aVar.f21478b = i;
        }
    }

    /* renamed from: a */
    public static boolean m26621a(JSONArray jSONArray) {
        if (jSONArray == null) {
            return true;
        }
        int length = jSONArray.length();
        if (length == 0) {
            return true;
        }
        boolean z = false;
        for (int i = 0; i < length; i++) {
            JSONObject optJSONObject = jSONArray.optJSONObject(i);
            if (optJSONObject != null) {
                String optString = optJSONObject.optString("package_names");
                JSONArray optJSONArray = optJSONObject.optJSONArray("version_white");
                JSONArray optJSONArray2 = optJSONObject.optJSONArray("version_black");
                if (TextUtils.isEmpty(optString) || (optJSONArray == null && optJSONArray2 == null)) {
                    return false;
                }
                String[] split = optString.split(StorageInterface.KEY_SPLITER);
                if (split != null) {
                    boolean z2 = z;
                    for (String b : split) {
                        C6750a b2 = m26626b(b);
                        if (b2 != null) {
                            z2 = m26623a(optJSONArray, optJSONArray2, b2);
                            if (!z2) {
                                return false;
                            }
                        }
                    }
                    z = z2;
                } else {
                    continue;
                }
            }
        }
        return z;
    }

    /* renamed from: b */
    private static C6750a m26626b(String str) {
        if (f21486b.containsKey(str)) {
            C6750a aVar = (C6750a) f21486b.get(str);
            if (aVar != null) {
                return aVar;
            }
            return null;
        }
        C6750a a = AppUtils.m28726a(str);
        f21486b.put(str, a);
        if (a != null) {
            return a;
        }
        return null;
    }

    /* renamed from: a */
    public static C6750a m26607a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            String[] split = str.split(StorageInterface.KEY_SPLITER);
            if (split != null) {
                for (String str2 : split) {
                    if (!TextUtils.isEmpty(str2)) {
                        C6750a b = m26626b(str2);
                        if (b != null) {
                            return b;
                        }
                    }
                }
            }
        } catch (Throwable unused) {
        }
        return null;
    }

    /* renamed from: a */
    private static boolean m26623a(JSONArray jSONArray, JSONArray jSONArray2, C6750a aVar) {
        String g = aVar.mo32602g();
        int f = aVar.mo32601f();
        StringBuilder sb = new StringBuilder();
        sb.append(f);
        sb.append("_");
        sb.append(g);
        String sb2 = sb.toString();
        if (jSONArray == null || jSONArray.length() <= 0) {
            if (jSONArray2 != null && jSONArray2.length() > 0 && !m26622a(jSONArray2, sb2)) {
                return true;
            }
        } else if (m26622a(jSONArray, sb2)) {
            return true;
        }
        return false;
    }

    /* renamed from: a */
    private static boolean m26622a(JSONArray jSONArray, String str) {
        if (!(jSONArray == null || str == null)) {
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                if (str.equalsIgnoreCase(jSONArray.optString(i).trim())) {
                    return true;
                }
            }
        }
        return false;
    }

    /* renamed from: a */
    private static boolean m26620a(File file, DownloadInfo cVar, JSONObject jSONObject) {
        if (file == null) {
            return false;
        }
        String path = file.getPath();
        JSONObject d = DownloadSetting.m28610a(cVar.mo32283g()).mo32555d("anti_hijack_dir");
        File file2 = null;
        String optString = d != null ? d.optString("install_desc") : null;
        if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString)) {
            StringBuilder sb = new StringBuilder();
            sb.append(path);
            sb.append(File.separator);
            sb.append(optString);
            file2 = new File(sb.toString());
        }
        if (file2 != null) {
            try {
                if (file2.createNewFile()) {
                    file2.deleteOnExit();
                }
            } catch (IOException unused) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: a */
    public static boolean m26615a(Context context, Intent intent, JSONObject jSONObject, AntiHijackAttempt aVar) {
        if (!(context == null || jSONObject == null)) {
            int optInt = jSONObject.optInt("max_jump_count", 0);
            if (optInt <= 0) {
                return false;
            }
            SharedPreferences sharedPreferences = context.getSharedPreferences("sp_anti_hijack_config", 0);
            String str = "jump_unknown_source_count";
            int i = sharedPreferences.getInt(str, 0);
            if (i < optInt && !m26612a(context)) {
                sharedPreferences.edit().putInt(str, i + 1).apply();
                Intent intent2 = new Intent(context, JumpUnknownSourceActivity.class);
                intent2.addFlags(268435456);
                intent2.putExtra("intent", intent);
                intent2.putExtra("config", jSONObject.toString());
                try {
                    m26616a(context, intent2, false);
                    if (aVar != null) {
                        aVar.f21478b = 0;
                    }
                    return true;
                } catch (Throwable th) {
                    if (aVar != null) {
                        aVar.f21478b = 1;
                        StringBuilder sb = new StringBuilder();
                        sb.append("tryShowUnknownSourceDialog");
                        sb.append(m26608a(th));
                        aVar.f21479c = sb.toString();
                    }
                }
            }
        }
        return false;
    }

    /* renamed from: a */
    public static boolean m26614a(Context context, Intent intent, JSONObject jSONObject) {
        try {
            if (!C6792i.m28932b() || VERSION.SDK_INT >= 26) {
                if (VERSION.SDK_INT >= 26 && context.getApplicationInfo().targetSdkVersion >= 26 && !m26632e(context)) {
                    AndroidUnknownSourcePlan bVar = new AndroidUnknownSourcePlan(context);
                    if (bVar.mo31455a()) {
                        m26609a(context, intent, jSONObject, (C6608b) new C6608b() {
                            /* renamed from: a */
                            public boolean mo31457a(Context context) {
                                return C6604b.m26632e(context);
                            }
                        });
                        return m26628b(context, bVar.mo31456b());
                    }
                }
                return false;
            }
            if (!m26631d(context)) {
                XiaoMiUnknownSourcePlan jVar = new XiaoMiUnknownSourcePlan(context);
                if (!jVar.mo31455a()) {
                    return true;
                }
                m26609a(context, intent, jSONObject, (C6608b) new C6608b() {
                    /* renamed from: a */
                    public boolean mo31457a(Context context) {
                        return C6604b.m26631d(context);
                    }
                });
                return m26628b(context, jVar.mo31456b());
            }
            return false;
        } catch (Throwable unused) {
        }
    }

    /* renamed from: a */
    public static boolean m26612a(Context context) {
        if (context == null) {
            return true;
        }
        try {
            if (C6792i.m28932b() && VERSION.SDK_INT < 26) {
                return m26631d(context);
            }
            if (VERSION.SDK_INT >= 26 && context.getApplicationInfo().targetSdkVersion >= 26) {
                return m26632e(context);
            }
            return true;
        } catch (Throwable unused) {
        }
    }

    /* access modifiers changed from: private|static */
    /* renamed from: d */
    public static boolean m26631d(Context context) {
        boolean z = true;
        if (context == null) {
            return true;
        }
        try {
            if (Secure.getInt(context.getContentResolver(), "install_non_market_apps", 1) <= 0) {
                z = false;
            }
        } catch (Throwable unused) {
        }
        return z;
    }

    /* access modifiers changed from: private|static */
    /* renamed from: e */
    public static boolean m26632e(Context context) {
        if (context == null) {
            return true;
        }
        try {
            return context.getPackageManager().canRequestPackageInstalls();
        } catch (Throwable unused) {
            return true;
        }
    }

    /* renamed from: a */
    private static void m26609a(Context context, Intent intent, JSONObject jSONObject, C6608b bVar) {
        if (f21487c != null) {
            AppStatusManager.m26964a().mo31647b((C6638a) f21487c);
            f21487c = null;
        }
        f21487c = new C6607a(context, intent, jSONObject, bVar);
        AppStatusManager.m26964a().mo31645a((C6638a) f21487c);
    }

    /* access modifiers changed from: private|static */
    /* renamed from: b */
    public static boolean m26628b(Context context, Intent intent) {
        return m26616a(context, intent, true);
    }

    /* renamed from: a */
    public static boolean m26616a(Context context, Intent intent, boolean z) {
        if (context == null || intent == null) {
            return false;
        }
        String str = "start_only_for_android";
        if (z) {
            try {
                intent.putExtra(str, true);
                context.startActivity(intent);
                return true;
            } catch (Throwable unused) {
                return false;
            }
        } else {
            intent.putExtra(str, true);
            context.startActivity(intent);
            return true;
        }
    }

    /* renamed from: a */
    public static String m26608a(Throwable th) {
        String th2 = th.toString();
        return th2.length() > 800 ? th2.substring(0, 500) : th2;
    }

    /* renamed from: a */
    public static void m26611a(C6609c cVar) {
        f21485a = cVar;
    }
}
