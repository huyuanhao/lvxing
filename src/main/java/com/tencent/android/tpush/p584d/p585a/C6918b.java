package com.tencent.android.tpush.p584d.p585a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.tencent.android.tpush.common.C6914l;
import com.tencent.android.tpush.p580b.C6864a;
import com.tencent.android.tpush.p584d.C6926c;
import com.tencent.android.tpush.service.p595e.C7055h;
import com.tencent.android.tpush.service.p595e.C7056i;
import com.tencent.p605ep.commonbase.api.ConfigManager.OEM;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/* compiled from: ProGuard */
/* renamed from: com.tencent.android.tpush.d.a.b */
public class C6918b extends C6926c {
    /* renamed from: a */
    Object f22998a;
    /* renamed from: b */
    Context f22999b;
    /* renamed from: c */
    BroadcastReceiver f23000c = null;
    /* renamed from: d */
    String f23001d;

    /* compiled from: ProGuard */
    /* renamed from: com.tencent.android.tpush.d.a.b$a */
    public class C6920a implements InvocationHandler {
        public C6920a() {
        }

        public Object invoke(Object obj, Method method, Object[] objArr) {
            String str = "com.huawei.hms.support.api.push.TokenResult";
            String str2 = "TokenResult =  ";
            String str3 = "com.huawei.hms.api.ConnectionResult";
            if (method == null) {
                return null;
            }
            if (method.getName().equals("onConnected")) {
                C6914l.m29510a("reveiver onConnected", C6918b.this.f22999b);
                C6918b.this.m29544b();
            } else if (method.getName().equals("onResult")) {
                C6914l.m29510a("reveiver onResult", C6918b.this.f22999b);
                if (objArr != null) {
                    try {
                        if (objArr.length > 0) {
                            Object obj2 = objArr[0];
                            Class cls = Class.forName("com.huawei.hms.support.api.entity.push.TokenResp");
                            Class cls2 = Class.forName(str);
                            Object invoke = cls.getDeclaredMethod("getToken", new Class[0]).invoke(cls2.getDeclaredMethod("getTokenRes", new Class[0]).invoke(Class.forName(str).cast(obj2), new Object[0]), new Object[0]);
                            StringBuilder sb = new StringBuilder();
                            sb.append(str2);
                            sb.append(invoke);
                            C6914l.m29510a(sb.toString(), C6918b.this.f22999b);
                        }
                    } catch (Exception e) {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append(str2);
                        sb2.append(e.getMessage());
                        C6914l.m29510a(sb2.toString(), C6918b.this.f22999b);
                    }
                }
            } else {
                if ("onConnectionFailed".equals(method.getName()) && objArr != null) {
                    try {
                        if (objArr.length > 0) {
                            Class cls3 = Class.forName(str3);
                            int intValue = ((Integer) cls3.getDeclaredMethod("getErrorCode", new Class[0]).invoke(Class.forName(str3).cast(objArr[0]), new Object[0])).intValue();
                            StringBuilder sb3 = new StringBuilder();
                            sb3.append("reveiver ");
                            sb3.append(method.getName());
                            sb3.append(" errorcode ");
                            sb3.append(intValue);
                            C6914l.m29510a(sb3.toString(), C6918b.this.f22999b);
                        }
                    } catch (Throwable th) {
                        StringBuilder sb4 = new StringBuilder();
                        sb4.append("onConnectionFailed + ");
                        sb4.append(th.getMessage());
                        C6914l.m29510a(sb4.toString(), C6918b.this.f22999b);
                    }
                }
            }
            return method;
        }
    }

    /* compiled from: ProGuard */
    /* renamed from: com.tencent.android.tpush.d.a.b$b */
    public class C6921b implements InvocationHandler {
        public C6921b() {
        }

