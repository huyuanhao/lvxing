package com.tencent.android.tpush;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ProviderInfo;
import android.net.Uri;
import android.os.Build;
import com.tencent.android.tpush.common.Constants;
import com.tencent.android.tpush.data.RegisterEntity;
import com.tencent.android.tpush.encrypt.Rijndael;
import com.tencent.android.tpush.p579a.C6862b;
import com.tencent.android.tpush.p580b.C6864a;
import com.tencent.android.tpush.service.cache.CacheManager;
import com.tencent.android.tpush.service.p595e.C7056i;
import com.tencent.android.tpush.stat.p596a.C7066c;
import com.tencent.android.tpush.stat.p597b.C7074c;
import com.tencent.mid.sotrage.StorageInterface;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantLock;
import org.json.JSONObject;

/* compiled from: ProGuard */
/* renamed from: com.tencent.android.tpush.a */
public class C6860a {
    /* renamed from: a */
    private static ReentrantLock f22823a = new ReentrantLock();
    /* renamed from: b */
    private static Map<String, String> f22824b = new HashMap();

    /* renamed from: a */
    public static synchronized Map<String, ProviderInfo> m29253a(Context context) {
        HashMap hashMap;
        synchronized (C6860a.class) {
            hashMap = new HashMap();
            try {
                for (ProviderInfo providerInfo : context.getPackageManager().queryContentProviders(null, 0, 0)) {
                    if (providerInfo.name.equals(XGPushProvider.class.getName()) && providerInfo.authority.equals(m29252a(providerInfo.packageName))) {
                        hashMap.put(providerInfo.packageName, providerInfo);
                        String str = Constants.LogTag;
                        StringBuilder sb = new StringBuilder();
                        sb.append(providerInfo.authority);
                        sb.append(StorageInterface.KEY_SPLITER);
                        sb.append(providerInfo.packageName);
                        sb.append(StorageInterface.KEY_SPLITER);
                        sb.append(providerInfo.name);
                        C6864a.m29298c(str, sb.toString());
                    }
                }
            } catch (Throwable th) {
                C6864a.m29302d("ProviderUtil", "Package manager has died", th);
            }
        }
        return hashMap;
    }

    /* renamed from: a */
    public static String m29252a(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(XGPushProvider.AUTH_PRIX);
        return sb.toString();
    }

