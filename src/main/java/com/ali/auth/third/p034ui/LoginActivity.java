package com.ali.auth.third.p034ui;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import com.ali.auth.third.core.p023b.C0985c;
import com.ali.auth.third.core.p024c.C0989a;
import com.ali.auth.third.core.p033j.C1018a;
import com.ali.auth.third.core.util.C1039d;
import com.ali.auth.third.p016a.C0955a;
import com.ali.auth.third.p016a.p019c.C0972e;
import com.ali.auth.third.p016a.p020d.C0977a;
import com.ali.auth.third.p034ui.p035a.C1067a;
import java.util.Map;
import org.json.JSONObject;

/* renamed from: com.ali.auth.third.ui.LoginActivity */
public class LoginActivity extends Activity {
    /* renamed from: a */
    LinearLayout f2087a;

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo10380a() {
        int intExtra = getIntent().getIntExtra("login_type", 0);
        if (intExtra == 4) {
            String stringExtra = getIntent().getStringExtra("params");
            Map map = null;
            if (!TextUtils.isEmpty(stringExtra)) {
                map = C1039d.m1993a(new JSONObject(stringExtra));
            }
            C0955a.f1830a.mo10263a(this, map);
        } else if (intExtra != 5) {
            C0955a.f1830a.mo10262a((Activity) this);
        } else {
            try {
                String stringExtra2 = getIntent().getStringExtra("token");
                new C0972e(this, (C0985c) C1067a.f2147a).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[]{stringExtra2});
            } catch (Throwable unused) {
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        StringBuilder sb = new StringBuilder();
        sb.append("onActivityResult requestCode = ");
        sb.append(i);
        sb.append(" resultCode=");
        sb.append(i2);
        C1018a.m1964b("login.LoginActivity", sb.toString());
        if (!C0989a.m1888d()) {
            finish();
            return;
        }
        this.f2087a.setClickable(true);
        this.f2087a.setLongClickable(true);
        super.onActivityResult(i, i2, intent);
        if (C1067a.f2149c == null) {
            C1067a.m2074a(this);
        }
        C1067a.m2075a(i, i2, intent);
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f2087a = new LinearLayout(this);
        this.f2087a.setLayoutParams(new LayoutParams(-1, -1));
        setContentView(this.f2087a);
        if (C0989a.f1891f == null) {
            C0989a.f1891f = getApplicationContext();
        }
        this.f2087a.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                C1018a.m1967d("login.LoginActivity", "click to destroy");
                LoginActivity.this.finish();
                C0977a.m1852a();
            }
        });
        this.f2087a.setClickable(false);
        this.f2087a.setLongClickable(false);
        String str = "login.LoginActivity";
        if (!C0989a.m1888d()) {
            C1018a.m1964b(str, "static field null");
            C0977a.m1852a();
            finish();
            return;
        }
        C1067a.m2074a(this);
        C1018a.m1967d(str, "before mtop call showLogin");
        mo10380a();
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        if (!C0989a.m1888d()) {
            finish();
        }
    }
}
