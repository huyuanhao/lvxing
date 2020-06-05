package com.bytedance.sdk.openadsdk.utils;

import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.TTLocation;
import com.bytedance.sdk.openadsdk.core.AdPreference;
import com.bytedance.sdk.openadsdk.core.GlobalInfo;
import com.bytedance.sdk.openadsdk.core.InternalContainer;
import com.bytedance.sdk.openadsdk.p198i.TTExecutor;
import com.bytedance.sdk.openadsdk.p198i.TTFutureTask;
import com.bytedance.sdk.openadsdk.p198i.TTRunnable;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/* renamed from: com.bytedance.sdk.openadsdk.utils.d */
public class AdLocationUtils {
    /* renamed from: a */
    private static long f9148a = 1800000;
    /* renamed from: b */
    private static Handler f9149b = new Handler(Looper.getMainLooper());

    /* compiled from: AdLocationUtils */
    /* renamed from: com.bytedance.sdk.openadsdk.utils.d$a */
    private static class C2546a implements Callable<TTLocation> {
        private C2546a() {
        }

        /* renamed from: a */
        public TTLocation call() throws Exception {
            return GlobalInfo.m9616c().mo15672d().getTTLocation();
        }
    }

    /* compiled from: AdLocationUtils */
    /* renamed from: com.bytedance.sdk.openadsdk.utils.d$b */
    private static class C2547b implements Callable<Location> {
        /* renamed from: a */
        private LocationManager f9158a;
        /* renamed from: b */
        private String f9159b;

        public C2547b(LocationManager locationManager, String str) {
            this.f9158a = locationManager;
            this.f9159b = str;
        }

        /* renamed from: a */
        public Location call() throws Exception {
            long currentTimeMillis = System.currentTimeMillis();
            Location lastKnownLocation = this.f9158a.getLastKnownLocation(this.f9159b);
            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
            StringBuilder sb = new StringBuilder();
            sb.append("location:");
            sb.append(lastKnownLocation);
            sb.append(",getLastKnownLocation use time :");
            sb.append(currentTimeMillis2);
            C2564t.m12220b("AdLocationUtils", sb.toString());
            return lastKnownLocation;
        }
    }

    /* renamed from: a */
    public static AdLocation m12114a(Context context) {
        if (!GlobalInfo.m9616c().mo15672d().isCanUseLocation() && GlobalInfo.m9616c().mo15672d().getTTLocation() == null) {
            return null;
        }
        Context a = context == null ? InternalContainer.m10059a() : context.getApplicationContext();
        f9148a = (long) (InternalContainer.m10069h().mo15801m() * 60 * 1000);
        AdLocation c = m12126c(a);
        if (!m12124b(a)) {
            return c;
        }
        return m12127d(a);
    }

    /* renamed from: b */
    private static boolean m12124b(Context context) {
        long longValue = AdPreference.m9212a(context).mo15326b("lbstime", -1).longValue();
        return longValue == -1 || System.currentTimeMillis() - longValue > f9148a;
    }

    /* renamed from: c */
    private static AdLocation m12126c(Context context) {
        AdPreference a = AdPreference.m9212a(context);
        float b = a.mo15324b("latitude", -1.0f);
        float b2 = a.mo15324b("longitude", -1.0f);
        if (b == -1.0f || b2 == -1.0f) {
            return null;
        }
        return new AdLocation(b, b2);
    }

    /* renamed from: d */
    private static AdLocation m12127d(final Context context) {
        AdLocation cVar = null;
        if (!GlobalInfo.m9616c().mo15672d().isCanUseLocation()) {
            try {
                TTLocation a = m12113a();
                if (a != null) {
                    m12117a(context, a);
                    return new AdLocation(Double.valueOf(a.getLatitude()).floatValue(), Double.valueOf(a.getLongitude()).floatValue());
                }
            } catch (Throwable unused) {
            }
            return null;
        }
        final LocationManager locationManager = (LocationManager) context.getSystemService("location");
        if (locationManager != null) {
            try {
                Location a2 = m12111a(locationManager);
                if (a2 != null && m12125b(a2)) {
                    m12121b(context, a2);
                    cVar = new AdLocation((float) a2.getLatitude(), (float) a2.getLongitude());
                }
                if (Looper.myLooper() != Looper.getMainLooper()) {
                    new Handler(Looper.getMainLooper()).post(new Runnable() {
                        public void run() {
                            AdLocationUtils.m12122b(context, locationManager);
                        }
                    });
                } else {
                    m12122b(context, locationManager);
                }
            } catch (Throwable th) {
                if (C2564t.m12224c()) {
                    th.printStackTrace();
                }
            }
        }
        return cVar;
    }

