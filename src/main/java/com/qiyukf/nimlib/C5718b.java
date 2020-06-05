package com.qiyukf.nimlib;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.text.TextUtils;
import com.qiyukf.basesdk.C5263a;
import com.qiyukf.basesdk.C5272b;
import com.qiyukf.basesdk.p393a.C5264a;
import com.qiyukf.basesdk.p412c.p417d.C5413e;
import com.qiyukf.basesdk.sdk.ServerAddresses;
import com.qiyukf.nimlib.p429a.C5668c;
import com.qiyukf.nimlib.p429a.C5685d;
import com.qiyukf.nimlib.p429a.p436c.C5669a;
import com.qiyukf.nimlib.p429a.p436c.p437a.C5671a;
import com.qiyukf.nimlib.p469e.C5805a;
import com.qiyukf.nimlib.p469e.C5815g;
import com.qiyukf.nimlib.p488k.p491c.C5946c;
import com.qiyukf.nimlib.sdk.SDKOptions;
import com.qiyukf.nimlib.sdk.auth.LoginInfo;
import com.qiyukf.nimlib.service.NimService;
import com.qiyukf.unicorn.analytics.C5973a;
import com.qiyukf.unicorn.api.StatusBarNotificationConfig;
import com.qiyukf.unicorn.p513g.C6174c;
import com.tencent.stat.common.DeviceInfo;
import java.io.File;

/* renamed from: com.qiyukf.nimlib.b */
public final class C5718b {
    /* renamed from: i */
    private static C5718b f18270i;
    /* renamed from: j */
    private static C5272b f18271j = new C5272b() {
        /* renamed from: a */
        public final String mo27114a() {
            return C5718b.m23020g();
        }

        /* renamed from: b */
        public final int mo27115b() {
            return C5718b.m23017d().thumbnailSize;
        }

        /* renamed from: c */
        public final ServerAddresses mo27116c() {
            return C5718b.m23022i();
        }

        /* renamed from: d */
        public final String mo27117d() {
            String str = C5263a.m21611d() == null ? null : C5263a.m21611d().nosUpload;
            return TextUtils.isEmpty(str) ? "https://wanproxy.127.net/lbs" : str;
        }

        /* renamed from: e */
        public final String mo27118e() {
            String str = C5263a.m21611d() == null ? null : C5263a.m21611d().nosUpload;
            return TextUtils.isEmpty(str) ? "nosup-hz1.127.net" : str;
        }

        /* renamed from: f */
        public final void mo27119f() {
            C5671a aVar = new C5671a();
            aVar.mo27876f();
            C5668c.m22861a().mo27864a((C5669a) aVar);
        }
    };
    /* renamed from: a */
    private Context f18272a;
    /* renamed from: b */
    private LoginInfo f18273b;
    /* renamed from: c */
    private Integer f18274c;
    /* renamed from: d */
    private SDKOptions f18275d;
    /* renamed from: e */
    private ServerAddresses f18276e;
    /* renamed from: f */
    private C5815g f18277f;
    /* renamed from: g */
    private String f18278g;
    /* renamed from: h */
    private String f18279h;

    private C5718b() {
    }

    /* renamed from: a */
    public static Context m23009a() {
        C5718b bVar = f18270i;
        if (bVar == null) {
            return null;
        }
        return bVar.f18272a;
    }

    /* renamed from: a */
    public static <T> T m23010a(Class<T> cls) {
        C5718b bVar = f18270i;
        if (bVar != null) {
            C5815g gVar = bVar.f18277f;
            if (gVar != null) {
                return gVar.mo28110a(cls);
            }
        }
        throw new IllegalStateException("SDK not initialized or invoked in wrong process!");
    }

