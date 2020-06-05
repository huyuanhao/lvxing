package com.tencent.stat.lbs;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.telephony.CellLocation;
import android.telephony.NeighboringCellInfo;
import android.telephony.TelephonyManager;
import android.telephony.cdma.CdmaCellLocation;
import android.telephony.gsm.GsmCellLocation;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.tencent.mid.sotrage.StorageInterface;
import com.tencent.stat.StatActionListener;
import com.tencent.stat.StatConfig;
import com.tencent.stat.StatServiceImpl;
import com.tencent.stat.common.StatCommonHelper;
import com.tencent.stat.common.StatLogger;
import com.tencent.stat.common.Util;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class StatGpsMonitor {
    /* renamed from: a */
    private static volatile StatGpsMonitor f25832a;
    /* access modifiers changed from: private|static */
    /* renamed from: i */
    public static StatLogger f25833i = StatCommonHelper.getLogger();
    /* renamed from: o */
    private static long f25834o = 1800000;
    /* access modifiers changed from: private */
    /* renamed from: b */
    public LocationManager f25835b = null;
    /* access modifiers changed from: private|volatile */
    /* renamed from: c */
    public volatile Location f25836c = null;
    /* renamed from: d */
    private volatile long f25837d = 0;
    /* renamed from: e */
    private volatile Location f25838e = null;
    /* access modifiers changed from: private */
    /* renamed from: f */
    public LocationListener f25839f = null;
    /* access modifiers changed from: private */
    /* renamed from: g */
    public LocationListener f25840g = null;
    /* access modifiers changed from: private */
    /* renamed from: h */
    public Handler f25841h = null;
    /* renamed from: j */
    private Context f25842j = StatServiceImpl.getContext(null);
    /* renamed from: k */
    private boolean f25843k = false;
    /* renamed from: l */
    private PendingIntent f25844l = null;
    /* renamed from: m */
    private BroadcastReceiver f25845m = null;
    /* renamed from: n */
    private AlarmManager f25846n = null;
    /* renamed from: p */
    private StatActionListener f25847p = new StatActionListener() {
        public void onBecameForeground() {
            StatGpsMonitor.this.m32897f();
        }

        public void onBecameBackground() {
            StatGpsMonitor.this.m32899g();
        }
    };

    /* renamed from: com.tencent.stat.lbs.StatGpsMonitor$a */
    private class C7646a implements LocationListener {
        /* renamed from: b */
        private String f25856b = "";

        public C7646a(String str) {
            this.f25856b = str;
        }

        public void onStatusChanged(String str, int i, Bundle bundle) {
            StatLogger c = StatGpsMonitor.f25833i;
            StringBuilder sb = new StringBuilder();
            sb.append(this.f25856b);
            sb.append(" gps onStatusChanged status:");
            sb.append(i);
            sb.append(",extras:");
            sb.append(bundle);
            sb.append(", provider:");
            sb.append(str);
            c.mo37108i(sb.toString());
            if (i == 0) {
                StatLogger c2 = StatGpsMonitor.f25833i;
                StringBuilder sb2 = new StringBuilder();
                sb2.append(str);
                sb2.append(" OUT_OF_SERVICE gps");
                c2.mo37108i(sb2.toString());
            } else if (i == 1) {
                StatLogger c3 = StatGpsMonitor.f25833i;
                StringBuilder sb3 = new StringBuilder();
                sb3.append(str);
                sb3.append(" TEMPORARILY_UNAVAILABLE gps");
                c3.mo37108i(sb3.toString());
            } else if (i == 2) {
                StatLogger c4 = StatGpsMonitor.f25833i;
                StringBuilder sb4 = new StringBuilder();
                sb4.append(str);
                sb4.append(" AVAILABLE gps");
                c4.mo37108i(sb4.toString());
            }
        }

        public void onProviderEnabled(String str) {
            StatLogger c = StatGpsMonitor.f25833i;
            StringBuilder sb = new StringBuilder();
            sb.append(this.f25856b);
            sb.append(" gps onProviderEnabled provider:");
            sb.append(str);
            c.mo37101d(sb.toString());
            if (StatGpsMonitor.this.f25836c == null) {
                try {
                    StatGpsMonitor.this.f25836c = StatGpsMonitor.this.f25835b.getLastKnownLocation(StatGpsMonitor.this.m32901h());
                } catch (Exception e) {
                    StatGpsMonitor.f25833i.mo37104e((Throwable) e);
                }
            }
        }

        public void onProviderDisabled(String str) {
            StatLogger c = StatGpsMonitor.f25833i;
            StringBuilder sb = new StringBuilder();
            sb.append(this.f25856b);
            sb.append(" gps onProviderDisabled provider:");
            sb.append(str);
            c.mo37101d(sb.toString());
        }

        public void onLocationChanged(Location location) {
            if (location != null) {
                StatLogger c = StatGpsMonitor.f25833i;
                StringBuilder sb = new StringBuilder();
                sb.append(this.f25856b);
                sb.append(" gps onLocationChanged location:");
                sb.append(location.getLatitude());
                String str = StorageInterface.KEY_SPLITER;
                sb.append(str);
                sb.append(location.getLongitude());
                sb.append(str);
                sb.append(location.getTime());
                sb.append("==?");
                sb.append(System.currentTimeMillis());
                c.mo37108i(sb.toString());
                StatGpsMonitor statGpsMonitor = StatGpsMonitor.this;
                if (statGpsMonitor.m32883a(location, statGpsMonitor.f25836c)) {
                    StatGpsMonitor.this.f25836c = location;
                }
            }
        }
    }

    public static StatGpsMonitor getInstance() {
        if (f25832a == null) {
            synchronized (StatGpsMonitor.class) {
                if (f25832a == null) {
                    f25832a = new StatGpsMonitor();
                }
            }
        }
        return f25832a;
    }

    public void init(StatGpsOption statGpsOption) {
        f25833i.mo37101d("init StatGpsMonitor");
        HandlerThread handlerThread = new HandlerThread("fbilbs");
        handlerThread.start();
        this.f25841h = new Handler(handlerThread.getLooper());
        this.f25846n = (AlarmManager) this.f25842j.getSystemService(NotificationCompat.CATEGORY_ALARM);
        this.f25835b = (LocationManager) this.f25842j.getSystemService("location");
        m32882a(statGpsOption);
    }

    public void startMonitor() {
        if (!this.f25843k) {
            f25833i.mo37101d("startMonitor");
            StatServiceImpl.addActionListener(this.f25847p);
            m32897f();
            this.f25843k = true;
        }
    }

    public void stopMonitor() {
        if (this.f25843k) {
            f25833i.mo37101d("stopMonitor");
            StatServiceImpl.removeActionListener(this.f25847p);
            m32899g();
            m32903i();
            this.f25843k = false;
        }
    }

    public Location getLastLocation() {
        return this.f25836c;
    }

    /* renamed from: d */
    private void m32892d() {
        StatLogger statLogger = f25833i;
        StringBuilder sb = new StringBuilder();
        sb.append("gps reportCurLocation:");
        sb.append(this.f25836c);
        statLogger.mo37101d(sb.toString());
        Context context = this.f25842j;
        StatServiceImpl.reportEvent(this.f25842j, new C7647a(context, StatServiceImpl.getSessionID(context, false, null), null), null);
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public void m32895e() {
        try {
            m32892d();
            m32897f();
        } catch (Throwable th) {
            f25833i.mo37116w(th);
        }
    }

    public static long getLbsReportDuration(Context context) {
        long longValue = Long.valueOf(StatConfig.getCustomProperty(context, "_lbs_du_", "0")).longValue();
        if (longValue > 30000) {
            f25834o = longValue;
        }
        return f25834o;
    }

    public static void setLbsReportDuration(Context context, long j) {
        f25834o = j;
    }

    /* access modifiers changed from: private */
    /* renamed from: f */
    public void m32897f() {
        try {
            long lbsReportDuration = getLbsReportDuration(this.f25842j);
            long currentTimeMillis = System.currentTimeMillis();
            if (this.f25844l == null) {
                synchronized (StatGpsMonitor.class) {
                    if (this.f25844l == null) {
                        this.f25844l = PendingIntent.getBroadcast(this.f25842j, 0, new Intent("com.tencent.fbi.lbs.report.action"), 134217728);
                        m32892d();
                        this.f25845m = new BroadcastReceiver() {
                            public void onReceive(Context context, Intent intent) {
                                StatLogger c = StatGpsMonitor.f25833i;
                                StringBuilder sb = new StringBuilder();
                                sb.append("hearbeat onReceive:");
                                sb.append(intent);
                                c.mo37108i(sb.toString());
                                StatGpsMonitor.this.f25841h.post(new Runnable() {
                                    public void run() {
                                        StatGpsMonitor.this.m32895e();
                                    }
                                });
                            }
                        };
                        try {
                            StatLogger statLogger = f25833i;
                            StringBuilder sb = new StringBuilder();
                            sb.append("registerReceiver:");
                            sb.append(this.f25845m);
                            statLogger.mo37108i(sb.toString());
                            this.f25842j.registerReceiver(this.f25845m, new IntentFilter("com.tencent.fbi.lbs.report.action"));
                        } catch (Throwable th) {
                            th.printStackTrace();
                        }
                    }
                }
            }
            StatLogger statLogger2 = f25833i;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("AlarmManager set reportInterval:");
            sb2.append(lbsReportDuration);
            sb2.append(",reportPendingIntent:");
            sb2.append(this.f25844l);
            statLogger2.mo37108i(sb2.toString());
            this.f25846n.set(0, currentTimeMillis + lbsReportDuration, this.f25844l);
        } catch (Throwable th2) {
            f25833i.mo37116w(th2);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: g */
    public void m32899g() {
        try {
            StatLogger statLogger = f25833i;
            StringBuilder sb = new StringBuilder();
            sb.append("stopReporting, reportPendingIntent=");
            sb.append(this.f25844l);
            sb.append(",reportBroadcastReceiver=");
            sb.append(this.f25845m);
            statLogger.mo37108i(sb.toString());
            if (this.f25844l != null) {
                this.f25846n.cancel(this.f25844l);
                this.f25844l = null;
            }
            if (this.f25845m != null) {
                this.f25842j.unregisterReceiver(this.f25845m);
                this.f25845m = null;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public JSONObject mo37202a() {
        try {
            JSONObject jSONObject = new JSONObject();
            try {
                TelephonyManager telephonyManager = (TelephonyManager) this.f25842j.getSystemService("phone");
                String networkOperator = telephonyManager.getNetworkOperator();
                CellLocation cellLocation = telephonyManager.getCellLocation();
                String str = "mnc";
                String str2 = "mcc";
                String str3 = "op";
                String str4 = "type";
                String str5 = "cid";
                String str6 = "lac";
                if (cellLocation instanceof GsmCellLocation) {
                    StatLogger statLogger = f25833i;
                    StringBuilder sb = new StringBuilder();
                    sb.append("CellLocation type:GsmCellLocation:");
                    sb.append(cellLocation);
                    statLogger.mo37108i(sb.toString());
                    jSONObject.put(str4, "gsm");
                    jSONObject.put(str6, ((GsmCellLocation) cellLocation).getLac());
                    jSONObject.put(str5, ((GsmCellLocation) cellLocation).getCid());
                    if (networkOperator != null && networkOperator.length() >= 6) {
                        jSONObject.put(str3, networkOperator);
                        jSONObject.put(str2, networkOperator.substring(0, 3));
                        jSONObject.put(str, networkOperator.substring(3, 5));
                    }
                } else if (cellLocation instanceof CdmaCellLocation) {
                    StatLogger statLogger2 = f25833i;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("CellLocation type:CdmaCellLocation:");
                    sb2.append(cellLocation);
                    statLogger2.mo37108i(sb2.toString());
                    CdmaCellLocation cdmaCellLocation = (CdmaCellLocation) cellLocation;
                    jSONObject.put(str4, "cdma");
                    jSONObject.put(str6, cdmaCellLocation.getNetworkId());
                    jSONObject.put(str5, cdmaCellLocation.getBaseStationId());
                    jSONObject.put("lat", cdmaCellLocation.getBaseStationLatitude());
                    jSONObject.put("lng", cdmaCellLocation.getBaseStationLongitude());
                    if (networkOperator != null && networkOperator.length() >= 6) {
                        jSONObject.put(str3, networkOperator);
                        jSONObject.put(str2, networkOperator.substring(0, 3));
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append(cdmaCellLocation.getSystemId());
                        sb3.append("");
                        jSONObject.put(str, sb3.toString());
                    }
                } else {
                    f25833i.mo37116w("error CellLocation type");
                    return null;
                }
                jSONObject.put("nt", telephonyManager.getNetworkType());
                StatLogger statLogger3 = f25833i;
                StringBuilder sb4 = new StringBuilder();
                sb4.append("cellLoc:");
                sb4.append(jSONObject);
                statLogger3.mo37108i(sb4.toString());
                JSONArray jSONArray = new JSONArray();
                List<NeighboringCellInfo> neighboringCellInfo = telephonyManager.getNeighboringCellInfo();
                if (neighboringCellInfo != null && neighboringCellInfo.size() > 0) {
                    StatLogger statLogger4 = f25833i;
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append("infoLists:");
                    sb5.append(neighboringCellInfo);
                    sb5.append("     size:");
                    sb5.append(neighboringCellInfo.size());
                    statLogger4.mo37108i(sb5.toString());
                    for (NeighboringCellInfo neighboringCellInfo2 : neighboringCellInfo) {
                        StatLogger statLogger5 = f25833i;
                        StringBuilder sb6 = new StringBuilder();
                        sb6.append("get neighboringCellInfo:");
                        sb6.append(neighboringCellInfo2);
                        statLogger5.mo37108i(sb6.toString());
                        if (!(neighboringCellInfo2.getRssi() == 99 || neighboringCellInfo2.getCid() == -1)) {
                            JSONObject jSONObject2 = new JSONObject();
                            jSONObject2.put("dBm", (neighboringCellInfo2.getRssi() * 2) - 133);
                            jSONObject2.put("rssi", neighboringCellInfo2.getRssi());
                            jSONObject2.put(str6, neighboringCellInfo2.getLac());
                            jSONObject2.put(str5, neighboringCellInfo2.getCid());
                            jSONArray.put(jSONObject2);
                        }
                    }
                }
                if (jSONArray.length() > 0) {
                    jSONObject.put("nb", jSONArray);
                }
                return jSONObject;
            } catch (Throwable th) {
                th = th;
                f25833i.mo37104e(th);
                return null;
            }
        } catch (Throwable th2) {
            th = th2;
            f25833i.mo37104e(th);
            return null;
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public JSONObject mo37203b() {
        JSONObject jSONObject = new JSONObject();
        if (this.f25836c != null) {
            Util.safeJsonPut(jSONObject, "lat", Double.valueOf(this.f25836c.getLatitude()));
            Util.safeJsonPut(jSONObject, "lng", Double.valueOf(this.f25836c.getLongitude()));
            Util.safeJsonPut(jSONObject, "alt", Double.valueOf(this.f25836c.getAltitude()));
            Util.safeJsonPut(jSONObject, "bear", Float.valueOf(this.f25836c.getBearing()));
            Util.safeJsonPut(jSONObject, "acc", Float.valueOf(this.f25836c.getAccuracy()));
            Util.safeJsonPut(jSONObject, "time", Long.valueOf(this.f25836c.getTime()));
            Util.safeJsonPut(jSONObject, "sp", Float.valueOf(this.f25836c.getSpeed()));
            Util.safeJsonPut(jSONObject, "pvd", this.f25836c.getProvider());
        }
        return jSONObject;
    }

    /* access modifiers changed from: private */
    /* renamed from: h */
    public String m32901h() {
        Criteria criteria = new Criteria();
        criteria.setAccuracy(1);
        criteria.setAltitudeRequired(false);
        criteria.setBearingRequired(false);
        criteria.setCostAllowed(false);
        criteria.setPowerRequirement(1);
        return this.f25835b.getBestProvider(criteria, true);
    }

    /* renamed from: a */
    private void m32882a(StatGpsOption statGpsOption) {
        f25833i.mo37101d("registerGps");
        if (statGpsOption == null) {
            statGpsOption = new StatGpsOption();
        }
        m32888b(statGpsOption);
        m32891c(statGpsOption);
    }

    /* renamed from: b */
    private void m32888b(final StatGpsOption statGpsOption) {
        if (this.f25839f == null) {
            Handler handler = this.f25841h;
            if (handler != null) {
                handler.post(new Runnable() {
                    public void run() {
                        try {
                            StatGpsMonitor.f25833i.mo37101d("registerGpsLocationListener");
                            StatGpsMonitor.this.f25839f = new C7646a("gps");
                            String e = StatGpsMonitor.this.m32901h();
                            if (!TextUtils.isEmpty(e)) {
                                Location lastKnownLocation = StatGpsMonitor.this.f25835b.getLastKnownLocation(e);
                                if (StatGpsMonitor.this.m32883a(StatGpsMonitor.this.f25836c, lastKnownLocation)) {
                                    StatGpsMonitor.this.f25836c = lastKnownLocation;
                                }
                                StatGpsMonitor.this.f25835b.requestLocationUpdates("gps", statGpsOption.getMinTime(), statGpsOption.getMinDistance(), StatGpsMonitor.this.f25839f);
                            }
                        } catch (Throwable th) {
                            StatGpsMonitor.f25833i.mo37104e(th);
                        }
                    }
                });
            }
        }
    }

    /* renamed from: c */
    private void m32891c(final StatGpsOption statGpsOption) {
        if (this.f25840g == null) {
            Handler handler = this.f25841h;
            if (handler != null) {
                handler.post(new Runnable() {
                    public void run() {
                        try {
                            StatGpsMonitor.f25833i.mo37101d("registerNetworkLocationListener");
                            StatGpsMonitor.this.f25840g = new C7646a("network");
                            if (StatGpsMonitor.this.m32901h() != null) {
                                Location lastKnownLocation = StatGpsMonitor.this.f25835b.getLastKnownLocation(StatGpsMonitor.this.m32901h());
                                if (StatGpsMonitor.this.m32883a(StatGpsMonitor.this.f25836c, lastKnownLocation)) {
                                    StatGpsMonitor.this.f25836c = lastKnownLocation;
                                }
                                StatGpsMonitor.this.f25835b.requestLocationUpdates("gps", statGpsOption.getMinTime(), statGpsOption.getMinDistance(), StatGpsMonitor.this.f25840g);
                            }
                        } catch (Throwable th) {
                            StatGpsMonitor.f25833i.mo37104e(th);
                        }
                    }
                });
            }
        }
    }

    /* renamed from: i */
    private void m32903i() {
        m32904j();
        m32905k();
    }

    /* renamed from: j */
    private void m32904j() {
        LocationListener locationListener = this.f25839f;
        if (locationListener != null) {
            this.f25835b.removeUpdates(locationListener);
            this.f25839f = null;
        }
    }

    /* renamed from: k */
    private void m32905k() {
        LocationListener locationListener = this.f25840g;
        if (locationListener != null) {
            this.f25835b.removeUpdates(locationListener);
            this.f25839f = null;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public boolean m32883a(Location location, Location location2) {
        if (location2 == null) {
            return true;
        }
        if (location == null) {
            return false;
        }
        long time = location.getTime() - location2.getTime();
        boolean z = time > 120000;
        boolean z2 = time < -120000;
        boolean z3 = time > 0;
        if (z) {
            return true;
        }
        if (z2) {
            return false;
        }
        int accuracy = (int) (location.getAccuracy() - location2.getAccuracy());
        boolean z4 = accuracy > 0;
        boolean z5 = accuracy < 0;
        boolean z6 = accuracy > 200;
        boolean a = m32885a(location.getProvider(), location2.getProvider());
        if (z5) {
            return true;
        }
        if (!z3 || z4) {
            return z3 && !z6 && a;
        }
        return true;
    }

    /* renamed from: a */
    private boolean m32885a(String str, String str2) {
        if (str != null) {
            return str.equals(str2);
        }
        return str2 == null;
    }
}
