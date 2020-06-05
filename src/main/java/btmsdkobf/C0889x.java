package btmsdkobf;

import androidx.core.app.NotificationCompat;
import com.p522qq.taf.jce.JceDisplayer;
import com.p522qq.taf.jce.JceInputStream;
import com.p522qq.taf.jce.JceOutputStream;
import com.p522qq.taf.jce.JceStruct;
import com.p522qq.taf.jce.JceUtil;

/* renamed from: btmsdkobf.x */
public final class C0889x extends JceStruct implements Cloneable {
    /* renamed from: az */
    static final /* synthetic */ boolean f1088az = (!C0889x.class.desiredAssertionStatus());
    /* renamed from: aA */
    public int f1089aA = 0;
    /* renamed from: aB */
    public String f1090aB;
    /* renamed from: aC */
    public String f1091aC;
    /* renamed from: aD */
    public String f1092aD;
    /* renamed from: aE */
    public String f1093aE;
    /* renamed from: aF */
    public int f1094aF;
    /* renamed from: aG */
    public long f1095aG;
    public int status;

    public C0889x() {
        String str = "";
        this.f1090aB = str;
        this.f1091aC = str;
        this.f1092aD = str;
        this.f1093aE = str;
        this.status = 0;
        this.f1094aF = 0;
        this.f1095aG = 0;
    }

    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException unused) {
            if (f1088az) {
                return null;
            }
            throw new AssertionError();
        }
    }

    public void display(StringBuilder sb, int i) {
        JceDisplayer jceDisplayer = new JceDisplayer(sb, i);
        jceDisplayer.display(this.f1089aA, "ac_id");
        jceDisplayer.display(this.f1090aB, "title");
        jceDisplayer.display(this.f1091aC, "icon");
        jceDisplayer.display(this.f1092aD, "image1");
        jceDisplayer.display(this.f1093aE, "link");
        jceDisplayer.display(this.status, NotificationCompat.CATEGORY_STATUS);
        jceDisplayer.display(this.f1094aF, "sort");
        jceDisplayer.display(this.f1095aG, "create_time");
    }

    public void displaySimple(StringBuilder sb, int i) {
        JceDisplayer jceDisplayer = new JceDisplayer(sb, i);
        jceDisplayer.displaySimple(this.f1089aA, true);
        jceDisplayer.displaySimple(this.f1090aB, true);
        jceDisplayer.displaySimple(this.f1091aC, true);
        jceDisplayer.displaySimple(this.f1092aD, true);
        jceDisplayer.displaySimple(this.f1093aE, true);
        jceDisplayer.displaySimple(this.status, true);
        jceDisplayer.displaySimple(this.f1094aF, true);
        jceDisplayer.displaySimple(this.f1095aG, false);
    }

    public boolean equals(Object obj) {
        boolean z = false;
        if (obj == null) {
            return false;
        }
        C0889x xVar = (C0889x) obj;
        if (JceUtil.equals(this.f1089aA, xVar.f1089aA) && JceUtil.equals((Object) this.f1090aB, (Object) xVar.f1090aB) && JceUtil.equals((Object) this.f1091aC, (Object) xVar.f1091aC) && JceUtil.equals((Object) this.f1092aD, (Object) xVar.f1092aD) && JceUtil.equals((Object) this.f1093aE, (Object) xVar.f1093aE) && JceUtil.equals(this.status, xVar.status) && JceUtil.equals(this.f1094aF, xVar.f1094aF) && JceUtil.equals(this.f1095aG, xVar.f1095aG)) {
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
        this.f1089aA = jceInputStream.read(this.f1089aA, 0, true);
        this.f1090aB = jceInputStream.readString(1, false);
        this.f1091aC = jceInputStream.readString(2, false);
        this.f1092aD = jceInputStream.readString(3, false);
        this.f1093aE = jceInputStream.readString(4, false);
        this.status = jceInputStream.read(this.status, 5, false);
        this.f1094aF = jceInputStream.read(this.f1094aF, 6, false);
        this.f1095aG = jceInputStream.read(this.f1095aG, 7, false);
    }

    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.f1089aA, 0);
        String str = this.f1090aB;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
        String str2 = this.f1091aC;
        if (str2 != null) {
            jceOutputStream.write(str2, 2);
        }
        String str3 = this.f1092aD;
        if (str3 != null) {
            jceOutputStream.write(str3, 3);
        }
        String str4 = this.f1093aE;
        if (str4 != null) {
            jceOutputStream.write(str4, 4);
        }
        jceOutputStream.write(this.status, 5);
        jceOutputStream.write(this.f1094aF, 6);
        jceOutputStream.write(this.f1095aG, 7);
    }
}
