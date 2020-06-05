package mtopsdk.network.domain;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class ParcelableRequestBodyImpl extends C8343b implements Parcelable {
    public static final Creator<ParcelableRequestBodyImpl> CREATOR = new C8342a();
    /* renamed from: a */
    private String f28034a;
    /* renamed from: b */
    private byte[] f28035b;

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f28034a);
        parcel.writeByteArray(this.f28035b);
    }

    protected ParcelableRequestBodyImpl(Parcel parcel) {
        this.f28034a = parcel.readString();
        this.f28035b = parcel.createByteArray();
    }
}
