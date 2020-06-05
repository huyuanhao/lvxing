package btmsdkobf;

import java.io.Serializable;

/* renamed from: btmsdkobf.ck */
public final class C0651ck implements Serializable {
    /* renamed from: az */
    static final /* synthetic */ boolean f407az = (!C0651ck.class.desiredAssertionStatus());
    /* renamed from: fR */
    private static C0651ck[] f408fR = new C0651ck[6];
    /* renamed from: fU */
    public static final C0651ck f409fU = new C0651ck(0, 0, "CT_NONE");
    /* renamed from: fV */
    public static final C0651ck f410fV = new C0651ck(1, 1, "CT_GPRS");
    /* renamed from: fW */
    public static final C0651ck f411fW = new C0651ck(2, 2, "CT_WIFI");
    /* renamed from: fX */
    public static final C0651ck f412fX = new C0651ck(3, 3, "CT_GPRS_WAP");
    /* renamed from: fY */
    public static final C0651ck f413fY = new C0651ck(4, 4, "CT_GPRS_NET");
    /* renamed from: fZ */
    public static final C0651ck f414fZ = new C0651ck(5, 5, "CT_3G_NET");
    /* renamed from: fS */
    private int f415fS;
    /* renamed from: fT */
    private String f416fT = new String();

    private C0651ck(int i, int i2, String str) {
        this.f416fT = str;
        this.f415fS = i2;
        f408fR[i] = this;
    }

    public String toString() {
        return this.f416fT;
    }
}
