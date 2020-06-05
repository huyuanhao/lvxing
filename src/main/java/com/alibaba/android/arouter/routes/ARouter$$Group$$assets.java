package com.alibaba.android.arouter.routes;

import com.alibaba.android.arouter.facade.enums.RouteType;
import com.alibaba.android.arouter.facade.model.RouteMeta;
import com.alibaba.android.arouter.facade.template.IRouteGroup;
import com.jiayouya.travel.module.assets.p251ui.CashActivity;
import com.jiayouya.travel.module.assets.p251ui.CashApplyActivity;
import com.jiayouya.travel.module.assets.p251ui.CashLogsActivity;
import java.util.HashMap;
import java.util.Map;

public class ARouter$$Group$$assets implements IRouteGroup {
    public void loadInto(Map<String, RouteMeta> map) {
        map.put("/assets/cash", RouteMeta.build(RouteType.ACTIVITY, CashActivity.class, "/assets/cash", "assets", null, -1, Integer.MIN_VALUE));
        map.put("/assets/cashLogs", RouteMeta.build(RouteType.ACTIVITY, CashLogsActivity.class, "/assets/cashlogs", "assets", null, -1, Integer.MIN_VALUE));
        String str = "/assets/cashResult";
        map.put(str, RouteMeta.build(RouteType.ACTIVITY, CashApplyActivity.class, "/assets/cashresult", "assets", new HashMap<String, Integer>() {
            {
                put("item", Integer.valueOf(10));
            }
        }, -1, Integer.MIN_VALUE));
    }
}
