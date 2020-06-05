package com.alibaba.fastjson.support.p067a;

import com.alibaba.fastjson.serializer.JSONSerializer;
import com.alibaba.fastjson.serializer.ObjectSerializer;
import java.io.IOException;
import java.lang.reflect.Type;
import springfox.documentation.spring.web.json.Json;

/* renamed from: com.alibaba.fastjson.support.a.a */
public class SwaggerJsonSerializer implements ObjectSerializer {
    /* renamed from: a */
    public static final SwaggerJsonSerializer f2972a = new SwaggerJsonSerializer();

    /* renamed from: a */
    public void mo11198a(JSONSerializer agVar, Object obj, Object obj2, Type type, int i) throws IOException {
        agVar.mo11328f().write(((Json) obj).value());
    }
}
