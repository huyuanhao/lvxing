package com.yanzhenjie.permission.p633a;

import android.content.Context;
import android.location.LocationManager;
import java.util.List;

/* renamed from: com.yanzhenjie.permission.a.j */
class LocationFineTest implements PermissionTest {
    /* renamed from: a */
    private Context f26624a;

    LocationFineTest(Context context) {
        this.f26624a = context;
    }

    /* renamed from: a */
    public boolean mo38007a() throws Throwable {
        LocationManager locationManager = (LocationManager) this.f26624a.getSystemService("location");
        List providers = locationManager.getProviders(true);
        String str = "gps";
        boolean contains = providers.contains(str);
        boolean contains2 = providers.contains("passive");
        if (contains || contains2 || !this.f26624a.getPackageManager().hasSystemFeature("android.hardware.location.gps")) {
            return true;
        }
        return !locationManager.isProviderEnabled(str);
    }
}
