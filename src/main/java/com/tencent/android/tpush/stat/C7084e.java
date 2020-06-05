package com.tencent.android.tpush.stat;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Handler;
import com.tencent.android.tpush.common.MessageKey;
import com.tencent.android.tpush.service.channel.protocol.TpnsClickClientReport;
import com.tencent.android.tpush.service.channel.protocol.TpnsPushClientReport;
import com.tencent.android.tpush.service.channel.protocol.TpnsPushMsg;
import com.tencent.android.tpush.stat.event.C7098a;
import com.tencent.android.tpush.stat.event.C7098a.C7099a;
import com.tencent.android.tpush.stat.event.C7100b;
import com.tencent.android.tpush.stat.event.C7102d;
import com.tencent.android.tpush.stat.event.C7103e;
import com.tencent.android.tpush.stat.p596a.C7066c;
import com.tencent.android.tpush.stat.p596a.C7067d;
import com.tencent.android.tpush.stat.p596a.C7068e;
import java.lang.Thread.UncaughtExceptionHandler;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: ProGuard */
/* renamed from: com.tencent.android.tpush.stat.e */
public class C7084e {
    /* renamed from: a */
    static volatile long f23553a = 0;
    /* access modifiers changed from: private|static */
    /* renamed from: b */
    public static Map<String, Long> f23554b = new ConcurrentHashMap();
    /* renamed from: c */
    private static volatile Handler f23555c = null;
    /* renamed from: d */
    private static volatile int f23556d = 0;
    /* access modifiers changed from: private|static|volatile */
    /* renamed from: e */
    public static volatile String f23557e;
    /* access modifiers changed from: private|static|volatile */
    /* renamed from: f */
    public static volatile String f23558f;
    /* access modifiers changed from: private|static */
    /* renamed from: g */
    public static C7067d f23559g = C7066c.m30259b();
    /* access modifiers changed from: private|static */
    /* renamed from: h */
    public static UncaughtExceptionHandler f23560h = null;
    /* access modifiers changed from: private|static */
    /* renamed from: i */
    public static Context f23561i = null;
    /* renamed from: j */
    private static String f23562j = null;
    /* access modifiers changed from: private|static|volatile */
    /* renamed from: k */
    public static volatile SharedPreferences f23563k = null;

    static {
        String str = "";
        f23557e = str;
        f23558f = str;
    }

    /* renamed from: a */
    public static Context m30384a(Context context) {
        return context != null ? context : f23561i;
    }

    /* renamed from: b */
    public static void m30402b(Context context) {
        if (context != null) {
            f23561i = context.getApplicationContext();
        }
    }

    /* renamed from: c */
    static boolean m30412c(Context context) {
        boolean z;
        long a = C7068e.m30283a(context, C7070b.f23502c, 0);
        long a2 = C7066c.m30252a("2.0.6");
        if (a2 <= a) {
            C7067d dVar = f23559g;
            StringBuilder sb = new StringBuilder();
            sb.append("MTA is disable for current version:");
            sb.append(a2);
            sb.append(",wakeup version:");
            sb.append(a);
            dVar.mo34173e(sb.toString());
            z = false;
        } else {
            z = true;
        }
        C7070b.m30301a(z);
        return z;
    }

