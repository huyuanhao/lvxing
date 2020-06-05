package com.bytedance.tea.crash.p221g;

import android.app.ActivityManager;
import android.app.ActivityManager.MemoryInfo;
import android.app.ActivityManager.ProcessErrorStateInfo;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.ActivityManager.RunningTaskInfo;
import android.content.ComponentName;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.Debug;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.tea.crash.upload.CrashUploadService;
import com.tencent.android.tpush.common.Constants;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.bytedance.tea.crash.g.a */
public final class App {
    /* renamed from: a */
    private static String f9365a = null;
    /* renamed from: b */
    private static String f9366b = null;
    /* renamed from: c */
    private static Class<?> f9367c = null;
    /* renamed from: d */
    private static Field f9368d = null;
    /* renamed from: e */
    private static Field f9369e = null;
    /* renamed from: f */
    private static boolean f9370f = false;

    /* renamed from: a */
    private static long m12494a(int i) {
        if (i < 0) {
            return 0;
        }
        return ((long) i) * 1024;
    }

    /* renamed from: a */
    public static boolean m12500a(Context context) {
        if (context == null) {
            return false;
        }
        String packageName = context.getPackageName();
        try {
            ActivityManager activityManager = (ActivityManager) context.getSystemService(Constants.FLAG_ACTIVITY_NAME);
            if (activityManager == null) {
                return false;
            }
            if (VERSION.SDK_INT < 21) {
                List runningTasks = activityManager.getRunningTasks(1);
                if (runningTasks != null && !runningTasks.isEmpty()) {
                    ComponentName componentName = ((RunningTaskInfo) runningTasks.get(0)).topActivity;
                    if (componentName == null || !packageName.equals(componentName.getPackageName())) {
                        return false;
                    }
                    return true;
                }
            } else {
                List<RunningAppProcessInfo> runningAppProcesses = activityManager.getRunningAppProcesses();
                if (runningAppProcesses != null) {
                    for (RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                        if (runningAppProcessInfo.importance == 100) {
                            return packageName.equals(runningAppProcessInfo.pkgList[0]);
                        }
                    }
                }
            }
            return false;
        } catch (Throwable unused) {
        }
    }

    /* renamed from: a */
    public static ProcessErrorStateInfo m12495a(Context context, int i) {
        ActivityManager activityManager = (ActivityManager) context.getSystemService(Constants.FLAG_ACTIVITY_NAME);
        if (activityManager == null) {
            return null;
        }
        for (int i2 = 0; i2 < i; i2++) {
            SystemClock.sleep(200);
            List<ProcessErrorStateInfo> processesInErrorState = activityManager.getProcessesInErrorState();
            if (processesInErrorState != null) {
                for (ProcessErrorStateInfo processErrorStateInfo : processesInErrorState) {
                    if (processErrorStateInfo.condition == 2) {
                        return processErrorStateInfo;
                    }
                }
                continue;
            }
        }
        return null;
    }

    /* renamed from: b */
    public static boolean m12502b(Context context) {
        String d = m12504d(context);
        boolean z = false;
        if (d != null && d.contains(":")) {
            return false;
        }
        if (d != null && d.equals(context.getPackageName())) {
            return true;
        }
        if (d != null && d.equals(context.getApplicationInfo().processName)) {
            z = true;
        }
        return z;
    }

    /* renamed from: c */
    public static boolean m12503c(Context context) {
        String d = m12504d(context);
        if (f9366b == null) {
            try {
                f9366b = context.getPackageManager().getServiceInfo(new ComponentName(context, CrashUploadService.class), 65536).processName;
                f9366b = f9366b.substring(f9366b.lastIndexOf(":"));
            } catch (Throwable th) {
                th.printStackTrace();
                f9366b = ":npth";
            }
        }
        return d != null && d.endsWith(f9366b);
    }

    /* renamed from: d */
    public static String m12504d(Context context) {
        String str = f9365a;
        if (!TextUtils.isEmpty(str)) {
            return str;
        }
        try {
            int myPid = Process.myPid();
            ActivityManager activityManager = (ActivityManager) context.getSystemService(Constants.FLAG_ACTIVITY_NAME);
            if (activityManager != null) {
                for (RunningAppProcessInfo runningAppProcessInfo : activityManager.getRunningAppProcesses()) {
                    if (runningAppProcessInfo.pid == myPid) {
                        f9365a = runningAppProcessInfo.processName;
                        return f9365a;
                    }
                }
            }
        } catch (Throwable th) {
            NpthLog.m12550b(th);
        }
        f9365a = m12496a();
        String str2 = f9365a;
        if (str2 == null) {
            str2 = "";
        }
        return str2;
    }

