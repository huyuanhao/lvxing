package com.p530ss.android.socialbase.downloader.p562g;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.p530ss.android.socialbase.downloader.p561f.C6704a;
import com.p530ss.android.socialbase.downloader.p568l.DownloadChunkRunnable;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/* renamed from: com.ss.android.socialbase.downloader.g.b */
public class DownloadChunk implements Parcelable {
    public static final Creator<DownloadChunk> CREATOR = new Creator<DownloadChunk>() {
        /* renamed from: a */
        public DownloadChunk createFromParcel(Parcel parcel) {
            return new DownloadChunk(parcel);
        }

        /* renamed from: a */
        public DownloadChunk[] newArray(int i) {
            return new DownloadChunk[i];
        }
    };
    /* renamed from: a */
    private static final String f21952a = DownloadChunk.class.getSimpleName();
    /* renamed from: b */
    private int f21953b;
    /* renamed from: c */
    private long f21954c;
    /* renamed from: d */
    private AtomicLong f21955d;
    /* renamed from: e */
    private long f21956e;
    /* renamed from: f */
    private long f21957f;
    /* renamed from: g */
    private int f21958g;
    /* renamed from: h */
    private AtomicInteger f21959h;
    /* renamed from: i */
    private long f21960i;
    /* renamed from: j */
    private List<DownloadChunk> f21961j;
    /* renamed from: k */
    private DownloadChunk f21962k;
    /* renamed from: l */
    private int f21963l;
    /* renamed from: m */
    private boolean f21964m;
    /* renamed from: n */
    private AtomicBoolean f21965n;
    /* renamed from: o */
    private DownloadChunkRunnable f21966o;

    /* compiled from: DownloadChunk */
    /* renamed from: com.ss.android.socialbase.downloader.g.b$a */
    public static class C6709a {
        /* access modifiers changed from: private */
        /* renamed from: a */
        public int f21967a;
        /* access modifiers changed from: private */
        /* renamed from: b */
        public long f21968b;
        /* access modifiers changed from: private */
        /* renamed from: c */
        public long f21969c;
        /* access modifiers changed from: private */
        /* renamed from: d */
        public long f21970d;
        /* access modifiers changed from: private */
        /* renamed from: e */
        public long f21971e;
        /* access modifiers changed from: private */
        /* renamed from: f */
        public int f21972f;
        /* access modifiers changed from: private */
        /* renamed from: g */
        public long f21973g;
        /* access modifiers changed from: private */
        /* renamed from: h */
        public DownloadChunk f21974h;

        public C6709a(int i) {
            this.f21967a = i;
        }

        /* renamed from: a */
        public C6709a mo32148a(long j) {
            this.f21968b = j;
            return this;
        }

        /* renamed from: b */
        public C6709a mo32151b(long j) {
            this.f21969c = j;
            return this;
        }

        /* renamed from: c */
        public C6709a mo32152c(long j) {
            this.f21970d = j;
            return this;
        }

        /* renamed from: d */
        public C6709a mo32153d(long j) {
            this.f21971e = j;
            return this;
        }

        /* renamed from: a */
        public C6709a mo32147a(int i) {
            this.f21972f = i;
            return this;
        }

        /* renamed from: a */
        public C6709a mo32149a(DownloadChunk bVar) {
            this.f21974h = bVar;
            return this;
        }

        /* renamed from: e */
        public C6709a mo32154e(long j) {
            this.f21973g = j;
            return this;
        }

        /* renamed from: a */
        public DownloadChunk mo32150a() {
            return new DownloadChunk(this);
        }
    }

    public int describeContents() {
        return 0;
    }

