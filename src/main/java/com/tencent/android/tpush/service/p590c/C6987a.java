package com.tencent.android.tpush.service.p590c;

import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.kwad.sdk.core.imageloader.core.download.BaseImageDownloader;
import com.p522qq.taf.jce.JceStruct;
import com.qiyukf.nimlib.sdk.msg.MsgService;
import com.tencent.android.tpush.XGPushConfig;
import com.tencent.android.tpush.common.C6901c;
import com.tencent.android.tpush.common.C6905e;
import com.tencent.android.tpush.common.C6907g;
import com.tencent.android.tpush.common.C6908h;
import com.tencent.android.tpush.common.C6914l;
import com.tencent.android.tpush.common.Constants;
import com.tencent.android.tpush.common.MessageKey;
import com.tencent.android.tpush.data.MessageId;
import com.tencent.android.tpush.data.PushClickEntity;
import com.tencent.android.tpush.encrypt.Rijndael;
import com.tencent.android.tpush.p580b.C6864a;
import com.tencent.android.tpush.p581c.C6871c;
import com.tencent.android.tpush.rpc.C6949a;
import com.tencent.android.tpush.rpc.C6949a.C6950a;
import com.tencent.android.tpush.rpc.C6955c;
import com.tencent.android.tpush.service.C6973b;
import com.tencent.android.tpush.service.C6982c;
import com.tencent.android.tpush.service.C7045d;
import com.tencent.android.tpush.service.XGPushServiceV4;
import com.tencent.android.tpush.service.cache.CacheManager;
import com.tencent.android.tpush.service.channel.C7000a;
import com.tencent.android.tpush.service.channel.C7005b;
import com.tencent.android.tpush.service.channel.C7030c.C7031a;
import com.tencent.android.tpush.service.channel.exception.ChannelException;
import com.tencent.android.tpush.service.channel.protocol.TpnsClickClientReport;
import com.tencent.android.tpush.service.channel.protocol.TpnsPushClientReport;
import com.tencent.android.tpush.service.channel.protocol.TpnsPushMsg;
import com.tencent.android.tpush.service.channel.protocol.TpnsPushVerifyReq;
import com.tencent.android.tpush.service.p594d.C7046a;
import com.tencent.android.tpush.service.p595e.C7053f;
import com.tencent.android.tpush.service.p595e.C7056i;
import com.tencent.bigdata.dataacquisition.DeviceInfos;
import com.tencent.mid.sotrage.StorageInterface;
import com.tencent.p605ep.commonbase.software.AppEntity;
import java.io.PrintStream;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: ProGuard */
/* renamed from: com.tencent.android.tpush.service.c.a */
public class C6987a {
    /* renamed from: a */
    public static long f23203a = 306000;
    /* renamed from: b */
    private static C6987a f23204b = new C6987a();
    /* renamed from: c */
    private static final byte[] f23205c = new byte[0];
    /* renamed from: d */
    private static long f23206d = 0;
    /* access modifiers changed from: private|static|volatile */
    /* renamed from: e */
    public static volatile boolean f23207e = false;
    /* access modifiers changed from: private|static|volatile */
    /* renamed from: f */
    public static volatile boolean f23208f = false;
    /* access modifiers changed from: private|static|volatile */
    /* renamed from: g */
    public static volatile boolean f23209g = false;
    /* access modifiers changed from: private|static|volatile */
    /* renamed from: h */
    public static volatile boolean f23210h = false;
    /* renamed from: i */
    private static ConcurrentHashMap<Long, Map<String, List<Long>>> f23211i = null;
    /* renamed from: j */
    private PendingIntent f23212j = null;

    /* compiled from: ProGuard */
    /* renamed from: com.tencent.android.tpush.service.c.a$a */
    private class C6997a implements Runnable {
        /* renamed from: a */
        int f23238a;
        /* renamed from: b */
        Context f23239b;

        public C6997a(Context context, int i) {
            this.f23239b = context;
            this.f23238a = i;
        }

        public void run() {
            int i = this.f23238a;
            if (i == 1) {
                C6987a.this.m29870c(this.f23239b, (MessageId) null);
            } else if (i == 2) {
                C6987a.this.m29850a(this.f23239b, Long.valueOf(-1));
            } else if (i != 4) {
                C6864a.m29308i("SrvMessageManager", "unknown report type");
            } else {
                C6987a.this.m29865b(this.f23239b, (MessageId) null);
            }
        }
    }

    private C6987a() {
    }

