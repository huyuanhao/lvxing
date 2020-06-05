package com.jiayouya.travel.common.p246d;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import androidx.appcompat.app.AlertDialog.Builder;
import com.jiayouya.travel.R;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.C8271i;
import kotlin.jvm.p679a.C8246a;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000$\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\\\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00072\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000b2\u0010\b\u0002\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000b¨\u0006\r"}, mo39189d2 = {"showAlert", "", "context", "Landroid/content/Context;", "title", "", "message", "", "okText", "cancelText", "onOkClick", "Lkotlin/Function0;", "onCancelClick", "app_grRelease"}, mo39190k = 2, mo39191mv = {1, 1, 15})
/* renamed from: com.jiayouya.travel.common.d.e */
public final class DialogTool {

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, mo39189d2 = {"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "which", "", "onClick"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: DialogTool.kt */
    /* renamed from: com.jiayouya.travel.common.d.e$a */
    static final class C2896a implements OnClickListener {
        /* renamed from: a */
        final /* synthetic */ C8246a f9633a;

        C2896a(C8246a aVar) {
            this.f9633a = aVar;
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.dismiss();
            C8246a aVar = this.f9633a;
            if (aVar != null) {
                Unit jVar = (Unit) aVar.invoke();
            }
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, mo39189d2 = {"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "which", "", "onClick"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: DialogTool.kt */
    /* renamed from: com.jiayouya.travel.common.d.e$b */
    static final class C2897b implements OnClickListener {
        /* renamed from: a */
        final /* synthetic */ C8246a f9634a;

        C2897b(C8246a aVar) {
            this.f9634a = aVar;
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.dismiss();
            C8246a aVar = this.f9634a;
            if (aVar != null) {
                Unit jVar = (Unit) aVar.invoke();
            }
        }
    }

    /* renamed from: a */
    public static /* synthetic */ void m12956a(Context context, CharSequence charSequence, String str, String str2, String str3, C8246a aVar, C8246a aVar2, int i, Object obj) {
        if ((i & 8) != 0) {
            str2 = "确定";
        }
        String str4 = str2;
        if ((i & 16) != 0) {
            str3 = "取消";
        }
        String str5 = str3;
        if ((i & 32) != 0) {
            aVar = null;
        }
        C8246a aVar3 = aVar;
        if ((i & 64) != 0) {
            aVar2 = null;
        }
        m12955a(context, charSequence, str, str4, str5, aVar3, aVar2);
    }

    /* renamed from: a */
    public static final void m12955a(Context context, CharSequence charSequence, String str, String str2, String str3, C8246a<Unit> aVar, C8246a<Unit> aVar2) {
        C8271i.m35386b(context, "context");
        C8271i.m35386b(str, "message");
        new Builder(context, R.style.App_Dialog).setTitle(charSequence).setMessage((CharSequence) str).setPositiveButton((CharSequence) str2, (OnClickListener) new C2896a(aVar)).setNegativeButton((CharSequence) str3, (OnClickListener) new C2897b(aVar2)).show();
    }
}
