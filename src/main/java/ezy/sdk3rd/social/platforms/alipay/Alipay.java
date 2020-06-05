package ezy.sdk3rd.social.platforms.alipay;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import com.alipay.sdk.app.PayTask;
import ezy.sdk3rd.social.payment.IPayable;
import ezy.sdk3rd.social.sdk.OnCallback;
import ezy.sdk3rd.social.sdk.Platform;

public class Alipay implements IPayable {
    public static final String TAG = "ezy.sdk3rd.alipay";
    Activity mActivity;

    public void onResult(int i, int i2, Intent intent) {
    }

    Alipay(Activity activity, Platform platform) {
        this.mActivity = activity;
    }

    public void pay(final String str, final OnCallback<String> fVar) {
        new AsyncTask<String, Void, Result>() {
            /* access modifiers changed from: protected */
            public void onPreExecute() {
                fVar.mo20727a(Alipay.this.mActivity);
            }

            /* access modifiers changed from: protected|varargs */
            /* renamed from: a */
            public Result doInBackground(String... strArr) {
                return new Result(new PayTask(Alipay.this.mActivity).payV2(str, true));
            }

            /* access modifiers changed from: protected */
            /* renamed from: a */
            public void onPostExecute(Result aVar) {
                StringBuilder sb = new StringBuilder();
                sb.append("[");
                sb.append(aVar.f27285b);
                sb.append("]");
                sb.append(aVar.f27287d);
                String sb2 = sb.toString();
                if (aVar.mo38583a()) {
                    fVar.mo20729a(Alipay.this.mActivity, "");
                } else if (aVar.mo38584b()) {
                    fVar.mo20728a(Alipay.this.mActivity, 1, sb2);
                } else if (aVar.mo38585c()) {
                    fVar.mo20728a(Alipay.this.mActivity, 2, sb2);
                } else {
                    fVar.mo20728a(Alipay.this.mActivity, 3, sb2);
                }
                fVar.mo20731b(Alipay.this.mActivity);
            }
        }.execute(new String[]{str});
    }
}
