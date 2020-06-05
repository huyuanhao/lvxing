package btmsdkobf;

import com.p522qq.taf.jce.JceInputStream;
import com.p522qq.taf.jce.JceOutputStream;
import com.p522qq.taf.jce.JceStruct;

/* renamed from: btmsdkobf.bn */
public final class C0625bn extends JceStruct {
    /* renamed from: dr */
    static byte[] f241dr = new byte[1];
    /* renamed from: cn */
    public int f242cn = 0;
    /* renamed from: dn */
    public int f243dn = 0;
    /* renamed from: do */
    public byte[] f244do = null;
    /* renamed from: dp */
    public int f245dp = 0;
    /* renamed from: dq */
    public int f246dq = 0;
    public int version = 0;

    static {
        f241dr[0] = 0;
    }

    public JceStruct newInit() {
        return new C0625bn();
    }

    public void readFrom(JceInputStream jceInputStream) {
        this.f243dn = jceInputStream.read(this.f243dn, 0, true);
        this.f244do = jceInputStream.read(f241dr, 1, true);
        this.f242cn = jceInputStream.read(this.f242cn, 2, true);
        this.f245dp = jceInputStream.read(this.f245dp, 3, false);
        this.f246dq = jceInputStream.read(this.f246dq, 4, false);
        this.version = jceInputStream.read(this.version, 5, false);
    }

    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.f243dn, 0);
        jceOutputStream.write(this.f244do, 1);
        jceOutputStream.write(this.f242cn, 2);
        int i = this.f245dp;
        if (i != 0) {
            jceOutputStream.write(i, 3);
        }
        int i2 = this.f246dq;
        if (i2 != 0) {
            jceOutputStream.write(i2, 4);
        }
        int i3 = this.version;
        if (i3 != 0) {
            jceOutputStream.write(i3, 5);
        }
    }
}
