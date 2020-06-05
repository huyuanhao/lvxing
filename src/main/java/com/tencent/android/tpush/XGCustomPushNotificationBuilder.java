package com.tencent.android.tpush;

import android.app.Notification;
import android.content.Context;
import android.graphics.Bitmap;
import android.widget.RemoteViews;
import com.tencent.android.tpush.common.C6900b;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.json.JSONObject;

/* compiled from: ProGuard */
public class XGCustomPushNotificationBuilder extends XGPushNotificationBuilder {
    /* renamed from: A */
    private Integer f22623A = null;
    /* renamed from: B */
    private Integer f22624B = null;
    /* renamed from: C */
    private Integer f22625C = null;
    /* renamed from: D */
    private Integer f22626D = null;
    /* renamed from: E */
    private Integer f22627E = null;
    /* renamed from: F */
    private Bitmap f22628F = null;
    /* renamed from: y */
    private Integer f22629y = null;
    /* renamed from: z */
    private Integer f22630z = null;

    public String getType() {
        return "custom";
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo32769a(JSONObject jSONObject) {
        C6900b.m29457a(jSONObject, "layoutId", (Object) this.f22629y);
        C6900b.m29457a(jSONObject, "layoutIconId", (Object) this.f22630z);
        C6900b.m29457a(jSONObject, "layoutTitleId", (Object) this.f22623A);
        C6900b.m29457a(jSONObject, "layoutTextId", (Object) this.f22624B);
        C6900b.m29457a(jSONObject, "layoutIconDrawableId", (Object) this.f22625C);
        C6900b.m29457a(jSONObject, "statusBarIconDrawableId", (Object) this.f22626D);
        C6900b.m29457a(jSONObject, "layoutTimeId", (Object) this.f22627E);
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo32770b(JSONObject jSONObject) {
        this.f22629y = (Integer) C6900b.m29458b(jSONObject, "layoutId", null);
        this.f22630z = (Integer) C6900b.m29458b(jSONObject, "layoutIconId", null);
        this.f22623A = (Integer) C6900b.m29458b(jSONObject, "layoutTitleId", null);
        this.f22624B = (Integer) C6900b.m29458b(jSONObject, "layoutTextId", null);
        this.f22625C = (Integer) C6900b.m29458b(jSONObject, "layoutIconDrawableId", null);
        this.f22626D = (Integer) C6900b.m29458b(jSONObject, "statusBarIconDrawableId", null);
        this.f22627E = (Integer) C6900b.m29458b(jSONObject, "layoutTimeId", null);
    }

    public Notification buildNotification(Context context) {
        if (this.f22629y == null) {
            return mo32904a(context);
        }
        RemoteViews remoteViews = new RemoteViews(context.getPackageName(), this.f22629y.intValue());
        Integer num = this.f22623A;
        if (num != null) {
            remoteViews.setTextViewText(num.intValue(), getTitle(context));
        }
        Integer num2 = this.f22624B;
        if (num2 != null) {
            remoteViews.setTextViewText(num2.intValue(), this.f22794q);
        }
        Integer num3 = this.f22630z;
        if (num3 != null) {
            remoteViews.setImageViewResource(num3.intValue(), this.f22625C.intValue());
        }
        if (this.f22628F != null) {
            remoteViews.setImageViewBitmap(this.f22630z.intValue(), this.f22628F);
        }
        Integer num4 = this.f22626D;
        if (num4 != null) {
            remoteViews.setTextViewText(num4.intValue(), getTitle(context));
        }
        if (this.f22627E != null) {
            remoteViews.setTextViewText(this.f22627E.intValue(), String.valueOf(new SimpleDateFormat("HH:mm").format(new Date(System.currentTimeMillis()))));
        }
        this.f22782e = remoteViews;
        return mo32904a(context);
    }

    public int getLayoutId() {
        return this.f22629y.intValue();
    }

    public XGCustomPushNotificationBuilder setLayoutId(int i) {
        this.f22629y = Integer.valueOf(i);
        return this;
    }

    public Integer getLayoutIconId() {
        return this.f22630z;
    }

    public XGCustomPushNotificationBuilder setLayoutIconId(int i) {
        this.f22630z = Integer.valueOf(i);
        return this;
    }

    public int getLayoutTitleId() {
        return this.f22623A.intValue();
    }

    public XGCustomPushNotificationBuilder setLayoutTitleId(int i) {
        this.f22623A = Integer.valueOf(i);
        return this;
    }

    public int getLayoutTextId() {
        return this.f22624B.intValue();
    }

    public int getLayoutTimeId() {
        return this.f22627E.intValue();
    }

    public XGCustomPushNotificationBuilder setLayoutTextId(int i) {
        this.f22624B = Integer.valueOf(i);
        return this;
    }

    public XGCustomPushNotificationBuilder setLayoutTimeId(int i) {
        this.f22627E = Integer.valueOf(i);
        return this;
    }

    public int getLayoutIconDrawableId() {
        return this.f22625C.intValue();
    }

    public XGCustomPushNotificationBuilder setLayoutIconDrawableId(int i) {
        this.f22625C = Integer.valueOf(i);
        return this;
    }

    public XGCustomPushNotificationBuilder setLayoutIconDrawableBmp(Bitmap bitmap) {
        this.f22628F = bitmap;
        return this;
    }
}
