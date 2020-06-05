package com.alipay.sdk.app;

import android.app.Activity;
import android.content.res.Configuration;
import android.os.Bundle;
import com.alipay.sdk.app.statistic.C1505a;
import com.alipay.sdk.util.C1542e;
import com.alipay.sdk.util.C1553o;
import com.alipay.sdk.widget.C1566g;
import com.alipay.sdk.widget.C1567h;
import com.alipay.sdk.widget.C1569j;
import com.p522qq.p523e.comm.constants.Constants.KEYS;
import com.tencent.p605ep.commonbase.software.AppEntity;

public class H5PayActivity extends Activity {
    /* renamed from: a */
    private C1566g f3794a;
    /* renamed from: b */
    private String f3795b;
    /* renamed from: c */
    private String f3796c;
    /* renamed from: d */
    private String f3797d;
    /* renamed from: e */
    private String f3798e;
    /* renamed from: f */
    private boolean f3799f;
    /* renamed from: g */
    private String f3800g;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        m4397b();
        super.onCreate(bundle);
        try {
            Bundle extras = getIntent().getExtras();
            this.f3795b = extras.getString("url", null);
            if (!C1553o.m4694f(this.f3795b)) {
                finish();
                return;
            }
            this.f3797d = extras.getString("cookie", null);
            this.f3796c = extras.getString("method", null);
            this.f3798e = extras.getString("title", null);
            this.f3800g = extras.getString(AppEntity.KEY_VERSION_STR, "v1");
            this.f3799f = extras.getBoolean("backisexit", false);
            try {
                if ("v2".equals(this.f3800g)) {
                    C1569j jVar = new C1569j(this);
                    setContentView(jVar);
                    jVar.mo12257a(this.f3798e, this.f3796c, this.f3799f);
                    jVar.mo12253a(this.f3795b);
                    this.f3794a = jVar;
                } else {
                    this.f3794a = new C1567h(this);
                    setContentView(this.f3794a);
                    this.f3794a.mo12254a(this.f3795b, this.f3797d);
                    this.f3794a.mo12253a(this.f3795b);
                }
            } catch (Throwable th) {
                C1505a.m4453a(KEYS.BIZ, "GetInstalledAppEx", th);
                finish();
            }
        } catch (Exception unused) {
            finish();
        }
    }

    /* renamed from: b */
    private void m4397b() {
        try {
            super.requestWindowFeature(1);
        } catch (Throwable th) {
            C1542e.m4633a(th);
        }
    }

    public void onBackPressed() {
        C1566g gVar = this.f3794a;
        if (gVar instanceof C1567h) {
            gVar.mo12255b();
            return;
        }
        if (!gVar.mo12255b()) {
            super.onBackPressed();
        }
        C1503j.m4439a(C1503j.m4442c());
        finish();
    }

    public void finish() {
        mo12102a();
        super.finish();
    }

    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0009 */
    /* renamed from: a */
    public void mo12102a() {
        /*
        r2 = this;
        java.lang.Object r0 = com.alipay.sdk.app.PayTask.f3804a
        monitor-enter(r0)
        r0.notify()     // Catch:{ Exception -> 0x0009 }
        goto L_0x0009
    L_0x0007:
        r1 = move-exception
        goto L_0x000b
    L_0x0009:
        monitor-exit(r0)     // Catch:{ all -> 0x0007 }
        return
    L_0x000b:
        monitor-exit(r0)     // Catch:{ all -> 0x0007 }
        throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.sdk.app.H5PayActivity.mo12102a():void");
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        this.f3794a.mo12252a();
    }
}
