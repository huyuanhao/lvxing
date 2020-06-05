package com.alibaba.android.arouter.core;

import com.alibaba.android.arouter.base.UniqueKeyTreeMap;
import com.alibaba.android.arouter.facade.model.RouteMeta;
import com.alibaba.android.arouter.facade.template.IInterceptor;
import com.alibaba.android.arouter.facade.template.IProvider;
import com.alibaba.android.arouter.facade.template.IRouteGroup;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* renamed from: com.alibaba.android.arouter.core.b */
class Warehouse {
    /* renamed from: a */
    static Map<String, Class<? extends IRouteGroup>> f2299a = new HashMap();
    /* renamed from: b */
    static Map<String, RouteMeta> f2300b = new HashMap();
    /* renamed from: c */
    static Map<Class, IProvider> f2301c = new HashMap();
    /* renamed from: d */
    static Map<String, RouteMeta> f2302d = new HashMap();
    /* renamed from: e */
    static Map<Integer, Class<? extends IInterceptor>> f2303e = new UniqueKeyTreeMap("More than one interceptors use same priority [%s]");
    /* renamed from: f */
    static List<IInterceptor> f2304f = new ArrayList();
}