    /* renamed from: a */
    static boolean m30398a(String str) {
        return str == null || str.length() == 0;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0039, code lost:
            return;
     */
    /* renamed from: d */
    static synchronized void m30414d(android.content.Context r3) {
        /*
        java.lang.Class<com.tencent.android.tpush.stat.e> r0 = com.tencent.android.tpush.stat.C7084e.class
        monitor-enter(r0)
        if (r3 != 0) goto L_0x0007
        monitor-exit(r0)
        return
    L_0x0007:
        android.os.Handler r1 = f23555c     // Catch:{ all -> 0x003a }
        if (r1 != 0) goto L_0x0038
        boolean r1 = m30412c(r3)     // Catch:{ all -> 0x003a }
        if (r1 != 0) goto L_0x0013
        monitor-exit(r0)
        return
    L_0x0013:
        android.content.Context r3 = r3.getApplicationContext()     // Catch:{ all -> 0x003a }
        f23561i = r3     // Catch:{ all -> 0x003a }
        android.os.HandlerThread r1 = new android.os.HandlerThread     // Catch:{ all -> 0x003a }
        java.lang.String r2 = "XgStat"
        r1.<init>(r2)     // Catch:{ all -> 0x003a }
        r1.start()     // Catch:{ all -> 0x003a }
        android.os.Handler r2 = new android.os.Handler     // Catch:{ all -> 0x003a }
        android.os.Looper r1 = r1.getLooper()     // Catch:{ all -> 0x003a }
        r2.<init>(r1)     // Catch:{ all -> 0x003a }
        f23555c = r2     // Catch:{ all -> 0x003a }
        android.os.Handler r1 = f23555c     // Catch:{ all -> 0x003a }
        com.tencent.android.tpush.stat.e$1 r2 = new com.tencent.android.tpush.stat.e$1     // Catch:{ all -> 0x003a }
        r2.m52317init(r3)     // Catch:{ all -> 0x003a }
        r1.post(r2)     // Catch:{ all -> 0x003a }
    L_0x0038:
        monitor-exit(r0)
        return
    L_0x003a:
        r3 = move-exception
        monitor-exit(r0)
        throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.android.tpush.stat.C7084e.m30414d(android.content.Context):void");
    }

    /* renamed from: e */
    public static Handler m30416e(Context context) {
        if (f23555c == null) {
            synchronized (C7084e.class) {
                if (f23555c == null) {
                    try {
                        m30414d(context);
                    } catch (Throwable th) {
                        f23559g.mo34166a(th);
                        C7070b.m30301a(false);
                    }
                }
            }
        }
        return f23555c;
    }

    /* renamed from: a */
    static JSONObject m30387a() {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            String str = "v";
            if (C7070b.f23501b.f23518d != 0) {
                jSONObject2.put(str, C7070b.f23501b.f23518d);
            }
            jSONObject.put(Integer.toString(C7070b.f23501b.f23515a), jSONObject2);
            JSONObject jSONObject3 = new JSONObject();
            if (C7070b.f23500a.f23518d != 0) {
                jSONObject3.put(str, C7070b.f23500a.f23518d);
            }
            jSONObject.put(Integer.toString(C7070b.f23500a.f23515a), jSONObject3);
        } catch (JSONException e) {
            f23559g.mo34170b((Throwable) e);
        }
        return jSONObject;
    }

    /* renamed from: a */
    static void m30389a(Context context, long j) {
        C7103e eVar = new C7103e(context, f23556d, m30387a(), j);
        m30396a((C7100b) eVar);
    }

    /* renamed from: b */
    static int m30399b(Context context, long j) {
        long currentTimeMillis = System.currentTimeMillis();
        String str = "_INTER_MTA_NEXT_DAY";
        if (f23553a == 0) {
            f23553a = C7068e.m30283a(f23561i, str, 0);
        }
        boolean z = true;
        if (f23556d != 0 && currentTimeMillis < f23553a) {
            z = false;
        }
        if (z) {
            f23556d = C7066c.m30250a();
            f23553a = C7066c.m30263c();
            C7068e.m30287b(f23561i, str, f23553a);
            m30389a(context, j);
        }
        return f23556d;
    }

    /* renamed from: a */
    public static void m30390a(Context context, final C7100b bVar) {
        if (C7070b.m30305c()) {
            if (f23561i == null) {
                m30414d(context);
            }
            if (m30416e(m30384a(context)) != null) {
                f23555c.post(new Runnable() {
                    public void run() {
                        try {
                            C7084e.m30396a(bVar);
                        } catch (Throwable th) {
                            C7084e.f23559g.mo34170b(th);
                        }
                    }
                });
            }
        }
    }

    /* renamed from: a */
    public static void m30394a(Context context, String str, Properties properties, long j, long j2) {
        if (C7070b.m30305c()) {
            final Context a = m30384a(context);
            if (a == null) {
                f23559g.mo34173e("The Context of StatService.trackCustomEvent() can not be null!");
            } else if (m30398a(str)) {
                f23559g.mo34173e("The event_id of StatService.trackCustomEvent() can not be null or empty.");
            } else {
                final C7099a aVar = new C7099a(str, null, properties);
                if (m30416e(a) != null) {
                    Handler handler = f23555c;
                    final long j3 = j;
                    final long j4 = j2;
                    C70957 r1 = new Runnable() {
                        public void run() {
                            try {
                                C7098a aVar = new C7098a(a, C7084e.m30399b(a, j3), aVar.f23594a, j3, j4);
                                aVar.mo34231a().f23596c = aVar.f23596c;
                                C7084e.m30396a((C7100b) aVar);
                            } catch (Throwable th) {
                                C7084e.f23559g.mo34170b(th);
                            }
                        }
                    };
                    handler.post(r1);
                }
            }
        }
    }

    /* renamed from: a */
    public static void m30395a(Context context, final ArrayList<TpnsPushMsg> arrayList) {
        if (C7070b.m30305c()) {
            final Context a = m30384a(context);
            if (a == null) {
                f23559g.mo34173e("The Context of StatService.trackCustomEvent() can not be null!");
            } else if (arrayList == null || arrayList.size() == 0) {
                f23559g.mo34173e("The reportList of StatService.trackCustomEvent() can not be null or empty.");
            } else {
                if (m30416e(a) != null) {
                    f23555c.post(new Runnable() {
                        public void run() {
                            String str = "";
                            try {
                                ArrayList arrayList = new ArrayList(arrayList.size());
                                Iterator it = arrayList.iterator();
                                while (it.hasNext()) {
                                    TpnsPushMsg tpnsPushMsg = (TpnsPushMsg) it.next();
                                    JSONObject jSONObject = new JSONObject();
                                    StringBuilder sb = new StringBuilder();
                                    sb.append(str);
                                    sb.append(tpnsPushMsg.type);
                                    jSONObject.put("type", sb.toString());
                                    String str2 = MessageKey.MSG_BUSI_MSG_ID;
                                    StringBuilder sb2 = new StringBuilder();
                                    sb2.append(str);
                                    sb2.append(tpnsPushMsg.busiMsgId);
                                    jSONObject.put(str2, sb2.toString());
                                    String str3 = MessageKey.MSG_ID;
                                    StringBuilder sb3 = new StringBuilder();
                                    sb3.append(str);
                                    sb3.append(tpnsPushMsg.msgId);
                                    jSONObject.put(str3, sb3.toString());
                                    C7098a aVar = new C7098a(a, C7084e.m30399b(a, tpnsPushMsg.accessId), "SrvAck", tpnsPushMsg.accessId, tpnsPushMsg.timestamp);
                                    aVar.mo34231a().f23596c = jSONObject;
                                    arrayList.add(aVar);
                                }
                                C7084e.m30397a((List<C7100b>) arrayList);
                            } catch (Throwable th) {
                                C7084e.f23559g.mo34170b(th);
                            }
                        }
                    });
                }
            }
        }
    }

    /* renamed from: b */
    public static void m30405b(Context context, final ArrayList<TpnsPushClientReport> arrayList) {
        if (C7070b.m30305c()) {
            final Context a = m30384a(context);
            if (a == null) {
                f23559g.mo34173e("The Context of StatService.trackCustomEvent() can not be null!");
            } else if (arrayList == null || arrayList.size() == 0) {
                f23559g.mo34173e("The reportList of StatService.trackCustomEvent() can not be null or empty.");
            } else {
                if (m30416e(a) != null) {
                    f23555c.post(new Runnable() {
                        public void run() {
                            String str = "";
                            try {
                                ArrayList arrayList = new ArrayList(arrayList.size());
                                Iterator it = arrayList.iterator();
                                while (it.hasNext()) {
                                    TpnsPushClientReport tpnsPushClientReport = (TpnsPushClientReport) it.next();
                                    long j = tpnsPushClientReport.type;
                                    long j2 = tpnsPushClientReport.timestamp;
                                    long j3 = tpnsPushClientReport.broadcastId;
                                    long j4 = tpnsPushClientReport.msgId;
                                    long j5 = tpnsPushClientReport.accessId;
                                    Iterator it2 = it;
                                    long j6 = tpnsPushClientReport.channelId;
                                    Iterator it3 = it2;
                                    JSONObject jSONObject = new JSONObject();
                                    ArrayList arrayList2 = arrayList;
                                    long j7 = j2;
                                    StringBuilder sb = new StringBuilder();
                                    sb.append(str);
                                    sb.append(j);
                                    jSONObject.put("type", sb.toString());
                                    String str2 = MessageKey.MSG_BUSI_MSG_ID;
                                    StringBuilder sb2 = new StringBuilder();
                                    sb2.append(str);
                                    sb2.append(j3);
                                    jSONObject.put(str2, sb2.toString());
                                    String str3 = MessageKey.MSG_ID;
                                    StringBuilder sb3 = new StringBuilder();
                                    sb3.append(str);
                                    sb3.append(j4);
                                    jSONObject.put(str3, sb3.toString());
                                    String str4 = MessageKey.MSG_CHANNEL_ID;
                                    StringBuilder sb4 = new StringBuilder();
                                    sb4.append(str);
                                    sb4.append(j6);
                                    jSONObject.put(str4, sb4.toString());
                                    C7098a aVar = new C7098a(a, C7084e.m30399b(a, j5), "Ack", j5, j7);
                                    aVar.mo34231a().f23596c = jSONObject;
                                    ArrayList arrayList3 = arrayList2;
                                    arrayList3.add(aVar);
                                    arrayList = arrayList3;
                                    it = it3;
                                }
                                C7084e.m30397a((List<C7100b>) arrayList);
                            } catch (Throwable th) {
                                C7084e.f23559g.mo34170b(th);
                            }
                        }
                    });
                }
            }
        }
    }

    /* renamed from: c */
    public static void m30410c(Context context, final ArrayList<TpnsClickClientReport> arrayList) {
        if (C7070b.m30305c()) {
            final Context a = m30384a(context);
            if (a == null) {
                f23559g.mo34173e("The Context of StatService.trackCustomEvent() can not be null!");
            } else if (arrayList == null || arrayList.size() == 0) {
                f23559g.mo34173e("The reportList of StatService.trackCustomEvent() can not be null or empty.");
            } else {
                if (m30416e(a) != null) {
                    f23555c.post(new Runnable() {
                        public void run() {
                            String str = "";
                            try {
                                ArrayList arrayList = new ArrayList(arrayList.size());
                                Iterator it = arrayList.iterator();
                                while (it.hasNext()) {
                                    TpnsClickClientReport tpnsClickClientReport = (TpnsClickClientReport) it.next();
                                    long j = tpnsClickClientReport.type;
                                    long j2 = tpnsClickClientReport.timestamp;
                                    long j3 = tpnsClickClientReport.broadcastId;
                                    long j4 = tpnsClickClientReport.msgId;
                                    long j5 = tpnsClickClientReport.accessId;
                                    Iterator it2 = it;
                                    long j6 = tpnsClickClientReport.action;
                                    Iterator it3 = it2;
                                    JSONObject jSONObject = new JSONObject();
                                    ArrayList arrayList2 = arrayList;
                                    long j7 = j2;
                                    StringBuilder sb = new StringBuilder();
                                    sb.append(str);
                                    sb.append(j);
                                    jSONObject.put("type", sb.toString());
                                    String str2 = MessageKey.MSG_BUSI_MSG_ID;
                                    StringBuilder sb2 = new StringBuilder();
                                    sb2.append(str);
                                    sb2.append(j3);
                                    jSONObject.put(str2, sb2.toString());
                                    String str3 = MessageKey.MSG_ID;
                                    StringBuilder sb3 = new StringBuilder();
                                    sb3.append(str);
                                    sb3.append(j4);
                                    jSONObject.put(str3, sb3.toString());
                                    StringBuilder sb4 = new StringBuilder();
                                    sb4.append(str);
                                    sb4.append(j6);
                                    jSONObject.put("action", sb4.toString());
                                    C7098a aVar = new C7098a(a, C7084e.m30399b(a, j5), "Action", j5, j7);
                                    aVar.mo34231a().f23596c = jSONObject;
                                    ArrayList arrayList3 = arrayList2;
                                    arrayList3.add(aVar);
                                    arrayList = arrayList3;
                                    it = it3;
                                }
                                C7084e.m30397a((List<C7100b>) arrayList);
                            } catch (Throwable th) {
                                C7084e.f23559g.mo34170b(th);
                            }
                        }
                    });
                }
            }
        }
    }

    /* renamed from: a */
    public static void m30393a(Context context, String str, Properties properties, long j) {
        if (C7070b.m30305c()) {
            final Context a = m30384a(context);
            if (a == null) {
                f23559g.mo34173e("The Context of StatService.trackCustomEvent() can not be null!");
            } else if (m30398a(str)) {
                f23559g.mo34173e("The event_id of StatService.trackCustomEvent() can not be null or empty.");
            } else {
                final C7099a aVar = new C7099a(str, null, properties);
                if (m30416e(a) != null) {
                    Handler handler = f23555c;
                    final long j2 = j;
                    final String str2 = str;
                    C708711 r1 = new Runnable() {
                        public void run() {
                            try {
                                C7098a aVar = new C7098a(a, C7084e.m30399b(a, j2), str2, j2, System.currentTimeMillis());
                                aVar.mo34231a().f23596c = aVar.f23596c;
                                ArrayList arrayList = new ArrayList();
                                arrayList.add(aVar);
                                C7084e.m30397a((List<C7100b>) arrayList);
                            } catch (Throwable th) {
                                C7084e.f23559g.mo34170b(th);
                            }
                        }
                    };
                    handler.post(r1);
                }
            }
        }
    }

    /* renamed from: a */
    public static void m30388a(Context context, int i) {
        if (C7070b.m30305c()) {
            if (C7070b.m30304b()) {
                C7067d dVar = f23559g;
                StringBuilder sb = new StringBuilder();
                sb.append("commitEvents, maxNumber=");
                sb.append(i);
                dVar.mo34169b((Object) sb.toString());
            }
            Context a = m30384a(context);
            if (a == null) {
                f23559g.mo34173e("The Context of StatService.commitEvents() can not be null!");
            } else if (i < -1 || i == 0) {
                f23559g.mo34173e("The maxNumber of StatService.commitEvents() should be -1 or bigger than 0.");
            } else {
                if (C7060a.m30235a(a).mo34159c() && m30416e(a) != null) {
                    f23555c.post(new Runnable() {
                        public void run() {
                            try {
                                C7084e.m30401b();
                            } catch (Throwable th) {
                                C7084e.f23559g.mo34170b(th);
                            }
                        }
                    });
                }
            }
        }
    }

    /* renamed from: a */
    static void m30397a(final List<C7100b> list) {
        C7067d dVar = f23559g;
        StringBuilder sb = new StringBuilder();
        sb.append("sentEventList size:");
        sb.append(list.size());
        dVar.mo34176h(sb.toString());
        if (C7060a.m30235a(f23561i).mo34159c()) {
            C7082d.m30380b(f23561i).mo34218b(list, new C7081c() {
                /* renamed from: a */
                public void mo34214a() {
                }

                /* renamed from: b */
                public void mo34215b() {
                    C7084e.m30406b(list);
                }
            });
        } else {
            m30406b(list);
        }
    }

    /* renamed from: a */
    static void m30396a(final C7100b bVar) {
        if (C7060a.m30235a(f23561i).mo34159c()) {
            C7082d.m30380b(f23561i).mo34216a(bVar, (C7081c) new C7081c() {
                /* renamed from: a */
                public void mo34214a() {
                    C7067d d = C7084e.f23559g;
                    StringBuilder sb = new StringBuilder();
                    sb.append("send Event sucess:");
                    sb.append(bVar.mo34233b());
                    d.mo34176h(sb.toString());
                }

                /* renamed from: b */
                public void mo34215b() {
                    C7084e.m30406b(Arrays.asList(new C7100b[]{bVar}));
                }
            });
            return;
        }
        m30406b(Arrays.asList(new C7100b[]{bVar}));
    }

    /* renamed from: b */
    static synchronized void m30406b(List<?> list) {
        synchronized (C7084e.class) {
            if (list != null) {
                try {
                    if (f23563k != null) {
                        C7067d dVar = f23559g;
                        StringBuilder sb = new StringBuilder();
                        sb.append("store event size:");
                        sb.append(list.size());
                        dVar.mo34176h(sb.toString());
                        Editor edit = f23563k.edit();
                        for (Object obj : list) {
                            edit.putLong(obj.toString(), System.currentTimeMillis());
                        }
                        edit.commit();
                    }
                } catch (Exception e) {
                    f23559g.mo34170b((Throwable) e);
                }
            }
        }
        return;
    }

    /* renamed from: c */
    static synchronized void m30411c(List<?> list) {
        synchronized (C7084e.class) {
            if (list != null) {
                try {
                    if (f23563k != null) {
                        C7067d dVar = f23559g;
                        StringBuilder sb = new StringBuilder();
                        sb.append("delete event size:");
                        sb.append(list.size());
                        dVar.mo34176h(sb.toString());
                        Editor edit = f23563k.edit();
                        for (Object obj : list) {
                            edit.remove(obj.toString());
                        }
                        edit.commit();
                    }
                } catch (Exception e) {
                    f23559g.mo34170b((Throwable) e);
                }
            }
        }
        return;
    }

    /* renamed from: d */
    static synchronized void m30415d(List<?> list) {
        synchronized (C7084e.class) {
            try {
                long currentTimeMillis = System.currentTimeMillis() - 259200000;
                if (!(list == null || f23563k == null)) {
                    Editor edit = f23563k.edit();
                    for (Object obj : list) {
                        String obj2 = obj.toString();
                        if (f23563k.getLong(obj2, 1) < currentTimeMillis) {
                            edit.remove(obj2);
                        }
                    }
                    edit.commit();
                }
            } catch (Exception e) {
                f23559g.mo34170b((Throwable) e);
            }
        }
        return;
    }

    /* renamed from: e */
    static void m30418e(final List<String> list) {
        if (list != null && list.size() != 0) {
            C7082d.m30380b(f23561i).mo34218b(list, new C7081c() {
                /* renamed from: a */
                public void mo34214a() {
                    C7084e.m30411c(list);
                }

                /* renamed from: b */
                public void mo34215b() {
                    C7084e.m30415d(list);
                }
            });
        }
    }

    /* renamed from: a */
    public static void m30391a(final Context context, String str, final long j) {
        final String str2 = new String(str);
        if (m30416e(context) != null) {
            f23555c.post(new Runnable() {
                /* JADX WARNING: Code restructure failed: missing block: B:17:?, code lost:
            com.tencent.android.tpush.stat.C7084e.m30399b(r2, r4);
     */
                public void run() {
                    /*
                    r5 = this;
                    java.util.Map r0 = com.tencent.android.tpush.stat.C7084e.f23554b     // Catch:{ all -> 0x008a }
                    monitor-enter(r0)     // Catch:{ all -> 0x008a }
                    java.util.Map r1 = com.tencent.android.tpush.stat.C7084e.f23554b     // Catch:{ all -> 0x0087 }
                    int r1 = r1.size()     // Catch:{ all -> 0x0087 }
                    int r2 = com.tencent.android.tpush.stat.C7070b.m30308f()     // Catch:{ all -> 0x0087 }
                    if (r1 < r2) goto L_0x0035
                    com.tencent.android.tpush.stat.a.d r1 = com.tencent.android.tpush.stat.C7084e.f23559g     // Catch:{ all -> 0x0087 }
                    java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0087 }
                    r2.<init>()     // Catch:{ all -> 0x0087 }
                    java.lang.String r3 = "The number of page events exceeds the maximum value "
                    r2.append(r3)     // Catch:{ all -> 0x0087 }
                    int r3 = com.tencent.android.tpush.stat.C7070b.m30308f()     // Catch:{ all -> 0x0087 }
                    java.lang.String r3 = java.lang.Integer.toString(r3)     // Catch:{ all -> 0x0087 }
                    r2.append(r3)     // Catch:{ all -> 0x0087 }
                    java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x0087 }
                    r1.mo34173e(r2)     // Catch:{ all -> 0x0087 }
                    monitor-exit(r0)     // Catch:{ all -> 0x0087 }
                    return
                L_0x0035:
                    java.lang.String r1 = r0     // Catch:{ all -> 0x0087 }
                    com.tencent.android.tpush.stat.C7084e.f23557e = r1     // Catch:{ all -> 0x0087 }
                    java.util.Map r1 = com.tencent.android.tpush.stat.C7084e.f23554b     // Catch:{ all -> 0x0087 }
                    java.lang.String r2 = com.tencent.android.tpush.stat.C7084e.f23557e     // Catch:{ all -> 0x0087 }
                    boolean r1 = r1.containsKey(r2)     // Catch:{ all -> 0x0087 }
                    if (r1 == 0) goto L_0x006b
                    com.tencent.android.tpush.stat.a.d r1 = com.tencent.android.tpush.stat.C7084e.f23559g     // Catch:{ all -> 0x0087 }
                    java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0087 }
                    r2.<init>()     // Catch:{ all -> 0x0087 }
                    java.lang.String r3 = "Duplicate PageID : "
                    r2.append(r3)     // Catch:{ all -> 0x0087 }
                    java.lang.String r3 = com.tencent.android.tpush.stat.C7084e.f23557e     // Catch:{ all -> 0x0087 }
                    r2.append(r3)     // Catch:{ all -> 0x0087 }
                    java.lang.String r3 = ", onResume() repeated?"
                    r2.append(r3)     // Catch:{ all -> 0x0087 }
                    java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x0087 }
                    r1.mo34174f(r2)     // Catch:{ all -> 0x0087 }
                    monitor-exit(r0)     // Catch:{ all -> 0x0087 }
                    return
                L_0x006b:
                    java.util.Map r1 = com.tencent.android.tpush.stat.C7084e.f23554b     // Catch:{ all -> 0x0087 }
                    java.lang.String r2 = com.tencent.android.tpush.stat.C7084e.f23557e     // Catch:{ all -> 0x0087 }
                    long r3 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x0087 }
                    java.lang.Long r3 = java.lang.Long.valueOf(r3)     // Catch:{ all -> 0x0087 }
                    r1.put(r2, r3)     // Catch:{ all -> 0x0087 }
                    monitor-exit(r0)     // Catch:{ all -> 0x0087 }
                    android.content.Context r0 = r2     // Catch:{ all -> 0x008a }
                    long r1 = r4     // Catch:{ all -> 0x008a }
                    com.tencent.android.tpush.stat.C7084e.m30399b(r0, r1)     // Catch:{ all -> 0x008a }
                    goto L_0x0092
                L_0x0087:
                    r1 = move-exception
                    monitor-exit(r0)     // Catch:{ all -> 0x0087 }
                    throw r1     // Catch:{ all -> 0x008a }
                L_0x008a:
                    r0 = move-exception
                    com.tencent.android.tpush.stat.a.d r1 = com.tencent.android.tpush.stat.C7084e.f23559g
                    r1.mo34170b(r0)
                L_0x0092:
                    return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.tencent.android.tpush.stat.C7084e.C70924.run():void");
                }
            });
        }
    }

    /* renamed from: b */
    public static void m30403b(Context context, String str, long j) {
        if (C7070b.m30305c()) {
            Context a = m30384a(context);
            if (a == null || str == null || str.length() == 0) {
                f23559g.mo34173e("The Context or pageName of StatService.trackBeginPage() can not be null or empty!");
            } else {
                m30391a(a, str, j);
            }
        }
    }

    /* renamed from: b */
    private static void m30404b(Context context, String str, long j, long j2, long j3) {
        String str2 = str;
        final String str3 = new String(str);
        if (m30416e(context) != null) {
            Handler handler = f23555c;
            final Context context2 = context;
            final long j4 = j;
            final long j5 = j2;
            final long j6 = j3;
            C70935 r0 = new Runnable() {
                public void run() {
                    Long l;
                    try {
                        synchronized (C7084e.f23554b) {
                            l = (Long) C7084e.f23554b.remove(str3);
                        }
                        if (l != null) {
                            Long valueOf = Long.valueOf((System.currentTimeMillis() - l.longValue()) / 1000);
                            if (valueOf.longValue() <= 0) {
                                valueOf = Long.valueOf(1);
                            }
                            Long l2 = valueOf;
                            String g = C7084e.f23558f;
                            if (g != null && g.equals(str3)) {
                                g = "-";
                            }
                            C7102d dVar = new C7102d(context2, g, str3, C7084e.m30399b(context2, j4), l2, j4);
                            if (j5 > 0) {
                                dVar.f23611n = j5;
                            }
                            if (j6 > 0) {
                                dVar.f23611n = j6;
                            }
                            if (!str3.equals(C7084e.f23557e)) {
                                C7084e.f23559g.mo34171c("Invalid invocation since previous onResume on diff page.");
                            }
                            ArrayList arrayList = new ArrayList();
                            arrayList.add(dVar);
                            C7084e.m30397a((List<C7100b>) arrayList);
                            C7084e.f23558f = str3;
                            return;
                        }
                        C7067d d = C7084e.f23559g;
                        StringBuilder sb = new StringBuilder();
                        sb.append("Starttime for PageID:");
                        sb.append(str3);
                        sb.append(" not found, lost onResume()?");
                        d.mo34174f(sb.toString());
                    } catch (Throwable th) {
                        C7084e.f23559g.mo34170b(th);
                    }
                }
            };
            handler.post(r0);
        }
    }

    /* renamed from: c */
    public static void m30409c(Context context, String str, long j) {
        if (C7070b.m30305c()) {
            Context a = m30384a(context);
            if (a == null || str == null || str.length() == 0) {
                f23559g.mo34173e("The Context or pageName of StatService.trackEndPage() can not be null or empty!");
            } else {
                m30404b(a, str, j, 0, 0);
            }
        }
    }

    /* renamed from: a */
    public static void m30392a(Context context, String str, long j, long j2, long j3) {
        if (C7070b.m30305c()) {
            Context a = m30384a(context);
            if (a == null || str == null || str.length() == 0) {
                f23559g.mo34173e("The Context or pageName of StatService.trackEndPage() can not be null or empty!");
            } else {
                m30404b(a, str, j, j2, j3);
            }
        }
    }

    /* renamed from: b */
    static synchronized void m30401b() {
        synchronized (C7084e.class) {
            if (f23563k != null) {
                Map all = f23563k.getAll();
                if (all != null && all.size() > 0) {
                    ArrayList arrayList = new ArrayList(10);
                    for (Entry key : all.entrySet()) {
                        arrayList.add(key.getKey());
                        if (arrayList.size() == 10) {
                            m30418e((List<String>) arrayList);
                            arrayList.clear();
                        }
                    }
                    m30418e((List<String>) arrayList);
                    arrayList.clear();
                }
            }
        }
    }
}