        public Object invoke(Object obj, Method method, Object[] objArr) {
            String str = "com.huawei.hms.support.api.push.TokenResult";
            if (method == null) {
                return null;
            }
            if (method.getName().equals("onResult") && objArr != null) {
                try {
                    if (objArr.length > 0) {
                        Object obj2 = objArr[0];
                        Class cls = Class.forName("com.huawei.hms.support.api.entity.push.TokenResp");
                        Class cls2 = Class.forName(str);
                        Object invoke = cls.getDeclaredMethod("getToken", new Class[0]).invoke(cls2.getDeclaredMethod("getTokenRes", new Class[0]).invoke(Class.forName(str).cast(obj2), new Object[0]), new Object[0]);
                        StringBuilder sb = new StringBuilder();
                        sb.append("TokenResult =  ");
                        sb.append(invoke);
                        C6914l.m29510a(sb.toString(), C6918b.this.f22999b);
                    }
                } catch (Throwable th) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("MyTokenHandler error TokenResult =  ");
                    sb2.append(th.getMessage());
                    C6914l.m29510a(sb2.toString(), C6918b.this.f22999b);
                }
            }
            return method;
        }
    }

    /* renamed from: a */
    public String mo33123a() {
        return OEM.HUAWEI;
    }

    /* renamed from: d */
    public boolean mo33127d(Context context) {
        return true;
    }

    /* renamed from: a */
    public void mo33124a(Context context) {
        C6914l.m29510a("registerPush huawei", context);
        m29545e(context);
        try {
            this.f22999b = context;
            Class cls = Class.forName("com.huawei.hms.api.HuaweiApiClient");
            Class cls2 = Class.forName("com.huawei.hms.api.HuaweiApiClient$Builder");
            Object[] objArr = {context};
            Constructor declaredConstructor = cls2.getDeclaredConstructor(new Class[]{Context.class});
            Class loadClass = cls2.getClassLoader().loadClass("com.huawei.hms.api.HuaweiApiClient$OnConnectionFailedListener");
            Class cls3 = Class.forName("com.huawei.hms.api.HuaweiApiClient$ConnectionCallbacks");
            C6920a aVar = new C6920a();
            Object newProxyInstance = Proxy.newProxyInstance(cls.getClassLoader(), new Class[]{cls3}, aVar);
            Object newProxyInstance2 = Proxy.newProxyInstance(cls.getClassLoader(), new Class[]{loadClass}, aVar);
            Object newInstance = declaredConstructor.newInstance(objArr);
            Class cls4 = Class.forName("com.huawei.hms.support.api.push.HuaweiPush");
            Class cls5 = Class.forName("com.huawei.hms.api.Api");
            Field declaredField = cls4.getDeclaredField("PUSH_API");
            cls2.getDeclaredMethod("addApi", new Class[]{cls5}).invoke(newInstance, new Object[]{declaredField.get(cls5)});
            cls2.getDeclaredMethod("addConnectionCallbacks", new Class[]{cls3}).invoke(newInstance, new Object[]{newProxyInstance});
            cls2.getDeclaredMethod("addOnConnectionFailedListener", new Class[]{loadClass}).invoke(newInstance, new Object[]{newProxyInstance2});
            this.f22998a = cls2.getDeclaredMethod("build", new Class[0]).invoke(newInstance, new Object[0]);
            cls.getDeclaredMethod("connect", new Class[0]).invoke(this.f22998a, new Object[0]);
            C6914l.m29510a("connect to huawei", context);
        } catch (Throwable th) {
            StringBuilder sb = new StringBuilder();
            sb.append("register =  ");
            sb.append(th.getMessage());
            C6914l.m29510a(sb.toString(), context);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m29544b() {
        String str = "OtherPushHuaWeiImpl";
        C6914l.m29510a("getTokenAsyn", this.f22999b);
        try {
            Class cls = Class.forName("com.huawei.hms.support.api.client.ApiClient");
            if (((Boolean) cls.getDeclaredMethod("isConnected", new Class[0]).invoke(this.f22998a, new Object[0])).booleanValue()) {
                Class cls2 = Class.forName("com.huawei.hms.support.api.push.HuaweiPush");
                Class.forName("com.huawei.hms.support.api.push.HuaweiPushApi");
                Object obj = cls2.getDeclaredField("HuaweiPushApi").get(cls2);
                Object invoke = obj.getClass().getDeclaredMethod("getToken", new Class[]{cls}).invoke(obj, new Object[]{this.f22998a});
                Class cls3 = Class.forName("com.huawei.hms.support.api.client.PendingResult");
                Class cls4 = Class.forName("com.huawei.hms.support.api.client.ResultCallback");
                C6921b bVar = new C6921b();
                Object newProxyInstance = Proxy.newProxyInstance(cls.getClassLoader(), new Class[]{cls4}, bVar);
                cls3.getDeclaredMethod("setResultCallback", new Class[]{cls4}).invoke(invoke, new Object[]{newProxyInstance});
                return;
            }
            C6864a.m29308i(str, "getTokenAsyn failed with unconnected");
        } catch (Throwable th) {
            C6864a.m29302d(str, "registerPush ", th);
        }
    }

    /* renamed from: b */
    public void mo33125b(Context context) {
        try {
            Class cls = Class.forName("com.huawei.hms.support.api.client.ApiClient");
            if (((Boolean) cls.getDeclaredMethod("isConnected", new Class[0]).invoke(this.f22998a, new Object[0])).booleanValue()) {
                Class cls2 = Class.forName("com.huawei.hms.support.api.push.HuaweiPush");
                Class.forName("com.huawei.hms.support.api.push.HuaweiPushApi");
                cls2.getDeclaredField("HuaweiPushApi").get(cls2).getClass().getDeclaredMethod("deleteToken", new Class[]{cls, String.class}).invoke(this.f22998a, new Object[]{mo33126c(context)});
            }
        } catch (Exception e) {
            C6864a.m29302d("OtherPushHuaWeiImpl", "unregisterPush ", e);
        }
    }

    /* renamed from: e */
    private void m29545e(Context context) {
        if (this.f23000c == null) {
            this.f23000c = new BroadcastReceiver() {
                public void onReceive(Context context, Intent intent) {
                    String str = "OtherPushHuaWeiImpl";
                    if (intent != null) {
                        try {
                            String action = intent.getAction();
                            if (!C7056i.m30194b(action)) {
                                if ("com.huawei.android.push.intent.REGISTRATION".equals(action)) {
                                    byte[] byteArrayExtra = intent.getByteArrayExtra("device_token");
                                    if (byteArrayExtra != null) {
                                        C6918b.this.f23001d = new String(byteArrayExtra, "UTF-8");
                                        if (!C7056i.m30194b(C6918b.this.f23001d)) {
                                            C7055h.m30172b(context, "huawei_token", C6918b.this.f23001d);
                                        }
                                    }
                                } else if ("com.huawei.android.push.intent.RECEIVE".equals(action)) {
                                    C6864a.m29298c(str, "reciver action com.huawei.android.push.intent.RECEIVE");
                                } else if ("com.huawei.intent.action.PUSH_STATE".equals(action)) {
                                    C6864a.m29298c(str, "reciver action com.huawei.intent.action.PUSH_STATEE");
                                }
                            }
                        } catch (Throwable th) {
                            C6864a.m29302d(str, "registerHuaweiRecevier ", th);
                            StringBuilder sb = new StringBuilder();
                            sb.append("receiver token error");
                            sb.append(th.getLocalizedMessage());
                            C6914l.m29510a(sb.toString(), C6918b.this.f22999b);
                        }
                    }
                }
            };
            try {
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("com.huawei.android.push.intent.REGISTRATION");
                intentFilter.addAction("com.huawei.android.push.intent.RECEIVE");
                intentFilter.addAction("com.huawei.intent.action.PUSH_STATE");
                context.registerReceiver(this.f23000c, intentFilter);
            } catch (Throwable th) {
                StringBuilder sb = new StringBuilder();
                sb.append("registerReceiver error ");
                sb.append(th.getLocalizedMessage());
                C6914l.m29510a(sb.toString(), this.f22999b);
            }
        }
    }

    /* renamed from: c */
    public String mo33126c(Context context) {
        if (!C7056i.m30194b(this.f23001d)) {
            return this.f23001d;
        }
        return C7055h.m30169a(context, "huawei_token", "");
    }
}
