package btmsdkobf;

import com.p522qq.taf.jce.JceInputStream;
import com.p522qq.taf.jce.JceOutputStream;
import com.p522qq.taf.jce.JceStruct;

/* renamed from: btmsdkobf.p */
public final class C0881p extends JceStruct {
    /* renamed from: ae */
    public int f1055ae = 0;
    /* renamed from: af */
    public int f1056af = 0;

    public void readFrom(JceInputStream jceInputStream) {
        this.f1055ae = jceInputStream.read(this.f1055ae, 0, true);
        this.f1056af = jceInputStream.read(this.f1056af, 1, false);
    }

    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.f1055ae, 0);
        int i = this.f1056af;
        if (i != 0) {
            jceOutputStream.write(i, 1);
        }
    }
}
