package ezy.sdk3rd.social.platforms.weixin;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import ezy.sdk3rd.social.sdk.IResult;

public class WXCallbackActivity extends Activity {
    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        onNewIntent(getIntent());
    }

    /* access modifiers changed from: protected */
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        StringBuilder sb = new StringBuilder();
        sb.append("==> ");
        sb.append(getIntent() == null ? "" : getIntent().getExtras());
        Log.e(WXBase.TAG, sb.toString());
        for (IResult eVar : WXBase.services.keySet()) {
            if (eVar != null) {
                eVar.onResult(WXBase.REQUEST_CODE, -1, intent);
            }
        }
        finish();
    }
}
