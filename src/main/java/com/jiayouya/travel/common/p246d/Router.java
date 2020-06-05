package com.jiayouya.travel.common.p246d;

import android.os.Bundle;
import android.text.TextUtils;
import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.p043a.ARouter;
import com.jiayouya.travel.C2835b;
import com.jiayouya.travel.module.web.p291ui.WebActivity;
import kotlin.Metadata;
import kotlin.jvm.internal.C8271i;
import kotlin.text.C8313m;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J+\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u000b¨\u0006\f"}, mo39189d2 = {"Lcom/jiayouya/travel/common/util/Router;", "", "()V", "go", "", "url", "", "bundle", "Landroid/os/Bundle;", "flags", "", "(Ljava/lang/String;Landroid/os/Bundle;Ljava/lang/Integer;)V", "app_grRelease"}, mo39190k = 1, mo39191mv = {1, 1, 15})
/* renamed from: com.jiayouya.travel.common.d.m */
public final class Router {
    /* renamed from: a */
    public static final Router f9644a = new Router();

    private Router() {
    }

    /* renamed from: a */
    public static /* synthetic */ void m12969a(Router mVar, String str, Bundle bundle, Integer num, int i, Object obj) {
        if ((i & 2) != 0) {
            bundle = null;
        }
        if ((i & 4) != 0) {
            num = null;
        }
        mVar.mo19953a(str, bundle, num);
    }

    /* renamed from: a */
    public final void mo19953a(String str, Bundle bundle, Integer num) {
        C8271i.m35386b(str, "url");
        if (!TextUtils.isEmpty(str)) {
            if (C8313m.m35465a(str, "http://", false, 2, null) || C8313m.m35465a(str, "https://", false, 2, null)) {
                WebActivity.f12320d.mo22574a(C2835b.f9544a, str);
            } else {
                try {
                    if (!C8313m.m35465a(str, "/", false, 2, null)) {
                        StringBuilder sb = new StringBuilder();
                        sb.append('/');
                        sb.append(str);
                        str = sb.toString();
                    }
                    Postcard with = ARouter.m2127a().mo10486a(str).with(bundle);
                    if (num != null) {
                        with = with.withFlags(num.intValue());
                    }
                    with.navigation();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
