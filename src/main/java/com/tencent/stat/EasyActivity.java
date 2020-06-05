package com.tencent.stat;

import android.app.Activity;

public class EasyActivity extends Activity {
    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        StatService.onResume(this);
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        StatService.onPause(this);
    }
}
