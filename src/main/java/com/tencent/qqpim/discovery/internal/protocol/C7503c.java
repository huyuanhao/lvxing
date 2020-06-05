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

/* renamed from: com.tencent.qqpim.discovery.internal.protocol.c */
public final class C7503c extends JceStruct implements Cloneable {
    static final /* synthetic */ boolean $assertionsDisabled = (!C7503c.class.desiredAssertionStatus());
    /* renamed from: la */
    static ArrayList<C7504d> f25145la = new ArrayList<>();
    /* renamed from: ma */
    public int f25146ma = 0;
    public String msg = "";
    /* renamed from: na */
    public ArrayList<C7504d> f25147na = null;
    public int positionId = 0;

    static {
        f25145la.add(new C7504d());
    }

    public C7503c() {
    }

    public C7503c(int i, String str, int i2, ArrayList<C7504d> arrayList) {
        this.f25146ma = i;
        this.msg = str;
        this.positionId = i2;
        this.f25147na = arrayList;
    }

    /* renamed from: E */
    public String mo36664E() {
        return this.msg;
    }

    /* renamed from: F */
    public int mo36665F() {
        return this.f25146ma;
    }

    /* renamed from: G */
    public ArrayList<C7504d> mo36666G() {
        return this.f25147na;
    }

    /* renamed from: c */
    public void mo36667c(ArrayList<C7504d> arrayList) {
        this.f25147na = arrayList;
    }

    public String className() {
        return "ADV.AdvPositonResp";
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
        jceDisplayer.display(this.f25146ma, KEYS.RET);
        jceDisplayer.display(this.msg, NotificationCompat.CATEGORY_MESSAGE);
        jceDisplayer.display(this.positionId, "positionId");
        jceDisplayer.display((Collection<T>) this.f25147na, "vecAdvertise");
    }

    public void displaySimple(StringBuilder sb, int i) {
        JceDisplayer jceDisplayer = new JceDisplayer(sb, i);
        jceDisplayer.displaySimple(this.f25146ma, true);
        jceDisplayer.displaySimple(this.msg, true);
        jceDisplayer.displaySimple(this.positionId, true);
        jceDisplayer.displaySimple((Collection<T>) this.f25147na, false);
    }

    public boolean equals(Object obj) {
        boolean z = false;
        if (obj == null) {
            return false;
        }
        C7503c cVar = (C7503c) obj;
        if (JceUtil.equals(this.f25146ma, cVar.f25146ma) && JceUtil.equals((Object) this.msg, (Object) cVar.msg) && JceUtil.equals(this.positionId, cVar.positionId) && JceUtil.equals((Object) this.f25147na, (Object) cVar.f25147na)) {
            z = true;
        }
        return z;
    }

    public String fullClassName() {
        return "com.tencent.qqpim.discovery.internal.protocol.AdvPositonResp";
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
    public void mo36674j(int i) {
        this.positionId = i;
    }

    /* renamed from: m */
    public void mo36675m(int i) {
        this.f25146ma = i;
    }

    /* renamed from: p */
    public void mo36676p(String str) {
        this.msg = str;
    }

    public void readFrom(JceInputStream jceInputStream) {
        this.f25146ma = jceInputStream.read(this.f25146ma, 0, false);
        this.msg = jceInputStream.readString(1, false);
        this.positionId = jceInputStream.read(this.positionId, 2, false);
        this.f25147na = (ArrayList) jceInputStream.read(f25145la, 3, false);
    }

    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.f25146ma, 0);
        String str = this.msg;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
        jceOutputStream.write(this.positionId, 2);
        ArrayList<C7504d> arrayList = this.f25147na;
        if (arrayList != null) {
            jceOutputStream.write((Collection<T>) arrayList, 3);
        }
    }
}
