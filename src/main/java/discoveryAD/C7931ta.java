package discoveryAD;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.text.TextUtils;
import com.tencent.bigdata.dataacquisition.DeviceInfos;
import com.tencent.qqpim.discovery.DiscoverySdk;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

/* renamed from: discoveryAD.ta */
public class C7931ta {
    /* renamed from: H */
    public static boolean m34344H(String str) {
        PackageInfo packageInfo;
        try {
            packageInfo = DiscoverySdk.getInstance().getApplicationContext().getPackageManager().getPackageInfo(str, 0);
        } catch (Exception e) {
            e.printStackTrace();
            packageInfo = null;
        }
        return packageInfo != null;
    }

    /* renamed from: I */
    public static boolean m34345I(String str) {
        Intent intent = new Intent();
        intent.setAction("android.intent.action.VIEW");
        intent.setData(Uri.parse(str));
        intent.setFlags(268435456);
        try {
            DiscoverySdk.getInstance().getApplicationContext().startActivity(intent);
            return true;
        } catch (ActivityNotFoundException unused) {
            return false;
        }
    }

    public static final String bytesToHexString(byte[] bArr) {
        if (bArr == null || bArr.length <= 0) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer(bArr.length);
        for (byte b : bArr) {
            String hexString = Integer.toHexString(b & DeviceInfos.NETWORK_TYPE_UNCONNECTED);
            if (hexString.length() < 2) {
                stringBuffer.append(0);
            }
            stringBuffer.append(hexString.toUpperCase());
        }
        return stringBuffer.toString();
    }

    /* renamed from: g */
    public static String m34346g(String str, String str2) {
        String[] split = TextUtils.split(str, str2);
        if (split == null || split.length != 2) {
            return null;
        }
        return split[1];
    }

    /* renamed from: g */
    public static boolean m34347g(List<?> list) {
        return list == null || list.isEmpty();
    }

    public static byte[] getMD5(String str) {
        MessageDigest messageDigest;
        if (str == null || "".equals(str)) {
            return null;
        }
        try {
            messageDigest = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            messageDigest = null;
        }
        if (messageDigest != null) {
            try {
                messageDigest.update(str.getBytes("UTF-8"));
            } catch (UnsupportedEncodingException e2) {
                e2.printStackTrace();
            }
        }
        if (messageDigest == null) {
            return null;
        }
        return messageDigest.digest();
    }

    public static boolean isNetworkConnected(Context context) {
        NetworkInfo networkInfo;
        try {
            networkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        } catch (Exception unused) {
            networkInfo = null;
        }
        if (networkInfo == null) {
            C7852Aa.m34156i("isNetworkConnected():false");
            return false;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("isNetworkConnected():");
        sb.append(networkInfo.isConnected());
        C7852Aa.m34156i(sb.toString());
        return networkInfo.isConnected();
    }
}
