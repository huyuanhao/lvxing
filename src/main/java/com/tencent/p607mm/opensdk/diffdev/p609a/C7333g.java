package com.tencent.p607mm.opensdk.diffdev.p609a;

import com.tencent.p605ep.commonbase.network.HttpStatus;

/* renamed from: com.tencent.mm.opensdk.diffdev.a.g */
public enum C7333g {
    UUID_EXPIRED(402),
    UUID_CANCELED(403),
    UUID_SCANED(404),
    UUID_CONFIRM(405),
    UUID_KEEP_CONNECT(HttpStatus.SC_REQUEST_TIMEOUT),
    UUID_ERROR(500);
    
    private int code;

    private C7333g(int i) {
        this.code = i;
    }

    public final int getCode() {
        return this.code;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("UUIDStatusCode:");
        sb.append(this.code);
        return sb.toString();
    }
}
