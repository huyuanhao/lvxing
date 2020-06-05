package com.bytedance.sdk.openadsdk.utils;

import android.graphics.Rect;
import android.view.TouchDelegate;
import android.view.View;
import android.view.ViewConfiguration;

/* renamed from: com.bytedance.sdk.openadsdk.utils.m */
public class HackTouchDelegate extends TouchDelegate {
    /* renamed from: a */
    private View f9176a;
    /* renamed from: b */
    private Rect f9177b;
    /* renamed from: c */
    private Rect f9178c;
    /* renamed from: d */
    private boolean f9179d;
    /* renamed from: e */
    private int f9180e;

    public HackTouchDelegate(Rect rect, View view) {
        super(rect, view);
        this.f9177b = rect;
        this.f9180e = ViewConfiguration.get(view.getContext()).getScaledTouchSlop();
        this.f9178c = new Rect(rect);
        Rect rect2 = this.f9178c;
        int i = this.f9180e;
        rect2.inset(-i, -i);
        this.f9176a = view;
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x003e  */
    /* JADX WARNING: Removed duplicated region for block: B:24:? A[RETURN, SYNTHETIC] */
    public boolean onTouchEvent(android.view.MotionEvent r7) {
        /*
        r6 = this;
        float r0 = r7.getX()
        int r0 = (int) r0
        float r1 = r7.getY()
        int r1 = (int) r1
        int r2 = r7.getAction()
        r3 = 2
        r4 = 1
        r5 = 0
        if (r2 == 0) goto L_0x002d
        if (r2 == r4) goto L_0x0022
        if (r2 == r3) goto L_0x0022
        r0 = 3
        if (r2 == r0) goto L_0x001c
    L_0x001a:
        r2 = 0
        goto L_0x003c
    L_0x001c:
        boolean r0 = r6.f9179d
        r6.f9179d = r5
        r2 = r0
        goto L_0x003c
    L_0x0022:
        boolean r2 = r6.f9179d
        if (r2 == 0) goto L_0x003c
        android.graphics.Rect r4 = r6.f9178c
        boolean r4 = r4.contains(r0, r1)
        goto L_0x003c
    L_0x002d:
        android.graphics.Rect r2 = r6.f9177b
        boolean r0 = r2.contains(r0, r1)
        if (r0 == 0) goto L_0x0039
        r6.f9179d = r4
        r2 = 1
        goto L_0x003c
    L_0x0039:
        r6.f9179d = r5
        goto L_0x001a
    L_0x003c:
        if (r2 == 0) goto L_0x0065
        android.view.View r0 = r6.f9176a
        if (r4 == 0) goto L_0x0052
        int r1 = r0.getWidth()
        int r1 = r1 / r3
        float r1 = (float) r1
        int r2 = r0.getHeight()
        int r2 = r2 / r3
        float r2 = (float) r2
        r7.setLocation(r1, r2)
        goto L_0x005b
    L_0x0052:
        int r1 = r6.f9180e
        int r1 = r1 * 2
        int r1 = -r1
        float r1 = (float) r1
        r7.setLocation(r1, r1)
    L_0x005b:
        int r1 = r0.getVisibility()
        if (r1 != 0) goto L_0x0065
        boolean r5 = r0.dispatchTouchEvent(r7)
    L_0x0065:
        return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.utils.HackTouchDelegate.onTouchEvent(android.view.MotionEvent):boolean");
    }
}