    /* renamed from: a */
    public static boolean m29255a(Context context, String str, String str2) {
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put(SettingsContentProvider.KEY, str2);
            StringBuilder sb = new StringBuilder();
            sb.append("content://");
            sb.append(str);
            sb.append(XGPushProvider.AUTH_PRIX);
            sb.append("/");
            sb.append(TypeStr.msg.getStr());
            C6862b.m29274a(context, Uri.parse(sb.toString()), contentValues);
            return true;
        } catch (Throwable th) {
            C6864a.m29302d("ProviderUtil", "sendMsgByPkgName", th);
            return false;
        }
    }

    /* renamed from: b */
    public static void m29258b(Context context, String str, String str2) {
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("mid", str2);
            StringBuilder sb = new StringBuilder();
            sb.append("content://");
            sb.append(str);
            sb.append(XGPushProvider.AUTH_PRIX);
            sb.append("/");
            sb.append(TypeStr.insert_mid_new.getStr());
            C6862b.m29274a(context, Uri.parse(sb.toString()), contentValues);
        } catch (Throwable th) {
            C6864a.m29302d("ProviderUtil", "", th);
        }
    }

    /* renamed from: c */
    public static void m29260c(Context context, String str, String str2) {
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("mid", str2);
            StringBuilder sb = new StringBuilder();
            sb.append("content://");
            sb.append(str);
            sb.append(XGPushProvider.AUTH_PRIX);
            sb.append("/");
            sb.append(TypeStr.insert_mid_old.getStr());
            C6862b.m29274a(context, Uri.parse(sb.toString()), contentValues);
        } catch (Throwable th) {
            C6864a.m29302d("ProviderUtil", "", th);
        }
    }

    /* renamed from: a */
    public static boolean m29254a(Context context, String str, Intent intent) {
        return m29255a(context, str, intent.toURI());
    }

    /* renamed from: d */
    public static void m29262d(Context context, String str, String str2) {
        StringBuilder sb = new StringBuilder();
        sb.append("content://");
        sb.append(str);
        sb.append(XGPushProvider.AUTH_PRIX);
        sb.append("/");
        sb.append(TypeStr.feedback.getStr());
        Uri parse = Uri.parse(sb.toString());
        ContentValues contentValues = new ContentValues();
        contentValues.put("feedback", Rijndael.encrypt(str2));
        try {
            C6862b.m29272a(context, parse, contentValues, null, null);
        } catch (Throwable th) {
            C6864a.m29302d("SettingsContentProvider", "error : ", th);
        }
    }

    /* renamed from: b */
    public static void m29257b(Context context) {
        Map a = m29253a(context);
        if (a != null && a.size() != 0) {
            boolean contains = Build.MODEL.contains(Constants.VIVO_STR);
            String str = "cnt";
            String str2 = " ";
            String str3 = "heartbeat ";
            String str4 = "/";
            String str5 = XGPushProvider.AUTH_PRIX;
            String str6 = "content://";
            String str7 = "heartbeat to ";
            String str8 = "";
            String str9 = "ProviderUtil";
            String str10 = Constants.LogTag;
            if (contains) {
                try {
                    f22823a.lock();
                    for (String str11 : a.keySet()) {
                        if (C7056i.m30199c(context, str11) && !str11.equals(context.getPackageName())) {
                            StringBuilder sb = new StringBuilder();
                            sb.append(str7);
                            sb.append(str11);
                            C6864a.m29303e(str10, sb.toString());
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append(str6);
                            sb2.append(str11);
                            sb2.append(str5);
                            sb2.append(str4);
                            sb2.append(TypeStr.hearbeat.getStr());
                            String decrypt = Rijndael.decrypt(C6862b.m29275a(context, Uri.parse(sb2.toString())));
                            StringBuilder sb3 = new StringBuilder();
                            sb3.append(str3);
                            sb3.append(str11);
                            sb3.append(str2);
                            sb3.append(decrypt);
                            C6864a.m29303e(str10, sb3.toString());
                            if (C7066c.m30262b(decrypt)) {
                                new JSONObject(decrypt).optInt(str, 0);
                                f22824b.put(str11, decrypt);
                            }
                        }
                    }
                } catch (Throwable th) {
                    try {
                        f22823a.unlock();
                    } catch (Throwable unused) {
                    }
                    throw th;
                }
                try {
                    f22823a.unlock();
                } catch (Throwable unused2) {
                }
            } else {
                for (String str12 : a.keySet()) {
                    try {
                        if (C7056i.m30199c(context, str12) && !str12.equals(context.getPackageName())) {
                            StringBuilder sb4 = new StringBuilder();
                            sb4.append(str7);
                            sb4.append(str12);
                            C6864a.m29303e(str10, sb4.toString());
                            StringBuilder sb5 = new StringBuilder();
                            sb5.append(str6);
                            sb5.append(str12);
                            sb5.append(str5);
                            sb5.append(str4);
                            sb5.append(TypeStr.hearbeat.getStr());
                            String decrypt2 = Rijndael.decrypt(C6862b.m29275a(context, Uri.parse(sb5.toString())));
                            StringBuilder sb6 = new StringBuilder();
                            sb6.append(str3);
                            sb6.append(str12);
                            sb6.append(str2);
                            sb6.append(decrypt2);
                            C6864a.m29303e(str10, sb6.toString());
                            if (C7066c.m30262b(decrypt2)) {
                                new JSONObject(decrypt2).optInt(str, 0);
                                f22824b.put(str12, decrypt2);
                            }
                        }
                    } catch (Throwable th2) {
                        C6864a.m29302d(str9, str8, th2);
                    }
                }
            }
        }
    }

    /* renamed from: a */
    public static String m29251a(Context context, String str) {
        boolean contains = Build.MODEL.contains(Constants.VIVO_STR);
        String str2 = ", token:";
        String str3 = "get token from pkg:";
        String str4 = Constants.LogTag;
        String str5 = "/";
        String str6 = XGPushProvider.AUTH_PRIX;
        String str7 = "content://";
        String str8 = "";
        String str9 = "ProviderUtil";
        if (contains) {
            try {
                f22823a.lock();
                StringBuilder sb = new StringBuilder();
                sb.append(str7);
                sb.append(str);
                sb.append(str6);
                sb.append(str5);
                sb.append(TypeStr.token.getStr());
                String decrypt = Rijndael.decrypt(C6862b.m29275a(context, Uri.parse(sb.toString())));
                StringBuilder sb2 = new StringBuilder();
                sb2.append(str3);
                sb2.append(str);
                sb2.append(str2);
                sb2.append(decrypt);
                C6864a.m29303e(str4, sb2.toString());
                if (decrypt != null && decrypt.trim().length() == 40) {
                    try {
                        f22823a.unlock();
                    } catch (Throwable unused) {
                    }
                    return decrypt;
                }
            } catch (Throwable th) {
                try {
                    f22823a.unlock();
                } catch (Throwable unused2) {
                }
                throw th;
            }
            try {
                f22823a.unlock();
            } catch (Throwable unused3) {
            }
        } else {
            try {
                StringBuilder sb3 = new StringBuilder();
                sb3.append(str7);
                sb3.append(str);
                sb3.append(str6);
                sb3.append(str5);
                sb3.append(TypeStr.token.getStr());
                String decrypt2 = Rijndael.decrypt(C6862b.m29275a(context, Uri.parse(sb3.toString())));
                StringBuilder sb4 = new StringBuilder();
                sb4.append(str3);
                sb4.append(str);
                sb4.append(str2);
                sb4.append(decrypt2);
                C6864a.m29303e(str4, sb4.toString());
                if (decrypt2 != null && decrypt2.trim().length() == 40) {
                    return decrypt2;
                }
            } catch (Throwable th2) {
                C6864a.m29302d(str9, str8, th2);
            }
        }
        return null;
    }

    /* renamed from: c */
    public static Map<String, Integer> m29259c(Context context) {
        Map a = m29253a(context);
        HashMap hashMap = new HashMap();
        if (!(a == null || a.size() == 0)) {
            for (String a2 : a.keySet()) {
                String a3 = m29251a(context, a2);
                if (C7074c.m30319a(a3)) {
                    Integer num = (Integer) hashMap.get(a3);
                    if (num == null) {
                        hashMap.put(a3, Integer.valueOf(1));
                    } else {
                        hashMap.put(a3, Integer.valueOf(num.intValue() + 1));
                    }
                }
            }
        }
        return hashMap;
    }

    /* renamed from: d */
    public static String m29261d(Context context) {
        String str;
        Map c = m29259c(context);
        String str2 = null;
        if (c != null && c.size() > 0) {
            int i = 0;
            for (Entry entry : c.entrySet()) {
                if (((Integer) entry.getValue()).intValue() > i) {
                    i = ((Integer) entry.getValue()).intValue();
                    str2 = (String) entry.getKey();
                }
            }
        }
        return str;
    }

    /* renamed from: b */
    public static RegisterEntity m29256b(Context context, String str) {
        boolean contains = Build.MODEL.contains(Constants.VIVO_STR);
        String str2 = "/";
        String str3 = XGPushProvider.AUTH_PRIX;
        String str4 = "content://";
        String str5 = "getRegisterInfo";
        String str6 = "ProviderUtil";
        if (contains) {
            try {
                StringBuilder sb = new StringBuilder();
                sb.append(str4);
                sb.append(str);
                sb.append(str3);
                sb.append(str2);
                sb.append(TypeStr.register.getStr());
                String decrypt = Rijndael.decrypt(C6862b.m29275a(context, Uri.parse(sb.toString())));
                if (decrypt != null) {
                    RegisterEntity decode = RegisterEntity.decode(decrypt);
                    try {
                        f22823a.unlock();
                    } catch (Throwable unused) {
                    }
                    return decode;
                }
            } catch (Throwable th) {
                try {
                    f22823a.unlock();
                } catch (Throwable unused2) {
                }
                throw th;
            }
            try {
                f22823a.unlock();
            } catch (Throwable unused3) {
            }
        } else {
            try {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(str4);
                sb2.append(str);
                sb2.append(str3);
                sb2.append(str2);
                sb2.append(TypeStr.register.getStr());
                String decrypt2 = Rijndael.decrypt(C6862b.m29275a(context, Uri.parse(sb2.toString())));
                if (decrypt2 != null) {
                    return RegisterEntity.decode(decrypt2);
                }
            } catch (Throwable th2) {
                C6864a.m29302d(str6, str5, th2);
            }
        }
        return null;
    }

    /* renamed from: e */
    public static Map<Long, RegisterEntity> m29263e(Context context) {
        RegisterEntity registerEntity;
        Map a = m29253a(context);
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        if (!(a == null || a.size() == 0)) {
            for (String str : a.keySet()) {
                if (str == null || !str.equals(context.getPackageName())) {
                    registerEntity = m29256b(context, str);
                } else {
                    registerEntity = CacheManager.getCurrentAppRegisterEntity(context);
                }
                if (registerEntity != null && registerEntity.accessId > 0) {
                    concurrentHashMap.put(Long.valueOf(registerEntity.accessId), registerEntity);
                }
            }
        }
        return concurrentHashMap;
    }
}
