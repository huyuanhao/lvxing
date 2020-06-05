package com.kwad.sdk.p306a;

import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import androidx.core.content.ContextCompat;
import com.kwad.sdk.core.p319c.C4065b;

/* renamed from: com.kwad.sdk.a.c */
public class C3797c {
    /* renamed from: a */
    public static Location m15733a(Context context) {
        if (context == null) {
            return null;
        }
        try {
            LocationManager locationManager = (LocationManager) context.getSystemService("location");
            Location a = locationManager.isProviderEnabled("gps") ? m15734a(context, locationManager) : null;
            if (a == null && locationManager.isProviderEnabled("network")) {
                a = m15735b(context, locationManager);
            }
            if (a == null && locationManager.isProviderEnabled("passive")) {
                a = m15736c(context, locationManager);
            }
            return a;
        } catch (Exception e) {
            C4065b.m16865a(e);
            return null;
        }
    }

    /* renamed from: a */
    private static Location m15734a(Context context, LocationManager locationManager) {
        try {
            if (ContextCompat.checkSelfPermission(context, "android.permission.ACCESS_FINE_LOCATION") == 0) {
                return locationManager.getLastKnownLocation("gps");
            }
        } catch (Exception e) {
            C4065b.m16865a(e);
        }
        return null;
    }

    /* renamed from: b */
    private static Location m15735b(Context context, LocationManager locationManager) {
        try {
            if (ContextCompat.checkSelfPermission(context, "android.permission.ACCESS_FINE_LOCATION") == 0 || ContextCompat.checkSelfPermission(context, "android.permission.ACCESS_COARSE_LOCATION") == 0) {
                return locationManager.getLastKnownLocation("network");
            }
        } catch (Exception e) {
            C4065b.m16865a(e);
        }
        return null;
    }

    /* renamed from: c */
    private static Location m15736c(Context context, LocationManager locationManager) {
        try {
            if (ContextCompat.checkSelfPermission(context, "android.permission.ACCESS_COARSE_LOCATION") == 0) {
                return locationManager.getLastKnownLocation("passive");
            }
        } catch (Exception e) {
            C4065b.m16865a(e);
        }
        return null;
    }
}
