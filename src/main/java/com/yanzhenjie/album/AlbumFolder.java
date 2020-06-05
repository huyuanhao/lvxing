package com.yanzhenjie.album;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.ArrayList;

public class AlbumFolder implements Parcelable {
    public static final Creator<AlbumFolder> CREATOR = new Creator<AlbumFolder>() {
        /* renamed from: a */
        public AlbumFolder createFromParcel(Parcel parcel) {
            return new AlbumFolder(parcel);
        }

        /* renamed from: a */
        public AlbumFolder[] newArray(int i) {
            return new AlbumFolder[i];
        }
    };
    /* renamed from: a */
    private String f26093a;
    /* renamed from: b */
    private ArrayList<AlbumFile> f26094b = new ArrayList<>();
    /* renamed from: c */
    private boolean f26095c;

    public int describeContents() {
        return 0;
    }

    public AlbumFolder() {
    }

    /* renamed from: a */
    public String mo37512a() {
        return this.f26093a;
    }

    /* renamed from: a */
    public void mo37514a(String str) {
        this.f26093a = str;
    }

    /* renamed from: b */
    public ArrayList<AlbumFile> mo37516b() {
        return this.f26094b;
    }

    /* renamed from: a */
    public void mo37513a(AlbumFile albumFile) {
        this.f26094b.add(albumFile);
    }

    /* renamed from: c */
    public boolean mo37517c() {
        return this.f26095c;
    }

    /* renamed from: a */
    public void mo37515a(boolean z) {
        this.f26095c = z;
    }

    protected AlbumFolder(Parcel parcel) {
        this.f26093a = parcel.readString();
        this.f26094b = parcel.createTypedArrayList(AlbumFile.CREATOR);
        this.f26095c = parcel.readByte() != 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f26093a);
        parcel.writeTypedList(this.f26094b);
        parcel.writeByte(this.f26095c ? (byte) 1 : 0);
    }
}
