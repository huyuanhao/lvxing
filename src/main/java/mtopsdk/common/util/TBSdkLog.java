package mtopsdk.common.util;

import android.util.Log;
import com.tencent.mid.sotrage.StorageInterface;
import java.util.HashMap;
import java.util.Map;
import mtopsdk.common.p688b.LogAdapter;

public class TBSdkLog {
    /* renamed from: a */
    private static boolean f27829a = true;
    /* renamed from: b */
    private static boolean f27830b = true;
    /* renamed from: c */
    private static LogEnable f27831c = LogEnable.DebugEnable;
    /* renamed from: d */
    private static Map<String, LogEnable> f27832d = new HashMap(5);
    /* renamed from: e */
    private static LogAdapter f27833e;

    /* renamed from: mtopsdk.common.util.TBSdkLog$LogEnable */
    public enum LogEnable {
        VerboseEnable("V"),
        DebugEnable("D"),
        InfoEnable("I"),
        WarnEnable("W"),
        ErrorEnable("E"),
        NoneEnable("L");
        
        private String logEnable;

        public final String getLogEnable() {
            return this.logEnable;
        }

        private LogEnable(String str) {
            this.logEnable = str;
        }
    }

    static {
        LogEnable[] values;
        for (LogEnable logEnable : LogEnable.values()) {
            f27832d.put(logEnable.getLogEnable(), logEnable);
        }
    }

    /* renamed from: a */
    public static void m35505a(LogEnable logEnable) {
        if (logEnable != null) {
            f27831c = logEnable;
            StringBuilder sb = new StringBuilder("[setLogEnable] logEnable=");
            sb.append(logEnable);
            Log.d("mtopsdk.TBSdkLog", sb.toString());
        }
    }

    /* renamed from: a */
    public static void m35501a(String str, String str2) {
        m35502a(str, (String) null, str2);
    }

    /* renamed from: a */
    public static void m35502a(String str, String str2, String str3) {
        if (m35509b(LogEnable.DebugEnable)) {
            if (f27830b) {
                LogAdapter aVar = f27833e;
                if (aVar != null) {
                    aVar.mo39739a(2, str, m35500a(str2, str3), null);
                }
            } else if (f27829a) {
                Log.d(str, m35500a(str2, str3));
            }
        }
    }

    /* renamed from: b */
    public static void m35506b(String str, String str2) {
        m35507b(str, null, str2);
    }

    /* renamed from: b */
    public static void m35507b(String str, String str2, String str3) {
        if (m35509b(LogEnable.InfoEnable)) {
            if (f27830b) {
                LogAdapter aVar = f27833e;
                if (aVar != null) {
                    aVar.mo39739a(4, str, m35500a(str2, str3), null);
                }
            } else if (f27829a) {
                Log.i(str, m35500a(str2, str3));
            }
        }
    }

    /* renamed from: c */
    public static void m35511c(String str, String str2, String str3) {
        if (m35509b(LogEnable.WarnEnable)) {
            if (f27830b) {
                LogAdapter aVar = f27833e;
                if (aVar != null) {
                    aVar.mo39739a(8, str, m35500a(str2, str3), null);
                }
            } else if (f27829a) {
                Log.w(str, m35500a(str2, str3));
            }
        }
    }

    /* renamed from: a */
    public static void m35503a(String str, String str2, String str3, Throwable th) {
        if (m35509b(LogEnable.WarnEnable)) {
            if (f27830b) {
                LogAdapter aVar = f27833e;
                if (aVar != null) {
                    aVar.mo39739a(8, str, m35500a(str2, str3), th);
                }
            } else if (f27829a) {
                Log.w(str, m35500a(str2, str3), th);
            }
        }
    }

    /* renamed from: c */
    public static void m35510c(String str, String str2) {
        m35513d(str, null, str2);
    }

    /* renamed from: d */
    public static void m35513d(String str, String str2, String str3) {
        if (m35509b(LogEnable.ErrorEnable)) {
            if (f27830b) {
                LogAdapter aVar = f27833e;
                if (aVar != null) {
                    aVar.mo39739a(16, str, m35500a(str2, str3), null);
                }
            } else if (f27829a) {
                Log.e(str, m35500a(str2, str3));
            }
        }
    }

    /* renamed from: a */
    public static void m35504a(String str, String str2, Throwable th) {
        m35508b(str, null, str2, th);
    }

    /* renamed from: b */
    public static void m35508b(String str, String str2, String str3, Throwable th) {
        if (m35509b(LogEnable.ErrorEnable)) {
            if (f27830b) {
                LogAdapter aVar = f27833e;
                if (aVar != null) {
                    aVar.mo39739a(16, str, m35500a(str2, str3), th);
                }
            } else if (f27829a) {
                Log.e(str, m35500a(str2, str3), th);
            }
        }
    }

    /* renamed from: a */
    private static String m35500a(String str, String... strArr) {
        StringBuilder sb = new StringBuilder();
        if (str != null) {
            sb.append("[seq:");
            sb.append(str);
            sb.append("]|");
        }
        if (strArr != null) {
            for (int i = 0; i < strArr.length; i++) {
                sb.append(strArr[i]);
                if (i < strArr.length - 1) {
                    sb.append(StorageInterface.KEY_SPLITER);
                }
            }
        }
        return sb.toString();
    }

    /* renamed from: b */
    public static boolean m35509b(LogEnable logEnable) {
        if (f27830b) {
            LogAdapter aVar = f27833e;
            if (aVar != null) {
                LogEnable logEnable2 = (LogEnable) f27832d.get(aVar.mo39738a());
                if (!(logEnable2 == null || f27831c.ordinal() == logEnable2.ordinal())) {
                    m35505a(logEnable2);
                }
            }
        }
        return logEnable.ordinal() >= f27831c.ordinal();
    }

    /* renamed from: d */
    public static void m35512d(String str, String str2) {
        try {
            if (f27833e != null) {
                f27833e.mo39740a(str, str2);
            }
        } catch (Throwable unused) {
            Log.w("mtopsdk.TBSdkLog", "[logTraceId] call LogAdapter.traceLog error");
        }
    }
}
