package com.tencent.qqpim.discovery.internal.protocol;

import com.p522qq.taf.jce.JceDisplayer;
import com.p522qq.taf.jce.JceInputStream;
import com.p522qq.taf.jce.JceOutputStream;
import com.p522qq.taf.jce.JceStruct;
import com.p522qq.taf.jce.JceUtil;
import com.tencent.android.tpush.common.MessageKey;

/* renamed from: com.tencent.qqpim.discovery.internal.protocol.d */
public final class C7504d extends JceStruct implements Cloneable {
    static final /* synthetic */ boolean $assertionsDisabled = (!C7504d.class.desiredAssertionStatus());
    static byte[] cache_context = new byte[1];
    /* renamed from: oa */
    static C7510j f25148oa = new C7510j();
    /* renamed from: pa */
    static C7509i f25149pa = new C7509i();
    /* renamed from: qa */
    static C7511k f25150qa = new C7511k();
    /* renamed from: ra */
    static C7524x f25151ra = new C7524x();
    public C7509i content = null;
    public byte[] context = null;
    /* renamed from: sa */
    public int f25152sa = 0;
    /* renamed from: ta */
    public C7510j f25153ta = null;
    /* renamed from: va */
    public long f25154va = 0;
    /* renamed from: wa */
    public C7511k f25155wa = null;
    /* renamed from: xa */
    public C7524x f25156xa = null;

    static {
        cache_context[0] = 0;
    }

    public C7504d() {
    }

    public C7504d(int i, C7510j jVar, C7509i iVar, byte[] bArr, long j, C7511k kVar, C7524x xVar) {
        this.f25152sa = i;
        this.f25153ta = jVar;
        this.content = iVar;
        this.context = bArr;
        this.f25154va = j;
        this.f25155wa = kVar;
        this.f25156xa = xVar;
    }

    /* renamed from: H */
    public long mo36677H() {
        return this.f25154va;
    }

    /* renamed from: I */
    public C7511k mo36678I() {
        return this.f25155wa;
    }

    /* renamed from: J */
    public C7510j mo36679J() {
        return this.f25153ta;
    }

    /* renamed from: K */
    public int mo36680K() {
        return this.f25152sa;
    }

    /* renamed from: L */
    public C7524x mo36681L() {
        return this.f25156xa;
    }

    /* renamed from: a */
    public void mo36682a(C7509i iVar) {
        this.content = iVar;
    }

    /* renamed from: a */
    public void mo36683a(C7510j jVar) {
        this.f25153ta = jVar;
    }

    /* renamed from: a */
    public void mo36684a(C7511k kVar) {
        this.f25155wa = kVar;
    }

    /* renamed from: a */
    public void mo36685a(C7524x xVar) {
        this.f25156xa = xVar;
    }

    public String className() {
        return "ADV.Advertise";
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

    /* renamed from: d */
    public void mo36688d(byte[] bArr) {
        this.context = bArr;
    }

    public void display(StringBuilder sb, int i) {
        JceDisplayer jceDisplayer = new JceDisplayer(sb, i);
        jceDisplayer.display(this.f25152sa, "expireTime");
        jceDisplayer.display((JceStruct) this.f25153ta, "displayInfo");
        jceDisplayer.display((JceStruct) this.content, MessageKey.MSG_CONTENT);
        jceDisplayer.display(this.context, "context");
        jceDisplayer.display(this.f25154va, "advId");
        jceDisplayer.display((JceStruct) this.f25155wa, "displayCtrl");
        jceDisplayer.display((JceStruct) this.f25156xa, "gdtSDKInfo");
    }

    public void displaySimple(StringBuilder sb, int i) {
        JceDisplayer jceDisplayer = new JceDisplayer(sb, i);
        jceDisplayer.displaySimple(this.f25152sa, true);
        jceDisplayer.displaySimple((JceStruct) this.f25153ta, true);
        jceDisplayer.displaySimple((JceStruct) this.content, true);
        jceDisplayer.displaySimple(this.context, true);
        jceDisplayer.displaySimple(this.f25154va, true);
        jceDisplayer.displaySimple((JceStruct) this.f25155wa, true);
        jceDisplayer.displaySimple((JceStruct) this.f25156xa, false);
    }

    public boolean equals(Object obj) {
        boolean z = false;
        if (obj == null) {
            return false;
        }
        C7504d dVar = (C7504d) obj;
        if (JceUtil.equals(this.f25152sa, dVar.f25152sa) && JceUtil.equals((Object) this.f25153ta, (Object) dVar.f25153ta) && JceUtil.equals((Object) this.content, (Object) dVar.content) && JceUtil.equals((Object) this.context, (Object) dVar.context) && JceUtil.equals(this.f25154va, dVar.f25154va) && JceUtil.equals((Object) this.f25155wa, (Object) dVar.f25155wa) && JceUtil.equals((Object) this.f25156xa, (Object) dVar.f25156xa)) {
            z = true;
        }
        return z;
    }

    public String fullClassName() {
        return "com.tencent.qqpim.discovery.internal.protocol.Advertise";
    }

    public C7509i getContent() {
        return this.content;
    }

    public byte[] getContext() {
        return this.context;
    }

    /* renamed from: h */
    public void mo36693h(long j) {
        this.f25154va = j;
    }

    public int hashCode() {
        try {
            throw new Exception("Need define key first!");
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    /* renamed from: n */
    public void mo36695n(int i) {
        this.f25152sa = i;
    }

    public void readFrom(JceInputStream jceInputStream) {
        this.f25152sa = jceInputStream.read(this.f25152sa, 0, false);
        this.f25153ta = (C7510j) jceInputStream.read((JceStruct) f25148oa, 1, false);
        this.content = (C7509i) jceInputStream.read((JceStruct) f25149pa, 2, false);
        this.context = jceInputStream.read(cache_context, 3, false);
        this.f25154va = jceInputStream.read(this.f25154va, 4, false);
        this.f25155wa = (C7511k) jceInputStream.read((JceStruct) f25150qa, 5, false);
        this.f25156xa = (C7524x) jceInputStream.read((JceStruct) f25151ra, 6, false);
    }

    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.f25152sa, 0);
        C7510j jVar = this.f25153ta;
        if (jVar != null) {
            jceOutputStream.write((JceStruct) jVar, 1);
        }
        C7509i iVar = this.content;
        if (iVar != null) {
            jceOutputStream.write((JceStruct) iVar, 2);
        }
        byte[] bArr = this.context;
        if (bArr != null) {
            jceOutputStream.write(bArr, 3);
        }
        jceOutputStream.write(this.f25154va, 4);
        C7511k kVar = this.f25155wa;
        if (kVar != null) {
            jceOutputStream.write((JceStruct) kVar, 5);
        }
        C7524x xVar = this.f25156xa;
        if (xVar != null) {
            jceOutputStream.write((JceStruct) xVar, 6);
        }
    }
}
