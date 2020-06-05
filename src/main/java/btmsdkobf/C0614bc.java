package btmsdkobf;

import com.p522qq.taf.jce.JceInputStream;
import com.p522qq.taf.jce.JceOutputStream;
import com.p522qq.taf.jce.JceStruct;

/* renamed from: btmsdkobf.bc */
public final class C0614bc extends JceStruct {
    /* renamed from: cu */
    public int f187cu = 0;
    /* renamed from: cv */
    public String f188cv;
    /* renamed from: cw */
    public int f189cw;
    /* renamed from: cx */
    public String f190cx;
    public String version;

    public C0614bc() {
        String str = "";
        this.f188cv = str;
        this.f189cw = 0;
        this.f190cx = str;
        this.version = str;
    }

    public void readFrom(JceInputStream jceInputStream) {
        this.f187cu = jceInputStream.read(this.f187cu, 0, true);
        this.f188cv = jceInputStream.readString(1, false);
        this.f189cw = jceInputStream.read(this.f189cw, 2, false);
        this.f190cx = jceInputStream.readString(3, false);
        this.version = jceInputStream.readString(4, false);
    }

    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.f187cu, 0);
        String str = this.f188cv;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
        int i = this.f189cw;
        if (i != 0) {
            jceOutputStream.write(i, 2);
        }
        String str2 = this.f190cx;
        if (str2 != null) {
            jceOutputStream.write(str2, 3);
        }
        String str3 = this.version;
        if (str3 != null) {
            jceOutputStream.write(str3, 4);
        }
    }
}
