package btmsdkobf;

import com.p522qq.taf.jce.JceInputStream;
import com.p522qq.taf.jce.JceOutputStream;
import com.p522qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* renamed from: btmsdkobf.bo */
public final class C0626bo extends JceStruct {
    /* renamed from: dA */
    static ArrayList<C0627bp> f247dA = new ArrayList<>();
    /* renamed from: dx */
    static C0622bk f248dx = new C0622bk();
    /* renamed from: dy */
    static C0623bl f249dy = new C0623bl();
    /* renamed from: dz */
    static C0623bl f250dz = new C0623bl();
    /* renamed from: ds */
    public String f251ds = "";
    /* renamed from: dt */
    public C0622bk f252dt = null;
    /* renamed from: du */
    public C0623bl f253du = null;
    /* renamed from: dv */
    public C0623bl f254dv = null;
    /* renamed from: dw */
    public ArrayList<C0627bp> f255dw = null;

    static {
        f247dA.add(new C0627bp());
    }

    public JceStruct newInit() {
        return new C0626bo();
    }

    public void readFrom(JceInputStream jceInputStream) {
        this.f251ds = jceInputStream.readString(0, true);
        this.f252dt = (C0622bk) jceInputStream.read((JceStruct) f248dx, 1, false);
        this.f253du = (C0623bl) jceInputStream.read((JceStruct) f249dy, 2, false);
        this.f254dv = (C0623bl) jceInputStream.read((JceStruct) f250dz, 3, false);
        this.f255dw = (ArrayList) jceInputStream.read(f247dA, 4, false);
    }

    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.f251ds, 0);
        C0622bk bkVar = this.f252dt;
        if (bkVar != null) {
            jceOutputStream.write((JceStruct) bkVar, 1);
        }
        C0623bl blVar = this.f253du;
        if (blVar != null) {
            jceOutputStream.write((JceStruct) blVar, 2);
        }
        C0623bl blVar2 = this.f254dv;
        if (blVar2 != null) {
            jceOutputStream.write((JceStruct) blVar2, 3);
        }
        ArrayList<C0627bp> arrayList = this.f255dw;
        if (arrayList != null) {
            jceOutputStream.write((Collection<T>) arrayList, 4);
        }
    }
}
