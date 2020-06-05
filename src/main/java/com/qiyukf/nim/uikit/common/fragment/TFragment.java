package com.qiyukf.nim.uikit.common.fragment;

import android.os.Bundle;
import android.os.Handler;
import androidx.fragment.app.Fragment;
import com.qiyukf.basesdk.p393a.C5264a;
import com.qiyukf.basesdk.p412c.C5399c;
import com.tencent.stat.common.DeviceInfo;

public abstract class TFragment extends Fragment {
    /* renamed from: a */
    private static final Handler f17441a = new Handler();
    /* renamed from: b */
    private int f17442b;
    /* renamed from: c */
    private boolean f17443c;

    /* access modifiers changed from: protected|final */
    /* renamed from: a */
    public final void mo27424a(final Runnable runnable, long j) {
        f17441a.postDelayed(new Runnable() {
            public final void run() {
                if (TFragment.this.isAdded()) {
                    runnable.run();
                }
            }
        }, j);
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        StringBuilder sb = new StringBuilder("fragment: ");
        sb.append(getClass().getSimpleName());
        sb.append(" onActivityCreated()");
        C5264a.m21617a(DeviceInfo.TAG_IMEI, sb.toString());
        this.f17443c = false;
    }

    public void onDestroy() {
        super.onDestroy();
        StringBuilder sb = new StringBuilder("fragment: ");
        sb.append(getClass().getSimpleName());
        sb.append(" onDestroy()");
        C5264a.m21617a(DeviceInfo.TAG_IMEI, sb.toString());
        this.f17443c = true;
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        C5399c.m22102a(i, iArr);
    }

    public void setContainerId(int i) {
        this.f17442b = i;
    }
}
