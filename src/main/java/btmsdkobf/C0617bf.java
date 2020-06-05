package btmsdkobf;

import com.p522qq.taf.jce.JceInputStream;
import com.p522qq.taf.jce.JceOutputStream;
import com.p522qq.taf.jce.JceStruct;

/* renamed from: btmsdkobf.bf */
public final class C0617bf extends JceStruct {
    /* renamed from: cB */
    public long f195cB = 0;
    /* renamed from: cC */
    public long f196cC = 0;

    public JceStruct newInit() {
        return new C0617bf();
    }

    public void readFrom(JceInputStream jceInputStream) {
        this.f195cB = jceInputStream.read(this.f195cB, 0, false);
        this.f196cC = jceInputStream.read(this.f196cC, 1, false);
    }

    public void writeTo(JceOutputStream jceOutputStream) {
        long j = this.f195cB;
        if (j != 0) {
            jceOutputStream.write(j, 0);
        }
        long j2 = this.f196cC;
        if (j2 != 0) {
            jceOutputStream.write(j2, 1);
        }
    }
}
