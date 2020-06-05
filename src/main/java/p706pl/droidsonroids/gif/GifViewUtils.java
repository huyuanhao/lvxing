package p706pl.droidsonroids.gif;

import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.content.res.TypedArray;
import android.net.Uri;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.widget.ImageView;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/* renamed from: pl.droidsonroids.gif.e */
final class GifViewUtils {
    /* renamed from: a */
    static final List<String> f29283a = Arrays.asList(new String[]{"raw", "drawable", "mipmap"});

    /* compiled from: GifViewUtils */
    /* renamed from: pl.droidsonroids.gif.e$a */
    static class C8596a {
        /* renamed from: a */
        final int f29284a;
        /* renamed from: b */
        final int f29285b;
        /* renamed from: c */
        final boolean f29286c;

        C8596a(int i, int i2, boolean z) {
            this.f29284a = i;
            this.f29285b = i2;
            this.f29286c = z;
        }
    }

    /* renamed from: a */
    static C8596a m37437a(ImageView imageView, AttributeSet attributeSet, int i, int i2) {
        if (attributeSet == null || imageView.isInEditMode()) {
            return new C8596a(0, 0, false);
        }
        return new C8596a(m37436a(imageView, attributeSet, true), m37436a(imageView, attributeSet, false), m37438a((View) imageView, attributeSet, i, i2));
    }

    /* renamed from: a */
    private static int m37436a(ImageView imageView, AttributeSet attributeSet, boolean z) {
        int attributeResourceValue = attributeSet.getAttributeResourceValue("http://schemas.android.com/apk/res/android", z ? "src" : "background", 0);
        if (attributeResourceValue > 0) {
            if (!f29283a.contains(imageView.getResources().getResourceTypeName(attributeResourceValue)) || m37440a(imageView, z, attributeResourceValue)) {
                return 0;
            }
            return attributeResourceValue;
        }
        return 0;
    }

    /* renamed from: a */
    static boolean m37440a(ImageView imageView, boolean z, int i) {
        Resources resources = imageView.getResources();
        if (resources != null) {
            try {
                GifDrawable cVar = new GifDrawable(resources, i);
                if (z) {
                    imageView.setImageDrawable(cVar);
                } else if (VERSION.SDK_INT >= 16) {
                    imageView.setBackground(cVar);
                } else {
                    imageView.setBackgroundDrawable(cVar);
                }
                return true;
            } catch (NotFoundException | IOException unused) {
            }
        }
        return false;
    }

    /* renamed from: a */
    static boolean m37438a(View view, AttributeSet attributeSet, int i, int i2) {
        TypedArray obtainStyledAttributes = view.getContext().obtainStyledAttributes(attributeSet, R.styleable.GifView, i, i2);
        boolean z = obtainStyledAttributes.getBoolean(R.styleable.GifView_freezesAnimation, false);
        obtainStyledAttributes.recycle();
        return z;
    }

    /* renamed from: a */
    static boolean m37439a(ImageView imageView, Uri uri) {
        if (uri != null) {
            try {
                imageView.setImageDrawable(new GifDrawable(imageView.getContext().getContentResolver(), uri));
                return true;
            } catch (IOException unused) {
            }
        }
        return false;
    }

    /* renamed from: a */
    static float m37435a(Resources resources, int i) {
        TypedValue typedValue = new TypedValue();
        resources.getValue(i, typedValue, true);
        int i2 = typedValue.density;
        if (i2 == 0) {
            i2 = 160;
        } else if (i2 == 65535) {
            i2 = 0;
        }
        int i3 = resources.getDisplayMetrics().densityDpi;
        if (i2 <= 0 || i3 <= 0) {
            return 1.0f;
        }
        return ((float) i3) / ((float) i2);
    }
}
