package com.tencent.android.tpush;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import com.tencent.android.tpush.common.C6901c;
import com.tencent.android.tpush.common.C6908h;
import com.tencent.android.tpush.common.Constants;
import com.tencent.android.tpush.p580b.C6864a;
import com.tencent.bigdata.dataacquisition.DeviceInfos;
import java.io.File;

/* compiled from: ProGuard */
public class XGDownloadService extends Service {
    /* access modifiers changed from: private|static|final */
    /* renamed from: c */
    public static final String f22631c = XGDownloadService.class.getSimpleName();
    /* renamed from: a */
    private int f22632a = 0;
    /* access modifiers changed from: private */
    /* renamed from: b */
    public String f22633b = "";
    /* access modifiers changed from: private */
    /* renamed from: d */
    public File f22634d = null;
    /* access modifiers changed from: private */
    /* renamed from: e */
    public File f22635e = null;
    /* access modifiers changed from: private */
    /* renamed from: f */
    public NotificationManager f22636f = null;
    /* access modifiers changed from: private */
    /* renamed from: g */
    public Notification f22637g = null;
    /* renamed from: h */
    private Intent f22638h = null;
    /* access modifiers changed from: private */
    /* renamed from: i */
    public PendingIntent f22639i = null;
    /* access modifiers changed from: private */
    /* renamed from: j */
    public Handler f22640j = new Handler() {
        public void handleMessage(Message message) {
            int i = message.arg1;
            message.getData();
            int i2 = message.what;
            if (i2 == 0) {
                Uri fromFile = Uri.fromFile(XGDownloadService.this.f22635e);
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.setDataAndType(fromFile, "application/vnd.android.package-archive");
                XGDownloadService xGDownloadService = XGDownloadService.this;
                xGDownloadService.f22639i = PendingIntent.getActivity(xGDownloadService, i, intent, 0);
                XGDownloadService.this.f22637g.flags = 16;
                XGDownloadService.this.f22637g.defaults = 1;
                XGDownloadService.this.f22636f.notify(i, XGDownloadService.this.f22637g);
                XGDownloadService.this.stopSelf();
            } else if (i2 != 1) {
                XGDownloadService.this.stopSelf();
            } else {
                XGDownloadService.this.f22637g.flags = 16;
                XGDownloadService.this.f22636f.notify(i, XGDownloadService.this.f22637g);
            }
        }
    };

    /* compiled from: ProGuard */
    /* renamed from: com.tencent.android.tpush.XGDownloadService$a */
    class C6818a implements Runnable {
        /* renamed from: a */
        Message f22642a = XGDownloadService.this.f22640j.obtainMessage();
        /* renamed from: c */
        private Intent f22644c;
        /* renamed from: d */
        private int f22645d;

        public C6818a(Intent intent, int i) {
            this.f22644c = intent;
            this.f22645d = i;
        }

        public void run() {
            Message message = this.f22642a;
            message.what = 0;
            message.arg1 = this.f22645d;
            new Bundle();
            this.f22642a.setData(this.f22644c.getExtras());
            try {
                if (!XGDownloadService.this.f22634d.exists()) {
                    XGDownloadService.this.f22634d.mkdirs();
                }
                if (!XGDownloadService.this.f22635e.exists()) {
                    XGDownloadService.this.f22635e.createNewFile();
                }
                if (XGDownloadService.this.mo32786a(XGDownloadService.this.f22633b, XGDownloadService.this.f22635e, this.f22645d) > 0) {
                    XGDownloadService.this.f22640j.sendMessage(this.f22642a);
                }
            } catch (Exception e) {
                C6864a.m29302d(XGDownloadService.f22631c, "downloadRunnable", e);
                XGDownloadService.this.f22640j.sendMessage(this.f22642a);
            }
        }
    }

