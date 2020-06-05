package btmsdkobf;

import com.p522qq.taf.jce.JceInputStream;
import com.p522qq.taf.jce.JceOutputStream;
import com.p522qq.taf.jce.JceStruct;

/* renamed from: btmsdkobf.bs */
public final class C0630bs extends JceStruct {
    /* renamed from: cZ */
    public String f278cZ = "";

    public JceStruct newInit() {
        return new C0630bs();
    }

    public void readFrom(JceInputStream jceInputStream) {
        this.f278cZ = jceInputStream.readString(0, false);
    }

    public void writeTo(JceOutputStream jceOutputStream) {
        String str = this.f278cZ;
        if (str != null) {
            jceOutputStream.write(str, 0);
        }
    }
}
