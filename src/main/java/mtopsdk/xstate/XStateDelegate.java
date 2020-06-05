package mtopsdk.xstate;

import android.content.Context;
import android.content.IntentFilter;
import java.util.concurrent.ConcurrentHashMap;
import mtopsdk.common.util.TBSdkLog;
import mtopsdk.common.util.TBSdkLog.LogEnable;
import mtopsdk.xstate.p692a.NetworkStateReceiver;

/* renamed from: mtopsdk.xstate.b */
public final class XStateDelegate {
    /* renamed from: a */
    private static ConcurrentHashMap<String, String> f28066a = null;
    /* renamed from: b */
    private static NetworkStateReceiver f28067b = null;
    /* renamed from: c */
    private static Context f28068c = null;
    /* renamed from: d */
    private static volatile boolean f28069d = false;

    /* renamed from: a */
    public static void m35605a(Context context) {
        String str = "mtopsdk.XStateDelegate";
        if (!f28069d) {
            try {
                if (!f28069d) {
                    if (context == null) {
                        TBSdkLog.m35510c(str, "[checkInit]parameter context for init(Context context) is null.");
                        return;
                    }
                    if (f28066a == null) {
                        f28066a = new ConcurrentHashMap<>();
                    }
                    f28068c = context;
                    if (f28067b == null) {
                        f28067b = new NetworkStateReceiver();
                        IntentFilter intentFilter = new IntentFilter();
                        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
                        context.registerReceiver(f28067b, intentFilter);
                    }
                    f28069d = true;
                    if (TBSdkLog.m35509b(LogEnable.InfoEnable)) {
                        StringBuilder sb = new StringBuilder("[checkInit] init XState OK,isInit=");
                        sb.append(f28069d);
                        TBSdkLog.m35506b(str, sb.toString());
                    }
                }
            } catch (Throwable th) {
                StringBuilder sb2 = new StringBuilder("[checkInit] checkInit error --");
                sb2.append(th.toString());
                TBSdkLog.m35510c(str, sb2.toString());
            }
        }
    }

    /* renamed from: a */
    public static void m35604a() {
        String str = "mtopsdk.XStateDelegate";
        if (f28069d) {
            try {
                if (f28069d) {
                    if (f28066a != null) {
                        f28066a.clear();
                        f28066a = null;
                    }
                    if (f28068c == null) {
                        TBSdkLog.m35510c(str, "[unInit] context in Class XState is null.");
                        return;
                    }
                    try {
                        if (f28067b != null) {
                            f28068c.unregisterReceiver(f28067b);
                            f28067b = null;
                        }
                    } catch (Throwable th) {
                        TBSdkLog.m35504a(str, "[unRegisterReceive]unRegisterReceive failed", th);
                    }
                    f28069d = false;
                    if (TBSdkLog.m35509b(LogEnable.InfoEnable)) {
                        StringBuilder sb = new StringBuilder("[unInit] unInit XState OK,isInit=");
                        sb.append(f28069d);
                        TBSdkLog.m35506b(str, sb.toString());
                    }
                }
            } catch (Exception e) {
                StringBuilder sb2 = new StringBuilder("[unInit] unInit error --");
                sb2.append(e.toString());
                TBSdkLog.m35510c(str, sb2.toString());
            }
        }
    }

    /* renamed from: a */
    public static String m35603a(String str) {
        ConcurrentHashMap<String, String> concurrentHashMap = f28066a;
        if (concurrentHashMap == null || str == null) {
            return null;
        }
        return (String) concurrentHashMap.get(str);
    }

    /* renamed from: a */
    public static void m35606a(String str, String str2) {
        ConcurrentHashMap<String, String> concurrentHashMap = f28066a;
        String str3 = "mtopsdk.XStateDelegate";
        if (concurrentHashMap != null && str != null && str2 != null) {
            concurrentHashMap.put(str, str2);
            if (TBSdkLog.m35509b(LogEnable.DebugEnable)) {
                StringBuilder sb = new StringBuilder("[setValue]set  XStateID succeed,");
                sb.append(str);
                sb.append("=");
                sb.append(str2);
                TBSdkLog.m35501a(str3, sb.toString());
            }
        } else if (TBSdkLog.m35509b(LogEnable.DebugEnable)) {
            StringBuilder sb2 = new StringBuilder("[setValue]set  XStateID failed,key=");
            sb2.append(str);
            sb2.append(",value=");
            sb2.append(str2);
            TBSdkLog.m35501a(str3, sb2.toString());
        }
    }

    /* renamed from: b */
    public static String m35607b(String str) {
        if (f28066a == null || str == null) {
            return null;
        }
        if (TBSdkLog.m35509b(LogEnable.DebugEnable)) {
            StringBuilder sb = new StringBuilder("remove XState key=");
            sb.append(str);
            TBSdkLog.m35501a("mtopsdk.XStateDelegate", sb.toString());
        }
        return (String) f28066a.remove(str);
    }
}
