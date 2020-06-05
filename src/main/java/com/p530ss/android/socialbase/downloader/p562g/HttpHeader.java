package com.p530ss.android.socialbase.downloader.p562g;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;

/* renamed from: com.ss.android.socialbase.downloader.g.e */
public class HttpHeader implements Parcelable, Comparable {
    public static final Creator<HttpHeader> CREATOR = new Creator<HttpHeader>() {
        /* renamed from: a */
        public HttpHeader createFromParcel(Parcel parcel) {
            return new HttpHeader(parcel);
        }

        /* renamed from: a */
        public HttpHeader[] newArray(int i) {
            return new HttpHeader[i];
        }
    };
    /* renamed from: a */
    private final String f22111a;
    /* renamed from: b */
    private final String f22112b;

    public int describeContents() {
        return 0;
    }

    public HttpHeader(String str, String str2) {
        this.f22111a = str;
        this.f22112b = str2;
    }

    protected HttpHeader(Parcel parcel) {
        this.f22111a = parcel.readString();
        this.f22112b = parcel.readString();
    }

    /* renamed from: a */
    public String mo32429a() {
        return this.f22111a;
    }

    /* renamed from: b */
    public String mo32430b() {
        return this.f22112b;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f22111a);
        parcel.writeString(this.f22112b);
    }

    public int compareTo(Object obj) {
        if (!(obj instanceof HttpHeader)) {
            return 1;
        }
        HttpHeader eVar = (HttpHeader) obj;
        if (TextUtils.equals(this.f22111a, eVar.mo32429a())) {
            return 0;
        }
        String str = this.f22111a;
        if (str == null) {
            return -1;
        }
        int compareTo = str.compareTo(eVar.mo32429a());
        if (compareTo > 0) {
            return 1;
        }
        if (compareTo < 0) {
            return -1;
        }
        return 0;
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        HttpHeader eVar = (HttpHeader) obj;
        if (!TextUtils.equals(this.f22111a, eVar.f22111a) || !TextUtils.equals(this.f22112b, eVar.f22112b)) {
            z = false;
        }
        return z;
    }

    public int hashCode() {
        String str = this.f22111a;
        int i = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.f22112b;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return hashCode + i;
    }
}
