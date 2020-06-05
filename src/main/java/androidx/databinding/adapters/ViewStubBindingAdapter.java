package androidx.databinding.adapters;

import android.view.ViewStub.OnInflateListener;
import androidx.databinding.ViewStubProxy;

public class ViewStubBindingAdapter {
    public static void setOnInflateListener(ViewStubProxy viewStubProxy, OnInflateListener onInflateListener) {
        viewStubProxy.setOnInflateListener(onInflateListener);
    }
}
