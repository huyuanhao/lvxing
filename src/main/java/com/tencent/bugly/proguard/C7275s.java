package com.tencent.bugly.proguard;

import android.content.ContentValues;
import android.text.TextUtils;
import com.tencent.bugly.beta.download.C7125b;
import com.tencent.bugly.beta.download.DownloadTask;
import com.tencent.bugly.beta.global.C7131e;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;

/* compiled from: BUGLY */
/* renamed from: com.tencent.bugly.proguard.s */
public class C7275s implements C7125b {
    /* renamed from: a */
    public static C7275s f24609a = new C7275s();
    /* renamed from: b */
    public ConcurrentHashMap<String, DownloadTask> f24610b = new ConcurrentHashMap<>(3);
    /* renamed from: c */
    private ScheduledExecutorService f24611c = null;

    public C7275s() {
        try {
            this.f24611c = Executors.newScheduledThreadPool(3, new ThreadFactory() {
                public Thread newThread(Runnable runnable) {
                    Thread thread = new Thread(runnable);
                    thread.setName("BETA_SDK_DOWNLOAD");
                    return thread;
                }
            });
            if (this.f24611c.isShutdown()) {
                throw new IllegalArgumentException("ScheduledExecutorService is not available!");
            }
        } catch (Exception e) {
            C7226an.m31142a(e);
        }
    }

    /* renamed from: a */
    public DownloadTask mo34326a(String str, String str2, String str3, String str4) {
        String str5 = str;
        C7277t tVar = null;
        if (TextUtils.isEmpty(str)) {
            C7226an.m31149e("downloadUrl is null!", new Object[0]);
            return null;
        } else if (TextUtils.isEmpty(str2)) {
            C7226an.m31149e("saveDir is null!", new Object[0]);
            return null;
        } else if (this.f24610b.get(str5) != null) {
            return (DownloadTask) this.f24610b.get(str5);
        } else {
            ContentValues a = C7270p.f24600a.mo34949a(str5);
            if (a != null) {
                String str6 = "_dUrl";
                if (a.get(str6) != null) {
                    String str7 = "_sFile";
                    if (a.getAsString(str7) != null) {
                        String str8 = "_sLen";
                        if (a.getAsLong(str8) != null) {
                            String str9 = "_tLen";
                            if (a.getAsLong(str9) != null) {
                                String str10 = "_MD5";
                                if (a.getAsString(str10) != null) {
                                    tVar = new C7277t((String) a.get(str6), a.getAsString(str7), a.getAsLong(str8).longValue(), a.getAsLong(str9).longValue(), a.getAsString(str10));
                                    String str11 = "_DLTIME";
                                    if (a.getAsLong(str11) != null) {
                                        tVar.f24613k = a.getAsLong(str11).longValue();
                                    }
                                }
                            }
                        }
                    }
                }
            }
            if (tVar == null) {
                tVar = new C7277t(str5, str2, str3, str4);
            }
            tVar.setDownloadType(C7131e.f23698E.f23729ae);
            return tVar;
        }
    }

    /* renamed from: a */
    public synchronized boolean mo34962a(Runnable runnable) {
        if (this.f24611c != null) {
            if (!this.f24611c.isShutdown()) {
                if (runnable == null) {
                    C7226an.m31148d("async task = null", new Object[0]);
                    return false;
                }
                C7226an.m31148d("task start %s", runnable.getClass().getName());
                this.f24611c.execute(runnable);
                return true;
            }
        }
        C7226an.m31148d("async handler was closed , should not post task!", new Object[0]);
        return false;
    }
}
