package com.tencent.qqpim.discovery.internal.protocol;

import com.p522qq.taf.jce.JceDisplayer;
import com.p522qq.taf.jce.JceInputStream;
import com.p522qq.taf.jce.JceOutputStream;
import com.p522qq.taf.jce.JceStruct;
import com.p522qq.taf.jce.JceUtil;

/* renamed from: com.tencent.qqpim.discovery.internal.protocol.k */
public final class C7511k extends JceStruct implements Cloneable {
    static final /* synthetic */ boolean $assertionsDisabled = (!C7511k.class.desiredAssertionStatus());
    /* renamed from: bb */
    public int f25192bb = 0;
    /* renamed from: cb */
    public int f25193cb = 0;
    /* renamed from: db */
    public int f25194db = 0;
    /* renamed from: eb */
    public boolean f25195eb = false;
    public boolean isDeepLink = true;
    public int rotation = 0;
    public int scenes = 0;

    public C7511k() {
    }

    public C7511k(int i, int i2, int i3, int i4, boolean z, int i5, boolean z2) {
        this.f25192bb = i;
        this.f25193cb = i2;
        this.scenes = i3;
        this.f25194db = i4;
        this.isDeepLink = z;
        this.rotation = i5;
        this.f25195eb = z2;
    }

    public String className() {
        return "ADV.DisplayCtrl";
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
    public void mo36802d(boolean z) {
        this.f25195eb = z;
    }

    public void display(StringBuilder sb, int i) {
        JceDisplayer jceDisplayer = new JceDisplayer(sb, i);
        jceDisplayer.display(this.f25192bb, "displayTime");
        jceDisplayer.display(this.f25193cb, "displayInterval");
        jceDisplayer.display(this.scenes, C7887a.f26828Dh);
        jceDisplayer.display(this.f25194db, "downloadType");
        jceDisplayer.display(this.isDeepLink, "isDeepLink");
        jceDisplayer.display(this.rotation, C7887a.ROTATION);
        jceDisplayer.display(this.f25195eb, "displayInVipMode");
    }

    public void displaySimple(StringBuilder sb, int i) {
        JceDisplayer jceDisplayer = new JceDisplayer(sb, i);
        jceDisplayer.displaySimple(this.f25192bb, true);
        jceDisplayer.displaySimple(this.f25193cb, true);
        jceDisplayer.displaySimple(this.scenes, true);
        jceDisplayer.displaySimple(this.f25194db, true);
        jceDisplayer.displaySimple(this.isDeepLink, true);
        jceDisplayer.displaySimple(this.rotation, true);
        jceDisplayer.displaySimple(this.f25195eb, false);
    }

    /* renamed from: e */
    public void mo36803e(boolean z) {
        this.isDeepLink = z;
    }

    public boolean equals(Object obj) {
        boolean z = false;
        if (obj == null) {
            return false;
        }
        C7511k kVar = (C7511k) obj;
        if (JceUtil.equals(this.f25192bb, kVar.f25192bb) && JceUtil.equals(this.f25193cb, kVar.f25193cb) && JceUtil.equals(this.scenes, kVar.scenes) && JceUtil.equals(this.f25194db, kVar.f25194db) && JceUtil.equals(this.isDeepLink, kVar.isDeepLink) && JceUtil.equals(this.rotation, kVar.rotation) && JceUtil.equals(this.f25195eb, kVar.f25195eb)) {
            z = true;
        }
        return z;
    }

    public String fullClassName() {
        return "com.tencent.qqpim.discovery.internal.protocol.DisplayCtrl";
    }

    public int getRotation() {
        return this.rotation;
    }

    public int hashCode() {
        try {
            throw new Exception("Need define key first!");
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    /* renamed from: ma */
    public boolean mo36808ma() {
        return this.f25195eb;
    }

    /* renamed from: na */
    public int mo36809na() {
        return this.f25193cb;
    }

    /* renamed from: oa */
    public int mo36810oa() {
        return this.f25192bb;
    }

    /* renamed from: pa */
    public int mo36811pa() {
        return this.f25194db;
    }

    /* renamed from: qa */
    public boolean mo36812qa() {
        return this.isDeepLink;
    }

    /* renamed from: ra */
    public int mo36813ra() {
        return this.scenes;
    }

    public void readFrom(JceInputStream jceInputStream) {
        this.f25192bb = jceInputStream.read(this.f25192bb, 0, false);
        this.f25193cb = jceInputStream.read(this.f25193cb, 1, false);
        this.scenes = jceInputStream.read(this.scenes, 2, false);
        this.f25194db = jceInputStream.read(this.f25194db, 3, false);
        this.isDeepLink = jceInputStream.read(this.isDeepLink, 4, false);
        this.rotation = jceInputStream.read(this.rotation, 5, false);
        this.f25195eb = jceInputStream.read(this.f25195eb, 6, false);
    }

    public void setRotation(int i) {
        this.rotation = i;
    }

    /* renamed from: v */
    public void mo36815v(int i) {
        this.f25193cb = i;
    }

    /* renamed from: w */
    public void mo36816w(int i) {
        this.f25192bb = i;
    }

    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.f25192bb, 0);
        jceOutputStream.write(this.f25193cb, 1);
        jceOutputStream.write(this.scenes, 2);
        jceOutputStream.write(this.f25194db, 3);
        jceOutputStream.write(this.isDeepLink, 4);
        jceOutputStream.write(this.rotation, 5);
        jceOutputStream.write(this.f25195eb, 6);
    }

    /* renamed from: x */
    public void mo36817x(int i) {
        this.f25194db = i;
    }

    /* renamed from: y */
    public void mo36818y(int i) {
        this.scenes = i;
    }
}
