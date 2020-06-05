package com.yanzhenjie.permission.p633a;

import android.content.Context;
import android.net.sip.SipManager;
import android.net.sip.SipProfile;
import android.net.sip.SipProfile.Builder;
import com.yanzhenjie.permission.p638e.C7838a;

/* renamed from: com.yanzhenjie.permission.a.q */
class SipTest implements PermissionTest {
    /* renamed from: a */
    private static final String f26632a = C7838a.m34069b("5065726D697373696F6E");
    /* renamed from: b */
    private static final String f26633b = C7838a.m34069b("3132372E302E302E31");
    /* renamed from: c */
    private static final String f26634c = C7838a.m34068a("70617373776F7264");
    /* renamed from: d */
    private Context f26635d;

    SipTest(Context context) {
        this.f26635d = context;
    }

    /* renamed from: a */
    public boolean mo38007a() throws Throwable {
        if (!SipManager.isApiSupported(this.f26635d)) {
            return true;
        }
        SipManager newInstance = SipManager.newInstance(this.f26635d);
        if (newInstance == null) {
            return true;
        }
        Builder builder = new Builder(f26632a, f26633b);
        builder.setPassword(f26634c);
        SipProfile build = builder.build();
        newInstance.open(build);
        newInstance.close(build.getUriString());
        return true;
    }
}
