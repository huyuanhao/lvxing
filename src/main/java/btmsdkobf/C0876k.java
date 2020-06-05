package btmsdkobf;

import com.p522qq.taf.jce.JceInputStream;
import com.p522qq.taf.jce.JceOutputStream;
import com.p522qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* renamed from: btmsdkobf.k */
public final class C0876k extends JceStruct {
    /* renamed from: U */
    static C0887v f1039U = new C0887v();
    /* renamed from: V */
    static ArrayList<byte[]> f1040V = new ArrayList<>();
    /* renamed from: S */
    public C0887v f1041S = null;
    /* renamed from: T */
    public ArrayList<byte[]> f1042T = null;

    static {
        byte[] bArr = new byte[1];
        bArr[0] = 0;
        f1040V.add(bArr);
    }

    public void readFrom(JceInputStream jceInputStream) {
        this.f1041S = (C0887v) jceInputStream.read((JceStruct) f1039U, 0, true);
        this.f1042T = (ArrayList) jceInputStream.read(f1040V, 1, true);
    }

    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write((JceStruct) this.f1041S, 0);
        jceOutputStream.write((Collection<T>) this.f1042T, 1);
    }
}
