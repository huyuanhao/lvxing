package btmsdkobf;

import com.p522qq.taf.jce.JceInputStream;
import com.p522qq.taf.jce.JceOutputStream;
import com.p522qq.taf.jce.JceStruct;

/* renamed from: btmsdkobf.al */
public final class C0574al extends JceStruct {
    /* renamed from: W */
    public int f108W = 0;
    /* renamed from: bu */
    public long f109bu = 0;
    /* renamed from: bv */
    public int f110bv;
    /* renamed from: bw */
    public int f111bw;
    public String resource;
    public String stock;

    public C0574al() {
        String str = "";
        this.resource = str;
        this.stock = str;
        this.f110bv = 0;
        this.f111bw = 0;
    }

    public JceStruct newInit() {
        return new C0574al();
    }

    public void readFrom(JceInputStream jceInputStream) {
        this.f108W = jceInputStream.read(this.f108W, 0, true);
        this.f109bu = jceInputStream.read(this.f109bu, 1, false);
        this.resource = jceInputStream.readString(2, false);
        this.stock = jceInputStream.readString(3, false);
        this.f110bv = jceInputStream.read(this.f110bv, 4, false);
        this.f111bw = jceInputStream.read(this.f111bw, 5, false);
    }

    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.f108W, 0);
        long j = this.f109bu;
        if (j != 0) {
            jceOutputStream.write(j, 1);
        }
        String str = this.resource;
        if (str != null) {
            jceOutputStream.write(str, 2);
        }
        String str2 = this.stock;
        if (str2 != null) {
            jceOutputStream.write(str2, 3);
        }
        int i = this.f110bv;
        if (i != 0) {
            jceOutputStream.write(i, 4);
        }
        int i2 = this.f111bw;
        if (i2 != 0) {
            jceOutputStream.write(i2, 5);
        }
    }
}
