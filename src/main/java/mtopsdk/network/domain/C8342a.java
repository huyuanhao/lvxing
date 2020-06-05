package mtopsdk.network.domain;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: ParcelableRequestBodyImpl */
/* renamed from: mtopsdk.network.domain.a */
final class C8342a implements Creator<ParcelableRequestBodyImpl> {
    C8342a() {
    }

    /* renamed from: a */
    public final ParcelableRequestBodyImpl createFromParcel(Parcel parcel) {
        return new ParcelableRequestBodyImpl(parcel);
    }

    /* renamed from: a */
    public final ParcelableRequestBodyImpl[] newArray(int i) {
        return new ParcelableRequestBodyImpl[i];
    }
}
