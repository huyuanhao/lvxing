package com.alibaba.android.arouter.core;

import android.content.Context;
import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.enums.RouteType;
import com.alibaba.android.arouter.facade.enums.TypeKind;
import com.alibaba.android.arouter.facade.model.RouteMeta;
import com.alibaba.android.arouter.facade.template.ILogger;
import com.alibaba.android.arouter.p043a.ARouter;
import com.alibaba.android.arouter.p045c.TextUtils;
import java.util.concurrent.ThreadPoolExecutor;

/* renamed from: com.alibaba.android.arouter.core.a */
public class LogisticsCenter {
    /* renamed from: a */
    static ThreadPoolExecutor f2295a;
    /* renamed from: b */
    private static Context f2296b;
    /* renamed from: c */
    private static boolean f2297c;

    /* compiled from: LogisticsCenter */
    /* renamed from: com.alibaba.android.arouter.core.a$1 */
    static /* synthetic */ class C11051 {
        /* renamed from: a */
        static final /* synthetic */ int[] f2298a = new int[RouteType.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
     */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        static {
            /*
            com.alibaba.android.arouter.facade.enums.RouteType[] r0 = com.alibaba.android.arouter.facade.enums.RouteType.values()
            int r0 = r0.length
            int[] r0 = new int[r0]
            f2298a = r0
            int[] r0 = f2298a     // Catch:{ NoSuchFieldError -> 0x0014 }
            com.alibaba.android.arouter.facade.enums.RouteType r1 = com.alibaba.android.arouter.facade.enums.RouteType.PROVIDER     // Catch:{ NoSuchFieldError -> 0x0014 }
            int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
            r2 = 1
            r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0014 }
        L_0x0014:
            int[] r0 = f2298a     // Catch:{ NoSuchFieldError -> 0x001f }
            com.alibaba.android.arouter.facade.enums.RouteType r1 = com.alibaba.android.arouter.facade.enums.RouteType.FRAGMENT     // Catch:{ NoSuchFieldError -> 0x001f }
            int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
            r2 = 2
            r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001f }
        L_0x001f:
            return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.alibaba.android.arouter.core.LogisticsCenter.C11051.m41328clinit():void");
        }
    }

    /* renamed from: a */
    private static void m2173a() {
        f2297c = false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x00b4 A[Catch:{ Exception -> 0x0195 }] */
    /* renamed from: a */
    public static synchronized void m2174a(android.content.Context r8, java.util.concurrent.ThreadPoolExecutor r9) throws com.alibaba.android.arouter.exception.HandlerException {
        /*
        java.lang.Class<com.alibaba.android.arouter.core.a> r0 = com.alibaba.android.arouter.core.LogisticsCenter.class
        monitor-enter(r0)
        f2296b = r8     // Catch:{ all -> 0x01b6 }
        f2295a = r9     // Catch:{ all -> 0x01b6 }
        long r1 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x0195 }
        m2173a()     // Catch:{ Exception -> 0x0195 }
        boolean r9 = f2297c     // Catch:{ Exception -> 0x0195 }
        r3 = 0
        if (r9 == 0) goto L_0x001e
        com.alibaba.android.arouter.facade.template.ILogger r8 = com.alibaba.android.arouter.p043a.ARouter.f2236a     // Catch:{ Exception -> 0x0195 }
        java.lang.String r9 = "ARouter::"
        java.lang.String r4 = "Load router map by arouter-auto-register plugin."
        r8.info(r9, r4)     // Catch:{ Exception -> 0x0195 }
        goto L_0x0120
    L_0x001e:
        boolean r9 = com.alibaba.android.arouter.p043a.ARouter.m2129b()     // Catch:{ Exception -> 0x0195 }
        if (r9 != 0) goto L_0x004b
        boolean r9 = com.alibaba.android.arouter.p045c.PackageUtils.m2161a(r8)     // Catch:{ Exception -> 0x0195 }
        if (r9 == 0) goto L_0x002b
        goto L_0x004b
    L_0x002b:
        com.alibaba.android.arouter.facade.template.ILogger r9 = com.alibaba.android.arouter.p043a.ARouter.f2236a     // Catch:{ Exception -> 0x0195 }
        java.lang.String r4 = "ARouter::"
        java.lang.String r5 = "Load router map from cache."
        r9.info(r4, r5)     // Catch:{ Exception -> 0x0195 }
        java.util.HashSet r9 = new java.util.HashSet     // Catch:{ Exception -> 0x0195 }
        java.lang.String r4 = "SP_AROUTER_CACHE"
        android.content.SharedPreferences r8 = r8.getSharedPreferences(r4, r3)     // Catch:{ Exception -> 0x0195 }
        java.lang.String r4 = "ROUTER_MAP"
        java.util.HashSet r5 = new java.util.HashSet     // Catch:{ Exception -> 0x0195 }
        r5.<init>()     // Catch:{ Exception -> 0x0195 }
        java.util.Set r8 = r8.getStringSet(r4, r5)     // Catch:{ Exception -> 0x0195 }
        r9.<init>(r8)     // Catch:{ Exception -> 0x0195 }
        goto L_0x0078
    L_0x004b:
        com.alibaba.android.arouter.facade.template.ILogger r9 = com.alibaba.android.arouter.p043a.ARouter.f2236a     // Catch:{ Exception -> 0x0195 }
        java.lang.String r4 = "ARouter::"
        java.lang.String r5 = "Run with debug mode or new install, rebuild router map."
        r9.info(r4, r5)     // Catch:{ Exception -> 0x0195 }
        android.content.Context r9 = f2296b     // Catch:{ Exception -> 0x0195 }
        java.lang.String r4 = "com.alibaba.android.arouter.routes"
        java.util.Set r9 = com.alibaba.android.arouter.p045c.ClassUtils.m2154a(r9, r4)     // Catch:{ Exception -> 0x0195 }
        boolean r4 = r9.isEmpty()     // Catch:{ Exception -> 0x0195 }
        if (r4 != 0) goto L_0x0075
        java.lang.String r4 = "SP_AROUTER_CACHE"
        android.content.SharedPreferences r4 = r8.getSharedPreferences(r4, r3)     // Catch:{ Exception -> 0x0195 }
        android.content.SharedPreferences$Editor r4 = r4.edit()     // Catch:{ Exception -> 0x0195 }
        java.lang.String r5 = "ROUTER_MAP"
        android.content.SharedPreferences$Editor r4 = r4.putStringSet(r5, r9)     // Catch:{ Exception -> 0x0195 }
        r4.apply()     // Catch:{ Exception -> 0x0195 }
    L_0x0075:
        com.alibaba.android.arouter.p045c.PackageUtils.m2162b(r8)     // Catch:{ Exception -> 0x0195 }
    L_0x0078:
        com.alibaba.android.arouter.facade.template.ILogger r8 = com.alibaba.android.arouter.p043a.ARouter.f2236a     // Catch:{ Exception -> 0x0195 }
        java.lang.String r4 = "ARouter::"
        java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0195 }
        r5.<init>()     // Catch:{ Exception -> 0x0195 }
        java.lang.String r6 = "Find router map finished, map size = "
        r5.append(r6)     // Catch:{ Exception -> 0x0195 }
        int r6 = r9.size()     // Catch:{ Exception -> 0x0195 }
        r5.append(r6)     // Catch:{ Exception -> 0x0195 }
        java.lang.String r6 = ", cost "
        r5.append(r6)     // Catch:{ Exception -> 0x0195 }
        long r6 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x0195 }
        long r6 = r6 - r1
        r5.append(r6)     // Catch:{ Exception -> 0x0195 }
        java.lang.String r1 = " ms."
        r5.append(r1)     // Catch:{ Exception -> 0x0195 }
        java.lang.String r1 = r5.toString()     // Catch:{ Exception -> 0x0195 }
        r8.info(r4, r1)     // Catch:{ Exception -> 0x0195 }
        long r1 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x0195 }
        java.util.Iterator r8 = r9.iterator()     // Catch:{ Exception -> 0x0195 }
    L_0x00ae:
        boolean r9 = r8.hasNext()     // Catch:{ Exception -> 0x0195 }
        if (r9 == 0) goto L_0x0120
        java.lang.Object r9 = r8.next()     // Catch:{ Exception -> 0x0195 }
        java.lang.String r9 = (java.lang.String) r9     // Catch:{ Exception -> 0x0195 }
        java.lang.String r4 = "com.alibaba.android.arouter.routes.ARouter$$Root"
        boolean r4 = r9.startsWith(r4)     // Catch:{ Exception -> 0x0195 }
        if (r4 == 0) goto L_0x00dc
        java.lang.Class r9 = java.lang.Class.forName(r9)     // Catch:{ Exception -> 0x0195 }
        java.lang.Class[] r4 = new java.lang.Class[r3]     // Catch:{ Exception -> 0x0195 }
        java.lang.reflect.Constructor r9 = r9.getConstructor(r4)     // Catch:{ Exception -> 0x0195 }
        java.lang.Object[] r4 = new java.lang.Object[r3]     // Catch:{ Exception -> 0x0195 }
        java.lang.Object r9 = r9.newInstance(r4)     // Catch:{ Exception -> 0x0195 }
        com.alibaba.android.arouter.facade.template.IRouteRoot r9 = (com.alibaba.android.arouter.facade.template.IRouteRoot) r9     // Catch:{ Exception -> 0x0195 }
        com.alibaba.android.arouter.facade.template.IRouteRoot r9 = (com.alibaba.android.arouter.facade.template.IRouteRoot) r9     // Catch:{ Exception -> 0x0195 }
        java.util.Map<java.lang.String, java.lang.Class<? extends com.alibaba.android.arouter.facade.template.IRouteGroup>> r4 = com.alibaba.android.arouter.core.Warehouse.f2299a     // Catch:{ Exception -> 0x0195 }
        r9.loadInto(r4)     // Catch:{ Exception -> 0x0195 }
        goto L_0x00ae
    L_0x00dc:
        java.lang.String r4 = "com.alibaba.android.arouter.routes.ARouter$$Interceptors"
        boolean r4 = r9.startsWith(r4)     // Catch:{ Exception -> 0x0195 }
        if (r4 == 0) goto L_0x00fe
        java.lang.Class r9 = java.lang.Class.forName(r9)     // Catch:{ Exception -> 0x0195 }
        java.lang.Class[] r4 = new java.lang.Class[r3]     // Catch:{ Exception -> 0x0195 }
        java.lang.reflect.Constructor r9 = r9.getConstructor(r4)     // Catch:{ Exception -> 0x0195 }
        java.lang.Object[] r4 = new java.lang.Object[r3]     // Catch:{ Exception -> 0x0195 }
        java.lang.Object r9 = r9.newInstance(r4)     // Catch:{ Exception -> 0x0195 }
        com.alibaba.android.arouter.facade.template.IInterceptorGroup r9 = (com.alibaba.android.arouter.facade.template.IInterceptorGroup) r9     // Catch:{ Exception -> 0x0195 }
        com.alibaba.android.arouter.facade.template.IInterceptorGroup r9 = (com.alibaba.android.arouter.facade.template.IInterceptorGroup) r9     // Catch:{ Exception -> 0x0195 }
        java.util.Map<java.lang.Integer, java.lang.Class<? extends com.alibaba.android.arouter.facade.template.IInterceptor>> r4 = com.alibaba.android.arouter.core.Warehouse.f2303e     // Catch:{ Exception -> 0x0195 }
        r9.loadInto(r4)     // Catch:{ Exception -> 0x0195 }
        goto L_0x00ae
    L_0x00fe:
        java.lang.String r4 = "com.alibaba.android.arouter.routes.ARouter$$Providers"
        boolean r4 = r9.startsWith(r4)     // Catch:{ Exception -> 0x0195 }
        if (r4 == 0) goto L_0x00ae
        java.lang.Class r9 = java.lang.Class.forName(r9)     // Catch:{ Exception -> 0x0195 }
        java.lang.Class[] r4 = new java.lang.Class[r3]     // Catch:{ Exception -> 0x0195 }
        java.lang.reflect.Constructor r9 = r9.getConstructor(r4)     // Catch:{ Exception -> 0x0195 }
        java.lang.Object[] r4 = new java.lang.Object[r3]     // Catch:{ Exception -> 0x0195 }
        java.lang.Object r9 = r9.newInstance(r4)     // Catch:{ Exception -> 0x0195 }
        com.alibaba.android.arouter.facade.template.IProviderGroup r9 = (com.alibaba.android.arouter.facade.template.IProviderGroup) r9     // Catch:{ Exception -> 0x0195 }
        com.alibaba.android.arouter.facade.template.IProviderGroup r9 = (com.alibaba.android.arouter.facade.template.IProviderGroup) r9     // Catch:{ Exception -> 0x0195 }
        java.util.Map<java.lang.String, com.alibaba.android.arouter.facade.model.RouteMeta> r4 = com.alibaba.android.arouter.core.Warehouse.f2302d     // Catch:{ Exception -> 0x0195 }
        r9.loadInto(r4)     // Catch:{ Exception -> 0x0195 }
        goto L_0x00ae
    L_0x0120:
        com.alibaba.android.arouter.facade.template.ILogger r8 = com.alibaba.android.arouter.p043a.ARouter.f2236a     // Catch:{ Exception -> 0x0195 }
        java.lang.String r9 = "ARouter::"
        java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0195 }
        r4.<init>()     // Catch:{ Exception -> 0x0195 }
        java.lang.String r5 = "Load root element finished, cost "
        r4.append(r5)     // Catch:{ Exception -> 0x0195 }
        long r5 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x0195 }
        long r5 = r5 - r1
        r4.append(r5)     // Catch:{ Exception -> 0x0195 }
        java.lang.String r1 = " ms."
        r4.append(r1)     // Catch:{ Exception -> 0x0195 }
        java.lang.String r1 = r4.toString()     // Catch:{ Exception -> 0x0195 }
        r8.info(r9, r1)     // Catch:{ Exception -> 0x0195 }
        java.util.Map<java.lang.String, java.lang.Class<? extends com.alibaba.android.arouter.facade.template.IRouteGroup>> r8 = com.alibaba.android.arouter.core.Warehouse.f2299a     // Catch:{ Exception -> 0x0195 }
        int r8 = r8.size()     // Catch:{ Exception -> 0x0195 }
        if (r8 != 0) goto L_0x0153
        com.alibaba.android.arouter.facade.template.ILogger r8 = com.alibaba.android.arouter.p043a.ARouter.f2236a     // Catch:{ Exception -> 0x0195 }
        java.lang.String r9 = "ARouter::"
        java.lang.String r1 = "No mapping files were found, check your configuration please!"
        r8.error(r9, r1)     // Catch:{ Exception -> 0x0195 }
    L_0x0153:
        boolean r8 = com.alibaba.android.arouter.p043a.ARouter.m2129b()     // Catch:{ Exception -> 0x0195 }
        if (r8 == 0) goto L_0x0193
        com.alibaba.android.arouter.facade.template.ILogger r8 = com.alibaba.android.arouter.p043a.ARouter.f2236a     // Catch:{ Exception -> 0x0195 }
        java.lang.String r9 = "ARouter::"
        java.util.Locale r1 = java.util.Locale.getDefault()     // Catch:{ Exception -> 0x0195 }
        java.lang.String r2 = "LogisticsCenter has already been loaded, GroupIndex[%d], InterceptorIndex[%d], ProviderIndex[%d]"
        r4 = 3
        java.lang.Object[] r4 = new java.lang.Object[r4]     // Catch:{ Exception -> 0x0195 }
        java.util.Map<java.lang.String, java.lang.Class<? extends com.alibaba.android.arouter.facade.template.IRouteGroup>> r5 = com.alibaba.android.arouter.core.Warehouse.f2299a     // Catch:{ Exception -> 0x0195 }
        int r5 = r5.size()     // Catch:{ Exception -> 0x0195 }
        java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ Exception -> 0x0195 }
        r4[r3] = r5     // Catch:{ Exception -> 0x0195 }
        r3 = 1
        java.util.Map<java.lang.Integer, java.lang.Class<? extends com.alibaba.android.arouter.facade.template.IInterceptor>> r5 = com.alibaba.android.arouter.core.Warehouse.f2303e     // Catch:{ Exception -> 0x0195 }
        int r5 = r5.size()     // Catch:{ Exception -> 0x0195 }
        java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ Exception -> 0x0195 }
        r4[r3] = r5     // Catch:{ Exception -> 0x0195 }
        r3 = 2
        java.util.Map<java.lang.String, com.alibaba.android.arouter.facade.model.RouteMeta> r5 = com.alibaba.android.arouter.core.Warehouse.f2302d     // Catch:{ Exception -> 0x0195 }
        int r5 = r5.size()     // Catch:{ Exception -> 0x0195 }
        java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ Exception -> 0x0195 }
        r4[r3] = r5     // Catch:{ Exception -> 0x0195 }
        java.lang.String r1 = java.lang.String.format(r1, r2, r4)     // Catch:{ Exception -> 0x0195 }
        r8.debug(r9, r1)     // Catch:{ Exception -> 0x0195 }
    L_0x0193:
        monitor-exit(r0)
        return
    L_0x0195:
        r8 = move-exception
        com.alibaba.android.arouter.exception.HandlerException r9 = new com.alibaba.android.arouter.exception.HandlerException     // Catch:{ all -> 0x01b6 }
        java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x01b6 }
        r1.<init>()     // Catch:{ all -> 0x01b6 }
        java.lang.String r2 = "ARouter::ARouter init logistics center exception! ["
        r1.append(r2)     // Catch:{ all -> 0x01b6 }
        java.lang.String r8 = r8.getMessage()     // Catch:{ all -> 0x01b6 }
        r1.append(r8)     // Catch:{ all -> 0x01b6 }
        java.lang.String r8 = "]"
        r1.append(r8)     // Catch:{ all -> 0x01b6 }
        java.lang.String r8 = r1.toString()     // Catch:{ all -> 0x01b6 }
        r9.m41330init(r8)     // Catch:{ all -> 0x01b6 }
        throw r9     // Catch:{ all -> 0x01b6 }
    L_0x01b6:
        r8 = move-exception
        monitor-exit(r0)
        throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.android.arouter.core.LogisticsCenter.m2174a(android.content.Context, java.util.concurrent.ThreadPoolExecutor):void");
    }

    /* renamed from: a */
    public static Postcard m2172a(String str) {
        RouteMeta routeMeta = (RouteMeta) Warehouse.f2302d.get(str);
        if (routeMeta == null) {
            return null;
        }
        return new Postcard(routeMeta.getPath(), routeMeta.getGroup());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x008f, code lost:
            r12 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0090, code lost:
            r2 = new java.lang.StringBuilder();
            r2.append("ARouter::Fatal exception when loading group meta. [");
            r2.append(r12.getMessage());
            r2.append("]");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x00af, code lost:
            throw new com.alibaba.android.arouter.exception.HandlerException(r2.toString());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x0194, code lost:
            r12 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:?, code lost:
            r2 = new java.lang.StringBuilder();
            r2.append("Init provider failed! ");
            r2.append(r12.getMessage());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x01af, code lost:
            throw new com.alibaba.android.arouter.exception.HandlerException(r2.toString());
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [B:8:0x0024, B:39:0x017b] */
    /* renamed from: a */
    public static synchronized void m2175a(com.alibaba.android.arouter.facade.Postcard r12) {
        /*
        java.lang.Class<com.alibaba.android.arouter.core.a> r0 = com.alibaba.android.arouter.core.LogisticsCenter.class
        monitor-enter(r0)
        if (r12 == 0) goto L_0x01ba
        java.util.Map<java.lang.String, com.alibaba.android.arouter.facade.model.RouteMeta> r1 = com.alibaba.android.arouter.core.Warehouse.f2300b     // Catch:{ all -> 0x01b8 }
        java.lang.String r2 = r12.getPath()     // Catch:{ all -> 0x01b8 }
        java.lang.Object r1 = r1.get(r2)     // Catch:{ all -> 0x01b8 }
        com.alibaba.android.arouter.facade.model.RouteMeta r1 = (com.alibaba.android.arouter.facade.model.RouteMeta) r1     // Catch:{ all -> 0x01b8 }
        r2 = 1
        r3 = 2
        r4 = 0
        if (r1 != 0) goto L_0x00dc
        java.util.Map<java.lang.String, java.lang.Class<? extends com.alibaba.android.arouter.facade.template.IRouteGroup>> r1 = com.alibaba.android.arouter.core.Warehouse.f2299a     // Catch:{ all -> 0x01b8 }
        java.lang.String r5 = r12.getGroup()     // Catch:{ all -> 0x01b8 }
        java.lang.Object r1 = r1.get(r5)     // Catch:{ all -> 0x01b8 }
        java.lang.Class r1 = (java.lang.Class) r1     // Catch:{ all -> 0x01b8 }
        if (r1 == 0) goto L_0x00b0
        boolean r5 = com.alibaba.android.arouter.p043a.ARouter.m2129b()     // Catch:{ Exception -> 0x008f }
        if (r5 == 0) goto L_0x0049
        com.alibaba.android.arouter.facade.template.ILogger r5 = com.alibaba.android.arouter.p043a.ARouter.f2236a     // Catch:{ Exception -> 0x008f }
        java.lang.String r6 = "ARouter::"
        java.util.Locale r7 = java.util.Locale.getDefault()     // Catch:{ Exception -> 0x008f }
        java.lang.String r8 = "The group [%s] starts loading, trigger by [%s]"
        java.lang.Object[] r9 = new java.lang.Object[r3]     // Catch:{ Exception -> 0x008f }
        java.lang.String r10 = r12.getGroup()     // Catch:{ Exception -> 0x008f }
        r9[r4] = r10     // Catch:{ Exception -> 0x008f }
        java.lang.String r10 = r12.getPath()     // Catch:{ Exception -> 0x008f }
        r9[r2] = r10     // Catch:{ Exception -> 0x008f }
        java.lang.String r7 = java.lang.String.format(r7, r8, r9)     // Catch:{ Exception -> 0x008f }
        r5.debug(r6, r7)     // Catch:{ Exception -> 0x008f }
    L_0x0049:
        java.lang.Class[] r5 = new java.lang.Class[r4]     // Catch:{ Exception -> 0x008f }
        java.lang.reflect.Constructor r1 = r1.getConstructor(r5)     // Catch:{ Exception -> 0x008f }
        java.lang.Object[] r5 = new java.lang.Object[r4]     // Catch:{ Exception -> 0x008f }
        java.lang.Object r1 = r1.newInstance(r5)     // Catch:{ Exception -> 0x008f }
        com.alibaba.android.arouter.facade.template.IRouteGroup r1 = (com.alibaba.android.arouter.facade.template.IRouteGroup) r1     // Catch:{ Exception -> 0x008f }
        java.util.Map<java.lang.String, com.alibaba.android.arouter.facade.model.RouteMeta> r5 = com.alibaba.android.arouter.core.Warehouse.f2300b     // Catch:{ Exception -> 0x008f }
        r1.loadInto(r5)     // Catch:{ Exception -> 0x008f }
        java.util.Map<java.lang.String, java.lang.Class<? extends com.alibaba.android.arouter.facade.template.IRouteGroup>> r1 = com.alibaba.android.arouter.core.Warehouse.f2299a     // Catch:{ Exception -> 0x008f }
        java.lang.String r5 = r12.getGroup()     // Catch:{ Exception -> 0x008f }
        r1.remove(r5)     // Catch:{ Exception -> 0x008f }
        boolean r1 = com.alibaba.android.arouter.p043a.ARouter.m2129b()     // Catch:{ Exception -> 0x008f }
        if (r1 == 0) goto L_0x008a
        com.alibaba.android.arouter.facade.template.ILogger r1 = com.alibaba.android.arouter.p043a.ARouter.f2236a     // Catch:{ Exception -> 0x008f }
        java.lang.String r5 = "ARouter::"
        java.util.Locale r6 = java.util.Locale.getDefault()     // Catch:{ Exception -> 0x008f }
        java.lang.String r7 = "The group [%s] has already been loaded, trigger by [%s]"
        java.lang.Object[] r3 = new java.lang.Object[r3]     // Catch:{ Exception -> 0x008f }
        java.lang.String r8 = r12.getGroup()     // Catch:{ Exception -> 0x008f }
        r3[r4] = r8     // Catch:{ Exception -> 0x008f }
        java.lang.String r4 = r12.getPath()     // Catch:{ Exception -> 0x008f }
        r3[r2] = r4     // Catch:{ Exception -> 0x008f }
        java.lang.String r2 = java.lang.String.format(r6, r7, r3)     // Catch:{ Exception -> 0x008f }
        r1.debug(r5, r2)     // Catch:{ Exception -> 0x008f }
    L_0x008a:
        m2175a(r12)     // Catch:{ all -> 0x01b8 }
        goto L_0x01b6
    L_0x008f:
        r12 = move-exception
        com.alibaba.android.arouter.exception.HandlerException r1 = new com.alibaba.android.arouter.exception.HandlerException     // Catch:{ all -> 0x01b8 }
        java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x01b8 }
        r2.<init>()     // Catch:{ all -> 0x01b8 }
        java.lang.String r3 = "ARouter::Fatal exception when loading group meta. ["
        r2.append(r3)     // Catch:{ all -> 0x01b8 }
        java.lang.String r12 = r12.getMessage()     // Catch:{ all -> 0x01b8 }
        r2.append(r12)     // Catch:{ all -> 0x01b8 }
        java.lang.String r12 = "]"
        r2.append(r12)     // Catch:{ all -> 0x01b8 }
        java.lang.String r12 = r2.toString()     // Catch:{ all -> 0x01b8 }
        r1.m41330init(r12)     // Catch:{ all -> 0x01b8 }
        throw r1     // Catch:{ all -> 0x01b8 }
    L_0x00b0:
        com.alibaba.android.arouter.exception.NoRouteFoundException r1 = new com.alibaba.android.arouter.exception.NoRouteFoundException     // Catch:{ all -> 0x01b8 }
        java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x01b8 }
        r2.<init>()     // Catch:{ all -> 0x01b8 }
        java.lang.String r3 = "ARouter::There is no route match the path ["
        r2.append(r3)     // Catch:{ all -> 0x01b8 }
        java.lang.String r3 = r12.getPath()     // Catch:{ all -> 0x01b8 }
        r2.append(r3)     // Catch:{ all -> 0x01b8 }
        java.lang.String r3 = "], in group ["
        r2.append(r3)     // Catch:{ all -> 0x01b8 }
        java.lang.String r12 = r12.getGroup()     // Catch:{ all -> 0x01b8 }
        r2.append(r12)     // Catch:{ all -> 0x01b8 }
        java.lang.String r12 = "]"
        r2.append(r12)     // Catch:{ all -> 0x01b8 }
        java.lang.String r12 = r2.toString()     // Catch:{ all -> 0x01b8 }
        r1.m41332init(r12)     // Catch:{ all -> 0x01b8 }
        throw r1     // Catch:{ all -> 0x01b8 }
    L_0x00dc:
        java.lang.Class r5 = r1.getDestination()     // Catch:{ all -> 0x01b8 }
        r12.setDestination(r5)     // Catch:{ all -> 0x01b8 }
        com.alibaba.android.arouter.facade.enums.RouteType r5 = r1.getType()     // Catch:{ all -> 0x01b8 }
        r12.setType(r5)     // Catch:{ all -> 0x01b8 }
        int r5 = r1.getPriority()     // Catch:{ all -> 0x01b8 }
        r12.setPriority(r5)     // Catch:{ all -> 0x01b8 }
        int r5 = r1.getExtra()     // Catch:{ all -> 0x01b8 }
        r12.setExtra(r5)     // Catch:{ all -> 0x01b8 }
        android.net.Uri r5 = r12.getUri()     // Catch:{ all -> 0x01b8 }
        if (r5 == 0) goto L_0x0158
        java.util.Map r6 = com.alibaba.android.arouter.p045c.TextUtils.m2165a(r5)     // Catch:{ all -> 0x01b8 }
        java.util.Map r7 = r1.getParamsType()     // Catch:{ all -> 0x01b8 }
        boolean r8 = com.alibaba.android.arouter.p045c.MapUtils.m2159a(r7)     // Catch:{ all -> 0x01b8 }
        if (r8 == 0) goto L_0x014f
        java.util.Set r8 = r7.entrySet()     // Catch:{ all -> 0x01b8 }
        java.util.Iterator r8 = r8.iterator()     // Catch:{ all -> 0x01b8 }
    L_0x0114:
        boolean r9 = r8.hasNext()     // Catch:{ all -> 0x01b8 }
        if (r9 == 0) goto L_0x013a
        java.lang.Object r9 = r8.next()     // Catch:{ all -> 0x01b8 }
        java.util.Map$Entry r9 = (java.util.Map.Entry) r9     // Catch:{ all -> 0x01b8 }
        java.lang.Object r10 = r9.getValue()     // Catch:{ all -> 0x01b8 }
        java.lang.Integer r10 = (java.lang.Integer) r10     // Catch:{ all -> 0x01b8 }
        java.lang.Object r11 = r9.getKey()     // Catch:{ all -> 0x01b8 }
        java.lang.String r11 = (java.lang.String) r11     // Catch:{ all -> 0x01b8 }
        java.lang.Object r9 = r9.getKey()     // Catch:{ all -> 0x01b8 }
        java.lang.Object r9 = r6.get(r9)     // Catch:{ all -> 0x01b8 }
        java.lang.String r9 = (java.lang.String) r9     // Catch:{ all -> 0x01b8 }
        m2176a(r12, r10, r11, r9)     // Catch:{ all -> 0x01b8 }
        goto L_0x0114
    L_0x013a:
        android.os.Bundle r6 = r12.getExtras()     // Catch:{ all -> 0x01b8 }
        java.lang.String r8 = "wmHzgD4lOj5o4241"
        java.util.Set r7 = r7.keySet()     // Catch:{ all -> 0x01b8 }
        java.lang.String[] r9 = new java.lang.String[r4]     // Catch:{ all -> 0x01b8 }
        java.lang.Object[] r7 = r7.toArray(r9)     // Catch:{ all -> 0x01b8 }
        java.lang.String[] r7 = (java.lang.String[]) r7     // Catch:{ all -> 0x01b8 }
        r6.putStringArray(r8, r7)     // Catch:{ all -> 0x01b8 }
    L_0x014f:
        java.lang.String r6 = "NTeRQWvye18AkPd6G"
        java.lang.String r5 = r5.toString()     // Catch:{ all -> 0x01b8 }
        r12.withString(r6, r5)     // Catch:{ all -> 0x01b8 }
    L_0x0158:
        int[] r5 = com.alibaba.android.arouter.core.LogisticsCenter.C11051.f2298a     // Catch:{ all -> 0x01b8 }
        com.alibaba.android.arouter.facade.enums.RouteType r6 = r1.getType()     // Catch:{ all -> 0x01b8 }
        int r6 = r6.ordinal()     // Catch:{ all -> 0x01b8 }
        r5 = r5[r6]     // Catch:{ all -> 0x01b8 }
        if (r5 == r2) goto L_0x016d
        if (r5 == r3) goto L_0x0169
        goto L_0x01b6
    L_0x0169:
        r12.greenChannel()     // Catch:{ all -> 0x01b8 }
        goto L_0x01b6
    L_0x016d:
        java.lang.Class r1 = r1.getDestination()     // Catch:{ all -> 0x01b8 }
        java.util.Map<java.lang.Class, com.alibaba.android.arouter.facade.template.IProvider> r2 = com.alibaba.android.arouter.core.Warehouse.f2301c     // Catch:{ all -> 0x01b8 }
        java.lang.Object r2 = r2.get(r1)     // Catch:{ all -> 0x01b8 }
        com.alibaba.android.arouter.facade.template.IProvider r2 = (com.alibaba.android.arouter.facade.template.IProvider) r2     // Catch:{ all -> 0x01b8 }
        if (r2 != 0) goto L_0x01b0
        java.lang.Class[] r2 = new java.lang.Class[r4]     // Catch:{ Exception -> 0x0194 }
        java.lang.reflect.Constructor r2 = r1.getConstructor(r2)     // Catch:{ Exception -> 0x0194 }
        java.lang.Object[] r3 = new java.lang.Object[r4]     // Catch:{ Exception -> 0x0194 }
        java.lang.Object r2 = r2.newInstance(r3)     // Catch:{ Exception -> 0x0194 }
        com.alibaba.android.arouter.facade.template.IProvider r2 = (com.alibaba.android.arouter.facade.template.IProvider) r2     // Catch:{ Exception -> 0x0194 }
        android.content.Context r3 = f2296b     // Catch:{ Exception -> 0x0194 }
        r2.init(r3)     // Catch:{ Exception -> 0x0194 }
        java.util.Map<java.lang.Class, com.alibaba.android.arouter.facade.template.IProvider> r3 = com.alibaba.android.arouter.core.Warehouse.f2301c     // Catch:{ Exception -> 0x0194 }
        r3.put(r1, r2)     // Catch:{ Exception -> 0x0194 }
        goto L_0x01b0
    L_0x0194:
        r12 = move-exception
        com.alibaba.android.arouter.exception.HandlerException r1 = new com.alibaba.android.arouter.exception.HandlerException     // Catch:{ all -> 0x01b8 }
        java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x01b8 }
        r2.<init>()     // Catch:{ all -> 0x01b8 }
        java.lang.String r3 = "Init provider failed! "
        r2.append(r3)     // Catch:{ all -> 0x01b8 }
        java.lang.String r12 = r12.getMessage()     // Catch:{ all -> 0x01b8 }
        r2.append(r12)     // Catch:{ all -> 0x01b8 }
        java.lang.String r12 = r2.toString()     // Catch:{ all -> 0x01b8 }
        r1.m41330init(r12)     // Catch:{ all -> 0x01b8 }
        throw r1     // Catch:{ all -> 0x01b8 }
    L_0x01b0:
        r12.setProvider(r2)     // Catch:{ all -> 0x01b8 }
        r12.greenChannel()     // Catch:{ all -> 0x01b8 }
    L_0x01b6:
        monitor-exit(r0)
        return
    L_0x01b8:
        r12 = move-exception
        goto L_0x01c2
    L_0x01ba:
        com.alibaba.android.arouter.exception.NoRouteFoundException r12 = new com.alibaba.android.arouter.exception.NoRouteFoundException     // Catch:{ all -> 0x01b8 }
        java.lang.String r1 = "ARouter::No postcard!"
        r12.m41332init(r1)     // Catch:{ all -> 0x01b8 }
        throw r12     // Catch:{ all -> 0x01b8 }
    L_0x01c2:
        monitor-exit(r0)
        throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.android.arouter.core.LogisticsCenter.m2175a(com.alibaba.android.arouter.facade.Postcard):void");
    }

    /* renamed from: a */
    private static void m2176a(Postcard postcard, Integer num, String str, String str2) {
        if (!TextUtils.m2166a((CharSequence) str) && !TextUtils.m2166a((CharSequence) str2)) {
            if (num != null) {
                try {
                    if (num.intValue() == TypeKind.BOOLEAN.ordinal()) {
                        postcard.withBoolean(str, Boolean.parseBoolean(str2));
                    } else if (num.intValue() == TypeKind.BYTE.ordinal()) {
                        postcard.withByte(str, Byte.valueOf(str2).byteValue());
                    } else if (num.intValue() == TypeKind.SHORT.ordinal()) {
                        postcard.withShort(str, Short.valueOf(str2).shortValue());
                    } else if (num.intValue() == TypeKind.INT.ordinal()) {
                        postcard.withInt(str, Integer.valueOf(str2).intValue());
                    } else if (num.intValue() == TypeKind.LONG.ordinal()) {
                        postcard.withLong(str, Long.valueOf(str2).longValue());
                    } else if (num.intValue() == TypeKind.FLOAT.ordinal()) {
                        postcard.withFloat(str, Float.valueOf(str2).floatValue());
                    } else if (num.intValue() == TypeKind.DOUBLE.ordinal()) {
                        postcard.withDouble(str, Double.valueOf(str2).doubleValue());
                    } else if (num.intValue() == TypeKind.STRING.ordinal()) {
                        postcard.withString(str, str2);
                    } else if (num.intValue() != TypeKind.PARCELABLE.ordinal()) {
                        if (num.intValue() == TypeKind.OBJECT.ordinal()) {
                            postcard.withString(str, str2);
                        } else {
                            postcard.withString(str, str2);
                        }
                    }
                } catch (Throwable th) {
                    ILogger iLogger = ARouter.f2236a;
                    StringBuilder sb = new StringBuilder();
                    sb.append("LogisticsCenter setValue failed! ");
                    sb.append(th.getMessage());
                    iLogger.warning(ILogger.defaultTag, sb.toString());
                }
            } else {
                postcard.withString(str, str2);
            }
        }
    }
}
