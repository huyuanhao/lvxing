package btmsdkobf;

import com.p522qq.taf.jce.JceInputStream;
import com.p522qq.taf.jce.JceOutputStream;
import com.p522qq.taf.jce.JceStruct;

/* renamed from: btmsdkobf.t */
public final class C0885t extends JceStruct {
    /* renamed from: an */
    static C0886u f1067an = new C0886u();
    /* renamed from: ao */
    static byte[] f1068ao = new byte[1];
    /* renamed from: ai */
    public short f1069ai = 0;
    /* renamed from: aj */
    public C0886u f1070aj = null;
    /* renamed from: ak */
    public int f1071ak = 0;
    /* renamed from: al */
    public int f1072al = 0;
    /* renamed from: am */
    public int f1073am = 0;
    public int coin_num = 0;
    public byte[] order_data = null;
    public String order_id = "";
    public int task_type = 0;

    static {
        f1068ao[0] = 0;
    }

    public void readFrom(JceInputStream jceInputStream) {
        this.order_id = jceInputStream.readString(0, false);
        this.task_type = jceInputStream.read(this.task_type, 1, false);
        this.f1069ai = jceInputStream.read(this.f1069ai, 2, false);
        this.coin_num = jceInputStream.read(this.coin_num, 3, false);
        this.f1070aj = (C0886u) jceInputStream.read((JceStruct) f1067an, 4, false);
        this.f1071ak = jceInputStream.read(this.f1071ak, 5, false);
        this.f1072al = jceInputStream.read(this.f1072al, 6, false);
        this.f1073am = jceInputStream.read(this.f1073am, 7, false);
        this.order_data = jceInputStream.read(f1068ao, 8, false);
    }

    public void writeTo(JceOutputStream jceOutputStream) {
        String str = this.order_id;
        if (str != null) {
            jceOutputStream.write(str, 0);
        }
        int i = this.task_type;
        if (i != 0) {
            jceOutputStream.write(i, 1);
        }
        short s = this.f1069ai;
        if (s != 0) {
            jceOutputStream.write(s, 2);
        }
        int i2 = this.coin_num;
        if (i2 != 0) {
            jceOutputStream.write(i2, 3);
        }
        C0886u uVar = this.f1070aj;
        if (uVar != null) {
            jceOutputStream.write((JceStruct) uVar, 4);
        }
        int i3 = this.f1071ak;
        if (i3 != 0) {
            jceOutputStream.write(i3, 5);
        }
        int i4 = this.f1072al;
        if (i4 != 0) {
            jceOutputStream.write(i4, 6);
        }
        int i5 = this.f1073am;
        if (i5 != 0) {
            jceOutputStream.write(i5, 7);
        }
        byte[] bArr = this.order_data;
        if (bArr != null) {
            jceOutputStream.write(bArr, 8);
        }
    }
}
