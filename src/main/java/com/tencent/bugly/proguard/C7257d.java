package com.tencent.bugly.proguard;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/* compiled from: BUGLY */
/* renamed from: com.tencent.bugly.proguard.d */
public class C7257d extends C7256c {
    /* renamed from: e */
    protected HashMap<String, byte[]> f24558e = null;
    /* renamed from: f */
    C7264k f24559f = new C7264k();
    /* renamed from: g */
    private HashMap<String, Object> f24560g = new HashMap<>();

    /* renamed from: a */
    public /* bridge */ /* synthetic */ void mo34866a(String str) {
        super.mo34866a(str);
    }

    /* renamed from: b */
    public void mo34871b() {
        this.f24558e = new HashMap<>();
    }

    /* renamed from: a */
    public <T> void mo34867a(String str, T t) {
        if (this.f24558e == null) {
            super.mo34867a(str, t);
        } else if (str == null) {
            throw new IllegalArgumentException("put key can not is null");
        } else if (t == null) {
            throw new IllegalArgumentException("put value can not is null");
        } else if (!(t instanceof Set)) {
            C7266l lVar = new C7266l();
            lVar.mo34924a(this.f24555c);
            lVar.mo34933a((Object) t, 0);
            this.f24558e.put(str, C7268n.m31405a(lVar.mo34925a()));
        } else {
            throw new IllegalArgumentException("can not support Set");
        }
    }

    /* renamed from: b */
    public <T> T mo34870b(String str, T t) throws C7242b {
        HashMap<String, byte[]> hashMap = this.f24558e;
        if (hashMap != null) {
            if (!hashMap.containsKey(str)) {
                return null;
            }
            if (this.f24560g.containsKey(str)) {
                return this.f24560g.get(str);
            }
            try {
                T a = m31298a((byte[]) this.f24558e.get(str), (Object) t);
                if (a != null) {
                    m31299c(str, a);
                }
                return a;
            } catch (Exception e) {
                throw new C7242b(e);
            }
        } else if (!this.f24553a.containsKey(str)) {
            return null;
        } else {
            if (this.f24560g.containsKey(str)) {
                return this.f24560g.get(str);
            }
            byte[] bArr = new byte[0];
            Iterator it = ((HashMap) this.f24553a.get(str)).entrySet().iterator();
            if (it.hasNext()) {
                Entry entry = (Entry) it.next();
                String str2 = (String) entry.getKey();
                bArr = (byte[]) entry.getValue();
            }
            try {
                this.f24559f.mo34913a(bArr);
                this.f24559f.mo34903a(this.f24555c);
                T a2 = this.f24559f.mo34906a(t, 0, true);
                m31299c(str, a2);
                return a2;
            } catch (Exception e2) {
                throw new C7242b(e2);
            }
        }
    }

    /* renamed from: a */
    private Object m31298a(byte[] bArr, Object obj) {
        this.f24559f.mo34913a(bArr);
        this.f24559f.mo34903a(this.f24555c);
        return this.f24559f.mo34906a(obj, 0, true);
    }

    /* renamed from: c */
    private void m31299c(String str, Object obj) {
        this.f24560g.put(str, obj);
    }

    /* renamed from: a */
    public byte[] mo34869a() {
        if (this.f24558e == null) {
            return super.mo34869a();
        }
        C7266l lVar = new C7266l(0);
        lVar.mo34924a(this.f24555c);
        lVar.mo34936a((Map<K, V>) this.f24558e, 0);
        return C7268n.m31405a(lVar.mo34925a());
    }

    /* renamed from: a */
    public void mo34868a(byte[] bArr) {
        try {
            super.mo34868a(bArr);
        } catch (Exception unused) {
            this.f24559f.mo34913a(bArr);
            this.f24559f.mo34903a(this.f24555c);
            HashMap hashMap = new HashMap(1);
            hashMap.put("", new byte[0]);
            this.f24558e = this.f24559f.mo34908a((Map<K, V>) hashMap, 0, false);
        }
    }
}
