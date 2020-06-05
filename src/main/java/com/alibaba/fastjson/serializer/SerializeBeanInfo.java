package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.annotation.JSONType;
import com.alibaba.fastjson.util.FieldInfo;

/* renamed from: com.alibaba.fastjson.serializer.aw */
public class SerializeBeanInfo {
    /* renamed from: a */
    protected final Class<?> f2875a;
    /* renamed from: b */
    protected final String f2876b;
    /* renamed from: c */
    protected final String f2877c;
    /* renamed from: d */
    protected final JSONType f2878d;
    /* renamed from: e */
    protected final FieldInfo[] f2879e;
    /* renamed from: f */
    protected final FieldInfo[] f2880f;
    /* renamed from: g */
    protected int f2881g;

    public SerializeBeanInfo(Class<?> cls, JSONType jSONType, String str, String str2, int i, FieldInfo[] cVarArr, FieldInfo[] cVarArr2) {
        this.f2875a = cls;
        this.f2878d = jSONType;
        this.f2876b = str;
        this.f2877c = str2;
        this.f2881g = i;
        this.f2879e = cVarArr;
        this.f2880f = cVarArr2;
    }
}
