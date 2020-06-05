package com.tencent.p605ep.commonbase.service;

import android.content.Intent;
import android.os.IBinder;
import com.tencent.p605ep.commonbase.api.AppContext;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.tencent.ep.commonbase.service.TMSService */
public abstract class TMSService extends BaseSafeIntentService {
    private static final HashMap<Class<?>, BaseService> mService = new HashMap<>();
    private static final HashMap<Class<?>, ArrayList<BaseServiceConnection>> mServiceConnections = new HashMap<>();

    public static IBinder bindService(Class<? extends BaseService> cls, BaseServiceConnection baseServiceConnection) {
        IBinder iBinder;
        synchronized (BaseService.class) {
            BaseService baseService = (BaseService) mService.get(cls);
            if (baseService != null) {
                iBinder = baseService.getBinder();
                ArrayList arrayList = (ArrayList) mServiceConnections.get(cls);
                if (arrayList == null) {
                    arrayList = new ArrayList(1);
                    mServiceConnections.put(cls, arrayList);
                }
                arrayList.add(baseServiceConnection);
            } else {
                iBinder = null;
            }
        }
        return iBinder;
    }

    public static BaseService startService(BaseService baseService) {
        return startService(baseService, null);
    }

    public static BaseService startService(BaseService baseService, Intent intent) {
        synchronized (BaseService.class) {
            if (mService.containsKey(baseService.getClass())) {
                ((BaseService) mService.get(baseService.getClass())).onStart(intent);
            } else {
                baseService.onCreate(AppContext.context.getApplicationContext());
                baseService.onStart(intent);
                mService.put(baseService.getClass(), baseService);
            }
        }
        return baseService;
    }

    public static synchronized boolean stopService(BaseService baseService) {
        boolean stopService;
        synchronized (TMSService.class) {
            stopService = stopService(baseService.getClass());
        }
        return stopService;
    }

    public static boolean stopService(Class<? extends BaseService> cls) {
        synchronized (BaseService.class) {
            if (!mService.containsKey(cls)) {
                return true;
            }
            List list = (List) mServiceConnections.get(cls);
            if (list != null) {
                if (list.size() != 0) {
                    return false;
                }
            }
            ((BaseService) mService.get(cls)).onDestory();
            mService.remove(cls);
            mServiceConnections.remove(cls);
            return true;
        }
    }

    public static void unBindService(Class<? extends BaseService> cls, BaseServiceConnection baseServiceConnection) {
        synchronized (BaseService.class) {
            List list = (List) mServiceConnections.get(cls);
            if (list != null) {
                list.remove(baseServiceConnection);
            }
        }
    }

    public IBinder doOnBind(Intent intent) {
        return null;
    }

    public /* bridge */ /* synthetic */ void doOnRebind(Intent intent) {
        super.doOnRebind(intent);
    }

    public /* bridge */ /* synthetic */ void doOnStart(Intent intent, int i) {
        super.doOnStart(intent, i);
    }

    public int doOnStartCommand(Intent intent, int i, int i2) {
        super.doOnStartCommand(intent, i, i2);
        return 1;
    }

    public /* bridge */ /* synthetic */ boolean doOnUnbind(Intent intent) {
        return super.doOnUnbind(intent);
    }

    public void onCreate() {
        super.onCreate();
        synchronized (BaseService.class) {
            mService.clear();
            mServiceConnections.clear();
        }
    }

    public void onDestroy() {
        synchronized (BaseService.class) {
            Iterator it = new ArrayList(mService.values()).iterator();
            while (it.hasNext()) {
                ((BaseService) it.next()).onDestory();
            }
            mService.clear();
            mServiceConnections.clear();
        }
        super.onDestroy();
    }
}
