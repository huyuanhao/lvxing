package com.tencent.bigdata.customdataacquisition.p598a;

import android.content.Context;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.telephony.CellIdentityCdma;
import android.telephony.CellIdentityGsm;
import android.telephony.CellIdentityLte;
import android.telephony.CellIdentityWcdma;
import android.telephony.CellInfo;
import android.telephony.CellInfoCdma;
import android.telephony.CellInfoGsm;
import android.telephony.CellInfoLte;
import android.telephony.CellInfoWcdma;
import android.telephony.TelephonyManager;
import android.telephony.cdma.CdmaCellLocation;
import android.telephony.gsm.GsmCellLocation;
import com.tencent.bigdata.customdataacquisition.p599b.C7112a;
import com.tencent.mid.core.Constants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.tencent.bigdata.customdataacquisition.a.b */
public class C7105b {

    /* renamed from: com.tencent.bigdata.customdataacquisition.a.b$a */
    private static class C7107a {
        /* access modifiers changed from: private */
        /* renamed from: a */
        public int f23615a;
        /* access modifiers changed from: private */
        /* renamed from: b */
        public int f23616b;
        /* access modifiers changed from: private */
        /* renamed from: c */
        public int f23617c;
        /* access modifiers changed from: private */
        /* renamed from: d */
        public int f23618d;
        /* access modifiers changed from: private */
        /* renamed from: e */
        public String f23619e;
        /* access modifiers changed from: private */
        /* renamed from: f */
        public double f23620f;
        /* access modifiers changed from: private */
        /* renamed from: g */
        public double f23621g;
        /* access modifiers changed from: private */
        /* renamed from: h */
        public int f23622h;

        private C7107a() {
        }

        /* renamed from: a */
        public JSONObject mo34241a() {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("cid", this.f23615a);
                jSONObject.put("mcc", this.f23616b);
                jSONObject.put("lac", this.f23618d);
                jSONObject.put("mnc", this.f23617c);
                jSONObject.put("type", this.f23619e);
                jSONObject.put("nt", this.f23622h);
                if (this.f23620f != 0.0d) {
                    jSONObject.put("lat", this.f23620f);
                }
                if (this.f23621g != 0.0d) {
                    jSONObject.put("lng", this.f23621g);
                }
                return jSONObject;
            } catch (JSONException e) {
                StringBuilder sb = new StringBuilder();
                sb.append("CellIDInfo toJSONObject error:");
                sb.append(e.toString());
                C7112a.m30485d(sb.toString());
                return null;
            }
        }

