package com.yanzhenjie.permission.p633a;

import android.content.Context;
import android.location.LocationManager;

/* renamed from: com.yanzhenjie.permission.a.i */
class LocationCoarseTest implements PermissionTest {
    /* renamed from: a */
    private Context f26623a;

    LocationCoarseTest(Context context) {
        this.f26623a = context;
    }

    /* renamed from: a */
    public boolean mo38007a() throws Throwable {
        LocationManager locationManager = (LocationManager) this.f26623a.getSystemService("location");
        String str = "network";
        if (!locationManager.getProviders(true).contains(str) && this.f26623a.getPackageManager().hasSystemFeature("android.hardware.location.network")) {
            return !locationManager.isProviderEnabled(str);
        }
        return true;
    }
}
