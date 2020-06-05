package com.bytedance.sdk.openadsdk.p190h.p197g;

import android.content.Context;
import com.bytedance.sdk.openadsdk.core.InternalContainer;
import java.lang.reflect.Method;

/* renamed from: com.bytedance.sdk.openadsdk.h.g.c */
public class StorageList {
    /* renamed from: e */
    private static StorageList f8911e;
    /* renamed from: a */
    private Context f8912a;
    /* renamed from: b */
    private Object f8913b;
    /* renamed from: c */
    private Method f8914c;
    /* renamed from: d */
    private Method f8915d;

    /* renamed from: a */
    public static StorageList m11649a() {
        if (f8911e == null) {
            synchronized (StorageList.class) {
                if (f8911e == null) {
                    f8911e = new StorageList();
                }
            }
        }
        return f8911e;
    }

    private StorageList() {
        this.f8912a = null;
        this.f8913b = null;
        this.f8914c = null;
        this.f8915d = null;
        this.f8912a = InternalContainer.m10059a();
        Context context = this.f8912a;
        if (context != null) {
            this.f8913b = context.getSystemService("storage");
            try {
                this.f8914c = this.f8913b.getClass().getMethod("getVolumeList", new Class[0]);
                this.f8915d = this.f8913b.getClass().getMethod("getVolumeState", new Class[]{String.class});
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* renamed from: b */
    public boolean mo16785b() {
        Object obj = this.f8913b;
        if (obj != null) {
            Method method = this.f8914c;
            if (!(method == null || this.f8915d == null)) {
                try {
                    Object[] objArr = (Object[]) method.invoke(obj, new Object[0]);
                    if (objArr != null) {
                        if (objArr.length != 0) {
                            Method method2 = objArr[0].getClass().getMethod("getPath", new Class[0]);
                            Method method3 = objArr[0].getClass().getMethod("isEmulated", new Class[0]);
                            if (method2 != null) {
                                if (method3 != null) {
                                    for (Object obj2 : objArr) {
                                        if (((Boolean) method3.invoke(obj2, new Object[0])).booleanValue()) {
                                            if (this.f8915d.invoke(this.f8913b, new Object[]{(String) method2.invoke(obj2, new Object[0])}).equals("mounted")) {
                                                return true;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                    return false;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return false;
    }
}
