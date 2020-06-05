package com.kwad.sdk.contentalliance.home.viewpager;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.viewpager.widget.PagerAdapter;
import com.kwad.sdk.contentalliance.p309b.C3835b;
import com.kwad.sdk.contentalliance.refreshview.C4053e;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.kwad.sdk.contentalliance.home.viewpager.b */
public class C4026b extends C3835b {
    /* renamed from: a */
    protected boolean f13502a;
    /* renamed from: b */
    protected boolean f13503b;
    /* renamed from: c */
    protected boolean f13504c;
    /* renamed from: d */
    protected C4053e f13505d;
    /* renamed from: f */
    private float f13506f;
    /* renamed from: g */
    private float f13507g;
    /* renamed from: h */
    private boolean f13508h;
    /* renamed from: i */
    private boolean f13509i;
    /* renamed from: j */
    private boolean f13510j;
    /* renamed from: k */
    private List<C4027a> f13511k;

    /* renamed from: com.kwad.sdk.contentalliance.home.viewpager.b$a */
    public interface C4027a {
        /* renamed from: a */
        void mo23581a();

        /* renamed from: b */
        void mo23582b();
    }

    public C4026b(Context context) {
        this(context, null);
    }

    public C4026b(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f13510j = true;
        this.f13511k = new ArrayList();
    }

    /* renamed from: b */
    private void m16683b(MotionEvent motionEvent) {
        if (motionEvent.getActionMasked() == 0) {
            this.f13506f = motionEvent.getX();
            this.f13507g = motionEvent.getY();
            this.f13509i = false;
            this.f13508h = false;
        }
    }

    /* renamed from: e */
    private void mo23608e() {
        this.f13508h = false;
    }

