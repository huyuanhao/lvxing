package androidx.core.graphics;

import android.graphics.Canvas;
import android.graphics.Picture;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.C8271i;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.p679a.C8247b;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\"\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u001a6\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0017\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006¢\u0006\u0002\b\tH\b¨\u0006\n"}, mo39189d2 = {"record", "Landroid/graphics/Picture;", "width", "", "height", "block", "Lkotlin/Function1;", "Landroid/graphics/Canvas;", "", "Lkotlin/ExtensionFunctionType;", "core-ktx_release"}, mo39190k = 2, mo39191mv = {1, 1, 15})
/* compiled from: Picture.kt */
public final class PictureKt {
    public static final Picture record(Picture picture, int i, int i2, C8247b<? super Canvas, Unit> bVar) {
        C8271i.m35386b(picture, "$this$record");
        C8271i.m35386b(bVar, "block");
        Canvas beginRecording = picture.beginRecording(i, i2);
        try {
            C8271i.m35382a((Object) beginRecording, "c");
            bVar.invoke(beginRecording);
            return picture;
        } finally {
            InlineMarker.m35375a(1);
            picture.endRecording();
            InlineMarker.m35376b(1);
        }
    }
}
