package com.qiyukf.unicorn.api.pop;

import com.qiyukf.nimlib.sdk.uinfo.UserInfoProvider.UserInfo;

public interface ShopInfo extends UserInfo {
    String getAccount();

    String getAvatar();

    String getName();
}
