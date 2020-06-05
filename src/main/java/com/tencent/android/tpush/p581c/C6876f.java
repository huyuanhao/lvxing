package com.tencent.android.tpush.p581c;

import android.content.Context;
import android.content.Intent;
import com.tencent.android.tpush.XGIOperateCallback;
import com.tencent.android.tpush.XGPushConfig;
import com.tencent.android.tpush.common.C6901c;
import com.tencent.android.tpush.common.Constants;
import com.tencent.android.tpush.common.MessageKey;
import com.tencent.android.tpush.data.MessageId;
import com.tencent.android.tpush.data.RegisterEntity;
import com.tencent.android.tpush.p580b.C6864a;
import com.tencent.android.tpush.service.C6973b;
import com.tencent.android.tpush.service.cache.CacheManager;
import com.tencent.android.tpush.service.p595e.C7056i;
import com.tencent.bigdata.dataacquisition.DeviceInfos;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/* compiled from: ProGuard */
/* renamed from: com.tencent.android.tpush.c.f */
public class C6876f {
    /* renamed from: a */
    static ArrayList<Long> f22901a;
    /* access modifiers changed from: private|static|final */
    /* renamed from: b */
    public static final String f22902b = C6876f.class.getSimpleName();
    /* renamed from: c */
    private static volatile C6876f f22903c = null;
    /* renamed from: e */
    private static long f22904e = 0;
    /* access modifiers changed from: private */
    /* renamed from: d */
    public Context f22905d = null;

    /* compiled from: ProGuard */
    /* renamed from: com.tencent.android.tpush.c.f$a */
    private class C6880a implements Runnable {
        /* renamed from: b */
        private final String f22912b = C6880a.class.getSimpleName();
        /* renamed from: c */
        private Context f22913c;
        /* renamed from: d */
        private Intent f22914d;
        /* renamed from: e */
        private XGIOperateCallback f22915e;

        public C6880a(Context context, Intent intent, XGIOperateCallback xGIOperateCallback) {
            this.f22913c = context;
            this.f22914d = intent;
            this.f22915e = xGIOperateCallback;
        }

