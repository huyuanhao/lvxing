package p706pl.droidsonroids.gif;

import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.view.View.BaseSavedState;

/* renamed from: pl.droidsonroids.gif.GifViewSavedState */
class GifViewSavedState extends BaseSavedState {
    public static final Creator<GifViewSavedState> CREATOR = new Creator<GifViewSavedState>() {
        /* renamed from: a */
        public GifViewSavedState createFromParcel(Parcel parcel) {
            return new GifViewSavedState(parcel);
        }

        /* renamed from: a */
        public GifViewSavedState[] newArray(int i) {
            return new GifViewSavedState[i];
        }
    };
    /* renamed from: a */
    final long[][] f29258a;

    GifViewSavedState(Parcelable parcelable, Drawable... drawableArr) {
        super(parcelable);
        this.f29258a = new long[drawableArr.length][];
        for (int i = 0; i < drawableArr.length; i++) {
            GifDrawable cVar = drawableArr[i];
            if (cVar instanceof GifDrawable) {
                this.f29258a[i] = cVar.f29265f.mo41173o();
            } else {
                this.f29258a[i] = null;
            }
        }
    }

    private GifViewSavedState(Parcel parcel) {
        super(parcel);
        this.f29258a = new long[parcel.readInt()][];
        int i = 0;
        while (true) {
            long[][] jArr = this.f29258a;
            if (i < jArr.length) {
                jArr[i] = parcel.createLongArray();
                i++;
            } else {
                return;
            }
        }
    }

    GifViewSavedState(Parcelable parcelable, long[] jArr) {
        super(parcelable);
        this.f29258a = new long[1][];
        this.f29258a[0] = jArr;
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeInt(this.f29258a.length);
        for (long[] writeLongArray : this.f29258a) {
            parcel.writeLongArray(writeLongArray);
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo41210a(Drawable drawable, int i) {
        if (this.f29258a[i] != null && (drawable instanceof GifDrawable)) {
            GifDrawable cVar = (GifDrawable) drawable;
            cVar.mo41223a((long) cVar.f29265f.mo41152a(this.f29258a[i], cVar.f29264e));
        }
    }
}
