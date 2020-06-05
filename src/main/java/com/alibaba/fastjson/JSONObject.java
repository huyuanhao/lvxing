package com.alibaba.fastjson;

import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.parser.ParserConfig;
import com.alibaba.fastjson.util.TypeUtils;
import java.io.Serializable;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class JSONObject extends JSON implements Serializable, Cloneable, InvocationHandler, Map<String, Object> {
    private static final int DEFAULT_INITIAL_CAPACITY = 16;
    private static final long serialVersionUID = 1;
    private final Map<String, Object> map;

    public JSONObject() {
        this(16, false);
    }

    public JSONObject(Map<String, Object> map2) {
        this.map = map2;
    }

    public JSONObject(boolean z) {
        this(16, z);
    }

    public JSONObject(int i) {
        this(i, false);
    }

    public JSONObject(int i, boolean z) {
        if (z) {
            this.map = new LinkedHashMap(i);
        } else {
            this.map = new HashMap(i);
        }
    }

    public int size() {
        return this.map.size();
    }

    public boolean isEmpty() {
        return this.map.isEmpty();
    }

    public boolean containsKey(Object obj) {
        return this.map.containsKey(obj);
    }

    public boolean containsValue(Object obj) {
        return this.map.containsValue(obj);
    }

    public Object get(Object obj) {
        Object obj2 = this.map.get(obj);
        return (obj2 != null || !(obj instanceof Number)) ? obj2 : this.map.get(obj.toString());
    }

    public JSONObject getJSONObject(String str) {
        Object obj = this.map.get(str);
        if (obj instanceof JSONObject) {
            return (JSONObject) obj;
        }
        if (obj instanceof String) {
            return JSON.parseObject((String) obj);
        }
        return (JSONObject) toJSON(obj);
    }

    public JSONArray getJSONArray(String str) {
        Object obj = this.map.get(str);
        if (obj instanceof JSONArray) {
            return (JSONArray) obj;
        }
        if (obj instanceof String) {
            return (JSONArray) JSON.parse((String) obj);
        }
        return (JSONArray) toJSON(obj);
    }

    public <T> T getObject(String str, Class<T> cls) {
        return TypeUtils.m3221a(this.map.get(str), cls);
    }

    public <T> T getObject(String str, Type type) {
        return TypeUtils.m3224a(this.map.get(str), type, ParserConfig.m2904a());
    }

    public <T> T getObject(String str, TypeReference hVar) {
        T t = this.map.get(str);
        if (hVar == null) {
            return t;
        }
        return TypeUtils.m3224a((Object) t, hVar.mo11111a(), ParserConfig.m2904a());
    }

    public Boolean getBoolean(String str) {
        Object obj = get(str);
        if (obj == null) {
            return null;
        }
        return TypeUtils.m3276o(obj);
    }

    public byte[] getBytes(String str) {
        Object obj = get(str);
        if (obj == null) {
            return null;
        }
        return TypeUtils.m3275n(obj);
    }

    public boolean getBooleanValue(String str) {
        Boolean o = TypeUtils.m3276o(get(str));
        if (o == null) {
            return false;
        }
        return o.booleanValue();
    }

    public Byte getByte(String str) {
        return TypeUtils.m3243b(get(str));
    }

    public byte getByteValue(String str) {
        Byte b = TypeUtils.m3243b(get(str));
        if (b == null) {
            return 0;
        }
        return b.byteValue();
    }

    public Short getShort(String str) {
        return TypeUtils.m3256d(get(str));
    }

    public short getShortValue(String str) {
        Short d = TypeUtils.m3256d(get(str));
        if (d == null) {
            return 0;
        }
        return d.shortValue();
    }

    public Integer getInteger(String str) {
        return TypeUtils.m3274m(get(str));
    }

    public int getIntValue(String str) {
        Integer m = TypeUtils.m3274m(get(str));
        if (m == null) {
            return 0;
        }
        return m.intValue();
    }

    public Long getLong(String str) {
        return TypeUtils.m3273l(get(str));
    }

    public long getLongValue(String str) {
        Long l = TypeUtils.m3273l(get(str));
        if (l == null) {
            return 0;
        }
        return l.longValue();
    }

    public Float getFloat(String str) {
        return TypeUtils.m3266g(get(str));
    }

    public float getFloatValue(String str) {
        Float g = TypeUtils.m3266g(get(str));
        if (g == null) {
            return 0.0f;
        }
        return g.floatValue();
    }

    public Double getDouble(String str) {
        return TypeUtils.m3269h(get(str));
    }

    public double getDoubleValue(String str) {
        Double h = TypeUtils.m3269h(get(str));
        if (h == null) {
            return 0.0d;
        }
        return h.doubleValue();
    }

    public BigDecimal getBigDecimal(String str) {
        return TypeUtils.m3260e(get(str));
    }

    public BigInteger getBigInteger(String str) {
        return TypeUtils.m3264f(get(str));
    }

    public String getString(String str) {
        Object obj = get(str);
        if (obj == null) {
            return null;
        }
        return obj.toString();
    }

    public Date getDate(String str) {
        return TypeUtils.m3270i(get(str));
    }

    public java.sql.Date getSqlDate(String str) {
        return TypeUtils.m3271j(get(str));
    }

    public Timestamp getTimestamp(String str) {
        return TypeUtils.m3272k(get(str));
    }

    public Object put(String str, Object obj) {
        return this.map.put(str, obj);
    }

    public JSONObject fluentPut(String str, Object obj) {
        this.map.put(str, obj);
        return this;
    }

    public void putAll(Map<? extends String, ? extends Object> map2) {
        this.map.putAll(map2);
    }

    public JSONObject fluentPutAll(Map<? extends String, ? extends Object> map2) {
        this.map.putAll(map2);
        return this;
    }

    public void clear() {
        this.map.clear();
    }

    public JSONObject fluentClear() {
        this.map.clear();
        return this;
    }

    public Object remove(Object obj) {
        return this.map.remove(obj);
    }

    public JSONObject fluentRemove(Object obj) {
        this.map.remove(obj);
        return this;
    }

    public Set<String> keySet() {
        return this.map.keySet();
    }

    public Collection<Object> values() {
        return this.map.values();
    }

    public Set<Entry<String, Object>> entrySet() {
        return this.map.entrySet();
    }

    public Object clone() {
        Map<String, Object> map2 = this.map;
        return new JSONObject(map2 instanceof LinkedHashMap ? new LinkedHashMap<>(map2) : new HashMap<>(map2));
    }

    public boolean equals(Object obj) {
        return this.map.equals(obj);
    }

    public int hashCode() {
        return this.map.hashCode();
    }

    public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
        Class[] parameterTypes = method.getParameterTypes();
        String str = null;
        if (parameterTypes.length == 1) {
            if (method.getName().equals("equals")) {
                return Boolean.valueOf(equals(objArr[0]));
            }
            String str2 = "illegal setter";
            if (method.getReturnType() == Void.TYPE) {
                JSONField jSONField = (JSONField) method.getAnnotation(JSONField.class);
                String name = (jSONField == null || jSONField.name().length() == 0) ? null : jSONField.name();
                if (name == null) {
                    String name2 = method.getName();
                    if (name2.startsWith("set")) {
                        String substring = name2.substring(3);
                        if (substring.length() != 0) {
                            StringBuilder sb = new StringBuilder();
                            sb.append(Character.toLowerCase(substring.charAt(0)));
                            sb.append(substring.substring(1));
                            name = sb.toString();
                        } else {
                            throw new JSONException(str2);
                        }
                    } else {
                        throw new JSONException(str2);
                    }
                }
                this.map.put(name, objArr[0]);
                return null;
            }
            throw new JSONException(str2);
        } else if (parameterTypes.length == 0) {
            String str3 = "illegal getter";
            if (method.getReturnType() != Void.TYPE) {
                JSONField jSONField2 = (JSONField) method.getAnnotation(JSONField.class);
                if (!(jSONField2 == null || jSONField2.name().length() == 0)) {
                    str = jSONField2.name();
                }
                if (str == null) {
                    String name3 = method.getName();
                    if (name3.startsWith("get")) {
                        String substring2 = name3.substring(3);
                        if (substring2.length() != 0) {
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append(Character.toLowerCase(substring2.charAt(0)));
                            sb2.append(substring2.substring(1));
                            str = sb2.toString();
                        } else {
                            throw new JSONException(str3);
                        }
                    } else if (name3.startsWith("is")) {
                        String substring3 = name3.substring(2);
                        if (substring3.length() != 0) {
                            StringBuilder sb3 = new StringBuilder();
                            sb3.append(Character.toLowerCase(substring3.charAt(0)));
                            sb3.append(substring3.substring(1));
                            str = sb3.toString();
                        } else {
                            throw new JSONException(str3);
                        }
                    } else if (name3.startsWith("hashCode")) {
                        return Integer.valueOf(hashCode());
                    } else {
                        if (name3.startsWith("toString")) {
                            return toString();
                        }
                        throw new JSONException(str3);
                    }
                }
                return TypeUtils.m3224a(this.map.get(str), method.getGenericReturnType(), ParserConfig.m2904a());
            }
            throw new JSONException(str3);
        } else {
            throw new UnsupportedOperationException(method.toGenericString());
        }
    }

    public Map<String, Object> getInnerMap() {
        return this.map;
    }
}
