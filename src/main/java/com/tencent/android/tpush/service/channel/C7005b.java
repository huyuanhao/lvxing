package com.tencent.android.tpush.service.channel;

import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Message;
import com.p522qq.taf.jce.JceStruct;
import com.tencent.android.tpush.C6860a;
import com.tencent.android.tpush.XGPushConfig;
import com.tencent.android.tpush.common.C6901c;
import com.tencent.android.tpush.common.Constants;
import com.tencent.android.tpush.common.MessageKey;
import com.tencent.android.tpush.common.ReturnCode;
import com.tencent.android.tpush.data.CachedMessageIntent;
import com.tencent.android.tpush.data.RegisterEntity;
import com.tencent.android.tpush.encrypt.Rijndael;
import com.tencent.android.tpush.horse.C6938d;
import com.tencent.android.tpush.horse.C6938d.C6942a;
import com.tencent.android.tpush.horse.C6938d.C6943b;
import com.tencent.android.tpush.horse.data.StrategyItem;
import com.tencent.android.tpush.p580b.C6864a;
import com.tencent.android.tpush.p581c.C6871c;
import com.tencent.android.tpush.service.C6973b;
import com.tencent.android.tpush.service.C6982c;
import com.tencent.android.tpush.service.C7045d;
import com.tencent.android.tpush.service.C7059f;
import com.tencent.android.tpush.service.XGPushServiceV4;
import com.tencent.android.tpush.service.cache.CacheManager;
import com.tencent.android.tpush.service.channel.C7030c.C7031a;
import com.tencent.android.tpush.service.channel.exception.ChannelException;
import com.tencent.android.tpush.service.channel.p591a.C7001a;
import com.tencent.android.tpush.service.channel.p591a.C7001a.C7002a;
import com.tencent.android.tpush.service.channel.p591a.C7003b;
import com.tencent.android.tpush.service.channel.p591a.C7004c;
import com.tencent.android.tpush.service.channel.p592b.C7028h;
import com.tencent.android.tpush.service.channel.p592b.C7029i;
import com.tencent.android.tpush.service.channel.p593c.C7035b;
import com.tencent.android.tpush.service.channel.protocol.TpnsPushVerifyReq;
import com.tencent.android.tpush.service.channel.protocol.TpnsReconnectReq;
import com.tencent.android.tpush.service.p588a.C6971a;
import com.tencent.android.tpush.service.p589b.C6979b;
import com.tencent.android.tpush.service.p590c.C6987a;
import com.tencent.android.tpush.service.p594d.C7046a;
import com.tencent.android.tpush.service.p595e.C7048a;
import com.tencent.android.tpush.service.p595e.C7055h;
import com.tencent.android.tpush.service.p595e.C7056i;
import com.tencent.bigdata.dataacquisition.CustomDeviceInfos;
import com.tencent.bigdata.dataacquisition.DeviceInfos;
import com.tencent.mid.sotrage.StorageInterface;
import java.nio.channels.SocketChannel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: ProGuard */
/* renamed from: com.tencent.android.tpush.service.channel.b */
public final class C7005b implements C6943b, C7002a {
    /* renamed from: D */
    private static volatile long f23262D = 0;
    /* renamed from: E */
    private static volatile long f23263E = 0;
    /* renamed from: F */
    private static volatile long f23264F = 0;
    /* access modifiers changed from: private|static */
    /* renamed from: G */
    public static String f23265G = "";
    /* renamed from: a */
    public static int f23266a = 0;
    /* renamed from: b */
    public static int f23267b = 0;
    /* renamed from: c */
    public static int f23268c = 0;
    /* renamed from: d */
    public static long f23269d = 0;
    /* renamed from: e */
    public static int f23270e = 0;
    /* renamed from: f */
    public static int f23271f = 0;
    /* renamed from: g */
    public static JSONArray f23272g = null;
    /* renamed from: h */
    public static JSONArray f23273h = null;
    /* renamed from: i */
    public static int f23274i = 0;
    /* renamed from: j */
    public static int f23275j = 0;
    /* renamed from: k */
    public static int f23276k = 290000;
    /* renamed from: l */
    public static int f23277l = 180000;
    /* renamed from: m */
    public static int f23278m = 300000;
    /* renamed from: n */
    public static int f23279n = f23276k;
    /* renamed from: o */
    public static int f23280o = 3600000;
    /* renamed from: p */
    public static int f23281p = 1800000;
    /* renamed from: q */
    public static int f23282q = f23277l;
    /* renamed from: r */
    protected static int f23283r;
    /* renamed from: s */
    protected static Boolean f23284s;
    /* renamed from: A */
    private PendingIntent f23285A;
    /* access modifiers changed from: private */
    /* renamed from: B */
    public C7030c f23286B;
    /* access modifiers changed from: private|volatile */
    /* renamed from: C */
    public volatile boolean f23287C;
    /* renamed from: H */
    private C6942a f23288H;
    /* renamed from: I */
    private Handler f23289I;
    /* access modifiers changed from: private */
    /* renamed from: J */
    public C7031a f23290J;
    /* access modifiers changed from: private */
    /* renamed from: K */
    public long f23291K;
    /* renamed from: L */
    private C7015b f23292L;
    /* access modifiers changed from: private */
    /* renamed from: t */
    public Handler f23293t;
    /* access modifiers changed from: private */
    /* renamed from: u */
    public ArrayList<C7030c> f23294u;
    /* access modifiers changed from: private */
    /* renamed from: v */
    public Map<C7001a, ConcurrentHashMap<Integer, C7030c>> f23295v;
    /* access modifiers changed from: private */
    /* renamed from: w */
    public Map<C7030c, C7019f> f23296w;
    /* access modifiers changed from: private */
    /* renamed from: x */
    public C7001a f23297x;
    /* access modifiers changed from: private|volatile */
    /* renamed from: y */
    public volatile boolean f23298y;
    /* renamed from: z */
    private PendingIntent f23299z;

    /* compiled from: ProGuard */
    /* renamed from: com.tencent.android.tpush.service.channel.b$a */
    private class C7014a implements Runnable {
        /* renamed from: b */
        private C7001a f23311b = null;
        /* renamed from: c */
        private C7029i f23312c = null;

        public C7014a(C7001a aVar, C7029i iVar) {
            this.f23311b = aVar;
            this.f23312c = iVar;
        }

