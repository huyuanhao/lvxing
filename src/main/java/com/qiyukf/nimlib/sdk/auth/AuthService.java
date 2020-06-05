package com.qiyukf.nimlib.sdk.auth;

import com.qiyukf.nimlib.sdk.AbortableFuture;
import com.qiyukf.nimlib.sdk.InvocationFuture;
import com.qiyukf.unicorn.api.SavePowerConfig;

public interface AuthService {
    void changeSaverMode(int i);

    int getKickedClientType();

    InvocationFuture<Void> kickOtherClient(OnlineClient onlineClient);

    AbortableFuture<LoginInfo> login(LoginInfo loginInfo);

    InvocationFuture<Void> logout();

    boolean openLocalCache(String str);

    void updateSavePowerConfig(SavePowerConfig savePowerConfig);
}
