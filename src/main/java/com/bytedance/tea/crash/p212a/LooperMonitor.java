package com.bytedance.tea.crash.p212a;

import android.os.Build.VERSION;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.MessageQueue;
import android.os.Process;
import android.os.SystemClock;
import android.util.Log;
import android.util.Printer;
import androidx.core.app.NotificationCompat;
import com.bytedance.tea.crash.p218e.CpuInfo;
import com.bytedance.tea.crash.p218e.LooperMessageManager;
import com.bytedance.tea.crash.p218e.LooperTrace;
import com.bytedance.tea.crash.p218e.NpthHandlerThread;
import com.bytedance.tea.crash.p221g.NpthLog;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.bytedance.tea.crash.a.g */
public class LooperMonitor {
    /* renamed from: a */
    public static long f9219a = -1;
    /* renamed from: b */
    public static long f9220b = -1;
    /* renamed from: c */
    private static boolean f9221c = false;
    /* access modifiers changed from: private|static */
    /* renamed from: d */
    public static boolean f9222d = true;
    /* renamed from: e */
    private static int f9223e;
    /* renamed from: f */
    private static List<C2577a> f9224f;
    /* access modifiers changed from: private|static|volatile */
    /* renamed from: g */
    public static volatile AtomicLong f9225g = new AtomicLong(-1);
    /* access modifiers changed from: private|static */
    /* renamed from: h */
    public static long f9226h = 100;
    /* access modifiers changed from: private|static */
    /* renamed from: i */
    public static long f9227i;
    /* renamed from: j */
    private static HandlerThread f9228j;
    /* access modifiers changed from: private|static */
    /* renamed from: k */
    public static long f9229k;
    /* access modifiers changed from: private|static */
    /* renamed from: l */
    public static long f9230l;
    /* access modifiers changed from: private|static */
    /* renamed from: m */
    public static Handler f9231m;
    /* access modifiers changed from: private|static */
    /* renamed from: n */
    public static int f9232n;
    /* access modifiers changed from: private|static */
    /* renamed from: o */
    public static boolean f9233o;
    /* access modifiers changed from: private|static|volatile */
    /* renamed from: p */
    public static volatile String f9234p = null;
    /* access modifiers changed from: private|static|volatile */
    /* renamed from: q */
    public static volatile boolean f9235q = false;
    /* access modifiers changed from: private|static */
    /* renamed from: r */
    public static int f9236r = -1;
    /* renamed from: s */
    private static int f9237s = -1;
    /* renamed from: t */
    private static MessageQueue f9238t = null;
    /* renamed from: u */
    private static Field f9239u = null;
    /* renamed from: v */
    private static Field f9240v = null;

    /* compiled from: LooperMonitor */
    /* renamed from: com.bytedance.tea.crash.a.g$a */
    public static class C2577a {
        /* renamed from: a */
        public int f9241a;
        /* renamed from: b */
        public int f9242b;
        /* renamed from: c */
        public long f9243c;
        /* renamed from: d */
        public long f9244d;
        /* renamed from: e */
        public long f9245e;
        /* renamed from: f */
        public boolean f9246f;
        /* renamed from: g */
        public String f9247g;

