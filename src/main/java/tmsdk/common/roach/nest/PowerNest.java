package tmsdk.common.roach.nest;

import android.content.Context;
import tmsdk.common.roach.RoachE;
import tmsdk.wup.taf.jce.JceStruct;

public class PowerNest {
    public static final int CALLBACK_RUN_ON_THREAD = 0;
    public static final int CALLBACK_RUN_ON_UI = 8;
    public static final int S_ERR_NONE = 0;
    public static final int sNestVersion = 202;

    public static void actionDataReport() {
        RoachE.actionDataReport();
    }

    public static void addTask(Runnable runnable, String str) {
        RoachE.addTask(runnable, str);
    }

    public static byte[] decrypt(byte[] bArr, byte[] bArr2) {
        return RoachE.decrypt(bArr, bArr2);
    }

    public static byte[] encrypt(byte[] bArr, byte[] bArr2) {
        return RoachE.encrypt(bArr, bArr2);
    }

    public static Context getAppContext() {
        return RoachE.getAppContext();
    }

    public static String getGuid() {
        return RoachE.getGuid();
    }

    public static int getInt(String str, int i) {
        return RoachE.getInt(str, i);
    }

    public static long getLong(String str, long j) {
        return RoachE.getLong(str, j);
    }

    public static String getString(String str, String str2) {
        return RoachE.getString(str, str2);
    }

    public static void putInt(String str, int i) {
        RoachE.putInt(str, i);
    }

    public static void putLong(String str, long j) {
        RoachE.putLong(str, j);
    }

    public static void putString(String str, String str2) {
        RoachE.putString(str, str2);
    }

    public static void remove(String str) {
        RoachE.remove(str);
    }

    public static void saveActionData(int i) {
        RoachE.saveActionData(i);
    }

    public static void saveStringData(int i, String str) {
        RoachE.saveStringData(i, str);
    }

    public static boolean sendShark(int i, JceStruct jceStruct, JceStruct jceStruct2, int i2, ISharkCallBackNest iSharkCallBackNest, long j) {
        return RoachE.sendShark(i, jceStruct, jceStruct2, i2, iSharkCallBackNest, j);
    }
}
