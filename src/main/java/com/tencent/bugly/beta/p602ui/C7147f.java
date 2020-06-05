package com.tencent.bugly.beta.p602ui;

import android.graphics.Color;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.bugly.beta.Beta;
import com.tencent.bugly.beta.download.DownloadTask;
import com.tencent.bugly.beta.global.C7128b;
import com.tencent.bugly.beta.global.C7131e;
import com.tencent.bugly.proguard.C7226an;

/* compiled from: BUGLY */
/* renamed from: com.tencent.bugly.beta.ui.f */
public class C7147f extends C7139a {
    /* renamed from: n */
    public DownloadTask f23796n;
    /* renamed from: o */
    protected TextView f23797o;

    /* renamed from: a */
    public boolean mo34441a(int i, KeyEvent keyEvent) {
        return false;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f23770l = C7131e.f23698E.f23738j;
        View onCreateView = super.onCreateView(layoutInflater, viewGroup, bundle);
        int i = this.f23770l;
        String str = Beta.TAG_TIP_MESSAGE;
        if (i == 0) {
            LayoutParams layoutParams = new LayoutParams(-1, -2);
            this.f23797o = new TextView(this.f23759a);
            this.f23797o.setLayoutParams(layoutParams);
            TextView textView = this.f23797o;
            this.f23768j.getClass();
            textView.setTextColor(Color.parseColor("#757575"));
            this.f23797o.setTextSize(16.0f);
            this.f23797o.setTag(str);
            this.f23767i.addView(this.f23797o);
        } else if (onCreateView != null) {
            this.f23797o = (TextView) onCreateView.findViewWithTag(str);
        }
        try {
            this.f23797o.setText(Beta.strNetworkTipsMessage);
            this.f23764f.setText(Beta.strNetworkTipsTitle);
            mo34435a(Beta.strNetworkTipsCancelBtn, new C7128b(2, this), Beta.strNetworkTipsConfirmBtn, new C7128b(3, this, this.f23796n));
        } catch (Exception e) {
            if (this.f23770l != 0) {
                C7226an.m31149e("please confirm your argument: [Beta.tipsDialogLayoutId] is correct", new Object[0]);
            }
            if (!C7226an.m31145b(e)) {
                e.printStackTrace();
            }
        }
        return onCreateView;
    }

    public void onDestroyView() {
        super.onDestroyView();
        this.f23797o = null;
    }
}
