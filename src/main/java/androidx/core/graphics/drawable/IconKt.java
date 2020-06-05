package androidx.core.graphics.drawable;

import android.graphics.Bitmap;
import android.graphics.drawable.Icon;
import android.net.Uri;
import kotlin.Metadata;
import kotlin.jvm.internal.C8271i;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\u001a\r\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\b\u001a\r\u0010\u0003\u001a\u00020\u0001*\u00020\u0002H\b\u001a\r\u0010\u0003\u001a\u00020\u0001*\u00020\u0004H\b\u001a\r\u0010\u0003\u001a\u00020\u0001*\u00020\u0005H\b¨\u0006\u0006"}, mo39189d2 = {"toAdaptiveIcon", "Landroid/graphics/drawable/Icon;", "Landroid/graphics/Bitmap;", "toIcon", "Landroid/net/Uri;", "", "core-ktx_release"}, mo39190k = 2, mo39191mv = {1, 1, 15})
/* compiled from: Icon.kt */
public final class IconKt {
    public static final Icon toAdaptiveIcon(Bitmap bitmap) {
        C8271i.m35386b(bitmap, "$this$toAdaptiveIcon");
        Icon createWithAdaptiveBitmap = Icon.createWithAdaptiveBitmap(bitmap);
        C8271i.m35382a((Object) createWithAdaptiveBitmap, "Icon.createWithAdaptiveBitmap(this)");
        return createWithAdaptiveBitmap;
    }

    public static final Icon toIcon(Bitmap bitmap) {
        C8271i.m35386b(bitmap, "$this$toIcon");
        Icon createWithBitmap = Icon.createWithBitmap(bitmap);
        C8271i.m35382a((Object) createWithBitmap, "Icon.createWithBitmap(this)");
        return createWithBitmap;
    }

    public static final Icon toIcon(Uri uri) {
        C8271i.m35386b(uri, "$this$toIcon");
        Icon createWithContentUri = Icon.createWithContentUri(uri);
        C8271i.m35382a((Object) createWithContentUri, "Icon.createWithContentUri(this)");
        return createWithContentUri;
    }

    public static final Icon toIcon(byte[] bArr) {
        C8271i.m35386b(bArr, "$this$toIcon");
        Icon createWithData = Icon.createWithData(bArr, 0, bArr.length);
        C8271i.m35382a((Object) createWithData, "Icon.createWithData(this, 0, size)");
        return createWithData;
    }
}
