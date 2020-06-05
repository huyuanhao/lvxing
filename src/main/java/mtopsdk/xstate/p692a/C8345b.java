package mtopsdk.xstate.p692a;

import android.content.Context;
import mtopsdk.common.util.TBSdkLog;

/* compiled from: NetworkStateReceiver */
/* renamed from: mtopsdk.xstate.a.b */
final class C8345b implements Runnable {
    /* renamed from: a */
    private /* synthetic */ Context f28064a;
    /* renamed from: b */
    private /* synthetic */ NetworkStateReceiver f28065b;

    C8345b(NetworkStateReceiver aVar, Context context) {
        this.f28065b = aVar;
        this.f28064a = context;
    }

    public final void run() {
        try {
            this.f28065b.mo39881a(this.f28064a);
        } catch (Throwable th) {
            TBSdkLog.m35504a("mtopsdk.NetworkStateReceiver", "[onReceive] updateNetworkStatus error", th);
        }
    }
}
