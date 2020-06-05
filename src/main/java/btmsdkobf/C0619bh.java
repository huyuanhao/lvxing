package btmsdkobf;

import com.p522qq.taf.jce.JceInputStream;
import com.p522qq.taf.jce.JceOutputStream;
import com.p522qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/* renamed from: btmsdkobf.bh */
public final class C0619bh extends JceStruct {
    /* renamed from: cL */
    static ArrayList<String> f200cL = new ArrayList<>();
    /* renamed from: cM */
    static Map<String, String> f201cM = new HashMap();
    /* renamed from: cG */
    public ArrayList<String> f202cG = null;
    /* renamed from: cH */
    public int f203cH = 0;
    /* renamed from: cI */
    public boolean f204cI = false;
    /* renamed from: cJ */
    public int f205cJ = 0;
    /* renamed from: cK */
    public Map<String, String> f206cK = null;
    /* renamed from: cy */
    public int f207cy = 0;

    static {
        String str = "";
        f200cL.add(str);
        f201cM.put(str, str);
    }

    public JceStruct newInit() {
        return new C0619bh();
    }

    public void readFrom(JceInputStream jceInputStream) {
        this.f207cy = jceInputStream.read(this.f207cy, 0, true);
        this.f202cG = (ArrayList) jceInputStream.read(f200cL, 1, true);
        this.f203cH = jceInputStream.read(this.f203cH, 2, true);
        this.f204cI = jceInputStream.read(this.f204cI, 3, false);
        this.f205cJ = jceInputStream.read(this.f205cJ, 4, false);
        this.f206cK = (Map) jceInputStream.read(f201cM, 5, false);
    }

    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.f207cy, 0);
        jceOutputStream.write((Collection<T>) this.f202cG, 1);
        jceOutputStream.write(this.f203cH, 2);
        boolean z = this.f204cI;
        if (z) {
            jceOutputStream.write(z, 3);
        }
        jceOutputStream.write(this.f205cJ, 4);
        Map<String, String> map = this.f206cK;
        if (map != null) {
            jceOutputStream.write(map, 5);
        }
    }
}
