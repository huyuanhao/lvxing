package btmsdkobf;

import androidx.core.app.NotificationCompat;
import com.p522qq.taf.jce.JceDisplayer;
import com.p522qq.taf.jce.JceInputStream;
import com.p522qq.taf.jce.JceOutputStream;
import com.p522qq.taf.jce.JceStruct;
import com.p522qq.taf.jce.JceUtil;

/* renamed from: btmsdkobf.aj */
public final class C0572aj extends JceStruct implements Cloneable {
    /* renamed from: az */
    static final /* synthetic */ boolean f96az = (!C0572aj.class.desiredAssertionStatus());
    /* renamed from: aG */
    public long f97aG = 0;
    /* renamed from: aX */
    public int f98aX;
    /* renamed from: aq */
    public String f99aq;
    /* renamed from: bo */
    public int f100bo = 0;
    /* renamed from: bp */
    public String f101bp;
    /* renamed from: bq */
    public String f102bq;
    public int status = 0;

    public C0572aj() {
        String str = "";
        this.f101bp = str;
        this.f98aX = 0;
        this.f99aq = str;
        this.f102bq = str;
    }

    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException unused) {
            if (f96az) {
                return null;
            }
            throw new AssertionError();
        }
    }

    public void display(StringBuilder sb, int i) {
        JceDisplayer jceDisplayer = new JceDisplayer(sb, i);
        jceDisplayer.display(this.f100bo, "mall_record_id");
        jceDisplayer.display(this.status, NotificationCompat.CATEGORY_STATUS);
        jceDisplayer.display(this.f97aG, "create_time");
        jceDisplayer.display(this.f101bp, "device_id");
        jceDisplayer.display(this.f98aX, "mid");
        jceDisplayer.display(this.f99aq, "account_id");
        jceDisplayer.display(this.f102bq, "exc_detail");
    }

    public void displaySimple(StringBuilder sb, int i) {
        JceDisplayer jceDisplayer = new JceDisplayer(sb, i);
        jceDisplayer.displaySimple(this.f100bo, true);
        jceDisplayer.displaySimple(this.status, true);
        jceDisplayer.displaySimple(this.f97aG, true);
        jceDisplayer.displaySimple(this.f101bp, true);
        jceDisplayer.displaySimple(this.f98aX, true);
        jceDisplayer.displaySimple(this.f99aq, true);
        jceDisplayer.displaySimple(this.f102bq, false);
    }

    public boolean equals(Object obj) {
        boolean z = false;
        if (obj == null) {
            return false;
        }
        C0572aj ajVar = (C0572aj) obj;
        if (JceUtil.equals(this.f100bo, ajVar.f100bo) && JceUtil.equals(this.status, ajVar.status) && JceUtil.equals(this.f97aG, ajVar.f97aG) && JceUtil.equals((Object) this.f101bp, (Object) ajVar.f101bp) && JceUtil.equals(this.f98aX, ajVar.f98aX) && JceUtil.equals((Object) this.f99aq, (Object) ajVar.f99aq) && JceUtil.equals((Object) this.f102bq, (Object) ajVar.f102bq)) {
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
        this.f100bo = jceInputStream.read(this.f100bo, 0, true);
        this.status = jceInputStream.read(this.status, 1, false);
        this.f97aG = jceInputStream.read(this.f97aG, 2, false);
        this.f101bp = jceInputStream.readString(3, false);
        this.f98aX = jceInputStream.read(this.f98aX, 4, false);
        this.f99aq = jceInputStream.readString(5, false);
        this.f102bq = jceInputStream.readString(6, false);
    }

    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.f100bo, 0);
        jceOutputStream.write(this.status, 1);
        jceOutputStream.write(this.f97aG, 2);
        String str = this.f101bp;
        if (str != null) {
            jceOutputStream.write(str, 3);
        }
        jceOutputStream.write(this.f98aX, 4);
        String str2 = this.f99aq;
        if (str2 != null) {
            jceOutputStream.write(str2, 5);
        }
        String str3 = this.f102bq;
        if (str3 != null) {
            jceOutputStream.write(str3, 6);
        }
    }
}
