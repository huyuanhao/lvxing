package btmsdkobf;

import com.p522qq.taf.jce.JceDisplayer;
import com.p522qq.taf.jce.JceInputStream;
import com.p522qq.taf.jce.JceOutputStream;
import com.p522qq.taf.jce.JceStruct;
import com.p522qq.taf.jce.JceUtil;

/* renamed from: btmsdkobf.ci */
public final class C0649ci extends JceStruct implements Cloneable {
    /* renamed from: az */
    static final /* synthetic */ boolean f395az = (!C0649ci.class.desiredAssertionStatus());
    /* renamed from: fH */
    public String f396fH;
    /* renamed from: fI */
    public String f397fI;
    /* renamed from: fJ */
    public String f398fJ;
    /* renamed from: fK */
    public String f399fK;
    /* renamed from: fL */
    public String f400fL;
    /* renamed from: fM */
    public String f401fM;
    /* renamed from: fN */
    public String f402fN;
    /* renamed from: fO */
    public String f403fO;

    public C0649ci() {
        String str = "";
        this.f396fH = str;
        this.f397fI = str;
        this.f398fJ = str;
        this.f399fK = str;
        this.f400fL = str;
        this.f401fM = str;
        this.f402fN = str;
        this.f403fO = str;
    }

    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException unused) {
            if (f395az) {
                return null;
            }
            throw new AssertionError();
        }
    }

    public void display(StringBuilder sb, int i) {
        JceDisplayer jceDisplayer = new JceDisplayer(sb, i);
        jceDisplayer.display(this.f396fH, "data1");
        jceDisplayer.display(this.f397fI, "data2");
        jceDisplayer.display(this.f398fJ, "data3");
        jceDisplayer.display(this.f399fK, "data4");
        jceDisplayer.display(this.f400fL, "data5");
        jceDisplayer.display(this.f401fM, "data6");
        jceDisplayer.display(this.f402fN, "data7");
        jceDisplayer.display(this.f403fO, "data8");
    }

    public boolean equals(Object obj) {
        boolean z = false;
        if (obj == null) {
            return false;
        }
        C0649ci ciVar = (C0649ci) obj;
        if (JceUtil.equals((Object) this.f396fH, (Object) ciVar.f396fH) && JceUtil.equals((Object) this.f397fI, (Object) ciVar.f397fI) && JceUtil.equals((Object) this.f398fJ, (Object) ciVar.f398fJ) && JceUtil.equals((Object) this.f399fK, (Object) ciVar.f399fK) && JceUtil.equals((Object) this.f400fL, (Object) ciVar.f400fL) && JceUtil.equals((Object) this.f401fM, (Object) ciVar.f401fM) && JceUtil.equals((Object) this.f402fN, (Object) ciVar.f402fN) && JceUtil.equals((Object) this.f403fO, (Object) ciVar.f403fO)) {
            z = true;
        }
        return z;
    }

    public int hashCode() {
        try {
            throw new Exception("Need define key first!");
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public void readFrom(JceInputStream jceInputStream) {
        this.f396fH = jceInputStream.readString(0, false);
        this.f397fI = jceInputStream.readString(1, false);
        this.f398fJ = jceInputStream.readString(3, false);
        this.f399fK = jceInputStream.readString(4, false);
        this.f400fL = jceInputStream.readString(5, false);
        this.f401fM = jceInputStream.readString(6, false);
        this.f402fN = jceInputStream.readString(7, false);
        this.f403fO = jceInputStream.readString(8, false);
    }

    public void writeTo(JceOutputStream jceOutputStream) {
        String str = this.f396fH;
        if (str != null) {
            jceOutputStream.write(str, 0);
        }
        String str2 = this.f397fI;
        if (str2 != null) {
            jceOutputStream.write(str2, 1);
        }
        String str3 = this.f398fJ;
        if (str3 != null) {
            jceOutputStream.write(str3, 3);
        }
        String str4 = this.f399fK;
        if (str4 != null) {
            jceOutputStream.write(str4, 4);
        }
        String str5 = this.f400fL;
        if (str5 != null) {
            jceOutputStream.write(str5, 5);
        }
        String str6 = this.f401fM;
        if (str6 != null) {
            jceOutputStream.write(str6, 6);
        }
        String str7 = this.f402fN;
        if (str7 != null) {
            jceOutputStream.write(str7, 7);
        }
        String str8 = this.f403fO;
        if (str8 != null) {
            jceOutputStream.write(str8, 8);
        }
    }
}
