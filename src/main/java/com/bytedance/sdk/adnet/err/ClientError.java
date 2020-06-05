package com.bytedance.sdk.adnet.err;

import com.bytedance.sdk.adnet.core.NetworkResponse;

/* renamed from: com.bytedance.sdk.adnet.err.b */
public class ClientError extends ServerError {
    public ClientError(NetworkResponse lVar) {
        super(lVar);
    }

    public ClientError() {
    }
}
