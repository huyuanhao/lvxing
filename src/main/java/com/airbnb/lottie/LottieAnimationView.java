package com.airbnb.lottie;

import android.animation.Animator.AnimatorListener;
import android.content.Context;
import android.content.res.TypedArray;
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
import com.airbnb.lottie.model.KeyPath;
import com.airbnb.lottie.model.LottieCompositionCache;
import com.airbnb.lottie.p014e.LottieValueCallback;
import java.io.StringReader;
import org.json.JSONObject;

public class LottieAnimationView extends AppCompatImageView {
    /* renamed from: a */
    public static final CacheStrategy f1213a = CacheStrategy.Weak;
    /* renamed from: b */
    private static final String f1214b = LottieAnimationView.class.getSimpleName();
    /* renamed from: c */
    private final LottieListener<LottieComposition> f1215c = new LottieListener<LottieComposition>() {
        /* renamed from: a */
        public void mo9777a(LottieComposition dVar) {
            LottieAnimationView.this.setComposition(dVar);
        }
    };
    /* renamed from: d */
    private final LottieListener<Throwable> f1216d = new LottieListener<Throwable>() {
        /* renamed from: a */
        public void mo9777a(Throwable th) {
            throw new IllegalStateException("Unable to parse composition", th);
        }
    };
    /* renamed from: e */
    private final LottieDrawable f1217e = new LottieDrawable();
    /* renamed from: f */
    private CacheStrategy f1218f;
    /* renamed from: g */
    private String f1219g;
    /* renamed from: h */
    private int f1220h;
    /* renamed from: i */
    private boolean f1221i = false;
    /* renamed from: j */
    private boolean f1222j = false;
    /* renamed from: k */
    private boolean f1223k = false;
    /* renamed from: l */
    private LottieTask f1224l;
    /* renamed from: m */
    private LottieComposition f1225m;

    @Deprecated
    /* renamed from: com.airbnb.lottie.LottieAnimationView$CacheStrategy */
    public enum CacheStrategy {
        None,
        Weak,
        Strong
    }

