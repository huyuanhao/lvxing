package com.tencent.bugly.beta.tinker;

import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.app.Application.OnProvideAssistDataListener;
import android.content.BroadcastReceiver;
import android.content.ComponentCallbacks;
import android.content.ContentResolver;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.util.Log;
import com.tencent.tinker.loader.TinkerLoader;
import com.tencent.tinker.loader.app.TinkerApplication;
import com.tencent.tinker.loader.shareutil.ShareReflectUtil;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/* compiled from: BUGLY */
public class TinkerPatchReflectApplication extends TinkerApplication {
    private static final String TAG = "Tinker.ReflectApp";
    private boolean isReflectFailure = false;
    private String rawApplicationName = null;
    private Application realApplication;

    public TinkerPatchReflectApplication() {
        super(7, "com.tencent.bugly.beta.tinker.TinkerApplicationLike", TinkerLoader.class.getName(), false);
    }

    /* access modifiers changed from: protected */
    public void attachBaseContext(Context context) {
        TinkerPatchReflectApplication.super.attachBaseContext(context);
        try {
            String rawApplicationName2 = getRawApplicationName(context);
            if (rawApplicationName2 != null) {
                this.realApplication = (Application) Class.forName(rawApplicationName2, false, getClassLoader()).getConstructor(new Class[0]).newInstance(new Object[0]);
                if (this.realApplication != null) {
                    try {
                        Method declaredMethod = ContextWrapper.class.getDeclaredMethod("attachBaseContext", new Class[]{Context.class});
                        declaredMethod.setAccessible(true);
                        declaredMethod.invoke(this.realApplication, new Object[]{context});
                    } catch (Exception e) {
                        throw new IllegalStateException(e);
                    }
                }
            } else {
                throw new RuntimeException("can get real realApplication from manifest!");
            }
        } catch (Exception e2) {
            throw new IllegalStateException(e2);
        }
    }

    /* JADX WARNING: type inference failed for: r12v0, types: [android.content.Context, com.tencent.tinker.loader.app.TinkerApplication, com.tencent.bugly.beta.tinker.TinkerPatchReflectApplication] */
    public void onCreate() {
        Class cls;
        Object activityThread;
        Class cls2;
        String str = TAG;
        if (this.realApplication != null) {
            try {
                cls = Class.forName("android.app.ActivityThread");
                activityThread = ShareReflectUtil.getActivityThread(this, cls);
                Field declaredField = cls.getDeclaredField("mInitialApplication");
                declaredField.setAccessible(true);
                Application application = (Application) declaredField.get(activityThread);
                if (this.realApplication != null && application == this) {
                    declaredField.set(activityThread, this.realApplication);
                }
                if (this.realApplication != null) {
                    Field declaredField2 = cls.getDeclaredField("mAllApplications");
                    declaredField2.setAccessible(true);
                    List list = (List) declaredField2.get(activityThread);
                    for (int i = 0; i < list.size(); i++) {
                        if (list.get(i) == this) {
                            list.set(i, this.realApplication);
                        }
                    }
                }
                cls2 = Class.forName("android.app.LoadedApk");
            } catch (ClassNotFoundException unused) {
                cls2 = Class.forName("android.app.ActivityThread$PackageInfo");
            } catch (Throwable th) {
                StringBuilder sb = new StringBuilder();
                sb.append("Error, reflect Application fail, result:");
                sb.append(th);
                Log.e(str, sb.toString());
                this.isReflectFailure = true;
            }
            Field declaredField3 = cls2.getDeclaredField("mApplication");
            declaredField3.setAccessible(true);
            Field field = null;
            try {
                field = Application.class.getDeclaredField("mLoadedApk");
            } catch (NoSuchFieldException e) {
                e.printStackTrace();
            }
            String[] strArr = {"mPackages", "mResourcePackages"};
            for (int i2 = 0; i2 < 2; i2++) {
                Field declaredField4 = cls.getDeclaredField(strArr[i2]);
                declaredField4.setAccessible(true);
                for (Entry value : ((Map) declaredField4.get(activityThread)).entrySet()) {
                    Object obj = ((WeakReference) value.getValue()).get();
                    if (obj != null && declaredField3.get(obj) == this) {
                        if (this.realApplication != null) {
                            declaredField3.set(obj, this.realApplication);
                        }
                        if (!(this.realApplication == null || field == null)) {
                            field.set(this.realApplication, obj);
                        }
                    }
                }
            }
            if (!this.isReflectFailure) {
                try {
                    Class cls3 = Class.forName("com.tencent.bugly.beta.tinker.TinkerApplicationLike", false, getClassLoader());
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("replaceApplicationLike delegateClass:");
                    sb2.append(cls3);
                    Log.e(str, sb2.toString());
                    ShareReflectUtil.findField(cls3, "application").set(cls3.getDeclaredMethod("getTinkerPatchApplicationLike", new Class[0]).invoke(cls3, new Object[0]), this.realApplication);
                } catch (Throwable th2) {
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("replaceApplicationLike exception:");
                    sb3.append(th2.getMessage());
                    Log.e(str, sb3.toString());
                }
            }
        }
        TinkerPatchReflectApplication.super.onCreate();
        Application application2 = this.realApplication;
        if (application2 != null) {
            application2.onCreate();
        }
    }

