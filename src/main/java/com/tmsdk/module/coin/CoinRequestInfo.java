package com.tmsdk.module.coin;

public class CoinRequestInfo {
    public String accountId;
    public String loginKey;

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("accountId:");
        sb.append(this.accountId);
        sb.append("loginKey:");
        sb.append(this.loginKey);
        return sb.toString();
    }
}
