package com.tencent.android.tpush.p581c;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import com.tencent.android.tpush.NotificationAction;
import com.tencent.android.tpush.XGBasicPushNotificationBuilder;
import com.tencent.android.tpush.XGCustomPushNotificationBuilder;
import com.tencent.android.tpush.XGPushActivity;
import com.tencent.android.tpush.XGPushConfig;
import com.tencent.android.tpush.XGPushNotificationBuilder;
import com.tencent.android.tpush.common.C6900b;
import com.tencent.android.tpush.common.C6908h;
import com.tencent.android.tpush.common.C6914l;
import com.tencent.android.tpush.common.Constants;
import com.tencent.android.tpush.common.MessageKey;
import com.tencent.android.tpush.p580b.C6864a;
import com.tencent.android.tpush.p581c.C6873e.C6874a;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: ProGuard */
/* renamed from: com.tencent.android.tpush.c.b */
public class C6868b {
    /* renamed from: a */
    private static volatile BroadcastReceiver f22863a;

    /* compiled from: ProGuard */
    /* renamed from: com.tencent.android.tpush.c.b$2 */
    static /* synthetic */ class C68702 {
        /* renamed from: a */
        static final /* synthetic */ int[] f22864a = new int[NotificationAction.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(12:0|1|2|3|4|5|6|7|8|9|10|12) */
        /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
            return;
     */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x002a */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0035 */
        static {
            /*
            com.tencent.android.tpush.NotificationAction[] r0 = com.tencent.android.tpush.NotificationAction.values()
            int r0 = r0.length
            int[] r0 = new int[r0]
            f22864a = r0
            int[] r0 = f22864a     // Catch:{ NoSuchFieldError -> 0x0014 }
            com.tencent.android.tpush.NotificationAction r1 = com.tencent.android.tpush.NotificationAction.activity     // Catch:{ NoSuchFieldError -> 0x0014 }
            int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
            r2 = 1
            r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0014 }
        L_0x0014:
            int[] r0 = f22864a     // Catch:{ NoSuchFieldError -> 0x001f }
            com.tencent.android.tpush.NotificationAction r1 = com.tencent.android.tpush.NotificationAction.url     // Catch:{ NoSuchFieldError -> 0x001f }
            int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
            r2 = 2
            r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001f }
        L_0x001f:
            int[] r0 = f22864a     // Catch:{ NoSuchFieldError -> 0x002a }
            com.tencent.android.tpush.NotificationAction r1 = com.tencent.android.tpush.NotificationAction.intent     // Catch:{ NoSuchFieldError -> 0x002a }
            int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002a }
            r2 = 3
            r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002a }
        L_0x002a:
            int[] r0 = f22864a     // Catch:{ NoSuchFieldError -> 0x0035 }
            com.tencent.android.tpush.NotificationAction r1 = com.tencent.android.tpush.NotificationAction.intent_with_action     // Catch:{ NoSuchFieldError -> 0x0035 }
            int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0035 }
            r2 = 4
            r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0035 }
        L_0x0035:
            int[] r0 = f22864a     // Catch:{ NoSuchFieldError -> 0x0040 }
            com.tencent.android.tpush.NotificationAction r1 = com.tencent.android.tpush.NotificationAction.action_package     // Catch:{ NoSuchFieldError -> 0x0040 }
            int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0040 }
            r2 = 5
            r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0040 }
        L_0x0040:
            return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.android.tpush.p581c.C6868b.C68702.m51867clinit():void");
        }
    }

    /* renamed from: a */
    private static String m29320a(int i) {
        StringBuilder sb = new StringBuilder();
        sb.append("TPUSH_NOTIF_BUILDID_");
        sb.append(String.valueOf(i));
        return sb.toString();
    }

    /* renamed from: a */
    public static synchronized XGPushNotificationBuilder m29318a(Context context) {
        XGPushNotificationBuilder flags;
        synchronized (C6868b.class) {
            flags = new XGBasicPushNotificationBuilder().setFlags(16);
        }
        return flags;
    }

    /* renamed from: a */
    public static void m29321a(Context context, int i, XGPushNotificationBuilder xGPushNotificationBuilder) {
        String a = m29320a(i);
        JSONObject jSONObject = new JSONObject();
        xGPushNotificationBuilder.encode(jSONObject);
        JSONObject jSONObject2 = new JSONObject();
        C6900b.m29457a(jSONObject2, xGPushNotificationBuilder.getType(), (Object) jSONObject.toString());
        C6908h.m29487b(context, a, jSONObject2.toString());
    }

    /* renamed from: a */
    public static XGPushNotificationBuilder m29319a(Context context, int i) {
        XGPushNotificationBuilder xGCustomPushNotificationBuilder;
        String string;
        String str = "custom";
        String str2 = XGPushNotificationBuilder.BASIC_NOTIFICATION_BUILDER_TYPE;
        XGPushNotificationBuilder xGPushNotificationBuilder = null;
        if (context == null) {
            return null;
        }
        String a = C6908h.m29483a(context, m29320a(i), (String) null);
        if (a != null) {
            try {
                JSONObject jSONObject = new JSONObject(a);
                if (jSONObject.has(str2)) {
                    xGCustomPushNotificationBuilder = new XGBasicPushNotificationBuilder();
                    try {
                        string = jSONObject.getString(str2);
                    } catch (JSONException e) {
                        e = e;
                        xGPushNotificationBuilder = xGCustomPushNotificationBuilder;
                    }
                } else if (!jSONObject.has(str)) {
                    return null;
                } else {
                    xGCustomPushNotificationBuilder = new XGCustomPushNotificationBuilder();
                    string = jSONObject.getString(str);
                }
                xGPushNotificationBuilder = xGCustomPushNotificationBuilder;
                xGPushNotificationBuilder.decode(string);
            } catch (JSONException e2) {
                e = e2;
            }
        }
        return xGPushNotificationBuilder;
        C6864a.m29302d(Constants.LogTag, "", e);
        return xGPushNotificationBuilder;
    }

    /* renamed from: b */
    public static String m29325b(Context context) {
        try {
            Intent intent = new Intent("android.intent.action.MAIN", null);
            intent.addCategory("android.intent.category.LAUNCHER");
            intent.setPackage(context.getPackageName());
            for (ResolveInfo resolveInfo : context.getPackageManager().queryIntentActivities(intent, 0)) {
                if (resolveInfo.activityInfo != null) {
                    return resolveInfo.activityInfo.name;
                }
            }
        } catch (Throwable th) {
            C6864a.m29302d("MessageHelper", "get Activity error", th);
        }
        return null;
    }

    /* renamed from: a */
    public static Intent m29317a(Context context, C6874a aVar, boolean z, C6881g gVar) {
        Intent intent;
        int i = C68702.f22864a[NotificationAction.getNotificationAction(aVar.f22889a).ordinal()];
        String str = MessageKey.MSG_BUSI_MSG_ID;
        String str2 = MessageKey.MSG_ID;
        String str3 = Constants.FLAG_ACTION_TYPE;
        String str4 = Constants.FLAG_ACTIVITY_NAME;
        String str5 = Constants.ACTION_INTERNAL_PUSH_MESSAGE;
        String str6 = Constants.FLAG_NOTIFICATION_ACTION_TYPE;
        if (i == 1) {
            Intent intent2 = new Intent(str5);
            String str7 = aVar.f22890b;
            if (C6914l.m29521c(str7)) {
                str7 = m29325b(context);
            }
            int i2 = 538968064;
            if (aVar.f22891c == null || aVar.f22891c.f22899a <= 0) {
                if (z) {
                    i2 = 268435456;
                }
                intent2.addFlags(i2);
                intent2.setFlags(67239936);
            } else {
                intent2.setFlags(aVar.f22891c.f22899a);
            }
            intent2.putExtra(str4, str7);
            intent2.putExtra(str2, gVar.mo33052b());
            intent2.putExtra(str, gVar.mo33054d());
            intent2.putExtra(str6, NotificationAction.activity.getType());
            intent2.putExtra(str3, NotificationAction.activity.getType());
            intent2.setClass(context.getApplicationContext(), XGPushActivity.class);
            intent = intent2;
        } else if (i == 2) {
            intent = new Intent(str5);
            intent.putExtra(str4, aVar.f22894f);
            intent.putExtra(str3, aVar.f22889a);
            intent.putExtra(str6, NotificationAction.url.getType());
            intent.setClass(context.getApplicationContext(), XGPushActivity.class);
        } else if (i == 3 || i == 4) {
            intent = new Intent(str5);
            intent.putExtra(str4, aVar.f22892d);
            intent.putExtra(str3, aVar.f22889a);
            if (aVar.f22889a == NotificationAction.intent_with_action.getType()) {
                intent.putExtra(str6, NotificationAction.intent_with_action.getType());
            } else {
                intent.putExtra(str6, NotificationAction.intent.getType());
            }
            intent.putExtra(str2, gVar.mo33052b());
            intent.putExtra(str, gVar.mo33054d());
            intent.setClass(context.getApplicationContext(), XGPushActivity.class);
        } else if (i != 5) {
            StringBuilder sb = new StringBuilder();
            sb.append("unkown type");
            sb.append(aVar.f22889a);
            C6864a.m29308i("MessageHelper", sb.toString());
            intent = null;
        } else {
            intent = new Intent(str5);
            String str8 = aVar.f22896h;
            if (C6914l.m29521c(str8)) {
                return intent;
            }
            intent.putExtra(str3, aVar.f22889a);
            intent.putExtra(Constants.FLAG_PACKAGE_DOWNLOAD_URL, aVar.f22898j);
            intent.putExtra(Constants.FLAG_PACKAGE_NAME, str8);
            intent.putExtra(str4, str8);
            intent.putExtra(str6, NotificationAction.action_package.getType());
            intent.setClass(context.getApplicationContext(), XGPushActivity.class);
        }
        if (intent != null) {
            intent.putExtra(Constants.FLAG_ACTION_CONFIRM, aVar.f22895g);
        }
        return intent;
    }

    /* JADX WARNING: Removed duplicated region for block: B:132:0x045d  */
    /* JADX WARNING: Removed duplicated region for block: B:133:0x0461  */
    /* renamed from: a */
    public static void m29322a(android.content.Context r18, com.tencent.android.tpush.p581c.C6881g r19) {
        /*
        r0 = r18
        com.tencent.android.tpush.c.a r1 = r19.mo33057g()
        com.tencent.android.tpush.c.e r1 = (com.tencent.android.tpush.p581c.C6873e) r1
        com.tencent.android.tpush.c.e$a r2 = r1.mo33034m()
        int r3 = r1.mo33029h()
        com.tencent.android.tpush.XGPushNotificationBuilder r3 = m29319a(r0, r3)
        r4 = 16
        java.lang.String r5 = "notification_icon"
        java.lang.String r6 = "drawable"
        r7 = 1
        if (r3 == 0) goto L_0x0023
        int r8 = r1.mo33041t()
        if (r8 != r7) goto L_0x017d
    L_0x0023:
        if (r3 != 0) goto L_0x0029
        com.tencent.android.tpush.XGPushNotificationBuilder r3 = com.tencent.android.tpush.XGPushManager.getDefaultNotificationBuilder(r18)
    L_0x0029:
        if (r3 != 0) goto L_0x002f
        com.tencent.android.tpush.XGPushNotificationBuilder r3 = m29318a(r18)
    L_0x002f:
        int r8 = r1.mo33032k()
        if (r8 == 0) goto L_0x0038
        r3.setFlags(r4)
    L_0x0038:
        int r8 = r1.mo33030i()
        if (r8 == 0) goto L_0x0088
        java.lang.String r8 = r1.mo33037p()
        boolean r8 = android.text.TextUtils.isEmpty(r8)
        if (r8 != 0) goto L_0x0085
        android.content.res.Resources r8 = r18.getResources()
        java.lang.String r9 = r1.mo33037p()
        java.lang.String r10 = r18.getPackageName()
        java.lang.String r11 = "raw"
        int r8 = r8.getIdentifier(r9, r11, r10)
        if (r8 <= 0) goto L_0x0081
        java.lang.StringBuilder r9 = new java.lang.StringBuilder
        r9.<init>()
        java.lang.String r10 = "android.resource://"
        r9.append(r10)
        java.lang.String r10 = r18.getPackageName()
        r9.append(r10)
        java.lang.String r10 = "/"
        r9.append(r10)
        r9.append(r8)
        java.lang.String r8 = r9.toString()
        android.net.Uri r8 = android.net.Uri.parse(r8)
        r3.setSound(r8)
        goto L_0x0088
    L_0x0081:
        r3.setDefaults(r7)
        goto L_0x0088
    L_0x0085:
        r3.setDefaults(r7)
    L_0x0088:
        int r8 = r1.mo33031j()
        if (r8 == 0) goto L_0x0092
        r8 = 2
        r3.setDefaults(r8)
    L_0x0092:
        int r8 = r1.mo33036o()
        if (r8 == 0) goto L_0x009b
        r3.setFlags(r7)
    L_0x009b:
        java.lang.String r8 = r1.mo33039r()
        if (r8 == 0) goto L_0x00e1
        boolean r9 = android.text.TextUtils.isEmpty(r8)
        if (r9 != 0) goto L_0x00e1
        android.content.res.Resources r9 = r18.getResources()
        java.lang.String r10 = r18.getPackageName()
        int r8 = r9.getIdentifier(r8, r6, r10)
        if (r8 <= 0) goto L_0x00bd
        java.lang.Integer r8 = java.lang.Integer.valueOf(r8)
        r3.setSmallIcon(r8)
        goto L_0x010a
    L_0x00bd:
        android.content.res.Resources r8 = r18.getResources()
        java.lang.String r9 = r18.getPackageName()
        int r8 = r8.getIdentifier(r5, r6, r9)
        if (r8 <= 0) goto L_0x00d3
        java.lang.Integer r8 = java.lang.Integer.valueOf(r8)
        r3.setSmallIcon(r8)
        goto L_0x010a
    L_0x00d3:
        android.content.pm.ApplicationInfo r8 = r18.getApplicationInfo()
        int r8 = r8.icon
        java.lang.Integer r8 = java.lang.Integer.valueOf(r8)
        r3.setSmallIcon(r8)
        goto L_0x010a
    L_0x00e1:
        java.lang.Integer r8 = r3.getSmallIcon()
        if (r8 != 0) goto L_0x010a
        android.content.res.Resources r8 = r18.getResources()
        java.lang.String r9 = r18.getPackageName()
        int r8 = r8.getIdentifier(r5, r6, r9)
        if (r8 <= 0) goto L_0x00fd
        java.lang.Integer r8 = java.lang.Integer.valueOf(r8)
        r3.setSmallIcon(r8)
        goto L_0x010a
    L_0x00fd:
        android.content.pm.ApplicationInfo r8 = r18.getApplicationInfo()
        int r8 = r8.icon
        java.lang.Integer r8 = java.lang.Integer.valueOf(r8)
        r3.setSmallIcon(r8)
    L_0x010a:
        int r8 = r1.mo33040s()
        java.lang.String r9 = r1.mo33038q()
        r10 = 0
        boolean r11 = r3 instanceof com.tencent.android.tpush.XGCustomPushNotificationBuilder
        if (r11 == 0) goto L_0x011e
        r10 = r3
        com.tencent.android.tpush.XGCustomPushNotificationBuilder r10 = (com.tencent.android.tpush.XGCustomPushNotificationBuilder) r10
        java.lang.Integer r10 = r10.getLayoutIconId()
    L_0x011e:
        if (r9 == 0) goto L_0x0160
        boolean r11 = android.text.TextUtils.isEmpty(r9)
        if (r11 != 0) goto L_0x0160
        if (r8 > 0) goto L_0x015c
        android.content.res.Resources r8 = r18.getResources()
        java.lang.String r11 = r18.getPackageName()
        int r8 = r8.getIdentifier(r9, r6, r11)
        if (r8 <= 0) goto L_0x014a
        android.content.res.Resources r9 = r18.getResources()
        android.graphics.Bitmap r9 = android.graphics.BitmapFactory.decodeResource(r9, r8)
        r3.setLargeIcon(r9)
        if (r10 == 0) goto L_0x017d
        r9 = r3
        com.tencent.android.tpush.XGCustomPushNotificationBuilder r9 = (com.tencent.android.tpush.XGCustomPushNotificationBuilder) r9
        r9.setLayoutIconDrawableId(r8)
        goto L_0x017d
    L_0x014a:
        android.content.res.Resources r8 = r18.getResources()
        android.content.pm.ApplicationInfo r9 = r18.getApplicationInfo()
        int r9 = r9.icon
        android.graphics.Bitmap r8 = android.graphics.BitmapFactory.decodeResource(r8, r9)
        r3.setLargeIcon(r8)
        goto L_0x017d
    L_0x015c:
        m29323a(r9, r3, r0, r10)
        goto L_0x017d
    L_0x0160:
        android.graphics.Bitmap r8 = r3.getLargeIcon()
        if (r8 != 0) goto L_0x017d
        java.lang.Integer r8 = r3.getNotificationLargeIcon()
        if (r8 != 0) goto L_0x017d
        android.content.res.Resources r8 = r18.getResources()
        android.content.pm.ApplicationInfo r9 = r18.getApplicationInfo()
        int r9 = r9.icon
        android.graphics.Bitmap r8 = android.graphics.BitmapFactory.decodeResource(r8, r9)
        r3.setLargeIcon(r8)
    L_0x017d:
        int r8 = r1.mo33035n()
        if (r8 <= 0) goto L_0x018e
        int r8 = r1.mo33035n()
        java.lang.Integer r8 = java.lang.Integer.valueOf(r8)
        r3.setIcon(r8)
    L_0x018e:
        java.lang.Integer r8 = r3.getSmallIcon()
        if (r8 != 0) goto L_0x01d4
        android.graphics.Bitmap r8 = r3.getLargeIcon()
        if (r8 != 0) goto L_0x01d4
        java.lang.Integer r8 = r3.getIcon()
        if (r8 != 0) goto L_0x01d4
        android.content.res.Resources r8 = r18.getResources()
        java.lang.String r9 = r18.getPackageName()
        int r5 = r8.getIdentifier(r5, r6, r9)
        if (r5 <= 0) goto L_0x01b6
        java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
        r3.setSmallIcon(r5)
        goto L_0x01c3
    L_0x01b6:
        android.content.pm.ApplicationInfo r5 = r18.getApplicationInfo()
        int r5 = r5.icon
        java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
        r3.setSmallIcon(r5)
    L_0x01c3:
        android.content.res.Resources r5 = r18.getResources()
        android.content.pm.ApplicationInfo r6 = r18.getApplicationInfo()
        int r6 = r6.icon
        android.graphics.Bitmap r5 = android.graphics.BitmapFactory.decodeResource(r5, r6)
        r3.setLargeIcon(r5)
    L_0x01d4:
        java.lang.String r5 = r1.mo33000e()
        int r5 = r5.length()
        r6 = 20
        r8 = 0
        if (r5 < r6) goto L_0x01fe
        java.lang.StringBuilder r5 = new java.lang.StringBuilder
        r5.<init>()
        java.lang.String r9 = r1.mo33000e()
        java.lang.String r6 = r9.substring(r8, r6)
        r5.append(r6)
        java.lang.String r6 = "..."
        r5.append(r6)
        java.lang.String r5 = r5.toString()
        r3.setTitle(r5)
        goto L_0x0205
    L_0x01fe:
        java.lang.String r5 = r1.mo33000e()
        r3.setTitle(r5)
    L_0x0205:
        java.lang.String r5 = r1.mo33001f()
        r3.setTickerText(r5)
        java.lang.String r5 = r1.mo33042u()
        boolean r5 = android.text.TextUtils.isEmpty(r5)
        if (r5 != 0) goto L_0x021d
        java.lang.String r5 = r1.mo33042u()
        r3.setChannelId(r5)
    L_0x021d:
        java.lang.String r5 = r1.mo33043v()
        boolean r5 = android.text.TextUtils.isEmpty(r5)
        if (r5 != 0) goto L_0x022e
        java.lang.String r5 = r1.mo33043v()
        r3.setChannelName(r5)
    L_0x022e:
        java.lang.String r5 = r1.mo33002g()
        boolean r6 = com.tencent.android.tpush.common.C6914l.m29521c(r5)
        if (r6 != 0) goto L_0x0243
        java.lang.String r6 = "{}"
        boolean r5 = r6.equalsIgnoreCase(r5)
        if (r5 != 0) goto L_0x0243
        r5 = r19
        goto L_0x0246
    L_0x0243:
        r5 = r19
        r7 = 0
    L_0x0246:
        android.content.Intent r6 = m29317a(r0, r2, r7, r5)
        java.lang.String r9 = "MessageHelper"
        if (r6 != 0) goto L_0x0254
        java.lang.String r0 = "intent is null"
        com.tencent.android.tpush.p580b.C6864a.m29308i(r9, r0)
        return
    L_0x0254:
        java.lang.String r10 = "custom_content"
        if (r7 == 0) goto L_0x025f
        java.lang.String r7 = r1.mo33002g()
        r6.putExtra(r10, r7)
    L_0x025f:
        java.lang.String r7 = "tag.tpush.MSG"
        java.lang.String r11 = "true"
        r6.putExtra(r7, r11)
        java.lang.String r7 = r1.mo33000e()
        java.lang.String r7 = com.tencent.android.tpush.encrypt.Rijndael.encrypt(r7)
        java.lang.String r11 = "title"
        r6.putExtra(r11, r7)
        java.lang.String r7 = r1.mo33001f()
        java.lang.String r7 = com.tencent.android.tpush.encrypt.Rijndael.encrypt(r7)
        java.lang.String r11 = "content"
        r6.putExtra(r11, r7)
        java.lang.String r7 = r1.mo33002g()
        if (r7 == 0) goto L_0x0291
        java.lang.String r7 = r1.mo33002g()
        java.lang.String r7 = com.tencent.android.tpush.encrypt.Rijndael.encrypt(r7)
        r6.putExtra(r10, r7)
    L_0x0291:
        long r10 = r19.mo33052b()
        java.lang.String r7 = "msgId"
        r6.putExtra(r7, r10)
        long r10 = r19.mo33053c()
        java.lang.String r7 = "accId"
        r6.putExtra(r7, r10)
        long r10 = r19.mo33054d()
        java.lang.String r7 = "busiMsgId"
        r6.putExtra(r7, r10)
        long r10 = r19.mo33055e()
        java.lang.String r5 = "timestamps"
        r6.putExtra(r5, r10)
        long r10 = java.lang.System.currentTimeMillis()
        r12 = 1000(0x3e8, double:4.94E-321)
        long r10 = r10 - r12
        java.lang.StringBuilder r5 = new java.lang.StringBuilder
        r5.<init>()
        java.lang.String r7 = ""
        r5.append(r7)
        r5.append(r10)
        java.lang.String r5 = r5.toString()
        java.lang.String r5 = com.tencent.android.tpush.encrypt.Rijndael.encrypt(r5)
        java.lang.String r7 = "protect"
        r6.putExtra(r7, r5)
        java.lang.String r5 = "notification"
        java.lang.Object r5 = r0.getSystemService(r5)
        android.app.NotificationManager r5 = (android.app.NotificationManager) r5
        int r7 = r1.mo33033l()
        if (r7 > 0) goto L_0x02ec
        int r7 = r1.mo33029h()
        int r7 = m29324b(r0, r7)
    L_0x02ec:
        r10 = -1
        if (r7 != r10) goto L_0x02f2
        r5.cancelAll()
    L_0x02f2:
        java.lang.String r10 = "notifaction_id"
        r6.putExtra(r10, r7)
        r11 = 134217728(0x8000000, float:3.85186E-34)
        com.tencent.android.tpush.c.e$a$a r14 = r2.f22891c
        if (r14 == 0) goto L_0x0307
        com.tencent.android.tpush.c.e$a$a r14 = r2.f22891c
        int r14 = r14.f22900b
        if (r14 <= 0) goto L_0x0307
        com.tencent.android.tpush.c.e$a$a r2 = r2.f22891c
        int r11 = r2.f22900b
    L_0x0307:
        android.content.BroadcastReceiver r2 = f22863a
        java.lang.String r14 = ".APP_PUSH_CANCELLED.RESULT"
        if (r2 != 0) goto L_0x0338
        com.tencent.android.tpush.c.b$1 r2 = new com.tencent.android.tpush.c.b$1
        r2.m51866init()
        f22863a = r2
        android.content.IntentFilter r2 = new android.content.IntentFilter
        r2.<init>()
        java.lang.StringBuilder r15 = new java.lang.StringBuilder
        r15.<init>()
        java.lang.String r8 = r18.getPackageName()
        r15.append(r8)
        r15.append(r14)
        java.lang.String r8 = r15.toString()
        r2.addAction(r8)
        android.content.Context r8 = r18.getApplicationContext()
        android.content.BroadcastReceiver r15 = f22863a
        r8.registerReceiver(r15, r2)
    L_0x0338:
        android.content.Intent r2 = new android.content.Intent
        java.lang.StringBuilder r8 = new java.lang.StringBuilder
        r8.<init>()
        java.lang.String r15 = r18.getPackageName()
        r8.append(r15)
        r8.append(r14)
        java.lang.String r8 = r8.toString()
        r2.<init>(r8)
        java.lang.String r8 = r18.getPackageName()
        java.lang.String r14 = "packName"
        r2.putExtra(r14, r8)
        com.tencent.android.tpush.NotificationAction r8 = com.tencent.android.tpush.NotificationAction.delete
        int r8 = r8.getType()
        java.lang.String r14 = "action"
        r2.putExtra(r14, r8)
        long r14 = java.lang.System.currentTimeMillis()
        long r14 = r14 / r12
        java.lang.String r8 = "clickTime"
        r2.putExtra(r8, r14)
        java.lang.String r8 = r18.getPackageName()
        r2.setPackage(r8)
        r2.putExtras(r6)
        int r8 = android.os.Build.VERSION.SDK_INT
        r12 = 19
        if (r8 != r12) goto L_0x0389
        android.content.Context r8 = r18.getApplicationContext()
        android.app.PendingIntent r8 = android.app.PendingIntent.getActivity(r8, r7, r6, r11)
        r8.cancel()
    L_0x0389:
        android.content.Context r8 = r18.getApplicationContext()
        android.app.PendingIntent r8 = android.app.PendingIntent.getActivity(r8, r7, r6, r11)
        r3.setContentIntent(r8)
        int r8 = android.os.Build.VERSION.SDK_INT
        if (r8 < r4) goto L_0x0443
        android.content.res.Resources r4 = r18.getResources()
        java.lang.String r8 = r18.getPackageName()
        java.lang.String r12 = "xg_notification"
        java.lang.String r13 = "layout"
        int r4 = r4.getIdentifier(r12, r13, r8)
        if (r4 == 0) goto L_0x0443
        android.content.res.Resources r8 = r18.getResources()
        java.lang.String r12 = r18.getPackageName()
        java.lang.String r13 = "id"
        java.lang.String r14 = "xg_notification_icon"
        int r8 = r8.getIdentifier(r14, r13, r12)
        android.content.res.Resources r12 = r18.getResources()
        java.lang.String r14 = r18.getPackageName()
        java.lang.String r15 = "xg_notification_style_title"
        int r12 = r12.getIdentifier(r15, r13, r14)
        android.content.res.Resources r14 = r18.getResources()
        java.lang.String r15 = r18.getPackageName()
        r19 = r10
        java.lang.String r10 = "xg_notification_date"
        int r10 = r14.getIdentifier(r10, r13, r15)
        android.content.res.Resources r14 = r18.getResources()
        java.lang.String r15 = r18.getPackageName()
        r16 = r6
        java.lang.String r6 = "xg_notification_style"
        int r6 = r14.getIdentifier(r6, r13, r15)
        android.content.res.Resources r14 = r18.getResources()
        java.lang.String r15 = r18.getPackageName()
        r17 = r9
        java.lang.String r9 = "xg_notification_style_content"
        int r9 = r14.getIdentifier(r9, r13, r15)
        if (r8 == 0) goto L_0x0449
        if (r12 == 0) goto L_0x0449
        if (r10 == 0) goto L_0x0449
        if (r9 == 0) goto L_0x0449
        android.widget.RemoteViews r13 = new android.widget.RemoteViews
        java.lang.String r14 = r18.getPackageName()
        r13.<init>(r14, r4)
        java.lang.String r4 = r1.mo33000e()
        r13.setTextViewText(r12, r4)
        java.lang.String r4 = r1.mo33001f()
        r13.setTextViewText(r9, r4)
        java.text.SimpleDateFormat r4 = new java.text.SimpleDateFormat
        java.lang.String r9 = "HH:mm"
        r4.<init>(r9)
        java.util.Date r9 = new java.util.Date
        long r14 = java.lang.System.currentTimeMillis()
        r9.<init>(r14)
        java.lang.String r4 = r4.format(r9)
        java.lang.String r4 = java.lang.String.valueOf(r4)
        r13.setTextViewText(r10, r4)
        android.content.pm.ApplicationInfo r4 = r18.getApplicationInfo()
        int r4 = r4.icon
        r13.setImageViewResource(r8, r4)
        r4 = 0
        r13.setViewVisibility(r6, r4)
        r3.setContentView(r13)
        goto L_0x0449
    L_0x0443:
        r16 = r6
        r17 = r9
        r19 = r10
    L_0x0449:
        android.app.Notification r3 = r3.buildNotification(r0)
        android.content.Context r4 = r18.getApplicationContext()
        android.app.PendingIntent r2 = android.app.PendingIntent.getBroadcast(r4, r7, r2, r11)
        r3.deleteIntent = r2
        com.tencent.android.tpush.XGPushNotifactionCallback r2 = com.tencent.android.tpush.XGPushManager.getNotifactionCallback()
        if (r2 != 0) goto L_0x0461
        r5.notify(r7, r3)
        goto L_0x047f
    L_0x0461:
        java.lang.StringBuilder r4 = new java.lang.StringBuilder
        r4.<init>()
        java.lang.String r5 = "call notifactionCallback:"
        r4.append(r5)
        r4.append(r3)
        java.lang.String r4 = r4.toString()
        r5 = r17
        com.tencent.android.tpush.p580b.C6864a.m29303e(r5, r4)
        com.tencent.android.tpush.XGNotifaction r4 = new com.tencent.android.tpush.XGNotifaction
        r4.m51793init(r0, r7, r3, r1)
        r2.handleNotify(r4)
    L_0x047f:
        android.content.Intent r1 = new android.content.Intent
        java.lang.String r2 = "com.tencent.android.tpush.action.FEEDBACK"
        r1.<init>(r2)
        java.lang.String r2 = "TPUSH.ERRORCODE"
        r3 = 0
        r1.putExtra(r2, r3)
        java.lang.String r2 = r18.getPackageName()
        r1.setPackage(r2)
        r2 = r16
        r1.putExtras(r2)
        r2 = 5
        java.lang.String r3 = "TPUSH.FEEDBACK"
        r1.putExtra(r3, r2)
        r2 = r19
        r1.putExtra(r2, r7)
        r0.sendBroadcast(r1)
        return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.android.tpush.p581c.C6868b.m29322a(android.content.Context, com.tencent.android.tpush.c.g):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:64:0x0100 A[SYNTHETIC, Splitter:B:64:0x0100] */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x0108 A[Catch:{ IOException -> 0x0104 }] */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x010d A[Catch:{ IOException -> 0x0104 }] */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x0112 A[Catch:{ IOException -> 0x0104 }] */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x0124 A[SYNTHETIC, Splitter:B:79:0x0124] */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x012c A[Catch:{ IOException -> 0x0128 }] */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x0131 A[Catch:{ IOException -> 0x0128 }] */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x0136 A[Catch:{ IOException -> 0x0128 }] */
    /* renamed from: a */
    private static void m29323a(java.lang.String r7, com.tencent.android.tpush.XGPushNotificationBuilder r8, android.content.Context r9, java.lang.Integer r10) {
        /*
        org.apache.http.params.BasicHttpParams r0 = new org.apache.http.params.BasicHttpParams
        r0.<init>()
        r1 = 3000(0xbb8, float:4.204E-42)
        org.apache.http.params.HttpConnectionParams.setSoTimeout(r0, r1)
        org.apache.http.params.HttpConnectionParams.setConnectionTimeout(r0, r1)
        org.apache.http.impl.client.DefaultHttpClient r1 = new org.apache.http.impl.client.DefaultHttpClient
        r1.<init>(r0)
        r2 = 4000(0xfa0, float:5.605E-42)
        org.apache.http.params.HttpConnectionParams.setConnectionTimeout(r0, r2)
        org.apache.http.params.HttpConnectionParams.setSoTimeout(r0, r2)
        r2 = 4000(0xfa0, double:1.9763E-320)
        org.apache.http.conn.params.ConnManagerParams.setTimeout(r0, r2)
        r0 = 0
        java.net.URL r2 = new java.net.URL     // Catch:{ Exception -> 0x00f7, all -> 0x00f2 }
        r2.<init>(r7)     // Catch:{ Exception -> 0x00f7, all -> 0x00f2 }
        org.apache.http.client.methods.HttpGet r7 = new org.apache.http.client.methods.HttpGet     // Catch:{ Exception -> 0x00f7, all -> 0x00f2 }
        java.net.URI r3 = r2.toURI()     // Catch:{ Exception -> 0x00f7, all -> 0x00f2 }
        r7.<init>(r3)     // Catch:{ Exception -> 0x00f7, all -> 0x00f2 }
        java.lang.String r3 = "X-Online-Host"
        java.lang.String r2 = r2.getHost()     // Catch:{ Exception -> 0x00ef, all -> 0x00ec }
        r7.addHeader(r3, r2)     // Catch:{ Exception -> 0x00ef, all -> 0x00ec }
        org.apache.http.params.HttpParams r2 = r1.getParams()     // Catch:{ Exception -> 0x00ef, all -> 0x00ec }
        java.lang.String r3 = "http.socket.timeout"
        r4 = 20000(0x4e20, float:2.8026E-41)
        java.lang.Integer r5 = java.lang.Integer.valueOf(r4)     // Catch:{ Exception -> 0x00ef, all -> 0x00ec }
        r2.setParameter(r3, r5)     // Catch:{ Exception -> 0x00ef, all -> 0x00ec }
        org.apache.http.params.HttpParams r2 = r1.getParams()     // Catch:{ Exception -> 0x00ef, all -> 0x00ec }
        java.lang.String r3 = "http.connection.timeout"
        java.lang.Integer r4 = java.lang.Integer.valueOf(r4)     // Catch:{ Exception -> 0x00ef, all -> 0x00ec }
        r2.setParameter(r3, r4)     // Catch:{ Exception -> 0x00ef, all -> 0x00ec }
        org.apache.http.HttpResponse r2 = r1.execute(r7)     // Catch:{ Exception -> 0x00ef, all -> 0x00ec }
        org.apache.http.StatusLine r3 = r2.getStatusLine()     // Catch:{ Exception -> 0x00ef, all -> 0x00ec }
        int r3 = r3.getStatusCode()     // Catch:{ Exception -> 0x00ef, all -> 0x00ec }
        r4 = 200(0xc8, float:2.8E-43)
        if (r3 == r4) goto L_0x0084
        android.content.res.Resources r10 = r9.getResources()     // Catch:{ Exception -> 0x00ef, all -> 0x00ec }
        android.content.pm.ApplicationInfo r9 = r9.getApplicationInfo()     // Catch:{ Exception -> 0x00ef, all -> 0x00ec }
        int r9 = r9.icon     // Catch:{ Exception -> 0x00ef, all -> 0x00ec }
        android.graphics.Bitmap r9 = android.graphics.BitmapFactory.decodeResource(r10, r9)     // Catch:{ Exception -> 0x00ef, all -> 0x00ec }
        r8.setLargeIcon(r9)     // Catch:{ Exception -> 0x00ef, all -> 0x00ec }
        r7.abort()     // Catch:{ IOException -> 0x007f }
        org.apache.http.conn.ClientConnectionManager r7 = r1.getConnectionManager()     // Catch:{ IOException -> 0x007f }
        r7.shutdown()     // Catch:{ IOException -> 0x007f }
        goto L_0x0083
    L_0x007f:
        r7 = move-exception
        r7.printStackTrace()
    L_0x0083:
        return
    L_0x0084:
        org.apache.http.HttpEntity r9 = r2.getEntity()     // Catch:{ Exception -> 0x00ef, all -> 0x00ec }
        if (r9 == 0) goto L_0x00d1
        java.io.InputStream r2 = r9.getContent()     // Catch:{ Exception -> 0x00cc, all -> 0x00c6 }
        java.io.ByteArrayOutputStream r3 = new java.io.ByteArrayOutputStream     // Catch:{ Exception -> 0x00c3, all -> 0x00c0 }
        r3.<init>()     // Catch:{ Exception -> 0x00c3, all -> 0x00c0 }
        r0 = 1024(0x400, float:1.435E-42)
        byte[] r0 = new byte[r0]     // Catch:{ Exception -> 0x00be, all -> 0x00bc }
    L_0x0097:
        int r4 = r2.read(r0)     // Catch:{ Exception -> 0x00be, all -> 0x00bc }
        r5 = -1
        r6 = 0
        if (r4 == r5) goto L_0x00a3
        r3.write(r0, r6, r4)     // Catch:{ Exception -> 0x00be, all -> 0x00bc }
        goto L_0x0097
    L_0x00a3:
        byte[] r0 = r3.toByteArray()     // Catch:{ Exception -> 0x00be, all -> 0x00bc }
        byte[] r4 = r3.toByteArray()     // Catch:{ Exception -> 0x00be, all -> 0x00bc }
        int r4 = r4.length     // Catch:{ Exception -> 0x00be, all -> 0x00bc }
        android.graphics.Bitmap r0 = android.graphics.BitmapFactory.decodeByteArray(r0, r6, r4)     // Catch:{ Exception -> 0x00be, all -> 0x00bc }
        r8.setLargeIcon(r0)     // Catch:{ Exception -> 0x00be, all -> 0x00bc }
        if (r10 == 0) goto L_0x00ba
        com.tencent.android.tpush.XGCustomPushNotificationBuilder r8 = (com.tencent.android.tpush.XGCustomPushNotificationBuilder) r8     // Catch:{ Exception -> 0x00be, all -> 0x00bc }
        r8.setLayoutIconDrawableBmp(r0)     // Catch:{ Exception -> 0x00be, all -> 0x00bc }
    L_0x00ba:
        r0 = r2
        goto L_0x00d2
    L_0x00bc:
        r8 = move-exception
        goto L_0x00c9
    L_0x00be:
        r8 = move-exception
        goto L_0x00cf
    L_0x00c0:
        r8 = move-exception
        r3 = r0
        goto L_0x00c9
    L_0x00c3:
        r8 = move-exception
        r3 = r0
        goto L_0x00cf
    L_0x00c6:
        r8 = move-exception
        r2 = r0
        r3 = r2
    L_0x00c9:
        r0 = r9
        goto L_0x0122
    L_0x00cc:
        r8 = move-exception
        r2 = r0
        r3 = r2
    L_0x00cf:
        r0 = r9
        goto L_0x00fb
    L_0x00d1:
        r3 = r0
    L_0x00d2:
        if (r9 == 0) goto L_0x00d7
        r9.consumeContent()     // Catch:{ IOException -> 0x0104 }
    L_0x00d7:
        if (r0 == 0) goto L_0x00dc
        r0.close()     // Catch:{ IOException -> 0x0104 }
    L_0x00dc:
        if (r3 == 0) goto L_0x00e1
        r3.close()     // Catch:{ IOException -> 0x0104 }
    L_0x00e1:
        r7.abort()     // Catch:{ IOException -> 0x0104 }
        org.apache.http.conn.ClientConnectionManager r7 = r1.getConnectionManager()     // Catch:{ IOException -> 0x0104 }
        r7.shutdown()     // Catch:{ IOException -> 0x0104 }
        goto L_0x0120
    L_0x00ec:
        r8 = move-exception
        r2 = r0
        goto L_0x00f5
    L_0x00ef:
        r8 = move-exception
        r2 = r0
        goto L_0x00fa
    L_0x00f2:
        r8 = move-exception
        r7 = r0
        r2 = r7
    L_0x00f5:
        r3 = r2
        goto L_0x0122
    L_0x00f7:
        r8 = move-exception
        r7 = r0
        r2 = r7
    L_0x00fa:
        r3 = r2
    L_0x00fb:
        r8.printStackTrace()     // Catch:{ all -> 0x0121 }
        if (r0 == 0) goto L_0x0106
        r0.consumeContent()     // Catch:{ IOException -> 0x0104 }
        goto L_0x0106
    L_0x0104:
        r7 = move-exception
        goto L_0x011d
    L_0x0106:
        if (r2 == 0) goto L_0x010b
        r2.close()     // Catch:{ IOException -> 0x0104 }
    L_0x010b:
        if (r3 == 0) goto L_0x0110
        r3.close()     // Catch:{ IOException -> 0x0104 }
    L_0x0110:
        if (r7 == 0) goto L_0x0115
        r7.abort()     // Catch:{ IOException -> 0x0104 }
    L_0x0115:
        org.apache.http.conn.ClientConnectionManager r7 = r1.getConnectionManager()     // Catch:{ IOException -> 0x0104 }
        r7.shutdown()     // Catch:{ IOException -> 0x0104 }
        goto L_0x0120
    L_0x011d:
        r7.printStackTrace()
    L_0x0120:
        return
    L_0x0121:
        r8 = move-exception
    L_0x0122:
        if (r0 == 0) goto L_0x012a
        r0.consumeContent()     // Catch:{ IOException -> 0x0128 }
        goto L_0x012a
    L_0x0128:
        r7 = move-exception
        goto L_0x0141
    L_0x012a:
        if (r2 == 0) goto L_0x012f
        r2.close()     // Catch:{ IOException -> 0x0128 }
    L_0x012f:
        if (r3 == 0) goto L_0x0134
        r3.close()     // Catch:{ IOException -> 0x0128 }
    L_0x0134:
        if (r7 == 0) goto L_0x0139
        r7.abort()     // Catch:{ IOException -> 0x0128 }
    L_0x0139:
        org.apache.http.conn.ClientConnectionManager r7 = r1.getConnectionManager()     // Catch:{ IOException -> 0x0128 }
        r7.shutdown()     // Catch:{ IOException -> 0x0128 }
        goto L_0x0144
    L_0x0141:
        r7.printStackTrace()
    L_0x0144:
        throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.android.tpush.p581c.C6868b.m29323a(java.lang.String, com.tencent.android.tpush.XGPushNotificationBuilder, android.content.Context, java.lang.Integer):void");
    }

    /* renamed from: b */
    public static void m29326b(Context context, C6881g gVar) {
        if (gVar.mo33057g() instanceof C6873e) {
            String str = "MessageHelper";
            if (XGPushConfig.enableDebug) {
                StringBuilder sb = new StringBuilder();
                sb.append("Action -> showNotification ");
                sb.append(gVar.mo33056f());
                C6864a.m29305f(str, sb.toString());
            }
            C6873e eVar = (C6873e) gVar.mo33057g();
            if (eVar == null || eVar.mo33034m() == null) {
                C6864a.m29308i(str, "showNotification holder == null || holder.getAction() == null");
            } else {
                m29322a(context, gVar);
            }
        }
    }

    /* renamed from: b */
    private static synchronized int m29324b(Context context, int i) {
        int i2;
        synchronized (C6868b.class) {
            i2 = 0;
            try {
                StringBuilder sb = new StringBuilder();
                sb.append("_XINGE_NOTIF_NUMBER_");
                sb.append(String.valueOf(i));
                String sb2 = sb.toString();
                int a = C6908h.m29480a(context, sb2, 0);
                if (a < 2147483646) {
                    i2 = a;
                }
                C6908h.m29485b(context, sb2, i2 + 1);
            } catch (Throwable th) {
                C6864a.m29302d("MessageHelper", "", th);
            }
        }
        return i2;
    }
}
