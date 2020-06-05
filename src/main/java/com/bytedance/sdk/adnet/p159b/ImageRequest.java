package com.bytedance.sdk.adnet.p159b;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.widget.ImageView.ScaleType;
import com.bytedance.sdk.adnet.core.C1982p;
import com.bytedance.sdk.adnet.core.C1982p.C1983a;
import com.bytedance.sdk.adnet.core.DefaultRetryPolicy;
import com.bytedance.sdk.adnet.core.NetworkResponse;
import com.bytedance.sdk.adnet.core.Request;
import com.bytedance.sdk.adnet.core.Request.C1968b;
import com.bytedance.sdk.adnet.err.ParseError;
import com.bytedance.sdk.adnet.err.VAdError;
import com.bytedance.sdk.adnet.p161d.HttpHeaderParser;

/* renamed from: com.bytedance.sdk.adnet.b.e */
public class ImageRequest extends Request<Bitmap> {
    /* renamed from: i */
    private static final Object f6131i = new Object();
    /* renamed from: c */
    private final Object f6132c = new Object();
    /* renamed from: d */
    private C1983a<Bitmap> f6133d;
    /* renamed from: e */
    private final Config f6134e;
    /* renamed from: f */
    private final int f6135f;
    /* renamed from: g */
    private final int f6136g;
    /* renamed from: h */
    private final ScaleType f6137h;

    public ImageRequest(String str, C1983a<Bitmap> aVar, int i, int i2, ScaleType scaleType, Config config) {
        super(0, str, aVar);
        setRetryPolicy(new DefaultRetryPolicy(1000, 2, 2.0f));
        this.f6133d = aVar;
        this.f6134e = config;
        this.f6135f = i;
        this.f6136g = i2;
        this.f6137h = scaleType;
        setShouldCache(false);
    }

    public C1968b getPriority() {
        return C1968b.LOW;
    }

    /* renamed from: a */
    private static int m7738a(int i, int i2, int i3, int i4, ScaleType scaleType) {
        if (i == 0 && i2 == 0) {
            return i3;
        }
        if (scaleType == ScaleType.FIT_XY) {
            return i == 0 ? i3 : i;
        }
        if (i == 0) {
            return (int) (((double) i3) * (((double) i2) / ((double) i4)));
        } else if (i2 == 0) {
            return i;
        } else {
            double d = ((double) i4) / ((double) i3);
            if (scaleType == ScaleType.CENTER_CROP) {
                double d2 = (double) i2;
                if (((double) i) * d < d2) {
                    i = (int) (d2 / d);
                }
                return i;
            }
            double d3 = (double) i2;
            if (((double) i) * d > d3) {
                i = (int) (d3 / d);
            }
            return i;
        }
    }

    /* JADX WARNING: type inference failed for: r6v9, types: [com.bytedance.sdk.adnet.core.p, com.bytedance.sdk.adnet.core.p<android.graphics.Bitmap>] */
    /* access modifiers changed from: protected */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* renamed from: a */
    public com.bytedance.sdk.adnet.core.C1982p<android.graphics.Bitmap> mo14188a(com.bytedance.sdk.adnet.core.NetworkResponse r6) {
        /*
        r5 = this;
        java.lang.Object r0 = f6131i
        monitor-enter(r0)
        com.bytedance.sdk.adnet.core.p r6 = r5.m7739b(r6)     // Catch:{ OutOfMemoryError -> 0x000b }
        monitor-exit(r0)     // Catch:{ all -> 0x0009 }
        return r6
    L_0x0009:
        r6 = move-exception
        goto L_0x0030
    L_0x000b:
        r1 = move-exception
        java.lang.String r2 = "Caught OOM for %d byte image, url=%s"
        r3 = 2
        java.lang.Object[] r3 = new java.lang.Object[r3]     // Catch:{ all -> 0x0009 }
        r4 = 0
        byte[] r6 = r6.f6275b     // Catch:{ all -> 0x0009 }
        int r6 = r6.length     // Catch:{ all -> 0x0009 }
        java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch:{ all -> 0x0009 }
        r3[r4] = r6     // Catch:{ all -> 0x0009 }
        r6 = 1
        java.lang.String r4 = r5.getUrl()     // Catch:{ all -> 0x0009 }
        r3[r6] = r4     // Catch:{ all -> 0x0009 }
        com.bytedance.sdk.adnet.core.VNetLog.m7929c(r2, r3)     // Catch:{ all -> 0x0009 }
        com.bytedance.sdk.adnet.err.e r6 = new com.bytedance.sdk.adnet.err.e     // Catch:{ all -> 0x0009 }
        r6.m43215init(r1)     // Catch:{ all -> 0x0009 }
        com.bytedance.sdk.adnet.core.p r6 = com.bytedance.sdk.adnet.core.C1982p.m7916a(r6)     // Catch:{ all -> 0x0009 }
        monitor-exit(r0)     // Catch:{ all -> 0x0009 }
        return r6
    L_0x0030:
        monitor-exit(r0)     // Catch:{ all -> 0x0009 }
        throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.adnet.p159b.ImageRequest.mo14188a(com.bytedance.sdk.adnet.core.l):com.bytedance.sdk.adnet.core.p");
    }

    /* renamed from: b */
    private C1982p<Bitmap> m7739b(NetworkResponse lVar) {
        Bitmap bitmap;
        byte[] bArr = lVar.f6275b;
        Options options = new Options();
        if (this.f6135f == 0 && this.f6136g == 0) {
            options.inPreferredConfig = this.f6134e;
            bitmap = BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
        } else {
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
            int i = options.outWidth;
            int i2 = options.outHeight;
            int a = m7738a(this.f6135f, this.f6136g, i, i2, this.f6137h);
            int a2 = m7738a(this.f6136g, this.f6135f, i2, i, this.f6137h);
            options.inJustDecodeBounds = false;
            options.inSampleSize = m7737a(i, i2, a, a2);
            bitmap = BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
            if (bitmap != null && (bitmap.getWidth() > a || bitmap.getHeight() > a2)) {
                Bitmap createScaledBitmap = Bitmap.createScaledBitmap(bitmap, a, a2, true);
                bitmap.recycle();
                bitmap = createScaledBitmap;
            }
        }
        if (bitmap == null) {
            return C1982p.m7916a((VAdError) new ParseError(lVar));
        }
        return C1982p.m7917a(bitmap, HttpHeaderParser.m7939a(lVar));
    }

    public void cancel() {
        super.cancel();
        synchronized (this.f6132c) {
            this.f6133d = null;
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo14190a(C1982p<Bitmap> pVar) {
        C1983a<Bitmap> aVar;
        synchronized (this.f6132c) {
            aVar = this.f6133d;
        }
        if (aVar != null) {
            aVar.mo14171a(pVar);
        }
    }

    /* renamed from: a */
    static int m7737a(int i, int i2, int i3, int i4) {
        double min = Math.min(((double) i) / ((double) i3), ((double) i2) / ((double) i4));
        float f = 1.0f;
        while (true) {
            float f2 = 2.0f * f;
            if (((double) f2) > min) {
                return (int) f;
            }
            f = f2;
        }
    }
}
