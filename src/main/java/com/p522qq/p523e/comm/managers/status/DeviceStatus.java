package com.p522qq.p523e.comm.managers.status;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Build.VERSION;
import android.provider.Settings.Secure;
import android.telephony.CellLocation;
import android.telephony.TelephonyManager;
import android.telephony.cdma.CdmaCellLocation;
import android.telephony.gsm.GsmCellLocation;
import android.util.DisplayMetrics;
import com.p522qq.p523e.comm.constants.Constants;
import com.p522qq.p523e.comm.util.GDTLogger;
import com.p522qq.p523e.comm.util.Md5Util;
import com.p522qq.p523e.comm.util.StringUtil;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/* renamed from: com.qq.e.comm.managers.status.DeviceStatus */
public class DeviceStatus {
    /* renamed from: a */
    private String f20247a;
    /* renamed from: b */
    private String f20248b;
    /* renamed from: c */
    private int f20249c;
    /* renamed from: d */
    private int f20250d;
    /* renamed from: e */
    private int f20251e;
    /* renamed from: f */
    private String f20252f;
    /* renamed from: g */
    private String f20253g;
    /* renamed from: h */
    private String f20254h;
    /* renamed from: i */
    private String f20255i;
    /* renamed from: j */
    private String f20256j;
    /* access modifiers changed from: private|volatile */
    /* renamed from: k */
    public volatile String f20257k;
    /* access modifiers changed from: private|volatile */
    /* renamed from: l */
    public volatile String f20258l;
    /* renamed from: m */
    private volatile float f20259m;
    public final String model = Build.MODEL;
    /* renamed from: n */
    private Context f20260n;

    public DeviceStatus(Context context) {
        this.f20260n = context.getApplicationContext();
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        this.f20251e = getVersion() > 3 ? displayMetrics.densityDpi : 120;
        this.f20249c = getVersion() > 3 ? m25235a(displayMetrics.density, displayMetrics.widthPixels) : displayMetrics.widthPixels;
        this.f20250d = getVersion() > 3 ? m25235a(displayMetrics.density, displayMetrics.heightPixels) : displayMetrics.heightPixels;
        m25237a();
    }

