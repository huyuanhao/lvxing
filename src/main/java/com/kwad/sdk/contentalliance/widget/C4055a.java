package com.kwad.sdk.contentalliance.widget;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.view.GestureDetector;
import android.view.GestureDetector.OnDoubleTapListener;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;

/* renamed from: com.kwad.sdk.contentalliance.widget.a */
public class C4055a extends GestureDetector {
    /* renamed from: b */
    public static final int f13616b = ViewConfiguration.getDoubleTapTimeout();
    /* renamed from: g */
    private static final int f13617g = ViewConfiguration.getLongPressTimeout();
    /* renamed from: h */
    private static final int f13618h = ViewConfiguration.getTapTimeout();
    /* renamed from: A */
    private long f13619A;
    /* renamed from: B */
    private VelocityTracker f13620B;
    /* renamed from: a */
    private int f13621a;
    /* renamed from: c */
    private int f13622c;
    /* renamed from: d */
    private int f13623d;
    /* renamed from: e */
    private int f13624e;
    /* renamed from: f */
    private int f13625f;
    /* renamed from: i */
    private final Handler f13626i;
    /* access modifiers changed from: private|final */
    /* renamed from: j */
    public final OnGestureListener f13627j;
    /* access modifiers changed from: private */
    /* renamed from: k */
    public OnDoubleTapListener f13628k;
    /* access modifiers changed from: private */
    /* renamed from: l */
    public boolean f13629l;
    /* access modifiers changed from: private */
    /* renamed from: m */
    public boolean f13630m;
    /* renamed from: n */
    private boolean f13631n;
    /* renamed from: o */
    private boolean f13632o;
    /* renamed from: p */
    private boolean f13633p;
    /* renamed from: q */
    private boolean f13634q;
    /* renamed from: r */
    private boolean f13635r;
    /* access modifiers changed from: private */
    /* renamed from: s */
    public MotionEvent f13636s;
    /* renamed from: t */
    private MotionEvent f13637t;
    /* renamed from: u */
    private boolean f13638u;
    /* renamed from: v */
    private float f13639v;
    /* renamed from: w */
    private float f13640w;
    /* renamed from: x */
    private float f13641x;
    /* renamed from: y */
    private float f13642y;
    /* renamed from: z */
    private boolean f13643z;

    /* renamed from: com.kwad.sdk.contentalliance.widget.a$a */
    private class C4056a extends Handler {
        C4056a() {
        }

        C4056a(Handler handler) {
            super(handler.getLooper());
        }

        public void handleMessage(Message message) {
            int i = message.what;
            if (i == 1) {
                C4055a.this.f13627j.onShowPress(C4055a.this.f13636s);
            } else if (i == 2) {
                C4055a.this.m16813c();
            } else if (i != 3 || C4055a.this.f13628k == null) {
            } else {
                if (!C4055a.this.f13629l) {
                    C4055a.this.f13628k.onSingleTapConfirmed(C4055a.this.f13636s);
                } else {
                    C4055a.this.f13630m = true;
                }
            }
        }
    }

    public C4055a(Context context, OnGestureListener onGestureListener) {
        this(context, onGestureListener, null);
    }

    public C4055a(Context context, OnGestureListener onGestureListener, Handler handler) {
        super(context, onGestureListener, handler);
        this.f13619A = (long) f13616b;
        if (handler != null) {
            this.f13626i = new C4056a(handler);
        } else {
            this.f13626i = new C4056a();
        }
        this.f13627j = onGestureListener;
        if (onGestureListener instanceof OnDoubleTapListener) {
            setOnDoubleTapListener((OnDoubleTapListener) onGestureListener);
        }
        m16808a(context);
    }

    /* renamed from: a */
    private void m16807a() {
        this.f13626i.removeMessages(1);
        this.f13626i.removeMessages(2);
        this.f13626i.removeMessages(3);
        this.f13620B.recycle();
        this.f13620B = null;
        this.f13638u = false;
        this.f13629l = false;
        this.f13633p = false;
        this.f13634q = false;
        this.f13630m = false;
        this.f13631n = false;
        this.f13632o = false;
        this.f13635r = false;
    }

