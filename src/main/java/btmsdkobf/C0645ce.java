package btmsdkobf;

import com.p522qq.taf.jce.JceInputStream;
import com.p522qq.taf.jce.JceOutputStream;
import com.p522qq.taf.jce.JceStruct;

/* renamed from: btmsdkobf.ce */
public final class C0645ce extends JceStruct {
    /* renamed from: fC */
    public String f379fC = "";

    public JceStruct newInit() {
        return new C0645ce();
    }

    public void readFrom(JceInputStream jceInputStream) {
        this.f379fC = jceInputStream.readString(0, true);
    }

    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.f379fC, 0);
    }
}
