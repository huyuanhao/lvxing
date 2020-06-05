package com.tencent.bugly.crashreport.biz;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import androidx.core.p003os.EnvironmentCompat;
import com.tencent.bugly.proguard.C7232aq;
import java.util.Map;

/* compiled from: BUGLY */
public class UserInfoBean implements Parcelable {
    public static final Creator<UserInfoBean> CREATOR = new Creator<UserInfoBean>() {
        /* renamed from: a */
        public UserInfoBean createFromParcel(Parcel parcel) {
            return new UserInfoBean(parcel);
        }

        /* renamed from: a */
        public UserInfoBean[] newArray(int i) {
            return new UserInfoBean[i];
        }
    };
    /* renamed from: a */
    public long f23909a;
    /* renamed from: b */
    public int f23910b;
    /* renamed from: c */
    public String f23911c;
    /* renamed from: d */
    public String f23912d;
    /* renamed from: e */
    public long f23913e;
    /* renamed from: f */
    public long f23914f;
    /* renamed from: g */
    public long f23915g;
    /* renamed from: h */
    public long f23916h;
    /* renamed from: i */
    public long f23917i;
    /* renamed from: j */
    public String f23918j;
    /* renamed from: k */
    public long f23919k;
    /* renamed from: l */
    public boolean f23920l;
    /* renamed from: m */
    public String f23921m;
    /* renamed from: n */
    public String f23922n;
    /* renamed from: o */
    public int f23923o;
    /* renamed from: p */
    public int f23924p;
    /* renamed from: q */
    public int f23925q;
    /* renamed from: r */
    public Map<String, String> f23926r;
    /* renamed from: s */
    public Map<String, String> f23927s;

    public int describeContents() {
        return 0;
    }

    public UserInfoBean() {
        this.f23919k = 0;
        this.f23920l = false;
        this.f23921m = EnvironmentCompat.MEDIA_UNKNOWN;
        this.f23924p = -1;
        this.f23925q = -1;
        this.f23926r = null;
        this.f23927s = null;
    }

    public UserInfoBean(Parcel parcel) {
        this.f23919k = 0;
        boolean z = false;
        this.f23920l = false;
        this.f23921m = EnvironmentCompat.MEDIA_UNKNOWN;
        this.f23924p = -1;
        this.f23925q = -1;
        this.f23926r = null;
        this.f23927s = null;
        this.f23910b = parcel.readInt();
        this.f23911c = parcel.readString();
        this.f23912d = parcel.readString();
        this.f23913e = parcel.readLong();
        this.f23914f = parcel.readLong();
        this.f23915g = parcel.readLong();
        this.f23916h = parcel.readLong();
        this.f23917i = parcel.readLong();
        this.f23918j = parcel.readString();
        this.f23919k = parcel.readLong();
        if (parcel.readByte() == 1) {
            z = true;
        }
        this.f23920l = z;
        this.f23921m = parcel.readString();
        this.f23924p = parcel.readInt();
        this.f23925q = parcel.readInt();
        this.f23926r = C7232aq.m31208b(parcel);
        this.f23927s = C7232aq.m31208b(parcel);
        this.f23922n = parcel.readString();
        this.f23923o = parcel.readInt();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f23910b);
        parcel.writeString(this.f23911c);
        parcel.writeString(this.f23912d);
        parcel.writeLong(this.f23913e);
        parcel.writeLong(this.f23914f);
        parcel.writeLong(this.f23915g);
        parcel.writeLong(this.f23916h);
        parcel.writeLong(this.f23917i);
        parcel.writeString(this.f23918j);
        parcel.writeLong(this.f23919k);
        parcel.writeByte(this.f23920l ? (byte) 1 : 0);
        parcel.writeString(this.f23921m);
        parcel.writeInt(this.f23924p);
        parcel.writeInt(this.f23925q);
        C7232aq.m31210b(parcel, this.f23926r);
        C7232aq.m31210b(parcel, this.f23927s);
        parcel.writeString(this.f23922n);
        parcel.writeInt(this.f23923o);
    }
}
