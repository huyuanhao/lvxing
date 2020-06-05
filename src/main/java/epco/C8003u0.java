package epco;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/* renamed from: epco.u0 */
public class C8003u0 {
    /* renamed from: a */
    public static C7996r m34634a(ByteBuffer byteBuffer, C7998s sVar) {
        C7996r rVar;
        C7996r rVar2;
        C7992q qVar = new C7992q();
        qVar.mo38410a(C7997r0.m34603c(byteBuffer));
        qVar.mo38414b(C7997r0.m34599a(byteBuffer));
        qVar.mo38412a(C7997r0.m34599a(byteBuffer));
        short b = qVar.mo38413b();
        if (b != 0) {
            boolean z = true;
            if (b == 1) {
                rVar = new C7996r(C7997r0.m34601b(byteBuffer));
            } else if (b != 3) {
                if (b == 5) {
                    rVar2 = new C7996r(m34637a(byteBuffer));
                } else if (b != 6) {
                    switch (b) {
                        case 16:
                        case 17:
                            rVar2 = new C7996r(byteBuffer.getInt());
                            break;
                        case 18:
                            if (byteBuffer.getInt() == 0) {
                                z = false;
                            }
                            rVar2 = new C7996r(z);
                            break;
                        default:
                            switch (b) {
                                case 28:
                                case 30:
                                    rVar2 = new C7996r(m34638a(byteBuffer, 8));
                                    break;
                                case 29:
                                case 31:
                                    rVar = new C7996r(m34638a(byteBuffer, 6));
                                    break;
                                default:
                                    StringBuilder sb = new StringBuilder();
                                    sb.append("{");
                                    sb.append(qVar.mo38413b());
                                    sb.append(":");
                                    sb.append(C7997r0.m34601b(byteBuffer));
                                    sb.append("}");
                                    rVar2 = new C7996r(sb.toString());
                                    break;
                            }
                    }
                } else {
                    rVar2 = new C7996r(m34641b(byteBuffer));
                }
                qVar.mo38411a(rVar2);
            } else {
                int i = byteBuffer.getInt();
                if (i >= 0) {
                    rVar = new C7996r(sVar.mo38424a(i));
                }
            }
            qVar.mo38411a(rVar);
        } else {
            qVar.mo38411a(new C7996r(""));
        }
        return qVar.mo38409a();
    }

    /* renamed from: a */
    public static C7998s m34635a(ByteBuffer byteBuffer, C8000t tVar) {
        long position = (long) byteBuffer.position();
        long[] jArr = new long[((int) tVar.mo38431f())];
        if (tVar.mo38431f() > 0) {
            for (int i = 0; ((long) i) < tVar.mo38431f(); i++) {
                jArr[i] = C7997r0.m34601b(byteBuffer);
            }
        }
        boolean z = (tVar.mo38429e() & 256) != 0;
        long g = (tVar.mo38433g() + position) - ((long) tVar.mo38401d());
        byteBuffer.position((int) g);
        C7976j[] jVarArr = new C7976j[jArr.length];
        for (int i2 = 0; i2 < jArr.length; i2++) {
            jVarArr[i2] = new C7976j(i2, jArr[i2] + g);
        }
        String str = null;
        long j = -1;
        C7998s sVar = new C7998s((int) tVar.mo38431f());
        for (C7976j jVar : jVarArr) {
            long j2 = jVar.f27102b;
            if (j2 != j) {
                byteBuffer.position((int) j2);
                j = jVar.f27102b;
                str = m34639a(byteBuffer, z);
            }
            sVar.mo38425a(jVar.f27101a, str);
        }
        byteBuffer.position((int) (position + ((long) tVar.mo38395a())));
        return sVar;
    }

