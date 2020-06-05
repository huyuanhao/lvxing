package com.yanzhenjie.permission.runtime;

import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build.VERSION;
import com.yanzhenjie.permission.runtime.p639a.RuntimeOption;
import com.yanzhenjie.permission.runtime.p640b.AllRequest;
import com.yanzhenjie.permission.runtime.p640b.SettingRequest;
import com.yanzhenjie.permission.source.C7847b;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* renamed from: com.yanzhenjie.permission.runtime.h */
public class Runtime implements RuntimeOption {
    /* renamed from: a */
    private static final C7845a f26693a;
    /* renamed from: b */
    private static List<String> f26694b;
    /* renamed from: c */
    private C7847b f26695c;

    /* compiled from: Runtime */
    /* renamed from: com.yanzhenjie.permission.runtime.h$a */
    public interface C7845a {
        /* renamed from: a */
        PermissionRequest mo38071a(C7847b bVar);
    }

    static {
        if (VERSION.SDK_INT >= 23) {
            f26693a = new C7843e();
        } else {
            f26693a = new C7841c();
        }
    }

    public Runtime(C7847b bVar) {
        this.f26695c = bVar;
    }

    /* renamed from: a */
    public PermissionRequest mo38061a(String... strArr) {
        m34122b(strArr);
        return f26693a.mo38071a(this.f26695c).mo38063a(strArr);
    }

    /* renamed from: a */
    public PermissionRequest mo38062a(String[]... strArr) {
        ArrayList arrayList = new ArrayList();
        for (String[] strArr2 : strArr) {
            m34122b(strArr2);
            arrayList.addAll(Arrays.asList(strArr2));
        }
        return mo38061a((String[]) arrayList.toArray(new String[0]));
    }

    /* renamed from: a */
    public SettingRequest mo38060a() {
        return new AllRequest(this.f26695c);
    }

    /* renamed from: b */
    private void m34122b(String... strArr) {
        if (f26694b == null) {
            f26694b = new ArrayList(m34121a(this.f26695c.mo38075a()));
            if (f26694b.contains("android.permission.ADD_VOICEMAIL")) {
                f26694b.add("com.android.voicemail.permission.ADD_VOICEMAIL");
            }
        }
        if (strArr.length != 0) {
            int length = strArr.length;
            int i = 0;
            while (i < length) {
                String str = strArr[i];
                if (f26694b.contains(str)) {
                    i++;
                } else {
                    throw new IllegalStateException(String.format("The permission %1$s is not registered in manifest.xml", new Object[]{str}));
                }
            }
            return;
        }
        throw new IllegalArgumentException("Please enter at least one permission.");
    }

    /* renamed from: a */
    public static List<String> m34121a(Context context) {
        try {
            String[] strArr = context.getPackageManager().getPackageInfo(context.getPackageName(), 4096).requestedPermissions;
            if (strArr != null && strArr.length != 0) {
                return Arrays.asList(strArr);
            }
            throw new IllegalStateException("You did not register any permissions in the manifest.xml.");
        } catch (NameNotFoundException unused) {
            throw new AssertionError("Package name cannot be found.");
        }
    }
}
