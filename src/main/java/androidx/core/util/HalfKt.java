package androidx.core.util;

import android.util.Half;
import kotlin.Metadata;
import kotlin.jvm.internal.C8271i;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0002\u0010\u0007\n\u0002\u0010\n\n\u0002\u0010\u000e\n\u0000\u001a\r\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\b\u001a\r\u0010\u0000\u001a\u00020\u0001*\u00020\u0003H\b\u001a\r\u0010\u0000\u001a\u00020\u0001*\u00020\u0004H\b\u001a\r\u0010\u0000\u001a\u00020\u0001*\u00020\u0005H\b¨\u0006\u0006"}, mo39189d2 = {"toHalf", "Landroid/util/Half;", "", "", "", "", "core-ktx_release"}, mo39190k = 2, mo39191mv = {1, 1, 15})
/* compiled from: Half.kt */
public final class HalfKt {
    public static final Half toHalf(short s) {
        Half valueOf = Half.valueOf(s);
        C8271i.m35382a((Object) valueOf, "Half.valueOf(this)");
        return valueOf;
    }

    public static final Half toHalf(float f) {
        Half valueOf = Half.valueOf(f);
        C8271i.m35382a((Object) valueOf, "Half.valueOf(this)");
        return valueOf;
    }

    public static final Half toHalf(String str) {
        C8271i.m35386b(str, "$this$toHalf");
        Half valueOf = Half.valueOf(str);
        C8271i.m35382a((Object) valueOf, "Half.valueOf(this)");
        return valueOf;
    }

    public static final Half toHalf(double d) {
        Half valueOf = Half.valueOf((float) d);
        C8271i.m35382a((Object) valueOf, "Half.valueOf(this)");
        return valueOf;
    }
}