    /* renamed from: a */
    private static String m12496a() {
        BufferedReader bufferedReader;
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("/proc/");
            sb.append(Process.myPid());
            sb.append("/cmdline");
            bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(sb.toString()), "iso-8859-1"));
            try {
                StringBuilder sb2 = new StringBuilder();
                while (true) {
                    int read = bufferedReader.read();
                    if (read > 0) {
                        sb2.append((char) read);
                    } else {
                        String sb3 = sb2.toString();
                        IoUtil.m12535a(bufferedReader);
                        return sb3;
                    }
                }
            } catch (Throwable unused) {
                IoUtil.m12535a(bufferedReader);
                return null;
            }
        } catch (Throwable unused2) {
            bufferedReader = null;
            IoUtil.m12535a(bufferedReader);
            return null;
        }
    }

    /* renamed from: a */
    public static void m12497a(Context context, JSONObject jSONObject) {
        try {
            m12498a(jSONObject);
            ActivityManager activityManager = (ActivityManager) context.getSystemService(Constants.FLAG_ACTIVITY_NAME);
            if (activityManager != null) {
                m12501b(jSONObject, activityManager);
            }
            m12499a(jSONObject, activityManager);
        } catch (Throwable unused) {
        }
    }

    /* renamed from: a */
    private static void m12499a(JSONObject jSONObject, ActivityManager activityManager) throws JSONException {
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("native_heap_size", Debug.getNativeHeapSize());
        jSONObject2.put("native_heap_alloc_size", Debug.getNativeHeapAllocatedSize());
        jSONObject2.put("native_heap_free_size", Debug.getNativeHeapFreeSize());
        Runtime runtime = Runtime.getRuntime();
        jSONObject2.put("max_memory", runtime.maxMemory());
        jSONObject2.put("free_memory", runtime.freeMemory());
        jSONObject2.put("total_memory", runtime.totalMemory());
        if (activityManager != null) {
            jSONObject2.put("memory_class", activityManager.getMemoryClass());
            jSONObject2.put("large_memory_class", activityManager.getLargeMemoryClass());
        }
        jSONObject.put("app_memory_info", jSONObject2);
    }

    /* renamed from: b */
    private static void m12501b(JSONObject jSONObject, ActivityManager activityManager) throws JSONException {
        JSONObject jSONObject2 = new JSONObject();
        MemoryInfo memoryInfo = new MemoryInfo();
        activityManager.getMemoryInfo(memoryInfo);
        jSONObject2.put("availMem", memoryInfo.availMem);
        jSONObject2.put("lowMemory", memoryInfo.lowMemory);
        jSONObject2.put("threshold", memoryInfo.threshold);
        jSONObject2.put("totalMem", JellyBeanV16Compat.m12536a(memoryInfo));
        jSONObject.put("sys_memory_info", jSONObject2);
    }

    /* renamed from: a */
    private static void m12498a(JSONObject jSONObject) throws JSONException {
        Debug.MemoryInfo memoryInfo = new Debug.MemoryInfo();
        Debug.getMemoryInfo(memoryInfo);
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("dalvikPrivateDirty", m12494a(memoryInfo.dalvikPrivateDirty));
        jSONObject2.put("dalvikPss", m12494a(memoryInfo.dalvikPss));
        jSONObject2.put("dalvikSharedDirty", m12494a(memoryInfo.dalvikSharedDirty));
        jSONObject2.put("nativePrivateDirty", m12494a(memoryInfo.nativePrivateDirty));
        jSONObject2.put("nativePss", m12494a(memoryInfo.nativePss));
        jSONObject2.put("nativeSharedDirty", m12494a(memoryInfo.nativeSharedDirty));
        jSONObject2.put("otherPrivateDirty", m12494a(memoryInfo.otherPrivateDirty));
        jSONObject2.put("otherPss", m12494a(memoryInfo.otherPss));
        jSONObject2.put("otherSharedDirty", memoryInfo.otherSharedDirty);
        jSONObject2.put("totalPrivateClean", DebugMemInfoCompat.m12508a(memoryInfo));
        jSONObject2.put("totalPrivateDirty", memoryInfo.getTotalPrivateDirty());
        jSONObject2.put("totalPss", m12494a(memoryInfo.getTotalPss()));
        jSONObject2.put("totalSharedClean", DebugMemInfoCompat.m12509b(memoryInfo));
        jSONObject2.put("totalSharedDirty", m12494a(memoryInfo.getTotalSharedDirty()));
        jSONObject2.put("totalSwappablePss", m12494a(DebugMemInfoCompat.m12510c(memoryInfo)));
        jSONObject.put("memory_info", jSONObject2);
    }

    /* renamed from: e */
    public static String m12505e(Context context) {
        Class g = m12507g(context);
        if (f9368d == null && g != null) {
            try {
                f9368d = g.getDeclaredField("VERSION_NAME");
            } catch (NoSuchFieldException unused) {
            }
        }
        Field field = f9368d;
        if (field != null) {
            try {
                return (String) field.get(null);
            } catch (Throwable unused2) {
            }
        }
        return "";
    }

    /* renamed from: f */
    public static int m12506f(Context context) {
        Class g = m12507g(context);
        if (f9369e == null && g != null) {
            try {
                f9369e = g.getDeclaredField("VERSION_CODE");
            } catch (NoSuchFieldException unused) {
            }
        }
        Field field = f9369e;
        if (field != null) {
            try {
                return ((Integer) field.get(null)).intValue();
            } catch (Throwable unused2) {
            }
        }
        return -1;
    }

    /* renamed from: g */
    private static Class<?> m12507g(Context context) {
        if (f9367c == null && !f9370f) {
            try {
                StringBuilder sb = new StringBuilder();
                sb.append(context.getPackageName());
                sb.append(".BuildConfig");
                f9367c = Class.forName(sb.toString());
            } catch (ClassNotFoundException unused) {
            }
            f9370f = true;
        }
        return f9367c;
    }
}
