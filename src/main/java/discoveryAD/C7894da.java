package discoveryAD;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.qqpim.discovery.DiscoverySdk;
import com.tmsdk.module.coin.ESpKey;

/* renamed from: discoveryAD.da */
public class C7894da {
    /* renamed from: _d */
    private final String f26881_d;
    /* renamed from: ae */
    private SharedPreferences f26882ae;
    /* renamed from: be */
    private final String f26883be = "requesttime";
    /* renamed from: ce */
    private final String f26884ce = "feedback_switch";
    /* renamed from: de */
    private final String f26885de = "ad_switch_slop";
    /* renamed from: ee */
    private final String f26886ee = "pre_ad_request_state";

    public C7894da() {
        String str = ESpKey.F_AD_SP;
        this.f26881_d = str;
        this.f26882ae = DiscoverySdk.getInstance().getApplicationContext().getSharedPreferences(str, 0);
    }

    /* renamed from: M */
    public int mo38202M(int i) {
        return this.f26882ae.getInt("ad_switch_slop", -1);
    }

    /* renamed from: N */
    public boolean mo38203N(int i) {
        SharedPreferences sharedPreferences = this.f26882ae;
        StringBuilder sb = new StringBuilder();
        sb.append("pre_ad_request_state");
        sb.append(i);
        return sharedPreferences.getBoolean(sb.toString(), true);
    }

    /* renamed from: O */
    public long mo38204O(int i) {
        SharedPreferences sharedPreferences = this.f26882ae;
        StringBuilder sb = new StringBuilder();
        sb.append("requesttime");
        sb.append(i);
        return sharedPreferences.getLong(sb.toString(), -1);
    }

    /* renamed from: P */
    public void mo38205P(int i) {
        Editor edit = this.f26882ae.edit();
        edit.putInt("ad_switch_slop", i);
        edit.apply();
    }

    /* renamed from: a */
    public void mo38206a(int i, long j) {
        Editor edit = this.f26882ae.edit();
        StringBuilder sb = new StringBuilder();
        sb.append("requesttime");
        sb.append(i);
        edit.putLong(sb.toString(), j);
        edit.apply();
    }

    /* renamed from: b */
    public void mo38207b(int i, boolean z) {
        Editor edit = this.f26882ae.edit();
        StringBuilder sb = new StringBuilder();
        sb.append("pre_ad_request_state");
        sb.append(i);
        edit.putBoolean(sb.toString(), z);
        edit.apply();
    }

    /* renamed from: hb */
    public boolean mo38208hb() {
        return this.f26882ae.getBoolean("feedback_switch", true);
    }

    /* renamed from: i */
    public void mo38209i(boolean z) {
        Editor edit = this.f26882ae.edit();
        edit.putBoolean("feedback_switch", z);
        edit.apply();
    }
}
