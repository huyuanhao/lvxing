package com.ali.auth.third.core.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class SNSSignInAccount implements Parcelable {
    public static final Creator<SNSSignInAccount> CREATOR = new Creator<SNSSignInAccount>() {
        /* renamed from: a */
        public SNSSignInAccount createFromParcel(Parcel parcel) {
            return new SNSSignInAccount(parcel);
        }

        /* renamed from: a */
        public SNSSignInAccount[] newArray(int i) {
            return new SNSSignInAccount[i];
        }
    };
    /* renamed from: a */
    public String f1977a;
    /* renamed from: b */
    public String f1978b;
    /* renamed from: c */
    public String f1979c;
    /* renamed from: d */
    public String f1980d;
    /* renamed from: e */
    public String f1981e;
    /* renamed from: f */
    public String f1982f;
    /* renamed from: g */
    public String f1983g;
    /* renamed from: h */
    public String f1984h;
    /* renamed from: i */
    public String f1985i;

    public SNSSignInAccount() {
    }

    protected SNSSignInAccount(Parcel parcel) {
        this.f1977a = parcel.readString();
        this.f1978b = parcel.readString();
        this.f1979c = parcel.readString();
        this.f1980d = parcel.readString();
        this.f1981e = parcel.readString();
        this.f1982f = parcel.readString();
        this.f1983g = parcel.readString();
        this.f1984h = parcel.readString();
        this.f1985i = parcel.readString();
    }

    public int describeContents() {
        return 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("SNSSignInAccount{snsType='");
        sb.append(this.f1977a);
        sb.append('\'');
        sb.append(", userId='");
        sb.append(this.f1978b);
        sb.append('\'');
        sb.append(", token='");
        sb.append(this.f1979c);
        sb.append('\'');
        sb.append(", email='");
        sb.append(this.f1980d);
        sb.append('\'');
        sb.append(", firstName='");
        sb.append(this.f1981e);
        sb.append('\'');
        sb.append(", lastName='");
        sb.append(this.f1982f);
        sb.append('\'');
        sb.append(", company='");
        sb.append(this.f1983g);
        sb.append('\'');
        sb.append(", countryFullName='");
        sb.append(this.f1984h);
        sb.append('\'');
        sb.append(", countryAbbr='");
        sb.append(this.f1985i);
        sb.append('\'');
        sb.append('}');
        return sb.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f1977a);
        parcel.writeString(this.f1978b);
        parcel.writeString(this.f1979c);
        parcel.writeString(this.f1980d);
        parcel.writeString(this.f1981e);
        parcel.writeString(this.f1982f);
        parcel.writeString(this.f1983g);
        parcel.writeString(this.f1984h);
        parcel.writeString(this.f1985i);
    }
}
