package com.alibaba.fastjson.parser.p066a;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.util.TypeUtils;
import java.lang.reflect.Array;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/* renamed from: com.alibaba.fastjson.parser.a.x */
public final class ResolveFieldDeserializer extends FieldDeserializer {
    /* renamed from: a */
    private final int f2760a;
    /* renamed from: d */
    private final List f2761d;
    /* renamed from: e */
    private final DefaultJSONParser f2762e;
    /* renamed from: f */
    private final Object f2763f;
    /* renamed from: g */
    private final Map f2764g;
    /* renamed from: h */
    private final Collection f2765h;

    /* renamed from: a */
    public void mo11166a(DefaultJSONParser aVar, Object obj, Type type, Map<String, Object> map) {
    }

    public ResolveFieldDeserializer(DefaultJSONParser aVar, List list, int i) {
        super(null, null);
        this.f2762e = aVar;
        this.f2760a = i;
        this.f2761d = list;
        this.f2763f = null;
        this.f2764g = null;
        this.f2765h = null;
    }

    public ResolveFieldDeserializer(Map map, Object obj) {
        super(null, null);
        this.f2762e = null;
        this.f2760a = -1;
        this.f2761d = null;
        this.f2763f = obj;
        this.f2764g = map;
        this.f2765h = null;
    }

    public ResolveFieldDeserializer(Collection collection) {
        super(null, null);
        this.f2762e = null;
        this.f2760a = -1;
        this.f2761d = null;
        this.f2763f = null;
        this.f2764g = null;
        this.f2765h = collection;
    }

    /* renamed from: a */
    public void mo11177a(Object obj, Object obj2) {
        Map map = this.f2764g;
        if (map != null) {
            map.put(this.f2763f, obj2);
            return;
        }
        Collection collection = this.f2765h;
        if (collection != null) {
            collection.add(obj2);
            return;
        }
        this.f2761d.set(this.f2760a, obj2);
        List list = this.f2761d;
        if (list instanceof JSONArray) {
            JSONArray jSONArray = (JSONArray) list;
            Object relatedArray = jSONArray.getRelatedArray();
            if (relatedArray != null && Array.getLength(relatedArray) > this.f2760a) {
                if (jSONArray.getComponentType() != null) {
                    obj2 = TypeUtils.m3224a(obj2, jSONArray.getComponentType(), this.f2762e.mo11146d());
                }
                Array.set(relatedArray, this.f2760a, obj2);
            }
        }
    }
}
