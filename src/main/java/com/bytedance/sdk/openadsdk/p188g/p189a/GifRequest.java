package com.bytedance.sdk.openadsdk.p188g.p189a;

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
import com.bytedance.sdk.openadsdk.utils.BitmapUtils;
import com.bytedance.sdk.openadsdk.utils.C2564t;

/* renamed from: com.bytedance.sdk.openadsdk.g.a.c */
public class GifRequest extends Request<byte[]> {
    /* renamed from: i */
    private static final Object f8705i = new Object();
    /* renamed from: c */
    private final Object f8706c = new Object();
    /* access modifiers changed from: private */
    /* renamed from: d */
    public C2437a f8707d;
    /* renamed from: e */
    private final Config f8708e;
    /* renamed from: f */
    private final int f8709f;
    /* renamed from: g */
    private final int f8710g;
    /* renamed from: h */
    private final ScaleType f8711h;

    /* compiled from: GifRequest */
    /* renamed from: com.bytedance.sdk.openadsdk.g.a.c$a */
    public interface C2437a extends C1983a<byte[]> {
        /* renamed from: a */
        void mo16637a(String str, byte[] bArr);
    }

    public GifRequest(String str, C2437a aVar, int i, int i2, ScaleType scaleType, Config config) {
        super(0, str, aVar);
        setRetryPolicy(new DefaultRetryPolicy(1000, 2, 2.0f));
        this.f8707d = aVar;
        this.f8708e = config;
        this.f8709f = i;
        this.f8710g = i2;
        this.f8711h = scaleType;
        setShouldCache(false);
    }

    public C1968b getPriority() {
        return C1968b.LOW;
    }

    /* renamed from: a */
    private static int m11401a(int i, int i2, int i3, int i4, ScaleType scaleType) {
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

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public C1982p<byte[]> mo14188a(NetworkResponse lVar) {
        C1982p<byte[]> b;
        synchronized (f8705i) {
            try {
                b = m11403b(lVar);
            } catch (OutOfMemoryError e) {
                C2564t.m12223c("GifRequest", "Caught OOM for byte image", e);
                return C1982p.m7916a((VAdError) new ParseError((Throwable) e));
            } catch (Throwable th) {
                throw th;
            }
        }
        return b;
    }

    /* renamed from: b */
    private C1982p<byte[]> m11403b(NetworkResponse lVar) {
        Bitmap bitmap;
        final byte[] bArr = lVar.f6275b;
        String a = GifCache.m11369a().mo16625a(getUrl(), this.f8709f, this.f8710g, this.f8711h);
        if (bArr.length >= 3 && bArr[0] == 71 && bArr[1] == 73 && bArr[2] == 70) {
            try {
                GifCache.m11369a().mo16626a(a, bArr);
                if (this.f8707d != null) {
                    this.f6184b.post(new Runnable() {
                        public void run() {
                            if (GifRequest.this.f8707d != null) {
                                GifRequest.this.f8707d.mo16637a(GifRequest.this.getUrl(), bArr);
                            }
                        }
                    });
                }
                return C1982p.m7917a(bArr, HttpHeaderParser.m7939a(lVar));
            } catch (Exception unused) {
            }
        }
        Options options = new Options();
        if (this.f8709f == 0 && this.f8710g == 0) {
            options.inPreferredConfig = this.f8708e;
            bitmap = BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
        } else {
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
            int i = options.outWidth;
            int i2 = options.outHeight;
            int a2 = m11401a(this.f8709f, this.f8710g, i, i2, this.f8711h);
            int a3 = m11401a(this.f8710g, this.f8709f, i2, i, this.f8711h);
            options.inJustDecodeBounds = false;
            options.inSampleSize = m11400a(i, i2, a2, a3);
            bitmap = BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
            if (bitmap != null && (bitmap.getWidth() > a2 || bitmap.getHeight() > a3)) {
                Bitmap createScaledBitmap = Bitmap.createScaledBitmap(bitmap, a2, a3, true);
                bitmap.recycle();
                bitmap = createScaledBitmap;
            }
        }
        if (bitmap == null) {
            return C1982p.m7916a((VAdError) new ParseError(lVar));
        }
        final byte[] b = BitmapUtils.m12138b(bitmap);
        GifCache.m11369a().mo16626a(a, b);
        if (this.f8707d != null) {
            this.f6184b.post(new Runnable() {
                public void run() {
                    if (GifRequest.this.f8707d != null) {
                        GifRequest.this.f8707d.mo16637a(GifRequest.this.getUrl(), b);
                    }
                }
            });
        }
        return C1982p.m7917a(b, HttpHeaderParser.m7939a(lVar));
    }

    public void cancel() {
        super.cancel();
        synchronized (this.f8706c) {
            this.f8707d = null;
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo14190a(C1982p<byte[]> pVar) {
        C2437a aVar;
        synchronized (this.f8706c) {
            aVar = this.f8707d;
        }
        if (aVar != null) {
            aVar.mo14171a(pVar);
        }
    }

    /* renamed from: a */
    static int m11400a(int i, int i2, int i3, int i4) {
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
