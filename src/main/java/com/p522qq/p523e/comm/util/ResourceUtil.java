package com.p522qq.p523e.comm.util;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import com.tencent.android.tpush.SettingsContentProvider;
import java.lang.reflect.Field;

/* renamed from: com.qq.e.comm.util.ResourceUtil */
public class ResourceUtil {
    public static int getColorId(Context context, String str) {
        if (context != null && !TextUtils.isEmpty(str)) {
            Resources resources = context.getResources();
            if (resources != null) {
                return resources.getIdentifier(str, "color", context.getPackageName());
            }
        }
        return -1;
    }

    public static int getDrawableId(Context context, String str) {
        if (context != null && !TextUtils.isEmpty(str)) {
            Resources resources = context.getResources();
            if (resources != null) {
                return resources.getIdentifier(str, "drawable", context.getPackageName());
            }
        }
        return -1;
    }

    public static int getId(Context context, String str) {
        if (context != null && !TextUtils.isEmpty(str)) {
            Resources resources = context.getResources();
            if (resources != null) {
                return resources.getIdentifier(str, "id", context.getPackageName());
            }
        }
        return -1;
    }

    public static int getLayoutId(Context context, String str) {
        if (context != null && !TextUtils.isEmpty(str)) {
            Resources resources = context.getResources();
            if (resources != null) {
                return resources.getIdentifier(str, "layout", context.getPackageName());
            }
        }
        return -1;
    }

    public static int getStringId(Context context, String str) {
        if (context != null && !TextUtils.isEmpty(str)) {
            Resources resources = context.getResources();
            if (resources != null) {
                return resources.getIdentifier(str, SettingsContentProvider.STRING_TYPE, context.getPackageName());
            }
        }
        return -1;
    }

    public static int getStyleId(Context context, String str) {
        if (context != null && !TextUtils.isEmpty(str)) {
            Resources resources = context.getResources();
            if (resources != null) {
                return resources.getIdentifier(str, "style", context.getPackageName());
            }
        }
        return -1;
    }

    public static int getStyleableFieldId(Context context, String str, String str2) {
        Class[] classes;
        Field[] fields;
        StringBuilder sb = new StringBuilder();
        sb.append(context.getPackageName());
        sb.append(".R");
        String sb2 = sb.toString();
        String str3 = "styleable";
        StringBuilder sb3 = new StringBuilder();
        sb3.append(str);
        sb3.append("_");
        sb3.append(str2);
        String sb4 = sb3.toString();
        try {
            for (Class cls : Class.forName(sb2).getClasses()) {
                if (cls.getSimpleName().equals(str3)) {
                    for (Field field : cls.getFields()) {
                        if (field.getName().equals(sb4)) {
                            return ((Integer) field.get(null)).intValue();
                        }
                    }
                    continue;
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return 0;
    }

    public static int[] getStyleableIntArray(Context context, String str) {
        Field[] fields;
        try {
            StringBuilder sb = new StringBuilder();
            sb.append(context.getPackageName());
            sb.append(".R$styleable");
            for (Field field : Class.forName(sb.toString()).getFields()) {
                if (field.getName().equals(str)) {
                    return (int[]) field.get(null);
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return null;
    }
}
