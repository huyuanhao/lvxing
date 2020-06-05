package com.p530ss.android.downloadlib.p546b;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.graphics.drawable.Drawable;
import android.widget.Toast;
import com.p530ss.android.p531a.p532a.p533a.DownloadUIFactory;
import com.p530ss.android.p531a.p532a.p534b.C6507c;
import com.p530ss.android.p531a.p532a.p536c.DownloadAlertDialogInfo;

/* renamed from: com.ss.android.downloadlib.b.a */
public class DefaultDownloadUIFactory implements DownloadUIFactory {
    /* renamed from: a */
    public void mo16487a(int i, Context context, C6507c cVar, String str, Drawable drawable, int i2) {
        Toast.makeText(context, str, 0).show();
    }

    /* renamed from: b */
    public Dialog mo16488b(DownloadAlertDialogInfo cVar) {
        return m26405a(cVar);
    }

    /* renamed from: a */
    private static Dialog m26405a(final DownloadAlertDialogInfo cVar) {
        if (cVar == null) {
            return null;
        }
        AlertDialog show = new Builder(cVar.f21054a).setTitle(cVar.f21055b).setMessage(cVar.f21056c).setPositiveButton(cVar.f21057d, new OnClickListener() {
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
        }).show();
        show.setCanceledOnTouchOutside(cVar.f21059f);
        show.setOnCancelListener(new OnCancelListener() {
            public void onCancel(DialogInterface dialogInterface) {
                if (cVar.f21061h != null) {
                    cVar.f21061h.mo31118c(dialogInterface);
                }
            }
        });
        if (cVar.f21060g != null) {
            show.setIcon(cVar.f21060g);
        }
        return show;
    }
}
