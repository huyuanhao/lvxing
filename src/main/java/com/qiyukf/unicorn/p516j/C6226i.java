package com.qiyukf.unicorn.p516j;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.style.DynamicDrawableSpan;
import android.text.style.ImageSpan;
import android.widget.TextView;
import com.qiyukf.basesdk.p393a.C5264a;
import com.qiyukf.nim.uikit.C5426a;
import com.qiyukf.unicorn.C5961R;
import com.qiyukf.unicorn.api.ImageLoaderListener;
import java.lang.reflect.Field;

/* renamed from: com.qiyukf.unicorn.j.i */
public final class C6226i extends ImageSpan {
    /* renamed from: a */
    private String f19408a;
    /* access modifiers changed from: private */
    /* renamed from: b */
    public TextView f19409b;
    /* access modifiers changed from: private */
    /* renamed from: c */
    public boolean f19410c;

    public C6226i(Context context, String str, TextView textView) {
        super(context, C5961R.C5962drawable.ysf_ic_emoji_loading);
        this.f19408a = str;
        this.f19409b = textView;
    }

    /* renamed from: a */
    public static Bitmap m24663a(Bitmap bitmap) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        Matrix matrix = new Matrix();
        matrix.postScale(0.7f, 0.7f);
        return Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
    }

    public final Drawable getDrawable() {
        if (!this.f19410c) {
            C5426a.m22177a(this.f19408a, 100, 100, (ImageLoaderListener) new ImageLoaderListener() {
                public final void onLoadComplete(Bitmap bitmap) {
                    String message;
                    String str = "UrlImageSpan 加载网络图片异常";
                    BitmapDrawable bitmapDrawable = new BitmapDrawable(C6226i.this.f19409b.getContext().getResources(), C6226i.m24663a(bitmap));
                    bitmapDrawable.setBounds(0, 0, bitmapDrawable.getIntrinsicWidth(), bitmapDrawable.getIntrinsicHeight());
                    try {
                        Field declaredField = ImageSpan.class.getDeclaredField("mDrawable");
                        declaredField.setAccessible(true);
                        declaredField.set(C6226i.this, bitmapDrawable);
                        Field declaredField2 = DynamicDrawableSpan.class.getDeclaredField("mDrawableRef");
                        declaredField2.setAccessible(true);
                        declaredField2.set(C6226i.this, null);
                        C6226i.this.f19410c = true;
                        C6226i.this.f19409b.setText(C6226i.this.f19409b.getText());
                    } catch (IllegalAccessException e) {
                        message = e.getMessage();
                        C5264a.m21617a(str, message);
                    } catch (NoSuchFieldException e2) {
                        message = e2.getMessage();
                        C5264a.m21617a(str, message);
                    }
                }

                public final void onLoadFailed(Throwable th) {
                    C5264a.m21617a("UrlImageSpan 加载网络图片异常", th.getMessage());
                }
            });
        }
        return super.getDrawable();
    }
}
