package com.tencent.bugly.beta.tinker;

import android.util.Log;
import com.tencent.tinker.lib.util.TinkerLog.TinkerLogImp;

/* compiled from: BUGLY */
public class TinkerLogger implements TinkerLogImp {
    public static final int LEVEL_DEBUG = 1;
    public static final int LEVEL_ERROR = 4;
    public static final int LEVEL_INFO = 2;
    public static final int LEVEL_NONE = 5;
    public static final int LEVEL_VERBOSE = 0;
    public static final int LEVEL_WARNING = 3;
    private static final String TAG = "Tinker.TinkerLogger";
    private static int level;

    public static int getLogLevel() {
        return level;
    }

    public static void setLevel(int i) {
        level = i;
        StringBuilder sb = new StringBuilder();
        sb.append("new log level: ");
        sb.append(i);
        Log.w(TAG, sb.toString());
    }

    /* renamed from: v */
    public void mo34366v(String str, String str2, Object... objArr) {
        if (level <= 0) {
            if (objArr != null) {
                str2 = String.format(str2, objArr);
            }
            Log.v(str, str2);
        }
    }

    /* renamed from: i */
    public void mo34364i(String str, String str2, Object... objArr) {
        if (level <= 2) {
            if (objArr != null) {
                str2 = String.format(str2, objArr);
            }
            Log.i(str, str2);
        }
    }

    /* renamed from: w */
    public void mo34367w(String str, String str2, Object... objArr) {
        if (level <= 3) {
            if (objArr != null) {
                str2 = String.format(str2, objArr);
            }
            Log.w(str, str2);
        }
    }

    /* renamed from: d */
    public void mo34362d(String str, String str2, Object... objArr) {
        if (level <= 1) {
            if (objArr != null) {
                str2 = String.format(str2, objArr);
            }
            Log.d(str, str2);
        }
    }

    /* renamed from: e */
    public void mo34363e(String str, String str2, Object... objArr) {
        if (level <= 4) {
            if (objArr != null) {
                str2 = String.format(str2, objArr);
            }
            Log.e(str, str2);
        }
    }

    public void printErrStackTrace(String str, Throwable th, String str2, Object... objArr) {
        if (objArr != null) {
            str2 = String.format(str2, objArr);
        }
        if (str2 == null) {
            str2 = "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(str2);
        sb.append("  ");
        sb.append(Log.getStackTraceString(th));
        Log.e(str, sb.toString());
    }
}