    /* renamed from: a */
    private void m16808a(Context context) {
        int i;
        int i2;
        if (this.f13627j != null) {
            this.f13643z = true;
            int i3 = 300;
            if (context == null) {
                i = ViewConfiguration.getTouchSlop();
                this.f13624e = ViewConfiguration.getMinimumFlingVelocity();
                this.f13625f = ViewConfiguration.getMaximumFlingVelocity();
                i3 = i;
                i2 = 300;
            } else {
                ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
                int scaledTouchSlop = viewConfiguration.getScaledTouchSlop();
                i2 = viewConfiguration.getScaledDoubleTapSlop();
                this.f13624e = viewConfiguration.getScaledMinimumFlingVelocity();
                this.f13625f = viewConfiguration.getScaledMaximumFlingVelocity();
                i = scaledTouchSlop;
            }
            this.f13621a = i * i;
            this.f13622c = i3 * i3;
            this.f13623d = i2 * i2;
            return;
        }
        throw new NullPointerException("OnGestureListener must not be null");
    }

    /* renamed from: a */
    private boolean m16809a(MotionEvent motionEvent, MotionEvent motionEvent2, MotionEvent motionEvent3) {
        if (!this.f13634q) {
            return false;
        }
        long eventTime = motionEvent3.getEventTime() - motionEvent2.getEventTime();
        if (eventTime > this.f13619A || eventTime < 10) {
            return false;
        }
        int x = ((int) motionEvent.getX()) - ((int) motionEvent3.getX());
        int y = ((int) motionEvent.getY()) - ((int) motionEvent3.getY());
        boolean z = true;
        if ((x * x) + (y * y) >= ((motionEvent.getFlags() & 8) != 0 ? 0 : this.f13623d)) {
            z = false;
        }
        return z;
    }

