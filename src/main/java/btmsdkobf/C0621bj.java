package btmsdkobf;

import com.p522qq.taf.jce.JceInputStream;
import com.p522qq.taf.jce.JceOutputStream;
import com.p522qq.taf.jce.JceStruct;

/* renamed from: btmsdkobf.bj */
public final class C0621bj extends JceStruct {
    /* renamed from: as */
    public String f221as;
    /* renamed from: cJ */
    public int f222cJ = 2;
    /* renamed from: cX */
    public int f223cX = 0;
    /* renamed from: cY */
    public String f224cY;
    /* renamed from: cZ */
    public String f225cZ;
    /* renamed from: cw */
    public int f226cw;
    /* renamed from: da */
    public int f227da;
    /* renamed from: db */
    public long f228db;
    /* renamed from: dc */
    public int f229dc;
    /* renamed from: dd */
    public String f230dd;

    public C0621bj() {
        String str = "";
        this.f221as = str;
        this.f224cY = str;
        this.f225cZ = str;
        this.f226cw = 0;
        this.f227da = 0;
        this.f228db = 0;
        this.f229dc = 0;
        this.f230dd = str;
    }

    public JceStruct newInit() {
        return new C0621bj();
    }

    public void readFrom(JceInputStream jceInputStream) {
        this.f222cJ = jceInputStream.read(this.f222cJ, 0, true);
        this.f223cX = jceInputStream.read(this.f223cX, 1, true);
        this.f221as = jceInputStream.readString(2, false);
        this.f224cY = jceInputStream.readString(3, false);
        this.f225cZ = jceInputStream.readString(4, false);
        this.f226cw = jceInputStream.read(this.f226cw, 5, false);
        this.f227da = jceInputStream.read(this.f227da, 6, false);
        this.f228db = jceInputStream.read(this.f228db, 7, false);
        this.f229dc = jceInputStream.read(this.f229dc, 8, false);
        this.f230dd = jceInputStream.readString(9, false);
    }

    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.f222cJ, 0);
        jceOutputStream.write(this.f223cX, 1);
        String str = this.f221as;
        if (str != null) {
            jceOutputStream.write(str, 2);
        }
        String str2 = this.f224cY;
        if (str2 != null) {
            jceOutputStream.write(str2, 3);
        }
        String str3 = this.f225cZ;
        if (str3 != null) {
            jceOutputStream.write(str3, 4);
        }
        int i = this.f226cw;
        if (i != 0) {
            jceOutputStream.write(i, 5);
        }
        int i2 = this.f227da;
        if (i2 != 0) {
            jceOutputStream.write(i2, 6);
        }
        long j = this.f228db;
        if (j != 0) {
            jceOutputStream.write(j, 7);
        }
        int i3 = this.f229dc;
        if (i3 != 0) {
            jceOutputStream.write(i3, 8);
        }
        String str4 = this.f230dd;
        if (str4 != null) {
            jceOutputStream.write(str4, 9);
        }
    }
}
