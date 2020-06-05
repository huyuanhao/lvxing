package btmsdkobf;

import androidx.core.app.NotificationCompat;
import com.p522qq.taf.jce.JceDisplayer;
import com.p522qq.taf.jce.JceInputStream;
import com.p522qq.taf.jce.JceOutputStream;
import com.p522qq.taf.jce.JceStruct;
import com.p522qq.taf.jce.JceUtil;
import com.tencent.p605ep.common.adapt.iservice.account.AccountConst.ArgKey;

/* renamed from: btmsdkobf.af */
public final class C0568af extends JceStruct implements Cloneable {
    /* renamed from: az */
    static final /* synthetic */ boolean f65az = (!C0568af.class.desiredAssertionStatus());
    /* renamed from: aC */
    public String f66aC;
    /* renamed from: aD */
    public String f67aD;
    /* renamed from: aF */
    public int f68aF;
    /* renamed from: aX */
    public int f69aX = 0;
    /* renamed from: aY */
    public String f70aY;
    /* renamed from: aZ */
    public String f71aZ;
    /* renamed from: ba */
    public String f72ba;
    /* renamed from: bb */
    public String f73bb;
    /* renamed from: bc */
    public String f74bc;
    /* renamed from: bd */
    public int f75bd;
    /* renamed from: be */
    public String f76be;
    /* renamed from: bf */
    public String f77bf;
    /* renamed from: bg */
    public String f78bg;
    /* renamed from: bh */
    public int f79bh;
    /* renamed from: bi */
    public int f80bi;
    /* renamed from: bj */
    public int f81bj;
    public String name;
    public int status;
    public String value;

