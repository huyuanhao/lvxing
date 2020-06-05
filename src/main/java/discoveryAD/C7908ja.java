package discoveryAD;

import android.os.Bundle;
import org.apache.http.HttpHost;
import org.apache.http.client.HttpClient;
import org.apache.http.client.params.HttpClientParams;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;

/* renamed from: discoveryAD.ja */
public class C7908ja {
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
    protected C7909a mNetworkListener = null;
    private String mProxyHost = null;
    private int mProxyPort = 0;
    private boolean mUseProxy = false;
    /* renamed from: me */
    protected HttpParams f26907me = null;

    /* renamed from: discoveryAD.ja$a */
    public interface C7909a {
        void onNetworkEvent(Bundle bundle);

        void onProgressChanged(Bundle bundle);
    }

    /* renamed from: a */
    public void mo38218a(C7909a aVar) {
        this.mNetworkListener = aVar;
    }

    /* access modifiers changed from: protected */
    public void doCallback(int i, Bundle bundle) {
        C7909a aVar = this.mNetworkListener;
        if (aVar == null) {
            return;
        }
        if (i == 1) {
            aVar.onNetworkEvent(bundle);
        } else if (i == 2) {
            aVar.onProgressChanged(bundle);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: ib */
    public HttpClient mo38220ib() {
        if (this.f26907me == null) {
            this.f26907me = new BasicHttpParams();
        }
        HttpConnectionParams.setConnectionTimeout(this.f26907me, 10000);
        HttpConnectionParams.setSoTimeout(this.f26907me, 20000);
        HttpConnectionParams.setSocketBufferSize(this.f26907me, 4096);
        HttpClientParams.setRedirecting(this.f26907me, true);
        DefaultHttpClient defaultHttpClient = new DefaultHttpClient(this.f26907me);
        if (this.mUseProxy) {
            defaultHttpClient.getParams().setParameter("http.route.default-proxy", new HttpHost(this.mProxyHost, this.mProxyPort));
        }
        return defaultHttpClient;
    }

    public void setProxy(String str, int i) {
        this.mProxyHost = str;
        this.mProxyPort = i;
    }

    public void setUseProxy(boolean z) {
        this.mUseProxy = z;
    }
}
