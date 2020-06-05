package com.tencent.android.tpush;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.android.tpush.common.C6901c;
import com.tencent.android.tpush.common.C6908h;
import com.tencent.android.tpush.common.Constants;
import com.tencent.android.tpush.encrypt.Rijndael;
import com.tencent.android.tpush.horse.Tools;
import com.tencent.android.tpush.p580b.C6864a;
import com.tencent.android.tpush.p581c.C6868b;
import com.tencent.android.tpush.service.C6973b;
import com.tencent.android.tpush.service.p595e.C7056i;
import com.tencent.mid.sotrage.StorageInterface;
import java.util.Set;
import org.slf4j.Marker;

/* compiled from: ProGuard */
public class XGPush4Msdk {
    /* renamed from: a */
    private static long f22680a = 0;
    /* renamed from: b */
    private static long f22681b = 0;
    /* renamed from: c */
    private static String f22682c = "";

    /* renamed from: a */
    private static boolean m29202a(long j, long j2, long j3) {
        return j >= j2 && j < j3;
    }

    public static void setQQAppKey(Context context, String str) {
    }

    /* access modifiers changed from: private|static */
    /* renamed from: b */
    public static String m29203b(Context context) {
        StringBuilder sb = new StringBuilder();
        sb.append(context.getPackageName());
        sb.append(":");
        sb.append("XG_DEBUG_SERVER_INFO");
        return sb.toString();
    }

    public static void setDebugServerInfo(final Context context, String str, int i) {
        if (!C7056i.m30194b(str)) {
            String b = m29203b(context);
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append(StorageInterface.KEY_SPLITER);
            sb.append(i);
            C6908h.m29487b(context, b, sb.toString());
            return;
        }
        C6901c.m29459a().mo33104a((Runnable) new Runnable() {
            public void run() {
                Context context = context;
                if (!C7056i.m30194b(C6908h.m29483a(context, XGPush4Msdk.m29203b(context), (String) null))) {
                    Context context2 = context;
                    C6908h.m29484a(context2, XGPush4Msdk.m29203b(context2));
                    Tools.clearCacheServerItems(context);
                    Tools.clearOptStrategyItem(context);
                }
            }
        });
    }

    public static String getDebugServerInfo(Context context) {
        return C6908h.m29483a(context, m29203b(context), (String) null);
    }

    public static boolean isDebugServerInfoStrategyItem(Context context) {
        try {
            String debugServerInfo = getDebugServerInfo(C6973b.m29776f());
            if (!C7056i.m30194b(debugServerInfo)) {
                String[] split = debugServerInfo.split(StorageInterface.KEY_SPLITER);
                if (split.length == 2 && split[0].length() > 4) {
                    return true;
                }
            }
        } catch (Throwable th) {
            C6864a.m29302d("XGPush4Msdk", " .isDebugServerInfoStrategyItem", th);
        }
        return false;
    }

    public static void setQQAppId(Context context, long j) {
        long j2 = 0;
        if (m29202a(j, 0, 200000)) {
            j2 = 90000000;
        } else if (!m29202a(j, 99000000, 100000000)) {
            if (m29202a(j, 100200000, 100600000)) {
                j2 = -10000000;
            } else if (m29202a(j, 101000000, 101400000)) {
                j2 = -10400000;
            } else if (m29202a(j, 900000000, 900100000)) {
                j2 = -809000000;
            } else if (m29202a(j, 1000000000, 1000100000)) {
                j2 = -908900000;
            } else if (m29202a(j, 1101000000, 1104500000)) {
                j2 = -1009800000;
            } else if (m29202a(j, 1150000000, 1150100000)) {
                j2 = -1055300000;
            } else if (m29202a(j, 100600000, 101000000)) {
                j2 = -5800000;
            } else if (m29202a(j, 1104500000, 1109300000)) {
                j2 = -1009300000;
            } else if (m29202a(j, 1109300000, 1119300000)) {
                j2 = -1029300000;
            } else if (m29202a(j, 1119300000, 1120000000)) {
                j2 = -1049300000;
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append("手Q的appid：");
                sb.append(j);
                sb.append(" 不在固定的范围，请联系msdk和信鸽的同事解决之。");
                Log.e(Constants.MSDK_TAG, sb.toString());
            }
        }
        long j3 = j2 + 2100000000 + j;
        f22680a = j;
        f22681b = j3;
        C6908h.m29486b(context, "TPUSH_QQ_ACCESS_ID", f22681b);
        C6908h.m29484a(context, "TPUSH_QQ_APP_ID");
        StringBuilder sb2 = new StringBuilder();
        sb2.append("MSDK_");
        sb2.append(j);
        f22682c = sb2.toString();
        C6908h.m29487b(context, "__en__TPUSH_QQ_ACCESS_KEY", Rijndael.encrypt(f22682c));
        C6908h.m29484a(context, "TPUSH_QQ_ACCESS_KEY");
    }

    public static long getQQAccessId(Context context) {
        long j = f22681b;
        if (j <= 0) {
            f22681b = C6908h.m29481a(context, "TPUSH_QQ_ACCESS_ID", j);
        }
        return f22681b;
    }