    /* renamed from: a */
    private int m25235a(float f, int i) {
        return (this.f20260n.getApplicationInfo().flags & 8192) != 0 ? (int) (((float) i) / f) : i;
    }

    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* renamed from: a */
    private void m25237a() {
        /*
        r7 = this;
        android.content.Context r0 = r7.f20260n     // Catch:{ all -> 0x0067 }
        java.lang.String r1 = "location"
        java.lang.Object r0 = r0.getSystemService(r1)     // Catch:{ all -> 0x0067 }
        r1 = r0
        android.location.LocationManager r1 = (android.location.LocationManager) r1     // Catch:{ all -> 0x0067 }
        if (r1 != 0) goto L_0x000e
        return
    L_0x000e:
        android.location.Criteria r0 = new android.location.Criteria     // Catch:{ all -> 0x0067 }
        r0.<init>()     // Catch:{ all -> 0x0067 }
        r2 = 2
        r0.setAccuracy(r2)     // Catch:{ all -> 0x0067 }
        r2 = 0
        r0.setAltitudeRequired(r2)     // Catch:{ all -> 0x0067 }
        r0.setBearingRequired(r2)     // Catch:{ all -> 0x0067 }
        r2 = 1
        r0.setCostAllowed(r2)     // Catch:{ all -> 0x0067 }
        r0.setPowerRequirement(r2)     // Catch:{ all -> 0x0067 }
        java.lang.String r2 = r1.getBestProvider(r0, r2)     // Catch:{  }
        android.location.Location r0 = r1.getLastKnownLocation(r2)     // Catch:{  }
        if (r0 == 0) goto L_0x005a
        java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{  }
        r1.<init>()     // Catch:{  }
        double r2 = r0.getLatitude()     // Catch:{  }
        r1.append(r2)     // Catch:{  }
        java.lang.String r1 = r1.toString()     // Catch:{  }
        r7.f20257k = r1     // Catch:{  }
        java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{  }
        r1.<init>()     // Catch:{  }
        double r2 = r0.getLongitude()     // Catch:{  }
        r1.append(r2)     // Catch:{  }
        java.lang.String r1 = r1.toString()     // Catch:{  }
        r7.f20258l = r1     // Catch:{  }
        float r0 = r0.getAccuracy()     // Catch:{  }
        r7.f20259m = r0     // Catch:{  }
        goto L_0x0067
    L_0x005a:
        com.qq.e.comm.managers.status.DeviceStatus$1 r6 = new com.qq.e.comm.managers.status.DeviceStatus$1     // Catch:{  }
        r6.m50868init(r1)     // Catch:{  }
        r3 = 2000(0x7d0, double:9.88E-321)
        r5 = 1171963904(0x45dac000, float:7000.0)
        r1.requestLocationUpdates(r2, r3, r5, r6)     // Catch:{ all -> 0x0067 }
    L_0x0067:
        return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.p522qq.p523e.comm.managers.status.DeviceStatus.m25237a():void");
    }

    public Carrier getCarrier() {
        String operator = getOperator();
        if (operator != null) {
            if (operator.equals("46000") || operator.equals("46002") || operator.equals("46007") || operator.equals("46020")) {
                return Carrier.CMCC;
            }
            if (operator.equals("46001") || operator.equals("46006")) {
                return Carrier.UNICOM;
            }
            if (operator.equals("46003") || operator.equals("46005")) {
                return Carrier.TELECOM;
            }
        }
        return Carrier.UNKNOWN;
    }

    public String getDataNet() {
        NetworkInfo networkInfo;
        try {
            networkInfo = ((ConnectivityManager) this.f20260n.getSystemService("connectivity")).getActiveNetworkInfo();
        } catch (Exception unused) {
            networkInfo = null;
        }
        if (networkInfo == null) {
            return null;
        }
        int type = networkInfo.getType();
        String str = type != 0 ? type != 1 ? "unknow" : "wi" : "ed";
        this.f20255i = str;
        return this.f20255i;
    }

    public int getDeviceDensity() {
        return this.f20251e;
    }

    public int getDeviceHeight() {
        return this.f20250d;
    }

    public int getDeviceWidth() {
        return this.f20249c;
    }

    public String getDid() {
        String plainDid = getPlainDid();
        return StringUtil.isEmpty(plainDid) ? "" : Md5Util.encode(plainDid.toLowerCase());
    }

    public Map<String, String> getLacAndCeilId() {
        int i;
        String operator = getOperator();
        HashMap hashMap = new HashMap();
        if (this.f20260n.checkCallingOrSelfPermission("android.permission.ACCESS_COARSE_LOCATION") == 0 && !StringUtil.isEmpty(operator) && !"null".equalsIgnoreCase(operator)) {
            int i2 = 0;
            try {
                if (Integer.parseInt(operator.substring(0, 3)) == 460) {
                    TelephonyManager telephonyManager = (TelephonyManager) this.f20260n.getSystemService("phone");
                    CellLocation cellLocation = telephonyManager.getCellLocation();
                    if (cellLocation instanceof CdmaCellLocation) {
                        CdmaCellLocation cdmaCellLocation = (CdmaCellLocation) cellLocation;
                        i2 = cdmaCellLocation.getNetworkId();
                        i = cdmaCellLocation.getBaseStationId();
                    } else {
                        if (cellLocation instanceof GsmCellLocation) {
                            GsmCellLocation gsmCellLocation = (GsmCellLocation) telephonyManager.getCellLocation();
                            if (gsmCellLocation != null) {
                                i2 = gsmCellLocation.getLac();
                                i = gsmCellLocation.getCid();
                            }
                        }
                        i = 0;
                    }
                    StringBuilder sb = new StringBuilder();
                    sb.append(i2);
                    hashMap.put("lac", sb.toString());
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(i);
                    hashMap.put("cellid", sb2.toString());
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return hashMap;
    }

    public String getLanguage() {
        if (this.f20248b == null) {
            this.f20248b = Locale.getDefault().getLanguage().toLowerCase(Locale.US);
            if (this.f20248b.length() == 0) {
                this.f20248b = "en";
            }
        }
        return this.f20248b;
    }

    public String getLat() {
        return this.f20257k;
    }

    public String getLng() {
        return this.f20258l;
    }

    public float getLocationAccuracy() {
        return this.f20259m;
    }

    public NetworkType getNetworkType() {
        int i;
        String dataNet = getDataNet();
        if (dataNet != null && dataNet.equals("wi")) {
            return NetworkType.WIFI;
        }
        try {
            i = Integer.parseInt(getPhoneNet());
        } catch (NumberFormatException unused) {
            i = 0;
        }
        switch (i) {
            case 1:
            case 2:
            case 16:
                return NetworkType.NET_2G;
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 14:
            case 17:
                return NetworkType.NET_3G;
            case 13:
            case 15:
            case 18:
            case 19:
            case 20:
                return NetworkType.NET_4G;
            default:
                return NetworkType.UNKNOWN;
        }
    }

    public String getOperator() {
        try {
            this.f20253g = ((TelephonyManager) this.f20260n.getSystemService("phone")).getNetworkOperator();
        } catch (Exception unused) {
        }
        return this.f20253g;
    }

    public String getPhoneNet() {
        try {
            TelephonyManager telephonyManager = (TelephonyManager) this.f20260n.getSystemService("phone");
            StringBuilder sb = new StringBuilder();
            sb.append(telephonyManager.getNetworkType());
            this.f20254h = sb.toString();
        } catch (Exception unused) {
        }
        return this.f20254h;
    }

    public String getPlainDid() {
        if (!StringUtil.isEmpty(this.f20256j)) {
            return this.f20256j;
        }
        try {
            this.f20256j = ((TelephonyManager) this.f20260n.getSystemService("phone")).getDeviceId();
        } catch (Exception e) {
            StringBuilder sb = new StringBuilder("Get imei encounter error: ");
            sb.append(e.getMessage());
            GDTLogger.m25258d(sb.toString());
        }
        return StringUtil.isEmpty(this.f20256j) ? "" : this.f20256j;
    }

    public String getScreenOrientation() {
        this.f20252f = this.f20260n.getResources().getConfiguration().orientation == 2 ? Constants.LANDSCAPE : Constants.PORTRAIT;
        return this.f20252f;
    }

    public String getUid() {
        if (this.f20247a == null) {
            String string = Secure.getString(this.f20260n.getContentResolver(), "android_id");
            if (string == null) {
                string = "emulator";
            }
            this.f20247a = Md5Util.encode(string);
        }
        return this.f20247a;
    }

    public int getVersion() {
        try {
            return VERSION.SDK_INT;
        } catch (Exception unused) {
            return 3;
        }
    }
}
