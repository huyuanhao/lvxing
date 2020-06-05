package com.qiyukf.unicorn.apicloud;

import android.content.Context;
import android.content.res.Resources;
import com.tencent.android.tpush.SettingsContentProvider;
import java.lang.reflect.Field;

public class QYResUtils {
    private static String sPkgName;
    private static Resources sRes;

    public static int anim(String str) {
        return sRes.getIdentifier(str, "anim", sPkgName);
    }

    public static int animator(String str) {
        return sRes.getIdentifier(str, "animator", sPkgName);
    }

    public static int array(String str) {
        return sRes.getIdentifier(str, "array", sPkgName);
    }

    public static int attr(String str) {
        return sRes.getIdentifier(str, "attr", sPkgName);
    }

    public static int color(String str) {
        return sRes.getIdentifier(str, "color", sPkgName);
    }

    public static int dimen(String str) {
        return sRes.getIdentifier(str, "dimen", sPkgName);
    }

    public static int drawable(String str) {
        return sRes.getIdentifier(str, "drawable", sPkgName);
    }

    private static Object getResId(String str, String str2) {
        Field[] fields;
        StringBuilder sb = new StringBuilder();
        sb.append(sPkgName);
        sb.append(".R");
        try {
            Class[] classes = Class.forName(sb.toString()).getClasses();
            int length = classes.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    break;
                }
                Class cls = classes[i];
                if (cls.getSimpleName().equals(str2)) {
                    for (Field field : cls.getFields()) {
                        if (field.getName().equals(str)) {
                            return field.get(null);
                        }
                    }
                } else {
                    i++;
                }
            }
        } catch (Exception unused) {
        }
        return null;
    }

    /* renamed from: id */
    public static int m23912id(String str) {
        return sRes.getIdentifier(str, "id", sPkgName);
    }

    public static void init(Context context) {
        sRes = context.getResources();
        sPkgName = context.getPackageName();
    }

    public static int layout(String str) {
        return sRes.getIdentifier(str, "layout", sPkgName);
    }

    public static int raw(String str) {
        return sRes.getIdentifier(str, "raw", sPkgName);
    }

    public static int string(String str) {
        return sRes.getIdentifier(str, SettingsContentProvider.STRING_TYPE, sPkgName);
    }

    public static int style(String str) {
        return sRes.getIdentifier(str, "style", sPkgName);
    }

    public static int styleable(String str) {
        Object resId = getResId(str, "styleable");
        if (resId != null) {
            return ((Integer) resId).intValue();
        }
        return 0;
    }

    public static int[] styleableArray(String str) {
        Object resId = getResId(str, "styleable");
        if (resId != null) {
            return (int[]) resId;
        }
        return new int[]{0};
    }

    public static int xml(String str) {
        return sRes.getIdentifier(str, "xml", sPkgName);
    }
}