    public static String getQQAppKey(Context context) {
        if (!TextUtils.isEmpty(f22682c)) {
            return f22682c;
        }
        String a = C6908h.m29483a(context, "__en__TPUSH_QQ_ACCESS_KEY", f22682c);
        if (!TextUtils.isEmpty(a)) {
            f22682c = Rijndael.decrypt(a);
        } else {
            String str = "";
            String str2 = "TPUSH_QQ_ACCESS_KEY";
            f22682c = C6908h.m29483a(context, str2, str);
            C6908h.m29487b(context, str2, str);
        }
        return f22682c;
    }

    public static void setTag(Context context, String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("setTag: tagName=");
        sb.append(str);
        sb.append(",qqAppid=");
        sb.append(f22680a);
        sb.append(",xg_accessid=");
        sb.append(getQQAccessId(context));
        C6864a.m29298c(Constants.MSDK_TAG, sb.toString());
        XGPushManager.m29233a(context, str, 1, getQQAccessId(context), str);
    }

    public static void deleteTag(Context context, String str) {
        if (XGPushConfig.enableDebug) {
            StringBuilder sb = new StringBuilder();
            sb.append("deleteTag: tagName=");
            sb.append(str);
            sb.append(",qqAppid=");
            sb.append(f22680a);
            sb.append(",xg_accessid=");
            sb.append(getQQAccessId(context));
            C6864a.m29298c(Constants.MSDK_TAG, sb.toString());
        }
        XGPushManager.m29233a(context, str, 2, getQQAccessId(context), str);
    }

