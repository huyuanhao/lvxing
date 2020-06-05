package com.tencent.bugly.proguard;

import androidx.core.app.NotificationCompat;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;

/* compiled from: BUGLY */
/* renamed from: com.tencent.bugly.proguard.g */
public final class C7260g extends C7267m {
    /* renamed from: k */
    static byte[] f24567k = null;
    /* renamed from: l */
    static Map<String, String> f24568l = null;
    /* renamed from: m */
    static final /* synthetic */ boolean f24569m = (!C7260g.class.desiredAssertionStatus());
    /* renamed from: a */
    public short f24570a = 0;
    /* renamed from: b */
    public byte f24571b = 0;
    /* renamed from: c */
    public int f24572c = 0;
    /* renamed from: d */
    public int f24573d = 0;
    /* renamed from: e */
    public String f24574e = null;
    /* renamed from: f */
    public String f24575f = null;
    /* renamed from: g */
    public byte[] f24576g;
    /* renamed from: h */
    public int f24577h = 0;
    /* renamed from: i */
    public Map<String, String> f24578i;
    /* renamed from: j */
    public Map<String, String> f24579j;

    public boolean equals(Object obj) {
        C7260g gVar = (C7260g) obj;
        short s = gVar.f24570a;
        Integer valueOf = Integer.valueOf(1);
        return C7268n.m31401a(1, (int) s) && C7268n.m31401a(1, (int) gVar.f24571b) && C7268n.m31401a(1, gVar.f24572c) && C7268n.m31401a(1, gVar.f24573d) && C7268n.m31403a((Object) valueOf, (Object) gVar.f24574e) && C7268n.m31403a((Object) valueOf, (Object) gVar.f24575f) && C7268n.m31403a((Object) valueOf, (Object) gVar.f24576g) && C7268n.m31401a(1, gVar.f24577h) && C7268n.m31403a((Object) valueOf, (Object) gVar.f24578i) && C7268n.m31403a((Object) valueOf, (Object) gVar.f24579j);
    }

    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException unused) {
            if (f24569m) {
                return null;
            }
            throw new AssertionError();
        }
    }

    /* renamed from: a */
    public void mo34761a(C7266l lVar) {
        lVar.mo34937a(this.f24570a, 1);
        lVar.mo34946b(this.f24571b, 2);
        lVar.mo34930a(this.f24572c, 3);
        lVar.mo34930a(this.f24573d, 4);
        lVar.mo34934a(this.f24574e, 5);
        lVar.mo34934a(this.f24575f, 6);
        lVar.mo34939a(this.f24576g, 7);
        lVar.mo34930a(this.f24577h, 8);
        lVar.mo34936a(this.f24578i, 9);
        lVar.mo34936a(this.f24579j, 10);
    }

    /* renamed from: a */
    public void mo34760a(C7264k kVar) {
        try {
            this.f24570a = kVar.mo34910a(this.f24570a, 1, true);
            this.f24571b = kVar.mo34899a(this.f24571b, 2, true);
            this.f24572c = kVar.mo34902a(this.f24572c, 3, true);
            this.f24573d = kVar.mo34902a(this.f24573d, 4, true);
            this.f24574e = kVar.mo34907a(5, true);
            this.f24575f = kVar.mo34907a(6, true);
            if (f24567k == null) {
                f24567k = new byte[]{0};
            }
            this.f24576g = kVar.mo34916a(f24567k, 7, true);
            this.f24577h = kVar.mo34902a(this.f24577h, 8, true);
            String str = "";
            if (f24568l == null) {
                f24568l = new HashMap();
                f24568l.put(str, str);
            }
            this.f24578i = (Map) kVar.mo34906a(f24568l, 9, true);
            if (f24568l == null) {
                f24568l = new HashMap();
                f24568l.put(str, str);
            }
            this.f24579j = (Map) kVar.mo34906a(f24568l, 10, true);
        } catch (Exception e) {
            e.printStackTrace();
            PrintStream printStream = System.out;
            StringBuilder sb = new StringBuilder();
            sb.append("RequestPacket decode error ");
            sb.append(C7259f.m31315a(this.f24576g));
            printStream.println(sb.toString());
            throw new RuntimeException(e);
        }
    }

    /* renamed from: a */
    public void mo34762a(StringBuilder sb, int i) {
        C7262i iVar = new C7262i(sb, i);
        iVar.mo34890a(this.f24570a, "iVersion");
        iVar.mo34879a(this.f24571b, "cPacketType");
        iVar.mo34883a(this.f24572c, "iMessageType");
        iVar.mo34883a(this.f24573d, "iRequestId");
        iVar.mo34887a(this.f24574e, "sServantName");
        iVar.mo34887a(this.f24575f, "sFuncName");
        iVar.mo34892a(this.f24576g, "sBuffer");
        iVar.mo34883a(this.f24577h, "iTimeout");
        iVar.mo34889a(this.f24578i, "context");
        iVar.mo34889a(this.f24579j, NotificationCompat.CATEGORY_STATUS);
    }
}
