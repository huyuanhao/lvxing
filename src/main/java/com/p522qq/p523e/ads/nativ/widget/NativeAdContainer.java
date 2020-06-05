package com.p522qq.p523e.ads.nativ.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import com.p522qq.p523e.comm.util.GDTLogger;

/* renamed from: com.qq.e.ads.nativ.widget.NativeAdContainer */
public class NativeAdContainer extends FrameLayout {
    /* renamed from: a */
    private ViewStatusListener f20109a;
    /* renamed from: b */
    private ViewStatus f20110b = ViewStatus.INIT;

    /* renamed from: com.qq.e.ads.nativ.widget.NativeAdContainer$1 */
    static /* synthetic */ class C64041 {
        /* renamed from: a */
        static final /* synthetic */ int[] f20111a = new int[ViewStatus.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
     */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        static {
            /*
            com.qq.e.ads.nativ.widget.NativeAdContainer$ViewStatus[] r0 = com.p522qq.p523e.ads.nativ.widget.NativeAdContainer.ViewStatus.values()
            int r0 = r0.length
            int[] r0 = new int[r0]
            f20111a = r0
            int[] r0 = f20111a     // Catch:{ NoSuchFieldError -> 0x0014 }
            com.qq.e.ads.nativ.widget.NativeAdContainer$ViewStatus r1 = com.p522qq.p523e.ads.nativ.widget.NativeAdContainer.ViewStatus.ATTACHED     // Catch:{ NoSuchFieldError -> 0x0014 }
            int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
            r2 = 1
            r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0014 }
        L_0x0014:
            int[] r0 = f20111a     // Catch:{ NoSuchFieldError -> 0x001f }
            com.qq.e.ads.nativ.widget.NativeAdContainer$ViewStatus r1 = com.p522qq.p523e.ads.nativ.widget.NativeAdContainer.ViewStatus.DETACHED     // Catch:{ NoSuchFieldError -> 0x001f }
            int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
            r2 = 2
            r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001f }
        L_0x001f:
            return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.p522qq.p523e.ads.nativ.widget.NativeAdContainer.C64041.m50790clinit():void");
        }
    }

    /* renamed from: com.qq.e.ads.nativ.widget.NativeAdContainer$ViewStatus */
    private enum ViewStatus {
        INIT,
        ATTACHED,
        DETACHED
    }

    static {
        NativeAdContainer.class.getSimpleName();
    }

    public NativeAdContainer(Context context) {
        super(context);
    }

    public NativeAdContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public NativeAdContainer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        ViewStatusListener viewStatusListener = this.f20109a;
        if (viewStatusListener != null) {
            viewStatusListener.onDispatchTouchEvent(motionEvent);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        GDTLogger.m25258d("NativeAdContainer onAttachedToWindow");
        this.f20110b = ViewStatus.ATTACHED;
        ViewStatusListener viewStatusListener = this.f20109a;
        if (viewStatusListener != null) {
            viewStatusListener.onAttachToWindow();
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        GDTLogger.m25258d("NativeAdContainer onDetachedFromWindow");
        this.f20110b = ViewStatus.DETACHED;
        ViewStatusListener viewStatusListener = this.f20109a;
        if (viewStatusListener != null) {
            viewStatusListener.onDetachFromWindow();
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        StringBuilder sb = new StringBuilder("onWindowFocusChanged: hasWindowFocus: ");
        sb.append(z);
        GDTLogger.m25258d(sb.toString());
        ViewStatusListener viewStatusListener = this.f20109a;
        if (viewStatusListener != null) {
            viewStatusListener.onWindowFocusChanged(z);
        }
    }

    /* access modifiers changed from: protected */
    public void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        StringBuilder sb = new StringBuilder("onWindowVisibilityChanged: visibility: ");
        sb.append(i);
        GDTLogger.m25258d(sb.toString());
        ViewStatusListener viewStatusListener = this.f20109a;
        if (viewStatusListener != null) {
            viewStatusListener.onWindowVisibilityChanged(i);
        }
    }

    public void setViewStatusListener(ViewStatusListener viewStatusListener) {
        this.f20109a = viewStatusListener;
        if (this.f20109a != null) {
            int i = C64041.f20111a[this.f20110b.ordinal()];
            if (i == 1) {
                this.f20109a.onAttachToWindow();
            } else if (i == 2) {
                this.f20109a.onDetachFromWindow();
            }
        }
    }
}
