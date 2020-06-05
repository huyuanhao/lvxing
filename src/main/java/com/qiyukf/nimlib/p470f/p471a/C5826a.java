package com.qiyukf.nimlib.p470f.p471a;

import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.SparseArray;
import com.qiyukf.nimlib.p429a.p436c.C5669a;
import com.qiyukf.nimlib.p429a.p442d.C5686a.C5687a;
import com.qiyukf.nimlib.p473h.p481c.C5888a;
import com.qiyukf.nimlib.p473h.p481c.p484c.C5894b;
import com.qiyukf.nimlib.p473h.p481c.p484c.C5898f;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: com.qiyukf.nimlib.f.a.a */
public final class C5826a implements Parcelable {
    public static final Creator<C5826a> CREATOR = new Creator<C5826a>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            C5826a a = C5829b.m23369a(parcel);
            if (a != null) {
                a.f18502d.flip();
            }
            return a;
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new C5826a[i];
        }
    };
    /* renamed from: a */
    public int f18499a;
    /* access modifiers changed from: private */
    /* renamed from: b */
    public int f18500b;
    /* access modifiers changed from: private */
    /* renamed from: c */
    public ByteBuffer f18501c;
    /* access modifiers changed from: private */
    /* renamed from: d */
    public ByteBuffer f18502d;

    /* renamed from: com.qiyukf.nimlib.f.a.a$a */
    private static final class C5828a {
        /* renamed from: a */
        private static AtomicInteger f18503a = new AtomicInteger(0);

        /* renamed from: a */
        public static int m23368a() {
            return f18503a.incrementAndGet();
        }
    }

    /* renamed from: com.qiyukf.nimlib.f.a.a$b */
    private static class C5829b {
        /* renamed from: a */
        private static SparseArray<C5826a> f18504a = new SparseArray<>();

        /* JADX WARNING: Removed duplicated region for block: B:16:0x006e A[RETURN] */
        /* JADX WARNING: Removed duplicated region for block: B:17:0x006f  */
        /* renamed from: a */
        static com.qiyukf.nimlib.p470f.p471a.C5826a m23369a(android.os.Parcel r4) {
            /*
            com.qiyukf.nimlib.f.a.a r0 = new com.qiyukf.nimlib.f.a.a
            r1 = 0
            r0.m50001init(r1)
            int r2 = r4.readInt()
            r0.f18499a = r2
            int r2 = r4.readInt()
            if (r2 <= 0) goto L_0x001d
            byte[] r2 = r4.createByteArray()
            java.nio.ByteBuffer r2 = java.nio.ByteBuffer.wrap(r2)
            r0.f18501c = r2
        L_0x001d:
            int r2 = r4.readInt()
            r0.f18500b = r2
            int r2 = r4.readInt()
            if (r2 <= 0) goto L_0x0061
            byte[] r4 = r4.createByteArray()
            int r3 = r0.f18500b
            if (r3 <= 0) goto L_0x005c
            int r1 = r0.f18500b
            if (r1 != r2) goto L_0x0049
            java.nio.ByteBuffer r4 = java.nio.ByteBuffer.wrap(r4)
            r0.f18502d = r4
            java.nio.ByteBuffer r4 = r0.f18502d
            r4.position(r2)
            goto L_0x0068
        L_0x0049:
            int r1 = r0.f18500b
            java.nio.ByteBuffer r1 = java.nio.ByteBuffer.allocate(r1)
            r0.f18502d = r1
            java.nio.ByteBuffer r1 = r0.f18502d
            r1.put(r4)
            goto L_0x0068
        L_0x005c:
            java.nio.ByteBuffer r4 = java.nio.ByteBuffer.wrap(r4, r1, r2)
            goto L_0x0065
        L_0x0061:
            java.nio.ByteBuffer r4 = java.nio.ByteBuffer.allocate(r1)
        L_0x0065:
            r0.f18502d = r4
        L_0x0068:
            boolean r4 = m23372b(r0)
            if (r4 == 0) goto L_0x006f
            return r0
        L_0x006f:
            int r4 = r0.f18500b
            if (r4 <= 0) goto L_0x007d
            android.util.SparseArray<com.qiyukf.nimlib.f.a.a> r4 = f18504a
            int r1 = r0.f18499a
            r4.put(r1, r0)
            goto L_0x00a2
        L_0x007d:
            android.util.SparseArray<com.qiyukf.nimlib.f.a.a> r4 = f18504a
            int r1 = r0.f18499a
            java.lang.Object r4 = r4.get(r1)
            com.qiyukf.nimlib.f.a.a r4 = (com.qiyukf.nimlib.p470f.p471a.C5826a) r4
            if (r4 == 0) goto L_0x00a2
            java.nio.ByteBuffer r1 = r4.f18502d
            java.nio.ByteBuffer r0 = r0.f18502d
            r1.put(r0)
            boolean r0 = m23372b(r4)
            if (r0 == 0) goto L_0x00a2
            android.util.SparseArray<com.qiyukf.nimlib.f.a.a> r0 = f18504a
            int r1 = r4.f18499a
            r0.remove(r1)
            return r4
        L_0x00a2:
            r4 = 0
            return r4
            */
            throw new UnsupportedOperationException("Method not decompiled: com.qiyukf.nimlib.p470f.p471a.C5826a.C5829b.m23369a(android.os.Parcel):com.qiyukf.nimlib.f.a.a");
        }

        /* renamed from: a */
        static List<C5826a> m23370a(C5826a aVar) {
            aVar.f18500b = aVar.f18502d.remaining();
            int c = ((aVar.f18500b - 1) / 131072) + 1;
            ArrayList arrayList = new ArrayList(c);
            arrayList.add(aVar);
            for (int i = 1; i < c; i++) {
                C5826a aVar2 = new C5826a(0);
                aVar2.f18499a = aVar.f18499a;
                aVar2.f18502d = aVar.f18502d.duplicate();
                aVar2.f18502d.position(aVar.f18502d.position() + (i * 131072));
                arrayList.add(aVar2);
            }
            return arrayList;
        }

        /* renamed from: a */
        static void m23371a(Parcel parcel, C5826a aVar) {
            parcel.writeInt(aVar.f18499a);
            if (aVar.f18501c == null || aVar.f18501c.remaining() <= 0) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(aVar.f18501c.limit());
                parcel.writeByteArray(aVar.f18501c.array(), 0, aVar.f18501c.limit());
            }
            parcel.writeInt(aVar.f18500b);
            if (aVar.f18502d.remaining() > 0) {
                int min = Math.min(aVar.f18502d.remaining(), 131072);
                parcel.writeInt(min);
                C5826a.m23360a(parcel, aVar.f18502d.array(), aVar.f18502d.position(), min);
                return;
            }
            parcel.writeInt(0);
        }

        /* renamed from: b */
        private static boolean m23372b(C5826a aVar) {
            return aVar.f18502d.capacity() == 0 || (aVar.f18500b > 0 && aVar.f18502d.position() == aVar.f18500b);
        }
    }

    private C5826a() {
    }

    /* synthetic */ C5826a(byte b) {
        this();
    }

    public C5826a(C5669a aVar) {
        this.f18499a = C5828a.m23368a();
        C5894b bVar = new C5894b();
        aVar.mo27870a().mo28223a(bVar);
        this.f18501c = bVar.mo28258b();
        C5894b b = aVar.mo27872b();
        this.f18502d = b != null ? b.mo28258b() : ByteBuffer.allocate(0);
    }

    public C5826a(C5687a aVar) {
        this.f18499a = C5828a.m23368a();
        C5894b bVar = new C5894b();
        aVar.f18231a.mo28223a(bVar);
        this.f18501c = bVar.mo28258b();
        this.f18502d = aVar.f18232b != null ? aVar.f18232b.mo28263b() : ByteBuffer.allocate(0);
    }

    /* renamed from: a */
    static /* synthetic */ void m23360a(Parcel parcel, byte[] bArr, int i, int i2) {
        if (VERSION.SDK_INT >= 11) {
            parcel.writeByteArray(bArr, i, i2);
            return;
        }
        byte[] bArr2 = new byte[i2];
        System.arraycopy(bArr, i, bArr2, 0, i2);
        parcel.writeByteArray(bArr2);
    }

    /* renamed from: a */
    public final List<C5826a> mo28132a() {
        return C5829b.m23370a(this);
    }

    /* renamed from: b */
    public final C5888a mo28133b() {
        if (this.f18501c == null) {
            return null;
        }
        C5888a aVar = new C5888a();
        aVar.mo28224a(new C5898f(this.f18501c));
        return aVar;
    }

    /* renamed from: c */
    public final ByteBuffer mo28134c() {
        return this.f18502d;
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        C5829b.m23371a(parcel, this);
    }
}