    /* renamed from: a */
    private static Location m12111a(LocationManager locationManager) {
        Location a = m12112a(locationManager, "gps");
        if (a == null) {
            a = m12112a(locationManager, "network");
        }
        return a == null ? m12112a(locationManager, "passive") : a;
    }

    /* renamed from: a */
    private static Location m12112a(LocationManager locationManager, String str) {
        try {
            final TTFutureTask bVar = new TTFutureTask(new C2547b(locationManager, str), 1, 2);
            TTExecutor.m11692a().mo16806b(new TTRunnable() {
                public void run() {
                    bVar.run();
                }
            });
            return (Location) bVar.get(1, TimeUnit.SECONDS);
        } catch (Throwable unused) {
            return null;
        }
    }

    /* renamed from: a */
    private static TTLocation m12113a() {
        try {
            final TTFutureTask bVar = new TTFutureTask(new C2546a(), 1, 2);
            TTExecutor.m11692a().mo16806b(new TTRunnable() {
                public void run() {
                    bVar.run();
                }
            });
            TTLocation tTLocation = (TTLocation) bVar.get(1, TimeUnit.SECONDS);
            StringBuilder sb = new StringBuilder();
            sb.append("location dev:");
            sb.append(tTLocation);
            C2564t.m12220b("AdLocationUtils", sb.toString());
            return tTLocation;
        } catch (Throwable unused) {
            return null;
        }
    }

    /* renamed from: b */
    private static String m12120b(LocationManager locationManager) {
        String str = "gps";
        if (locationManager.isProviderEnabled(str)) {
            return str;
        }
        String str2 = "network";
        if (locationManager.isProviderEnabled(str2)) {
            return str2;
        }
        String str3 = "passive";
        if (locationManager.isProviderEnabled(str3)) {
            return str3;
        }
        return null;
    }

    /* access modifiers changed from: private|static */
    /* renamed from: b */
    public static void m12122b(final Context context, final LocationManager locationManager) {
        if (!(context == null || locationManager == null)) {
            final C25444 r0 = new LocationListener() {
                public void onProviderDisabled(String str) {
                }

                public void onProviderEnabled(String str) {
                }

                public void onStatusChanged(String str, int i, Bundle bundle) {
                }

                public void onLocationChanged(Location location) {
                    if (location != null && AdLocationUtils.m12125b(location)) {
                        AdLocationUtils.m12121b(context, location);
                    }
                    AdLocationUtils.m12123b(locationManager, (LocationListener) this);
                }
            };
            try {
                String b = m12120b(locationManager);
                if (!TextUtils.isEmpty(b)) {
                    locationManager.requestSingleUpdate(b, r0, Looper.getMainLooper());
                    f9149b.postDelayed(new Runnable() {
                        public void run() {
                            AdLocationUtils.m12123b(locationManager, r0);
                        }
                    }, 30000);
                }
            } catch (Throwable th) {
                if (C2564t.m12224c()) {
                    th.printStackTrace();
                }
                m12123b(locationManager, (LocationListener) r0);
            }
        }
    }

    /* access modifiers changed from: private|static */
    /* renamed from: b */
    public static void m12123b(LocationManager locationManager, LocationListener locationListener) {
        if (locationManager != null && locationListener != null) {
            try {
                locationManager.removeUpdates(locationListener);
            } catch (Throwable th) {
                if (C2564t.m12224c()) {
                    th.printStackTrace();
                }
            }
        }
    }

    /* access modifiers changed from: private|static */
    /* renamed from: b */
    public static void m12121b(Context context, Location location) {
        if (m12125b(location)) {
            AdPreference a = AdPreference.m9212a(context);
            a.mo15319a("latitude", (float) location.getLatitude());
            a.mo15319a("longitude", (float) location.getLongitude());
            a.mo15321a("lbstime", System.currentTimeMillis());
        }
    }

    /* renamed from: a */
    private static void m12117a(Context context, TTLocation tTLocation) {
        if (tTLocation != null && tTLocation.getLatitude() != 0.0d && tTLocation.getLongitude() != 0.0d) {
            AdPreference a = AdPreference.m9212a(context);
            a.mo15319a("latitude", (float) tTLocation.getLatitude());
            a.mo15319a("longitude", (float) tTLocation.getLongitude());
            a.mo15321a("lbstime", System.currentTimeMillis());
        }
    }

    /* access modifiers changed from: private|static */
    /* renamed from: b */
    public static boolean m12125b(Location location) {
        return (location.getLatitude() == 0.0d || location.getLongitude() == 0.0d) ? false : true;
    }
}
