package com.alibaba.alibclinkpartner.smartlink;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.alibaba.alibclinkpartner.p038a.p039a.ALPCallbackManager;
import com.alibaba.alibclinkpartner.smartlink.data.SafeConfig;
import com.alibaba.alibclinkpartner.smartlink.p040a.p041a.ALSLIntentPoint;
import com.alibaba.alibclinkpartner.smartlink.p042b.ALSLCommonUtils;
import com.alibaba.alibclinkpartner.smartlink.p042b.ALSLLogUtil;
import com.alibaba.alibclinkpartner.smartlink.p042b.ALSLSPUtil;
import java.util.Iterator;

public class ALPEntranceActivity extends Activity {
    /* renamed from: a */
    private boolean m2119a(Intent intent) {
        return intent != null;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        finish();
        Intent intent = getIntent();
        String str = "onCreate";
        String str2 = "ALPEntranceActivity";
        if (!m2119a(intent)) {
            ALSLLogUtil.m2123a(str2, str, " check intent fail,param miss");
            return;
        }
        String stringExtra = intent.getStringExtra("pluginRules");
        if (stringExtra != null && stringExtra.equals("forward")) {
            m2118a(intent, this);
        } else if (stringExtra != null) {
            ALPCallbackManager.m2115a(intent.getStringExtra("sourcePackageName"), stringExtra, intent.getExtras().getInt("resultCode", 0), intent.getExtras());
        } else {
            ALSLLogUtil.m2123a(str2, str, " module is null");
        }
    }

    /* renamed from: a */
    private void m2118a(Intent intent, Activity activity) {
        String str = "ALPEntranceActivity";
        boolean z = false;
        try {
            String a = ALSLCommonUtils.m2121a(activity);
            Iterator it = ((SafeConfig) ALSLSPUtil.m2126b("safe_package_config", new SafeConfig())).getWhiteList().iterator();
            String str2 = null;
            String str3 = null;
            Intent intent2 = null;
            while (true) {
                if (!it.hasNext()) {
                    break;
                } else if (TextUtils.equals((String) it.next(), a)) {
                    intent2 = (Intent) intent.getParcelableExtra("linkIntent");
                    Uri data = intent2.getData();
                    if (data != null) {
                        str2 = (String) ALSLSPUtil.m2125a(a, "");
                        str3 = Uri.parse(str2).getQueryParameter("backURL");
                        if (TextUtils.equals(data.toString(), str3)) {
                            z = true;
                            break;
                        }
                    } else {
                        continue;
                    }
                }
            }
            if (z) {
                m2120b(intent2);
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append("callingPackage = ");
                sb.append(a);
                sb.append("  uri是 = ");
                sb.append(str2);
                sb.append(" backUrl = ");
                sb.append(str3);
                ALSLLogUtil.m2123a(str, "onCreate", sb.toString());
            }
            new ALSLIntentPoint().f2231a.put("intentData", intent.getExtras().toString());
        } catch (Exception e) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(" t=");
            sb2.append(e.toString());
            ALSLLogUtil.m2123a(str, "jumpThird", sb2.toString());
        }
    }

    /* renamed from: b */
    private void m2120b(Intent intent) {
        String str = "startNewActivity";
        String str2 = "ALPEntranceActivity";
        if (intent != null) {
            try {
                startActivity(intent);
                ALSLLogUtil.m2124b(str2, str, "数据一致，startNewActivity");
            } catch (Throwable th) {
                StringBuilder sb = new StringBuilder();
                sb.append("startActivityError t=");
                sb.append(th.toString());
                ALSLLogUtil.m2123a(str2, str, sb.toString());
            }
        }
    }
}
