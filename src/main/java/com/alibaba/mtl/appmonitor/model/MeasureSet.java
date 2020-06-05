package com.alibaba.mtl.appmonitor.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.ArrayList;
import java.util.List;

public class MeasureSet implements Parcelable {
    public static final Creator<MeasureSet> CREATOR = new Creator<MeasureSet>() {
        /* renamed from: a */
        public MeasureSet createFromParcel(Parcel parcel) {
            return MeasureSet.m3635a(parcel);
        }

        /* renamed from: a */
        public MeasureSet[] newArray(int i) {
            return new MeasureSet[i];
        }
    };
    /* renamed from: a */
    private List<Measure> f3253a = new ArrayList(3);

    public int describeContents() {
        return 0;
    }

    /* renamed from: a */
    public static MeasureSet m3634a() {
        return new MeasureSet();
    }

    private MeasureSet() {
    }

    /* renamed from: a */
    public boolean mo11712a(MeasureValueSet measureValueSet) {
        if (this.f3253a != null) {
            if (measureValueSet == null) {
                return false;
            }
            for (int i = 0; i < this.f3253a.size(); i++) {
                Measure measure = (Measure) this.f3253a.get(i);
                if (measure != null) {
                    String b = measure.mo11700b();
                    if (!measureValueSet.mo11739b(b) || !measure.mo11699a(measureValueSet.mo11734a(b))) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    /* renamed from: a */
    public MeasureSet mo11711a(Measure measure) {
        if (!this.f3253a.contains(measure)) {
            this.f3253a.add(measure);
        }
        return this;
    }

    /* renamed from: a */
    public Measure mo11710a(String str) {
        for (Measure measure : this.f3253a) {
            if (measure.mo11700b().equals(str)) {
                return measure;
            }
        }
        return null;
    }

    /* renamed from: b */
    public List<Measure> mo11713b() {
        return this.f3253a;
    }

    /* renamed from: b */
    public void mo11714b(MeasureValueSet measureValueSet) {
        List<Measure> list = this.f3253a;
        if (list != null && measureValueSet != null) {
            for (Measure measure : list) {
                if (measure.mo11701c() != null && measureValueSet.mo11734a(measure.mo11700b()) == null) {
                    measureValueSet.mo11735a(measure.mo11700b(), measure.mo11701c().doubleValue());
                }
            }
        }
    }

    public void writeToParcel(Parcel parcel, int i) {
        List<Measure> list = this.f3253a;
        if (list != null) {
            try {
                Object[] array = list.toArray();
                Measure[] measureArr = null;
                if (array != null) {
                    measureArr = new Measure[array.length];
                    for (int i2 = 0; i2 < array.length; i2++) {
                        measureArr[i2] = (Measure) array[i2];
                    }
                }
                parcel.writeParcelableArray(measureArr, i);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* renamed from: a */
    static MeasureSet m3635a(Parcel parcel) {
        MeasureSet a = m3634a();
        try {
            Parcelable[] readParcelableArray = parcel.readParcelableArray(MeasureSet.class.getClassLoader());
            if (readParcelableArray != null) {
                ArrayList arrayList = new ArrayList(readParcelableArray.length);
                for (Parcelable parcelable : readParcelableArray) {
                    arrayList.add((Measure) parcelable);
                }
                a.f3253a = arrayList;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return a;
    }
}
