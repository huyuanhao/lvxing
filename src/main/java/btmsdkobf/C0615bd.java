package btmsdkobf;

import com.p522qq.taf.jce.JceInputStream;
import com.p522qq.taf.jce.JceOutputStream;
import com.p522qq.taf.jce.JceStruct;

/* renamed from: btmsdkobf.bd */
public final class C0615bd extends JceStruct {
    /* renamed from: cy */
    public int f191cy = 0;

    public JceStruct newInit() {
        return new C0615bd();
    }

    public void readFrom(JceInputStream jceInputStream) {
        this.f191cy = jceInputStream.read(this.f191cy, 0, true);
    }

    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.f191cy, 0);
    }
}
