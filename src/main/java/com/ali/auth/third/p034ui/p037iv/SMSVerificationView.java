package com.ali.auth.third.p034ui.p037iv;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ScrollView;
import com.ali.auth.third.core.p023b.C0988e;
import com.ali.auth.third.ui.R;

/* renamed from: com.ali.auth.third.ui.iv.SMSVerificationView */
public class SMSVerificationView extends ScrollView {
    /* renamed from: a */
    protected IVParam f2189a;
    /* renamed from: b */
    private C0988e<String> f2190b;

    public SMSVerificationView(Context context) {
        this(context, null);
    }

    public SMSVerificationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f2189a = new IVParam();
        LayoutInflater.from(context).inflate(getLayoutId(), this);
    }

    /* access modifiers changed from: protected */
    public int getLayoutId() {
        return R.layout.ali_auth_sms_verification;
    }

    public String getPageName() {
        return "";
    }

    public void setResultCallback(C0988e eVar) {
        this.f2190b = eVar;
    }
}
