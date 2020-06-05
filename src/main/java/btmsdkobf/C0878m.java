package btmsdkobf;

import com.p522qq.taf.jce.JceInputStream;
import com.p522qq.taf.jce.JceOutputStream;
import com.p522qq.taf.jce.JceStruct;

/* renamed from: btmsdkobf.m */
public final class C0878m extends JceStruct {
    /* renamed from: W */
    public int f1046W = 0;
    public int coin_num = 0;
    public String order_id = "";

    public JceStruct newInit() {
        return new C0878m();
    }

    public void readFrom(JceInputStream jceInputStream) {
        this.order_id = jceInputStream.readString(0, false);
        this.f1046W = jceInputStream.read(this.f1046W, 1, false);
        this.coin_num = jceInputStream.read(this.coin_num, 2, false);
    }

    public void writeTo(JceOutputStream jceOutputStream) {
        String str = this.order_id;
        if (str != null) {
            jceOutputStream.write(str, 0);
        }
        int i = this.f1046W;
        if (i != 0) {
            jceOutputStream.write(i, 1);
        }
        int i2 = this.coin_num;
        if (i2 != 0) {
            jceOutputStream.write(i2, 2);
        }
    }
}
