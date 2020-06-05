package com.tencent.android.tpush;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import com.tencent.android.tpush.p581c.C6873e;

/* compiled from: ProGuard */
public class XGNotifaction {
    /* renamed from: a */
    private int f22674a = 0;
    /* renamed from: b */
    private Notification f22675b = null;
    /* renamed from: c */
    private String f22676c = null;
    /* renamed from: d */
    private String f22677d = null;
    /* renamed from: e */
    private String f22678e = null;
    /* renamed from: f */
    private Context f22679f = null;

    public XGNotifaction(Context context, int i, Notification notification, C6873e eVar) {
        this.f22679f = context.getApplicationContext();
        this.f22674a = i;
        this.f22675b = notification;
        this.f22676c = eVar.mo33000e();
        this.f22677d = eVar.mo33001f();
        this.f22678e = eVar.mo33002g();
    }

    public void setNotifyId(int i) {
        this.f22674a = i;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("XGNotifaction [notifyId=");
        sb.append(this.f22674a);
        sb.append(", title=");
        sb.append(this.f22676c);
        sb.append(", content=");
        sb.append(this.f22677d);
        sb.append(", customContent=");
        sb.append(this.f22678e);
        sb.append("]");
        return sb.toString();
    }

    public boolean doNotify() {
        if (this.f22675b != null) {
            Context context = this.f22679f;
            if (context != null) {
                NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
                if (notificationManager != null) {
                    notificationManager.notify(this.f22674a, this.f22675b);
                    return true;
                }
            }
        }
        return false;
    }

    public int getNotifyId() {
        return this.f22674a;
    }

    public Notification getNotifaction() {
        return this.f22675b;
    }

    public String getTitle() {
        return this.f22676c;
    }

    public String getContent() {
        return this.f22677d;
    }

    public String getCustomContent() {
        return this.f22678e;
    }
}
