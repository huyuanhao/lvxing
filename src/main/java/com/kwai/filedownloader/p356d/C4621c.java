package com.kwai.filedownloader.p356d;

import android.content.ContentValues;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import androidx.core.app.NotificationCompat;
import com.kwai.filedownloader.p358f.C4664f;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/* renamed from: com.kwai.filedownloader.d.c */
public class C4621c implements Parcelable {
    public static final Creator<C4621c> CREATOR = new Creator<C4621c>() {
        /* renamed from: a */
        public C4621c createFromParcel(Parcel parcel) {
            return new C4621c(parcel);
        }

        /* renamed from: a */
        public C4621c[] newArray(int i) {
            return new C4621c[i];
        }
    };
    /* renamed from: a */
    private int f15036a;
    /* renamed from: b */
    private String f15037b;
    /* renamed from: c */
    private String f15038c;
    /* renamed from: d */
    private boolean f15039d;
    /* renamed from: e */
    private String f15040e;
    /* renamed from: f */
    private final AtomicInteger f15041f;
    /* renamed from: g */
    private final AtomicLong f15042g;
    /* renamed from: h */
    private long f15043h;
    /* renamed from: i */
    private String f15044i;
    /* renamed from: j */
    private String f15045j;
    /* renamed from: k */
    private int f15046k;
    /* renamed from: l */
    private boolean f15047l;

    public C4621c() {
        this.f15042g = new AtomicLong();
        this.f15041f = new AtomicInteger();
    }

    protected C4621c(Parcel parcel) {
        this.f15036a = parcel.readInt();
        this.f15037b = parcel.readString();
        this.f15038c = parcel.readString();
        boolean z = true;
        this.f15039d = parcel.readByte() != 0;
        this.f15040e = parcel.readString();
        this.f15041f = new AtomicInteger(parcel.readByte());
        this.f15042g = new AtomicLong(parcel.readLong());
        this.f15043h = parcel.readLong();
        this.f15044i = parcel.readString();
        this.f15045j = parcel.readString();
        this.f15046k = parcel.readInt();
        if (parcel.readByte() == 0) {
            z = false;
        }
        this.f15047l = z;
    }

    /* renamed from: a */
    public int mo25071a() {
        return this.f15036a;
    }

    /* renamed from: a */
    public void mo25072a(byte b) {
        this.f15041f.set(b);
    }

    /* renamed from: a */
    public void mo25073a(int i) {
        this.f15036a = i;
    }

    /* renamed from: a */
    public void mo25074a(long j) {
        this.f15042g.set(j);
    }

    /* renamed from: a */
    public void mo25075a(String str) {
        this.f15037b = str;
    }

    /* renamed from: a */
    public void mo25076a(String str, boolean z) {
        this.f15038c = str;
        this.f15039d = z;
    }

    /* renamed from: b */
    public String mo25077b() {
        return this.f15037b;
    }

    /* renamed from: b */
    public void mo25078b(int i) {
        this.f15046k = i;
    }

    /* renamed from: b */
    public void mo25079b(long j) {
        this.f15042g.addAndGet(j);
    }

    /* renamed from: b */
    public void mo25080b(String str) {
        this.f15045j = str;
    }

    /* renamed from: c */
    public String mo25081c() {
        return this.f15038c;
    }

    /* renamed from: c */
    public void mo25082c(long j) {
        this.f15047l = j > 2147483647L;
        this.f15043h = j;
    }

    /* renamed from: c */
    public void mo25083c(String str) {
        this.f15044i = str;
    }

    /* renamed from: d */
    public String mo25084d() {
        return C4664f.m19134a(mo25081c(), mo25094l(), mo25095m());
    }

    /* renamed from: d */
    public void mo25085d(String str) {
        this.f15040e = str;
    }

    public int describeContents() {
        return 0;
    }

    /* renamed from: e */
    public String mo25087e() {
        if (mo25084d() == null) {
            return null;
        }
        return C4664f.m19153d(mo25084d());
    }

    /* renamed from: f */
    public byte mo25088f() {
        return (byte) this.f15041f.get();
    }

    /* renamed from: g */
    public long mo25089g() {
        return this.f15042g.get();
    }

    /* renamed from: h */
    public long mo25090h() {
        return this.f15043h;
    }

    /* renamed from: i */
    public boolean mo25091i() {
        return this.f15043h == -1;
    }

    /* renamed from: j */
    public String mo25092j() {
        return this.f15045j;
    }

    /* renamed from: k */
    public String mo25093k() {
        return this.f15044i;
    }

    /* renamed from: l */
    public boolean mo25094l() {
        return this.f15039d;
    }

    /* renamed from: m */
    public String mo25095m() {
        return this.f15040e;
    }

    /* renamed from: n */
    public int mo25096n() {
        return this.f15046k;
    }

    /* renamed from: o */
    public void mo25097o() {
        this.f15046k = 1;
    }

    /* renamed from: p */
    public ContentValues mo25098p() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(C7887a.f26833ID, Integer.valueOf(mo25071a()));
        contentValues.put("url", mo25077b());
        contentValues.put("path", mo25081c());
        contentValues.put(NotificationCompat.CATEGORY_STATUS, Byte.valueOf(mo25088f()));
        contentValues.put("sofar", Long.valueOf(mo25089g()));
        contentValues.put("total", Long.valueOf(mo25090h()));
        contentValues.put("errMsg", mo25093k());
        contentValues.put("etag", mo25092j());
        contentValues.put("connectionCount", Integer.valueOf(mo25096n()));
        contentValues.put("pathAsDirectory", Boolean.valueOf(mo25094l()));
        if (mo25094l() && mo25095m() != null) {
            contentValues.put("filename", mo25095m());
        }
        return contentValues;
    }

    /* renamed from: q */
    public boolean mo25099q() {
        return this.f15047l;
    }

    public String toString() {
        return C4664f.m19135a("id[%d], url[%s], path[%s], status[%d], sofar[%s], total[%d], etag[%s], %s", Integer.valueOf(this.f15036a), this.f15037b, this.f15038c, Integer.valueOf(this.f15041f.get()), this.f15042g, Long.valueOf(this.f15043h), this.f15045j, super.toString());
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f15036a);
        parcel.writeString(this.f15037b);
        parcel.writeString(this.f15038c);
        parcel.writeByte(this.f15039d);
        parcel.writeString(this.f15040e);
        parcel.writeByte((byte) this.f15041f.get());
        parcel.writeLong(this.f15042g.get());
        parcel.writeLong(this.f15043h);
        parcel.writeString(this.f15044i);
        parcel.writeString(this.f15045j);
        parcel.writeInt(this.f15046k);
        parcel.writeByte(this.f15047l);
    }
}
