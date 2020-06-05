package com.qiyukf.nimlib.service;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import androidx.core.app.NotificationCompat;
import com.qiyukf.basesdk.p393a.C5264a;
import com.qiyukf.basesdk.p412c.p417d.C5413e;
import com.qiyukf.nimlib.C5743d;
import com.qiyukf.nimlib.p470f.C5837d;
import com.qiyukf.nimlib.p473h.C5906f;
import com.qiyukf.unicorn.C6029d;

public class NimService extends Service {

    /* renamed from: com.qiyukf.nimlib.service.NimService$Aux */
    public static final class Aux extends Service {
        /* renamed from: a */
        private static final Binder f18784a = new Binder();

        public final IBinder onBind(Intent intent) {
            C5837d.m23409d();
            return f18784a;
        }

        public final void onRebind(Intent intent) {
            C5837d.m23409d();
            super.onRebind(intent);
        }

        public final boolean onUnbind(Intent intent) {
            return true;
        }
    }

    /* renamed from: a */
    public static Intent m23851a(Context context) {
        Intent intent = new Intent(context.getApplicationContext(), NimService.class);
        intent.setAction("com.qiyukf.desk.ACTION.KEEP_ALIVE");
        intent.putExtra("EXTRA_FROM", 4);
        return intent;
    }

    /* renamed from: a */
    public static void m23852a(Context context, int i) {
        StringBuilder sb = new StringBuilder("start service from ");
        sb.append(i);
        C5264a.m21624d(NotificationCompat.CATEGORY_SERVICE, sb.toString());
        Context applicationContext = context.getApplicationContext();
        Intent intent = new Intent(applicationContext, NimService.class);
        intent.putExtra("EXTRA_FROM", i);
        C5413e.m22153a(applicationContext, intent);
    }

    /* renamed from: b */
    public static Intent m23853b(Context context) {
        return new Intent(context, NimService.class);
    }

    /* renamed from: c */
    public static Intent m23854c(Context context) {
        return new Intent(context, Aux.class);
    }

    public IBinder onBind(Intent intent) {
        C5837d.m23409d();
        return C5837d.m23408c();
    }

    public void onCreate() {
        super.onCreate();
        C6029d.m24028a((Context) this);
        C5743d.m23111a(true);
        C5264a.m21617a("core", "nim service startup");
    }

    public void onDestroy() {
        C5743d.m23111a(false);
        super.onDestroy();
    }

    public void onRebind(Intent intent) {
        C5837d.m23409d();
        super.onRebind(intent);
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        int i3 = 0;
        if (intent != null) {
            i3 = intent.getIntExtra("EXTRA_FROM", 0);
        }
        StringBuilder sb = new StringBuilder("onStartCommand from#");
        sb.append(i3);
        sb.append(" flags#");
        sb.append(i);
        sb.append(" startId#");
        sb.append(i2);
        C5264a.m21624d(NotificationCompat.CATEGORY_SERVICE, sb.toString());
        if (i3 != 2) {
            NimReceiver.m23850a((Context) this);
        }
        if (i3 == 4) {
            C5906f.m23656a().mo28286d();
        }
        return 2;
    }

    public boolean onUnbind(Intent intent) {
        return true;
    }
}
