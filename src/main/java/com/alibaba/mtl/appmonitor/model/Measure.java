package com.alibaba.mtl.appmonitor.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class Measure implements Parcelable {
    public static final Creator<Measure> CREATOR = new Creator<Measure>() {
        /* renamed from: a */
        public Measure createFromParcel(Parcel parcel) {
            return Measure.m3627a(parcel);
        }

        /* renamed from: a */
        public Measure[] newArray(int i) {
            return new Measure[i];
        }
    };
    /* renamed from: a */
    protected Double f3249a;
    /* renamed from: b */
    protected Double f3250b;
    /* renamed from: c */
    protected String f3251c;
    /* renamed from: d */
    protected Double f3252d;

    public int describeContents() {
        return 0;
    }

    public Measure(String str, Double d, Double d2, Double d3) {
        double d4 = 0.0d;
        Double valueOf = Double.valueOf(0.0d);
        this.f3249a = valueOf;
        this.f3250b = valueOf;
        this.f3252d = valueOf;
        this.f3249a = d2;
        this.f3250b = d3;
        this.f3251c = str;
        if (d != null) {
            d4 = d.doubleValue();
        }
        this.f3252d = Double.valueOf(d4);
    }

    /* renamed from: a */
    public Double mo11698a() {
        return this.f3250b;
    }

    /* renamed from: b */
    public String mo11700b() {
        return this.f3251c;
    }

    /* renamed from: c */
    public Double mo11701c() {
        return this.f3252d;
    }

    /* renamed from: a */
    public boolean mo11699a(MeasureValue measureValue) {
        Double valueOf = Double.valueOf(measureValue.mo11728e());
        return valueOf != null && (this.f3249a == null || valueOf.doubleValue() >= this.f3249a.doubleValue()) && (this.f3250b == null || valueOf.doubleValue() <= this.f3250b.doubleValue());
    }

    public int hashCode() {
        String str = this.f3251c;
        return 31 + (str == null ? 0 : str.hashCode());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Measure measure = (Measure) obj;
        String str = this.f3251c;
        if (str == null) {
            if (measure.f3251c != null) {
                return false;
            }
        } else if (!str.equals(measure.f3251c)) {
            return false;
        }
        return true;
    }

    public void writeToParcel(Parcel parcel, int i) {
        try {
            int i2 = 0;
            parcel.writeInt(this.f3250b == null ? 0 : 1);
            if (this.f3250b != null) {
                parcel.writeDouble(this.f3250b.doubleValue());
            }
            parcel.writeInt(this.f3249a == null ? 0 : 1);
            if (this.f3249a != null) {
                parcel.writeDouble(this.f3249a.doubleValue());
            }
            parcel.writeString(this.f3251c);
            if (this.f3252d != null) {
                i2 = 1;
            }
            parcel.writeInt(i2);
            if (this.f3252d != null) {
                parcel.writeDouble(this.f3252d.doubleValue());
            }
        } catch (Throwable unused) {
        }
    }

    /* renamed from: a */
    static Measure m3627a(Parcel parcel) {
        try {
            boolean z = true;
            Double valueOf = !(parcel.readInt() == 0) ? Double.valueOf(parcel.readDouble()) : null;
            Double valueOf2 = !(parcel.readInt() == 0) ? Double.valueOf(parcel.readDouble()) : null;
            String readString = parcel.readString();
            if (parcel.readInt() != 0) {
                z = false;
            }
            return new Measure(readString, !z ? Double.valueOf(parcel.readDouble()) : null, valueOf2, valueOf);
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }
}
