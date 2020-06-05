package btmsdkobf;

import com.p522qq.taf.jce.JceInputStream;
import com.p522qq.taf.jce.JceOutputStream;
import com.p522qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* renamed from: btmsdkobf.bm */
public final class C0624bm extends JceStruct {
    /* renamed from: dm */
    static ArrayList<C0625bn> f238dm = new ArrayList<>();
    /* renamed from: dk */
    public ArrayList<C0625bn> f239dk = null;
    /* renamed from: dl */
    public int f240dl = 0;

    static {
        f238dm.add(new C0625bn());
    }

    public void readFrom(JceInputStream jceInputStream) {
        this.f239dk = (ArrayList) jceInputStream.read(f238dm, 0, true);
        this.f240dl = jceInputStream.read(this.f240dl, 1, false);
    }

    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write((Collection<T>) this.f239dk, 0);
        int i = this.f240dl;
        if (i != 0) {
            jceOutputStream.write(i, 1);
        }
    }
}
