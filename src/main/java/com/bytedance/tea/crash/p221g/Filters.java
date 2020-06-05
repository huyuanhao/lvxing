package com.bytedance.tea.crash.p221g;

import java.util.HashSet;
import java.util.Set;

/* renamed from: com.bytedance.tea.crash.g.e */
public final class Filters {
    /* renamed from: a */
    private static final Set<String> f9373a = new HashSet();

    static {
        f9373a.add("HeapTaskDaemon");
        f9373a.add("ThreadPlus");
        f9373a.add("ApiDispatcher");
        f9373a.add("ApiLocalDispatcher");
        f9373a.add("AsyncLoader");
        f9373a.add("AsyncTask");
        f9373a.add("Binder");
        f9373a.add("PackageProcessor");
        f9373a.add("SettingsObserver");
        f9373a.add("WifiManager");
        f9373a.add("JavaBridge");
        f9373a.add("Compiler");
        f9373a.add("Signal Catcher");
        f9373a.add("GC");
        f9373a.add("ReferenceQueueDaemon");
        f9373a.add("FinalizerDaemon");
        f9373a.add("FinalizerWatchdogDaemon");
        f9373a.add("CookieSyncManager");
        f9373a.add("RefQueueWorker");
        f9373a.add("CleanupReference");
        f9373a.add("VideoManager");
        f9373a.add("DBHelper-AsyncOp");
        f9373a.add("InstalledAppTracker2");
        f9373a.add("AppData-AsyncOp");
        f9373a.add("IdleConnectionMonitor");
        f9373a.add("LogReaper");
        f9373a.add("ActionReaper");
        f9373a.add("Okio Watchdog");
        f9373a.add("CheckWaitingQueue");
        f9373a.add("NPTH-CrashTimer");
        f9373a.add("NPTH-JavaCallback");
        f9373a.add("NPTH-LocalParser");
        f9373a.add("ANR_FILE_MODIFY");
    }

    /* renamed from: a */
    public static Set<String> m12534a() {
        return f9373a;
    }
}