        public String toString() {
            try {
                return String.format("{\"cellId\":%d,\"mcc\":%d,\"lac\":%d,\"mnc\":%d,\"type\":%s,\"lat\":%f,\"lng\":%f}", new Object[]{Integer.valueOf(this.f23615a), Integer.valueOf(this.f23616b), Integer.valueOf(this.f23618d), Integer.valueOf(this.f23617c), this.f23619e, Double.valueOf(this.f23620f), Double.valueOf(this.f23621g)});
            } catch (Exception unused) {
                return "";
            }
        }
    }

    /* renamed from: com.tencent.bigdata.customdataacquisition.a.b$b */
    private static class C7108b implements Comparable<C7108b> {
        /* renamed from: a */
        public final String f23623a;
        /* renamed from: b */
        public final int f23624b;
        /* renamed from: c */
        public final String f23625c;

        public C7108b(ScanResult scanResult) {
            this.f23623a = scanResult.BSSID;
            this.f23624b = scanResult.level;
            this.f23625c = scanResult.SSID;
        }

        public C7108b(String str, int i, String str2) {
            this.f23623a = str;
            this.f23624b = i;
            this.f23625c = str2;
        }

        /* renamed from: a */
        public int compareTo(C7108b bVar) {
            return bVar.f23624b - this.f23624b;
        }

        /* renamed from: a */
        public JSONObject mo34244a() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("bs", this.f23623a);
                jSONObject.put("dBm", this.f23624b);
                jSONObject.put("ss", this.f23625c);
            } catch (Exception e) {
                C7112a.m30479a("", (Throwable) e);
            }
            return jSONObject;
        }
    }

    /* renamed from: a */
    public static JSONArray m30446a(Context context) {
        if (!C7112a.m30480a(context, "android.permission.ACCESS_COARSE_LOCATION")) {
            C7112a.m30483b("getCellInfo Require the permissionandroid.permission.ACCESS_COARSE_LOCATION");
            return null;
        }
        C7112a.m30483b("getCellInfo begin");
        JSONArray jSONArray = new JSONArray();
        try {
            ArrayList c = m30450c(context);
            if (c != null) {
                Iterator it = c.iterator();
                while (it.hasNext()) {
                    jSONArray.put(((C7107a) it.next()).mo34241a());
                }
            }
        } catch (Exception e) {
            C7112a.m30479a("getCellInfo", (Throwable) e);
        }
        return jSONArray;
    }

    /* renamed from: a */
    private static JSONObject m30447a(Location location) {
        if (location == null) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("lat", location.getLatitude());
            jSONObject.put("lng", location.getLongitude());
            jSONObject.put("alt", location.getAltitude());
            jSONObject.put("bear", (double) location.getBearing());
            jSONObject.put("acc", (double) location.getAccuracy());
            jSONObject.put("time", location.getTime());
            jSONObject.put("sp", (double) location.getSpeed());
            jSONObject.put("pvd", location.getProvider());
            return jSONObject;
        } catch (Exception e) {
            StringBuilder sb = new StringBuilder();
            sb.append("[loactionToJson]");
            sb.append(e.getMessage());
            C7112a.m30485d(sb.toString());
            return null;
        }
    }

    /* renamed from: a */
    private static boolean m30448a(LocationManager locationManager) {
        return locationManager.isProviderEnabled("gps");
    }

    /* renamed from: b */
    public static JSONObject m30449b(Context context) {
        if (!C7112a.m30480a(context, "android.permission.ACCESS_COARSE_LOCATION")) {
            return null;
        }
        try {
            LocationManager locationManager = (LocationManager) context.getSystemService("location");
            String str = "network";
            if (locationManager != null) {
                Location lastKnownLocation = locationManager.getLastKnownLocation(str);
                if (lastKnownLocation != null) {
                    return m30447a(lastKnownLocation);
                }
            }
        } catch (Exception e) {
            StringBuilder sb = new StringBuilder();
            sb.append("getLastLocation:");
            sb.append(e.toString());
            C7112a.m30485d(sb.toString());
        }
        return null;
    }

    /* renamed from: c */
    public static ArrayList<C7107a> m30450c(Context context) {
        C7107a aVar;
        C7107a aVar2;
        if (!C7112a.m30480a(context, "android.permission.ACCESS_COARSE_LOCATION")) {
            return null;
        }
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        if (telephonyManager == null) {
            C7112a.m30478a((Object) "getCellIDInfo: get TelephonyManager return null");
            return null;
        }
        ArrayList<C7107a> arrayList = new ArrayList<>();
        C7107a aVar3 = new C7107a();
        int networkType = telephonyManager.getNetworkType();
        int phoneType = telephonyManager.getPhoneType();
        StringBuilder sb = new StringBuilder();
        sb.append("getCellIDInfo--> \t\tphoneType = ");
        sb.append(phoneType);
        C7112a.m30483b(sb.toString());
        int i = 0;
        if (phoneType == 2) {
            CdmaCellLocation cdmaCellLocation = (CdmaCellLocation) telephonyManager.getCellLocation();
            if (cdmaCellLocation == null) {
                C7112a.m30485d("CdmaCellLocation is null!!!");
                return null;
            }
            int networkId = cdmaCellLocation.getNetworkId();
            String substring = telephonyManager.getNetworkOperator().substring(0, 3);
            String valueOf = String.valueOf(cdmaCellLocation.getSystemId());
            aVar3.f23615a = cdmaCellLocation.getBaseStationId();
            aVar3.f23616b = Integer.valueOf(substring).intValue();
            aVar3.f23617c = Integer.valueOf(valueOf).intValue();
            aVar3.f23618d = networkId;
            String str = "cdma";
            aVar3.f23619e = str;
            aVar3.f23622h = networkType;
            arrayList.add(aVar3);
            List allCellInfo = telephonyManager.getAllCellInfo();
            int size = allCellInfo.size();
            while (i < size && i < 3) {
                CellInfo cellInfo = (CellInfo) allCellInfo.get(i);
                if (cellInfo instanceof CellInfoCdma) {
                    CellIdentityCdma cellIdentity = ((CellInfoCdma) cellInfo).getCellIdentity();
                    aVar2 = new C7107a();
                    aVar2.f23615a = cellIdentity.getBasestationId();
                    aVar2.f23616b = Integer.valueOf(substring).intValue();
                    aVar2.f23617c = Integer.valueOf(valueOf).intValue();
                    aVar2.f23618d = networkId;
                    aVar2.f23620f = (double) cellIdentity.getLatitude();
                    aVar2.f23621g = (double) cellIdentity.getLongitude();
                    aVar2.f23622h = networkType;
                    aVar2.f23619e = str;
                } else if (cellInfo instanceof CellInfoWcdma) {
                    CellIdentityWcdma cellIdentity2 = ((CellInfoWcdma) cellInfo).getCellIdentity();
                    aVar2 = new C7107a();
                    aVar2.f23615a = cellIdentity2.getCid();
                    aVar2.f23616b = cellIdentity2.getMcc();
                    aVar2.f23617c = cellIdentity2.getMnc();
                    aVar2.f23618d = cellIdentity2.getLac();
                    aVar2.f23618d = networkId;
                    aVar2.f23619e = "wcdma";
                    aVar2.f23622h = networkType;
                } else {
                    i++;
                }
                arrayList.add(aVar2);
                i++;
            }
        } else {
            GsmCellLocation gsmCellLocation = (GsmCellLocation) telephonyManager.getCellLocation();
            if (gsmCellLocation == null) {
                C7112a.m30485d("GsmCellLocation is null!!!");
                return null;
            }
            int lac = gsmCellLocation.getLac();
            String substring2 = telephonyManager.getNetworkOperator().substring(0, 3);
            String substring3 = telephonyManager.getNetworkOperator().substring(3, 5);
            aVar3.f23615a = gsmCellLocation.getCid();
            aVar3.f23616b = Integer.valueOf(substring2).intValue();
            aVar3.f23617c = Integer.valueOf(substring3).intValue();
            aVar3.f23618d = lac;
            aVar3.f23622h = networkType;
            String str2 = "gsm";
            aVar3.f23619e = str2;
            arrayList.add(aVar3);
            List allCellInfo2 = telephonyManager.getAllCellInfo();
            int size2 = allCellInfo2.size();
            while (i < size2 && i < 3) {
                CellInfo cellInfo2 = (CellInfo) allCellInfo2.get(i);
                if (cellInfo2 instanceof CellInfoGsm) {
                    CellIdentityGsm cellIdentity3 = ((CellInfoGsm) cellInfo2).getCellIdentity();
                    aVar = new C7107a();
                    aVar.f23615a = cellIdentity3.getCid();
                    aVar.f23616b = cellIdentity3.getMcc();
                    aVar.f23617c = cellIdentity3.getMnc();
                    aVar.f23618d = cellIdentity3.getLac();
                    aVar.f23619e = str2;
                } else if (cellInfo2 instanceof CellInfoLte) {
                    CellIdentityLte cellIdentity4 = ((CellInfoLte) cellInfo2).getCellIdentity();
                    aVar = new C7107a();
                    aVar.f23615a = cellIdentity4.getCi();
                    aVar.f23616b = cellIdentity4.getMcc();
                    aVar.f23617c = cellIdentity4.getMnc();
                    aVar.f23618d = cellIdentity4.getTac();
                    aVar.f23619e = "lte";
                } else {
                    i++;
                }
                aVar.f23622h = networkType;
                arrayList.add(aVar);
                i++;
            }
        }
        return arrayList;
    }

    /* renamed from: d */
    public static JSONObject m30451d(Context context) {
        if (!C7112a.m30480a(context, "android.permission.ACCESS_FINE_LOCATION")) {
            C7112a.m30483b("getGps Require the permissionandroid.permission.ACCESS_FINE_LOCATION");
            return null;
        }
        try {
            LocationManager locationManager = (LocationManager) context.getSystemService("location");
            if (locationManager == null || !m30448a(locationManager)) {
                return null;
            }
            Criteria criteria = new Criteria();
            criteria.setAccuracy(1);
            criteria.setAltitudeRequired(false);
            criteria.setBearingRequired(false);
            criteria.setCostAllowed(true);
            criteria.setPowerRequirement(1);
            Location lastKnownLocation = locationManager.getLastKnownLocation(locationManager.getBestProvider(criteria, true));
            if (lastKnownLocation != null) {
                return m30447a(lastKnownLocation);
            }
            return null;
        } catch (Exception e) {
            StringBuilder sb = new StringBuilder();
            sb.append("[getGps]");
            sb.append(e.getMessage());
            C7112a.m30485d(sb.toString());
        }
    }

    /* renamed from: e */
    public static JSONArray m30452e(Context context) {
        if (!C7112a.m30480a(context, Constants.PERMISSION_ACCESS_WIFI_STATE)) {
            C7112a.m30483b("getWifiTowers Require the permissionandroid.permission.ACCESS_WIFI_STATE");
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        try {
            for (C7108b a : m30455h(context)) {
                jSONArray.put(a.mo34244a());
            }
            return jSONArray;
        } catch (Exception e) {
            C7112a.m30479a("", (Throwable) e);
            return jSONArray;
        }
    }

    /* renamed from: f */
    public static JSONObject m30453f(Context context) {
        try {
            JSONObject jSONObject = new JSONObject();
            JSONArray a = m30446a(context);
            if (!C7112a.m30481a(a)) {
                jSONObject.put("cell", a);
            }
            JSONArray e = m30452e(context);
            if (!C7112a.m30481a(e)) {
                jSONObject.put("wflist", e);
            }
            JSONObject d = m30451d(context);
            if (!C7112a.m30482a(d)) {
                jSONObject.put("cgps", d);
            } else {
                JSONObject b = m30449b(context);
                if (!C7112a.m30482a(b)) {
                    jSONObject.put("lasgps", b);
                }
            }
            if (C7112a.m30482a(jSONObject)) {
                C7112a.m30485d("No location info, return..");
                return null;
            }
            jSONObject.put("fun", "xg");
            return jSONObject;
        } catch (Throwable th) {
            C7112a.m30479a("getReportLocationJson: ", th);
            return null;
        }
    }

    /* renamed from: g */
    private static boolean m30454g(Context context) {
        boolean z = false;
        try {
            WifiManager wifiManager = (WifiManager) context.getApplicationContext().getSystemService("wifi");
            if (wifiManager != null && wifiManager.isWifiEnabled()) {
                z = true;
            }
            return z;
        } catch (Exception e) {
            C7112a.m30479a("Wifi Error", (Throwable) e);
            return false;
        }
    }

    /* renamed from: h */
    private static List<C7108b> m30455h(Context context) {
        if (!C7112a.m30480a(context, Constants.PERMISSION_ACCESS_WIFI_STATE)) {
            C7112a.m30483b("dump Require the permissionandroid.permission.ACCESS_WIFI_STATE");
            return new ArrayList();
        } else if (!m30454g(context)) {
            return new ArrayList();
        } else {
            WifiManager wifiManager = (WifiManager) context.getApplicationContext().getSystemService("wifi");
            if (wifiManager == null) {
                return new ArrayList();
            }
            WifiInfo connectionInfo = wifiManager.getConnectionInfo();
            C7108b bVar = null;
            if (connectionInfo != null) {
                bVar = new C7108b(connectionInfo.getBSSID(), connectionInfo.getRssi(), connectionInfo.getSSID());
            }
            ArrayList arrayList = new ArrayList();
            if (bVar != null) {
                arrayList.add(bVar);
            }
            List<ScanResult> scanResults = wifiManager.getScanResults();
            int i = 0;
            if (scanResults != null && scanResults.size() > 0) {
                for (ScanResult scanResult : scanResults) {
                    i++;
                    if (i >= 10) {
                        break;
                    }
                    C7108b bVar2 = new C7108b(scanResult);
                    if (bVar == null || !bVar2.f23625c.equals(bVar.f23625c)) {
                        arrayList.add(bVar2);
                    }
                }
            }
            return arrayList;
        }
    }
}
