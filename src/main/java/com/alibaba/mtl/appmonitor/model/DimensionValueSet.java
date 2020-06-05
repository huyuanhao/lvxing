package com.alibaba.mtl.appmonitor.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.alibaba.mtl.appmonitor.p070c.BalancedPool;
import com.alibaba.mtl.appmonitor.p070c.Reusable;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

public class DimensionValueSet implements Parcelable, Reusable {
    public static final Creator<DimensionValueSet> CREATOR = new Creator<DimensionValueSet>() {
        /* renamed from: a */
        public DimensionValueSet createFromParcel(Parcel parcel) {
            return DimensionValueSet.m3616a(parcel);
        }

        /* renamed from: a */
        public DimensionValueSet[] newArray(int i) {
            return new DimensionValueSet[i];
        }
    };
    /* renamed from: a */
    protected Map<String, String> f3248a;

    public int describeContents() {
        return 0;
    }

    /* renamed from: a */
    public static DimensionValueSet m3615a() {
        return (DimensionValueSet) BalancedPool.m3491a().mo11627a(DimensionValueSet.class, new Object[0]);
    }

    @Deprecated
    public DimensionValueSet() {
        if (this.f3248a == null) {
            this.f3248a = new LinkedHashMap();
        }
    }

    /* renamed from: a */
    public DimensionValueSet mo11685a(String str, String str2) {
        Map<String, String> map = this.f3248a;
        if (str2 == null) {
            str2 = "null";
        }
        map.put(str, str2);
        return this;
    }

    /* renamed from: a */
    public DimensionValueSet mo11684a(DimensionValueSet dimensionValueSet) {
        if (dimensionValueSet != null) {
            Map b = dimensionValueSet.mo11689b();
            if (b != null) {
                for (Entry entry : b.entrySet()) {
                    this.f3248a.put(entry.getKey(), entry.getValue() != null ? (String) entry.getValue() : "null");
                }
            }
        }
        return this;
    }

    /* renamed from: a */
    public boolean mo11687a(String str) {
        return this.f3248a.containsKey(str);
    }

    /* renamed from: b */
    public String mo11688b(String str) {
        return (String) this.f3248a.get(str);
    }

    /* renamed from: b */
    public Map<String, String> mo11689b() {
        return this.f3248a;
    }

    /* renamed from: a */
    public void mo11686a(Map<String, String> map) {
        for (Entry entry : map.entrySet()) {
            this.f3248a.put(entry.getKey(), entry.getValue() != null ? (String) entry.getValue() : "null");
        }
    }

    public int hashCode() {
        Map<String, String> map = this.f3248a;
        return 31 + (map == null ? 0 : map.hashCode());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        DimensionValueSet dimensionValueSet = (DimensionValueSet) obj;
        Map<String, String> map = this.f3248a;
        if (map == null) {
            if (dimensionValueSet.f3248a != null) {
                return false;
            }
        } else if (!map.equals(dimensionValueSet.f3248a)) {
            return false;
        }
        return true;
    }

    /* renamed from: d */
    public void mo11546d() {
        this.f3248a.clear();
    }

    /* renamed from: a */
    public void mo11548a(Object... objArr) {
        if (this.f3248a == null) {
            this.f3248a = new LinkedHashMap();
        }
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeMap(this.f3248a);
    }

    /* renamed from: a */
    static DimensionValueSet m3616a(Parcel parcel) {
        DimensionValueSet dimensionValueSet;
        try {
            dimensionValueSet = m3615a();
            try {
                dimensionValueSet.f3248a = parcel.readHashMap(DimensionValueSet.class.getClassLoader());
            } catch (Throwable th) {
                th = th;
            }
        } catch (Throwable th2) {
            th = th2;
            dimensionValueSet = null;
            th.printStackTrace();
            return dimensionValueSet;
        }
        return dimensionValueSet;
    }
}
