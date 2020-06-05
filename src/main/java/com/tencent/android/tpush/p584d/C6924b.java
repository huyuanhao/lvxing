package com.tencent.android.tpush.p584d;

import android.content.Context;
import android.content.Intent;
import com.tencent.android.tpush.XGPushConfig;
import com.tencent.android.tpush.common.C6901c;
import com.tencent.android.tpush.common.C6914l;
import com.tencent.android.tpush.common.Constants;
import com.tencent.android.tpush.encrypt.Rijndael;
import com.tencent.android.tpush.p580b.C6864a;

/* compiled from: ProGuard */
/* renamed from: com.tencent.android.tpush.d.b */
public class C6924b {
    /* renamed from: a */
    public static void m29561a(final Context context) {
        if (context == null) {
            C6864a.m29309j(Constants.OTHER_PUSH_TAG, "updateToken Error: context is null");
        } else {
            C6901c.m29459a().mo33104a((Runnable) new Runnable() {
                public void run() {
                    C6924b.m29563c(context);
                }
            });
        }
    }

    /* access modifiers changed from: private|static */
    /* renamed from: c */
    public static void m29563c(Context context) {
        String token = XGPushConfig.getToken(context);
        String str = Constants.OTHER_PUSH_TAG;
        if (token == null) {
            C6864a.m29309j(str, "updateToken Error: get XG Token is null");
            return;
        }
        long accessId = XGPushConfig.getAccessId(context);
        String f = C6927d.m29569a(context).mo33136f();
        String d = C6927d.m29569a(context).mo33135d();
        StringBuilder sb = new StringBuilder();
        sb.append("other push token is : ");
        sb.append(d);
        sb.append(" other push type: ");
        sb.append(f);
        C6864a.m29305f(str, sb.toString());
        if (C6914l.m29521c(f) || C6914l.m29521c(d)) {
            C6864a.m29307h(str, "updateToken Error: get otherPushType or otherPushToken is null");
            return;
        }
        Intent intent = new Intent("com.tencent.android.tpush.action.UPDATE_OTHER_PUSH_TOKEN.V4");
        StringBuilder sb2 = new StringBuilder();
        sb2.append("");
        sb2.append(accessId);
        intent.putExtra("accId", Rijndael.encrypt(sb2.toString()));
        intent.putExtra("token", Rijndael.encrypt(token));
        intent.putExtra("other_push_type", Rijndael.encrypt(f));
        intent.putExtra(Constants.OTHER_PUSH_TOKEN, Rijndael.encrypt(d));
        context.sendBroadcast(intent);
    }
}
