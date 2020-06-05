package com.alibaba.mtl.appmonitor.p070c;

import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.alibaba.mtl.appmonitor.c.e */
public class ReuseJSONObject extends JSONObject implements Reusable {
    /* renamed from: a */
    public void mo11548a(Object... objArr) {
    }

    /* renamed from: d */
    public void mo11546d() {
        Iterator keys = keys();
        if (keys != null) {
            while (keys.hasNext()) {
                try {
                    Object obj = get((String) keys.next());
                    if (obj != null && (obj instanceof Reusable)) {
                        BalancedPool.m3491a().mo11628a((Reusable) obj);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