    public IBinder onBind(Intent intent) {
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:39:0x0080  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x0085  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x008a  */
    /* renamed from: a */
    public long mo32786a(java.lang.String r12, java.io.File r13, int r14) {
        /*
        r11 = this;
        r0 = 0
        java.net.URL r1 = new java.net.URL     // Catch:{ all -> 0x007b }
        r1.<init>(r12)     // Catch:{ all -> 0x007b }
        java.net.URLConnection r12 = r1.openConnection()     // Catch:{ all -> 0x007b }
        java.net.HttpURLConnection r12 = (java.net.HttpURLConnection) r12     // Catch:{ all -> 0x007b }
        java.lang.String r1 = "User-Agent"
        java.lang.String r2 = "PacificHttpClient"
        r12.setRequestProperty(r1, r2)     // Catch:{ all -> 0x0078 }
        r1 = 10000(0x2710, float:1.4013E-41)
        r12.setConnectTimeout(r1)     // Catch:{ all -> 0x0078 }
        r1 = 20000(0x4e20, float:2.8026E-41)
        r12.setReadTimeout(r1)     // Catch:{ all -> 0x0078 }
        int r1 = r12.getContentLength()     // Catch:{ all -> 0x0078 }
        int r2 = r12.getResponseCode()     // Catch:{ all -> 0x0078 }
        r3 = 404(0x194, float:5.66E-43)
        if (r2 == r3) goto L_0x0070
        java.io.InputStream r2 = r12.getInputStream()     // Catch:{ all -> 0x0078 }
        java.io.FileOutputStream r3 = new java.io.FileOutputStream     // Catch:{ all -> 0x006c }
        r4 = 0
        r3.<init>(r13, r4)     // Catch:{ all -> 0x006c }
        r13 = 4096(0x1000, float:5.74E-42)
        byte[] r13 = new byte[r13]     // Catch:{ all -> 0x006a }
        r5 = 0
        r0 = 0
    L_0x003a:
        int r7 = r2.read(r13)     // Catch:{ all -> 0x006a }
        if (r7 <= 0) goto L_0x005c
        r3.write(r13, r4, r7)     // Catch:{ all -> 0x006a }
        long r7 = (long) r7     // Catch:{ all -> 0x006a }
        long r5 = r5 + r7
        if (r0 == 0) goto L_0x0052
        r7 = 100
        long r7 = r7 * r5
        long r9 = (long) r1     // Catch:{ all -> 0x006a }
        long r7 = r7 / r9
        int r8 = (int) r7     // Catch:{ all -> 0x006a }
        int r8 = r8 + -10
        if (r8 <= r0) goto L_0x003a
    L_0x0052:
        int r0 = r0 + 10
        android.app.NotificationManager r7 = r11.f22636f     // Catch:{ all -> 0x006a }
        android.app.Notification r8 = r11.f22637g     // Catch:{ all -> 0x006a }
        r7.notify(r14, r8)     // Catch:{ all -> 0x006a }
        goto L_0x003a
    L_0x005c:
        if (r12 == 0) goto L_0x0061
        r12.disconnect()
    L_0x0061:
        if (r2 == 0) goto L_0x0066
        r2.close()
    L_0x0066:
        r3.close()
        return r5
    L_0x006a:
        r13 = move-exception
        goto L_0x006e
    L_0x006c:
        r13 = move-exception
        r3 = r0
    L_0x006e:
        r0 = r2
        goto L_0x007e
    L_0x0070:
        java.lang.Exception r13 = new java.lang.Exception     // Catch:{ all -> 0x0078 }
        java.lang.String r14 = "fail!"
        r13.<init>(r14)     // Catch:{ all -> 0x0078 }
        throw r13     // Catch:{ all -> 0x0078 }
    L_0x0078:
        r13 = move-exception
        r3 = r0
        goto L_0x007e
    L_0x007b:
        r13 = move-exception
        r12 = r0
        r3 = r12
    L_0x007e:
        if (r12 == 0) goto L_0x0083
        r12.disconnect()
    L_0x0083:
        if (r0 == 0) goto L_0x0088
        r0.close()
    L_0x0088:
        if (r3 == 0) goto L_0x008d
        r3.close()
    L_0x008d:
        throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.android.tpush.XGDownloadService.mo32786a(java.lang.String, java.io.File, int):long");
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        this.f22633b = intent.getStringExtra(Constants.FLAG_PACKAGE_DOWNLOAD_URL);
        int i3 = 0;
        String str = "NOTIFY_ID";
        try {
            int a = C6908h.m29480a((Context) this, str, 0);
            if (a < 2147483646) {
                i3 = a;
            }
            C6908h.m29485b((Context) this, str, i3 + 1);
        } catch (Throwable th) {
            C6864a.m29302d(f22631c, "", th);
        }
        if (DeviceInfos.isSDCardMounted()) {
            this.f22634d = new File(Environment.getExternalStorageDirectory(), "app/download/");
            String path = this.f22634d.getPath();
            StringBuilder sb = new StringBuilder();
            sb.append("downloadApp");
            sb.append(i3);
            sb.append(".apk");
            this.f22635e = new File(path, sb.toString());
        }
        this.f22636f = (NotificationManager) getSystemService("notification");
        this.f22637g = new Notification();
        this.f22637g.icon = getApplicationInfo().icon;
        Notification notification = this.f22637g;
        notification.tickerText = "开始下载";
        this.f22636f.notify(i3, notification);
        C6901c.m29459a().mo33104a((Runnable) new C6818a(intent, i3));
        return super.onStartCommand(intent, i, i2);
    }
}
