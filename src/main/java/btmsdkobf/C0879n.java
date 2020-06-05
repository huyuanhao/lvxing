package btmsdkobf;

import com.p522qq.taf.jce.JceInputStream;
import com.p522qq.taf.jce.JceOutputStream;
import com.p522qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* renamed from: btmsdkobf.n */
public final class C0879n extends JceStruct {
    /* renamed from: U */
    static C0887v f1047U = new C0887v();
    /* renamed from: aa */
    static ArrayList<Integer> f1048aa = new ArrayList<>();
    /* renamed from: S */
    public C0887v f1049S = null;
    /* renamed from: Z */
    public ArrayList<Integer> f1050Z = null;

    static {
        f1048aa.add(Integer.valueOf(0));
    }

    public JceStruct newInit() {
        return new C0879n();
    }

    public void readFrom(JceInputStream jceInputStream) {
        this.f1049S = (C0887v) jceInputStream.read((JceStruct) f1047U, 0, false);
        this.f1050Z = (ArrayList) jceInputStream.read(f1048aa, 1, false);
    }

    public void writeTo(JceOutputStream jceOutputStream) {
        C0887v vVar = this.f1049S;
        if (vVar != null) {
            jceOutputStream.write((JceStruct) vVar, 0);
        }
        ArrayList<Integer> arrayList = this.f1050Z;
        if (arrayList != null) {
            jceOutputStream.write((Collection<T>) arrayList, 1);
        }
    }
}