        public void run() {
            String str = "TpnsChannel";
            try {
                long currentTimeMillis = System.currentTimeMillis() - C7005b.this.f23286B.f23369c;
                C7000a f = this.f23311b.mo33376f();
                f.mo33362a(3, Long.valueOf(currentTimeMillis));
                C7031a aVar = C7005b.this.f23286B.f23372f;
                if (aVar == null) {
                    C6864a.m29308i(str, ">> messageHandler is null");
                    C7005b.this.f23290J.mo33269a(C7005b.this.f23286B.f23371e, this.f23312c.mo33451l(), null, f);
                    return;
                }
                C7005b.this.f23293t.removeCallbacks((C7019f) C7005b.this.f23296w.remove(C7005b.this.f23286B));
                aVar.mo33269a(C7005b.this.f23286B.f23371e, this.f23312c.mo33451l(), null, f);
            } catch (Throwable th) {
                C6864a.m29302d(str, "", th);
            }
        }
    }

    /* compiled from: ProGuard */
    /* renamed from: com.tencent.android.tpush.service.channel.b$b */
    private class C7015b extends BroadcastReceiver {
        private C7015b() {
        }

        public void onReceive(Context context, Intent intent) {
            long currentTimeMillis = System.currentTimeMillis();
            if (C7005b.this.f23291K == 0 || currentTimeMillis - C7005b.this.f23291K > 20000) {
                C7005b.m29964a().m29984l();
                C7005b.this.f23291K = currentTimeMillis;
                return;
            }
            C6864a.m29303e("TpnsChannel", "give up heartbeatSlave ");
        }
    }

    /* compiled from: ProGuard */
    /* renamed from: com.tencent.android.tpush.service.channel.b$c */
    private class C7016c implements Runnable {
        /* renamed from: b */
        private C7001a f23315b = null;
        /* renamed from: c */
        private C7029i f23316c = null;

        public C7016c(C7001a aVar, C7029i iVar) {
            this.f23315b = aVar;
            this.f23316c = iVar;
        }

        public void run() {
            try {
                C6982c.m29815a().mo33316a(C7035b.m30082a(this.f23316c.mo33447h(), this.f23316c.mo33450k()), this.f23315b.mo33376f());
            } catch (Throwable th) {
                C6864a.m29302d("TpnsChannel", "run", th);
            }
        }
    }

    /* compiled from: ProGuard */
    /* renamed from: com.tencent.android.tpush.service.channel.b$d */
    private class C7017d implements Runnable {
        /* renamed from: b */
        private C7001a f23318b = null;
        /* renamed from: c */
        private ChannelException f23319c = null;
        /* renamed from: d */
        private boolean f23320d = false;

        public C7017d(C7001a aVar, ChannelException channelException, boolean z) {
            this.f23318b = aVar;
            this.f23319c = channelException;
            this.f23320d = z;
        }

        public void run() {
            if (this.f23318b == null) {
                C6864a.m29308i("TpnsChannel", "@@RequestFailRunnable currentClient == null");
                return;
            }
            long currentTimeMillis = System.currentTimeMillis();
            C7000a f = this.f23318b.mo33376f();
            int i = this.f23319c.errorCode;
            boolean z = this.f23320d && (i == ReturnCode.CODE_NETWORK_UNKNOWN_EXCEPTION.getType() || i == ReturnCode.CODE_NETWORK_UNEXPECTED_DATA_EXCEPTION_OCCUR.getType());
            ConcurrentHashMap concurrentHashMap = (ConcurrentHashMap) C7005b.this.f23295v.get(this.f23318b);
            if (concurrentHashMap != null) {
                for (Entry value : concurrentHashMap.entrySet()) {
                    C7030c cVar = (C7030c) value.getValue();
                    C7031a aVar = cVar.f23372f;
                    if (aVar != null) {
                        if (!z || cVar.f23367a >= 5) {
                            f.mo33362a(3, Long.valueOf(currentTimeMillis - cVar.f23369c));
                            C7005b.this.f23293t.removeCallbacks((C7019f) C7005b.this.f23296w.remove(cVar));
                            aVar.mo33271a(cVar.f23371e, this.f23319c, f);
                        } else if (cVar.mo33456b()) {
                            C7005b.this.m29969a(cVar);
                        }
                    }
                }
                concurrentHashMap.clear();
            }
            if (!this.f23318b.mo33375e()) {
                ArrayList arrayList = new ArrayList();
                synchronized (C7005b.this) {
                    Iterator it = C7005b.this.f23294u.iterator();
                    while (it.hasNext()) {
                        C7030c cVar2 = (C7030c) it.next();
                        C7031a aVar2 = cVar2.f23372f;
                        if (aVar2 != null) {
                            if (!z || cVar2.f23367a >= 5) {
                                f.mo33362a(3, Long.valueOf(currentTimeMillis - cVar2.f23369c));
                                C7005b.this.f23293t.removeCallbacks((C7019f) C7005b.this.f23296w.get(cVar2));
                                aVar2.mo33271a(cVar2.f23371e, this.f23319c, f);
                                arrayList.add(cVar2);
                            } else {
                                cVar2.f23367a++;
                            }
                        }
                    }
                    if (z) {
                        C7005b.this.f23294u.removeAll(arrayList);
                    } else {
                        C7005b.this.f23294u.clear();
                    }
                }
            }
            C7005b.f23266a = 0;
            if (C7005b.f23279n > C7005b.f23277l) {
                C7005b.f23279n = (C7005b.f23279n / 10) * 9;
            } else {
                C7005b.f23279n = C7005b.f23277l;
            }
            C7005b.this.mo33393c();
            if (!C7005b.this.f23294u.isEmpty()) {
                C7005b.this.mo33395e();
            }
            if (this.f23320d) {
                C7005b.this.mo33396f();
            }
        }
    }

    /* compiled from: ProGuard */
    /* renamed from: com.tencent.android.tpush.service.channel.b$e */
    private class C7018e implements Runnable {
        /* renamed from: b */
        private C7001a f23322b = null;
        /* renamed from: c */
        private C7029i f23323c = null;

        public C7018e(C7001a aVar, C7029i iVar) {
            this.f23322b = aVar;
            this.f23323c = iVar;
        }

