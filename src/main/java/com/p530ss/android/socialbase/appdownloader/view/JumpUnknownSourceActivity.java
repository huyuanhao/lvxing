package com.p530ss.android.socialbase.appdownloader.view;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import com.p530ss.android.socialbase.appdownloader.AppDownloader;
import com.p530ss.android.socialbase.appdownloader.C6604b;
import com.p530ss.android.socialbase.appdownloader.ResourceUtils;
import com.p530ss.android.socialbase.appdownloader.p552c.IAppDownloadDepend;
import com.p530ss.android.socialbase.appdownloader.p552c.IDownloadAlertDialog;
import com.p530ss.android.socialbase.appdownloader.p552c.IDownloadAlertDialogBuilder;
import com.p530ss.android.socialbase.appdownloader.p553d.DefaultAlertDialogBuilder;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.ss.android.socialbase.appdownloader.view.JumpUnknownSourceActivity */
public class JumpUnknownSourceActivity extends Activity {
    /* renamed from: a */
    private IDownloadAlertDialog f21660a;
    /* renamed from: b */
    private Intent f21661b;
    /* access modifiers changed from: private */
    /* renamed from: c */
    public Intent f21662c;
    /* access modifiers changed from: private */
    /* renamed from: d */
    public JSONObject f21663d;

    /* access modifiers changed from: protected */
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        m26955a();
    }

    /* renamed from: a */
    private void m26955a() {
        Window window = getWindow();
        LayoutParams attributes = window.getAttributes();
        attributes.alpha = 0.0f;
        window.setAttributes(attributes);
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        Intent intent = getIntent();
        this.f21661b = intent;
        if (intent != null) {
            this.f21662c = (Intent) intent.getParcelableExtra("intent");
            try {
                this.f21663d = new JSONObject(intent.getStringExtra("config"));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        m26957b();
        IDownloadAlertDialog jVar = this.f21660a;
        if (jVar != null && !jVar.mo31384b()) {
            this.f21660a.mo31383a();
        } else if (this.f21660a == null) {
            finish();
        }
    }

    /* renamed from: b */
    private void m26957b() {
        if (this.f21660a == null && this.f21661b != null) {
            try {
                IAppDownloadDepend a = AppDownloader.m26714h().mo31474a();
                IDownloadAlertDialogBuilder kVar = null;
                if (a != null) {
                    kVar = a.mo31374a(this);
                }
                if (kVar == null) {
                    kVar = new DefaultAlertDialogBuilder(this);
                }
                int a2 = ResourceUtils.m26944a((Context) this, "appdownloader_tip");
                int a3 = ResourceUtils.m26944a((Context) this, "appdownloader_label_ok");
                int a4 = ResourceUtils.m26944a((Context) this, "appdownloader_label_cancel");
                String optString = this.f21663d.optString("jump_unknown_source_tips");
                if (TextUtils.isEmpty(optString)) {
                    optString = getString(ResourceUtils.m26944a((Context) this, "appdownloader_jump_unknown_source_tips"));
                }
                kVar.mo31377a(a2).mo31380a(optString).mo31378a(a3, new OnClickListener() {
                    public void onClick(DialogInterface dialogInterface, int i) {
                        JumpUnknownSourceActivity jumpUnknownSourceActivity = JumpUnknownSourceActivity.this;
                        if (!C6604b.m26614a((Context) jumpUnknownSourceActivity, jumpUnknownSourceActivity.f21662c, JumpUnknownSourceActivity.this.f21663d)) {
                            JumpUnknownSourceActivity jumpUnknownSourceActivity2 = JumpUnknownSourceActivity.this;
                            C6604b.m26616a((Context) jumpUnknownSourceActivity2, jumpUnknownSourceActivity2.f21662c, true);
                        }
                        JumpUnknownSourceActivity.this.finish();
                    }
                }).mo31382b(a4, new OnClickListener() {
                    public void onClick(DialogInterface dialogInterface, int i) {
                        if (JumpUnknownSourceActivity.this.f21662c != null) {
                            JumpUnknownSourceActivity jumpUnknownSourceActivity = JumpUnknownSourceActivity.this;
                            C6604b.m26616a((Context) jumpUnknownSourceActivity, jumpUnknownSourceActivity.f21662c, true);
                        }
                        JumpUnknownSourceActivity.this.finish();
                    }
                }).mo31379a((OnCancelListener) new OnCancelListener() {
                    public void onCancel(DialogInterface dialogInterface) {
                        if (JumpUnknownSourceActivity.this.f21662c != null) {
                            JumpUnknownSourceActivity jumpUnknownSourceActivity = JumpUnknownSourceActivity.this;
                            C6604b.m26616a((Context) jumpUnknownSourceActivity, jumpUnknownSourceActivity.f21662c, true);
                        }
                        JumpUnknownSourceActivity.this.finish();
                    }
                }).mo31381a(false);
                this.f21660a = kVar.mo31376a();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
