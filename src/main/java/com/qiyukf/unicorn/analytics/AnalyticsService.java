package com.qiyukf.unicorn.analytics;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.qiyukf.basesdk.p393a.C5264a;
import com.qiyukf.basesdk.p412c.p417d.C5411c;
import com.qiyukf.basesdk.p412c.p417d.C5413e;

public class AnalyticsService extends IntentService {
    public AnalyticsService() {
        super(C5973a.f18807a);
    }

    /* renamed from: a */
    private void m23879a() {
        if (C5411c.m22139f(this)) {
            C5979c.m23907a();
        }
    }

    /* renamed from: a */
    public static void m23880a(Context context) {
        Intent intent = new Intent(context, AnalyticsService.class);
        intent.setAction("com.qiyukf.action.AUTO_UPLOAD");
        C5413e.m22153a(context, intent);
        C5264a.m21617a(C5973a.f18807a, "try to upload log");
    }

    /* renamed from: a */
    public static void m23881a(Context context, Throwable th, C5977b bVar) {
        Intent intent = new Intent(context, AnalyticsService.class);
        intent.setAction("com.qiyukf.action.AUTO_ERROR");
        intent.putExtra("com.qiyukf.extra.ERROR_MESSAGE", th);
        intent.putExtra("com.qiyukf.extra.ERROR_TYPE", bVar);
        C5413e.m22153a(context, intent);
        C5264a.m21617a(C5973a.f18807a, "try to save error log");
    }

    /* access modifiers changed from: protected */
    public void onHandleIntent(Intent intent) {
        if (intent != null) {
            try {
                if (!TextUtils.isEmpty(intent.getAction())) {
                    if (!C5973a.m23886a()) {
                        C5264a.m21626e(C5973a.f18807a, "Analytics not init");
                    } else if (C5978b.m23898a()) {
                        if (TextUtils.equals(intent.getAction(), "com.qiyukf.action.AUTO_ERROR")) {
                            C5973a.m23885a((Throwable) intent.getSerializableExtra("com.qiyukf.extra.ERROR_MESSAGE"), (C5977b) intent.getSerializableExtra("com.qiyukf.extra.ERROR_TYPE"));
                            m23879a();
                            return;
                        }
                        if (TextUtils.equals(intent.getAction(), "com.qiyukf.action.AUTO_UPLOAD")) {
                            m23879a();
                        }
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }
}
