package com.qiyukf.unicorn.p503f.p504a;

import com.qiyukf.basesdk.p412c.C5366b;
import com.qiyukf.unicorn.p503f.p504a.p508b.C6110a;
import com.qiyukf.unicorn.p503f.p504a.p508b.C6111b;
import java.lang.reflect.Field;
import java.util.List;
import org.json.JSONObject;

/* renamed from: com.qiyukf.unicorn.f.a.e */
public abstract class C6144e extends C6118d {
    private void fromObject(JSONObject jSONObject, Object obj) {
        Field[] declaredFields;
        for (Field field : obj.getClass().getDeclaredFields()) {
            C6110a aVar = (C6110a) field.getAnnotation(C6110a.class);
            if (aVar != null) {
                try {
                    field.setAccessible(true);
                    Object obj2 = field.get(obj);
                    if (obj2 != null) {
                        jSONObject.put(aVar.mo29051a(), toJSONable(obj2));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private Object toJSONable(Object obj) {
        if (obj instanceof C6070a) {
            return fromAttachObject((C6070a) obj);
        }
        if (obj instanceof List) {
            r4 = (List) obj;
            for (int i = 0; i < r4.size(); i++) {
                Object obj2 = r4.get(i);
                if (obj2 instanceof C6070a) {
                    r4.set(i, fromAttachObject((C6070a) obj2));
                }
            }
            obj = r4;
        }
        return obj;
    }

    /* access modifiers changed from: protected */
    public JSONObject fromAttachObject(C6070a aVar) {
        JSONObject jSONObject = new JSONObject();
        fromObject(jSONObject, aVar);
        return jSONObject;
    }

    public final int getCmdId() {
        C6111b bVar = (C6111b) getClass().getAnnotation(C6111b.class);
        if (bVar != null) {
            return bVar.mo29052a();
        }
        return 0;
    }

    public final boolean supportOffline() {
        C6111b bVar = (C6111b) getClass().getAnnotation(C6111b.class);
        return bVar != null && bVar.mo29053b();
    }

    public String toJson(boolean z) {
        return toJsonObject(z).toString();
    }

    /* access modifiers changed from: protected */
    public JSONObject toJsonObject(boolean z) {
        JSONObject jSONObject = new JSONObject();
        C5366b.m22029a(jSONObject, "cmd", getCmdId());
        fromObject(jSONObject, this);
        return jSONObject;
    }
}
