package btmsdkobf;

import com.p522qq.taf.jce.JceInputStream;
import com.p522qq.taf.jce.JceOutputStream;
import com.p522qq.taf.jce.JceStruct;

/* renamed from: btmsdkobf.bq */
public final class C0628bq extends JceStruct {
    /* renamed from: dQ */
    static byte[] f273dQ = new byte[1];
    /* renamed from: dO */
    public int f274dO = 0;
    /* renamed from: dP */
    public byte[] f275dP = null;
    public int status = 0;

    static {
        f273dQ[0] = 0;
    }

    public JceStruct newInit() {
        return new C0628bq();
    }

    public void readFrom(JceInputStream jceInputStream) {
        this.f274dO = jceInputStream.read(this.f274dO, 0, true);
        this.f275dP = jceInputStream.read(f273dQ, 1, false);
        this.status = jceInputStream.read(this.status, 2, false);
    }

    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.f274dO, 0);
        byte[] bArr = this.f275dP;
        if (bArr != null) {
            jceOutputStream.write(bArr, 1);
        }
        int i = this.status;
        if (i != 0) {
            jceOutputStream.write(i, 2);
        }
    }
}
