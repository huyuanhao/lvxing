package btmsdkobf;

import com.p522qq.taf.jce.JceInputStream;
import com.p522qq.taf.jce.JceOutputStream;
import com.p522qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* renamed from: btmsdkobf.ba */
public final class C0612ba extends JceStruct {
    /* renamed from: ck */
    static ArrayList<C0613bb> f175ck;
    /* renamed from: cl */
    static C0614bc f176cl;
    /* renamed from: ci */
    public ArrayList<C0613bb> f177ci = null;
    /* renamed from: cj */
    public C0614bc f178cj = null;

    public void readFrom(JceInputStream jceInputStream) {
        if (f175ck == null) {
            f175ck = new ArrayList<>();
            f175ck.add(new C0613bb());
        }
        this.f177ci = (ArrayList) jceInputStream.read(f175ck, 0, true);
        if (f176cl == null) {
            f176cl = new C0614bc();
        }
        this.f178cj = (C0614bc) jceInputStream.read((JceStruct) f176cl, 1, false);
    }

    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write((Collection<T>) this.f177ci, 0);
        C0614bc bcVar = this.f178cj;
        if (bcVar != null) {
            jceOutputStream.write((JceStruct) bcVar, 1);
        }
    }
}
