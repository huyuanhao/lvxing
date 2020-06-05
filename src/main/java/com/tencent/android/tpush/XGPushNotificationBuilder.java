package com.tencent.android.tpush;

import android.app.Notification;
import android.app.Notification.BigTextStyle;
import android.app.Notification.Builder;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Build.VERSION;
import android.widget.RemoteViews;
import androidx.core.app.NotificationCompat;
import com.tencent.android.tpush.common.C6900b;
import com.tencent.android.tpush.common.Constants;
import com.tencent.android.tpush.common.MessageKey;
import com.tencent.android.tpush.p580b.C6864a;
import com.tencent.mid.sotrage.StorageInterface;
import org.json.JSONObject;

/* compiled from: ProGuard */
public abstract class XGPushNotificationBuilder {
    public static final String BASIC_NOTIFICATION_BUILDER_TYPE = "basic";
    public static final String CUSTOM_NOTIFICATION_BUILDER_TYPE = "custom";
    /* renamed from: a */
    protected String f22778a = "xg-channle-id";
    /* renamed from: b */
    protected String f22779b = "message";
    /* renamed from: c */
    protected Integer f22780c = null;
    /* renamed from: d */
    protected PendingIntent f22781d = null;
    /* renamed from: e */
    protected RemoteViews f22782e = null;
    /* renamed from: f */
    protected RemoteViews f22783f = null;
    /* renamed from: g */
    protected Integer f22784g = null;
    /* renamed from: h */
    protected PendingIntent f22785h = null;
    /* renamed from: i */
    protected Integer f22786i = null;
    /* renamed from: j */
    protected Integer f22787j = null;
    /* renamed from: k */
    protected Integer f22788k = null;
    /* renamed from: l */
    protected Integer f22789l = null;
    /* renamed from: m */
    protected Integer f22790m = null;
    /* renamed from: n */
    protected Integer f22791n = null;
    /* renamed from: o */
    protected Integer f22792o = null;
    /* renamed from: p */
    protected Uri f22793p = null;
    /* renamed from: q */
    protected CharSequence f22794q = null;
    /* renamed from: r */
    protected long[] f22795r = null;
    /* renamed from: s */
    protected Long f22796s = null;
    /* renamed from: t */
    protected Integer f22797t = null;
    /* renamed from: u */
    protected Bitmap f22798u = null;
    /* renamed from: v */
    protected Integer f22799v = null;
    /* renamed from: w */
    protected String f22800w;
    /* renamed from: x */
    protected Integer f22801x = null;

    /* renamed from: a */
    public abstract void mo32769a(JSONObject jSONObject);

    /* renamed from: b */
    public abstract void mo32770b(JSONObject jSONObject);

    public abstract Notification buildNotification(Context context);

    public abstract String getType();

    public void encode(JSONObject jSONObject) {
        mo32769a(jSONObject);
        C6900b.m29457a(jSONObject, "audioStringType", (Object) this.f22780c);
        C6900b.m29457a(jSONObject, "defaults", (Object) this.f22784g);
        C6900b.m29457a(jSONObject, "flags", (Object) this.f22786i);
        C6900b.m29457a(jSONObject, "icon", (Object) this.f22787j);
        C6900b.m29457a(jSONObject, "iconLevel", (Object) this.f22788k);
        C6900b.m29457a(jSONObject, "ledARGB", (Object) this.f22789l);
        C6900b.m29457a(jSONObject, "ledOffMS", (Object) this.f22790m);
        C6900b.m29457a(jSONObject, "ledOnMS", (Object) this.f22791n);
        C6900b.m29457a(jSONObject, "number", (Object) this.f22792o);
        C6900b.m29457a(jSONObject, "sound", (Object) this.f22793p);
        C6900b.m29457a(jSONObject, "smallIcon", (Object) this.f22797t);
        C6900b.m29457a(jSONObject, "notificationLargeIcon", (Object) this.f22799v);
        if (this.f22795r != null) {
            StringBuilder sb = new StringBuilder();
            int i = 0;
            while (true) {
                long[] jArr = this.f22795r;
                if (i >= jArr.length) {
                    break;
                }
                sb.append(String.valueOf(jArr[i]));
                if (i != this.f22795r.length - 1) {
                    sb.append(StorageInterface.KEY_SPLITER);
                }
                i++;
            }
            C6900b.m29457a(jSONObject, MessageKey.MSG_VIBRATE, (Object) sb.toString());
        }
        C6900b.m29457a(jSONObject, "notificationId", (Object) this.f22801x);
    }

