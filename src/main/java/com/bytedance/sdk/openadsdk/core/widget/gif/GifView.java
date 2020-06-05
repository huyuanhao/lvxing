package com.bytedance.sdk.openadsdk.core.widget.gif;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ImageDecoder;
import android.graphics.ImageDecoder.Source;
import android.graphics.Movie;
import android.graphics.drawable.AnimatedImageDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import com.bytedance.sdk.openadsdk.multipro.MultiGlobalInfo;
import com.bytedance.sdk.openadsdk.utils.C2564t;
import com.bytedance.sdk.openadsdk.utils.FileUtils;
import com.bytedance.sdk.openadsdk.utils.Reflection;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.InputStream;

public class GifView extends ImageView {
    /* renamed from: a */
    private Movie f8362a;
    /* renamed from: b */
    private long f8363b;
    /* renamed from: c */
    private int f8364c;
    /* renamed from: d */
    private AnimatedImageDrawable f8365d;
    /* renamed from: e */
    private boolean f8366e;
    /* renamed from: f */
    private boolean f8367f;
    /* renamed from: g */
    private float f8368g;
    /* renamed from: h */
    private float f8369h;
    /* renamed from: i */
    private float f8370i;
    /* renamed from: j */
    private int f8371j;
    /* renamed from: k */
    private int f8372k;
    /* renamed from: l */
    private volatile boolean f8373l;
    /* renamed from: m */
    private boolean f8374m;

    public GifView(Context context) {
        super(context);
        this.f8366e = VERSION.SDK_INT >= 28;
        this.f8367f = false;
        this.f8374m = true;
        mo16325a();
    }

