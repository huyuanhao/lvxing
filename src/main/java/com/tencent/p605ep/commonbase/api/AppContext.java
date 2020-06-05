package com.tencent.p605ep.commonbase.api;

import android.app.Activity;
import android.content.Context;

/* renamed from: com.tencent.ep.commonbase.api.AppContext */
public class AppContext {
    public static Context context;
    public static Activity sCurrentActivity;

    public static Context getAppContext() {
        return context.getApplicationContext();
    }

    public static Context getCurrentActivity() {
        return sCurrentActivity;
    }
}