    /* renamed from: a */
    private static String m23011a(Context context) {
        C5718b bVar;
        String trim;
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
            if (applicationInfo != null) {
                if (TextUtils.isEmpty(m23017d().appKey)) {
                    bVar = f18270i;
                    trim = applicationInfo.metaData.getString("com.qiyukf.nim.appKey").trim();
                } else {
                    bVar = f18270i;
                    trim = m23017d().appKey.trim();
                }
                bVar.f18279h = trim;
                f18270i.f18278g = applicationInfo.packageName;
            }
        } catch (Exception e) {
            C5264a.m21621b("readAppKey is error", "", e);
        }
        return null;
    }

    /* renamed from: a */
    public static void m23012a(Context context, LoginInfo loginInfo, SDKOptions sDKOptions, boolean z) {
        if (C5743d.m23121f() || C5743d.m23122g()) {
            C5718b bVar = new C5718b();
            f18270i = bVar;
            bVar.f18272a = context.getApplicationContext();
            C5718b bVar2 = f18270i;
            bVar2.f18275d = sDKOptions;
            bVar2.f18273b = loginInfo;
            m23011a(context);
            C5263a.m21608a(context, f18271j);
            C5946c.m23835a(context);
            C5729c.m23062a(z);
            String str = f18270i.f18279h;
            try {
                String str2 = context.getApplicationInfo().dataDir;
                C5644a.f18159a = str2;
                String str3 = "/data/data/";
                if (TextUtils.isEmpty(str2)) {
                    StringBuilder sb = new StringBuilder(str3);
                    sb.append(context.getPackageName());
                    C5644a.f18159a = sb.toString();
                }
                if (context.getCacheDir() == null) {
                    StringBuilder sb2 = new StringBuilder(str3);
                    sb2.append(context.getPackageName());
                    sb2.append("/cache");
                    C5644a.f18160b = sb2.toString();
                    File file = new File(C5644a.f18160b);
                    if (!file.exists()) {
                        file.mkdir();
                    }
                } else {
                    C5644a.f18160b = context.getCacheDir().getAbsolutePath();
                }
            } catch (Exception e) {
                C5264a.m21621b("AppDir init is error", "", e);
            }
            StringBuilder sb3 = new StringBuilder();
            sb3.append(C5644a.f18159a);
            String str4 = "/";
            sb3.append(str4);
            sb3.append(str);
            C5644a.f18159a = sb3.toString();
            StringBuilder sb4 = new StringBuilder();
            sb4.append(C5644a.f18160b);
            sb4.append(str4);
            sb4.append(str);
            C5644a.f18160b = sb4.toString();
            StringBuilder sb5 = new StringBuilder("DATA ");
            sb5.append(C5644a.f18159a);
            String str5 = "AppDir";
            C5264a.m21624d(str5, sb5.toString());
            StringBuilder sb6 = new StringBuilder("CACHE ");
            sb6.append(C5644a.f18160b);
            C5264a.m21624d(str5, sb6.toString());
            String a = C5413e.m22152a(context);
            String str6 = C5743d.m23121f() ? DeviceInfo.TAG_IMEI : "core";
            StringBuilder sb7 = new StringBuilder("SDK init, processName=");
            sb7.append(a);
            C5264a.m21617a(str6, sb7.toString());
            if (C5743d.m23121f()) {
                StringBuilder sb8 = new StringBuilder("**** SDK Start ");
                sb8.append(context.getPackageName());
                sb8.append(" **** Version: 4.10.0/53/31194287 ****");
                C5264a.m21617a("NIM", sb8.toString());
                f18270i.f18277f = new C5815g();
                C5805a.m23311a();
                C5668c.m22861a().mo27867b();
                NimService.m23852a(context, 1);
            }
            if (C5743d.m23122g()) {
                C6174c.m24489a(context).mo29241a();
                if (!C5743d.m23121f()) {
                    f18270i.f18275d = null;
                }
            }
            C5973a.m23882a(context);
        }
    }

    /* renamed from: a */
    public static void m23013a(LoginInfo loginInfo) {
        m23023j().f18273b = loginInfo;
    }

    /* renamed from: a */
    public static void m23014a(StatusBarNotificationConfig statusBarNotificationConfig) {
        if (statusBarNotificationConfig != null) {
            m23017d().statusBarNotificationConfig = statusBarNotificationConfig;
        }
    }

    /* renamed from: b */
    public static String m23015b() {
        C5718b bVar = f18270i;
        if (bVar != null) {
            LoginInfo loginInfo = bVar.f18273b;
            if (loginInfo != null) {
                return loginInfo.getAccount();
            }
        }
        return null;
    }

    /* renamed from: c */
    public static Integer m23016c() {
        return m23023j().f18274c;
    }

    /* renamed from: d */
    public static SDKOptions m23017d() {
        return m23023j().f18275d == null ? SDKOptions.DEFAULT : f18270i.f18275d;
    }

    /* renamed from: e */
    public static LoginInfo m23018e() {
        C5718b bVar = f18270i;
        if (bVar == null) {
            return null;
        }
        return bVar.f18273b;
    }

    /* renamed from: f */
    public static String m23019f() {
        return m23023j().f18278g;
    }

    /* renamed from: g */
    public static String m23020g() {
        return m23023j().f18279h;
    }

    /* renamed from: h */
    public static String m23021h() {
        return C5685d.m22938b();
    }

    /* renamed from: i */
    public static ServerAddresses m23022i() {
        return m23023j().f18276e;
    }

    /* renamed from: j */
    private static C5718b m23023j() {
        C5718b bVar = f18270i;
        if (bVar != null) {
            return bVar;
        }
        throw new IllegalStateException("SDK not initialized, call NimClient.init() first!");
    }
}
