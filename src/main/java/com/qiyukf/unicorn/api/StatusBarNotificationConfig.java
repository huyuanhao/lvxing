package com.qiyukf.unicorn.api;

import android.app.Activity;
import java.io.Serializable;

public class StatusBarNotificationConfig implements Serializable {
    public String bigIconUri;
    public int color;
    public String contentTitle;
    public String downTimeBegin;
    public String downTimeEnd;
    public boolean downTimeToggle = false;
    public boolean hideContent = false;
    public Class<? extends Activity> notificationEntrance;
    public int notificationSmallIconId;
    public String notificationSound;
    public boolean ring = true;
    public boolean vibrate = true;
}
