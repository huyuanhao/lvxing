package com.gyf.barlibrary;

import android.content.res.Configuration;
import android.os.Bundle;
import androidx.fragment.app.Fragment;

public abstract class SimpleImmersionFragment extends Fragment implements SimpleImmersionOwner {
    private SimpleImmersionProxy mSimpleImmersionProxy = new SimpleImmersionProxy(this);

    public boolean immersionBarEnabled() {
        return true;
    }

    public void setUserVisibleHint(boolean z) {
        super.setUserVisibleHint(z);
        this.mSimpleImmersionProxy.setUserVisibleHint(z);
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.mSimpleImmersionProxy.onActivityCreated(bundle);
    }

    public void onDestroy() {
        super.onDestroy();
        this.mSimpleImmersionProxy.onDestroy();
    }

    public void onHiddenChanged(boolean z) {
        super.onHiddenChanged(z);
        this.mSimpleImmersionProxy.onHiddenChanged(z);
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.mSimpleImmersionProxy.onConfigurationChanged(configuration);
    }
}
