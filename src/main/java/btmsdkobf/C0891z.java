package btmsdkobf;

import androidx.core.app.NotificationCompat;
import com.p522qq.taf.jce.JceDisplayer;
import com.p522qq.taf.jce.JceInputStream;
import com.p522qq.taf.jce.JceOutputStream;
import com.p522qq.taf.jce.JceStruct;
import com.p522qq.taf.jce.JceUtil;
import com.tencent.p605ep.common.adapt.iservice.account.AccountConst.ArgKey;

/* renamed from: btmsdkobf.z */
public final class C0891z extends JceStruct implements Cloneable {
    /* renamed from: az */
    static final /* synthetic */ boolean f1100az = (!C0891z.class.desiredAssertionStatus());
    /* renamed from: aE */
    public String f1101aE;
    /* renamed from: aF */
    public int f1102aF;
    /* renamed from: aG */
    public long f1103aG;
    /* renamed from: aJ */
    public int f1104aJ = 0;
    /* renamed from: aK */
    public String f1105aK;
    /* renamed from: aL */
    public String f1106aL;
    /* renamed from: aM */
    public String f1107aM;
    public int status;

    public C0891z() {
        String str = "";
        this.f1105aK = str;
        this.status = 0;
        this.f1106aL = str;
        this.f1101aE = str;
        this.f1107aM = str;
        this.f1102aF = 0;
        this.f1103aG = 0;
    }

    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException unused) {
            if (f1100az) {
                return null;
            }
            throw new AssertionError();
        }
    }

    public void display(StringBuilder sb, int i) {
        JceDisplayer jceDisplayer = new JceDisplayer(sb, i);
        jceDisplayer.display(this.f1104aJ, "banner_id");
        jceDisplayer.display(this.f1105aK, "text");
        jceDisplayer.display(this.status, NotificationCompat.CATEGORY_STATUS);
        jceDisplayer.display(this.f1106aL, ArgKey.KEY_DESC);
        jceDisplayer.display(this.f1101aE, "link");
        jceDisplayer.display(this.f1107aM, "image");
        jceDisplayer.display(this.f1102aF, "sort");
        jceDisplayer.display(this.f1103aG, "create_time");
    }

    public void displaySimple(StringBuilder sb, int i) {
        JceDisplayer jceDisplayer = new JceDisplayer(sb, i);
        jceDisplayer.displaySimple(this.f1104aJ, true);
        jceDisplayer.displaySimple(this.f1105aK, true);
        jceDisplayer.displaySimple(this.status, true);
        jceDisplayer.displaySimple(this.f1106aL, true);
        jceDisplayer.displaySimple(this.f1101aE, true);
        jceDisplayer.displaySimple(this.f1107aM, true);
        jceDisplayer.displaySimple(this.f1102aF, true);
        jceDisplayer.displaySimple(this.f1103aG, false);
    }

    public boolean equals(Object obj) {
        boolean z = false;
        if (obj == null) {
            return false;
        }
        C0891z zVar = (C0891z) obj;
        if (JceUtil.equals(this.f1104aJ, zVar.f1104aJ) && JceUtil.equals((Object) this.f1105aK, (Object) zVar.f1105aK) && JceUtil.equals(this.status, zVar.status) && JceUtil.equals((Object) this.f1106aL, (Object) zVar.f1106aL) && JceUtil.equals((Object) this.f1101aE, (Object) zVar.f1101aE) && JceUtil.equals((Object) this.f1107aM, (Object) zVar.f1107aM) && JceUtil.equals(this.f1102aF, zVar.f1102aF) && JceUtil.equals(this.f1103aG, zVar.f1103aG)) {
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
        this.f1104aJ = jceInputStream.read(this.f1104aJ, 0, true);
        this.f1105aK = jceInputStream.readString(1, false);
        this.status = jceInputStream.read(this.status, 2, false);
        this.f1106aL = jceInputStream.readString(3, false);
        this.f1101aE = jceInputStream.readString(4, false);
        this.f1107aM = jceInputStream.readString(5, false);
        this.f1102aF = jceInputStream.read(this.f1102aF, 6, false);
        this.f1103aG = jceInputStream.read(this.f1103aG, 7, false);
    }

    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.f1104aJ, 0);
        String str = this.f1105aK;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
        jceOutputStream.write(this.status, 2);
        String str2 = this.f1106aL;
        if (str2 != null) {
            jceOutputStream.write(str2, 3);
        }
        String str3 = this.f1101aE;
        if (str3 != null) {
            jceOutputStream.write(str3, 4);
        }
        String str4 = this.f1107aM;
        if (str4 != null) {
            jceOutputStream.write(str4, 5);
        }
        jceOutputStream.write(this.f1102aF, 6);
        jceOutputStream.write(this.f1103aG, 7);
    }
}
