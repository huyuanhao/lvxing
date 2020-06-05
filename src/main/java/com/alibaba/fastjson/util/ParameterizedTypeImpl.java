package com.alibaba.fastjson.util;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Arrays;

/* renamed from: com.alibaba.fastjson.util.g */
public class ParameterizedTypeImpl implements ParameterizedType {
    /* renamed from: a */
    private final Type[] f3052a;
    /* renamed from: b */
    private final Type f3053b;
    /* renamed from: c */
    private final Type f3054c;

    public ParameterizedTypeImpl(Type[] typeArr, Type type, Type type2) {
        this.f3052a = typeArr;
        this.f3053b = type;
        this.f3054c = type2;
    }

    public Type[] getActualTypeArguments() {
        return this.f3052a;
    }

    public Type getOwnerType() {
        return this.f3053b;
    }

    public Type getRawType() {
        return this.f3054c;
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        ParameterizedTypeImpl gVar = (ParameterizedTypeImpl) obj;
        if (!Arrays.equals(this.f3052a, gVar.f3052a)) {
            return false;
        }
        Type type = this.f3053b;
        if (type == null ? gVar.f3053b != null : !type.equals(gVar.f3053b)) {
            return false;
        }
        Type type2 = this.f3054c;
        Type type3 = gVar.f3054c;
        if (type2 != null) {
            z = type2.equals(type3);
        } else if (type3 != null) {
            z = false;
        }
        return z;
    }

    public int hashCode() {
        Type[] typeArr = this.f3052a;
        int i = 0;
        int hashCode = (typeArr != null ? Arrays.hashCode(typeArr) : 0) * 31;
        Type type = this.f3053b;
        int hashCode2 = (hashCode + (type != null ? type.hashCode() : 0)) * 31;
        Type type2 = this.f3054c;
        if (type2 != null) {
            i = type2.hashCode();
        }
        return hashCode2 + i;
    }
}
