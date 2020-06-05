package com.alibaba.android.arouter.routes;

import com.alibaba.android.arouter.facade.enums.RouteType;
import com.alibaba.android.arouter.facade.model.RouteMeta;
import com.alibaba.android.arouter.facade.template.IRouteGroup;
import com.jiayouya.travel.module.answer.p248ui.AnswerActivity;
import com.jiayouya.travel.module.answer.p248ui.AnswerResultActivity;
import com.tencent.p605ep.common.adapt.iservice.account.AccountConst.ArgKey;
import java.util.HashMap;
import java.util.Map;

public class ARouter$$Group$$answer implements IRouteGroup {
    public void loadInto(Map<String, RouteMeta> map) {
        map.put("/answer/index", RouteMeta.build(RouteType.ACTIVITY, AnswerActivity.class, "/answer/index", "answer", new HashMap<String, Integer>() {
            {
                put("isAnswerAgain", Integer.valueOf(0));
            }
        }, -1, Integer.MIN_VALUE));
        String str = "/answer/result";
        map.put(str, RouteMeta.build(RouteType.ACTIVITY, AnswerResultActivity.class, "/answer/result", "answer", new HashMap<String, Integer>() {
            {
                put(ArgKey.KEY_RESULT, Integer.valueOf(10));
            }
        }, -1, Integer.MIN_VALUE));
    }
}
