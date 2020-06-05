package com.tencent.android.tpush.horse;

import android.content.Context;
import com.tencent.android.tpush.XGPushConfig;
import com.tencent.android.tpush.XGPushManager;
import com.tencent.android.tpush.common.C6907g;
import com.tencent.android.tpush.common.Constants;
import com.tencent.android.tpush.horse.data.OptStrategyList;
import com.tencent.android.tpush.p580b.C6864a;
import com.tencent.android.tpush.service.C6973b;
import com.tencent.android.tpush.service.cache.CacheManager;
import com.tencent.android.tpush.service.p588a.C6971a;
import com.tencent.android.tpush.service.p595e.C7056i;
import java.util.Iterator;

/* compiled from: ProGuard */
public class Tools {
    public static final String KEY = ".com.tencent.tpush.toolschannel";
    public static final String SHARE_NAME = ".com.tencent.tpush.toolschannel_name";
    public static final String STRATEGY = ".com.tencent.tpush.toolsstrategy";
    public static final String TOOLS_NAME_UNI_SUFFIX = ".com.tencent.tpush.tools";
    public static final int TYPE_DEFAULT = 0;
    public static final int TYPE_HTTP = 2;
    public static final int TYPE_HTTP_WAP = 3;
    public static final int TYPE_TCP = 1;
    public static final int TYPE_TCP_OR_HTTP = 4;

    public static void clearOptKeyList(Context context) {
        if (context != null) {
            CacheManager.clearOptKeyList(context);
        }
    }

    public static void clearOptStrategyItem(Context context) {
        if (context != null) {
            boolean z = XGPushConfig.enableDebug;
            String str = Constants.ServiceLogTag;
            if (z) {
                StringBuilder sb = new StringBuilder();
                sb.append("Action -> clearOptStrategyItem(");
                sb.append(context.getPackageName());
                sb.append(")");
                C6864a.m29305f(str, sb.toString());
            }
            try {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(C7056i.m30218l(C6973b.m29776f()));
                sb2.append(".com.tencent.tpush.cache.redirect");
                C6907g.m29478a(context, sb2.toString(), "", true);
                Iterator it = CacheManager.getOptKeyList(context).iterator();
                while (it.hasNext()) {
                    CacheManager.addOptStrategyList(context, (String) it.next(), new OptStrategyList());
                }
            } catch (Exception e) {
                CacheManager.clearOptKeyList(C6973b.m29776f());
                C6864a.m29304e(str, "clearOptStrategyItem error", e);
            }
            CacheManager.addOptStrategyList(context, C7056i.m30218l(context), new OptStrategyList());
        }
    }

    public static void clearCacheServerItems(Context context) {
        if (context != null) {
            boolean z = XGPushConfig.enableDebug;
            String str = Constants.ServiceLogTag;
            if (z) {
                StringBuilder sb = new StringBuilder();
                sb.append("Action -> clearCacheServerItems(");
                sb.append(context.getPackageName());
                sb.append(")");
                C6864a.m29305f(str, sb.toString());
            }
            try {
                CacheManager.clearDomainServerItem(context);
                CacheManager.saveDomain(context, "");
                CacheManager.saveDomainKeyList(context, null);
                C6971a.m29749a(context).mo33279a(0);
            } catch (Throwable th) {
                C6864a.m29304e(str, "clearCacheServerItems error", th);
            }
        }
    }

    public static void clearRegisterInfo(Context context, long j) {
        if (context != null) {
            try {
                CacheManager.removeRegisterInfoByPkgName(context.getPackageName());
            } catch (Exception e) {
                C6864a.m29302d(Constants.ServiceLogTag, "clearRegisterInfo", e);
            }
        }
    }

    public static void setChannelType(Context context, int i) {
        if (context != null) {
            C6907g.m29477a(context, KEY, i);
        }
    }

    public static int getChannelType(Context context) {
        if (context != null) {
            return C6907g.m29479b(context, KEY, 0);
        }
        return 0;
    }

    public static void clearAll(Context context) {
        clearOptKeyList(context);
        clearCacheServerItems(context);
        clearOptStrategyItem(context);
        XGPushManager.clearLocalNotifications(context);
        C6907g.m29478a(context, Constants.IS_CACHE_CLEAR, Constants.IS_CLEAR_CACHE, true);
    }
}
