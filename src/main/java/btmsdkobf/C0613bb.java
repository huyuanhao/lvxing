package btmsdkobf;

import com.p522qq.taf.jce.JceInputStream;
import com.p522qq.taf.jce.JceOutputStream;
import com.p522qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* renamed from: btmsdkobf.bb */
public final class C0613bb extends JceStruct {
    /* renamed from: cs */
    static ArrayList<Integer> f179cs;
    /* renamed from: ct */
    static ArrayList<String> f180ct;
    /* renamed from: cm */
    public int f181cm = 0;
    /* renamed from: cn */
    public int f182cn = 0;
    /* renamed from: co */
    public ArrayList<Integer> f183co = null;
    public int count = 1;
    /* renamed from: cp */
    public ArrayList<String> f184cp = null;
    /* renamed from: cq */
    public int f185cq = 0;
    /* renamed from: cr */
    public int f186cr = 0;

    public void readFrom(JceInputStream jceInputStream) {
        this.f181cm = jceInputStream.read(this.f181cm, 0, true);
        this.f182cn = jceInputStream.read(this.f182cn, 1, true);
        this.count = jceInputStream.read(this.count, 2, false);
        if (f179cs == null) {
            f179cs = new ArrayList<>();
            f179cs.add(Integer.valueOf(0));
        }
        this.f183co = (ArrayList) jceInputStream.read(f179cs, 3, false);
        if (f180ct == null) {
            f180ct = new ArrayList<>();
            f180ct.add("");
        }
        this.f184cp = (ArrayList) jceInputStream.read(f180ct, 4, false);
        this.f185cq = jceInputStream.read(this.f185cq, 5, false);
        this.f186cr = jceInputStream.read(this.f186cr, 6, false);
    }

    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.f181cm, 0);
        jceOutputStream.write(this.f182cn, 1);
        int i = this.count;
        if (i != 1) {
            jceOutputStream.write(i, 2);
        }
        ArrayList<Integer> arrayList = this.f183co;
        if (arrayList != null) {
            jceOutputStream.write((Collection<T>) arrayList, 3);
        }
        ArrayList<String> arrayList2 = this.f184cp;
        if (arrayList2 != null) {
            jceOutputStream.write((Collection<T>) arrayList2, 4);
        }
        int i2 = this.f185cq;
        if (i2 != 0) {
            jceOutputStream.write(i2, 5);
        }
        int i3 = this.f186cr;
        if (i3 != 0) {
            jceOutputStream.write(i3, 6);
        }
    }
}
