package btmsdkobf;

import com.p522qq.taf.jce.JceInputStream;
import com.p522qq.taf.jce.JceOutputStream;
import com.p522qq.taf.jce.JceStruct;

/* renamed from: btmsdkobf.cf */
public final class C0646cf extends JceStruct {
    /* renamed from: fl */
    public long f380fl = 0;

    public JceStruct newInit() {
        return new C0646cf();
    }

    public void readFrom(JceInputStream jceInputStream) {
        this.f380fl = jceInputStream.read(this.f380fl, 0, false);
    }

    public void writeTo(JceOutputStream jceOutputStream) {
        long j = this.f380fl;
        if (j != 0) {
            jceOutputStream.write(j, 0);
        }
    }
}
