package com.alibaba.android.arouter.routes;

import com.alibaba.android.arouter.facade.enums.RouteType;
import com.alibaba.android.arouter.facade.model.RouteMeta;
import com.alibaba.android.arouter.facade.template.IRouteGroup;
import com.jiayouya.travel.module.travel.p288ui.HandbookActivity;
import com.jiayouya.travel.module.travel.p288ui.RankingListActivity;
import com.jiayouya.travel.module.travel.p288ui.TodayProfitLogsActivity;
import java.util.Map;

public class ARouter$$Group$$travel implements IRouteGroup {
    public void loadInto(Map<String, RouteMeta> map) {
        map.put("/travel/handbook", RouteMeta.build(RouteType.ACTIVITY, HandbookActivity.class, "/travel/handbook", "travel", null, -1, Integer.MIN_VALUE));
        map.put("/travel/rankingList", RouteMeta.build(RouteType.ACTIVITY, RankingListActivity.class, "/travel/rankinglist", "travel", null, -1, Integer.MIN_VALUE));
        map.put("/travel/todayProfitLogs", RouteMeta.build(RouteType.ACTIVITY, TodayProfitLogsActivity.class, "/travel/todayprofitlogs", "travel", null, -1, Integer.MIN_VALUE));
    }
}
