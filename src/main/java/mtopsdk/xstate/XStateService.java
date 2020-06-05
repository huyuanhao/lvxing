package mtopsdk.xstate;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import mtopsdk.common.util.TBSdkLog;
import mtopsdk.common.util.TBSdkLog.LogEnable;
import mtopsdk.xstate.p693b.IXState.C8346a;

public class XStateService extends Service {
    /* renamed from: a */
    C8346a f28051a = null;
    /* renamed from: b */
    Object f28052b = new Object();

    /* renamed from: mtopsdk.xstate.XStateService$a */
    class C8344a extends C8346a {
        public C8344a() {
        }

        /* renamed from: a */
        public String mo39876a(String str) throws RemoteException {
            return XStateDelegate.m35607b(str);
        }

        /* renamed from: a */
        public void mo39878a(String str, String str2) throws RemoteException {
            XStateDelegate.m35606a(str, str2);
        }

        /* renamed from: a */
        public void mo39877a() throws RemoteException {
            XStateDelegate.m35605a(XStateService.this.getBaseContext());
        }

        /* renamed from: b */
        public void mo39880b() throws RemoteException {
            XStateDelegate.m35604a();
        }

        /* renamed from: b */
        public String mo39879b(String str) throws RemoteException {
            return XStateDelegate.m35603a(str);
        }
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        return 2;
    }

    public IBinder onBind(Intent intent) {
        synchronized (this.f28052b) {
            if (this.f28051a == null) {
                this.f28051a = new C8344a();
                try {
                    this.f28051a.mo39877a();
                } catch (RemoteException e) {
                    TBSdkLog.m35504a("mtopsdk.XStateService", "[onBind]init() exception", (Throwable) e);
                } catch (Throwable th) {
                    TBSdkLog.m35504a("mtopsdk.XStateService", "[onBind]init() error", th);
                }
            }
        }
        if (TBSdkLog.m35509b(LogEnable.InfoEnable)) {
            StringBuilder sb = new StringBuilder("[onBind] XStateService  stub= ");
            sb.append(this.f28051a.hashCode());
            TBSdkLog.m35506b("mtopsdk.XStateService", sb.toString());
        }
        return this.f28051a;
    }

    public void onDestroy() {
        super.onDestroy();
        synchronized (this.f28052b) {
            if (this.f28051a != null) {
                try {
                    this.f28051a.mo39880b();
                } catch (RemoteException e) {
                    TBSdkLog.m35504a("mtopsdk.XStateService", "[onDestroy]unInit() exception", (Throwable) e);
                } catch (Throwable th) {
                    TBSdkLog.m35504a("mtopsdk.XStateService", "[onDestroy]unInit() error", th);
                }
            }
        }
    }
}
