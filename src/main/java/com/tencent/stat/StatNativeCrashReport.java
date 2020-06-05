package com.tencent.stat;

import android.content.Context;
import android.os.Build.VERSION;
import android.support.p000v4.media.session.PlaybackStateCompat;
import com.tencent.stat.common.StatCommonHelper;
import com.tencent.stat.common.StatLogger;
import com.tencent.stat.common.StatPreferences;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedHashSet;
import org.json.JSONArray;

public class StatNativeCrashReport {
    public static final String PRE_TAG_TOMBSTONE_FNAME = "tombstone_";
    public static final String SO_FULL_NAME = "libMtaNativeCrash_v2.so";
    public static final String SO_LOAD_NAME = "MtaNativeCrash_v2";
    /* renamed from: a */
    static StatNativeCrashReport f25414a = new StatNativeCrashReport();
    /* renamed from: b */
    private static StatLogger f25415b = StatCommonHelper.getLogger();
    /* renamed from: d */
    private static JSONArray f25416d;
    /* renamed from: e */
    private static Thread f25417e = null;
    /* renamed from: f */
    private static boolean f25418f;
    /* renamed from: g */
    private static boolean f25419g = false;
    /* renamed from: h */
    private static String f25420h = null;
    /* renamed from: i */
    private static boolean f25421i;
    /* renamed from: c */
    private volatile boolean f25422c = false;

    public native void enableNativeCrash(boolean z);

    public native void enableNativeCrashDebug(boolean z);

    public native boolean initJNICrash(String str, int i);

    public native String makeJniCrash();

    public native String stringFromJNI();

    static {
        f25418f = false;
        f25421i = false;
        try {
            System.loadLibrary(SO_LOAD_NAME);
            f25421i = true;
        } catch (Throwable unused) {
            f25418f = false;
            f25415b.mo37116w("can't find libMtaNativeCrash_v2.so, NativeCrash report disable.");
        }
    }

    /* renamed from: a */
    static JSONArray m32617a() {
        JSONArray jSONArray = new JSONArray();
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        if (stackTrace != null) {
            boolean z = false;
            for (StackTraceElement stackTraceElement : stackTrace) {
                if (stackTraceElement.getClassName().equals(StatNativeCrashReport.class.getName())) {
                    z = true;
                } else if (z) {
                    jSONArray.put(stackTraceElement.toString());
                }
            }
        }
        return jSONArray;
    }

    /* renamed from: b */
    private static void m32618b() {
        f25416d = m32617a();
        f25417e = Thread.currentThread();
    }

    public static void createNativeCrashEvent(String str) {
        StatLogger statLogger = f25415b;
        StringBuilder sb = new StringBuilder();
        sb.append("createNativeCrashEvent:");
        sb.append(str);
        statLogger.mo37101d(sb.toString());
        StatServiceImpl.m32625a(StatServiceImpl.getContext(null), (StatSpecifyReportedInfo) null, true);
        m32618b();
        StatServiceImpl.m32631a(f25416d, f25417e, str);
    }

    public static void doNativeCrashTest() {
        if (!f25421i) {
            f25415b.mo37116w("libMtaNativeCrash_v2.so not loaded.");
        } else {
            f25414a.makeJniCrash();
        }
    }

    public static void setNativeCrashEnable(boolean z) {
        if (!f25421i) {
            f25415b.mo37116w("libMtaNativeCrash_v2.so not loaded.");
            return;
        }
        try {
            f25414a.enableNativeCrash(z);
            f25418f = z;
        } catch (Throwable th) {
            f25415b.mo37116w(th);
        }
    }

    public static boolean isNativeCrashEnable() {
        return f25418f;
    }

    public static void setNativeCrashDebugEnable(boolean z) {
        if (!f25421i) {
            f25415b.mo37116w("libMtaNativeCrash_v2.so not loaded.");
            return;
        }
        try {
            f25414a.enableNativeCrashDebug(z);
            f25419g = z;
        } catch (Throwable th) {
            f25415b.mo37116w(th);
        }
    }

    public static boolean isNativeCrashDebugEnable() {
        return f25419g;
    }

    public static void initNativeCrash(Context context, String str) {
        if (!f25421i) {
            f25415b.mo37116w("libMtaNativeCrash_v2.so not loaded.");
        } else if (!f25414a.f25422c) {
            if (str == null) {
                try {
                    str = context.getDir("tombstones", 0).getAbsolutePath();
                } catch (Throwable th) {
                    f25415b.mo37116w(th);
                }
            }
            f25420h = str;
            StatPreferences.putString(context, "__mta_tombstone__", str);
            setNativeCrashEnable(true);
            f25414a.initJNICrash(str, VERSION.SDK_INT);
            f25414a.f25422c = true;
            if (StatConfig.isDebugEnable()) {
                f25415b.mo37101d("initNativeCrash success.");
            }
        }
    }

    public static String getTombstonesDir(Context context) {
        if (f25420h == null) {
            f25420h = StatPreferences.getString(context, "__mta_tombstone__", "");
        }
        return f25420h;
    }

    public static String readFile(File file) {
        StringBuilder sb = new StringBuilder();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                }
                sb.append(readLine);
                sb.append(10);
            }
            bufferedReader.close();
        } catch (IOException e) {
            f25415b.mo37104e((Throwable) e);
        }
        return sb.toString();
    }

    public static LinkedHashSet<File> getCrashEventsFilesList(Context context) {
        LinkedHashSet<File> linkedHashSet = new LinkedHashSet<>();
        String absolutePath = context.getDir("mtajcrash", 0).getAbsolutePath();
        if (absolutePath != null) {
            File file = new File(absolutePath);
            if (file.isDirectory()) {
                File[] listFiles = file.listFiles();
                if (listFiles != null) {
                    int length = listFiles.length;
                    for (int i = 0; i < length; i++) {
                        File file2 = listFiles[i];
                        if (file2.exists() && file2.length() > PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED) {
                            try {
                                file2.delete();
                            } catch (Throwable unused) {
                            }
                        } else if (file2.getName().endsWith(".v1.crash") && file2.isFile()) {
                            if (StatConfig.isDebugEnable()) {
                                StatLogger statLogger = f25415b;
                                StringBuilder sb = new StringBuilder();
                                sb.append("get tombstone file:");
                                sb.append(file2.getAbsolutePath().toString());
                                statLogger.mo37101d(sb.toString());
                            }
                            linkedHashSet.add(file2.getAbsoluteFile());
                        }
                    }
                }
            }
        }
        return linkedHashSet;
    }
}
