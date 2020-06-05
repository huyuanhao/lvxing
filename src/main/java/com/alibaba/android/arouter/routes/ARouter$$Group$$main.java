package com.alibaba.android.arouter.routes;

import com.alibaba.android.arouter.facade.enums.RouteType;
import com.alibaba.android.arouter.facade.model.RouteMeta;
import com.alibaba.android.arouter.facade.template.IRouteGroup;
import com.jiayouya.travel.module.main.p273ui.MainActivity;
import java.util.Map;

public class ARouter$$Group$$main implements IRouteGroup {
    public void loadInto(Map<String, RouteMeta> map) {
        map.put("/main/index", RouteMeta.build(RouteType.ACTIVITY, MainActivity.class, "/main/index", "main", null, -1, Integer.MIN_VALUE));
    }
}
