package btmsdkobf;

import com.p522qq.taf.jce.JceInputStream;
import com.p522qq.taf.jce.JceOutputStream;
import com.p522qq.taf.jce.JceStruct;

/* renamed from: btmsdkobf.bx */
public final class C0635bx extends JceStruct {
    /* renamed from: fl */
    public long f354fl = 0;

    public JceStruct newInit() {
        return new C0635bx();
    }

    public void readFrom(JceInputStream jceInputStream) {
        this.f354fl = jceInputStream.read(this.f354fl, 0, false);
    }

    public void writeTo(JceOutputStream jceOutputStream) {
        long j = this.f354fl;
        if (j != 0) {
            jceOutputStream.write(j, 0);
        }
    }
}
