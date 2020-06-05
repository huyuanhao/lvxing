package com.p530ss.android.downloadlib.p547c;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import com.p530ss.android.downloadlib.p541a.C6565j;
import com.p530ss.android.downloadlib.p549e.TLogger;
import com.p530ss.android.p531a.p532a.p536c.DownloadAlertDialogInfo.C6516a;
import com.p530ss.android.p531a.p532a.p536c.DownloadAlertDialogInfo.C6517b;
import com.p530ss.android.socialbase.appdownloader.p552c.AbsAppDownloadDepend;
import com.p530ss.android.socialbase.appdownloader.p552c.IDownloadAlertDialog;
import com.p530ss.android.socialbase.appdownloader.p552c.IDownloadAlertDialogBuilder;

/* renamed from: com.ss.android.downloadlib.c.c */
public class NewDownloadDepend extends AbsAppDownloadDepend {
    /* access modifiers changed from: private|static */
    /* renamed from: a */
    public static String f21412a = NewDownloadDepend.class.getSimpleName();

    /* compiled from: NewDownloadDepend */
    /* renamed from: com.ss.android.downloadlib.c.c$a */
    private static class C6575a implements IDownloadAlertDialog {
        /* renamed from: a */
        private Dialog f21420a;

        public C6575a(Dialog dialog) {
            if (dialog != null) {
                this.f21420a = dialog;
                mo31383a();
            }
        }

        /* renamed from: a */
        public void mo31383a() {
            Dialog dialog = this.f21420a;
            if (dialog != null) {
                dialog.show();
            }
        }

        /* renamed from: b */
        public boolean mo31384b() {
            Dialog dialog = this.f21420a;
            if (dialog != null) {
                return dialog.isShowing();
            }
            return false;
        }
    }

    /* renamed from: a */
    public boolean mo31375a() {
        return true;
    }

    /* renamed from: a */
    public IDownloadAlertDialogBuilder mo31374a(final Context context) {
        return new IDownloadAlertDialogBuilder() {
            /* renamed from: c */
            private C6516a f21415c = new C6516a(context);
            /* access modifiers changed from: private */
            /* renamed from: d */
            public OnClickListener f21416d;
            /* access modifiers changed from: private */
            /* renamed from: e */
            public OnClickListener f21417e;
            /* access modifiers changed from: private */
            /* renamed from: f */
            public OnCancelListener f21418f;

            /* renamed from: a */
            public IDownloadAlertDialogBuilder mo31377a(int i) {
                this.f21415c.mo31110a(context.getResources().getString(i));
                return this;
            }

            /* renamed from: a */
            public IDownloadAlertDialogBuilder mo31380a(String str) {
                this.f21415c.mo31113b(str);
                return this;
            }

            /* renamed from: a */
            public IDownloadAlertDialogBuilder mo31378a(int i, OnClickListener onClickListener) {
                this.f21415c.mo31114c(context.getResources().getString(i));
                this.f21416d = onClickListener;
                return this;
            }

            /* renamed from: b */
            public IDownloadAlertDialogBuilder mo31382b(int i, OnClickListener onClickListener) {
                this.f21415c.mo31115d(context.getResources().getString(i));
                this.f21417e = onClickListener;
                return this;
            }

            /* renamed from: a */
            public IDownloadAlertDialogBuilder mo31379a(OnCancelListener onCancelListener) {
                this.f21418f = onCancelListener;
                return this;
            }

            /* renamed from: a */
            public IDownloadAlertDialogBuilder mo31381a(boolean z) {
                this.f21415c.mo31111a(z);
                return this;
            }

            /* renamed from: a */
            public IDownloadAlertDialog mo31376a() {
                this.f21415c.mo31109a((C6517b) new C6517b() {
                    /* renamed from: a */
                    public void mo31116a(DialogInterface dialogInterface) {
                        if (C65731.this.f21416d != null) {
                            C65731.this.f21416d.onClick(dialogInterface, -1);
                        }
                    }

                    /* renamed from: b */
                    public void mo31117b(DialogInterface dialogInterface) {
                        if (C65731.this.f21417e != null) {
                            C65731.this.f21417e.onClick(dialogInterface, -2);
                        }
                    }

                    /* renamed from: c */
                    public void mo31118c(DialogInterface dialogInterface) {
                        if (C65731.this.f21418f != null && dialogInterface != null) {
                            C65731.this.f21418f.onCancel(dialogInterface);
                        }
                    }
                });
                TLogger.m26504a(NewDownloadDepend.f21412a, "getThemedAlertDlgBuilder", null);
                this.f21415c.mo31107a(3);
                return new C6575a(C6565j.m26370d().mo16488b(this.f21415c.mo31112a()));
            }
        };
    }
}