    public static void setTags(Context context, String str, Set<String> set) {
        boolean z = XGPushConfig.enableDebug;
        String str2 = Constants.MSDK_TAG;
        if (z) {
            StringBuilder sb = new StringBuilder();
            sb.append("setTags: operateName=");
            sb.append(str);
            sb.append(",qqAppid=");
            sb.append(f22680a);
            sb.append(",xg_accessid=");
            sb.append(getQQAccessId(context));
            C6864a.m29298c(str2, sb.toString());
        }
        if (context == null || set == null || set.isEmpty()) {
            C6864a.m29309j(str2, "the parameter context or tags of setTags is invalid.");
            return;
        }
        String a = XGPushManager.m29226a(set, "setTags");
        if (a == null) {
            C6864a.m29309j(str2, "setTags -> getTagsFromSet return null!!!");
            return;
        }
        if (XGPushConfig.enableDebug) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Action -> setTags with all tags = ");
            sb2.append(a);
            C6864a.m29305f(str2, sb2.toString());
        }
        XGPushManager.m29233a(context, a, 6, getQQAccessId(context), str);
    }

    public static void addTags(Context context, String str, Set<String> set) {
        boolean z = XGPushConfig.enableDebug;
        String str2 = Constants.MSDK_TAG;
        if (z) {
            StringBuilder sb = new StringBuilder();
            sb.append("addTags: operateName=");
            sb.append(str);
            sb.append(",qqAppid=");
            sb.append(f22680a);
            sb.append(",xg_accessid=");
            sb.append(getQQAccessId(context));
            C6864a.m29298c(str2, sb.toString());
        }
        if (context == null || set == null || set.isEmpty()) {
            C6864a.m29309j(str2, "the parameter context or tags of addTags is invalid.");
            return;
        }
        String a = XGPushManager.m29226a(set, "addTags");
        if (a == null) {
            C6864a.m29309j(str2, "addTags -> getTagsFromSet return null!!!");
            return;
        }
        if (XGPushConfig.enableDebug) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("addTags -> setTags with all tags = ");
            sb2.append(a);
            C6864a.m29305f(str2, sb2.toString());
        }
        XGPushManager.m29233a(context, a, 5, getQQAccessId(context), str);
    }

    public static void deleteTags(Context context, String str, Set<String> set) {
        boolean z = XGPushConfig.enableDebug;
        String str2 = Constants.MSDK_TAG;
        if (z) {
            StringBuilder sb = new StringBuilder();
            sb.append("deleteTags: operateName=");
            sb.append(str);
            sb.append(",qqAppid=");
            sb.append(f22680a);
            sb.append(",xg_accessid=");
            sb.append(getQQAccessId(context));
            C6864a.m29298c(str2, sb.toString());
        }
        if (context == null || set == null || set.isEmpty()) {
            C6864a.m29309j(str2, "the parameter context or tags of deleteTags is invalid.");
            return;
        }
        String a = XGPushManager.m29226a(set, "deleteTags");
        if (a == null) {
            C6864a.m29309j(str2, "deleteTags -> getTagsFromSet return null!!!");
            return;
        }
        if (XGPushConfig.enableDebug) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("deleteTags -> setTags with all tags = ");
            sb2.append(a);
            C6864a.m29305f(str2, sb2.toString());
        }
        XGPushManager.m29233a(context, a, 7, getQQAccessId(context), str);
    }

    public static void cleanTags(Context context, String str) {
        boolean z = XGPushConfig.enableDebug;
        String str2 = Constants.MSDK_TAG;
        if (z) {
            StringBuilder sb = new StringBuilder();
            sb.append("cleanTags: operateName=");
            sb.append(str);
            sb.append(",qqAppid=");
            sb.append(f22680a);
            sb.append(",xg_accessid=");
            sb.append(getQQAccessId(context));
            C6864a.m29298c(str2, sb.toString());
        }
        if (context == null) {
            C6864a.m29309j(str2, "the parameter context of cleanTags is invalid");
            return;
        }
        if (XGPushConfig.enableDebug) {
            C6864a.m29305f(str2, "Action -> cleanTags");
        }
        Context context2 = context;
        XGPushManager.m29233a(context2, Marker.ANY_MARKER, 8, getQQAccessId(context), str);
    }

    public static void registerPush(Context context, String str, XGIOperateCallback xGIOperateCallback) {
        if (XGPushConfig.enableDebug) {
            StringBuilder sb = new StringBuilder();
            sb.append("registerPush: account=");
            sb.append(str);
            sb.append(",qqAppid=");
            sb.append(f22680a);
            sb.append(",xg_accessid=");
            sb.append(getQQAccessId(context));
            C6864a.m29303e(Constants.MSDK_TAG, sb.toString());
        }
        if (xGIOperateCallback == null) {
            xGIOperateCallback = new XGIOperateCallback() {
                public void onSuccess(Object obj, int i) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("xg register push onSuccess. token:");
                    sb.append(obj);
                    C6864a.m29303e(Constants.MSDK_TAG, sb.toString());
                }

                public void onFail(Object obj, int i, String str) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("xg register push onFail. token:");
                    sb.append(obj);
                    sb.append(", errCode:");
                    sb.append(i);
                    sb.append(",msg:");
                    sb.append(str);
                    C6864a.m29308i(Constants.MSDK_TAG, sb.toString());
                }
            };
        }
        XGIOperateCallback xGIOperateCallback2 = xGIOperateCallback;
        if (!C7056i.m30194b(str)) {
            Context context2 = context;
            String str2 = str;
            XGPushManager.m29234a(context2, str2, "0", 0, null, xGIOperateCallback2, getQQAccessId(context), getQQAppKey(context), null, null, null, 0);
            return;
        }
        XGPushManager.m29234a(context, null, null, -1, null, xGIOperateCallback2, getQQAccessId(context), getQQAppKey(context), null, null, null, 0);
    }

    public static void unregisterPush(Context context, XGIOperateCallback xGIOperateCallback) {
        if (XGPushConfig.enableDebug) {
            StringBuilder sb = new StringBuilder();
            sb.append("unregisterPush,qqAppid=");
            sb.append(f22680a);
            sb.append(",xg_accessid=");
            sb.append(getQQAccessId(context));
            C6864a.m29303e(Constants.MSDK_TAG, sb.toString());
        }
        if (xGIOperateCallback == null) {
            xGIOperateCallback = new XGIOperateCallback() {
                public void onSuccess(Object obj, int i) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("xg unregisterPush push onSuccess. flag:");
                    sb.append(i);
                    C6864a.m29303e(Constants.MSDK_TAG, sb.toString());
                }

                public void onFail(Object obj, int i, String str) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("xg unregisterPush push onFail. token:");
                    sb.append(obj);
                    sb.append(", errCode:");
                    sb.append(i);
                    sb.append(",msg:");
                    sb.append(str);
                    C6864a.m29308i(Constants.MSDK_TAG, sb.toString());
                }
            };
        }
        XGPushManager.m29232a(context, xGIOperateCallback, getQQAccessId(context), getQQAppKey(context), null, null, null);
    }

    public static long addLocalNotification(Context context, XGLocalMessage xGLocalMessage) {
        if (XGPushConfig.enableDebug) {
            StringBuilder sb = new StringBuilder();
            sb.append("addLocalNotification:msg=");
            sb.append(xGLocalMessage.toString());
            sb.append(",qqAppid=");
            sb.append(f22680a);
            sb.append(",xg_accessid=");
            sb.append(getQQAccessId(context));
            C6864a.m29303e(Constants.MSDK_TAG, sb.toString());
        }
        return XGPushManager.m29222a(context, xGLocalMessage, getQQAccessId(context));
    }

    public static void setPushNotificationBuilder(Context context, int i, XGPushNotificationBuilder xGPushNotificationBuilder) {
        if (context == null) {
            throw new IllegalArgumentException("context is null.");
        } else if (i < 5000 || i > 6000) {
            throw new IllegalArgumentException("notificationBulderId超过范围[5000, 6000].");
        } else if (xGPushNotificationBuilder != null) {
            C6868b.m29321a(context, i, xGPushNotificationBuilder);
        }
    }

    public static void setDefaultNotificationBuilder(Context context, XGPushNotificationBuilder xGPushNotificationBuilder) {
        XGPushManager.setDefaultNotificationBuilder(context, xGPushNotificationBuilder);
    }
}
