package com.alibaba.android.arouter.routes;

import com.alibaba.android.arouter.facade.enums.RouteType;
import com.alibaba.android.arouter.facade.model.RouteMeta;
import com.alibaba.android.arouter.facade.template.IRouteGroup;
import com.jiayouya.travel.module.group.p268ui.TravelIncomeLogsActivity;
import java.util.Map;

public class ARouter$$Group$$group implements IRouteGroup {
    public void loadInto(Map<String, RouteMeta> map) {
        map.put("/group/travelIncomeLogs", RouteMeta.build(RouteType.ACTIVITY, TravelIncomeLogsActivity.class, "/group/travelincomelogs", "group", null, -1, Integer.MIN_VALUE));
    }
}
