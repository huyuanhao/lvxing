package com.bytedance.sdk.adnet.core;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

/* renamed from: com.bytedance.sdk.adnet.core.l */
public class NetworkResponse {
    /* renamed from: a */
    public final int f6274a;
    /* renamed from: b */
    public final byte[] f6275b;
    /* renamed from: c */
    public final Map<String, String> f6276c;
    /* renamed from: d */
    public final List<C1969a> f6277d;
    /* renamed from: e */
    public final boolean f6278e;
    /* renamed from: f */
    public final long f6279f;

    @Deprecated
    public NetworkResponse(int i, byte[] bArr, Map<String, String> map, boolean z, long j) {
        this(i, bArr, map, m7892a(map), z, j);
    }

    public NetworkResponse(int i, byte[] bArr, boolean z, long j, List<C1969a> list) {
        this(i, bArr, m7893a(list), list, z, j);
    }

    @Deprecated
    public NetworkResponse(byte[] bArr, Map<String, String> map) {
        this(200, bArr, map, false, 0);
    }

    private NetworkResponse(int i, byte[] bArr, Map<String, String> map, List<C1969a> list, boolean z, long j) {
        this.f6274a = i;
        this.f6275b = bArr;
        this.f6276c = map;
        if (list == null) {
            this.f6277d = null;
        } else {
            this.f6277d = Collections.unmodifiableList(list);
        }
        this.f6278e = z;
        this.f6279f = j;
    }

    /* renamed from: a */
    private static Map<String, String> m7893a(List<C1969a> list) {
        if (list == null) {
            return null;
        }
        if (list.isEmpty()) {
            return Collections.emptyMap();
        }
        TreeMap treeMap = new TreeMap(String.CASE_INSENSITIVE_ORDER);
        for (C1969a aVar : list) {
            treeMap.put(aVar.mo14306a(), aVar.mo14307b());
        }
        return treeMap;
    }

    /* renamed from: a */
    private static List<C1969a> m7892a(Map<String, String> map) {
        if (map == null) {
            return null;
        }
        if (map.isEmpty()) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList(map.size());
        for (Entry entry : map.entrySet()) {
            arrayList.add(new C1969a((String) entry.getKey(), (String) entry.getValue()));
        }
        return arrayList;
    }
}
