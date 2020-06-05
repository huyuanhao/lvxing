package com.kwai.filedownloader.message;

import android.os.Parcel;
import com.kwai.filedownloader.message.MessageSnapshot.C4681a;

/* renamed from: com.kwai.filedownloader.message.h */
public abstract class C4705h extends MessageSnapshot {

    /* renamed from: com.kwai.filedownloader.message.h$a */
    public static class C4706a extends C4707b implements C4685b {
        C4706a(int i, boolean z, int i2) {
            super(i, z, i2);
        }
    }

    /* renamed from: com.kwai.filedownloader.message.h$b */
    public static class C4707b extends C4705h {
        /* renamed from: b */
        private final boolean f15238b;
        /* renamed from: c */
        private final int f15239c;

        C4707b(int i, boolean z, int i2) {
            super(i);
            this.f15238b = z;
            this.f15239c = i2;
        }

        C4707b(Parcel parcel) {
            super(parcel);
            this.f15238b = parcel.readByte() != 0;
            this.f15239c = parcel.readInt();
        }

        /* renamed from: b */
        public byte mo25286b() {
            return -3;
        }

        /* renamed from: c */
        public int mo25268c() {
            return this.f15239c;
        }

        public int describeContents() {
            return 0;
        }

        /* renamed from: e */
        public boolean mo25271e() {
            return this.f15238b;
        }

        public void writeToParcel(Parcel parcel, int i) {
            C4705h.super.writeToParcel(parcel, i);
            parcel.writeByte(this.f15238b);
            parcel.writeInt(this.f15239c);
        }
    }

    /* renamed from: com.kwai.filedownloader.message.h$c */
    public static class C4708c extends C4705h {
        /* renamed from: b */
        private final boolean f15240b;
        /* renamed from: c */
        private final int f15241c;
        /* renamed from: d */
        private final String f15242d;
        /* renamed from: e */
        private final String f15243e;

        C4708c(int i, boolean z, int i2, String str, String str2) {
            super(i);
            this.f15240b = z;
            this.f15241c = i2;
            this.f15242d = str;
            this.f15243e = str2;
        }

        C4708c(Parcel parcel) {
            super(parcel);
            this.f15240b = parcel.readByte() != 0;
            this.f15241c = parcel.readInt();
            this.f15242d = parcel.readString();
            this.f15243e = parcel.readString();
        }

        /* renamed from: b */
        public byte mo25286b() {
            return 2;
        }

        /* renamed from: c */
        public int mo25268c() {
            return this.f15241c;
        }

        public int describeContents() {
            return 0;
        }

        /* renamed from: f */
        public String mo25272f() {
            return this.f15243e;
        }

        /* renamed from: g */
        public boolean mo25273g() {
            return this.f15240b;
        }

        /* renamed from: h */
        public String mo25274h() {
            return this.f15242d;
        }

        public void writeToParcel(Parcel parcel, int i) {
            C4705h.super.writeToParcel(parcel, i);
            parcel.writeByte(this.f15240b);
            parcel.writeInt(this.f15241c);
            parcel.writeString(this.f15242d);
            parcel.writeString(this.f15243e);
        }
    }

    /* renamed from: com.kwai.filedownloader.message.h$d */
    public static class C4709d extends C4705h {
        /* renamed from: b */
        private final int f15244b;
        /* renamed from: c */
        private final Throwable f15245c;

        C4709d(int i, int i2, Throwable th) {
            super(i);
            this.f15244b = i2;
            this.f15245c = th;
        }

        C4709d(Parcel parcel) {
            super(parcel);
            this.f15244b = parcel.readInt();
            this.f15245c = (Throwable) parcel.readSerializable();
        }

        /* renamed from: a */
        public int mo25267a() {
            return this.f15244b;
        }

        /* renamed from: b */
        public byte mo25286b() {
            return -1;
        }

        public int describeContents() {
            return 0;
        }

        /* renamed from: j */
        public Throwable mo25276j() {
            return this.f15245c;
        }

