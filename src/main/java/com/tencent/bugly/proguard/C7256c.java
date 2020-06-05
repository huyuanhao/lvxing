package com.tencent.bugly.proguard;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* compiled from: BUGLY */
/* renamed from: com.tencent.bugly.proguard.c */
class C7256c {
    /* renamed from: a */
    protected HashMap<String, HashMap<String, byte[]>> f24553a = new HashMap<>();
    /* renamed from: b */
    protected HashMap<String, Object> f24554b = new HashMap<>();
    /* renamed from: c */
    protected String f24555c = "GBK";
    /* renamed from: d */
    C7264k f24556d = new C7264k();
    /* renamed from: e */
    private HashMap<String, Object> f24557e = new HashMap<>();

    C7256c() {
    }

    /* renamed from: a */
    public void mo34866a(String str) {
        this.f24555c = str;
    }

    /* renamed from: a */
    public <T> void mo34867a(String str, T t) {
        if (str == null) {
            throw new IllegalArgumentException("put key can not is null");
        } else if (t == null) {
            throw new IllegalArgumentException("put value can not is null");
        } else if (!(t instanceof Set)) {
            C7266l lVar = new C7266l();
            lVar.mo34924a(this.f24555c);
            lVar.mo34933a((Object) t, 0);
            byte[] a = C7268n.m31405a(lVar.mo34925a());
            HashMap hashMap = new HashMap(1);
            ArrayList arrayList = new ArrayList(1);
            m31293a(arrayList, (Object) t);
            hashMap.put(C7205a.m31016a(arrayList), a);
            this.f24557e.remove(str);
            this.f24553a.put(str, hashMap);
        } else {
            throw new IllegalArgumentException("can not support Set");
        }
    }

    /* renamed from: a */
    private void m31293a(ArrayList<String> arrayList, Object obj) {
        String str = "java.util.List";
        String str2 = "?";
        if (obj.getClass().isArray()) {
            if (!obj.getClass().getComponentType().toString().equals("byte")) {
                throw new IllegalArgumentException("only byte[] is supported");
            } else if (Array.getLength(obj) > 0) {
                arrayList.add(str);
                m31293a(arrayList, Array.get(obj, 0));
            } else {
                arrayList.add("Array");
                arrayList.add(str2);
            }
        } else if (obj instanceof Array) {
            throw new IllegalArgumentException("can not support Array, please use List");
        } else if (obj instanceof List) {
            arrayList.add(str);
            List list = (List) obj;
            if (list.size() > 0) {
                m31293a(arrayList, list.get(0));
            } else {
                arrayList.add(str2);
            }
        } else if (obj instanceof Map) {
            arrayList.add("java.util.Map");
            Map map = (Map) obj;
            if (map.size() > 0) {
                Object next = map.keySet().iterator().next();
                Object obj2 = map.get(next);
                arrayList.add(next.getClass().getName());
                m31293a(arrayList, obj2);
                return;
            }
            arrayList.add(str2);
            arrayList.add(str2);
        } else {
            arrayList.add(obj.getClass().getName());
        }
    }

    /* renamed from: a */
    public byte[] mo34869a() {
        C7266l lVar = new C7266l(0);
        lVar.mo34924a(this.f24555c);
        lVar.mo34936a((Map<K, V>) this.f24553a, 0);
        return C7268n.m31405a(lVar.mo34925a());
    }

    /* renamed from: a */
    public void mo34868a(byte[] bArr) {
        this.f24556d.mo34913a(bArr);
        this.f24556d.mo34903a(this.f24555c);
        HashMap hashMap = new HashMap(1);
        HashMap hashMap2 = new HashMap(1);
        String str = "";
        hashMap2.put(str, new byte[0]);
        hashMap.put(str, hashMap2);
        this.f24553a = this.f24556d.mo34908a((Map<K, V>) hashMap, 0, false);
    }
}
