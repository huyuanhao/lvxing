package com.alibaba.baichuan.trade.common.adapter.mtop;

import android.text.TextUtils;
import java.io.Serializable;
import java.util.Map;

public class NetworkRequest implements Serializable {
    private static final long serialVersionUID = 3052085037769716049L;
    public String accessToken;
    public String apiName;
    public String apiVersion = "1.0";
    public String authParams = "";
    public Map<String, String> extHeaders;
    public boolean isPost = true;
    public boolean isVip;
    public boolean needAuth = false;
    public boolean needCache = false;
    public boolean needLogin = false;
    public boolean needWua = false;
    public String openAppKey;
    public Map<String, Serializable> paramMap;
    public int requestType;
    public boolean showAuthUI = false;
    public int timeOut = -1;
    public String ttid;

    public boolean check() {
        return !TextUtils.isEmpty(this.apiName) && !TextUtils.isEmpty(this.apiVersion);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("NetworkRequest [apiName=");
        sb.append(this.apiName);
        sb.append(", apiVersion=");
        sb.append(this.apiVersion);
        sb.append(", params=");
        sb.append(this.paramMap);
        sb.append(", openAppKey=");
        sb.append(this.openAppKey);
        sb.append(", accessToken=");
        sb.append(this.accessToken);
        sb.append(", ttid=");
        sb.append(this.ttid);
        sb.append(", needAuth=");
        sb.append(this.needAuth);
        sb.append(", needWua=");
        sb.append(this.needWua);
        sb.append("]");
        return sb.toString();
    }
}
