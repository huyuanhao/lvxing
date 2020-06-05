package btmsdkobf;

/* renamed from: btmsdkobf.cu */
public class C0667cu {
    /* renamed from: a */
    public static long m142a(int i, long j) {
        if (i < 0) {
            throw new IllegalStateException("thread pool sub-ident is negative");
        } else if (j >= 0) {
            return ((long) i) + j;
        } else {
            throw new IllegalStateException("thread pool parent-ident is illegal");
        }
    }
}
