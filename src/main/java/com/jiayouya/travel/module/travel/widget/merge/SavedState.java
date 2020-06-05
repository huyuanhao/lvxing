package com.jiayouya.travel.module.travel.widget.merge;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.view.View.BaseSavedState;

public class SavedState extends BaseSavedState {
    public static final Creator<SavedState> CREATOR = new Creator<SavedState>() {
        /* renamed from: a */
        public SavedState createFromParcel(Parcel parcel) {
            return new SavedState(parcel);
        }

        /* renamed from: a */
        public SavedState[] newArray(int i) {
            return new SavedState[i];
        }
    };
    /* renamed from: a */
    int f12318a;

    public SavedState(Parcel parcel) {
        super(parcel);
        this.f12318a = parcel.readInt();
    }

    public SavedState(Parcelable parcelable) {
        super(parcelable);
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeInt(this.f12318a);
    }
}
