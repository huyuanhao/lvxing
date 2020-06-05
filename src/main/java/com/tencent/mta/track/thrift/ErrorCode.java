package com.tencent.mta.track.thrift;

/* compiled from: ProGuard */
public enum ErrorCode {
    Ok(0),
    ErrorInternal(1),
    ErrorSession(2),
    ErrorDebugNotStart(3);
    
    private final int value;

    private ErrorCode(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }

    /* renamed from: a */
    public static ErrorCode m31888a(int i) {
        if (i == 0) {
            return Ok;
        }
        if (i == 1) {
            return ErrorInternal;
        }
        if (i == 2) {
            return ErrorSession;
        }
        if (i != 3) {
            return null;
        }
        return ErrorDebugNotStart;
    }
}
