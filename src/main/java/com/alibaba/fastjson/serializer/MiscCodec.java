package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONPath;
import com.alibaba.fastjson.JSONStreamAware;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.fastjson.parser.p066a.ObjectDeserializer;
import com.alibaba.fastjson.util.IOUtils;
import com.alibaba.fastjson.util.TypeUtils;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.net.UnknownHostException;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.Currency;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map.Entry;
import java.util.TimeZone;
import java.util.UUID;
import java.util.regex.Pattern;

/* renamed from: com.alibaba.fastjson.serializer.an */
public class MiscCodec implements ObjectDeserializer, ObjectSerializer {
    /* renamed from: a */
    public static final MiscCodec f2864a = new MiscCodec();
    /* renamed from: b */
    private static boolean f2865b = "true".equals(IOUtils.m3190a("fastjson.deserializer.fileRelativePathSupport"));
    /* renamed from: c */
    private static Method f2866c;
    /* renamed from: d */
    private static boolean f2867d = false;

    /* renamed from: g_ */
    public int mo11162g_() {
        return 4;
    }

    /* renamed from: a */
    public void mo11198a(JSONSerializer agVar, Object obj, Object obj2, Type type, int i) throws IOException {
        String str;
        SerializeWriter baVar = agVar.f2846b;
        if (obj == null) {
            baVar.mo11396b();
            return;
        }
        Class<InetSocketAddress> cls = obj.getClass();
        if (cls == SimpleDateFormat.class) {
            str = ((SimpleDateFormat) obj).toPattern();
            if (baVar.mo11391a(SerializerFeature.WriteClassName) && obj.getClass() != type) {
                baVar.write(123);
                baVar.mo11404c(JSON.DEFAULT_TYPE_KEY);
                agVar.mo11323b(obj.getClass().getName());
                baVar.mo11377a(',', "val", str);
                baVar.write(125);
                return;
            }
        } else if (cls == Class.class) {
            str = ((Class) obj).getName();
        } else if (cls == InetSocketAddress.class) {
            InetSocketAddress inetSocketAddress = (InetSocketAddress) obj;
            InetAddress address = inetSocketAddress.getAddress();
            baVar.write(123);
            if (address != null) {
                baVar.mo11404c("address");
                agVar.mo11325c(address);
                baVar.write(44);
            }
            baVar.mo11404c("port");
            baVar.mo11403c(inetSocketAddress.getPort());
            baVar.write(125);
            return;
        } else if (obj instanceof File) {
            str = ((File) obj).getPath();
        } else if (obj instanceof InetAddress) {
            str = ((InetAddress) obj).getHostAddress();
        } else if (obj instanceof TimeZone) {
            str = ((TimeZone) obj).getID();
        } else if (obj instanceof Currency) {
            str = ((Currency) obj).getCurrencyCode();
        } else if (obj instanceof JSONStreamAware) {
            ((JSONStreamAware) obj).writeJSONString(baVar);
            return;
        } else if (obj instanceof Iterator) {
            mo11347a(agVar, baVar, (Iterator) obj);
            return;
        } else if (obj instanceof Iterable) {
            mo11347a(agVar, baVar, ((Iterable) obj).iterator());
            return;
        } else if (obj instanceof Entry) {
            Entry entry = (Entry) obj;
            Object key = entry.getKey();
            Object value = entry.getValue();
            if (key instanceof String) {
                String str2 = (String) key;
                if (value instanceof String) {
                    baVar.mo11397b('{', str2, (String) value);
                } else {
                    baVar.write(123);
                    baVar.mo11404c(str2);
                    agVar.mo11325c(value);
                }
            } else {
                baVar.write(123);
                agVar.mo11325c(key);
                baVar.write(58);
                agVar.mo11325c(value);
            }
            baVar.write(125);
            return;
        } else if (obj.getClass().getName().equals("net.sf.json.JSONNull")) {
            baVar.mo11396b();
            return;
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append("not support class : ");
            sb.append(cls);
            throw new JSONException(sb.toString());
        }
        baVar.mo11384a(str);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo11347a(JSONSerializer agVar, SerializeWriter baVar, Iterator<?> it) {
        baVar.write(91);
        int i = 0;
        while (it.hasNext()) {
            if (i != 0) {
                baVar.write(44);
            }
            agVar.mo11325c(it.next());
            i++;
        }
        baVar.write(93);
    }

    /* renamed from: a */
    public <T> T mo11161a(DefaultJSONParser aVar, Type type, Object obj) {
        Object obj2;
        String str;
        String str2 = "Path deserialize erorr";
        JSONLexer bVar = aVar.f2689d;
        InetAddress inetAddress = null;
        int i = 0;
        if (type != InetSocketAddress.class) {
            if (aVar.f2691f == 2) {
                aVar.f2691f = 0;
                aVar.mo11139b(16);
                String str3 = "syntax error";
                if (bVar.mo11205a() == 4) {
                    if ("val".equals(bVar.mo11233l())) {
                        bVar.mo11222d();
                        aVar.mo11139b(17);
                        obj2 = aVar.mo11155m();
                        aVar.mo11139b(13);
                    } else {
                        throw new JSONException(str3);
                    }
                } else {
                    throw new JSONException(str3);
                }
            } else {
                obj2 = aVar.mo11155m();
            }
            if (obj2 == null) {
                str = null;
            } else if (obj2 instanceof String) {
                str = (String) obj2;
            } else if (obj2 instanceof JSONObject) {
                JSONObject jSONObject = (JSONObject) obj2;
                if (type == Currency.class) {
                    String string = jSONObject.getString("currency");
                    if (string != null) {
                        return Currency.getInstance(string);
                    }
                    String string2 = jSONObject.getString("currencyCode");
                    if (string2 != null) {
                        return Currency.getInstance(string2);
                    }
                }
                if (type == Entry.class) {
                    return jSONObject.entrySet().iterator().next();
                }
                return jSONObject.toJavaObject(type);
            } else {
                throw new JSONException("expect string");
            }
            if (str == null || str.length() == 0) {
                return null;
            }
            if (type == UUID.class) {
                return UUID.fromString(str);
            }
            if (type == URI.class) {
                return URI.create(str);
            }
            if (type == URL.class) {
                try {
                    return new URL(str);
                } catch (MalformedURLException e) {
                    throw new JSONException("create url error", e);
                }
            } else if (type == Pattern.class) {
                return Pattern.compile(str);
            } else {
                if (type == Locale.class) {
                    return TypeUtils.m3246b(str);
                }
                if (type == SimpleDateFormat.class) {
                    T simpleDateFormat = new SimpleDateFormat(str, bVar.mo11244w());
                    simpleDateFormat.setTimeZone(bVar.mo11243v());
                    return simpleDateFormat;
                } else if (type == InetAddress.class || type == Inet4Address.class || type == Inet6Address.class) {
                    try {
                        return InetAddress.getByName(str);
                    } catch (UnknownHostException e2) {
                        throw new JSONException("deserialize inet adress error", e2);
                    }
                } else if (type == File.class) {
                    if (str.indexOf("..") < 0 || f2865b) {
                        return new File(str);
                    }
                    throw new JSONException("file relative path not support.");
                } else if (type == TimeZone.class) {
                    return TimeZone.getTimeZone(str);
                } else {
                    if (type instanceof ParameterizedType) {
                        type = ((ParameterizedType) type).getRawType();
                    }
                    if (type == Class.class) {
                        return TypeUtils.m3219a(str, aVar.mo11146d().mo11300c());
                    }
                    if (type == Charset.class) {
                        return Charset.forName(str);
                    }
                    if (type == Currency.class) {
                        return Currency.getInstance(str);
                    }
                    if (type == JSONPath.class) {
                        return new JSONPath(str);
                    }
                    String str4 = "MiscCodec not support ";
                    if (type instanceof Class) {
                        String name = ((Class) type).getName();
                        if (name.equals("java.nio.file.Path")) {
                            try {
                                if (f2866c == null && !f2867d) {
                                    f2866c = TypeUtils.m3250c("java.nio.file.Paths").getMethod("get", new Class[]{String.class, String[].class});
                                }
                                if (f2866c != null) {
                                    return f2866c.invoke(null, new Object[]{str, new String[0]});
                                }
                                throw new JSONException(str2);
                            } catch (NoSuchMethodException unused) {
                                f2867d = true;
                            } catch (IllegalAccessException e3) {
                                throw new JSONException(str2, e3);
                            } catch (InvocationTargetException e4) {
                                throw new JSONException(str2, e4);
                            }
                        }
                        StringBuilder sb = new StringBuilder();
                        sb.append(str4);
                        sb.append(name);
                        throw new JSONException(sb.toString());
                    }
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(str4);
                    sb2.append(type.toString());
                    throw new JSONException(sb2.toString());
                }
            }
        } else if (bVar.mo11205a() == 8) {
            bVar.mo11222d();
            return null;
        } else {
            aVar.mo11139b(12);
            while (true) {
                String l = bVar.mo11233l();
                bVar.mo11211a(17);
                if (l.equals("address")) {
                    aVar.mo11139b(17);
                    inetAddress = (InetAddress) aVar.mo11116a(InetAddress.class);
                } else if (l.equals("port")) {
                    aVar.mo11139b(17);
                    if (bVar.mo11205a() == 2) {
                        int n = bVar.mo11235n();
                        bVar.mo11222d();
                        i = n;
                    } else {
                        throw new JSONException("port is not int");
                    }
                } else {
                    aVar.mo11139b(17);
                    aVar.mo11155m();
                }
                if (bVar.mo11205a() == 16) {
                    bVar.mo11222d();
                } else {
                    aVar.mo11139b(13);
                    return new InetSocketAddress(inetAddress, i);
                }
            }
        }
    }
}