        public void writeToParcel(Parcel parcel, int i) {
            C4705h.super.writeToParcel(parcel, i);
            parcel.writeInt(this.f15244b);
            parcel.writeSerializable(this.f15245c);
        }
    }

    /* renamed from: com.kwai.filedownloader.message.h$e */
    public static class C4710e extends C4711f {
        C4710e(int i, int i2, int i3) {
            super(i, i2, i3);
        }

        /* renamed from: b */
        public byte mo25286b() {
            return -2;
        }
    }

    /* renamed from: com.kwai.filedownloader.message.h$f */
    public static class C4711f extends C4705h {
        /* renamed from: b */
        private final int f15246b;
        /* renamed from: c */
        private final int f15247c;

        C4711f(int i, int i2, int i3) {
            super(i);
            this.f15246b = i2;
            this.f15247c = i3;
        }

        C4711f(Parcel parcel) {
            super(parcel);
            this.f15246b = parcel.readInt();
            this.f15247c = parcel.readInt();
        }

        C4711f(C4711f fVar) {
            this(fVar.mo25278m(), fVar.mo25267a(), fVar.mo25268c());
        }

        /* renamed from: a */
        public int mo25267a() {
            return this.f15246b;
        }

        /* renamed from: b */
        public byte mo25286b() {
            return 1;
        }

        /* renamed from: c */
        public int mo25268c() {
            return this.f15247c;
        }

        public void writeToParcel(Parcel parcel, int i) {
            C4705h.super.writeToParcel(parcel, i);
            parcel.writeInt(this.f15246b);
            parcel.writeInt(this.f15247c);
        }
    }

    /* renamed from: com.kwai.filedownloader.message.h$g */
    public static class C4712g extends C4705h {
        /* renamed from: b */
        private final int f15248b;

        C4712g(int i, int i2) {
            super(i);
            this.f15248b = i2;
        }

        C4712g(Parcel parcel) {
            super(parcel);
            this.f15248b = parcel.readInt();
        }

        /* renamed from: a */
        public int mo25267a() {
            return this.f15248b;
        }

        /* renamed from: b */
        public byte mo25286b() {
            return 3;
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            C4705h.super.writeToParcel(parcel, i);
            parcel.writeInt(this.f15248b);
        }
    }

    /* renamed from: com.kwai.filedownloader.message.h$h */
    public static class C4713h extends C4709d {
        /* renamed from: b */
        private final int f15249b;

        C4713h(int i, int i2, Throwable th, int i3) {
            super(i, i2, th);
            this.f15249b = i3;
        }

        C4713h(Parcel parcel) {
            super(parcel);
            this.f15249b = parcel.readInt();
        }

        /* renamed from: b */
        public byte mo25286b() {
            return 5;
        }

        public int describeContents() {
            return 0;
        }

        /* renamed from: k */
        public int mo25277k() {
            return this.f15249b;
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.f15249b);
        }
    }

    /* renamed from: com.kwai.filedownloader.message.h$i */
    public static class C4714i extends C4715j implements C4685b {
        C4714i(int i, int i2, int i3) {
            super(i, i2, i3);
        }
    }

    /* renamed from: com.kwai.filedownloader.message.h$j */
    public static class C4715j extends C4711f implements C4681a {
        C4715j(int i, int i2, int i3) {
            super(i, i2, i3);
        }

        C4715j(Parcel parcel) {
            super(parcel);
        }

        /* renamed from: b */
        public byte mo25286b() {
            return -4;
        }

        /* renamed from: l */
        public MessageSnapshot mo25285l() {
            return new C4711f((C4711f) this);
        }
    }

    C4705h(int i) {
        super(i);
        this.f15213a = false;
    }

    C4705h(Parcel parcel) {
        super(parcel);
    }

    /* renamed from: d */
    public long mo25269d() {
        return (long) mo25268c();
    }

    /* renamed from: i */
    public long mo25275i() {
        return (long) mo25267a();
    }
}
