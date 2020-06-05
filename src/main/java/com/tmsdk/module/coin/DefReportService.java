package com.tmsdk.module.coin;

import btmsdkobf.C0638c;
import com.tencent.p605ep.common.adapt.iservice.IReportService;
import java.util.ArrayList;
import java.util.Map;

public class DefReportService implements IReportService {
    public static final String TAG = "TMSDK_DefReportService";

    public void addBlackList(String str) {
    }

    public void clearOldSwitch(ArrayList<Integer> arrayList) {
    }

    public void clearState(int i) {
    }

    public void featureReport2Server() {
    }

    public void removeBlackList(String str) {
    }

    public void reportAction(int i, int i2) {
        StringBuilder sb = new StringBuilder();
        sb.append("[featureId : ");
        sb.append(i);
        sb.append("]reportAction");
        TmsLog.m32943i(TAG, sb.toString());
        C0638c.saveActionData(i);
    }

    public void reportFeature(int i, ArrayList<Integer> arrayList, ArrayList<String> arrayList2, int i2) {
    }

    public void reportInteger(int i, int i2, int i3) {
        StringBuilder sb = new StringBuilder();
        sb.append("[featureId : ");
        sb.append(i);
        sb.append("][intValue : ");
        sb.append(i2);
        sb.append("]reportInteger");
        TmsLog.m32943i(TAG, sb.toString());
        C0638c.m74a(i, i2);
    }

    public void reportInteger(int i, ArrayList<Integer> arrayList, int i2) {
    }

    public void reportOldSwitch(int i, ArrayList<Integer> arrayList) {
    }

    public void reportOldSwitch(int i, ArrayList<Integer> arrayList, ArrayList<String> arrayList2) {
    }

    public void reportState(int i, int i2) {
    }

    public void reportString(int i, String str, int i2) {
        StringBuilder sb = new StringBuilder();
        sb.append("[featureId : ");
        sb.append(i);
        sb.append("][strValue : ");
        sb.append(str);
        sb.append("]reportString");
        TmsLog.m32943i(TAG, sb.toString());
        C0638c.m76a(i, str);
    }

    public void reportString(int i, ArrayList<String> arrayList, int i2) {
    }

    public void setCloudControlSet(int i, int i2) {
    }

    public void unifiedReport(int i, Map<Integer, String> map, int i2) {
    }

    public void unifiedReport2Server() {
    }
}
