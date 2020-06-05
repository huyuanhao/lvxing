package com.tencent.bugly.beta.upgrade;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.bugly.beta.global.C7131e;
import com.tencent.bugly.crashreport.common.strategy.StrategyBean;
import com.tencent.bugly.proguard.C7216ah;
import com.tencent.bugly.proguard.C7253bk;
import com.tencent.bugly.proguard.C7267m;

/* compiled from: BUGLY */
public class BetaUploadStrategy implements Parcelable, Creator<BetaUploadStrategy> {
    public static final Creator<BetaUploadStrategy> CREATOR = new BetaUploadStrategy();
    /* renamed from: a */
    public C7253bk f23823a;
    /* renamed from: b */
    public long f23824b;

    public int describeContents() {
        return 0;
    }

    public BetaUploadStrategy() {
        this.f23823a = new C7253bk();
        C7253bk bkVar = this.f23823a;
        bkVar.f24526b = true;
        bkVar.f24527c = true;
        if (C7131e.f23698E.f23715Q) {
            this.f23823a.f24528d = StrategyBean.f24052b;
            this.f23823a.f24529e = StrategyBean.f24052b;
        } else {
            C7253bk bkVar2 = this.f23823a;
            String str = "http://android.bugly.qq.com/rqd/async";
            bkVar2.f24528d = str;
            bkVar2.f24529e = str;
        }
        long currentTimeMillis = System.currentTimeMillis();
        this.f23823a.f24532h = currentTimeMillis;
        this.f23824b = currentTimeMillis;
    }

    public BetaUploadStrategy(Parcel parcel) {
        this.f23823a = (C7253bk) C7216ah.m31077a(parcel.createByteArray(), C7253bk.class);
        this.f23824b = parcel.readLong();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeByteArray(C7216ah.m31078a((C7267m) this.f23823a));
        parcel.writeLong(this.f23824b);
    }

    /* renamed from: a */
    public BetaUploadStrategy createFromParcel(Parcel parcel) {
        return new BetaUploadStrategy(parcel);
    }

    /* renamed from: a */
    public BetaUploadStrategy[] newArray(int i) {
        return new BetaUploadStrategy[i];
    }
}
