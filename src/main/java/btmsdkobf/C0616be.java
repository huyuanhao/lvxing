package btmsdkobf;

import com.p522qq.taf.jce.JceInputStream;
import com.p522qq.taf.jce.JceOutputStream;
import com.p522qq.taf.jce.JceStruct;

/* renamed from: btmsdkobf.be */
public final class C0616be extends JceStruct {
    /* renamed from: cA */
    static C0617bf f192cA = new C0617bf();
    /* renamed from: cy */
    public int f193cy = 0;
    /* renamed from: cz */
    public C0617bf f194cz = null;

    public JceStruct newInit() {
        return new C0616be();
    }

    public void readFrom(JceInputStream jceInputStream) {
        this.f193cy = jceInputStream.read(this.f193cy, 0, true);
        this.f194cz = (C0617bf) jceInputStream.read((JceStruct) f192cA, 1, false);
    }

    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.f193cy, 0);
        C0617bf bfVar = this.f194cz;
        if (bfVar != null) {
            jceOutputStream.write((JceStruct) bfVar, 1);
        }
    }
}
