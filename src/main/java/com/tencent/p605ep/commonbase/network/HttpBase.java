package com.tencent.p605ep.commonbase.network;

import android.os.Bundle;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.Proxy.Type;
import java.net.URL;

/* renamed from: com.tencent.ep.commonbase.network.HttpBase */
public class HttpBase {
    protected static final int CALL_TYPE_ERROR = 1;
    protected static final int CALL_TYPE_PROGRESS = 2;
    protected static final int CONNECTION_TIMEOUT = 10000;
    public static final String KEY_COMPLETED = "key_completed";
    public static final String KEY_DOWNSIZE = "key_downSize";
    public static final String KEY_DOWNTYPE = "key_downType";
    public static final String KEY_ERRCODE = "key_errcode";
    public static final String KEY_ERRORMSG = "key_errorMsg";
    public static final String KEY_PROGRESS = "key_progress";
    public static final String KEY_SDCARDSTATUS = "key_sdcardstatus";
    public static final String KEY_SUCCESS = "key_success";
    public static final String KEY_TOTAL = "key_total";
    protected static final int SOCKET_BUFFER_SIZE = 4096;
    protected static final int SO_TIMEOUT = 20000;
    protected static final String TAG = "HttpBase";
    protected NetworkListener mNetworkListener = null;
    private String mProxyHost = null;
    private int mProxyPort = 0;
    private boolean mUseProxy = false;

    /* renamed from: com.tencent.ep.commonbase.network.HttpBase$NetworkListener */
    public interface NetworkListener {
        void onNetworkEvent(Bundle bundle);

        void onProgressChanged(Bundle bundle);
    }

    /* access modifiers changed from: protected */
    public void doCallback(int i, Bundle bundle) {
        NetworkListener networkListener = this.mNetworkListener;
        if (networkListener == null) {
            return;
        }
        if (i == 1) {
            networkListener.onNetworkEvent(bundle);
        } else if (i == 2) {
            networkListener.onProgressChanged(bundle);
        }
    }

    /* access modifiers changed from: protected */
    public HttpURLConnection getCon(String str) {
        try {
            URL url = new URL(str);
            HttpURLConnection httpURLConnection = (HttpURLConnection) (this.mUseProxy ? url.openConnection(new Proxy(Type.HTTP, new InetSocketAddress(this.mProxyHost, this.mProxyPort))) : url.openConnection());
            httpURLConnection.setConnectTimeout(10000);
            httpURLConnection.setReadTimeout(20000);
            return httpURLConnection;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public void setNetworkListener(NetworkListener networkListener) {
        this.mNetworkListener = networkListener;
    }

    public void setProxy(String str, int i) {
        this.mProxyHost = str;
        this.mProxyPort = i;
    }

    public void setUseProxy(boolean z) {
        this.mUseProxy = z;
    }
}
