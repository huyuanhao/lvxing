package com.p530ss.android.downloadlib.activity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import androidx.core.app.ActivityCompat.OnRequestPermissionsResultCallback;
import com.p530ss.android.downloadlib.p541a.C6565j;
import com.p530ss.android.downloadlib.p549e.C6587g;
import com.p530ss.android.downloadlib.p549e.PermissionUtils;
import com.p530ss.android.p531a.p532a.p533a.IPermissionCallback;
import java.lang.ref.WeakReference;

/* renamed from: com.ss.android.downloadlib.activity.TTDelegateActivity */
public class TTDelegateActivity extends Activity implements OnRequestPermissionsResultCallback {
    /* renamed from: a */
    protected Intent f21399a = null;

    /* renamed from: a */
    public static void m26394a(String str, String[] strArr) {
        Intent intent = new Intent(C6565j.m26357a(), TTDelegateActivity.class);
        intent.addFlags(268435456);
        intent.putExtra("type", 1);
        intent.putExtra("permission_id_key", str);
        intent.putExtra("permission_content_key", strArr);
        if (C6565j.m26357a() != null) {
            C6565j.m26357a().startActivity(intent);
        }
    }

    /* renamed from: a */
    public static void m26393a(String str) {
        Intent intent = new Intent(C6565j.m26357a(), TTDelegateActivity.class);
        intent.addFlags(268435456);
        intent.putExtra("type", 2);
        intent.putExtra("open_url", str);
        if (C6565j.m26357a() != null) {
            C6565j.m26357a().startActivity(intent);
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        m26395b();
        this.f21399a = getIntent();
        C6565j.m26368b(this);
    }

    /* renamed from: b */
    private void m26395b() {
        Window window = getWindow();
        LayoutParams attributes = window.getAttributes();
        attributes.alpha = 0.0f;
        window.setAttributes(attributes);
    }

    /* access modifiers changed from: protected */
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        this.f21399a = intent;
        C6565j.m26368b(this);
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        mo31358a();
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        C6565j.m26372f().mo16480a(this, i, strArr, iArr);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo31358a() {
        Intent intent = this.f21399a;
        if (intent != null) {
            int intExtra = intent.getIntExtra("type", 0);
            if (intExtra == 1) {
                m26397b(this.f21399a.getStringExtra("permission_id_key"), this.f21399a.getStringArrayExtra("permission_content_key"));
            } else if (intExtra != 2) {
                C6587g.m26519a((Activity) this);
            } else {
                m26396b(this.f21399a.getStringExtra("open_url"));
            }
            this.f21399a = null;
        }
    }

    /* renamed from: b */
    private void m26397b(final String str, String[] strArr) {
        if (TextUtils.isEmpty(str) || strArr == null || strArr.length <= 0) {
            C6587g.m26519a((Activity) this);
            return;
        }
        C65691 r0 = new IPermissionCallback() {
            /* renamed from: c */
            private WeakReference<Activity> f21402c = new WeakReference<>(TTDelegateActivity.this);

            /* renamed from: a */
            public void mo31041a() {
                PermissionUtils.m26496a(str);
                C6587g.m26519a((Activity) this.f21402c.get());
            }

            /* renamed from: a */
            public void mo31042a(String str) {
                PermissionUtils.m26498a(str, str);
                C6587g.m26519a((Activity) this.f21402c.get());
            }
        };
        if (VERSION.SDK_INT >= 23) {
            try {
                C6565j.m26372f().mo16481a(this, strArr, r0);
            } catch (Exception unused) {
                r0.mo31041a();
            }
        } else {
            r0.mo31041a();
        }
    }

    /* renamed from: b */
    private void m26396b(String str) {
        if (TextUtils.isEmpty(str)) {
            C6587g.m26519a((Activity) this);
            return;
        }
        try {
            Uri parse = Uri.parse(str);
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(parse);
            intent.putExtra("open_url", str);
            intent.addFlags(268435456);
            startActivity(intent);
        } catch (Exception e) {
            e.printStackTrace();
        } catch (Throwable th) {
            C6587g.m26519a((Activity) this);
            throw th;
        }
        C6587g.m26519a((Activity) this);
    }
}
