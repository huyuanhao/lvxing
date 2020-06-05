package p655io.reactivex.internal.util;

/* renamed from: io.reactivex.internal.util.g */
public final class Pow2 {
    /* renamed from: a */
    public static int m35194a(int i) {
        return 1 << (32 - Integer.numberOfLeadingZeros(i - 1));
    }
}
