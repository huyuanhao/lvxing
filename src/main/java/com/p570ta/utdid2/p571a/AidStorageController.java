package com.p570ta.utdid2.p571a;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build.VERSION;
import android.util.Log;
import com.p570ta.utdid2.p572b.p573a.Base64Helper;
import com.p570ta.utdid2.p572b.p573a.C6797b;
import com.p570ta.utdid2.p572b.p573a.C6804i;
import com.p570ta.utdid2.p572b.p573a.DebugUtils;
import com.p570ta.utdid2.p572b.p573a.SharedPreferenceHelper;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: com.ta.utdid2.a.c */
public class AidStorageController {
    private static final String TAG = AidStorageController.class.getName();
    /* renamed from: a */
    private static Map<String, String> f22483a = new ConcurrentHashMap();
    /* renamed from: b */
    private static Map<String, Long> f22484b = new ConcurrentHashMap();

    /* renamed from: a */
    public static void m29013a(Context context, String str, String str2, String str3) {
        if (context == null) {
            Log.e(TAG, "no context!");
            return;
        }
        String c = m29014c(str, str3);
        long currentTimeMillis = System.currentTimeMillis();
        f22483a.put(c, str2);
        f22484b.put(c, Long.valueOf(currentTimeMillis));
        SharedPreferences sharedPreferences = context.getSharedPreferences("OfJbkLdFbPOMbGyP", 0);
        String str4 = "rKrMJgyAEbVtSQGi";
        String str5 = "EvQwnbilKezpOJey";
        if (VERSION.SDK_INT >= 9) {
            SharedPreferenceHelper.m29032a(sharedPreferences.edit().putString(str5.concat(c), str2));
            SharedPreferenceHelper.m29032a(sharedPreferences.edit().putLong(str4.concat(c), currentTimeMillis));
        } else {
            sharedPreferences.edit().putString(str5.concat(c), str2).commit();
            sharedPreferences.edit().putLong(str4.concat(c), currentTimeMillis).commit();
        }
    }

    /* renamed from: a */
    public static String m29012a(Context context, String str, String str2) {
        String str3 = "";
        if (context == null) {
            Log.e(TAG, "no context!");
            return str3;
        }
        String c = m29014c(str, str2);
        String str4 = (String) f22483a.get(c);
        if (DebugUtils.f22504e) {
            String str5 = TAG;
            StringBuilder sb = new StringBuilder("cache AID:");
            sb.append(str4);
            Log.d(str5, sb.toString());
        }
        if (C6804i.m29033a(str4)) {
            str4 = context.getSharedPreferences("OfJbkLdFbPOMbGyP", 0).getString("EvQwnbilKezpOJey".concat(c), str3);
            f22483a.put(c, str4);
        }
        return str4;
    }

    /* renamed from: a */
    public static long m29011a(Context context, String str, String str2) {
        if (context == null) {
            Log.e(TAG, "no context!");
            return 0;
        }
        String c = m29014c(str, str2);
        Long valueOf = Long.valueOf(f22484b.containsKey(c) ? ((Long) f22484b.get(c)).longValue() : 0);
        if (DebugUtils.f22504e) {
            String str3 = TAG;
            StringBuilder sb = new StringBuilder("cache AIDGenTime:");
            sb.append(valueOf);
            Log.d(str3, sb.toString());
        }
        if (valueOf.longValue() == 0) {
            valueOf = Long.valueOf(context.getSharedPreferences("OfJbkLdFbPOMbGyP", 0).getLong("rKrMJgyAEbVtSQGi".concat(c), 0));
            f22484b.put(c, valueOf);
        }
        return valueOf.longValue();
    }

    /* renamed from: c */
    private static String m29014c(String str, String str2) {
        String str3;
        if (VERSION.SDK_INT >= 8) {
            str3 = Base64Helper.encodeToString(str.concat(str2).getBytes(), 2);
        } else {
            str3 = C6797b.encodeToString(str.concat(str2).getBytes(), 2);
        }
        if (DebugUtils.f22504e) {
            String str4 = TAG;
            StringBuilder sb = new StringBuilder("encodedName:");
            sb.append(str3);
            Log.d(str4, sb.toString());
        }
        return str3;
    }
}
