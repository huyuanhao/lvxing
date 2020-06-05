package com.bytedance.sdk.openadsdk.utils;

import android.content.Context;
import android.content.pm.Signature;
import com.tencent.bigdata.dataacquisition.DeviceInfos;
import com.tencent.mid.sotrage.StorageInterface;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.HashMap;

/* renamed from: com.bytedance.sdk.openadsdk.utils.e */
public class AppSigning {
    /* renamed from: a */
    private static HashMap<String, ArrayList<String>> f9160a = new HashMap<>();

    /* renamed from: a */
    public static ArrayList<String> m12132a(Context context, String str) {
        Signature[] b;
        String str2 = "SHA256";
        String str3 = "SHA1";
        String str4 = "MD5";
        ArrayList<String> arrayList = null;
        if (!(context == null || str == null)) {
            String packageName = context.getPackageName();
            if (packageName == null) {
                return null;
            }
            if (f9160a.get(str) != null) {
                return (ArrayList) f9160a.get(str);
            }
            arrayList = new ArrayList<>();
            try {
                for (Signature signature : m12133b(context, packageName)) {
                    String str5 = "error!";
                    if (str4.equals(str)) {
                        str5 = m12131a(signature, str4);
                    } else if (str3.equals(str)) {
                        str5 = m12131a(signature, str3);
                    } else if (str2.equals(str)) {
                        str5 = m12131a(signature, str2);
                    }
                    arrayList.add(str5);
                }
            } catch (Exception e) {
                C2564t.m12219b(e.toString());
            }
            f9160a.put(str, arrayList);
        }
        return arrayList;
    }

    /* renamed from: a */
    public static String m12130a(Context context) {
        StringBuilder sb = new StringBuilder();
        ArrayList a = m12132a(context, "SHA1");
        if (!(a == null || a.size() == 0)) {
            for (int i = 0; i < a.size(); i++) {
                sb.append((String) a.get(i));
                if (i < a.size() - 1) {
                    sb.append(StorageInterface.KEY_SPLITER);
                }
            }
        }
        return sb.toString();
    }

    /* renamed from: b */
    private static Signature[] m12133b(Context context, String str) {
        try {
            return context.getPackageManager().getPackageInfo(str, 64).signatures;
        } catch (Exception e) {
            C2564t.m12219b(e.toString());
            return null;
        }
    }

    /* renamed from: a */
    private static String m12131a(Signature signature, String str) {
        byte[] byteArray = signature.toByteArray();
        String str2 = "error!";
        try {
            MessageDigest instance = MessageDigest.getInstance(str);
            if (instance == null) {
                return str2;
            }
            byte[] digest = instance.digest(byteArray);
            StringBuilder sb = new StringBuilder();
            for (byte b : digest) {
                sb.append(Integer.toHexString((b & DeviceInfos.NETWORK_TYPE_UNCONNECTED) | 0).substring(1, 3).toUpperCase());
                sb.append(":");
            }
            return sb.substring(0, sb.length() - 1).toString();
        } catch (Exception e) {
            C2564t.m12219b(e.toString());
            return str2;
        }
    }
}
