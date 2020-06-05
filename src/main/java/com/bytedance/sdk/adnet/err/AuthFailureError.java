package com.bytedance.sdk.adnet.err;

import android.content.Intent;
import com.bytedance.sdk.adnet.core.NetworkResponse;

/* renamed from: com.bytedance.sdk.adnet.err.a */
public class AuthFailureError extends VAdError {
    /* renamed from: a */
    private Intent f6334a;

    public AuthFailureError() {
    }

    public AuthFailureError(NetworkResponse lVar) {
        super(lVar);
    }

    public String getMessage() {
        if (this.f6334a != null) {
            return "User needs to (re)enter credentials.";
        }
        return super.getMessage();
    }
}
