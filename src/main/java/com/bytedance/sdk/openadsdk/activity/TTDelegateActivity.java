package com.bytedance.sdk.openadsdk.activity;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.bytedance.sdk.openadsdk.TTCustomController;
import com.bytedance.sdk.openadsdk.core.GlobalInfo;
import com.bytedance.sdk.openadsdk.core.IdUtils;
import com.bytedance.sdk.openadsdk.core.InternalContainer;
import com.bytedance.sdk.openadsdk.core.p172f.PermissionsManager;
import com.bytedance.sdk.openadsdk.core.p172f.PermissionsResultAction;
import com.bytedance.sdk.openadsdk.core.widget.InstallDialog;
import com.bytedance.sdk.openadsdk.core.widget.InstallDialog.C2360a;
import com.bytedance.sdk.openadsdk.downloadnew.p181a.LibHolder;
import com.bytedance.sdk.openadsdk.p198i.TTExecutor;
import com.bytedance.sdk.openadsdk.utils.ActivityUtil;
import com.bytedance.sdk.openadsdk.utils.ActivityUtil.C2540a;
import com.bytedance.sdk.openadsdk.utils.C2564t;
import com.bytedance.sdk.openadsdk.utils.CommonDialogHelper;
import com.bytedance.sdk.openadsdk.utils.CommonPermissionUtils;
import com.bytedance.sdk.openadsdk.utils.ResourceHelp;
import com.tencent.mid.core.Constants;
import java.util.ArrayList;

public class TTDelegateActivity extends Activity {
    /* renamed from: a */
    private Intent f6540a;
    /* renamed from: b */
    private AlertDialog f6541b;

    /* renamed from: com.bytedance.sdk.openadsdk.activity.TTDelegateActivity$a */
    public static class C2032a implements Runnable {
        public void run() {
            LibHolder.m11224a();
            IdUtils.m9872j(InternalContainer.m10059a());
        }
    }

