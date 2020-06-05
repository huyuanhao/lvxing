package com.jiayouya.travel.module.common.p259ui.dialog;

import android.app.Dialog;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.jvm.internal.C8271i;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0005J\b\u0010\t\u001a\u0004\u0018\u00010\u0005R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, mo39189d2 = {"Lcom/jiayouya/travel/module/common/ui/dialog/DialogQueue;", "", "()V", "queue", "Ljava/util/LinkedList;", "Landroid/app/Dialog;", "offer", "", "dialog", "poll", "app_grRelease"}, mo39190k = 1, mo39191mv = {1, 1, 15})
/* renamed from: com.jiayouya.travel.module.common.ui.dialog.b */
public final class DialogQueue {
    /* renamed from: a */
    private final LinkedList<Dialog> f11307a = new LinkedList<>();

    /* renamed from: a */
    public final void mo20717a(Dialog dialog) {
        C8271i.m35386b(dialog, "dialog");
        this.f11307a.offer(dialog);
    }

    /* renamed from: a */
    public final Dialog mo20716a() {
        return (Dialog) this.f11307a.poll();
    }
}
