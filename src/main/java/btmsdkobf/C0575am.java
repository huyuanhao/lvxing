package btmsdkobf;

import com.p522qq.taf.jce.JceInputStream;
import com.p522qq.taf.jce.JceOutputStream;
import com.p522qq.taf.jce.JceStruct;

/* renamed from: btmsdkobf.am */
public final class C0575am extends JceStruct {
    /* renamed from: ae */
    public int f112ae = 0;
    /* renamed from: aq */
    public String f113aq;
    /* renamed from: as */
    public String f114as;
    /* renamed from: at */
    public String f115at;
    /* renamed from: bu */
    public long f116bu;

    public C0575am() {
        String str = "";
        this.f113aq = str;
        this.f116bu = 0;
        this.f114as = str;
        this.f115at = str;
    }

    public JceStruct newInit() {
        return new C0575am();
    }

    public void readFrom(JceInputStream jceInputStream) {
        this.f112ae = jceInputStream.read(this.f112ae, 0, true);
        this.f113aq = jceInputStream.readString(1, false);
        this.f116bu = jceInputStream.read(this.f116bu, 2, false);
        this.f114as = jceInputStream.readString(3, false);
        this.f115at = jceInputStream.readString(4, false);
    }

    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.f112ae, 0);
        String str = this.f113aq;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
        long j = this.f116bu;
        if (j != 0) {
            jceOutputStream.write(j, 2);
        }
        String str2 = this.f114as;
        if (str2 != null) {
            jceOutputStream.write(str2, 3);
        }
        String str3 = this.f115at;
        if (str3 != null) {
            jceOutputStream.write(str3, 4);
        }
    }
}
