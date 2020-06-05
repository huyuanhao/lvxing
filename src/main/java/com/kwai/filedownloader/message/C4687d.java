package com.kwai.filedownloader.message;

import android.os.Parcel;
import com.kwai.filedownloader.message.MessageSnapshot.C4681a;

/* renamed from: com.kwai.filedownloader.message.d */
public abstract class C4687d extends MessageSnapshot {

    /* renamed from: com.kwai.filedownloader.message.d$a */
    public static class C4688a extends C4689b implements C4685b {
        C4688a(int i, boolean z, long j) {
            super(i, z, j);
        }
    }

    /* renamed from: com.kwai.filedownloader.message.d$b */
    public static class C4689b extends C4687d {
        /* renamed from: b */
        private final boolean f15216b;
        /* renamed from: c */
        private final long f15217c;

        C4689b(int i, boolean z, long j) {
            super(i);
            this.f15216b = z;
            this.f15217c = j;
        }

        C4689b(Parcel parcel) {
            super(parcel);
            this.f15216b = parcel.readByte() != 0;
            this.f15217c = parcel.readLong();
        }

        /* renamed from: b */
        public byte mo25286b() {
            return -3;
        }

        /* renamed from: d */
        public long mo25269d() {
            return this.f15217c;
        }

        public int describeContents() {
            return 0;
        }

        /* renamed from: e */
        public boolean mo25271e() {
            return this.f15216b;
        }

        public void writeToParcel(Parcel parcel, int i) {
            C4687d.super.writeToParcel(parcel, i);
            parcel.writeByte(this.f15216b);
            parcel.writeLong(this.f15217c);
        }
    }

    /* renamed from: com.kwai.filedownloader.message.d$c */
    public static class C4690c extends C4687d {
        /* renamed from: b */
        private final boolean f15218b;
        /* renamed from: c */
        private final long f15219c;
        /* renamed from: d */
        private final String f15220d;
        /* renamed from: e */
        private final String f15221e;

        C4690c(int i, boolean z, long j, String str, String str2) {
            super(i);
            this.f15218b = z;
            this.f15219c = j;
            this.f15220d = str;
            this.f15221e = str2;
        }

        C4690c(Parcel parcel) {
            super(parcel);
            this.f15218b = parcel.readByte() != 0;
            this.f15219c = parcel.readLong();
            this.f15220d = parcel.readString();
            this.f15221e = parcel.readString();
        }

        /* renamed from: b */
        public byte mo25286b() {
            return 2;
        }

        /* renamed from: d */
        public long mo25269d() {
            return this.f15219c;
        }

        public int describeContents() {
            return 0;
        }

        /* renamed from: f */
        public String mo25272f() {
            return this.f15221e;
        }

        /* renamed from: g */
        public boolean mo25273g() {
            return this.f15218b;
        }

        /* renamed from: h */
        public String mo25274h() {
            return this.f15220d;
        }

        public void writeToParcel(Parcel parcel, int i) {
            C4687d.super.writeToParcel(parcel, i);
            parcel.writeByte(this.f15218b);
            parcel.writeLong(this.f15219c);
            parcel.writeString(this.f15220d);
            parcel.writeString(this.f15221e);
        }
    }

    /* renamed from: com.kwai.filedownloader.message.d$d */
    public static class C4691d extends C4687d {
        /* renamed from: b */
        private final long f15222b;
        /* renamed from: c */
        private final Throwable f15223c;

        C4691d(int i, long j, Throwable th) {
            super(i);
            this.f15222b = j;
            this.f15223c = th;
        }

        C4691d(Parcel parcel) {
            super(parcel);
            this.f15222b = parcel.readLong();
            this.f15223c = (Throwable) parcel.readSerializable();
        }

        /* renamed from: b */
        public byte mo25286b() {
            return -1;
        }

        public int describeContents() {
            return 0;
        }

        /* renamed from: i */
        public long mo25275i() {
            return this.f15222b;
        }

        /* renamed from: j */
        public Throwable mo25276j() {
            return this.f15223c;
        }