    public String getRawApplicationName(Context context) {
        String str = TAG;
        String str2 = this.rawApplicationName;
        if (str2 != null) {
            return str2;
        }
        try {
            Object obj = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData.get("TINKER_PATCH_APPLICATION");
            if (obj != null) {
                this.rawApplicationName = String.valueOf(obj);
            } else {
                this.rawApplicationName = null;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("with app realApplication from manifest applicationName:");
            sb.append(this.rawApplicationName);
            Log.i(str, sb.toString());
            return this.rawApplicationName;
        } catch (Exception e) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("getManifestApplication exception:");
            sb2.append(e.getMessage());
            Log.e(str, sb2.toString());
            return null;
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (this.isReflectFailure) {
            Application application = this.realApplication;
            if (application != null) {
                application.onConfigurationChanged(configuration);
                return;
            }
        }
        TinkerPatchReflectApplication.super.onConfigurationChanged(configuration);
    }

    public void onLowMemory() {
        if (this.isReflectFailure) {
            Application application = this.realApplication;
            if (application != null) {
                application.onLowMemory();
                return;
            }
        }
        TinkerPatchReflectApplication.super.onLowMemory();
    }

    public void onTrimMemory(int i) {
        if (this.isReflectFailure) {
            Application application = this.realApplication;
            if (application != null) {
                application.onTrimMemory(i);
                return;
            }
        }
        TinkerPatchReflectApplication.super.onTrimMemory(i);
    }

    public void onTerminate() {
        if (this.isReflectFailure) {
            Application application = this.realApplication;
            if (application != null) {
                application.onTerminate();
                return;
            }
        }
        TinkerPatchReflectApplication.super.onTerminate();
    }

    public Intent registerReceiver(BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
        if (this.isReflectFailure) {
            Application application = this.realApplication;
            if (application != null) {
                return application.registerReceiver(broadcastReceiver, intentFilter);
            }
        }
        return TinkerPatchReflectApplication.super.registerReceiver(broadcastReceiver, intentFilter);
    }

    public void unregisterReceiver(BroadcastReceiver broadcastReceiver) {
        if (this.isReflectFailure) {
            Application application = this.realApplication;
            if (application != null) {
                application.unregisterReceiver(broadcastReceiver);
                return;
            }
        }
        TinkerPatchReflectApplication.super.unregisterReceiver(broadcastReceiver);
    }

    public boolean bindService(Intent intent, ServiceConnection serviceConnection, int i) {
        if (this.isReflectFailure) {
            Application application = this.realApplication;
            if (application != null) {
                return application.bindService(intent, serviceConnection, i);
            }
        }
        return TinkerPatchReflectApplication.super.bindService(intent, serviceConnection, i);
    }

    public void unbindService(ServiceConnection serviceConnection) {
        if (this.isReflectFailure) {
            Application application = this.realApplication;
            if (application != null) {
                application.unbindService(serviceConnection);
                return;
            }
        }
        TinkerPatchReflectApplication.super.unbindService(serviceConnection);
    }

    public void registerComponentCallbacks(ComponentCallbacks componentCallbacks) {
        if (this.isReflectFailure) {
            Application application = this.realApplication;
            if (application != null) {
                application.registerComponentCallbacks(componentCallbacks);
                return;
            }
        }
        TinkerPatchReflectApplication.super.registerComponentCallbacks(componentCallbacks);
    }

    public void unregisterComponentCallbacks(ComponentCallbacks componentCallbacks) {
        if (this.isReflectFailure) {
            Application application = this.realApplication;
            if (application != null) {
                application.unregisterComponentCallbacks(componentCallbacks);
                return;
            }
        }
        TinkerPatchReflectApplication.super.unregisterComponentCallbacks(componentCallbacks);
    }

    public void registerActivityLifecycleCallbacks(ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        if (this.isReflectFailure) {
            Application application = this.realApplication;
            if (application != null) {
                application.registerActivityLifecycleCallbacks(activityLifecycleCallbacks);
                return;
            }
        }
        TinkerPatchReflectApplication.super.registerActivityLifecycleCallbacks(activityLifecycleCallbacks);
    }

    public void unregisterActivityLifecycleCallbacks(ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        if (this.isReflectFailure) {
            Application application = this.realApplication;
            if (application != null) {
                application.unregisterActivityLifecycleCallbacks(activityLifecycleCallbacks);
                return;
            }
        }
        TinkerPatchReflectApplication.super.unregisterActivityLifecycleCallbacks(activityLifecycleCallbacks);
    }

    public void registerOnProvideAssistDataListener(OnProvideAssistDataListener onProvideAssistDataListener) {
        if (this.isReflectFailure) {
            Application application = this.realApplication;
            if (application != null) {
                application.registerOnProvideAssistDataListener(onProvideAssistDataListener);
                return;
            }
        }
        TinkerPatchReflectApplication.super.registerOnProvideAssistDataListener(onProvideAssistDataListener);
    }

    public void unregisterOnProvideAssistDataListener(OnProvideAssistDataListener onProvideAssistDataListener) {
        if (this.isReflectFailure) {
            Application application = this.realApplication;
            if (application != null) {
                application.unregisterOnProvideAssistDataListener(onProvideAssistDataListener);
                return;
            }
        }
        TinkerPatchReflectApplication.super.unregisterOnProvideAssistDataListener(onProvideAssistDataListener);
    }

    public Resources getResources() {
        if (this.isReflectFailure) {
            Application application = this.realApplication;
            if (application != null) {
                return application.getResources();
            }
        }
        return TinkerPatchReflectApplication.super.getResources();
    }

    public ClassLoader getClassLoader() {
        if (this.isReflectFailure) {
            Application application = this.realApplication;
            if (application != null) {
                return application.getClassLoader();
            }
        }
        return TinkerPatchReflectApplication.super.getClassLoader();
    }

    public AssetManager getAssets() {
        if (this.isReflectFailure) {
            Application application = this.realApplication;
            if (application != null) {
                return application.getAssets();
            }
        }
        return TinkerPatchReflectApplication.super.getAssets();
    }

    public ContentResolver getContentResolver() {
        if (this.isReflectFailure) {
            Application application = this.realApplication;
            if (application != null) {
                return application.getContentResolver();
            }
        }
        return TinkerPatchReflectApplication.super.getContentResolver();
    }
}
