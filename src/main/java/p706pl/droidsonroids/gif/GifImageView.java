package p706pl.droidsonroids.gif;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.widget.ImageView;

/* renamed from: pl.droidsonroids.gif.GifImageView */
public class GifImageView extends ImageView {
    /* renamed from: a */
    private boolean f29240a;

    public GifImageView(Context context) {
        super(context);
    }

    public GifImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m37369a(GifViewUtils.m37437a((ImageView) this, attributeSet, 0, 0));
    }

    public GifImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m37369a(GifViewUtils.m37437a((ImageView) this, attributeSet, i, 0));
    }

    /* renamed from: a */
    private void m37369a(C8596a aVar) {
        this.f29240a = aVar.f29286c;
        if (aVar.f29284a > 0) {
            super.setImageResource(aVar.f29284a);
        }
        if (aVar.f29285b > 0) {
            super.setBackgroundResource(aVar.f29285b);
        }
    }

    public void setImageURI(Uri uri) {
        if (!GifViewUtils.m37439a((ImageView) this, uri)) {
            super.setImageURI(uri);
        }
    }

    public void setImageResource(int i) {
        if (!GifViewUtils.m37440a((ImageView) this, true, i)) {
            super.setImageResource(i);
        }
    }

    public void setBackgroundResource(int i) {
        if (!GifViewUtils.m37440a((ImageView) this, false, i)) {
            super.setBackgroundResource(i);
        }
    }

    public Parcelable onSaveInstanceState() {
        Drawable drawable = null;
        Drawable drawable2 = this.f29240a ? getDrawable() : null;
        if (this.f29240a) {
            drawable = getBackground();
        }
        return new GifViewSavedState(super.onSaveInstanceState(), drawable2, drawable);
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof GifViewSavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        GifViewSavedState gifViewSavedState = (GifViewSavedState) parcelable;
        super.onRestoreInstanceState(gifViewSavedState.getSuperState());
        gifViewSavedState.mo41210a(getDrawable(), 0);
        gifViewSavedState.mo41210a(getBackground(), 1);
    }

    public void setFreezesAnimation(boolean z) {
        this.f29240a = z;
    }
}