    /* renamed from: a */
    public static void m8100a(String str, String[] strArr) {
        Intent intent = new Intent(InternalContainer.m10059a(), TTDelegateActivity.class);
        intent.addFlags(268435456);
        intent.putExtra("type", 4);
        intent.putExtra("permission_id_key", str);
        intent.putExtra("permission_content_key", strArr);
        if (InternalContainer.m10059a() != null) {
            ActivityUtil.m12108a(InternalContainer.m10059a(), intent, new C2540a() {
                /* renamed from: a */
                public void mo14890a() {
                }

                /* renamed from: a */
                public void mo14891a(Throwable th) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("requestPermission->startActivity error :");
                    sb.append(th.toString());
                    C2564t.m12219b(sb.toString());
                }
            });
        }
    }

    /* renamed from: a */
    public static void m8098a(String str, String str2, String str3) {
        Intent intent = new Intent(InternalContainer.m10059a(), TTDelegateActivity.class);
        intent.addFlags(268435456);
        intent.putExtra("type", 3);
        intent.putExtra("app_download_url", str);
        intent.putExtra("dialog_title_key", str2);
        intent.putExtra("dialog_content_key", str3);
        if (InternalContainer.m10059a() != null) {
            ActivityUtil.m12108a(InternalContainer.m10059a(), intent, null);
        }
    }

    /* renamed from: a */
    public static void m8099a(String str, String str2, String str3, String str4, String str5) {
        Intent intent = new Intent(InternalContainer.m10059a(), TTDelegateActivity.class);
        intent.addFlags(268435456);
        intent.putExtra("type", 5);
        intent.putExtra("app_download_url", str);
        intent.putExtra("dialog_title_key", str2);
        intent.putExtra("dialog_content_key", str3);
        intent.putExtra("dialog_btn_yes_key", str4);
        intent.putExtra("dialog_btn_no_key", str5);
        if (InternalContainer.m10059a() != null) {
            ActivityUtil.m12108a(InternalContainer.m10059a(), intent, null);
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        m8096a();
        this.f6540a = getIntent();
        if (InternalContainer.m10059a() == null) {
            InternalContainer.m10061a(this);
        }
    }

    /* renamed from: a */
    private void m8096a() {
        if (GlobalInfo.m9616c().mo15682l()) {
            getWindow().addFlags(2621440);
        }
        Window window = getWindow();
        LayoutParams attributes = window.getAttributes();
        attributes.alpha = 0.0f;
        window.setAttributes(attributes);
    }

    /* access modifiers changed from: protected */
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (InternalContainer.m10059a() == null) {
            InternalContainer.m10061a(this);
        }
        try {
            setIntent(intent);
            this.f6540a = intent;
        } catch (Throwable unused) {
        }
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        if (getIntent() != null) {
            m8101b();
        }
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        try {
            if (this.f6541b != null && this.f6541b.isShowing()) {
                this.f6541b.dismiss();
            }
        } catch (Throwable unused) {
        }
        super.onDestroy();
    }

    /* renamed from: b */
    private void m8101b() {
        try {
            int intExtra = this.f6540a.getIntExtra("type", 0);
            String stringExtra = this.f6540a.getStringExtra("app_download_url");
            this.f6540a.getStringExtra("app_name");
            if (intExtra == 1) {
                return;
            }
            if (intExtra != 2) {
                String str = "dialog_content_key";
                String str2 = "dialog_title_key";
                if (intExtra == 3) {
                    m8102b(stringExtra, this.f6540a.getStringExtra(str2), this.f6540a.getStringExtra(str));
                } else if (intExtra == 4) {
                    m8104b(this.f6540a.getStringExtra("permission_id_key"), this.f6540a.getStringArrayExtra("permission_content_key"));
                } else if (intExtra != 5) {
                    finish();
                } else {
                    m8103b(stringExtra, this.f6540a.getStringExtra(str2), this.f6540a.getStringExtra(str), this.f6540a.getStringExtra("dialog_btn_yes_key"), this.f6540a.getStringExtra("dialog_btn_no_key"));
                }
            } else {
                m8105c();
            }
        } catch (Exception unused) {
            finish();
        }
    }

    /* renamed from: b */
    private void m8103b(final String str, String str2, String str3, String str4, String str5) {
        AlertDialog alertDialog = this.f6541b;
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
        InstallDialog a = new InstallDialog(this).mo16297a(str2).mo16298b(str3).mo16299c(str4).mo16300d(str5).mo16296a((C2360a) new C2360a() {
            /* renamed from: a */
            public void mo14893a(Dialog dialog) {
                CommonDialogHelper.m12140a(str);
                TTDelegateActivity.this.finish();
            }

            /* renamed from: b */
            public void mo14894b(Dialog dialog) {
                CommonDialogHelper.m12146b(str);
                TTDelegateActivity.this.finish();
            }
        }).mo16294a((OnCancelListener) new OnCancelListener() {
            public void onCancel(DialogInterface dialogInterface) {
                CommonDialogHelper.m12147c(str);
                TTDelegateActivity.this.finish();
            }
        });
        a.show();
        this.f6541b = a;
    }

    /* renamed from: b */
    private void m8104b(final String str, String[] strArr) {
        if (TextUtils.isEmpty(str) || strArr == null || strArr.length <= 0) {
            finish();
            return;
        }
        if (VERSION.SDK_INT >= 23) {
            try {
                PermissionsManager.m9560a().mo15630a((Activity) this, strArr, (PermissionsResultAction) new PermissionsResultAction() {
                    /* renamed from: a */
                    public void mo14895a() {
                        CommonPermissionUtils.m12153a(str);
                        TTDelegateActivity.this.finish();
                    }

                    /* renamed from: a */
                    public void mo14896a(String str) {
                        CommonPermissionUtils.m12155a(str, str);
                        TTDelegateActivity.this.finish();
                    }
                });
            } catch (Exception unused) {
                finish();
            }
        } else {
            C2564t.m12220b(TTAdConstant.TAG, "已经有权限");
            finish();
        }
    }

    /* renamed from: b */
    private void m8102b(final String str, String str2, String str3) {
        if (TextUtils.isEmpty(str2)) {
            str2 = ResourceHelp.m11931a(this, "tt_tip");
        }
        String str4 = str2;
        if (TextUtils.isEmpty(str3)) {
            str3 = "";
        }
        m8097a(str4, str3, (OnClickListener) new OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                CommonDialogHelper.m12140a(str);
                TTDelegateActivity.this.finish();
            }
        }, (OnClickListener) new OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                CommonDialogHelper.m12146b(str);
                TTDelegateActivity.this.finish();
            }
        }, (OnCancelListener) new OnCancelListener() {
            public void onCancel(DialogInterface dialogInterface) {
                CommonDialogHelper.m12147c(str);
                TTDelegateActivity.this.finish();
            }
        });
    }

    /* renamed from: c */
    private void m8105c() {
        if (VERSION.SDK_INT >= 23) {
            try {
                TTCustomController d = GlobalInfo.m9616c().mo15672d();
                boolean isCanUseLocation = d.isCanUseLocation();
                boolean isCanUsePhoneState = d.isCanUsePhoneState();
                boolean isCanUseWriteExternal = d.isCanUseWriteExternal();
                ArrayList arrayList = new ArrayList();
                if (isCanUseLocation) {
                    arrayList.add("android.permission.ACCESS_COARSE_LOCATION");
                    arrayList.add("android.permission.ACCESS_FINE_LOCATION");
                }
                if (isCanUsePhoneState) {
                    arrayList.add(Constants.PERMISSION_READ_PHONE_STATE);
                }
                if (isCanUseWriteExternal) {
                    arrayList.add(Constants.PERMISSION_WRITE_EXTERNAL_STORAGE);
                }
                String[] strArr = new String[arrayList.size()];
                arrayList.toArray(strArr);
                PermissionsManager.m9560a().mo15630a((Activity) this, strArr, (PermissionsResultAction) new PermissionsResultAction() {
                    /* renamed from: a */
                    public void mo14895a() {
                        TTExecutor.m11692a().mo16808c(new C2032a(), 1);
                        TTDelegateActivity.this.finish();
                    }

                    /* renamed from: a */
                    public void mo14896a(String str) {
                        Constants.PERMISSION_READ_PHONE_STATE.equals(str);
                        TTExecutor.m11692a().mo16808c(new C2032a(), 1);
                        TTDelegateActivity.this.finish();
                    }
                });
            } catch (Exception unused) {
                finish();
            }
        } else {
            C2564t.m12220b(TTAdConstant.TAG, "已经有Read phone state权限");
            finish();
        }
    }

    /* renamed from: a */
    private void m8097a(String str, String str2, OnClickListener onClickListener, OnClickListener onClickListener2, OnCancelListener onCancelListener) {
        String str3;
        try {
            if (this.f6541b == null) {
                if (VERSION.SDK_INT >= 21) {
                    str3 = "Theme.Dialog.TTDownload";
                } else {
                    str3 = "Theme.Dialog.TTDownloadOld";
                }
                this.f6541b = new Builder(this, ResourceHelp.m11937g(this, str3)).create();
            }
            this.f6541b.setTitle(String.valueOf(str));
            this.f6541b.setMessage(String.valueOf(str2));
            this.f6541b.setButton(-1, ResourceHelp.m11931a(this, "tt_label_ok"), onClickListener);
            this.f6541b.setButton(-2, ResourceHelp.m11931a(this, "tt_label_cancel"), onClickListener2);
            this.f6541b.setOnCancelListener(onCancelListener);
            if (!this.f6541b.isShowing()) {
                this.f6541b.show();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        PermissionsManager.m9560a().mo15631a((Activity) this, strArr, iArr);
        TTExecutor.m11692a().mo16808c(new C2032a(), 1);
        finish();
    }
}
