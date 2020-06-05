package com.tencent.bugly.crashreport.crash;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.bugly.crashreport.common.info.PlugInBean;
import com.tencent.bugly.proguard.C7232aq;
import java.util.Map;
import java.util.UUID;

/* compiled from: BUGLY */
public class CrashDetailBean implements Parcelable, Comparable<CrashDetailBean> {
    public static final Creator<CrashDetailBean> CREATOR = new Creator<CrashDetailBean>() {
        /* renamed from: a */
        public CrashDetailBean createFromParcel(Parcel parcel) {
            return new CrashDetailBean(parcel);
        }

        /* renamed from: a */
        public CrashDetailBean[] newArray(int i) {
            return new CrashDetailBean[i];
        }
    };
    /* renamed from: A */
    public String f24093A;
    /* renamed from: B */
    public String f24094B;
    /* renamed from: C */
    public long f24095C;
    /* renamed from: D */
    public long f24096D;
    /* renamed from: E */
    public long f24097E;
    /* renamed from: F */
    public long f24098F;
    /* renamed from: G */
    public long f24099G;
    /* renamed from: H */
    public long f24100H;
    /* renamed from: I */
    public String f24101I;
    /* renamed from: J */
    public String f24102J;
    /* renamed from: K */
    public String f24103K;
    /* renamed from: L */
    public String f24104L;
    /* renamed from: M */
    public String f24105M;
    /* renamed from: N */
    public long f24106N;
    /* renamed from: O */
    public boolean f24107O;
    /* renamed from: P */
    public Map<String, String> f24108P;
    /* renamed from: Q */
    public int f24109Q;
    /* renamed from: R */
    public int f24110R;
    /* renamed from: S */
    public Map<String, String> f24111S;
    /* renamed from: T */
    public Map<String, String> f24112T;
    /* renamed from: U */
    public byte[] f24113U;
    /* renamed from: V */
    public String f24114V;
    /* renamed from: W */
    public String f24115W;
    /* renamed from: a */
    public long f24116a = -1;
    /* renamed from: b */
    public int f24117b = 0;
    /* renamed from: c */
    public String f24118c = UUID.randomUUID().toString();
    /* renamed from: d */
    public boolean f24119d = false;
    /* renamed from: e */
    public String f24120e;
    /* renamed from: f */
    public String f24121f;
    /* renamed from: g */
    public String f24122g;
    /* renamed from: h */
    public Map<String, PlugInBean> f24123h;
    /* renamed from: i */
    public Map<String, PlugInBean> f24124i;
    /* renamed from: j */
    public boolean f24125j;
    /* renamed from: k */
    public boolean f24126k;
    /* renamed from: l */
    public int f24127l;
    /* renamed from: m */
    public String f24128m;
    /* renamed from: n */
    public String f24129n;
    /* renamed from: o */
    public String f24130o;
    /* renamed from: p */
    public String f24131p;
    /* renamed from: q */
    public String f24132q;
    /* renamed from: r */
    public long f24133r;
    /* renamed from: s */
    public String f24134s;
    /* renamed from: t */
    public int f24135t;
    /* renamed from: u */
    public String f24136u;
    /* renamed from: v */
    public String f24137v;
    /* renamed from: w */
    public String f24138w;
    /* renamed from: x */
    public String f24139x;
    /* renamed from: y */
    public byte[] f24140y;
    /* renamed from: z */
    public Map<String, String> f24141z;

    public int describeContents() {
        return 0;
    }

    public CrashDetailBean() {
        String str = "";
        this.f24120e = str;
        this.f24121f = str;
        this.f24122g = str;
        this.f24123h = null;
        this.f24124i = null;
        this.f24125j = false;
        this.f24126k = false;
        this.f24127l = 0;
        this.f24128m = str;
        this.f24129n = str;
        this.f24130o = str;
        this.f24131p = str;
        this.f24132q = str;
        this.f24133r = -1;
        this.f24134s = null;
        this.f24135t = 0;
        this.f24136u = str;
        this.f24137v = str;
        this.f24138w = null;
        this.f24139x = null;
        this.f24140y = null;
        this.f24141z = null;
        this.f24093A = str;
        this.f24094B = str;
        this.f24095C = -1;
        this.f24096D = -1;
        this.f24097E = -1;
        this.f24098F = -1;
        this.f24099G = -1;
        this.f24100H = -1;
        this.f24101I = str;
        this.f24102J = str;
        this.f24103K = str;
        this.f24104L = str;
        this.f24105M = str;
        this.f24106N = -1;
        this.f24107O = false;
        this.f24108P = null;
        this.f24109Q = -1;
        this.f24110R = -1;
        this.f24111S = null;
        this.f24112T = null;
        this.f24113U = null;
        this.f24114V = null;
        this.f24115W = null;
    }

