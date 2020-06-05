package com.yanzhenjie.durban.p631b;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.RectF;
import android.os.AsyncTask;
import com.yanzhenjie.durban.model.CropParameters;
import com.yanzhenjie.durban.model.ImageState;
import com.yanzhenjie.durban.p630a.BitmapCropCallback;
import com.yanzhenjie.loading.dialog.LoadingDialog;

/* renamed from: com.yanzhenjie.durban.b.a */
public class BitmapCropTask extends AsyncTask<Void, Void, C7790a> {
    /* renamed from: a */
    private LoadingDialog f26452a;
    /* renamed from: b */
    private Bitmap f26453b;
    /* renamed from: c */
    private final RectF f26454c;
    /* renamed from: d */
    private final RectF f26455d;
    /* renamed from: e */
    private float f26456e;
    /* renamed from: f */
    private float f26457f;
    /* renamed from: g */
    private final int f26458g;
    /* renamed from: h */
    private final int f26459h;
    /* renamed from: i */
    private final CompressFormat f26460i;
    /* renamed from: j */
    private final int f26461j;
    /* renamed from: k */
    private final String f26462k;
    /* renamed from: l */
    private final String f26463l;
    /* renamed from: m */
    private final BitmapCropCallback f26464m;
    /* renamed from: n */
    private int f26465n;
    /* renamed from: o */
    private int f26466o;

    /* compiled from: BitmapCropTask */
    /* renamed from: com.yanzhenjie.durban.b.a$a */
    static class C7790a {
        /* renamed from: a */
        final String f26467a;
        /* renamed from: b */
        final Exception f26468b;

        C7790a(String str, Exception exc) {
            this.f26467a = str;
            this.f26468b = exc;
        }
    }

    public BitmapCropTask(Context context, Bitmap bitmap, ImageState cVar, CropParameters aVar, BitmapCropCallback aVar2) {
        this.f26452a = new LoadingDialog(context);
        this.f26453b = bitmap;
        this.f26454c = cVar.mo37862a();
        this.f26455d = cVar.mo37863b();
        this.f26456e = cVar.mo37864c();
        this.f26457f = cVar.mo37865d();
        this.f26458g = aVar.mo37854a();
        this.f26459h = aVar.mo37855b();
        this.f26460i = aVar.mo37856c();
        this.f26461j = aVar.mo37857d();
        this.f26462k = aVar.mo37858e();
        this.f26463l = aVar.mo37859f();
        this.f26464m = aVar2;
    }

