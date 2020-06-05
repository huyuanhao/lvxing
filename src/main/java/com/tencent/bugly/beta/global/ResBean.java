package com.tencent.bugly.beta.global;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: BUGLY */
public class ResBean implements Parcelable, Creator<ResBean> {
    public static final Creator<ResBean> CREATOR = new ResBean();
    /* renamed from: a */
    public static ResBean f23687a;
    /* renamed from: b */
    public static final String[] f23688b = {"IMG_title", "VAL_style"};
    /* renamed from: c */
    public final String f23689c = "#273238";
    /* renamed from: d */
    public final String f23690d = "#757575";
    /* renamed from: e */
    private Map<String, String> f23691e = new ConcurrentHashMap();

    /* renamed from: a */
    public ResBean[] newArray(int i) {
        return new ResBean[0];
    }

    public int describeContents() {
        return 0;
    }

    public ResBean() {
    }

    public ResBean(Parcel parcel) {
        try {
            for (String put : f23688b) {
                this.f23691e.put(put, parcel.readString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: a */
    public String mo34329a(String str) {
        return (String) this.f23691e.get(str);
    }

    /* renamed from: a */
    public void mo34330a(String str, Object obj) {
        if (obj instanceof String) {
            this.f23691e.put(str, (String) obj);
        }
    }

    public void writeToParcel(Parcel parcel, int i) {
        for (String str : f23688b) {
            parcel.writeString((String) this.f23691e.get(str));
        }
    }

    /* renamed from: a */
    public ResBean createFromParcel(Parcel parcel) {
        return new ResBean(parcel);
    }
}
