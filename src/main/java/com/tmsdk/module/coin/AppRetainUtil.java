package com.tmsdk.module.coin;

import com.google.gson.Gson;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class AppRetainUtil {
    /* renamed from: C */
    static Gson f25872C = new Gson();
    /* renamed from: D */
    static List<AppRetainModel> f25873D = null;
    /* renamed from: E */
    private static ThreadLocal<SimpleDateFormat> f25874E = new ThreadLocal<>();

    public static List<AppRetainModel> getAllList() {
        f25873D = new ArrayList();
        Map all = AppRetainSpUtil.getISharePreferenceImp().getAll();
        if (all != null && !all.isEmpty()) {
            Set<String> keySet = all.keySet();
            if (keySet != null) {
                all.isEmpty();
            }
            for (String str : keySet) {
                f25873D.add((AppRetainModel) f25872C.fromJson((String) all.get(str), AppRetainModel.class));
            }
        }
        return f25873D;
    }

    public static List<AppRetainModel> getLastDAYList() {
        return getLastNDAYList(1);
    }

    public static List<AppRetainModel> getLastNDAYList(int i) {
        getAllList();
        if (f25873D.isEmpty()) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (AppRetainModel appRetainModel : f25873D) {
            if (isYestoday(appRetainModel.downloadOrInstallTime, System.currentTimeMillis(), i)) {
                arrayList.add(appRetainModel);
            }
        }
        return arrayList;
    }

    public static List<AppRetainModel> getLastSevenDAYList() {
        return getLastNDAYList(7);
    }

    public static List<AppRetainModel> getLastThreeDAYList() {
        return getLastNDAYList(3);
    }

    public static boolean isYestoday(long j, long j2, int i) {
        Calendar instance = Calendar.getInstance();
        instance.setTimeInMillis(j);
        int i2 = instance.get(6);
        int i3 = instance.get(1);
        int actualMaximum = instance.getActualMaximum(6);
        instance.setTimeInMillis(j2);
        int i4 = instance.get(6);
        if (instance.get(1) > i3) {
            i4 += actualMaximum;
        }
        return i2 - i4 == i || i4 - i2 == i;
    }

    public static void putDownloadAppToSp(String str, AppRetainModel appRetainModel) {
        AppRetainSpUtil.getISharePreferenceImp().putString(str, f25872C.toJson((Object) appRetainModel));
    }

    public static void putInstalledAppToSp(String str, AppRetainModel appRetainModel) {
        AppRetainSpUtil.getISharePreferenceImp().putString(str, f25872C.toJson((Object) appRetainModel));
    }
}
