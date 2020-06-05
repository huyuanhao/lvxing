package com.yanzhenjie.album;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class AlbumFile implements Parcelable, Comparable<AlbumFile> {
    public static final Creator<AlbumFile> CREATOR = new Creator<AlbumFile>() {
        /* renamed from: a */
        public AlbumFile createFromParcel(Parcel parcel) {
            return new AlbumFile(parcel);
        }

        /* renamed from: a */
        public AlbumFile[] newArray(int i) {
            return new AlbumFile[i];
        }
    };
    /* renamed from: a */
    private String f26081a;
    /* renamed from: b */
    private String f26082b;
    /* renamed from: c */
    private String f26083c;
    /* renamed from: d */
    private long f26084d;
    /* renamed from: e */
    private float f26085e;
    /* renamed from: f */
    private float f26086f;
    /* renamed from: g */
    private long f26087g;
    /* renamed from: h */
    private long f26088h;
    /* renamed from: i */
    private String f26089i;
    /* renamed from: j */
    private int f26090j;
    /* renamed from: k */
    private boolean f26091k;
    /* renamed from: l */
    private boolean f26092l;

    @Retention(RetentionPolicy.SOURCE)
    /* renamed from: com.yanzhenjie.album.AlbumFile$MediaType */
    public @interface MediaType {
    }

    public int describeContents() {
        return 0;
    }

    public AlbumFile() {
    }

    /* renamed from: a */
    public int compareTo(AlbumFile albumFile) {
        long b = albumFile.mo37491b() - mo37491b();
        if (b > 2147483647L) {
            return ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        }
        if (b < -2147483647L) {
            return -2147483647;
        }
        return (int) b;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof AlbumFile)) {
            String a = ((AlbumFile) obj).mo37485a();
            String str = this.f26081a;
            if (!(str == null || a == null)) {
                return str.equals(a);
            }
        }
        return super.equals(obj);
    }

    public int hashCode() {
        String str = this.f26081a;
        return str != null ? str.hashCode() : super.hashCode();
    }

    /* renamed from: a */
    public String mo37485a() {
        return this.f26081a;
    }

    /* renamed from: a */
    public void mo37489a(String str) {
        this.f26081a = str;
    }

    /* renamed from: b */
    public void mo37494b(String str) {
        this.f26082b = str;
    }

    /* renamed from: c */
    public void mo37498c(String str) {
        this.f26083c = str;
    }

    /* renamed from: b */
    public long mo37491b() {
        return this.f26084d;
    }

    /* renamed from: a */
    public void mo37488a(long j) {
        this.f26084d = j;
    }

    /* renamed from: a */
    public void mo37486a(float f) {
        this.f26085e = f;
    }

    /* renamed from: b */
    public void mo37492b(float f) {
        this.f26086f = f;
    }

    /* renamed from: b */
    public void mo37493b(long j) {
        this.f26087g = j;
    }

    /* renamed from: c */
    public long mo37496c() {
        return this.f26088h;
    }

    /* renamed from: c */
    public void mo37497c(long j) {
        this.f26088h = j;
    }

    /* renamed from: d */
    public void mo37501d(String str) {
        this.f26089i = str;
    }

    /* renamed from: d */
    public int mo37500d() {
        return this.f26090j;
    }

    /* renamed from: a */
    public void mo37487a(int i) {
        this.f26090j = i;
    }

    /* renamed from: e */
    public boolean mo37503e() {
        return this.f26091k;
    }

    /* renamed from: a */
    public void mo37490a(boolean z) {
        this.f26091k = z;
    }

    /* renamed from: f */
    public boolean mo37505f() {
        return this.f26092l;
    }

    /* renamed from: b */
    public void mo37495b(boolean z) {
        this.f26092l = z;
    }

    protected AlbumFile(Parcel parcel) {
        this.f26081a = parcel.readString();
        this.f26082b = parcel.readString();
        this.f26083c = parcel.readString();
        this.f26084d = parcel.readLong();
        this.f26085e = parcel.readFloat();
        this.f26086f = parcel.readFloat();
        this.f26087g = parcel.readLong();
        this.f26088h = parcel.readLong();
        this.f26089i = parcel.readString();
        this.f26090j = parcel.readInt();
        boolean z = true;
        this.f26091k = parcel.readByte() != 0;
        if (parcel.readByte() == 0) {
            z = false;
        }
        this.f26092l = z;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f26081a);
        parcel.writeString(this.f26082b);
        parcel.writeString(this.f26083c);
        parcel.writeLong(this.f26084d);
        parcel.writeFloat(this.f26085e);
        parcel.writeFloat(this.f26086f);
        parcel.writeLong(this.f26087g);
        parcel.writeLong(this.f26088h);
        parcel.writeString(this.f26089i);
        parcel.writeInt(this.f26090j);
        parcel.writeByte(this.f26091k ? (byte) 1 : 0);
        parcel.writeByte(this.f26092l ? (byte) 1 : 0);
    }
}
