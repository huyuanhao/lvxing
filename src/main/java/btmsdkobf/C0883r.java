package btmsdkobf;

import com.p522qq.taf.jce.JceInputStream;
import com.p522qq.taf.jce.JceOutputStream;
import com.p522qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* renamed from: btmsdkobf.r */
public final class C0883r extends JceStruct {
    /* renamed from: Y */
    static ArrayList<C0878m> f1061Y = new ArrayList<>();
    /* renamed from: W */
    public int f1062W = 0;
    /* renamed from: X */
    public ArrayList<C0878m> f1063X = null;
    /* renamed from: ac */
    public int f1064ac = 0;

    static {
        f1061Y.add(new C0878m());
    }

    public JceStruct newInit() {
        return new C0883r();
    }

    public void readFrom(JceInputStream jceInputStream) {
        this.f1062W = jceInputStream.read(this.f1062W, 0, true);
        this.f1063X = (ArrayList) jceInputStream.read(f1061Y, 1, false);
        this.f1064ac = jceInputStream.read(this.f1064ac, 2, false);
    }

    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.f1062W, 0);
        ArrayList<C0878m> arrayList = this.f1063X;
        if (arrayList != null) {
            jceOutputStream.write((Collection<T>) arrayList, 1);
        }
        int i = this.f1064ac;
        if (i != 0) {
            jceOutputStream.write(i, 2);
        }
    }
}