    /* renamed from: b */
    private void m16812b() {
        this.f13626i.removeMessages(1);
        this.f13626i.removeMessages(2);
        this.f13626i.removeMessages(3);
        this.f13638u = false;
        this.f13633p = false;
        this.f13634q = false;
        this.f13630m = false;
        this.f13631n = false;
        this.f13632o = false;
        this.f13635r = false;
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m16813c() {
        this.f13626i.removeMessages(3);
        this.f13630m = false;
        this.f13631n = true;
        this.f13627j.onLongPress(this.f13636s);
    }

    /* renamed from: a */
    public void mo23715a(long j) {
        this.f13619A = j;
    }

    public boolean isLongpressEnabled() {
        return this.f13643z;
    }

    /* JADX WARNING: Removed duplicated region for block: B:115:0x0227  */
    /* JADX WARNING: Removed duplicated region for block: B:118:0x023e  */
    public boolean onTouchEvent(android.view.MotionEvent r14) {
        /*
        r13 = this;
        int r0 = r14.getAction()
        android.view.VelocityTracker r1 = r13.f13620B
        if (r1 != 0) goto L_0x000e
        android.view.VelocityTracker r1 = android.view.VelocityTracker.obtain()
        r13.f13620B = r1
    L_0x000e:
        android.view.VelocityTracker r1 = r13.f13620B
        r1.addMovement(r14)
        r0 = r0 & 255(0xff, float:3.57E-43)
        r1 = 6
        r2 = 1
        r3 = 0
        if (r0 != r1) goto L_0x001c
        r4 = 1
        goto L_0x001d
    L_0x001c:
        r4 = 0
    L_0x001d:
        if (r4 == 0) goto L_0x0024
        int r5 = r14.getActionIndex()
        goto L_0x0025
    L_0x0024:
        r5 = -1
    L_0x0025:
        int r6 = r14.getFlags()
        r6 = r6 & 8
        if (r6 == 0) goto L_0x002f
        r6 = 1
        goto L_0x0030
    L_0x002f:
        r6 = 0
    L_0x0030:
        int r7 = r14.getPointerCount()
        r8 = 0
        r9 = 0
        r10 = 0
        r11 = 0
    L_0x0038:
        if (r9 >= r7) goto L_0x004a
        if (r5 != r9) goto L_0x003d
        goto L_0x0047
    L_0x003d:
        float r12 = r14.getX(r9)
        float r10 = r10 + r12
        float r12 = r14.getY(r9)
        float r11 = r11 + r12
    L_0x0047:
        int r9 = r9 + 1
        goto L_0x0038
    L_0x004a:
        if (r4 == 0) goto L_0x004f
        int r4 = r7 + -1
        goto L_0x0050
    L_0x004f:
        r4 = r7
    L_0x0050:
        float r4 = (float) r4
        float r10 = r10 / r4
        float r11 = r11 / r4
        r4 = 2
        r5 = 3
        if (r0 == 0) goto L_0x01df
        r9 = 1000(0x3e8, float:1.401E-42)
        if (r0 == r2) goto L_0x0148
        if (r0 == r4) goto L_0x00c5
        if (r0 == r5) goto L_0x00c0
        r2 = 5
        if (r0 == r2) goto L_0x00b3
        if (r0 == r1) goto L_0x0066
        goto L_0x0269
    L_0x0066:
        r13.f13639v = r10
        r13.f13641x = r10
        r13.f13640w = r11
        r13.f13642y = r11
        android.view.VelocityTracker r0 = r13.f13620B
        int r1 = r13.f13625f
        float r1 = (float) r1
        r0.computeCurrentVelocity(r9, r1)
        int r0 = r14.getActionIndex()
        int r1 = r14.getPointerId(r0)
        android.view.VelocityTracker r2 = r13.f13620B
        float r2 = r2.getXVelocity(r1)
        android.view.VelocityTracker r4 = r13.f13620B
        float r1 = r4.getYVelocity(r1)
        r4 = 0
    L_0x008b:
        if (r4 >= r7) goto L_0x0269
        if (r4 != r0) goto L_0x0090
        goto L_0x00b0
    L_0x0090:
        int r5 = r14.getPointerId(r4)
        android.view.VelocityTracker r6 = r13.f13620B
        float r6 = r6.getXVelocity(r5)
        float r6 = r6 * r2
        android.view.VelocityTracker r9 = r13.f13620B
        float r5 = r9.getYVelocity(r5)
        float r5 = r5 * r1
        float r6 = r6 + r5
        int r5 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
        if (r5 >= 0) goto L_0x00b0
        android.view.VelocityTracker r14 = r13.f13620B
        r14.clear()
        goto L_0x0269
    L_0x00b0:
        int r4 = r4 + 1
        goto L_0x008b
    L_0x00b3:
        r13.f13639v = r10
        r13.f13641x = r10
        r13.f13640w = r11
        r13.f13642y = r11
        r13.m16812b()
        goto L_0x0269
    L_0x00c0:
        r13.m16807a()
        goto L_0x0269
    L_0x00c5:
        boolean r0 = r13.f13631n
        if (r0 != 0) goto L_0x0269
        boolean r0 = r13.f13632o
        if (r0 == 0) goto L_0x00cf
        goto L_0x0269
    L_0x00cf:
        float r0 = r13.f13639v
        float r0 = r0 - r10
        float r1 = r13.f13640w
        float r1 = r1 - r11
        boolean r7 = r13.f13638u
        if (r7 == 0) goto L_0x00e2
        android.view.GestureDetector$OnDoubleTapListener r0 = r13.f13628k
        boolean r14 = r0.onDoubleTapEvent(r14)
        r3 = r3 | r14
        goto L_0x0269
    L_0x00e2:
        boolean r7 = r13.f13633p
        if (r7 == 0) goto L_0x0128
        float r7 = r13.f13641x
        float r7 = r10 - r7
        int r7 = (int) r7
        float r8 = r13.f13642y
        float r8 = r11 - r8
        int r8 = (int) r8
        int r7 = r7 * r7
        int r8 = r8 * r8
        int r7 = r7 + r8
        if (r6 == 0) goto L_0x00f9
        r8 = 0
        goto L_0x00fb
    L_0x00f9:
        int r8 = r13.f13621a
    L_0x00fb:
        if (r7 <= r8) goto L_0x011b
        android.view.GestureDetector$OnGestureListener r8 = r13.f13627j
        android.view.MotionEvent r9 = r13.f13636s
        boolean r14 = r8.onScroll(r9, r14, r0, r1)
        r13.f13639v = r10
        r13.f13640w = r11
        r13.f13633p = r3
        android.os.Handler r0 = r13.f13626i
        r0.removeMessages(r5)
        android.os.Handler r0 = r13.f13626i
        r0.removeMessages(r2)
        android.os.Handler r0 = r13.f13626i
        r0.removeMessages(r4)
        goto L_0x011c
    L_0x011b:
        r14 = 0
    L_0x011c:
        if (r6 == 0) goto L_0x0120
        r0 = 0
        goto L_0x0122
    L_0x0120:
        int r0 = r13.f13622c
    L_0x0122:
        if (r7 <= r0) goto L_0x01dc
        r13.f13634q = r3
        goto L_0x01dc
    L_0x0128:
        float r2 = java.lang.Math.abs(r0)
        r4 = 1065353216(0x3f800000, float:1.0)
        int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
        if (r2 >= 0) goto L_0x013a
        float r2 = java.lang.Math.abs(r1)
        int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
        if (r2 < 0) goto L_0x0269
    L_0x013a:
        android.view.GestureDetector$OnGestureListener r2 = r13.f13627j
        android.view.MotionEvent r3 = r13.f13636s
        boolean r3 = r2.onScroll(r3, r14, r0, r1)
        r13.f13639v = r10
        r13.f13640w = r11
        goto L_0x0269
    L_0x0148:
        r13.f13629l = r3
        android.view.MotionEvent r0 = android.view.MotionEvent.obtain(r14)
        boolean r1 = r13.f13638u
        if (r1 == 0) goto L_0x015a
        android.view.GestureDetector$OnDoubleTapListener r1 = r13.f13628k
        boolean r14 = r1.onDoubleTapEvent(r14)
        r14 = r14 | r3
        goto L_0x01b9
    L_0x015a:
        boolean r1 = r13.f13631n
        if (r1 == 0) goto L_0x0166
        android.os.Handler r14 = r13.f13626i
        r14.removeMessages(r5)
        r13.f13631n = r3
        goto L_0x01b8
    L_0x0166:
        boolean r1 = r13.f13633p
        if (r1 == 0) goto L_0x0181
        boolean r1 = r13.f13635r
        if (r1 != 0) goto L_0x0181
        android.view.GestureDetector$OnGestureListener r1 = r13.f13627j
        boolean r1 = r1.onSingleTapUp(r14)
        boolean r5 = r13.f13630m
        if (r5 == 0) goto L_0x017f
        android.view.GestureDetector$OnDoubleTapListener r5 = r13.f13628k
        if (r5 == 0) goto L_0x017f
        r5.onSingleTapConfirmed(r14)
    L_0x017f:
        r14 = r1
        goto L_0x01b9
    L_0x0181:
        boolean r1 = r13.f13635r
        if (r1 != 0) goto L_0x01b8
        android.view.VelocityTracker r1 = r13.f13620B
        int r5 = r14.getPointerId(r3)
        int r6 = r13.f13625f
        float r6 = (float) r6
        r1.computeCurrentVelocity(r9, r6)
        float r6 = r1.getYVelocity(r5)
        float r1 = r1.getXVelocity(r5)
        float r5 = java.lang.Math.abs(r6)
        int r7 = r13.f13624e
        float r7 = (float) r7
        int r5 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
        if (r5 > 0) goto L_0x01af
        float r5 = java.lang.Math.abs(r1)
        int r7 = r13.f13624e
        float r7 = (float) r7
        int r5 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
        if (r5 <= 0) goto L_0x01b8
    L_0x01af:
        android.view.GestureDetector$OnGestureListener r5 = r13.f13627j
        android.view.MotionEvent r7 = r13.f13636s
        boolean r14 = r5.onFling(r7, r14, r1, r6)
        goto L_0x01b9
    L_0x01b8:
        r14 = 0
    L_0x01b9:
        android.view.MotionEvent r1 = r13.f13637t
        if (r1 == 0) goto L_0x01c0
        r1.recycle()
    L_0x01c0:
        r13.f13637t = r0
        android.view.VelocityTracker r0 = r13.f13620B
        if (r0 == 0) goto L_0x01cc
        r0.recycle()
        r0 = 0
        r13.f13620B = r0
    L_0x01cc:
        r13.f13638u = r3
        r13.f13630m = r3
        r13.f13635r = r3
        android.os.Handler r0 = r13.f13626i
        r0.removeMessages(r2)
        android.os.Handler r0 = r13.f13626i
        r0.removeMessages(r4)
    L_0x01dc:
        r3 = r14
        goto L_0x0269
    L_0x01df:
        android.view.GestureDetector$OnDoubleTapListener r0 = r13.f13628k
        if (r0 == 0) goto L_0x021a
        android.os.Handler r0 = r13.f13626i
        boolean r0 = r0.hasMessages(r5)
        if (r0 == 0) goto L_0x01f0
        android.os.Handler r1 = r13.f13626i
        r1.removeMessages(r5)
    L_0x01f0:
        android.view.MotionEvent r1 = r13.f13636s
        if (r1 == 0) goto L_0x0213
        android.view.MotionEvent r6 = r13.f13637t
        if (r6 == 0) goto L_0x0213
        if (r0 == 0) goto L_0x0213
        boolean r0 = r13.m16809a(r1, r6, r14)
        if (r0 == 0) goto L_0x0213
        r13.f13638u = r2
        android.view.GestureDetector$OnDoubleTapListener r0 = r13.f13628k
        android.view.MotionEvent r1 = r13.f13636s
        boolean r0 = r0.onDoubleTap(r1)
        r0 = r0 | r3
        android.view.GestureDetector$OnDoubleTapListener r1 = r13.f13628k
        boolean r1 = r1.onDoubleTapEvent(r14)
        r0 = r0 | r1
        goto L_0x021b
    L_0x0213:
        android.os.Handler r0 = r13.f13626i
        long r6 = r13.f13619A
        r0.sendEmptyMessageDelayed(r5, r6)
    L_0x021a:
        r0 = 0
    L_0x021b:
        r13.f13639v = r10
        r13.f13641x = r10
        r13.f13640w = r11
        r13.f13642y = r11
        android.view.MotionEvent r1 = r13.f13636s
        if (r1 == 0) goto L_0x022a
        r1.recycle()
    L_0x022a:
        android.view.MotionEvent r1 = android.view.MotionEvent.obtain(r14)
        r13.f13636s = r1
        r13.f13633p = r2
        r13.f13634q = r2
        r13.f13629l = r2
        r13.f13631n = r3
        r13.f13630m = r3
        boolean r1 = r13.f13643z
        if (r1 == 0) goto L_0x0252
        android.os.Handler r1 = r13.f13626i
        r1.removeMessages(r4)
        android.os.Handler r1 = r13.f13626i
        android.view.MotionEvent r3 = r13.f13636s
        long r5 = r3.getDownTime()
        int r3 = f13617g
        long r7 = (long) r3
        long r5 = r5 + r7
        r1.sendEmptyMessageAtTime(r4, r5)
    L_0x0252:
        android.os.Handler r1 = r13.f13626i
        android.view.MotionEvent r3 = r13.f13636s
        long r3 = r3.getDownTime()
        int r5 = f13618h
        long r5 = (long) r5
        long r3 = r3 + r5
        r1.sendEmptyMessageAtTime(r2, r3)
        android.view.GestureDetector$OnGestureListener r1 = r13.f13627j
        boolean r14 = r1.onDown(r14)
        r3 = r0 | r14
    L_0x0269:
        return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.sdk.contentalliance.widget.C4055a.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public void setIsLongpressEnabled(boolean z) {
        this.f13643z = z;
    }

    public void setOnDoubleTapListener(OnDoubleTapListener onDoubleTapListener) {
        this.f13628k = onDoubleTapListener;
    }
}