    public GifView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f8366e = VERSION.SDK_INT >= 28;
        this.f8367f = false;
        this.f8374m = true;
        mo16325a();
    }

    public GifView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f8366e = VERSION.SDK_INT >= 28;
        this.f8367f = false;
        this.f8374m = true;
        mo16325a();
    }

    public GifView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.f8366e = VERSION.SDK_INT >= 28;
        this.f8367f = false;
        this.f8374m = true;
        mo16325a();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo16325a() {
        if (!this.f8366e) {
            setLayerType(1, null);
            return;
        }
        this.f8367f = Reflection.m11927a();
        StringBuilder sb = new StringBuilder();
        sb.append("android p 反射解锁：exempt result: ");
        sb.append(this.f8367f);
        C2564t.m12220b("GifView", sb.toString());
    }

    /* renamed from: a */
    public void mo16326a(byte[] bArr, boolean z) {
        this.f8373l = z;
        if (bArr == null) {
            return;
        }
        if (!this.f8366e) {
            this.f8362a = m10840a(bArr);
        } else {
            this.f8365d = m10844b(bArr);
        }
    }

    /* renamed from: a */
    private Movie m10840a(byte[] bArr) {
        try {
            return Movie.decodeByteArray(bArr, 0, bArr.length);
        } catch (Throwable th) {
            C2564t.m12216a("GifView", "createMovieWithByteArrayBySafely error1", th);
            return null;
        }
    }

    /* renamed from: b */
    private AnimatedImageDrawable m10844b(byte[] bArr) {
        Source source = null;
        if (bArr == null) {
            return null;
        }
        if (this.f8367f) {
            try {
                source = (Source) ImageDecoder.class.getMethod("createSource", new Class[]{Resources.class, InputStream.class}).invoke(null, new Object[]{getResources(), new ByteArrayInputStream(bArr)});
            } catch (Throwable th) {
                C2564t.m12223c("GifView", "GifView android P  : Use Reflection fail : ", th);
            }
        }
        if (source == null) {
            source = m10846c(bArr);
        }
        return m10841a(source);
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x0035 A[SYNTHETIC, Splitter:B:21:0x0035] */
    /* renamed from: c */
    private android.graphics.ImageDecoder.Source m10846c(byte[] r6) {
        /*
        r5 = this;
        r0 = 0
        android.content.Context r1 = r5.getContext()     // Catch:{ all -> 0x002a }
        boolean r2 = com.bytedance.sdk.openadsdk.multipro.MultiGlobalInfo.m11808b()     // Catch:{ all -> 0x002a }
        if (r2 == 0) goto L_0x000e
        java.lang.String r2 = "GIF_AD_CACHE/"
        goto L_0x0010
    L_0x000e:
        java.lang.String r2 = "/GIF_CACHE/"
    L_0x0010:
        java.lang.String r3 = "TT_GIF_FILE"
        java.io.File r1 = r5.m10842a(r1, r2, r3)     // Catch:{ all -> 0x002a }
        java.io.FileOutputStream r2 = new java.io.FileOutputStream     // Catch:{ all -> 0x002a }
        r2.<init>(r1)     // Catch:{ all -> 0x002a }
        r3 = 0
        int r4 = r6.length     // Catch:{ all -> 0x0028 }
        r2.write(r6, r3, r4)     // Catch:{ all -> 0x0028 }
        android.graphics.ImageDecoder$Source r6 = android.graphics.ImageDecoder.createSource(r1)     // Catch:{ all -> 0x0028 }
        r2.close()     // Catch:{ all -> 0x0027 }
    L_0x0027:
        return r6
    L_0x0028:
        r6 = move-exception
        goto L_0x002c
    L_0x002a:
        r6 = move-exception
        r2 = r0
    L_0x002c:
        java.lang.String r1 = "GifView"
        java.lang.String r3 = "GifView  getSourceByFile fail : "
        com.bytedance.sdk.openadsdk.utils.C2564t.m12223c(r1, r3, r6)     // Catch:{ all -> 0x0039 }
        if (r2 == 0) goto L_0x0038
        r2.close()     // Catch:{ all -> 0x0038 }
    L_0x0038:
        return r0
    L_0x0039:
        r6 = move-exception
        if (r2 == 0) goto L_0x003f
        r2.close()     // Catch:{ all -> 0x003f }
    L_0x003f:
        throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.widget.gif.GifView.m10846c(byte[]):android.graphics.ImageDecoder$Source");
    }

    /* renamed from: a */
    private AnimatedImageDrawable m10841a(Source source) {
        try {
            Drawable decodeDrawable = ImageDecoder.decodeDrawable(source);
            setImageDrawable(decodeDrawable);
            if (decodeDrawable instanceof AnimatedImageDrawable) {
                AnimatedImageDrawable animatedImageDrawable = (AnimatedImageDrawable) decodeDrawable;
                if (!this.f8373l) {
                    animatedImageDrawable.start();
                }
                return animatedImageDrawable;
            }
        } catch (Throwable th) {
            C2564t.m12216a("GifView", "getAnimatedImageDrawable error", th);
        }
        return null;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0030  */
    public void onMeasure(int r5, int r6) {
        /*
        r4 = this;
        super.onMeasure(r5, r6)
        boolean r0 = r4.f8366e
        if (r0 != 0) goto L_0x0059
        android.graphics.Movie r0 = r4.f8362a
        if (r0 == 0) goto L_0x0059
        int r0 = r0.width()
        android.graphics.Movie r1 = r4.f8362a
        int r1 = r1.height()
        int r2 = android.view.View.MeasureSpec.getMode(r5)
        r3 = 1065353216(0x3f800000, float:1.0)
        if (r2 == 0) goto L_0x0028
        int r5 = android.view.View.MeasureSpec.getSize(r5)
        if (r0 <= r5) goto L_0x0028
        float r2 = (float) r0
        float r5 = (float) r5
        float r5 = r2 / r5
        goto L_0x002a
    L_0x0028:
        r5 = 1065353216(0x3f800000, float:1.0)
    L_0x002a:
        int r2 = android.view.View.MeasureSpec.getMode(r6)
        if (r2 == 0) goto L_0x003b
        int r6 = android.view.View.MeasureSpec.getSize(r6)
        if (r1 <= r6) goto L_0x003b
        float r2 = (float) r1
        float r6 = (float) r6
        float r6 = r2 / r6
        goto L_0x003d
    L_0x003b:
        r6 = 1065353216(0x3f800000, float:1.0)
    L_0x003d:
        float r5 = java.lang.Math.max(r5, r6)
        float r3 = r3 / r5
        r4.f8370i = r3
        float r5 = (float) r0
        float r6 = r4.f8370i
        float r5 = r5 * r6
        int r5 = (int) r5
        r4.f8371j = r5
        float r5 = (float) r1
        float r5 = r5 * r6
        int r5 = (int) r5
        r4.f8372k = r5
        int r5 = r4.f8371j
        int r6 = r4.f8372k
        r4.setMeasuredDimension(r5, r6)
    L_0x0059:
        return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.widget.gif.GifView.onMeasure(int, int):void");
    }

    /* renamed from: a */
    private File m10842a(Context context, String str, String str2) {
        if (context == null) {
            return null;
        }
        return FileUtils.m12172a(context, MultiGlobalInfo.m11808b(), str, str2);
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.f8362a != null && !this.f8366e) {
            this.f8368g = ((float) (getWidth() - this.f8371j)) / 2.0f;
            this.f8369h = ((float) (getHeight() - this.f8372k)) / 2.0f;
        }
        this.f8374m = getVisibility() == 0;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        if (this.f8362a == null || this.f8366e) {
            super.onDraw(canvas);
            return;
        }
        try {
            if (!this.f8373l) {
                m10847c();
                m10843a(canvas);
                m10845b();
                return;
            }
            m10843a(canvas);
        } catch (Throwable th) {
            C2564t.m12223c("GifView", "onDraw->Throwable->", th);
        }
    }

    /* renamed from: b */
    private void m10845b() {
        if (this.f8362a != null && !this.f8366e && this.f8374m) {
            if (VERSION.SDK_INT >= 16) {
                postInvalidateOnAnimation();
            } else {
                invalidate();
            }
        }
    }

    /* renamed from: c */
    private void m10847c() {
        if (this.f8362a != null) {
            long uptimeMillis = SystemClock.uptimeMillis();
            if (this.f8363b == 0) {
                this.f8363b = uptimeMillis;
            }
            int duration = this.f8362a.duration();
            if (duration == 0) {
                duration = 1000;
            }
            this.f8364c = (int) ((uptimeMillis - this.f8363b) % ((long) duration));
        }
    }

    /* renamed from: a */
    private void m10843a(Canvas canvas) {
        Movie movie = this.f8362a;
        if (movie != null) {
            movie.setTime(this.f8364c);
            float f = this.f8370i;
            canvas.scale(f, f);
            Movie movie2 = this.f8362a;
            float f2 = this.f8368g;
            float f3 = this.f8370i;
            movie2.draw(canvas, f2 / f3, this.f8369h / f3);
            canvas.restore();
        }
    }

    public void onScreenStateChanged(int i) {
        super.onScreenStateChanged(i);
        if (this.f8362a != null) {
            boolean z = true;
            if (i != 1) {
                z = false;
            }
            this.f8374m = z;
            m10845b();
        }
    }

    /* access modifiers changed from: protected */
    public void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        if (this.f8362a != null) {
            this.f8374m = i == 0;
            m10845b();
        }
    }

    /* access modifiers changed from: protected */
    public void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (this.f8362a != null) {
            this.f8374m = i == 0;
            m10845b();
        }
    }
}
