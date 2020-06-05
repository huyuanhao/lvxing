package com.alibaba.fastjson.parser.p066a;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.fastjson.parser.JSONToken;
import java.lang.reflect.Type;

/* renamed from: com.alibaba.fastjson.parser.a.z */
public class StackTraceElementDeserializer implements ObjectDeserializer {
    /* renamed from: a */
    public static final StackTraceElementDeserializer f2769a = new StackTraceElementDeserializer();

    /* renamed from: g_ */
    public int mo11162g_() {
        return 12;
    }

    /* renamed from: a */
    public <T> T mo11161a(DefaultJSONParser aVar, Type type, Object obj) {
        JSONLexer bVar = aVar.f2689d;
        if (bVar.mo11205a() == 8) {
            bVar.mo11222d();
            return null;
        } else if (bVar.mo11205a() == 12 || bVar.mo11205a() == 16) {
            String str = null;
            String str2 = null;
            String str3 = null;
            int i = 0;
            while (true) {
                String a = bVar.mo11209a(aVar.mo11142c());
                if (a == null) {
                    if (bVar.mo11205a() == 13) {
                        bVar.mo11211a(16);
                        break;
                    } else if (bVar.mo11205a() == 16 && bVar.mo11212a(Feature.AllowArbitraryCommas)) {
                    }
                }
                bVar.mo11219c(4);
                String str4 = "syntax error";
                if ("className".equals(a)) {
                    if (bVar.mo11205a() == 8) {
                        str = null;
                    } else if (bVar.mo11205a() == 4) {
                        str = bVar.mo11233l();
                    } else {
                        throw new JSONException(str4);
                    }
                } else if ("methodName".equals(a)) {
                    if (bVar.mo11205a() == 8) {
                        str2 = null;
                    } else if (bVar.mo11205a() == 4) {
                        str2 = bVar.mo11233l();
                    } else {
                        throw new JSONException(str4);
                    }
                } else if ("fileName".equals(a)) {
                    if (bVar.mo11205a() == 8) {
                        str3 = null;
                    } else if (bVar.mo11205a() == 4) {
                        str3 = bVar.mo11233l();
                    } else {
                        throw new JSONException(str4);
                    }
                } else if ("lineNumber".equals(a)) {
                    if (bVar.mo11205a() == 8) {
                        i = 0;
                    } else if (bVar.mo11205a() == 2) {
                        i = bVar.mo11235n();
                    } else {
                        throw new JSONException(str4);
                    }
                } else if (!"nativeMethod".equals(a)) {
                    String str5 = "syntax error : ";
                    if (a == JSON.DEFAULT_TYPE_KEY) {
                        if (bVar.mo11205a() == 4) {
                            String l = bVar.mo11233l();
                            if (!l.equals("java.lang.StackTraceElement")) {
                                StringBuilder sb = new StringBuilder();
                                sb.append(str5);
                                sb.append(l);
                                throw new JSONException(sb.toString());
                            }
                        } else if (bVar.mo11205a() != 8) {
                            throw new JSONException(str4);
                        }
                    } else if ("moduleName".equals(a)) {
                        if (bVar.mo11205a() != 8) {
                            if (bVar.mo11205a() == 4) {
                                bVar.mo11233l();
                            } else {
                                throw new JSONException(str4);
                            }
                        }
                    } else if ("moduleVersion".equals(a)) {
                        if (bVar.mo11205a() != 8) {
                            if (bVar.mo11205a() == 4) {
                                bVar.mo11233l();
                            } else {
                                throw new JSONException(str4);
                            }
                        }
                    } else if (!"classLoaderName".equals(a)) {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append(str5);
                        sb2.append(a);
                        throw new JSONException(sb2.toString());
                    } else if (bVar.mo11205a() != 8) {
                        if (bVar.mo11205a() == 4) {
                            bVar.mo11233l();
                        } else {
                            throw new JSONException(str4);
                        }
                    }
                } else if (bVar.mo11205a() == 8) {
                    bVar.mo11211a(16);
                } else if (bVar.mo11205a() == 6) {
                    bVar.mo11211a(16);
                } else if (bVar.mo11205a() == 7) {
                    bVar.mo11211a(16);
                } else {
                    throw new JSONException(str4);
                }
                if (bVar.mo11205a() == 13) {
                    bVar.mo11211a(16);
                    break;
                }
            }
            return new StackTraceElement(str, str2, str3, i);
        } else {
            StringBuilder sb3 = new StringBuilder();
            sb3.append("syntax error: ");
            sb3.append(JSONToken.m2903a(bVar.mo11205a()));
            throw new JSONException(sb3.toString());
        }
    }
}