    /* renamed from: a */
    public static C6987a m29846a() {
        m29869c();
        return f23204b;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m29850a(final Context context, Long l) {
        long currentTimeMillis = System.currentTimeMillis();
        ArrayList b = mo33337b(context);
        String str = "SrvMessageManager";
        if (f23207e) {
            StringBuilder sb = new StringBuilder();
            sb.append(">> msg ack is uploading , this time will give up! MessageId = ");
            sb.append(l);
            C6864a.m29298c(str, sb.toString());
            return;
        }
        final ArrayList c = mo33345c(context, (List<MessageId>) b);
        if (c == null || c.size() <= 0) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Null report list with msgId ");
            sb2.append(l);
            C6864a.m29298c(str, sb2.toString());
        } else {
            f23207e = true;
            f23206d = currentTimeMillis;
        }
        C6864a.m29284a(5, (List<TpnsPushClientReport>) c);
        C6982c.m29815a().mo33319a(c, (C7031a) new C7031a() {
            /* renamed from: a */
            public void mo33269a(JceStruct jceStruct, int i, JceStruct jceStruct2, C7000a aVar) {
                C6987a.f23207e = false;
                String str = "SrvMessageManager";
                if (i == 0) {
                    C6864a.m29284a(6, (List<TpnsPushClientReport>) c);
                    ArrayList<TpnsPushClientReport> arrayList = ((TpnsPushVerifyReq) jceStruct).msgReportList;
                    C6864a.m29284a(7, (List<TpnsPushClientReport>) arrayList);
                    C7046a.m30131b(c);
                    if (arrayList == null || arrayList.size() == 0) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("requestAck ack failed with null tReq.msgReportList rsp = ");
                        sb.append(aVar.mo33364c());
                        C6864a.m29308i(str, sb.toString());
                    }
                    C6987a.this.mo33351d(C6973b.m29776f(), (List<TpnsPushClientReport>) arrayList);
                    C6901c.m29459a().mo33103a(2);
                    C6901c.m29459a().mo33105a(new C6997a(context, 2), 2, 3000);
                    return;
                }
                StringBuilder sb2 = new StringBuilder();
                sb2.append(">> msg ack onMessageSendFailed  responseCode=");
                sb2.append(i);
                C6864a.m29308i(str, sb2.toString());
            }

            /* renamed from: a */
            public void mo33271a(JceStruct jceStruct, ChannelException channelException, C7000a aVar) {
                StringBuilder sb = new StringBuilder();
                sb.append("@@ TpnsMessage.IEventListener.onMessageSendFailed ");
                sb.append(channelException.errorCode);
                sb.append(StorageInterface.KEY_SPLITER);
                sb.append(channelException.getMessage());
                C6864a.m29308i(Constants.ServiceLogTag, sb.toString());
                C6987a.f23207e = false;
                C6864a.m29284a(8, (List<TpnsPushClientReport>) c);
            }

            /* renamed from: a */
            public void mo33270a(JceStruct jceStruct, C7000a aVar) {
                C6987a.f23207e = false;
                C6864a.m29308i(Constants.ServiceLogTag, "@@ TpnsMessage.IEventListener.onMessageDiscarded ");
            }
        });
    }

    /* renamed from: a */
    private static String m29848a(Context context, long j) {
        StringBuilder sb = new StringBuilder();
        sb.append("tpush_channelId_");
        sb.append(j);
        String a = C6907g.m29475a(context, sb.toString(), true);
        if (a != null && a.length() > 5500) {
            a = a.substring(0, 5120);
        }
        return a != null ? a : "";
    }

    /* renamed from: a */
    private static boolean m29859a(Context context, long j, Long l) {
        String a = m29848a(context, j);
        StringBuilder sb = new StringBuilder();
        sb.append(l);
        sb.append("$");
        return a.contains(sb.toString());
    }

    /* renamed from: b */
    private static void m29864b(Context context, long j, Long l) {
        if (j > 0 && l.longValue() > 0) {
            String a = m29848a(context, j);
            StringBuilder sb = new StringBuilder();
            sb.append("tpush_channelId_");
            sb.append(j);
            String sb2 = sb.toString();
            StringBuilder sb3 = new StringBuilder();
            sb3.append(l);
            sb3.append("$");
            sb3.append(a);
            C6907g.m29478a(context, sb2, sb3.toString(), true);
        }
    }

    /* renamed from: a */
    public synchronized void mo33327a(Context context, Intent intent) {
        if (!(context == null || intent == null)) {
            try {
                long longExtra = intent.getLongExtra(MessageKey.MSG_ID, -1);
                String stringExtra = intent.getStringExtra(Constants.FLAG_PACK_NAME);
                MessageId messageId = (MessageId) intent.getSerializableExtra("MessageId");
                C6864a.m29283a(4, longExtra);
                if (messageId != null) {
                    String str = Constants.ServiceLogTag;
                    StringBuilder sb = new StringBuilder();
                    sb.append("verify ");
                    sb.append(stringExtra);
                    sb.append(longExtra);
                    C6864a.m29286a(str, sb.toString());
                    C6871c.m29327a().mo33022c(context, stringExtra, longExtra);
                    mo33347c(context, stringExtra, messageId);
                    mo33329a(context, stringExtra, longExtra, 1);
                    m29850a(context, Long.valueOf(longExtra));
                }
            } catch (Throwable unused) {
            }
        }
    }

    /* renamed from: b */
    public synchronized void mo33339b(Context context, Intent intent) {
        if (!(context == null || intent == null)) {
            try {
                long currentTimeMillis = System.currentTimeMillis();
                MessageId messageId = new MessageId();
                messageId.f23015id = intent.getLongExtra(MessageKey.MSG_ID, -1);
                if (messageId.f23015id < 0) {
                    C6864a.m29286a(Constants.ServiceLogTag, "@@ msgSendSDKAck: Not add LocalMsg");
                    return;
                }
                messageId.accessId = intent.getLongExtra("accId", -1);
                messageId.host = intent.getLongExtra(MessageKey.MSG_EXTRA_HOST, -1);
                messageId.port = intent.getIntExtra(MessageKey.MSG_EXTRA_PORT, -1);
                messageId.pact = intent.getByteExtra(MessageKey.MSG_EXTRA_PACT, -1);
                messageId.apn = DeviceInfos.getNetworkType(C6973b.m29776f());
                messageId.isp = C7056i.m30217k(C6973b.m29776f());
                messageId.pushTime = intent.getLongExtra(MessageKey.MSG_EXTRA_PUSHTIME, -1);
                messageId.serviceHost = C6973b.m29776f().getPackageName();
                messageId.receivedTime = currentTimeMillis;
                messageId.pkgName = intent.getPackage();
                messageId.busiMsgId = intent.getLongExtra(MessageKey.MSG_BUSI_MSG_ID, -1);
                messageId.timestamp = intent.getLongExtra(MessageKey.MSG_CREATE_TIMESTAMPS, -1);
                messageId.msgType = intent.getLongExtra("type", -1);
                messageId.multiPkg = intent.getLongExtra(MessageKey.MSG_CREATE_MULTIPKG, -1);
                messageId.date = intent.getStringExtra(MessageKey.MSG_DATE);
                messageId.channelId = intent.getLongExtra(MessageKey.MSG_CHANNEL_ID, -1);
                String stringExtra = intent.getStringExtra(MessageKey.MSG_GROUP_KEYS);
                if (!C7056i.m30194b(stringExtra)) {
                    messageId.groupKeys = stringExtra;
                }
                String stringExtra2 = intent.getStringExtra(MessageKey.MSG_STAT_TAG);
                if (!C7056i.m30194b(stringExtra2)) {
                    messageId.statTag = stringExtra2;
                }
                mo33340b(context, MsgService.MSG_CHATTING_ACCOUNT_ALL, messageId);
                m29865b(context, messageId);
            } catch (Throwable unused) {
            }
        }
    }

    /* access modifiers changed from: private|declared_synchronized */
    /* renamed from: b */
    public synchronized void m29865b(final Context context, final MessageId messageId) {
        Long l;
        ArrayList c = m29868c(context, MsgService.MSG_CHATTING_ACCOUNT_ALL);
        if (f23209g) {
            String str = "SrvMessageManager";
            StringBuilder sb = new StringBuilder();
            sb.append("requestSendSDKAck ack is uploading , this time will give up!  msgId =  ");
            if (messageId == null) {
                l = null;
            } else {
                l = Long.valueOf(messageId.f23015id);
            }
            sb.append(l);
            C6864a.m29298c(str, sb.toString());
            return;
        }
        ArrayList b = mo33338b(context, (List<MessageId>) c);
        if (b != null) {
            if (b.size() != 0) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("requestSendSDKAck with list size = ");
                sb2.append(b.size());
                C6864a.m29298c("SrvMessageManager", sb2.toString());
                f23209g = true;
                C6982c.m29815a().mo33319a(b, (C7031a) new C7031a() {
                    /* JADX WARNING: Code restructure failed: missing block: B:22:?, code lost:
            com.tencent.android.tpush.p580b.C6864a.m29308i(r2, r8);
     */
                    /* JADX WARNING: Code restructure failed: missing block: B:24:0x00ad, code lost:
            r6 = move-exception;
     */
                    /* JADX WARNING: Code restructure failed: missing block: B:25:0x00ae, code lost:
            com.tencent.android.tpush.service.p590c.C6987a.m29867b(false);
     */
                    /* JADX WARNING: Code restructure failed: missing block: B:26:0x00b1, code lost:
            throw r6;
     */
                    /* JADX WARNING: Failed to process nested try/catch */
                    /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x00a6 */
                    /* renamed from: a */
                    public void mo33269a(com.p522qq.taf.jce.JceStruct r6, int r7, com.p522qq.taf.jce.JceStruct r8, com.tencent.android.tpush.service.channel.C7000a r9) {
                        /*
                        r5 = this;
                        java.lang.String r8 = "requestServiceAck -> Invalid ack callback"
                        r0 = 0
                        r1 = 0
                        java.lang.String r2 = "SrvMessageManager"
                        if (r7 != 0) goto L_0x00b2
                        boolean r7 = r6 instanceof com.tencent.android.tpush.service.channel.protocol.TpnsPushVerifyReq     // Catch:{ all -> 0x00a6 }
                        if (r7 == 0) goto L_0x0088
                        com.tencent.android.tpush.service.channel.protocol.TpnsPushVerifyReq r6 = (com.tencent.android.tpush.service.channel.protocol.TpnsPushVerifyReq) r6     // Catch:{ all -> 0x00a6 }
                        java.util.ArrayList<com.tencent.android.tpush.service.channel.protocol.TpnsPushClientReport> r7 = r6.msgReportList     // Catch:{ all -> 0x00a6 }
                        if (r7 == 0) goto L_0x001a
                        java.util.ArrayList<com.tencent.android.tpush.service.channel.protocol.TpnsPushClientReport> r7 = r6.msgReportList     // Catch:{ all -> 0x00a6 }
                        int r7 = r7.size()     // Catch:{ all -> 0x00a6 }
                        if (r7 != 0) goto L_0x0047
                    L_0x001a:
                        java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x00a6 }
                        r7.<init>()     // Catch:{ all -> 0x00a6 }
                        java.lang.String r3 = "requestSendSDKAck ack failed with null tReq.msgReportList rsp = "
                        r7.append(r3)     // Catch:{ all -> 0x00a6 }
                        long r3 = r9.mo33364c()     // Catch:{ all -> 0x00a6 }
                        r7.append(r3)     // Catch:{ all -> 0x00a6 }
                        java.lang.String r9 = " msgId "
                        r7.append(r9)     // Catch:{ all -> 0x00a6 }
                        com.tencent.android.tpush.data.MessageId r9 = r6     // Catch:{ all -> 0x00a6 }
                        if (r9 != 0) goto L_0x0035
                        goto L_0x003d
                    L_0x0035:
                        com.tencent.android.tpush.data.MessageId r9 = r6     // Catch:{ all -> 0x00a6 }
                        long r3 = r9.f23015id     // Catch:{ all -> 0x00a6 }
                        java.lang.Long r0 = java.lang.Long.valueOf(r3)     // Catch:{ all -> 0x00a6 }
                    L_0x003d:
                        r7.append(r0)     // Catch:{ all -> 0x00a6 }
                        java.lang.String r7 = r7.toString()     // Catch:{ all -> 0x00a6 }
                        com.tencent.android.tpush.p580b.C6864a.m29308i(r2, r7)     // Catch:{ all -> 0x00a6 }
                    L_0x0047:
                        java.util.ArrayList<com.tencent.android.tpush.service.channel.protocol.TpnsPushClientReport> r7 = r6.msgReportList     // Catch:{ all -> 0x00a6 }
                        java.util.Iterator r7 = r7.iterator()     // Catch:{ all -> 0x00a6 }
                    L_0x004d:
                        boolean r9 = r7.hasNext()     // Catch:{ all -> 0x00a6 }
                        if (r9 == 0) goto L_0x007e
                        java.lang.Object r9 = r7.next()     // Catch:{ all -> 0x00a6 }
                        com.tencent.android.tpush.service.channel.protocol.TpnsPushClientReport r9 = (com.tencent.android.tpush.service.channel.protocol.TpnsPushClientReport) r9     // Catch:{ all -> 0x00a6 }
                        java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x00a6 }
                        r0.<init>()     // Catch:{ all -> 0x00a6 }
                        java.lang.String r3 = "requestSendSDKAck ack succeed with size = "
                        r0.append(r3)     // Catch:{ all -> 0x00a6 }
                        java.util.ArrayList<com.tencent.android.tpush.service.channel.protocol.TpnsPushClientReport> r3 = r6.msgReportList     // Catch:{ all -> 0x00a6 }
                        int r3 = r3.size()     // Catch:{ all -> 0x00a6 }
                        r0.append(r3)     // Catch:{ all -> 0x00a6 }
                        java.lang.String r3 = " msgid = "
                        r0.append(r3)     // Catch:{ all -> 0x00a6 }
                        long r3 = r9.msgId     // Catch:{ all -> 0x00a6 }
                        r0.append(r3)     // Catch:{ all -> 0x00a6 }
                        java.lang.String r9 = r0.toString()     // Catch:{ all -> 0x00a6 }
                        com.tencent.android.tpush.p580b.C6864a.m29298c(r2, r9)     // Catch:{ all -> 0x00a6 }
                        goto L_0x004d
                    L_0x007e:
                        com.tencent.android.tpush.service.c.a r7 = com.tencent.android.tpush.service.p590c.C6987a.this     // Catch:{ all -> 0x00a6 }
                        android.content.Context r9 = r5     // Catch:{ all -> 0x00a6 }
                        java.util.ArrayList<com.tencent.android.tpush.service.channel.protocol.TpnsPushClientReport> r6 = r6.msgReportList     // Catch:{ all -> 0x00a6 }
                        r7.m29871c(r9, r6)     // Catch:{ all -> 0x00a6 }
                        goto L_0x008b
                    L_0x0088:
                        com.tencent.android.tpush.p580b.C6864a.m29308i(r2, r8)     // Catch:{ all -> 0x00a6 }
                    L_0x008b:
                        com.tencent.android.tpush.common.c r6 = com.tencent.android.tpush.common.C6901c.m29459a()     // Catch:{ all -> 0x00a6 }
                        r7 = 1
                        r6.mo33103a(r7)     // Catch:{ all -> 0x00a6 }
                        com.tencent.android.tpush.common.c r6 = com.tencent.android.tpush.common.C6901c.m29459a()     // Catch:{ all -> 0x00a6 }
                        com.tencent.android.tpush.service.c.a$a r9 = new com.tencent.android.tpush.service.c.a$a     // Catch:{ all -> 0x00a6 }
                        com.tencent.android.tpush.service.c.a r0 = com.tencent.android.tpush.service.p590c.C6987a.this     // Catch:{ all -> 0x00a6 }
                        android.content.Context r3 = r5     // Catch:{ all -> 0x00a6 }
                        r9.m52048init(r3, r7)     // Catch:{ all -> 0x00a6 }
                        r3 = 3000(0xbb8, double:1.482E-320)
                        r6.mo33105a(r9, r7, r3)     // Catch:{ all -> 0x00a6 }
                        goto L_0x00a9
                    L_0x00a6:
                        com.tencent.android.tpush.p580b.C6864a.m29308i(r2, r8)     // Catch:{ all -> 0x00ad }
                    L_0x00a9:
                        com.tencent.android.tpush.service.p590c.C6987a.f23209g = r1
                        goto L_0x00dc
                    L_0x00ad:
                        r6 = move-exception
                        com.tencent.android.tpush.service.p590c.C6987a.f23209g = r1
                        throw r6
                    L_0x00b2:
                        com.tencent.android.tpush.service.p590c.C6987a.f23209g = r1
                        java.lang.StringBuilder r6 = new java.lang.StringBuilder
                        r6.<init>()
                        java.lang.String r8 = ">> requestServiceAck ack onMessageSendFailed responseCode= "
                        r6.append(r8)
                        r6.append(r7)
                        java.lang.String r7 = " msgId = "
                        r6.append(r7)
                        com.tencent.android.tpush.data.MessageId r7 = r6
                        if (r7 != 0) goto L_0x00cc
                        goto L_0x00d2
                    L_0x00cc:
                        long r7 = r7.f23015id
                        java.lang.Long r0 = java.lang.Long.valueOf(r7)
                    L_0x00d2:
                        r6.append(r0)
                        java.lang.String r6 = r6.toString()
                        com.tencent.android.tpush.p580b.C6864a.m29308i(r2, r6)
                    L_0x00dc:
                        return
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.tencent.android.tpush.service.p590c.C6987a.C69892.mo33269a(com.qq.taf.jce.JceStruct, int, com.qq.taf.jce.JceStruct, com.tencent.android.tpush.service.channel.a):void");
                    }

                    /* renamed from: a */
                    public void mo33271a(JceStruct jceStruct, ChannelException channelException, C7000a aVar) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("requestServiceAck ack onMessageSendFailed  responseCode= ");
                        sb.append(channelException.errorCode);
                        sb.append(StorageInterface.KEY_SPLITER);
                        sb.append(channelException.getMessage());
                        C6864a.m29308i("SrvMessageManager", sb.toString());
                        C6987a.f23209g = false;
                    }

                    /* renamed from: a */
                    public void mo33270a(JceStruct jceStruct, C7000a aVar) {
                        Long l;
                        StringBuilder sb = new StringBuilder();
                        sb.append("requestServiceAck ack onMessageDiscarded msgId = ");
                        MessageId messageId = messageId;
                        if (messageId == null) {
                            l = null;
                        } else {
                            l = Long.valueOf(messageId.f23015id);
                        }
                        sb.append(l);
                        C6864a.m29308i("SrvMessageManager", sb.toString());
                        C6987a.f23209g = false;
                    }
                });
                return;
            }
        }
        C6864a.m29298c("SrvMessageManager", "requestSendSDKAck with null list , give up this time");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0076, code lost:
            return;
     */
    /* renamed from: c */
    public synchronized void mo33346c(android.content.Context r22, android.content.Intent r23) {
        /*
        r21 = this;
        r1 = r21
        r0 = r22
        r2 = r23
        monitor-enter(r21)
        if (r0 == 0) goto L_0x0075
        if (r2 == 0) goto L_0x0075
        java.lang.String r3 = "packName"
        java.lang.String r3 = r2.getStringExtra(r3)     // Catch:{ all -> 0x0072 }
        java.lang.String r4 = "msgId"
        r5 = -1
        long r7 = r2.getLongExtra(r4, r5)     // Catch:{ all -> 0x0072 }
        r9 = 0
        int r4 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
        if (r4 > 0) goto L_0x0028
        java.lang.String r0 = "XGService"
        java.lang.String r2 = "@@ msgClick: Not add LocalMsg"
        com.tencent.android.tpush.p580b.C6864a.m29286a(r0, r2)     // Catch:{ all -> 0x0072 }
        monitor-exit(r21)
        return
    L_0x0028:
        java.lang.String r4 = "accId"
        long r9 = r2.getLongExtra(r4, r5)     // Catch:{ all -> 0x0072 }
        java.lang.String r4 = "busiMsgId"
        long r11 = r2.getLongExtra(r4, r5)     // Catch:{ all -> 0x0072 }
        java.lang.String r4 = "timestamps"
        long r13 = r2.getLongExtra(r4, r5)     // Catch:{ all -> 0x0072 }
        java.lang.String r4 = "clickTime"
        long r5 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x0072 }
        r15 = 1000(0x3e8, double:4.94E-321)
        long r5 = r5 / r15
        long r16 = r2.getLongExtra(r4, r5)     // Catch:{ all -> 0x0072 }
        java.lang.String r4 = "action"
        com.tencent.android.tpush.NotificationAction r5 = com.tencent.android.tpush.NotificationAction.clicked     // Catch:{ all -> 0x0072 }
        int r5 = r5.getType()     // Catch:{ all -> 0x0072 }
        int r18 = r2.getIntExtra(r4, r5)     // Catch:{ all -> 0x0072 }
        java.lang.String r4 = "PUSH.CHANNEL"
        r5 = 1
        int r4 = r2.getIntExtra(r4, r5)     // Catch:{ all -> 0x0072 }
        com.tencent.android.tpush.data.PushClickEntity r15 = new com.tencent.android.tpush.data.PushClickEntity     // Catch:{ all -> 0x0072 }
        long r5 = (long) r4     // Catch:{ all -> 0x0072 }
        r4 = r15
        r19 = r5
        r5 = r7
        r7 = r9
        r9 = r11
        r11 = r13
        r13 = r3
        r2 = r15
        r14 = r19
        r4.m51952init(r5, r7, r9, r11, r13, r14, r16, r18)     // Catch:{ all -> 0x0072 }
        r1.mo33331a(r0, r3, r2)     // Catch:{ all -> 0x0072 }
        r21.mo33349d(r22, r23)     // Catch:{ all -> 0x0072 }
        goto L_0x0075
    L_0x0072:
        r0 = move-exception
        monitor-exit(r21)
        throw r0
    L_0x0075:
        monitor-exit(r21)
        return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.android.tpush.service.p590c.C6987a.mo33346c(android.content.Context, android.content.Intent):void");
    }

    /* renamed from: a */
    public void mo33328a(Context context, TpnsPushMsg tpnsPushMsg, long j, C7000a aVar) {
        if (tpnsPushMsg.msgId <= 0) {
            C6864a.m29286a(Constants.ServiceLogTag, "@@ msgServiceAck: Not add LocalMsg");
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        MessageId messageId = new MessageId();
        messageId.f23015id = tpnsPushMsg.msgId;
        messageId.accessId = tpnsPushMsg.accessId;
        messageId.host = C7056i.m30195c(aVar.mo33365d());
        messageId.port = aVar.mo33366e();
        messageId.pact = C6982c.m29814a(aVar.mo33363b());
        messageId.apn = DeviceInfos.getNetworkType(C6973b.m29776f());
        messageId.isp = C7056i.m30217k(C6973b.m29776f());
        messageId.pushTime = j;
        messageId.serviceHost = C6973b.m29776f().getPackageName();
        messageId.receivedTime = currentTimeMillis;
        messageId.pkgName = tpnsPushMsg.appPkgName;
        messageId.busiMsgId = tpnsPushMsg.busiMsgId;
        messageId.timestamp = tpnsPushMsg.timestamp;
        messageId.msgType = tpnsPushMsg.type;
        messageId.multiPkg = tpnsPushMsg.multiPkg;
        messageId.date = tpnsPushMsg.date;
        messageId.channelId = tpnsPushMsg.channelId;
        String str = tpnsPushMsg.groupKey;
        if (!C7056i.m30194b(str)) {
            messageId.groupKeys = str;
        }
        String str2 = tpnsPushMsg.statTag;
        if (!C7056i.m30194b(str2)) {
            messageId.statTag = str2;
        }
        mo33330a(context, tpnsPushMsg.appPkgName, messageId);
        m29870c(context, messageId);
    }

    /* access modifiers changed from: private|declared_synchronized */
    /* renamed from: c */
    public synchronized void m29870c(final Context context, final MessageId messageId) {
        Long l;
        ArrayList a = mo33324a(context, messageId);
        if (f23208f) {
            String str = "SrvMessageManager";
            StringBuilder sb = new StringBuilder();
            sb.append("requestServiceAck ack is uploading , this time will give up!  msgId =  ");
            if (messageId == null) {
                l = null;
            } else {
                l = Long.valueOf(messageId.f23015id);
            }
            sb.append(l);
            C6864a.m29298c(str, sb.toString());
            return;
        }
        ArrayList a2 = mo33326a(context, (List<MessageId>) a);
        if (a2 != null) {
            if (a2.size() != 0) {
                f23208f = true;
                C6982c.m29815a().mo33319a(a2, (C7031a) new C7031a() {
                    /* JADX WARNING: Code restructure failed: missing block: B:18:?, code lost:
            com.tencent.android.tpush.p580b.C6864a.m29308i(r1, r9);
     */
                    /* JADX WARNING: Code restructure failed: missing block: B:20:0x007b, code lost:
            r7 = move-exception;
     */
                    /* JADX WARNING: Code restructure failed: missing block: B:21:0x007c, code lost:
            com.tencent.android.tpush.service.p590c.C6987a.m29872c(false);
     */
                    /* JADX WARNING: Code restructure failed: missing block: B:22:0x007f, code lost:
            throw r7;
     */
                    /* JADX WARNING: Failed to process nested try/catch */
                    /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0074 */
                    /* renamed from: a */
                    public void mo33269a(com.p522qq.taf.jce.JceStruct r7, int r8, com.p522qq.taf.jce.JceStruct r9, com.tencent.android.tpush.service.channel.C7000a r10) {
                        /*
                        r6 = this;
                        java.lang.String r9 = "requestServiceAck -> Invalid ack callback"
                        r0 = 0
                        java.lang.String r1 = "SrvMessageManager"
                        r2 = 0
                        if (r8 != 0) goto L_0x0080
                        boolean r8 = r7 instanceof com.tencent.android.tpush.service.channel.protocol.TpnsPushVerifyReq     // Catch:{ all -> 0x0074 }
                        r3 = 1
                        if (r8 == 0) goto L_0x0057
                        com.tencent.android.tpush.service.channel.protocol.TpnsPushVerifyReq r7 = (com.tencent.android.tpush.service.channel.protocol.TpnsPushVerifyReq) r7     // Catch:{ all -> 0x0074 }
                        java.util.ArrayList<com.tencent.android.tpush.service.channel.protocol.TpnsPushClientReport> r8 = r7.msgReportList     // Catch:{ all -> 0x0074 }
                        com.tencent.android.tpush.p580b.C6864a.m29284a(r3, r8)     // Catch:{ all -> 0x0074 }
                        java.util.ArrayList<com.tencent.android.tpush.service.channel.protocol.TpnsPushClientReport> r8 = r7.msgReportList     // Catch:{ all -> 0x0074 }
                        if (r8 == 0) goto L_0x0020
                        java.util.ArrayList<com.tencent.android.tpush.service.channel.protocol.TpnsPushClientReport> r8 = r7.msgReportList     // Catch:{ all -> 0x0074 }
                        int r8 = r8.size()     // Catch:{ all -> 0x0074 }
                        if (r8 != 0) goto L_0x004d
                    L_0x0020:
                        java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ all -> 0x0074 }
                        r8.<init>()     // Catch:{ all -> 0x0074 }
                        java.lang.String r4 = "ServiceAcking ack failed with null tReq.msgReportList rsp = "
                        r8.append(r4)     // Catch:{ all -> 0x0074 }
                        long r4 = r10.mo33364c()     // Catch:{ all -> 0x0074 }
                        r8.append(r4)     // Catch:{ all -> 0x0074 }
                        java.lang.String r10 = " msgId "
                        r8.append(r10)     // Catch:{ all -> 0x0074 }
                        com.tencent.android.tpush.data.MessageId r10 = r5     // Catch:{ all -> 0x0074 }
                        if (r10 != 0) goto L_0x003b
                        goto L_0x0043
                    L_0x003b:
                        com.tencent.android.tpush.data.MessageId r10 = r5     // Catch:{ all -> 0x0074 }
                        long r4 = r10.f23015id     // Catch:{ all -> 0x0074 }
                        java.lang.Long r0 = java.lang.Long.valueOf(r4)     // Catch:{ all -> 0x0074 }
                    L_0x0043:
                        r8.append(r0)     // Catch:{ all -> 0x0074 }
                        java.lang.String r8 = r8.toString()     // Catch:{ all -> 0x0074 }
                        com.tencent.android.tpush.p580b.C6864a.m29308i(r1, r8)     // Catch:{ all -> 0x0074 }
                    L_0x004d:
                        com.tencent.android.tpush.service.c.a r8 = com.tencent.android.tpush.service.p590c.C6987a.this     // Catch:{ all -> 0x0074 }
                        android.content.Context r10 = r4     // Catch:{ all -> 0x0074 }
                        java.util.ArrayList<com.tencent.android.tpush.service.channel.protocol.TpnsPushClientReport> r7 = r7.msgReportList     // Catch:{ all -> 0x0074 }
                        r8.mo33333a(r10, r7)     // Catch:{ all -> 0x0074 }
                        goto L_0x005a
                    L_0x0057:
                        com.tencent.android.tpush.p580b.C6864a.m29308i(r1, r9)     // Catch:{ all -> 0x0074 }
                    L_0x005a:
                        com.tencent.android.tpush.common.c r7 = com.tencent.android.tpush.common.C6901c.m29459a()     // Catch:{ all -> 0x0074 }
                        r7.mo33103a(r3)     // Catch:{ all -> 0x0074 }
                        com.tencent.android.tpush.common.c r7 = com.tencent.android.tpush.common.C6901c.m29459a()     // Catch:{ all -> 0x0074 }
                        com.tencent.android.tpush.service.c.a$a r8 = new com.tencent.android.tpush.service.c.a$a     // Catch:{ all -> 0x0074 }
                        com.tencent.android.tpush.service.c.a r10 = com.tencent.android.tpush.service.p590c.C6987a.this     // Catch:{ all -> 0x0074 }
                        android.content.Context r0 = r4     // Catch:{ all -> 0x0074 }
                        r8.m52048init(r0, r3)     // Catch:{ all -> 0x0074 }
                        r4 = 3000(0xbb8, double:1.482E-320)
                        r7.mo33105a(r8, r3, r4)     // Catch:{ all -> 0x0074 }
                        goto L_0x0077
                    L_0x0074:
                        com.tencent.android.tpush.p580b.C6864a.m29308i(r1, r9)     // Catch:{ all -> 0x007b }
                    L_0x0077:
                        com.tencent.android.tpush.service.p590c.C6987a.f23208f = r2
                        goto L_0x00aa
                    L_0x007b:
                        r7 = move-exception
                        com.tencent.android.tpush.service.p590c.C6987a.f23208f = r2
                        throw r7
                    L_0x0080:
                        com.tencent.android.tpush.service.p590c.C6987a.f23208f = r2
                        java.lang.StringBuilder r7 = new java.lang.StringBuilder
                        r7.<init>()
                        java.lang.String r9 = ">> ServiceAcking ack onMessageSendFailed responseCode= "
                        r7.append(r9)
                        r7.append(r8)
                        java.lang.String r8 = " msgId = "
                        r7.append(r8)
                        com.tencent.android.tpush.data.MessageId r8 = r5
                        if (r8 != 0) goto L_0x009a
                        goto L_0x00a0
                    L_0x009a:
                        long r8 = r8.f23015id
                        java.lang.Long r0 = java.lang.Long.valueOf(r8)
                    L_0x00a0:
                        r7.append(r0)
                        java.lang.String r7 = r7.toString()
                        com.tencent.android.tpush.p580b.C6864a.m29308i(r1, r7)
                    L_0x00aa:
                        return
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.tencent.android.tpush.service.p590c.C6987a.C69903.mo33269a(com.qq.taf.jce.JceStruct, int, com.qq.taf.jce.JceStruct, com.tencent.android.tpush.service.channel.a):void");
                    }

                    /* renamed from: a */
                    public void mo33271a(JceStruct jceStruct, ChannelException channelException, C7000a aVar) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("ServiceAcking ack onMessageSendFailed  responseCode= ");
                        sb.append(channelException.errorCode);
                        sb.append(StorageInterface.KEY_SPLITER);
                        sb.append(channelException.getMessage());
                        C6864a.m29308i("SrvMessageManager", sb.toString());
                        C6987a.f23208f = false;
                    }

                    /* renamed from: a */
                    public void mo33270a(JceStruct jceStruct, C7000a aVar) {
                        Long l;
                        StringBuilder sb = new StringBuilder();
                        sb.append("ServiceAcking ack onMessageDiscarded msgId = ");
                        MessageId messageId = messageId;
                        if (messageId == null) {
                            l = null;
                        } else {
                            l = Long.valueOf(messageId.f23015id);
                        }
                        sb.append(l);
                        C6864a.m29308i("SrvMessageManager", sb.toString());
                        C6987a.f23208f = false;
                    }
                });
                return;
            }
        }
        C6864a.m29298c("SrvMessageManager", "requestServiceAck with null list , give up this time");
    }

    /* renamed from: a */
    public void mo33333a(Context context, ArrayList<TpnsPushClientReport> arrayList) {
        synchronized (f23205c) {
            if (!(context == null || arrayList == null)) {
                if (arrayList.size() > 0) {
                    try {
                        ArrayList b = m29862b(context, MsgService.MSG_CHATTING_ACCOUNT_ALL);
                        if (b != null && b.size() > 0) {
                            HashMap hashMap = new HashMap();
                            Iterator it = b.iterator();
                            while (it.hasNext()) {
                                MessageId messageId = (MessageId) it.next();
                                ArrayList arrayList2 = (ArrayList) hashMap.get(messageId.pkgName);
                                if (arrayList2 == null) {
                                    arrayList2 = new ArrayList();
                                    hashMap.put(messageId.pkgName, arrayList2);
                                }
                                boolean z = false;
                                int i = 0;
                                while (true) {
                                    if (i >= arrayList.size()) {
                                        z = true;
                                        break;
                                    }
                                    if (messageId.f23015id == ((TpnsPushClientReport) arrayList.get(i)).msgId) {
                                        arrayList.remove(i);
                                        break;
                                    }
                                    i++;
                                }
                                if (z) {
                                    arrayList2.add(messageId);
                                    hashMap.put(messageId.pkgName, arrayList2);
                                }
                            }
                            for (String str : hashMap.keySet()) {
                                mo33341b(context, str, (ArrayList) hashMap.get(str));
                            }
                        }
                    } catch (Exception e) {
                        C6864a.m29302d("SrvMessageManager", "+++ clear msg id exception", e);
                    }
                }
            }
            C6864a.m29308i("SrvMessageManager", "deleteServiceMsgIdBatch with null context or null list");
        }
    }

    /* renamed from: a */
    public ArrayList<TpnsPushClientReport> mo33326a(Context context, List<MessageId> list) {
        ArrayList<TpnsPushClientReport> arrayList;
        if (list == null || list.size() <= 0) {
            arrayList = null;
        } else {
            arrayList = new ArrayList<>();
            for (MessageId messageId : list) {
                TpnsPushClientReport tpnsPushClientReport = new TpnsPushClientReport();
                tpnsPushClientReport.accessId = messageId.accessId;
                tpnsPushClientReport.msgId = messageId.f23015id;
                tpnsPushClientReport.apn = messageId.apn;
                tpnsPushClientReport.isp = messageId.isp;
                tpnsPushClientReport.locip = messageId.host;
                tpnsPushClientReport.locport = messageId.port;
                tpnsPushClientReport.pack = messageId.pact;
                tpnsPushClientReport.timeUs = messageId.pushTime;
                tpnsPushClientReport.qua = CacheManager.getQua(context, tpnsPushClientReport.accessId);
                tpnsPushClientReport.serviceHost = messageId.serviceHost;
                tpnsPushClientReport.confirmMs = System.currentTimeMillis() - messageId.receivedTime;
                tpnsPushClientReport.broadcastId = messageId.busiMsgId;
                tpnsPushClientReport.timestamp = messageId.timestamp;
                tpnsPushClientReport.type = messageId.msgType;
                tpnsPushClientReport.ackType = 1;
                tpnsPushClientReport.receiveTime = messageId.receivedTime / 1000;
                tpnsPushClientReport.channelId = messageId.channelId;
                tpnsPushClientReport.groupKey = messageId.groupKeys;
                tpnsPushClientReport.statTag = messageId.statTag;
                if (XGPushConfig.enableDebug) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Ack to server : @msgId=");
                    sb.append(tpnsPushClientReport.msgId);
                    sb.append(" @accId=");
                    sb.append(tpnsPushClientReport.accessId);
                    sb.append(" @timeUs=");
                    sb.append(tpnsPushClientReport.timeUs);
                    sb.append(" @confirmMs=");
                    sb.append(tpnsPushClientReport.confirmMs);
                    sb.append(" @recTime=");
                    sb.append(messageId.receivedTime);
                    sb.append(" @msgType=");
                    sb.append(messageId.msgType);
                    sb.append(" @broadcastId=");
                    sb.append(tpnsPushClientReport.broadcastId);
                    C6864a.m29298c("SrvMessageManager", sb.toString());
                }
                arrayList.add(tpnsPushClientReport);
                if (arrayList.size() > 30) {
                    return arrayList;
                }
            }
        }
        return arrayList;
    }

    /* renamed from: b */
    public ArrayList<TpnsPushClientReport> mo33338b(Context context, List<MessageId> list) {
        ArrayList<TpnsPushClientReport> arrayList;
        if (list == null || list.size() <= 0) {
            arrayList = null;
        } else {
            arrayList = new ArrayList<>();
            for (MessageId messageId : list) {
                TpnsPushClientReport tpnsPushClientReport = new TpnsPushClientReport();
                tpnsPushClientReport.accessId = messageId.accessId;
                tpnsPushClientReport.msgId = messageId.f23015id;
                tpnsPushClientReport.apn = messageId.apn;
                tpnsPushClientReport.isp = messageId.isp;
                tpnsPushClientReport.locip = messageId.host;
                tpnsPushClientReport.locport = messageId.port;
                tpnsPushClientReport.pack = messageId.pact;
                tpnsPushClientReport.timeUs = messageId.pushTime;
                tpnsPushClientReport.qua = CacheManager.getQua(context, tpnsPushClientReport.accessId);
                tpnsPushClientReport.serviceHost = messageId.serviceHost;
                tpnsPushClientReport.confirmMs = System.currentTimeMillis() - messageId.receivedTime;
                tpnsPushClientReport.broadcastId = messageId.busiMsgId;
                tpnsPushClientReport.timestamp = messageId.timestamp;
                tpnsPushClientReport.type = messageId.msgType;
                tpnsPushClientReport.ackType = 4;
                tpnsPushClientReport.receiveTime = messageId.receivedTime / 1000;
                tpnsPushClientReport.channelId = messageId.channelId;
                tpnsPushClientReport.groupKey = messageId.groupKeys;
                tpnsPushClientReport.statTag = messageId.statTag;
                if (XGPushConfig.enableDebug) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Send sdk Ack to server : @msgId=");
                    sb.append(tpnsPushClientReport.msgId);
                    sb.append(" @accId=");
                    sb.append(tpnsPushClientReport.accessId);
                    sb.append(" @timeUs=");
                    sb.append(tpnsPushClientReport.timeUs);
                    sb.append(" @confirmMs=");
                    sb.append(tpnsPushClientReport.confirmMs);
                    sb.append(" @recTime=");
                    sb.append(messageId.receivedTime);
                    sb.append(" @msgType=");
                    sb.append(messageId.msgType);
                    sb.append(" @broadcastId=");
                    sb.append(tpnsPushClientReport.broadcastId);
                    C6864a.m29298c("SrvMessageManager", sb.toString());
                }
                arrayList.add(tpnsPushClientReport);
                if (arrayList.size() > 30) {
                    return arrayList;
                }
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    public ArrayList<MessageId> mo33324a(Context context, MessageId messageId) {
        ArrayList<MessageId> arrayList;
        boolean z;
        synchronized (f23205c) {
            arrayList = null;
            if (context != null) {
                boolean z2 = false;
                List<String> registerInfos = CacheManager.getRegisterInfos(context);
                if (registerInfos != null && registerInfos.size() > 0) {
                    arrayList = new ArrayList<>();
                    for (String str : registerInfos) {
                        ArrayList b = m29862b(context, str);
                        if (messageId == null || str.equals(messageId.pkgName)) {
                            z2 = true;
                        }
                        if (b != null && b.size() > 0) {
                            arrayList.addAll(b);
                        }
                    }
                }
                if (!z) {
                    try {
                        ArrayList b2 = m29862b(context, messageId.pkgName);
                        if (b2 != null && b2.size() > 0) {
                            arrayList.retainAll(b2);
                            if (arrayList.size() > 0) {
                                arrayList.removeAll(arrayList);
                                arrayList.addAll(b2);
                            } else {
                                arrayList.addAll(b2);
                            }
                        }
                    } catch (Exception unused) {
                    }
                }
                mo33341b(context, MsgService.MSG_CHATTING_ACCOUNT_ALL, arrayList);
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    public void mo33330a(Context context, String str, MessageId messageId) {
        synchronized (f23205c) {
            if (context != null) {
                if (!C7056i.m30194b(str) && messageId != null) {
                    ArrayList b = m29862b(context, str);
                    ArrayList arrayList = new ArrayList();
                    for (int i = 0; i < b.size(); i++) {
                        MessageId messageId2 = (MessageId) b.get(i);
                        if (messageId2.f23015id == messageId.f23015id) {
                            arrayList.add(messageId2);
                        }
                    }
                    b.removeAll(arrayList);
                    b.add(messageId);
                    mo33341b(context, str, b);
                }
            }
        }
    }

    /* renamed from: b */
    public void mo33340b(Context context, String str, MessageId messageId) {
        synchronized (f23205c) {
            if (context != null) {
                if (!C7056i.m30194b(str) && messageId != null) {
                    ArrayList c = m29868c(context, str);
                    ArrayList arrayList = new ArrayList();
                    for (int i = 0; i < c.size(); i++) {
                        MessageId messageId2 = (MessageId) c.get(i);
                        if (messageId2.f23015id == messageId.f23015id) {
                            arrayList.add(messageId2);
                        }
                    }
                    c.removeAll(arrayList);
                    c.add(messageId);
                    mo33332a(context, str, c);
                }
            }
        }
    }

    /* renamed from: a */
    public void mo33332a(Context context, String str, ArrayList<MessageId> arrayList) {
        synchronized (f23205c) {
            if (!(context == null || arrayList == null)) {
                m29851a(context, str, ".tpns.msg.id.send.sdk", arrayList);
            }
        }
    }

    /* renamed from: b */
    public void mo33341b(Context context, String str, ArrayList<MessageId> arrayList) {
        synchronized (f23205c) {
            if (!(context == null || arrayList == null)) {
                m29851a(context, str, ".tpns.msg.id.service", arrayList);
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0016  */
    /* renamed from: b */
    private java.util.ArrayList<com.tencent.android.tpush.data.MessageId> m29862b(android.content.Context r2, java.lang.String r3) {
        /*
        r1 = this;
        if (r2 == 0) goto L_0x0013
        boolean r0 = com.tencent.android.tpush.service.p595e.C7056i.m30194b(r3)
        if (r0 != 0) goto L_0x0013
        java.lang.String r0 = ".tpns.msg.id.service"
        java.lang.Object r2 = r1.m29847a(r2, r3, r0)
        if (r2 == 0) goto L_0x0013
        java.util.ArrayList r2 = (java.util.ArrayList) r2
        goto L_0x0014
    L_0x0013:
        r2 = 0
    L_0x0014:
        if (r2 != 0) goto L_0x001b
        java.util.ArrayList r2 = new java.util.ArrayList
        r2.<init>()
    L_0x001b:
        return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.android.tpush.service.p590c.C6987a.m29862b(android.content.Context, java.lang.String):java.util.ArrayList");
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0016  */
    /* renamed from: c */
    private java.util.ArrayList<com.tencent.android.tpush.data.MessageId> m29868c(android.content.Context r2, java.lang.String r3) {
        /*
        r1 = this;
        if (r2 == 0) goto L_0x0013
        boolean r0 = com.tencent.android.tpush.service.p595e.C7056i.m30194b(r3)
        if (r0 != 0) goto L_0x0013
        java.lang.String r0 = ".tpns.msg.id.send.sdk"
        java.lang.Object r2 = r1.m29847a(r2, r3, r0)
        if (r2 == 0) goto L_0x0013
        java.util.ArrayList r2 = (java.util.ArrayList) r2
        goto L_0x0014
    L_0x0013:
        r2 = 0
    L_0x0014:
        if (r2 != 0) goto L_0x001b
        java.util.ArrayList r2 = new java.util.ArrayList
        r2.<init>()
    L_0x001b:
        return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.android.tpush.service.p590c.C6987a.m29868c(android.content.Context, java.lang.String):java.util.ArrayList");
    }

    /* renamed from: b */
    public void mo33342b(Context context, ArrayList<TpnsClickClientReport> arrayList) {
        synchronized (f23205c) {
            if (!(context == null || arrayList == null)) {
                if (arrayList.size() > 0) {
                    try {
                        ArrayList c = mo33344c(context);
                        if (c != null && c.size() > 0) {
                            HashMap hashMap = new HashMap();
                            Iterator it = c.iterator();
                            while (it.hasNext()) {
                                PushClickEntity pushClickEntity = (PushClickEntity) it.next();
                                ArrayList arrayList2 = (ArrayList) hashMap.get(pushClickEntity.pkgName);
                                if (arrayList2 == null) {
                                    arrayList2 = new ArrayList();
                                    hashMap.put(pushClickEntity.pkgName, arrayList2);
                                }
                                boolean z = false;
                                int i = 0;
                                while (true) {
                                    if (i >= arrayList.size()) {
                                        z = true;
                                        break;
                                    }
                                    if (pushClickEntity.msgId == ((TpnsClickClientReport) arrayList.get(i)).msgId) {
                                        arrayList.remove(i);
                                        break;
                                    }
                                    i++;
                                }
                                if (z) {
                                    arrayList2.add(pushClickEntity);
                                    hashMap.put(pushClickEntity.pkgName, arrayList2);
                                }
                            }
                            for (String str : hashMap.keySet()) {
                                mo33348c(context, str, (ArrayList) hashMap.get(str));
                            }
                        }
                    } catch (Exception e) {
                        C6864a.m29302d("SrvMessageManager", "+++ clear msg id exception", e);
                    }
                }
            }
        }
    }

    /* renamed from: a */
    public ArrayList<TpnsClickClientReport> mo33323a(Context context) {
        ArrayList<TpnsClickClientReport> arrayList;
        ArrayList<PushClickEntity> c = mo33344c(context);
        if (c == null || c.size() <= 0) {
            arrayList = null;
        } else {
            arrayList = new ArrayList<>();
            for (PushClickEntity pushClickEntity : c) {
                TpnsClickClientReport tpnsClickClientReport = new TpnsClickClientReport();
                tpnsClickClientReport.accessId = pushClickEntity.accessId;
                tpnsClickClientReport.msgId = pushClickEntity.msgId;
                tpnsClickClientReport.broadcastId = pushClickEntity.broadcastId;
                tpnsClickClientReport.timestamp = pushClickEntity.timestamp;
                tpnsClickClientReport.type = pushClickEntity.type;
                tpnsClickClientReport.clickTime = pushClickEntity.clickTime;
                tpnsClickClientReport.action = (long) pushClickEntity.action;
                arrayList.add(tpnsClickClientReport);
                if (arrayList.size() > 30) {
                    return arrayList;
                }
            }
        }
        return arrayList;
    }

    /* renamed from: d */
    public void mo33349d(final Context context, final Intent intent) {
        if (!f23210h) {
            final ArrayList a = mo33323a(context);
            if (a == null || a.size() <= 0) {
                f23210h = false;
                return;
            }
            f23210h = true;
            C6982c.m29815a().mo33322b(a, new C7031a() {
                /* renamed from: a */
                public void mo33269a(JceStruct jceStruct, int i, JceStruct jceStruct2, C7000a aVar) {
                    C7046a.m30133c(a);
                    if (i == 0) {
                        C6987a.this.mo33342b(C6973b.m29776f(), a);
                        C6901c.m29459a().mo33106a(new Runnable() {
                            public void run() {
                                C6987a.this.mo33349d(context, intent);
                            }
                        }, 10000);
                    } else {
                        StringBuilder sb = new StringBuilder();
                        sb.append(">> msg ckicled ack failed responseCode=");
                        sb.append(i);
                        C6864a.m29308i("SrvMessageManager", sb.toString());
                    }
                    C6987a.f23210h = false;
                }

                /* renamed from: a */
                public void mo33271a(JceStruct jceStruct, ChannelException channelException, C7000a aVar) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("### msg ack onMessageSendFailed  responseCode=");
                    sb.append(channelException.errorCode);
                    C6864a.m29308i("SrvMessageManager", sb.toString());
                    C6987a.f23210h = false;
                }

                /* renamed from: a */
                public void mo33270a(JceStruct jceStruct, C7000a aVar) {
                    C6987a.f23210h = false;
                }
            });
        }
    }

    /* renamed from: b */
    public ArrayList<MessageId> mo33337b(Context context) {
        if (context != null) {
            List<String> registerInfos = CacheManager.getRegisterInfos(context);
            if (registerInfos != null && registerInfos.size() > 0) {
                ArrayList<MessageId> arrayList = new ArrayList<>();
                for (String e : registerInfos) {
                    ArrayList e2 = m29876e(context, e);
                    if (e2 != null && e2.size() > 0) {
                        arrayList.addAll(e2);
                    }
                }
                return arrayList;
            }
        }
        return null;
    }

    /* renamed from: c */
    public ArrayList<PushClickEntity> mo33344c(Context context) {
        if (context != null) {
            List<String> registerInfos = CacheManager.getRegisterInfos(context);
            if (registerInfos != null && registerInfos.size() > 0) {
                ArrayList<PushClickEntity> arrayList = new ArrayList<>();
                for (String d : registerInfos) {
                    ArrayList d2 = m29873d(context, d);
                    if (d2 != null && d2.size() > 0) {
                        arrayList.addAll(d2);
                    }
                }
                return arrayList;
            }
        }
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0016  */
    /* renamed from: d */
    private java.util.ArrayList<com.tencent.android.tpush.data.PushClickEntity> m29873d(android.content.Context r2, java.lang.String r3) {
        /*
        r1 = this;
        if (r2 == 0) goto L_0x0013
        boolean r0 = com.tencent.android.tpush.service.p595e.C7056i.m30194b(r3)
        if (r0 != 0) goto L_0x0013
        java.lang.String r0 = ".tpns.msg.id.clicked"
        java.lang.Object r2 = r1.m29847a(r2, r3, r0)
        if (r2 == 0) goto L_0x0013
        java.util.ArrayList r2 = (java.util.ArrayList) r2
        goto L_0x0014
    L_0x0013:
        r2 = 0
    L_0x0014:
        if (r2 != 0) goto L_0x001b
        java.util.ArrayList r2 = new java.util.ArrayList
        r2.<init>()
    L_0x001b:
        return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.android.tpush.service.p590c.C6987a.m29873d(android.content.Context, java.lang.String):java.util.ArrayList");
    }

    /* renamed from: a */
    public void mo33331a(Context context, String str, PushClickEntity pushClickEntity) {
        synchronized (f23205c) {
            if (context != null) {
                if (!C7056i.m30194b(str) && pushClickEntity != null) {
                    ArrayList d = m29873d(context, str);
                    ArrayList arrayList = new ArrayList();
                    for (int i = 0; i < d.size(); i++) {
                        PushClickEntity pushClickEntity2 = (PushClickEntity) d.get(i);
                        if (pushClickEntity2.msgId == pushClickEntity.msgId) {
                            arrayList.add(pushClickEntity2);
                        }
                    }
                    d.removeAll(arrayList);
                    d.add(pushClickEntity);
                    mo33348c(context, str, d);
                }
            }
        }
    }

    /* renamed from: c */
    public void mo33348c(Context context, String str, ArrayList<PushClickEntity> arrayList) {
        synchronized (f23205c) {
            if (!(context == null || arrayList == null)) {
                m29851a(context, str, ".tpns.msg.id.clicked", arrayList);
            }
        }
    }

    /* renamed from: c */
    public ArrayList<TpnsPushClientReport> mo33345c(Context context, List<MessageId> list) {
        ArrayList<TpnsPushClientReport> arrayList = new ArrayList<>();
        if (list != null && list.size() > 0) {
            arrayList = new ArrayList<>();
            for (MessageId messageId : list) {
                TpnsPushClientReport tpnsPushClientReport = new TpnsPushClientReport();
                tpnsPushClientReport.accessId = messageId.accessId;
                tpnsPushClientReport.msgId = messageId.f23015id;
                tpnsPushClientReport.apn = messageId.apn;
                tpnsPushClientReport.isp = messageId.isp;
                tpnsPushClientReport.locip = messageId.host;
                tpnsPushClientReport.locport = messageId.port;
                tpnsPushClientReport.pack = messageId.pact;
                tpnsPushClientReport.timeUs = messageId.pushTime;
                tpnsPushClientReport.qua = CacheManager.getQua(context, tpnsPushClientReport.accessId);
                tpnsPushClientReport.serviceHost = messageId.serviceHost;
                tpnsPushClientReport.confirmMs = System.currentTimeMillis() - messageId.receivedTime;
                tpnsPushClientReport.broadcastId = messageId.busiMsgId;
                tpnsPushClientReport.timestamp = messageId.timestamp;
                tpnsPushClientReport.type = messageId.msgType;
                tpnsPushClientReport.receiveTime = messageId.receivedTime / 1000;
                tpnsPushClientReport.channelId = messageId.channelId;
                tpnsPushClientReport.statTag = messageId.statTag;
                tpnsPushClientReport.groupKey = messageId.groupKeys;
                arrayList.add(tpnsPushClientReport);
                if (arrayList.size() > 30) {
                    break;
                }
            }
        }
        return arrayList;
    }

    /* renamed from: e */
    private ArrayList<MessageId> m29876e(Context context, String str) {
        ArrayList<MessageId> arrayList;
        synchronized (f23205c) {
            arrayList = null;
            if (context != null) {
                if (!C7056i.m30194b(str)) {
                    ArrayList a = mo33325a(context, str);
                    if (a != null && a.size() > 0) {
                        arrayList = new ArrayList<>();
                        Iterator it = a.iterator();
                        while (it.hasNext()) {
                            MessageId messageId = (MessageId) it.next();
                            if (messageId.isMsgAcked()) {
                                arrayList.add(messageId);
                            }
                        }
                    }
                }
            }
        }
        return arrayList;
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0016  */
    /* renamed from: a */
    public java.util.ArrayList<com.tencent.android.tpush.data.MessageId> mo33325a(android.content.Context r2, java.lang.String r3) {
        /*
        r1 = this;
        if (r2 == 0) goto L_0x0013
        boolean r0 = com.tencent.android.tpush.service.p595e.C7056i.m30194b(r3)
        if (r0 != 0) goto L_0x0013
        java.lang.String r0 = ".tpns.msg.id"
        java.lang.Object r2 = r1.m29847a(r2, r3, r0)
        if (r2 == 0) goto L_0x0013
        java.util.ArrayList r2 = (java.util.ArrayList) r2
        goto L_0x0014
    L_0x0013:
        r2 = 0
    L_0x0014:
        if (r2 != 0) goto L_0x001b
        java.util.ArrayList r2 = new java.util.ArrayList
        r2.<init>()
    L_0x001b:
        return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.android.tpush.service.p590c.C6987a.mo33325a(android.content.Context, java.lang.String):java.util.ArrayList");
    }

    /* renamed from: d */
    public void mo33350d(Context context, String str, ArrayList<MessageId> arrayList) {
        synchronized (f23205c) {
            if (!(context == null || arrayList == null)) {
                m29851a(context, str, ".tpns.msg.id", arrayList);
            }
        }
    }

    /* renamed from: a */
    public void mo33329a(Context context, String str, long j, short s) {
        synchronized (f23205c) {
            boolean z = false;
            if (context != null && j > 0) {
                ArrayList a = mo33325a(context, str);
                if (a == null || a.size() <= 0) {
                    C6864a.m29283a(12, j);
                } else {
                    Iterator it = a.iterator();
                    while (it.hasNext()) {
                        MessageId messageId = (MessageId) it.next();
                        if (messageId.f23015id == j) {
                            messageId.isAck = s;
                            z = true;
                        }
                    }
                    if (z) {
                        mo33350d(context, str, a);
                    } else {
                        StringBuilder sb = new StringBuilder();
                        sb.append("updateMsgIdFlag Failed with no equal MessageId = ");
                        sb.append(j);
                        sb.append(" pkgName = ");
                        sb.append(str);
                        C6864a.m29308i("SrvMessageManager", sb.toString());
                        C6864a.m29283a(11, j);
                    }
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m29871c(Context context, ArrayList<TpnsPushClientReport> arrayList) {
        synchronized (f23205c) {
            if (!(context == null || arrayList == null)) {
                if (arrayList.size() > 0) {
                    try {
                        ArrayList c = m29868c(context, MsgService.MSG_CHATTING_ACCOUNT_ALL);
                        ArrayList arrayList2 = new ArrayList();
                        if (c != null && c.size() > 0) {
                            Iterator it = c.iterator();
                            while (it.hasNext()) {
                                MessageId messageId = (MessageId) it.next();
                                for (int i = 0; i < arrayList.size(); i++) {
                                    if (messageId.f23015id == ((TpnsPushClientReport) arrayList.get(i)).msgId) {
                                        arrayList2.add(messageId);
                                    }
                                }
                            }
                        }
                        c.removeAll(arrayList2);
                        mo33332a(context, MsgService.MSG_CHATTING_ACCOUNT_ALL, c);
                    } catch (Exception e) {
                        C6864a.m29302d("SrvMessageManager", "deleteMsgIdBatch", e);
                    }
                }
            }
        }
    }

    /* renamed from: d */
    public void mo33351d(Context context, List<TpnsPushClientReport> list) {
        synchronized (f23205c) {
            if (!(context == null || list == null)) {
                if (list.size() > 0) {
                    try {
                        ArrayList b = mo33337b(context);
                        if (b != null && b.size() > 0) {
                            HashMap hashMap = new HashMap();
                            Iterator it = b.iterator();
                            while (it.hasNext()) {
                                MessageId messageId = (MessageId) it.next();
                                ArrayList arrayList = (ArrayList) hashMap.get(messageId.pkgName);
                                if (arrayList == null) {
                                    arrayList = new ArrayList();
                                    hashMap.put(messageId.pkgName, arrayList);
                                }
                                boolean z = false;
                                int i = 0;
                                while (true) {
                                    if (i >= list.size()) {
                                        z = true;
                                        break;
                                    }
                                    if (messageId.f23015id == ((TpnsPushClientReport) list.get(i)).msgId) {
                                        break;
                                    }
                                    i++;
                                }
                                if (z) {
                                    arrayList.add(messageId);
                                    hashMap.put(messageId.pkgName, arrayList);
                                }
                            }
                            for (String str : hashMap.keySet()) {
                                mo33350d(context, str, (ArrayList) hashMap.get(str));
                            }
                        }
                    } catch (Exception e) {
                        C6864a.m29302d("SrvMessageManager", "deleteMsgIdBatch", e);
                    }
                }
            }
        }
    }

    /* renamed from: c */
    public void mo33347c(Context context, String str, MessageId messageId) {
        synchronized (f23205c) {
            if (context != null) {
                if (!C7056i.m30194b(str) && messageId != null) {
                    ArrayList a = mo33325a(context, str);
                    if (a == null) {
                        a = new ArrayList();
                    } else {
                        int i = 0;
                        while (true) {
                            if (i >= a.size()) {
                                break;
                            } else if (((MessageId) a.get(i)).f23015id == messageId.f23015id) {
                                a.remove(i);
                                break;
                            } else {
                                i++;
                            }
                        }
                    }
                    a.add(messageId);
                    mo33350d(context, str, a);
                }
            }
        }
    }

    /* JADX WARNING: type inference failed for: r5v44, types: [java.lang.String[], java.io.Serializable] */
    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0198, code lost:
            if (r5.size() > 0) goto L_0x019a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x025d, code lost:
            if (r5.size() > 0) goto L_0x019a;
     */
    /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r5v44, types: [java.lang.String[], java.io.Serializable]
  assigns: [java.lang.String[]]
  uses: [java.io.Serializable]
	at jadx.core.dex.visitors.typeinference.TypeSearch.fillTypeCandidates(TypeSearch.java:231)
	at java.util.ArrayList.forEach(ArrayList.java:1249)
	at jadx.core.dex.visitors.typeinference.TypeSearch.run(TypeSearch.java:53)
	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runMultiVariableSearch(TypeInferenceVisitor.java:95)
	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:88)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:27)
	at jadx.core.dex.visitors.DepthTraversal.lambda$visit$1(DepthTraversal.java:14)
	at java.util.ArrayList.forEach(ArrayList.java:1249)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:30)
	at jadx.core.ProcessClass.lambda$processDependencies$0(ProcessClass.java:49)
	at java.util.ArrayList.forEach(ArrayList.java:1249)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:49)
	at jadx.core.ProcessClass.process(ProcessClass.java:35)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:290)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
 */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* renamed from: a */
    public void m29857a(com.tencent.android.tpush.service.channel.protocol.TpnsPushMsg r23, long r24, com.tencent.android.tpush.service.channel.C7000a r26) {
        /*
        r22 = this;
        r1 = r22
        r2 = r23
        java.lang.String r3 = "SrvMessageManager"
        android.content.Intent r4 = new android.content.Intent
        java.lang.String r0 = "com.tencent.android.tpush.action.INTERNAL_PUSH_MESSAGE"
        r4.<init>(r0)
        java.lang.String r0 = r2.appPkgName
        r4.setPackage(r0)
        long r5 = r2.msgId
        java.lang.String r0 = "msgId"
        r4.putExtra(r0, r5)
        java.lang.String r0 = r2.title
        java.lang.String r0 = com.tencent.android.tpush.encrypt.Rijndael.encrypt(r0)
        java.lang.String r5 = "title"
        r4.putExtra(r5, r0)
        java.lang.String r0 = r2.content
        java.lang.String r0 = com.tencent.android.tpush.encrypt.Rijndael.encrypt(r0)
        java.lang.String r6 = "content"
        r4.putExtra(r6, r0)
        java.lang.String r0 = r2.date
        java.lang.String r7 = "date"
        r4.putExtra(r7, r0)
        long r7 = r2.type
        java.lang.String r0 = "type"
        r4.putExtra(r0, r7)
        long r7 = r2.accessId
        java.lang.String r0 = "accId"
        r4.putExtra(r0, r7)
        long r7 = r2.busiMsgId
        java.lang.String r0 = "busiMsgId"
        r4.putExtra(r0, r7)
        long r7 = r2.timestamp
        java.lang.String r0 = "timestamps"
        r4.putExtra(r0, r7)
        long r7 = r2.multiPkg
        java.lang.String r0 = "multiPkg"
        r4.putExtra(r0, r7)
        long r7 = r2.serverTime
        java.lang.String r0 = "server_time"
        r4.putExtra(r0, r7)
        int r0 = r2.ttl
        java.lang.String r7 = "ttl"
        r4.putExtra(r7, r0)
        long r7 = r2.channelId
        r9 = 1
        java.lang.String r0 = "svrAck"
        r4.putExtra(r0, r9)
        java.lang.String r0 = com.tencent.android.tpush.service.C6973b.m29777g()
        java.lang.String r10 = "svrPkgName"
        r4.putExtra(r10, r0)
        int r0 = r2.ttl
        long r10 = r2.serverTime
        long r12 = r2.timestamp
        long r14 = java.lang.System.currentTimeMillis()
        r16 = 1000(0x3e8, double:4.94E-321)
        r18 = 0
        if (r0 <= 0) goto L_0x008e
        r20 = r10
        long r9 = (long) r0
        long r9 = r9 * r16
        goto L_0x009e
    L_0x008e:
        r20 = r10
        long r9 = r2.msgId
        int r11 = (r9 > r18 ? 1 : (r9 == r18 ? 0 : -1))
        if (r11 <= 0) goto L_0x009b
        if (r0 != 0) goto L_0x009b
        r9 = 30000(0x7530, double:1.4822E-319)
        goto L_0x009e
    L_0x009b:
        r9 = 259200000(0xf731400, double:1.280618154E-315)
    L_0x009e:
        int r0 = (r20 > r18 ? 1 : (r20 == r18 ? 0 : -1))
        if (r0 <= 0) goto L_0x00ad
        int r0 = (r12 > r18 ? 1 : (r12 == r18 ? 0 : -1))
        if (r0 <= 0) goto L_0x00ad
        long r11 = r20 - r12
        long r11 = r11 * r16
        long r11 = r11 + r14
        long r11 = r11 + r9
        goto L_0x00af
    L_0x00ad:
        long r11 = r14 + r9
    L_0x00af:
        java.lang.Long.signum(r20)
        long r9 = r20 * r16
        long r14 = r14 - r9
        java.lang.String r0 = "time_gap"
        r4.putExtra(r0, r14)
        java.lang.String r0 = "expire_time"
        r4.putExtra(r0, r11)
        java.lang.String r0 = "enKeySet"
        java.lang.String[] r5 = new java.lang.String[]{r5, r6}     // Catch:{ Exception -> 0x00cd }
        java.lang.String r5 = com.tencent.android.tpush.common.C6905e.m29468a(r5)     // Catch:{ Exception -> 0x00cd }
        r4.putExtra(r0, r5)     // Catch:{ Exception -> 0x00cd }
        goto L_0x00d3
    L_0x00cd:
        r0 = move-exception
        java.lang.String r5 = "distribute2SDK"
        com.tencent.android.tpush.p580b.C6864a.m29302d(r3, r5, r0)
    L_0x00d3:
        java.lang.String r0 = r26.mo33365d()
        long r5 = com.tencent.android.tpush.service.p595e.C7056i.m30195c(r0)
        java.lang.String r0 = "extra_host"
        r4.putExtra(r0, r5)
        int r0 = r26.mo33366e()
        java.lang.String r5 = "extra_port"
        r4.putExtra(r5, r0)
        boolean r0 = r26.mo33363b()
        byte r0 = com.tencent.android.tpush.service.C6982c.m29814a(r0)
        java.lang.String r5 = "extra_pact"
        r4.putExtra(r5, r0)
        java.lang.String r0 = "extra_push_time"
        r5 = r24
        r4.putExtra(r0, r5)
        long r5 = r2.multiPkg
        long r9 = r2.accessId
        java.util.ArrayList r0 = new java.util.ArrayList
        r0.<init>()
        int r11 = (r7 > r18 ? 1 : (r7 == r18 ? 0 : -1))
        if (r11 <= 0) goto L_0x0276
        android.content.Context r5 = com.tencent.android.tpush.service.C6973b.m29776f()
        long r12 = r2.msgId
        java.lang.Long r6 = java.lang.Long.valueOf(r12)
        boolean r5 = m29859a(r5, r7, r6)
        if (r5 == 0) goto L_0x0139
        java.lang.StringBuilder r0 = new java.lang.StringBuilder
        r0.<init>()
        java.lang.String r4 = "give up sended msg id "
        r0.append(r4)
        long r4 = r2.msgId
        r0.append(r4)
        java.lang.String r2 = "  channel "
        r0.append(r2)
        r0.append(r7)
        java.lang.String r0 = r0.toString()
        com.tencent.android.tpush.p580b.C6864a.m29308i(r3, r0)
        return
    L_0x0139:
        long r5 = r2.channelId
        java.lang.String r12 = "channel_id"
        r4.putExtra(r12, r5)
        java.lang.String r5 = r2.groupKey
        java.lang.String r6 = "group_keys"
        r4.putExtra(r6, r5)
        java.lang.String r5 = r2.groupKey
        boolean r5 = com.tencent.android.tpush.common.C6914l.m29521c(r5)
        if (r5 == 0) goto L_0x019d
        java.lang.StringBuilder r5 = new java.lang.StringBuilder
        r5.<init>()
        java.lang.String r6 = "push msg by channelId "
        r5.append(r6)
        r5.append(r7)
        java.lang.String r5 = r5.toString()
        com.tencent.android.tpush.p580b.C6864a.m29303e(r3, r5)
        android.content.Context r5 = com.tencent.android.tpush.service.C6973b.m29776f()
        java.lang.Long r6 = java.lang.Long.valueOf(r7)
        boolean r5 = com.tencent.android.tpush.service.p595e.C7056i.m30181a(r5, r6)
        if (r5 == 0) goto L_0x017e
        android.content.Context r5 = com.tencent.android.tpush.service.C6973b.m29776f()
        java.lang.String r5 = r5.getPackageName()
        r0.add(r5)
        goto L_0x0266
    L_0x017e:
        android.content.Context r0 = com.tencent.android.tpush.service.C6973b.m29776f()
        java.lang.Long r5 = java.lang.Long.valueOf(r7)
        java.util.List r0 = com.tencent.android.tpush.service.p595e.C7056i.m30189b(r0, r5)
        android.content.Context r5 = com.tencent.android.tpush.service.C6973b.m29776f()
        java.util.List r5 = com.tencent.android.tpush.service.p595e.C7056i.m30179a(r5, r0)
        if (r5 == 0) goto L_0x0266
        int r6 = r5.size()
        if (r6 <= 0) goto L_0x0266
    L_0x019a:
        r0 = r5
        goto L_0x0266
    L_0x019d:
        java.lang.StringBuilder r5 = new java.lang.StringBuilder
        r5.<init>()
        java.lang.String r6 = "push msg by groupkey "
        r5.append(r6)
        java.lang.String r6 = r2.groupKey
        r5.append(r6)
        java.lang.String r6 = "  channelId "
        r5.append(r6)
        r5.append(r7)
        java.lang.String r5 = r5.toString()
        com.tencent.android.tpush.p580b.C6864a.m29303e(r3, r5)
        java.util.concurrent.ConcurrentHashMap<java.lang.Long, java.util.Map<java.lang.String, java.util.List<java.lang.Long>>> r5 = f23211i
        java.lang.Long r6 = java.lang.Long.valueOf(r7)
        java.lang.Object r5 = r5.get(r6)
        java.util.Map r5 = (java.util.Map) r5
        if (r5 == 0) goto L_0x0261
        boolean r6 = r5.isEmpty()
        if (r6 != 0) goto L_0x0261
        java.lang.String r6 = r2.groupKey
        java.lang.Object r5 = r5.get(r6)
        java.util.List r5 = (java.util.List) r5
        java.lang.StringBuilder r6 = new java.lang.StringBuilder
        r6.<init>()
        java.lang.String r12 = "push msg by groupkey accessids "
        r6.append(r12)
        r6.append(r5)
        java.lang.String r6 = r6.toString()
        com.tencent.android.tpush.p580b.C6864a.m29303e(r3, r6)
        android.content.Context r6 = com.tencent.android.tpush.service.C6973b.m29776f()
        java.util.List r5 = com.tencent.android.tpush.service.p595e.C7056i.m30190b(r6, r5)
        java.lang.StringBuilder r6 = new java.lang.StringBuilder
        r6.<init>()
        java.lang.String r12 = "push msg by groupkey pkgsGroups "
        r6.append(r12)
        r6.append(r5)
        java.lang.String r6 = r6.toString()
        com.tencent.android.tpush.p580b.C6864a.m29303e(r3, r6)
        if (r5 == 0) goto L_0x0266
        boolean r6 = r5.isEmpty()
        if (r6 != 0) goto L_0x0266
        android.content.Context r0 = com.tencent.android.tpush.service.C6973b.m29776f()
        java.lang.Long r6 = java.lang.Long.valueOf(r7)
        java.util.List r0 = com.tencent.android.tpush.service.p595e.C7056i.m30189b(r0, r6)
        java.lang.StringBuilder r6 = new java.lang.StringBuilder
        r6.<init>()
        java.lang.String r12 = "push msg by groupkey channelPakgs "
        r6.append(r12)
        r6.append(r0)
        java.lang.String r6 = r6.toString()
        com.tencent.android.tpush.p580b.C6864a.m29303e(r3, r6)
        r0.retainAll(r5)
        android.content.Context r5 = com.tencent.android.tpush.service.C6973b.m29776f()
        java.lang.String r5 = r5.getPackageName()
        boolean r5 = r0.contains(r5)
        if (r5 == 0) goto L_0x024f
        r0.clear()
        android.content.Context r5 = com.tencent.android.tpush.service.C6973b.m29776f()
        java.lang.String r5 = r5.getPackageName()
        r0.add(r5)
        goto L_0x0266
    L_0x024f:
        android.content.Context r5 = com.tencent.android.tpush.service.C6973b.m29776f()
        java.util.List r5 = com.tencent.android.tpush.service.p595e.C7056i.m30179a(r5, r0)
        if (r5 == 0) goto L_0x0266
        int r6 = r5.size()
        if (r6 <= 0) goto L_0x0266
        goto L_0x019a
    L_0x0261:
        java.lang.String r5 = "the groupkey is null"
        com.tencent.android.tpush.p580b.C6864a.m29303e(r3, r5)
    L_0x0266:
        if (r0 == 0) goto L_0x026e
        boolean r5 = r0.isEmpty()
        if (r5 == 0) goto L_0x028f
    L_0x026e:
        android.content.Context r0 = com.tencent.android.tpush.service.C6973b.m29776f()
        r1.mo33339b(r0, r4)
        return
    L_0x0276:
        int r12 = (r5 > r18 ? 1 : (r5 == r18 ? 0 : -1))
        if (r12 != 0) goto L_0x0282
        java.lang.String r5 = r4.getPackage()
        r0.add(r5)
        goto L_0x028f
    L_0x0282:
        java.lang.String r5 = com.tencent.android.tpush.service.cache.CacheManager.findValidPackageByAccessid(r9)
        boolean r6 = com.tencent.android.tpush.service.p595e.C7056i.m30194b(r5)
        if (r6 != 0) goto L_0x028f
        r0.add(r5)
    L_0x028f:
        r5 = r0
        java.lang.StringBuilder r0 = new java.lang.StringBuilder
        r0.<init>()
        java.lang.String r6 = "distribute2SDK pkgs "
        r0.append(r6)
        int r6 = r5.size()
        r0.append(r6)
        java.lang.String r6 = " pkgs "
        r0.append(r6)
        r0.append(r5)
        java.lang.String r0 = r0.toString()
        com.tencent.android.tpush.p580b.C6864a.m29303e(r3, r0)
        r0 = 0
        r6 = 0
    L_0x02b2:
        int r0 = r5.size()
        if (r6 >= r0) goto L_0x03a8
        java.lang.Object r0 = r5.get(r6)     // Catch:{ Exception -> 0x039d }
        java.lang.String r0 = (java.lang.String) r0     // Catch:{ Exception -> 0x039d }
        java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x039d }
        r12.<init>()     // Catch:{ Exception -> 0x039d }
        java.lang.String r13 = "distribute2SDK pkgs msgid "
        r12.append(r13)     // Catch:{ Exception -> 0x039d }
        long r13 = r2.msgId     // Catch:{ Exception -> 0x039d }
        r12.append(r13)     // Catch:{ Exception -> 0x039d }
        java.lang.String r13 = "  pkg "
        r12.append(r13)     // Catch:{ Exception -> 0x039d }
        java.lang.String r13 = r2.appPkgName     // Catch:{ Exception -> 0x039d }
        r12.append(r13)     // Catch:{ Exception -> 0x039d }
        java.lang.String r12 = r12.toString()     // Catch:{ Exception -> 0x039d }
        com.tencent.android.tpush.p580b.C6864a.m29303e(r3, r12)     // Catch:{ Exception -> 0x039d }
        boolean r12 = com.tencent.android.tpush.service.p595e.C7056i.m30194b(r0)     // Catch:{ Exception -> 0x039d }
        if (r12 == 0) goto L_0x02ec
        java.lang.String r0 = ">> msg.appPkgName is null!"
        com.tencent.android.tpush.p580b.C6864a.m29298c(r3, r0)     // Catch:{ Exception -> 0x039d }
    L_0x02e9:
        r14 = 1
        goto L_0x03a4
    L_0x02ec:
        android.content.Context r12 = com.tencent.android.tpush.service.C6973b.m29776f()     // Catch:{ Exception -> 0x039d }
        com.tencent.android.tpush.a.a r12 = com.tencent.android.tpush.p579a.C6861a.m29264a(r12)     // Catch:{ Exception -> 0x039d }
        r12.mo32985a(r0)     // Catch:{ Exception -> 0x039d }
        android.content.Context r12 = com.tencent.android.tpush.service.C6973b.m29776f()     // Catch:{ Exception -> 0x039d }
        boolean r12 = com.tencent.android.tpush.service.p595e.C7056i.m30183a(r12, r0, r9)     // Catch:{ Exception -> 0x039d }
        if (r12 != 0) goto L_0x032d
        java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x039d }
        r12.<init>()     // Catch:{ Exception -> 0x039d }
        java.lang.String r13 = "dispatchMessageOnTime appPkgName "
        r12.append(r13)     // Catch:{ Exception -> 0x039d }
        r12.append(r0)     // Catch:{ Exception -> 0x039d }
        java.lang.String r13 = " is not installed."
        r12.append(r13)     // Catch:{ Exception -> 0x039d }
        java.lang.String r12 = r12.toString()     // Catch:{ Exception -> 0x039d }
        com.tencent.android.tpush.p580b.C6864a.m29303e(r3, r12)     // Catch:{ Exception -> 0x039d }
        com.tencent.android.tpush.service.c r12 = com.tencent.android.tpush.service.C6982c.m29815a()     // Catch:{ Exception -> 0x039d }
        r12.mo33317a(r0)     // Catch:{ Exception -> 0x039d }
        com.tencent.android.tpush.c.c r12 = com.tencent.android.tpush.p581c.C6871c.m29327a()     // Catch:{ Exception -> 0x039d }
        android.content.Context r13 = com.tencent.android.tpush.service.C6973b.m29776f()     // Catch:{ Exception -> 0x039d }
        r12.mo33025d(r13, r0)     // Catch:{ Exception -> 0x039d }
        goto L_0x02e9
    L_0x032d:
        com.tencent.android.tpush.data.RegisterEntity r12 = com.tencent.android.tpush.service.cache.CacheManager.getRegisterInfoByPkgName(r0)     // Catch:{ Exception -> 0x039d }
        if (r12 != 0) goto L_0x0359
        java.lang.StringBuilder r13 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x039d }
        r13.<init>()     // Catch:{ Exception -> 0x039d }
        java.lang.String r14 = "RegInfo is null "
        r13.append(r14)     // Catch:{ Exception -> 0x039d }
        r13.append(r0)     // Catch:{ Exception -> 0x039d }
        java.lang.String r13 = r13.toString()     // Catch:{ Exception -> 0x039d }
        com.tencent.android.tpush.p580b.C6864a.m29286a(r3, r13)     // Catch:{ Exception -> 0x039d }
        if (r11 <= 0) goto L_0x0352
        int r13 = r5.size()     // Catch:{ Exception -> 0x039d }
        r14 = 1
        int r13 = r13 - r14
        if (r6 == r13) goto L_0x035a
        goto L_0x03a4
    L_0x0352:
        r14 = 1
        java.lang.String r12 = r2.date     // Catch:{ Exception -> 0x039b }
        r1.mo33335a(r12, r4, r0)     // Catch:{ Exception -> 0x039b }
        goto L_0x03a4
    L_0x0359:
        r14 = 1
    L_0x035a:
        int r12 = r12.state     // Catch:{ Exception -> 0x039b }
        if (r12 <= 0) goto L_0x036a
        com.tencent.android.tpush.c.c r12 = com.tencent.android.tpush.p581c.C6871c.m29327a()     // Catch:{ Exception -> 0x039b }
        android.content.Context r13 = com.tencent.android.tpush.service.C6973b.m29776f()     // Catch:{ Exception -> 0x039b }
        r12.mo33025d(r13, r0)     // Catch:{ Exception -> 0x039b }
        goto L_0x03a4
    L_0x036a:
        r4.setPackage(r0)     // Catch:{ Exception -> 0x039b }
        r22.m29877e()     // Catch:{ Exception -> 0x039b }
        android.content.Context r12 = com.tencent.android.tpush.service.C6973b.m29776f()     // Catch:{ Exception -> 0x039b }
        java.lang.String r13 = r4.getPackage()     // Catch:{ Exception -> 0x039b }
        boolean r12 = com.tencent.android.tpush.C6860a.m29254a(r12, r13, r4)     // Catch:{ Exception -> 0x039b }
        if (r12 != 0) goto L_0x0384
        java.lang.String r12 = r2.date     // Catch:{ Exception -> 0x039b }
        r1.mo33335a(r12, r4, r0)     // Catch:{ Exception -> 0x039b }
        goto L_0x038b
    L_0x0384:
        android.content.Context r0 = com.tencent.android.tpush.service.C6973b.m29776f()     // Catch:{ Exception -> 0x039b }
        r1.mo33339b(r0, r4)     // Catch:{ Exception -> 0x039b }
    L_0x038b:
        if (r11 <= 0) goto L_0x03a4
        android.content.Context r0 = com.tencent.android.tpush.service.C6973b.m29776f()     // Catch:{ Exception -> 0x039b }
        long r12 = r2.msgId     // Catch:{ Exception -> 0x039b }
        java.lang.Long r12 = java.lang.Long.valueOf(r12)     // Catch:{ Exception -> 0x039b }
        m29864b(r0, r7, r12)     // Catch:{ Exception -> 0x039b }
        goto L_0x03a8
    L_0x039b:
        r0 = move-exception
        goto L_0x039f
    L_0x039d:
        r0 = move-exception
        r14 = 1
    L_0x039f:
        java.lang.String r12 = "dispatchMessageOnTime"
        com.tencent.android.tpush.p580b.C6864a.m29302d(r3, r12, r0)
    L_0x03a4:
        int r6 = r6 + 1
        goto L_0x02b2
    L_0x03a8:
        return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.android.tpush.service.p590c.C6987a.m29857a(com.tencent.android.tpush.service.channel.protocol.TpnsPushMsg, long, com.tencent.android.tpush.service.channel.a):void");
    }

    /* renamed from: a */
    public void mo33335a(String str, Intent intent, String str2) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
        boolean b = C7056i.m30194b(str);
        String str3 = Constants.RPC_SUFFIX;
        if (b || (!C7056i.m30194b(str) && simpleDateFormat.parse(str).compareTo(simpleDateFormat.parse(simpleDateFormat.format(new Date()))) == 0)) {
            if (C7056i.m30185a(intent)) {
                Context f = C6973b.m29776f();
                StringBuilder sb = new StringBuilder();
                sb.append(str2);
                sb.append(str3);
                List e = C7056i.m30206e(f, sb.toString());
                String str4 = Constants.ServiceLogTag;
                if (e == null || e.size() < 1) {
                    if (XGPushConfig.enableDebug) {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append(">> send message intent:");
                        sb2.append(intent);
                        C6864a.m29298c(str4, sb2.toString());
                    }
                    C6871c.m29327a().mo33010a(C6973b.m29776f(), str2, intent);
                } else {
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append(">> send rpc message intent:");
                    sb3.append(intent);
                    C6864a.m29298c(str4, sb3.toString());
                    mo33334a(intent);
                }
            }
            return;
        }
        if (!C7056i.m30194b(str) && simpleDateFormat.parse(str).compareTo(simpleDateFormat.parse(simpleDateFormat.format(new Date()))) < 0) {
            Context f2 = C6973b.m29776f();
            StringBuilder sb4 = new StringBuilder();
            sb4.append(str2);
            sb4.append(str3);
            List e2 = C7056i.m30206e(f2, sb4.toString());
            if (e2 == null || e2.size() < 1) {
                C6973b.m29776f().sendBroadcast(intent);
            } else {
                mo33334a(intent);
            }
        }
    }

    /* renamed from: a */
    public void mo33334a(final Intent intent) {
        C6901c.m29459a().mo33104a((Runnable) new Runnable() {
            /* access modifiers changed from: private */
            /* renamed from: c */
            public C6949a f23229c;
            /* access modifiers changed from: private */
            /* renamed from: d */
            public C6955c f23230d = new C6955c();
            /* access modifiers changed from: private */
            /* renamed from: e */
            public ServiceConnection f23231e = new ServiceConnection() {
                public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                    try {
                        C69935.this.f23229c = C6950a.m29679a(iBinder);
                        if (C69935.this.f23229c != null) {
                            C69935.this.f23229c.mo33242a(intent.toURI(), C69935.this.f23230d);
                        }
                    } catch (Throwable th) {
                        C6864a.m29302d("SrvMessageManager", "SendBroadcastByRPC", th);
                    }
                }

                public void onServiceDisconnected(ComponentName componentName) {
                    C69935.this.f23231e = null;
                    C69935.this.f23229c = null;
                    C69935.this.f23230d = null;
                }
            };

            public void run() {
                String str = "SrvMessageManager";
                try {
                    Intent intent = intent;
                    StringBuilder sb = new StringBuilder();
                    sb.append(intent.getPackage());
                    sb.append(Constants.RPC_SUFFIX);
                    intent.setAction(sb.toString());
                    this.f23230d.mo33251a(this.f23231e);
                    boolean bindService = C6973b.m29776f().bindService(intent, this.f23231e, 1);
                    String str2 = MessageKey.MSG_ID;
                    if (!bindService) {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("Failed Send AIDL");
                        sb2.append(intent);
                        sb2.append(" failed  msgid = ");
                        sb2.append(intent.getLongExtra(str2, -1));
                        C6864a.m29308i(str, sb2.toString());
                        C6871c.m29327a().mo33010a(C6973b.m29776f(), intent.getPackage(), intent);
                        return;
                    }
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("Succeed Send AIDL");
                    sb3.append(intent);
                    sb3.append(" success  msgid = ");
                    sb3.append(intent.getLongExtra(str2, -1));
                    C6864a.m29298c(str, sb3.toString());
                    C6987a.this.mo33339b(C6973b.m29776f(), intent);
                } catch (Throwable th) {
                    C6864a.m29302d(str, "SendBroadcastByRPC -> bindService", th);
                    C6871c.m29327a().mo33010a(C6973b.m29776f(), intent.getPackage(), intent);
                }
            }
        });
    }

    /* renamed from: a */
    public void mo33336a(ArrayList<TpnsPushMsg> arrayList, long j, C7000a aVar) {
        mo33343b(arrayList, j, aVar);
    }

    /* renamed from: b */
    public void mo33343b(ArrayList<TpnsPushMsg> arrayList, long j, C7000a aVar) {
        String str;
        ArrayList<TpnsPushMsg> arrayList2 = arrayList;
        if (!(C6973b.m29776f() == null || arrayList2 == null || arrayList.size() <= 0)) {
            int i = 0;
            C6864a.m29292b(0, (List<TpnsPushMsg>) arrayList2);
            while (true) {
                str = "SrvMessageManager";
                if (i >= arrayList.size()) {
                    break;
                }
                StringBuilder sb = new StringBuilder();
                sb.append("receive msg from service msgId = ");
                sb.append(((TpnsPushMsg) arrayList2.get(i)).msgId);
                sb.append(" pkg = ");
                sb.append(((TpnsPushMsg) arrayList2.get(i)).appPkgName);
                sb.append(" size = ");
                sb.append(arrayList.size());
                C6864a.m29286a(str, sb.toString());
                i++;
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                TpnsPushMsg tpnsPushMsg = (TpnsPushMsg) it.next();
                StringBuilder sb2 = new StringBuilder();
                sb2.append("distributeFromServer : accid=");
                sb2.append(tpnsPushMsg.accessId);
                sb2.append(" ,channelId=");
                sb2.append(tpnsPushMsg.channelId);
                sb2.append(",busiId=");
                sb2.append(tpnsPushMsg.busiMsgId);
                sb2.append(",pkg=");
                sb2.append(tpnsPushMsg.appPkgName);
                sb2.append(",msgId=");
                sb2.append(tpnsPushMsg.msgId);
                sb2.append(",type=");
                sb2.append(tpnsPushMsg.type);
                sb2.append(",ts=");
                sb2.append(tpnsPushMsg.timestamp);
                sb2.append(",multi=");
                sb2.append(tpnsPushMsg.multiPkg);
                sb2.append(",date=");
                sb2.append(tpnsPushMsg.date);
                sb2.append(",serverTime=");
                sb2.append(tpnsPushMsg.serverTime);
                sb2.append(",ttl=");
                sb2.append(tpnsPushMsg.ttl);
                sb2.append(", size = ");
                sb2.append(arrayList.size());
                C6864a.m29298c(str, sb2.toString());
                mo33328a(C6973b.m29776f(), tpnsPushMsg, j, aVar);
                if (tpnsPushMsg.type == 3) {
                    try {
                        if (tpnsPushMsg.getContent() != null) {
                            m29858a(tpnsPushMsg.getContent());
                        } else {
                            return;
                        }
                    } catch (Throwable unused) {
                    }
                } else if (C7056i.m30194b(tpnsPushMsg.appPkgName) && tpnsPushMsg.multiPkg == 0 && tpnsPushMsg.channelId <= 0) {
                    C6864a.m29298c(str, ">> messageDistribute, msg.appPkgName is null!");
                } else if (tpnsPushMsg.accessId == XGPushConfig.getAccessId(C6973b.m29776f()) || System.currentTimeMillis() - XGPushServiceV4.f23078a >= 10000) {
                    m29857a(tpnsPushMsg, j, aVar);
                } else {
                    long nextInt = (long) (new Random().nextInt(BaseImageDownloader.DEFAULT_HTTP_CONNECT_TIMEOUT) + BaseImageDownloader.DEFAULT_HTTP_CONNECT_TIMEOUT);
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append(">> messageDistribute, delay ");
                    sb3.append(nextInt);
                    sb3.append("ms send to app, msgid:");
                    sb3.append(tpnsPushMsg.msgId);
                    sb3.append(", accessid:");
                    sb3.append(tpnsPushMsg.accessId);
                    C6864a.m29298c(str, sb3.toString());
                    C6901c a = C6901c.m29459a();
                    final TpnsPushMsg tpnsPushMsg2 = tpnsPushMsg;
                    final long j2 = j;
                    final C7000a aVar2 = aVar;
                    C69956 r0 = new Runnable() {
                        public void run() {
                            C6987a.this.m29857a(tpnsPushMsg2, j2, aVar2);
                        }
                    };
                    a.mo33106a(r0, nextInt);
                }
                long j3 = j;
                C7000a aVar3 = aVar;
            }
        }
        C7046a.m30127a(arrayList);
    }

    /* renamed from: a */
    private synchronized void m29858a(String str) {
        if (!C6914l.m29521c(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str).getJSONObject("custom_content");
                JSONArray jSONArray = jSONObject.getJSONArray("config");
                int i = jSONObject.getInt(AppEntity.KEY_VERSION_STR);
                int i2 = 0;
                if (jSONArray != null && jSONArray.length() > 0) {
                    int i3 = 0;
                    while (i2 < jSONArray.length()) {
                        boolean a = m29860a(jSONArray.getJSONObject(i2));
                        if (a) {
                            i3 = a;
                        }
                        i2++;
                    }
                    i2 = i3;
                }
                if (i2 != 0) {
                    JSONArray b = m29863b();
                    C6908h.m29485b(C6973b.m29776f(), "GroupKeysConfigVersion", i);
                    C6908h.m29487b(C6973b.m29776f(), "ChannelGroupKeysConfig", b.toString());
                }
            } catch (Throwable th) {
                C6864a.m29302d("SrvMessageManager", "handleGroupKeysConfig", th);
            }
        } else {
            return;
        }
        return;
    }

    /* renamed from: b */
    private static JSONArray m29863b() {
        JSONArray jSONArray = new JSONArray();
        for (Entry entry : f23211i.entrySet()) {
            JSONObject jSONObject = new JSONObject();
            PrintStream printStream = System.out;
            StringBuilder sb = new StringBuilder();
            sb.append("Key = ");
            sb.append(entry.getKey());
            printStream.println(sb.toString());
            Map map = (Map) entry.getValue();
            JSONArray jSONArray2 = new JSONArray();
            for (Entry entry2 : map.entrySet()) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put((String) entry2.getKey(), new JSONArray((Collection) entry2.getValue()));
                jSONArray2.put(jSONObject2);
            }
            jSONObject.put(((Long) entry.getKey()).toString(), jSONArray2);
            jSONArray.put(jSONObject);
        }
        return jSONArray;
    }

    /* renamed from: c */
    private static synchronized void m29869c() {
        synchronized (C6987a.class) {
            try {
                if (f23211i == null) {
                    f23211i = new ConcurrentHashMap<>();
                    String a = C6908h.m29483a(C6973b.m29776f(), "ChannelGroupKeysConfig", (String) null);
                    if (!C6914l.m29521c(a)) {
                        JSONArray jSONArray = new JSONArray(a);
                        if (jSONArray.length() > 0) {
                            for (int i = 0; i < jSONArray.length(); i++) {
                                JSONObject jSONObject = jSONArray.getJSONObject(i);
                                Iterator keys = jSONObject.keys();
                                while (keys.hasNext()) {
                                    String str = (String) keys.next();
                                    Long valueOf = Long.valueOf(str);
                                    JSONArray jSONArray2 = jSONObject.getJSONArray(str);
                                    if (jSONArray2 != null && jSONArray2.length() > 0) {
                                        HashMap hashMap = new HashMap();
                                        for (int i2 = 0; i2 < jSONArray2.length(); i2++) {
                                            JSONObject jSONObject2 = jSONArray2.getJSONObject(i2);
                                            Iterator keys2 = jSONObject2.keys();
                                            while (keys2.hasNext()) {
                                                String str2 = (String) keys2.next();
                                                hashMap.put(str2, m29849a(jSONObject2.getJSONArray(str2)));
                                            }
                                        }
                                        f23211i.put(valueOf, hashMap);
                                    }
                                }
                            }
                        }
                    }
                }
            } catch (Throwable th) {
                C6864a.m29302d("SrvMessageManager", "initChanellGroupKey", th);
            }
        }
        return;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:43:0x00b7, code lost:
            return r1;
     */
    /* renamed from: a */
    private synchronized boolean m29860a(org.json.JSONObject r11) {
        /*
        r10 = this;
        monitor-enter(r10)
        java.lang.String r0 = "channelId"
        long r0 = r11.getLong(r0)     // Catch:{ all -> 0x00b8 }
        java.lang.Long r0 = java.lang.Long.valueOf(r0)     // Catch:{ all -> 0x00b8 }
        long r1 = r0.longValue()     // Catch:{ all -> 0x00b8 }
        r3 = 0
        r5 = 0
        int r6 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
        if (r6 > 0) goto L_0x0018
        monitor-exit(r10)
        return r5
    L_0x0018:
        java.lang.String r1 = "infos"
        org.json.JSONArray r11 = r11.getJSONArray(r1)     // Catch:{ all -> 0x00b8 }
        if (r11 == 0) goto L_0x00b5
        int r1 = r11.length()     // Catch:{ all -> 0x00b8 }
        if (r1 <= 0) goto L_0x00b5
        java.util.concurrent.ConcurrentHashMap<java.lang.Long, java.util.Map<java.lang.String, java.util.List<java.lang.Long>>> r1 = f23211i     // Catch:{ all -> 0x00b8 }
        boolean r1 = r1.containsKey(r0)     // Catch:{ all -> 0x00b8 }
        if (r1 != 0) goto L_0x0038
        java.util.HashMap r1 = new java.util.HashMap     // Catch:{ all -> 0x00b8 }
        r1.<init>()     // Catch:{ all -> 0x00b8 }
        java.util.concurrent.ConcurrentHashMap<java.lang.Long, java.util.Map<java.lang.String, java.util.List<java.lang.Long>>> r2 = f23211i     // Catch:{ all -> 0x00b8 }
        r2.put(r0, r1)     // Catch:{ all -> 0x00b8 }
    L_0x0038:
        r1 = 0
    L_0x0039:
        int r2 = r11.length()     // Catch:{ all -> 0x00b8 }
        if (r5 >= r2) goto L_0x00b6
        java.util.concurrent.ConcurrentHashMap<java.lang.Long, java.util.Map<java.lang.String, java.util.List<java.lang.Long>>> r2 = f23211i     // Catch:{ all -> 0x00b8 }
        java.lang.Object r2 = r2.get(r0)     // Catch:{ all -> 0x00b8 }
        java.util.Map r2 = (java.util.Map) r2     // Catch:{ all -> 0x00b8 }
        org.json.JSONObject r3 = r11.getJSONObject(r5)     // Catch:{ all -> 0x00b8 }
        java.lang.String r4 = "groupKey"
        java.lang.String r4 = r3.getString(r4)     // Catch:{ all -> 0x00b8 }
        java.lang.String r6 = "op"
        int r6 = r3.getInt(r6)     // Catch:{ all -> 0x00b8 }
        java.lang.String r7 = "apps"
        org.json.JSONArray r3 = r3.getJSONArray(r7)     // Catch:{ all -> 0x00b8 }
        if (r3 == 0) goto L_0x00ad
        int r7 = r3.length()     // Catch:{ all -> 0x00b8 }
        if (r7 <= 0) goto L_0x00ad
        boolean r7 = r2.containsKey(r4)     // Catch:{ all -> 0x00b8 }
        if (r7 != 0) goto L_0x0073
        java.util.ArrayList r7 = new java.util.ArrayList     // Catch:{ all -> 0x00b8 }
        r7.<init>()     // Catch:{ all -> 0x00b8 }
        r2.put(r4, r7)     // Catch:{ all -> 0x00b8 }
    L_0x0073:
        java.lang.Object r7 = r2.get(r4)     // Catch:{ all -> 0x00b8 }
        java.util.List r7 = (java.util.List) r7     // Catch:{ all -> 0x00b8 }
        java.util.List r3 = m29849a(r3)     // Catch:{ all -> 0x00b8 }
        r8 = 1
        if (r6 != r8) goto L_0x0083
        r7 = r3
    L_0x0081:
        r1 = 1
        goto L_0x00aa
    L_0x0083:
        r9 = 2
        if (r6 != r9) goto L_0x008d
        r3.remove(r7)     // Catch:{ all -> 0x00b8 }
        r7.addAll(r3)     // Catch:{ all -> 0x00b8 }
        goto L_0x0081
    L_0x008d:
        r9 = 3
        if (r6 != r9) goto L_0x0094
        r7.removeAll(r3)     // Catch:{ all -> 0x00b8 }
        goto L_0x0081
    L_0x0094:
        java.lang.String r3 = "SrvMessageManager"
        java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ all -> 0x00b8 }
        r8.<init>()     // Catch:{ all -> 0x00b8 }
        java.lang.String r9 = "error op type "
        r8.append(r9)     // Catch:{ all -> 0x00b8 }
        r8.append(r6)     // Catch:{ all -> 0x00b8 }
        java.lang.String r6 = r8.toString()     // Catch:{ all -> 0x00b8 }
        com.tencent.android.tpush.p580b.C6864a.m29308i(r3, r6)     // Catch:{ all -> 0x00b8 }
    L_0x00aa:
        r2.put(r4, r7)     // Catch:{ all -> 0x00b8 }
    L_0x00ad:
        java.util.concurrent.ConcurrentHashMap<java.lang.Long, java.util.Map<java.lang.String, java.util.List<java.lang.Long>>> r3 = f23211i     // Catch:{ all -> 0x00b8 }
        r3.put(r0, r2)     // Catch:{ all -> 0x00b8 }
        int r5 = r5 + 1
        goto L_0x0039
    L_0x00b5:
        r1 = 0
    L_0x00b6:
        monitor-exit(r10)
        return r1
    L_0x00b8:
        r11 = move-exception
        monitor-exit(r10)
        throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.android.tpush.service.p590c.C6987a.m29860a(org.json.JSONObject):boolean");
    }

    /* renamed from: a */
    private static List<Long> m29849a(JSONArray jSONArray) {
        ArrayList arrayList = new ArrayList();
        if (jSONArray != null) {
            for (int i = 0; i < jSONArray.length(); i++) {
                arrayList.add(Long.valueOf(jSONArray.getLong(i)));
            }
        }
        return arrayList;
    }

    /* access modifiers changed from: private|declared_synchronized */
    /* renamed from: d */
    public synchronized void m29874d() {
        if (C7005b.m29964a().mo33391b(true) > 0) {
            m29877e();
        }
    }

    /* renamed from: e */
    private void m29877e() {
        if (this.f23212j == null) {
            String str = "com.tencent.android.tpush.service.channel.cacheMsgBeatIntent";
            C6973b.m29776f().registerReceiver(new BroadcastReceiver() {
                public void onReceive(Context context, Intent intent) {
                    C6987a.m29846a().m29874d();
                }
            }, new IntentFilter(str));
            this.f23212j = PendingIntent.getBroadcast(C6973b.m29776f(), 0, new Intent(str), 134217728);
        }
        if (XGPushConfig.isForeignWeakAlarmMode(C6973b.m29776f())) {
            StringBuilder sb = new StringBuilder();
            sb.append("scheduleCacheMsgBeat WaekAlarmMode heartbeatinterval: ");
            sb.append(C7005b.f23280o);
            sb.append(" ms");
            C6864a.m29305f("SrvMessageManager", sb.toString());
            f23203a = (long) C7005b.f23280o;
        }
        C7045d.m30117a().mo34149a(0, System.currentTimeMillis() + f23203a, this.f23212j);
    }

    /* renamed from: a */
    private void m29851a(Context context, String str, String str2, ArrayList<?> arrayList) {
        try {
            if (arrayList.size() > 50) {
                arrayList.subList(0, 10).clear();
            }
            String encrypt = Rijndael.encrypt(C6905e.m29468a((Serializable) arrayList));
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append(str2);
            C7053f.m30155a(context, sb.toString(), encrypt);
        } catch (Exception e) {
            C6864a.m29302d("SrvMessageManager", "putSettings", e);
        }
    }

    /* renamed from: a */
    private Object m29847a(Context context, String str, String str2) {
        try {
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append(str2);
            return C6905e.m29467a(Rijndael.decrypt(C7053f.m30151a(context, sb.toString())));
        } catch (Exception e) {
            C6864a.m29302d("SrvMessageManager", "getSettings", e);
            return null;
        }
    }
}
