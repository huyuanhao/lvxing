package btmsdkobf;

import com.p522qq.taf.jce.JceInputStream;
import com.p522qq.taf.jce.JceOutputStream;
import com.p522qq.taf.jce.JceStruct;

/* renamed from: btmsdkobf.cc */
public final class C0643cc extends JceStruct {
    /* renamed from: as */
    public String f377as = "";

    public JceStruct newInit() {
        return new C0643cc();
    }

    public void readFrom(JceInputStream jceInputStream) {
        this.f377as = jceInputStream.readString(0, true);
    }

    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.f377as, 0);
    }
}
