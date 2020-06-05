package com.qiyukf.nimlib.p472g;

import android.app.KeyguardManager;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.qiyukf.basesdk.p393a.C5264a;
import com.qiyukf.basesdk.p412c.p417d.C5412d;
import com.qiyukf.nim.uikit.C5426a;
import com.qiyukf.nimlib.C5718b;
import com.qiyukf.nimlib.C5743d;
import com.qiyukf.nimlib.p485i.C5912a;
import com.qiyukf.nimlib.sdk.msg.constant.SessionTypeEnum;
import com.qiyukf.nimlib.sdk.msg.model.IMMessage;
import com.qiyukf.nimlib.sdk.uinfo.UserInfoProvider;
import com.qiyukf.nimlib.sdk.uinfo.UserInfoProvider.UserInfo;
import com.qiyukf.unicorn.C5961R;
import com.qiyukf.unicorn.C6029d;
import com.qiyukf.unicorn.api.ImageLoaderListener;
import com.qiyukf.unicorn.api.StatusBarNotificationConfig;
import com.qiyukf.unicorn.p499b.C6014b;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/* renamed from: com.qiyukf.nimlib.g.b */
public final class C5843b {
    /* renamed from: k */
    private static C5843b f18528k;
    /* renamed from: a */
    protected Context f18529a = C5718b.m23009a();
    /* renamed from: b */
    private SimpleDateFormat f18530b = new SimpleDateFormat("HH:mm", Locale.getDefault());
    /* renamed from: c */
    private NotificationManager f18531c = ((NotificationManager) this.f18529a.getSystemService("notification"));
    /* renamed from: d */
    private Map<String, C5912a> f18532d = new HashMap();
    /* renamed from: e */
    private String f18533e;
    /* renamed from: f */
    private String f18534f;
    /* renamed from: g */
    private String f18535g;
    /* renamed from: h */
    private String f18536h;
    /* renamed from: i */
    private int f18537i;
    /* renamed from: j */
    private long f18538j = 0;

