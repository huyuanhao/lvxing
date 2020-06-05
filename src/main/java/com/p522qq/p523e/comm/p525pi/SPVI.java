package com.p522qq.p523e.comm.p525pi;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.p522qq.p523e.comm.adevent.ADListener;

/* renamed from: com.qq.e.comm.pi.SPVI */
public abstract class SPVI extends RelativeLayout {
    public SPVI(Context context, String str, String str2) {
        super(context);
    }

    public abstract void fetchAndShowIn(ViewGroup viewGroup);

    public abstract void setAdListener(ADListener aDListener);

    public abstract void setFetchDelay(int i);
}
