package com.alibaba.mtl.appmonitor.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.alibaba.mtl.appmonitor.p070c.BalancedPool;
import com.alibaba.mtl.appmonitor.p070c.Reusable;
import java.util.LinkedHashMap;
import java.util.Map;

public class MeasureValueSet implements Parcelable, Reusable {
    public static final Creator<MeasureValueSet> CREATOR = new Creator<MeasureValueSet>() {
        /* renamed from: a */
        public MeasureValueSet createFromParcel(Parcel parcel) {
            return MeasureValueSet.m3657a(parcel);
        }

        /* renamed from: a */
        public MeasureValueSet[] newArray(int i) {
            return new MeasureValueSet[i];
        }
    };
    /* renamed from: a */
    private Map<String, MeasureValue> f3257a = new LinkedHashMap();

    public int describeContents() {
        return 0;
    }

    /* renamed from: a */
    public static MeasureValueSet m3656a() {
        return (MeasureValueSet) BalancedPool.m3491a().mo11627a(MeasureValueSet.class, new Object[0]);
    }

    /* renamed from: a */
    public MeasureValueSet mo11735a(String str, double d) {
        this.f3257a.put(str, BalancedPool.m3491a().mo11627a(MeasureValue.class, Double.valueOf(d)));
        return this;
    }

    /* renamed from: a */
    public void mo11737a(String str, MeasureValue measureValue) {
        this.f3257a.put(str, measureValue);
    }

    /* renamed from: a */
    public MeasureValue mo11734a(String str) {
        return (MeasureValue) this.f3257a.get(str);
    }

    /* renamed from: b */
    public Map<String, MeasureValue> mo11738b() {
        return this.f3257a;
    }

    /* renamed from: b */
    public boolean mo11739b(String str) {
        return this.f3257a.containsKey(str);
    }

    /* renamed from: a */
    public void mo11736a(MeasureValueSet measureValueSet) {
        for (String str : this.f3257a.keySet()) {
            ((MeasureValue) this.f3257a.get(str)).mo11722a(measureValueSet.mo11734a(str));
        }
    }

    /* renamed from: d */
    public void mo11546d() {
        for (MeasureValue a : this.f3257a.values()) {
            BalancedPool.m3491a().mo11628a(a);
        }
        this.f3257a.clear();
    }

    /* renamed from: a */
    public void mo11548a(Object... objArr) {
        if (this.f3257a == null) {
            this.f3257a = new LinkedHashMap();
        }
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeMap(this.f3257a);
    }

    /* renamed from: a */
    static MeasureValueSet m3657a(Parcel parcel) {
        try {
            MeasureValueSet a = m3656a();
            try {
                a.f3257a = parcel.readHashMap(DimensionValueSet.class.getClassLoader());
                return a;
            } catch (Throwable unused) {
                return a;
            }
        } catch (Throwable unused2) {
            return null;
        }
    }
}
