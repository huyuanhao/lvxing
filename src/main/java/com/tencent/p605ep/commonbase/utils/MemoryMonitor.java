package com.tencent.p605ep.commonbase.utils;

import android.content.Context;
import android.text.SpannableStringBuilder;
import com.tencent.android.tpush.common.MessageKey;
import com.tencent.p605ep.commonbase.api.Log;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* renamed from: com.tencent.ep.commonbase.utils.MemoryMonitor */
public final class MemoryMonitor {
    public static final int FLAG_LEAK_DETEC_LEVEL_0 = 0;
    public static final int FLAG_LEAK_DETEC_LEVEL_1 = 65536;
    public static final int FLAG_LEAK_DETEC_LEVEL_2 = 131072;
    public static final int FLAG_LEAK_DETEC_LEVEL_3 = 196608;
    public static final int FLAG_LEAK_DETEC_LEVEL_4 = 262144;
    public static final int FLAG_LEAK_DETEC_LEVEL_5 = 327680;
    public static final int FLAG_LEAK_DETEC_LEVEL_6 = 393216;
    public static final int FLAG_LEAK_DETEC_LEVEL_7 = 458752;
    public static final int FLAG_NEED_CHECK_BASE_PAGE = 524288;
    public static final String TAG = "MemoryMonitor";
    private static Method addObjectMethod;
    private static Method broadCastAppVisibleMethod;
    private static Method initMethod;
    private static Method startMethod;
    private static Method stopMethod;

    public static void addObject(Object obj) {
        addObject(null, obj, 0);
    }

    public static void addObject(Object obj, int i) {
        addObject(null, obj, i);
    }

    public static void addObject(String str, Object obj) {
        addObject(str, obj, 0);
    }

    public static void addObject(String str, Object obj, int i) {
        if (obj != null) {
            invokeMethod(addObjectMethod, null, str, obj, Integer.valueOf(i));
        }
    }

    public static void broadCastAppVisible(boolean z) {
        invokeMethod(broadCastAppVisibleMethod, null, Boolean.valueOf(z));
    }

    public static void init(Context context, boolean z) {
        init(context, z, false, false);
    }

    public static void init(Context context, boolean z, boolean z2) {
        init(context, z, z2, false);
    }

    public static void init(Context context, boolean z, boolean z2, boolean z3) {
        if (context != null && z) {
            try {
                Class cls = Class.forName("com.tencent.memorytools.MemoryLeakDetector");
                initMethod = cls.getMethod("init", new Class[]{Context.class, Boolean.TYPE, Boolean.TYPE, Boolean.TYPE});
                startMethod = cls.getMethod(MessageKey.MSG_ACCEPT_TIME_START, new Class[0]);
                stopMethod = cls.getMethod("stop", new Class[0]);
                addObjectMethod = cls.getMethod("addObject", new Class[]{String.class, Object.class, Integer.TYPE});
                broadCastAppVisibleMethod = cls.getMethod("broadCastAppVisible", new Class[]{Boolean.TYPE});
                invokeMethod(initMethod, null, context, Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3));
            } catch (Exception e) {
                Log.m31487w(TAG, toString((Throwable) e));
                initMethod = null;
                startMethod = null;
                stopMethod = null;
                addObjectMethod = null;
                broadCastAppVisibleMethod = null;
            }
        }
    }

    private static void invokeMethod(Method method, Object obj, Object... objArr) {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append("Method == null ? ");
        sb.append(method == null);
        String sb2 = sb.toString();
        String str2 = TAG;
        Log.m31483i(str2, sb2);
        if (method != null) {
            try {
                method.invoke(obj, objArr);
            } catch (InvocationTargetException e) {
                str = toString(e);
            } catch (Exception e2) {
                str = toString((Throwable) e2);
            }
        }
        return;
        Log.m31487w(str2, str);
    }

    public static void start() {
        invokeMethod(startMethod, null, new Object[0]);
    }

    public static void stop() {
        invokeMethod(stopMethod, null, new Object[0]);
    }

    private static String toString(Throwable th) {
        StackTraceElement[] stackTrace;
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        spannableStringBuilder.append(th.toString());
        for (StackTraceElement stackTraceElement : th.getStackTrace()) {
            StringBuilder sb = new StringBuilder();
            sb.append("\n    at ");
            sb.append(stackTraceElement.toString());
            spannableStringBuilder.append(sb.toString());
        }
        return spannableStringBuilder.toString();
    }

    private static String toString(InvocationTargetException invocationTargetException) {
        return toString(invocationTargetException.getTargetException());
    }
}
