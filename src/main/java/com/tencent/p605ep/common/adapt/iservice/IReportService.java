package com.tencent.p605ep.common.adapt.iservice;

import java.util.ArrayList;
import java.util.Map;

/* renamed from: com.tencent.ep.common.adapt.iservice.IReportService */
public interface IReportService {

    /* renamed from: com.tencent.ep.common.adapt.iservice.IReportService$FeatureType */
    public interface FeatureType {
        public static final int TYPE_ADD_UP = 4;
        public static final int TYPE_CLOUD_INSTANT = 22;
        public static final int TYPE_INSTANT = 1;
        @Deprecated
        public static final int TYPE_REPEAT_STATE = 8;
        public static final int TYPE_SINGLE = 2;
    }

    void addBlackList(String str);

    void clearOldSwitch(ArrayList<Integer> arrayList);

    void clearState(int i);

    void featureReport2Server();

    void removeBlackList(String str);

    void reportAction(int i, int i2);

    void reportFeature(int i, ArrayList<Integer> arrayList, ArrayList<String> arrayList2, int i2);

    void reportInteger(int i, int i2, int i3);

    void reportInteger(int i, ArrayList<Integer> arrayList, int i2);

    void reportOldSwitch(int i, ArrayList<Integer> arrayList);

    void reportOldSwitch(int i, ArrayList<Integer> arrayList, ArrayList<String> arrayList2);

    void reportState(int i, int i2);

    void reportString(int i, String str, int i2);

    void reportString(int i, ArrayList<String> arrayList, int i2);

    void setCloudControlSet(int i, int i2);

    void unifiedReport(int i, Map<Integer, String> map, int i2);

    void unifiedReport2Server();
}
