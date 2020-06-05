package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.JSONScanner;
import com.alibaba.fastjson.parser.p066a.AbstractDateDeserializer;
import com.alibaba.fastjson.parser.p066a.ObjectDeserializer;
import com.alibaba.fastjson.util.IOUtils;
import com.alibaba.fastjson.util.TypeUtils;
import discoveryAD.C7895e;
import java.io.IOException;
import java.lang.reflect.Type;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/* renamed from: com.alibaba.fastjson.serializer.v */
public class DateCodec extends AbstractDateDeserializer implements ObjectDeserializer, ObjectSerializer {
    /* renamed from: a */
    public static final DateCodec f2951a = new DateCodec();

    /* renamed from: g_ */
    public int mo11162g_() {
        return 2;
    }

    /* renamed from: a */
    public void mo11198a(JSONSerializer agVar, Object obj, Object obj2, Type type, int i) throws IOException {
        Date date;
        char[] cArr;
        JSONSerializer agVar2 = agVar;
        Object obj3 = obj;
        SerializeWriter baVar = agVar2.f2846b;
        if (obj3 == null) {
            baVar.mo11396b();
            return;
        }
        if (obj3 instanceof Date) {
            date = (Date) obj3;
        } else {
            date = TypeUtils.m3270i(obj);
        }
        if (baVar.mo11391a(SerializerFeature.WriteDateUseDateFormat)) {
            DateFormat b = agVar.mo11321b();
            if (b == null) {
                b = new SimpleDateFormat(JSON.DEFFAULT_DATE_FORMAT, agVar2.f2850f);
                b.setTimeZone(agVar2.f2849e);
            }
            baVar.mo11384a(b.format(date));
        } else if (!baVar.mo11391a(SerializerFeature.WriteClassName) || obj.getClass() == type) {
            long time = date.getTime();
            if (baVar.mo11391a(SerializerFeature.UseISO8601DateFormat)) {
                int i2 = baVar.mo11391a(SerializerFeature.UseSingleQuotes) ? 39 : 34;
                baVar.write(i2);
                Calendar instance = Calendar.getInstance(agVar2.f2849e, agVar2.f2850f);
                instance.setTimeInMillis(time);
                int i3 = instance.get(1);
                int i4 = instance.get(2) + 1;
                int i5 = instance.get(5);
                int i6 = instance.get(11);
                int i7 = instance.get(12);
                int i8 = instance.get(13);
                int i9 = instance.get(14);
                if (i9 != 0) {
                    cArr = "0000-00-00T00:00:00.000".toCharArray();
                    IOUtils.m3192a(i9, 23, cArr);
                    IOUtils.m3192a(i8, 19, cArr);
                    IOUtils.m3192a(i7, 16, cArr);
                    IOUtils.m3192a(i6, 13, cArr);
                    IOUtils.m3192a(i5, 10, cArr);
                    IOUtils.m3192a(i4, 7, cArr);
                    IOUtils.m3192a(i3, 4, cArr);
                } else if (i8 == 0 && i7 == 0 && i6 == 0) {
                    cArr = "0000-00-00".toCharArray();
                    IOUtils.m3192a(i5, 10, cArr);
                    IOUtils.m3192a(i4, 7, cArr);
                    IOUtils.m3192a(i3, 4, cArr);
                } else {
                    cArr = "0000-00-00T00:00:00".toCharArray();
                    IOUtils.m3192a(i8, 19, cArr);
                    IOUtils.m3192a(i7, 16, cArr);
                    IOUtils.m3192a(i6, 13, cArr);
                    IOUtils.m3192a(i5, 10, cArr);
                    IOUtils.m3192a(i4, 7, cArr);
                    IOUtils.m3192a(i3, 4, cArr);
                }
                baVar.write(cArr);
                int rawOffset = instance.getTimeZone().getRawOffset() / C7895e.f26887Bc;
                if (rawOffset == 0) {
                    baVar.write(90);
                } else {
                    if (rawOffset > 9) {
                        baVar.write(43);
                        baVar.mo11403c(rawOffset);
                    } else if (rawOffset > 0) {
                        baVar.write(43);
                        baVar.write(48);
                        baVar.mo11403c(rawOffset);
                    } else if (rawOffset < -9) {
                        baVar.write(45);
                        baVar.mo11403c(rawOffset);
                    } else if (rawOffset < 0) {
                        baVar.write(45);
                        baVar.write(48);
                        baVar.mo11403c(rawOffset);
                    }
                    baVar.append((CharSequence) ":00");
                }
                baVar.write(i2);
            } else {
                baVar.mo11381a(time);
            }
        } else {
            if (obj.getClass() == Date.class) {
                baVar.write("new Date(");
                baVar.mo11381a(((Date) obj3).getTime());
                baVar.write(41);
            } else {
                baVar.write(123);
                baVar.mo11404c(JSON.DEFAULT_TYPE_KEY);
                agVar2.mo11323b(obj.getClass().getName());
                baVar.mo11376a(',', "val", ((Date) obj3).getTime());
                baVar.write(125);
            }
        }
    }

    /* renamed from: a */
    public <T> T mo11163a(DefaultJSONParser aVar, Type type, Object obj, Object obj2) {
        T t = null;
        if (obj2 == null) {
            return null;
        }
        if (obj2 instanceof Date) {
            return obj2;
        }
        if (obj2 instanceof Number) {
            return new Date(((Number) obj2).longValue());
        }
        if (obj2 instanceof String) {
            String str = (String) obj2;
            if (str.length() == 0) {
                return null;
            }
            JSONScanner eVar = new JSONScanner(str);
            try {
                if (eVar.mo11288b(false)) {
                    T E = eVar.mo11251E();
                    if (type == Calendar.class) {
                        return E;
                    }
                    T time = E.getTime();
                    eVar.close();
                    return time;
                }
                eVar.close();
                if (str.length() == aVar.mo11121a().length() || (str.length() == 22 && aVar.mo11121a().equals("yyyyMMddHHmmssSSSZ"))) {
                    try {
                        return aVar.mo11138b().parse(str);
                    } catch (ParseException unused) {
                    }
                }
                if (str.startsWith("/Date(") && str.endsWith(")/")) {
                    str = str.substring(6, str.length() - 2);
                }
                if (!"0000-00-00".equals(str) && !"0000-00-00T00:00:00".equalsIgnoreCase(str) && !"0001-01-01T00:00:00+08:00".equalsIgnoreCase(str)) {
                    int lastIndexOf = str.lastIndexOf(124);
                    if (lastIndexOf > 20) {
                        TimeZone timeZone = TimeZone.getTimeZone(str.substring(lastIndexOf + 1));
                        if (!"GMT".equals(timeZone.getID())) {
                            JSONScanner eVar2 = new JSONScanner(str.substring(0, lastIndexOf));
                            try {
                                if (eVar2.mo11288b(false)) {
                                    T E2 = eVar2.mo11251E();
                                    E2.setTimeZone(timeZone);
                                    if (type == Calendar.class) {
                                        return E2;
                                    }
                                    T time2 = E2.getTime();
                                    eVar2.close();
                                    return time2;
                                }
                                eVar2.close();
                            } finally {
                                eVar2.close();
                            }
                        }
                    }
                    t = new Date(Long.parseLong(str));
                }
                return t;
            } finally {
                eVar.close();
            }
        } else {
            throw new JSONException("parse error");
        }
    }
}
