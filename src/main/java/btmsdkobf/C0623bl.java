package btmsdkobf;

import com.p522qq.taf.jce.JceInputStream;
import com.p522qq.taf.jce.JceOutputStream;
import com.p522qq.taf.jce.JceStruct;

/* renamed from: btmsdkobf.bl */
public final class C0623bl extends JceStruct {
    /* renamed from: aB */
    public String f235aB;
    /* renamed from: di */
    public String f236di;
    /* renamed from: dj */
    public int f237dj = 0;
    public int type = 0;

    public C0623bl() {
        String str = "";
        this.f235aB = str;
        this.f236di = str;
    }

    public void readFrom(JceInputStream jceInputStream) {
        this.f235aB = jceInputStream.readString(0, true);
        this.f236di = jceInputStream.readString(1, true);
        this.type = jceInputStream.read(this.type, 2, true);
        this.f237dj = jceInputStream.read(this.f237dj, 3, true);
    }

    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.f235aB, 0);
        jceOutputStream.write(this.f236di, 1);
        jceOutputStream.write(this.type, 2);
        jceOutputStream.write(this.f237dj, 3);
    }
}
