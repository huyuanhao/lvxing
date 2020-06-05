package btmsdkobf;

import com.p522qq.taf.jce.JceInputStream;
import com.p522qq.taf.jce.JceOutputStream;
import com.p522qq.taf.jce.JceStruct;

/* renamed from: btmsdkobf.cb */
public final class C0642cb extends JceStruct {
    /* renamed from: fB */
    public int f376fB = 0;

    public JceStruct newInit() {
        return new C0642cb();
    }

    public void readFrom(JceInputStream jceInputStream) {
        this.f376fB = jceInputStream.read(this.f376fB, 0, true);
    }

    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.f376fB, 0);
    }
}
