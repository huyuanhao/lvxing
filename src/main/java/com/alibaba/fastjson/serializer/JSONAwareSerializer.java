package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.JSONAware;
import java.io.IOException;
import java.lang.reflect.Type;

/* renamed from: com.alibaba.fastjson.serializer.ad */
public class JSONAwareSerializer implements ObjectSerializer {
    /* renamed from: a */
    public static JSONAwareSerializer f2843a = new JSONAwareSerializer();

    /* renamed from: a */
    public void mo11198a(JSONSerializer agVar, Object obj, Object obj2, Type type, int i) throws IOException {
        SerializeWriter baVar = agVar.f2846b;
        if (obj == null) {
            baVar.mo11396b();
        } else {
            baVar.write(((JSONAware) obj).toJSONString());
        }
    }
}