        public void writeToParcel(Parcel parcel, int i) {
            C4687d.super.writeToParcel(parcel, i);
            parcel.writeLong(this.f15222b);
            parcel.writeSerializable(this.f15223c);
        }
    }

    /* renamed from: com.kwai.filedownloader.message.d$e */
    public static class C4692e extends C4693f {
        C4692e(int i, long j, long j2) {
            super(i, j, j2);
        }

        /* renamed from: b */
        public byte mo25286b() {
            return -2;
        }
    }

    /* renamed from: com.kwai.filedownloader.message.d$f */
    public static class C4693f extends C4687d {
        /* renamed from: b */
        private final long f15224b;
        /* renamed from: c */
        private final long f15225c;

        C4693f(int i, long j, long j2) {
            super(i);
            this.f15224b = j;
            this.f15225c = j2;
        }

        C4693f(Parcel parcel) {
            super(parcel);
            this.f15224b = parcel.readLong();
            this.f15225c = parcel.readLong();
        }

        C4693f(C4693f fVar) {
            this(fVar.mo25278m(), fVar.mo25275i(), fVar.mo25269d());
        }

        /* renamed from: b */
        public byte mo25286b() {
            return 1;
        }

        /* renamed from: d */
        public long mo25269d() {
            return this.f15225c;
        }

        public int describeContents() {
            return 0;
        }

        /* renamed from: i */
        public long mo25275i() {
            return this.f15224b;
        }

        public void writeToParcel(Parcel parcel, int i) {
            C4687d.super.writeToParcel(parcel, i);
            parcel.writeLong(this.f15224b);
            parcel.writeLong(this.f15225c);
        }
    }

    /* renamed from: com.kwai.filedownloader.message.d$g */
    public static class C4694g extends C4687d {
        /* renamed from: b */
        private final long f15226b;

        C4694g(int i, long j) {
            super(i);
            this.f15226b = j;
        }

        C4694g(Parcel parcel) {
            super(parcel);
            this.f15226b = parcel.readLong();
        }

        /* renamed from: b */
        public byte mo25286b() {
            return 3;
        }

        public int describeContents() {
            return 0;
        }

        /* renamed from: i */
        public long mo25275i() {
            return this.f15226b;
        }

        public void writeToParcel(Parcel parcel, int i) {
            C4687d.super.writeToParcel(parcel, i);
            parcel.writeLong(this.f15226b);
        }
    }

    /* renamed from: com.kwai.filedownloader.message.d$h */
    public static class C4695h extends C4691d {
        /* renamed from: b */
        private final int f15227b;

        C4695h(int i, long j, Throwable th, int i2) {
            super(i, j, th);
            this.f15227b = i2;
        }

        C4695h(Parcel parcel) {
            super(parcel);
            this.f15227b = parcel.readInt();
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
            return this.f15227b;
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.f15227b);
        }
    }

    /* renamed from: com.kwai.filedownloader.message.d$i */
    public static class C4696i extends C4697j implements C4685b {
        C4696i(int i, long j, long j2) {
            super(i, j, j2);
        }
    }

    /* renamed from: com.kwai.filedownloader.message.d$j */
    public static class C4697j extends C4693f implements C4681a {
        C4697j(int i, long j, long j2) {
            super(i, j, j2);
        }

        C4697j(Parcel parcel) {
            super(parcel);
        }

        /* renamed from: b */
        public byte mo25286b() {
            return -4;
        }

        /* renamed from: l */
        public MessageSnapshot mo25285l() {
            return new C4693f((C4693f) this);
        }
    }

    C4687d(int i) {
        super(i);
        this.f15213a = true;
    }

    C4687d(Parcel parcel) {
        super(parcel);
    }

    /* renamed from: a */
    public int mo25267a() {
        return mo25275i() > 2147483647L ? ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED : (int) mo25275i();
    }

    /* renamed from: c */
    public int mo25268c() {
        return mo25269d() > 2147483647L ? ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED : (int) mo25269d();
    }
}
