package com.alibaba.fastjson.parser.p066a;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.fastjson.util.TypeUtils;
import java.lang.reflect.Type;
import java.math.BigDecimal;

/* renamed from: com.alibaba.fastjson.parser.a.r */
public class NumberDeserializer implements ObjectDeserializer {
    /* renamed from: a */
    public static final NumberDeserializer f2757a = new NumberDeserializer();

    /* renamed from: g_ */
    public int mo11162g_() {
        return 2;
    }

    /* renamed from: a */
    public <T> T mo11161a(DefaultJSONParser aVar, Type type, Object obj) {
        JSONLexer bVar = aVar.f2689d;
        String str = "short overflow : ";
        if (bVar.mo11205a() == 2) {
            if (type == Double.TYPE || type == Double.class) {
                String s = bVar.mo11240s();
                bVar.mo11211a(16);
                return Double.valueOf(Double.parseDouble(s));
            }
            long q = bVar.mo11238q();
            bVar.mo11211a(16);
            if (type == Short.TYPE || type == Short.class) {
                if (q <= 32767 && q >= -32768) {
                    return Short.valueOf((short) ((int) q));
                }
                StringBuilder sb = new StringBuilder();
                sb.append(str);
                sb.append(q);
                throw new JSONException(sb.toString());
            } else if (type == Byte.TYPE || type == Byte.class) {
                if (q <= 127 && q >= -128) {
                    return Byte.valueOf((byte) ((int) q));
                }
                StringBuilder sb2 = new StringBuilder();
                sb2.append(str);
                sb2.append(q);
                throw new JSONException(sb2.toString());
            } else if (q < -2147483648L || q > 2147483647L) {
                return Long.valueOf(q);
            } else {
                return Integer.valueOf((int) q);
            }
        } else if (bVar.mo11205a() != 3) {
            T t = null;
            if (bVar.mo11205a() == 18) {
                if ("NaN".equals(bVar.mo11233l())) {
                    bVar.mo11222d();
                    if (type == Double.class) {
                        t = Double.valueOf(Double.NaN);
                    } else if (type == Float.class) {
                        t = Float.valueOf(Float.NaN);
                    }
                    return t;
                }
            }
            Object m = aVar.mo11155m();
            if (m == null) {
                return null;
            }
            if (type == Double.TYPE || type == Double.class) {
                try {
                    return TypeUtils.m3269h(m);
                } catch (Exception e) {
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("parseDouble error, field : ");
                    sb3.append(obj);
                    throw new JSONException(sb3.toString(), e);
                }
            } else if (type == Short.TYPE || type == Short.class) {
                try {
                    return TypeUtils.m3256d(m);
                } catch (Exception e2) {
                    StringBuilder sb4 = new StringBuilder();
                    sb4.append("parseShort error, field : ");
                    sb4.append(obj);
                    throw new JSONException(sb4.toString(), e2);
                }
            } else if (type != Byte.TYPE && type != Byte.class) {
                return TypeUtils.m3260e(m);
            } else {
                try {
                    return TypeUtils.m3243b(m);
                } catch (Exception e3) {
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append("parseByte error, field : ");
                    sb5.append(obj);
                    throw new JSONException(sb5.toString(), e3);
                }
            }
        } else if (type == Double.TYPE || type == Double.class) {
            String s2 = bVar.mo11240s();
            bVar.mo11211a(16);
            return Double.valueOf(Double.parseDouble(s2));
        } else {
            T k = bVar.mo11232k();
            bVar.mo11211a(16);
            if (type == Short.TYPE || type == Short.class) {
                if (k.compareTo(BigDecimal.valueOf(32767)) <= 0 && k.compareTo(BigDecimal.valueOf(-32768)) >= 0) {
                    return Short.valueOf(k.shortValue());
                }
                StringBuilder sb6 = new StringBuilder();
                sb6.append(str);
                sb6.append(k);
                throw new JSONException(sb6.toString());
            } else if (type == Byte.TYPE || type == Byte.class) {
                return Byte.valueOf(k.byteValue());
            } else {
                return k;
            }
        }
    }
}
