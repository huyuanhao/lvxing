package com.p522qq.p523e.ads.hybrid;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

/* renamed from: com.qq.e.ads.hybrid.HybridADSetting */
public class HybridADSetting implements Parcelable {
    public static final Creator<HybridADSetting> CREATOR = new Creator<HybridADSetting>() {
        public final HybridADSetting createFromParcel(Parcel parcel) {
            return new HybridADSetting(parcel);
        }

        public final HybridADSetting[] newArray(int i) {
            return new HybridADSetting[i];
        }
    };
    public static final int TYPE_REWARD_VIDEO = 1;
    /* renamed from: a */
    private int f20006a = 1;
    /* renamed from: b */
    private int f20007b = 44;
    /* renamed from: c */
    private int f20008c = -1;
    /* renamed from: d */
    private int f20009d = -14013133;
    /* renamed from: e */
    private int f20010e = 16;
    /* renamed from: f */
    private String f20011f;
    /* renamed from: g */
    private String f20012g;
    /* renamed from: h */
    private String f20013h;
    /* renamed from: i */
    private int f20014i = -1776153;
    /* renamed from: j */
    private int f20015j = 16;

    public HybridADSetting() {
    }

    protected HybridADSetting(Parcel parcel) {
        this.f20006a = parcel.readInt();
        this.f20007b = parcel.readInt();
        this.f20008c = parcel.readInt();
        this.f20009d = parcel.readInt();
        this.f20010e = parcel.readInt();
        this.f20011f = parcel.readString();
        this.f20012g = parcel.readString();
        this.f20013h = parcel.readString();
        this.f20014i = parcel.readInt();
        this.f20015j = parcel.readInt();
    }

    public HybridADSetting backButtonImage(String str) {
        this.f20012g = str;
        return this;
    }

    public HybridADSetting backSeparatorLength(int i) {
        this.f20015j = i;
        return this;
    }

    public HybridADSetting closeButtonImage(String str) {
        this.f20013h = str;
        return this;
    }

    public int describeContents() {
        return 0;
    }

    public String getBackButtonImage() {
        return this.f20012g;
    }

    public int getBackSeparatorLength() {
        return this.f20015j;
    }

    public String getCloseButtonImage() {
        return this.f20013h;
    }

    public int getSeparatorColor() {
        return this.f20014i;
    }

    public String getTitle() {
        return this.f20011f;
    }

    public int getTitleBarColor() {
        return this.f20008c;
    }

    public int getTitleBarHeight() {
        return this.f20007b;
    }

    public int getTitleColor() {
        return this.f20009d;
    }

    public int getTitleSize() {
        return this.f20010e;
    }

    public int getType() {
        return this.f20006a;
    }

    public HybridADSetting separatorColor(int i) {
        this.f20014i = i;
        return this;
    }

    public HybridADSetting title(String str) {
        this.f20011f = str;
        return this;
    }

    public HybridADSetting titleBarColor(int i) {
        this.f20008c = i;
        return this;
    }

    public HybridADSetting titleBarHeight(int i) {
        this.f20007b = i;
        return this;
    }

    public HybridADSetting titleColor(int i) {
        this.f20009d = i;
        return this;
    }

    public HybridADSetting titleSize(int i) {
        this.f20010e = i;
        return this;
    }

    public HybridADSetting type(int i) {
        this.f20006a = i;
        return this;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f20006a);
        parcel.writeInt(this.f20007b);
        parcel.writeInt(this.f20008c);
        parcel.writeInt(this.f20009d);
        parcel.writeInt(this.f20010e);
        parcel.writeString(this.f20011f);
        parcel.writeString(this.f20012g);
        parcel.writeString(this.f20013h);
        parcel.writeInt(this.f20014i);
        parcel.writeInt(this.f20015j);
    }
}