    /* renamed from: com.airbnb.lottie.LottieAnimationView$SavedState */
    private static class SavedState extends BaseSavedState {
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
        String f1232a;
        /* renamed from: b */
        int f1233b;
        /* renamed from: c */
        float f1234c;
        /* renamed from: d */
        boolean f1235d;
        /* renamed from: e */
        String f1236e;
        /* renamed from: f */
        int f1237f;
        /* renamed from: g */
        int f1238g;

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.f1232a = parcel.readString();
            this.f1234c = parcel.readFloat();
            boolean z = true;
            if (parcel.readInt() != 1) {
                z = false;
            }
            this.f1235d = z;
            this.f1236e = parcel.readString();
            this.f1237f = parcel.readInt();
            this.f1238g = parcel.readInt();
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeString(this.f1232a);
            parcel.writeFloat(this.f1234c);
            parcel.writeInt(this.f1235d);
            parcel.writeString(this.f1236e);
            parcel.writeInt(this.f1237f);
            parcel.writeInt(this.f1238g);
        }
    }

    public LottieAnimationView(Context context) {
        super(context);
        m1060a((AttributeSet) null);
    }

    public LottieAnimationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m1060a(attributeSet);
    }

    public LottieAnimationView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m1060a(attributeSet);
    }

    /* renamed from: a */
    private void m1060a(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.LottieAnimationView);
        this.f1218f = CacheStrategy.values()[obtainStyledAttributes.getInt(R.styleable.LottieAnimationView_lottie_cacheStrategy, f1213a.ordinal())];
        if (!isInEditMode()) {
            boolean hasValue = obtainStyledAttributes.hasValue(R.styleable.LottieAnimationView_lottie_rawRes);
            boolean hasValue2 = obtainStyledAttributes.hasValue(R.styleable.LottieAnimationView_lottie_fileName);
            boolean hasValue3 = obtainStyledAttributes.hasValue(R.styleable.LottieAnimationView_lottie_url);
            if (hasValue && hasValue2) {
                throw new IllegalArgumentException("lottie_rawRes and lottie_fileName cannot be used at the same time. Please use use only one at once.");
            } else if (hasValue) {
                int resourceId = obtainStyledAttributes.getResourceId(R.styleable.LottieAnimationView_lottie_rawRes, 0);
                if (resourceId != 0) {
                    setAnimation(resourceId);
                }
            } else if (hasValue2) {
                String string = obtainStyledAttributes.getString(R.styleable.LottieAnimationView_lottie_fileName);
                if (string != null) {
                    setAnimation(string);
                }
            } else if (hasValue3) {
                String string2 = obtainStyledAttributes.getString(R.styleable.LottieAnimationView_lottie_url);
                if (string2 != null) {
                    setAnimationFromUrl(string2);
                }
            }
        }
        if (obtainStyledAttributes.getBoolean(R.styleable.LottieAnimationView_lottie_autoPlay, false)) {
            this.f1221i = true;
            this.f1222j = true;
        }
        if (obtainStyledAttributes.getBoolean(R.styleable.LottieAnimationView_lottie_loop, false)) {
            this.f1217e.mo9813e(-1);
        }
        if (obtainStyledAttributes.hasValue(R.styleable.LottieAnimationView_lottie_repeatMode)) {
            setRepeatMode(obtainStyledAttributes.getInt(R.styleable.LottieAnimationView_lottie_repeatMode, 1));
        }
        if (obtainStyledAttributes.hasValue(R.styleable.LottieAnimationView_lottie_repeatCount)) {
            setRepeatCount(obtainStyledAttributes.getInt(R.styleable.LottieAnimationView_lottie_repeatCount, -1));
        }
        setImageAssetsFolder(obtainStyledAttributes.getString(R.styleable.LottieAnimationView_lottie_imageAssetsFolder));
        setProgress(obtainStyledAttributes.getFloat(R.styleable.LottieAnimationView_lottie_progress, 0.0f));
        mo9731a(obtainStyledAttributes.getBoolean(R.styleable.LottieAnimationView_lottie_enableMergePathsForKitKatAndAbove, false));
        if (obtainStyledAttributes.hasValue(R.styleable.LottieAnimationView_lottie_colorFilter)) {
            SimpleColorFilter lVar = new SimpleColorFilter(obtainStyledAttributes.getColor(R.styleable.LottieAnimationView_lottie_colorFilter, 0));
            mo9729a(new KeyPath("**"), LottieProperty.f1547x, new LottieValueCallback(lVar));
        }
        if (obtainStyledAttributes.hasValue(R.styleable.LottieAnimationView_lottie_scale)) {
            this.f1217e.mo9812e(obtainStyledAttributes.getFloat(R.styleable.LottieAnimationView_lottie_scale, 1.0f));
        }
        obtainStyledAttributes.recycle();
        m1063g();
    }

    public void setImageResource(int i) {
        mo9726a();
        m1061e();
        super.setImageResource(i);
    }

    public void setImageDrawable(Drawable drawable) {
        m1059a(drawable, true);
    }

    /* renamed from: a */
    private void m1059a(Drawable drawable, boolean z) {
        if (z && drawable != this.f1217e) {
            mo9726a();
        }
        m1061e();
        super.setImageDrawable(drawable);
    }

    public void setImageBitmap(Bitmap bitmap) {
        mo9726a();
        m1061e();
        super.setImageBitmap(bitmap);
    }

    public void invalidateDrawable(Drawable drawable) {
        Drawable drawable2 = getDrawable();
        LottieDrawable lottieDrawable = this.f1217e;
        if (drawable2 == lottieDrawable) {
            super.invalidateDrawable(lottieDrawable);
        } else {
            super.invalidateDrawable(drawable);
        }
    }

    /* access modifiers changed from: protected */
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f1232a = this.f1219g;
        savedState.f1233b = this.f1220h;
        savedState.f1234c = this.f1217e.mo9840t();
        savedState.f1235d = this.f1217e.mo9829n();
        savedState.f1236e = this.f1217e.mo9800b();
        savedState.f1237f = this.f1217e.mo9827l();
        savedState.f1238g = this.f1217e.mo9828m();
        return savedState;
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.f1219g = savedState.f1232a;
        if (!TextUtils.isEmpty(this.f1219g)) {
            setAnimation(this.f1219g);
        }
        this.f1220h = savedState.f1233b;
        int i = this.f1220h;
        if (i != 0) {
            setAnimation(i);
        }
        setProgress(savedState.f1234c);
        if (savedState.f1235d) {
            mo9732b();
        }
        this.f1217e.mo9795a(savedState.f1236e);
        setRepeatMode(savedState.f1237f);
        setRepeatCount(savedState.f1238g);
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f1222j && this.f1221i) {
            mo9732b();
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        if (mo9734c()) {
            mo9735d();
            this.f1221i = true;
        }
        mo9726a();
        super.onDetachedFromWindow();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo9726a() {
        LottieDrawable lottieDrawable = this.f1217e;
        if (lottieDrawable != null) {
            lottieDrawable.mo9804c();
        }
    }

    /* renamed from: a */
    public void mo9731a(boolean z) {
        this.f1217e.mo9796a(z);
    }

    /* renamed from: b */
    public void mo9733b(boolean z) {
        if (this.f1223k != z) {
            this.f1223k = z;
            m1063g();
        }
    }

    public boolean getUseHardwareAcceleration() {
        return this.f1223k;
    }

    public void setAnimation(final int i) {
        this.f1220h = i;
        this.f1219g = null;
        LottieComposition a = LottieCompositionCache.m1654a().mo10128a(i);
        if (a != null) {
            setComposition(a);
            return;
        }
        m1062f();
        m1061e();
        this.f1224l = LottieCompositionFactory.m1463a(getContext(), i).mo9999a((LottieListener<T>) new LottieListener<LottieComposition>() {
            /* renamed from: a */
            public void mo9777a(LottieComposition dVar) {
                LottieCompositionCache.m1654a().mo10130a(i, dVar);
            }
        }).mo9999a(this.f1215c).mo10001c(this.f1216d);
    }

    public void setAnimation(final String str) {
        this.f1219g = str;
        this.f1220h = 0;
        LottieComposition a = LottieCompositionCache.m1654a().mo10129a(str);
        if (a != null) {
            setComposition(a);
            return;
        }
        m1062f();
        m1061e();
        this.f1224l = LottieCompositionFactory.m1472b(getContext(), str).mo9999a((LottieListener<T>) new LottieListener<LottieComposition>() {
            /* renamed from: a */
            public void mo9777a(LottieComposition dVar) {
                LottieCompositionCache.m1654a().mo10131a(str, dVar);
            }
        }).mo9999a(this.f1215c).mo10001c(this.f1216d);
    }

    @Deprecated
    public void setAnimation(JSONObject jSONObject) {
        setAnimation(new JsonReader(new StringReader(jSONObject.toString())));
    }

    @Deprecated
    public void setAnimationFromJson(String str) {
        mo9730a(str, (String) null);
    }

    /* renamed from: a */
    public void mo9730a(String str, String str2) {
        mo9728a(new JsonReader(new StringReader(str)), str2);
    }

    @Deprecated
    public void setAnimation(JsonReader jsonReader) {
        mo9728a(jsonReader, (String) null);
    }

    /* renamed from: a */
    public void mo9728a(JsonReader jsonReader, String str) {
        m1062f();
        m1061e();
        this.f1224l = LottieCompositionFactory.m1465a(jsonReader, str).mo9999a(this.f1215c).mo10001c(this.f1216d);
    }

    public void setAnimationFromUrl(String str) {
        m1062f();
        m1061e();
        this.f1224l = LottieCompositionFactory.m1464a(getContext(), str).mo9999a(this.f1215c).mo10001c(this.f1216d);
    }

    /* renamed from: e */
    private void m1061e() {
        LottieTask jVar = this.f1224l;
        if (jVar != null) {
            jVar.mo10000b(this.f1215c);
            this.f1224l.mo10002d(this.f1216d);
        }
    }

    public void setComposition(LottieComposition dVar) {
        if (L.f1437a) {
            String str = f1214b;
            StringBuilder sb = new StringBuilder();
            sb.append("Set Composition \n");
            sb.append(dVar);
            Log.v(str, sb.toString());
        }
        this.f1217e.setCallback(this);
        this.f1225m = dVar;
        boolean a = this.f1217e.mo9798a(dVar);
        m1063g();
        if (getDrawable() != this.f1217e || a) {
            setImageDrawable(null);
            setImageDrawable(this.f1217e);
            requestLayout();
        }
    }

    public LottieComposition getComposition() {
        return this.f1225m;
    }

    /* renamed from: b */
    public void mo9732b() {
        this.f1217e.mo9814f();
        m1063g();
    }

    public void setMinFrame(int i) {
        this.f1217e.mo9789a(i);
    }

    public float getMinFrame() {
        return this.f1217e.mo9820h();
    }

    public void setMinProgress(float f) {
        this.f1217e.mo9788a(f);
    }

    public void setMaxFrame(int i) {
        this.f1217e.mo9802b(i);
    }

    public float getMaxFrame() {
        return this.f1217e.mo9821i();
    }

    public void setMaxProgress(float f) {
        this.f1217e.mo9801b(f);
    }

    public void setSpeed(float f) {
        this.f1217e.mo9805c(f);
    }

    public float getSpeed() {
        return this.f1217e.mo9825j();
    }

    /* renamed from: a */
    public void mo9727a(AnimatorListener animatorListener) {
        this.f1217e.mo9790a(animatorListener);
    }

    public void setRepeatMode(int i) {
        this.f1217e.mo9809d(i);
    }

    public int getRepeatMode() {
        return this.f1217e.mo9827l();
    }

    public void setRepeatCount(int i) {
        this.f1217e.mo9813e(i);
    }

    public int getRepeatCount() {
        return this.f1217e.mo9828m();
    }

    /* renamed from: c */
    public boolean mo9734c() {
        return this.f1217e.mo9829n();
    }

    public void setImageAssetsFolder(String str) {
        this.f1217e.mo9795a(str);
    }

    public String getImageAssetsFolder() {
        return this.f1217e.mo9800b();
    }

    public void setImageAssetDelegate(ImageAssetDelegate bVar) {
        this.f1217e.mo9792a(bVar);
    }

    public void setFontAssetDelegate(FontAssetDelegate aVar) {
        this.f1217e.mo9791a(aVar);
    }

    public void setTextDelegate(TextDelegate mVar) {
        this.f1217e.mo9793a(mVar);
    }

    /* renamed from: a */
    public <T> void mo9729a(KeyPath eVar, T t, LottieValueCallback<T> cVar) {
        this.f1217e.mo9794a(eVar, t, cVar);
    }

    public void setScale(float f) {
        this.f1217e.mo9812e(f);
        if (getDrawable() == this.f1217e) {
            m1059a((Drawable) null, false);
            m1059a((Drawable) this.f1217e, false);
        }
    }

    public float getScale() {
        return this.f1217e.mo9832q();
    }

    /* renamed from: d */
    public void mo9735d() {
        this.f1217e.mo9834s();
        m1063g();
    }

    public void setFrame(int i) {
        this.f1217e.mo9806c(i);
    }

    public int getFrame() {
        return this.f1217e.mo9826k();
    }

    public void setProgress(float f) {
        this.f1217e.mo9808d(f);
    }

    public float getProgress() {
        return this.f1217e.mo9840t();
    }

    public long getDuration() {
        LottieComposition dVar = this.f1225m;
        if (dVar != null) {
            return (long) dVar.mo9920c();
        }
        return 0;
    }

    public void setPerformanceTrackingEnabled(boolean z) {
        this.f1217e.mo9803b(z);
    }

    public PerformanceTracker getPerformanceTracker() {
        return this.f1217e.mo9807d();
    }

    /* renamed from: f */
    private void m1062f() {
        this.f1225m = null;
        this.f1217e.mo9811e();
    }

    /* renamed from: g */
    private void m1063g() {
        int i = 1;
        boolean z = this.f1223k && this.f1217e.mo9829n();
        if (z) {
            i = 2;
        }
        setLayerType(i, null);
    }
}
