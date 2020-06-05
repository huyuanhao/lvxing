package com.bytedance.sdk.p145a.p147b.p148a.p153e;

/* renamed from: com.bytedance.sdk.a.b.a.e.b */
public enum ErrorCode {
    NO_ERROR(0),
    PROTOCOL_ERROR(1),
    INTERNAL_ERROR(2),
    FLOW_CONTROL_ERROR(3),
    REFUSED_STREAM(7),
    CANCEL(8);
    
    /* renamed from: g */
    public final int f5480g;

    private ErrorCode(int i) {
        this.f5480g = i;
    }

    /* renamed from: a */
    public static ErrorCode m7057a(int i) {
        ErrorCode[] values;
        for (ErrorCode bVar : values()) {
            if (bVar.f5480g == i) {
                return bVar;
            }
        }
        return null;
    }
}
