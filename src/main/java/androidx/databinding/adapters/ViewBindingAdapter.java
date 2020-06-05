package androidx.databinding.adapters;

import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.View.OnClickListener;
import android.view.View.OnLayoutChangeListener;
import android.view.View.OnLongClickListener;
import androidx.databinding.library.baseAdapters.C0269R;

public class ViewBindingAdapter {
    public static final int FADING_EDGE_HORIZONTAL = 1;
    public static final int FADING_EDGE_NONE = 0;
    public static final int FADING_EDGE_VERTICAL = 2;

    /* renamed from: androidx.databinding.adapters.ViewBindingAdapter$OnViewAttachedToWindow */
    public interface OnViewAttachedToWindow {
        void onViewAttachedToWindow(View view);
    }

    /* renamed from: androidx.databinding.adapters.ViewBindingAdapter$OnViewDetachedFromWindow */
    public interface OnViewDetachedFromWindow {
        void onViewDetachedFromWindow(View view);
    }

    private static int pixelsToDimensionPixelSize(float f) {
        int i = (int) (0.5f + f);
        if (i != 0) {
            return i;
        }
        int i2 = (f > 0.0f ? 1 : (f == 0.0f ? 0 : -1));
        if (i2 == 0) {
            return 0;
        }
        return i2 > 0 ? 1 : -1;
    }

    public static void setPadding(View view, float f) {
        int pixelsToDimensionPixelSize = pixelsToDimensionPixelSize(f);
        view.setPadding(pixelsToDimensionPixelSize, pixelsToDimensionPixelSize, pixelsToDimensionPixelSize, pixelsToDimensionPixelSize);
    }

    public static void setPaddingBottom(View view, float f) {
        view.setPadding(view.getPaddingLeft(), view.getPaddingTop(), view.getPaddingRight(), pixelsToDimensionPixelSize(f));
    }

    public static void setPaddingEnd(View view, float f) {
        int pixelsToDimensionPixelSize = pixelsToDimensionPixelSize(f);
        if (VERSION.SDK_INT >= 17) {
            view.setPaddingRelative(view.getPaddingStart(), view.getPaddingTop(), pixelsToDimensionPixelSize, view.getPaddingBottom());
        } else {
            view.setPadding(view.getPaddingLeft(), view.getPaddingTop(), pixelsToDimensionPixelSize, view.getPaddingBottom());
        }
    }

    public static void setPaddingLeft(View view, float f) {
        view.setPadding(pixelsToDimensionPixelSize(f), view.getPaddingTop(), view.getPaddingRight(), view.getPaddingBottom());
    }

    public static void setPaddingRight(View view, float f) {
        view.setPadding(view.getPaddingLeft(), view.getPaddingTop(), pixelsToDimensionPixelSize(f), view.getPaddingBottom());
    }

    public static void setPaddingStart(View view, float f) {
        int pixelsToDimensionPixelSize = pixelsToDimensionPixelSize(f);
        if (VERSION.SDK_INT >= 17) {
            view.setPaddingRelative(pixelsToDimensionPixelSize, view.getPaddingTop(), view.getPaddingEnd(), view.getPaddingBottom());
        } else {
            view.setPadding(pixelsToDimensionPixelSize, view.getPaddingTop(), view.getPaddingRight(), view.getPaddingBottom());
        }
    }

    public static void setPaddingTop(View view, float f) {
        view.setPadding(view.getPaddingLeft(), pixelsToDimensionPixelSize(f), view.getPaddingRight(), view.getPaddingBottom());
    }

    public static void setRequiresFadingEdge(View view, int i) {
        boolean z = false;
        boolean z2 = (i & 2) != 0;
        if ((i & 1) != 0) {
            z = true;
        }
        view.setVerticalFadingEdgeEnabled(z2);
        view.setHorizontalFadingEdgeEnabled(z);
    }

    public static void setClickListener(View view, OnClickListener onClickListener, boolean z) {
        view.setOnClickListener(onClickListener);
        view.setClickable(z);
    }

    public static void setOnClick(View view, OnClickListener onClickListener, boolean z) {
        view.setOnClickListener(onClickListener);
        view.setClickable(z);
    }

    public static void setOnLongClickListener(View view, OnLongClickListener onLongClickListener, boolean z) {
        view.setOnLongClickListener(onLongClickListener);
        view.setLongClickable(z);
    }

    public static void setOnLongClick(View view, OnLongClickListener onLongClickListener, boolean z) {
        view.setOnLongClickListener(onLongClickListener);
        view.setLongClickable(z);
    }

    public static void setOnAttachStateChangeListener(View view, final OnViewDetachedFromWindow onViewDetachedFromWindow, final OnViewAttachedToWindow onViewAttachedToWindow) {
        OnAttachStateChangeListener onAttachStateChangeListener;
        if (onViewDetachedFromWindow == null && onViewAttachedToWindow == null) {
            onAttachStateChangeListener = null;
        } else {
            onAttachStateChangeListener = new OnAttachStateChangeListener() {
                public void onViewAttachedToWindow(View view) {
                    OnViewAttachedToWindow onViewAttachedToWindow = onViewAttachedToWindow;
                    if (onViewAttachedToWindow != null) {
                        onViewAttachedToWindow.onViewAttachedToWindow(view);
                    }
                }

                public void onViewDetachedFromWindow(View view) {
                    OnViewDetachedFromWindow onViewDetachedFromWindow = onViewDetachedFromWindow;
                    if (onViewDetachedFromWindow != null) {
                        onViewDetachedFromWindow.onViewDetachedFromWindow(view);
                    }
                }
            };
        }
        OnAttachStateChangeListener onAttachStateChangeListener2 = (OnAttachStateChangeListener) ListenerUtil.trackListener(view, onAttachStateChangeListener, C0269R.C0270id.onAttachStateChangeListener);
        if (onAttachStateChangeListener2 != null) {
            view.removeOnAttachStateChangeListener(onAttachStateChangeListener2);
        }
        if (onAttachStateChangeListener != null) {
            view.addOnAttachStateChangeListener(onAttachStateChangeListener);
        }
    }

    public static void setOnLayoutChangeListener(View view, OnLayoutChangeListener onLayoutChangeListener, OnLayoutChangeListener onLayoutChangeListener2) {
        if (onLayoutChangeListener != null) {
            view.removeOnLayoutChangeListener(onLayoutChangeListener);
        }
        if (onLayoutChangeListener2 != null) {
            view.addOnLayoutChangeListener(onLayoutChangeListener2);
        }
    }

    public static void setBackground(View view, Drawable drawable) {
        if (VERSION.SDK_INT >= 16) {
            view.setBackground(drawable);
        } else {
            view.setBackgroundDrawable(drawable);
        }
    }
}
