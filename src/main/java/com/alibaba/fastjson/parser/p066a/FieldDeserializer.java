package com.alibaba.fastjson.parser.p066a;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.util.FieldInfo;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/* renamed from: com.alibaba.fastjson.parser.a.k */
public abstract class FieldDeserializer {
    /* renamed from: b */
    public final FieldInfo f2724b;
    /* renamed from: c */
    protected final Class<?> f2725c;

    /* renamed from: a */
    public int mo11165a() {
        return 0;
    }

    /* renamed from: a */
    public abstract void mo11166a(DefaultJSONParser aVar, Object obj, Type type, Map<String, Object> map);

    public FieldDeserializer(Class<?> cls, FieldInfo cVar) {
        this.f2725c = cls;
        this.f2724b = cVar;
    }

    /* renamed from: a */
    public void mo11179a(Object obj, boolean z) {
        mo11177a(obj, (Object) Boolean.valueOf(z));
    }

    /* renamed from: a */
    public void mo11175a(Object obj, int i) {
        mo11177a(obj, (Object) Integer.valueOf(i));
    }

    /* renamed from: a */
    public void mo11176a(Object obj, long j) {
        mo11177a(obj, (Object) Long.valueOf(j));
    }

    /* renamed from: a */
    public void mo11178a(Object obj, String str) {
        mo11177a(obj, (Object) str);
    }

    /* renamed from: a */
    public void mo11177a(Object obj, Object obj2) {
        if (obj2 != null || !this.f2724b.f2995d.isPrimitive()) {
            if (this.f2724b.f2995d == String.class && this.f2724b.f3008q != null && this.f2724b.f3008q.equals("trim")) {
                obj2 = ((String) obj2).trim();
            }
            try {
                Method method = this.f2724b.f2993b;
                if (method == null) {
                    Field field = this.f2724b.f2994c;
                    if (this.f2724b.f2998g) {
                        if (this.f2724b.f2995d == AtomicInteger.class) {
                            AtomicInteger atomicInteger = (AtomicInteger) field.get(obj);
                            if (atomicInteger != null) {
                                atomicInteger.set(((AtomicInteger) obj2).get());
                            }
                        } else if (this.f2724b.f2995d == AtomicLong.class) {
                            AtomicLong atomicLong = (AtomicLong) field.get(obj);
                            if (atomicLong != null) {
                                atomicLong.set(((AtomicLong) obj2).get());
                            }
                        } else if (this.f2724b.f2995d == AtomicBoolean.class) {
                            AtomicBoolean atomicBoolean = (AtomicBoolean) field.get(obj);
                            if (atomicBoolean != null) {
                                atomicBoolean.set(((AtomicBoolean) obj2).get());
                            }
                        } else if (Map.class.isAssignableFrom(this.f2724b.f2995d)) {
                            Map map = (Map) field.get(obj);
                            if (map != null) {
                                map.putAll((Map) obj2);
                            }
                        } else {
                            Collection collection = (Collection) field.get(obj);
                            if (!(collection == null || obj2 == null)) {
                                collection.clear();
                                collection.addAll((Collection) obj2);
                            }
                        }
                    } else if (field != null) {
                        field.set(obj, obj2);
                    }
                } else if (!this.f2724b.f2998g) {
                    method.invoke(obj, new Object[]{obj2});
                } else if (this.f2724b.f2995d == AtomicInteger.class) {
                    AtomicInteger atomicInteger2 = (AtomicInteger) method.invoke(obj, new Object[0]);
                    if (atomicInteger2 != null) {
                        atomicInteger2.set(((AtomicInteger) obj2).get());
                    }
                } else if (this.f2724b.f2995d == AtomicLong.class) {
                    AtomicLong atomicLong2 = (AtomicLong) method.invoke(obj, new Object[0]);
                    if (atomicLong2 != null) {
                        atomicLong2.set(((AtomicLong) obj2).get());
                    }
                } else if (this.f2724b.f2995d == AtomicBoolean.class) {
                    AtomicBoolean atomicBoolean2 = (AtomicBoolean) method.invoke(obj, new Object[0]);
                    if (atomicBoolean2 != null) {
                        atomicBoolean2.set(((AtomicBoolean) obj2).get());
                    }
                } else if (Map.class.isAssignableFrom(method.getReturnType())) {
                    Map map2 = (Map) method.invoke(obj, new Object[0]);
                    if (map2 != null) {
                        map2.putAll((Map) obj2);
                    }
                } else {
                    Collection collection2 = (Collection) method.invoke(obj, new Object[0]);
                    if (!(collection2 == null || obj2 == null)) {
                        collection2.clear();
                        collection2.addAll((Collection) obj2);
                    }
                }
            } catch (Exception e) {
                StringBuilder sb = new StringBuilder();
                sb.append("set property error, ");
                sb.append(this.f2724b.f2992a);
                throw new JSONException(sb.toString(), e);
            }
        }
    }
}
