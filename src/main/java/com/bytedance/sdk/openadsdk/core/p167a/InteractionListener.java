package com.bytedance.sdk.openadsdk.core.p167a;

import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewConfiguration;
import com.bytedance.sdk.openadsdk.core.InternalContainer;
import com.bytedance.sdk.openadsdk.core.p174h.SdkSwitch;

/* renamed from: com.bytedance.sdk.openadsdk.core.a.c */
public abstract class InteractionListener implements OnClickListener, OnTouchListener {
    /* renamed from: A */
    protected static int f7212A = ViewConfiguration.get(InternalContainer.m10059a()).getScaledTouchSlop();
    /* renamed from: a */
    private static float f7213a = 0.0f;
    /* renamed from: b */
    private static float f7214b = 0.0f;
    /* renamed from: c */
    private static float f7215c = 0.0f;
    /* renamed from: d */
    private static float f7216d = 0.0f;
    /* renamed from: e */
    private static long f7217e = 0;
    /* renamed from: B */
    protected SparseArray<C2204a> f7218B = new SparseArray<>();
    /* renamed from: r */
    protected int f7219r;
    /* renamed from: s */
    protected int f7220s;
    /* renamed from: t */
    protected int f7221t;
    /* renamed from: u */
    protected int f7222u;
    /* renamed from: v */
    protected long f7223v;
    /* renamed from: w */
    protected long f7224w;
    /* renamed from: x */
    protected int f7225x;
    /* renamed from: y */
    protected int f7226y;
    /* renamed from: z */
    protected int f7227z;

    /* compiled from: InteractionListener */
    /* renamed from: com.bytedance.sdk.openadsdk.core.a.c$a */
    public static class C2204a {
        /* renamed from: a */
        public int f7228a = -1;
        /* renamed from: b */
        public double f7229b;
        /* renamed from: c */
        public double f7230c;
        /* renamed from: d */
        public long f7231d;

        public C2204a(int i, double d, double d2, long j) {
            this.f7228a = i;
            this.f7229b = d;
            this.f7230c = d2;
            this.f7231d = j;
        }
    }

    /* renamed from: a */
    public abstract void mo14920a(View view, int i, int i2, int i3, int i4);

    static {
        if (ViewConfiguration.get(InternalContainer.m10059a()) != null) {
        }
    }

    public void onClick(View view) {
        if (SdkSwitch.m9757a()) {
            mo14920a(view, this.f7219r, this.f7220s, this.f7221t, this.f7222u);
        }
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        int i;
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.f7219r = (int) motionEvent.getRawX();
            this.f7220s = (int) motionEvent.getRawY();
            this.f7223v = System.currentTimeMillis();
            this.f7225x = motionEvent.getToolType(0);
            this.f7226y = motionEvent.getDeviceId();
            this.f7227z = motionEvent.getSource();
            f7217e = System.currentTimeMillis();
            i = 0;
        } else if (actionMasked == 1) {
            this.f7221t = (int) motionEvent.getRawX();
            this.f7222u = (int) motionEvent.getRawY();
            this.f7224w = System.currentTimeMillis();
            i = 3;
        } else if (actionMasked != 2) {
            i = actionMasked != 3 ? -1 : 4;
        } else {
            f7215c += Math.abs(motionEvent.getX() - f7213a);
            f7216d += Math.abs(motionEvent.getY() - f7214b);
            f7213a = motionEvent.getX();
            f7214b = motionEvent.getY();
            if (System.currentTimeMillis() - f7217e > 200) {
                float f = f7215c;
                int i2 = f7212A;
                if (f > ((float) i2) || f7216d > ((float) i2)) {
                    i = 1;
                }
            }
            i = 2;
        }
        if (this.f7218B.get(motionEvent.getActionMasked()) == null) {
            SparseArray<C2204a> sparseArray = this.f7218B;
            int actionMasked2 = motionEvent.getActionMasked();
            C2204a aVar = new C2204a(i, (double) motionEvent.getSize(), (double) motionEvent.getPressure(), System.currentTimeMillis());
            sparseArray.put(actionMasked2, aVar);
        }
        return false;
    }
}
