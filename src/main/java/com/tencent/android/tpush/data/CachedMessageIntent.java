package com.tencent.android.tpush.data;

import java.io.Serializable;

/* compiled from: ProGuard */
public class CachedMessageIntent implements Serializable {
    private static final long serialVersionUID = 1724218633838690967L;
    public String intent;
    public long msgId;
    public String pkgName;

    public CachedMessageIntent() {
        String str = "";
        this.pkgName = str;
        this.intent = str;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof CachedMessageIntent)) {
            return super.equals(obj);
        }
        CachedMessageIntent cachedMessageIntent = (CachedMessageIntent) obj;
        boolean z = cachedMessageIntent.pkgName.equals(this.pkgName) && cachedMessageIntent.msgId == this.msgId;
        return z;
    }

    public int hashCode() {
        return super.hashCode();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("CachedMessageIntent [pkgName=");
        sb.append(this.pkgName);
        sb.append(", msgId=");
        sb.append(this.msgId);
        sb.append("]");
        return sb.toString();
    }
}
