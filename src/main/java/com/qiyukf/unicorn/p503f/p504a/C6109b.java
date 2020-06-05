package com.qiyukf.unicorn.p503f.p504a;

import com.qiyukf.basesdk.p393a.C5264a;
import com.qiyukf.basesdk.p412c.C5366b;
import com.qiyukf.unicorn.p503f.p504a.p508b.C6110a;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.qiyukf.unicorn.f.a.b */
public final class C6109b {
    /* renamed from: a */
    private static Object m24266a(JSONArray jSONArray, int i, Class<?> cls) {
        if (C6070a.class.isAssignableFrom(cls)) {
            JSONObject optJSONObject = jSONArray.optJSONObject(i);
            if (optJSONObject != null) {
                try {
                    C6070a aVar = (C6070a) cls.newInstance();
                    m24269a((Object) aVar, optJSONObject);
                    return aVar;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } else if (cls == String.class) {
            return jSONArray.optString(i);
        } else {
            if (cls == Integer.class) {
                return Integer.valueOf(jSONArray.optInt(i));
            }
            if (cls == Long.class) {
                return Long.valueOf(jSONArray.optLong(i));
            }
            if (cls == Float.class) {
                return Float.valueOf((float) jSONArray.optDouble(i));
            }
            if (cls == Double.class) {
                return Double.valueOf(jSONArray.optDouble(i));
            }
            if (cls == Boolean.class) {
                return Boolean.valueOf(jSONArray.optBoolean(i));
            }
            if (cls == JSONObject.class) {
                return jSONArray.optJSONObject(i);
            }
            if (cls == JSONArray.class) {
                return jSONArray.optJSONArray(i);
            }
            if (cls == Object.class) {
                return jSONArray.opt(i);
            }
        }
        return null;
    }

    /* renamed from: a */
    private static Type m24267a(Type type) {
        if (type instanceof ParameterizedType) {
            Type[] actualTypeArguments = ((ParameterizedType) type).getActualTypeArguments();
            if (actualTypeArguments != null && actualTypeArguments.length > 0) {
                return actualTypeArguments[0];
            }
        }
        return null;
    }

    /* renamed from: a */
    private static List<Object> m24268a(JSONArray jSONArray, Type type) {
        ArrayList arrayList = new ArrayList();
        if (!(jSONArray == null || jSONArray.length() == 0)) {
            int i = 0;
            if (type instanceof Class) {
                while (i < jSONArray.length()) {
                    arrayList.add(m24266a(jSONArray, i, (Class) type));
                    i++;
                }
            } else if (type instanceof ParameterizedType) {
                ParameterizedType parameterizedType = (ParameterizedType) type;
                if ((parameterizedType.getRawType() instanceof Class) && List.class.isAssignableFrom((Class) parameterizedType.getRawType())) {
                    while (i < jSONArray.length()) {
                        arrayList.add(m24268a(jSONArray == null ? null : jSONArray.optJSONArray(i), m24267a(parameterizedType)));
                        i++;
                    }
                }
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    public static void m24269a(Object obj, JSONObject jSONObject) {
        Field[] declaredFields;
        Object a;
        if (jSONObject != null) {
            for (Field field : obj.getClass().getDeclaredFields()) {
                C6110a aVar = (C6110a) field.getAnnotation(C6110a.class);
                if (aVar != null) {
                    try {
                        Class<Object> type = field.getType();
                        String a2 = aVar.mo29051a();
                        field.setAccessible(true);
                        if (type == String.class) {
                            a = C5366b.m22039e(jSONObject, a2);
                        } else {
                            if (type != Integer.TYPE) {
                                if (type != Integer.class) {
                                    if (type != Long.TYPE) {
                                        if (type != Long.class) {
                                            if (type != Float.TYPE) {
                                                if (type != Float.class) {
                                                    if (type != Double.TYPE) {
                                                        if (type != Double.class) {
                                                            if (type != Boolean.TYPE) {
                                                                if (type != Boolean.class) {
                                                                    if (type == JSONObject.class) {
                                                                        a = C5366b.m22040f(jSONObject, a2);
                                                                    } else if (type == JSONArray.class) {
                                                                        a = C5366b.m22041g(jSONObject, a2);
                                                                    } else if (type == Object.class) {
                                                                        a = jSONObject == null ? null : jSONObject.opt(a2);
                                                                    } else if (C6070a.class.isAssignableFrom(type)) {
                                                                        JSONObject f = C5366b.m22040f(jSONObject, a2);
                                                                        if (f != null) {
                                                                            C6070a aVar2 = (C6070a) type.newInstance();
                                                                            m24269a((Object) aVar2, f);
                                                                            field.set(obj, aVar2);
                                                                        }
                                                                    } else if (List.class.isAssignableFrom(type)) {
                                                                        a = m24268a(C5366b.m22041g(jSONObject, a2), m24267a(field.getGenericType()));
                                                                    }
                                                                }
                                                            }
                                                            field.setBoolean(obj, Boolean.valueOf(C5366b.m22039e(jSONObject, a2)).booleanValue());
                                                        }
                                                    }
                                                    field.setDouble(obj, C5366b.m22038d(jSONObject, a2));
                                                }
                                            }
                                            field.setFloat(obj, (float) C5366b.m22038d(jSONObject, a2));
                                        }
                                    }
                                    field.setLong(obj, C5366b.m22037c(jSONObject, a2));
                                }
                            }
                            field.setInt(obj, C5366b.m22034b(jSONObject, a2));
                        }
                        field.set(obj, a);
                    } catch (Exception e) {
                        StringBuilder sb = new StringBuilder("is exception");
                        sb.append(e);
                        C5264a.m21617a("attachparser", sb.toString());
                    }
                }
            }
        }
    }
}
