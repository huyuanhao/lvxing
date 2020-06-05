package com.jiayouya.travel.module.p281tb.util;

import com.alibaba.baichuan.android.trade.callback.AlibcTradeCallback;
import com.alibaba.baichuan.trade.biz.context.AlibcTradeResult;
import com.elvishew.xlog.XLog;
import kotlin.Metadata;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u0012\u0010\b\u001a\u00020\u00032\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016¨\u0006\u000b"}, mo39189d2 = {"com/jiayouya/travel/module/tb/util/TaobaoUtil$openShop$2", "Lcom/alibaba/baichuan/android/trade/callback/AlibcTradeCallback;", "onFailure", "", "code", "", "msg", "", "onTradeSuccess", "result", "Lcom/alibaba/baichuan/trade/biz/context/AlibcTradeResult;", "app_grRelease"}, mo39190k = 1, mo39191mv = {1, 1, 15})
/* compiled from: TaobaoUtil.kt */
/* renamed from: com.jiayouya.travel.module.tb.util.TaobaoUtil$openShop$2 */
public final class TaobaoUtil$openShop$2 implements AlibcTradeCallback {
    TaobaoUtil$openShop$2() {
    }

    public void onTradeSuccess(AlibcTradeResult alibcTradeResult) {
        StringBuilder sb = new StringBuilder();
        sb.append("AlibcTrade，type = ");
        sb.append(alibcTradeResult != null ? alibcTradeResult.resultType : null);
        XLog.m12692b(sb.toString());
    }

    public void onFailure(int i, String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("AlibcTrade，code = ");
        sb.append(i);
        sb.append(", info = ");
        sb.append(str);
        XLog.m12692b(sb.toString());
    }
}
