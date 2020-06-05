package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.Map;
import java.util.Map.Entry;
import sun.reflect.annotation.AnnotationType;

/* renamed from: com.alibaba.fastjson.serializer.d */
public class AnnotationSerializer implements ObjectSerializer {
    /* renamed from: a */
    public static AnnotationSerializer f2931a = new AnnotationSerializer();

    /* renamed from: a */
    public void mo11198a(JSONSerializer agVar, Object obj, Object obj2, Type type, int i) throws IOException {
        Class[] interfaces = obj.getClass().getInterfaces();
        if (interfaces.length == 1 && interfaces[0].isAnnotation()) {
            Map members = AnnotationType.getInstance(interfaces[0]).members();
            JSONObject jSONObject = new JSONObject(members.size());
            Object obj3 = null;
            for (Entry entry : members.entrySet()) {
                try {
                    obj3 = ((Method) entry.getValue()).invoke(obj, new Object[0]);
                } catch (IllegalAccessException | InvocationTargetException unused) {
                }
                jSONObject.put((String) entry.getKey(), JSON.toJSON(obj3));
            }
            agVar.mo11325c(jSONObject);
        }
    }
}
