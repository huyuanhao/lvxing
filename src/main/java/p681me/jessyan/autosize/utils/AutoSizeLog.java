package p681me.jessyan.autosize.utils;

import android.util.Log;

/* renamed from: me.jessyan.autosize.utils.AutoSizeLog */
public class AutoSizeLog {
    private static final String TAG = "AndroidAutoSize";
    private static boolean debug;

    private AutoSizeLog() {
        throw new IllegalStateException("you can't instantiate me!");
    }

    public static boolean isDebug() {
        return debug;
    }

    public static void setDebug(boolean z) {
        debug = z;
    }

    /* renamed from: d */
    public static void m35489d(String str) {
        if (debug) {
            Log.d(TAG, str);
        }
    }

    /* renamed from: w */
    public static void m35491w(String str) {
        if (debug) {
            Log.w(TAG, str);
        }
    }

    /* renamed from: e */
    public static void m35490e(String str) {
        if (debug) {
            Log.e(TAG, str);
        }
    }
}
