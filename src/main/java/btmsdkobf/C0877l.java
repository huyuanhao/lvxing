package btmsdkobf;

import com.p522qq.taf.jce.JceInputStream;
import com.p522qq.taf.jce.JceOutputStream;
import com.p522qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* renamed from: btmsdkobf.l */
public final class C0877l extends JceStruct {
    /* renamed from: Y */
    static ArrayList<C0878m> f1043Y = new ArrayList<>();
    /* renamed from: W */
    public int f1044W = 0;
    /* renamed from: X */
    public ArrayList<C0878m> f1045X = null;

    static {
        f1043Y.add(new C0878m());
    }

    public void readFrom(JceInputStream jceInputStream) {
        this.f1044W = jceInputStream.read(this.f1044W, 0, true);
        this.f1045X = (ArrayList) jceInputStream.read(f1043Y, 1, false);
    }

    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.f1044W, 0);
        ArrayList<C0878m> arrayList = this.f1045X;
        if (arrayList != null) {
            jceOutputStream.write((Collection<T>) arrayList, 1);
        }
    }
}
