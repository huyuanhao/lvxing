package com.jiayouya.travel;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.p131c.p132a.SimpleTarget;
import com.bumptech.glide.p131c.p133b.Transition;
import com.qiyukf.unicorn.api.ImageLoaderListener;
import com.qiyukf.unicorn.api.UnicornImageLoader;
import kotlin.Metadata;
import kotlin.jvm.internal.C8271i;
import kotlin.jvm.internal.Ref.IntRef;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J*\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\"\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\nH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, mo39189d2 = {"Lcom/jiayouya/travel/GlideImageLoader;", "Lcom/qiyukf/unicorn/api/UnicornImageLoader;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "loadImage", "", "uri", "", "w", "", "h", "listener", "Lcom/qiyukf/unicorn/api/ImageLoaderListener;", "loadImageSync", "Landroid/graphics/Bitmap;", "width", "height", "app_grRelease"}, mo39190k = 1, mo39191mv = {1, 1, 15})
/* compiled from: Launcher.kt */
public final class GlideImageLoader implements UnicornImageLoader {
    /* renamed from: a */
    private final Context f9538a;

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\"\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00022\u0010\u0010\t\u001a\f\u0012\u0006\b\u0000\u0012\u00020\u0002\u0018\u00010\nH\u0016¨\u0006\u000b"}, mo39189d2 = {"com/jiayouya/travel/GlideImageLoader$loadImage$1", "Lcom/bumptech/glide/request/target/SimpleTarget;", "Landroid/graphics/Bitmap;", "onLoadFailed", "", "errorDrawable", "Landroid/graphics/drawable/Drawable;", "onResourceReady", "resource", "transition", "Lcom/bumptech/glide/request/transition/Transition;", "app_grRelease"}, mo39190k = 1, mo39191mv = {1, 1, 15})
    /* compiled from: Launcher.kt */
    /* renamed from: com.jiayouya.travel.GlideImageLoader$a */
    public static final class C2827a extends SimpleTarget<Bitmap> {
        /* renamed from: a */
        final /* synthetic */ ImageLoaderListener f9539a;
        /* renamed from: b */
        final /* synthetic */ IntRef f9540b;
        /* renamed from: c */
        final /* synthetic */ IntRef f9541c;

        C2827a(ImageLoaderListener imageLoaderListener, IntRef intRef, IntRef intRef2, int i, int i2) {
            this.f9539a = imageLoaderListener;
            this.f9540b = intRef;
            this.f9541c = intRef2;
            super(i, i2);
        }

        /* renamed from: a */
        public void onResourceReady(Bitmap bitmap, Transition<? super Bitmap> fVar) {
            C8271i.m35386b(bitmap, "resource");
            ImageLoaderListener imageLoaderListener = this.f9539a;
            if (imageLoaderListener != null) {
                imageLoaderListener.onLoadComplete(bitmap);
            }
        }

        public void onLoadFailed(Drawable drawable) {
            ImageLoaderListener imageLoaderListener = this.f9539a;
            if (imageLoaderListener != null) {
                imageLoaderListener.onLoadFailed(new Exception(""));
            }
        }
    }

    public Bitmap loadImageSync(String str, int i, int i2) {
        C8271i.m35386b(str, "uri");
        return null;
    }

    public GlideImageLoader(Context context) {
        C8271i.m35386b(context, "context");
        this.f9538a = context;
    }

    public void loadImage(String str, int i, int i2, ImageLoaderListener imageLoaderListener) {
        C8271i.m35386b(str, "uri");
        IntRef intRef = new IntRef();
        intRef.element = i;
        IntRef intRef2 = new IntRef();
        intRef2.element = i2;
        if (intRef.element <= 0 || intRef2.element <= 0) {
            intRef2.element = Integer.MIN_VALUE;
            intRef.element = intRef2.element;
        }
        RequestBuilder a = Glide.m5174b(this.f9538a).mo12599c().mo12588a(str);
        C2827a aVar = new C2827a(imageLoaderListener, intRef, intRef2, intRef.element, intRef2.element);
        a.mo12580a(aVar);
    }
}
