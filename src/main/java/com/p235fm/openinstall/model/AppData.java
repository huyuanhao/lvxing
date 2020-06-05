package com.p235fm.openinstall.model;

import android.text.TextUtils;
import java.io.Serializable;

/* renamed from: com.fm.openinstall.model.AppData */
public class AppData implements Serializable {
    public String channel;
    public String data;

    public AppData() {
        String str = "";
        this.channel = str;
        this.data = str;
    }

    public String getChannel() {
        return this.channel;
    }

    public String getData() {
        return this.data;
    }

    public boolean isEmpty() {
        return TextUtils.isEmpty(getChannel()) && TextUtils.isEmpty(getData());
    }

    public void setChannel(String str) {
        this.channel = str;
    }

    public void setData(String str) {
        this.data = str;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("AppData{channel='");
        sb.append(this.channel);
        sb.append('\'');
        sb.append(", data='");
        sb.append(this.data);
        sb.append('\'');
        sb.append('}');
        return sb.toString();
    }
}
