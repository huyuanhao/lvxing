package com.tencent.qqpim.discovery.internal.protocol;

import androidx.core.app.NotificationCompat;
import com.p522qq.p523e.comm.constants.Constants.KEYS;
import com.p522qq.taf.jce.JceDisplayer;
import com.p522qq.taf.jce.JceInputStream;
import com.p522qq.taf.jce.JceOutputStream;
import com.p522qq.taf.jce.JceStruct;
import com.p522qq.taf.jce.JceUtil;
import java.util.ArrayList;
import java.util.Collection;

/* renamed from: com.tencent.qqpim.discovery.internal.protocol.G */
public final class C7498G extends JceStruct implements Cloneable {
    static final /* synthetic */ boolean $assertionsDisabled = (!C7498G.class.desiredAssertionStatus());
    /* renamed from: Qb */
    static ArrayList<C7499H> f25113Qb = new ArrayList<>();
    /* renamed from: ra */
    static C7524x f25114ra = new C7524x();
    /* renamed from: Rb */
    public ArrayList<C7499H> f25115Rb = null;
    /* renamed from: ma */
    public int f25116ma = 0;
    public String msg = "";
    public int positionId = 0;
    /* renamed from: xa */
    public C7524x f25117xa = null;

    static {
        f25113Qb.add(new C7499H());
    }

    public C7498G() {
    }

    public C7498G(int i, String str, int i2, ArrayList<C7499H> arrayList, C7524x xVar) {
        this.f25116ma = i;
        this.msg = str;
        this.positionId = i2;
        this.f25115Rb = arrayList;
        this.f25117xa = xVar;
    }

    /* renamed from: E */
    public String mo36556E() {
        return this.msg;
    }

    /* renamed from: F */
    public int mo36557F() {
        return this.f25116ma;
    }

    /* renamed from: L */
    public C7524x mo36558L() {
        return this.f25117xa;
    }

    /* renamed from: La */
    public ArrayList<C7499H> mo36559La() {
        return this.f25115Rb;
    }

    /* renamed from: a */
    public void mo36560a(C7524x xVar) {
        this.f25117xa = xVar;
    }

    public String className() {
        return "ADV.SecureAdvPositonResp";
    }

    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException unused) {
            if ($assertionsDisabled) {
                return null;
            }
            throw new AssertionError();
        }
    }

    public void display(StringBuilder sb, int i) {
        JceDisplayer jceDisplayer = new JceDisplayer(sb, i);
        jceDisplayer.display(this.f25116ma, KEYS.RET);
        jceDisplayer.display(this.msg, NotificationCompat.CATEGORY_MESSAGE);
        jceDisplayer.display(this.positionId, "positionId");
        jceDisplayer.display((Collection<T>) this.f25115Rb, "vecSecureAdvertise");
        jceDisplayer.display((JceStruct) this.f25117xa, "gdtSDKInfo");
    }

    public void displaySimple(StringBuilder sb, int i) {
        JceDisplayer jceDisplayer = new JceDisplayer(sb, i);
        jceDisplayer.displaySimple(this.f25116ma, true);
        jceDisplayer.displaySimple(this.msg, true);
        jceDisplayer.displaySimple(this.positionId, true);
        jceDisplayer.displaySimple((Collection<T>) this.f25115Rb, true);
        jceDisplayer.displaySimple((JceStruct) this.f25117xa, false);
    }

    public boolean equals(Object obj) {
        boolean z = false;
        if (obj == null) {
            return false;
        }
        C7498G g = (C7498G) obj;
        if (JceUtil.equals(this.f25116ma, g.f25116ma) && JceUtil.equals((Object) this.msg, (Object) g.msg) && JceUtil.equals(this.positionId, g.positionId) && JceUtil.equals((Object) this.f25115Rb, (Object) g.f25115Rb) && JceUtil.equals((Object) this.f25117xa, (Object) g.f25117xa)) {
            z = true;
        }
        return z;
    }

    public String fullClassName() {
        return "com.tencent.qqpim.discovery.internal.protocol.SecureAdvPositonResp";
    }

    public int getPositionId() {
        return this.positionId;
    }

    public int hashCode() {
        try {
            throw new Exception("Need define key first!");
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    /* renamed from: j */
    public void mo36567j(int i) {
        this.positionId = i;
    }

    /* renamed from: k */
    public void mo36568k(ArrayList<C7499H> arrayList) {
        this.f25115Rb = arrayList;
    }

    /* renamed from: m */
    public void mo36569m(int i) {
        this.f25116ma = i;
    }

    /* renamed from: p */
    public void mo36570p(String str) {
        this.msg = str;
    }

    public void readFrom(JceInputStream jceInputStream) {
        this.f25116ma = jceInputStream.read(this.f25116ma, 0, false);
        this.msg = jceInputStream.readString(1, false);
        this.positionId = jceInputStream.read(this.positionId, 2, false);
        this.f25115Rb = (ArrayList) jceInputStream.read(f25113Qb, 3, false);
        this.f25117xa = (C7524x) jceInputStream.read((JceStruct) f25114ra, 4, false);
    }

    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.f25116ma, 0);
        String str = this.msg;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
        jceOutputStream.write(this.positionId, 2);
        ArrayList<C7499H> arrayList = this.f25115Rb;
        if (arrayList != null) {
            jceOutputStream.write((Collection<T>) arrayList, 3);
        }
        C7524x xVar = this.f25117xa;
        if (xVar != null) {
            jceOutputStream.write((JceStruct) xVar, 4);
        }
    }
}
