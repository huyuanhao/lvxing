package com.tencent.qqpim.discovery.internal.protocol;

import androidx.core.app.NotificationCompat;
import com.p522qq.taf.jce.JceDisplayer;
import com.p522qq.taf.jce.JceInputStream;
import com.p522qq.taf.jce.JceOutputStream;
import com.p522qq.taf.jce.JceStruct;
import com.p522qq.taf.jce.JceUtil;
import discoveryAD.C7880W.C7881a;

/* renamed from: com.tencent.qqpim.discovery.internal.protocol.a */
public final class C7501a extends JceStruct implements Cloneable {
    static final /* synthetic */ boolean $assertionsDisabled = (!C7501a.class.desiredAssertionStatus());
    /* renamed from: R */
    static int f25130R = 0;
    /* renamed from: S */
    static C7500I f25131S = new C7500I();
    /* renamed from: U */
    static C7522v f25132U = new C7522v();
    static byte[] cache_context = new byte[1];
    /* renamed from: W */
    public int f25133W = 0;
    /* renamed from: aa */
    public int f25134aa = 0;
    /* renamed from: ba */
    public C7500I f25135ba = null;
    /* renamed from: ca */
    public C7522v f25136ca = null;
    public byte[] context = null;
    public int positionId = 0;
    public int status = 0;
    public long timeStamp = 0;

    static {
        cache_context[0] = 0;
    }

    public C7501a() {
    }

    public C7501a(int i, byte[] bArr, int i2, long j, int i3, int i4, C7500I i5, C7522v vVar) {
        this.f25133W = i;
        this.context = bArr;
        this.positionId = i2;
        this.timeStamp = j;
        this.status = i3;
        this.f25134aa = i4;
        this.f25135ba = i5;
        this.f25136ca = vVar;
    }

    /* renamed from: a */
    public void mo36622a(C7500I i) {
        this.f25135ba = i;
    }

    /* renamed from: a */
    public void mo36623a(C7522v vVar) {
        this.f25136ca = vVar;
    }

    public String className() {
        return "ADV.AdReportItem";
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
    public void mo36626d(byte[] bArr) {
        this.context = bArr;
    }

    public void display(StringBuilder sb, int i) {
        JceDisplayer jceDisplayer = new JceDisplayer(sb, i);
        jceDisplayer.display(this.f25133W, C7881a.f26804fh);
        jceDisplayer.display(this.context, "context");
        jceDisplayer.display(this.positionId, "positionId");
        jceDisplayer.display(this.timeStamp, "timeStamp");
        jceDisplayer.display(this.status, NotificationCompat.CATEGORY_STATUS);
        jceDisplayer.display(this.f25134aa, "phaseTime");
        jceDisplayer.display((JceStruct) this.f25135ba, "videoDisplayInfo");
        jceDisplayer.display((JceStruct) this.f25136ca, "reportUrls");
    }

    public void displaySimple(StringBuilder sb, int i) {
        JceDisplayer jceDisplayer = new JceDisplayer(sb, i);
        jceDisplayer.displaySimple(this.f25133W, true);
        jceDisplayer.displaySimple(this.context, true);
        jceDisplayer.displaySimple(this.positionId, true);
        jceDisplayer.displaySimple(this.timeStamp, true);
        jceDisplayer.displaySimple(this.status, true);
        jceDisplayer.displaySimple(this.f25134aa, true);
        jceDisplayer.displaySimple((JceStruct) this.f25135ba, true);
        jceDisplayer.displaySimple((JceStruct) this.f25136ca, false);
    }

    public boolean equals(Object obj) {
        boolean z = false;
        if (obj == null) {
            return false;
        }
        C7501a aVar = (C7501a) obj;
        if (JceUtil.equals(this.f25133W, aVar.f25133W) && JceUtil.equals((Object) this.context, (Object) aVar.context) && JceUtil.equals(this.positionId, aVar.positionId) && JceUtil.equals(this.timeStamp, aVar.timeStamp) && JceUtil.equals(this.status, aVar.status) && JceUtil.equals(this.f25134aa, aVar.f25134aa) && JceUtil.equals((Object) this.f25135ba, (Object) aVar.f25135ba) && JceUtil.equals((Object) this.f25136ca, (Object) aVar.f25136ca)) {
            z = true;
        }
        return z;
    }

    public String fullClassName() {
        return "com.tencent.qqpim.discovery.internal.protocol.AdReportItem";
    }

    /* renamed from: g */
    public void mo36629g(long j) {
        this.timeStamp = j;
    }

    public byte[] getContext() {
        return this.context;
    }

    public int getPhase() {
        return this.f25133W;
    }

    public int getPositionId() {
        return this.positionId;
    }

    public int getStatus() {
        return this.status;
    }

    public long getTimeStamp() {
        return this.timeStamp;
    }

    /* renamed from: h */
    public void mo36635h(int i) {
        this.f25133W = i;
    }

    public int hashCode() {
        try {
            throw new Exception("Need define key first!");
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    /* renamed from: i */
    public void mo36637i(int i) {
        this.f25134aa = i;
    }

    /* renamed from: j */
    public void mo36638j(int i) {
        this.positionId = i;
    }

    public void readFrom(JceInputStream jceInputStream) {
        this.f25133W = jceInputStream.read(this.f25133W, 0, false);
        this.context = jceInputStream.read(cache_context, 1, false);
        this.positionId = jceInputStream.read(this.positionId, 2, false);
        this.timeStamp = jceInputStream.read(this.timeStamp, 3, false);
        this.status = jceInputStream.read(this.status, 4, false);
        this.f25134aa = jceInputStream.read(this.f25134aa, 5, false);
        this.f25135ba = (C7500I) jceInputStream.read((JceStruct) f25131S, 6, false);
        this.f25136ca = (C7522v) jceInputStream.read((JceStruct) f25132U, 7, false);
    }

    public void setStatus(int i) {
        this.status = i;
    }

    /* renamed from: w */
    public int mo36640w() {
        return this.f25134aa;
    }

    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.f25133W, 0);
        byte[] bArr = this.context;
        if (bArr != null) {
            jceOutputStream.write(bArr, 1);
        }
        jceOutputStream.write(this.positionId, 2);
        jceOutputStream.write(this.timeStamp, 3);
        jceOutputStream.write(this.status, 4);
        jceOutputStream.write(this.f25134aa, 5);
        C7500I i = this.f25135ba;
        if (i != null) {
            jceOutputStream.write((JceStruct) i, 6);
        }
        C7522v vVar = this.f25136ca;
        if (vVar != null) {
            jceOutputStream.write((JceStruct) vVar, 7);
        }
    }

    /* renamed from: x */
    public C7522v mo36641x() {
        return this.f25136ca;
    }

    /* renamed from: y */
    public C7500I mo36642y() {
        return this.f25135ba;
    }
}
