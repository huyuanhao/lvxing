package btmsdkobf;

import com.p522qq.taf.jce.JceInputStream;
import com.p522qq.taf.jce.JceOutputStream;
import com.p522qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* renamed from: btmsdkobf.q */
public final class C0882q extends JceStruct {
    /* renamed from: U */
    static C0887v f1057U = new C0887v();
    /* renamed from: V */
    static ArrayList<byte[]> f1058V = new ArrayList<>();
    /* renamed from: S */
    public C0887v f1059S = null;
    /* renamed from: T */
    public ArrayList<byte[]> f1060T = null;

    static {
        byte[] bArr = new byte[1];
        bArr[0] = 0;
        f1058V.add(bArr);
    }

    public void readFrom(JceInputStream jceInputStream) {
        this.f1059S = (C0887v) jceInputStream.read((JceStruct) f1057U, 0, true);
        this.f1060T = (ArrayList) jceInputStream.read(f1058V, 1, false);
    }

    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write((JceStruct) this.f1059S, 0);
        ArrayList<byte[]> arrayList = this.f1060T;
        if (arrayList != null) {
            jceOutputStream.write((Collection<T>) arrayList, 1);
        }
    }
}
