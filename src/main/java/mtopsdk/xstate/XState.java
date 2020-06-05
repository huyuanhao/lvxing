package mtopsdk.xstate;

import android.content.Context;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import mtopsdk.common.util.AsyncServiceBinder;
import mtopsdk.common.util.C8330d;
import mtopsdk.common.util.TBSdkLog;
import mtopsdk.common.util.TBSdkLog.LogEnable;
import mtopsdk.xstate.p693b.IXState;

/* renamed from: mtopsdk.xstate.a */
public class XState {
    /* renamed from: a */
    static volatile AtomicBoolean f28054a = new AtomicBoolean(false);
    /* renamed from: b */
    private static final ConcurrentHashMap<String, String> f28055b = new ConcurrentHashMap<>();
    /* renamed from: c */
    private static AsyncServiceBinder<IXState> f28056c;
    /* renamed from: d */
    private static AtomicBoolean f28057d = new AtomicBoolean(false);
    /* renamed from: e */
    private static Context f28058e = null;

    /* renamed from: a */
    public static boolean m35598a() {
        String a = m35595a("AppBackground");
        if (a != null) {
            try {
                return Boolean.valueOf(a).booleanValue();
            } catch (Exception unused) {
                TBSdkLog.m35510c("mtopsdk.XState", "[isAppBackground] parse KEY_APP_BACKGROUND error");
            }
        }
        return false;
    }

    /* renamed from: a */
    public static String m35595a(String str) {
        return m35596a(null, str);
    }

    /* renamed from: a */
    public static String m35596a(String str, String str2) {
        if (C8330d.m35525b(str2)) {
            return null;
        }
        if (C8330d.m35523a(str)) {
            str2 = C8330d.m35522a(str, str2);
        }
        String str3 = "[getValue]Attention :Use XState Local Mode: key:";
        String str4 = "mtopsdk.XState";
        if (!m35600b() || !f28054a.get()) {
            if (TBSdkLog.m35509b(LogEnable.InfoEnable)) {
                StringBuilder sb = new StringBuilder(str3);
                sb.append(str2);
                TBSdkLog.m35506b(str4, sb.toString());
            }
            return (String) f28055b.get(str2);
        }
        try {
            return ((IXState) f28056c.mo39742a()).mo39879b(str2);
        } catch (Exception e) {
            StringBuilder sb2 = new StringBuilder("[getValue] IXState.getValue(Key) failed,key:");
            sb2.append(str2);
            TBSdkLog.m35504a(str4, sb2.toString(), (Throwable) e);
            if (TBSdkLog.m35509b(LogEnable.InfoEnable)) {
                StringBuilder sb3 = new StringBuilder(str3);
                sb3.append(str2);
                TBSdkLog.m35506b(str4, sb3.toString());
            }
            return (String) f28055b.get(str2);
        }
    }

    /* renamed from: b */
    public static void m35599b(String str, String str2) {
        m35597a(null, str, str2);
    }

    /* renamed from: a */
    public static void m35597a(String str, String str2, String str3) {
        if (!C8330d.m35525b(str2) && !C8330d.m35525b(str3)) {
            if (C8330d.m35523a(str)) {
                str2 = C8330d.m35522a(str, str2);
            }
            String str4 = "[setValue]Attention :Use XState Local Mode: key:";
            String str5 = ",value:";
            String str6 = "mtopsdk.XState";
            if (!m35600b() || !f28054a.get()) {
                if (TBSdkLog.m35509b(LogEnable.WarnEnable)) {
                    StringBuilder sb = new StringBuilder(str4);
                    sb.append(str2);
                    sb.append(str5);
                    sb.append(str3);
                    TBSdkLog.m35506b(str6, sb.toString());
                }
                f28055b.put(str2, str3);
            } else {
                try {
                    ((IXState) f28056c.mo39742a()).mo39878a(str2, str3);
                } catch (Exception e) {
                    StringBuilder sb2 = new StringBuilder("[setValue] IXState.setValue(key,value) failed,key:");
                    sb2.append(str2);
                    sb2.append(str5);
                    sb2.append(str3);
                    TBSdkLog.m35504a(str6, sb2.toString(), (Throwable) e);
                    if (TBSdkLog.m35509b(LogEnable.InfoEnable)) {
                        StringBuilder sb3 = new StringBuilder(str4);
                        sb3.append(str2);
                        sb3.append(str5);
                        sb3.append(str3);
                        TBSdkLog.m35506b(str6, sb3.toString());
                    }
                    f28055b.put(str2, str3);
                }
            }
        }
    }

    /* renamed from: b */
    private static boolean m35600b() {
        AsyncServiceBinder<IXState> aVar = f28056c;
        if (aVar == null) {
            return false;
        }
        if (aVar.mo39742a() != null) {
            return true;
        }
        f28056c.mo39743a(f28058e);
        return false;
    }
}
