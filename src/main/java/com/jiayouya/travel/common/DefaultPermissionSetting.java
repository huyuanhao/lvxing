package com.jiayouya.travel.common;

import android.content.Context;
import android.text.TextUtils;
import com.jiayouya.travel.common.p246d.DialogTool;
import com.tencent.p605ep.commonbase.software.AppEntity;
import com.yanzhenjie.permission.AndPermission;
import com.yanzhenjie.permission.runtime.Permission;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.C8271i;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.p679a.C8246a;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J&\u0010\u0005\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u000bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, mo39189d2 = {"Lcom/jiayouya/travel/common/DefaultPermissionSetting;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "showSetting", "", "permissions", "", "", "onCancel", "Lkotlin/Function0;", "app_grRelease"}, mo39190k = 1, mo39191mv = {1, 1, 15})
/* compiled from: DefaultPermissionSetting.kt */
public final class DefaultPermissionSetting {
    /* access modifiers changed from: private|final */
    /* renamed from: a */
    public final Context f9556a;

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo39189d2 = {"<anonymous>", "", "invoke"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: DefaultPermissionSetting.kt */
    /* renamed from: com.jiayouya.travel.common.DefaultPermissionSetting$a */
    static final class C2851a extends Lambda implements C8246a<Unit> {
        final /* synthetic */ C8246a $onCancel;

        C2851a(C8246a aVar) {
            this.$onCancel = aVar;
            super(0);
        }

        public final void invoke() {
            C8246a aVar = this.$onCancel;
            if (aVar != null) {
                Unit jVar = (Unit) aVar.invoke();
            }
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo39189d2 = {"<anonymous>", "", "invoke"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: DefaultPermissionSetting.kt */
    /* renamed from: com.jiayouya.travel.common.DefaultPermissionSetting$b */
    static final class C2852b extends Lambda implements C8246a<Unit> {
        final /* synthetic */ DefaultPermissionSetting this$0;

        C2852b(DefaultPermissionSetting defaultPermissionSetting) {
            this.this$0 = defaultPermissionSetting;
            super(0);
        }

        public final void invoke() {
            AndPermission.m33993a(this.this$0.f9556a).mo38048a().mo38060a().mo38069a(100);
        }
    }

    public DefaultPermissionSetting(Context context) {
        C8271i.m35386b(context, "context");
        this.f9556a = context;
    }

    /* renamed from: a */
    public static /* synthetic */ void m12774a(DefaultPermissionSetting defaultPermissionSetting, List list, C8246a aVar, int i, Object obj) {
        if ((i & 2) != 0) {
            aVar = null;
        }
        defaultPermissionSetting.mo19838a(list, aVar);
    }

    /* renamed from: a */
    public final void mo19838a(List<String> list, C8246a<Unit> aVar) {
        C8271i.m35386b(list, AppEntity.KEY_PERMISSION_STR_ARRAY);
        List a = Permission.m34115a(this.f9556a, list);
        StringBuilder sb = new StringBuilder();
        sb.append("我们需要以下权限，请在设置中为我们开启：\n\n");
        sb.append(TextUtils.join("\n", a));
        String sb2 = sb.toString();
        String str = "去设置";
        DialogTool.m12956a(this.f9556a, "提示", sb2, str, null, new C2852b(this), new C2851a(aVar), 16, null);
    }
}
