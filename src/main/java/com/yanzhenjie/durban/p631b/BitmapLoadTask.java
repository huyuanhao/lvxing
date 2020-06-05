package com.yanzhenjie.durban.p631b;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Matrix;
import android.os.AsyncTask;
import com.yanzhenjie.durban.model.ExifInfo;
import com.yanzhenjie.durban.p630a.BitmapLoadCallback;
import com.yanzhenjie.durban.p632c.BitmapLoadUtils;
import com.yanzhenjie.loading.dialog.LoadingDialog;

/* renamed from: com.yanzhenjie.durban.b.b */
public class BitmapLoadTask extends AsyncTask<String, Void, C7791a> {
    /* renamed from: a */
    private final LoadingDialog f26469a;
    /* renamed from: b */
    private final int f26470b;
    /* renamed from: c */
    private final int f26471c;
    /* renamed from: d */
    private final BitmapLoadCallback f26472d;

    /* compiled from: BitmapLoadTask */
    /* renamed from: com.yanzhenjie.durban.b.b$a */
    static class C7791a {
        /* renamed from: a */
        final Bitmap f26473a;
        /* renamed from: b */
        final ExifInfo f26474b;

        C7791a(Bitmap bitmap, ExifInfo bVar) {
            this.f26473a = bitmap;
            this.f26474b = bVar;
        }
    }

    public BitmapLoadTask(Context context, int i, int i2, BitmapLoadCallback bVar) {
        this.f26469a = new LoadingDialog(context);
        this.f26470b = i;
        this.f26471c = i2;
        this.f26472d = bVar;
    }

    /* access modifiers changed from: protected */
    public void onPreExecute() {
        if (!this.f26469a.isShowing()) {
            this.f26469a.show();
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void onPostExecute(C7791a aVar) {
        if (this.f26469a.isShowing()) {
            this.f26469a.dismiss();
        }
        if (aVar.f26473a == null) {
            this.f26472d.mo37810a();
        } else {
            this.f26472d.mo37811a(aVar.f26473a, aVar.f26474b);
        }
    }

    /* access modifiers changed from: protected|varargs */
    /* renamed from: a */
    public C7791a doInBackground(String... strArr) {
        boolean z = false;
        String str = strArr[0];
        Options options = new Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(str, options);
        Bitmap bitmap = null;
        if (options.outWidth == -1 || options.outHeight == -1) {
            return new C7791a(null, null);
        }
        options.inSampleSize = BitmapLoadUtils.m33815a(options, this.f26470b, this.f26471c);
        options.inJustDecodeBounds = false;
        while (!z) {
            try {
                bitmap = BitmapFactory.decodeFile(str, options);
                z = true;
            } catch (Throwable unused) {
                options.inSampleSize *= 2;
            }
        }
        int a = BitmapLoadUtils.m33816a(str);
        int a2 = BitmapLoadUtils.m33813a(a);
        int b = BitmapLoadUtils.m33818b(a);
        ExifInfo bVar = new ExifInfo(a, a2, b);
        Matrix matrix = new Matrix();
        if (a2 != 0) {
            matrix.preRotate((float) a2);
        }
        if (b != 1) {
            matrix.postScale((float) b, 1.0f);
        }
        if (!matrix.isIdentity()) {
            return new C7791a(BitmapLoadUtils.m33817a(bitmap, matrix), bVar);
        }
        return new C7791a(bitmap, bVar);
    }
}
