package com.alibaba.fastjson;

import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.fastjson.parser.ParserConfig;
import com.alibaba.fastjson.parser.p066a.ExtraProcessor;
import com.alibaba.fastjson.parser.p066a.ExtraTypeProvider;
import com.alibaba.fastjson.parser.p066a.FieldTypeResolver;
import com.alibaba.fastjson.parser.p066a.ParseProcess;
import com.alibaba.fastjson.serializer.JSONSerializable;
import com.alibaba.fastjson.serializer.JSONSerializer;
import com.alibaba.fastjson.serializer.JavaBeanSerializer;
import com.alibaba.fastjson.serializer.ObjectSerializer;
import com.alibaba.fastjson.serializer.SerializeConfig;
import com.alibaba.fastjson.serializer.SerializeFilter;
import com.alibaba.fastjson.serializer.SerializeWriter;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.util.IOUtils;
import com.alibaba.fastjson.util.TypeUtils;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Writer;
import java.lang.reflect.Array;
import java.lang.reflect.Type;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TimeZone;
import java.util.TreeMap;

/* renamed from: com.alibaba.fastjson.a */
public abstract class JSON implements JSONAware, JSONStreamAware {
    public static int DEFAULT_GENERATE_FEATURE = 0;
    public static int DEFAULT_PARSER_FEATURE = ((((((((Feature.AutoCloseSource.getMask() | 0) | Feature.InternFieldNames.getMask()) | Feature.UseBigDecimal.getMask()) | Feature.AllowUnQuotedFieldNames.getMask()) | Feature.AllowSingleQuotes.getMask()) | Feature.AllowArbitraryCommas.getMask()) | Feature.SortFeidFastMatch.getMask()) | Feature.IgnoreNotMatch.getMask());
    public static String DEFAULT_TYPE_KEY = "@type";
    public static String DEFFAULT_DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";
    public static final String VERSION = "1.2.41";
    private static final ThreadLocal<byte[]> bytesLocal = new ThreadLocal<>();
    private static final ThreadLocal<char[]> charsLocal = new ThreadLocal<>();
    public static Locale defaultLocale = Locale.getDefault();
    public static TimeZone defaultTimeZone = TimeZone.getDefault();
    static final SerializeFilter[] emptyFilters = new SerializeFilter[0];

    static {
        int mask = 0 | SerializerFeature.QuoteFieldNames.getMask() | SerializerFeature.SkipTransientField.getMask() | SerializerFeature.WriteEnumUsingName.getMask() | SerializerFeature.SortField.getMask();
        String a = IOUtils.m3190a("fastjson.serializerFeatures.MapSortField");
        int mask2 = SerializerFeature.MapSortField.getMask();
        if ("true".equals(a)) {
            mask |= mask2;
        } else if ("false".equals(a)) {
            mask &= ~mask2;
        }
        DEFAULT_GENERATE_FEATURE = mask;
    }

    public static void setDefaultTypeKey(String str) {
        DEFAULT_TYPE_KEY = str;
        ParserConfig.f2801c.f2805d.mo11302a(str, 0, str.length(), str.hashCode(), true);
    }

    public static Object parse(String str) {
        return parse(str, DEFAULT_PARSER_FEATURE);
    }

    public static Object parse(String str, ParserConfig hVar) {
        return parse(str, hVar, DEFAULT_PARSER_FEATURE);
    }

    public static Object parse(String str, ParserConfig hVar, int i) {
        if (str == null) {
            return null;
        }
        DefaultJSONParser aVar = new DefaultJSONParser(str, hVar, i);
        Object m = aVar.mo11155m();
        aVar.mo11144c(m);
        aVar.close();
        return m;
    }

    public static Object parse(String str, int i) {
        return parse(str, ParserConfig.m2904a(), i);
    }

    public static Object parse(byte[] bArr, Feature... featureArr) {
        char[] allocateChars = allocateChars(bArr.length);
        int a = IOUtils.m3188a(bArr, 0, bArr.length, allocateChars);
        if (a < 0) {
            return null;
        }
        return parse(new String(allocateChars, 0, a), featureArr);
    }

