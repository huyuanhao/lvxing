package com.tencent.p605ep.common.adapt.iservice;

import android.graphics.Camera;
import android.location.LocationManager;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import android.telephony.CellInfo;
import android.telephony.CellLocation;
import android.telephony.NeighboringCellInfo;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import java.util.List;
import java.util.Map;

/* renamed from: com.tencent.ep.common.adapt.iservice.ISecureSystemService */
public interface ISecureSystemService {
    List<CellInfo> getAllCellInfo(TelephonyManager telephonyManager);

    int getCellId();

    CellLocation getCellLocation(TelephonyManager telephonyManager);

    String getDeviceId(TelephonyManager telephonyManager);

    String getDeviceId(TelephonyManager telephonyManager, int i);

    String getICCID();

    String getIMEI();

    String getIMSI();

    Map<String, String> getImeiAndMeid();

    int getLac();

    String getLine1Number();

    String getLine1Number(TelephonyManager telephonyManager);

    String getMSISDN();

    List<NeighboringCellInfo> getNeighboringCellInfo(TelephonyManager telephonyManager);

    List<ScanResult> getScanResults(WifiManager wifiManager);

    String getSimSerialNumber(TelephonyManager telephonyManager);

    String getSubscriberId(TelephonyManager telephonyManager);

    boolean isProviderEnabled(LocationManager locationManager, String str);

    void listen(TelephonyManager telephonyManager, PhoneStateListener phoneStateListener, int i);

    Camera openCamera(int i);
}
