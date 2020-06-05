package btmsdkobf;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import androidx.core.app.NotificationCompat;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: btmsdkobf.eu */
public class C0825eu {
    private static Object lock = new Object();
    /* renamed from: ny */
    private static C0825eu f936ny;
    /* renamed from: nz */
    private static Object f937nz = new Object();
    /* renamed from: nu */
    private Context f938nu = C0652cl.m85D();
    /* renamed from: nx */
    ConcurrentHashMap<String, C0826a> f939nx = new ConcurrentHashMap<>();

    /* renamed from: btmsdkobf.eu$a */
    class C0826a extends BroadcastReceiver {
        /* renamed from: nA */
        public String f940nA = null;
        /* renamed from: nB */
        public Runnable f941nB = null;

        C0826a() {
        }

        public void onReceive(Context context, Intent intent) {
            final String action = intent.getAction();
            if (action != null) {
                StringBuilder sb = new StringBuilder();
                sb.append("action:");
                sb.append(action);
                C0848ff.m907i("cccccc", sb.toString());
                if (this.f940nA.equals(action) && this.f941nB != null) {
                    C0845fd.m898cN().addTask(new Runnable() {
                        public void run() {
                            C0826a.this.f941nB.run();
                            C0825eu.this.mo9529w(action);
                        }
                    }, "AlarmerTaskReceiver");
                }
            }
        }
    }

    private C0825eu() {
    }

    /* renamed from: cK */
    public static C0825eu m861cK() {
        if (f936ny == null) {
            synchronized (lock) {
                if (f936ny == null) {
                    f936ny = new C0825eu();
                }
            }
        }
        return f936ny;
    }

    /* renamed from: a */
    public void mo9528a(String str, long j, Runnable runnable, int i) {
        if (i == 0 || i == 1) {
            try {
                synchronized (f937nz) {
                    C0826a aVar = new C0826a();
                    this.f938nu.registerReceiver(aVar, new IntentFilter(str));
                    aVar.f941nB = runnable;
                    aVar.f940nA = str;
                    PendingIntent broadcast = PendingIntent.getBroadcast(this.f938nu, 0, new Intent(str), 0);
                    AlarmManager alarmManager = (AlarmManager) this.f938nu.getSystemService(NotificationCompat.CATEGORY_ALARM);
                    this.f939nx.put(str, aVar);
                    alarmManager.set(i, System.currentTimeMillis() + j, broadcast);
                }
            } catch (Throwable unused) {
            }
        }
    }

    /* renamed from: w */
    public void mo9529w(String str) {
        synchronized (f937nz) {
            C0826a aVar = (C0826a) this.f939nx.remove(str);
            if (aVar != null) {
                C0807em.m810a(this.f938nu, str);
                this.f938nu.unregisterReceiver(aVar);
            }
        }
    }
}
