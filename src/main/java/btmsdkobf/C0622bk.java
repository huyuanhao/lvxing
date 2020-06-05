package btmsdkobf;

import com.p522qq.taf.jce.JceInputStream;
import com.p522qq.taf.jce.JceOutputStream;
import com.p522qq.taf.jce.JceStruct;

/* renamed from: btmsdkobf.bk */
public final class C0622bk extends JceStruct {
    /* renamed from: de */
    public int f231de = 0;
    /* renamed from: df */
    public boolean f232df = true;
    /* renamed from: dg */
    public int f233dg = 0;
    /* renamed from: dh */
    public int f234dh = 0;

    public void readFrom(JceInputStream jceInputStream) {
        this.f231de = jceInputStream.read(this.f231de, 0, true);
        this.f232df = jceInputStream.read(this.f232df, 1, true);
        this.f233dg = jceInputStream.read(this.f233dg, 2, false);
        this.f234dh = jceInputStream.read(this.f234dh, 3, false);
    }

    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.f231de, 0);
        jceOutputStream.write(this.f232df, 1);
        int i = this.f233dg;
        if (i != 0) {
            jceOutputStream.write(i, 2);
        }
        int i2 = this.f234dh;
        if (i2 != 0) {
            jceOutputStream.write(i2, 3);
        }
    }
}
