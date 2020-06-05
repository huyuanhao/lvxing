package btmsdkobf;

import com.p522qq.taf.jce.JceInputStream;
import com.p522qq.taf.jce.JceOutputStream;
import com.p522qq.taf.jce.JceStruct;

/* renamed from: btmsdkobf.bv */
public final class C0633bv extends JceStruct {
    /* renamed from: fi */
    static C0631bt f346fi = new C0631bt();
    /* renamed from: fe */
    public C0631bt f347fe = null;
    /* renamed from: ff */
    public String f348ff;
    /* renamed from: fg */
    public String f349fg;
    /* renamed from: fh */
    public String f350fh;

    public C0633bv() {
        String str = "";
        this.f348ff = str;
        this.f349fg = str;
        this.f350fh = str;
    }

    public JceStruct newInit() {
        return new C0633bv();
    }

    public void readFrom(JceInputStream jceInputStream) {
        this.f347fe = (C0631bt) jceInputStream.read((JceStruct) f346fi, 0, true);
        this.f348ff = jceInputStream.readString(1, true);
        this.f349fg = jceInputStream.readString(2, false);
        this.f350fh = jceInputStream.readString(3, false);
    }

    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write((JceStruct) this.f347fe, 0);
        jceOutputStream.write(this.f348ff, 1);
        String str = this.f349fg;
        if (str != null) {
            jceOutputStream.write(str, 2);
        }
        String str2 = this.f350fh;
        if (str2 != null) {
            jceOutputStream.write(str2, 3);
        }
    }
}
