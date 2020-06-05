package btmsdkobf;

import com.p522qq.taf.jce.JceInputStream;
import com.p522qq.taf.jce.JceOutputStream;
import com.p522qq.taf.jce.JceStruct;

/* renamed from: btmsdkobf.cg */
public final class C0647cg extends JceStruct {
    /* renamed from: fE */
    static C0646cf f381fE = new C0646cf();
    /* renamed from: fu */
    static byte[] f382fu = new byte[1];
    /* renamed from: dO */
    public int f383dO = 0;
    /* renamed from: fD */
    public C0646cf f384fD = null;
    /* renamed from: fm */
    public int f385fm = 0;
    /* renamed from: fn */
    public int f386fn = 0;
    /* renamed from: fo */
    public byte[] f387fo = null;
    /* renamed from: fq */
    public int f388fq = 0;
    /* renamed from: fr */
    public int f389fr = 0;
    /* renamed from: ft */
    public int f390ft = 0;

    static {
        f382fu[0] = 0;
    }

    public JceStruct newInit() {
        return new C0647cg();
    }

    public void readFrom(JceInputStream jceInputStream) {
        this.f383dO = jceInputStream.read(this.f383dO, 0, true);
        this.f385fm = jceInputStream.read(this.f385fm, 1, false);
        this.f386fn = jceInputStream.read(this.f386fn, 2, false);
        this.f388fq = jceInputStream.read(this.f388fq, 3, false);
        this.f389fr = jceInputStream.read(this.f389fr, 4, false);
        this.f387fo = jceInputStream.read(f382fu, 5, false);
        this.f384fD = (C0646cf) jceInputStream.read((JceStruct) f381fE, 6, false);
        this.f390ft = jceInputStream.read(this.f390ft, 7, false);
    }

    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.f383dO, 0);
        int i = this.f385fm;
        if (i != 0) {
            jceOutputStream.write(i, 1);
        }
        int i2 = this.f386fn;
        if (i2 != 0) {
            jceOutputStream.write(i2, 2);
        }
        jceOutputStream.write(this.f388fq, 3);
        int i3 = this.f389fr;
        if (i3 != 0) {
            jceOutputStream.write(i3, 4);
        }
        byte[] bArr = this.f387fo;
        if (bArr != null) {
            jceOutputStream.write(bArr, 5);
        }
        C0646cf cfVar = this.f384fD;
        if (cfVar != null) {
            jceOutputStream.write((JceStruct) cfVar, 6);
        }
        int i4 = this.f390ft;
        if (i4 != 0) {
            jceOutputStream.write(i4, 7);
        }
    }
}
