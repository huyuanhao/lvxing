package com.tencent.stat.common;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.util.Log;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import org.json.JSONObject;

public class X5Helper {
    /* renamed from: a */
    private static StatLogger f25650a = StatCommonHelper.getLogger();
    /* renamed from: b */
    private static Bundle f25651b = null;
    /* renamed from: c */
    private static String f25652c = null;

    /* renamed from: a */
    private static Class<?> m32743a() {
        try {
            return Class.forName("com.tencent.smtt.sdk.WebView");
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }

    public static String getX5UserAgent() {
        return f25652c;
    }

    public static Bundle getBundle() {
        return f25651b;
    }

    public static String getX5Guid() {
        Bundle bundle = f25651b;
        if (bundle != null) {
            return bundle.getString("guid");
        }
        return null;
    }

    public static String getQua2() {
        Bundle bundle = f25651b;
        if (bundle != null) {
            return bundle.getString("qua2");
        }
        return null;
    }

    public static String getLc() {
        Bundle bundle = f25651b;
        if (bundle != null) {
            return bundle.getString("lc");
        }
        return null;
    }

    public static void encodeX5(Context context, JSONObject jSONObject) {
        try {
            if (f25651b != null) {
                Util.jsonPut(jSONObject, "x5qua2", getQua2());
                Util.jsonPut(jSONObject, "x5ua", getX5UserAgent());
                encodeQGuid(context, jSONObject);
            }
        } catch (Throwable th) {
            f25650a.mo37116w(th);
        }
    }

    public static void encodeQGuid(Context context, JSONObject jSONObject) {
        try {
            if (f25651b != null) {
                Util.jsonPut(jSONObject, "x5guid", getX5Guid());
                Util.jsonPut(jSONObject, "x5lc", getLc());
                jSONObject.put("x5vc", getX5Version(context));
            }
        } catch (Throwable th) {
            f25650a.mo37116w(th);
        }
    }

    public static void initOnUiThread(Context context) {
        m32745a(context);
    }

    /* renamed from: a */
    private static void m32745a(Context context) {
        try {
            if (Looper.myLooper() != Looper.getMainLooper()) {
                f25650a.warn("init X5 sdk failed, should init on UI thread, such as Application.onCreate() or MainActivity.onCreate()");
            } else if (f25651b == null) {
                Class a = m32743a();
                if (a != null) {
                    m32746a(context, a);
                }
            }
        } catch (Throwable th) {
            f25650a.mo37104e(th);
        }
    }

    public static int getX5Version(Context context) {
        try {
            Class cls = Class.forName("com.tencent.smtt.sdk.QbSdk");
            return ((Integer) cls.getDeclaredMethod("getTbsVersion", new Class[]{Context.class}).invoke(cls, new Object[]{context})).intValue();
        } catch (Throwable th) {
            f25650a.mo37116w(th);
            return 0;
        }
    }

    /* renamed from: a */
    private static void m32746a(Context context, Class<?> cls) {
        String str = StatConstants.LOG_TAG;
        try {
            Object newInstance = cls.getConstructor(new Class[]{Context.class}).newInstance(new Object[]{context});
            m32747a(newInstance);
            Field a = m32744a(newInstance, "com.tencent.smtt.export.external.interfaces.IX5WebViewBase");
            Object obj = a.get(newInstance);
            StringBuilder sb = new StringBuilder();
            sb.append("iX5WebViewBase:");
            sb.append(obj);
            sb.append(",webviewObject:");
            sb.append(newInstance);
            sb.append(",base:");
            sb.append(a);
            Log.e(str, sb.toString());
            Method method = obj.getClass().getMethod("getX5WebViewExtension", new Class[0]);
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Method getX5WebViewExtension:");
            sb2.append(method);
            Log.e(str, sb2.toString());
            Object invoke = method.invoke(obj, new Object[0]);
            StringBuilder sb3 = new StringBuilder();
            sb3.append("iX5WebViewExtension:");
            sb3.append(invoke);
            Log.e(str, sb3.toString());
            f25651b = (Bundle) invoke.getClass().getMethod("getSdkQBStatisticsInfo", new Class[0]).invoke(invoke, new Object[0]);
            StringBuilder sb4 = new StringBuilder();
            sb4.append("x5statisticsInfoBundle:");
            sb4.append(f25651b);
            Log.e(str, sb4.toString());
        } catch (Throwable th) {
            f25650a.mo37116w(th);
        }
    }

    /* renamed from: a */
    private static void m32747a(Object obj) {
        try {
            Object invoke = obj.getClass().getDeclaredMethod("getSettings", new Class[0]).invoke(obj, new Object[0]);
            f25652c = (String) invoke.getClass().getMethod("getUserAgentString", new Class[0]).invoke(invoke, new Object[0]);
            String str = StatConstants.LOG_TAG;
            StringBuilder sb = new StringBuilder();
            sb.append("x5UserAgent:");
            sb.append(f25652c);
            Log.e(str, sb.toString());
        } catch (Throwable th) {
            f25650a.mo37116w(th);
        }
    }

    /* renamed from: a */
    private static Field m32744a(Object obj, String str) {
        Field[] declaredFields;
        for (Class<Object> cls = obj.getClass(); cls != Object.class; cls = cls.getSuperclass()) {
            try {
                for (Field field : cls.getDeclaredFields()) {
                    if (field.getType().getName().equals(str)) {
                        field.setAccessible(true);
                        return field;
                    }
                }
                continue;
            } catch (Exception e) {
                f25650a.mo37116w(e);
            }
        }
        return null;
    }
}
