package com.p530ss.android.socialbase.downloader.p560e;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.p530ss.android.socialbase.downloader.p569m.DownloadUtils;

/* renamed from: com.ss.android.socialbase.downloader.e.a */
public class BaseException extends Exception implements Parcelable {
    public static final Creator<BaseException> CREATOR = new Creator<BaseException>() {
        /* renamed from: a */
        public BaseException createFromParcel(Parcel parcel) {
            return new BaseException(parcel);
        }

        /* renamed from: a */
        public BaseException[] newArray(int i) {
            return new BaseException[i];
        }
    };
    /* renamed from: a */
    private int f21940a;
    /* renamed from: b */
    private String f21941b;

    public int describeContents() {
        return 0;
    }

    public BaseException() {
    }

    public BaseException(int i, String str) {
        StringBuilder sb = new StringBuilder();
        String str2 = "[d-ex]:";
        sb.append(str2);
        sb.append(str);
        super(sb.toString());
        StringBuilder sb2 = new StringBuilder();
        sb2.append(str2);
        sb2.append(str);
        this.f21941b = sb2.toString();
        this.f21940a = i;
    }

    /* renamed from: a */
    public void mo32075a(String str) {
        this.f21941b = str;
    }

    public BaseException(int i, Throwable th) {
        this(i, DownloadUtils.m28820i(th));
    }

    protected BaseException(Parcel parcel) {
        mo32074a(parcel);
    }

    /* renamed from: a */
    public void mo32074a(Parcel parcel) {
        this.f21940a = parcel.readInt();
        this.f21941b = parcel.readString();
    }

    /* renamed from: a */
    public int mo32073a() {
        return this.f21940a;
    }

    /* renamed from: b */
    public String mo32076b() {
        return this.f21941b;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f21940a);
        parcel.writeString(this.f21941b);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("BaseException{errorCode=");
        sb.append(this.f21940a);
        sb.append(", errorMsg='");
        sb.append(this.f21941b);
        sb.append('\'');
        sb.append('}');
        return sb.toString();
    }
}
