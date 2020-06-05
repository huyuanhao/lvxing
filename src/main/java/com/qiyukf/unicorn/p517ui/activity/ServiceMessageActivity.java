package com.qiyukf.unicorn.p517ui.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.qiyukf.basesdk.p412c.p417d.C5409b;
import com.qiyukf.nim.uikit.common.activity.BaseFragmentActivity;
import com.qiyukf.nimlib.sdk.NimIntent;
import com.qiyukf.nimlib.sdk.msg.model.IMMessage;
import com.qiyukf.unicorn.C5961R;
import com.qiyukf.unicorn.C6029d;
import com.qiyukf.unicorn.api.ConsultSource;
import com.qiyukf.unicorn.api.lifecycle.SessionLifeCycleListener;
import com.qiyukf.unicorn.api.lifecycle.SessionLifeCycleOptions;
import com.qiyukf.unicorn.apicloud.APICloudClient;
import com.qiyukf.unicorn.p517ui.fragment.ServiceMessageFragment;
import com.tencent.p605ep.common.adapt.iservice.account.AccountConst.ArgKey;

/* renamed from: com.qiyukf.unicorn.ui.activity.ServiceMessageActivity */
public class ServiceMessageActivity extends BaseFragmentActivity {
    /* renamed from: b */
    private ServiceMessageFragment f19453b;
    /* renamed from: c */
    private Boolean f19454c = Boolean.valueOf(false);
    /* renamed from: d */
    private ImageView f19455d;
    /* renamed from: e */
    private TextView f19456e;
    /* renamed from: f */
    private SessionLifeCycleListener f19457f = new SessionLifeCycleListener() {
        public final void onLeaveSession() {
            C5409b.m22130a((Activity) ServiceMessageActivity.this);
            ServiceMessageActivity.this.finish();
        }
    };

    /* renamed from: g */
    private String m24703g() {
        try {
            PackageManager packageManager = getApplicationContext().getPackageManager();
            return packageManager.getApplicationLabel(packageManager.getApplicationInfo(getPackageName(), 128)).toString();
        } catch (NameNotFoundException e) {
            e.printStackTrace();
            return getString(C5961R.string.ysf_service_title_default);
        }
    }

    public static void start(Context context, String str, ConsultSource consultSource) {
        Intent intent = new Intent();
        intent.putExtra(ArgKey.KEY_SOURCE, consultSource);
        intent.putExtra("title", str);
        intent.setClass(context, ServiceMessageActivity.class);
        intent.addFlags(67108864);
        if (!(context instanceof Activity)) {
            intent.addFlags(268435456);
        }
        context.startActivity(intent);
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (this.f19454c.booleanValue() && this.f19453b != null) {
            this.f19454c = Boolean.valueOf(false);
            this.f19453b.onActivityResult(i, i2, intent);
        }
    }

    public void onBackPressed() {
        C5409b.m22130a((Activity) this);
        if (getSupportFragmentManager().getBackStackEntryCount() > 0) {
            super.onBackPressed();
            return;
        }
        ServiceMessageFragment serviceMessageFragment = this.f19453b;
        if (serviceMessageFragment == null || !serviceMessageFragment.onBackPressed()) {
            finish();
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        String str;
        ConsultSource consultSource;
        super.onCreate(bundle);
        setContentView(C5961R.C5964layout.ysf_message_activity);
        if (!(C6029d.m24045e().titleBarConfig == null || C6029d.m24045e().titleBarConfig.titleBarRightImg == 0 || C6029d.m24045e().titleBarConfig.onTitleBarRightBtnClickListener == null)) {
            View b = mo27412b(C5961R.C5964layout.ysf_action_bar_right_custom_img_layout);
            this.f19455d = (ImageView) b.findViewById(C5961R.C5963id.ysf_iv_title_bar_right_btn);
            this.f19455d.setBackgroundResource(C6029d.m24045e().titleBarConfig.titleBarRightImg);
            this.f19456e = (TextView) b.findViewById(C5961R.C5963id.ysf_tv_title_bar_right_btn);
            if (C6029d.m24045e().titleBarConfig.titleBarRightText != null) {
                this.f19456e.setText(C6029d.m24045e().titleBarConfig.titleBarRightText.length() > 4 ? C6029d.m24045e().titleBarConfig.titleBarRightText.substring(0, 4) : C6029d.m24045e().titleBarConfig.titleBarRightText);
            } else {
                this.f19456e.setVisibility(8);
            }
            b.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    C6029d.m24045e().titleBarConfig.onTitleBarRightBtnClickListener.onClick(ServiceMessageActivity.this);
                }
            });
        }
        APICloudClient.onActivityCreate(this);
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(0);
        linearLayout.setGravity(17);
        mo27408a((View) linearLayout);
        Intent intent = getIntent();
        String str2 = ArgKey.KEY_SOURCE;
        if (intent.hasExtra(str2)) {
            str = intent.getStringExtra("title");
            consultSource = (ConsultSource) intent.getSerializableExtra(str2);
        } else {
            String str3 = NimIntent.EXTRA_NOTIFY_CONTENT;
            if (intent.hasExtra(str3)) {
                str = m24703g();
                ConsultSource consultSource2 = new ConsultSource("com.qiyukf.notification", getString(C5961R.string.ysf_service_source_title_notification), null);
                consultSource2.shopId = ((IMMessage) intent.getSerializableExtra(str3)).getSessionId();
                consultSource = consultSource2;
            } else {
                str = m24703g();
                consultSource = null;
            }
        }
        if (consultSource == null) {
            consultSource = new ConsultSource(null, null, null);
        }
        if (consultSource.sessionLifeCycleOptions == null) {
            consultSource.sessionLifeCycleOptions = new SessionLifeCycleOptions();
        }
        consultSource.sessionLifeCycleOptions.setSessionLifeCycleListener(this.f19457f);
        this.f19453b = new ServiceMessageFragment();
        this.f19453b.setArguments(str, consultSource, linearLayout);
        mo27410a(C5961R.C5963id.message_fragment_container, this.f19453b);
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        APICloudClient.onActivityDestroy();
        super.onDestroy();
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        if (bundle != null) {
            this.f19454c = Boolean.valueOf(true);
        }
    }
}
