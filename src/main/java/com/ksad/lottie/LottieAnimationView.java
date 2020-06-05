package com.ksad.lottie;

import android.animation.Animator.AnimatorListener;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.JsonReader;
import android.util.Log;
import android.view.View.BaseSavedState;
import androidx.appcompat.widget.AppCompatImageView;
import java.io.StringReader;
import java.util.HashSet;
import java.util.Set;

public class LottieAnimationView extends AppCompatImageView {
    /* renamed from: a */
    private static final String f12386a = LottieAnimationView.class.getSimpleName();
    /* renamed from: b */
    private final C3732h<C3703d> f12387b = new C3732h<C3703d>() {
        /* renamed from: a */
        public void mo22802a(C3703d dVar) {
            LottieAnimationView.this.setComposition(dVar);
        }
    };
    /* renamed from: c */
    private final C3732h<Throwable> f12388c = new C3732h<Throwable>() {
        /* renamed from: a */
        public void mo22802a(Throwable th) {
            throw new IllegalStateException("Unable to parse composition", th);
        }
    };
    /* renamed from: d */
    private final C3721f f12389d = new C3721f();
    /* renamed from: e */
    private String f12390e;
    /* renamed from: f */
    private int f12391f;
    /* renamed from: g */
    private boolean f12392g = false;
    /* renamed from: h */
    private boolean f12393h = false;
    /* renamed from: i */
    private boolean f12394i = false;
    /* renamed from: j */
    private Set<C3733i> f12395j = new HashSet();
    /* renamed from: k */
    private C3735k<C3703d> f12396k;
    /* renamed from: l */
    private C3703d f12397l;

    /* renamed from: com.ksad.lottie.LottieAnimationView$a */
    private static class C3621a extends BaseSavedState {
        public static final Creator<C3621a> CREATOR = new Creator<C3621a>() {
            /* renamed from: a */
            public C3621a createFromParcel(Parcel parcel) {
                return new C3621a(parcel);
            }

            /* renamed from: a */
            public C3621a[] newArray(int i) {
                return new C3621a[i];
            }
        };
        /* renamed from: a */
        String f12400a;
        /* renamed from: b */
        int f12401b;
        /* renamed from: c */
        float f12402c;
        /* renamed from: d */
        boolean f12403d;
        /* renamed from: e */
        String f12404e;
        /* renamed from: f */
        int f12405f;
        /* renamed from: g */
        int f12406g;

        private C3621a(Parcel parcel) {
            super(parcel);
            this.f12400a = parcel.readString();
            this.f12402c = parcel.readFloat();
            boolean z = true;
            if (parcel.readInt() != 1) {
                z = false;
            }
            this.f12403d = z;
            this.f12404e = parcel.readString();
            this.f12405f = parcel.readInt();
            this.f12406g = parcel.readInt();
        }

        C3621a(Parcelable parcelable) {
            super(parcelable);
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeString(this.f12400a);
            parcel.writeFloat(this.f12402c);
            parcel.writeInt(this.f12403d);
            parcel.writeString(this.f12404e);
            parcel.writeInt(this.f12405f);
            parcel.writeInt(this.f12406g);
        }
    }

    public LottieAnimationView(Context context) {
        super(context);
        m15097a((AttributeSet) null);
    }

