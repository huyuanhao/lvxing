package com.tencent.mid.util;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.pm.ProviderInfo;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Proxy;
import android.net.Uri;
import android.os.Build.VERSION;
import android.util.Base64;
import android.util.Log;
import com.tencent.bigdata.dataacquisition.CustomDeviceInfos;
import com.tencent.mid.api.MidConstants;
import com.tencent.mid.api.MidEntity;
import com.tencent.mid.api.MidProvider;
import com.tencent.mid.core.Constants;
import com.tencent.mid.sotrage.StorageInterface;
import com.tencent.mid.sotrage.UnifiedStorage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.zip.GZIPInputStream;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import org.apache.http.HttpHost;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Util {
    private static final String AUTHORTY_POSTFIX = ".AUTH_XGPUSH";
    private static final String GET_TOKEN_CMD = "tokenByMid";
    public static int errorCount;
    public static long lastGetOtherMidMapTime;
    public static Map<String, MidEntity> lastOtherMidMap;
    private static Logger logger;
    private static Random random;

    /* renamed from: com.tencent.mid.util.Util$MidResolver */
    static class MidResolver implements Runnable {
        private Map<String, MidEntity> appPrivateMidMap;
        private Context context;
        private int providerCmd;

        public MidResolver(Context context2, int i) {
            this.providerCmd = i;
            this.context = context2;
        }

        public void run() {
            try {
                set(Util.getMidsByAppsByThread(this.context, this.providerCmd));
            } catch (Exception unused) {
            }
        }

        public synchronized void set(Map<String, MidEntity> map) {
            this.appPrivateMidMap = map;
        }

        public synchronized Map<String, MidEntity> get() {
            return this.appPrivateMidMap;
        }
    }

    public static synchronized Logger getLogger() {
        Logger logger2;
        synchronized (Util.class) {
            if (logger == null) {
                logger = new Logger(Constants.LOG_TAG);
            }
            logger2 = logger;
        }
        return logger2;
    }

    public static boolean isStringValid(String str) {
        return (str == null || str.trim().length() == 0) ? false : true;
    }

    public static boolean isMidValid(MidEntity midEntity) {
        return midEntity != null && isMidValid(midEntity.getMid());
    }

    public static boolean isMidValid(String str) {
        return str != null && str.trim().length() >= 40;
    }

    public static MidEntity getNewerMidEntity(MidEntity midEntity, MidEntity midEntity2) {
        if (midEntity != null && midEntity2 != null) {
            if (midEntity.compairTo(midEntity2) < 0) {
                midEntity = midEntity2;
            }
            return midEntity;
        } else if (midEntity != null) {
            return midEntity;
        } else {
            if (midEntity2 != null) {
                return midEntity2;
            }
            return null;
        }
    }

    public static boolean equal(MidEntity midEntity, MidEntity midEntity2) {
        boolean z = true;
        if (midEntity == null || midEntity2 == null) {
            return midEntity == null && midEntity2 == null;
        }
        if (midEntity.compairTo(midEntity2) != 0) {
            z = false;
        }
        return z;
    }

    public static boolean checkPermission(Context context, String str) {
        try {
            if (context.getPackageManager().checkPermission(str, context.getPackageName()) == 0) {
                return true;
            }
            return false;
        } catch (Throwable th) {
            Log.e(Constants.LOG_TAG, "checkPermission error", th);
            return false;
        }
    }

    public static boolean isNetworkAvailable(Context context) {
        String str = Constants.LOG_TAG;
        try {
            if (!checkPermission(context, Constants.PERMISSION_INTERNET)) {
                return false;
            }
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager != null) {
                NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                if (activeNetworkInfo != null) {
                    if (activeNetworkInfo.isConnectedOrConnecting()) {
                        return true;
                    }
                    Log.w(str, "Network error is not exist");
                    return false;
                }
            }
            errorCount++;
            int i = errorCount;
            if (i <= 5) {
                return true;
            }
            if (i >= 10 && i >= 10) {
                errorCount = 0;
            }
            return false;
        } catch (Throwable th) {
            Log.e(str, "isNetworkAvailable error", th);
        }
    }

    public static String md5sum(String str) {
        return md5(str);
    }

    public static String md5(String str) {
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            instance.update(str.getBytes("UTF-8"));
            byte[] digest = instance.digest();
            StringBuffer stringBuffer = new StringBuffer();
            for (byte append : digest) {
                stringBuffer.append(append);
            }
            return stringBuffer.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return str;
        } catch (UnsupportedEncodingException e2) {
            e2.printStackTrace();
            return str;
        }
    }

    public static void jsonPut(JSONObject jSONObject, String str, String str2) throws JSONException {
        if (isStringValid(str2)) {
            jSONObject.put(str, str2);
        }
    }

    public static String decode(String str) {
        String str2 = "UTF-8";
        String str3 = "";
        if (str == null) {
            return null;
        }
        if (VERSION.SDK_INT < 8) {
            return str;
        }
        try {
            str = new String(RC4.decrypt(Base64.decode(str.getBytes(str2), 0)), str2).trim().replace("\t", str3).replace("\n", str3).replace("\r", str3);
            return str;
        } catch (Throwable th) {
            Log.e(Constants.LOG_TAG, "decode error", th);
            return str;
        }
    }

    public static String encode(String str) {
        String str2 = "UTF-8";
        String str3 = "";
        if (str == null) {
            return null;
        }
        if (VERSION.SDK_INT < 8) {
            return str;
        }
        try {
            str = new String(Base64.encode(RC4.encrypt(str.getBytes(str2)), 0), str2).trim().replace("\t", str3).replace("\n", str3).replace("\r", str3);
            return str;
        } catch (Throwable th) {
            Log.e(Constants.LOG_TAG, "encode error", th);
            return str;
        }
    }

    public static HttpHost getHttpProxy() {
        if (Proxy.getDefaultHost() != null) {
            return new HttpHost(Proxy.getDefaultHost(), Proxy.getDefaultPort());
        }
        return null;
    }

    public static HttpHost getHttpProxy(Context context) {
        if (context == null) {
            return null;
        }
        try {
            if (context.getPackageManager().checkPermission(Constants.PERMISSION_ACCESS_NETWORK_STATE, context.getPackageName()) != 0) {
                return null;
            }
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo == null) {
                return null;
            }
            if (activeNetworkInfo.getTypeName() != null && activeNetworkInfo.getTypeName().equalsIgnoreCase("WIFI")) {
                return null;
            }
            String extraInfo = activeNetworkInfo.getExtraInfo();
            if (extraInfo == null) {
                return null;
            }
            if (!extraInfo.equals("cmwap") && !extraInfo.equals("3gwap")) {
                if (!extraInfo.equals("uniwap")) {
                    if (extraInfo.equals("ctwap")) {
                        return new HttpHost("10.0.0.200", 80);
                    }
                    return null;
                }
            }
            return new HttpHost("10.0.0.172", 80);
        } catch (Throwable th) {
            logger.mo35696e(th);
        }
    }

    public static byte[] deocdeGZipContent(byte[] bArr) throws IOException {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        GZIPInputStream gZIPInputStream = new GZIPInputStream(byteArrayInputStream);
        byte[] bArr2 = new byte[4096];
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(bArr.length * 2);
        while (true) {
            int read = gZIPInputStream.read(bArr2);
            if (read != -1) {
                byteArrayOutputStream.write(bArr2, 0, read);
            } else {
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                byteArrayInputStream.close();
                gZIPInputStream.close();
                byteArrayOutputStream.close();
                return byteArray;
            }
        }
    }

    public static String getHttpAddr(Context context) {
        StringBuilder sb = new StringBuilder();
        sb.append("http://");
        sb.append(ConstantUtil.getInstance(context).getHttpService());
        return sb.toString();
    }

    public static byte[] getHMAC(String str, String str2) {
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(str.getBytes(), "hmacmd5");
            Mac instance = Mac.getInstance("HmacSHA1");
            instance.init(secretKeySpec);
            instance.update(str2.getBytes());
            return instance.doFinal();
        } catch (Exception e) {
            logger.mo35695e(e);
            return null;
        }
    }

    private static synchronized Random getRandom() {
        Random random2;
        synchronized (Util.class) {
            if (random == null) {
                random = new Random();
            }
            random2 = random;
        }
        return random2;
    }

    public static int getRandInt() {
        return getRandom().nextInt(ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
    }

    public static String bytesToStr(byte[] bArr) {
        StringBuffer stringBuffer = new StringBuffer();
        for (byte append : bArr) {
            StringBuilder sb = new StringBuilder();
            sb.append(append);
            sb.append("");
            stringBuffer.append(sb.toString());
        }
        return stringBuffer.toString();
    }

    public static byte[] strToBytes(String str) {
        byte[] bArr = new byte[str.length()];
        for (int i = 0; i < str.length(); i++) {
            bArr[i] = (byte) str.charAt(i);
        }
        return bArr;
    }

    public static boolean isEmpty(String str) {
        return str == null || str.trim().length() == 0;
    }

    public static JSONArray queryMids(Context context, int i) {
        MidEntity midEntity;
        MidEntity midEntity2;
        Logger logger2 = logger;
        StringBuilder sb = new StringBuilder();
        sb.append("queryMids, midType=");
        sb.append(i);
        logger2.mo35693d(sb.toString());
        JSONArray jSONArray = new JSONArray();
        Map midsByApps = getMidsByApps(context, i == 2 ? 3 : 2);
        String str = "loc";
        if (midsByApps != null && midsByApps.size() > 0) {
            for (Entry entry : midsByApps.entrySet()) {
                String str2 = (String) entry.getKey();
                MidEntity midEntity3 = (MidEntity) entry.getValue();
                if (midEntity3 != null && midEntity3.isMidValid()) {
                    try {
                        JSONObject convert2MidEntityJSON = convert2MidEntityJSON(midEntity3);
                        convert2MidEntityJSON.put(str, "priv");
                        if (str2.equals(context.getPackageName())) {
                            convert2MidEntityJSON.put("app", 1);
                        }
                        convert2MidEntityJSON.put("pkg", str2);
                        jSONArray.put(convert2MidEntityJSON);
                    } catch (Exception unused) {
                    }
                }
            }
        }
        if (i == 2) {
            midEntity = UnifiedStorage.getInstance(context).readSettingNewVersionMidEntity();
        } else {
            midEntity = UnifiedStorage.getInstance(context).readSettingMidEntity();
        }
        Logger logger3 = logger;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("settingEntity:");
        sb2.append(midEntity);
        logger3.mo35700i(sb2.toString());
        String str3 = "lc";
        String str4 = "pub";
        if (midEntity != null && midEntity.isMidValid()) {
            try {
                JSONObject convert2MidEntityJSON2 = convert2MidEntityJSON(midEntity);
                convert2MidEntityJSON2.put(str, str4);
                convert2MidEntityJSON2.put(str3, "set");
                jSONArray.put(convert2MidEntityJSON2);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        if (i == 2) {
            midEntity2 = UnifiedStorage.getInstance(context).readSdCarkNewVersionMidEntity();
        } else {
            midEntity2 = UnifiedStorage.getInstance(context).readSdCarkMidEntity();
        }
        Logger logger4 = logger;
        StringBuilder sb3 = new StringBuilder();
        sb3.append("sdCardEntity:");
        sb3.append(midEntity2);
        logger4.mo35700i(sb3.toString());
        if (midEntity2 != null && midEntity2.isMidValid()) {
            try {
                JSONObject convert2MidEntityJSON3 = convert2MidEntityJSON(midEntity2);
                convert2MidEntityJSON3.put(str, str4);
                convert2MidEntityJSON3.put(str3, "sd");
                jSONArray.put(convert2MidEntityJSON3);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        return jSONArray;
    }

    private static JSONObject convert2MidEntityJSON(MidEntity midEntity) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("mid", midEntity.getMid());
        jSONObject.put("ts", midEntity.getTimestamps() / 1000);
        return jSONObject;
    }

    public static String getPackageAuth(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("content://");
        sb.append(getPackageAuthName(str));
        return sb.toString();
    }

    public static String getPackageAuthName(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(MidConstants.PROVIDER_AUTH_SUFFIX);
        return sb.toString();
    }

    public static Map<String, MidEntity> getMidsByApps(Context context, int i) {
        MidResolver midResolver = new MidResolver(context, i);
        Thread thread = new Thread(midResolver);
        thread.start();
        try {
            thread.join(3500);
        } catch (Throwable th) {
            logger.mo35708w(th.toString());
        }
        return midResolver.get();
    }

    /* access modifiers changed from: private|static */
    public static Map<String, MidEntity> getMidsByAppsByThread(Context context, int i) {
        HashMap hashMap = new HashMap(4);
        Map queryMatchContentProviders = queryMatchContentProviders(context);
        StringBuilder sb = new StringBuilder();
        sb.append(">>>   queryMatchContentProviders size:");
        sb.append(queryMatchContentProviders != null ? queryMatchContentProviders.size() : 0);
        String sb2 = sb.toString();
        String str = Constants.LOG_TAG;
        Log.i(str, sb2);
        MidEntity midEntity = null;
        if (i == 2) {
            midEntity = UnifiedStorage.getInstance(context).readPrivateMidEntity();
        } else if (i == 3) {
            midEntity = UnifiedStorage.getInstance(context).readPrivateNewVersionMidEntity();
        }
        if (isMidValid(midEntity)) {
            hashMap.put(context.getPackageName(), midEntity);
        }
        if (!(queryMatchContentProviders == null || queryMatchContentProviders.size() == 0)) {
            Map<String, MidEntity> map = lastOtherMidMap;
            String str2 = ",content:";
            if (map == null || map.isEmpty() || Math.abs(System.currentTimeMillis() - lastGetOtherMidMapTime) >= 1000) {
                for (String str3 : queryMatchContentProviders.keySet()) {
                    try {
                        if (!str3.equals(context.getPackageName())) {
                            StringBuilder sb3 = new StringBuilder();
                            sb3.append(getPackageAuth(str3));
                            sb3.append("/");
                            sb3.append(i);
                            String sb4 = sb3.toString();
                            StringBuilder sb5 = new StringBuilder();
                            sb5.append(">>>   read mid from other providrt cmd:");
                            sb5.append(sb4);
                            Log.d(str, sb5.toString());
                            String type = context.getContentResolver().getType(Uri.parse(sb4));
                            StringBuilder sb6 = new StringBuilder();
                            sb6.append(">>>   mid cmd:");
                            sb6.append(sb4);
                            sb6.append(", return:");
                            sb6.append(type);
                            Log.d(str, sb6.toString());
                            if (!isEmpty(type)) {
                                MidEntity parse = MidEntity.parse(type);
                                if (parse != null && parse.isMidValid()) {
                                    hashMap.put(str3, parse);
                                }
                            }
                        }
                    } catch (Throwable th) {
                        logger.mo35696e(th);
                    }
                }
                lastOtherMidMap = hashMap;
                lastGetOtherMidMapTime = System.currentTimeMillis();
                StringBuilder sb7 = new StringBuilder();
                sb7.append(">>>   appPrivateMidMap size:");
                sb7.append(hashMap.size());
                sb7.append(str2);
                Log.d(str, sb7.toString());
                for (Entry entry : hashMap.entrySet()) {
                    StringBuilder sb8 = new StringBuilder();
                    sb8.append(">>>   pkg:");
                    sb8.append((String) entry.getKey());
                    sb8.append(",midEntity:");
                    sb8.append(((MidEntity) entry.getValue()).toString());
                    Log.w(str, sb8.toString());
                }
            } else {
                StringBuilder sb9 = new StringBuilder();
                sb9.append(">>> use lastOtherMidMap size:");
                sb9.append(lastOtherMidMap.size());
                sb9.append(str2);
                Log.d(str, sb9.toString());
                return lastOtherMidMap;
            }
        }
        return hashMap;
    }

    public static void insertMid2Provider(Context context, String str, String str2) {
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("mid", str2);
            ContentResolver contentResolver = context.getContentResolver();
            StringBuilder sb = new StringBuilder();
            sb.append(getPackageAuth(str));
            sb.append("/");
            sb.append(10);
            contentResolver.insert(Uri.parse(sb.toString()), contentValues);
        } catch (Throwable unused) {
        }
    }

    public static void insertMid2OldProvider(Context context, String str, String str2) {
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("mid", str2);
            ContentResolver contentResolver = context.getContentResolver();
            StringBuilder sb = new StringBuilder();
            sb.append(getPackageAuth(str));
            sb.append("/");
            sb.append(11);
            contentResolver.insert(Uri.parse(sb.toString()), contentValues);
        } catch (Throwable unused) {
        }
    }

    public static Map<String, ProviderInfo> queryMatchContentProviders(Context context) {
        HashMap hashMap = new HashMap();
        for (ProviderInfo providerInfo : context.getPackageManager().queryContentProviders(null, 0, 0)) {
            if (providerInfo.name.equals(MidProvider.class.getName()) && providerInfo.authority.equals(getPackageAuthName(providerInfo.packageName))) {
                hashMap.put(providerInfo.packageName, providerInfo);
            }
        }
        return hashMap;
    }

    public static void updateIfLocalInvalid(Context context, String str) {
        if (isMidValid(str)) {
            MidEntity midEntity = new MidEntity();
            midEntity.setImei(CustomDeviceInfos.getDeviceId(context));
            midEntity.setMac(CustomDeviceInfos.getMacAddress(context));
            midEntity.setMid(str);
            midEntity.setTimestamps(System.currentTimeMillis());
            UnifiedStorage.getInstance(context).writeMidEntity(midEntity);
        }
    }

    public static String getDateString(int i) {
        try {
            Calendar instance = Calendar.getInstance();
            instance.roll(6, i);
            return new SimpleDateFormat("yyyyMMdd").format(instance.getTime());
        } catch (Throwable unused) {
            return "00";
        }
    }

    public static Map<String, ProviderInfo> getLocalXGAppList(Context context) {
        HashMap hashMap = new HashMap();
        for (ProviderInfo providerInfo : context.getPackageManager().queryContentProviders(null, 0, 0)) {
            if (providerInfo.name.equals("com.tencent.android.tpush.XGPushProvider") && providerInfo.authority.equals(getProviderAuth(providerInfo.packageName))) {
                hashMap.put(providerInfo.packageName, providerInfo);
                StringBuilder sb = new StringBuilder();
                sb.append(providerInfo.authority);
                String str = StorageInterface.KEY_SPLITER;
                sb.append(str);
                sb.append(providerInfo.packageName);
                sb.append(str);
                sb.append(providerInfo.name);
                Log.d("MID.XG", sb.toString());
            }
        }
        return hashMap;
    }

    public static String getProviderAuth(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(".AUTH_XGPUSH");
        return sb.toString();
    }

    public static String getToken(Context context, String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("content://");
        sb.append(str);
        sb.append(".AUTH_XGPUSH");
        sb.append("/");
        sb.append(GET_TOKEN_CMD);
        String type = context.getContentResolver().getType(Uri.parse(sb.toString()));
        if (type != null) {
            try {
                type = new String(Base64.decode(type.getBytes(), 0), "UTF-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("get token from pkg:");
        sb2.append(str);
        sb2.append(", token:");
        sb2.append(type);
        Log.i("MID.XG", sb2.toString());
        if (type == null || type.trim().length() != 40) {
            return null;
        }
        return type;
    }

    public static Map<String, Integer> queryAllToken(Context context) {
        Map localXGAppList = getLocalXGAppList(context);
        HashMap hashMap = new HashMap();
        if (!(localXGAppList == null || localXGAppList.size() == 0)) {
            for (String token : localXGAppList.keySet()) {
                String token2 = getToken(context, token);
                if (isMidValid(token2)) {
                    Integer num = (Integer) hashMap.get(token2);
                    if (num == null) {
                        hashMap.put(token2, Integer.valueOf(1));
                    } else {
                        hashMap.put(token2, Integer.valueOf(num.intValue() + 1));
                    }
                }
            }
        }
        return hashMap;
    }

    public static String selectMaxCountXgAppToken(Context context) {
        String str;
        Map queryAllToken = queryAllToken(context);
        String str2 = null;
        if (queryAllToken != null && queryAllToken.size() > 0) {
            int i = 0;
            for (Entry entry : queryAllToken.entrySet()) {
                if (((Integer) entry.getValue()).intValue() > i) {
                    i = ((Integer) entry.getValue()).intValue();
                    str2 = (String) entry.getKey();
                }
            }
        }
        return str;
    }
}