        public String toString() {
            int i = this.f9242b;
            String str = ",cpuTime:";
            String str2 = " tick , mDuration：";
            if (i == 0) {
                StringBuilder sb = new StringBuilder();
                sb.append("[[[ IDLE  ]]] cost ");
                sb.append(this.f9243c);
                sb.append(str2);
                sb.append(this.f9244d);
                sb.append(str);
                sb.append(this.f9245e);
                return sb.toString();
            } else if (i == 1) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("[[[ Long IDLE  ]]] cost ");
                sb2.append(this.f9243c);
                sb2.append(str2);
                sb2.append(this.f9244d);
                sb2.append(str);
                sb2.append(this.f9245e);
                return sb2.toString();
            } else if (i == 2) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append("[[[  1 msg  ]]] cost ");
                sb3.append(this.f9243c);
                sb3.append(str2);
                sb3.append(this.f9244d);
                sb3.append(str);
                sb3.append(this.f9245e);
                sb3.append(", msg:");
                sb3.append(this.f9247g);
                return sb3.toString();
            } else if (i == 3) {
                StringBuilder sb4 = new StringBuilder();
                sb4.append("[[[ 1 msg + IDLE  ]]] cost ");
                sb4.append(this.f9243c);
                sb4.append(str2);
                sb4.append(this.f9244d);
                sb4.append(str);
                sb4.append(this.f9245e);
                return sb4.toString();
            } else {
                String str3 = " msg:";
                String str4 = "cpuTime:";
                String str5 = "[[[ ";
                if (i == 4) {
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append(str5);
                    sb5.append(this.f9241a - 1);
                    sb5.append(" msgs  ]]] cost less than 1 tick, [[[  last msg ]]] cost more than ");
                    sb5.append(this.f9243c - 1);
                    sb5.append("tick ,, mDuration：");
                    sb5.append(this.f9244d);
                    sb5.append(str4);
                    sb5.append(this.f9245e);
                    sb5.append(str3);
                    sb5.append(this.f9247g);
                    return sb5.toString();
                } else if (i == 5) {
                    StringBuilder sb6 = new StringBuilder();
                    sb6.append(str5);
                    sb6.append(this.f9241a);
                    sb6.append(" msgs ]]] cost less than 1 tick but [[[  IDLE ]]] cost more than");
                    sb6.append(this.f9243c - 1);
                    sb6.append(" ticks, , mDuration：");
                    sb6.append(this.f9244d);
                    sb6.append(str4);
                    sb6.append(this.f9245e);
                    return sb6.toString();
                } else if (i == 6) {
                    StringBuilder sb7 = new StringBuilder();
                    sb7.append("[[[  1 msg  ]]] cost less than 1 tick , but [[[  IDLE ]]] cost more than");
                    sb7.append(this.f9243c - 1);
                    sb7.append(", , mDuration：");
                    sb7.append(this.f9244d);
                    sb7.append(str4);
                    sb7.append(this.f9245e);
                    return sb7.toString();
                } else {
                    String str6 = " cost cpuTime:";
                    if (i == 7) {
                        StringBuilder sb8 = new StringBuilder();
                        sb8.append(str5);
                        sb8.append(this.f9241a);
                        sb8.append(" msgs + IDLE  ]]] cost 1 tick , mDuration：");
                        sb8.append(this.f9244d);
                        sb8.append(str6);
                        sb8.append(this.f9245e);
                        return sb8.toString();
                    } else if (i == 8) {
                        StringBuilder sb9 = new StringBuilder();
                        sb9.append("[[[ 1 msgs ]]] cost ");
                        sb9.append(this.f9243c);
                        sb9.append(" ticks , mDuration：");
                        sb9.append(this.f9244d);
                        sb9.append(str6);
                        sb9.append(this.f9245e);
                        sb9.append(str3);
                        sb9.append(this.f9247g);
                        return sb9.toString();
                    } else if (i == 9) {
                        StringBuilder sb10 = new StringBuilder();
                        sb10.append(str5);
                        sb10.append(this.f9241a);
                        sb10.append(" msgs ]]] cost 1 tick , mDuration：");
                        sb10.append(this.f9244d);
                        sb10.append(str6);
                        sb10.append(this.f9245e);
                        return sb10.toString();
                    } else {
                        StringBuilder sb11 = new StringBuilder();
                        sb11.append("=========   UNKNOW =========  Type:");
                        sb11.append(this.f9242b);
                        sb11.append(" cost ticks ");
                        sb11.append(this.f9243c);
                        sb11.append(" msgs:");
                        sb11.append(this.f9241a);
                        return sb11.toString();
                    }
                }
            }
        }
    }

    /* renamed from: j */
    static /* synthetic */ int m12310j() {
        int i = f9232n;
        f9232n = i + 1;
        return i;
    }

    /* renamed from: a */
    public static void m12295a(int i, int i2) {
        if (f9222d) {
            if (i > 10) {
                f9223e = i;
            }
            if (i2 > 10) {
                f9226h = (long) i2;
            }
            f9224f = new ArrayList();
            m12294a();
            m12289a(m12304d());
        }
    }

    /* renamed from: a */
    public static void m12294a() {
        LooperTrace.m12472a(4);
        LooperMessageManager.m12459a().mo17054b();
        LooperMessageManager.m12459a().mo17055b((Printer) new Printer() {
            public void println(String str) {
                if (LooperMonitor.f9222d) {
                    LooperMonitor.f9234p = str;
                    if (!LooperMonitor.f9233o) {
                        LooperMonitor.f9233o = true;
                        LooperMonitor.f9236r = Process.myTid();
                        LooperMonitor.m12321u();
                    }
                    LooperMonitor.f9219a = LooperMonitor.f9225g.get();
                    if (LooperMonitor.f9220b != -1) {
                        long j = LooperMonitor.f9219a - LooperMonitor.f9220b;
                        if (j <= 0) {
                            LooperMonitor.m12310j();
                        } else {
                            int i = j == 1 ? LooperMonitor.f9232n > 1 ? 7 : LooperMonitor.f9232n == 1 ? 3 : 0 : LooperMonitor.f9232n > 1 ? 5 : LooperMonitor.f9232n == 1 ? 6 : 1;
                            long l = LooperMonitor.m12322v();
                            long uptimeMillis = SystemClock.uptimeMillis();
                            if (!LooperMonitor.f9235q) {
                                LooperMonitor.m12301b(LooperMonitor.m12320t(), l - LooperMonitor.f9229k, uptimeMillis - LooperMonitor.f9230l, j, i, LooperMonitor.f9232n, null);
                            }
                            LooperMonitor.f9229k = l;
                            LooperMonitor.f9230l = uptimeMillis;
                            LooperMonitor.f9232n = 1;
                        }
                    }
                }
            }
        });
        LooperMessageManager.m12459a().mo17052a((Printer) new Printer() {
            public void println(String str) {
                LooperMonitor.f9220b = LooperMonitor.f9225g.get();
                if (LooperMonitor.f9219a > 0) {
                    long j = LooperMonitor.f9220b - LooperMonitor.f9219a;
                    if (j > 0) {
                        long l = LooperMonitor.m12322v();
                        long uptimeMillis = SystemClock.uptimeMillis();
                        int i = (j > 1 ? 1 : (j == 1 ? 0 : -1));
                        int i2 = (i != 0 || LooperMonitor.f9232n <= 1) ? (i == 0 && LooperMonitor.f9232n == 1) ? 2 : (i <= 0 || LooperMonitor.f9232n <= 1) ? (i <= 0 || LooperMonitor.f9232n != 1) ? 0 : 8 : 4 : 9;
                        if (!LooperMonitor.f9235q) {
                            LooperMonitor.m12301b(LooperMonitor.m12320t(), l - LooperMonitor.f9229k, uptimeMillis - LooperMonitor.f9230l, j, i2, LooperMonitor.f9232n, str);
                        }
                        LooperMonitor.f9229k = l;
                        LooperMonitor.f9230l = uptimeMillis;
                        LooperMonitor.f9232n = 0;
                        LooperMonitor.f9219a = -1;
                    }
                }
            }
        });
        f9229k = m12322v();
        f9230l = SystemClock.uptimeMillis();
    }

    /* access modifiers changed from: private|static */
    /* renamed from: t */
    public static C2577a m12320t() {
        int size = f9224f.size();
        int i = f9223e;
        if (size == i) {
            f9237s = (f9237s + 1) % i;
            return (C2577a) f9224f.get(f9237s);
        }
        C2577a aVar = new C2577a();
        f9224f.add(aVar);
        f9237s++;
        return aVar;
    }

    /* access modifiers changed from: private|static */
    /* renamed from: b */
    public static void m12301b(C2577a aVar, long j, long j2, long j3, int i, int i2, String str) {
        aVar.f9245e = j;
        aVar.f9243c = j3;
        aVar.f9244d = j2;
        aVar.f9246f = false;
        aVar.f9241a = i2;
        if (str != null) {
            aVar.f9247g = str;
        }
        aVar.f9242b = i;
    }

    /* renamed from: b */
    public static JSONArray m12300b() {
        JSONArray jSONArray = new JSONArray();
        List<C2577a> c = m12303c();
        if (c == null) {
            return jSONArray;
        }
        int i = 0;
        for (C2577a aVar : c) {
            if (aVar != null) {
                i++;
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put(NotificationCompat.CATEGORY_MESSAGE, aVar.f9247g);
                    jSONObject.put("cpuDuration", aVar.f9245e);
                    jSONObject.put("duration", aVar.f9244d);
                    jSONObject.put("tick", aVar.f9243c);
                    jSONObject.put("type", aVar.f9242b);
                    jSONObject.put("count", aVar.f9241a);
                    jSONObject.put("id", i);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                jSONArray.put(jSONObject);
            }
        }
        return jSONArray;
    }

    /* renamed from: c */
    public static List<C2577a> m12303c() {
        if (f9224f == null) {
            return null;
        }
        f9235q = true;
        ArrayList arrayList = new ArrayList();
        if (f9224f.size() == f9223e) {
            for (int i = f9237s; i < f9224f.size(); i++) {
                arrayList.add((C2577a) f9224f.get(i));
            }
            for (int i2 = 0; i2 < f9237s; i2++) {
                arrayList.add((C2577a) f9224f.get(i2));
            }
        } else {
            arrayList.addAll(f9224f);
        }
        f9235q = false;
        return arrayList;
    }

    /* access modifiers changed from: private|static */
    /* renamed from: u */
    public static void m12321u() {
        f9228j = NpthHandlerThread.m12473a();
        f9227i = SystemClock.uptimeMillis();
        f9231m = new Handler(f9228j.getLooper());
        LooperTrace.m12472a(8);
        f9231m.postDelayed(new Runnable() {
            public void run() {
                long j;
                LooperMonitor.f9225g.set((SystemClock.uptimeMillis() - LooperMonitor.f9227i) / LooperMonitor.f9226h);
                long uptimeMillis = (SystemClock.uptimeMillis() - LooperMonitor.f9227i) % LooperMonitor.f9226h;
                if (uptimeMillis >= 95) {
                    LooperMonitor.f9225g.incrementAndGet();
                    j = LooperMonitor.f9226h << 1;
                } else {
                    j = LooperMonitor.f9226h;
                }
                LooperMonitor.f9231m.postDelayed(this, j - uptimeMillis);
            }
        }, f9226h);
    }

    /* renamed from: d */
    public static MessageQueue m12304d() {
        if (f9238t == null && Looper.getMainLooper() != null) {
            Looper mainLooper = Looper.getMainLooper();
            if (mainLooper == Looper.myLooper()) {
                f9238t = Looper.myQueue();
            } else if (VERSION.SDK_INT >= 23) {
                f9238t = mainLooper.getQueue();
            } else {
                try {
                    Field declaredField = mainLooper.getClass().getDeclaredField("mQueue");
                    declaredField.setAccessible(true);
                    f9238t = (MessageQueue) declaredField.get(mainLooper);
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        }
        return f9238t;
    }

    /* renamed from: a */
    private static Message m12289a(MessageQueue messageQueue) {
        Field field = f9239u;
        if (field == null) {
            try {
                f9239u = Class.forName("android.os.MessageQueue").getDeclaredField("mMessages");
                f9239u.setAccessible(true);
                return (Message) f9239u.get(messageQueue);
            } catch (Exception unused) {
                return null;
            }
        } else {
            try {
                return (Message) field.get(messageQueue);
            } catch (Exception unused2) {
                return null;
            }
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(6:12|13|14|15|16|17) */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0031, code lost:
            return r1;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:16:0x0028 */
    /* renamed from: a */
    public static org.json.JSONArray m12291a(int r7, long r8) {
        /*
        android.os.MessageQueue r0 = m12304d()
        org.json.JSONArray r1 = new org.json.JSONArray
        r1.<init>()
        if (r0 != 0) goto L_0x000c
        return r1
    L_0x000c:
        monitor-enter(r0)
        android.os.Message r2 = m12289a(r0)     // Catch:{ all -> 0x0032 }
        if (r2 != 0) goto L_0x0015
        monitor-exit(r0)     // Catch:{ all -> 0x0032 }
        return r1
    L_0x0015:
        r3 = 0
        r4 = 0
    L_0x0017:
        if (r2 == 0) goto L_0x0030
        if (r3 >= r7) goto L_0x0030
        int r3 = r3 + 1
        int r4 = r4 + 1
        org.json.JSONObject r5 = m12293a(r2, r8)     // Catch:{ all -> 0x0032 }
        java.lang.String r6 = "id"
        r5.put(r6, r4)     // Catch:{ JSONException -> 0x0028 }
    L_0x0028:
        r1.put(r5)     // Catch:{ all -> 0x0032 }
        android.os.Message r2 = m12288a(r2)     // Catch:{ all -> 0x0032 }
        goto L_0x0017
    L_0x0030:
        monitor-exit(r0)     // Catch:{ all -> 0x0032 }
        return r1
    L_0x0032:
        r7 = move-exception
        monitor-exit(r0)     // Catch:{ all -> 0x0032 }
        throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.tea.crash.p212a.LooperMonitor.m12291a(int, long):org.json.JSONArray");
    }

    /* access modifiers changed from: private|static */
    /* renamed from: v */
    public static long m12322v() {
        return CpuInfo.m12451a(f9236r);
    }

    /* renamed from: a */
    public static JSONObject m12292a(long j) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("message", f9234p);
            jSONObject.put("currentMessageCost", m12305e());
            jSONObject.put("currentMessageCpu", m12322v() - f9229k);
            jSONObject.put("currentTick", f9225g.get());
        } catch (Throwable th) {
            NpthLog.m12549a(th);
        }
        return jSONObject;
    }

    /* renamed from: a */
    private static JSONObject m12293a(Message message, long j) {
        JSONObject jSONObject = new JSONObject();
        if (message == null) {
            return jSONObject;
        }
        try {
            jSONObject.put("when", message.getWhen() - j);
            if (message.getCallback() != null) {
                jSONObject.put("callback", message.getCallback());
            }
            jSONObject.put("what", message.what);
            if (message.getTarget() != null) {
                jSONObject.put("target", message.getTarget());
            } else {
                jSONObject.put("barrier", message.arg1);
            }
            jSONObject.put("arg1", message.arg1);
            jSONObject.put("arg2", message.arg2);
            if (message.obj != null) {
                jSONObject.put("obj", message.obj);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    /* renamed from: e */
    public static long m12305e() {
        long uptimeMillis;
        long j;
        long j2;
        if (f9219a < 0) {
            uptimeMillis = SystemClock.uptimeMillis() - f9227i;
            j = f9220b;
            j2 = f9226h;
        } else {
            uptimeMillis = SystemClock.uptimeMillis() - f9227i;
            j = f9219a;
            j2 = f9226h;
        }
        return uptimeMillis - (j * j2);
    }

    /* renamed from: a */
    private static Message m12288a(Message message) {
        Field field = f9240v;
        if (field == null) {
            try {
                f9240v = Class.forName("android.os.Message").getDeclaredField("next");
                f9240v.setAccessible(true);
                Message message2 = (Message) f9240v.get(message);
                if (f9221c) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("[getNextMessage] success get next msg :");
                    sb.append(message2);
                    Log.i("LooperMonitor", sb.toString());
                }
                return message2;
            } catch (Exception unused) {
                return null;
            }
        } else {
            try {
                return (Message) field.get(message);
            } catch (Exception unused2) {
                return null;
            }
        }
    }
}
