package com.alibaba.android.arouter.routes;

import com.alibaba.android.arouter.facade.enums.RouteType;
import com.alibaba.android.arouter.facade.model.RouteMeta;
import com.alibaba.android.arouter.facade.template.IRouteGroup;
import com.jiayouya.travel.module.login.p270ui.LoginActivity;
import com.jiayouya.travel.module.login.p270ui.PhoneLoginActivity;
import java.util.HashMap;
import java.util.Map;

public class ARouter$$Group$$login implements IRouteGroup {
    public void loadInto(Map<String, RouteMeta> map) {
        map.put("/login/phone", RouteMeta.build(RouteType.ACTIVITY, PhoneLoginActivity.class, "/login/phone", "login", null, -1, Integer.MIN_VALUE));
        String str = "/login/wx";
        map.put(str, RouteMeta.build(RouteType.ACTIVITY, LoginActivity.class, "/login/wx", "login", new HashMap<String, Integer>() {
            {
                put("isAuth", Integer.valueOf(0));
            }
        }, -1, Integer.MIN_VALUE));
    }
}
