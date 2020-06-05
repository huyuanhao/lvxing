package com.jiayouya.travel.common.p246d;

import android.content.Intent;
import com.elvishew.xlog.XLog;
import com.jiayouya.travel.C2835b;
import com.jiayouya.travel.common.p245c.PreferenceRes;
import com.jiayouya.travel.module.common.data.InviteConfirm;
import com.jiayouya.travel.module.common.p257a.C2962j;
import com.jiayouya.travel.module.common.p260vm.ResidentMemoryModel;
import ezy.app.p643a.API;
import kotlin.Metadata;
import p655io.reactivex.p664d.Consumer;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0006\u0010\u0000\u001a\u00020\u0001\u001a\u0010\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u001a\u0012\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0002\u001a\u0010\u0010\b\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\u0005H\u0003¨\u0006\n"}, mo39189d2 = {"getInviteCode", "", "intent", "Landroid/content/Intent;", "parseData", "", "appData", "Lcom/fm/openinstall/model/AppData;", "processInviteCode", "code", "app_grRelease"}, mo39190k = 2, mo39191mv = {1, 1, 15})
/* renamed from: com.jiayouya.travel.common.d.i */
public final class InviteCodeUtil {

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo39189d2 = {"<anonymous>", "", "it", "Lcom/jiayouya/travel/module/common/data/InviteConfirm;", "kotlin.jvm.PlatformType", "accept"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: InviteCodeUtil.kt */
    /* renamed from: com.jiayouya.travel.common.d.i$a */
    static final class C2899a<T> implements Consumer<InviteConfirm> {
        /* renamed from: a */
        public static final C2899a f9636a = new C2899a();

        C2899a() {
        }

        /* renamed from: a */
        public final void accept(InviteConfirm inviteConfirm) {
            if (inviteConfirm.getStatus() == 0) {
                ResidentMemoryModel.f11323a.mo20738c().postValue(Boolean.valueOf(true));
            }
        }
    }

    /* renamed from: a */
    public static final void m12963a() {
        String a = ClipboardUtil.m12951a(C2835b.f9544a);
        if (!RegexUtil.m12968a(a)) {
            a = "";
        }
        if (PreferenceRes.f9605b.mo19924b().isUseLocal()) {
            m12965a(a);
        }
    }

    /* renamed from: a */
    public static final void m12964a(Intent intent) {
        if (PreferenceRes.f9605b.mo19924b().isUseLocal()) {
        }
    }

    /* renamed from: a */
    private static final void m12965a(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("code===");
        sb.append(str);
        XLog.m12692b(sb.toString());
        C2962j.m13561a(API.f27251a).mo20431e(str).mo38904c((Consumer<? super T>) C2899a.f9636a);
    }
}
