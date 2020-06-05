package com.alibaba.android.arouter.routes;

import com.alibaba.android.arouter.facade.enums.RouteType;
import com.alibaba.android.arouter.facade.model.RouteMeta;
import com.alibaba.android.arouter.facade.template.IRouteGroup;
import com.jiayouya.travel.module.qiyu.OnlineServiceActivity;
import java.util.Map;

public class ARouter$$Group$$online implements IRouteGroup {
    public void loadInto(Map<String, RouteMeta> map) {
        map.put("/online/serve", RouteMeta.build(RouteType.ACTIVITY, OnlineServiceActivity.class, "/online/serve", "online", null, -1, Integer.MIN_VALUE));
    }
}
