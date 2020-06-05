package com.tencent.p605ep.common.adapt.iservice.vip;

import android.content.Context;
import com.tencent.p605ep.common.adapt.iservice.account.MainAccountInfo;

/* renamed from: com.tencent.ep.common.adapt.iservice.vip.IVipService */
public interface IVipService {
    public static final String ACTION_MSG_VIP_STATE_CHANGE_NOTIFY = "qqpimsecure.action.msg.vip_state_change_notify";

    /* renamed from: com.tencent.ep.common.adapt.iservice.vip.IVipService$VIP_BROADCAST_KEY */
    public interface VIP_BROADCAST_KEY {
        public static final String VIPINFO = "vipinfo";
    }

    boolean canShowVIP();

    VIPInfo getCacheVIPInfo();

    @Deprecated
    VIPInfo getRealTimeVIPInfo();

    VIPInfo getRealTimeVIPInfo(MainAccountInfo mainAccountInfo);

    VIPPrice getVIPPriceByMonth(int i, IGetVIPPriceListener iGetVIPPriceListener);

    @Deprecated
    void jumpToBuyVIP(Context context);

    void jumpToBuyVIP(Context context, int i);

    void setCanShowVIP(boolean z);
}