    private DownloadChunk(C6709a aVar) {
        if (aVar != null) {
            this.f21953b = aVar.f21967a;
            this.f21954c = aVar.f21968b;
            this.f21955d = new AtomicLong(aVar.f21969c);
            this.f21956e = aVar.f21970d;
            this.f21957f = aVar.f21971e;
            this.f21958g = aVar.f21972f;
            this.f21960i = aVar.f21973g;
            this.f21959h = new AtomicInteger(-1);
            mo32114a(aVar.f21974h);
            this.f21965n = new AtomicBoolean(false);
        }
    }

    public DownloadChunk(Cursor cursor) {
        if (cursor != null) {
            this.f21953b = cursor.getInt(cursor.getColumnIndex(C7887a.f26833ID));
            this.f21958g = cursor.getInt(cursor.getColumnIndex("chunkIndex"));
            this.f21954c = cursor.getLong(cursor.getColumnIndex("startOffset"));
            int columnIndex = cursor.getColumnIndex("curOffset");
            if (columnIndex != -1) {
                this.f21955d = new AtomicLong(cursor.getLong(columnIndex));
            } else {
                this.f21955d = new AtomicLong(0);
            }
            this.f21956e = cursor.getLong(cursor.getColumnIndex("endOffset"));
            int columnIndex2 = cursor.getColumnIndex("hostChunkIndex");
            if (columnIndex2 != -1) {
                this.f21959h = new AtomicInteger(cursor.getInt(columnIndex2));
            } else {
                this.f21959h = new AtomicInteger(-1);
            }
            int columnIndex3 = cursor.getColumnIndex("chunkContentLen");
            if (columnIndex3 != -1) {
                this.f21957f = cursor.getLong(columnIndex3);
            }
            this.f21965n = new AtomicBoolean(false);
        }
    }

