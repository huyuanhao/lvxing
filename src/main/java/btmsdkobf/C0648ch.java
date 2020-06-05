package btmsdkobf;

import com.p522qq.taf.jce.JceInputStream;
import com.p522qq.taf.jce.JceOutputStream;
import com.p522qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* renamed from: btmsdkobf.ch */
public final class C0648ch extends JceStruct {
    /* renamed from: fG */
    static ArrayList<C0647cg> f391fG = new ArrayList<>();
    /* renamed from: fF */
    public ArrayList<C0647cg> f392fF = null;
    /* renamed from: fm */
    public int f393fm = 0;
    /* renamed from: fn */
    public int f394fn = 0;

    static {
        f391fG.add(new C0647cg());
    }

    public JceStruct newInit() {
        return new C0648ch();
    }

    public void readFrom(JceInputStream jceInputStream) {
        this.f393fm = jceInputStream.read(this.f393fm, 0, false);
        this.f394fn = jceInputStream.read(this.f394fn, 1, false);
        this.f392fF = (ArrayList) jceInputStream.read(f391fG, 2, false);
    }

    public void writeTo(JceOutputStream jceOutputStream) {
        int i = this.f393fm;
        if (i != 0) {
            jceOutputStream.write(i, 0);
        }
        int i2 = this.f394fn;
        if (i2 != 0) {
            jceOutputStream.write(i2, 1);
        }
        ArrayList<C0647cg> arrayList = this.f392fF;
        if (arrayList != null) {
            jceOutputStream.write((Collection<T>) arrayList, 2);
        }
    }
}
