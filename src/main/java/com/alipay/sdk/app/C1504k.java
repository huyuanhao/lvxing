package com.alipay.sdk.app;

import com.kwad.sdk.core.imageloader.core.download.BaseImageDownloader;
import com.tmsdk.module.coin.ErrorCode;

/* renamed from: com.alipay.sdk.app.k */
public enum C1504k {
    SUCCEEDED(9000, "处理成功"),
    FAILED(4000, "系统繁忙，请稍后再试"),
    CANCELED(ErrorCode.ERC_LOGIN_PARAM_INVALID, "用户取消"),
    NETWORK_ERROR(ErrorCode.ERC_LOGIN_ACCOUNT_INVALID, "网络连接异常"),
    PARAMS_ERROR(4001, "参数错误"),
    DOUBLE_REQUEST(BaseImageDownloader.DEFAULT_HTTP_CONNECT_TIMEOUT, "重复请求"),
    PAY_WAITTING(8000, "支付结果确认中");
    
    /* renamed from: h */
    private int f3850h;
    /* renamed from: i */
    private String f3851i;

    private C1504k(int i, String str) {
        this.f3850h = i;
        this.f3851i = str;
    }

    /* renamed from: a */
    public void mo12143a(int i) {
        this.f3850h = i;
    }

    /* renamed from: a */
    public int mo12142a() {
        return this.f3850h;
    }

    /* renamed from: a */
    public void mo12144a(String str) {
        this.f3851i = str;
    }

    /* renamed from: b */
    public String mo12145b() {
        return this.f3851i;
    }

    /* renamed from: b */
    public static C1504k m4445b(int i) {
        if (i == 4001) {
            return PARAMS_ERROR;
        }
        if (i == 5000) {
            return DOUBLE_REQUEST;
        }
        if (i == 8000) {
            return PAY_WAITTING;
        }
        if (i == 9000) {
            return SUCCEEDED;
        }
        if (i == 6001) {
            return CANCELED;
        }
        if (i != 6002) {
            return FAILED;
        }
        return NETWORK_ERROR;
    }
}
