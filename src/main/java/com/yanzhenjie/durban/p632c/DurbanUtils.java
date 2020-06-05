package com.yanzhenjie.durban.p632c;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build.VERSION;
import java.util.Locale;

/* renamed from: com.yanzhenjie.durban.c.c */
public class DurbanUtils {
    /* renamed from: a */
    public static Context m33821a(Context context, Locale locale) {
        Resources resources = context.getResources();
        Configuration configuration = resources.getConfiguration();
        if (VERSION.SDK_INT >= 24) {
            configuration.setLocale(locale);
            return context.createConfigurationContext(configuration);
        }
        configuration.locale = locale;
        resources.updateConfiguration(configuration, resources.getDisplayMetrics());
        return context;
    }
}
