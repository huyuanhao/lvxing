package com.alibaba.mtl.log.p074a;

import com.alibaba.mtl.log.p077d.Logger;
import com.tencent.android.tpush.common.MessageKey;
import discoveryAD.C7880W.C7881a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.alibaba.mtl.log.a.d */
public class HostConfigMgr {
    /* renamed from: a */
    private static HostConfigMgr f3306a = new HostConfigMgr();
    /* renamed from: b */
    private Map<String, HostConfig> f3307b = Collections.synchronizedMap(new HashMap());
    /* renamed from: c */
    private String f3308c;

    /* renamed from: a */
    public static HostConfigMgr m3724a() {
        return f3306a;
    }

    /* renamed from: a */
    public void mo11765a(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("host config:");
        sb.append(str);
        Logger.m3833a("HostConfigMgr", sb.toString());
        if (str != null) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                JSONObject jSONObject2 = jSONObject.getJSONObject(MessageKey.MSG_CONTENT);
                if (jSONObject2 != null) {
                    JSONObject jSONObject3 = jSONObject2.getJSONObject("hosts");
                    if (jSONObject3 != null) {
                        Iterator keys = jSONObject3.keys();
                        while (keys.hasNext()) {
                            String str2 = (String) keys.next();
                            if (str2 != null) {
                                HostConfig cVar = new HostConfig();
                                JSONObject jSONObject4 = jSONObject3.getJSONObject(str2);
                                if (jSONObject4 != null) {
                                    cVar.f3305c = str2.substring(1);
                                    cVar.f3303a = jSONObject4.getString("host");
                                    JSONArray jSONArray = jSONObject4.getJSONArray("eids");
                                    if (jSONArray != null) {
                                        cVar.f3304b = new ArrayList<>();
                                        for (int i = 0; i < jSONArray.length(); i++) {
                                            cVar.f3304b.add(jSONArray.getString(i));
                                        }
                                    }
                                }
                                Map<String, HostConfig> map = this.f3307b;
                                StringBuilder sb2 = new StringBuilder();
                                sb2.append(cVar.f3305c);
                                sb2.append("");
                                map.put(sb2.toString(), cVar);
                            }
                        }
                    }
                }
                this.f3308c = jSONObject.getString(C7881a.TIMESTAMP);
            } catch (Throwable unused) {
            }
        }
    }

    /* renamed from: b */
    public Map<String, HostConfig> mo11766b() {
        return this.f3307b;
    }
}
