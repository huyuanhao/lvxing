package com.jiayouya.travel.common.p243a;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import androidx.databinding.BindingAdapter;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.bitmap.BitmapTransformation;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.CenterInside;
import com.bumptech.glide.load.resource.bitmap.DownsampleStrategy;
import com.bumptech.glide.p131c.BaseRequestOptions;
import com.bumptech.glide.p131c.RequestOptions;
import com.bumptech.glide.p131c.p132a.ViewTarget;
import com.bumptech.glide.p131c.p133b.Transition;
import com.jiayouya.travel.common.p244b.ActivityEx;
import com.jiayouya.travel.common.p246d.Mipmap;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.C8271i;
import p672jp.wasabeef.glide.transformations.RoundedCornersTransformation;
import p672jp.wasabeef.glide.transformations.RoundedCornersTransformation.CornerType;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001f\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0007¢\u0006\u0002\u0010\tJ\u001a\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\nH\u0007J\"\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\bH\u0007J*\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\bH\u0007J\u001a\u0010\r\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\nH\u0007J\u001a\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\nH\u0007J\u001a\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\nH\u0007J\u001f\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0007¢\u0006\u0002\u0010\u0013J\u001f\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0015\u001a\u0004\u0018\u00010\u0012H\u0007¢\u0006\u0002\u0010\u0013J;\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0017\u001a\u00020\b2\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\bH\u0007¢\u0006\u0002\u0010\u001bJ;\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0017\u001a\u00020\b2\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\bH\u0007¢\u0006\u0002\u0010\u001c¨\u0006\u001d"}, mo39189d2 = {"Lcom/jiayouya/travel/common/adapter/ImageAdapter;", "", "()V", "adapt", "", "view", "Landroid/widget/ImageView;", "src", "", "(Landroid/widget/ImageView;Ljava/lang/Integer;)V", "", "placeholder", "error", "adaptAdjustSizeHalf", "adaptAutoSize", "adaptCircle", "adaptColorFilter", "isGrey", "", "(Landroid/widget/ImageView;Ljava/lang/Boolean;)V", "adaptEnable", "enable", "adaptRound", "cornerRadius", "cornerType", "Ljp/wasabeef/glide/transformations/RoundedCornersTransformation$CornerType;", "scaleType", "(Landroid/widget/ImageView;Ljava/lang/Integer;ILjp/wasabeef/glide/transformations/RoundedCornersTransformation$CornerType;Ljava/lang/Integer;)V", "(Landroid/widget/ImageView;Ljava/lang/String;ILjp/wasabeef/glide/transformations/RoundedCornersTransformation$CornerType;Ljava/lang/Integer;)V", "app_grRelease"}, mo39190k = 1, mo39191mv = {1, 1, 15})
/* renamed from: com.jiayouya.travel.common.a.b */
public final class ImageAdapter {
    /* renamed from: a */
    public static final ImageAdapter f9558a = new ImageAdapter();

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001J\"\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00032\u0010\u0010\u0007\u001a\f\u0012\u0006\b\u0000\u0012\u00020\u0003\u0018\u00010\bH\u0016¨\u0006\t"}, mo39189d2 = {"com/jiayouya/travel/common/adapter/ImageAdapter$adaptAutoSize$1", "Lcom/bumptech/glide/request/target/ViewTarget;", "Landroid/widget/ImageView;", "Landroid/graphics/drawable/Drawable;", "onResourceReady", "", "resource", "transition", "Lcom/bumptech/glide/request/transition/Transition;", "app_grRelease"}, mo39190k = 1, mo39191mv = {1, 1, 15})
    /* compiled from: ImageAdapter.kt */
    /* renamed from: com.jiayouya.travel.common.a.b$a */
    public static final class C2853a extends ViewTarget<ImageView, Drawable> {
        /* renamed from: b */
        final /* synthetic */ ImageView f9559b;

        C2853a(ImageView imageView, View view) {
            this.f9559b = imageView;
            super(view);
        }

        /* renamed from: a */
        public void onResourceReady(Drawable drawable, Transition<? super Drawable> fVar) {
            C8271i.m35386b(drawable, "resource");
            LayoutParams layoutParams = this.f9559b.getLayoutParams();
            layoutParams.width = drawable.getIntrinsicWidth();
            layoutParams.height = drawable.getIntrinsicHeight();
            this.f9559b.setLayoutParams(layoutParams);
            this.f9559b.setImageDrawable(drawable);
        }
    }

    private ImageAdapter() {
    }

    @JvmStatic
    @BindingAdapter({"localSrc"})
    /* renamed from: a */
    public static final void m12780a(ImageView imageView, Integer num) {
        C8271i.m35386b(imageView, "view");
        if ((num == null || num.intValue() != -1) && num != null) {
            num.intValue();
            imageView.setImageResource(num.intValue());
        }
    }

    @JvmStatic
    @BindingAdapter({"autoSizeSrc"})
    /* renamed from: a */
    public static final void m12782a(ImageView imageView, String str) {
        C8271i.m35386b(imageView, "view");
        Context context = imageView.getContext();
        if ((!(context instanceof Activity) || ActivityEx.m12804a((Activity) context)) && !TextUtils.isEmpty(str)) {
            BaseRequestOptions a = ((RequestOptions) ((RequestOptions) new RequestOptions().mo12445h()).mo12428a((DownsampleStrategy) Mipmap.f9640d)).mo12425a(DiskCacheStrategy.f4631c);
            C8271i.m35382a((Object) a, "RequestOptions().dontAni…y(DiskCacheStrategy.DATA)");
            Glide.m5174b(context).mo12591a(str).mo12435b((BaseRequestOptions<?>) (RequestOptions) a).mo12580a(new C2853a(imageView, imageView));
        }
    }

    @JvmStatic
    @BindingAdapter(requireAll = false, value = {"android:src", "cornerRadius", "cornerType", "scaleType"})
    /* renamed from: a */
    public static final void m12783a(ImageView imageView, String str, int i, CornerType cornerType, Integer num) {
        C8271i.m35386b(imageView, "view");
        Context context = imageView.getContext();
        if (!(context instanceof Activity) || ActivityEx.m12804a((Activity) context)) {
            RequestOptions fVar = (RequestOptions) new RequestOptions().mo12445h();
            Transformation[] iVarArr = new Transformation[2];
            BitmapTransformation centerInside = (num != null && num.intValue() == 1) ? new CenterInside() : new CenterCrop();
            iVarArr[0] = centerInside;
            Context context2 = imageView.getContext();
            C8271i.m35382a((Object) context2, "view.context");
            int a = ezy.p642a.Context.m34741a(context2, (float) i);
            if (cornerType == null) {
                cornerType = CornerType.ALL;
            }
            iVarArr[1] = new RoundedCornersTransformation(a, 0, cornerType);
            BaseRequestOptions a2 = ((RequestOptions) fVar.mo12433a((Transformation<Bitmap>[]) iVarArr)).mo12425a(DiskCacheStrategy.f4631c);
            C8271i.m35382a((Object) a2, "RequestOptions().dontAni…y(DiskCacheStrategy.DATA)");
            Glide.m5174b(context).mo12591a(str).mo12435b((BaseRequestOptions<?>) (RequestOptions) a2).mo12582a(imageView);
        }
    }

    @JvmStatic
    @BindingAdapter(requireAll = false, value = {"android:src", "cornerRadius", "cornerType", "scaleType"})
    /* renamed from: a */
    public static final void m12781a(ImageView imageView, Integer num, int i, CornerType cornerType, Integer num2) {
        C8271i.m35386b(imageView, "view");
        Context context = imageView.getContext();
        if (!(context instanceof Activity) || ActivityEx.m12804a((Activity) context)) {
            RequestOptions fVar = (RequestOptions) new RequestOptions().mo12445h();
            Transformation[] iVarArr = new Transformation[2];
            BitmapTransformation centerInside = (num2 != null && num2.intValue() == 1) ? new CenterInside() : new CenterCrop();
            iVarArr[0] = centerInside;
            Context context2 = imageView.getContext();
            C8271i.m35382a((Object) context2, "view.context");
            int a = ezy.p642a.Context.m34741a(context2, (float) i);
            if (cornerType == null) {
                cornerType = CornerType.ALL;
            }
            iVarArr[1] = new RoundedCornersTransformation(a, 0, cornerType);
            BaseRequestOptions a2 = ((RequestOptions) fVar.mo12433a((Transformation<Bitmap>[]) iVarArr)).mo12425a(DiskCacheStrategy.f4631c);
            C8271i.m35382a((Object) a2, "RequestOptions().dontAni…y(DiskCacheStrategy.DATA)");
            Glide.m5174b(context).mo12590a(num).mo12435b((BaseRequestOptions<?>) (RequestOptions) a2).mo12582a(imageView);
        }
    }
}
