package com.alibaba.mtl.appmonitor.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.alibaba.mtl.appmonitor.p070c.BalancedPool;
import com.alibaba.mtl.appmonitor.p070c.Reusable;

public class MeasureValue implements Parcelable, Reusable {
    public static final Creator<MeasureValue> CREATOR = new Creator<MeasureValue>() {
        /* renamed from: a */
        public MeasureValue createFromParcel(Parcel parcel) {
            return MeasureValue.m3644a(parcel);
        }

        /* renamed from: a */
        public MeasureValue[] newArray(int i) {
            return new MeasureValue[i];
        }
    };
    /* renamed from: a */
    private boolean f3254a;
    /* renamed from: b */
    private Double f3255b;
    /* renamed from: c */
    private double f3256c;

    public int describeContents() {
        return 0;
    }

    /* renamed from: a */
    public static MeasureValue m3643a() {
        return (MeasureValue) BalancedPool.m3491a().mo11627a(MeasureValue.class, new Object[0]);
    }

    /* renamed from: b */
    public Double mo11724b() {
        return this.f3255b;
    }

    /* renamed from: c */
    public boolean mo11726c() {
        return this.f3254a;
    }

    /* renamed from: a */
    public void mo11723a(boolean z) {
        this.f3254a = z;
    }

    /* renamed from: a */
    public void mo11721a(double d) {
        this.f3255b = Double.valueOf(d);
    }

    /* renamed from: e */
    public double mo11728e() {
        return this.f3256c;
    }

    /* renamed from: b */
    public void mo11725b(double d) {
        this.f3256c = d;
    }

    /* renamed from: a */
    public synchronized void mo11722a(MeasureValue measureValue) {
        if (measureValue != null) {
            try {
                this.f3256c += measureValue.mo11728e();
                if (measureValue.mo11724b() != null) {
                    if (this.f3255b == null) {
                        this.f3255b = Double.valueOf(0.0d);
                    }
                    this.f3255b = Double.valueOf(this.f3255b.doubleValue() + measureValue.mo11724b().doubleValue());
                }
            } catch (Throwable unused) {
            }
        }
    }

    /* renamed from: d */
    public synchronized void mo11546d() {
        this.f3256c = 0.0d;
        this.f3255b = null;
        this.f3254a = false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0020, code lost:
            return;
     */
    /* renamed from: a */
    public synchronized void mo11548a(java.lang.Object... r5) {
        /*
        r4 = this;
        monitor-enter(r4)
        if (r5 != 0) goto L_0x0005
        monitor-exit(r4)
        return
    L_0x0005:
        int r0 = r5.length     // Catch:{ all -> 0x0021 }
        r1 = 0
        if (r0 <= 0) goto L_0x0013
        r0 = r5[r1]     // Catch:{ all -> 0x0021 }
        java.lang.Double r0 = (java.lang.Double) r0     // Catch:{ all -> 0x0021 }
        double r2 = r0.doubleValue()     // Catch:{ all -> 0x0021 }
        r4.f3256c = r2     // Catch:{ all -> 0x0021 }
    L_0x0013:
        int r0 = r5.length     // Catch:{ all -> 0x0021 }
        r2 = 1
        if (r0 <= r2) goto L_0x001f
        r5 = r5[r2]     // Catch:{ all -> 0x0021 }
        java.lang.Double r5 = (java.lang.Double) r5     // Catch:{ all -> 0x0021 }
        r4.f3255b = r5     // Catch:{ all -> 0x0021 }
        r4.f3254a = r1     // Catch:{ all -> 0x0021 }
    L_0x001f:
        monitor-exit(r4)
        return
    L_0x0021:
        r5 = move-exception
        monitor-exit(r4)
        throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.mtl.appmonitor.model.MeasureValue.mo11548a(java.lang.Object[]):void");
    }

    public void writeToParcel(Parcel parcel, int i) {
        try {
            parcel.writeInt(this.f3254a ? 1 : 0);
            parcel.writeDouble(this.f3255b == null ? 0.0d : this.f3255b.doubleValue());
            parcel.writeDouble(this.f3256c);
        } catch (Throwable unused) {
        }
    }

    /* renamed from: a */
    static MeasureValue m3644a(Parcel parcel) {
        try {
            boolean z = parcel.readInt() != 0;
            Double valueOf = Double.valueOf(parcel.readDouble());
            double readDouble = parcel.readDouble();
            MeasureValue a = m3643a();
            a.f3254a = z;
            a.f3255b = valueOf;
            a.f3256c = readDouble;
            return a;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }
}
