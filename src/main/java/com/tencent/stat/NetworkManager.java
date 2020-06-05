package com.tencent.stat;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.stat.common.StatCommonHelper;
import com.tencent.stat.common.StatLogger;
import com.tencent.stat.common.Util;
import org.apache.http.HttpHost;

public class NetworkManager {
    public static final int TYPE_NOT_WIFI = 2;
    public static final int TYPE_NO_NETWORK = 0;
    public static final int TYPE_WIFI = 1;
    /* renamed from: f */
    private static NetworkManager f25293f;
    /* renamed from: a */
    private volatile int f25294a = 2;
    /* renamed from: b */
    private volatile String f25295b = "";
    /* renamed from: c */
    private volatile HttpHost f25296c = null;
    /* access modifiers changed from: private */
    /* renamed from: d */
    public Handler f25297d = null;
    /* renamed from: e */
    private int f25298e = 0;
    /* renamed from: g */
    private Context f25299g = null;
    /* renamed from: h */
    private StatLogger f25300h = null;

    public void onDispatchFailed() {
    }

    public HttpHost getHttpProxy() {
        return this.f25296c;
    }

    public String getCurNetwrokName() {
        return this.f25295b;
    }

    public int getNetworkType() {
        return this.f25294a;
    }

    private NetworkManager(Context context) {
        if (context == null) {
            this.f25299g = StatServiceImpl.getContext(null);
        } else if (context.getApplicationContext() != null) {
            this.f25299g = context.getApplicationContext();
        } else {
            this.f25299g = context;
        }
        HandlerThread handlerThread = new HandlerThread("nt");
        handlerThread.start();
        this.f25297d = new Handler(handlerThread.getLooper());
        C7608d.m32795a(context);
        this.f25300h = StatCommonHelper.getLogger();
        m32582b();
        mo36901a();
    }

    public boolean isWifi() {
        return this.f25294a == 1;
    }

    public boolean isNetworkAvailable() {
        return this.f25294a != 0;
    }

    public static NetworkManager getInstance(Context context) {
        if (f25293f == null) {
            synchronized (NetworkManager.class) {
                if (f25293f == null) {
                    f25293f = new NetworkManager(context);
                }
            }
        }
        return f25293f;
    }

    /* renamed from: b */
    private void m32582b() {
        this.f25294a = 0;
        this.f25296c = null;
        this.f25295b = null;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo36901a() {
        if (Util.isNetworkAvailable(this.f25299g)) {
            this.f25295b = StatCommonHelper.getLinkedWay(this.f25299g);
            if (StatConfig.isDebugEnable()) {
                StatLogger statLogger = this.f25300h;
                StringBuilder sb = new StringBuilder();
                sb.append("NETWORK name:");
                sb.append(this.f25295b);
                statLogger.mo37108i(sb.toString());
            }
            if (StatCommonHelper.isStringValid(this.f25295b)) {
                if ("WIFI".equalsIgnoreCase(this.f25295b)) {
                    this.f25294a = 1;
                } else {
                    this.f25294a = 2;
                }
                this.f25296c = StatCommonHelper.getHttpProxy(this.f25299g);
            }
            if (StatServiceImpl.m32632a()) {
                StatServiceImpl.m32654d(this.f25299g);
                return;
            }
            return;
        }
        if (StatConfig.isDebugEnable()) {
            this.f25300h.mo37108i("NETWORK TYPE: network is close.");
        }
        m32582b();
    }

    public void registerBroadcast() {
        try {
            this.f25299g.registerReceiver(new BroadcastReceiver() {
                public void onReceive(Context context, Intent intent) {
                    if (NetworkManager.this.f25297d != null) {
                        NetworkManager.this.f25297d.post(new Runnable() {
                            public void run() {
                                NetworkManager.this.mo36901a();
                            }
                        });
                    }
                }
            }, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
