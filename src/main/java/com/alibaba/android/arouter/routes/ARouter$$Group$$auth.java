package com.alibaba.android.arouter.routes;

import com.alibaba.android.arouter.facade.enums.RouteType;
import com.alibaba.android.arouter.facade.model.RouteMeta;
import com.alibaba.android.arouter.facade.template.IRouteGroup;
import com.jiayouya.travel.module.auth.p255ui.AuthActivity;
import java.util.Map;

public class ARouter$$Group$$auth implements IRouteGroup {
    public void loadInto(Map<String, RouteMeta> map) {
        map.put("/auth/index", RouteMeta.build(RouteType.ACTIVITY, AuthActivity.class, "/auth/index", "auth", null, -1, Integer.MIN_VALUE));
    }
}
