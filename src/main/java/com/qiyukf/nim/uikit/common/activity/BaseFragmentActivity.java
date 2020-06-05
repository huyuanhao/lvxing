package com.qiyukf.nim.uikit.common.activity;

import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;
import com.qiyukf.basesdk.p393a.C5264a;
import com.qiyukf.basesdk.p412c.C5399c;
import com.qiyukf.nim.uikit.common.fragment.TFragment;
import com.qiyukf.nimlib.p488k.p492d.C5947a;
import com.qiyukf.unicorn.C5961R;
import com.qiyukf.unicorn.C6029d;
import com.qiyukf.unicorn.api.UICustomization;
import com.tencent.stat.common.DeviceInfo;

public abstract class BaseFragmentActivity extends FragmentActivity {
    /* renamed from: a */
    protected ViewGroup f17438a;
    /* renamed from: b */
    private boolean f17439b = false;

    /* renamed from: b */
    private View m22209b(View view) {
        if (!mo27411a()) {
            return view;
        }
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(1);
        LayoutInflater from = LayoutInflater.from(this);
        UICustomization uICustomization = C6029d.m24045e().uiCustomization;
        int i = ((uICustomization == null || !uICustomization.titleCenter) && !mo27414c()) ? C5961R.C5964layout.ysf_title_bar : C5961R.C5964layout.ysf_title_bar_center;
        this.f17438a = (ViewGroup) from.inflate(i, linearLayout, false);
        linearLayout.addView(this.f17438a, -1, (int) getResources().getDimension(C5961R.dimen.ysf_title_bar_height));
        linearLayout.addView(view, -1, -1);
        return linearLayout;
    }

    /* renamed from: g */
    private void mo27600g() {
        if (mo27411a()) {
            setTitle(getTitle());
            View findViewById = findViewById(C5961R.C5963id.ysf_title_bar_back_area);
            View findViewById2 = findViewById(C5961R.C5963id.ysf_title_bar_back_view);
            if (mo27413b()) {
                findViewById.setOnClickListener(new OnClickListener() {
                    public final void onClick(View view) {
                        BaseFragmentActivity.this.onBackPressed();
                    }
                });
            } else {
                findViewById2.setVisibility(8);
            }
            mo27416e();
        }
    }

    /* renamed from: h */
    private static boolean m22211h() {
        UICustomization uICustomization = C6029d.m24045e().uiCustomization;
        return uICustomization != null && uICustomization.titleBarStyle == 1;
    }

    /* access modifiers changed from: protected|final */
    /* renamed from: a */
    public final View mo27408a(View view) {
        LinearLayout linearLayout = (LinearLayout) findViewById(C5961R.C5963id.ysf_title_bar_actions_layout);
        if (linearLayout != null) {
            linearLayout.addView(view);
        }
        return view;
    }

    /* access modifiers changed from: protected|final */
    /* renamed from: a */
    public final TextView mo27409a(int i) {
        int i2;
        Resources resources;
        String string = getString(i);
        TextView textView = (TextView) LayoutInflater.from(this).inflate(C5961R.C5964layout.ysf_action_bar_right_text_menu, null);
        if (m22211h()) {
            resources = getResources();
            i2 = C5961R.color.ysf_title_bar_text_color_light_selector;
        } else {
            resources = getResources();
            i2 = C5961R.color.ysf_title_bar_text_color_dark_selector;
        }
        textView.setTextColor(resources.getColorStateList(i2));
        textView.setText(string);
        mo27408a((View) textView);
        return textView;
    }

    /* access modifiers changed from: protected|final */
    /* renamed from: a */
    public final void mo27410a(int i, TFragment tFragment) {
        FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
        beginTransaction.replace(i, tFragment);
        try {
            beginTransaction.commitAllowingStateLoss();
        } catch (Exception unused) {
            C5264a.m21622c("BaseFragmentActivity", "repleaseFragment is error");
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public boolean mo27411a() {
        return true;
    }

    /* access modifiers changed from: protected|final */
    /* renamed from: b */
    public final View mo27412b(int i) {
        return mo27408a(LayoutInflater.from(this).inflate(i, null));
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public boolean mo27413b() {
        return true;
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public boolean mo27414c() {
        return false;
    }

    /* access modifiers changed from: protected|final */
    /* renamed from: d */
    public final int mo27415d() {
        ViewGroup viewGroup = this.f17438a;
        if (viewGroup == null || viewGroup.getVisibility() != 0) {
            return 0;
        }
        return this.f17438a.getHeight();
    }

    /* access modifiers changed from: protected */
    /* renamed from: e */
    public void mo27416e() {
        UICustomization uICustomization = C6029d.m24045e().uiCustomization;
        if (uICustomization != null) {
            if (uICustomization.titleBackgroundResId > 0) {
                this.f17438a.setBackgroundResource(uICustomization.titleBackgroundResId);
            } else if (uICustomization.titleBackgroundColor != 0) {
                this.f17438a.setBackgroundColor(uICustomization.titleBackgroundColor);
            }
            if (m22211h()) {
                TextView textView = (TextView) findViewById(C5961R.C5963id.ysf_title_bar_title);
                ((ImageView) findViewById(C5961R.C5963id.ysf_title_bar_back_view)).setImageResource(C5961R.C5962drawable.ysf_title_bar_back_icon_white);
                textView.setTextColor(-1);
            }
        }
    }

    /* access modifiers changed from: protected|final */
    /* renamed from: f */
    public final boolean mo27417f() {
        return VERSION.SDK_INT >= 17 ? super.isDestroyed() : this.f17439b || super.isFinishing();
    }

    public void onBackPressed() {
        if (VERSION.SDK_INT >= 11) {
            C5947a.m23844a(getSupportFragmentManager(), "noteStateNotSaved");
        }
        super.onBackPressed();
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        int i;
        super.onCreate(bundle);
        UICustomization uICustomization = C6029d.m24045e().uiCustomization;
        if (uICustomization != null) {
            if (uICustomization.screenOrientation == 1) {
                i = 0;
            } else if (uICustomization.screenOrientation == 2) {
                i = 4;
            } else {
                setRequestedOrientation(1);
            }
            setRequestedOrientation(i);
        }
        StringBuilder sb = new StringBuilder("activity: ");
        sb.append(getClass().getSimpleName());
        sb.append(" onCreate()");
        C5264a.m21617a(DeviceInfo.TAG_IMEI, sb.toString());
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        StringBuilder sb = new StringBuilder("activity: ");
        sb.append(getClass().getSimpleName());
        sb.append(" onDestroy()");
        C5264a.m21617a(DeviceInfo.TAG_IMEI, sb.toString());
        this.f17439b = true;
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        C5399c.m22102a(i, iArr);
    }

    public void setContentView(int i) {
        setContentView(LayoutInflater.from(this).inflate(i, null));
    }

    public void setContentView(View view) {
        super.setContentView(m22209b(view));
        mo27600g();
    }

    public void setContentView(View view, LayoutParams layoutParams) {
        super.setContentView(m22209b(view), layoutParams);
        mo27600g();
    }

    public void setTitle(int i) {
        setTitle((CharSequence) getString(i));
    }

    public void setTitle(CharSequence charSequence) {
        super.setTitle(charSequence);
        TextView textView = (TextView) findViewById(C5961R.C5963id.ysf_title_bar_title);
        if (textView != null) {
            textView.setText(charSequence);
        }
    }
}
