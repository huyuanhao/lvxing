package com.p235fm.openinstall.activity;

import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import com.p235fm.openinstall.C2611a;
import com.p235fm.openinstall.p239d.C2620a;

/* renamed from: com.fm.openinstall.activity.OpenInstallFragmentActivity */
public abstract class OpenInstallFragmentActivity extends FragmentActivity {
    /* renamed from: a */
    Intent f9475a;
    /* renamed from: b */
    C2620a f9476b;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f9476b = new C2615c(this);
        this.f9475a = getIntent();
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        this.f9475a = null;
        this.f9476b = null;
    }

    /* access modifiers changed from: protected */
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        this.f9475a = intent;
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        super.onStart();
        C2611a.m12713a(this.f9475a, this.f9476b);
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
