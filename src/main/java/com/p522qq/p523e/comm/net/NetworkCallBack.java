package com.p522qq.p523e.comm.net;

import com.p522qq.p523e.comm.net.p524rr.Request;
import com.p522qq.p523e.comm.net.p524rr.Response;

/* renamed from: com.qq.e.comm.net.NetworkCallBack */
public interface NetworkCallBack {
    void onException(Exception exc);

    void onResponse(Request request, Response response);
}