    public static Object parse(byte[] bArr, int i, int i2, CharsetDecoder charsetDecoder, Feature... featureArr) {
        if (bArr == null || bArr.length == 0) {
            return null;
        }
        int i3 = DEFAULT_PARSER_FEATURE;
        for (Feature config : featureArr) {
            i3 = Feature.config(i3, config, true);
        }
        return parse(bArr, i, i2, charsetDecoder, i3);
    }

    public static Object parse(byte[] bArr, int i, int i2, CharsetDecoder charsetDecoder, int i3) {
        charsetDecoder.reset();
        char[] allocateChars = allocateChars((int) (((double) i2) * ((double) charsetDecoder.maxCharsPerByte())));
        ByteBuffer wrap = ByteBuffer.wrap(bArr, i, i2);
        CharBuffer wrap2 = CharBuffer.wrap(allocateChars);
        IOUtils.m3195a(charsetDecoder, wrap, wrap2);
        DefaultJSONParser aVar = new DefaultJSONParser(allocateChars, wrap2.position(), ParserConfig.m2904a(), i3);
        Object m = aVar.mo11155m();
        aVar.mo11144c(m);
        aVar.close();
        return m;
    }

    public static Object parse(String str, Feature... featureArr) {
        int i = DEFAULT_PARSER_FEATURE;
        for (Feature config : featureArr) {
            i = Feature.config(i, config, true);
        }
        return parse(str, i);
    }

    public static JSONObject parseObject(String str, Feature... featureArr) {
        return (JSONObject) parse(str, featureArr);
    }

    public static JSONObject parseObject(String str) {
        Object parse = parse(str);
        if (parse instanceof JSONObject) {
            return (JSONObject) parse;
        }
        try {
            return (JSONObject) toJSON(parse);
        } catch (RuntimeException e) {
            throw new JSONException("can not cast to JSONObject.", e);
        }
    }

    public static <T> T parseObject(String str, TypeReference<T> hVar, Feature... featureArr) {
        return parseObject(str, hVar.f2684b, ParserConfig.f2801c, DEFAULT_PARSER_FEATURE, featureArr);
    }

    public static <T> T parseObject(String str, Class<T> cls, Feature... featureArr) {
        return parseObject(str, (Type) cls, ParserConfig.f2801c, (ParseProcess) null, DEFAULT_PARSER_FEATURE, featureArr);
    }

    public static <T> T parseObject(String str, Class<T> cls, ParseProcess uVar, Feature... featureArr) {
        return parseObject(str, (Type) cls, ParserConfig.f2801c, uVar, DEFAULT_PARSER_FEATURE, featureArr);
    }

    public static <T> T parseObject(String str, Type type, Feature... featureArr) {
        return parseObject(str, type, ParserConfig.f2801c, DEFAULT_PARSER_FEATURE, featureArr);
    }

    public static <T> T parseObject(String str, Type type, ParseProcess uVar, Feature... featureArr) {
        return parseObject(str, type, ParserConfig.f2801c, uVar, DEFAULT_PARSER_FEATURE, featureArr);
    }

    public static <T> T parseObject(String str, Type type, int i, Feature... featureArr) {
        if (str == null) {
            return null;
        }
        for (Feature config : featureArr) {
            i = Feature.config(i, config, true);
        }
        DefaultJSONParser aVar = new DefaultJSONParser(str, ParserConfig.m2904a(), i);
        T a = aVar.mo11117a(type);
        aVar.mo11144c((Object) a);
        aVar.close();
        return a;
    }

    public static <T> T parseObject(String str, Type type, ParserConfig hVar, Feature... featureArr) {
        return parseObject(str, type, hVar, (ParseProcess) null, DEFAULT_PARSER_FEATURE, featureArr);
    }

    public static <T> T parseObject(String str, Type type, ParserConfig hVar, int i, Feature... featureArr) {
        return parseObject(str, type, hVar, (ParseProcess) null, i, featureArr);
    }

    public static <T> T parseObject(String str, Type type, ParserConfig hVar, ParseProcess uVar, int i, Feature... featureArr) {
        if (str == null) {
            return null;
        }
        if (featureArr != null) {
            for (Feature feature : featureArr) {
                i |= feature.mask;
            }
        }
        DefaultJSONParser aVar = new DefaultJSONParser(str, hVar, i);
        if (uVar != null) {
            if (uVar instanceof ExtraTypeProvider) {
                aVar.mo11152j().add((ExtraTypeProvider) uVar);
            }
            if (uVar instanceof ExtraProcessor) {
                aVar.mo11151i().add((ExtraProcessor) uVar);
            }
            if (uVar instanceof FieldTypeResolver) {
                aVar.mo11124a((FieldTypeResolver) uVar);
            }
        }
        T a = aVar.mo11118a(type, (Object) null);
        aVar.mo11144c((Object) a);
        aVar.close();
        return a;
    }