    public C0568af() {
        String str = "";
        this.name = str;
        this.value = str;
        this.f66aC = str;
        this.f70aY = str;
        this.f71aZ = str;
        this.f72ba = str;
        this.f68aF = 0;
        this.f73bb = str;
        this.f67aD = str;
        this.f74bc = str;
        this.status = 0;
        this.f75bd = 0;
        this.f76be = str;
        this.f77bf = str;
        this.f78bg = str;
        this.f79bh = 0;
        this.f80bi = 0;
        this.f81bj = 0;
    }

    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException unused) {
            if (f65az) {
                return null;
            }
            throw new AssertionError();
        }
    }

    public void display(StringBuilder sb, int i) {
        JceDisplayer jceDisplayer = new JceDisplayer(sb, i);
        jceDisplayer.display(this.f69aX, "mid");
        jceDisplayer.display(this.name, ArgKey.KEY_NAME);
        jceDisplayer.display(this.value, ArgKey.KEY_VALUE);
        jceDisplayer.display(this.f66aC, "icon");
        jceDisplayer.display(this.f70aY, "cover_img");
        jceDisplayer.display(this.f71aZ, "short_dec");
        jceDisplayer.display(this.f72ba, "long_desc");
        jceDisplayer.display(this.f68aF, "sort");
        jceDisplayer.display(this.f73bb, "home_hide");
        jceDisplayer.display(this.f67aD, "image1");
        jceDisplayer.display(this.f74bc, "image2");
        jceDisplayer.display(this.status, NotificationCompat.CATEGORY_STATUS);
        jceDisplayer.display(this.f75bd, "rule");
        jceDisplayer.display(this.f76be, "point_cost");
        jceDisplayer.display(this.f77bf, "start_time");
        jceDisplayer.display(this.f78bg, "end_time");
        jceDisplayer.display(this.f79bh, "classify_id");
        jceDisplayer.display(this.f80bi, "section_id");
        jceDisplayer.display(this.f81bj, "award_delay");
    }

    public void displaySimple(StringBuilder sb, int i) {
        JceDisplayer jceDisplayer = new JceDisplayer(sb, i);
        jceDisplayer.displaySimple(this.f69aX, true);
        jceDisplayer.displaySimple(this.name, true);
        jceDisplayer.displaySimple(this.value, true);
        jceDisplayer.displaySimple(this.f66aC, true);
        jceDisplayer.displaySimple(this.f70aY, true);
        jceDisplayer.displaySimple(this.f71aZ, true);
        jceDisplayer.displaySimple(this.f72ba, true);
        jceDisplayer.displaySimple(this.f68aF, true);
        jceDisplayer.displaySimple(this.f73bb, true);
        jceDisplayer.displaySimple(this.f67aD, true);
        jceDisplayer.displaySimple(this.f74bc, true);
        jceDisplayer.displaySimple(this.status, true);
        jceDisplayer.displaySimple(this.f75bd, true);
        jceDisplayer.displaySimple(this.f76be, true);
        jceDisplayer.displaySimple(this.f77bf, true);
        jceDisplayer.displaySimple(this.f78bg, true);
        jceDisplayer.displaySimple(this.f79bh, true);
        jceDisplayer.displaySimple(this.f80bi, true);
        jceDisplayer.displaySimple(this.f81bj, false);
    }

    public boolean equals(Object obj) {
        boolean z = false;
        if (obj == null) {
            return false;
        }
        C0568af afVar = (C0568af) obj;
        if (JceUtil.equals(this.f69aX, afVar.f69aX) && JceUtil.equals((Object) this.name, (Object) afVar.name) && JceUtil.equals((Object) this.value, (Object) afVar.value) && JceUtil.equals((Object) this.f66aC, (Object) afVar.f66aC) && JceUtil.equals((Object) this.f70aY, (Object) afVar.f70aY) && JceUtil.equals((Object) this.f71aZ, (Object) afVar.f71aZ) && JceUtil.equals((Object) this.f72ba, (Object) afVar.f72ba) && JceUtil.equals(this.f68aF, afVar.f68aF) && JceUtil.equals((Object) this.f73bb, (Object) afVar.f73bb) && JceUtil.equals((Object) this.f67aD, (Object) afVar.f67aD) && JceUtil.equals((Object) this.f74bc, (Object) afVar.f74bc) && JceUtil.equals(this.status, afVar.status) && JceUtil.equals(this.f75bd, afVar.f75bd) && JceUtil.equals((Object) this.f76be, (Object) afVar.f76be) && JceUtil.equals((Object) this.f77bf, (Object) afVar.f77bf) && JceUtil.equals((Object) this.f78bg, (Object) afVar.f78bg) && JceUtil.equals(this.f79bh, afVar.f79bh) && JceUtil.equals(this.f80bi, afVar.f80bi) && JceUtil.equals(this.f81bj, afVar.f81bj)) {
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
        this.f69aX = jceInputStream.read(this.f69aX, 0, true);
        this.name = jceInputStream.readString(1, false);
        this.value = jceInputStream.readString(2, false);
        this.f66aC = jceInputStream.readString(3, false);
        this.f70aY = jceInputStream.readString(4, false);
        this.f71aZ = jceInputStream.readString(5, false);
        this.f72ba = jceInputStream.readString(6, false);
        this.f68aF = jceInputStream.read(this.f68aF, 7, false);
        this.f73bb = jceInputStream.readString(8, false);
        this.f67aD = jceInputStream.readString(9, false);
        this.f74bc = jceInputStream.readString(10, false);
        this.status = jceInputStream.read(this.status, 11, false);
        this.f75bd = jceInputStream.read(this.f75bd, 12, false);
        this.f76be = jceInputStream.readString(13, false);
        this.f77bf = jceInputStream.readString(14, false);
        this.f78bg = jceInputStream.readString(15, false);
        this.f79bh = jceInputStream.read(this.f79bh, 16, false);
        this.f80bi = jceInputStream.read(this.f80bi, 17, false);
        this.f81bj = jceInputStream.read(this.f81bj, 18, false);
    }

    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.f69aX, 0);
        String str = this.name;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
        String str2 = this.value;
        if (str2 != null) {
            jceOutputStream.write(str2, 2);
        }
        String str3 = this.f66aC;
        if (str3 != null) {
            jceOutputStream.write(str3, 3);
        }
        String str4 = this.f70aY;
        if (str4 != null) {
            jceOutputStream.write(str4, 4);
        }
        String str5 = this.f71aZ;
        if (str5 != null) {
            jceOutputStream.write(str5, 5);
        }
        String str6 = this.f72ba;
        if (str6 != null) {
            jceOutputStream.write(str6, 6);
        }
        jceOutputStream.write(this.f68aF, 7);
        String str7 = this.f73bb;
        if (str7 != null) {
            jceOutputStream.write(str7, 8);
        }
        String str8 = this.f67aD;
        if (str8 != null) {
            jceOutputStream.write(str8, 9);
        }
        String str9 = this.f74bc;
        if (str9 != null) {
            jceOutputStream.write(str9, 10);
        }
        jceOutputStream.write(this.status, 11);
        jceOutputStream.write(this.f75bd, 12);
        String str10 = this.f76be;
        if (str10 != null) {
            jceOutputStream.write(str10, 13);
        }
        String str11 = this.f77bf;
        if (str11 != null) {
            jceOutputStream.write(str11, 14);
        }
        String str12 = this.f78bg;
        if (str12 != null) {
            jceOutputStream.write(str12, 15);
        }
        jceOutputStream.write(this.f79bh, 16);
        jceOutputStream.write(this.f80bi, 17);
        jceOutputStream.write(this.f81bj, 18);
    }
}
