package com.p530ss.android.socialbase.appdownloader.p553d;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import com.p530ss.android.socialbase.appdownloader.p552c.AbsDownloadAlertDialogBuilder;
import com.p530ss.android.socialbase.appdownloader.p552c.IDownloadAlertDialog;
import com.p530ss.android.socialbase.appdownloader.p552c.IDownloadAlertDialogBuilder;

/* renamed from: com.ss.android.socialbase.appdownloader.d.a */
public class DefaultAlertDialogBuilder extends AbsDownloadAlertDialogBuilder {
    /* renamed from: a */
    private Builder f21534a;

    /* compiled from: DefaultAlertDialogBuilder */
    /* renamed from: com.ss.android.socialbase.appdownloader.d.a$a */
    private static class C6616a implements IDownloadAlertDialog {
        /* renamed from: a */
        private AlertDialog f21535a;

        public C6616a(Builder builder) {
            if (builder != null) {
                this.f21535a = builder.show();
            }
        }

        /* renamed from: a */
        public void mo31383a() {
            AlertDialog alertDialog = this.f21535a;
            if (alertDialog != null) {
                alertDialog.show();
            }
        }

        /* renamed from: b */
        public boolean mo31384b() {
            AlertDialog alertDialog = this.f21535a;
            if (alertDialog != null) {
                return alertDialog.isShowing();
            }
            return false;
        }
    }

    public DefaultAlertDialogBuilder(Context context) {
        this.f21534a = new Builder(context);
    }

    /* renamed from: a */
    public IDownloadAlertDialogBuilder mo31377a(int i) {
        Builder builder = this.f21534a;
        if (builder != null) {
            builder.setTitle(i);
        }
        return this;
    }

    /* renamed from: a */
    public IDownloadAlertDialogBuilder mo31380a(String str) {
        Builder builder = this.f21534a;
        if (builder != null) {
            builder.setMessage(str);
        }
        return this;
    }

    /* renamed from: a */
    public IDownloadAlertDialogBuilder mo31378a(int i, OnClickListener onClickListener) {
        Builder builder = this.f21534a;
        if (builder != null) {
            builder.setPositiveButton(i, onClickListener);
        }
        return this;
    }

    /* renamed from: b */
    public IDownloadAlertDialogBuilder mo31382b(int i, OnClickListener onClickListener) {
        Builder builder = this.f21534a;
        if (builder != null) {
            builder.setNegativeButton(i, onClickListener);
        }
        return this;
    }

    /* renamed from: a */
    public IDownloadAlertDialogBuilder mo31379a(OnCancelListener onCancelListener) {
        Builder builder = this.f21534a;
        if (builder != null) {
            builder.setOnCancelListener(onCancelListener);
        }
        return this;
    }

    /* renamed from: a */
    public IDownloadAlertDialog mo31376a() {
        return new C6616a(this.f21534a);
    }
}
