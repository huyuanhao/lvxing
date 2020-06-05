package com.bytedance.tea.crash.p218e;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.util.Printer;
import android.util.SparseArray;
import com.bytedance.tea.crash.p221g.NpthLog;
import java.lang.reflect.Field;
import java.util.LinkedList;
import java.util.List;

/* renamed from: com.bytedance.tea.crash.e.f */
public class LooperMessageManager implements Callback {
    /* access modifiers changed from: private|static */
    /* renamed from: a */
    public static Printer f9336a;
    /* renamed from: b */
    private static LooperMessageManager f9337b;
    /* access modifiers changed from: private|static|final */
    /* renamed from: j */
    public static final Printer f9338j = new Printer() {
        public void println(String str) {
            if (str != null) {
                if (str.startsWith(">>>>> Dispatching")) {
                    LooperMessageManager.m12459a().mo17053a(str);
                } else if (str.startsWith("<<<<< Finished")) {
                    LooperMessageManager.m12459a().mo17056b(str);
                }
                if (!(LooperMessageManager.f9336a == null || LooperMessageManager.f9336a == LooperMessageManager.f9338j)) {
                    LooperMessageManager.f9336a.println(str);
                }
            }
        }
    };
    /* renamed from: c */
    private Handler f9339c = new Handler(NpthHandlerThread.m12473a().getLooper(), this);
    /* renamed from: d */
    private int f9340d = 0;
    /* renamed from: e */
    private long f9341e;
    /* renamed from: f */
    private long f9342f;
    /* renamed from: g */
    private final SparseArray<List<Runnable>> f9343g = new SparseArray<>();
    /* renamed from: h */
    private final List<Printer> f9344h = new LinkedList();
    /* renamed from: i */
    private final List<Printer> f9345i = new LinkedList();
    /* renamed from: k */
    private boolean f9346k = false;
    /* renamed from: l */
    private boolean f9347l;

    private LooperMessageManager() {
        mo17054b();
    }

    /* renamed from: a */
    public static LooperMessageManager m12459a() {
        if (f9337b == null) {
            synchronized (LooperMessageManager.class) {
                if (f9337b == null) {
                    f9337b = new LooperMessageManager();
                }
            }
        }
        return f9337b;
    }

    /* renamed from: b */
    public void mo17054b() {
        if (!this.f9346k) {
            this.f9346k = true;
            f9336a = m12464e();
            if (f9336a == f9338j) {
                f9336a = null;
            }
            Looper.getMainLooper().setMessageLogging(f9338j);
        }
    }

    /* renamed from: e */
    private Printer m12464e() {
        try {
            Field declaredField = Class.forName("android.os.Looper").getDeclaredField("mLogging");
            declaredField.setAccessible(true);
            return (Printer) declaredField.get(Looper.getMainLooper());
        } catch (Exception e) {
            NpthLog.m12550b(e);
            return null;
        }
    }

    /* renamed from: a */
    public void mo17050a(long j, Runnable runnable) {
        mo17051a(j, runnable, 1, 0);
    }

    /* renamed from: a */
    public void mo17051a(long j, Runnable runnable, int i, long j2) {
        if (j >= 0) {
            for (int i2 = 0; i2 < i; i2++) {
                int i3 = (int) j;
                List list = (List) this.f9343g.get(i3);
                if (list == null) {
                    synchronized (this.f9343g) {
                        list = (List) this.f9343g.get(i3);
                        if (list == null) {
                            list = new LinkedList();
                            this.f9343g.put(i3, list);
                        }
                    }
                }
                list.add(runnable);
                j += j2;
            }
        }
    }

    /* renamed from: a */
    public void mo17052a(Printer printer) {
        this.f9345i.add(printer);
    }

    /* renamed from: b */
    public synchronized void mo17055b(Printer printer) {
        this.f9344h.add(printer);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo17053a(String str) {
        if (!this.f9347l) {
            LooperTrace.m12472a(32);
            this.f9347l = true;
        }
        this.f9341e = SystemClock.uptimeMillis();
        try {
            m12461a(this.f9344h, str);
            this.f9339c.sendEmptyMessage(0);
        } catch (Exception e) {
            NpthLog.m12549a((Throwable) e);
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public void mo17056b(String str) {
        this.f9342f = SystemClock.uptimeMillis();
        try {
            this.f9339c.removeMessages(2);
            m12461a(this.f9345i, str);
            this.f9339c.sendEmptyMessage(1);
        } catch (Exception e) {
            NpthLog.m12550b(e);
        }
    }

    public boolean handleMessage(Message message) {
        if (this.f9339c.hasMessages(0)) {
            return true;
        }
        int i = message.what;
        if (i == 0) {
            this.f9340d = 0;
            if (this.f9343g.size() != 0 && this.f9343g.keyAt(0) == 0) {
                m12460a((List) this.f9343g.valueAt(0));
                this.f9340d++;
            }
        } else if (i == 1) {
            this.f9339c.removeMessages(2);
            if (this.f9343g.size() != 0) {
                SparseArray<List<Runnable>> sparseArray = this.f9343g;
                if (sparseArray.keyAt(sparseArray.size() - 1) == 0) {
                    m12460a((List) this.f9343g.get(ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED));
                }
            }
            return true;
        } else if (i == 2) {
            m12460a((List) this.f9343g.valueAt(this.f9340d));
            this.f9340d++;
        }
        if (this.f9340d >= this.f9343g.size()) {
            return true;
        }
        long keyAt = (long) this.f9343g.keyAt(this.f9340d);
        if (keyAt != 2147483647L) {
            this.f9339c.sendEmptyMessageAtTime(2, this.f9341e + keyAt);
        }
        return true;
    }

    /* renamed from: a */
    private static void m12460a(List<? extends Runnable> list) {
        if (list != null && !list.isEmpty()) {
            try {
                for (Runnable run : list) {
                    run.run();
                }
            } catch (Exception e) {
                NpthLog.m12549a((Throwable) e);
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0028, code lost:
            return;
     */
    /* renamed from: a */
    private synchronized void m12461a(java.util.List<? extends android.util.Printer> r2, java.lang.String r3) {
        /*
        r1 = this;
        monitor-enter(r1)
        if (r2 == 0) goto L_0x0027
        boolean r0 = r2.isEmpty()     // Catch:{ all -> 0x0024 }
        if (r0 == 0) goto L_0x000a
        goto L_0x0027
    L_0x000a:
        java.util.Iterator r2 = r2.iterator()     // Catch:{ Exception -> 0x001e }
    L_0x000e:
        boolean r0 = r2.hasNext()     // Catch:{ Exception -> 0x001e }
        if (r0 == 0) goto L_0x0022
        java.lang.Object r0 = r2.next()     // Catch:{ Exception -> 0x001e }
        android.util.Printer r0 = (android.util.Printer) r0     // Catch:{ Exception -> 0x001e }
        r0.println(r3)     // Catch:{ Exception -> 0x001e }
        goto L_0x000e
    L_0x001e:
        r2 = move-exception
        com.bytedance.tea.crash.p221g.NpthLog.m12549a(r2)     // Catch:{ all -> 0x0024 }
    L_0x0022:
        monitor-exit(r1)
        return
    L_0x0024:
        r2 = move-exception
        monitor-exit(r1)
        throw r2
    L_0x0027:
        monitor-exit(r1)
        return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.tea.crash.p218e.LooperMessageManager.m12461a(java.util.List, java.lang.String):void");
    }
}
