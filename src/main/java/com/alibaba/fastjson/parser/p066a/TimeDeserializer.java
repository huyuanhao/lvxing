package com.alibaba.fastjson.parser.p066a;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.fastjson.parser.JSONScanner;
import java.lang.reflect.Type;
import java.sql.Time;

/* renamed from: com.alibaba.fastjson.parser.a.ab */
public class TimeDeserializer implements ObjectDeserializer {
    /* renamed from: a */
    public static final TimeDeserializer f2715a = new TimeDeserializer();

    /* renamed from: g_ */
    public int mo11162g_() {
        return 2;
    }

    /* renamed from: a */
    public <T> T mo11161a(DefaultJSONParser aVar, Type type, Object obj) {
        long j;
        JSONLexer bVar = aVar.f2689d;
        if (bVar.mo11205a() == 16) {
            bVar.mo11211a(4);
            String str = "syntax error";
            if (bVar.mo11205a() == 4) {
                bVar.mo11219c(2);
                if (bVar.mo11205a() == 2) {
                    long q = bVar.mo11238q();
                    bVar.mo11211a(13);
                    if (bVar.mo11205a() == 13) {
                        bVar.mo11211a(16);
                        return new Time(q);
                    }
                    throw new JSONException(str);
                }
                throw new JSONException(str);
            }
            throw new JSONException(str);
        }
        T m = aVar.mo11155m();
        if (m == null) {
            return null;
        }
        if (m instanceof Time) {
            return m;
        }
        if (m instanceof Number) {
            return new Time(((Number) m).longValue());
        }
        if (m instanceof String) {
            String str2 = (String) m;
            if (str2.length() == 0) {
                return null;
            }
            JSONScanner eVar = new JSONScanner(str2);
            if (eVar.mo11284K()) {
                j = eVar.mo11251E().getTimeInMillis();
            } else {
                boolean z = false;
                int i = 0;
                while (true) {
                    if (i >= str2.length()) {
                        z = true;
                        break;
                    }
                    char charAt = str2.charAt(i);
                    if (charAt < '0' || charAt > '9') {
                        break;
                    }
                    i++;
                }
                if (!z) {
                    eVar.close();
                    return Time.valueOf(str2);
                }
                j = Long.parseLong(str2);
            }
            eVar.close();
            return new Time(j);
        }
        throw new JSONException("parse error");
    }
}
