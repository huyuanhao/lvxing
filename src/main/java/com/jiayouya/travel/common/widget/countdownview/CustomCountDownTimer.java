package com.jiayouya.travel.common.widget.countdownview;

import android.os.Handler;
import android.os.SystemClock;

/* renamed from: com.jiayouya.travel.common.widget.countdownview.c */
public abstract class CustomCountDownTimer {
    /* renamed from: a */
    private final long f9801a;
    /* access modifiers changed from: private|final */
    /* renamed from: b */
    public final long f9802b;
    /* access modifiers changed from: private */
    /* renamed from: c */
    public long f9803c;
    /* access modifiers changed from: private */
    /* renamed from: d */
    public boolean f9804d = false;
    /* access modifiers changed from: private */
    /* renamed from: e */
    public boolean f9805e = false;
    /* renamed from: f */
    private Handler f9806f = new Handler() {
        /* JADX WARNING: Code restructure failed: missing block: B:17:0x0055, code lost:
            return;
     */
        /* JADX WARNING: Code restructure failed: missing block: B:19:0x0057, code lost:
            return;
     */
        public void handleMessage(android.os.Message r8) {
            /*
            r7 = this;
            com.jiayouya.travel.common.widget.countdownview.c r8 = com.jiayouya.travel.common.widget.countdownview.CustomCountDownTimer.this
            monitor-enter(r8)
            com.jiayouya.travel.common.widget.countdownview.c r0 = com.jiayouya.travel.common.widget.countdownview.CustomCountDownTimer.this     // Catch:{ all -> 0x0058 }
            boolean r0 = r0.f9804d     // Catch:{ all -> 0x0058 }
            if (r0 != 0) goto L_0x0056
            com.jiayouya.travel.common.widget.countdownview.c r0 = com.jiayouya.travel.common.widget.countdownview.CustomCountDownTimer.this     // Catch:{ all -> 0x0058 }
            boolean r0 = r0.f9805e     // Catch:{ all -> 0x0058 }
            if (r0 == 0) goto L_0x0014
            goto L_0x0056
        L_0x0014:
            com.jiayouya.travel.common.widget.countdownview.c r0 = com.jiayouya.travel.common.widget.countdownview.CustomCountDownTimer.this     // Catch:{ all -> 0x0058 }
            long r0 = r0.f9803c     // Catch:{ all -> 0x0058 }
            long r2 = android.os.SystemClock.elapsedRealtime()     // Catch:{ all -> 0x0058 }
            long r0 = r0 - r2
            r2 = 0
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 > 0) goto L_0x002b
            com.jiayouya.travel.common.widget.countdownview.c r0 = com.jiayouya.travel.common.widget.countdownview.CustomCountDownTimer.this     // Catch:{ all -> 0x0058 }
            r0.mo20046a()     // Catch:{ all -> 0x0058 }
            goto L_0x0054
        L_0x002b:
            long r4 = android.os.SystemClock.elapsedRealtime()     // Catch:{ all -> 0x0058 }
            com.jiayouya.travel.common.widget.countdownview.c r6 = com.jiayouya.travel.common.widget.countdownview.CustomCountDownTimer.this     // Catch:{ all -> 0x0058 }
            r6.mo20047a(r0)     // Catch:{ all -> 0x0058 }
            com.jiayouya.travel.common.widget.countdownview.c r0 = com.jiayouya.travel.common.widget.countdownview.CustomCountDownTimer.this     // Catch:{ all -> 0x0058 }
            long r0 = r0.f9802b     // Catch:{ all -> 0x0058 }
            long r4 = r4 + r0
            long r0 = android.os.SystemClock.elapsedRealtime()     // Catch:{ all -> 0x0058 }
            long r4 = r4 - r0
        L_0x0040:
            int r0 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r0 >= 0) goto L_0x004c
            com.jiayouya.travel.common.widget.countdownview.c r0 = com.jiayouya.travel.common.widget.countdownview.CustomCountDownTimer.this     // Catch:{ all -> 0x0058 }
            long r0 = r0.f9802b     // Catch:{ all -> 0x0058 }
            long r4 = r4 + r0
            goto L_0x0040
        L_0x004c:
            r0 = 1
            android.os.Message r0 = r7.obtainMessage(r0)     // Catch:{ all -> 0x0058 }
            r7.sendMessageDelayed(r0, r4)     // Catch:{ all -> 0x0058 }
        L_0x0054:
            monitor-exit(r8)     // Catch:{ all -> 0x0058 }
            return
        L_0x0056:
            monitor-exit(r8)     // Catch:{ all -> 0x0058 }
            return
        L_0x0058:
            r0 = move-exception
            monitor-exit(r8)     // Catch:{ all -> 0x0058 }
            throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.jiayouya.travel.common.widget.countdownview.CustomCountDownTimer.C29121.handleMessage(android.os.Message):void");
        }
    };

    /* renamed from: a */
    public abstract void mo20046a();

    /* renamed from: a */
    public abstract void mo20047a(long j);

    public CustomCountDownTimer(long j, long j2) {
        if (j2 > 1000) {
            j += 15;
        }
        this.f9801a = j;
        this.f9802b = j2;
    }

    /* renamed from: b */
    private synchronized CustomCountDownTimer m13164b(long j) {
        this.f9804d = false;
        if (j <= 0) {
            mo20046a();
            return this;
        }
        this.f9803c = SystemClock.elapsedRealtime() + j;
        this.f9806f.sendMessage(this.f9806f.obtainMessage(1));
        return this;
    }

    /* renamed from: b */
    public final synchronized void mo20064b() {
        m13164b(this.f9801a);
    }

    /* renamed from: c */
    public final synchronized void mo20065c() {
        this.f9804d = true;
        this.f9806f.removeMessages(1);
    }
}
