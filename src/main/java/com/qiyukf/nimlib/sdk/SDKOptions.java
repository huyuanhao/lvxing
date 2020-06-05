package com.qiyukf.nimlib.sdk;

import com.qiyukf.nimlib.sdk.uinfo.UserInfoProvider;
import com.qiyukf.unicorn.api.StatusBarNotificationConfig;
import com.tencent.bugly.beta.tinker.TinkerReport;

public class SDKOptions {
    public static final SDKOptions DEFAULT = new SDKOptions();
    public String appKey;
    public String databaseEncryptKey;
    public boolean preloadAttach = true;
    public String sdkStorageRootPath;
    public StatusBarNotificationConfig statusBarNotificationConfig;
    public int thumbnailSize = TinkerReport.KEY_LOADED_PACKAGE_CHECK_SIGNATURE;
    public UserInfoProvider userInfoProvider;
}