    public static <T> T parseObject(byte[] bArr, Type type, Feature... featureArr) {
        return parseObject(bArr, 0, bArr.length, IOUtils.f3014b, type, featureArr);
    }

    public static <T> T parseObject(byte[] bArr, int i, int i2, Charset charset, Type type, Feature... featureArr) {
        String str;
        if (charset == null) {
            charset = IOUtils.f3014b;
        }
        if (charset == IOUtils.f3014b) {
            char[] allocateChars = allocateChars(bArr.length);
            int a = IOUtils.m3188a(bArr, i, i2, allocateChars);
            if (a < 0) {
                return null;
            }
            str = new String(allocateChars, 0, a);
        } else if (i2 < 0) {
            return null;
        } else {
            str = new String(bArr, i, i2, charset);
        }
        return parseObject(str, type, featureArr);
    }

    public static <T> T parseObject(byte[] bArr, int i, int i2, CharsetDecoder charsetDecoder, Type type, Feature... featureArr) {
        charsetDecoder.reset();
        char[] allocateChars = allocateChars((int) (((double) i2) * ((double) charsetDecoder.maxCharsPerByte())));
        ByteBuffer wrap = ByteBuffer.wrap(bArr, i, i2);
        CharBuffer wrap2 = CharBuffer.wrap(allocateChars);
        IOUtils.m3195a(charsetDecoder, wrap, wrap2);
        return parseObject(allocateChars, wrap2.position(), type, featureArr);
    }

    public static <T> T parseObject(char[] cArr, int i, Type type, Feature... featureArr) {
        if (cArr == null || cArr.length == 0) {
            return null;
        }
        int i2 = DEFAULT_PARSER_FEATURE;
        for (Feature config : featureArr) {
            i2 = Feature.config(i2, config, true);
        }
        DefaultJSONParser aVar = new DefaultJSONParser(cArr, i, ParserConfig.m2904a(), i2);
        T a = aVar.mo11117a(type);
        aVar.mo11144c((Object) a);
        aVar.close();
        return a;
    }

    public static <T> T parseObject(InputStream inputStream, Type type, Feature... featureArr) throws IOException {
        return parseObject(inputStream, IOUtils.f3014b, type, featureArr);
    }

    public static <T> T parseObject(InputStream inputStream, Charset charset, Type type, Feature... featureArr) throws IOException {
        if (charset == null) {
            charset = IOUtils.f3014b;
        }
        Charset charset2 = charset;
        byte[] allocateBytes = allocateBytes(65536);
        int i = 0;
        while (true) {
            int read = inputStream.read(allocateBytes, i, allocateBytes.length - i);
            if (read == -1) {
                return parseObject(allocateBytes, 0, i, charset2, type, featureArr);
            }
            i += read;
            if (i == allocateBytes.length) {
                byte[] bArr = new byte[((allocateBytes.length * 3) / 2)];
                System.arraycopy(allocateBytes, 0, bArr, 0, allocateBytes.length);
                allocateBytes = bArr;
            }
        }
    }

    public static <T> T parseObject(String str, Class<T> cls) {
        return parseObject(str, cls, new Feature[0]);
    }

    public static JSONArray parseArray(String str) {
        JSONArray jSONArray = null;
        if (str == null) {
            return null;
        }
        DefaultJSONParser aVar = new DefaultJSONParser(str, ParserConfig.m2904a());
        JSONLexer bVar = aVar.f2689d;
        if (bVar.mo11205a() == 8) {
            bVar.mo11222d();
        } else if (bVar.mo11205a() != 20) {
            jSONArray = new JSONArray();
            aVar.mo11140b((Collection) jSONArray);
            aVar.mo11144c((Object) jSONArray);
        }
        aVar.close();
        return jSONArray;
    }

