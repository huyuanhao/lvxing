package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.util.TypeUtils;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

/* renamed from: com.alibaba.fastjson.serializer.ak */
public final class ListSerializer implements ObjectSerializer {
    /* renamed from: a */
    public static final ListSerializer f2860a = new ListSerializer();

    /* JADX INFO: finally extract failed */
    /* renamed from: a */
    public final void mo11198a(JSONSerializer agVar, Object obj, Object obj2, Type type, int i) throws IOException {
        boolean z;
        int i2;
        Object obj3;
        JSONSerializer agVar2 = agVar;
        Object obj4 = obj;
        int i3 = i;
        boolean z2 = agVar2.f2846b.mo11391a(SerializerFeature.WriteClassName) || SerializerFeature.isEnabled(i3, SerializerFeature.WriteClassName);
        SerializeWriter baVar = agVar2.f2846b;
        Type type2 = null;
        if (z2) {
            type2 = TypeUtils.m3259e(type);
        }
        Type type3 = type2;
        if (obj4 == null) {
            baVar.mo11399b(SerializerFeature.WriteNullListAsEmpty);
            return;
        }
        List list = (List) obj4;
        if (list.size() == 0) {
            baVar.append((CharSequence) "[]");
            return;
        }
        SerialContext avVar = agVar2.f2848d;
        agVar2.mo11312a(avVar, obj4, obj2, 0);
        try {
            char c = ',';
            if (baVar.mo11391a(SerializerFeature.PrettyFormat)) {
                baVar.append('[');
                agVar.mo11324c();
                int i4 = 0;
                for (Object next : list) {
                    if (i4 != 0) {
                        baVar.append(c);
                    }
                    agVar.mo11327e();
                    if (next == null) {
                        agVar2.f2846b.mo11396b();
                    } else if (agVar2.mo11319a(next)) {
                        agVar2.mo11322b(next);
                    } else {
                        ObjectSerializer a = agVar2.mo11309a(next.getClass());
                        SerialContext avVar2 = r1;
                        Object obj5 = next;
                        SerialContext avVar3 = new SerialContext(avVar, obj, obj2, 0, 0);
                        agVar2.f2848d = avVar2;
                        a.mo11198a(agVar, obj5, Integer.valueOf(i4), type3, i);
                    }
                    i4++;
                    Object obj6 = obj;
                    c = ',';
                }
                agVar.mo11326d();
                agVar.mo11327e();
                baVar.append(']');
                agVar2.f2848d = avVar;
                return;
            }
            char c2 = ']';
            baVar.append('[');
            int size = list.size();
            int i5 = 0;
            while (i5 < size) {
                Object obj7 = list.get(i5);
                if (i5 != 0) {
                    baVar.append(',');
                }
                if (obj7 == null) {
                    baVar.append((CharSequence) "null");
                } else {
                    Class<Long> cls = obj7.getClass();
                    if (cls == Integer.class) {
                        baVar.mo11403c(((Integer) obj7).intValue());
                    } else if (cls == Long.class) {
                        long longValue = ((Long) obj7).longValue();
                        if (z2) {
                            baVar.mo11381a(longValue);
                            baVar.write(76);
                        } else {
                            baVar.mo11381a(longValue);
                        }
                    } else {
                        if ((SerializerFeature.DisableCircularReferenceDetect.mask & i3) != 0) {
                            i2 = i5;
                            agVar2.mo11309a(obj7.getClass()).mo11198a(agVar, obj7, Integer.valueOf(i5), type3, i);
                            z = z2;
                        } else {
                            i2 = i5;
                            if (!baVar.f2914g) {
                                obj3 = obj7;
                                z = z2;
                                SerialContext avVar4 = r1;
                                SerialContext avVar5 = new SerialContext(avVar, obj, obj2, 0, 0);
                                agVar2.f2848d = avVar4;
                            } else {
                                obj3 = obj7;
                                z = z2;
                            }
                            if (agVar2.mo11319a(obj3)) {
                                agVar2.mo11322b(obj3);
                            } else {
                                ObjectSerializer a2 = agVar2.mo11309a(obj3.getClass());
                                if ((SerializerFeature.WriteClassName.mask & i3) == 0 || !(a2 instanceof JavaBeanSerializer)) {
                                    a2.mo11198a(agVar, obj3, Integer.valueOf(i2), type3, i);
                                } else {
                                    ((JavaBeanSerializer) a2).mo11343b(agVar, obj3, Integer.valueOf(i2), type3, i);
                                }
                            }
                        }
                        i5 = i2 + 1;
                        z2 = z;
                        c2 = ']';
                    }
                }
                i2 = i5;
                z = z2;
                i5 = i2 + 1;
                z2 = z;
                c2 = ']';
            }
            baVar.append(c2);
            agVar2.f2848d = avVar;
        } catch (Throwable th) {
            agVar2.f2848d = avVar;
            throw th;
        }
    }
}
