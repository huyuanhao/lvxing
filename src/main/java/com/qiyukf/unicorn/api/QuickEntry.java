package com.qiyukf.unicorn.api;

import com.qiyukf.unicorn.p502e.C6047e;

public class QuickEntry implements C6047e {
    private String iconUrl;
    /* renamed from: id */
    private long f18814id;
    private String name;

    public QuickEntry(long j, String str, String str2) {
        this.f18814id = j;
        this.name = str;
        this.iconUrl = str2;
    }

    public String getIconUrl() {
        return this.iconUrl;
    }

    public long getId() {
        return this.f18814id;
    }

    public String getName() {
        return this.name;
    }

    public void setIconUrl(String str) {
        this.iconUrl = str;
    }

    public void setId(long j) {
        this.f18814id = j;
    }

    public void setName(String str) {
        this.name = str;
    }
}