    public void decode(String str) {
        JSONObject jSONObject = new JSONObject(str);
        mo32770b(jSONObject);
        this.f22780c = (Integer) C6900b.m29458b(jSONObject, "audioStringType", null);
        this.f22784g = (Integer) C6900b.m29458b(jSONObject, "defaults", null);
        this.f22786i = (Integer) C6900b.m29458b(jSONObject, "flags", null);
        this.f22787j = (Integer) C6900b.m29458b(jSONObject, "icon", null);
        this.f22788k = (Integer) C6900b.m29458b(jSONObject, "iconLevel", null);
        this.f22789l = (Integer) C6900b.m29458b(jSONObject, "ledARGB", null);
        this.f22790m = (Integer) C6900b.m29458b(jSONObject, "ledOffMS", null);
        this.f22791n = (Integer) C6900b.m29458b(jSONObject, "ledOnMS", null);
        this.f22792o = (Integer) C6900b.m29458b(jSONObject, "number", null);
        String str2 = (String) C6900b.m29458b(jSONObject, "sound", null);
        this.f22797t = (Integer) C6900b.m29458b(jSONObject, "smallIcon", null);
        this.f22799v = (Integer) C6900b.m29458b(jSONObject, "notificationLargeIcon", null);
        if (str2 != null) {
            this.f22793p = Uri.parse(str2);
        }
        String str3 = (String) C6900b.m29458b(jSONObject, MessageKey.MSG_VIBRATE, null);
        if (str3 != null) {
            String[] split = str3.split(StorageInterface.KEY_SPLITER);
            int length = split.length;
            this.f22795r = new long[length];
            for (int i = 0; i < length; i++) {
                try {
                    this.f22795r[i] = Long.valueOf(split[i]).longValue();
                } catch (NumberFormatException unused) {
                }
            }
        }
        this.f22801x = (Integer) C6900b.m29458b(jSONObject, "notificationId", null);
    }

    public String getTitle(Context context) {
        if (this.f22800w == null) {
            this.f22800w = (String) context.getApplicationContext().getPackageManager().getApplicationLabel(context.getApplicationInfo());
        }
        return this.f22800w;
    }

    public void setTitle(String str) {
        this.f22800w = str;
    }

    public String getChannelId() {
        return this.f22778a;
    }

    public void setChannelId(String str) {
        this.f22778a = str;
    }

    public String getChannelName() {
        return this.f22779b;
    }

    public void setChannelName(String str) {
        this.f22779b = str;
    }

    public int getApplicationIcon(Context context) {
        return context.getApplicationInfo().icon;
    }

