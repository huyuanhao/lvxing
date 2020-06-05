package androidx.databinding.adapters;

import android.widget.TabHost;
import android.widget.TabHost.OnTabChangeListener;
import androidx.databinding.InverseBindingListener;

public class TabHostBindingAdapter {
    public static int getCurrentTab(TabHost tabHost) {
        return tabHost.getCurrentTab();
    }

    public static String getCurrentTabTag(TabHost tabHost) {
        return tabHost.getCurrentTabTag();
    }

    public static void setCurrentTab(TabHost tabHost, int i) {
        if (tabHost.getCurrentTab() != i) {
            tabHost.setCurrentTab(i);
        }
    }

    public static void setCurrentTabTag(TabHost tabHost, String str) {
        if (tabHost.getCurrentTabTag() != str) {
            tabHost.setCurrentTabByTag(str);
        }
    }

    public static void setListeners(TabHost tabHost, final OnTabChangeListener onTabChangeListener, final InverseBindingListener inverseBindingListener) {
        if (inverseBindingListener == null) {
            tabHost.setOnTabChangedListener(onTabChangeListener);
        } else {
            tabHost.setOnTabChangedListener(new OnTabChangeListener() {
                public void onTabChanged(String str) {
                    OnTabChangeListener onTabChangeListener = onTabChangeListener;
                    if (onTabChangeListener != null) {
                        onTabChangeListener.onTabChanged(str);
                    }
                    inverseBindingListener.onChange();
                }
            });
        }
    }
}
