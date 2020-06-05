package btmsdkobf;

import com.p522qq.taf.jce.JceInputStream;
import com.p522qq.taf.jce.JceOutputStream;
import com.p522qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* renamed from: btmsdkobf.o */
public final class C0880o extends JceStruct {
    /* renamed from: ad */
    static ArrayList<C0884s> f1051ad = new ArrayList<>();
    /* renamed from: W */
    public int f1052W = 0;
    /* renamed from: ab */
    public ArrayList<C0884s> f1053ab = null;
    /* renamed from: ac */
    public int f1054ac = 0;

    static {
        f1051ad.add(new C0884s());
    }

    public JceStruct newInit() {
        return new C0880o();
    }

    public void readFrom(JceInputStream jceInputStream) {
        this.f1052W = jceInputStream.read(this.f1052W, 0, true);
        this.f1053ab = (ArrayList) jceInputStream.read(f1051ad, 1, false);
        this.f1054ac = jceInputStream.read(this.f1054ac, 2, false);
    }

    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.f1052W, 0);
        ArrayList<C0884s> arrayList = this.f1053ab;
        if (arrayList != null) {
            jceOutputStream.write((Collection<T>) arrayList, 1);
        }
        int i = this.f1054ac;
        if (i != 0) {
            jceOutputStream.write(i, 2);
        }
    }
}
