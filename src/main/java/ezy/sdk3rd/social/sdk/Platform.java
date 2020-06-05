package ezy.sdk3rd.social.sdk;

import java.util.HashMap;
import java.util.Map;

public class Platform {
    final String appId;
    Map<String, String> extra;
    final String name;

    public Platform(String str, String str2) {
        this.name = str;
        this.appId = str2;
    }

    public String getName() {
        return this.name;
    }

    public String getAppId() {
        return this.appId;
    }

    public String extra(String str) {
        Map<String, String> map = this.extra;
        return map == null ? "" : (String) map.get(str);
    }

    public Platform extra(String str, String str2) {
        if (this.extra == null) {
            this.extra = new HashMap();
        }
        this.extra.put(str, str2);
        return this;
    }
}
