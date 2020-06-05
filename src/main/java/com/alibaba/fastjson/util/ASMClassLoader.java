package com.alibaba.fastjson.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONAware;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONPath;
import com.alibaba.fastjson.JSONPathException;
import com.alibaba.fastjson.JSONReader;
import com.alibaba.fastjson.JSONStreamAware;
import com.alibaba.fastjson.JSONWriter;
import com.alibaba.fastjson.TypeReference;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.fastjson.parser.JSONLexerBase;
import com.alibaba.fastjson.parser.JSONReaderScanner;
import com.alibaba.fastjson.parser.JSONScanner;
import com.alibaba.fastjson.parser.JSONToken;
import com.alibaba.fastjson.parser.ParseContext;
import com.alibaba.fastjson.parser.ParserConfig;
import com.alibaba.fastjson.parser.SymbolTable;
import com.alibaba.fastjson.parser.p066a.AutowiredObjectDeserializer;
import com.alibaba.fastjson.parser.p066a.DefaultFieldDeserializer;
import com.alibaba.fastjson.parser.p066a.ExtraProcessable;
import com.alibaba.fastjson.parser.p066a.ExtraProcessor;
import com.alibaba.fastjson.parser.p066a.ExtraTypeProvider;
import com.alibaba.fastjson.parser.p066a.FieldDeserializer;
import com.alibaba.fastjson.parser.p066a.JavaBeanDeserializer;
import com.alibaba.fastjson.parser.p066a.ObjectDeserializer;
import com.alibaba.fastjson.serializer.AfterFilter;
import com.alibaba.fastjson.serializer.BeanContext;
import com.alibaba.fastjson.serializer.BeforeFilter;
import com.alibaba.fastjson.serializer.ContextObjectSerializer;
import com.alibaba.fastjson.serializer.ContextValueFilter;
import com.alibaba.fastjson.serializer.JSONSerializer;
import com.alibaba.fastjson.serializer.JavaBeanSerializer;
import com.alibaba.fastjson.serializer.LabelFilter;
import com.alibaba.fastjson.serializer.Labels;
import com.alibaba.fastjson.serializer.NameFilter;
import com.alibaba.fastjson.serializer.ObjectSerializer;
import com.alibaba.fastjson.serializer.PropertyFilter;
import com.alibaba.fastjson.serializer.PropertyPreFilter;
import com.alibaba.fastjson.serializer.SerialContext;
import com.alibaba.fastjson.serializer.SerializeBeanInfo;
import com.alibaba.fastjson.serializer.SerializeConfig;
import com.alibaba.fastjson.serializer.SerializeFilter;
import com.alibaba.fastjson.serializer.SerializeFilterable;
import com.alibaba.fastjson.serializer.SerializeWriter;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.serializer.ValueFilter;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.security.ProtectionDomain;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.alibaba.fastjson.util.a */
public class ASMClassLoader extends ClassLoader {
    /* renamed from: a */
    private static ProtectionDomain f2988a = ((ProtectionDomain) AccessController.doPrivileged(new PrivilegedAction<Object>() {
        public Object run() {
            return ASMClassLoader.class.getProtectionDomain();
        }
    }));
    /* renamed from: b */
    private static Map<String, Class<?>> f2989b = new HashMap();

    static {
        Class[] clsArr;
        for (Class cls : new Class[]{JSON.class, JSONObject.class, JSONArray.class, JSONPath.class, JSONAware.class, JSONException.class, JSONPathException.class, JSONReader.class, JSONStreamAware.class, JSONWriter.class, TypeReference.class, FieldInfo.class, TypeUtils.class, IOUtils.class, IdentityHashMap.class, ParameterizedTypeImpl.class, JavaBeanInfo.class, ObjectSerializer.class, JavaBeanSerializer.class, SerializeFilterable.class, SerializeBeanInfo.class, JSONSerializer.class, SerializeWriter.class, SerializeFilter.class, Labels.class, LabelFilter.class, ContextValueFilter.class, AfterFilter.class, BeforeFilter.class, NameFilter.class, PropertyFilter.class, PropertyPreFilter.class, ValueFilter.class, SerializerFeature.class, ContextObjectSerializer.class, SerialContext.class, SerializeConfig.class, JavaBeanDeserializer.class, ParserConfig.class, DefaultJSONParser.class, JSONLexer.class, JSONLexerBase.class, ParseContext.class, JSONToken.class, SymbolTable.class, Feature.class, JSONScanner.class, JSONReaderScanner.class, AutowiredObjectDeserializer.class, ObjectDeserializer.class, ExtraProcessor.class, ExtraProcessable.class, ExtraTypeProvider.class, BeanContext.class, FieldDeserializer.class, DefaultFieldDeserializer.class}) {
            f2989b.put(cls.getName(), cls);
        }
    }

    public ASMClassLoader() {
        super(m3164a());
    }

    public ASMClassLoader(ClassLoader classLoader) {
        super(classLoader);
    }

    /* renamed from: a */
    static ClassLoader m3164a() {
        ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
        if (contextClassLoader != null) {
            try {
                contextClassLoader.loadClass(JSON.class.getName());
                return contextClassLoader;
            } catch (ClassNotFoundException unused) {
            }
        }
        return JSON.class.getClassLoader();
    }

    /* access modifiers changed from: protected */
    public Class<?> loadClass(String str, boolean z) throws ClassNotFoundException {
        Class<?> cls = (Class) f2989b.get(str);
        if (cls != null) {
            return cls;
        }
        try {
            return super.loadClass(str, z);
        } catch (ClassNotFoundException e) {
            throw e;
        }
    }

    /* renamed from: a */
    public Class<?> mo11495a(String str, byte[] bArr, int i, int i2) throws ClassFormatError {
        return defineClass(str, bArr, i, i2, f2988a);
    }

    /* renamed from: a */
    public boolean mo11496a(Class<?> cls) {
        ClassLoader classLoader = cls.getClassLoader();
        if (classLoader == null) {
            return false;
        }
        for (ClassLoader classLoader2 = this; classLoader2 != null; classLoader2 = classLoader2.getParent()) {
            if (classLoader2 == classLoader) {
                return false;
            }
        }
        return true;
    }
}
