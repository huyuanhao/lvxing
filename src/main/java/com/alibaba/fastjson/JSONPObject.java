package com.alibaba.fastjson;

import com.alibaba.fastjson.serializer.JSONSerializable;
import com.alibaba.fastjson.serializer.JSONSerializer;
import com.alibaba.fastjson.serializer.SerializeWriter;
import com.alibaba.fastjson.serializer.SerializerFeature;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.alibaba.fastjson.c */
public class JSONPObject implements JSONSerializable {
    /* renamed from: a */
    public static String f2598a = "/**/";
    /* renamed from: c */
    private static final int f2599c = SerializerFeature.BrowserSecure.mask;
    /* renamed from: b */
    private String f2600b;
    /* renamed from: d */
    private final List<Object> f2601d = new ArrayList();

    public JSONPObject() {
    }

    public JSONPObject(String str) {
        this.f2600b = str;
    }

    /* renamed from: a */
    public void mo11081a(Object obj) {
        this.f2601d.add(obj);
    }

    /* renamed from: a */
    public void mo11080a(JSONSerializer agVar, Object obj, Type type, int i) throws IOException {
        SerializeWriter baVar = agVar.f2846b;
        int i2 = f2599c;
        if ((i & i2) != 0 || baVar.mo11390a(i2)) {
            baVar.write(f2598a);
        }
        baVar.write(this.f2600b);
        baVar.write(40);
        for (int i3 = 0; i3 < this.f2601d.size(); i3++) {
            if (i3 != 0) {
                baVar.write(44);
            }
            agVar.mo11325c(this.f2601d.get(i3));
        }
        baVar.write(41);
    }

    public String toString() {
        return JSON.toJSONString(this);
    }
}
