package com.kwai.filedownloader.p356d;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* renamed from: com.kwai.filedownloader.d.b */
public class C4619b implements Parcelable {
    public static final Creator<C4619b> CREATOR = new Creator<C4619b>() {
        /* renamed from: a */
        public C4619b createFromParcel(Parcel parcel) {
            return new C4619b(parcel);
        }

        /* renamed from: a */
        public C4619b[] newArray(int i) {
            return new C4619b[i];
        }
    };
    /* renamed from: a */
    private HashMap<String, List<String>> f15035a;

    public C4619b() {
    }

    protected C4619b(Parcel parcel) {
        this.f15035a = parcel.readHashMap(String.class.getClassLoader());
    }

    /* renamed from: a */
    public HashMap<String, List<String>> mo25061a() {
        return this.f15035a;
    }

    /* renamed from: a */
    public void mo25062a(String str) {
        HashMap<String, List<String>> hashMap = this.f15035a;
        if (hashMap != null) {
            hashMap.remove(str);
        }
    }

    /* renamed from: a */
    public void mo25063a(String str, String str2) {
        if (str == null) {
            throw new NullPointerException("name == null");
        } else if (str.isEmpty()) {
            throw new IllegalArgumentException("name is empty");
        } else if (str2 != null) {
            if (this.f15035a == null) {
                this.f15035a = new HashMap<>();
            }
            List list = (List) this.f15035a.get(str);
            if (list == null) {
                list = new ArrayList();
                this.f15035a.put(str, list);
            }
            if (!list.contains(str2)) {
                list.add(str2);
            }
        } else {
            throw new NullPointerException("value == null");
        }
    }

    public int describeContents() {
        return 0;
    }

    public String toString() {
        return this.f15035a.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeMap(this.f15035a);
    }
}
