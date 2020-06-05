package com.tmsdk.module.coin;

import java.util.Map;

public interface ISharePreference {
    void clear();

    Map<String, ?> getAll();

    boolean getBoolean(String str, boolean z);

    float getFloat(String str, float f);

    int getInt(String str, int i);

    long getLong(String str, long j);

    String getString(String str, String str2);

    void putBoolean(String str, boolean z);

    void putFloat(String str, float f);

    void putInt(String str, int i);

    void putLong(String str, long j);

    void putString(String str, String str2);

    void remove(String str);
}
