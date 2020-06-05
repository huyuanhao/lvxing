package androidx.core.graphics;

import android.graphics.ImageDecoder;
import android.graphics.ImageDecoder.ImageInfo;
import android.graphics.ImageDecoder.OnHeaderDecodedListener;
import android.graphics.ImageDecoder.Source;
import com.tencent.p605ep.common.adapt.iservice.account.AccountConst.ArgKey;
import kotlin.Metadata;
import kotlin.jvm.internal.C8271i;
import kotlin.jvm.p679a.C8262q;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u00010\u00060\u00062\u000e\u0010\u0007\u001a\n \u0004*\u0004\u0018\u00010\b0\bH\n¢\u0006\u0002\b\t"}, mo39189d2 = {"<anonymous>", "", "decoder", "Landroid/graphics/ImageDecoder;", "kotlin.jvm.PlatformType", "info", "Landroid/graphics/ImageDecoder$ImageInfo;", "source", "Landroid/graphics/ImageDecoder$Source;", "onHeaderDecoded"}, mo39190k = 3, mo39191mv = {1, 1, 15})
/* compiled from: ImageDecoder.kt */
public final class ImageDecoderKt$decodeBitmap$1 implements OnHeaderDecodedListener {
    final /* synthetic */ C8262q $action;

    public ImageDecoderKt$decodeBitmap$1(C8262q qVar) {
        this.$action = qVar;
    }

    public final void onHeaderDecoded(ImageDecoder imageDecoder, ImageInfo imageInfo, Source source) {
        C8262q qVar = this.$action;
        C8271i.m35382a((Object) imageDecoder, "decoder");
        C8271i.m35382a((Object) imageInfo, "info");
        C8271i.m35382a((Object) source, ArgKey.KEY_SOURCE);
        qVar.invoke(imageDecoder, imageInfo, source);
    }
}
