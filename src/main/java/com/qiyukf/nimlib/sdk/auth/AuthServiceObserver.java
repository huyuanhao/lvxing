package com.qiyukf.nimlib.sdk.auth;

import com.qiyukf.nimlib.sdk.Observer;
import com.qiyukf.nimlib.sdk.StatusCode;
import java.util.List;

public interface AuthServiceObserver {
    void observeOnlineStatus(Observer<StatusCode> observer, boolean z);

    void observeOtherClients(Observer<List<OnlineClient>> observer, boolean z);
}
