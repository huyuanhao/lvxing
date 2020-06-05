package btmsdkobf;

import com.p522qq.taf.jce.JceInputStream;
import com.p522qq.taf.jce.JceOutputStream;
import com.p522qq.taf.jce.JceStruct;

/* renamed from: btmsdkobf.bw */
public final class C0634bw extends JceStruct {
    /* renamed from: fd */
    public String f351fd;
    /* renamed from: fj */
    public int f352fj = 0;
    /* renamed from: fk */
    public String f353fk;

    public C0634bw() {
        String str = "";
        this.f353fk = str;
        this.f351fd = str;
    }

    public JceStruct newInit() {
        return new C0634bw();
    }

    public void readFrom(JceInputStream jceInputStream) {
        this.f352fj = jceInputStream.read(this.f352fj, 0, true);
        this.f353fk = jceInputStream.readString(1, false);
        this.f351fd = jceInputStream.readString(2, false);
    }

    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.f352fj, 0);
        String str = this.f353fk;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
        String str2 = this.f351fd;
        if (str2 != null) {
            jceOutputStream.write(str2, 2);
        }
    }
}
