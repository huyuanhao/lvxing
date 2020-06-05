package com.tencent.p611xg.trydyload_api;

import com.tencent.dynamicbundle.reflect.RefClass;
import com.tencent.dynamicbundle.reflect.RefStaticMethod;

/* renamed from: com.tencent.xg.trydyload_api.TryDyLoaderRefMapping */
public class TryDyLoaderRefMapping {
    public static Class<?> TYPE;
    public static RefStaticMethod<Void> doSomething;

    public static void init(ClassLoader classLoader) {
        TYPE = RefClass.load(TryDyLoaderRefMapping.class, "com.tencent.xg.trydyloadbundle.TryDyLoaderImpl", classLoader);
    }
}
