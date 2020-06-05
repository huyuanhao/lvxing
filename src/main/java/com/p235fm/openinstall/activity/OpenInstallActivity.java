package com.p235fm.openinstall.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.p235fm.openinstall.C2611a;
import com.p235fm.openinstall.p239d.C2620a;

/* renamed from: com.fm.openinstall.activity.OpenInstallActivity */
public abstract class OpenInstallActivity extends Activity {
    /* renamed from: a */
    Intent f9471a;
    /* renamed from: b */
    C2620a f9472b;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f9472b = new C2613a(this);
        this.f9471a = getIntent();
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        this.f9471a = null;
        this.f9472b = null;
    }

    /* access modifiers changed from: protected */
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        this.f9471a = intent;
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        super.onStart();
        C2611a.m12713a(this.f9471a, this.f9472b);
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        super.onStop();
        getIntent().removeExtra("openinstall_intent");
    }

    public void startActivity(Intent intent) {
        super.startActivity(intent);
    }

    public void startActivityForResult(Intent intent, int i, Bundle bundle) {
        intent.putExtra("openinstall_intent", true);
        super.startActivityForResult(intent, i, bundle);
    }
}
