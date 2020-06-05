package com.alibaba.mtl.appmonitor.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.alibaba.mtl.log.p077d.Logger;
import java.util.ArrayList;
import java.util.List;

public class DimensionSet implements Parcelable {
    public static final Creator<DimensionSet> CREATOR = new Creator<DimensionSet>() {
        /* renamed from: a */
        public DimensionSet createFromParcel(Parcel parcel) {
            return DimensionSet.m3610a(parcel);
        }

        /* renamed from: a */
        public DimensionSet[] newArray(int i) {
            return new DimensionSet[i];
        }
    };
    /* renamed from: a */
    private List<Dimension> f3247a = new ArrayList(3);

    public int describeContents() {
        return 0;
    }

    /* renamed from: a */
    public static DimensionSet m3609a() {
        return new DimensionSet();
    }

    private DimensionSet() {
    }

    /* renamed from: a */
    public boolean mo11676a(DimensionValueSet dimensionValueSet) {
        List<Dimension> list = this.f3247a;
        if (list != null) {
            if (dimensionValueSet != null) {
                for (Dimension a : list) {
                    if (!dimensionValueSet.mo11687a(a.mo11666a())) {
                    }
                }
            }
            return false;
        }
        return true;
    }

    /* renamed from: b */
    public void mo11677b(DimensionValueSet dimensionValueSet) {
        List<Dimension> list = this.f3247a;
        if (list != null && dimensionValueSet != null) {
            for (Dimension dimension : list) {
                if (dimension.mo11667b() != null && dimensionValueSet.mo11688b(dimension.mo11666a()) == null) {
                    dimensionValueSet.mo11685a(dimension.mo11666a(), dimension.mo11667b());
                }
            }
        }
    }

    public void writeToParcel(Parcel parcel, int i) {
        List<Dimension> list = this.f3247a;
        if (list != null) {
            try {
                Object[] array = list.toArray();
                Dimension[] dimensionArr = null;
                if (array != null) {
                    dimensionArr = new Dimension[array.length];
                    for (int i2 = 0; i2 < array.length; i2++) {
                        dimensionArr[i2] = (Dimension) array[i2];
                    }
                }
                parcel.writeParcelableArray(dimensionArr, i);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* renamed from: a */
    static DimensionSet m3610a(Parcel parcel) {
        String str = "DimensionSet";
        DimensionSet a = m3609a();
        try {
            Parcelable[] readParcelableArray = parcel.readParcelableArray(DimensionSet.class.getClassLoader());
            if (readParcelableArray != null) {
                if (a.f3247a == null) {
                    a.f3247a = new ArrayList();
                }
                int i = 0;
                while (i < readParcelableArray.length) {
                    if (readParcelableArray[i] == null || !(readParcelableArray[i] instanceof Dimension)) {
                        Logger.m3833a(str, "parcelables[i]:", readParcelableArray[i]);
                    } else {
                        a.f3247a.add((Dimension) readParcelableArray[i]);
                    }
                    i++;
                }
            }
        } catch (Throwable th) {
            Logger.m3832a(str, "[readFromParcel]", th);
        }
        return a;
    }
}
