package com.tencent.bugly.beta.p602ui;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.tencent.bugly.beta.Beta;
import com.tencent.bugly.beta.global.C7128b;

/* compiled from: BUGLY */
/* renamed from: com.tencent.bugly.beta.ui.BetaActivity */
public class BetaActivity extends FragmentActivity {
    public Runnable onDestroyRunnable = null;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            requestWindowFeature(1);
            if (Beta.dialogFullScreen) {
                getWindow().setFlags(1024, 1024);
            }
            View findViewById = getWindow().getDecorView().findViewById(16908290);
            if (findViewById != null) {
                findViewById.setOnClickListener(new C7128b(1, this, findViewById));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        int intExtra = getIntent().getIntExtra("frag", -1);
        C7143b bVar = (C7143b) C7148g.f23798a.get(Integer.valueOf(intExtra));
        if (bVar != null) {
            getSupportFragmentManager().beginTransaction().add(16908290, (Fragment) bVar).commit();
            C7148g.f23798a.remove(Integer.valueOf(intExtra));
            return;
        }
        finish();
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        Runnable runnable = this.onDestroyRunnable;
        if (runnable != null) {
            runnable.run();
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        Fragment findFragmentById = getSupportFragmentManager().findFragmentById(16908290);
        boolean z = false;
        try {
            if (findFragmentById instanceof C7143b) {
                z = ((C7143b) findFragmentById).mo34441a(i, keyEvent);
            }
        } catch (Exception unused) {
        }
        if (!z) {
            return super.onKeyDown(i, keyEvent);
        }
        return true;
    }
}
