package com.p530ss.android.socialbase.appdownloader.view;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import com.p530ss.android.socialbase.appdownloader.AppDownloader;
import com.p530ss.android.socialbase.appdownloader.ResourceUtils;
import com.p530ss.android.socialbase.appdownloader.p552c.IAppDownloadDepend;
import com.p530ss.android.socialbase.appdownloader.p552c.IAppDownloadEventHandler;
import com.p530ss.android.socialbase.appdownloader.p552c.IDownloadAlertDialog;
import com.p530ss.android.socialbase.appdownloader.p552c.IDownloadAlertDialogBuilder;
import com.p530ss.android.socialbase.appdownloader.p553d.DefaultAlertDialogBuilder;
import com.p530ss.android.socialbase.downloader.downloader.C6694b;
import com.p530ss.android.socialbase.downloader.downloader.Downloader;
import com.p530ss.android.socialbase.downloader.p559d.IDownloadNotificationEventListener;
import com.p530ss.android.socialbase.downloader.p562g.DownloadInfo;

/* renamed from: com.ss.android.socialbase.appdownloader.view.DownloadTaskDeleteActivity */
public class DownloadTaskDeleteActivity extends Activity {
    /* renamed from: a */
    private IDownloadAlertDialog f21653a;
    /* renamed from: b */
    private Intent f21654b;

    /* access modifiers changed from: protected */
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        m26952a();
    }

    /* renamed from: a */
    private void m26952a() {
        Window window = getWindow();
        LayoutParams attributes = window.getAttributes();
        attributes.alpha = 0.0f;
        window.setAttributes(attributes);
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        this.f21654b = getIntent();
        m26953b();
        IDownloadAlertDialog jVar = this.f21653a;
        if (jVar != null && !jVar.mo31384b()) {
            this.f21653a.mo31383a();
        } else if (this.f21653a == null) {
            finish();
        }
    }

    /* renamed from: b */
    private void m26953b() {
        if (this.f21653a == null) {
            Intent intent = this.f21654b;
            if (intent != null) {
                try {
                    final int intExtra = intent.getIntExtra("extra_click_download_ids", 0);
                    final DownloadInfo h = Downloader.m27478a(getApplicationContext()).mo31928h(intExtra);
                    if (h != null) {
                        String i = h.mo32291i();
                        if (TextUtils.isEmpty(i)) {
                            Log.w("DeleteActivity", "Missing appName; skipping handle");
                            return;
                        }
                        String format = String.format(getString(ResourceUtils.m26944a((Context) this, "appdownloader_notification_download_delete")), new Object[]{i});
                        IAppDownloadDepend a = AppDownloader.m26714h().mo31474a();
                        IDownloadAlertDialogBuilder kVar = null;
                        if (a != null) {
                            kVar = a.mo31374a(this);
                        }
                        if (kVar == null) {
                            kVar = new DefaultAlertDialogBuilder(this);
                        }
                        if (kVar != null) {
                            int a2 = ResourceUtils.m26944a((Context) this, "appdownloader_tip");
                            int a3 = ResourceUtils.m26944a((Context) this, "appdownloader_label_ok");
                            kVar.mo31377a(a2).mo31380a(format).mo31378a(a3, new OnClickListener() {
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    IAppDownloadEventHandler b = AppDownloader.m26714h().mo31485b();
                                    if (b != null) {
                                        b.mo31371a(h);
                                    }
                                    IDownloadNotificationEventListener i2 = Downloader.m27478a(C6694b.m27342B()).mo31929i(intExtra);
                                    if (i2 != null) {
                                        String str = "";
                                        i2.mo31500a(10, h, str, str);
                                    }
                                    if (C6694b.m27342B() != null) {
                                        Downloader.m27478a(C6694b.m27342B()).mo31920b(intExtra);
                                    }
                                    DownloadTaskDeleteActivity.this.finish();
                                }
                            }).mo31382b(ResourceUtils.m26944a((Context) this, "appdownloader_label_cancel"), new OnClickListener() {
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    DownloadTaskDeleteActivity.this.finish();
                                }
                            }).mo31379a((OnCancelListener) new OnCancelListener() {
                                public void onCancel(DialogInterface dialogInterface) {
                                    DownloadTaskDeleteActivity.this.finish();
                                }
                            });
                            this.f21653a = kVar.mo31376a();
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
