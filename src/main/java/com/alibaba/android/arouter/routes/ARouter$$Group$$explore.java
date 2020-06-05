package com.alibaba.android.arouter.routes;

import com.alibaba.android.arouter.facade.enums.RouteType;
import com.alibaba.android.arouter.facade.model.RouteMeta;
import com.alibaba.android.arouter.facade.template.IRouteGroup;
import com.jiayouya.travel.module.explore.p265ui.DynamicActivity;
import com.jiayouya.travel.module.explore.p265ui.ExploreActivity;
import java.util.Map;

public class ARouter$$Group$$explore implements IRouteGroup {
    public void loadInto(Map<String, RouteMeta> map) {
        map.put("/explore/dynamic", RouteMeta.build(RouteType.ACTIVITY, DynamicActivity.class, "/explore/dynamic", "explore", null, -1, Integer.MIN_VALUE));
        map.put("/explore/index", RouteMeta.build(RouteType.ACTIVITY, ExploreActivity.class, "/explore/index", "explore", null, -1, Integer.MIN_VALUE));
    }
}
