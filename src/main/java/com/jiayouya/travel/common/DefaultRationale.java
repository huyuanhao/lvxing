package com.jiayouya.travel.common;

import android.content.Context;
import android.text.TextUtils;
import com.elvishew.xlog.XLog;
import com.jiayouya.travel.common.p246d.DialogTool;
import com.tencent.p605ep.commonbase.software.AppEntity;
import com.yanzhenjie.permission.C7837e;
import com.yanzhenjie.permission.Rationale;
import com.yanzhenjie.permission.runtime.Permission;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.C8271i;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.p679a.C8246a;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001B\u0017\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\u0002\u0010\u0007J&\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\f\u001a\u00020\rH\u0016R\u0016\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, mo39189d2 = {"Lcom/jiayouya/travel/common/DefaultRationale;", "Lcom/yanzhenjie/permission/Rationale;", "", "", "onCancel", "Lkotlin/Function0;", "", "(Lkotlin/jvm/functions/Function0;)V", "showRationale", "context", "Landroid/content/Context;", "permissions", "executor", "Lcom/yanzhenjie/permission/RequestExecutor;", "app_grRelease"}, mo39190k = 1, mo39191mv = {1, 1, 15})
/* renamed from: com.jiayouya.travel.common.b */
public final class DefaultRationale implements Rationale<List<? extends String>> {
    /* access modifiers changed from: private|final */
    /* renamed from: a */
    public final C8246a<Unit> f9563a;

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo39189d2 = {"<anonymous>", "", "invoke"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: DefaultRationale.kt */
    /* renamed from: com.jiayouya.travel.common.b$a */
    static final class C2856a extends Lambda implements C8246a<Unit> {
        final /* synthetic */ C7837e $executor;

        C2856a(C7837e eVar) {
            this.$executor = eVar;
            super(0);
        }

        public final void invoke() {
            this.$executor.mo38051a();
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo39189d2 = {"<anonymous>", "", "invoke"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: DefaultRationale.kt */
    /* renamed from: com.jiayouya.travel.common.b$b */
    static final class C2857b extends Lambda implements C8246a<Unit> {
        final /* synthetic */ C7837e $executor;
        final /* synthetic */ DefaultRationale this$0;

        C2857b(DefaultRationale bVar, C7837e eVar) {
            this.this$0 = bVar;
            this.$executor = eVar;
            super(0);
        }

        public final void invoke() {
            C8246a a = this.this$0.f9563a;
            if (a != null) {
                Unit jVar = (Unit) a.invoke();
            }
            this.$executor.mo38052b();
        }
    }

    public DefaultRationale() {
        this(null, 1, null);
    }

    public DefaultRationale(C8246a<Unit> aVar) {
        this.f9563a = aVar;
    }

    public /* synthetic */ DefaultRationale(C8246a aVar, int i, DefaultConstructorMarker fVar) {
        if ((i & 1) != 0) {
            aVar = null;
        }
        this(aVar);
    }

    /* renamed from: a */
    public void mo19846a(Context context, List<String> list, C7837e eVar) {
        C8271i.m35386b(context, "context");
        C8271i.m35386b(list, AppEntity.KEY_PERMISSION_STR_ARRAY);
        C8271i.m35386b(eVar, "executor");
        XLog.m12691a("showRationale");
        List a = Permission.m34115a(context, list);
        StringBuilder sb = new StringBuilder();
        sb.append("需要允许以下权限以便程序继续执行：\n\n");
        sb.append(TextUtils.join("\n", a));
        Context context2 = context;
        DialogTool.m12956a(context2, "提示", sb.toString(), "继续", null, new C2856a(eVar), new C2857b(this, eVar), 16, null);
    }
}