    private C5843b() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f18529a.getPackageName());
        sb.append(".unicorn");
        this.f18536h = sb.toString();
        C58441 r0 = new BroadcastReceiver() {
            public final void onReceive(Context context, Intent intent) {
                if (intent.getAction().equals("android.intent.action.USER_PRESENT")) {
                    C5843b.m23415a(C5843b.this);
                } else if (intent.getAction().equals("android.intent.action.SCREEN_ON")) {
                    if (!((KeyguardManager) context.getSystemService("keyguard")).inKeyguardRestrictedInputMode()) {
                        C5843b.m23415a(C5843b.this);
                    }
                } else {
                    if (intent.getAction().equals("android.intent.action.SCREEN_OFF")) {
                        C5743d.m23117c(false);
                    }
                }
            }
        };
        C5743d.m23117c(true);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.SCREEN_OFF");
        intentFilter.addAction("android.intent.action.SCREEN_ON");
        intentFilter.addAction("android.intent.action.USER_PRESENT");
        C5718b.m23009a().registerReceiver(r0, intentFilter);
        if (VERSION.SDK_INT >= 26) {
            this.f18531c.createNotificationChannel(new NotificationChannel(this.f18536h, this.f18529a.getString(C5961R.string.ysf_app_name), 3));
        }
    }

    /* renamed from: a */
    private int m23412a(StatusBarNotificationConfig statusBarNotificationConfig) {
        return statusBarNotificationConfig.notificationSmallIconId == 0 ? this.f18529a.getApplicationInfo().icon : statusBarNotificationConfig.notificationSmallIconId;
    }

    /* renamed from: a */
    private Bitmap m23413a(IMMessage iMMessage) {
        if (C5718b.m23017d().userInfoProvider != null && this.f18532d.size() <= 1) {
            String str = C6029d.m24045e().statusBarNotificationConfig != null ? C6029d.m24045e().statusBarNotificationConfig.bigIconUri : null;
            if (TextUtils.isEmpty(str)) {
                UserInfoProvider userInfoProvider = C5718b.m23017d().userInfoProvider;
                if (iMMessage.getSessionType() == SessionTypeEnum.P2P || iMMessage.getSessionType() == SessionTypeEnum.Ysf) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(iMMessage.getFromAccount());
                    sb.append(iMMessage.getUuid());
                    UserInfo userInfo = userInfoProvider.getUserInfo(sb.toString());
                    if (userInfo != null) {
                        str = userInfo.getAvatar();
                    }
                }
            }
            if (!TextUtils.isEmpty(str)) {
                try {
                    int a = C5412d.m22146a(72.0f);
                    Bitmap a2 = C5426a.m22173a(str);
                    if (a2 == null) {
                        a2 = C5426a.m22174a(str, a, a);
                    }
                    if (a2 != null && (a2.getWidth() < (a << 1) / 3 || a2.getWidth() > (a * 3) / 2)) {
                        a2 = Bitmap.createScaledBitmap(a2, a, a, false);
                    }
                    if (a2 == null) {
                        C5426a.m22177a(str, a, a, (ImageLoaderListener) null);
                    }
                    return a2;
                } catch (Throwable th) {
                    th.printStackTrace();
                    C5264a.m21617a("MN", "user custom image loader exception");
                }
            }
        }
        return null;
    }

    /* renamed from: a */
    public static void m23414a() {
        if (m23419c()) {
            m23417b().m23420d();
        }
    }

    /* renamed from: a */
    static /* synthetic */ void m23415a(C5843b bVar) {
        C5743d.m23117c(true);
        String d = C5743d.m23119d();
        if (!TextUtils.isEmpty(d) && bVar.f18532d.containsKey(d)) {
            m23414a();
        }
    }

    /* renamed from: a */
    public static void m23416a(C5912a aVar, String str, int i) {
        if (m23419c()) {
            m23417b().m23418b(aVar, str, i);
        }
    }

    /* renamed from: b */
    private static C5843b m23417b() {
        if (f18528k == null) {
            f18528k = new C5843b();
        }
        return f18528k;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0085, code lost:
            if (r5.compareTo(r4) > 0) goto L_0x0089;
     */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0098  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x009c  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x00c0  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x00e8  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x010e  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x011b  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x011c  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x0160  */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x01a2  */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x01dc  */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x01f1  */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x0235  */
    /* renamed from: b */
    private synchronized void m23418b(com.qiyukf.nimlib.p485i.C5912a r12, java.lang.String r13, int r14) {
        /*
        r11 = this;
        monitor-enter(r11)
        boolean r0 = com.qiyukf.nimlib.C5743d.m23118c()     // Catch:{ all -> 0x02f5 }
        r1 = 1
        r0 = r0 ^ r1
        if (r0 == 0) goto L_0x000c
        java.lang.String r0 = ""
        goto L_0x0010
    L_0x000c:
        java.lang.String r0 = com.qiyukf.nimlib.C5743d.m23119d()     // Catch:{ all -> 0x02f5 }
    L_0x0010:
        java.lang.String r2 = r12.getSessionId()     // Catch:{ all -> 0x02f5 }
        com.qiyukf.nimlib.sdk.msg.constant.SessionTypeEnum r3 = r12.getSessionType()     // Catch:{ all -> 0x02f5 }
        int r3 = r3.getValue()     // Catch:{ all -> 0x02f5 }
        java.lang.String r2 = com.qiyukf.nimlib.p485i.C5923g.m23765a(r2, r3)     // Catch:{ all -> 0x02f5 }
        boolean r2 = r0.equals(r2)     // Catch:{ all -> 0x02f5 }
        r3 = 0
        if (r2 != 0) goto L_0x0031
        java.lang.String r2 = "all"
        boolean r0 = r0.equals(r2)     // Catch:{ all -> 0x02f5 }
        if (r0 != 0) goto L_0x0031
        r0 = 1
        goto L_0x0032
    L_0x0031:
        r0 = 0
    L_0x0032:
        if (r0 == 0) goto L_0x02f3
        com.qiyukf.unicorn.api.YSFOptions r0 = com.qiyukf.unicorn.C6029d.m24045e()     // Catch:{ all -> 0x02f5 }
        com.qiyukf.unicorn.api.StatusBarNotificationConfig r0 = r0.statusBarNotificationConfig     // Catch:{ all -> 0x02f5 }
        com.qiyukf.unicorn.api.YSFOptions r2 = com.qiyukf.unicorn.C6029d.m24045e()     // Catch:{ all -> 0x02f5 }
        com.qiyukf.unicorn.api.StatusBarNotificationConfig r2 = r2.statusBarNotificationConfig     // Catch:{ all -> 0x02f5 }
        boolean r2 = r2.downTimeToggle     // Catch:{ all -> 0x02f5 }
        if (r2 == 0) goto L_0x0089
        com.qiyukf.unicorn.api.YSFOptions r2 = com.qiyukf.unicorn.C6029d.m24045e()     // Catch:{ all -> 0x02f5 }
        com.qiyukf.unicorn.api.StatusBarNotificationConfig r2 = r2.statusBarNotificationConfig     // Catch:{ all -> 0x02f5 }
        java.lang.String r2 = r2.downTimeBegin     // Catch:{ all -> 0x02f5 }
        com.qiyukf.unicorn.api.YSFOptions r4 = com.qiyukf.unicorn.C6029d.m24045e()     // Catch:{ all -> 0x02f5 }
        com.qiyukf.unicorn.api.StatusBarNotificationConfig r4 = r4.statusBarNotificationConfig     // Catch:{ all -> 0x02f5 }
        java.lang.String r4 = r4.downTimeEnd     // Catch:{ all -> 0x02f5 }
        if (r2 == 0) goto L_0x0089
        if (r4 != 0) goto L_0x0059
        goto L_0x0089
    L_0x0059:
        java.text.SimpleDateFormat r5 = r11.f18530b     // Catch:{ all -> 0x02f5 }
        java.util.Date r6 = new java.util.Date     // Catch:{ all -> 0x02f5 }
        long r7 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x02f5 }
        r6.<init>(r7)     // Catch:{ all -> 0x02f5 }
        java.lang.String r5 = r5.format(r6)     // Catch:{ all -> 0x02f5 }
        int r6 = r2.compareTo(r4)     // Catch:{ all -> 0x02f5 }
        if (r6 > 0) goto L_0x007b
        int r2 = r5.compareTo(r2)     // Catch:{ all -> 0x02f5 }
        if (r2 < 0) goto L_0x0089
        int r2 = r5.compareTo(r4)     // Catch:{ all -> 0x02f5 }
        if (r2 > 0) goto L_0x0089
        goto L_0x0087
    L_0x007b:
        int r2 = r5.compareTo(r2)     // Catch:{ all -> 0x02f5 }
        if (r2 >= 0) goto L_0x0087
        int r2 = r5.compareTo(r4)     // Catch:{ all -> 0x02f5 }
        if (r2 > 0) goto L_0x0089
    L_0x0087:
        r2 = 1
        goto L_0x008a
    L_0x0089:
        r2 = 0
    L_0x008a:
        long r4 = android.os.SystemClock.elapsedRealtime()     // Catch:{ all -> 0x02f5 }
        long r6 = r11.f18538j     // Catch:{ all -> 0x02f5 }
        long r6 = r4 - r6
        r8 = 1500(0x5dc, double:7.41E-321)
        int r10 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
        if (r10 < 0) goto L_0x009c
        r11.f18538j = r4     // Catch:{ all -> 0x02f5 }
        r4 = 0
        goto L_0x009d
    L_0x009c:
        r4 = 1
    L_0x009d:
        boolean r5 = r0.ring     // Catch:{ all -> 0x02f5 }
        if (r5 == 0) goto L_0x00a7
        if (r4 != 0) goto L_0x00a7
        if (r2 != 0) goto L_0x00a7
        r5 = 1
        goto L_0x00a8
    L_0x00a7:
        r5 = 0
    L_0x00a8:
        boolean r6 = r0.vibrate     // Catch:{ all -> 0x02f5 }
        if (r6 == 0) goto L_0x00b2
        if (r4 != 0) goto L_0x00b2
        if (r2 != 0) goto L_0x00b2
        r2 = 1
        goto L_0x00b3
    L_0x00b2:
        r2 = 0
    L_0x00b3:
        int r4 = r11.f18537i     // Catch:{ all -> 0x02f5 }
        int r4 = r4 + r14
        r11.f18537i = r4     // Catch:{ all -> 0x02f5 }
        com.qiyukf.nimlib.sdk.SDKOptions r14 = com.qiyukf.nimlib.C5718b.m23017d()     // Catch:{ all -> 0x02f5 }
        com.qiyukf.nimlib.sdk.uinfo.UserInfoProvider r14 = r14.userInfoProvider     // Catch:{ all -> 0x02f5 }
        if (r14 == 0) goto L_0x00e2
        java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x02f5 }
        r4.<init>()     // Catch:{ all -> 0x02f5 }
        java.lang.String r6 = r12.getFromAccount()     // Catch:{ all -> 0x02f5 }
        r4.append(r6)     // Catch:{ all -> 0x02f5 }
        java.lang.String r6 = r12.getUuid()     // Catch:{ all -> 0x02f5 }
        r4.append(r6)     // Catch:{ all -> 0x02f5 }
        java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x02f5 }
        com.qiyukf.nimlib.sdk.uinfo.UserInfoProvider$UserInfo r14 = r14.getUserInfo(r4)     // Catch:{ all -> 0x02f5 }
        if (r14 == 0) goto L_0x00e2
        java.lang.String r13 = r14.getName()     // Catch:{ all -> 0x02f5 }
        goto L_0x00ec
    L_0x00e2:
        boolean r14 = android.text.TextUtils.isEmpty(r13)     // Catch:{ all -> 0x02f5 }
        if (r14 == 0) goto L_0x00ec
        java.lang.String r13 = r12.getFromAccount()     // Catch:{ all -> 0x02f5 }
    L_0x00ec:
        boolean r14 = r0.hideContent     // Catch:{ all -> 0x02f5 }
        java.lang.String r0 = r12.getSessionId()     // Catch:{ all -> 0x02f5 }
        com.qiyukf.nimlib.sdk.msg.constant.SessionTypeEnum r4 = r12.getSessionType()     // Catch:{ all -> 0x02f5 }
        int r4 = r4.getValue()     // Catch:{ all -> 0x02f5 }
        java.lang.String r0 = com.qiyukf.nimlib.p485i.C5923g.m23765a(r0, r4)     // Catch:{ all -> 0x02f5 }
        java.lang.String r4 = ""
        r11.f18533e = r4     // Catch:{ all -> 0x02f5 }
        java.lang.String r4 = ""
        r11.f18534f = r4     // Catch:{ all -> 0x02f5 }
        java.util.Map<java.lang.String, com.qiyukf.nimlib.i.a> r4 = r11.f18532d     // Catch:{ all -> 0x02f5 }
        boolean r4 = r4.containsKey(r0)     // Catch:{ all -> 0x02f5 }
        if (r4 != 0) goto L_0x0113
        java.util.Map<java.lang.String, com.qiyukf.nimlib.i.a> r4 = r11.f18532d     // Catch:{ all -> 0x02f5 }
        r4.put(r0, r12)     // Catch:{ all -> 0x02f5 }
    L_0x0113:
        com.qiyukf.nimlib.sdk.msg.constant.SessionTypeEnum r0 = r12.getSessionType()     // Catch:{ all -> 0x02f5 }
        com.qiyukf.nimlib.sdk.msg.constant.SessionTypeEnum r4 = com.qiyukf.nimlib.sdk.msg.constant.SessionTypeEnum.P2P     // Catch:{ all -> 0x02f5 }
        if (r0 != r4) goto L_0x011c
        goto L_0x0158
    L_0x011c:
        com.qiyukf.nimlib.sdk.msg.constant.SessionTypeEnum r13 = r12.getSessionType()     // Catch:{ all -> 0x02f5 }
        com.qiyukf.nimlib.sdk.msg.constant.SessionTypeEnum r0 = com.qiyukf.nimlib.sdk.msg.constant.SessionTypeEnum.Ysf     // Catch:{ all -> 0x02f5 }
        if (r13 != r0) goto L_0x0154
        com.qiyukf.unicorn.api.YSFOptions r13 = com.qiyukf.unicorn.C6029d.m24045e()     // Catch:{ all -> 0x02f5 }
        com.qiyukf.unicorn.api.pop.OnShopEventListener r13 = r13.onShopEventListener     // Catch:{ all -> 0x02f5 }
        if (r13 == 0) goto L_0x013d
        android.content.Context r0 = r11.f18529a     // Catch:{ all -> 0x02f5 }
        java.lang.String r4 = r12.getSessionId()     // Catch:{ all -> 0x02f5 }
        java.lang.String r13 = r13.getNotificationTitle(r0, r4)     // Catch:{ all -> 0x02f5 }
        boolean r0 = android.text.TextUtils.isEmpty(r13)     // Catch:{ all -> 0x02f5 }
        if (r0 != 0) goto L_0x013d
        goto L_0x0158
    L_0x013d:
        com.qiyukf.unicorn.api.YSFOptions r13 = com.qiyukf.unicorn.C6029d.m24045e()     // Catch:{ all -> 0x02f5 }
        com.qiyukf.unicorn.api.StatusBarNotificationConfig r13 = r13.statusBarNotificationConfig     // Catch:{ all -> 0x02f5 }
        java.lang.String r13 = r13.contentTitle     // Catch:{ all -> 0x02f5 }
        boolean r13 = android.text.TextUtils.isEmpty(r13)     // Catch:{ all -> 0x02f5 }
        if (r13 != 0) goto L_0x0154
        com.qiyukf.unicorn.api.YSFOptions r13 = com.qiyukf.unicorn.C6029d.m24045e()     // Catch:{ all -> 0x02f5 }
        com.qiyukf.unicorn.api.StatusBarNotificationConfig r13 = r13.statusBarNotificationConfig     // Catch:{ all -> 0x02f5 }
        java.lang.String r13 = r13.contentTitle     // Catch:{ all -> 0x02f5 }
        goto L_0x0158
    L_0x0154:
        java.lang.String r13 = r11.m23421e()     // Catch:{ all -> 0x02f5 }
    L_0x0158:
        java.util.Map<java.lang.String, com.qiyukf.nimlib.i.a> r0 = r11.f18532d     // Catch:{ all -> 0x02f5 }
        int r0 = r0.size()     // Catch:{ all -> 0x02f5 }
        if (r0 != r1) goto L_0x01a2
        r11.f18533e = r13     // Catch:{ all -> 0x02f5 }
        int r0 = r11.f18537i     // Catch:{ all -> 0x02f5 }
        r4 = 99
        if (r0 <= r4) goto L_0x0169
        goto L_0x016b
    L_0x0169:
        int r4 = r11.f18537i     // Catch:{ all -> 0x02f5 }
    L_0x016b:
        r11.f18537i = r4     // Catch:{ all -> 0x02f5 }
        int r0 = r11.f18537i     // Catch:{ all -> 0x02f5 }
        if (r0 <= r1) goto L_0x0190
        java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x02f5 }
        r0.<init>()     // Catch:{ all -> 0x02f5 }
        java.lang.String r4 = r11.f18533e     // Catch:{ all -> 0x02f5 }
        r0.append(r4)     // Catch:{ all -> 0x02f5 }
        java.lang.String r4 = "("
        r0.append(r4)     // Catch:{ all -> 0x02f5 }
        int r4 = r11.f18537i     // Catch:{ all -> 0x02f5 }
        r0.append(r4)     // Catch:{ all -> 0x02f5 }
        java.lang.String r4 = ")"
        r0.append(r4)     // Catch:{ all -> 0x02f5 }
        java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x02f5 }
        r11.f18533e = r0     // Catch:{ all -> 0x02f5 }
    L_0x0190:
        if (r14 == 0) goto L_0x019d
        android.content.Context r14 = r11.f18529a     // Catch:{ all -> 0x02f5 }
        int r0 = com.qiyukf.unicorn.C5961R.string.ysf_msg_notify_hide     // Catch:{ all -> 0x02f5 }
        java.lang.String r14 = r14.getString(r0)     // Catch:{ all -> 0x02f5 }
    L_0x019a:
        r11.f18534f = r14     // Catch:{ all -> 0x02f5 }
        goto L_0x01bf
    L_0x019d:
        java.lang.String r14 = com.qiyukf.nimlib.p485i.C5923g.m23764a(r12)     // Catch:{ all -> 0x02f5 }
        goto L_0x019a
    L_0x01a2:
        java.lang.String r14 = r11.m23421e()     // Catch:{ all -> 0x02f5 }
        r11.f18533e = r14     // Catch:{ all -> 0x02f5 }
        android.content.Context r14 = r11.f18529a     // Catch:{ all -> 0x02f5 }
        int r0 = com.qiyukf.unicorn.C5961R.string.ysf_msg_notify_multi_person     // Catch:{ all -> 0x02f5 }
        java.lang.Object[] r4 = new java.lang.Object[r1]     // Catch:{ all -> 0x02f5 }
        java.util.Map<java.lang.String, com.qiyukf.nimlib.i.a> r6 = r11.f18532d     // Catch:{ all -> 0x02f5 }
        int r6 = r6.size()     // Catch:{ all -> 0x02f5 }
        java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch:{ all -> 0x02f5 }
        r4[r3] = r6     // Catch:{ all -> 0x02f5 }
        java.lang.String r14 = r14.getString(r0, r4)     // Catch:{ all -> 0x02f5 }
        goto L_0x019a
    L_0x01bf:
        android.content.Context r14 = r11.f18529a     // Catch:{ all -> 0x02f5 }
        int r0 = com.qiyukf.unicorn.C5961R.string.ysf_msg_notify_ticker_text     // Catch:{ all -> 0x02f5 }
        java.lang.Object[] r4 = new java.lang.Object[r1]     // Catch:{ all -> 0x02f5 }
        r4[r3] = r13     // Catch:{ all -> 0x02f5 }
        java.lang.String r13 = r14.getString(r0, r4)     // Catch:{ all -> 0x02f5 }
        r11.f18535g = r13     // Catch:{ all -> 0x02f5 }
        android.content.Intent r13 = new android.content.Intent     // Catch:{ all -> 0x02f5 }
        r13.<init>()     // Catch:{ all -> 0x02f5 }
        com.qiyukf.unicorn.api.YSFOptions r14 = com.qiyukf.unicorn.C6029d.m24045e()     // Catch:{ all -> 0x02f5 }
        com.qiyukf.unicorn.api.StatusBarNotificationConfig r14 = r14.statusBarNotificationConfig     // Catch:{ all -> 0x02f5 }
        java.lang.Class<? extends android.app.Activity> r14 = r14.notificationEntrance     // Catch:{ all -> 0x02f5 }
        if (r14 != 0) goto L_0x01f1
        android.content.Context r14 = r11.f18529a     // Catch:{ all -> 0x02f5 }
        android.content.pm.PackageManager r14 = r14.getPackageManager()     // Catch:{ all -> 0x02f5 }
        android.content.Context r0 = r11.f18529a     // Catch:{ all -> 0x02f5 }
        java.lang.String r0 = r0.getPackageName()     // Catch:{ all -> 0x02f5 }
        android.content.Intent r14 = r14.getLaunchIntentForPackage(r0)     // Catch:{ all -> 0x02f5 }
        android.content.ComponentName r14 = r14.getComponent()     // Catch:{ all -> 0x02f5 }
        goto L_0x01f9
    L_0x01f1:
        android.content.ComponentName r0 = new android.content.ComponentName     // Catch:{ all -> 0x02f5 }
        android.content.Context r4 = r11.f18529a     // Catch:{ all -> 0x02f5 }
        r0.<init>(r4, r14)     // Catch:{ all -> 0x02f5 }
        r14 = r0
    L_0x01f9:
        r13.setComponent(r14)     // Catch:{ all -> 0x02f5 }
        java.lang.String r14 = "com.netease.nim.EXTRA.NOTIFY_CONTENT.UNICORN"
        java.util.Map<java.lang.String, com.qiyukf.nimlib.i.a> r0 = r11.f18532d     // Catch:{ all -> 0x02f5 }
        java.util.Collection r0 = r0.values()     // Catch:{ all -> 0x02f5 }
        java.util.Iterator r0 = r0.iterator()     // Catch:{ all -> 0x02f5 }
        java.lang.Object r0 = r0.next()     // Catch:{ all -> 0x02f5 }
        java.io.Serializable r0 = (java.io.Serializable) r0     // Catch:{ all -> 0x02f5 }
        r13.putExtra(r14, r0)     // Catch:{ all -> 0x02f5 }
        java.lang.String r14 = "com.qiyukf.EXTRA.MSG_CONTENT"
        java.lang.String r0 = r11.f18534f     // Catch:{ all -> 0x02f5 }
        r13.putExtra(r14, r0)     // Catch:{ all -> 0x02f5 }
        r14 = 603979776(0x24000000, float:2.7755576E-17)
        r13.addFlags(r14)     // Catch:{ all -> 0x02f5 }
        java.lang.String r14 = "android.intent.action.VIEW"
        r13.setAction(r14)     // Catch:{ all -> 0x02f5 }
        r14 = 268435456(0x10000000, float:2.5243549E-29)
        r13.addFlags(r14)     // Catch:{ all -> 0x02f5 }
        android.content.Context r0 = r11.f18529a     // Catch:{ all -> 0x02f5 }
        com.qiyukf.nimlib.g.c r4 = com.qiyukf.nimlib.p472g.C5845c.MESSAGE     // Catch:{ all -> 0x02f5 }
        int r4 = r4.ordinal()     // Catch:{ all -> 0x02f5 }
        android.app.PendingIntent r13 = android.app.PendingIntent.getActivity(r0, r4, r13, r14)     // Catch:{ all -> 0x02f5 }
        if (r13 == 0) goto L_0x02f3
        long r6 = r12.getTime()     // Catch:{ all -> 0x02f5 }
        com.qiyukf.unicorn.api.YSFOptions r14 = com.qiyukf.unicorn.C6029d.m24045e()     // Catch:{ all -> 0x02f5 }
        com.qiyukf.unicorn.api.StatusBarNotificationConfig r14 = r14.statusBarNotificationConfig     // Catch:{ all -> 0x02f5 }
        r0 = 4
        r4 = 0
        if (r2 == 0) goto L_0x0244
        r0 = 6
    L_0x0244:
        if (r5 == 0) goto L_0x0253
        java.lang.String r2 = r14.notificationSound     // Catch:{ all -> 0x02f5 }
        if (r2 == 0) goto L_0x0251
        java.lang.String r2 = r14.notificationSound     // Catch:{ all -> 0x02f5 }
        android.net.Uri r4 = android.net.Uri.parse(r2)     // Catch:{ all -> 0x02f5 }
        goto L_0x0253
    L_0x0251:
        r0 = r0 | 1
    L_0x0253:
        int r2 = android.os.Build.VERSION.SDK_INT     // Catch:{ all -> 0x02f5 }
        r5 = 26
        if (r2 < r5) goto L_0x02a2
        android.app.Notification$Builder r2 = new android.app.Notification$Builder     // Catch:{ all -> 0x02f5 }
        android.content.Context r5 = r11.f18529a     // Catch:{ all -> 0x02f5 }
        java.lang.String r8 = r11.f18536h     // Catch:{ all -> 0x02f5 }
        r2.<init>(r5, r8)     // Catch:{ all -> 0x02f5 }
        java.lang.String r5 = r11.f18533e     // Catch:{ all -> 0x02f5 }
        android.app.Notification$Builder r5 = r2.setContentTitle(r5)     // Catch:{ all -> 0x02f5 }
        java.lang.String r8 = r11.f18534f     // Catch:{ all -> 0x02f5 }
        android.app.Notification$Builder r5 = r5.setContentText(r8)     // Catch:{ all -> 0x02f5 }
        android.app.Notification$Builder r1 = r5.setAutoCancel(r1)     // Catch:{ all -> 0x02f5 }
        android.app.Notification$Builder r13 = r1.setContentIntent(r13)     // Catch:{ all -> 0x02f5 }
        java.lang.String r1 = r11.f18535g     // Catch:{ all -> 0x02f5 }
        android.app.Notification$Builder r13 = r13.setTicker(r1)     // Catch:{ all -> 0x02f5 }
        int r1 = r11.m23412a(r14)     // Catch:{ all -> 0x02f5 }
        android.app.Notification$Builder r13 = r13.setSmallIcon(r1)     // Catch:{ all -> 0x02f5 }
        android.app.Notification$Builder r13 = r13.setWhen(r6)     // Catch:{ all -> 0x02f5 }
        android.graphics.Bitmap r12 = r11.m23413a(r12)     // Catch:{ all -> 0x02f5 }
        android.app.Notification$Builder r12 = r13.setLargeIcon(r12)     // Catch:{ all -> 0x02f5 }
        int r13 = r14.color     // Catch:{ all -> 0x02f5 }
        r12.setColor(r13)     // Catch:{ all -> 0x02f5 }
        r2.setDefaults(r0)     // Catch:{ all -> 0x02f5 }
        if (r4 == 0) goto L_0x029d
        r2.setSound(r4)     // Catch:{ all -> 0x02f5 }
    L_0x029d:
        android.app.Notification r12 = r2.build()     // Catch:{ all -> 0x02f5 }
        goto L_0x02e8
    L_0x02a2:
        androidx.core.app.NotificationCompat$Builder r2 = new androidx.core.app.NotificationCompat$Builder     // Catch:{ all -> 0x02f5 }
        android.content.Context r5 = r11.f18529a     // Catch:{ all -> 0x02f5 }
        r2.m38721init(r5)     // Catch:{ all -> 0x02f5 }
        java.lang.String r5 = r11.f18533e     // Catch:{ all -> 0x02f5 }
        androidx.core.app.NotificationCompat$Builder r5 = r2.setContentTitle(r5)     // Catch:{ all -> 0x02f5 }
        java.lang.String r8 = r11.f18534f     // Catch:{ all -> 0x02f5 }
        androidx.core.app.NotificationCompat$Builder r5 = r5.setContentText(r8)     // Catch:{ all -> 0x02f5 }
        androidx.core.app.NotificationCompat$Builder r1 = r5.setAutoCancel(r1)     // Catch:{ all -> 0x02f5 }
        androidx.core.app.NotificationCompat$Builder r13 = r1.setContentIntent(r13)     // Catch:{ all -> 0x02f5 }
        java.lang.String r1 = r11.f18535g     // Catch:{ all -> 0x02f5 }
        androidx.core.app.NotificationCompat$Builder r13 = r13.setTicker(r1)     // Catch:{ all -> 0x02f5 }
        int r1 = r11.m23412a(r14)     // Catch:{ all -> 0x02f5 }
        androidx.core.app.NotificationCompat$Builder r13 = r13.setSmallIcon(r1)     // Catch:{ all -> 0x02f5 }
        androidx.core.app.NotificationCompat$Builder r13 = r13.setWhen(r6)     // Catch:{ all -> 0x02f5 }
        android.graphics.Bitmap r12 = r11.m23413a(r12)     // Catch:{ all -> 0x02f5 }
        androidx.core.app.NotificationCompat$Builder r12 = r13.setLargeIcon(r12)     // Catch:{ all -> 0x02f5 }
        int r13 = r14.color     // Catch:{ all -> 0x02f5 }
        r12.setColor(r13)     // Catch:{ all -> 0x02f5 }
        r2.setDefaults(r0)     // Catch:{ all -> 0x02f5 }
        if (r4 == 0) goto L_0x02e4
        r2.setSound(r4)     // Catch:{ all -> 0x02f5 }
    L_0x02e4:
        android.app.Notification r12 = r2.build()     // Catch:{ all -> 0x02f5 }
    L_0x02e8:
        android.app.NotificationManager r13 = r11.f18531c     // Catch:{ all -> 0x02f5 }
        com.qiyukf.nimlib.g.c r14 = com.qiyukf.nimlib.p472g.C5845c.MESSAGE     // Catch:{ all -> 0x02f5 }
        java.lang.String r14 = r14.mo28158a()     // Catch:{ all -> 0x02f5 }
        r13.notify(r14, r3, r12)     // Catch:{ all -> 0x02f5 }
    L_0x02f3:
        monitor-exit(r11)
        return
    L_0x02f5:
        r12 = move-exception
        monitor-exit(r11)
        throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qiyukf.nimlib.p472g.C5843b.m23418b(com.qiyukf.nimlib.i.a, java.lang.String, int):void");
    }

    /* renamed from: c */
    private static boolean m23419c() {
        return C6029d.m24045e().statusBarNotificationConfig != null && C6014b.m23969l();
    }

    /* renamed from: d */
    private synchronized void m23420d() {
        this.f18531c.cancel(C5845c.MESSAGE.mo28158a(), 0);
        this.f18537i = 0;
        this.f18532d.clear();
    }

    /* renamed from: e */
    private String m23421e() {
        String str;
        if (this.f18529a.getApplicationInfo().labelRes == 0) {
            PackageManager packageManager = this.f18529a.getPackageManager();
            try {
                ApplicationInfo applicationInfo = packageManager.getApplicationInfo(this.f18529a.getPackageName(), 0);
                str = (String) (applicationInfo != null ? packageManager.getApplicationLabel(applicationInfo) : "");
            } catch (Exception unused) {
                str = null;
            }
        } else {
            Context context = this.f18529a;
            str = context.getString(context.getApplicationInfo().labelRes);
        }
        return TextUtils.isEmpty(str) ? this.f18529a.getString(C5961R.string.ysf_msg_notify_default_title) : str;
    }
}
