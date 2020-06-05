package btmsdkobf;

import com.p522qq.taf.jce.JceInputStream;
import com.p522qq.taf.jce.JceOutputStream;
import com.p522qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

/* renamed from: btmsdkobf.bp */
public final class C0627bp extends JceStruct {
    /* renamed from: dL */
    static byte[] f256dL = new byte[1];
    /* renamed from: dM */
    static byte[] f257dM = new byte[1];
    /* renamed from: dN */
    static Map<String, String> f258dN = new HashMap();
    /* renamed from: dr */
    static byte[] f259dr = new byte[1];
    /* renamed from: cn */
    public int f260cn = 0;
    /* renamed from: dB */
    public boolean f261dB;
    /* renamed from: dC */
    public byte[] f262dC;
    /* renamed from: dD */
    public byte[] f263dD;
    /* renamed from: dE */
    public int f264dE;
    /* renamed from: dF */
    public int f265dF;
    /* renamed from: dG */
    public long f266dG;
    /* renamed from: dH */
    public int f267dH;
    /* renamed from: dI */
    public int f268dI;
    /* renamed from: dJ */
    public String f269dJ;
    /* renamed from: dK */
    public Map<String, String> f270dK;
    /* renamed from: dn */
    public int f271dn = 0;
    /* renamed from: do */
    public byte[] f272do = null;
    public String url;

    static {
        f259dr[0] = 0;
        f256dL[0] = 0;
        f257dM[0] = 0;
        String str = "";
        f258dN.put(str, str);
    }

    public C0627bp() {
        String str = "";
        this.url = str;
        this.f261dB = false;
        this.f262dC = null;
        this.f263dD = null;
        this.f264dE = 0;
        this.f265dF = 0;
        this.f266dG = 0;
        this.f267dH = 0;
        this.f268dI = 0;
        this.f269dJ = str;
        this.f270dK = null;
    }

    public JceStruct newInit() {
        return new C0627bp();
    }

    public void readFrom(JceInputStream jceInputStream) {
        this.f271dn = jceInputStream.read(this.f271dn, 0, true);
        this.f272do = jceInputStream.read(f259dr, 1, true);
        this.f260cn = jceInputStream.read(this.f260cn, 2, true);
        this.url = jceInputStream.readString(3, false);
        this.f261dB = jceInputStream.read(this.f261dB, 4, false);
        this.f262dC = jceInputStream.read(f256dL, 5, false);
        this.f263dD = jceInputStream.read(f257dM, 6, false);
        this.f264dE = jceInputStream.read(this.f264dE, 7, false);
        this.f265dF = jceInputStream.read(this.f265dF, 8, false);
        this.f266dG = jceInputStream.read(this.f266dG, 9, false);
        this.f267dH = jceInputStream.read(this.f267dH, 10, false);
        this.f268dI = jceInputStream.read(this.f268dI, 11, false);
        this.f269dJ = jceInputStream.readString(12, false);
        this.f270dK = (Map) jceInputStream.read(f258dN, 13, false);
    }

    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.f271dn, 0);
        jceOutputStream.write(this.f272do, 1);
        jceOutputStream.write(this.f260cn, 2);
        String str = this.url;
        if (str != null) {
            jceOutputStream.write(str, 3);
        }
        boolean z = this.f261dB;
        if (z) {
            jceOutputStream.write(z, 4);
        }
        byte[] bArr = this.f262dC;
        if (bArr != null) {
            jceOutputStream.write(bArr, 5);
        }
        byte[] bArr2 = this.f263dD;
        if (bArr2 != null) {
            jceOutputStream.write(bArr2, 6);
        }
        int i = this.f264dE;
        if (i != 0) {
            jceOutputStream.write(i, 7);
        }
        int i2 = this.f265dF;
        if (i2 != 0) {
            jceOutputStream.write(i2, 8);
        }
        long j = this.f266dG;
        if (j != 0) {
            jceOutputStream.write(j, 9);
        }
        int i3 = this.f267dH;
        if (i3 != 0) {
            jceOutputStream.write(i3, 10);
        }
        int i4 = this.f268dI;
        if (i4 != 0) {
            jceOutputStream.write(i4, 11);
        }
        String str2 = this.f269dJ;
        if (str2 != null) {
            jceOutputStream.write(str2, 12);
        }
        Map<String, String> map = this.f270dK;
        if (map != null) {
            jceOutputStream.write(map, 13);
        }
    }
}
