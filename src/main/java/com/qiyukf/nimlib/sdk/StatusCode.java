package com.qiyukf.nimlib.sdk;

public enum StatusCode {
    INVALID,
    UNLOGIN,
    NET_BROKEN,
    CONNECTING,
    LOGINING,
    SYNCING,
    LOGINED,
    KICKOUT,
    KICK_BY_OTHER_CLIENT,
    FORBIDDEN,
    VER_ERROR,
    PWD_ERROR;

    public final boolean logined() {
        return this == LOGINED;
    }

    public final boolean shouldReLogin() {
        return this == UNLOGIN || this == NET_BROKEN;
    }

    public final boolean wontAutoLogin() {
        return this == KICKOUT || this == KICK_BY_OTHER_CLIENT || this == FORBIDDEN || this == PWD_ERROR;
    }
}