    /* renamed from: n */
    private boolean m16685n() {
        return !this.f13510j || getAdapter() == null;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public int mo23248a(int i, float f, int i2, int i3) {
        return Math.max(Math.min(super.mo23248a(i, f, i2, i3), getLastValidItemPosition()), getFirstValidItemPosition());
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo23251a() {
        super.mo23251a();
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo23256a(int i, boolean z, boolean z2) {
        super.mo23256a(i, z, z2);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo23615a(MotionEvent motionEvent) {
        if (this.f13503b) {
            float abs = Math.abs(motionEvent.getX() - this.f13506f);
            float y = motionEvent.getY();
            float abs2 = Math.abs(y - this.f13507g);
            if (abs2 > ((float) this.f13008e) && abs2 * 0.5f > abs) {
                if (!this.f13502a && y > this.f13507g && getCurrentItem() == getFirstValidItemPosition()) {
                    if (!this.f13504c) {
                        mo23619c();
                    }
                    for (C4027a a : this.f13511k) {
                        a.mo23581a();
                    }
                } else if (getCurrentItem() == getLastValidItemPosition() && !mo23620d() && y < this.f13507g) {
                    mo23617b();
                    for (C4027a b : this.f13511k) {
                        b.mo23582b();
                    }
                }
            }
        }
    }

    /* renamed from: a */
    public void mo23616a(C4027a aVar) {
        if (!this.f13511k.contains(aVar)) {
            this.f13511k.add(aVar);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo23617b() {
    }

    /* renamed from: b */
    public void mo23618b(C4027a aVar) {
        this.f13511k.remove(aVar);
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public void mo23619c() {
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public boolean mo23620d() {
        return false;
    }

    /* access modifiers changed from: protected */
    public int getFirstValidItemPosition() {
        return 0;
    }

    /* access modifiers changed from: protected */
    public int getLastValidItemPosition() {
        return getAdapter().getCount() - 1;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (m16685n()) {
            return false;
        }
        int action = motionEvent.getAction() & 255;
        m16683b(motionEvent);
        if (action == 2) {
            float abs = Math.abs(motionEvent.getX() - this.f13506f);
            float y = motionEvent.getY();
            float f = this.f13507g;
            float f2 = y - f;
            float abs2 = Math.abs(y - f);
            if (getCurrentItem() == getFirstValidItemPosition() && f2 > ((float) this.f13008e) && abs2 * 0.5f > abs) {
                this.f13508h = true;
                C4053e eVar = this.f13505d;
                if (eVar != null && this.f13502a) {
                    eVar.mo23708a(motionEvent);
                }
                return true;
            } else if (getCurrentItem() == getLastValidItemPosition() && f2 < ((float) (-this.f13008e)) && abs2 * 0.5f > abs) {
                this.f13509i = true;
                return true;
            }
        }
        C4053e eVar2 = this.f13505d;
        if (eVar2 != null && this.f13502a) {
            eVar2.mo23708a(motionEvent);
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0017, code lost:
            if (r0 != 2) goto L_0x0083;
     */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0087 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x009b  */
    public boolean onTouchEvent(android.view.MotionEvent r9) {
        /*
        r8 = this;
        boolean r0 = r8.m16685n()
        r1 = 0
        if (r0 == 0) goto L_0x0008
        return r1
    L_0x0008:
        int r0 = r9.getAction()
        r0 = r0 & 255(0xff, float:3.57E-43)
        r8.m16683b(r9)
        r2 = 1
        if (r0 == 0) goto L_0x001e
        if (r0 == r2) goto L_0x001a
        r1 = 2
        if (r0 == r1) goto L_0x0022
        goto L_0x0083
    L_0x001a:
        r8.mo23615a(r9)
        goto L_0x0083
    L_0x001e:
        r8.f13509i = r1
        r8.f13508h = r1
    L_0x0022:
        float r1 = r9.getX()
        float r3 = r8.f13506f
        float r1 = r1 - r3
        float r1 = java.lang.Math.abs(r1)
        float r3 = r9.getY()
        float r4 = r8.f13507g
        float r5 = r3 - r4
        float r3 = r3 - r4
        float r3 = java.lang.Math.abs(r3)
        int r4 = r8.getCurrentItem()
        int r6 = r8.getFirstValidItemPosition()
        r7 = 1056964608(0x3f000000, float:0.5)
        if (r4 != r6) goto L_0x0069
        int r4 = r8.f13008e
        float r4 = (float) r4
        int r4 = (r5 > r4 ? 1 : (r5 == r4 ? 0 : -1))
        if (r4 <= 0) goto L_0x0055
        float r4 = r3 * r7
        int r4 = (r4 > r1 ? 1 : (r4 == r1 ? 0 : -1))
        if (r4 <= 0) goto L_0x0055
        r8.f13508h = r2
    L_0x0055:
        boolean r4 = r8.f13508h
        if (r4 != 0) goto L_0x0069
        r4 = 0
        int r4 = (r5 > r4 ? 1 : (r5 == r4 ? 0 : -1))
        if (r4 <= 0) goto L_0x0069
        com.kwad.sdk.contentalliance.refreshview.e r4 = r8.f13505d
        if (r4 == 0) goto L_0x0069
        boolean r6 = r8.f13502a
        if (r6 == 0) goto L_0x0069
        r4.mo23709b(r9)
    L_0x0069:
        int r4 = r8.getCurrentItem()
        int r6 = r8.getLastValidItemPosition()
        if (r4 != r6) goto L_0x0083
        int r4 = r8.f13008e
        int r4 = -r4
        float r4 = (float) r4
        int r4 = (r5 > r4 ? 1 : (r5 == r4 ? 0 : -1))
        if (r4 >= 0) goto L_0x0083
        float r3 = r3 * r7
        int r1 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
        if (r1 <= 0) goto L_0x0083
        r8.f13509i = r2
    L_0x0083:
        boolean r1 = r8.f13508h
        if (r1 == 0) goto L_0x009b
        if (r0 == r2) goto L_0x008c
        r1 = 3
        if (r0 != r1) goto L_0x008f
    L_0x008c:
        r8.mo23608e()
    L_0x008f:
        com.kwad.sdk.contentalliance.refreshview.e r0 = r8.f13505d
        if (r0 == 0) goto L_0x009a
        boolean r1 = r8.f13502a
        if (r1 == 0) goto L_0x009a
        r0.mo23709b(r9)
    L_0x009a:
        return r2
    L_0x009b:
        boolean r1 = r8.f13509i
        if (r1 == 0) goto L_0x00a5
        if (r0 != r2) goto L_0x00a4
        super.onTouchEvent(r9)
    L_0x00a4:
        return r2
    L_0x00a5:
        boolean r9 = super.onTouchEvent(r9)
        return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.sdk.contentalliance.home.viewpager.C4026b.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public void setAdapter(PagerAdapter pagerAdapter) {
        super.setAdapter(pagerAdapter);
    }

    public void setEnabled(boolean z) {
        super.setEnabled(z);
        this.f13510j = true;
    }
}
