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
import com.tencent.bugly.beta.global.C7128b;
import com.tencent.bugly.beta.global.C7131e;
import com.tencent.bugly.proguard.C7226an;

/* compiled from: BUGLY */
/* renamed from: com.tencent.bugly.beta.ui.e */
public class C7146e extends C7139a {
    /* renamed from: n */
    protected TextView f23795n;

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
            this.f23795n = new TextView(this.f23759a);
            this.f23795n.setLayoutParams(layoutParams);
            TextView textView = this.f23795n;
            this.f23768j.getClass();
            textView.setTextColor(Color.parseColor("#757575"));
            this.f23795n.setTextSize(16.0f);
            this.f23795n.setTag(str);
            this.f23767i.addView(this.f23795n);
        } else if (onCreateView != null) {
            this.f23795n = (TextView) onCreateView.findViewWithTag(str);
        }
        try {
            this.f23795n.setText("检测到当前版本需要重启，是否重启应用？");
            this.f23764f.setText("更新提示");
            mo34435a("取消", new C7128b(8, this), "重启应用", new C7128b(7, this));
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
}
