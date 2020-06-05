package com.alibaba.fastjson.parser.p066a;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONPObject;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.JSONLexerBase;
import java.lang.reflect.Type;

/* renamed from: com.alibaba.fastjson.parser.a.m */
public class JSONPDeserializer implements ObjectDeserializer {
    /* renamed from: a */
    public static final JSONPDeserializer f2726a = new JSONPDeserializer();

    /* renamed from: g_ */
    public int mo11162g_() {
        return 0;
    }

    /* renamed from: a */
    public <T> T mo11161a(DefaultJSONParser aVar, Type type, Object obj) {
        int a;
        JSONLexerBase cVar = (JSONLexerBase) aVar.mo11156n();
        String b = cVar.mo11215b(aVar.mo11142c());
        cVar.mo11222d();
        int a2 = cVar.mo11205a();
        if (a2 == 25) {
            String b2 = cVar.mo11215b(aVar.mo11142c());
            StringBuilder sb = new StringBuilder();
            sb.append(b);
            sb.append(".");
            String sb2 = sb.toString();
            StringBuilder sb3 = new StringBuilder();
            sb3.append(sb2);
            sb3.append(b2);
            b = sb3.toString();
            cVar.mo11222d();
            a2 = cVar.mo11205a();
        }
        T cVar2 = new JSONPObject(b);
        String str = "illegal jsonp : ";
        if (a2 == 10) {
            cVar.mo11222d();
            while (true) {
                cVar2.mo11081a(aVar.mo11155m());
                a = cVar.mo11205a();
                if (a != 16) {
                    break;
                }
                cVar.mo11222d();
            }
            if (a == 11) {
                cVar.mo11222d();
                if (cVar.mo11205a() == 24) {
                    cVar.mo11222d();
                }
                return cVar2;
            }
            StringBuilder sb4 = new StringBuilder();
            sb4.append(str);
            sb4.append(cVar.mo11245x());
            throw new JSONException(sb4.toString());
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append(str);
        sb5.append(cVar.mo11245x());
        throw new JSONException(sb5.toString());
    }
}
