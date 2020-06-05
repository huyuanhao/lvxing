package com.tencent.p605ep.common.adapt.iservice;

import java.util.ArrayList;

/* renamed from: com.tencent.ep.common.adapt.iservice.ILocationService */
public interface ILocationService {
    ArrayList<String> getCityNameList(String str);

    String getLocation(String str);

    void getLocation(StringBuffer stringBuffer, StringBuffer stringBuffer2, StringBuffer stringBuffer3, String str);

    ArrayList<String> getProvinceNameList();

    boolean isYellowPageNumber(String str);
}
