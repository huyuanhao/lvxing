package com.p235fm.openinstall.activity;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.p235fm.openinstall.C2611a;
import com.p235fm.openinstall.p239d.C2620a;

/* renamed from: com.fm.openinstall.activity.OpenInstallAppCompatActivity */
public abstract class OpenInstallAppCompatActivity extends AppCompatActivity {
    /* renamed from: a */
    Intent f9473a;
    /* renamed from: b */
    C2620a f9474b;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f9474b = new C2614b(this);
        this.f9473a = getIntent();
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        this.f9473a = null;
        this.f9474b = null;
    }

    /* access modifiers changed from: protected */
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        this.f9473a = intent;
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        super.onStart();
        C2611a.m12713a(this.f9473a, this.f9474b);
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
