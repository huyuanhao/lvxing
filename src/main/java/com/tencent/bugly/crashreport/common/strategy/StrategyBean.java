package com.tencent.bugly.crashreport.common.strategy;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.bugly.proguard.C7232aq;
import java.util.Map;

/* compiled from: BUGLY */
public class StrategyBean implements Parcelable {
    public static final Creator<StrategyBean> CREATOR = new Creator<StrategyBean>() {
        /* renamed from: a */
        public StrategyBean createFromParcel(Parcel parcel) {
            return new StrategyBean(parcel);
        }

        /* renamed from: a */
        public StrategyBean[] newArray(int i) {
            return new StrategyBean[i];
        }
    };
    /* renamed from: a */
    public static String f24051a = "http://rqd.uu.qq.com/rqd/sync";
    /* renamed from: b */
    public static String f24052b = "http://android.bugly.qq.com/rqd/async";
    /* renamed from: c */
    public static String f24053c = "http://android.bugly.qq.com/rqd/async";
    /* renamed from: d */
    public static String f24054d;
    /* renamed from: e */
    public long f24055e;
    /* renamed from: f */
    public long f24056f;
    /* renamed from: g */
    public boolean f24057g;
    /* renamed from: h */
    public boolean f24058h;
    /* renamed from: i */
    public boolean f24059i;
    /* renamed from: j */
    public boolean f24060j;
    /* renamed from: k */
    public boolean f24061k;
    /* renamed from: l */
    public boolean f24062l;
    /* renamed from: m */
    public boolean f24063m;
    /* renamed from: n */
    public boolean f24064n;
    /* renamed from: o */
    public boolean f24065o;
    /* renamed from: p */
    public long f24066p;
    /* renamed from: q */
    public long f24067q;
    /* renamed from: r */
    public String f24068r;
    /* renamed from: s */
    public String f24069s;
    /* renamed from: t */
    public String f24070t;
    /* renamed from: u */
    public String f24071u;
    /* renamed from: v */
    public Map<String, String> f24072v;
    /* renamed from: w */
    public int f24073w;
    /* renamed from: x */
    public long f24074x;
    /* renamed from: y */
    public long f24075y;

    public int describeContents() {
        return 0;
    }

    public StrategyBean() {
        this.f24055e = -1;
        this.f24056f = -1;
        this.f24057g = true;
        this.f24058h = true;
        this.f24059i = true;
        this.f24060j = true;
        this.f24061k = false;
        this.f24062l = true;
        this.f24063m = true;
        this.f24064n = true;
        this.f24065o = true;
        this.f24067q = 30000;
        this.f24068r = f24052b;
        this.f24069s = f24053c;
        this.f24070t = f24051a;
        this.f24073w = 10;
        this.f24074x = 300000;
        this.f24075y = -1;
        this.f24056f = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder();
        sb.append("S(");
        sb.append("@L@L");
        sb.append("@)");
        f24054d = sb.toString();
        sb.setLength(0);
        sb.append("*^");
        sb.append("@K#K");
        sb.append("@!");
        this.f24071u = sb.toString();
    }

    public StrategyBean(Parcel parcel) {
        this.f24055e = -1;
        this.f24056f = -1;
        boolean z = true;
        this.f24057g = true;
        this.f24058h = true;
        this.f24059i = true;
        this.f24060j = true;
        this.f24061k = false;
        this.f24062l = true;
        this.f24063m = true;
        this.f24064n = true;
        this.f24065o = true;
        this.f24067q = 30000;
        this.f24068r = f24052b;
        this.f24069s = f24053c;
        this.f24070t = f24051a;
        this.f24073w = 10;
        this.f24074x = 300000;
        this.f24075y = -1;
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("S(");
            sb.append("@L@L");
            sb.append("@)");
            f24054d = sb.toString();
            this.f24056f = parcel.readLong();
            this.f24057g = parcel.readByte() == 1;
            this.f24058h = parcel.readByte() == 1;
            this.f24059i = parcel.readByte() == 1;
            this.f24068r = parcel.readString();
            this.f24069s = parcel.readString();
            this.f24071u = parcel.readString();
            this.f24072v = C7232aq.m31208b(parcel);
            this.f24060j = parcel.readByte() == 1;
            this.f24061k = parcel.readByte() == 1;
            this.f24064n = parcel.readByte() == 1;
            this.f24065o = parcel.readByte() == 1;
            this.f24067q = parcel.readLong();
            this.f24062l = parcel.readByte() == 1;
            if (parcel.readByte() != 1) {
                z = false;
            }
            this.f24063m = z;
            this.f24066p = parcel.readLong();
            this.f24073w = parcel.readInt();
            this.f24074x = parcel.readLong();
            this.f24075y = parcel.readLong();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.f24056f);
        parcel.writeByte(this.f24057g ? (byte) 1 : 0);
        parcel.writeByte(this.f24058h ? (byte) 1 : 0);
        parcel.writeByte(this.f24059i ? (byte) 1 : 0);
        parcel.writeString(this.f24068r);
        parcel.writeString(this.f24069s);
        parcel.writeString(this.f24071u);
        C7232aq.m31210b(parcel, this.f24072v);
        parcel.writeByte(this.f24060j ? (byte) 1 : 0);
        parcel.writeByte(this.f24061k ? (byte) 1 : 0);
        parcel.writeByte(this.f24064n ? (byte) 1 : 0);
        parcel.writeByte(this.f24065o ? (byte) 1 : 0);
        parcel.writeLong(this.f24067q);
        parcel.writeByte(this.f24062l ? (byte) 1 : 0);
        parcel.writeByte(this.f24063m ? (byte) 1 : 0);
        parcel.writeLong(this.f24066p);
        parcel.writeInt(this.f24073w);
        parcel.writeLong(this.f24074x);
        parcel.writeLong(this.f24075y);
    }
}
