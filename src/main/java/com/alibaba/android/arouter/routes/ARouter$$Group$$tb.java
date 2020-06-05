package com.alibaba.android.arouter.routes;

import com.alibaba.android.arouter.facade.enums.RouteType;
import com.alibaba.android.arouter.facade.model.RouteMeta;
import com.alibaba.android.arouter.facade.template.IRouteGroup;
import com.jiayouya.travel.module.p281tb.p283ui.OrderActivity;
import com.jiayouya.travel.module.p281tb.p283ui.OrderDetailsActivity;
import com.jiayouya.travel.module.p281tb.p283ui.SearchActivity;
import java.util.Map;

public class ARouter$$Group$$tb implements IRouteGroup {
    public void loadInto(Map<String, RouteMeta> map) {
        map.put("/tb/order", RouteMeta.build(RouteType.ACTIVITY, OrderActivity.class, "/tb/order", "tb", null, -1, Integer.MIN_VALUE));
        map.put("/tb/orderDetails", RouteMeta.build(RouteType.ACTIVITY, OrderDetailsActivity.class, "/tb/orderdetails", "tb", null, -1, Integer.MIN_VALUE));
        map.put("/tb/search", RouteMeta.build(RouteType.ACTIVITY, SearchActivity.class, "/tb/search", "tb", null, -1, Integer.MIN_VALUE));
    }
}
