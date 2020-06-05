package com.tencent.android.tpush.service.p588a;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.preference.PreferenceManager;
import android.util.Log;
import com.tencent.android.tpush.common.Constants;
import com.tencent.android.tpush.service.channel.p593c.C7037d;
import com.tencent.android.tpush.service.p595e.C7056i;
import com.tencent.mid.sotrage.StorageInterface;

/* compiled from: ProGuard */
/* renamed from: com.tencent.android.tpush.service.a.b */
public class C6972b {
    /* renamed from: a */
    public static void m29761a(Context context, String str) {
        SharedPreferences sharedPreferences;
        String str2 = Constants.LogTag;
        String str3 = StorageInterface.KEY_SPLITER;
        if (context != null && !C7056i.m30194b(str)) {
            for (String split : str.split(";;")) {
                try {
                    String[] split2 = split.split(str3);
                    String str4 = split2[0];
                    String str5 = split2[1];
                    if (split2.length == 4 && str5.length() == 1) {
                        String str6 = split2[2];
                        String str7 = split2[3];
                        if (C7056i.m30194b(str4)) {
                            sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
                        } else if (VERSION.SDK_INT >= 11) {
                            sharedPreferences = context.getSharedPreferences(str4, 4);
                        } else {
                            sharedPreferences = context.getSharedPreferences(str4, 0);
                        }
                        Editor edit = sharedPreferences.edit();
                        if (!C7056i.m30194b(str6) && !C7056i.m30194b(str7)) {
                            if ("S".equals(str5)) {
                                edit.putString(str6, str7);
                            } else if ("L".equals(str5)) {
                                edit.putLong(str6, Long.valueOf(str7).longValue());
                            } else if ("I".equals(str5)) {
                                edit.putInt(str6, Integer.valueOf(str7).intValue());
                            } else if ("F".equals(str5)) {
                                edit.putFloat(str6, Float.valueOf(str7).floatValue());
                            } else if ("B".equals(str5)) {
                                edit.putBoolean(str6, Boolean.valueOf(str7).booleanValue());
                            }
                        }
                        edit.commit();
                        StringBuilder sb = new StringBuilder();
                        sb.append(sharedPreferences);
                        sb.append(str3);
                        sb.append(str6);
                        sb.append(str3);
                        sb.append(str7);
                        Log.e(str2, sb.toString());
                    }
                } catch (Throwable th) {
                    Log.e(str2, "eeee", th);
                }
            }
        }
    }

    /* renamed from: b */
    public static void m29762b(Context context, String str) {
        if (context != null && !C7056i.m30194b(str)) {
            for (String split : str.split(";;")) {
                try {
                    String[] split2 = split.split(StorageInterface.KEY_SPLITER);
                    String str2 = split2[0];
                    if (split2.length == 3 && str2.length() == 1) {
                        String str3 = split2[1];
                        String str4 = split2[2];
                        if (!C7056i.m30194b(str3) && !C7056i.m30194b(str4)) {
                            if ("S".equals(str2)) {
                                C7037d.m30095a(context).mo33482a(str3, str4);
                            } else if ("L".equals(str2)) {
                                C7037d.m30095a(context).mo33481a(str3, Long.valueOf(str4).longValue());
                            } else if ("I".equals(str2)) {
                                C7037d.m30095a(context).mo33480a(str3, Integer.valueOf(str4).intValue());
                            } else if ("F".equals(str2)) {
                                C7037d.m30095a(context).mo33479a(str3, Float.valueOf(str4).floatValue());
                            }
                        }
                    }
                } catch (Throwable unused) {
                }
            }
        }
    }
}
