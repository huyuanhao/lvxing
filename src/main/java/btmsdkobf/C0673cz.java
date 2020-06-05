package btmsdkobf;

import com.tencent.p605ep.common.adapt.iservice.net.ESharkCode;
import com.tencent.qqpim.discovery.internal.protocol.C7516p;

/* renamed from: btmsdkobf.cz */
public class C0673cz {
    /* renamed from: a */
    public static final int m211a(String str, int i) {
        return str == null ? i : str.contains(ESharkCode.ERR_SOCKET_PERMISSION_DENIED_EACCES) ? ESharkCode.ERR_NETWORK_SOCKET_PERMISSION_DENIED_EACCES : str.contains(ESharkCode.ERR_SOCKET_PERMISSION_DENIED_ELSE) ? ESharkCode.ERR_NETWORK_SOCKET_PERMISSION_DENIED_ELSE : str.contains(ESharkCode.ERR_SOCKET_NO_ROUTE_1) ? ESharkCode.ERR_NETWORK_SOCKET_NO_ROUTE_1 : str.contains(ESharkCode.ERR_SOCKET_NO_ROUTE_2) ? ESharkCode.ERR_NETWORK_SOCKET_NO_ROUTE_2 : str.contains(ESharkCode.ERR_SOCKET_RESET) ? ESharkCode.ERR_NETWORK_SOCKET_RESET : str.contains("setsockopt failed: ENOPROTOOPT (tmsdk.Protocol not available)") ? ESharkCode.ERR_NETWORK_SOCKET_PROTOCOL_1 : str.contains("tmsdk.Protocol not available") ? ESharkCode.ERR_NETWORK_SOCKET_PROTOCOL_2 : str.contains(ESharkCode.ERR_SECURITY_PERMISSION_DENIED_MISSING_PERMISSION) ? ESharkCode.ERR_NETWORK_SECURITY_PERMISSION_DENIED_MISSING_PERMISSION : str.contains(ESharkCode.ERR_CONNECT_1) ? ESharkCode.ERR_NETWORK_CONNECT_1 : str.contains(ESharkCode.ERR_CONNECT_2) ? ESharkCode.ERR_NETWORK_CONNECT_2 : str.contains(ESharkCode.ERR_CONNECT_3) ? ESharkCode.ERR_NETWORK_CONNECT_3 : str.contains(ESharkCode.ERR_CONNECT_4) ? ESharkCode.ERR_NETWORK_CONNECT_4 : str.contains(ESharkCode.ERR_CONNECT_5) ? ESharkCode.ERR_NETWORK_CONNECT_5 : i;
    }

    /* renamed from: i */
    public static final int m212i(int i) {
        return i % 100;
    }

    /* renamed from: j */
    public static final int m213j(int i) {
        return (i % C7516p.f25219Cf) - m212i(i);
    }

