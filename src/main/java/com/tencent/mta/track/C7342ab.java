package com.tencent.mta.track;

import android.content.Context;
import android.util.Log;
import android.util.SparseArray;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/* compiled from: ProGuard */
/* renamed from: com.tencent.mta.track.ab */
public abstract class C7342ab implements C7341aa {
    /* renamed from: a */
    private final Context f24865a;
    /* renamed from: b */
    private final Map f24866b = new HashMap();
    /* renamed from: c */
    private final SparseArray f24867c = new SparseArray();

    /* renamed from: a */
    public abstract Class mo35839a();

    /* renamed from: a */
    public abstract String mo35840a(Context context);

    protected C7342ab(Context context) {
        this.f24865a = context;
    }

    /* renamed from: a */
    public boolean mo35837a(String str) {
        return this.f24866b.containsKey(str);
    }

    /* renamed from: b */
    public int mo35838b(String str) {
        return ((Integer) this.f24866b.get(str)).intValue();
    }

    /* renamed from: a */
    public String mo35836a(int i) {
        return (String) this.f24867c.get(i);
    }

    /* renamed from: a */
    private static void m31677a(Class cls, String str, Map map) {
        try {
            Field[] fields = cls.getFields();
            int length = fields.length;
            for (int i = 0; i < length; i++) {
                Field field = fields[i];
                if (Modifier.isStatic(field.getModifiers()) && field.getType() == Integer.TYPE) {
                    String name = field.getName();
                    int i2 = field.getInt(null);
                    if (str != null) {
                        StringBuilder sb = new StringBuilder();
                        sb.append(str);
                        sb.append(":");
                        sb.append(name);
                        name = sb.toString();
                    }
                    map.put(name, Integer.valueOf(i2));
                }
            }
        } catch (IllegalAccessException e) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Can't read built-in id names from ");
            sb2.append(cls.getName());
            Log.e("ResourceReader", sb2.toString(), e);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo35841b() {
        this.f24866b.clear();
        this.f24867c.clear();
        m31677a(mo35839a(), "android", this.f24866b);
        String a = mo35840a(this.f24865a);
        try {
            m31677a(Class.forName(a), null, this.f24866b);
        } catch (ClassNotFoundException unused) {
            StringBuilder sb = new StringBuilder();
            sb.append("Can't load names for Android view ids from '");
            sb.append(a);
            sb.append("', ids by name will not be available in the events editor.");
            String sb2 = sb.toString();
            String str = "ResourceReader";
            Log.w(str, sb2);
            Log.i(str, "You may be missing a Resources class for your package due to your proguard configuration, or you may be using an applicationId in your build that isn't the same as the package declared in your AndroidManifest.xml file.\nIf you're using proguard, you can fix this issue by adding the following to your proguard configuration:\n\n-keep class **.R$* {\n    <fields>;\n}\n\nIf you're not using proguard, or if your proguard configuration already contains the directive above, you can add the following to your AndroidManifest.xml file to explicitly point the StatisticsData library to the appropriate library for your resources class:\n\n<meta-data android:name=\"com.StatisticsData.analytics.android.ResourcePackageName\" android:value=\"YOUR_PACKAGE_NAME\" />\n\nwhere YOUR_PACKAGE_NAME is the same string you use for the \"package\" attribute in your <manifest> tag.");
        }
        for (Entry entry : this.f24866b.entrySet()) {
            this.f24867c.put(((Integer) entry.getValue()).intValue(), entry.getKey());
        }
    }
}