    /* renamed from: a */
    public static String m34636a(long j, C8012z zVar, Locale locale) {
        String str;
        String str2;
        StringBuilder sb = new StringBuilder();
        sb.append("resourceId:0x");
        sb.append(Long.toHexString(j));
        String sb2 = sb.toString();
        if (zVar == null) {
            return sb2;
        }
        short s = (short) ((int) ((j >> 16) & 255));
        int i = (int) (j & 65535);
        C8010y a = zVar.mo38528a((short) ((int) ((j >> 24) & 255)));
        if (a == null) {
            return sb2;
        }
        C7965e0 a2 = a.mo38508a(Short.valueOf(s));
        List b = a.mo38517b(Short.valueOf(s));
        if (a2 == null || b == null || !a2.mo38320a(i)) {
            return sb2;
        }
        Iterator it = b.iterator();
        C8006w wVar = null;
        String str3 = null;
        int i2 = -1;
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            C7957c0 c0Var = (C7957c0) it.next();
            C8006w a3 = c0Var.mo38275a(i);
            if (a3 != null) {
                if (a3.mo38500d() == null || a3.mo38500d().mo38418a() != 0 || a3.mo38500d().mo38422b() != null) {
                    str3 = a3.mo38497b();
                    int a4 = C7999s0.m34607a(locale, c0Var.mo38286d());
                    if (a4 == 2) {
                        wVar = a3;
                        break;
                    } else if (a4 > i2) {
                        i2 = a4;
                        wVar = a3;
                    }
                }
            }
        }
        if (locale == null || wVar == null) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append("@");
            sb3.append(a2.mo38323c());
            sb3.append("/");
            sb3.append(str);
            str2 = sb3.toString();
        } else {
            str2 = wVar.mo38493a(zVar, locale);
        }
        return str2;
    }

    /* renamed from: a */
    private static String m34637a(ByteBuffer byteBuffer) {
        String str;
        long b = C7997r0.m34601b(byteBuffer);
        short s = (short) ((int) (255 & b));
        if (s == 0) {
            str = "px";
        } else if (s == 1) {
            str = "dp";
        } else if (s == 2) {
            str = "sp";
        } else if (s == 3) {
            str = "pt";
        } else if (s == 4) {
            str = "in";
        } else if (s != 5) {
            StringBuilder sb = new StringBuilder();
            sb.append("unknown unit:0x");
            sb.append(Integer.toHexString(s));
            str = sb.toString();
        } else {
            str = "mm";
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(b >> 8);
        sb2.append(str);
        return sb2.toString();
    }

    /* renamed from: a */
    public static String m34638a(ByteBuffer byteBuffer, int i) {
        long b = C7997r0.m34601b(byteBuffer);
        StringBuilder sb = new StringBuilder();
        for (int i2 = (i / 2) - 1; i2 >= 0; i2--) {
            sb.append(Integer.toHexString((int) ((b >> (i2 * 8)) & 255)));
        }
        return sb.toString();
    }

    /* renamed from: a */
    public static String m34639a(ByteBuffer byteBuffer, boolean z) {
        if (z) {
            m34643c(byteBuffer);
            String str = null;
            try {
                str = new String(C7997r0.m34600a(byteBuffer, m34643c(byteBuffer)), "UTF-8");
            } catch (Exception e) {
                e.printStackTrace();
            }
            C7997r0.m34599a(byteBuffer);
            return str;
        }
        String b = C7997r0.m34602b(byteBuffer, m34644d(byteBuffer));
        C7997r0.m34603c(byteBuffer);
        return b;
    }

    /* renamed from: a */
    public static void m34640a(int i, int i2) {
        if (i != i2) {
            StringBuilder sb = new StringBuilder();
            sb.append("Expect chunk type:");
            sb.append(Integer.toHexString(i));
            sb.append(", but got:");
            sb.append(Integer.toHexString(i2));
            throw new IOException(sb.toString());
        }
    }

    /* renamed from: b */
    private static String m34641b(ByteBuffer byteBuffer) {
        String str;
        long b = C7997r0.m34601b(byteBuffer);
        short s = (short) ((int) (15 & b));
        if (s == 0) {
            str = "%";
        } else if (s != 1) {
            StringBuilder sb = new StringBuilder();
            sb.append("unknown type:0x");
            sb.append(Integer.toHexString(s));
            str = sb.toString();
        } else {
            str = "%p";
        }
        float intBitsToFloat = Float.intBitsToFloat((int) (b >> 4));
        StringBuilder sb2 = new StringBuilder();
        sb2.append(intBitsToFloat);
        sb2.append(str);
        return sb2.toString();
    }

    /* renamed from: b */
    public static String m34642b(ByteBuffer byteBuffer, int i) {
        String b = C7997r0.m34602b(byteBuffer, i);
        for (int i2 = 0; i2 < b.length(); i2++) {
            if (b.charAt(i2) == 0) {
                return b.substring(0, i2);
            }
        }
        return b;
    }

    /* renamed from: c */
    private static int m34643c(ByteBuffer byteBuffer) {
        short a = C7997r0.m34599a(byteBuffer);
        return (a & 128) != 0 ? (((a & 127) << 7) | 0) + C7997r0.m34599a(byteBuffer) : a;
    }

    /* renamed from: d */
    private static int m34644d(ByteBuffer byteBuffer) {
        int c = C7997r0.m34603c(byteBuffer);
        return (32768 & c) != 0 ? (((c & 32767) << 15) | 0) + C7997r0.m34603c(byteBuffer) : c;
    }
}