        public void run() {
            ConcurrentHashMap concurrentHashMap = (ConcurrentHashMap) C7005b.this.f23295v.get(this.f23322b);
            if (concurrentHashMap != null) {
                C7030c cVar = (C7030c) concurrentHashMap.get(Integer.valueOf(this.f23323c.mo33448i()));
                String str = "";
                String str2 = "TpnsChannel";
                if (cVar == null) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(">> NetCallBackRunnable >>> 请求已被回调过，响应对应的request不存在。");
                    sb.append(this.f23323c);
                    C6864a.m29308i(str2, sb.toString());
                    try {
                        JceStruct a = C7035b.m30082a(this.f23323c.mo33447h(), this.f23323c.mo33450k());
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("onRequestSuccRunnable unhandle message type");
                        sb2.append(a.getClass().getName());
                        C6864a.m29308i(str2, sb2.toString());
                    } catch (Exception e) {
                        C6864a.m29302d(str2, str, e);
                    }
                    return;
                }
                C7005b.this.f23293t.removeCallbacks((C7019f) C7005b.this.f23296w.remove(cVar));
                concurrentHashMap.remove(Integer.valueOf(this.f23323c.mo33448i()));
                C7031a aVar = cVar.f23372f;
                if (aVar == null) {
                    C6864a.m29308i(Constants.ServiceLogTag, ">> messageHandler is null");
                    return;
                }
                long currentTimeMillis = System.currentTimeMillis() - cVar.f23369c;
                C7000a f = this.f23322b.mo33376f();
                f.mo33362a(3, Long.valueOf(currentTimeMillis));
                try {
                    aVar.mo33269a(cVar.f23371e, this.f23323c.mo33451l(), C7035b.m30082a(this.f23323c.mo33447h(), this.f23323c.mo33450k()), f);
                } catch (Exception e2) {
                    C6864a.m29302d(str2, str, e2);
                }
            }
        }
    }

    /* compiled from: ProGuard */
    /* renamed from: com.tencent.android.tpush.service.channel.b$f */
    private class C7019f implements Runnable {
        private C7019f() {
        }

        public void run() {
            long j;
            Object obj;
            boolean z;
            try {
                long currentTimeMillis = System.currentTimeMillis();
                long j2 = Long.MAX_VALUE;
                long j3 = (long) C6971a.m29749a(C6973b.m29776f()).f23147f;
                boolean z2 = false;
                if (j3 < 15000) {
                    j3 = 15000;
                }
                ChannelException channelException = new ChannelException(ReturnCode.CODE_NETWORK_TIMEOUT_WAITING_FOR_RESPONSE.getType(), "TpnsMessage wait for response timeout!");
                for (C7001a aVar : C7005b.this.f23295v.keySet()) {
                    ConcurrentHashMap concurrentHashMap = (ConcurrentHashMap) C7005b.this.f23295v.get(aVar);
                    if (!(concurrentHashMap == null || concurrentHashMap.size() == 0)) {
                        Iterator it = concurrentHashMap.entrySet().iterator();
                        C7000a f = aVar.mo33376f();
                        while (it.hasNext()) {
                            C7030c cVar = (C7030c) ((Entry) it.next()).getValue();
                            if (cVar != null) {
                                long j4 = currentTimeMillis - cVar.f23369c;
                                z = z2;
                                f.mo33362a(3, Long.valueOf(j4));
                                if (j4 >= 0) {
                                    if (j4 > j3) {
                                        C7031a aVar2 = cVar.f23372f;
                                        if (aVar2 != null) {
                                            aVar2.mo33271a(cVar.f23371e, channelException, f);
                                            cVar.f23372f = null;
                                        }
                                        it.remove();
                                        z = true;
                                    } else {
                                        long j5 = j3 - j4;
                                        if (j5 < j) {
                                            j = j5;
                                        }
                                    }
                                }
                            } else {
                                z = z2;
                                it.remove();
                            }
                            z2 = z;
                        }
                        boolean z3 = z2;
                    }
                }
                ChannelException channelException2 = new ChannelException(ReturnCode.CODE_NETWORK_TIMEOUT_WAITING_TO_SEND.getType(), "TpnsMessage wait for response timeout!");
                synchronized (C7005b.this) {
                    Iterator it2 = C7005b.this.f23294u.iterator();
                    C7000a aVar3 = null;
                    while (it2.hasNext()) {
                        C7030c cVar2 = (C7030c) it2.next();
                        if (cVar2 != null) {
                            long j6 = currentTimeMillis - cVar2.f23368b;
                            if (j6 >= 0) {
                                if (j6 > j3) {
                                    C7031a aVar4 = cVar2.f23372f;
                                    if (aVar4 != null) {
                                        if (aVar3 == null) {
                                            if (C7005b.this.f23297x != null) {
                                                aVar3 = C7005b.this.f23297x.mo33376f();
                                            } else {
                                                aVar3 = new C7000a();
                                            }
                                            aVar3.mo33362a(3, Long.valueOf(j6));
                                        }
                                        aVar4.mo33271a(cVar2.f23371e, channelException2, aVar3);
                                        obj = null;
                                        cVar2.f23372f = null;
                                    } else {
                                        obj = null;
                                    }
                                    it2.remove();
                                    Object obj2 = obj;
                                    z2 = true;
                                } else {
                                    long j7 = j3 - j6;
                                    if (j7 < j) {
                                        j = j7;
                                    }
                                }
                            }
                        } else {
                            it2.remove();
                        }
                    }
                }
                if (z2) {
                    C7005b.this.mo33394d();
                }
            } catch (Exception e) {
                C6864a.m29302d("TpnsChannel", "TimeoutRunnable.run", e);
            }
        }
    }

    /* compiled from: ProGuard */
    /* renamed from: com.tencent.android.tpush.service.channel.b$g */
    public static class C7020g {
        /* renamed from: a */
        public static final C7005b f23325a = new C7005b();
    }

    /* renamed from: a */
    public static C7005b m29964a() {
        return C7020g.f23325a;
    }

    private C7005b() {
        this.f23293t = null;
        this.f23294u = new ArrayList<>();
        this.f23295v = new ConcurrentHashMap();
        this.f23296w = new ConcurrentHashMap();
        this.f23297x = null;
        this.f23298y = false;
        this.f23299z = null;
        this.f23285A = null;
        this.f23286B = null;
        this.f23287C = true;
        this.f23288H = new C6942a() {
            /* renamed from: a */
            public void mo33184a(int i, String str) {
                StringBuilder sb = new StringBuilder();
                sb.append("ICreateSocketChannelCallback onFailure(");
                sb.append(i);
                sb.append(StorageInterface.KEY_SPLITER);
                sb.append(str);
                sb.append(")");
                C6864a.m29308i("TpnsChannel", sb.toString());
                synchronized (C7005b.this) {
                    C7005b.this.f23298y = false;
                    if (!C7005b.this.mo33396f()) {
                        C6864a.m29305f("TpnsChannel", "Connect to Xinge Server failed!");
                        ChannelException channelException = new ChannelException(i, str);
                        Iterator it = C7005b.this.f23294u.iterator();
                        while (it.hasNext()) {
                            C7030c cVar = (C7030c) it.next();
                            if (cVar.f23372f != null) {
                                cVar.f23372f.mo33271a(cVar.f23371e, channelException, C7000a.m29932a());
                            } else {
                                C6864a.m29308i("TpnsChannel", cVar.toString());
                            }
                        }
                        C7005b.this.f23294u.clear();
                    }
                    C7005b.f23266a = 0;
                }
                C7005b.f23271f++;
                try {
                    if (C7005b.f23272g == null) {
                        C7005b.f23272g = new JSONArray();
                    }
                    if (C7005b.f23272g != null && C7005b.f23272g.length() < 10) {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("errorCode", i);
                        if (C6973b.m29776f() != null) {
                            jSONObject.put("np", DeviceInfos.getNetworkType(C6973b.m29776f()));
                        }
                        C7005b.f23272g.put(jSONObject);
                    }
                } catch (Throwable unused) {
                }
            }

            /* renamed from: a */
            public void mo33185a(SocketChannel socketChannel, StrategyItem strategyItem) {
                C7001a aVar;
                StringBuilder sb = new StringBuilder();
                sb.append("ICreateSocketChannelCallback onSuccess(");
                sb.append(socketChannel);
                sb.append(StorageInterface.KEY_SPLITER);
                sb.append(socketChannel);
                sb.append(")");
                C6864a.m29286a("TpnsChannel", sb.toString());
                C7005b.f23270e++;
                synchronized (C7005b.this) {
                    C7005b.this.f23298y = false;
                    C7005b.f23283r = 0;
                    try {
                        if (!C7005b.f23265G.equals(strategyItem.getServerIp())) {
                            byte networkType = DeviceInfos.getNetworkType(C6973b.m29776f());
                            if (networkType == 1) {
                                C7005b.f23279n = C7005b.f23277l;
                            } else if (networkType == 2) {
                                C7005b.f23279n = C7005b.f23276k;
                            } else if (networkType == 3) {
                                C7005b.f23279n = C7005b.f23276k;
                            } else if (networkType == 4) {
                                C7005b.f23279n = C7005b.f23276k;
                            }
                            C7005b.f23265G = strategyItem.getServerIp();
                        }
                        C7005b.f23266a = 0;
                        C7005b bVar = C7005b.this;
                        if (!strategyItem.isHttp()) {
                            aVar = new C7001a(socketChannel, C7005b.m29964a());
                        } else if (strategyItem.isWap()) {
                            aVar = new C7004c(socketChannel, C7005b.m29964a(), strategyItem.getServerIp(), strategyItem.getServerPort());
                        } else {
                            aVar = new C7003b(socketChannel, C7005b.m29964a());
                        }
                        bVar.f23297x = aVar;
                        C7005b.this.mo33390a(true);
                        C7005b.this.f23295v.clear();
                        C7005b.this.f23295v.put(C7005b.this.f23297x, new ConcurrentHashMap());
                        C7005b.this.f23287C = true;
                        C7005b.this.f23297x.start();
                    } catch (Exception e) {
                        C6864a.m29302d(Constants.ServiceLogTag, "", e);
                    }
                }
            }
        };
        this.f23289I = new Handler() {
            public void handleMessage(Message message) {
                super.handleMessage(message);
                String str = "TpnsChannel";
                if (message.what != 1000) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Unexpected: unhandled msg - ");
                    sb.append(message.what);
                    C6864a.m29308i(str, sb.toString());
                    return;
                }
                try {
                    C7005b.this.mo33395e();
                } catch (Throwable th) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("checkAndSetupClient expected:");
                    sb2.append(th);
                    C6864a.m29308i(str, sb2.toString());
                }
            }
        };
        this.f23290J = new C7031a() {
            /* renamed from: a */
            public void mo33269a(JceStruct jceStruct, int i, JceStruct jceStruct2, C7000a aVar) {
                if (i == 0) {
                    C7046a.m30120a();
                    int i2 = C7005b.f23266a;
                    C7005b.f23266a++;
                }
                C7005b.f23267b++;
                StringBuilder sb = new StringBuilder();
                sb.append("heartbeat success rsp = ");
                sb.append(aVar.mo33364c());
                sb.append(" heartbeattimes = ");
                sb.append(C7005b.f23266a);
                C6864a.m29298c("TpnsChannel", sb.toString());
                C7005b.m29980i();
            }

            /* renamed from: a */
            public void mo33271a(JceStruct jceStruct, ChannelException channelException, C7000a aVar) {
                String str = "TpnsChannel";
                C7005b.f23268c++;
                try {
                    StringBuilder sb = new StringBuilder();
                    sb.append("heartbeat failed onMessageSendFailed ");
                    sb.append(channelException.errorCode);
                    sb.append(StorageInterface.KEY_SPLITER);
                    sb.append(channelException.getMessage());
                    C6864a.m29308i(str, sb.toString());
                    if (C7005b.f23273h == null) {
                        C7005b.f23273h = new JSONArray();
                    }
                    if (!(channelException == null || C7005b.f23273h == null || C7005b.f23273h.length() >= 15)) {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("errorCode", channelException.errorCode);
                        if (C6973b.m29776f() != null) {
                            jSONObject.put("np", DeviceInfos.getNetworkType(C6973b.m29776f()));
                        }
                        C7005b.f23273h.put(jSONObject);
                    }
                } catch (Throwable unused) {
                    C6864a.m29308i(str, "Add reprot error");
                }
                C7005b.m29980i();
            }

            /* renamed from: a */
            public void mo33270a(JceStruct jceStruct, C7000a aVar) {
                C6864a.m29308i("TpnsChannel", "heartbeat failed TpnsMessage.IEventListener.onMessageDiscarded");
            }
        };
        this.f23291K = 0;
        this.f23292L = new C7015b();
        C6938d.m29638a().mo33181a((C6943b) this);
        this.f23293t = C6901c.m29459a().mo33107b();
    }

    /* renamed from: b */
    public void mo33392b() {
        mo33395e();
    }

    /* renamed from: c */
    public void mo33393c() {
        this.f23298y = false;
        C7001a aVar = this.f23297x;
        if (aVar != null) {
            aVar.mo33373c();
            this.f23297x = null;
        }
    }

    /* renamed from: d */
    public void mo33394d() {
        mo33393c();
        mo33395e();
    }

    /* renamed from: e */
    public void mo33395e() {
        if (XGPushConfig.enableDebug) {
            StringBuilder sb = new StringBuilder();
            sb.append("Action -> checkAndSetupClient( tpnsClient = ");
            sb.append(this.f23297x);
            sb.append(", isClientCreating = ");
            sb.append(this.f23298y);
            sb.append(")");
            C6864a.m29286a("TpnsChannel", sb.toString());
        }
        synchronized (this) {
            if (this.f23297x == null && !this.f23298y) {
                this.f23298y = true;
                try {
                    C6938d.m29638a().mo33180a(this.f23288H);
                } catch (Exception e) {
                    C6864a.m29302d("TpnsChannel", "createOptimalSocketChannel error", e);
                }
            } else if (!this.f23298y && this.f23297x != null && !this.f23297x.mo33374d()) {
                C6864a.m29308i("TpnsChannel", "The socket Channel is unconnected");
                try {
                    this.f23297x.mo33373c();
                    C6938d.m29638a().mo33180a(this.f23288H);
                } catch (Exception e2) {
                    C6864a.m29302d(Constants.ServiceLogTag, "createOptimalSocketChannel error", e2);
                }
            }
        }
    }

    /* access modifiers changed from: protected|declared_synchronized */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0075, code lost:
            return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0077, code lost:
            return false;
     */
    /* renamed from: f */
    public synchronized boolean mo33396f() {
        /*
        r7 = this;
        monitor-enter(r7)
        android.content.Context r0 = com.tencent.android.tpush.service.C6973b.m29776f()     // Catch:{ all -> 0x0078 }
        boolean r0 = com.tencent.android.tpush.service.p595e.C7048a.m30142d(r0)     // Catch:{ all -> 0x0078 }
        r1 = 0
        if (r0 == 0) goto L_0x0076
        android.content.Context r0 = com.tencent.android.tpush.service.C6973b.m29776f()     // Catch:{ all -> 0x0078 }
        int r0 = com.tencent.android.tpush.common.C6914l.m29529j(r0)     // Catch:{ all -> 0x0078 }
        android.content.Context r2 = com.tencent.android.tpush.service.C6973b.m29776f()     // Catch:{ all -> 0x0078 }
        boolean r2 = com.tencent.android.tpush.common.C6914l.m29528i(r2)     // Catch:{ all -> 0x0078 }
        if (r2 != 0) goto L_0x0020
        if (r0 <= 0) goto L_0x0076
    L_0x0020:
        int r2 = f23283r     // Catch:{ all -> 0x0078 }
        r3 = 1
        int r2 = r2 + r3
        int r2 = r2 * 2
        r4 = 1000(0x3e8, float:1.401E-42)
        int r2 = r2 * 1000
        int r5 = f23283r     // Catch:{ all -> 0x0078 }
        int r5 = r5 + r3
        f23283r = r5     // Catch:{ all -> 0x0078 }
        int r5 = f23283r     // Catch:{ all -> 0x0078 }
        r6 = 3
        if (r5 <= r6) goto L_0x0036
        monitor-exit(r7)
        return r1
    L_0x0036:
        int r5 = f23277l     // Catch:{ all -> 0x0078 }
        if (r2 <= r5) goto L_0x003c
        int r2 = f23277l     // Catch:{ all -> 0x0078 }
    L_0x003c:
        int r5 = f23283r     // Catch:{ all -> 0x0078 }
        if (r5 <= r6) goto L_0x0042
        if (r0 != r3) goto L_0x0076
    L_0x0042:
        android.os.Handler r0 = r7.f23289I     // Catch:{ all -> 0x0078 }
        boolean r0 = r0.hasMessages(r4)     // Catch:{ all -> 0x0078 }
        if (r0 != 0) goto L_0x0074
        boolean r0 = com.tencent.android.tpush.XGPushConfig.enableDebug     // Catch:{ all -> 0x0078 }
        if (r0 == 0) goto L_0x006e
        java.lang.String r0 = "TpnsChannel"
        java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0078 }
        r1.<init>()     // Catch:{ all -> 0x0078 }
        java.lang.String r5 = "onDisconnected and retry HANDLER_CHECKANDSETUP "
        r1.append(r5)     // Catch:{ all -> 0x0078 }
        r1.append(r2)     // Catch:{ all -> 0x0078 }
        java.lang.String r5 = " retry times = "
        r1.append(r5)     // Catch:{ all -> 0x0078 }
        int r5 = f23283r     // Catch:{ all -> 0x0078 }
        r1.append(r5)     // Catch:{ all -> 0x0078 }
        java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x0078 }
        com.tencent.android.tpush.p580b.C6864a.m29298c(r0, r1)     // Catch:{ all -> 0x0078 }
    L_0x006e:
        android.os.Handler r0 = r7.f23289I     // Catch:{ all -> 0x0078 }
        long r1 = (long) r2     // Catch:{ all -> 0x0078 }
        r0.sendEmptyMessageDelayed(r4, r1)     // Catch:{ all -> 0x0078 }
    L_0x0074:
        monitor-exit(r7)
        return r3
    L_0x0076:
        monitor-exit(r7)
        return r1
    L_0x0078:
        r0 = move-exception
        monitor-exit(r7)
        throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.android.tpush.service.channel.C7005b.mo33396f():boolean");
    }

    /* renamed from: a */
    private void m29967a(int i, C7030c cVar) {
        try {
            synchronized (this) {
                if (this.f23294u.size() < 128) {
                    cVar.f23368b = System.currentTimeMillis();
                    if (i == -1) {
                        this.f23294u.add(cVar);
                    } else {
                        this.f23294u.add(i, cVar);
                    }
                } else {
                    String str = Constants.ServiceLogTag;
                    StringBuilder sb = new StringBuilder();
                    sb.append(">>FG messageInQueue is full,size:");
                    sb.append(this.f23294u.size());
                    C6864a.m29308i(str, sb.toString());
                }
                if (this.f23297x != null) {
                    this.f23297x.mo33378h();
                }
                mo33395e();
            }
            C7019f fVar = new C7019f();
            this.f23296w.put(cVar, fVar);
            this.f23293t.postDelayed(fVar, (long) C6971a.m29749a(C6973b.m29776f()).f23147f);
        } catch (Throwable th) {
            C6864a.m29302d(Constants.ServiceLogTag, "messageInQueue", th);
        }
    }

    /* renamed from: a */
    public void mo33389a(JceStruct jceStruct, C7031a aVar) {
        String str = Constants.ServiceLogTag;
        if (jceStruct != null) {
            try {
                m29967a(-1, new C7030c(jceStruct, aVar));
            } catch (Exception e) {
                C6864a.m29302d(str, "sendMessage error ", e);
            }
        } else {
            C6864a.m29308i(str, "sendMessage null jceMessage");
        }
    }

    /* renamed from: a */
    public void mo33390a(boolean z) {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - f23263E > 120000 || z) {
            f23263E = currentTimeMillis;
            C7030c b = C6982c.m29815a().mo33321b();
            if (b != null) {
                if (XGPushConfig.enableDebug) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Action -> sendReconnMessage with token - ");
                    sb.append(CacheManager.getToken(C6973b.m29776f()));
                    C6864a.m29298c("TpnsChannel", sb.toString());
                }
                if (C6973b.m29776f() != null) {
                    if (!"0".equals(CacheManager.getToken(C6973b.m29776f()))) {
                        m29967a(0, b);
                    }
                }
            }
        }
    }

    /* access modifiers changed from: private|declared_synchronized */
    /* renamed from: k */
    public synchronized void m29983k() {
        if (this.f23294u.isEmpty()) {
            if (this.f23286B == null) {
                this.f23286B = new C7030c(7, null, this.f23290J);
            }
            if (this.f23286B.f23372f == null) {
                this.f23286B = new C7030c(7, null, this.f23290J);
            }
            if (XGPushConfig.enableDebug) {
                C6864a.m29298c("TpnsChannel", "Action -> send heartbeat ");
            }
            m29967a(-1, this.f23286B);
            if ((f23266a > 0 && f23266a % 3 == 0) || f23266a == 2) {
                C6901c.m29459a().mo33104a((Runnable) new Runnable() {
                    public void run() {
                        C7056i.m30212h(C6973b.m29776f());
                    }
                });
            }
        }
        m29985m();
        C6860a.m29257b(C6973b.m29776f());
        C7059f.m30231a(C6973b.m29776f()).mo34155a();
        m29980i();
        if (XGPushConfig.isLocationEnable(C6973b.m29776f())) {
            if (f23264F == 0) {
                f23264F = C7055h.m30167a(C6973b.m29776f(), Constants.LOC_REPORT_TIME, 0);
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (f23264F == 0 || Math.abs(currentTimeMillis - f23264F) > ((long) f23281p)) {
                final JSONObject reportLocationJson = CustomDeviceInfos.getReportLocationJson(C6973b.m29776f());
                C6901c.m29459a().mo33104a((Runnable) new Runnable() {
                    public void run() {
                        C7046a.m30130b(C6973b.m29776f(), "location", reportLocationJson);
                    }
                });
                f23264F = currentTimeMillis;
                C7055h.m30171b(C6973b.m29776f(), Constants.LOC_REPORT_TIME, currentTimeMillis);
            }
        }
    }

    /* access modifiers changed from: private|declared_synchronized */
    /* renamed from: l */
    public synchronized void m29984l() {
        if (XGPushConfig.enableDebug) {
            C6864a.m29298c("TpnsChannel", "Action -> send heartbeatSlave ");
        }
        f23274i++;
        mo33398h();
        if (C6973b.m29763a().mo33291f(C6973b.m29776f())) {
            if (!C7048a.m30142d(C6973b.m29776f())) {
                C6864a.m29308i(Constants.ServiceLogTag, "network is unreachable ,give up and go on slave service");
            } else if (C6973b.m29776f() != null) {
                C6901c.m29459a().mo33104a((Runnable) new Runnable() {
                    public void run() {
                        boolean isForeiginPush = XGPushConfig.isForeiginPush(C6973b.m29776f());
                        String str = Constants.ACTION_SLVAE_2_MAIN;
                        String str2 = Constants.ServiceLogTag;
                        if (isForeiginPush) {
                            C6864a.m29308i(str2, "isForeiginPush network is ok , switch to main service");
                            C6973b.m29767a(C6973b.m29776f(), str, 0);
                        } else if (C6979b.m29795a(C6973b.m29776f()).mo33300b()) {
                            C6864a.m29308i(str2, "network is ok , switch to main service");
                            C6973b.m29767a(C6973b.m29776f(), str, 0);
                        } else {
                            C6864a.m29308i(str2, "network is error , go on  slave service");
                        }
                    }
                });
            } else {
                C6864a.m29308i(Constants.ServiceLogTag, "PushServiceManager.getInstance().getContext() is null");
            }
        }
    }

    /* renamed from: b */
    public int mo33391b(boolean z) {
        mo33388a(true, (String) null);
        return 0;
    }

    /* renamed from: a */
    public int mo33388a(boolean z, String str) {
        ArrayList arrayList;
        String str2 = "TpnsChannel";
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - f23262D > 120000 || z) {
            f23262D = currentTimeMillis;
            Context f = C6973b.m29776f();
            if (f != null && !C7056i.m30194b(f.getPackageName())) {
                if (str == null) {
                    arrayList = C6871c.m29327a().mo33023d(f);
                } else {
                    arrayList = C6871c.m29327a().mo33019c(f, str);
                }
                if (arrayList != null && arrayList.size() > 0) {
                    boolean z2 = XGPushConfig.enableDebug;
                    String str3 = Constants.ServiceLogTag;
                    if (z2) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("Action -> trySendCachedMsgIntent with CachedMsgList size = ");
                        sb.append(arrayList.size());
                        C6864a.m29298c(str3, sb.toString());
                    }
                    ArrayList arrayList2 = new ArrayList();
                    for (int i = 0; i < arrayList.size(); i++) {
                        CachedMessageIntent cachedMessageIntent = (CachedMessageIntent) arrayList.get(i);
                        try {
                            String decrypt = Rijndael.decrypt(cachedMessageIntent.intent);
                            if (C7056i.m30194b(decrypt)) {
                                arrayList2.add(cachedMessageIntent);
                            } else {
                                Intent parseUri = Intent.parseUri(decrypt, 1);
                                String str4 = parseUri.getPackage();
                                parseUri.getLongExtra(MessageKey.MSG_CREATE_MULTIPKG, 0);
                                if (!C7056i.m30193b(C6973b.m29776f(), str4, parseUri.getLongExtra("accId", 0))) {
                                    arrayList2.add(cachedMessageIntent);
                                    StringBuilder sb2 = new StringBuilder();
                                    sb2.append(str4);
                                    sb2.append(" is uninstalled , discard the msg and report to the server");
                                    C6864a.m29308i(str2, sb2.toString());
                                    C6982c.m29815a().mo33317a(str4);
                                    C6871c.m29327a().mo33017b(C6973b.m29776f(), str4, new ArrayList<>());
                                } else {
                                    RegisterEntity registerInfoByPkgName = CacheManager.getRegisterInfoByPkgName(str4);
                                    if (registerInfoByPkgName == null || registerInfoByPkgName.state <= 0) {
                                        long longExtra = parseUri.getLongExtra(MessageKey.MSG_ID, 0);
                                        parseUri.getLongExtra(MessageKey.MSG_SERVER_TIME, 0);
                                        parseUri.getStringExtra(MessageKey.MSG_DATE);
                                        if (!C6860a.m29254a(C6973b.m29776f(), parseUri.getPackage(), parseUri)) {
                                            StringBuilder sb3 = new StringBuilder();
                                            sb3.append("ProviderUtils.sendMsgByPkgName error msgId = ");
                                            sb3.append(longExtra);
                                            sb3.append(" appPkgName = ");
                                            sb3.append(str4);
                                            C6864a.m29308i(str3, sb3.toString());
                                        } else {
                                            arrayList2.add(cachedMessageIntent);
                                            C6987a.m29846a().mo33339b(C6973b.m29776f(), parseUri);
                                        }
                                    }
                                }
                            }
                        } catch (Exception e) {
                            C6864a.m29302d(str2, "", e);
                        }
                    }
                    StringBuilder sb4 = new StringBuilder();
                    sb4.append("sendedList.size() = ");
                    sb4.append(arrayList2.size());
                    C6864a.m29298c(str3, sb4.toString());
                    if (arrayList2.size() > 0) {
                        C6871c.m29327a().mo33013a(f, (List<CachedMessageIntent>) arrayList2, arrayList);
                    }
                    return arrayList.size();
                }
            }
        }
        return 0;
    }

    /* renamed from: m */
    private void m29985m() {
        String str = "com.tencent.android.tpush.service.channel.heartbeatIntent";
        String str2 = "TpnsChannel";
        try {
            if (this.f23299z == null) {
                C6973b.m29776f().registerReceiver(new BroadcastReceiver() {
                    public void onReceive(Context context, Intent intent) {
                        C7005b.m29964a().m29983k();
                    }
                }, new IntentFilter(str));
                this.f23299z = PendingIntent.getBroadcast(C6973b.m29776f(), 0, new Intent(str), 134217728);
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (f23279n > f23278m) {
                f23279n = f23278m;
            }
            if (XGPushConfig.isForeignWeakAlarmMode(C6973b.m29776f())) {
                StringBuilder sb = new StringBuilder();
                sb.append("scheduleHeartbeat WaekAlarmMode heartbeatinterval: ");
                sb.append(f23280o);
                sb.append(" ms");
                C6864a.m29305f(str2, sb.toString());
                f23279n = f23280o;
            }
            f23279n = C7055h.m30166a(C6973b.m29776f(), "com.tencent.android.xg.wx.HeartbeatIntervalMs", f23279n);
            C7045d.m30117a().mo34149a(0, currentTimeMillis + ((long) f23279n), this.f23299z);
        } catch (Throwable th) {
            C6864a.m29302d(str2, "scheduleHeartbeat error", th);
        }
    }

    /* renamed from: g */
    public void mo33397g() {
        try {
            if (this.f23285A == null && this.f23292L != null) {
                C6973b.m29776f().unregisterReceiver(this.f23292L);
            }
        } catch (Throwable unused) {
        }
    }

    /* renamed from: h */
    public void mo33398h() {
        String str = "com.tencent.android.tpush.service.channel.heartbeatIntent.pullup";
        String str2 = "TpnsChannel";
        try {
            if (this.f23285A == null) {
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("android.intent.action.SCREEN_ON");
                intentFilter.addAction("android.intent.action.SCREEN_OFF");
                intentFilter.addAction("android.intent.action.USER_PRESENT");
                intentFilter.addAction(str);
                C6973b.m29776f().registerReceiver(this.f23292L, intentFilter);
                this.f23285A = PendingIntent.getBroadcast(C6973b.m29776f(), 0, new Intent(str), 134217728);
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (f23282q > f23278m) {
                f23282q = f23278m;
            }
            if (XGPushConfig.isForeignWeakAlarmMode(C6973b.m29776f())) {
                StringBuilder sb = new StringBuilder();
                sb.append("schedulePullUpHeartbeat WaekAlarmMode heartbeatinterval: ");
                sb.append(f23280o);
                sb.append(" ms");
                C6864a.m29305f(str2, sb.toString());
                f23282q = f23280o;
            }
            f23282q = C7055h.m30166a(C6973b.m29776f(), "com.tencent.android.xg.wx.HeartbeatIntervalMs", f23282q);
            long j = currentTimeMillis + ((long) f23282q);
            mo33391b(true);
            C7045d.m30117a().mo34149a(0, j, this.f23285A);
        } catch (Throwable th) {
            C6864a.m29302d(str2, "scheduleHeartbeat error", th);
        }
    }

    /* renamed from: a */
    public synchronized ArrayList<C7028h> mo33382a(C7001a aVar, int i) {
        ArrayList<C7028h> arrayList;
        if (i < 1) {
            i = 1;
        }
        long currentTimeMillis = System.currentTimeMillis();
        ConcurrentHashMap concurrentHashMap = (ConcurrentHashMap) this.f23295v.get(aVar);
        arrayList = new ArrayList<>(i);
        if (!this.f23294u.isEmpty()) {
            Iterator it = this.f23294u.iterator();
            C7030c cVar = (C7030c) it.next();
            C7028h hVar = new C7028h(cVar.mo33457c());
            cVar.mo33454a(hVar);
            arrayList.add(hVar);
            cVar.f23369c = currentTimeMillis;
            if (!cVar.mo33455a()) {
                concurrentHashMap.put(Integer.valueOf(cVar.mo33458d()), cVar);
            }
            it.remove();
            int i2 = i - 1;
            boolean z = cVar.f23371e instanceof TpnsReconnectReq;
            while (it.hasNext()) {
                final C7030c cVar2 = (C7030c) it.next();
                if (!z || (!(cVar2.f23371e instanceof TpnsReconnectReq) && !(cVar2.f23371e instanceof TpnsPushVerifyReq))) {
                    int i3 = i2 - 1;
                    if (i2 > 0) {
                        C7028h hVar2 = new C7028h(cVar2.mo33457c());
                        cVar2.mo33454a(hVar2);
                        arrayList.add(hVar2);
                        cVar2.f23369c = currentTimeMillis;
                        if (!cVar2.mo33455a()) {
                            concurrentHashMap.put(Integer.valueOf(cVar2.mo33458d()), cVar2);
                        }
                        it.remove();
                    }
                    i2 = i3;
                } else {
                    if (cVar2.f23372f != null) {
                        this.f23293t.post(new Runnable() {
                            public void run() {
                                cVar2.f23372f.mo33270a(cVar2.f23371e, new C7000a());
                            }
                        });
                    }
                    it.remove();
                }
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    public void mo33385a(C7001a aVar, ChannelException channelException) {
        StringBuilder sb = new StringBuilder();
        sb.append("clientExceptionOccurs(isHttpClient : ");
        sb.append(aVar instanceof C7003b);
        sb.append(StorageInterface.KEY_SPLITER);
        sb.append(channelException);
        sb.append(")");
        C6864a.m29308i("TpnsChannel", sb.toString());
        f23271f++;
        this.f23293t.post(new C7017d(aVar, channelException, true));
        try {
            if (f23272g == null) {
                f23272g = new JSONArray();
            }
            if (f23272g != null && f23272g.length() < 10) {
                JSONObject jSONObject = new JSONObject();
                if (channelException != null) {
                    jSONObject.put("errorCode", channelException.errorCode);
                }
                if (C6973b.m29776f() != null) {
                    jSONObject.put("np", DeviceInfos.getNetworkType(C6973b.m29776f()));
                }
                f23272g.put(jSONObject);
            }
        } catch (Throwable unused) {
        }
        m29980i();
    }

    /* renamed from: a */
    public void mo33383a(C7001a aVar) {
        if (XGPushConfig.enableDebug) {
            StringBuilder sb = new StringBuilder();
            sb.append("Action -> clientDidCancelled ");
            sb.append(aVar);
            C6864a.m29308i("TpnsChannel", sb.toString());
        }
        this.f23293t.post(new C7017d(aVar, new ChannelException(ReturnCode.CODE_NETWORK_CHANNEL_CANCELLED.getType(), "TpnsClient is cancelled!"), false));
    }

    /* renamed from: b */
    public void mo33386b(C7001a aVar) {
        if (XGPushConfig.enableDebug) {
            StringBuilder sb = new StringBuilder();
            sb.append("Action -> clientDidRetired ");
            sb.append(aVar);
            C6864a.m29308i("TpnsChannel", sb.toString());
        }
        this.f23293t.post(new C7017d(aVar, new ChannelException(ReturnCode.CODE_NETWORK_TIMEOUT_EXCEPTION_OCCUR.getType(), "TpnsMessage timeout!"), false));
    }

    /* renamed from: a */
    public void mo33384a(C7001a aVar, C7029i iVar) {
        String str = "TpnsChannel";
        if (XGPushConfig.enableDebug) {
            StringBuilder sb = new StringBuilder();
            sb.append("Action -> clientDidSendPacket packet : ");
            sb.append(iVar.mo33452m());
            C6864a.m29298c(str, sb.toString());
        }
        C7030c cVar = (C7030c) ((ConcurrentHashMap) this.f23295v.get(aVar)).get(Integer.valueOf(iVar.mo33448i()));
        if (cVar != null) {
            cVar.f23369c = System.currentTimeMillis();
            return;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(">> message(");
        sb2.append(iVar.mo33448i());
        sb2.append(") not in the sentQueue!");
        C6864a.m29308i(str, sb2.toString());
    }

    /* renamed from: b */
    public synchronized void mo33387b(C7001a aVar, C7029i iVar) {
        m29964a().mo33391b(false);
        if (XGPushConfig.enableDebug) {
            StringBuilder sb = new StringBuilder();
            sb.append("Action -> clientDidReceivePacket packet : ");
            sb.append(iVar.mo33452m());
            C6864a.m29298c("TpnsChannel", sb.toString());
        }
        short j = iVar.mo33449j();
        if (j == 1 || j == 10) {
            if (iVar.mo33444e()) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Action -> clientDidReceivePacket RequestSuccRunnable NEV1 : ");
                sb2.append(iVar.mo33452m());
                C6864a.m29298c("TpnsChannel", sb2.toString());
                this.f23293t.post(new C7018e(aVar, iVar));
            } else {
                StringBuilder sb3 = new StringBuilder();
                sb3.append("Action -> clientDidReceivePacket PushMessageRunnable NEV1 : ");
                sb3.append(iVar.mo33452m());
                C6864a.m29298c("TpnsChannel", sb3.toString());
                this.f23293t.post(new C7016c(aVar, iVar));
            }
            m29985m();
        } else if (j != 20) {
            StringBuilder sb4 = new StringBuilder();
            sb4.append("Action -> clientDidReceivePacket unkonwn protocol : ");
            sb4.append(iVar.mo33452m());
            C6864a.m29308i("TpnsChannel", sb4.toString());
            m29985m();
        } else {
            this.f23293t.post(new C7014a(aVar, iVar));
        }
    }

    /* renamed from: i */
    public static void m29980i() {
        String str = "TpnsChannel";
        try {
            long currentTimeMillis = System.currentTimeMillis();
            if (f23269d == 0) {
                f23269d = currentTimeMillis;
            } else if (currentTimeMillis - f23269d < 30000) {
                return;
            }
            if (C6973b.m29776f() != null) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("srv_stime", XGPushServiceV4.f23078a);
                jSONObject.put("srv_etime", System.currentTimeMillis());
                jSONObject.put("srv_startTime", XGPushServiceV4.f23079b);
                if (XGPushServiceV4.f23080c != null) {
                    jSONObject.put("srv_freason", XGPushServiceV4.f23080c);
                }
                jSONObject.put("hb_suc", f23267b);
                jSONObject.put("hb_failed", f23268c);
                if (f23273h != null) {
                    jSONObject.put("hb_freason", f23273h);
                }
                jSONObject.put("con_suc", f23270e);
                jSONObject.put("con_failed", f23271f);
                if (f23272g != null) {
                    jSONObject.put("con_freason", f23272g);
                }
                C7055h.m30172b(C6973b.m29776f(), "service_state", jSONObject.toString());
                f23269d = currentTimeMillis;
                StringBuilder sb = new StringBuilder();
                sb.append("Service bi state ");
                sb.append(jSONObject.toString());
                C6864a.m29303e(str, sb.toString());
            }
        } catch (Throwable th) {
            C6864a.m29302d(str, "saveBIReportJson ", th);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m29969a(C7030c cVar) {
        boolean z;
        try {
            boolean z2 = false;
            if (cVar.f23370d == 4) {
                Iterator it = this.f23294u.iterator();
                while (it.hasNext()) {
                    if (((C7030c) it.next()).f23370d == 4) {
                        z2 = true;
                    }
                }
                if (!z2) {
                    this.f23294u.add(cVar);
                }
            } else if (cVar.f23370d == 15) {
                Iterator it2 = this.f23294u.iterator();
                while (it2.hasNext()) {
                    if (((C7030c) it2.next()).mo33458d() == cVar.mo33458d()) {
                        z2 = true;
                    }
                }
                if (!z2) {
                    this.f23294u.add(cVar);
                }
            } else if (cVar.f23370d == 5) {
                Iterator it3 = this.f23294u.iterator();
                while (it3.hasNext()) {
                    if (((C7030c) it3.next()).f23370d == 5) {
                        z = true;
                    }
                }
                if (!z) {
                    this.f23294u.add(cVar);
                }
            }
        } catch (Throwable th) {
            C6864a.m29302d("TpnsChannel", "addTpnsMessages", th);
        }
    }
}
