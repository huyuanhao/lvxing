package btmsdkobf;

import com.p522qq.taf.jce.JceInputStream;
import com.p522qq.taf.jce.JceOutputStream;
import com.p522qq.taf.jce.JceStruct;

/* renamed from: btmsdkobf.u */
public final class C0886u extends JceStruct {
    public String app;
    public String extra;
    public String icon_1;
    public String icon_2;
    public String icon_3;
    public String text_1;
    public String text_2;
    public String text_3;
    public int type_id = 0;
    public String url;

    public C0886u() {
        String str = "";
        this.text_1 = str;
        this.text_2 = str;
        this.text_3 = str;
        this.icon_1 = str;
        this.icon_2 = str;
        this.icon_3 = str;
        this.url = str;
        this.app = str;
        this.extra = str;
    }

    public void readFrom(JceInputStream jceInputStream) {
        this.type_id = jceInputStream.read(this.type_id, 0, false);
        this.text_1 = jceInputStream.readString(1, false);
        this.text_2 = jceInputStream.readString(2, false);
        this.text_3 = jceInputStream.readString(3, false);
        this.icon_1 = jceInputStream.readString(4, false);
        this.icon_2 = jceInputStream.readString(5, false);
        this.icon_3 = jceInputStream.readString(6, false);
        this.url = jceInputStream.readString(7, false);
        this.app = jceInputStream.readString(8, false);
        this.extra = jceInputStream.readString(9, false);
    }

    public void writeTo(JceOutputStream jceOutputStream) {
        int i = this.type_id;
        if (i != 0) {
            jceOutputStream.write(i, 0);
        }
        String str = this.text_1;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
        String str2 = this.text_2;
        if (str2 != null) {
            jceOutputStream.write(str2, 2);
        }
        String str3 = this.text_3;
        if (str3 != null) {
            jceOutputStream.write(str3, 3);
        }
        String str4 = this.icon_1;
        if (str4 != null) {
            jceOutputStream.write(str4, 4);
        }
        String str5 = this.icon_2;
        if (str5 != null) {
            jceOutputStream.write(str5, 5);
        }
        String str6 = this.icon_3;
        if (str6 != null) {
            jceOutputStream.write(str6, 6);
        }
        String str7 = this.url;
        if (str7 != null) {
            jceOutputStream.write(str7, 7);
        }
        String str8 = this.app;
        if (str8 != null) {
            jceOutputStream.write(str8, 8);
        }
        String str9 = this.extra;
        if (str9 != null) {
            jceOutputStream.write(str9, 9);
        }
    }
}
