package com.alibaba.baichuan.trade.common.utils;

import android.text.TextUtils;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.alibaba.baichuan.trade.common.utils.c */
public class C1229c {
    /* JADX WARNING: type inference failed for: r5v6, types: [T, java.lang.Byte[]] */
    /* JADX WARNING: type inference failed for: r5v8, types: [java.lang.Character[], T] */
    /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r5v6, types: [T, java.lang.Byte[]]
  assigns: [java.lang.Byte[]]
  uses: [?[], T, ?[OBJECT, ARRAY][]]
	at jadx.core.dex.visitors.typeinference.TypeSearch.fillTypeCandidates(TypeSearch.java:231)
	at java.util.ArrayList.forEach(ArrayList.java:1249)
	at jadx.core.dex.visitors.typeinference.TypeSearch.run(TypeSearch.java:53)
	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runMultiVariableSearch(TypeInferenceVisitor.java:95)
	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:88)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:27)
	at jadx.core.dex.visitors.DepthTraversal.lambda$visit$1(DepthTraversal.java:14)
	at java.util.ArrayList.forEach(ArrayList.java:1249)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:30)
	at jadx.core.ProcessClass.lambda$processDependencies$0(ProcessClass.java:49)
	at java.util.ArrayList.forEach(ArrayList.java:1249)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:49)
	at jadx.core.ProcessClass.process(ProcessClass.java:35)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:290)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
 */
    /* JADX WARNING: Unknown variable types count: 2 */
    /* renamed from: a */
    public static <T> T m2417a(java.lang.String r4, java.lang.Class<T> r5) {
        /*
        r0 = 0
        if (r4 == 0) goto L_0x01a1
        if (r5 != 0) goto L_0x0007
        goto L_0x01a1
    L_0x0007:
        java.lang.Class<java.lang.String> r1 = java.lang.String.class
        boolean r1 = r1.equals(r5)
        if (r1 == 0) goto L_0x0010
        return r4
    L_0x0010:
        java.lang.Class r1 = java.lang.Short.TYPE
        boolean r1 = r1.equals(r5)
        if (r1 != 0) goto L_0x019c
        java.lang.Class<java.lang.Short> r1 = java.lang.Short.class
        boolean r1 = r1.equals(r5)
        if (r1 == 0) goto L_0x0022
        goto L_0x019c
    L_0x0022:
        java.lang.Class r1 = java.lang.Integer.TYPE
        boolean r1 = r1.equals(r5)
        if (r1 != 0) goto L_0x0197
        java.lang.Class<java.lang.Integer> r1 = java.lang.Integer.class
        boolean r1 = r1.equals(r5)
        if (r1 == 0) goto L_0x0034
        goto L_0x0197
    L_0x0034:
        java.lang.Class r1 = java.lang.Long.TYPE
        boolean r1 = r1.equals(r5)
        if (r1 != 0) goto L_0x0192
        java.lang.Class<java.lang.Long> r1 = java.lang.Long.class
        boolean r1 = r1.equals(r5)
        if (r1 == 0) goto L_0x0046
        goto L_0x0192
    L_0x0046:
        java.lang.Class r1 = java.lang.Boolean.TYPE
        boolean r1 = r1.equals(r5)
        if (r1 != 0) goto L_0x018d
        java.lang.Class<java.lang.Boolean> r1 = java.lang.Boolean.class
        boolean r1 = r1.equals(r5)
        if (r1 == 0) goto L_0x0058
        goto L_0x018d
    L_0x0058:
        java.lang.Class r1 = java.lang.Float.TYPE
        boolean r1 = r1.equals(r5)
        if (r1 != 0) goto L_0x0188
        java.lang.Class<java.lang.Float> r1 = java.lang.Float.class
        boolean r1 = r1.equals(r5)
        if (r1 == 0) goto L_0x006a
        goto L_0x0188
    L_0x006a:
        java.lang.Class r1 = java.lang.Double.TYPE
        boolean r1 = r1.equals(r5)
        if (r1 != 0) goto L_0x0183
        java.lang.Class<java.lang.Double> r1 = java.lang.Double.class
        boolean r1 = r1.equals(r5)
        if (r1 == 0) goto L_0x007c
        goto L_0x0183
    L_0x007c:
        java.lang.Class r1 = java.lang.Byte.TYPE
        boolean r1 = r1.equals(r5)
        if (r1 != 0) goto L_0x017e
        java.lang.Class<java.lang.Byte> r1 = java.lang.Byte.class
        boolean r1 = r1.equals(r5)
        if (r1 == 0) goto L_0x008e
        goto L_0x017e
    L_0x008e:
        java.lang.Class r1 = java.lang.Character.TYPE
        boolean r1 = r1.equals(r5)
        r2 = 0
        if (r1 != 0) goto L_0x0175
        java.lang.Class<java.lang.Character> r1 = java.lang.Character.class
        boolean r1 = r1.equals(r5)
        if (r1 == 0) goto L_0x00a1
        goto L_0x0175
    L_0x00a1:
        java.lang.Class<java.util.Date> r1 = java.util.Date.class
        boolean r1 = r1.isAssignableFrom(r5)
        if (r1 == 0) goto L_0x00c0
        java.text.SimpleDateFormat r5 = new java.text.SimpleDateFormat     // Catch:{ ParseException -> 0x00b7 }
        java.lang.String r0 = "yyyyMMddHHmmssSSSZ"
        java.util.Locale r1 = java.util.Locale.US     // Catch:{ ParseException -> 0x00b7 }
        r5.<init>(r0, r1)     // Catch:{ ParseException -> 0x00b7 }
        java.util.Date r4 = r5.parse(r4)     // Catch:{ ParseException -> 0x00b7 }
        return r4
    L_0x00b7:
        r4 = move-exception
        java.lang.RuntimeException r5 = new java.lang.RuntimeException
        java.lang.String r0 = "Parse Date error"
        r5.<init>(r0, r4)
        throw r5
    L_0x00c0:
        char r1 = r4.charAt(r2)
        boolean r3 = r5.isArray()
        if (r3 == 0) goto L_0x0149
        java.lang.Class r5 = r5.getComponentType()
        r3 = 91
        if (r1 != r3) goto L_0x00e3
        org.json.JSONArray r0 = new org.json.JSONArray     // Catch:{ Exception -> 0x00dc }
        r0.<init>(r4)     // Catch:{ Exception -> 0x00dc }
        java.lang.Object[] r4 = m2424a(r0, r5)     // Catch:{ Exception -> 0x00dc }
        return r4
    L_0x00dc:
        r4 = move-exception
        java.lang.RuntimeException r5 = new java.lang.RuntimeException
        r5.<init>(r4)
        throw r5
    L_0x00e3:
        java.lang.Class<java.lang.String> r1 = java.lang.String.class
        boolean r1 = r1.equals(r5)
        if (r1 == 0) goto L_0x00f2
        java.lang.String r5 = ","
        java.lang.String[] r4 = r4.split(r5)
        return r4
    L_0x00f2:
        java.lang.Class r1 = java.lang.Character.TYPE
        boolean r1 = r1.equals(r5)
        if (r1 == 0) goto L_0x00ff
        char[] r4 = r4.toCharArray()
        return r4
    L_0x00ff:
        java.lang.Class<java.lang.Character> r1 = java.lang.Character.class
        boolean r1 = r1.equals(r5)
        if (r1 == 0) goto L_0x011d
        char[] r4 = r4.toCharArray()
        int r5 = r4.length
        java.lang.Character[] r5 = new java.lang.Character[r5]
    L_0x010e:
        int r0 = r5.length
        if (r2 >= r0) goto L_0x011c
        char r0 = r4[r2]
        java.lang.Character r0 = java.lang.Character.valueOf(r0)
        r5[r2] = r0
        int r2 = r2 + 1
        goto L_0x010e
    L_0x011c:
        return r5
    L_0x011d:
        java.lang.Class r1 = java.lang.Byte.TYPE
        boolean r1 = r1.equals(r5)
        if (r1 == 0) goto L_0x012a
        byte[] r4 = android.util.Base64.decode(r4, r2)
        return r4
    L_0x012a:
        java.lang.Class<java.lang.Byte> r1 = java.lang.Byte.class
        boolean r5 = r1.equals(r5)
        if (r5 == 0) goto L_0x0148
        byte[] r4 = android.util.Base64.decode(r4, r2)
        int r5 = r4.length
        java.lang.Byte[] r5 = new java.lang.Byte[r5]
    L_0x0139:
        int r0 = r5.length
        if (r2 >= r0) goto L_0x0147
        byte r0 = r4[r2]
        java.lang.Byte r0 = java.lang.Byte.valueOf(r0)
        r5[r2] = r0
        int r2 = r2 + 1
        goto L_0x0139
    L_0x0147:
        return r5
    L_0x0148:
        return r0
    L_0x0149:
        r2 = 123(0x7b, float:1.72E-43)
        if (r1 != r2) goto L_0x016b
        org.json.JSONObject r0 = new org.json.JSONObject     // Catch:{ Exception -> 0x0164 }
        r0.<init>(r4)     // Catch:{ Exception -> 0x0164 }
        java.lang.Class<java.util.Map> r4 = java.util.Map.class
        boolean r4 = r4.isAssignableFrom(r5)     // Catch:{ Exception -> 0x0164 }
        if (r4 == 0) goto L_0x015f
        java.util.Map r4 = m2422a(r0)     // Catch:{ Exception -> 0x0164 }
        return r4
    L_0x015f:
        java.lang.Object r4 = m2418a(r0, r5)     // Catch:{ Exception -> 0x0164 }
        return r4
    L_0x0164:
        r4 = move-exception
        java.lang.RuntimeException r5 = new java.lang.RuntimeException
        r5.<init>(r4)
        throw r5
    L_0x016b:
        java.lang.Class<java.lang.String> r1 = java.lang.String.class
        boolean r5 = r5.isAssignableFrom(r1)
        if (r5 == 0) goto L_0x0174
        return r4
    L_0x0174:
        return r0
    L_0x0175:
        char r4 = r4.charAt(r2)
        java.lang.Character r4 = java.lang.Character.valueOf(r4)
        return r4
    L_0x017e:
        java.lang.Byte r4 = java.lang.Byte.valueOf(r4)
        return r4
    L_0x0183:
        java.lang.Double r4 = java.lang.Double.valueOf(r4)
        return r4
    L_0x0188:
        java.lang.Float r4 = java.lang.Float.valueOf(r4)
        return r4
    L_0x018d:
        java.lang.Boolean r4 = java.lang.Boolean.valueOf(r4)
        return r4
    L_0x0192:
        java.lang.Long r4 = java.lang.Long.valueOf(r4)
        return r4
    L_0x0197:
        java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
        return r4
    L_0x019c:
        java.lang.Short r4 = java.lang.Short.valueOf(r4)
        return r4
    L_0x01a1:
        return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.baichuan.trade.common.utils.C1229c.m2417a(java.lang.String, java.lang.Class):java.lang.Object");
    }

    /* renamed from: a */
    public static <T> T m2418a(JSONObject jSONObject, Class<T> cls) {
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
                                    obj = type.isArray() ? m2424a(jSONObject.getJSONArray(name), type.getComponentType()) : Map.class.isAssignableFrom(type) ? m2422a(jSONObject.getJSONObject(name)) : m2418a(jSONObject.getJSONObject(name), type);
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
    public static String m2419a(List<? extends Object> list) {
        JSONArray jSONArray = new JSONArray();
        if (list != null && list.size() > 0) {
            for (Object put : list) {
                jSONArray.put(put);
            }
        }
        return jSONArray.toString();
    }

    /* renamed from: a */
    public static String m2420a(JSONObject jSONObject, String str) {
        if (jSONObject.has(str)) {
            return jSONObject.optString(str);
        }
        return null;
    }

    /* renamed from: a */
    public static List<Object> m2421a(JSONArray jSONArray) {
        if (jSONArray == null) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList(jSONArray.length());
        int i = 0;
        int length = jSONArray.length();
        while (i < length) {
            Object obj = jSONArray.get(i);
            Object obj2 = obj instanceof JSONObject ? m2422a((JSONObject) obj) : obj instanceof JSONArray ? m2421a((JSONArray) obj) : jSONArray.get(i);
            arrayList.add(obj2);
            i++;
        }
        return arrayList;
    }

    /* renamed from: a */
    public static Map<String, Object> m2422a(JSONObject jSONObject) {
        HashMap hashMap = new HashMap();
        if (jSONObject == null) {
            return hashMap;
        }
        Iterator keys = jSONObject.keys();
        while (keys.hasNext()) {
            String str = (String) keys.next();
            Object opt = jSONObject.opt(str);
            if (opt instanceof JSONObject) {
                opt = m2422a((JSONObject) opt);
            } else if (opt instanceof JSONArray) {
                opt = m2421a((JSONArray) opt);
            }
            hashMap.put(str, opt);
        }
        return hashMap;
    }

    /* renamed from: a */
    public static JSONObject m2423a(String str) {
        JSONObject jSONObject;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            jSONObject = new JSONObject(str);
        } catch (JSONException e) {
            e.printStackTrace();
            jSONObject = null;
        }
        return jSONObject;
    }

    /* renamed from: a */
    public static <T> T[] m2424a(JSONArray jSONArray, Class<T> cls) {
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
                                obj = cls.isArray() ? m2424a(jSONArray.getJSONArray(i), cls.getComponentType()) : Map.class.isAssignableFrom(cls) ? m2422a(jSONArray.getJSONObject(i)) : m2418a(jSONArray.getJSONObject(i), cls);
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
    public static Long m2425b(JSONObject jSONObject, String str) {
        if (jSONObject.has(str)) {
            return Long.valueOf(jSONObject.optLong(str));
        }
        return null;
    }
}
