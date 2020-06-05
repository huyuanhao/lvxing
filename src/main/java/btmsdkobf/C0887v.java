package btmsdkobf;

import com.p522qq.taf.jce.JceInputStream;
import com.p522qq.taf.jce.JceOutputStream;
import com.p522qq.taf.jce.JceStruct;

/* renamed from: btmsdkobf.v */
public final class C0887v extends JceStruct {
    /* renamed from: au */
    static C0881p f1074au = new C0881p();
    /* renamed from: ap */
    public C0881p f1075ap = null;
    /* renamed from: aq */
    public String f1076aq;
    /* renamed from: ar */
    public String f1077ar;
    /* renamed from: as */
    public String f1078as;
    /* renamed from: at */
    public String f1079at;

    public C0887v() {
        String str = "";
        this.f1076aq = str;
        this.f1077ar = str;
        this.f1078as = str;
        this.f1079at = str;
    }

    public void readFrom(JceInputStream jceInputStream) {
        this.f1075ap = (C0881p) jceInputStream.read((JceStruct) f1074au, 0, false);
        this.f1076aq = jceInputStream.readString(1, false);
        this.f1077ar = jceInputStream.readString(2, false);
        this.f1078as = jceInputStream.readString(3, false);
        this.f1079at = jceInputStream.readString(4, false);
    }

    public void writeTo(JceOutputStream jceOutputStream) {
        C0881p pVar = this.f1075ap;
        if (pVar != null) {
            jceOutputStream.write((JceStruct) pVar, 0);
        }
        String str = this.f1076aq;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
        String str2 = this.f1077ar;
        if (str2 != null) {
            jceOutputStream.write(str2, 2);
        }
        String str3 = this.f1078as;
        if (str3 != null) {
            jceOutputStream.write(str3, 3);
        }
        String str4 = this.f1079at;
        if (str4 != null) {
            jceOutputStream.write(str4, 4);
        }
    }
}
