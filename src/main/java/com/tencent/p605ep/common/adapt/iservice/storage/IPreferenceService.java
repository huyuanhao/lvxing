package com.tencent.p605ep.common.adapt.iservice.storage;

import java.util.Map;

/* renamed from: com.tencent.ep.common.adapt.iservice.storage.IPreferenceService */
public interface IPreferenceService {
    void beginTransaction();

    void clear();

    boolean contains(String str);

    boolean endTransaction();

    Map<String, ?> getAll();

    boolean getBoolean(String str);

    boolean getBoolean(String str, boolean z);

    float getFloat(String str);

    float getFloat(String str, float f);

    int getInt(String str);

    int getInt(String str, int i);

    long getLong(String str);

    long getLong(String str, long j);

    String getString(String str);

    String getString(String str, String str2);

    boolean putBoolean(String str, boolean z);

    boolean putFloat(String str, float f);

    boolean putInt(String str, int i);

    boolean putLong(String str, long j);

    boolean putString(String str, String str2);

    boolean remove(String str);
}