    public Notification getChannelNotification(Context context) {
        String str = Constants.LogTag;
        Builder builder = new Builder(context);
        BigTextStyle bigTextStyle = new BigTextStyle();
        Integer num = this.f22797t;
        if (num != null) {
            builder.setSmallIcon(num.intValue());
        }
        if (this.f22799v != null) {
            try {
                builder.setLargeIcon(BitmapFactory.decodeResource(context.getResources(), this.f22799v.intValue()));
            } catch (OutOfMemoryError unused) {
            }
        }
        Bitmap bitmap = this.f22798u;
        if (bitmap != null) {
            builder.setLargeIcon(bitmap);
        }
        String str2 = this.f22800w;
        if (str2 == null) {
            this.f22800w = getTitle(context);
        } else {
            builder.setContentTitle(str2);
        }
        CharSequence charSequence = this.f22794q;
        if (charSequence == null || this.f22782e != null) {
            builder.setContentText(this.f22794q);
            builder.setTicker(this.f22794q);
        } else {
            bigTextStyle.bigText(charSequence);
            builder.setStyle(bigTextStyle);
            builder.setContentText(this.f22794q);
            builder.setTicker(this.f22794q);
        }
        if (VERSION.SDK_INT >= 26 && context.getApplicationInfo().targetSdkVersion >= 26) {
            try {
                StringBuilder sb = new StringBuilder();
                sb.append("XGPushNotification create notificationChannle, channelId:");
                sb.append(getChannelId());
                sb.append(", channelName:");
                sb.append(getChannelName());
                C6864a.m29303e(str, sb.toString());
                Class cls = Class.forName("android.app.NotificationChannel");
                Object newInstance = cls.getConstructor(new Class[]{String.class, CharSequence.class, Integer.TYPE}).newInstance(new Object[]{getChannelId(), getChannelName(), Integer.valueOf(4)});
                NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
                notificationManager.getClass().getMethod("createNotificationChannel", new Class[]{cls}).invoke(notificationManager, new Object[]{newInstance});
                builder.getClass().getMethod("setChannelId", new Class[]{String.class}).invoke(builder, new Object[]{getChannelId()});
            } catch (Exception e) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("XGPushNotification create channel Error: ");
                sb2.append(e.getMessage());
                C6864a.m29309j(str, sb2.toString());
                e.printStackTrace();
            }
        }
        return builder.build();
    }

    /* renamed from: b */
    private Notification m29246b(Context context) {
        NotificationCompat.Builder builder = new NotificationCompat.Builder(context);
        NotificationCompat.BigTextStyle bigTextStyle = new NotificationCompat.BigTextStyle();
        Integer num = this.f22797t;
        if (num != null) {
            builder.setSmallIcon(num.intValue());
        }
        if (this.f22799v != null) {
            try {
                builder.setLargeIcon(BitmapFactory.decodeResource(context.getResources(), this.f22799v.intValue()));
            } catch (OutOfMemoryError unused) {
            }
        }
        Bitmap bitmap = this.f22798u;
        if (bitmap != null) {
            builder.setLargeIcon(bitmap);
        }
        String str = this.f22800w;
        if (str == null) {
            this.f22800w = getTitle(context);
        } else {
            builder.setContentTitle(str);
        }
        CharSequence charSequence = this.f22794q;
        if (charSequence == null || this.f22782e != null) {
            builder.setContentText(this.f22794q);
            builder.setTicker(this.f22794q);
        } else {
            bigTextStyle.bigText(charSequence);
            builder.setStyle(bigTextStyle);
            builder.setContentText(this.f22794q);
            builder.setTicker(this.f22794q);
        }
        return builder.build();
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public Notification mo32904a(Context context) {
        Notification notification;
        new Notification();
        if (this.f22801x == null) {
            this.f22801x = Integer.valueOf(0);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("XGPushNotification Build.VERSION.SDK_INT: ");
        sb.append(VERSION.SDK_INT);
        sb.append(", targetSDK:");
        sb.append(context.getApplicationInfo().targetSdkVersion);
        String sb2 = sb.toString();
        String str = Constants.LogTag;
        C6864a.m29305f(str, sb2);
        if (VERSION.SDK_INT < 26 || context.getApplicationInfo().targetSdkVersion < 26) {
            notification = m29246b(context);
        } else {
            notification = getChannelNotification(context);
        }
        Integer num = this.f22780c;
        if (num != null) {
            notification.audioStreamType = num.intValue();
        }
        PendingIntent pendingIntent = this.f22781d;
        if (pendingIntent != null) {
            notification.contentIntent = pendingIntent;
        }
        if (this.f22782e != null) {
            if (Build.MANUFACTURER.trim().toLowerCase().equals("oppo")) {
                C6864a.m29307h(str, "XGPushNotification: Oppo Rom not allow custom contentview. Not set it");
            } else {
                notification.contentView = this.f22782e;
            }
        }
        Integer num2 = this.f22784g;
        if (num2 != null) {
            notification.defaults = num2.intValue();
        }
        Integer num3 = this.f22787j;
        if (num3 != null) {
            notification.icon = num3.intValue();
        }
        PendingIntent pendingIntent2 = this.f22785h;
        if (pendingIntent2 != null) {
            notification.deleteIntent = pendingIntent2;
        }
        Integer num4 = this.f22786i;
        if (num4 != null) {
            notification.flags = num4.intValue();
        } else {
            notification.flags = 16;
        }
        Integer num5 = this.f22788k;
        if (num5 != null) {
            notification.iconLevel = num5.intValue();
        }
        Integer num6 = this.f22789l;
        if (num6 != null) {
            notification.ledARGB = num6.intValue();
        }
        Integer num7 = this.f22790m;
        if (num7 != null) {
            notification.ledOffMS = num7.intValue();
        }
        Integer num8 = this.f22791n;
        if (num8 != null) {
            notification.ledOnMS = num8.intValue();
        }
        Integer num9 = this.f22792o;
        if (num9 != null) {
            notification.number = num9.intValue();
        }
        Uri uri = this.f22793p;
        if (uri != null) {
            notification.sound = uri;
        }
        long[] jArr = this.f22795r;
        if (jArr != null) {
            notification.vibrate = jArr;
        }
        Long l = this.f22796s;
        if (l != null) {
            notification.when = l.longValue();
        } else {
            notification.when = System.currentTimeMillis();
        }
        return notification;
    }

    public int getAudioStringType() {
        return this.f22780c.intValue();
    }

    public XGPushNotificationBuilder setAudioStringType(int i) {
        this.f22780c = Integer.valueOf(i);
        return this;
    }

    public PendingIntent getContentIntent() {
        return this.f22781d;
    }

    public XGPushNotificationBuilder setContentIntent(PendingIntent pendingIntent) {
        this.f22781d = pendingIntent;
        return this;
    }

    public XGPushNotificationBuilder setContentView(RemoteViews remoteViews) {
        this.f22782e = remoteViews;
        return this;
    }

    public XGPushNotificationBuilder setbigContentView(RemoteViews remoteViews) {
        this.f22783f = remoteViews;
        return this;
    }

    public int getDefaults() {
        return this.f22784g.intValue();
    }

    public XGPushNotificationBuilder setDefaults(int i) {
        Integer num = this.f22784g;
        if (num == null) {
            this.f22784g = Integer.valueOf(i);
        } else {
            this.f22784g = Integer.valueOf(i | num.intValue());
        }
        return this;
    }

    public int getFlags() {
        return this.f22786i.intValue();
    }

    public XGPushNotificationBuilder setFlags(int i) {
        Integer num = this.f22786i;
        if (num == null) {
            this.f22786i = Integer.valueOf(i);
        } else {
            this.f22786i = Integer.valueOf(i | num.intValue());
        }
        return this;
    }

    public Integer getIcon() {
        return this.f22787j;
    }

    public XGPushNotificationBuilder setIcon(Integer num) {
        this.f22787j = num;
        return this;
    }

    public Integer getSmallIcon() {
        return this.f22797t;
    }

    public XGPushNotificationBuilder setSmallIcon(Integer num) {
        this.f22797t = num;
        return this;
    }

    public Bitmap getLargeIcon() {
        return this.f22798u;
    }

    public XGPushNotificationBuilder setLargeIcon(Bitmap bitmap) {
        this.f22798u = bitmap;
        return this;
    }

    public XGPushNotificationBuilder setNotificationLargeIcon(int i) {
        this.f22799v = Integer.valueOf(i);
        return this;
    }

    public Integer getNotificationLargeIcon() {
        return this.f22799v;
    }

    public int getIconLevel() {
        return this.f22788k.intValue();
    }

    public XGPushNotificationBuilder setIconLevel(int i) {
        this.f22788k = Integer.valueOf(i);
        return this;
    }

    public int getLedARGB() {
        return this.f22789l.intValue();
    }

    public XGPushNotificationBuilder setLedARGB(int i) {
        this.f22789l = Integer.valueOf(i);
        return this;
    }

    public int getLedOffMS() {
        return this.f22790m.intValue();
    }

    public XGPushNotificationBuilder setLedOffMS(int i) {
        this.f22790m = Integer.valueOf(i);
        return this;
    }

    public int getLedOnMS() {
        return this.f22791n.intValue();
    }

    public XGPushNotificationBuilder setLedOnMS(int i) {
        this.f22791n = Integer.valueOf(i);
        return this;
    }

    public int getNumber() {
        return this.f22792o.intValue();
    }

    public XGPushNotificationBuilder setNumber(int i) {
        this.f22792o = Integer.valueOf(i);
        return this;
    }

    public Uri getSound() {
        return this.f22793p;
    }

    public XGPushNotificationBuilder setSound(Uri uri) {
        this.f22793p = uri;
        return this;
    }

    public CharSequence getTickerText() {
        return this.f22794q;
    }

    public XGPushNotificationBuilder setTickerText(CharSequence charSequence) {
        this.f22794q = charSequence;
        return this;
    }

    public long[] getVibrate() {
        return this.f22795r;
    }

    public XGPushNotificationBuilder setVibrate(long[] jArr) {
        this.f22795r = jArr;
        return this;
    }

    public long getWhen() {
        return this.f22796s.longValue();
    }

    public XGPushNotificationBuilder setWhen(long j) {
        this.f22796s = Long.valueOf(j);
        return this;
    }
}
