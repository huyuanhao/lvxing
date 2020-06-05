package com.tencent.android.tpush.horse;

import com.tencent.android.tpush.common.Constants;
import com.tencent.android.tpush.horse.data.ServerItem;
import com.tencent.android.tpush.horse.data.StrategyItem;
import com.tencent.android.tpush.p580b.C6864a;
import com.tencent.android.tpush.service.C6973b;
import com.tencent.android.tpush.service.cache.CacheManager;
import com.tencent.android.tpush.service.channel.exception.NullReturnException;
import java.util.ArrayList;
import java.util.List;

/* compiled from: ProGuard */
/* renamed from: com.tencent.android.tpush.horse.f */
public class C6947f {
    /* renamed from: a */
    private static StrategyItem m29669a(String str, int i, int i2) {
        if (str == null || i == 0) {
            return null;
        }
        StrategyItem strategyItem = new StrategyItem(str, i, "", 80, i2, 0);
        return strategyItem;
    }

    /* renamed from: a */
    private static List<StrategyItem> m29671a(List<ServerItem> list, short s, String str) {
        if (list != null) {
            ArrayList arrayList = new ArrayList();
            StrategyItem strategyItem = null;
            try {
                strategyItem = CacheManager.getOptStrategyList(C6973b.m29776f(), str).getOptStrategyItem();
                strategyItem.setRedirect(0);
                if (strategyItem.getProtocolType() == s) {
                    arrayList.add(strategyItem);
                }
            } catch (Exception unused) {
                C6864a.m29308i(Constants.ServiceLogTag, "getStrategyItems is null");
            }
            for (int i = 0; i < list.size(); i++) {
                StrategyItem a = m29669a(((ServerItem) list.get(i)).getServerIp(), ((ServerItem) list.get(i)).getServerPort(), (int) s);
                if (a != null && !a.equals(strategyItem)) {
                    arrayList.add(a);
                }
            }
            return arrayList;
        }
        throw new NullReturnException("getStrategyItems return null, because [items] is null");
    }

    /* renamed from: a */
    public static List<StrategyItem> m29670a(List<ServerItem> list, String str) {
        return m29671a(list, 0, str);
    }

    /* renamed from: b */
    public static List<StrategyItem> m29672b(List<ServerItem> list, String str) {
        return m29671a(list, 1, str);
    }
}
