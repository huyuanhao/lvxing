package com.tencent.p605ep.commonbase.software;

/* renamed from: com.tencent.ep.commonbase.software.AppInfo */
public class AppInfo {
    public String mApkPath;
    public String mAppName;
    public boolean mIsApk;
    public boolean mIsSystemApp;
    public long mLastModified;
    public String mPkgName;
    public String mSignatureMD5;
    public long mSize;
    public int mUid;
    public int mVersionCode = -1;
    public String mVersionName;

    public AppInfo() {
        String str = "";
        this.mPkgName = str;
        this.mAppName = str;
        this.mVersionName = str;
        this.mIsSystemApp = false;
        this.mUid = -1;
        this.mSize = -1;
        this.mSignatureMD5 = str;
        this.mIsApk = false;
    }
}
