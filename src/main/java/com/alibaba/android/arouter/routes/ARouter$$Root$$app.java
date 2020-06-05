package com.alibaba.android.arouter.routes;

import com.alibaba.android.arouter.facade.template.IRouteGroup;
import com.alibaba.android.arouter.facade.template.IRouteRoot;
import java.util.Map;

public class ARouter$$Root$$app implements IRouteRoot {
    public void loadInto(Map<String, Class<? extends IRouteGroup>> map) {
        map.put("answer", ARouter$$Group$$answer.class);
        map.put("assets", ARouter$$Group$$assets.class);
        map.put("auth", ARouter$$Group$$auth.class);
        map.put("explore", ARouter$$Group$$explore.class);
        map.put("group", ARouter$$Group$$group.class);
        map.put("login", ARouter$$Group$$login.class);
        map.put("main", ARouter$$Group$$main.class);
        map.put("me", ARouter$$Group$$me.class);
        map.put("online", ARouter$$Group$$online.class);
        map.put("tb", ARouter$$Group$$tb.class);
        map.put("travel", ARouter$$Group$$travel.class);
    }
}
