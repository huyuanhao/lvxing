package btmsdkobf;

import com.p522qq.taf.jce.JceInputStream;
import com.p522qq.taf.jce.JceOutputStream;
import com.p522qq.taf.jce.JceStruct;

/* renamed from: btmsdkobf.bg */
public final class C0618bg extends JceStruct {
    /* renamed from: cD */
    public int f197cD = 0;
    /* renamed from: cE */
    public int f198cE = 0;
    /* renamed from: cF */
    public int f199cF = 0;

    public JceStruct newInit() {
        return new C0618bg();
    }

    public void readFrom(JceInputStream jceInputStream) {
        this.f197cD = jceInputStream.read(this.f197cD, 0, false);
        this.f198cE = jceInputStream.read(this.f198cE, 1, false);
        this.f199cF = jceInputStream.read(this.f199cF, 2, false);
    }

    public void writeTo(JceOutputStream jceOutputStream) {
        int i = this.f197cD;
        if (i != 0) {
            jceOutputStream.write(i, 0);
        }
        int i2 = this.f198cE;
        if (i2 != 0) {
            jceOutputStream.write(i2, 1);
        }
        int i3 = this.f199cF;
        if (i3 != 0) {
            jceOutputStream.write(i3, 2);
        }
    }
}
