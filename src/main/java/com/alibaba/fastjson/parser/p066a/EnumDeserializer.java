package com.alibaba.fastjson.parser.p066a;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.JSONLexer;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.HashMap;

/* renamed from: com.alibaba.fastjson.parser.a.g */
public class EnumDeserializer implements ObjectDeserializer {
    /* renamed from: a */
    protected final Class<?> f2720a;
    /* renamed from: b */
    protected final Enum[] f2721b;
    /* renamed from: c */
    protected final Enum[] f2722c;
    /* renamed from: d */
    protected long[] f2723d;

    /* renamed from: g_ */
    public int mo11162g_() {
        return 2;
    }

    public EnumDeserializer(Class<?> cls) {
        JSONField jSONField;
        int i;
        Class<?> cls2 = cls;
        this.f2720a = cls2;
        this.f2722c = (Enum[]) cls.getEnumConstants();
        HashMap hashMap = new HashMap();
        int i2 = 0;
        while (true) {
            Enum[] enumArr = this.f2722c;
            if (i2 >= enumArr.length) {
                break;
            }
            Enum enumR = enumArr[i2];
            String name = enumR.name();
            try {
                jSONField = (JSONField) cls2.getField(name).getAnnotation(JSONField.class);
                if (jSONField != null) {
                    try {
                        String name2 = jSONField.name();
                        if (name2 != null && name2.length() > 0) {
                            name = name2;
                        }
                    } catch (Exception unused) {
                    }
                }
            } catch (Exception unused2) {
                jSONField = null;
            }
            int i3 = 0;
            long j = -3750763034362895579L;
            long j2 = -3750763034362895579L;
            while (i3 < name.length()) {
                int charAt = name.charAt(i3);
                long j3 = ((long) charAt) ^ j;
                if (charAt >= 65 && charAt <= 90) {
                    charAt += 32;
                }
                j2 = (((long) charAt) ^ j2) * 1099511628211L;
                i3++;
                j = j3 * 1099511628211L;
            }
            hashMap.put(Long.valueOf(j), enumR);
            if (j != j2) {
                hashMap.put(Long.valueOf(j2), enumR);
            }
            if (jSONField != null) {
                String[] alternateNames = jSONField.alternateNames();
                int length = alternateNames.length;
                int i4 = 0;
                while (i4 < length) {
                    String str = alternateNames[i4];
                    int i5 = 0;
                    long j4 = -3750763034362895579L;
                    while (i5 < str.length()) {
                        j4 = (j4 ^ ((long) str.charAt(i5))) * 1099511628211L;
                        i5++;
                        i2 = i2;
                    }
                    int i6 = i2;
                    if (!(j4 == j || j4 == j2)) {
                        hashMap.put(Long.valueOf(j4), enumR);
                    }
                    i4++;
                    i2 = i6;
                }
            }
            i2 = i + 1;
        }
        this.f2723d = new long[hashMap.size()];
        int i7 = 0;
        for (Long longValue : hashMap.keySet()) {
            int i8 = i7 + 1;
            this.f2723d[i7] = longValue.longValue();
            i7 = i8;
        }
        Arrays.sort(this.f2723d);
        this.f2721b = new Enum[this.f2723d.length];
        int i9 = 0;
        while (true) {
            long[] jArr = this.f2723d;
            if (i9 < jArr.length) {
                this.f2721b[i9] = (Enum) hashMap.get(Long.valueOf(jArr[i9]));
                i9++;
            } else {
                return;
            }
        }
    }

    /* renamed from: a */
    public Enum mo11171a(long j) {
        if (this.f2721b == null) {
            return null;
        }
        int binarySearch = Arrays.binarySearch(this.f2723d, j);
        if (binarySearch < 0) {
            return null;
        }
        return this.f2721b[binarySearch];
    }

    /* renamed from: a */
    public Enum<?> mo11170a(int i) {
        return this.f2722c[i];
    }

    /* renamed from: a */
    public <T> T mo11161a(DefaultJSONParser aVar, Type type, Object obj) {
        try {
            JSONLexer bVar = aVar.f2689d;
            int a = bVar.mo11205a();
            String str = " error, value : ";
            String str2 = "parse enum ";
            if (a == 2) {
                int n = bVar.mo11235n();
                bVar.mo11211a(16);
                if (n >= 0 && n <= this.f2722c.length) {
                    return this.f2722c[n];
                }
                StringBuilder sb = new StringBuilder();
                sb.append(str2);
                sb.append(this.f2720a.getName());
                sb.append(str);
                sb.append(n);
                throw new JSONException(sb.toString());
            } else if (a == 4) {
                String l = bVar.mo11233l();
                bVar.mo11211a(16);
                if (l.length() == 0) {
                    return null;
                }
                long j = -3750763034362895579L;
                for (int i = 0; i < l.length(); i++) {
                    j = (j ^ ((long) l.charAt(i))) * 1099511628211L;
                }
                return mo11171a(j);
            } else if (a == 8) {
                bVar.mo11211a(16);
                return null;
            } else {
                Object m = aVar.mo11155m();
                StringBuilder sb2 = new StringBuilder();
                sb2.append(str2);
                sb2.append(this.f2720a.getName());
                sb2.append(str);
                sb2.append(m);
                throw new JSONException(sb2.toString());
            }
        } catch (JSONException e) {
            throw e;
        } catch (Exception e2) {
            throw new JSONException(e2.getMessage(), e2);
        }
    }
}
