package btmsdkobf;

import com.p522qq.taf.jce.JceInputStream;
import com.p522qq.taf.jce.JceOutputStream;
import com.p522qq.taf.jce.JceStruct;

/* renamed from: btmsdkobf.by */
public final class C0636by extends JceStruct {
    /* renamed from: fu */
    static byte[] f355fu = new byte[1];
    /* renamed from: fv */
    static C0635bx f356fv = new C0635bx();
    /* renamed from: dO */
    public int f357dO = 0;
    /* renamed from: fm */
    public int f358fm = 0;
    /* renamed from: fn */
    public int f359fn = 0;
    /* renamed from: fo */
    public byte[] f360fo = null;
    /* renamed from: fp */
    public long f361fp = 0;
    /* renamed from: fq */
    public int f362fq = 0;
    /* renamed from: fr */
    public int f363fr = 0;
    /* renamed from: fs */
    public C0635bx f364fs = null;
    /* renamed from: ft */
    public int f365ft = 0;

    static {
        f355fu[0] = 0;
    }

    public JceStruct newInit() {
        return new C0636by();
    }

    public void readFrom(JceInputStream jceInputStream) {
        this.f357dO = jceInputStream.read(this.f357dO, 0, true);
        this.f358fm = jceInputStream.read(this.f358fm, 1, false);
        this.f359fn = jceInputStream.read(this.f359fn, 2, false);
        this.f360fo = jceInputStream.read(f355fu, 3, false);
        this.f361fp = jceInputStream.read(this.f361fp, 4, false);
        this.f362fq = jceInputStream.read(this.f362fq, 5, false);
        this.f363fr = jceInputStream.read(this.f363fr, 6, false);
        this.f364fs = (C0635bx) jceInputStream.read((JceStruct) f356fv, 7, false);
        this.f365ft = jceInputStream.read(this.f365ft, 8, false);
    }

    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.f357dO, 0);
        int i = this.f358fm;
        if (i != 0) {
            jceOutputStream.write(i, 1);
        }
        int i2 = this.f359fn;
        if (i2 != 0) {
            jceOutputStream.write(i2, 2);
        }
        byte[] bArr = this.f360fo;
        if (bArr != null) {
            jceOutputStream.write(bArr, 3);
        }
        long j = this.f361fp;
        if (j != 0) {
            jceOutputStream.write(j, 4);
        }
        int i3 = this.f362fq;
        if (i3 != 0) {
            jceOutputStream.write(i3, 5);
        }
        int i4 = this.f363fr;
        if (i4 != 0) {
            jceOutputStream.write(i4, 6);
        }
        C0635bx bxVar = this.f364fs;
        if (bxVar != null) {
            jceOutputStream.write((JceStruct) bxVar, 7);
        }
        int i5 = this.f365ft;
        if (i5 != 0) {
            jceOutputStream.write(i5, 8);
        }
    }
}
