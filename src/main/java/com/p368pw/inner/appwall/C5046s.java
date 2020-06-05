package com.p368pw.inner.appwall;

import android.app.Activity;
import com.p368pw.inner.appwall.C4983ad.C4986a;
import com.p368pw.inner.appwall.C5048u.C5051a;
import java.util.Locale;

/* renamed from: com.pw.inner.appwall.s */
public class C5046s {
    /* renamed from: a */
    public static C4983ad m21063a(Activity activity, double d, int i, boolean z, C5047t tVar) {
        double appWallOpenCoin = (tVar == null || tVar.mo26540b() != 2) ? C4970aa.m20784a().mo26332d().getAppWallOpenCoin() : tVar.mo26542d().mo26469d().mo26479a(C4970aa.m20784a().mo26333e());
        boolean e = C4970aa.m20784a().mo26333e();
        return new C4986a(activity).mo26368c(String.format(Locale.getDefault(), "%s 马上领取奖励", new Object[]{C4970aa.m20787a(e, appWallOpenCoin)})).mo26361a(d).mo26365a(z).mo26363a(tVar).mo26364a(z ? "你已经签到过了，继续完成其他任务，马上领取更多奖励！" : "恭喜你获得奖励！").mo26367b(C4970aa.m20787a(e, d)).mo26362a(i).mo26366a();
    }

    /* renamed from: a */
    public static C5048u m21064a(Activity activity, String str, double d, int i) {
        String a = C4970aa.m20787a(C4970aa.m20784a().mo26333e(), d);
        return new C5051a(activity).mo26550a(str).mo26552b(String.format(Locale.getDefault(), "%s 马上领取奖励", new Object[]{a})).mo26549a(i).mo26551a();
    }
}
