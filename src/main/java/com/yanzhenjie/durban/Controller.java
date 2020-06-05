package com.yanzhenjie.durban;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class Controller implements Parcelable {
    public static final Creator<Controller> CREATOR = new Creator<Controller>() {
        /* renamed from: a */
        public Controller createFromParcel(Parcel parcel) {
            return new Controller(parcel);
        }

        /* renamed from: a */
        public Controller[] newArray(int i) {
            return new Controller[i];
        }
    };
    /* renamed from: a */
    private boolean f26415a;
    /* renamed from: b */
    private boolean f26416b;
    /* renamed from: c */
    private boolean f26417c;
    /* renamed from: d */
    private boolean f26418d;
    /* renamed from: e */
    private boolean f26419e;

    /* renamed from: com.yanzhenjie.durban.Controller$a */
    public static final class C7779a {
        /* access modifiers changed from: private */
        /* renamed from: a */
        public boolean f26420a;
        /* access modifiers changed from: private */
        /* renamed from: b */
        public boolean f26421b;
        /* access modifiers changed from: private */
        /* renamed from: c */
        public boolean f26422c;
        /* access modifiers changed from: private */
        /* renamed from: d */
        public boolean f26423d;
        /* access modifiers changed from: private */
        /* renamed from: e */
        public boolean f26424e;

        private C7779a() {
            this.f26420a = true;
            this.f26421b = true;
            this.f26422c = true;
            this.f26423d = true;
            this.f26424e = true;
        }

        /* renamed from: a */
        public Controller mo37788a() {
            return new Controller(this);
        }
    }

    public int describeContents() {
        return 0;
    }

    private Controller(Parcel parcel) {
        boolean z = true;
        this.f26415a = parcel.readByte() != 0;
        this.f26416b = parcel.readByte() != 0;
        this.f26417c = parcel.readByte() != 0;
        this.f26418d = parcel.readByte() != 0;
        if (parcel.readByte() == 0) {
            z = false;
        }
        this.f26419e = z;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeByte(this.f26415a ? (byte) 1 : 0);
        parcel.writeByte(this.f26416b ? (byte) 1 : 0);
        parcel.writeByte(this.f26417c ? (byte) 1 : 0);
        parcel.writeByte(this.f26418d ? (byte) 1 : 0);
        parcel.writeByte(this.f26419e ? (byte) 1 : 0);
    }

    /* renamed from: a */
    public static C7779a m33747a() {
        return new C7779a();
    }

    private Controller(C7779a aVar) {
        this.f26415a = aVar.f26420a;
        this.f26416b = aVar.f26421b;
        this.f26417c = aVar.f26422c;
        this.f26418d = aVar.f26423d;
        this.f26419e = aVar.f26424e;
    }

    /* renamed from: b */
    public boolean mo37777b() {
        return this.f26415a;
    }

    /* renamed from: c */
    public boolean mo37778c() {
        return this.f26416b;
    }

    /* renamed from: d */
    public boolean mo37779d() {
        return this.f26417c;
    }

    /* renamed from: e */
    public boolean mo37781e() {
        return this.f26418d;
    }

    /* renamed from: f */
    public boolean mo37782f() {
        return this.f26419e;
    }
}
