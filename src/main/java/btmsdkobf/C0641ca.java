package btmsdkobf;

import com.p522qq.taf.jce.JceInputStream;
import com.p522qq.taf.jce.JceOutputStream;
import com.p522qq.taf.jce.JceStruct;

/* renamed from: btmsdkobf.ca */
public final class C0641ca extends JceStruct {
    /* renamed from: fh */
    public String f375fh = "";

    public JceStruct newInit() {
        return new C0641ca();
    }

    public void readFrom(JceInputStream jceInputStream) {
        this.f375fh = jceInputStream.readString(0, true);
    }

    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.f375fh, 0);
    }
}
