package btmsdkobf;

import com.p522qq.taf.jce.JceInputStream;
import com.p522qq.taf.jce.JceOutputStream;
import com.p522qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* renamed from: btmsdkobf.bi */
public final class C0620bi extends JceStruct {
    /* renamed from: cA */
    static C0617bf f208cA = new C0617bf();
    /* renamed from: cV */
    static ArrayList<Integer> f209cV = new ArrayList<>();
    /* renamed from: cW */
    static ArrayList<C0618bg> f210cW = new ArrayList<>();
    /* renamed from: cN */
    public int f211cN = 0;
    /* renamed from: cO */
    public ArrayList<Integer> f212cO = null;
    /* renamed from: cP */
    public ArrayList<C0618bg> f213cP = null;
    /* renamed from: cQ */
    public int f214cQ = 0;
    /* renamed from: cR */
    public boolean f215cR = true;
    /* renamed from: cS */
    public boolean f216cS = true;
    /* renamed from: cT */
    public int f217cT = 120;
    /* renamed from: cU */
    public int f218cU = 10;
    /* renamed from: cy */
    public int f219cy = 0;
    /* renamed from: cz */
    public C0617bf f220cz = null;

    static {
        f209cV.add(Integer.valueOf(0));
        f210cW.add(new C0618bg());
    }

    public JceStruct newInit() {
        return new C0620bi();
    }

    public void readFrom(JceInputStream jceInputStream) {
        this.f219cy = jceInputStream.read(this.f219cy, 0, true);
        this.f211cN = jceInputStream.read(this.f211cN, 1, false);
        this.f212cO = (ArrayList) jceInputStream.read(f209cV, 2, false);
        this.f213cP = (ArrayList) jceInputStream.read(f210cW, 3, false);
        this.f214cQ = jceInputStream.read(this.f214cQ, 4, false);
        this.f215cR = jceInputStream.read(this.f215cR, 5, false);
        this.f216cS = jceInputStream.read(this.f216cS, 6, false);
        this.f217cT = jceInputStream.read(this.f217cT, 7, false);
        this.f218cU = jceInputStream.read(this.f218cU, 8, false);
        this.f220cz = (C0617bf) jceInputStream.read((JceStruct) f208cA, 9, false);
    }

    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.f219cy, 0);
        int i = this.f211cN;
        if (i != 0) {
            jceOutputStream.write(i, 1);
        }
        ArrayList<Integer> arrayList = this.f212cO;
        if (arrayList != null) {
            jceOutputStream.write((Collection<T>) arrayList, 2);
        }
        ArrayList<C0618bg> arrayList2 = this.f213cP;
        if (arrayList2 != null) {
            jceOutputStream.write((Collection<T>) arrayList2, 3);
        }
        int i2 = this.f214cQ;
        if (i2 != 0) {
            jceOutputStream.write(i2, 4);
        }
        jceOutputStream.write(this.f215cR, 5);
        jceOutputStream.write(this.f216cS, 6);
        int i3 = this.f217cT;
        if (i3 != 120) {
            jceOutputStream.write(i3, 7);
        }
        int i4 = this.f218cU;
        if (i4 != 10) {
            jceOutputStream.write(i4, 8);
        }
        C0617bf bfVar = this.f220cz;
        if (bfVar != null) {
            jceOutputStream.write((JceStruct) bfVar, 9);
        }
    }
}
