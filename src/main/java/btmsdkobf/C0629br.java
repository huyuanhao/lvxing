package btmsdkobf;

import com.p522qq.taf.jce.JceInputStream;
import com.p522qq.taf.jce.JceOutputStream;
import com.p522qq.taf.jce.JceStruct;

/* renamed from: btmsdkobf.br */
public final class C0629br extends JceStruct {
    /* renamed from: dS */
    static byte[] f276dS = new byte[1];
    /* renamed from: dR */
    public byte[] f277dR = null;

    static {
        f276dS[0] = 0;
    }

    public JceStruct newInit() {
        return new C0629br();
    }

    public void readFrom(JceInputStream jceInputStream) {
        this.f277dR = jceInputStream.read(f276dS, 0, false);
    }

    public void writeTo(JceOutputStream jceOutputStream) {
        byte[] bArr = this.f277dR;
        if (bArr != null) {
            jceOutputStream.write(bArr, 0);
        }
    }
}
