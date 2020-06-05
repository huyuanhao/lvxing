package com.kwai.filedownloader.p358f;

/* renamed from: com.kwai.filedownloader.f.a */
public class C4651a {
    /* renamed from: a */
    private static void m19097a(String str, Object... objArr) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(", but the download service isn't connected yet.");
        sb.append("\nYou can use FileDownloader#isServiceConnected() to check whether the service has been connected, \nbesides you can use following functions easier to control your requestHttpCode invoke after the service has been connected: \n1. FileDownloader#bindService(Runnable)\n2. FileDownloader#insureServiceBind()\n3. FileDownloader#insureServiceBindAsync()");
        C4660d.m19124d(C4651a.class, sb.toString(), objArr);
    }

    /* renamed from: a */
    public static boolean m19098a(int i) {
        m19097a("request pause the task[%d] in the download service", Integer.valueOf(i));
        return false;
    }

    /* renamed from: a */
    public static boolean m19099a(String str, String str2, boolean z) {
        m19097a("request start the task([%s], [%s], [%B]) in the download service", str, str2, Boolean.valueOf(z));
        return false;
    }

    /* renamed from: b */
    public static byte m19100b(int i) {
        m19097a("request get the status for the task[%d] in the download service", Integer.valueOf(i));
        return 0;
    }

    /* renamed from: c */
    public static boolean m19101c(int i) {
        m19097a("request clear the task[%d] data in the database", Integer.valueOf(i));
        return false;
    }
}
