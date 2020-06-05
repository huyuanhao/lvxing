package com.tencent.p605ep.common.adapt.iservice.account;

import android.os.Bundle;

/* renamed from: com.tencent.ep.common.adapt.iservice.account.IAccountService */
public interface IAccountService {
    AccountInfo getAccountInfo(String str, int i);

    void getFace(int i, String str, FaceCallback faceCallback);

    void getFaceUrl(int i, String str, FaceUrlCallback faceUrlCallback);

    MainAccountInfo getMainAccountInfo();

    void getToken(String str, int i, int i2, boolean z, TokenCallback tokenCallback);

    UserInfo getUserInfo(int i, String str);

    void requestLogin(Bundle bundle, IAccountLoginCallBack iAccountLoginCallBack);
}
