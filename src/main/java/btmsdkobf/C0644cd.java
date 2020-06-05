package btmsdkobf;

import com.p522qq.taf.jce.JceInputStream;
import com.p522qq.taf.jce.JceOutputStream;
import com.p522qq.taf.jce.JceStruct;

/* renamed from: btmsdkobf.cd */
public final class C0644cd extends JceStruct {
    /* renamed from: fC */
    public String f378fC = "";

    public JceStruct newInit() {
        return new C0644cd();
    }

    public void readFrom(JceInputStream jceInputStream) {
        this.f378fC = jceInputStream.readString(0, true);
    }

    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.f378fC, 0);
    }
}
