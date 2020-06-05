package discoveryAD;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;
import com.tencent.p605ep.commonbase.api.Log;
import com.tencent.qqpim.discovery.DiscoverySdk;

/* renamed from: discoveryAD.la */
public class C7914la {
    private static final String TAG = "NetworkUtil";

    /* renamed from: i */
    public static ConnectivityManager m34328i(Context context) {
        try {
            return (ConnectivityManager) context.getSystemService("connectivity");
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static boolean isNetworkAvaliable() {
        try {
            ConnectivityManager i = m34328i(DiscoverySdk.getInstance().getApplicationContext());
            if (i != null) {
                NetworkInfo[] allNetworkInfo = i.getAllNetworkInfo();
                if (allNetworkInfo != null) {
                    for (NetworkInfo state : allNetworkInfo) {
                        if (state.getState() == State.CONNECTED) {
                            return true;
                        }
                    }
                }
            }
        } catch (Throwable th) {
            Log.m31479e(TAG, th.getMessage());
        }
        return false;
    }

    public static boolean isWifiActive() {
        NetworkInfo networkInfo;
        try {
            networkInfo = m34328i(DiscoverySdk.getInstance().getApplicationContext()).getActiveNetworkInfo();
        } catch (Exception e) {
            StringBuilder sb = new StringBuilder();
            sb.append(" getActiveNetworkInfo --- \n");
            sb.append(e.getMessage());
            Log.m31487w("getActiveNetworkInfo", sb.toString());
            networkInfo = null;
        }
        return networkInfo != null && networkInfo.getType() == 1;
    }
}
