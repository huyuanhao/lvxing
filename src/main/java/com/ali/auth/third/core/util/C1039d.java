package com.ali.auth.third.core.util;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.ali.auth.third.core.util.d */
public class C1039d {
    /* renamed from: a */
    public static Integer m1989a(JSONObject jSONObject, String str) {
        if (jSONObject.has(str)) {
            return Integer.valueOf(jSONObject.optInt(str));
        }
        return null;
    }

    /* renamed from: a */
    public static <T> T m1990a(JSONObject jSONObject, Class<T> cls) {
        Field[] fields;
        char c;
        Object obj;
        if (jSONObject == null || cls == null || cls == Void.TYPE) {
            return null;
        }
        try {
            T newInstance = cls.newInstance();
            for (Field field : cls.getFields()) {
                Class<Double> type = field.getType();
                String name = field.getName();
                if (jSONObject.has(name)) {
                    if (!type.isPrimitive()) {
                        if (type == String.class) {
                            obj = jSONObject.getString(name);
                        } else {
                            if (!(type == Boolean.class || type == Integer.class || type == Short.class || type == Long.class)) {
                                if (type != Double.class) {
                                    obj = type.isArray() ? m1997a(jSONObject.getJSONArray(name), type.getComponentType()) : Map.class.isAssignableFrom(type) ? m1993a(jSONObject.getJSONObject(name)) : m1990a(jSONObject.getJSONObject(name), type);
                                }
                            }
                            obj = jSONObject.get(name);
                        }
                        field.set(newInstance, obj);
                    } else if (type == Boolean.TYPE) {
                        field.setBoolean(newInstance, jSONObject.getBoolean(name));
                    } else if (type == Byte.TYPE) {
                        field.setByte(newInstance, (byte) jSONObject.getInt(name));
                    } else if (type == Character.TYPE) {
                        String string = jSONObject.getString(name);
                        if (string != null) {
                            if (string.length() != 0) {
                                c = string.charAt(0);
                                field.setChar(newInstance, c);
                            }
                        }
                        c = 0;
                        field.setChar(newInstance, c);
                    } else if (type == Short.TYPE) {
                        field.setShort(newInstance, (short) jSONObject.getInt(name));
                    } else if (type == Integer.TYPE) {
                        field.setInt(newInstance, jSONObject.getInt(name));
                    } else if (type == Long.TYPE) {
                        field.setLong(newInstance, jSONObject.getLong(name));
                    } else if (type == Float.TYPE) {
                        field.setFloat(newInstance, (float) jSONObject.getDouble(name));
                    } else if (type == Double.TYPE) {
                        field.setDouble(newInstance, jSONObject.getDouble(name));
                    }
                }
            }
            return newInstance;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /* renamed from: a */
    public static List<Object> m1991a(JSONArray jSONArray) throws JSONException {
        if (jSONArray == null) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList(jSONArray.length());
        int i = 0;
        int length = jSONArray.length();
        while (i < length) {
            Object obj = jSONArray.get(i);
            Object obj2 = obj instanceof JSONObject ? m1993a((JSONObject) obj) : obj instanceof JSONArray ? m1991a((JSONArray) obj) : jSONArray.get(i);
            arrayList.add(obj2);
            i++;
        }
        return arrayList;
    }

    /* renamed from: a */
    public static Map<String, Object> m1992a(Map<String, Object> map, JSONObject jSONObject) throws JSONException {
        if (map == null) {
            map = new HashMap<>();
        }
        if (jSONObject == null) {
            return map;
        }
        Iterator keys = jSONObject.keys();
        while (keys.hasNext()) {
            String str = (String) keys.next();
            Object opt = jSONObject.opt(str);
            if (opt instanceof JSONObject) {
                opt = m1993a((JSONObject) opt);
            } else if (opt instanceof JSONArray) {
                opt = m1991a((JSONArray) opt);
            }
            map.put(str, opt);
        }
        return map;
    }

    /* renamed from: a */
    public static Map<String, Object> m1993a(JSONObject jSONObject) throws JSONException {
        return m1992a(null, jSONObject);
    }

    /* renamed from: a */
    public static JSONArray m1994a(List<Object> list) {
        JSONArray jSONArray = new JSONArray();
        for (Object next : list) {
            if (next instanceof Map) {
                next = m1996a((Map) next);
            }
            jSONArray.put(next);
        }
        return jSONArray;
    }

    /* renamed from: a */
    public static JSONArray m1995a(Object[] objArr) {
        JSONArray jSONArray = new JSONArray();
        for (JSONObject jSONObject : objArr) {
            if (jSONObject instanceof Map) {
                jSONObject = m1996a((Map) jSONObject);
            }
            jSONArray.put(jSONObject);
        }
        return jSONArray;
    }

    /* renamed from: a */
    public static JSONObject m1996a(Map<String, ? extends Object> map) {
        String str;
        JSONObject jSONObject = new JSONObject();
        try {
            for (Entry entry : map.entrySet()) {
                Object value = entry.getValue();
                if (value != null) {
                    if (value instanceof Map) {
                        str = (String) entry.getKey();
                        value = m1996a((Map) value);
                    } else if (value instanceof List) {
                        str = (String) entry.getKey();
                        value = m1994a((List) value);
                    } else if (value.getClass().isArray()) {
                        str = (String) entry.getKey();
                        value = m1995a((Object[]) value);
                    } else {
                        str = (String) entry.getKey();
                    }
                    jSONObject.put(str, value);
                }
            }
            return jSONObject;
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    /* renamed from: a */
    public static <T> T[] m1997a(JSONArray jSONArray, Class<T> cls) {
        char c;
        Object obj;
        if (jSONArray == null || cls == null || cls == Void.TYPE) {
            return null;
        }
        Object newInstance = Array.newInstance(cls, jSONArray.length());
        int i = 0;
        while (i < jSONArray.length()) {
            try {
                if (!cls.isPrimitive()) {
                    if (cls == String.class) {
                        obj = jSONArray.getString(i);
                    } else {
                        if (!(cls == Boolean.class || cls == Integer.class || cls == Short.class || cls == Long.class)) {
                            if (cls != Double.class) {
                                obj = cls.isArray() ? m1997a(jSONArray.getJSONArray(i), cls.getComponentType()) : Map.class.isAssignableFrom(cls) ? m1993a(jSONArray.getJSONObject(i)) : m1990a(jSONArray.getJSONObject(i), cls);
                            }
                        }
                        obj = jSONArray.get(i);
                    }
                    Array.set(newInstance, i, obj);
                } else if (cls == Boolean.TYPE) {
                    Array.setBoolean(newInstance, i, jSONArray.getBoolean(i));
                } else if (cls == Byte.TYPE) {
                    Array.setByte(newInstance, i, (byte) jSONArray.getInt(i));
                } else if (cls == Character.TYPE) {
                    String string = jSONArray.getString(i);
                    if (string != null) {
                        if (string.length() != 0) {
                            c = string.charAt(0);
                            Array.setChar(newInstance, i, c);
                        }
                    }
                    c = 0;
                    Array.setChar(newInstance, i, c);
                } else if (cls == Short.TYPE) {
                    Array.setShort(newInstance, i, (short) jSONArray.getInt(i));
                } else if (cls == Integer.TYPE) {
                    Array.setInt(newInstance, i, jSONArray.getInt(i));
                } else if (cls == Long.TYPE) {
                    Array.setLong(newInstance, i, jSONArray.getLong(i));
                } else if (cls == Float.TYPE) {
                    Array.setFloat(newInstance, i, (float) jSONArray.getDouble(i));
                } else if (cls == Double.TYPE) {
                    Array.setDouble(newInstance, i, jSONArray.getDouble(i));
                }
                i++;
            } catch (JSONException e) {
                throw new RuntimeException(e);
            }
        }
        return (Object[]) newInstance;
    }

    /* renamed from: b */
    public static String m1998b(JSONObject jSONObject, String str) {
        if (jSONObject.has(str)) {
            return jSONObject.optString(str);
        }
        return null;
    }

    /* renamed from: c */
    public static Long m1999c(JSONObject jSONObject, String str) {
        if (jSONObject.has(str)) {
            return Long.valueOf(jSONObject.optLong(str));
        }
        return null;
    }
}
