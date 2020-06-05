package com.tencent.p605ep.common.adapt.iservice.profile;

/* renamed from: com.tencent.ep.common.adapt.iservice.profile.IKVProfileService */
public interface IKVProfileService {
    void fullCheckAndMonitorChange(long j);

    boolean getKVProfileBool(int i, boolean z);

    int getKVProfileInt(int i, int i2);

    long getKVProfileLong(int i, long j);

    String getKVProfileString(int i, String str);

    void setKVProfileBool(int i, boolean z);

    void setKVProfileInt(int i, int i2);

    void setKVProfileLong(int i, long j);

    void setKVProfileString(int i, String str);
}
