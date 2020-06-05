package com.p522qq.p523e.ads;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import com.p522qq.p523e.comm.managers.GDTADManager;
import com.p522qq.p523e.comm.p525pi.ACTD;
import com.p522qq.p523e.comm.util.GDTLogger;
import com.p522qq.p523e.comm.util.StringUtil;

/* renamed from: com.qq.e.ads.ADActivity */
public class ADActivity extends Activity {
    /* renamed from: a */
    private ACTD f19907a;

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        ACTD actd = this.f19907a;
        if (actd != null) {
            actd.onActivityResult(i, i2, intent);
        }
    }

    public void onBackPressed() {
        ACTD actd = this.f19907a;
        if (actd != null) {
            actd.onBackPressed();
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        ACTD actd = this.f19907a;
        if (actd != null) {
            actd.onConfigurationChanged(configuration);
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        String str;
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String string = extras.getString(ACTD.DELEGATE_NAME_KEY);
            String string2 = extras.getString(ACTD.APPID_KEY);
            if (!StringUtil.isEmpty(string) && !StringUtil.isEmpty(string2)) {
                try {
                    if (GDTADManager.getInstance().initWith(getApplicationContext(), string2)) {
                        this.f19907a = GDTADManager.getInstance().getPM().getPOFactory().getActivityDelegate(string, this);
                        if (this.f19907a == null) {
                            StringBuilder sb = new StringBuilder("Init ADActivity Delegate return null,delegateName");
                            sb.append(string);
                            str = sb.toString();
                        }
                    } else {
                        str = "Init GDTADManager fail in AdActivity";
                    }
                    GDTLogger.m25260e(str);
                } catch (Throwable th) {
                    StringBuilder sb2 = new StringBuilder("Init ADActivity Delegate Faile,DelegateName:");
                    sb2.append(string);
                    GDTLogger.m25261e(sb2.toString(), th);
                }
            }
        }
        ACTD actd = this.f19907a;
        if (actd != null) {
            actd.onBeforeCreate(bundle);
        } else {
            finish();
        }
        super.onCreate(bundle);
        ACTD actd2 = this.f19907a;
        if (actd2 != null) {
            actd2.onAfterCreate(bundle);
        }
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        ACTD actd = this.f19907a;
        if (actd != null) {
            actd.onDestroy();
        }
    }

    public void onPause() {
        ACTD actd = this.f19907a;
        if (actd != null) {
            actd.onPause();
        }
        super.onPause();
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        ACTD actd = this.f19907a;
        if (actd != null) {
            actd.onResume();
        }
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        ACTD actd = this.f19907a;
        if (actd != null) {
            actd.onStop();
        }
        super.onStop();
    }
}
