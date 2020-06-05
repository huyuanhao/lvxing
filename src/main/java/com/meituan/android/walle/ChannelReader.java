package com.meituan.android.walle;

import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.meituan.android.walle.c */
public final class ChannelReader {
    /* renamed from: a */
    public static ChannelInfo m19521a(File file) {
        Map b = m19522b(file);
        if (b == null) {
            return null;
        }
        String str = com.tencent.stat.apkreader.ChannelReader.CHANNEL_KEY;
        String str2 = (String) b.get(str);
        b.remove(str);
        return new ChannelInfo(str2, b);
    }

    /* renamed from: b */
    public static Map<String, String> m19522b(File file) {
        try {
            String c = m19523c(file);
            if (c == null) {
                return null;
            }
            JSONObject jSONObject = new JSONObject(c);
            Iterator keys = jSONObject.keys();
            HashMap hashMap = new HashMap();
            while (keys.hasNext()) {
                String obj = keys.next().toString();
                hashMap.put(obj, jSONObject.getString(obj));
            }
            return hashMap;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    /* renamed from: c */
    public static String m19523c(File file) {
        return PayloadReader.m19526a(file, 1903654775);
    }
}
