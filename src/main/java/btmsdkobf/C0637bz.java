package btmsdkobf;

import com.p522qq.taf.jce.JceInputStream;
import com.p522qq.taf.jce.JceOutputStream;
import com.p522qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* renamed from: btmsdkobf.bz */
public final class C0637bz extends JceStruct {
    /* renamed from: fA */
    static ArrayList<C0636by> f366fA = new ArrayList<>();
    /* renamed from: fz */
    static C0621bj f367fz = new C0621bj();
    /* renamed from: fm */
    public int f368fm = 0;
    /* renamed from: fn */
    public int f369fn = 0;
    /* renamed from: fw */
    public int f370fw = 1;
    /* renamed from: fx */
    public C0621bj f371fx = null;
    /* renamed from: fy */
    public ArrayList<C0636by> f372fy = null;

    static {
        f366fA.add(new C0636by());
    }

    public JceStruct newInit() {
        return new C0637bz();
    }

    public void readFrom(JceInputStream jceInputStream) {
        this.f368fm = jceInputStream.read(this.f368fm, 0, false);
        this.f369fn = jceInputStream.read(this.f369fn, 1, false);
        this.f370fw = jceInputStream.read(this.f370fw, 2, false);
        this.f371fx = (C0621bj) jceInputStream.read((JceStruct) f367fz, 3, false);
        this.f372fy = (ArrayList) jceInputStream.read(f366fA, 4, false);
    }

    public void writeTo(JceOutputStream jceOutputStream) {
        int i = this.f368fm;
        if (i != 0) {
            jceOutputStream.write(i, 0);
        }
        int i2 = this.f369fn;
        if (i2 != 0) {
            jceOutputStream.write(i2, 1);
        }
        int i3 = this.f370fw;
        if (i3 != 1) {
            jceOutputStream.write(i3, 2);
        }
        C0621bj bjVar = this.f371fx;
        if (bjVar != null) {
            jceOutputStream.write((JceStruct) bjVar, 3);
        }
        ArrayList<C0636by> arrayList = this.f372fy;
        if (arrayList != null) {
            jceOutputStream.write((Collection<T>) arrayList, 4);
        }
    }
}
