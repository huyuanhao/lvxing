package com.p620ut.device;

import android.content.Context;
import com.p570ta.utdid2.p571a.AidManager;

/* renamed from: com.ut.device.UTDevice */
public class UTDevice {
    public static String getUtdid(Context context) {
        return com.p570ta.utdid2.device.UTDevice.getUtdid(context);
    }

    public static String getAid(String str, String str2, Context context) {
        return AidManager.m28997a(context).mo32649a(str, str2, getUtdid(context));
    }

    public static void getAidAsync(String str, String str2, Context context, AidCallback aVar) {
        AidManager.m28997a(context).mo32650a(str, str2, getUtdid(context), aVar);
    }
}