    /* renamed from: k */
    public static final int m214k(int i) {
        return ((i % 1000000) - m213j(i)) - m212i(i);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0059, code lost:
            if (r1 != -300) goto L_0x006a;
     */
    /* renamed from: l */
    public static int m215l(int r3) {
        /*
        if (r3 != 0) goto L_0x0003
        return r3
    L_0x0003:
        int r0 = m212i(r3)
        if (r0 == 0) goto L_0x000c
        r0 = r3
        goto L_0x006a
    L_0x000c:
        int r0 = m214k(r3)
        switch(r0) {
            case -560000: goto L_0x002a;
            case -500000: goto L_0x0027;
            case -490000: goto L_0x0027;
            case -480000: goto L_0x0027;
            case -470000: goto L_0x0027;
            case -460000: goto L_0x0027;
            case -450000: goto L_0x0027;
            case -440000: goto L_0x0027;
            case -430000: goto L_0x0027;
            case -420000: goto L_0x0027;
            case -410000: goto L_0x0027;
            case -400000: goto L_0x0027;
            case -390000: goto L_0x0027;
            case -380000: goto L_0x0027;
            case -370000: goto L_0x0027;
            case -360000: goto L_0x0027;
            case -350000: goto L_0x0027;
            case -340000: goto L_0x0027;
            case -330000: goto L_0x0027;
            case -320000: goto L_0x0027;
            case -310000: goto L_0x0027;
            case -300000: goto L_0x0024;
            case -290000: goto L_0x0024;
            case -280000: goto L_0x0021;
            case -250000: goto L_0x0021;
            case -230000: goto L_0x001e;
            case -220000: goto L_0x001b;
            case -210000: goto L_0x0027;
            case -190000: goto L_0x0027;
            case -180000: goto L_0x0027;
            case -170000: goto L_0x002a;
            case -160000: goto L_0x0018;
            case -150000: goto L_0x0027;
            case -140000: goto L_0x0027;
            case -130000: goto L_0x0015;
            case -120000: goto L_0x0027;
            case -110000: goto L_0x0027;
            case -100000: goto L_0x0027;
            case -90000: goto L_0x0027;
            case -80000: goto L_0x0027;
            case -70000: goto L_0x0027;
            case -60000: goto L_0x0027;
            case -50000: goto L_0x0015;
            case -40000: goto L_0x0027;
            case -10000: goto L_0x0027;
            default: goto L_0x0013;
        }
    L_0x0013:
        r0 = r3
        goto L_0x002c
    L_0x0015:
        int r0 = r3 + -4
        goto L_0x002c
    L_0x0018:
        int r0 = r3 + -6
        goto L_0x002c
    L_0x001b:
        int r0 = r3 + -2
        goto L_0x002c
    L_0x001e:
        int r0 = r3 + -7
        goto L_0x002c
    L_0x0021:
        int r0 = r3 + -5
        goto L_0x002c
    L_0x0024:
        int r0 = r3 + -16
        goto L_0x002c
    L_0x0027:
        int r0 = r3 + -3
        goto L_0x002c
    L_0x002a:
        int r0 = r3 + -15
    L_0x002c:
        if (r0 == r3) goto L_0x002f
        goto L_0x006a
    L_0x002f:
        int r1 = m213j(r3)
        r2 = -1500(0xfffffffffffffa24, float:NaN)
        if (r1 == r2) goto L_0x0068
        r2 = -1400(0xfffffffffffffa88, float:NaN)
        if (r1 == r2) goto L_0x0065
        r2 = -1300(0xfffffffffffffaec, float:NaN)
        if (r1 == r2) goto L_0x0062
        r2 = -1200(0xfffffffffffffb50, float:NaN)
        if (r1 == r2) goto L_0x005f
        r2 = -1100(0xfffffffffffffbb4, float:NaN)
        if (r1 == r2) goto L_0x005c
        r2 = -1000(0xfffffffffffffc18, float:NaN)
        if (r1 == r2) goto L_0x005c
        r2 = -900(0xfffffffffffffc7c, float:NaN)
        if (r1 == r2) goto L_0x0068
        r2 = -800(0xfffffffffffffce0, float:NaN)
        if (r1 == r2) goto L_0x0065
        r2 = -400(0xfffffffffffffe70, float:NaN)
        if (r1 == r2) goto L_0x0068
        r2 = -300(0xfffffffffffffed4, float:NaN)
        if (r1 == r2) goto L_0x0068
        goto L_0x006a
    L_0x005c:
        int r0 = r3 + -13
        goto L_0x006a
    L_0x005f:
        int r0 = r3 + -14
        goto L_0x006a
    L_0x0062:
        int r0 = r3 + -9
        goto L_0x006a
    L_0x0065:
        int r0 = r3 + -3
        goto L_0x006a
    L_0x0068:
        int r0 = r3 + -5
    L_0x006a:
        java.lang.StringBuilder r1 = new java.lang.StringBuilder
        r1.<init>()
        java.lang.String r2 = "appendNormalCode: "
        r1.append(r2)
        r1.append(r3)
        java.lang.String r3 = " -> "
        r1.append(r3)
        r1.append(r0)
        java.lang.String r3 = r1.toString()
        java.lang.String r1 = "ESharkCode"
        btmsdkobf.C0849fg.m914i(r1, r3)
        return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: btmsdkobf.C0673cz.m215l(int):int");
    }

    /* renamed from: m */
    public static boolean m216m(int i) {
        if (i == 0) {
            return false;
        }
        int i2 = m212i(i);
        if (!(i2 == -17 || i2 == -18 || i2 == -7 || i2 == -19 || i2 == -2)) {
            int k = m214k(i);
            if (!(k == -220000 || k == -230000 || k == -160000 || k == -540000)) {
                return true;
            }
        }
        return false;
    }
}