    public static <T> List<T> parseArray(String str, Class<T> cls) {
        ArrayList arrayList = null;
        if (str == null) {
            return null;
        }
        DefaultJSONParser aVar = new DefaultJSONParser(str, ParserConfig.m2904a());
        JSONLexer bVar = aVar.f2689d;
        int a = bVar.mo11205a();
        if (a == 8) {
            bVar.mo11222d();
        } else if (a != 20 || !bVar.mo11237p()) {
            arrayList = new ArrayList();
            aVar.mo11126a(cls, (Collection) arrayList);
            aVar.mo11144c((Object) arrayList);
        }
        aVar.close();
        return arrayList;
    }

    public static List<Object> parseArray(String str, Type[] typeArr) {
        List<Object> list = null;
        if (str == null) {
            return null;
        }
        DefaultJSONParser aVar = new DefaultJSONParser(str, ParserConfig.m2904a());
        Object[] a = aVar.mo11135a(typeArr);
        if (a != null) {
            list = Arrays.asList(a);
        }
        aVar.mo11144c((Object) list);
        aVar.close();
        return list;
    }

    public static String toJSONString(Object obj) {
        return toJSONString(obj, emptyFilters, new SerializerFeature[0]);
    }

    public static String toJSONString(Object obj, SerializerFeature... serializerFeatureArr) {
        return toJSONString(obj, DEFAULT_GENERATE_FEATURE, serializerFeatureArr);
    }

    public static String toJSONString(Object obj, int i, SerializerFeature... serializerFeatureArr) {
        SerializeWriter baVar = new SerializeWriter(null, i, serializerFeatureArr);
        try {
            new JSONSerializer(baVar).mo11325c(obj);
            return baVar.toString();
        } finally {
            baVar.close();
        }
    }

    public static String toJSONStringWithDateFormat(Object obj, String str, SerializerFeature... serializerFeatureArr) {
        return toJSONString(obj, SerializeConfig.f2882a, null, str, DEFAULT_GENERATE_FEATURE, serializerFeatureArr);
    }

    public static String toJSONString(Object obj, SerializeFilter ayVar, SerializerFeature... serializerFeatureArr) {
        return toJSONString(obj, SerializeConfig.f2882a, new SerializeFilter[]{ayVar}, null, DEFAULT_GENERATE_FEATURE, serializerFeatureArr);
    }

    public static String toJSONString(Object obj, SerializeFilter[] ayVarArr, SerializerFeature... serializerFeatureArr) {
        return toJSONString(obj, SerializeConfig.f2882a, ayVarArr, null, DEFAULT_GENERATE_FEATURE, serializerFeatureArr);
    }

    public static byte[] toJSONBytes(Object obj, SerializerFeature... serializerFeatureArr) {
        return toJSONBytes(obj, DEFAULT_GENERATE_FEATURE, serializerFeatureArr);
    }

    public static byte[] toJSONBytes(Object obj, int i, SerializerFeature... serializerFeatureArr) {
        return toJSONBytes(obj, SerializeConfig.f2882a, i, serializerFeatureArr);
    }

    public static String toJSONString(Object obj, SerializeConfig axVar, SerializerFeature... serializerFeatureArr) {
        return toJSONString(obj, axVar, (SerializeFilter) null, serializerFeatureArr);
    }

    public static String toJSONString(Object obj, SerializeConfig axVar, SerializeFilter ayVar, SerializerFeature... serializerFeatureArr) {
        return toJSONString(obj, axVar, new SerializeFilter[]{ayVar}, null, DEFAULT_GENERATE_FEATURE, serializerFeatureArr);
    }

    public static String toJSONString(Object obj, SerializeConfig axVar, SerializeFilter[] ayVarArr, SerializerFeature... serializerFeatureArr) {
        return toJSONString(obj, axVar, ayVarArr, null, DEFAULT_GENERATE_FEATURE, serializerFeatureArr);
    }

    public static String toJSONString(Object obj, SerializeConfig axVar, SerializeFilter[] ayVarArr, String str, int i, SerializerFeature... serializerFeatureArr) {
        SerializeWriter baVar = new SerializeWriter(null, i, serializerFeatureArr);
        try {
            JSONSerializer agVar = new JSONSerializer(baVar, axVar);
            if (!(str == null || str.length() == 0)) {
                agVar.mo11317a(str);
                agVar.mo11311a(SerializerFeature.WriteDateUseDateFormat, true);
            }
            if (ayVarArr != null) {
                for (SerializeFilter a : ayVarArr) {
                    agVar.mo11357a(a);
                }
            }
            agVar.mo11325c(obj);
            return baVar.toString();
        } finally {
            baVar.close();
        }
    }