    public LottieAnimationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m15097a(attributeSet);
    }

    public LottieAnimationView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m15097a(attributeSet);
    }

    /* renamed from: a */
    private void m15096a(Drawable drawable, boolean z) {
        if (z && drawable != this.f12389d) {
            mo22754a();
        }
        m15098e();
        super.setImageDrawable(drawable);
    }

    /* renamed from: a */
    private void m15097a(AttributeSet attributeSet) {
        m15100g();
    }

    /* renamed from: e */
    private void m15098e() {
        C3735k<C3703d> kVar = this.f12396k;
        if (kVar != null) {
            kVar.mo23019b(this.f12387b);
            this.f12396k.mo23021d(this.f12388c);
        }
    }

    /* renamed from: f */
    private void m15099f() {
        this.f12397l = null;
        this.f12389d.mo22976e();
    }

    /* renamed from: g */
    private void m15100g() {
        int i = 1;
        boolean z = this.f12394i && this.f12389d.mo22994n();
        if (z) {
            i = 2;
        }
        setLayerType(i, null);
    }

    private void setCompositionTask(C3735k<C3703d> kVar) {
        m15099f();
        m15098e();
        this.f12396k = kVar.mo23018a(this.f12387b).mo23020c(this.f12388c);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo22754a() {
        this.f12389d.mo22969c();
    }

    /* renamed from: a */
    public void mo22755a(AnimatorListener animatorListener) {
        this.f12389d.mo22955a(animatorListener);
    }

    /* renamed from: a */
    public void mo22756a(JsonReader jsonReader, String str) {
        setCompositionTask(C3710e.m15401a(jsonReader, str));
    }

    /* renamed from: a */
    public void mo22757a(String str, String str2) {
        mo22756a(new JsonReader(new StringReader(str)), str2);
    }

    /* renamed from: a */
    public void mo22758a(boolean z) {
        this.f12389d.mo22960a(z);
    }

    /* renamed from: b */
    public void mo22759b() {
        this.f12389d.mo22979f();
        m15100g();
    }

    /* renamed from: b */
    public void mo22760b(AnimatorListener animatorListener) {
        this.f12389d.mo22967b(animatorListener);
    }

    /* renamed from: c */
    public boolean mo22761c() {
        return this.f12389d.mo22994n();
    }

    /* renamed from: d */
    public void mo22762d() {
        this.f12389d.mo22999s();
        m15100g();
    }

    public C3703d getComposition() {
        return this.f12397l;
    }

    public long getDuration() {
        C3703d dVar = this.f12397l;
        if (dVar != null) {
            return (long) dVar.mo22880c();
        }
        return 0;
    }

    public int getFrame() {
        return this.f12389d.mo22991k();
    }

    public String getImageAssetsFolder() {
        return this.f12389d.mo22964b();
    }

    public float getMaxFrame() {
        return this.f12389d.mo22986i();
    }

    public float getMinFrame() {
        return this.f12389d.mo22985h();
    }

    public C3738l getPerformanceTracker() {
        return this.f12389d.mo22972d();
    }

    public float getProgress() {
        return this.f12389d.mo23005t();
    }

    public int getRepeatCount() {
        return this.f12389d.mo22993m();
    }

    public int getRepeatMode() {
        return this.f12389d.mo22992l();
    }

    public float getScale() {
        return this.f12389d.mo22997q();
    }

    public float getSpeed() {
        return this.f12389d.mo22990j();
    }

    public boolean getUseHardwareAcceleration() {
        return this.f12394i;
    }

    public void invalidateDrawable(Drawable drawable) {
        Drawable drawable2 = getDrawable();
        C3721f fVar = this.f12389d;
        if (drawable2 == fVar) {
            super.invalidateDrawable(fVar);
        } else {
            super.invalidateDrawable(drawable);
        }
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f12393h && this.f12392g) {
            mo22759b();
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        if (mo22761c()) {
            mo22762d();
            this.f12392g = true;
        }
        mo22754a();
        super.onDetachedFromWindow();
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof C3621a)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        C3621a aVar = (C3621a) parcelable;
        super.onRestoreInstanceState(aVar.getSuperState());
        this.f12390e = aVar.f12400a;
        if (!TextUtils.isEmpty(this.f12390e)) {
            setAnimation(this.f12390e);
        }
        this.f12391f = aVar.f12401b;
        int i = this.f12391f;
        if (i != 0) {
            setAnimation(i);
        }
        setProgress(aVar.f12402c);
        if (aVar.f12403d) {
            mo22759b();
        }
        this.f12389d.mo22959a(aVar.f12404e);
        setRepeatMode(aVar.f12405f);
        setRepeatCount(aVar.f12406g);
    }

    /* access modifiers changed from: protected */
    public Parcelable onSaveInstanceState() {
        C3621a aVar = new C3621a(super.onSaveInstanceState());
        aVar.f12400a = this.f12390e;
        aVar.f12401b = this.f12391f;
        aVar.f12402c = this.f12389d.mo23005t();
        aVar.f12403d = this.f12389d.mo22994n();
        aVar.f12404e = this.f12389d.mo22964b();
        aVar.f12405f = this.f12389d.mo22992l();
        aVar.f12406g = this.f12389d.mo22993m();
        return aVar;
    }

    public void setAnimation(int i) {
        this.f12391f = i;
        this.f12390e = null;
        setCompositionTask(C3710e.m15399a(getContext(), i));
    }

    public void setAnimation(String str) {
        this.f12390e = str;
        this.f12391f = 0;
        setCompositionTask(C3710e.m15408b(getContext(), str));
    }

    @Deprecated
    public void setAnimationFromJson(String str) {
        mo22757a(str, (String) null);
    }

    public void setAnimationFromUrl(String str) {
        setCompositionTask(C3710e.m15400a(getContext(), str));
    }

    public void setComposition(C3703d dVar) {
        if (C3665c.f12569a) {
            String str = f12386a;
            StringBuilder sb = new StringBuilder();
            sb.append("Set Composition \n");
            sb.append(dVar);
            Log.v(str, sb.toString());
        }
        this.f12389d.setCallback(this);
        this.f12397l = dVar;
        boolean a = this.f12389d.mo22962a(dVar);
        m15100g();
        if (getDrawable() != this.f12389d || a) {
            setImageDrawable(null);
            setImageDrawable(this.f12389d);
            requestLayout();
            for (C3733i a2 : this.f12395j) {
                a2.mo23013a(dVar);
            }
        }
    }

    public void setFontAssetDelegate(C3623a aVar) {
        this.f12389d.mo22956a(aVar);
    }

    public void setFrame(int i) {
        this.f12389d.mo22971c(i);
    }

    public void setImageAssetDelegate(C3662b bVar) {
        this.f12389d.mo22957a(bVar);
    }

    public void setImageAssetsFolder(String str) {
        this.f12389d.mo22959a(str);
    }

    public void setImageBitmap(Bitmap bitmap) {
        mo22754a();
        m15098e();
        super.setImageBitmap(bitmap);
    }

    public void setImageDrawable(Drawable drawable) {
        m15096a(drawable, true);
    }

    public void setImageResource(int i) {
        mo22754a();
        m15098e();
        super.setImageResource(i);
    }

    public void setMaxFrame(int i) {
        this.f12389d.mo22966b(i);
    }

    public void setMaxProgress(float f) {
        this.f12389d.mo22965b(f);
    }

    public void setMinFrame(int i) {
        this.f12389d.mo22954a(i);
    }

    public void setMinProgress(float f) {
        this.f12389d.mo22953a(f);
    }

    public void setPerformanceTrackingEnabled(boolean z) {
        this.f12389d.mo22968b(z);
    }

    public void setProgress(float f) {
        this.f12389d.mo22973d(f);
    }

    public void setRepeatCount(int i) {
        this.f12389d.mo22978e(i);
    }

    public void setRepeatMode(int i) {
        this.f12389d.mo22974d(i);
    }

    public void setScale(float f) {
        this.f12389d.mo22977e(f);
        if (getDrawable() == this.f12389d) {
            m15096a((Drawable) null, false);
            m15096a((Drawable) this.f12389d, false);
        }
    }

    public void setSpeed(float f) {
        this.f12389d.mo22970c(f);
    }

    public void setTextDelegate(C3741m mVar) {
        this.f12389d.mo22958a(mVar);
    }
}