    public CrashDetailBean(Parcel parcel) {
        String str = "";
        this.f24120e = str;
        this.f24121f = str;
        this.f24122g = str;
        this.f24123h = null;
        this.f24124i = null;
        this.f24125j = false;
        this.f24126k = false;
        this.f24127l = 0;
        this.f24128m = str;
        this.f24129n = str;
        this.f24130o = str;
        this.f24131p = str;
        this.f24132q = str;
        this.f24133r = -1;
        this.f24134s = null;
        this.f24135t = 0;
        this.f24136u = str;
        this.f24137v = str;
        this.f24138w = null;
        this.f24139x = null;
        this.f24140y = null;
        this.f24141z = null;
        this.f24093A = str;
        this.f24094B = str;
        this.f24095C = -1;
        this.f24096D = -1;
        this.f24097E = -1;
        this.f24098F = -1;
        this.f24099G = -1;
        this.f24100H = -1;
        this.f24101I = str;
        this.f24102J = str;
        this.f24103K = str;
        this.f24104L = str;
        this.f24105M = str;
        this.f24106N = -1;
        this.f24107O = false;
        this.f24108P = null;
        this.f24109Q = -1;
        this.f24110R = -1;
        this.f24111S = null;
        this.f24112T = null;
        this.f24113U = null;
        this.f24114V = null;
        this.f24115W = null;
        this.f24117b = parcel.readInt();
        this.f24118c = parcel.readString();
        boolean z = true;
        this.f24119d = parcel.readByte() == 1;
        this.f24120e = parcel.readString();
        this.f24121f = parcel.readString();
        this.f24122g = parcel.readString();
        this.f24125j = parcel.readByte() == 1;
        this.f24126k = parcel.readByte() == 1;
        this.f24127l = parcel.readInt();
        this.f24128m = parcel.readString();
        this.f24129n = parcel.readString();
        this.f24130o = parcel.readString();
        this.f24131p = parcel.readString();
        this.f24132q = parcel.readString();
        this.f24133r = parcel.readLong();
        this.f24134s = parcel.readString();
        this.f24135t = parcel.readInt();
        this.f24136u = parcel.readString();
        this.f24137v = parcel.readString();
        this.f24138w = parcel.readString();
        this.f24141z = C7232aq.m31208b(parcel);
        this.f24093A = parcel.readString();
        this.f24094B = parcel.readString();
        this.f24095C = parcel.readLong();
        this.f24096D = parcel.readLong();
        this.f24097E = parcel.readLong();
        this.f24098F = parcel.readLong();
        this.f24099G = parcel.readLong();
        this.f24100H = parcel.readLong();
        this.f24101I = parcel.readString();
        this.f24102J = parcel.readString();
        this.f24103K = parcel.readString();
        this.f24104L = parcel.readString();
        this.f24105M = parcel.readString();
        this.f24106N = parcel.readLong();
        if (parcel.readByte() != 1) {
            z = false;
        }
        this.f24107O = z;
        this.f24108P = C7232aq.m31208b(parcel);
        this.f24123h = C7232aq.m31189a(parcel);
        this.f24124i = C7232aq.m31189a(parcel);
        this.f24109Q = parcel.readInt();
        this.f24110R = parcel.readInt();
        this.f24111S = C7232aq.m31208b(parcel);
        this.f24112T = C7232aq.m31208b(parcel);
        this.f24113U = parcel.createByteArray();
        this.f24140y = parcel.createByteArray();
        this.f24114V = parcel.readString();
        this.f24115W = parcel.readString();
        this.f24139x = parcel.readString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f24117b);
        parcel.writeString(this.f24118c);
        parcel.writeByte(this.f24119d ? (byte) 1 : 0);
        parcel.writeString(this.f24120e);
        parcel.writeString(this.f24121f);
        parcel.writeString(this.f24122g);
        parcel.writeByte(this.f24125j ? (byte) 1 : 0);
        parcel.writeByte(this.f24126k ? (byte) 1 : 0);
        parcel.writeInt(this.f24127l);
        parcel.writeString(this.f24128m);
        parcel.writeString(this.f24129n);
        parcel.writeString(this.f24130o);
        parcel.writeString(this.f24131p);
        parcel.writeString(this.f24132q);
        parcel.writeLong(this.f24133r);
        parcel.writeString(this.f24134s);
        parcel.writeInt(this.f24135t);
        parcel.writeString(this.f24136u);
        parcel.writeString(this.f24137v);
        parcel.writeString(this.f24138w);
        C7232aq.m31210b(parcel, this.f24141z);
        parcel.writeString(this.f24093A);
        parcel.writeString(this.f24094B);
        parcel.writeLong(this.f24095C);
        parcel.writeLong(this.f24096D);
        parcel.writeLong(this.f24097E);
        parcel.writeLong(this.f24098F);
        parcel.writeLong(this.f24099G);
        parcel.writeLong(this.f24100H);
        parcel.writeString(this.f24101I);
        parcel.writeString(this.f24102J);
        parcel.writeString(this.f24103K);
        parcel.writeString(this.f24104L);
        parcel.writeString(this.f24105M);
        parcel.writeLong(this.f24106N);
        parcel.writeByte(this.f24107O ? (byte) 1 : 0);
        C7232aq.m31210b(parcel, this.f24108P);
        C7232aq.m31191a(parcel, this.f24123h);
        C7232aq.m31191a(parcel, this.f24124i);
        parcel.writeInt(this.f24109Q);
        parcel.writeInt(this.f24110R);
        C7232aq.m31210b(parcel, this.f24111S);
        C7232aq.m31210b(parcel, this.f24112T);
        parcel.writeByteArray(this.f24113U);
        parcel.writeByteArray(this.f24140y);
        parcel.writeString(this.f24114V);
        parcel.writeString(this.f24115W);
        parcel.writeString(this.f24139x);
    }

    /* renamed from: a */
    public int compareTo(CrashDetailBean crashDetailBean) {
        if (crashDetailBean == null) {
            return 1;
        }
        int i = ((this.f24133r - crashDetailBean.f24133r) > 0 ? 1 : ((this.f24133r - crashDetailBean.f24133r) == 0 ? 0 : -1));
        if (i > 0) {
            return 1;
        }
        return i < 0 ? -1 : 0;
    }
}
