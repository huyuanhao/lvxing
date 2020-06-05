package com.qiyukf.unicorn.apicloud;

import android.app.Activity;

public class APICloudClient {
    private static Activity serviceActivity;

    public static Activity getServiceActivity() {
        return serviceActivity;
    }

    public static void onActivityCreate(Activity activity) {
        serviceActivity = activity;
    }

    public static void onActivityDestroy() {
        serviceActivity = null;
    }
}
