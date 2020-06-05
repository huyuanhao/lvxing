package com.p522qq.p523e.comm.net.p524rr;

import com.p522qq.p523e.comm.net.p524rr.C6433a.C6435b;
import java.io.IOException;
import java.net.HttpURLConnection;

/* renamed from: com.qq.e.comm.net.rr.S2SSResponse */
public class S2SSResponse extends AbstractResponse {
    public S2SSResponse(HttpURLConnection httpURLConnection) {
        super(httpURLConnection);
    }

    public byte[] getBytesContent() throws IllegalStateException, IOException {
        try {
            return C6433a.m25248b(super.getBytesContent());
        } catch (C6435b e) {
            e.printStackTrace();
            return null;
        }
    }
}
