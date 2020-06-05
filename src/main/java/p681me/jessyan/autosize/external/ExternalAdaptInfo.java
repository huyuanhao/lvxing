package p681me.jessyan.autosize.external;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

/* renamed from: me.jessyan.autosize.external.ExternalAdaptInfo */
public class ExternalAdaptInfo implements Parcelable {
    public static final Creator<ExternalAdaptInfo> CREATOR = new Creator<ExternalAdaptInfo>() {
        public ExternalAdaptInfo createFromParcel(Parcel parcel) {
            return new ExternalAdaptInfo(parcel);
        }

        public ExternalAdaptInfo[] newArray(int i) {
            return new ExternalAdaptInfo[i];
        }
    };
    private boolean isBaseOnWidth;
    private float sizeInDp;

    public int describeContents() {
        return 0;
    }

    public ExternalAdaptInfo(boolean z) {
        this.isBaseOnWidth = z;
    }

    public ExternalAdaptInfo(boolean z, float f) {
        this.isBaseOnWidth = z;
        this.sizeInDp = f;
    }

    public boolean isBaseOnWidth() {
        return this.isBaseOnWidth;
    }

    public void setBaseOnWidth(boolean z) {
        this.isBaseOnWidth = z;
    }

    public float getSizeInDp() {
        return this.sizeInDp;
    }

    public void setSizeInDp(float f) {
        this.sizeInDp = f;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeByte(this.isBaseOnWidth);
        parcel.writeFloat(this.sizeInDp);
    }

    protected ExternalAdaptInfo(Parcel parcel) {
        this.isBaseOnWidth = parcel.readByte() != 0;
        this.sizeInDp = parcel.readFloat();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ExternalAdaptInfo{isBaseOnWidth=");
        sb.append(this.isBaseOnWidth);
        sb.append(", sizeInDp=");
        sb.append(this.sizeInDp);
        sb.append('}');
        return sb.toString();
    }
}
