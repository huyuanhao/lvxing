package com.tencent.p605ep.common.adapt.iservice.profile;

import java.util.List;

/* renamed from: com.tencent.ep.common.adapt.iservice.profile.IAccountProfileService */
public interface IAccountProfileService {
    void checkDataChange(int i);

    void checkLoginChange();

    void cleanProfileData(int[] iArr);

    void delKVProfileValue(int i, String str);

    boolean getKVProfileBool(int i, String str, boolean z);

    byte[] getKVProfileByte(int i, String str);

    int getKVProfileInt(int i, String str, int i2);

    long getKVProfileLong(int i, String str, long j);

    short getKVProfileShort(int i, String str, short s);

    String getKVProfileString(int i, String str, String str2);

    List<String> getKeys(int i);

    boolean isProfileClear(int i);

    boolean isProfileClear(int i, String str);

    void setKVProfileBool(int i, String str, boolean z);

    void setKVProfileByte(int i, String str, byte[] bArr);

    void setKVProfileInt(int i, String str, int i2);

    void setKVProfileLong(int i, String str, long j);

    void setKVProfileShort(int i, String str, short s);

    void setKVProfileString(int i, String str, String str2);

    void setListener(IAccountProfileListener iAccountProfileListener);
}
