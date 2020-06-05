package com.tencent.stat.apkreader;

import java.util.Map;

public class ChannelInfo {
    /* renamed from: a */
    private final String f25593a;
    /* renamed from: b */
    private final Map<String, String> f25594b;

    public ChannelInfo(String str, Map<String, String> map) {
        this.f25593a = str;
        this.f25594b = map;
    }

    public String getChannel() {
        return this.f25593a;
    }

    public Map<String, String> getExtraInfo() {
        return this.f25594b;
    }
}
