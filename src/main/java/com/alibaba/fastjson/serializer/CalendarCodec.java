package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.fastjson.parser.p066a.ObjectDeserializer;
import com.alibaba.fastjson.util.IOUtils;
import discoveryAD.C7895e;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import org.slf4j.Marker;

/* renamed from: com.alibaba.fastjson.serializer.o */
public class CalendarCodec implements ObjectDeserializer, ObjectSerializer {
    /* renamed from: a */
    public static final CalendarCodec f2946a = new CalendarCodec();
    /* renamed from: b */
    private DatatypeFactory f2947b;

    /* renamed from: g_ */
    public int mo11162g_() {
        return 2;
    }

    /* renamed from: a */
    public void mo11198a(JSONSerializer agVar, Object obj, Object obj2, Type type, int i) throws IOException {
        Calendar calendar;
        char[] cArr;
        JSONSerializer agVar2 = agVar;
        Object obj3 = obj;
        SerializeWriter baVar = agVar2.f2846b;
        if (obj3 == null) {
            baVar.mo11396b();
            return;
        }
        if (obj3 instanceof XMLGregorianCalendar) {
            calendar = ((XMLGregorianCalendar) obj3).toGregorianCalendar();
        } else {
            calendar = (Calendar) obj3;
        }
        if (baVar.mo11391a(SerializerFeature.UseISO8601DateFormat)) {
            char c = baVar.mo11391a(SerializerFeature.UseSingleQuotes) ? '\'' : '\"';
            baVar.append(c);
            int i2 = calendar.get(1);
            int i3 = calendar.get(2) + 1;
            int i4 = calendar.get(5);
            int i5 = calendar.get(11);
            int i6 = calendar.get(12);
            int i7 = calendar.get(13);
            int i8 = calendar.get(14);
            if (i8 != 0) {
                cArr = "0000-00-00T00:00:00.000".toCharArray();
                IOUtils.m3192a(i8, 23, cArr);
                IOUtils.m3192a(i7, 19, cArr);
                IOUtils.m3192a(i6, 16, cArr);
                IOUtils.m3192a(i5, 13, cArr);
                IOUtils.m3192a(i4, 10, cArr);
                IOUtils.m3192a(i3, 7, cArr);
                IOUtils.m3192a(i2, 4, cArr);
            } else if (i7 == 0 && i6 == 0 && i5 == 0) {
                cArr = "0000-00-00".toCharArray();
                IOUtils.m3192a(i4, 10, cArr);
                IOUtils.m3192a(i3, 7, cArr);
                IOUtils.m3192a(i2, 4, cArr);
            } else {
                cArr = "0000-00-00T00:00:00".toCharArray();
                IOUtils.m3192a(i7, 19, cArr);
                IOUtils.m3192a(i6, 16, cArr);
                IOUtils.m3192a(i5, 13, cArr);
                IOUtils.m3192a(i4, 10, cArr);
                IOUtils.m3192a(i3, 7, cArr);
                IOUtils.m3192a(i2, 4, cArr);
            }
            baVar.write(cArr);
            int rawOffset = calendar.getTimeZone().getRawOffset() / C7895e.f26887Bc;
            if (rawOffset == 0) {
                baVar.append((CharSequence) "Z");
            } else {
                String str = ":00";
                String str2 = "%02d";
                if (rawOffset > 0) {
                    baVar.append((CharSequence) Marker.ANY_NON_NULL_MARKER).append((CharSequence) String.format(str2, new Object[]{Integer.valueOf(rawOffset)})).append((CharSequence) str);
                } else {
                    baVar.append((CharSequence) "-").append((CharSequence) String.format(str2, new Object[]{Integer.valueOf(-rawOffset)})).append((CharSequence) str);
                }
            }
            baVar.append(c);
        } else {
            agVar2.mo11325c(calendar.getTime());
        }
    }

    /* renamed from: a */
    public <T> T mo11161a(DefaultJSONParser aVar, Type type, Object obj) {
        T a = DateCodec.f2951a.mo11161a(aVar, type, obj);
        if (a instanceof Calendar) {
            return a;
        }
        Date date = (Date) a;
        if (date == null) {
            return null;
        }
        JSONLexer bVar = aVar.f2689d;
        T instance = Calendar.getInstance(bVar.mo11243v(), bVar.mo11244w());
        instance.setTime(date);
        if (type == XMLGregorianCalendar.class) {
            instance = mo11427a((GregorianCalendar) instance);
        }
        return instance;
    }

    /* renamed from: a */
    public XMLGregorianCalendar mo11427a(Calendar calendar) {
        if (this.f2947b == null) {
            try {
                this.f2947b = DatatypeFactory.newInstance();
            } catch (DatatypeConfigurationException e) {
                throw new IllegalStateException("Could not obtain an instance of DatatypeFactory.", e);
            }
        }
        return this.f2947b.newXMLGregorianCalendar((GregorianCalendar) calendar);
    }
}
