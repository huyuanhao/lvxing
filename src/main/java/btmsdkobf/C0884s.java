package btmsdkobf;

import com.p522qq.taf.jce.JceInputStream;
import com.p522qq.taf.jce.JceOutputStream;
import com.p522qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* renamed from: btmsdkobf.s */
public final class C0884s extends JceStruct {
    /* renamed from: ah */
    static ArrayList<C0885t> f1065ah = new ArrayList<>();
    /* renamed from: ag */
    public ArrayList<C0885t> f1066ag = null;
    public int task_type = 0;

    static {
        f1065ah.add(new C0885t());
    }

    public void readFrom(JceInputStream jceInputStream) {
        this.task_type = jceInputStream.read(this.task_type, 0, false);
        this.f1066ag = (ArrayList) jceInputStream.read(f1065ah, 1, false);
    }

    public void writeTo(JceOutputStream jceOutputStream) {
        int i = this.task_type;
        if (i != 0) {
            jceOutputStream.write(i, 0);
        }
        ArrayList<C0885t> arrayList = this.f1066ag;
        if (arrayList != null) {
            jceOutputStream.write((Collection<T>) arrayList, 1);
        }
    }
}
