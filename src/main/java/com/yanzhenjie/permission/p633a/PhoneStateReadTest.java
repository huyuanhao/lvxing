package com.yanzhenjie.permission.p633a;

import android.content.Context;
import android.os.Build.VERSION;
import android.telephony.TelephonyManager;

/* renamed from: com.yanzhenjie.permission.a.m */
class PhoneStateReadTest implements PermissionTest {
    /* renamed from: a */
    private Context f26625a;

    PhoneStateReadTest(Context context) {
        this.f26625a = context;
    }

    /* renamed from: a */
    public boolean mo38007a() throws Throwable {
        if (!this.f26625a.getPackageManager().hasSystemFeature("android.hardware.telephony")) {
            return true;
        }
        TelephonyManager telephonyManager = (TelephonyManager) this.f26625a.getSystemService("phone");
        if (VERSION.SDK_INT < 29) {
            telephonyManager.getDeviceId();
        } else {
            telephonyManager.getDeviceSoftwareVersion();
        }
        return true;
    }
}
