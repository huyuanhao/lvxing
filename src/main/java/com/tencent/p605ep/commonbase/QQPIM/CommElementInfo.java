package com.tencent.p605ep.commonbase.QQPIM;

import com.p522qq.taf.jce.JceDisplayer;
import com.p522qq.taf.jce.JceInputStream;
import com.p522qq.taf.jce.JceOutputStream;
import com.p522qq.taf.jce.JceStruct;
import com.p522qq.taf.jce.JceUtil;

/* renamed from: com.tencent.ep.commonbase.QQPIM.CommElementInfo */
public final class CommElementInfo extends JceStruct implements Cloneable {
    static final /* synthetic */ boolean $assertionsDisabled = (!CommElementInfo.class.desiredAssertionStatus());
    public String data1;
    public String data2;
    public String data3;
    public String data4;
    public String data5;
    public String data6;
    public String data7;
    public String data8;

    public CommElementInfo() {
        String str = "";
        this.data1 = str;
        this.data2 = str;
        this.data3 = str;
        this.data4 = str;
        this.data5 = str;
        this.data6 = str;
        this.data7 = str;
        this.data8 = str;
    }

    public CommElementInfo(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
        String str9 = "";
        this.data1 = str9;
        this.data2 = str9;
        this.data3 = str9;
        this.data4 = str9;
        this.data5 = str9;
        this.data6 = str9;
        this.data7 = str9;
        this.data8 = str9;
        this.data1 = str;
        this.data2 = str2;
        this.data3 = str3;
        this.data4 = str4;
        this.data5 = str5;
        this.data6 = str6;
        this.data7 = str7;
        this.data8 = str8;
    }

    public String className() {
        return "CommElementInfo";
    }

    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException unused) {
            if ($assertionsDisabled) {
                return null;
            }
            throw new AssertionError();
        }
    }

    public void display(StringBuilder sb, int i) {
        JceDisplayer jceDisplayer = new JceDisplayer(sb, i);
        jceDisplayer.display(this.data1, "data1");
        jceDisplayer.display(this.data2, "data2");
        jceDisplayer.display(this.data3, "data3");
        jceDisplayer.display(this.data4, "data4");
        jceDisplayer.display(this.data5, "data5");
        jceDisplayer.display(this.data6, "data6");
        jceDisplayer.display(this.data7, "data7");
        jceDisplayer.display(this.data8, "data8");
    }

    public boolean equals(Object obj) {
        boolean z = false;
        if (obj == null) {
            return false;
        }
        CommElementInfo commElementInfo = (CommElementInfo) obj;
        if (JceUtil.equals((Object) this.data1, (Object) commElementInfo.data1) && JceUtil.equals((Object) this.data2, (Object) commElementInfo.data2) && JceUtil.equals((Object) this.data3, (Object) commElementInfo.data3) && JceUtil.equals((Object) this.data4, (Object) commElementInfo.data4) && JceUtil.equals((Object) this.data5, (Object) commElementInfo.data5) && JceUtil.equals((Object) this.data6, (Object) commElementInfo.data6) && JceUtil.equals((Object) this.data7, (Object) commElementInfo.data7) && JceUtil.equals((Object) this.data8, (Object) commElementInfo.data8)) {
            z = true;
        }
        return z;
    }

    public String fullClassName() {
        return "CommElementInfo";
    }

    public String getData1() {
        return this.data1;
    }

    public String getData2() {
        return this.data2;
    }

    public String getData3() {
        return this.data3;
    }

    public String getData4() {
        return this.data4;
    }

    public String getData5() {
        return this.data5;
    }

    public String getData6() {
        return this.data6;
    }

    public String getData7() {
        return this.data7;
    }

    public String getData8() {
        return this.data8;
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
        this.data1 = jceInputStream.readString(0, false);
        this.data2 = jceInputStream.readString(1, false);
        this.data3 = jceInputStream.readString(3, false);
        this.data4 = jceInputStream.readString(4, false);
        this.data5 = jceInputStream.readString(5, false);
        this.data6 = jceInputStream.readString(6, false);
        this.data7 = jceInputStream.readString(7, false);
        this.data8 = jceInputStream.readString(8, false);
    }

    public void setData1(String str) {
        this.data1 = str;
    }

    public void setData2(String str) {
        this.data2 = str;
    }

    public void setData3(String str) {
        this.data3 = str;
    }

    public void setData4(String str) {
        this.data4 = str;
    }

    public void setData5(String str) {
        this.data5 = str;
    }

    public void setData6(String str) {
        this.data6 = str;
    }

    public void setData7(String str) {
        this.data7 = str;
    }

    public void setData8(String str) {
        this.data8 = str;
    }

    public void writeTo(JceOutputStream jceOutputStream) {
        String str = this.data1;
        if (str != null) {
            jceOutputStream.write(str, 0);
        }
        String str2 = this.data2;
        if (str2 != null) {
            jceOutputStream.write(str2, 1);
        }
        String str3 = this.data3;
        if (str3 != null) {
            jceOutputStream.write(str3, 3);
        }
        String str4 = this.data4;
        if (str4 != null) {
            jceOutputStream.write(str4, 4);
        }
        String str5 = this.data5;
        if (str5 != null) {
            jceOutputStream.write(str5, 5);
        }
        String str6 = this.data6;
        if (str6 != null) {
            jceOutputStream.write(str6, 6);
        }
        String str7 = this.data7;
        if (str7 != null) {
            jceOutputStream.write(str7, 7);
        }
        String str8 = this.data8;
        if (str8 != null) {
            jceOutputStream.write(str8, 8);
        }
    }
}
