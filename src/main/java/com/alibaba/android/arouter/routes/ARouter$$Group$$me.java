package com.alibaba.android.arouter.routes;

import com.alibaba.android.arouter.facade.enums.RouteType;
import com.alibaba.android.arouter.facade.model.RouteMeta;
import com.alibaba.android.arouter.facade.template.IRouteGroup;
import com.jiayouya.travel.module.p276me.p279ui.AboutUsActivity;
import com.jiayouya.travel.module.p276me.p279ui.AvatarActivity;
import com.jiayouya.travel.module.p276me.p279ui.BonusDetailActivity;
import com.jiayouya.travel.module.p276me.p279ui.BonusDogActivity;
import com.jiayouya.travel.module.p276me.p279ui.BonusLogsActivity;
import com.jiayouya.travel.module.p276me.p279ui.EditAliPayActivity;
import com.jiayouya.travel.module.p276me.p279ui.InviteCodeActivity;
import com.jiayouya.travel.module.p276me.p279ui.InviteLogsActivity;
import com.jiayouya.travel.module.p276me.p279ui.MapActivity;
import com.jiayouya.travel.module.p276me.p279ui.MyAliPayActivity;
import com.jiayouya.travel.module.p276me.p279ui.NicknameActivity;
import com.jiayouya.travel.module.p276me.p279ui.NoticeCenterActivity;
import com.jiayouya.travel.module.p276me.p279ui.OnlineServiceActivity;
import com.jiayouya.travel.module.p276me.p279ui.PhoneActivity;
import com.jiayouya.travel.module.p276me.p279ui.PrivateActivity;
import com.jiayouya.travel.module.p276me.p279ui.RealNameAuthActivity;
import com.jiayouya.travel.module.p276me.p279ui.SettingActivity;
import com.jiayouya.travel.module.p276me.p279ui.SocialInformationActivity;
import java.util.HashMap;
import java.util.Map;

public class ARouter$$Group$$me implements IRouteGroup {
    public void loadInto(Map<String, RouteMeta> map) {
        map.put("/me/aboutUs", RouteMeta.build(RouteType.ACTIVITY, AboutUsActivity.class, "/me/aboutus", "me", null, -1, Integer.MIN_VALUE));
        map.put("/me/avatar", RouteMeta.build(RouteType.ACTIVITY, AvatarActivity.class, "/me/avatar", "me", null, -1, Integer.MIN_VALUE));
        map.put("/me/bonusDetail", RouteMeta.build(RouteType.ACTIVITY, BonusDetailActivity.class, "/me/bonusdetail", "me", null, -1, Integer.MIN_VALUE));
        map.put("/me/bonusDog", RouteMeta.build(RouteType.ACTIVITY, BonusDogActivity.class, "/me/bonusdog", "me", null, -1, Integer.MIN_VALUE));
        map.put("/me/bonusLogs", RouteMeta.build(RouteType.ACTIVITY, BonusLogsActivity.class, "/me/bonuslogs", "me", null, -1, Integer.MIN_VALUE));
        map.put("/me/editAliPay", RouteMeta.build(RouteType.ACTIVITY, EditAliPayActivity.class, "/me/editalipay", "me", null, -1, Integer.MIN_VALUE));
        map.put("/me/inviteCode", RouteMeta.build(RouteType.ACTIVITY, InviteCodeActivity.class, "/me/invitecode", "me", null, -1, Integer.MIN_VALUE));
        map.put("/me/inviteLogs", RouteMeta.build(RouteType.ACTIVITY, InviteLogsActivity.class, "/me/invitelogs", "me", null, -1, Integer.MIN_VALUE));
        map.put("/me/map", RouteMeta.build(RouteType.ACTIVITY, MapActivity.class, "/me/map", "me", null, -1, Integer.MIN_VALUE));
        map.put("/me/myAliPay", RouteMeta.build(RouteType.ACTIVITY, MyAliPayActivity.class, "/me/myalipay", "me", null, -1, Integer.MIN_VALUE));
        map.put("/me/nickname", RouteMeta.build(RouteType.ACTIVITY, NicknameActivity.class, "/me/nickname", "me", null, -1, Integer.MIN_VALUE));
        map.put("/me/noticeCenter", RouteMeta.build(RouteType.ACTIVITY, NoticeCenterActivity.class, "/me/noticecenter", "me", null, -1, Integer.MIN_VALUE));
        map.put("/me/onlineService", RouteMeta.build(RouteType.ACTIVITY, OnlineServiceActivity.class, "/me/onlineservice", "me", null, -1, Integer.MIN_VALUE));
        String str = "/me/phone";
        map.put(str, RouteMeta.build(RouteType.ACTIVITY, PhoneActivity.class, "/me/phone", "me", new HashMap<String, Integer>() {
            {
                put("isMustBind", Integer.valueOf(0));
            }
        }, -1, Integer.MIN_VALUE));
        map.put("/me/private", RouteMeta.build(RouteType.ACTIVITY, PrivateActivity.class, "/me/private", "me", null, -1, Integer.MIN_VALUE));
        map.put("/me/realNameAuth", RouteMeta.build(RouteType.ACTIVITY, RealNameAuthActivity.class, "/me/realnameauth", "me", null, -1, Integer.MIN_VALUE));
        map.put("/me/setting", RouteMeta.build(RouteType.ACTIVITY, SettingActivity.class, "/me/setting", "me", null, -1, Integer.MIN_VALUE));
        map.put("/me/socialInfo", RouteMeta.build(RouteType.ACTIVITY, SocialInformationActivity.class, "/me/socialinfo", "me", null, -1, Integer.MIN_VALUE));
    }
}
