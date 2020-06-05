package androidx.databinding.adapters;

import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;

public class AbsListViewBindingAdapter {

    /* renamed from: androidx.databinding.adapters.AbsListViewBindingAdapter$OnScroll */
    public interface OnScroll {
        void onScroll(AbsListView absListView, int i, int i2, int i3);
    }

    /* renamed from: androidx.databinding.adapters.AbsListViewBindingAdapter$OnScrollStateChanged */
    public interface OnScrollStateChanged {
        void onScrollStateChanged(AbsListView absListView, int i);
    }

    public static void setOnScroll(AbsListView absListView, final OnScroll onScroll, final OnScrollStateChanged onScrollStateChanged) {
        absListView.setOnScrollListener(new OnScrollListener() {
            public void onScrollStateChanged(AbsListView absListView, int i) {
                OnScrollStateChanged onScrollStateChanged = onScrollStateChanged;
                if (onScrollStateChanged != null) {
                    onScrollStateChanged.onScrollStateChanged(absListView, i);
                }
            }

            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                OnScroll onScroll = onScroll;
                if (onScroll != null) {
                    onScroll.onScroll(absListView, i, i2, i3);
                }
            }
        });
    }
}