    protected DownloadChunk(Parcel parcel) {
        this.f21953b = parcel.readInt();
        this.f21954c = parcel.readLong();
        this.f21955d = new AtomicLong(parcel.readLong());
        this.f21956e = parcel.readLong();
        this.f21957f = parcel.readLong();
        this.f21958g = parcel.readInt();
        this.f21959h = new AtomicInteger(parcel.readInt());
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f21953b);
        parcel.writeLong(this.f21954c);
        AtomicLong atomicLong = this.f21955d;
        parcel.writeLong(atomicLong != null ? atomicLong.get() : 0);
        parcel.writeLong(this.f21956e);
        parcel.writeLong(this.f21957f);
        parcel.writeInt(this.f21958g);
        int i2 = -1;
        AtomicInteger atomicInteger = this.f21959h;
        if (atomicInteger != null) {
            i2 = atomicInteger.get();
        }
        parcel.writeInt(i2);
    }

    /* renamed from: a */
    public ContentValues mo32109a() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(C7887a.f26833ID, Integer.valueOf(this.f21953b));
        contentValues.put("chunkIndex", Integer.valueOf(this.f21958g));
        contentValues.put("startOffset", Long.valueOf(this.f21954c));
        contentValues.put("curOffset", Long.valueOf(mo32136n()));
        contentValues.put("endOffset", Long.valueOf(this.f21956e));
        contentValues.put("chunkContentLen", Long.valueOf(this.f21957f));
        contentValues.put("hostChunkIndex", Integer.valueOf(mo32118b()));
        return contentValues;
    }

    /* renamed from: a */
    public void mo32113a(SQLiteStatement sQLiteStatement) {
        if (sQLiteStatement != null) {
            this.f21963l = 0;
            sQLiteStatement.clearBindings();
            int i = this.f21963l + 1;
            this.f21963l = i;
            sQLiteStatement.bindLong(i, (long) this.f21953b);
            int i2 = this.f21963l + 1;
            this.f21963l = i2;
            sQLiteStatement.bindLong(i2, (long) this.f21958g);
            int i3 = this.f21963l + 1;
            this.f21963l = i3;
            sQLiteStatement.bindLong(i3, this.f21954c);
            int i4 = this.f21963l + 1;
            this.f21963l = i4;
            sQLiteStatement.bindLong(i4, mo32136n());
            int i5 = this.f21963l + 1;
            this.f21963l = i5;
            sQLiteStatement.bindLong(i5, this.f21956e);
            int i6 = this.f21963l + 1;
            this.f21963l = i6;
            sQLiteStatement.bindLong(i6, this.f21957f);
            int i7 = this.f21963l + 1;
            this.f21963l = i7;
            sQLiteStatement.bindLong(i7, (long) mo32118b());
        }
    }

    /* renamed from: b */
    public int mo32118b() {
        AtomicInteger atomicInteger = this.f21959h;
        if (atomicInteger == null) {
            return -1;
        }
        return atomicInteger.get();
    }

    /* renamed from: a */
    public void mo32111a(int i) {
        AtomicInteger atomicInteger = this.f21959h;
        if (atomicInteger == null) {
            this.f21959h = new AtomicInteger(i);
        } else {
            atomicInteger.set(i);
        }
    }

    /* renamed from: c */
    public boolean mo32124c() {
        AtomicBoolean atomicBoolean = this.f21965n;
        if (atomicBoolean == null) {
            return false;
        }
        return atomicBoolean.get();
    }

    /* renamed from: a */
    public void mo32115a(DownloadChunkRunnable bVar) {
        this.f21966o = bVar;
        mo32140r();
    }

    /* renamed from: a */
    public void mo32117a(boolean z) {
        AtomicBoolean atomicBoolean = this.f21965n;
        if (atomicBoolean == null) {
            this.f21965n = new AtomicBoolean(z);
        } else {
            atomicBoolean.set(z);
        }
        this.f21966o = null;
    }

    /* renamed from: a */
    public void mo32114a(DownloadChunk bVar) {
        this.f21962k = bVar;
        DownloadChunk bVar2 = this.f21962k;
        if (bVar2 != null) {
            mo32111a(bVar2.mo32141s());
        }
    }

    /* renamed from: d */
    public boolean mo32125d() {
        return mo32118b() == -1;
    }

    /* renamed from: e */
    public DownloadChunk mo32127e() {
        DownloadChunk bVar = !mo32125d() ? this.f21962k : this;
        if (bVar == null || !bVar.mo32128f()) {
            return null;
        }
        return (DownloadChunk) bVar.mo32129g().get(0);
    }

    /* renamed from: f */
    public boolean mo32128f() {
        List<DownloadChunk> list = this.f21961j;
        return list != null && list.size() > 0;
    }

    /* renamed from: a */
    public void mo32116a(List<DownloadChunk> list) {
        this.f21961j = list;
    }

    /* renamed from: g */
    public List<DownloadChunk> mo32129g() {
        return this.f21961j;
    }

    /* renamed from: h */
    public boolean mo32130h() {
        DownloadChunk bVar = this.f21962k;
        if (bVar == null) {
            return true;
        }
        if (!bVar.mo32128f()) {
            return false;
        }
        for (int i = 0; i < this.f21962k.mo32129g().size(); i++) {
            DownloadChunk bVar2 = (DownloadChunk) this.f21962k.mo32129g().get(i);
            if (bVar2 != null) {
                int indexOf = this.f21962k.mo32129g().indexOf(this);
                if (indexOf > i && !bVar2.mo32131i()) {
                    return false;
                }
                if (indexOf == i) {
                    return true;
                }
            }
        }
        return false;
    }

    /* renamed from: b */
    public void mo32121b(boolean z) {
        this.f21964m = z;
    }

    /* renamed from: i */
    public boolean mo32131i() {
        long j = this.f21954c;
        if (mo32125d()) {
            long j2 = this.f21960i;
            if (j2 > this.f21954c) {
                j = j2;
            }
        }
        return mo32136n() - j >= this.f21957f;
    }

    /* renamed from: j */
    public long mo32132j() {
        DownloadChunk bVar = this.f21962k;
        if (!(bVar == null || bVar.mo32129g() == null)) {
            int indexOf = this.f21962k.mo32129g().indexOf(this);
            boolean z = false;
            for (int i = 0; i < this.f21962k.mo32129g().size(); i++) {
                DownloadChunk bVar2 = (DownloadChunk) this.f21962k.mo32129g().get(i);
                if (bVar2 != null) {
                    if (z) {
                        return bVar2.mo32136n();
                    }
                    if (indexOf == i) {
                        z = true;
                    }
                }
            }
        }
        return -1;
    }

    /* renamed from: b */
    public void mo32119b(int i) {
        this.f21953b = i;
    }

    /* renamed from: c */
    public void mo32123c(int i) {
        this.f21958g = i;
    }

    /* renamed from: a */
    public void mo32112a(long j) {
        this.f21957f = j;
    }

    /* renamed from: k */
    public int mo32133k() {
        return this.f21953b;
    }

    /* renamed from: l */
    public long mo32134l() {
        return this.f21954c;
    }

    /* renamed from: m */
    public long mo32135m() {
        AtomicLong atomicLong = this.f21955d;
        if (atomicLong != null) {
            return atomicLong.get();
        }
        return 0;
    }

    /* renamed from: n */
    public long mo32136n() {
        if (!mo32125d() || !mo32128f()) {
            return mo32135m();
        }
        long j = 0;
        for (int i = 0; i < this.f21961j.size(); i++) {
            DownloadChunk bVar = (DownloadChunk) this.f21961j.get(i);
            if (bVar != null) {
                if (!bVar.mo32131i()) {
                    return bVar.mo32135m();
                }
                if (j < bVar.mo32135m()) {
                    j = bVar.mo32135m();
                }
            }
        }
        return j;
    }

    /* renamed from: b */
    public void mo32120b(long j) {
        AtomicLong atomicLong = this.f21955d;
        if (atomicLong != null) {
            atomicLong.set(j);
        } else {
            this.f21955d = new AtomicLong(j);
        }
    }

    /* renamed from: o */
    public long mo32137o() {
        long n = mo32136n() - this.f21954c;
        if (mo32128f()) {
            n = 0;
            for (int i = 0; i < this.f21961j.size(); i++) {
                DownloadChunk bVar = (DownloadChunk) this.f21961j.get(i);
                if (bVar != null) {
                    n += bVar.mo32136n() - bVar.mo32134l();
                }
            }
        }
        return n;
    }

    /* renamed from: p */
    public long mo32138p() {
        return this.f21956e;
    }

    /* renamed from: q */
    public long mo32139q() {
        return this.f21957f;
    }

    /* renamed from: r */
    public void mo32140r() {
        this.f21960i = mo32136n();
    }

    /* renamed from: c */
    public long mo32122c(boolean z) {
        long n = mo32136n();
        long j = this.f21957f;
        long j2 = this.f21960i;
        long j3 = j - (n - j2);
        if (!z && n == j2) {
            j3 = j - (n - this.f21954c);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("contentLength:");
        sb.append(this.f21957f);
        sb.append(" curOffset:");
        sb.append(mo32136n());
        sb.append(" oldOffset:");
        sb.append(this.f21960i);
        sb.append(" retainLen:");
        sb.append(j3);
        C6704a.m27758b("DownloadChunk", sb.toString());
        if (j3 < 0) {
            return 0;
        }
        return j3;
    }

    /* renamed from: a */
    public List<DownloadChunk> mo32110a(int i, long j) {
        long j2;
        long j3;
        long j4;
        long j5;
        long j6;
        int i2 = i;
        if (!mo32125d() || mo32128f()) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        long m = mo32135m();
        int i3 = 1;
        long c = mo32122c(true);
        long j7 = c / ((long) i2);
        String str = f21952a;
        StringBuilder sb = new StringBuilder();
        sb.append("retainLen:");
        sb.append(c);
        sb.append(" divideChunkForReuse chunkSize:");
        sb.append(j7);
        sb.append(" current host downloadChunk index:");
        sb.append(this.f21958g);
        C6704a.m27758b(str, sb.toString());
        long j8 = m;
        int i4 = 0;
        while (i4 < i2) {
            if (i4 == 0) {
                j6 = (j8 + j7) - 1;
                j3 = j7;
                j5 = mo32134l();
            } else {
                int i5 = i2 - 1;
                if (i4 == i5) {
                    long p = mo32138p();
                    j3 = p > j8 ? 1 + (p - j8) : c - (((long) i5) * j7);
                    j4 = p;
                    j5 = j8;
                    long j9 = c;
                    long j10 = j4;
                    long j11 = j8;
                    long j12 = j3;
                    DownloadChunk a = new C6709a(this.f21953b).mo32147a((-i4) - i3).mo32148a(j5).mo32151b(j8).mo32154e(j8).mo32152c(j10).mo32153d(j12).mo32149a(this).mo32150a();
                    String str2 = f21952a;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("divide sub chunk : ");
                    sb2.append(i4);
                    sb2.append(" startOffset:");
                    sb2.append(j5);
                    sb2.append(" curOffset:");
                    long j13 = j11;
                    sb2.append(j13);
                    sb2.append(" endOffset:");
                    sb2.append(j10);
                    sb2.append(" contentLen:");
                    sb2.append(j12);
                    C6704a.m27758b(str2, sb2.toString());
                    arrayList.add(a);
                    j8 = j13 + j7;
                    i4++;
                    c = j9;
                    i3 = 1;
                } else {
                    j6 = (j8 + j7) - 1;
                    j3 = j7;
                    j5 = j8;
                }
            }
            j4 = j6;
            long j92 = c;
            long j102 = j4;
            long j112 = j8;
            long j122 = j3;
            DownloadChunk a2 = new C6709a(this.f21953b).mo32147a((-i4) - i3).mo32148a(j5).mo32151b(j8).mo32154e(j8).mo32152c(j102).mo32153d(j122).mo32149a(this).mo32150a();
            String str22 = f21952a;
            StringBuilder sb22 = new StringBuilder();
            sb22.append("divide sub chunk : ");
            sb22.append(i4);
            sb22.append(" startOffset:");
            sb22.append(j5);
            sb22.append(" curOffset:");
            long j132 = j112;
            sb22.append(j132);
            sb22.append(" endOffset:");
            sb22.append(j102);
            sb22.append(" contentLen:");
            sb22.append(j122);
            C6704a.m27758b(str22, sb22.toString());
            arrayList.add(a2);
            j8 = j132 + j7;
            i4++;
            c = j92;
            i3 = 1;
        }
        long j14 = 0;
        for (int size = arrayList.size() - 1; size > 0; size--) {
            DownloadChunk bVar = (DownloadChunk) arrayList.get(size);
            if (bVar != null) {
                j14 += bVar.mo32139q();
            }
        }
        String str3 = f21952a;
        StringBuilder sb3 = new StringBuilder();
        sb3.append("reuseChunkContentLen:");
        sb3.append(j14);
        C6704a.m27758b(str3, sb3.toString());
        DownloadChunk bVar2 = (DownloadChunk) arrayList.get(0);
        if (bVar2 != null) {
            if (mo32138p() == 0) {
                j2 = j - mo32134l();
            } else {
                j2 = (mo32138p() - mo32134l()) + 1;
            }
            bVar2.mo32112a(j2 - j14);
            bVar2.mo32123c(this.f21958g);
            DownloadChunkRunnable bVar3 = this.f21966o;
            if (bVar3 != null) {
                bVar3.mo32559a(bVar2.mo32138p(), mo32139q() - j14);
            }
        }
        mo32116a((List<DownloadChunk>) arrayList);
        return arrayList;
    }

    /* renamed from: s */
    public int mo32141s() {
        return this.f21958g;
    }
}
