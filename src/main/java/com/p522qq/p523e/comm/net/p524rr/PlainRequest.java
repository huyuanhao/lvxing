package com.p522qq.p523e.comm.net.p524rr;

import com.p522qq.p523e.comm.net.p524rr.Request.Method;
import java.net.HttpURLConnection;
import java.util.Map;

/* renamed from: com.qq.e.comm.net.rr.PlainRequest */
public class PlainRequest extends AbstractRequest {
    public PlainRequest(String str, Method method, byte[] bArr) {
        super(str, method, bArr);
    }

    public PlainRequest(String str, Map<String, String> map, Method method) {
        super(str, map, method);
    }

    public Response initResponse(HttpURLConnection httpURLConnection) {
        return new PlainResponse(httpURLConnection);
    }
}