    public static String toJSONStringZ(Object obj, SerializeConfig axVar, SerializerFeature... serializerFeatureArr) {
        return toJSONString(obj, axVar, emptyFilters, null, 0, serializerFeatureArr);
    }

    public static byte[] toJSONBytes(Object obj, SerializeConfig axVar, SerializerFeature... serializerFeatureArr) {
        return toJSONBytes(obj, axVar, DEFAULT_GENERATE_FEATURE, serializerFeatureArr);
    }

    public static byte[] toJSONBytes(Object obj, SerializeConfig axVar, int i, SerializerFeature... serializerFeatureArr) {
        SerializeWriter baVar = new SerializeWriter(null, i, serializerFeatureArr);
        try {
            new JSONSerializer(baVar, axVar).mo11325c(obj);
            return baVar.mo11392a(IOUtils.f3014b);
        } finally {
            baVar.close();
        }
    }

    public static String toJSONString(Object obj, boolean z) {
        if (!z) {
            return toJSONString(obj);
        }
        return toJSONString(obj, SerializerFeature.PrettyFormat);
    }

    public static void writeJSONStringTo(Object obj, Writer writer, SerializerFeature... serializerFeatureArr) {
        writeJSONString(writer, obj, serializerFeatureArr);
    }

    public static void writeJSONString(Writer writer, Object obj, SerializerFeature... serializerFeatureArr) {
        writeJSONString(writer, obj, DEFAULT_GENERATE_FEATURE, serializerFeatureArr);
    }

    public static void writeJSONString(Writer writer, Object obj, int i, SerializerFeature... serializerFeatureArr) {
        SerializeWriter baVar = new SerializeWriter(writer, i, serializerFeatureArr);
        try {
            new JSONSerializer(baVar).mo11325c(obj);
        } finally {
            baVar.close();
        }
    }

    public static final int writeJSONString(OutputStream outputStream, Object obj, SerializerFeature... serializerFeatureArr) throws IOException {
        return writeJSONString(outputStream, obj, DEFAULT_GENERATE_FEATURE, serializerFeatureArr);
    }

    public static final int writeJSONString(OutputStream outputStream, Object obj, int i, SerializerFeature... serializerFeatureArr) throws IOException {
        return writeJSONString(outputStream, IOUtils.f3014b, obj, SerializeConfig.f2882a, null, null, i, serializerFeatureArr);
    }

    public static final int writeJSONString(OutputStream outputStream, Charset charset, Object obj, SerializerFeature... serializerFeatureArr) throws IOException {
        return writeJSONString(outputStream, charset, obj, SerializeConfig.f2882a, null, null, DEFAULT_GENERATE_FEATURE, serializerFeatureArr);
    }

    public static final int writeJSONString(OutputStream outputStream, Charset charset, Object obj, SerializeConfig axVar, SerializeFilter[] ayVarArr, String str, int i, SerializerFeature... serializerFeatureArr) throws IOException {
        SerializeWriter baVar = new SerializeWriter(null, i, serializerFeatureArr);
        try {
            JSONSerializer agVar = new JSONSerializer(baVar, axVar);
            if (!(str == null || str.length() == 0)) {
                agVar.mo11317a(str);
                agVar.mo11311a(SerializerFeature.WriteDateUseDateFormat, true);
            }
            if (ayVarArr != null) {
                for (SerializeFilter a : ayVarArr) {
                    agVar.mo11357a(a);
                }
            }
            agVar.mo11325c(obj);
            return baVar.mo11369a(outputStream, charset);
        } finally {
            baVar.close();
        }
    }

    public String toString() {
        return toJSONString();
    }

    public String toJSONString() {
        SerializeWriter baVar = new SerializeWriter();
        try {
            new JSONSerializer(baVar).mo11325c(this);
            return baVar.toString();
        } finally {
            baVar.close();
        }
    }

