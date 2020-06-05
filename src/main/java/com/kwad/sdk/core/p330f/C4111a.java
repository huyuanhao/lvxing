package com.kwad.sdk.core.p330f;

import android.content.Context;
import android.text.TextUtils;
import androidx.core.p003os.EnvironmentCompat;
import com.kwad.sdk.KsAdSDK;
import com.kwad.sdk.core.p319c.C4065b;

/* renamed from: com.kwad.sdk.core.f.a */
public class C4111a {
    /* access modifiers changed from: private|static */
    /* renamed from: a */
    public static String f13770a = "";
    /* renamed from: b */
    private static C4113a f13771b = null;
    /* access modifiers changed from: private|static */
    /* renamed from: c */
    public static boolean f13772c = false;

    /* renamed from: com.kwad.sdk.core.f.a$a */
    public interface C4113a {
        /* renamed from: a */
        void mo23807a(String str);
    }

    /* renamed from: a */
    public static String m17072a() {
        if (TextUtils.isEmpty(f13770a)) {
            m17074a(KsAdSDK.getContext());
        }
        return f13770a;
    }

    /* renamed from: a */
    public static void m17074a(Context context) {
        if (!f13772c) {
            f13772c = true;
            if (TextUtils.isEmpty(f13770a)) {
                if (context == null) {
                    context = KsAdSDK.getContext();
                }
                if (context != null) {
                    final Context applicationContext = context.getApplicationContext();
                    new Thread(new Runnable() {
                        /* JADX WARNING: Code restructure failed: missing block: B:54:0x00cb, code lost:
            r1 = r1.mo23827a();
     */
                        /* JADX WARNING: Code restructure failed: missing block: B:64:0x013b, code lost:
            com.kwad.sdk.core.p330f.C4111a.m17073a(r1);
     */
                        /* JADX WARNING: Code restructure failed: missing block: B:66:0x0147, code lost:
            r1 = new java.lang.StringBuilder();
            r1.append("manufacturer:");
            r1.append(r0);
            r1.append("--OAID:");
            r1.append(com.kwad.sdk.core.p330f.C4111a.m17079d());
            com.kwad.sdk.core.p319c.C4065b.m16867b("OAIDHelper", r1.toString());
            com.kwad.sdk.core.p330f.C4111a.m17080e();
            com.kwad.sdk.core.p330f.C4111a.m17075a(false);
     */
                        /* JADX WARNING: Code restructure failed: missing block: B:67:0x016f, code lost:
            return;
     */
                        public void run() {
                            /*
                            r4 = this;
                            java.lang.String r0 = android.os.Build.MANUFACTURER
                            java.lang.String r0 = r0.toUpperCase()
                            int r1 = r0.hashCode()
                            r2 = 0
                            switch(r1) {
                                case -2053026509: goto L_0x00a8;
                                case -1712043046: goto L_0x009d;
                                case -1706170181: goto L_0x0093;
                                case -1134767290: goto L_0x0089;
                                case -602397472: goto L_0x007f;
                                case 89163: goto L_0x0074;
                                case 2018896: goto L_0x0069;
                                case 2432928: goto L_0x005f;
                                case 2555124: goto L_0x0054;
                                case 2634924: goto L_0x004a;
                                case 73239724: goto L_0x003e;
                                case 74632627: goto L_0x0032;
                                case 630905871: goto L_0x0027;
                                case 976565563: goto L_0x001b;
                                case 2141820391: goto L_0x0010;
                                default: goto L_0x000e;
                            }
                        L_0x000e:
                            goto L_0x00b2
                        L_0x0010:
                            java.lang.String r1 = "HUAWEI"
                            boolean r1 = r0.equals(r1)
                            if (r1 == 0) goto L_0x00b2
                            r1 = 0
                            goto L_0x00b3
                        L_0x001b:
                            java.lang.String r1 = "FERRMEOS"
                            boolean r1 = r0.equals(r1)
                            if (r1 == 0) goto L_0x00b2
                            r1 = 13
                            goto L_0x00b3
                        L_0x0027:
                            java.lang.String r1 = "MOTOLORA"
                            boolean r1 = r0.equals(r1)
                            if (r1 == 0) goto L_0x00b2
                            r1 = 7
                            goto L_0x00b3
                        L_0x0032:
                            java.lang.String r1 = "NUBIA"
                            boolean r1 = r0.equals(r1)
                            if (r1 == 0) goto L_0x00b2
                            r1 = 9
                            goto L_0x00b3
                        L_0x003e:
                            java.lang.String r1 = "MEIZU"
                            boolean r1 = r0.equals(r1)
                            if (r1 == 0) goto L_0x00b2
                            r1 = 8
                            goto L_0x00b3
                        L_0x004a:
                            java.lang.String r1 = "VIVO"
                            boolean r1 = r0.equals(r1)
                            if (r1 == 0) goto L_0x00b2
                            r1 = 5
                            goto L_0x00b3
                        L_0x0054:
                            java.lang.String r1 = "SSUI"
                            boolean r1 = r0.equals(r1)
                            if (r1 == 0) goto L_0x00b2
                            r1 = 14
                            goto L_0x00b3
                        L_0x005f:
                            java.lang.String r1 = "OPPO"
                            boolean r1 = r0.equals(r1)
                            if (r1 == 0) goto L_0x00b2
                            r1 = 3
                            goto L_0x00b3
                        L_0x0069:
                            java.lang.String r1 = "ASUS"
                            boolean r1 = r0.equals(r1)
                            if (r1 == 0) goto L_0x00b2
                            r1 = 11
                            goto L_0x00b3
                        L_0x0074:
                            java.lang.String r1 = "ZTE"
                            boolean r1 = r0.equals(r1)
                            if (r1 == 0) goto L_0x00b2
                            r1 = 12
                            goto L_0x00b3
                        L_0x007f:
                            java.lang.String r1 = "ONEPLUS"
                            boolean r1 = r0.equals(r1)
                            if (r1 == 0) goto L_0x00b2
                            r1 = 4
                            goto L_0x00b3
                        L_0x0089:
                            java.lang.String r1 = "BLACKSHARK"
                            boolean r1 = r0.equals(r1)
                            if (r1 == 0) goto L_0x00b2
                            r1 = 2
                            goto L_0x00b3
                        L_0x0093:
                            java.lang.String r1 = "XIAOMI"
                            boolean r1 = r0.equals(r1)
                            if (r1 == 0) goto L_0x00b2
                            r1 = 1
                            goto L_0x00b3
                        L_0x009d:
                            java.lang.String r1 = "SAMSUNG"
                            boolean r1 = r0.equals(r1)
                            if (r1 == 0) goto L_0x00b2
                            r1 = 10
                            goto L_0x00b3
                        L_0x00a8:
                            java.lang.String r1 = "LENOVO"
                            boolean r1 = r0.equals(r1)
                            if (r1 == 0) goto L_0x00b2
                            r1 = 6
                            goto L_0x00b3
                        L_0x00b2:
                            r1 = -1
                        L_0x00b3:
                            switch(r1) {
                                case 0: goto L_0x0130;
                                case 1: goto L_0x0124;
                                case 2: goto L_0x0124;
                                case 3: goto L_0x0118;
                                case 4: goto L_0x0118;
                                case 5: goto L_0x010c;
                                case 6: goto L_0x0100;
                                case 7: goto L_0x0100;
                                case 8: goto L_0x00f4;
                                case 9: goto L_0x00e8;
                                case 10: goto L_0x00dc;
                                case 11: goto L_0x00d0;
                                case 12: goto L_0x00c4;
                                case 13: goto L_0x00c4;
                                case 14: goto L_0x00c4;
                                default: goto L_0x00b6;
                            }
                        L_0x00b6:
                            boolean r1 = com.kwad.sdk.core.p330f.C4111a.m17081f()
                            if (r1 != 0) goto L_0x013f
                            boolean r1 = com.kwad.sdk.core.p330f.C4111a.m17082g()
                            if (r1 == 0) goto L_0x0147
                            goto L_0x013f
                        L_0x00c4:
                            com.kwad.sdk.core.f.a.j r1 = new com.kwad.sdk.core.f.a.j
                            android.content.Context r3 = r2
                            r1.m47941init(r3)
                        L_0x00cb:
                            java.lang.String r1 = r1.mo23827a()
                            goto L_0x013b
                        L_0x00d0:
                            com.kwad.sdk.core.f.a.a r1 = new com.kwad.sdk.core.f.a.a
                            android.content.Context r3 = r2
                            r1.m47927init(r3)
                            java.lang.String r1 = r1.mo23808a()
                            goto L_0x013b
                        L_0x00dc:
                            com.kwad.sdk.core.f.a.g r1 = new com.kwad.sdk.core.f.a.g
                            android.content.Context r3 = r2
                            r1.m47937init(r3)
                            java.lang.String r1 = r1.mo23822a()
                            goto L_0x013b
                        L_0x00e8:
                            com.kwad.sdk.core.f.a.e r1 = new com.kwad.sdk.core.f.a.e
                            android.content.Context r3 = r2
                            r1.m47934init(r3)
                            java.lang.String r1 = r1.mo23818a()
                            goto L_0x013b
                        L_0x00f4:
                            com.kwad.sdk.core.f.a.d r1 = new com.kwad.sdk.core.f.a.d
                            android.content.Context r3 = r2
                            r1.m47933init(r3)
                            java.lang.String r1 = r1.mo23817a()
                            goto L_0x013b
                        L_0x0100:
                            com.kwad.sdk.core.f.a.c r1 = new com.kwad.sdk.core.f.a.c
                            android.content.Context r3 = r2
                            r1.m47931init(r3)
                            java.lang.String r1 = r1.mo23814a()
                            goto L_0x013b
                        L_0x010c:
                            com.kwad.sdk.core.f.a.h r1 = new com.kwad.sdk.core.f.a.h
                            android.content.Context r3 = r2
                            r1.m47939init(r3)
                            java.lang.String r1 = r1.mo23825a()
                            goto L_0x013b
                        L_0x0118:
                            com.kwad.sdk.core.f.a.f r1 = new com.kwad.sdk.core.f.a.f
                            android.content.Context r3 = r2
                            r1.m47935init(r3)
                            java.lang.String r1 = r1.mo23819a()
                            goto L_0x013b
                        L_0x0124:
                            com.kwad.sdk.core.f.a.i r1 = new com.kwad.sdk.core.f.a.i
                            android.content.Context r3 = r2
                            r1.m47940init(r3)
                            java.lang.String r1 = r1.mo23826a()
                            goto L_0x013b
                        L_0x0130:
                            com.kwad.sdk.core.f.a.b r1 = new com.kwad.sdk.core.f.a.b
                            android.content.Context r3 = r2
                            r1.m47929init(r3)
                            java.lang.String r1 = r1.mo23811a()
                        L_0x013b:
                            com.kwad.sdk.core.p330f.C4111a.f13770a = r1
                            goto L_0x0147
                        L_0x013f:
                            com.kwad.sdk.core.f.a.j r1 = new com.kwad.sdk.core.f.a.j
                            android.content.Context r3 = r2
                            r1.m47941init(r3)
                            goto L_0x00cb
                        L_0x0147:
                            java.lang.StringBuilder r1 = new java.lang.StringBuilder
                            r1.<init>()
                            java.lang.String r3 = "manufacturer:"
                            r1.append(r3)
                            r1.append(r0)
                            java.lang.String r0 = "--OAID:"
                            r1.append(r0)
                            java.lang.String r0 = com.kwad.sdk.core.p330f.C4111a.f13770a
                            r1.append(r0)
                            java.lang.String r0 = r1.toString()
                            java.lang.String r1 = "OAIDHelper"
                            com.kwad.sdk.core.p319c.C4065b.m16867b(r1, r0)
                            com.kwad.sdk.core.p330f.C4111a.m17083h()
                            com.kwad.sdk.core.p330f.C4111a.f13772c = r2
                            return
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.kwad.sdk.core.p330f.C4111a.C41121.run():void");
                        }
                    }).start();
                }
            }
        }
    }

    /* renamed from: b */
    private static String m17076b(String str) {
        String str2;
        if (str == null) {
            return null;
        }
        try {
            Class cls = Class.forName("android.os.SystemProperties");
            str2 = (String) cls.getMethod("get", new Class[]{String.class, String.class}).invoke(cls, new Object[]{str, EnvironmentCompat.MEDIA_UNKNOWN});
        } catch (Exception e) {
            C4065b.m16865a(e);
            str2 = null;
        }
        return str2;
    }

    /* access modifiers changed from: private|static */
    /* renamed from: f */
    public static boolean m17081f() {
        String b = m17076b("ro.build.freeme.label");
        return !TextUtils.isEmpty(b) && b.equalsIgnoreCase("FREEMEOS");
    }

    /* access modifiers changed from: private|static */
    /* renamed from: g */
    public static boolean m17082g() {
        String b = m17076b("ro.ssui.product");
        return !TextUtils.isEmpty(b) && !b.equalsIgnoreCase(EnvironmentCompat.MEDIA_UNKNOWN);
    }

    /* access modifiers changed from: private|static */
    /* renamed from: h */
    public static void m17083h() {
        C4113a aVar = f13771b;
        if (aVar != null) {
            aVar.mo23807a(f13770a);
        }
    }
}
