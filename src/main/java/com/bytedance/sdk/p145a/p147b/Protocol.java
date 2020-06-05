package com.bytedance.sdk.p145a.p147b;

import java.io.IOException;

/* renamed from: com.bytedance.sdk.a.b.w */
public enum Protocol {
    HTTP_1_0("http/1.0"),
    HTTP_1_1("http/1.1"),
    SPDY_3("spdy/3.1"),
    HTTP_2("h2");
    
    /* renamed from: e */
    private final String f5990e;

    private Protocol(String str) {
        this.f5990e = str;
    }

    /* renamed from: a */
    public static Protocol m7586a(String str) throws IOException {
        if (str.equals(HTTP_1_0.f5990e)) {
            return HTTP_1_0;
        }
        if (str.equals(HTTP_1_1.f5990e)) {
            return HTTP_1_1;
        }
        if (str.equals(HTTP_2.f5990e)) {
            return HTTP_2;
        }
        if (str.equals(SPDY_3.f5990e)) {
            return SPDY_3;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Unexpected protocol: ");
        sb.append(str);
        throw new IOException(sb.toString());
    }

    public String toString() {
        return this.f5990e;
    }
}
