package mtopsdk.p682a.p683a.p684a;

/* renamed from: mtopsdk.a.a.a.a */
public final class ErrorCodeMappingAfterFilter {
    /* JADX WARNING: Unknown top exception splitter block from list: {B:104:0x02b3=Splitter:B:104:0x02b3, B:140:0x03e5=Splitter:B:140:0x03e5} */
    /* renamed from: a */
    public final java.lang.String mo39735a(com.taobao.tao.remotebusiness.p577b.MtopListenerProxyFactory r15) {
        /*
        r14 = this;
        java.lang.String r0 = "key_data_seq"
        java.lang.String r1 = "key_data_response"
        java.lang.String r2 = "key_data_request"
        java.lang.String r3 = r15.f22582h
        mtopsdk.mtop.a.b r4 = mtopsdk.mtop.p689a.SwitchConfig.m35527a()
        boolean r4 = r4.mo39744b()
        java.lang.String r5 = "mtopsdk.ErrorCodeMappingAfterFilter"
        java.lang.String r6 = "CONTINUE"
        if (r4 != 0) goto L_0x001c
        java.lang.String r15 = "GlobalErrorCodeMappingOpen=false,Don't do ErrorCode Mapping."
        mtopsdk.common.util.TBSdkLog.m35507b(r5, r3, r15)
        return r6
    L_0x001c:
        mtopsdk.mtop.domain.MtopResponse r4 = r15.f22577c
        boolean r7 = r4.isApiSuccess()
        if (r7 == 0) goto L_0x0025
        return r6
    L_0x0025:
        boolean r7 = r4.isNoNetwork()     // Catch:{ all -> 0x044c }
        r8 = 1
        if (r7 == 0) goto L_0x0030
        mtopsdk.mtop.util.MtopStatistics r7 = r15.f22581g     // Catch:{ all -> 0x044c }
        r7.f27980b = r8     // Catch:{ all -> 0x044c }
    L_0x0030:
        boolean r7 = r4.isNetworkError()     // Catch:{ all -> 0x044c }
        if (r7 == 0) goto L_0x0099
        java.lang.String r7 = r4.getRetCode()     // Catch:{ all -> 0x044c }
        java.lang.String r7 = mtopsdk.mtop.util.ErrorConstant.m35558a(r7)     // Catch:{ all -> 0x044c }
        r4.mappingCodeSuffix = r7     // Catch:{ all -> 0x044c }
        int r7 = r4.getResponseCode()     // Catch:{ all -> 0x044c }
        java.lang.String r9 = r4.mappingCodeSuffix     // Catch:{ all -> 0x044c }
        java.lang.String r7 = mtopsdk.mtop.util.ErrorConstant.m35557a(r7, r9)     // Catch:{ all -> 0x044c }
        r4.mappingCode = r7     // Catch:{ all -> 0x044c }
        java.util.Map<java.lang.String, java.lang.String> r7 = mtopsdk.mtop.p689a.SwitchConfig.f27883c     // Catch:{ all -> 0x044c }
        java.lang.String r9 = "NETWORK_ERROR_MAPPING"
        java.lang.Object r7 = r7.get(r9)     // Catch:{ all -> 0x044c }
        java.lang.String r7 = (java.lang.String) r7     // Catch:{ all -> 0x044c }
        if (r7 == 0) goto L_0x0059
        goto L_0x005b
    L_0x0059:
        java.lang.String r7 = "网络竟然崩溃了"
    L_0x005b:
        r4.setRetMsg(r7)     // Catch:{ all -> 0x044c }
        mtopsdk.mtop.util.MtopStatistics r7 = r15.f22581g     // Catch:{ all -> 0x044c }
        r7.f28000v = r8     // Catch:{ all -> 0x044c }
        java.lang.String r7 = r4.getResponseLog()
        mtopsdk.common.util.TBSdkLog.m35513d(r5, r3, r7)
        mtopsdk.mtop.domain.MtopRequest r7 = r15.f22576b
        java.lang.String r7 = r7.getRequestLog()
        mtopsdk.common.util.TBSdkLog.m35513d(r5, r3, r7)
        mtopsdk.mtop.common.i r3 = mtopsdk.mtop.p691c.MtopMonitor.m35554a()
        if (r3 == 0) goto L_0x0098
        java.util.HashMap r3 = new java.util.HashMap
        r3.<init>()
        mtopsdk.mtop.domain.MtopRequest r5 = r15.f22576b
        java.lang.String r5 = r5.getRequestLog()
        r3.put(r2, r5)
        java.lang.String r2 = r4.getResponseLog()
        r3.put(r1, r2)
        java.lang.String r15 = r15.f22582h
        r3.put(r0, r15)
        mtopsdk.mtop.p691c.MtopMonitor.m35554a()
        r4.getHeaderFields()
    L_0x0098:
        return r6
    L_0x0099:
        mtopsdk.mtop.util.MtopStatistics r7 = r15.f22581g     // Catch:{ all -> 0x044c }
        r9 = 2
        r7.f28000v = r9     // Catch:{ all -> 0x044c }
        boolean r7 = r4.is41XResult()     // Catch:{ all -> 0x044c }
        java.lang.String r9 = "ES00000"
        if (r7 != 0) goto L_0x03e5
        boolean r7 = r4.isApiLockedResult()     // Catch:{ all -> 0x044c }
        if (r7 == 0) goto L_0x00ae
        goto L_0x03e5
    L_0x00ae:
        boolean r7 = r4.isMtopServerError()     // Catch:{ all -> 0x044c }
        java.lang.String r10 = "服务竟然出错了"
        java.lang.String r11 = "SERVICE_ERROR_MAPPING"
        if (r7 == 0) goto L_0x0124
        java.lang.String r7 = r4.mappingCodeSuffix     // Catch:{ all -> 0x044c }
        boolean r7 = mtopsdk.common.util.C8330d.m35525b(r7)     // Catch:{ all -> 0x044c }
        if (r7 == 0) goto L_0x00d2
        java.lang.String r7 = r4.getRetCode()     // Catch:{ all -> 0x044c }
        java.lang.String r7 = mtopsdk.mtop.util.ErrorConstant.m35558a(r7)     // Catch:{ all -> 0x044c }
        boolean r8 = mtopsdk.common.util.C8330d.m35523a(r7)     // Catch:{ all -> 0x044c }
        if (r8 == 0) goto L_0x00cf
        goto L_0x00d0
    L_0x00cf:
        r7 = r9
    L_0x00d0:
        r4.mappingCodeSuffix = r7     // Catch:{ all -> 0x044c }
    L_0x00d2:
        int r7 = r4.getResponseCode()     // Catch:{ all -> 0x044c }
        java.lang.String r8 = r4.mappingCodeSuffix     // Catch:{ all -> 0x044c }
        java.lang.String r7 = mtopsdk.mtop.util.ErrorConstant.m35557a(r7, r8)     // Catch:{ all -> 0x044c }
        r4.mappingCode = r7     // Catch:{ all -> 0x044c }
        java.util.Map<java.lang.String, java.lang.String> r7 = mtopsdk.mtop.p689a.SwitchConfig.f27883c     // Catch:{ all -> 0x044c }
        java.lang.Object r7 = r7.get(r11)     // Catch:{ all -> 0x044c }
        java.lang.String r7 = (java.lang.String) r7     // Catch:{ all -> 0x044c }
        if (r7 == 0) goto L_0x00e9
        goto L_0x00ea
    L_0x00e9:
        r7 = r10
    L_0x00ea:
        r4.setRetMsg(r7)     // Catch:{ all -> 0x044c }
        java.lang.String r7 = r4.getResponseLog()
        mtopsdk.common.util.TBSdkLog.m35513d(r5, r3, r7)
        mtopsdk.mtop.domain.MtopRequest r7 = r15.f22576b
        java.lang.String r7 = r7.getRequestLog()
        mtopsdk.common.util.TBSdkLog.m35513d(r5, r3, r7)
        mtopsdk.mtop.common.i r3 = mtopsdk.mtop.p691c.MtopMonitor.m35554a()
        if (r3 == 0) goto L_0x0123
        java.util.HashMap r3 = new java.util.HashMap
        r3.<init>()
        mtopsdk.mtop.domain.MtopRequest r5 = r15.f22576b
        java.lang.String r5 = r5.getRequestLog()
        r3.put(r2, r5)
        java.lang.String r2 = r4.getResponseLog()
        r3.put(r1, r2)
        java.lang.String r15 = r15.f22582h
        r3.put(r0, r15)
        mtopsdk.mtop.p691c.MtopMonitor.m35554a()
        r4.getHeaderFields()
    L_0x0123:
        return r6
    L_0x0124:
        boolean r7 = r4.isMtopSdkError()     // Catch:{ all -> 0x044c }
        if (r7 == 0) goto L_0x019b
        java.lang.String r7 = r4.getRetCode()     // Catch:{ all -> 0x044c }
        java.lang.String r8 = mtopsdk.mtop.util.ErrorConstant.m35558a(r7)     // Catch:{ all -> 0x044c }
        if (r7 == 0) goto L_0x013e
        java.lang.String r9 = "ANDROID_SYS_GENERATE_MTOP_SIGN_ERROR"
        boolean r7 = r7.startsWith(r9)     // Catch:{ all -> 0x044c }
        if (r7 == 0) goto L_0x013e
        java.lang.String r8 = "EC40002"
    L_0x013e:
        boolean r7 = mtopsdk.common.util.C8330d.m35523a(r8)     // Catch:{ all -> 0x044c }
        if (r7 == 0) goto L_0x0145
        goto L_0x0147
    L_0x0145:
        java.lang.String r8 = "EC00000"
    L_0x0147:
        r4.mappingCodeSuffix = r8     // Catch:{ all -> 0x044c }
        int r7 = r4.getResponseCode()     // Catch:{ all -> 0x044c }
        java.lang.String r8 = r4.mappingCodeSuffix     // Catch:{ all -> 0x044c }
        java.lang.String r7 = mtopsdk.mtop.util.ErrorConstant.m35557a(r7, r8)     // Catch:{ all -> 0x044c }
        r4.mappingCode = r7     // Catch:{ all -> 0x044c }
        java.util.Map<java.lang.String, java.lang.String> r7 = mtopsdk.mtop.p689a.SwitchConfig.f27883c     // Catch:{ all -> 0x044c }
        java.lang.Object r7 = r7.get(r11)     // Catch:{ all -> 0x044c }
        java.lang.String r7 = (java.lang.String) r7     // Catch:{ all -> 0x044c }
        if (r7 == 0) goto L_0x0160
        goto L_0x0161
    L_0x0160:
        r7 = r10
    L_0x0161:
        r4.setRetMsg(r7)     // Catch:{ all -> 0x044c }
        java.lang.String r7 = r4.getResponseLog()
        mtopsdk.common.util.TBSdkLog.m35513d(r5, r3, r7)
        mtopsdk.mtop.domain.MtopRequest r7 = r15.f22576b
        java.lang.String r7 = r7.getRequestLog()
        mtopsdk.common.util.TBSdkLog.m35513d(r5, r3, r7)
        mtopsdk.mtop.common.i r3 = mtopsdk.mtop.p691c.MtopMonitor.m35554a()
        if (r3 == 0) goto L_0x019a
        java.util.HashMap r3 = new java.util.HashMap
        r3.<init>()
        mtopsdk.mtop.domain.MtopRequest r5 = r15.f22576b
        java.lang.String r5 = r5.getRequestLog()
        r3.put(r2, r5)
        java.lang.String r2 = r4.getResponseLog()
        r3.put(r1, r2)
        java.lang.String r15 = r15.f22582h
        r3.put(r0, r15)
        mtopsdk.mtop.p691c.MtopMonitor.m35554a()
        r4.getHeaderFields()
    L_0x019a:
        return r6
    L_0x019b:
        mtopsdk.mtop.util.MtopStatistics r7 = r15.f22581g     // Catch:{ all -> 0x044c }
        r9 = 3
        r7.f28000v = r9     // Catch:{ all -> 0x044c }
        java.lang.String r7 = r4.mappingCodeSuffix     // Catch:{ all -> 0x044c }
        boolean r7 = mtopsdk.common.util.C8330d.m35523a(r7)     // Catch:{ all -> 0x044c }
        if (r7 == 0) goto L_0x01e3
        java.lang.String r7 = r4.mappingCodeSuffix     // Catch:{ all -> 0x044c }
        r4.mappingCode = r7     // Catch:{ all -> 0x044c }
        java.lang.String r7 = r4.getResponseLog()
        mtopsdk.common.util.TBSdkLog.m35513d(r5, r3, r7)
        mtopsdk.mtop.domain.MtopRequest r7 = r15.f22576b
        java.lang.String r7 = r7.getRequestLog()
        mtopsdk.common.util.TBSdkLog.m35513d(r5, r3, r7)
        mtopsdk.mtop.common.i r3 = mtopsdk.mtop.p691c.MtopMonitor.m35554a()
        if (r3 == 0) goto L_0x01e2
        java.util.HashMap r3 = new java.util.HashMap
        r3.<init>()
        mtopsdk.mtop.domain.MtopRequest r5 = r15.f22576b
        java.lang.String r5 = r5.getRequestLog()
        r3.put(r2, r5)
        java.lang.String r2 = r4.getResponseLog()
        r3.put(r1, r2)
        java.lang.String r15 = r15.f22582h
        r3.put(r0, r15)
        mtopsdk.mtop.p691c.MtopMonitor.m35554a()
        r4.getHeaderFields()
    L_0x01e2:
        return r6
    L_0x01e3:
        java.lang.String r7 = r4.getRetCode()     // Catch:{ all -> 0x044c }
        r4.mappingCode = r7     // Catch:{ all -> 0x044c }
        boolean r9 = mtopsdk.common.util.C8330d.m35525b(r7)     // Catch:{ all -> 0x044c }
        if (r9 == 0) goto L_0x0226
        java.lang.String r7 = r4.getResponseLog()
        mtopsdk.common.util.TBSdkLog.m35513d(r5, r3, r7)
        mtopsdk.mtop.domain.MtopRequest r7 = r15.f22576b
        java.lang.String r7 = r7.getRequestLog()
        mtopsdk.common.util.TBSdkLog.m35513d(r5, r3, r7)
        mtopsdk.mtop.common.i r3 = mtopsdk.mtop.p691c.MtopMonitor.m35554a()
        if (r3 == 0) goto L_0x0225
        java.util.HashMap r3 = new java.util.HashMap
        r3.<init>()
        mtopsdk.mtop.domain.MtopRequest r5 = r15.f22576b
        java.lang.String r5 = r5.getRequestLog()
        r3.put(r2, r5)
        java.lang.String r2 = r4.getResponseLog()
        r3.put(r1, r2)
        java.lang.String r15 = r15.f22582h
        r3.put(r0, r15)
        mtopsdk.mtop.p691c.MtopMonitor.m35554a()
        r4.getHeaderFields()
    L_0x0225:
        return r6
    L_0x0226:
        mtopsdk.mtop.a.b r9 = mtopsdk.mtop.p689a.SwitchConfig.m35527a()     // Catch:{ all -> 0x044c }
        boolean r9 = r9.mo39745c()     // Catch:{ all -> 0x044c }
        if (r9 != 0) goto L_0x026c
        java.lang.String r7 = "BizErrorCodeMappingOpen=false,Don't do BizErrorCode Mapping."
        mtopsdk.common.util.TBSdkLog.m35507b(r5, r3, r7)     // Catch:{ all -> 0x044c }
        java.lang.String r7 = r4.getResponseLog()
        mtopsdk.common.util.TBSdkLog.m35513d(r5, r3, r7)
        mtopsdk.mtop.domain.MtopRequest r7 = r15.f22576b
        java.lang.String r7 = r7.getRequestLog()
        mtopsdk.common.util.TBSdkLog.m35513d(r5, r3, r7)
        mtopsdk.mtop.common.i r3 = mtopsdk.mtop.p691c.MtopMonitor.m35554a()
        if (r3 == 0) goto L_0x026b
        java.util.HashMap r3 = new java.util.HashMap
        r3.<init>()
        mtopsdk.mtop.domain.MtopRequest r5 = r15.f22576b
        java.lang.String r5 = r5.getRequestLog()
        r3.put(r2, r5)
        java.lang.String r2 = r4.getResponseLog()
        r3.put(r1, r2)
        java.lang.String r15 = r15.f22582h
        r3.put(r0, r15)
        mtopsdk.mtop.p691c.MtopMonitor.m35554a()
        r4.getHeaderFields()
    L_0x026b:
        return r6
    L_0x026c:
        int r9 = r7.length()     // Catch:{ all -> 0x044c }
        r10 = 17
        if (r9 != r10) goto L_0x02b3
        char r8 = r7.charAt(r8)     // Catch:{ all -> 0x044c }
        r9 = 45
        if (r8 != r9) goto L_0x02b3
        java.lang.String r7 = r4.getResponseLog()
        mtopsdk.common.util.TBSdkLog.m35513d(r5, r3, r7)
        mtopsdk.mtop.domain.MtopRequest r7 = r15.f22576b
        java.lang.String r7 = r7.getRequestLog()
        mtopsdk.common.util.TBSdkLog.m35513d(r5, r3, r7)
        mtopsdk.mtop.common.i r3 = mtopsdk.mtop.p691c.MtopMonitor.m35554a()
        if (r3 == 0) goto L_0x02b2
        java.util.HashMap r3 = new java.util.HashMap
        r3.<init>()
        mtopsdk.mtop.domain.MtopRequest r5 = r15.f22576b
        java.lang.String r5 = r5.getRequestLog()
        r3.put(r2, r5)
        java.lang.String r2 = r4.getResponseLog()
        r3.put(r1, r2)
        java.lang.String r15 = r15.f22582h
        r3.put(r0, r15)
        mtopsdk.mtop.p691c.MtopMonitor.m35554a()
        r4.getHeaderFields()
    L_0x02b2:
        return r6
    L_0x02b3:
        mtopsdk.mtop.a.b r8 = mtopsdk.mtop.p689a.SwitchConfig.m35527a()     // Catch:{ all -> 0x044c }
        java.util.Set<java.lang.String> r8 = r8.f27891b     // Catch:{ all -> 0x044c }
        if (r8 == 0) goto L_0x031d
        mtopsdk.mtop.domain.MtopRequest r8 = r15.f22576b     // Catch:{ all -> 0x044c }
        java.lang.String r8 = r8.getKey()     // Catch:{ all -> 0x044c }
        mtopsdk.mtop.a.b r9 = mtopsdk.mtop.p689a.SwitchConfig.m35527a()     // Catch:{ all -> 0x044c }
        java.util.Set<java.lang.String> r9 = r9.f27891b     // Catch:{ all -> 0x044c }
        boolean r9 = r9.contains(r8)     // Catch:{ all -> 0x044c }
        if (r9 == 0) goto L_0x031d
        mtopsdk.common.util.TBSdkLog$LogEnable r7 = mtopsdk.common.util.TBSdkLog.LogEnable.InfoEnable     // Catch:{ all -> 0x044c }
        boolean r7 = mtopsdk.common.util.TBSdkLog.m35509b(r7)     // Catch:{ all -> 0x044c }
        if (r7 == 0) goto L_0x02e6
        java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x044c }
        java.lang.String r9 = "apiKey in degradeBizErrorMappingApiSet,apiKey="
        r7.<init>(r9)     // Catch:{ all -> 0x044c }
        r7.append(r8)     // Catch:{ all -> 0x044c }
        java.lang.String r7 = r7.toString()     // Catch:{ all -> 0x044c }
        mtopsdk.common.util.TBSdkLog.m35507b(r5, r3, r7)     // Catch:{ all -> 0x044c }
    L_0x02e6:
        java.lang.String r7 = r4.getResponseLog()
        mtopsdk.common.util.TBSdkLog.m35513d(r5, r3, r7)
        mtopsdk.mtop.domain.MtopRequest r7 = r15.f22576b
        java.lang.String r7 = r7.getRequestLog()
        mtopsdk.common.util.TBSdkLog.m35513d(r5, r3, r7)
        mtopsdk.mtop.common.i r3 = mtopsdk.mtop.p691c.MtopMonitor.m35554a()
        if (r3 == 0) goto L_0x031c
        java.util.HashMap r3 = new java.util.HashMap
        r3.<init>()
        mtopsdk.mtop.domain.MtopRequest r5 = r15.f22576b
        java.lang.String r5 = r5.getRequestLog()
        r3.put(r2, r5)
        java.lang.String r2 = r4.getResponseLog()
        r3.put(r1, r2)
        java.lang.String r15 = r15.f22582h
        r3.put(r0, r15)
        mtopsdk.mtop.p691c.MtopMonitor.m35554a()
        r4.getHeaderFields()
    L_0x031c:
        return r6
    L_0x031d:
        boolean r8 = mtopsdk.common.util.MtopUtils.m35520c(r7)     // Catch:{ Exception -> 0x039c }
        if (r8 == 0) goto L_0x036f
        java.lang.String r8 = "TERR00000"
        r4.mappingCode = r8     // Catch:{ Exception -> 0x039c }
        java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x039c }
        java.lang.String r9 = "retCode contain chinese character,retCode="
        r8.<init>(r9)     // Catch:{ Exception -> 0x039c }
        r8.append(r7)     // Catch:{ Exception -> 0x039c }
        java.lang.String r8 = r8.toString()     // Catch:{ Exception -> 0x039c }
        mtopsdk.common.util.TBSdkLog.m35513d(r5, r3, r8)     // Catch:{ Exception -> 0x039c }
        java.lang.String r7 = r4.getResponseLog()
        mtopsdk.common.util.TBSdkLog.m35513d(r5, r3, r7)
        mtopsdk.mtop.domain.MtopRequest r7 = r15.f22576b
        java.lang.String r7 = r7.getRequestLog()
        mtopsdk.common.util.TBSdkLog.m35513d(r5, r3, r7)
        mtopsdk.mtop.common.i r3 = mtopsdk.mtop.p691c.MtopMonitor.m35554a()
        if (r3 == 0) goto L_0x036e
        java.util.HashMap r3 = new java.util.HashMap
        r3.<init>()
        mtopsdk.mtop.domain.MtopRequest r5 = r15.f22576b
        java.lang.String r5 = r5.getRequestLog()
        r3.put(r2, r5)
        java.lang.String r2 = r4.getResponseLog()
        r3.put(r1, r2)
        java.lang.String r15 = r15.f22582h
        r3.put(r0, r15)
        mtopsdk.mtop.p691c.MtopMonitor.m35554a()
        r4.getHeaderFields()
    L_0x036e:
        return r6
    L_0x036f:
        java.lang.String r8 = mtopsdk.common.util.MtopUtils.m35518b(r7)     // Catch:{ Exception -> 0x039c }
        boolean r9 = mtopsdk.common.util.C8330d.m35523a(r8)     // Catch:{ Exception -> 0x039c }
        if (r9 == 0) goto L_0x03ae
        mtopsdk.mtop.a.b r9 = mtopsdk.mtop.p689a.SwitchConfig.m35527a()     // Catch:{ Exception -> 0x039c }
        long r9 = r9.mo39747e()     // Catch:{ Exception -> 0x039c }
        int r11 = r8.length()     // Catch:{ Exception -> 0x039c }
        long r11 = (long) r11     // Catch:{ Exception -> 0x039c }
        int r13 = (r11 > r9 ? 1 : (r11 == r9 ? 0 : -1))
        if (r13 <= 0) goto L_0x0399
        r11 = 0
        int r13 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1))
        if (r13 <= 0) goto L_0x0399
        r11 = 0
        int r10 = (int) r9     // Catch:{ Exception -> 0x039c }
        java.lang.String r8 = r8.substring(r11, r10)     // Catch:{ Exception -> 0x039c }
        r4.mappingCode = r8     // Catch:{ Exception -> 0x039c }
        goto L_0x03ae
    L_0x0399:
        r4.mappingCode = r8     // Catch:{ Exception -> 0x039c }
        goto L_0x03ae
    L_0x039c:
        r8 = move-exception
        java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ all -> 0x044c }
        java.lang.String r10 = "Mapping biz retCode to mappingCode error.retCode="
        r9.<init>(r10)     // Catch:{ all -> 0x044c }
        r9.append(r7)     // Catch:{ all -> 0x044c }
        java.lang.String r7 = r9.toString()     // Catch:{ all -> 0x044c }
        mtopsdk.common.util.TBSdkLog.m35508b(r5, r3, r7, r8)     // Catch:{ all -> 0x044c }
    L_0x03ae:
        java.lang.String r7 = r4.getResponseLog()
        mtopsdk.common.util.TBSdkLog.m35513d(r5, r3, r7)
        mtopsdk.mtop.domain.MtopRequest r7 = r15.f22576b
        java.lang.String r7 = r7.getRequestLog()
        mtopsdk.common.util.TBSdkLog.m35513d(r5, r3, r7)
        mtopsdk.mtop.common.i r3 = mtopsdk.mtop.p691c.MtopMonitor.m35554a()
        if (r3 == 0) goto L_0x03e4
        java.util.HashMap r3 = new java.util.HashMap
        r3.<init>()
        mtopsdk.mtop.domain.MtopRequest r5 = r15.f22576b
        java.lang.String r5 = r5.getRequestLog()
        r3.put(r2, r5)
        java.lang.String r2 = r4.getResponseLog()
        r3.put(r1, r2)
        java.lang.String r15 = r15.f22582h
        r3.put(r0, r15)
        mtopsdk.mtop.p691c.MtopMonitor.m35554a()
        r4.getHeaderFields()
    L_0x03e4:
        return r6
    L_0x03e5:
        java.lang.String r7 = r4.getRetCode()     // Catch:{ all -> 0x044c }
        java.lang.String r7 = mtopsdk.mtop.util.ErrorConstant.m35558a(r7)     // Catch:{ all -> 0x044c }
        boolean r8 = mtopsdk.common.util.C8330d.m35523a(r7)     // Catch:{ all -> 0x044c }
        if (r8 == 0) goto L_0x03f4
        goto L_0x03f5
    L_0x03f4:
        r7 = r9
    L_0x03f5:
        r4.mappingCodeSuffix = r7     // Catch:{ all -> 0x044c }
        int r7 = r4.getResponseCode()     // Catch:{ all -> 0x044c }
        java.lang.String r8 = r4.mappingCodeSuffix     // Catch:{ all -> 0x044c }
        java.lang.String r7 = mtopsdk.mtop.util.ErrorConstant.m35557a(r7, r8)     // Catch:{ all -> 0x044c }
        r4.mappingCode = r7     // Catch:{ all -> 0x044c }
        java.util.Map<java.lang.String, java.lang.String> r7 = mtopsdk.mtop.p689a.SwitchConfig.f27883c     // Catch:{ all -> 0x044c }
        java.lang.String r8 = "FLOW_LIMIT_ERROR_MAPPING"
        java.lang.Object r7 = r7.get(r8)     // Catch:{ all -> 0x044c }
        java.lang.String r7 = (java.lang.String) r7     // Catch:{ all -> 0x044c }
        if (r7 == 0) goto L_0x0410
        goto L_0x0412
    L_0x0410:
        java.lang.String r7 = "前方拥挤，亲稍等再试试"
    L_0x0412:
        r4.setRetMsg(r7)     // Catch:{ all -> 0x044c }
        java.lang.String r7 = r4.getResponseLog()
        mtopsdk.common.util.TBSdkLog.m35513d(r5, r3, r7)
        mtopsdk.mtop.domain.MtopRequest r7 = r15.f22576b
        java.lang.String r7 = r7.getRequestLog()
        mtopsdk.common.util.TBSdkLog.m35513d(r5, r3, r7)
        mtopsdk.mtop.common.i r3 = mtopsdk.mtop.p691c.MtopMonitor.m35554a()
        if (r3 == 0) goto L_0x044b
        java.util.HashMap r3 = new java.util.HashMap
        r3.<init>()
        mtopsdk.mtop.domain.MtopRequest r5 = r15.f22576b
        java.lang.String r5 = r5.getRequestLog()
        r3.put(r2, r5)
        java.lang.String r2 = r4.getResponseLog()
        r3.put(r1, r2)
        java.lang.String r15 = r15.f22582h
        r3.put(r0, r15)
        mtopsdk.mtop.p691c.MtopMonitor.m35554a()
        r4.getHeaderFields()
    L_0x044b:
        return r6
    L_0x044c:
        r6 = move-exception
        java.lang.String r7 = r4.getResponseLog()
        mtopsdk.common.util.TBSdkLog.m35513d(r5, r3, r7)
        mtopsdk.mtop.domain.MtopRequest r7 = r15.f22576b
        java.lang.String r7 = r7.getRequestLog()
        mtopsdk.common.util.TBSdkLog.m35513d(r5, r3, r7)
        mtopsdk.mtop.common.i r3 = mtopsdk.mtop.p691c.MtopMonitor.m35554a()
        if (r3 == 0) goto L_0x0483
        java.util.HashMap r3 = new java.util.HashMap
        r3.<init>()
        mtopsdk.mtop.domain.MtopRequest r5 = r15.f22576b
        java.lang.String r5 = r5.getRequestLog()
        r3.put(r2, r5)
        java.lang.String r2 = r4.getResponseLog()
        r3.put(r1, r2)
        java.lang.String r15 = r15.f22582h
        r3.put(r0, r15)
        mtopsdk.mtop.p691c.MtopMonitor.m35554a()
        r4.getHeaderFields()
    L_0x0483:
        throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: mtopsdk.p682a.p683a.p684a.ErrorCodeMappingAfterFilter.mo39735a(com.taobao.tao.remotebusiness.b.e):java.lang.String");
    }
}
