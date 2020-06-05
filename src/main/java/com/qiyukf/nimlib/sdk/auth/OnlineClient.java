package com.qiyukf.nimlib.sdk.auth;

import java.io.Serializable;

public interface OnlineClient extends Serializable {
    String getClientIp();

    int getClientType();

    int getLoginTime();

    String getOs();
}
