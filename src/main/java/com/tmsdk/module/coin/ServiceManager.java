package com.tmsdk.module.coin;

import android.content.Context;
import com.tencent.p605ep.common.adapt.ServiceCenter;
import com.tencent.p605ep.common.adapt.iservice.IReportService;
import com.tencent.p605ep.common.adapt.iservice.net.ISharkService;
import com.tencent.p605ep.commonbase.api.AppContext;

public class ServiceManager {
    public static boolean initService(Context context) {
        if (context == null) {
            return false;
        }
        Context applicationContext = context.getApplicationContext();
        AppContext.context = applicationContext;
        ServiceCenter.set(ISharkService.class, DefSharkServiceImpl.getInstance(applicationContext));
        ServiceCenter.set(IReportService.class, new DefReportService());
        return true;
    }
}