        /* renamed from: a */
        private void m29384a() {
            Intent intent = new Intent(Constants.ACTION_PUSH_MESSAGE);
            intent.setPackage(this.f22913c.getPackageName());
            intent.putExtras(this.f22914d);
            this.f22913c.sendBroadcast(intent);
            String stringExtra = this.f22914d.getStringExtra(MessageKey.MSG_SERVICE_PACKAGE_NAME);
            if (!C7056i.m30194b(stringExtra)) {
                Intent intent2 = new Intent("com.tencent.android.tpush.action.ack.sdk2srv.V4");
                intent2.setPackage(stringExtra);
                intent2.putExtras(this.f22914d);
                this.f22913c.sendBroadcast(intent2);
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:110:0x030f, code lost:
            return;
     */
        /* JADX WARNING: Removed duplicated region for block: B:106:0x02f7 A[Catch:{ JSONException -> 0x02ea, IllegalArgumentException -> 0x02e0, all -> 0x02d6, all -> 0x0310 }] */
        public void run() {
            /*
            r23 = this;
            r1 = r23
            com.tencent.android.tpush.c.f r2 = com.tencent.android.tpush.p581c.C6876f.this
            monitor-enter(r2)
            boolean r3 = com.tencent.android.tpush.XGPushConfig.enableDebug     // Catch:{ all -> 0x0310 }
            if (r3 == 0) goto L_0x0010
            java.lang.String r3 = r1.f22912b     // Catch:{ all -> 0x0310 }
            java.lang.String r4 = "Action -> handlerPushMessage"
            com.tencent.android.tpush.p580b.C6864a.m29298c(r3, r4)     // Catch:{ all -> 0x0310 }
        L_0x0010:
            r3 = 0
            android.content.Intent r4 = r1.f22914d     // Catch:{ JSONException -> 0x02ea, IllegalArgumentException -> 0x02e0, all -> 0x02d6 }
            java.lang.String r5 = "expire_time"
            r6 = 0
            long r4 = r4.getLongExtra(r5, r6)     // Catch:{ JSONException -> 0x02ea, IllegalArgumentException -> 0x02e0, all -> 0x02d6 }
            r8 = -1
            int r10 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r10 > 0) goto L_0x0064
            android.content.Intent r10 = r1.f22914d     // Catch:{ JSONException -> 0x02ea, IllegalArgumentException -> 0x02e0, all -> 0x02d6 }
            java.lang.String r11 = "server_time"
            long r10 = r10.getLongExtra(r11, r8)     // Catch:{ JSONException -> 0x02ea, IllegalArgumentException -> 0x02e0, all -> 0x02d6 }
            int r12 = (r10 > r6 ? 1 : (r10 == r6 ? 0 : -1))
            if (r12 <= 0) goto L_0x0064
            android.content.Intent r4 = r1.f22914d     // Catch:{ JSONException -> 0x02ea, IllegalArgumentException -> 0x02e0, all -> 0x02d6 }
            java.lang.String r5 = "ttl"
            int r4 = r4.getIntExtra(r5, r3)     // Catch:{ JSONException -> 0x02ea, IllegalArgumentException -> 0x02e0, all -> 0x02d6 }
            if (r4 > 0) goto L_0x003a
            r4 = 259200(0x3f480, float:3.63217E-40)
        L_0x003a:
            java.lang.String r5 = java.lang.String.valueOf(r10)     // Catch:{ all -> 0x0057 }
            long r12 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x0057 }
            java.lang.String r12 = java.lang.String.valueOf(r12)     // Catch:{ all -> 0x0057 }
            int r12 = r12.length()     // Catch:{ all -> 0x0057 }
            int r5 = r5.length()     // Catch:{ all -> 0x0057 }
            int r12 = r12 - r5
            r5 = 3
            if (r12 != r5) goto L_0x0060
            r12 = 1000(0x3e8, double:4.94E-321)
            long r10 = r10 * r12
            goto L_0x0060
        L_0x0057:
            r0 = move-exception
            r5 = r0
            java.lang.String r12 = "PushMessageHandler"
            java.lang.String r13 = ""
            com.tencent.android.tpush.p580b.C6864a.m29302d(r12, r13, r5)     // Catch:{ JSONException -> 0x02ea, IllegalArgumentException -> 0x02e0, all -> 0x02d6 }
        L_0x0060:
            int r4 = r4 * 1000
            long r4 = (long) r4     // Catch:{ JSONException -> 0x02ea, IllegalArgumentException -> 0x02e0, all -> 0x02d6 }
            long r4 = r4 + r10
        L_0x0064:
            android.content.Intent r10 = r1.f22914d     // Catch:{ JSONException -> 0x02ea, IllegalArgumentException -> 0x02e0, all -> 0x02d6 }
            java.lang.String r10 = r10.getPackage()     // Catch:{ JSONException -> 0x02ea, IllegalArgumentException -> 0x02e0, all -> 0x02d6 }
            long r11 = java.lang.System.currentTimeMillis()     // Catch:{ JSONException -> 0x02ea, IllegalArgumentException -> 0x02e0, all -> 0x02d6 }
            android.content.Intent r13 = r1.f22914d     // Catch:{ JSONException -> 0x02ea, IllegalArgumentException -> 0x02e0, all -> 0x02d6 }
            java.lang.String r14 = "msgId"
            long r13 = r13.getLongExtra(r14, r8)     // Catch:{ JSONException -> 0x02ea, IllegalArgumentException -> 0x02e0, all -> 0x02d6 }
            android.content.Context r15 = r1.f22913c     // Catch:{ JSONException -> 0x02ea, IllegalArgumentException -> 0x02e0, all -> 0x02d6 }
            android.content.Intent r3 = r1.f22914d     // Catch:{ JSONException -> 0x02ea, IllegalArgumentException -> 0x02e0, all -> 0x02d6 }
            com.tencent.android.tpush.c.g r3 = com.tencent.android.tpush.p581c.C6881g.m29385a(r15, r3)     // Catch:{ JSONException -> 0x02ea, IllegalArgumentException -> 0x02e0, all -> 0x02d6 }
            int r15 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r15 <= 0) goto L_0x00b3
            int r15 = (r11 > r4 ? 1 : (r11 == r4 ? 0 : -1))
            if (r15 <= 0) goto L_0x00b3
            java.lang.String r6 = "PushMessageHandler"
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ JSONException -> 0x02ea, IllegalArgumentException -> 0x02e0, all -> 0x02d6 }
            r7.<init>()     // Catch:{ JSONException -> 0x02ea, IllegalArgumentException -> 0x02e0, all -> 0x02d6 }
            java.lang.String r8 = "msg is expired, currentTimeMillis="
            r7.append(r8)     // Catch:{ JSONException -> 0x02ea, IllegalArgumentException -> 0x02e0, all -> 0x02d6 }
            r7.append(r11)     // Catch:{ JSONException -> 0x02ea, IllegalArgumentException -> 0x02e0, all -> 0x02d6 }
            java.lang.String r8 = ", expire_time="
            r7.append(r8)     // Catch:{ JSONException -> 0x02ea, IllegalArgumentException -> 0x02e0, all -> 0x02d6 }
            r7.append(r4)     // Catch:{ JSONException -> 0x02ea, IllegalArgumentException -> 0x02e0, all -> 0x02d6 }
            java.lang.String r4 = ". msgid = "
            r7.append(r4)     // Catch:{ JSONException -> 0x02ea, IllegalArgumentException -> 0x02e0, all -> 0x02d6 }
            r7.append(r13)     // Catch:{ JSONException -> 0x02ea, IllegalArgumentException -> 0x02e0, all -> 0x02d6 }
            java.lang.String r4 = r7.toString()     // Catch:{ JSONException -> 0x02ea, IllegalArgumentException -> 0x02e0, all -> 0x02d6 }
            com.tencent.android.tpush.p580b.C6864a.m29308i(r6, r4)     // Catch:{ JSONException -> 0x02ea, IllegalArgumentException -> 0x02e0, all -> 0x02d6 }
            android.content.Context r4 = r1.f22913c     // Catch:{ JSONException -> 0x02ea, IllegalArgumentException -> 0x02e0, all -> 0x02d6 }
            com.tencent.android.tpush.XGPushManager.msgAck(r4, r3)     // Catch:{ JSONException -> 0x02ea, IllegalArgumentException -> 0x02e0, all -> 0x02d6 }
            monitor-exit(r2)     // Catch:{ all -> 0x0310 }
            return
        L_0x00b3:
            java.lang.Long r4 = java.lang.Long.valueOf(r13)     // Catch:{ JSONException -> 0x02ea, IllegalArgumentException -> 0x02e0, all -> 0x02d6 }
            boolean r4 = com.tencent.android.tpush.p581c.C6876f.m29379a(r4)     // Catch:{ JSONException -> 0x02ea, IllegalArgumentException -> 0x02e0, all -> 0x02d6 }
            if (r4 != 0) goto L_0x00c4
            android.content.Context r4 = r1.f22913c     // Catch:{ JSONException -> 0x02ea, IllegalArgumentException -> 0x02e0, all -> 0x02d6 }
            com.tencent.android.tpush.XGPushManager.msgAck(r4, r3)     // Catch:{ JSONException -> 0x02ea, IllegalArgumentException -> 0x02e0, all -> 0x02d6 }
            monitor-exit(r2)     // Catch:{ all -> 0x0310 }
            return
        L_0x00c4:
            r4 = 2
            com.tencent.android.tpush.p580b.C6864a.m29283a(r4, r13)     // Catch:{ JSONException -> 0x02ea, IllegalArgumentException -> 0x02e0, all -> 0x02d6 }
            android.content.Intent r4 = r1.f22914d     // Catch:{ JSONException -> 0x02ea, IllegalArgumentException -> 0x02e0, all -> 0x02d6 }
            java.lang.String r5 = "busiMsgId"
            long r19 = r4.getLongExtra(r5, r6)     // Catch:{ JSONException -> 0x02ea, IllegalArgumentException -> 0x02e0, all -> 0x02d6 }
            android.content.Intent r4 = r1.f22914d     // Catch:{ JSONException -> 0x02ea, IllegalArgumentException -> 0x02e0, all -> 0x02d6 }
            java.lang.String r5 = "timestamps"
            long r17 = r4.getLongExtra(r5, r6)     // Catch:{ JSONException -> 0x02ea, IllegalArgumentException -> 0x02e0, all -> 0x02d6 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ JSONException -> 0x02ea, IllegalArgumentException -> 0x02e0, all -> 0x02d6 }
            r4.<init>()     // Catch:{ JSONException -> 0x02ea, IllegalArgumentException -> 0x02e0, all -> 0x02d6 }
            java.lang.String r5 = "@"
            r4.append(r5)     // Catch:{ JSONException -> 0x02ea, IllegalArgumentException -> 0x02e0, all -> 0x02d6 }
            r4.append(r13)     // Catch:{ JSONException -> 0x02ea, IllegalArgumentException -> 0x02e0, all -> 0x02d6 }
            r4.append(r10)     // Catch:{ JSONException -> 0x02ea, IllegalArgumentException -> 0x02e0, all -> 0x02d6 }
            java.lang.String r5 = "@"
            r4.append(r5)     // Catch:{ JSONException -> 0x02ea, IllegalArgumentException -> 0x02e0, all -> 0x02d6 }
            java.lang.String r4 = r4.toString()     // Catch:{ JSONException -> 0x02ea, IllegalArgumentException -> 0x02e0, all -> 0x02d6 }
            android.content.Intent r5 = r1.f22914d     // Catch:{ JSONException -> 0x02ea, IllegalArgumentException -> 0x02e0, all -> 0x02d6 }
            java.lang.String r10 = "accId"
            long r10 = r5.getLongExtra(r10, r8)     // Catch:{ JSONException -> 0x02ea, IllegalArgumentException -> 0x02e0, all -> 0x02d6 }
            android.content.Intent r5 = r1.f22914d     // Catch:{ JSONException -> 0x02ea, IllegalArgumentException -> 0x02e0, all -> 0x02d6 }
            java.lang.String r12 = "channel_id"
            long r8 = r5.getLongExtra(r12, r8)     // Catch:{ JSONException -> 0x02ea, IllegalArgumentException -> 0x02e0, all -> 0x02d6 }
            android.content.Context r5 = r1.f22913c     // Catch:{ JSONException -> 0x02ea, IllegalArgumentException -> 0x02e0, all -> 0x02d6 }
            java.util.List r5 = com.tencent.android.tpush.XGPushConfig.getAccessidList(r5)     // Catch:{ JSONException -> 0x02ea, IllegalArgumentException -> 0x02e0, all -> 0x02d6 }
            int r12 = (r8 > r6 ? 1 : (r8 == r6 ? 0 : -1))
            if (r12 <= 0) goto L_0x0151
            android.content.Context r6 = r1.f22913c     // Catch:{ JSONException -> 0x02ea, IllegalArgumentException -> 0x02e0, all -> 0x02d6 }
            long r6 = com.tencent.android.tpush.XGPushConfig.getChannelId(r6)     // Catch:{ JSONException -> 0x02ea, IllegalArgumentException -> 0x02e0, all -> 0x02d6 }
            int r15 = (r8 > r6 ? 1 : (r8 == r6 ? 0 : -1))
            if (r15 == 0) goto L_0x0151
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ JSONException -> 0x02ea, IllegalArgumentException -> 0x02e0, all -> 0x02d6 }
            r5.<init>()     // Catch:{ JSONException -> 0x02ea, IllegalArgumentException -> 0x02e0, all -> 0x02d6 }
            java.lang.String r6 = "PushMessageRunnable match channel failed, message droped cause channel id:"
            r5.append(r6)     // Catch:{ JSONException -> 0x02ea, IllegalArgumentException -> 0x02e0, all -> 0x02d6 }
            r5.append(r8)     // Catch:{ JSONException -> 0x02ea, IllegalArgumentException -> 0x02e0, all -> 0x02d6 }
            java.lang.String r6 = " === "
            r5.append(r6)     // Catch:{ JSONException -> 0x02ea, IllegalArgumentException -> 0x02e0, all -> 0x02d6 }
            android.content.Context r6 = r1.f22913c     // Catch:{ JSONException -> 0x02ea, IllegalArgumentException -> 0x02e0, all -> 0x02d6 }
            long r6 = com.tencent.android.tpush.XGPushConfig.getChannelId(r6)     // Catch:{ JSONException -> 0x02ea, IllegalArgumentException -> 0x02e0, all -> 0x02d6 }
            r5.append(r6)     // Catch:{ JSONException -> 0x02ea, IllegalArgumentException -> 0x02e0, all -> 0x02d6 }
            java.lang.String r6 = " msgId = "
            r5.append(r6)     // Catch:{ JSONException -> 0x02ea, IllegalArgumentException -> 0x02e0, all -> 0x02d6 }
            r5.append(r4)     // Catch:{ JSONException -> 0x02ea, IllegalArgumentException -> 0x02e0, all -> 0x02d6 }
            java.lang.String r4 = r5.toString()     // Catch:{ JSONException -> 0x02ea, IllegalArgumentException -> 0x02e0, all -> 0x02d6 }
            java.lang.String r5 = r1.f22912b     // Catch:{ JSONException -> 0x02ea, IllegalArgumentException -> 0x02e0, all -> 0x02d6 }
            com.tencent.android.tpush.p580b.C6864a.m29309j(r5, r4)     // Catch:{ JSONException -> 0x02ea, IllegalArgumentException -> 0x02e0, all -> 0x02d6 }
            com.tencent.android.tpush.c.c r4 = com.tencent.android.tpush.p581c.C6871c.m29327a()     // Catch:{ JSONException -> 0x02ea, IllegalArgumentException -> 0x02e0, all -> 0x02d6 }
            android.content.Context r5 = r1.f22913c     // Catch:{ JSONException -> 0x02ea, IllegalArgumentException -> 0x02e0, all -> 0x02d6 }
            r4.mo33015b(r5, r13)     // Catch:{ JSONException -> 0x02ea, IllegalArgumentException -> 0x02e0, all -> 0x02d6 }
            android.content.Context r4 = r1.f22913c     // Catch:{ JSONException -> 0x02ea, IllegalArgumentException -> 0x02e0, all -> 0x02d6 }
            com.tencent.android.tpush.XGPushManager.msgAck(r4, r3)     // Catch:{ JSONException -> 0x02ea, IllegalArgumentException -> 0x02e0, all -> 0x02d6 }
            monitor-exit(r2)     // Catch:{ all -> 0x0310 }
            return
        L_0x0151:
            if (r12 > 0) goto L_0x019b
            if (r5 == 0) goto L_0x019b
            int r6 = r5.size()     // Catch:{ JSONException -> 0x02ea, IllegalArgumentException -> 0x02e0, all -> 0x02d6 }
            if (r6 <= 0) goto L_0x019b
            java.lang.Long r6 = java.lang.Long.valueOf(r10)     // Catch:{ JSONException -> 0x02ea, IllegalArgumentException -> 0x02e0, all -> 0x02d6 }
            boolean r6 = r5.contains(r6)     // Catch:{ JSONException -> 0x02ea, IllegalArgumentException -> 0x02e0, all -> 0x02d6 }
            if (r6 != 0) goto L_0x019b
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ JSONException -> 0x02ea, IllegalArgumentException -> 0x02e0, all -> 0x02d6 }
            r6.<init>()     // Catch:{ JSONException -> 0x02ea, IllegalArgumentException -> 0x02e0, all -> 0x02d6 }
            java.lang.String r7 = "PushMessageRunnable match accessId failed, message droped cause accessId:"
            r6.append(r7)     // Catch:{ JSONException -> 0x02ea, IllegalArgumentException -> 0x02e0, all -> 0x02d6 }
            r6.append(r10)     // Catch:{ JSONException -> 0x02ea, IllegalArgumentException -> 0x02e0, all -> 0x02d6 }
            java.lang.String r7 = " not in "
            r6.append(r7)     // Catch:{ JSONException -> 0x02ea, IllegalArgumentException -> 0x02e0, all -> 0x02d6 }
            r6.append(r5)     // Catch:{ JSONException -> 0x02ea, IllegalArgumentException -> 0x02e0, all -> 0x02d6 }
            java.lang.String r5 = " msgId = "
            r6.append(r5)     // Catch:{ JSONException -> 0x02ea, IllegalArgumentException -> 0x02e0, all -> 0x02d6 }
            r6.append(r4)     // Catch:{ JSONException -> 0x02ea, IllegalArgumentException -> 0x02e0, all -> 0x02d6 }
            java.lang.String r4 = r6.toString()     // Catch:{ JSONException -> 0x02ea, IllegalArgumentException -> 0x02e0, all -> 0x02d6 }
            java.lang.String r5 = r1.f22912b     // Catch:{ JSONException -> 0x02ea, IllegalArgumentException -> 0x02e0, all -> 0x02d6 }
            com.tencent.android.tpush.p580b.C6864a.m29309j(r5, r4)     // Catch:{ JSONException -> 0x02ea, IllegalArgumentException -> 0x02e0, all -> 0x02d6 }
            com.tencent.android.tpush.c.c r4 = com.tencent.android.tpush.p581c.C6871c.m29327a()     // Catch:{ JSONException -> 0x02ea, IllegalArgumentException -> 0x02e0, all -> 0x02d6 }
            android.content.Context r5 = r1.f22913c     // Catch:{ JSONException -> 0x02ea, IllegalArgumentException -> 0x02e0, all -> 0x02d6 }
            r4.mo33015b(r5, r13)     // Catch:{ JSONException -> 0x02ea, IllegalArgumentException -> 0x02e0, all -> 0x02d6 }
            android.content.Context r4 = r1.f22913c     // Catch:{ JSONException -> 0x02ea, IllegalArgumentException -> 0x02e0, all -> 0x02d6 }
            com.tencent.android.tpush.XGPushManager.msgAck(r4, r3)     // Catch:{ JSONException -> 0x02ea, IllegalArgumentException -> 0x02e0, all -> 0x02d6 }
            monitor-exit(r2)     // Catch:{ all -> 0x0310 }
            return
        L_0x019b:
            android.content.Context r5 = r1.f22913c     // Catch:{ JSONException -> 0x02ea, IllegalArgumentException -> 0x02e0, all -> 0x02d6 }
            java.lang.String r5 = com.tencent.android.tpush.p581c.C6871c.m29330g(r5, r10)     // Catch:{ JSONException -> 0x02ea, IllegalArgumentException -> 0x02e0, all -> 0x02d6 }
            boolean r6 = r5.contains(r4)     // Catch:{ JSONException -> 0x02ea, IllegalArgumentException -> 0x02e0, all -> 0x02d6 }
            r7 = 0
            if (r6 != 0) goto L_0x02d3
            android.content.Context r6 = r1.f22913c     // Catch:{ JSONException -> 0x02ea, IllegalArgumentException -> 0x02e0, all -> 0x02d6 }
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ JSONException -> 0x02ea, IllegalArgumentException -> 0x02e0, all -> 0x02d6 }
            r8.<init>()     // Catch:{ JSONException -> 0x02ea, IllegalArgumentException -> 0x02e0, all -> 0x02d6 }
            java.lang.String r9 = "tpush_msgId_"
            r8.append(r9)     // Catch:{ JSONException -> 0x02ea, IllegalArgumentException -> 0x02e0, all -> 0x02d6 }
            r8.append(r10)     // Catch:{ JSONException -> 0x02ea, IllegalArgumentException -> 0x02e0, all -> 0x02d6 }
            java.lang.String r8 = r8.toString()     // Catch:{ JSONException -> 0x02ea, IllegalArgumentException -> 0x02e0, all -> 0x02d6 }
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ JSONException -> 0x02ea, IllegalArgumentException -> 0x02e0, all -> 0x02d6 }
            r9.<init>()     // Catch:{ JSONException -> 0x02ea, IllegalArgumentException -> 0x02e0, all -> 0x02d6 }
            r9.append(r4)     // Catch:{ JSONException -> 0x02ea, IllegalArgumentException -> 0x02e0, all -> 0x02d6 }
            r9.append(r5)     // Catch:{ JSONException -> 0x02ea, IllegalArgumentException -> 0x02e0, all -> 0x02d6 }
            java.lang.String r5 = r9.toString()     // Catch:{ JSONException -> 0x02ea, IllegalArgumentException -> 0x02e0, all -> 0x02d6 }
            r9 = 1
            com.tencent.android.tpush.common.C6907g.m29478a(r6, r8, r5, r9)     // Catch:{ JSONException -> 0x02ea, IllegalArgumentException -> 0x02e0, all -> 0x02d6 }
            android.content.Context r5 = r1.f22913c     // Catch:{ JSONException -> 0x02ea, IllegalArgumentException -> 0x02e0, all -> 0x02d6 }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ JSONException -> 0x02ea, IllegalArgumentException -> 0x02e0, all -> 0x02d6 }
            r6.<init>()     // Catch:{ JSONException -> 0x02ea, IllegalArgumentException -> 0x02e0, all -> 0x02d6 }
            java.lang.String r8 = "tpush_msgId_"
            r6.append(r8)     // Catch:{ JSONException -> 0x02ea, IllegalArgumentException -> 0x02e0, all -> 0x02d6 }
            r6.append(r10)     // Catch:{ JSONException -> 0x02ea, IllegalArgumentException -> 0x02e0, all -> 0x02d6 }
            java.lang.String r6 = r6.toString()     // Catch:{ JSONException -> 0x02ea, IllegalArgumentException -> 0x02e0, all -> 0x02d6 }
            java.lang.String r5 = com.tencent.android.tpush.common.C6907g.m29475a(r5, r6, r9)     // Catch:{ JSONException -> 0x02ea, IllegalArgumentException -> 0x02e0, all -> 0x02d6 }
            if (r5 == 0) goto L_0x02bb
            boolean r5 = r5.contains(r4)     // Catch:{ JSONException -> 0x02ea, IllegalArgumentException -> 0x02e0, all -> 0x02d6 }
            if (r5 != 0) goto L_0x01ef
            goto L_0x02bb
        L_0x01ef:
            boolean r4 = com.tencent.android.tpush.XGPushConfig.enableDebug     // Catch:{ JSONException -> 0x02ea, IllegalArgumentException -> 0x02e0, all -> 0x02d6 }
            if (r4 == 0) goto L_0x020d
            java.lang.String r4 = r1.f22912b     // Catch:{ JSONException -> 0x02ea, IllegalArgumentException -> 0x02e0, all -> 0x02d6 }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ JSONException -> 0x02ea, IllegalArgumentException -> 0x02e0, all -> 0x02d6 }
            r5.<init>()     // Catch:{ JSONException -> 0x02ea, IllegalArgumentException -> 0x02e0, all -> 0x02d6 }
            java.lang.String r6 = "Receiver msg from server :"
            r5.append(r6)     // Catch:{ JSONException -> 0x02ea, IllegalArgumentException -> 0x02e0, all -> 0x02d6 }
            java.lang.String r6 = r3.toString()     // Catch:{ JSONException -> 0x02ea, IllegalArgumentException -> 0x02e0, all -> 0x02d6 }
            r5.append(r6)     // Catch:{ JSONException -> 0x02ea, IllegalArgumentException -> 0x02e0, all -> 0x02d6 }
            java.lang.String r5 = r5.toString()     // Catch:{ JSONException -> 0x02ea, IllegalArgumentException -> 0x02e0, all -> 0x02d6 }
            com.tencent.android.tpush.p580b.C6864a.m29305f(r4, r5)     // Catch:{ JSONException -> 0x02ea, IllegalArgumentException -> 0x02e0, all -> 0x02d6 }
        L_0x020d:
            android.content.Context r4 = r1.f22913c     // Catch:{ JSONException -> 0x02ea, IllegalArgumentException -> 0x02e0, all -> 0x02d6 }
            com.tencent.android.tpush.XGPushManager.msgAck(r4, r3)     // Catch:{ JSONException -> 0x02ea, IllegalArgumentException -> 0x02e0, all -> 0x02d6 }
            android.content.Context r4 = r1.f22913c     // Catch:{ JSONException -> 0x02ea, IllegalArgumentException -> 0x02e0, all -> 0x02d6 }
            android.content.Intent r5 = r1.f22914d     // Catch:{ JSONException -> 0x02ea, IllegalArgumentException -> 0x02e0, all -> 0x02d6 }
            com.tencent.android.tpush.service.p594d.C7046a.m30129b(r4, r5)     // Catch:{ JSONException -> 0x02ea, IllegalArgumentException -> 0x02e0, all -> 0x02d6 }
            android.content.Intent r4 = r1.f22914d     // Catch:{ JSONException -> 0x02ea, IllegalArgumentException -> 0x02e0, all -> 0x02d6 }
            java.lang.String r5 = "svrPkgName"
            java.lang.String r4 = r4.getStringExtra(r5)     // Catch:{ JSONException -> 0x02ea, IllegalArgumentException -> 0x02e0, all -> 0x02d6 }
            android.content.Context r5 = r1.f22913c     // Catch:{ JSONException -> 0x02ea, IllegalArgumentException -> 0x02e0, all -> 0x02d6 }
            java.lang.String r5 = r5.getPackageName()     // Catch:{ JSONException -> 0x02ea, IllegalArgumentException -> 0x02e0, all -> 0x02d6 }
            boolean r5 = r5.equals(r4)     // Catch:{ JSONException -> 0x02ea, IllegalArgumentException -> 0x02e0, all -> 0x02d6 }
            if (r5 != 0) goto L_0x024a
            java.lang.String r5 = r1.f22912b     // Catch:{ JSONException -> 0x02ea, IllegalArgumentException -> 0x02e0, all -> 0x02d6 }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ JSONException -> 0x02ea, IllegalArgumentException -> 0x02e0, all -> 0x02d6 }
            r6.<init>()     // Catch:{ JSONException -> 0x02ea, IllegalArgumentException -> 0x02e0, all -> 0x02d6 }
            java.lang.String r8 = "Receiver msg from other app :"
            r6.append(r8)     // Catch:{ JSONException -> 0x02ea, IllegalArgumentException -> 0x02e0, all -> 0x02d6 }
            r6.append(r4)     // Catch:{ JSONException -> 0x02ea, IllegalArgumentException -> 0x02e0, all -> 0x02d6 }
            java.lang.String r4 = r6.toString()     // Catch:{ JSONException -> 0x02ea, IllegalArgumentException -> 0x02e0, all -> 0x02d6 }
            com.tencent.android.tpush.p580b.C6864a.m29305f(r5, r4)     // Catch:{ JSONException -> 0x02ea, IllegalArgumentException -> 0x02e0, all -> 0x02d6 }
            android.content.Context r4 = r1.f22913c     // Catch:{ JSONException -> 0x02ea, IllegalArgumentException -> 0x02e0, all -> 0x02d6 }
            android.content.Intent r5 = r1.f22914d     // Catch:{ JSONException -> 0x02ea, IllegalArgumentException -> 0x02e0, all -> 0x02d6 }
            com.tencent.android.tpush.service.p594d.C7046a.m30122a(r4, r5)     // Catch:{ JSONException -> 0x02ea, IllegalArgumentException -> 0x02e0, all -> 0x02d6 }
        L_0x024a:
            com.tencent.android.tpush.c.a r4 = r3.mo33057g()     // Catch:{ JSONException -> 0x02ea, IllegalArgumentException -> 0x02e0, all -> 0x02d6 }
            if (r4 == 0) goto L_0x02f3
            java.lang.String r5 = r3.mo33056f()     // Catch:{ JSONException -> 0x02ea, IllegalArgumentException -> 0x02e0, all -> 0x02d6 }
            boolean r5 = com.tencent.android.tpush.service.p595e.C7056i.m30194b(r5)     // Catch:{ JSONException -> 0x02ea, IllegalArgumentException -> 0x02e0, all -> 0x02d6 }
            if (r5 != 0) goto L_0x02f3
            com.tencent.android.tpush.c.d r15 = new com.tencent.android.tpush.c.d     // Catch:{ all -> 0x02a3 }
            android.content.Context r5 = r1.f22913c     // Catch:{ all -> 0x02a3 }
            android.content.Intent r6 = r1.f22914d     // Catch:{ all -> 0x02a3 }
            r15.m51871init(r5, r6)     // Catch:{ all -> 0x02a3 }
            r16 = r3
            r21 = r13
            boolean r5 = r15.mo33028a(r16, r17, r19, r21)     // Catch:{ all -> 0x02a3 }
            if (r5 == 0) goto L_0x0295
            r23.m29384a()     // Catch:{ all -> 0x02a3 }
            android.content.Context r5 = r1.f22913c     // Catch:{ all -> 0x02a3 }
            android.content.Intent r6 = r1.f22914d     // Catch:{ all -> 0x02a3 }
            com.tencent.android.tpush.service.p594d.C7046a.m30132c(r5, r6)     // Catch:{ all -> 0x02a3 }
            com.tencent.android.tpush.c.c r5 = com.tencent.android.tpush.p581c.C6871c.m29327a()     // Catch:{ all -> 0x02a3 }
            android.content.Context r6 = r1.f22913c     // Catch:{ all -> 0x02a3 }
            long r10 = r3.mo33052b()     // Catch:{ all -> 0x02a3 }
            r5.mo33021c(r6, r10)     // Catch:{ all -> 0x02a3 }
            int r4 = r4.mo32998c()     // Catch:{ all -> 0x02a3 }
            if (r4 != r9) goto L_0x02f3
            r3.mo33051a()     // Catch:{ all -> 0x02a3 }
            android.content.Context r4 = r1.f22913c     // Catch:{ all -> 0x02a3 }
            android.content.Intent r5 = r1.f22914d     // Catch:{ all -> 0x02a3 }
            com.tencent.android.tpush.service.p594d.C7046a.m30134d(r4, r5)     // Catch:{ all -> 0x02a3 }
            goto L_0x02f3
        L_0x0295:
            com.tencent.android.tpush.c.c r4 = com.tencent.android.tpush.p581c.C6871c.m29327a()     // Catch:{ all -> 0x02a3 }
            android.content.Context r5 = r1.f22913c     // Catch:{ all -> 0x02a3 }
            long r8 = r3.mo33052b()     // Catch:{ all -> 0x02a3 }
            r4.mo33024d(r5, r8)     // Catch:{ all -> 0x02a3 }
            goto L_0x02f3
        L_0x02a3:
            r0 = move-exception
            r4 = r0
            java.lang.String r5 = r1.f22912b     // Catch:{ JSONException -> 0x02ea, IllegalArgumentException -> 0x02e0, all -> 0x02d6 }
            java.lang.String r6 = "unknown error"
            com.tencent.android.tpush.p580b.C6864a.m29302d(r5, r6, r4)     // Catch:{ JSONException -> 0x02ea, IllegalArgumentException -> 0x02e0, all -> 0x02d6 }
            com.tencent.android.tpush.c.c r5 = com.tencent.android.tpush.p581c.C6871c.m29327a()     // Catch:{ JSONException -> 0x02ea, IllegalArgumentException -> 0x02e0, all -> 0x02d6 }
            android.content.Context r6 = r1.f22913c     // Catch:{ JSONException -> 0x02ea, IllegalArgumentException -> 0x02e0, all -> 0x02d6 }
            long r7 = r3.mo33052b()     // Catch:{ JSONException -> 0x02ea, IllegalArgumentException -> 0x02e0, all -> 0x02d6 }
            r5.mo33024d(r6, r7)     // Catch:{ JSONException -> 0x02ea, IllegalArgumentException -> 0x02e0, all -> 0x02d6 }
            r7 = r4
            goto L_0x02f3
        L_0x02bb:
            java.lang.String r3 = r1.f22912b     // Catch:{ JSONException -> 0x02ea, IllegalArgumentException -> 0x02e0, all -> 0x02d6 }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ JSONException -> 0x02ea, IllegalArgumentException -> 0x02e0, all -> 0x02d6 }
            r5.<init>()     // Catch:{ JSONException -> 0x02ea, IllegalArgumentException -> 0x02e0, all -> 0x02d6 }
            r5.append(r4)     // Catch:{ JSONException -> 0x02ea, IllegalArgumentException -> 0x02e0, all -> 0x02d6 }
            java.lang.String r4 = " flag write failed"
            r5.append(r4)     // Catch:{ JSONException -> 0x02ea, IllegalArgumentException -> 0x02e0, all -> 0x02d6 }
            java.lang.String r4 = r5.toString()     // Catch:{ JSONException -> 0x02ea, IllegalArgumentException -> 0x02e0, all -> 0x02d6 }
            com.tencent.android.tpush.p580b.C6864a.m29308i(r3, r4)     // Catch:{ JSONException -> 0x02ea, IllegalArgumentException -> 0x02e0, all -> 0x02d6 }
            monitor-exit(r2)     // Catch:{ all -> 0x0310 }
            return
        L_0x02d3:
            r1.f22915e = r7     // Catch:{ JSONException -> 0x02ea, IllegalArgumentException -> 0x02e0, all -> 0x02d6 }
            goto L_0x02f3
        L_0x02d6:
            r0 = move-exception
            r7 = r0
            java.lang.String r3 = r1.f22912b     // Catch:{ all -> 0x0310 }
            java.lang.String r4 = "unknown error"
            com.tencent.android.tpush.p580b.C6864a.m29302d(r3, r4, r7)     // Catch:{ all -> 0x0310 }
            goto L_0x02f3
        L_0x02e0:
            r0 = move-exception
            r7 = r0
            java.lang.String r3 = "XGService"
            java.lang.String r4 = "push msg type error"
            com.tencent.android.tpush.p580b.C6864a.m29302d(r3, r4, r7)     // Catch:{ all -> 0x0310 }
            goto L_0x02f3
        L_0x02ea:
            r0 = move-exception
            r7 = r0
            java.lang.String r3 = r1.f22912b     // Catch:{ all -> 0x0310 }
            java.lang.String r4 = "push parse error"
            com.tencent.android.tpush.p580b.C6864a.m29302d(r3, r4, r7)     // Catch:{ all -> 0x0310 }
        L_0x02f3:
            com.tencent.android.tpush.XGIOperateCallback r3 = r1.f22915e     // Catch:{ all -> 0x0310 }
            if (r3 == 0) goto L_0x030e
            if (r7 == 0) goto L_0x0306
            com.tencent.android.tpush.XGIOperateCallback r3 = r1.f22915e     // Catch:{ all -> 0x0310 }
            java.lang.String r4 = ""
            r5 = -1
            java.lang.String r6 = r7.toString()     // Catch:{ all -> 0x0310 }
            r3.onFail(r4, r5, r6)     // Catch:{ all -> 0x0310 }
            goto L_0x030e
        L_0x0306:
            com.tencent.android.tpush.XGIOperateCallback r3 = r1.f22915e     // Catch:{ all -> 0x0310 }
            java.lang.String r4 = ""
            r5 = 0
            r3.onSuccess(r4, r5)     // Catch:{ all -> 0x0310 }
        L_0x030e:
            monitor-exit(r2)     // Catch:{ all -> 0x0310 }
            return
        L_0x0310:
            r0 = move-exception
            r3 = r0
            monitor-exit(r2)     // Catch:{ all -> 0x0310 }
            throw r3
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.android.tpush.p581c.C6876f.C6880a.run():void");
        }
    }

    /* renamed from: a */
    public static C6876f m29376a(Context context) {
        if (f22903c == null) {
            synchronized (C6876f.class) {
                if (f22903c == null) {
                    f22903c = new C6876f();
                    f22903c.f22905d = context.getApplicationContext();
                    C6973b.m29774d(f22903c.f22905d);
                }
            }
        }
        return f22903c;
    }

    /* renamed from: a */
    public void mo33044a(Intent intent) {
        C6901c.m29459a().mo33104a((Runnable) new C6880a(this.f22905d, intent, null));
    }

    /* renamed from: a */
    protected static synchronized boolean m29379a(Long l) {
        synchronized (C6876f.class) {
            try {
                if (f22901a == null) {
                    f22901a = new ArrayList<>();
                }
                if (f22901a.contains(l)) {
                    return false;
                }
                f22901a.add(l);
                if (f22901a.size() > 200) {
                    f22901a.remove(0);
                }
                return true;
            } catch (Throwable th) {
                C6864a.m29302d("PushMessageHandler", "addCachedmsgID", th);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m29380c(final Intent intent) {
        C6901c.m29459a().mo33104a((Runnable) new Runnable() {
            public void run() {
                String stringExtra = intent.getStringExtra(MessageKey.MSG_DATE);
                try {
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
                    if (!C7056i.m30194b(stringExtra)) {
                        if (C7056i.m30194b(stringExtra) || simpleDateFormat.parse(stringExtra).compareTo(simpleDateFormat.parse(simpleDateFormat.format(new Date()))) != 0) {
                            if (!C7056i.m30194b(stringExtra) && simpleDateFormat.parse(stringExtra).compareTo(simpleDateFormat.parse(simpleDateFormat.format(new Date()))) < 0) {
                                C6876f.this.mo33044a(intent);
                                return;
                            }
                            return;
                        }
                    }
                    if (C7056i.m30185a(intent)) {
                        C6876f.this.mo33044a(intent);
                    }
                } catch (ParseException e) {
                    String a = C6876f.f22902b;
                    StringBuilder sb = new StringBuilder();
                    sb.append("try to handlerPushMessage, but ParseException : ");
                    sb.append(e);
                    C6864a.m29309j(a, sb.toString());
                }
            }
        });
    }

    /* renamed from: b */
    public void mo33046b(final Intent intent) {
        C6901c.m29459a().mo33104a((Runnable) new Runnable() {
            public void run() {
                if (XGPushConfig.enableDebug) {
                    C6864a.m29298c(C6876f.f22902b, "Action -> handleRemotePushMessage");
                }
                long longExtra = intent.getLongExtra(MessageKey.MSG_ID, 0);
                long longExtra2 = intent.getLongExtra(MessageKey.MSG_CREATE_TIMESTAMPS, 0);
                long longExtra3 = intent.getLongExtra(MessageKey.MSG_SERVER_TIME, 0);
                int intExtra = intent.getIntExtra(MessageKey.MSG_TTL, 0);
                long longExtra4 = intent.getLongExtra("type", 1);
                if (!XGPushConfig.isNotificationShowEnable(C6876f.this.f22905d)) {
                    String a = C6876f.f22902b;
                    StringBuilder sb = new StringBuilder();
                    sb.append("XINGE NotificationShow is not enabe, so discard this notification, msgid:");
                    sb.append(longExtra);
                    C6864a.m29305f(a, sb.toString());
                    return;
                }
                long longExtra5 = intent.getLongExtra("accId", 0);
                String str = intent.getPackage();
                try {
                    RegisterEntity currentAppRegisterEntity = CacheManager.getCurrentAppRegisterEntity(C6876f.this.f22905d);
                    if (currentAppRegisterEntity != null && !C7056i.m30194b(currentAppRegisterEntity.packageName) && str.equals(currentAppRegisterEntity.packageName) && longExtra5 == currentAppRegisterEntity.accessId && currentAppRegisterEntity.state == 1) {
                        return;
                    }
                } catch (Throwable th) {
                    C6864a.m29308i(C6876f.f22902b, th.toString());
                }
                String stringExtra = intent.getStringExtra(MessageKey.MSG_DATE);
                long j = longExtra3;
                long longExtra6 = intent.getLongExtra(MessageKey.MSG_EXTRA_PUSHTIME, 0);
                int i = intExtra;
                String str2 = stringExtra;
                long j2 = longExtra4;
                long longExtra7 = intent.getLongExtra(MessageKey.MSG_BUSI_MSG_ID, 0);
                long j3 = longExtra2;
                long longExtra8 = intent.getLongExtra(MessageKey.MSG_CREATE_MULTIPKG, 0);
                long longExtra9 = intent.getLongExtra(MessageKey.MSG_CHANNEL_ID, -1);
                String stringExtra2 = intent.getStringExtra(MessageKey.MSG_GROUP_KEYS);
                String stringExtra3 = intent.getStringExtra(MessageKey.MSG_STAT_TAG);
                long j4 = longExtra9;
                long currentTimeMillis = System.currentTimeMillis();
                MessageId messageId = new MessageId();
                messageId.f23015id = longExtra;
                messageId.isAck = 0;
                messageId.accessId = longExtra5;
                long j5 = longExtra5;
                messageId.host = intent.getLongExtra(MessageKey.MSG_EXTRA_HOST, 0);
                messageId.port = intent.getIntExtra(MessageKey.MSG_EXTRA_PORT, 0);
                messageId.pact = intent.getByteExtra(MessageKey.MSG_EXTRA_PACT, 0);
                messageId.apn = DeviceInfos.getNetworkType(C6876f.this.f22905d);
                messageId.isp = C7056i.m30217k(C6876f.this.f22905d);
                messageId.pushTime = longExtra6;
                messageId.serviceHost = intent.getStringExtra(MessageKey.MSG_SERVICE_PACKAGE_NAME);
                messageId.receivedTime = currentTimeMillis;
                messageId.pkgName = str;
                messageId.busiMsgId = longExtra7;
                long j6 = j3;
                messageId.timestamp = j6;
                long j7 = j2;
                messageId.msgType = j7;
                messageId.multiPkg = longExtra8;
                String str3 = str;
                String str4 = str2;
                messageId.date = str4;
                long j8 = currentTimeMillis;
                messageId.channelId = j4;
                if (!C7056i.m30194b(stringExtra2)) {
                    messageId.groupKeys = stringExtra2;
                }
                if (!C7056i.m30194b(stringExtra3)) {
                    messageId.statTag = stringExtra3;
                }
                if (XGPushConfig.enableDebug) {
                    String a2 = C6876f.f22902b;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(">> msg from service,  @msgId=");
                    String str5 = a2;
                    sb2.append(messageId.f23015id);
                    sb2.append(" @accId=");
                    sb2.append(messageId.accessId);
                    sb2.append(" @timeUs=");
                    sb2.append(longExtra6);
                    sb2.append(" @recTime=");
                    sb2.append(messageId.receivedTime);
                    sb2.append(" @msg.date=");
                    sb2.append(str4);
                    sb2.append(" @msg.busiMsgId=");
                    sb2.append(longExtra7);
                    sb2.append(" @msg.timestamp=");
                    sb2.append(j6);
                    sb2.append(" @msg.type=");
                    sb2.append(j7);
                    sb2.append(" @msg.multiPkg=");
                    sb2.append(longExtra8);
                    sb2.append(" @msg.serverTime=");
                    sb2.append(j);
                    sb2.append(" @msg.ttl=");
                    sb2.append(i);
                    sb2.append(" @currentTimeMillis=");
                    sb2.append(j8);
                    C6864a.m29305f(str5, sb2.toString());
                }
                String g = C6871c.m29330g(C6876f.this.f22905d, j5);
                StringBuilder sb3 = new StringBuilder();
                String str6 = "@";
                sb3.append(str6);
                sb3.append(messageId.f23015id);
                String str7 = str3;
                sb3.append(str7);
                sb3.append(str6);
                if (g.contains(sb3.toString())) {
                    C6864a.m29309j(C6876f.f22902b, "getNotifiedMsgIds contain the msgId id, return");
                } else if (C6871c.m29327a().mo33018b(C6876f.this.f22905d, str7, messageId.f23015id)) {
                    String a3 = C6876f.f22902b;
                    StringBuilder sb4 = new StringBuilder();
                    sb4.append(">> msgId:");
                    sb4.append(messageId.f23015id);
                    sb4.append(" has been acked, return");
                    C6864a.m29309j(a3, sb4.toString());
                } else {
                    messageId.pkgName = str7;
                    if (messageId.f23015id > 0) {
                        C6871c.m29327a().mo33011a(C6876f.this.f22905d, str7, messageId);
                    }
                    C6871c.m29327a().mo33009a(C6876f.this.f22905d, intent);
                    C6876f.this.m29380c(intent);
                }
            }
        });
    }

    /* renamed from: a */
    public void mo33045a(boolean z) {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - f22904e > 120000 || z) {
            f22904e = currentTimeMillis;
            C6901c.m29459a().mo33104a((Runnable) new Runnable() {
                public void run() {
                    if (C6876f.this.f22905d != null && !C7056i.m30194b(C6876f.this.f22905d.getPackageName())) {
                        ArrayList a = C6871c.m29327a().mo33006a(C6876f.this.f22905d);
                        if (a != null && a.size() > 0) {
                            if (XGPushConfig.enableDebug) {
                                String a2 = C6876f.f22902b;
                                StringBuilder sb = new StringBuilder();
                                sb.append("Action -> trySendCachedMsg with CachedMsgList size = ");
                                sb.append(a.size());
                                C6864a.m29298c(a2, sb.toString());
                            }
                            for (int i = 0; i < a.size(); i++) {
                                try {
                                    C6876f.this.m29380c((Intent) a.get(i));
                                } catch (Exception e) {
                                    C6864a.m29302d(C6876f.f22902b, "", e);
                                }
                            }
                        }
                    }
                }
            });
        }
    }
}
