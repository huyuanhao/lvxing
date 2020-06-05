package com.bytedance.sdk.openadsdk.downloadnew.p181a.p182a;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.widget.Toast;
import com.bytedance.sdk.openadsdk.core.widget.InstallDialog;
import com.bytedance.sdk.openadsdk.core.widget.InstallDialog.C2360a;
import com.bytedance.sdk.openadsdk.utils.CommonDialogHelper;
import com.bytedance.sdk.openadsdk.utils.CommonDialogHelper.C2550a;
import com.bytedance.sdk.openadsdk.utils.ResourceHelp;
import com.p530ss.android.p531a.p532a.p533a.DownloadUIFactory;
import com.p530ss.android.p531a.p532a.p534b.C6507c;
import com.p530ss.android.p531a.p532a.p536c.DownloadAlertDialogInfo;
import java.lang.ref.WeakReference;

/* renamed from: com.bytedance.sdk.openadsdk.downloadnew.a.a.f */
public class LibUIFactory implements DownloadUIFactory {
    /* renamed from: a */
    private final WeakReference<Context> f8549a;
    /* renamed from: b */
    private String f8550b = "已开始下载，可在\"我的\"里查看管理";

    /* compiled from: LibUIFactory */
    /* renamed from: com.bytedance.sdk.openadsdk.downloadnew.a.a.f$a */
    class C2406a implements DialogInterface {
        public void cancel() {
        }

        public void dismiss() {
        }

        C2406a() {
        }
    }

    public LibUIFactory(Context context) {
        this.f8549a = new WeakReference<>(context);
    }

    /* renamed from: a */
    public void mo16487a(int i, Context context, C6507c cVar, String str, Drawable drawable, int i2) {
        if (!TextUtils.isEmpty(this.f8550b) && this.f8550b.equals(str)) {
            str = "已开始下载";
        }
        Toast.makeText(context, str, 0).show();
    }

    /* renamed from: a */
    public AlertDialog mo16488b(DownloadAlertDialogInfo cVar) {
        if (cVar == null) {
            return null;
        }
        if (cVar.f21054a != null && (cVar.f21054a instanceof Activity)) {
            return m11102a((Activity) cVar.f21054a, cVar);
        }
        m11104c(cVar);
        return null;
    }

    /* renamed from: a */
    private AlertDialog m11102a(Activity activity, final DownloadAlertDialogInfo cVar) {
        if (cVar.f21063j == 1) {
            AlertDialog b = m11103b(activity, cVar);
            b.show();
            return b;
        }
        Builder onCancelListener = new Builder(activity, ResourceHelp.m11937g(activity, VERSION.SDK_INT >= 21 ? "Theme.Dialog.TTDownload" : "Theme.Dialog.TTDownloadOld")).setTitle(cVar.f21055b).setMessage(cVar.f21056c).setPositiveButton(cVar.f21057d, new OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                if (cVar.f21061h != null) {
                    cVar.f21061h.mo31116a(dialogInterface);
                }
            }
        }).setNegativeButton(cVar.f21058e, new OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                if (cVar.f21061h != null) {
                    cVar.f21061h.mo31117b(dialogInterface);
                }
            }
        }).setOnCancelListener(new OnCancelListener() {
            public void onCancel(DialogInterface dialogInterface) {
                if (cVar.f21061h != null) {
                    cVar.f21061h.mo31118c(dialogInterface);
                }
            }
        });
        if (cVar.f21060g != null) {
            onCancelListener.setIcon(cVar.f21060g);
        }
        AlertDialog create = onCancelListener.create();
        create.show();
        return create;
    }

    /* renamed from: b */
    private AlertDialog m11103b(Activity activity, final DownloadAlertDialogInfo cVar) {
        return new InstallDialog(activity).mo16297a(cVar.f21055b).mo16298b(cVar.f21056c).mo16299c(cVar.f21057d).mo16300d(cVar.f21058e).mo16295a(cVar.f21060g).mo16296a((C2360a) new C2360a() {
            /* renamed from: a */
            public void mo14893a(Dialog dialog) {
                if (cVar.f21061h != null) {
                    cVar.f21061h.mo31116a(dialog);
                }
            }

            /* renamed from: b */
            public void mo14894b(Dialog dialog) {
                if (cVar.f21061h != null) {
                    cVar.f21061h.mo31117b(dialog);
                }
            }
        }).mo16294a((OnCancelListener) new OnCancelListener() {
            public void onCancel(DialogInterface dialogInterface) {
                if (cVar.f21061h != null) {
                    cVar.f21061h.mo31118c(dialogInterface);
                }
            }
        });
    }

    /* renamed from: c */
    private void m11104c(final DownloadAlertDialogInfo cVar) {
        C24056 r5 = new C2550a() {
            /* renamed from: a */
            public void mo16493a() {
                if (cVar.f21061h != null) {
                    cVar.f21061h.mo31116a(new C2406a());
                }
            }

            /* renamed from: b */
            public void mo16494b() {
                if (cVar.f21061h != null) {
                    cVar.f21061h.mo31117b(new C2406a());
                }
            }

            /* renamed from: c */
            public void mo16495c() {
                if (cVar.f21061h != null) {
                    cVar.f21061h.mo31118c(new C2406a());
                }
            }
        };
        if (cVar.f21063j == 1) {
            CommonDialogHelper.m12144a(String.valueOf(cVar.hashCode()), cVar.f21055b, cVar.f21056c, cVar.f21057d, cVar.f21058e, r5);
        } else {
            CommonDialogHelper.m12143a(String.valueOf(cVar.hashCode()), cVar.f21055b, cVar.f21056c, r5);
        }
    }
}
