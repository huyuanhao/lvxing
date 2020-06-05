package com.tencent.bugly.proguard;

import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map;

/* compiled from: BUGLY */
/* renamed from: com.tencent.bugly.proguard.e */
public class C7258e extends C7257d {
    /* renamed from: h */
    static HashMap<String, byte[]> f24561h;
    /* renamed from: i */
    static HashMap<String, HashMap<String, byte[]>> f24562i;
    /* renamed from: g */
    protected C7260g f24563g = new C7260g();
    /* renamed from: j */
    private int f24564j = 0;

    /* renamed from: a */
    public <T> void mo34867a(String str, T t) {
        if (!str.startsWith(".")) {
            super.mo34867a(str, t);
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("put name can not startwith . , now is ");
        sb.append(str);
        throw new IllegalArgumentException(sb.toString());
    }

    /* renamed from: b */
    public void mo34871b() {
        super.mo34871b();
        this.f24563g.f24570a = 3;
    }

    /* renamed from: a */
    public byte[] mo34869a() {
        String str = "";
        if (this.f24563g.f24570a != 2) {
            if (this.f24563g.f24574e == null) {
                this.f24563g.f24574e = str;
            }
            if (this.f24563g.f24575f == null) {
                this.f24563g.f24575f = str;
            }
        } else if (this.f24563g.f24574e.equals(str)) {
            throw new IllegalArgumentException("servantName can not is null");
        } else if (this.f24563g.f24575f.equals(str)) {
            throw new IllegalArgumentException("funcName can not is null");
        }
        C7266l lVar = new C7266l(0);
        lVar.mo34924a(this.f24555c);
        if (this.f24563g.f24570a == 2) {
            lVar.mo34936a((Map<K, V>) this.f24553a, 0);
        } else {
            lVar.mo34936a((Map<K, V>) this.f24558e, 0);
        }
        this.f24563g.f24576g = C7268n.m31405a(lVar.mo34925a());
        C7266l lVar2 = new C7266l(0);
        lVar2.mo34924a(this.f24555c);
        mo34874a(lVar2);
        byte[] a = C7268n.m31405a(lVar2.mo34925a());
        int length = a.length + 4;
        ByteBuffer allocate = ByteBuffer.allocate(length);
        allocate.putInt(length).put(a).flip();
        return allocate.array();
    }

    /* renamed from: a */
    public void mo34868a(byte[] bArr) {
        if (bArr.length >= 4) {
            try {
                C7264k kVar = new C7264k(bArr, 4);
                kVar.mo34903a(this.f24555c);
                mo34873a(kVar);
                String str = "";
                if (this.f24563g.f24570a == 3) {
                    C7264k kVar2 = new C7264k(this.f24563g.f24576g);
                    kVar2.mo34903a(this.f24555c);
                    if (f24561h == null) {
                        f24561h = new HashMap<>();
                        f24561h.put(str, new byte[0]);
                    }
                    this.f24558e = kVar2.mo34908a((Map<K, V>) f24561h, 0, false);
                    return;
                }
                C7264k kVar3 = new C7264k(this.f24563g.f24576g);
                kVar3.mo34903a(this.f24555c);
                if (f24562i == null) {
                    f24562i = new HashMap<>();
                    HashMap hashMap = new HashMap();
                    hashMap.put(str, new byte[0]);
                    f24562i.put(str, hashMap);
                }
                this.f24553a = kVar3.mo34908a((Map<K, V>) f24562i, 0, false);
                this.f24554b = new HashMap();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        } else {
            throw new IllegalArgumentException("decode package must include size head");
        }
    }

    /* renamed from: b */
    public void mo34875b(String str) {
        this.f24563g.f24574e = str;
    }

    /* renamed from: c */
    public void mo34876c(String str) {
        this.f24563g.f24575f = str;
    }

    /* renamed from: a */
    public void mo34872a(int i) {
        this.f24563g.f24573d = i;
    }

    /* renamed from: a */
    public void mo34874a(C7266l lVar) {
        this.f24563g.mo34761a(lVar);
    }

    /* renamed from: a */
    public void mo34873a(C7264k kVar) {
        this.f24563g.mo34760a(kVar);
    }
}
