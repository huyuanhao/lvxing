package btmsdkobf;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import androidx.core.app.NotificationCompat;

/* renamed from: btmsdkobf.em */
public class C0807em {
    /* renamed from: a */
    public static PendingIntent m809a(Context context, String str, long j) {
        StringBuilder sb = new StringBuilder();
        sb.append("添加闹钟 : ");
        sb.append(str);
        sb.append(" ");
        sb.append(j / 1000);
        sb.append("s");
        String str2 = "AlarmerUtil";
        C0849fg.m914i(str2, sb.toString());
        PendingIntent pendingIntent = null;
        try {
            Intent intent = new Intent(str);
            intent.setPackage(C0652cl.m85D().getPackageName());
            pendingIntent = PendingIntent.getBroadcast(context, 0, intent, 0);
            ((AlarmManager) context.getSystemService(NotificationCompat.CATEGORY_ALARM)).set(0, System.currentTimeMillis() + j, pendingIntent);
            return pendingIntent;
        } catch (Throwable th) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("addAlarm: ");
            sb2.append(th);
            C0849fg.m912e(str2, sb2.toString());
            return pendingIntent;
        }
    }

    /* renamed from: a */
    public static void m810a(Context context, String str) {
        try {
            Intent intent = new Intent(str);
            intent.setPackage(C0652cl.m85D().getPackageName());
            ((AlarmManager) context.getSystemService(NotificationCompat.CATEGORY_ALARM)).cancel(PendingIntent.getBroadcast(context, 0, intent, 0));
        } catch (Throwable th) {
            StringBuilder sb = new StringBuilder();
            sb.append("delAlarm exception: ");
            sb.append(th);
            C0849fg.m912e("AlarmerUtil", sb.toString());
        }
    }
}
