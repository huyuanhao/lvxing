package com.tencent.p605ep.common.adapt.iservice.profile;

import android.content.Intent;

/* renamed from: com.tencent.ep.common.adapt.iservice.profile.IAccountProfileListener */
public interface IAccountProfileListener {
    public static final String ACCOUNT_SYNC_PROFILE_ID = "acsyprid";
    public static final String ACCOUNT_SYNC_PUSH_NUM = "acsypunum";
    public static final String ACCOUNT_SYNC_RESULT = "acsyre";
    public static final String ACCOUNT_SYNC_UPLOAD_NUM = "acsyupnum";
    public static final int MSG_ACCOUNT_PROFILE_SYNC_RESULT = 1076;

    void broadcastHostMsgAsync(int i, Intent intent);

    long getAccountID();

    String getToken();
}
