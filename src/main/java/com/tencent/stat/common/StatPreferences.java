package com.tencent.stat.common;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;
import com.tencent.stat.StatConfig;
import java.util.Map;

public class StatPreferences {
    /* renamed from: a */
    private static SharedPreferences f25647a;

    /* renamed from: a */
    static synchronized SharedPreferences m32741a(Context context) {
        SharedPreferences sharedPreferences;
        synchronized (StatPreferences.class) {
            if (f25647a == null) {
                try {
                    if (StatConfig.getMTAPreferencesFileName() != null) {
                        if (StatConfig.getMTAPreferencesFileName().trim().length() != 0) {
                            f25647a = context.getSharedPreferences(StatConfig.getMTAPreferencesFileName(), 0);
                        }
                    }
                    f25647a = PreferenceManager.getDefaultSharedPreferences(context);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            sharedPreferences = f25647a;
        }
        return sharedPreferences;
    }

    public static boolean contains(Context context, String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("");
        sb.append(str);
        return m32741a(context).contains(StatCommonHelper.getTagForConcurrentProcess(context, sb.toString()));
    }

    public static long getLong(Context context, String str, long j) {
        StringBuilder sb = new StringBuilder();
        sb.append("");
        sb.append(str);
        return m32741a(context).getLong(StatCommonHelper.getTagForConcurrentProcess(context, sb.toString()), j);
    }

    public static void putLong(Context context, String str, long j) {
        StringBuilder sb = new StringBuilder();
        sb.append("");
        sb.append(str);
        String tagForConcurrentProcess = StatCommonHelper.getTagForConcurrentProcess(context, sb.toString());
        Editor edit = m32741a(context).edit();
        edit.putLong(tagForConcurrentProcess, j);
        edit.commit();
    }

    public static int getInt(Context context, String str, int i) {
        StringBuilder sb = new StringBuilder();
        sb.append("");
        sb.append(str);
        return m32741a(context).getInt(StatCommonHelper.getTagForConcurrentProcess(context, sb.toString()), i);
    }

    public static void putInt(Context context, String str, int i) {
        StringBuilder sb = new StringBuilder();
        sb.append("");
        sb.append(str);
        String tagForConcurrentProcess = StatCommonHelper.getTagForConcurrentProcess(context, sb.toString());
        Editor edit = m32741a(context).edit();
        edit.putInt(tagForConcurrentProcess, i);
        edit.commit();
    }

    public static String getString(Context context, String str, String str2) {
        StringBuilder sb = new StringBuilder();
        sb.append("");
        sb.append(str);
        return m32741a(context).getString(StatCommonHelper.getTagForConcurrentProcess(context, sb.toString()), str2);
    }

    public static void putString(Context context, String str, String str2) {
        StringBuilder sb = new StringBuilder();
        sb.append("");
        sb.append(str);
        String tagForConcurrentProcess = StatCommonHelper.getTagForConcurrentProcess(context, sb.toString());
        Editor edit = m32741a(context).edit();
        edit.putString(tagForConcurrentProcess, str2);
        edit.commit();
    }

    public static float getFloat(Context context, String str, float f) {
        StringBuilder sb = new StringBuilder();
        sb.append("");
        sb.append(str);
        return m32741a(context).getFloat(StatCommonHelper.getTagForConcurrentProcess(context, sb.toString()), f);
    }

    public static void putFloat(Context context, String str, float f) {
        StringBuilder sb = new StringBuilder();
        sb.append("");
        sb.append(str);
        String tagForConcurrentProcess = StatCommonHelper.getTagForConcurrentProcess(context, sb.toString());
        Editor edit = m32741a(context).edit();
        edit.putFloat(tagForConcurrentProcess, f);
        edit.commit();
    }

    public static boolean getBoolean(Context context, String str, boolean z) {
        StringBuilder sb = new StringBuilder();
        sb.append("");
        sb.append(str);
        return m32741a(context).getBoolean(StatCommonHelper.getTagForConcurrentProcess(context, sb.toString()), z);
    }

    public static void putBoolean(Context context, String str, boolean z) {
        StringBuilder sb = new StringBuilder();
        sb.append("");
        sb.append(str);
        String tagForConcurrentProcess = StatCommonHelper.getTagForConcurrentProcess(context, sb.toString());
        Editor edit = m32741a(context).edit();
        edit.putBoolean(tagForConcurrentProcess, z);
        edit.commit();
    }

    public static Map<String, ?> getAll(Context context) {
        return m32741a(context).getAll();
    }

    public static void remove(Context context, String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("");
        sb.append(str);
        String tagForConcurrentProcess = StatCommonHelper.getTagForConcurrentProcess(context, sb.toString());
        if (m32741a(context).contains(tagForConcurrentProcess)) {
            Editor edit = m32741a(context).edit();
            edit.remove(tagForConcurrentProcess);
            edit.commit();
        }
    }
}
