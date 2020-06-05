package com.alipay.p099a.p100a;

import com.alipay.p099a.p101b.C1394a;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import org.json.alipay.C8577b;

/* renamed from: com.alipay.a.a.h */
public final class C1389h implements C1390i, C1391j {
    /* renamed from: a */
    private static Map<Object, Object> m4051a(Type type) {
        while (type != Properties.class) {
            if (type == Hashtable.class) {
                return new Hashtable();
            }
            if (type == IdentityHashMap.class) {
                return new IdentityHashMap();
            }
            if (type == SortedMap.class || type == TreeMap.class) {
                return new TreeMap();
            }
            if (type == ConcurrentMap.class || type == ConcurrentHashMap.class) {
                return new ConcurrentHashMap();
            }
            if (type == Map.class || type == HashMap.class) {
                return new HashMap();
            }
            if (type == LinkedHashMap.class) {
                return new LinkedHashMap();
            }
            if (type instanceof ParameterizedType) {
                type = ((ParameterizedType) type).getRawType();
            } else {
                Class cls = (Class) type;
                String str = "unsupport type ";
                if (!cls.isInterface()) {
                    try {
                        return (Map) cls.newInstance();
                    } catch (Exception e) {
                        StringBuilder sb = new StringBuilder(str);
                        sb.append(type);
                        throw new IllegalArgumentException(sb.toString(), e);
                    }
                } else {
                    StringBuilder sb2 = new StringBuilder(str);
                    sb2.append(type);
                    throw new IllegalArgumentException(sb2.toString());
                }
            }
        }
        return new Properties();
    }

    /* renamed from: a */
    public final Object mo11907a(Object obj) {
        TreeMap treeMap = new TreeMap();
        for (Entry entry : ((Map) obj).entrySet()) {
            if (entry.getKey() instanceof String) {
                treeMap.put((String) entry.getKey(), C1387f.m4047b(entry.getValue()));
            } else {
                throw new IllegalArgumentException("Map key must be String!");
            }
        }
        return treeMap;
    }

    /* renamed from: a */
    public final Object mo11908a(Object obj, Type type) {
        if (!obj.getClass().equals(C8577b.class)) {
            return null;
        }
        C8577b bVar = (C8577b) obj;
        Map a = m4051a(type);
        if (type instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) type;
            Type type2 = parameterizedType.getActualTypeArguments()[0];
            Type type3 = parameterizedType.getActualTypeArguments()[1];
            if (String.class == type2) {
                Iterator a2 = bVar.mo41009a();
                while (a2.hasNext()) {
                    String str = (String) a2.next();
                    a.put(str, C1394a.m4065a((Class) type3) ? bVar.mo41008a(str) : C1386e.m4044a(bVar.mo41008a(str), type3));
                }
                return a;
            }
            throw new IllegalArgumentException("Deserialize Map Key must be String.class");
        }
        throw new IllegalArgumentException("Deserialize Map must be Generics!");
    }

    /* renamed from: a */
    public final boolean mo11909a(Class<?> cls) {
        return Map.class.isAssignableFrom(cls);
    }
}
