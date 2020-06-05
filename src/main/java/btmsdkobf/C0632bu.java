package btmsdkobf;

import com.p522qq.taf.jce.JceInputStream;
import com.p522qq.taf.jce.JceOutputStream;
import com.p522qq.taf.jce.JceStruct;

/* renamed from: btmsdkobf.bu */
public final class C0632bu extends JceStruct {
    /* renamed from: fd */
    public String f345fd = "";

    public JceStruct newInit() {
        return new C0632bu();
    }

    public void readFrom(JceInputStream jceInputStream) {
        this.f345fd = jceInputStream.readString(0, true);
    }

    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.f345fd, 0);
    }
}
