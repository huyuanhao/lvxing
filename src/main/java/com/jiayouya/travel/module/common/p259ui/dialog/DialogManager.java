package com.jiayouya.travel.module.common.p259ui.dialog;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.jiayouya.travel.common.p245c.PreferenceRes;
import kotlin.C8182c;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.C8271i;
import kotlin.jvm.internal.C8272k;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.PropertyReference1;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.p679a.C8246a;
import kotlin.reflect.C8280j;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0004\u0018\u0000 \u00112\u00020\u0001:\u0002\u0011\u0012B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0004J\u0014\u0010\u000b\u001a\u00020\f2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00040\u000fJ\u0006\u0010\u0010\u001a\u00020\fR\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\b¨\u0006\u0013"}, mo39189d2 = {"Lcom/jiayouya/travel/module/common/ui/dialog/DialogManager;", "", "()V", "curDialog", "Landroid/app/Dialog;", "queue", "Lcom/jiayouya/travel/module/common/ui/dialog/DialogQueue;", "getQueue", "()Lcom/jiayouya/travel/module/common/ui/dialog/DialogQueue;", "queue$delegate", "Lkotlin/Lazy;", "addDialog", "", "dialog", "list", "", "show", "Companion", "Holder", "app_grRelease"}, mo39190k = 1, mo39191mv = {1, 1, 15})
/* renamed from: com.jiayouya.travel.module.common.ui.dialog.a */
public final class DialogManager {
    /* renamed from: a */
    static final /* synthetic */ C8280j[] f11299a = {C8272k.m35400a((PropertyReference1) new PropertyReference1Impl(C8272k.m35394a(DialogManager.class), "queue", "getQueue()Lcom/jiayouya/travel/module/common/ui/dialog/DialogQueue;"))};
    /* renamed from: b */
    public static final C2963a f11300b = new C2963a(null);
    /* renamed from: c */
    private final Lazy f11301c;
    /* access modifiers changed from: private */
    /* renamed from: d */
    public Dialog f11302d;

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"}, mo39189d2 = {"Lcom/jiayouya/travel/module/common/ui/dialog/DialogManager$Companion;", "", "()V", "getInstance", "Lcom/jiayouya/travel/module/common/ui/dialog/DialogManager;", "app_grRelease"}, mo39190k = 1, mo39191mv = {1, 1, 15})
    /* compiled from: DialogManager.kt */
    /* renamed from: com.jiayouya.travel.module.common.ui.dialog.a$a */
    public static final class C2963a {
        private C2963a() {
        }

        public /* synthetic */ C2963a(DefaultConstructorMarker fVar) {
            this();
        }

        /* renamed from: a */
        public final DialogManager mo20713a() {
            return C2964b.f11304b.mo20714a();
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bÂ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001b\u0010\u0003\u001a\u00020\u00048FX\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, mo39189d2 = {"Lcom/jiayouya/travel/module/common/ui/dialog/DialogManager$Holder;", "", "()V", "instance", "Lcom/jiayouya/travel/module/common/ui/dialog/DialogManager;", "getInstance", "()Lcom/jiayouya/travel/module/common/ui/dialog/DialogManager;", "instance$delegate", "Lkotlin/Lazy;", "app_grRelease"}, mo39190k = 1, mo39191mv = {1, 1, 15})
    /* compiled from: DialogManager.kt */
    /* renamed from: com.jiayouya.travel.module.common.ui.dialog.a$b */
    private static final class C2964b {
        /* renamed from: a */
        static final /* synthetic */ C8280j[] f11303a = {C8272k.m35400a((PropertyReference1) new PropertyReference1Impl(C8272k.m35394a(C2964b.class), "instance", "getInstance()Lcom/jiayouya/travel/module/common/ui/dialog/DialogManager;"))};
        /* renamed from: b */
        public static final C2964b f11304b = new C2964b();
        /* renamed from: c */
        private static final Lazy f11305c = C8182c.m35317a(C2965a.INSTANCE);

        @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo39189d2 = {"<anonymous>", "Lcom/jiayouya/travel/module/common/ui/dialog/DialogManager;", "invoke"}, mo39190k = 3, mo39191mv = {1, 1, 15})
        /* compiled from: DialogManager.kt */
        /* renamed from: com.jiayouya.travel.module.common.ui.dialog.a$b$a */
        static final class C2965a extends Lambda implements C8246a<DialogManager> {
            public static final C2965a INSTANCE = new C2965a();

            C2965a() {
                super(0);
            }

            public final DialogManager invoke() {
                return new DialogManager(null);
            }
        }

        /* renamed from: a */
        public final DialogManager mo20714a() {
            Lazy bVar = f11305c;
            C8280j jVar = f11303a[0];
            return (DialogManager) bVar.getValue();
        }

        private C2964b() {
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo39189d2 = {"<anonymous>", "Lcom/jiayouya/travel/module/common/ui/dialog/DialogQueue;", "invoke"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: DialogManager.kt */
    /* renamed from: com.jiayouya.travel.module.common.ui.dialog.a$c */
    static final class C2966c extends Lambda implements C8246a<DialogQueue> {
        public static final C2966c INSTANCE = new C2966c();

        C2966c() {
            super(0);
        }

        public final DialogQueue invoke() {
            return new DialogQueue();
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo39189d2 = {"<anonymous>", "", "it", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onDismiss"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: DialogManager.kt */
    /* renamed from: com.jiayouya.travel.module.common.ui.dialog.a$d */
    static final class C2967d implements OnDismissListener {
        /* renamed from: a */
        final /* synthetic */ DialogManager f11306a;

        C2967d(DialogManager aVar) {
            this.f11306a = aVar;
        }

        public final void onDismiss(DialogInterface dialogInterface) {
            this.f11306a.f11302d = null;
            this.f11306a.mo20711a();
        }
    }

    /* renamed from: b */
    private final DialogQueue m13566b() {
        Lazy bVar = this.f11301c;
        C8280j jVar = f11299a[0];
        return (DialogQueue) bVar.getValue();
    }

    private DialogManager() {
        this.f11301c = C8182c.m35317a(C2966c.INSTANCE);
    }

    public /* synthetic */ DialogManager(DefaultConstructorMarker fVar) {
        this();
    }

    /* renamed from: a */
    public final void mo20712a(Dialog dialog) {
        C8271i.m35386b(dialog, "dialog");
        m13566b().mo20717a(dialog);
    }

    /* renamed from: a */
    public final void mo20711a() {
        if (PreferenceRes.f9605b.mo19928d() && this.f11302d == null) {
            this.f11302d = m13566b().mo20716a();
            Dialog dialog = this.f11302d;
            if (dialog != null) {
                dialog.setOnDismissListener(new C2967d(this));
            }
            Dialog dialog2 = this.f11302d;
            if (dialog2 != null) {
                dialog2.show();
            }
        }
    }
}
