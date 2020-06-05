package com.tencent.stat.hybrid;

import android.text.TextUtils;
import com.tencent.mid.util.Util;
import com.tencent.stat.StatConfig;
import com.tencent.stat.StatServiceImpl;
import java.util.Iterator;
import java.util.Properties;
import org.json.JSONException;
import org.json.JSONObject;

public class StatHybridBridge {
    /* renamed from: a */
    private String f25827a;

    public void onUserLogin(JSONObject jSONObject) throws JSONException {
        String string = jSONObject.getString("uin");
        StatConfig.setCustomUserId(StatHybridHandler.getContext(), string);
        StatServiceImpl.reportQQ(StatHybridHandler.getContext(), string, StatHybridHandler.getH5reportInfo());
    }

    public void trackKVEvent(JSONObject jSONObject) throws JSONException {
        StatServiceImpl.trackCustomKVEvent(StatHybridHandler.getContext(), jSONObject.getString("id"), m32877a(jSONObject.getString("param")), StatHybridHandler.getH5reportInfo());
    }

    public void trackBeginPage(JSONObject jSONObject) throws JSONException {
        String string = jSONObject.getString("title");
        this.f25827a = string;
        StatServiceImpl.trackBeginPage(StatHybridHandler.getContext(), string, StatHybridHandler.getH5reportInfo());
    }

    public void trackEndPage(JSONObject jSONObject) throws JSONException {
        StatServiceImpl.trackEndPage(StatHybridHandler.getContext(), jSONObject.getString("title"), StatHybridHandler.getH5reportInfo());
        this.f25827a = null;
    }

    public void trackPage(JSONObject jSONObject) throws JSONException {
        String string = jSONObject.getString("title");
        if (!TextUtils.isEmpty(this.f25827a)) {
            StatServiceImpl.trackEndPage(StatHybridHandler.getContext(), this.f25827a, StatHybridHandler.getH5reportInfo());
        }
        this.f25827a = string;
        StatServiceImpl.trackBeginPage(StatHybridHandler.getContext(), this.f25827a, StatHybridHandler.getH5reportInfo());
    }

    /* renamed from: a */
    private Properties m32877a(String str) {
        if (Util.isEmpty(str)) {
            return null;
        }
        Properties properties = new Properties();
        try {
            JSONObject jSONObject = new JSONObject(str);
            Iterator keys = jSONObject.keys();
            while (keys.hasNext()) {
                String str2 = (String) keys.next();
                properties.put(str2, jSONObject.get(str2));
            }
        } catch (Throwable unused) {
        }
        return properties;
    }
}