    public void writeJSONString(Appendable appendable) {
        SerializeWriter baVar = new SerializeWriter();
        try {
            new JSONSerializer(baVar).mo11325c(this);
            appendable.append(baVar.toString());
            baVar.close();
        } catch (IOException e) {
            throw new JSONException(e.getMessage(), e);
        } catch (Throwable th) {
            baVar.close();
            throw th;
        }
    }

    public static Object toJSON(Object obj) {
        return toJSON(obj, SerializeConfig.f2882a);
    }

    public static Object toJSON(Object obj, ParserConfig hVar) {
        return toJSON(obj, SerializeConfig.f2882a);
    }

    public static Object toJSON(Object obj, SerializeConfig axVar) {
        Map map;
        if (obj == null) {
            return null;
        }
        if (obj instanceof JSON) {
            return obj;
        }
        if (obj instanceof Map) {
            Map map2 = (Map) obj;
            int size = map2.size();
            if (map2 instanceof LinkedHashMap) {
                map = new LinkedHashMap(size);
            } else if (map2 instanceof TreeMap) {
                map = new TreeMap();
            } else {
                map = new HashMap(size);
            }
            JSONObject jSONObject = new JSONObject(map);
            for (Entry entry : map2.entrySet()) {
                jSONObject.put(TypeUtils.m3226a(entry.getKey()), toJSON(entry.getValue()));
            }
            return jSONObject;
        } else if (obj instanceof Collection) {
            Collection<Object> collection = (Collection) obj;
            JSONArray jSONArray = new JSONArray(collection.size());
            for (Object json : collection) {
                jSONArray.add(toJSON(json));
            }
            return jSONArray;
        } else if (obj instanceof JSONSerializable) {
            return parse(toJSONString(obj));
        } else {
            Class cls = obj.getClass();
            if (cls.isEnum()) {
                return ((Enum) obj).name();
            }
            if (cls.isArray()) {
                int length = Array.getLength(obj);
                JSONArray jSONArray2 = new JSONArray(length);
                for (int i = 0; i < length; i++) {
                    jSONArray2.add(toJSON(Array.get(obj, i)));
                }
                return jSONArray2;
            } else if (ParserConfig.m2908a(cls)) {
                return obj;
            } else {
                ObjectSerializer b = axVar.mo11355b(cls);
                if (!(b instanceof JavaBeanSerializer)) {
                    return parse(toJSONString(obj));
                }
                JavaBeanSerializer ahVar = (JavaBeanSerializer) b;
                JSONObject jSONObject2 = new JSONObject();
                try {
                    for (Entry entry2 : ahVar.mo11344c(obj).entrySet()) {
                        jSONObject2.put((String) entry2.getKey(), toJSON(entry2.getValue()));
                    }
                    return jSONObject2;
                } catch (Exception e) {
                    throw new JSONException("toJSON error", e);
                }
            }
        }
    }

    public static <T> T toJavaObject(JSON aVar, Class<T> cls) {
        return TypeUtils.m3222a((Object) aVar, cls, ParserConfig.m2904a());
    }

    public <T> T toJavaObject(Class<T> cls) {
        return TypeUtils.m3222a((Object) this, cls, ParserConfig.m2904a());
    }

    public <T> T toJavaObject(Type type) {
        return TypeUtils.m3224a((Object) this, type, ParserConfig.m2904a());
    }

    public <T> T toJavaObject(TypeReference hVar) {
        return TypeUtils.m3224a((Object) this, hVar != null ? hVar.mo11111a() : null, ParserConfig.m2904a());
    }

    private static byte[] allocateBytes(int i) {
        byte[] bArr = (byte[]) bytesLocal.get();
        if (bArr != null) {
            return bArr.length < i ? new byte[i] : bArr;
        }
        if (i > 65536) {
            return new byte[i];
        }
        byte[] bArr2 = new byte[65536];
        bytesLocal.set(bArr2);
        return bArr2;
    }

    private static char[] allocateChars(int i) {
        char[] cArr = (char[]) charsLocal.get();
        if (cArr != null) {
            return cArr.length < i ? new char[i] : cArr;
        }
        if (i > 65536) {
            return new char[i];
        }
        char[] cArr2 = new char[65536];
        charsLocal.set(cArr2);
        return cArr2;
    }

    public static <T> void handleResovleTask(DefaultJSONParser aVar, T t) {
        aVar.mo11144c((Object) t);
    }
}
