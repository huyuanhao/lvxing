package btmsdkobf;

import com.p522qq.taf.jce.JceDisplayer;
import com.p522qq.taf.jce.JceInputStream;
import com.p522qq.taf.jce.JceOutputStream;
import com.p522qq.taf.jce.JceStruct;
import com.p522qq.taf.jce.JceUtil;

/* renamed from: btmsdkobf.ag */
public final class C0569ag extends JceStruct implements Cloneable {
    /* renamed from: az */
    static final /* synthetic */ boolean f82az = (!C0569ag.class.desiredAssertionStatus());
    /* renamed from: aX */
    public int f83aX = 0;
    /* renamed from: ae */
    public int f84ae = 0;
    /* renamed from: aq */
    public String f85aq;
    /* renamed from: as */
    public String f86as;
    /* renamed from: ay */
    public long f87ay = 0;

    public C0569ag() {
        String str = "";
        this.f85aq = str;
        this.f86as = str;
    }

    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException unused) {
            if (f82az) {
                return null;
            }
            throw new AssertionError();
        }
    }

    public void display(StringBuilder sb, int i) {
        JceDisplayer jceDisplayer = new JceDisplayer(sb, i);
        jceDisplayer.display(this.f84ae, "product_id");
        jceDisplayer.display(this.f83aX, "mid");
        jceDisplayer.display(this.f87ay, "ts");
        jceDisplayer.display(this.f85aq, "account_id");
        jceDisplayer.display(this.f86as, "guid");
    }

    public void displaySimple(StringBuilder sb, int i) {
        JceDisplayer jceDisplayer = new JceDisplayer(sb, i);
        jceDisplayer.displaySimple(this.f84ae, true);
        jceDisplayer.displaySimple(this.f83aX, true);
        jceDisplayer.displaySimple(this.f87ay, true);
        jceDisplayer.displaySimple(this.f85aq, true);
        jceDisplayer.displaySimple(this.f86as, false);
    }

    public boolean equals(Object obj) {
        boolean z = false;
        if (obj == null) {
            return false;
        }
        C0569ag agVar = (C0569ag) obj;
        if (JceUtil.equals(this.f84ae, agVar.f84ae) && JceUtil.equals(this.f83aX, agVar.f83aX) && JceUtil.equals(this.f87ay, agVar.f87ay) && JceUtil.equals((Object) this.f85aq, (Object) agVar.f85aq) && JceUtil.equals((Object) this.f86as, (Object) agVar.f86as)) {
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
        this.f84ae = jceInputStream.read(this.f84ae, 0, true);
        this.f83aX = jceInputStream.read(this.f83aX, 1, true);
        this.f87ay = jceInputStream.read(this.f87ay, 2, false);
        this.f85aq = jceInputStream.readString(3, false);
        this.f86as = jceInputStream.readString(4, false);
    }

    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.f84ae, 0);
        jceOutputStream.write(this.f83aX, 1);
        jceOutputStream.write(this.f87ay, 2);
        String str = this.f85aq;
        if (str != null) {
            jceOutputStream.write(str, 3);
        }
        String str2 = this.f86as;
        if (str2 != null) {
            jceOutputStream.write(str2, 4);
        }
    }
}
