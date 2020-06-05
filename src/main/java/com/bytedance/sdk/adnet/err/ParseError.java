package com.bytedance.sdk.adnet.err;

import com.bytedance.sdk.adnet.core.NetworkResponse;

/* renamed from: com.bytedance.sdk.adnet.err.e */
public class ParseError extends VAdError {
    public ParseError() {
    }

    public ParseError(NetworkResponse lVar) {
        super(lVar);
    }

    public ParseError(Throwable th) {
        super(th);
    }
}
