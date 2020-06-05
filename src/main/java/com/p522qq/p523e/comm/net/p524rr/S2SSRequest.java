package com.p522qq.p523e.comm.net.p524rr;

import com.p522qq.p523e.comm.net.p524rr.Request.Method;
import java.net.HttpURLConnection;

/* renamed from: com.qq.e.comm.net.rr.S2SSRequest */
public class S2SSRequest extends AbstractRequest {
    public S2SSRequest(String str, byte[] bArr) {
        super(str, Method.POST, bArr);
    }

    public byte[] getPostData() throws Exception {
        return C6433a.m25246a(super.getPostData());
    }

    public Response initResponse(HttpURLConnection httpURLConnection) {
        return new S2SSResponse(httpURLConnection);
    }
}