    /* access modifiers changed from: protected */
    public void onPreExecute() {
        if (!this.f26452a.isShowing()) {
            this.f26452a.show();
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void onPostExecute(C7790a aVar) {
        if (this.f26452a.isShowing()) {
            this.f26452a.dismiss();
        }
        if (this.f26464m == null) {
            return;
        }
        if (aVar.f26468b == null) {
            this.f26464m.mo37805a(aVar.f26467a, this.f26465n, this.f26466o);
        } else {
            this.f26464m.mo37806a(aVar.f26468b);
        }
    }

    /* access modifiers changed from: protected|varargs */
    /* renamed from: a */
    public C7790a doInBackground(Void... voidArr) {
        try {
            return new C7790a(m33807a(), null);
        } catch (Exception e) {
            return new C7790a(null, e);
        }
    }

    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:33:0x013b */
    /* renamed from: a */
    private java.lang.String m33807a() throws java.lang.Exception {
        /*
        r9 = this;
        java.lang.String r0 = r9.f26463l
        com.yanzhenjie.durban.p632c.C7792f.m33829a(r0)
        android.graphics.Bitmap$CompressFormat r0 = r9.f26460i
        java.lang.String r0 = com.yanzhenjie.durban.p632c.C7792f.m33827a(r0)
        java.io.File r1 = new java.io.File
        java.lang.String r2 = r9.f26463l
        r1.<init>(r2, r0)
        java.lang.String r0 = r1.getAbsolutePath()
        int r1 = r9.f26458g
        if (r1 <= 0) goto L_0x0077
        int r1 = r9.f26459h
        if (r1 <= 0) goto L_0x0077
        android.graphics.RectF r1 = r9.f26454c
        float r1 = r1.width()
        float r2 = r9.f26456e
        float r1 = r1 / r2
        android.graphics.RectF r2 = r9.f26454c
        float r2 = r2.height()
        float r3 = r9.f26456e
        float r2 = r2 / r3
        int r3 = r9.f26458g
        float r3 = (float) r3
        int r3 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
        if (r3 > 0) goto L_0x003e
        int r3 = r9.f26459h
        float r3 = (float) r3
        int r3 = (r2 > r3 ? 1 : (r2 == r3 ? 0 : -1))
        if (r3 <= 0) goto L_0x0077
    L_0x003e:
        int r3 = r9.f26458g
        float r3 = (float) r3
        float r3 = r3 / r1
        int r1 = r9.f26459h
        float r1 = (float) r1
        float r1 = r1 / r2
        float r1 = java.lang.Math.min(r3, r1)
        android.graphics.Bitmap r2 = r9.f26453b
        int r3 = r2.getWidth()
        float r3 = (float) r3
        float r3 = r3 * r1
        int r3 = java.lang.Math.round(r3)
        android.graphics.Bitmap r4 = r9.f26453b
        int r4 = r4.getHeight()
        float r4 = (float) r4
        float r4 = r4 * r1
        int r4 = java.lang.Math.round(r4)
        r5 = 0
        android.graphics.Bitmap r2 = android.graphics.Bitmap.createScaledBitmap(r2, r3, r4, r5)
        android.graphics.Bitmap r3 = r9.f26453b
        if (r3 == r2) goto L_0x0070
        r3.recycle()
    L_0x0070:
        r9.f26453b = r2
        float r2 = r9.f26456e
        float r2 = r2 / r1
        r9.f26456e = r2
    L_0x0077:
        float r1 = r9.f26457f
        r2 = 0
        int r1 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
        if (r1 == 0) goto L_0x00b6
        android.graphics.Matrix r7 = new android.graphics.Matrix
        r7.<init>()
        float r1 = r9.f26457f
        android.graphics.Bitmap r2 = r9.f26453b
        int r2 = r2.getWidth()
        int r2 = r2 / 2
        float r2 = (float) r2
        android.graphics.Bitmap r3 = r9.f26453b
        int r3 = r3.getHeight()
        int r3 = r3 / 2
        float r3 = (float) r3
        r7.setRotate(r1, r2, r3)
        android.graphics.Bitmap r2 = r9.f26453b
        r3 = 0
        r4 = 0
        int r5 = r2.getWidth()
        android.graphics.Bitmap r1 = r9.f26453b
        int r6 = r1.getHeight()
        r8 = 1
        android.graphics.Bitmap r1 = android.graphics.Bitmap.createBitmap(r2, r3, r4, r5, r6, r7, r8)
        android.graphics.Bitmap r2 = r9.f26453b
        if (r2 == r1) goto L_0x00b4
        r2.recycle()
    L_0x00b4:
        r9.f26453b = r1
    L_0x00b6:
        android.graphics.RectF r1 = r9.f26454c
        float r1 = r1.left
        android.graphics.RectF r2 = r9.f26455d
        float r2 = r2.left
        float r1 = r1 - r2
        float r2 = r9.f26456e
        float r1 = r1 / r2
        int r1 = java.lang.Math.round(r1)
        android.graphics.RectF r2 = r9.f26454c
        float r2 = r2.top
        android.graphics.RectF r3 = r9.f26455d
        float r3 = r3.top
        float r2 = r2 - r3
        float r3 = r9.f26456e
        float r2 = r2 / r3
        int r2 = java.lang.Math.round(r2)
        android.graphics.RectF r3 = r9.f26454c
        float r3 = r3.width()
        float r4 = r9.f26456e
        float r3 = r3 / r4
        int r3 = java.lang.Math.round(r3)
        r9.f26465n = r3
        android.graphics.RectF r3 = r9.f26454c
        float r3 = r3.height()
        float r4 = r9.f26456e
        float r3 = r3 / r4
        int r3 = java.lang.Math.round(r3)
        r9.f26466o = r3
        int r3 = r9.f26465n
        int r4 = r9.f26466o
        boolean r3 = r9.m33808a(r3, r4)
        if (r3 == 0) goto L_0x014a
        android.graphics.Bitmap r3 = r9.f26453b
        int r4 = r9.f26465n
        int r5 = r9.f26466o
        android.graphics.Bitmap r1 = android.graphics.Bitmap.createBitmap(r3, r1, r2, r4, r5)
        r2 = 0
        java.io.FileOutputStream r3 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x013b }
        r3.<init>(r0)     // Catch:{ Exception -> 0x013b }
        android.graphics.Bitmap$CompressFormat r2 = r9.f26460i     // Catch:{ Exception -> 0x0137, all -> 0x0134 }
        int r4 = r9.f26461j     // Catch:{ Exception -> 0x0137, all -> 0x0134 }
        r1.compress(r2, r4, r3)     // Catch:{ Exception -> 0x0137, all -> 0x0134 }
        r1.recycle()
        com.yanzhenjie.durban.p632c.C7792f.m33828a(r3)
        android.graphics.Bitmap$CompressFormat r1 = r9.f26460i
        android.graphics.Bitmap$CompressFormat r2 = android.graphics.Bitmap.CompressFormat.JPEG
        boolean r1 = r1.equals(r2)
        if (r1 == 0) goto L_0x014f
        android.media.ExifInterface r1 = new android.media.ExifInterface
        java.lang.String r2 = r9.f26462k
        r1.<init>(r2)
        int r2 = r9.f26465n
        int r3 = r9.f26466o
        com.yanzhenjie.durban.p632c.ImageHeaderParser.m33834a(r1, r2, r3, r0)
        goto L_0x014f
    L_0x0134:
        r0 = move-exception
        r2 = r3
        goto L_0x0143
    L_0x0137:
        r2 = r3
        goto L_0x013b
    L_0x0139:
        r0 = move-exception
        goto L_0x0143
    L_0x013b:
        com.yanzhenjie.durban.error.StorageError r0 = new com.yanzhenjie.durban.error.StorageError     // Catch:{ all -> 0x0139 }
        java.lang.String r3 = ""
        r0.m54140init(r3)     // Catch:{ all -> 0x0139 }
        throw r0     // Catch:{ all -> 0x0139 }
    L_0x0143:
        r1.recycle()
        com.yanzhenjie.durban.p632c.C7792f.m33828a(r2)
        throw r0
    L_0x014a:
        java.lang.String r1 = r9.f26462k
        com.yanzhenjie.durban.p632c.C7792f.m33830a(r1, r0)
    L_0x014f:
        android.graphics.Bitmap r1 = r9.f26453b
        if (r1 == 0) goto L_0x015e
        boolean r1 = r1.isRecycled()
        if (r1 != 0) goto L_0x015e
        android.graphics.Bitmap r1 = r9.f26453b
        r1.recycle()
    L_0x015e:
        return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.yanzhenjie.durban.p631b.BitmapCropTask.m33807a():java.lang.String");
    }

    /* renamed from: a */
    private boolean m33808a(int i, int i2) {
        int round = Math.round(((float) Math.max(i, i2)) / 1000.0f) + 1;
        if (this.f26458g > 0 && this.f26459h > 0) {
            return true;
        }
        float f = (float) round;
        if (Math.abs(this.f26454c.left - this.f26455d.left) > f || Math.abs(this.f26454c.top - this.f26455d.top) > f || Math.abs(this.f26454c.bottom - this.f26455d.bottom) > f || Math.abs(this.f26454c.right - this.f26455d.right) > f) {
            return true;
        }
        return false;
    }
}
