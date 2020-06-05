package p681me.jessyan.autosize;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

/* renamed from: me.jessyan.autosize.DisplayMetricsInfo */
public class DisplayMetricsInfo implements Parcelable {
    public static final Creator<DisplayMetricsInfo> CREATOR = new Creator<DisplayMetricsInfo>() {
        public DisplayMetricsInfo createFromParcel(Parcel parcel) {
            return new DisplayMetricsInfo(parcel);
        }

        public DisplayMetricsInfo[] newArray(int i) {
            return new DisplayMetricsInfo[i];
        }
    };
    private float density;
    private int densityDpi;
    private float scaledDensity;
    private int screenHeightDp;
    private int screenWidthDp;
    private float xdpi;

    public int describeContents() {
        return 0;
    }

    public DisplayMetricsInfo(float f, int i, float f2, float f3) {
        this.density = f;
        this.densityDpi = i;
        this.scaledDensity = f2;
        this.xdpi = f3;
    }

    public DisplayMetricsInfo(float f, int i, float f2, float f3, int i2, int i3) {
        this.density = f;
        this.densityDpi = i;
        this.scaledDensity = f2;
        this.xdpi = f3;
        this.screenWidthDp = i2;
        this.screenHeightDp = i3;
    }

    public float getDensity() {
        return this.density;
    }

    public void setDensity(float f) {
        this.density = f;
    }

    public int getDensityDpi() {
        return this.densityDpi;
    }

    public void setDensityDpi(int i) {
        this.densityDpi = i;
    }

    public float getScaledDensity() {
        return this.scaledDensity;
    }

    public void setScaledDensity(float f) {
        this.scaledDensity = f;
    }

    public float getXdpi() {
        return this.xdpi;
    }

    public void setXdpi(float f) {
        this.xdpi = f;
    }

    public int getScreenWidthDp() {
        return this.screenWidthDp;
    }

    public void setScreenWidthDp(int i) {
        this.screenWidthDp = i;
    }

    public int getScreenHeightDp() {
        return this.screenHeightDp;
    }

    public void setScreenHeightDp(int i) {
        this.screenHeightDp = i;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeFloat(this.density);
        parcel.writeInt(this.densityDpi);
        parcel.writeFloat(this.scaledDensity);
        parcel.writeFloat(this.xdpi);
        parcel.writeInt(this.screenWidthDp);
        parcel.writeInt(this.screenHeightDp);
    }

    protected DisplayMetricsInfo(Parcel parcel) {
        this.density = parcel.readFloat();
        this.densityDpi = parcel.readInt();
        this.scaledDensity = parcel.readFloat();
        this.xdpi = parcel.readFloat();
        this.screenWidthDp = parcel.readInt();
        this.screenHeightDp = parcel.readInt();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("DisplayMetricsInfo{density=");
        sb.append(this.density);
        sb.append(", densityDpi=");
        sb.append(this.densityDpi);
        sb.append(", scaledDensity=");
        sb.append(this.scaledDensity);
        sb.append(", xdpi=");
        sb.append(this.xdpi);
        sb.append(", screenWidthDp=");
        sb.append(this.screenWidthDp);
        sb.append(", screenHeightDp=");
        sb.append(this.screenHeightDp);
        sb.append('}');
        return sb.toString();
    }
}
