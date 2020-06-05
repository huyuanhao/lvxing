package com.yanzhenjie.album.api.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import androidx.core.content.ContextCompat;
import com.yanzhenjie.album.R;
import com.yanzhenjie.album.p629b.AlbumUtils;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class Widget implements Parcelable {
    public static final Creator<Widget> CREATOR = new Creator<Widget>() {
        /* renamed from: a */
        public Widget createFromParcel(Parcel parcel) {
            return new Widget(parcel);
        }

        /* renamed from: a */
        public Widget[] newArray(int i) {
            return new Widget[i];
        }
    };
    /* renamed from: a */
    private Context f26127a;
    /* renamed from: b */
    private int f26128b;
    /* renamed from: c */
    private int f26129c;
    /* renamed from: d */
    private int f26130d;
    /* renamed from: e */
    private int f26131e;
    /* renamed from: f */
    private String f26132f;
    /* renamed from: g */
    private ColorStateList f26133g;
    /* renamed from: h */
    private ColorStateList f26134h;
    /* renamed from: i */
    private ButtonStyle f26135i;

    /* renamed from: com.yanzhenjie.album.api.widget.Widget$ButtonStyle */
    public static class ButtonStyle implements Parcelable {
        public static final Creator<ButtonStyle> CREATOR = new Creator<ButtonStyle>() {
            /* renamed from: a */
            public ButtonStyle createFromParcel(Parcel parcel) {
                return new ButtonStyle(parcel);
            }

            /* renamed from: a */
            public ButtonStyle[] newArray(int i) {
                return new ButtonStyle[i];
            }
        };
        /* renamed from: a */
        private Context f26136a;
        /* renamed from: b */
        private int f26137b;
        /* renamed from: c */
        private ColorStateList f26138c;

        /* renamed from: com.yanzhenjie.album.api.widget.Widget$ButtonStyle$a */
        public static class C7729a {
            /* access modifiers changed from: private */
            /* renamed from: a */
            public Context f26139a;
            /* access modifiers changed from: private */
            /* renamed from: b */
            public int f26140b;
            /* access modifiers changed from: private */
            /* renamed from: c */
            public ColorStateList f26141c;

            private C7729a(Context context, int i) {
                this.f26139a = context;
                this.f26140b = i;
            }

            /* renamed from: a */
            public C7729a mo37567a(int i, int i2) {
                this.f26141c = AlbumUtils.m33536a(i, i2);
                return this;
            }

            /* renamed from: a */
            public ButtonStyle mo37568a() {
                return new ButtonStyle(this);
            }
        }

        public int describeContents() {
            return 0;
        }

        /* renamed from: a */
        public static C7729a m33316a(Context context) {
            return new C7729a(context, 2);
        }

        private ButtonStyle(C7729a aVar) {
            ColorStateList colorStateList;
            this.f26136a = aVar.f26139a;
            this.f26137b = aVar.f26140b;
            if (aVar.f26141c == null) {
                colorStateList = AlbumUtils.m33536a(ContextCompat.getColor(this.f26136a, R.color.albumColorPrimary), ContextCompat.getColor(this.f26136a, R.color.albumColorPrimaryDark));
            } else {
                colorStateList = aVar.f26141c;
            }
            this.f26138c = colorStateList;
        }

        /* renamed from: a */
        public int mo37559a() {
            return this.f26137b;
        }

        /* renamed from: b */
        public ColorStateList mo37560b() {
            return this.f26138c;
        }

        protected ButtonStyle(Parcel parcel) {
            this.f26137b = parcel.readInt();
            this.f26138c = (ColorStateList) parcel.readParcelable(ColorStateList.class.getClassLoader());
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.f26137b);
            parcel.writeParcelable(this.f26138c, i);
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    /* renamed from: com.yanzhenjie.album.api.widget.Widget$UiStyle */
    public @interface UiStyle {
    }

    /* renamed from: com.yanzhenjie.album.api.widget.Widget$a */
    public static class C7730a {
        /* access modifiers changed from: private */
        /* renamed from: a */
        public Context f26142a;
        /* access modifiers changed from: private */
        /* renamed from: b */
        public int f26143b;
        /* access modifiers changed from: private */
        /* renamed from: c */
        public int f26144c;
        /* access modifiers changed from: private */
        /* renamed from: d */
        public int f26145d;
        /* access modifiers changed from: private */
        /* renamed from: e */
        public int f26146e;
        /* access modifiers changed from: private */
        /* renamed from: f */
        public String f26147f;
        /* access modifiers changed from: private */
        /* renamed from: g */
        public ColorStateList f26148g;
        /* access modifiers changed from: private */
        /* renamed from: h */
        public ColorStateList f26149h;
        /* access modifiers changed from: private */
        /* renamed from: i */
        public ButtonStyle f26150i;

        private C7730a(Context context, int i) {
            this.f26142a = context;
            this.f26143b = i;
        }

        /* renamed from: a */
        public C7730a mo37569a(int i) {
            this.f26144c = i;
            return this;
        }

        /* renamed from: b */
        public C7730a mo37574b(int i) {
            this.f26145d = i;
            return this;
        }

        /* renamed from: c */
        public C7730a mo37576c(int i) {
            this.f26146e = i;
            return this;
        }

        /* renamed from: d */
        public C7730a mo37577d(int i) {
            return mo37572a(this.f26142a.getString(i));
        }

        /* renamed from: a */
        public C7730a mo37572a(String str) {
            this.f26147f = str;
            return this;
        }

        /* renamed from: a */
        public C7730a mo37570a(int i, int i2) {
            this.f26148g = AlbumUtils.m33536a(i, i2);
            return this;
        }

        /* renamed from: b */
        public C7730a mo37575b(int i, int i2) {
            this.f26149h = AlbumUtils.m33536a(i, i2);
            return this;
        }

        /* renamed from: a */
        public C7730a mo37571a(ButtonStyle buttonStyle) {
            this.f26150i = buttonStyle;
            return this;
        }

        /* renamed from: a */
        public Widget mo37573a() {
            return new Widget(this);
        }
    }

    public int describeContents() {
        return 0;
    }

    /* renamed from: a */
    public static C7730a m33304a(Context context) {
        return new C7730a(context, 2);
    }

    private Widget(C7730a aVar) {
        this.f26127a = aVar.f26142a;
        this.f26128b = aVar.f26143b;
        this.f26129c = aVar.f26144c == 0 ? m33303a(R.color.albumColorPrimaryDark) : aVar.f26144c;
        this.f26130d = aVar.f26145d == 0 ? m33303a(R.color.albumColorPrimary) : aVar.f26145d;
        this.f26131e = aVar.f26146e == 0 ? m33303a(R.color.albumColorPrimaryBlack) : aVar.f26146e;
        this.f26132f = TextUtils.isEmpty(aVar.f26147f) ? this.f26127a.getString(R.string.album_title) : aVar.f26147f;
        this.f26133g = aVar.f26148g == null ? AlbumUtils.m33536a(m33303a(R.color.albumSelectorNormal), m33303a(R.color.albumColorPrimary)) : aVar.f26148g;
        this.f26134h = aVar.f26149h == null ? AlbumUtils.m33536a(m33303a(R.color.albumSelectorNormal), m33303a(R.color.albumColorPrimary)) : aVar.f26149h;
        this.f26135i = aVar.f26150i == null ? ButtonStyle.m33316a(this.f26127a).mo37568a() : aVar.f26150i;
    }

    /* renamed from: a */
    public int mo37545a() {
        return this.f26128b;
    }

    /* renamed from: b */
    public int mo37546b() {
        return this.f26129c;
    }

    /* renamed from: c */
    public int mo37547c() {
        return this.f26130d;
    }

    /* renamed from: d */
    public int mo37548d() {
        return this.f26131e;
    }

    /* renamed from: e */
    public String mo37550e() {
        return this.f26132f;
    }

    /* renamed from: f */
    public ColorStateList mo37551f() {
        return this.f26133g;
    }

    /* renamed from: g */
    public ColorStateList mo37552g() {
        return this.f26134h;
    }

    /* renamed from: h */
    public ButtonStyle mo37553h() {
        return this.f26135i;
    }

    protected Widget(Parcel parcel) {
        this.f26128b = parcel.readInt();
        this.f26129c = parcel.readInt();
        this.f26130d = parcel.readInt();
        this.f26131e = parcel.readInt();
        this.f26132f = parcel.readString();
        this.f26133g = (ColorStateList) parcel.readParcelable(ColorStateList.class.getClassLoader());
        this.f26134h = (ColorStateList) parcel.readParcelable(ColorStateList.class.getClassLoader());
        this.f26135i = (ButtonStyle) parcel.readParcelable(ButtonStyle.class.getClassLoader());
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f26128b);
        parcel.writeInt(this.f26129c);
        parcel.writeInt(this.f26130d);
        parcel.writeInt(this.f26131e);
        parcel.writeString(this.f26132f);
        parcel.writeParcelable(this.f26133g, i);
        parcel.writeParcelable(this.f26134h, i);
        parcel.writeParcelable(this.f26135i, i);
    }

    /* renamed from: a */
    private int m33303a(int i) {
        return ContextCompat.getColor(this.f26127a, i);
    }

    /* renamed from: b */
    public static Widget m33305b(Context context) {
        return m33304a(context).mo37569a(ContextCompat.getColor(context, R.color.albumColorPrimaryDark)).mo37574b(ContextCompat.getColor(context, R.color.albumColorPrimary)).mo37576c(ContextCompat.getColor(context, R.color.albumColorPrimaryBlack)).mo37577d(R.string.album_title).mo37570a(ContextCompat.getColor(context, R.color.albumSelectorNormal), ContextCompat.getColor(context, R.color.albumColorPrimary)).mo37575b(ContextCompat.getColor(context, R.color.albumSelectorNormal), ContextCompat.getColor(context, R.color.albumColorPrimary)).mo37571a(ButtonStyle.m33316a(context).mo37567a(ContextCompat.getColor(context, R.color.albumColorPrimary), ContextCompat.getColor(context, R.color.albumColorPrimaryDark)).mo37568a()).mo37573a();
    }
}
