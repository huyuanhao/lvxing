package com.tencent.stat.apkreader;

import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public final class ChannelReader {
    public static final String CHANNEL_KEY = "channel";

    private ChannelReader() {
    }

    public static ChannelInfo get(File file) {
        Map map = getMap(file);
        if (map == null) {
            return null;
        }
        String str = CHANNEL_KEY;
        String str2 = (String) map.get(str);
        map.remove(str);
        return new ChannelInfo(str2, map);
    }

    public static Map<String, String> getMap(File file) {
        try {
            String raw = getRaw(file);
            if (raw == null) {
                return null;
            }
            JSONObject jSONObject = new JSONObject(raw);
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

    public static String getRaw(File file) {
        return C7582c.m32702a(file, 1903654775);
    }
}
