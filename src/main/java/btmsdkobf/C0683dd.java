package btmsdkobf;

import android.content.Context;
import android.os.Process;
import btmsdkobf.C0704ds.C0707b;
import btmsdkobf.C0718dy.C0738f;
import com.p522qq.taf.jce.JceStruct;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.zip.DeflaterOutputStream;
import java.util.zip.InflaterInputStream;
import tmsdk.common.tcc.C8708b;

/* renamed from: btmsdkobf.dd */
public class C0683dd {
    /* renamed from: hr */
    private static C0621bj f495hr = null;
    /* renamed from: hs */
    private static String f496hs = null;
    /* renamed from: ht */
    private static boolean f497ht = false;

    /* renamed from: a */
    private static C0621bj m246a(Context context, boolean z, C0707b bVar, String str, C0695dl dlVar) {
        if (dlVar == null) {
            return null;
        }
        C0621bj bjVar = new C0621bj();
        String str2 = "";
        String str3 = bVar != null ? bVar.f550il : str2;
        if (z) {
            str3 = str2;
        }
        bjVar.f225cZ = str3;
        bjVar.f226cw = C0652cl.m86E().mo9078b();
        bjVar.f222cJ = m265m(context);
        bjVar.f227da = C0871h.m971n();
        bjVar.f223cX = m258aO();
        StringBuilder sb = new StringBuilder();
        sb.append("[ip_list][conn_monitor]checkSharkfin(), apn=");
        sb.append(bjVar.f222cJ);
        sb.append(" isWifi=");
        sb.append(C0850fh.f990oh == 3);
        sb.append(" authType=");
        sb.append(bjVar.f223cX);
        C0849fg.m914i("ConverterUtil", sb.toString());
        bjVar.f221as = str;
        bjVar.f228db = dlVar.mo9228aC();
        bjVar.f229dc = dlVar.mo9232aG();
        bjVar.f230dd = dlVar.mo9295bg();
        if (f496hs == null) {
            int myPid = Process.myPid();
            StringBuilder sb2 = new StringBuilder();
            sb2.append(dlVar.mo9234ar() ? "b" : "f");
            sb2.append(myPid);
            f496hs = sb2.toString();
        }
        bjVar.f224cY = f496hs;
        return bjVar;
    }

    /* renamed from: a */
    private static C0637bz m247a(Context context, boolean z, C0738f fVar, C0707b bVar, ArrayList<C0636by> arrayList, String str, C0695dl dlVar) {
        C0637bz bi = C0699dp.m382bi();
        bi.f368fm = fVar.f646jK;
        bi.f370fw = 4;
        bi.f372fy = arrayList;
        String str2 = "ConverterUtil";
        if (!z || fVar.f639jD || fVar.f640jE || fVar.f642jG) {
            StringBuilder sb = new StringBuilder();
            sb.append("[shark_v4][shark_fin] must take sharkfin: !isTcpChannel: ");
            sb.append(!z);
            sb.append(" isRsa: ");
            sb.append(fVar.f639jD);
            sb.append(" isGuid: ");
            sb.append(fVar.f640jE);
            sb.append(" isFP: ");
            sb.append(fVar.f642jG);
            C0849fg.m911d(str2, sb.toString());
            C0621bj a = m246a(context, fVar.f639jD, bVar, str, dlVar);
            bi.f371fx = a;
            f495hr = a;
            f497ht = false;
            m250a(a, "[shark_fin][must take]");
        } else if (!fVar.f641jF) {
            C0621bj a2 = m246a(context, false, bVar, str, dlVar);
            String str3 = "[shark_fin][cur]";
            if (!m251a(a2, f495hr)) {
                C0849fg.m911d(str2, "[shark_v4][shark_fin] sharkfin changed, needed!");
                m250a(f495hr, "[shark_fin][last]");
            } else if (f497ht) {
                C0849fg.m916w(str2, "[shark_v4][shark_fin] mazu said need sharkfin!");
            } else {
                C0849fg.m914i(str2, "[shark_v4][shark_fin] sharkfin unchanged, no need to take sharkfin");
            }
            m250a(a2, str3);
            bi.f371fx = a2;
            f495hr = a2;
            f497ht = false;
        }
        return bi;
    }

    /* renamed from: a */
    public static JceStruct m248a(Context context, byte[] bArr, byte[] bArr2, JceStruct jceStruct, boolean z, int i) {
        JceStruct jceStruct2 = null;
        if (!(bArr2 == null || bArr2.length == 0)) {
            byte[] a = m254a(context, bArr, bArr2, i);
            if (!(a == null || a.length <= 0 || jceStruct == null)) {
                jceStruct2 = C0699dp.m380a(a, jceStruct, z);
                if (jceStruct2 == null) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("[shark_v4][shark_cmd]dataForReceive2JceStruct(), getJceStruct() return null! jceData: ");
                    sb.append(Arrays.toString(a));
                    C0849fg.m916w("ConverterUtil", sb.toString());
                }
            }
        }
        return jceStruct2;
    }

    /* renamed from: a */
    public static JceStruct m249a(byte[] bArr, JceStruct jceStruct) {
        return C0699dp.m380a(bArr, jceStruct, false);
    }

    /* renamed from: a */
    private static void m250a(C0621bj bjVar, String str) {
        String str2;
        String str3 = "[shark_v4]";
        String str4 = "ConverterUtil";
        if (bjVar == null) {
            StringBuilder sb = new StringBuilder();
            sb.append(str3);
            sb.append(str);
            sb.append(": null");
            str2 = sb.toString();
        } else {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(str3);
            sb2.append(str);
            sb2.append(": sharkfin.buildno: ");
            sb2.append(bjVar.f226cw);
            sb2.append(" sharkfin.apn: ");
            sb2.append(bjVar.f222cJ);
            sb2.append(" sharkfin.netType: ");
            sb2.append(bjVar.f227da);
            sb2.append(" sharkfin.authType: ");
            sb2.append(bjVar.f223cX);
            sb2.append(" sharkfin.guid: ");
            sb2.append(bjVar.f221as);
            sb2.append(" sharkfin.ext1: ");
            sb2.append(bjVar.f224cY);
            sb2.append(" sharkfin.accountId: ");
            sb2.append(bjVar.f228db);
            sb2.append(" sharkfin.bootType: ");
            sb2.append(bjVar.f229dc);
            sb2.append(" sharkfin.wsGuid: ");
            sb2.append(bjVar.f230dd);
            str2 = sb2.toString();
        }
        C0849fg.m914i(str4, str2);
    }

    /* renamed from: a */
    private static boolean m251a(C0621bj bjVar, C0621bj bjVar2) {
        boolean z = true;
        if (bjVar == null && bjVar2 == null) {
            return true;
        }
        if (bjVar == null || bjVar2 == null) {
            return false;
        }
        if (!(bjVar.f222cJ == bjVar2.f222cJ && bjVar.f223cX == bjVar2.f223cX && m260c(bjVar.f221as, bjVar2.f221as) && m260c(bjVar.f224cY, bjVar2.f224cY) && m260c(bjVar.f225cZ, bjVar2.f225cZ) && bjVar.f226cw == bjVar2.f226cw && bjVar.f227da == bjVar2.f227da && bjVar.f228db == bjVar2.f228db && bjVar.f229dc == bjVar2.f229dc && m260c(bjVar.f230dd, bjVar2.f230dd))) {
            z = false;
        }
        return z;
    }

    /* renamed from: a */
    public static byte[] m252a(Context context, JceStruct jceStruct, int i, C0636by byVar) {
        return m253a(context, jceStruct != null ? C0699dp.m381b(jceStruct) : null, i, byVar);
    }

    /* renamed from: a */
    public static byte[] m253a(Context context, byte[] bArr, int i, C0636by byVar) {
        String str;
        String sb;
        String str2 = " flag: ";
        String str3 = " cmdId: ";
        String str4 = " -> ";
        String str5 = "ConverterUtil";
        if (bArr != null) {
            try {
                if (bArr.length > 50) {
                    byte[] h = m263h(bArr);
                    if (byVar != null) {
                        int i2 = byVar.f365ft;
                        if (h == null || h.length >= bArr.length) {
                            int length = h == null ? -1 : h.length;
                            byVar.f365ft |= 1;
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append("[shark_compress]donnot compress, length: ");
                            sb2.append(bArr.length);
                            sb2.append(" (if compress)|-> ");
                            sb2.append(length);
                            sb2.append(str3);
                            sb2.append(i);
                            sb2.append(str2);
                            sb2.append(Integer.toBinaryString(i2));
                            sb2.append(str4);
                            sb2.append(Integer.toBinaryString(byVar.f365ft));
                            sb = sb2.toString();
                            C0849fg.m914i(str5, sb);
                            return m259b(i, bArr);
                        }
                        byVar.f365ft &= -2;
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append("[shark_compress]compressed, length: ");
                        sb3.append(bArr.length);
                        sb3.append(str4);
                        sb3.append(h.length);
                        sb3.append(str3);
                        sb3.append(i);
                        sb3.append(str2);
                        sb3.append(Integer.toBinaryString(i2));
                        sb3.append(str4);
                        sb3.append(Integer.toBinaryString(byVar.f365ft));
                        C0849fg.m914i(str5, sb3.toString());
                    }
                    bArr = h;
                    return m259b(i, bArr);
                }
            } catch (Exception e) {
                StringBuilder sb4 = new StringBuilder();
                sb4.append("jceStruct2DataForSend(), exception: ");
                sb4.append(e);
                C0849fg.m912e(str5, sb4.toString());
                return null;
            }
        }
        if (byVar != null) {
            int i3 = byVar.f365ft;
            byVar.f365ft |= 1;
            StringBuilder sb5 = new StringBuilder();
            sb5.append("[shark_compress]without compress, length: ");
            if (bArr != null) {
                StringBuilder sb6 = new StringBuilder();
                sb6.append("");
                sb6.append(bArr.length);
                str = sb6.toString();
            } else {
                str = "null";
            }
            sb5.append(str);
            sb5.append(str3);
            sb5.append(i);
            sb5.append(str2);
            sb5.append(Integer.toBinaryString(i3));
            sb5.append(str4);
            sb5.append(Integer.toBinaryString(byVar.f365ft));
            sb = sb5.toString();
            C0849fg.m914i(str5, sb);
        }
        return m259b(i, bArr);
    }

    /* renamed from: a */
    public static byte[] m254a(Context context, byte[] bArr, byte[] bArr2, int i) {
        boolean z = true;
        String str = "ConverterUtil";
        if (bArr2 == null || bArr2.length == 0) {
            StringBuilder sb = new StringBuilder();
            sb.append("[shark_v4]dataForReceive2JceBytes(), null or empty data, null? ");
            if (bArr2 != null) {
                z = false;
            }
            sb.append(z);
            C0849fg.m916w(str, sb.toString());
            return null;
        }
        if ((i & 2) == 0) {
            try {
                bArr2 = C8708b.decrypt(bArr2, bArr);
            } catch (Exception e) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("[shark_v4]dataForReceive2JceBytes(), decrypt exception: ");
                sb2.append(e);
                C0849fg.m916w(str, sb2.toString());
                bArr2 = null;
            }
        }
        if (bArr2 == null || bArr2.length < 4) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append("[shark_v4]dataForReceive2JceBytes(), data should be at least 4 bytes: ");
            sb3.append(bArr2 != null ? bArr2.length : -1);
            C0849fg.m916w(str, sb3.toString());
        } else {
            try {
                byte[] g = m262g(bArr2);
                int readInt = new DataInputStream(new ByteArrayInputStream(g)).readInt();
                StringBuilder sb4 = new StringBuilder();
                sb4.append("[shark_cmd]dataForReceive2JceBytes(), header bytes: ");
                sb4.append(Arrays.toString(g));
                sb4.append(" to int: ");
                sb4.append(readInt);
                sb4.append(" jce bytes count: ");
                sb4.append(bArr2.length - 4);
                C0849fg.m911d(str, sb4.toString());
            } catch (Exception e2) {
                e2.printStackTrace();
                StringBuilder sb5 = new StringBuilder();
                sb5.append("[shark_cmd][shark_v4]dataForReceive2JceBytes(), read header exception: ");
                sb5.append(e2);
                C0849fg.m916w(str, sb5.toString());
            }
            byte[] f = m261f(bArr2);
            if (f != null && f.length > 0) {
                if ((1 & i) == 0) {
                    f = m264i(f);
                }
                if (f == null) {
                    C0849fg.m916w(str, "[shark_v4]dataForReceive2JceBytes(), decompress failed!");
                }
                return f;
            }
        }
        return null;
    }

    /* renamed from: a */
    public static byte[] m255a(C0738f fVar, boolean z, String str, C0695dl dlVar) {
        if (fVar == null) {
            return null;
        }
        byte[] b = fVar.f641jF ? new byte[]{fVar.f653jR} : C0699dp.m381b(m247a(C0652cl.m85D(), z, fVar, fVar.f647jL, fVar.f649jN, str, dlVar));
        StringBuilder sb = new StringBuilder();
        sb.append("createSendBytes(), isHello? ");
        sb.append(fVar.f641jF);
        sb.append(" sendData.length: ");
        sb.append(b != null ? b.length : -1);
        C0849fg.m911d("ConverterUtil", sb.toString());
        return b;
    }

    /* renamed from: a */
    public static byte[] m256a(JceStruct jceStruct) {
        if (jceStruct == null) {
            return null;
        }
        return C0699dp.m381b(jceStruct);
    }

    /* renamed from: aN */
    public static void m257aN() {
        f497ht = true;
    }

    /* renamed from: aO */
    private static int m258aO() {
        return 0;
    }

    /* renamed from: b */
    private static byte[] m259b(int i, byte[] bArr) {
        String str = "ConverterUtil";
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
            dataOutputStream.writeInt(i);
            if (bArr != null && bArr.length > 0) {
                dataOutputStream.write(bArr);
            }
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            StringBuilder sb = new StringBuilder();
            sb.append("[shark_cmd]appendIntHeader(), header bytes: ");
            sb.append(Arrays.toString(m262g(byteArray)));
            sb.append(" header value: ");
            sb.append(i);
            sb.append(" mixData.length: ");
            sb.append(byteArray.length);
            C0849fg.m914i(str, sb.toString());
            return byteArray;
        } catch (Exception e) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("[shark_v4]appendIntHeader(), exception: ");
            sb2.append(e);
            C0849fg.m916w(str, sb2.toString());
            return null;
        }
    }

    /* renamed from: c */
    private static boolean m260c(String str, String str2) {
        if (str == null && str2 == null) {
            return true;
        }
        if (str == null || str2 == null) {
            return false;
        }
        return str.equals(str2);
    }

    public static byte[] decrypt(byte[] bArr, byte[] bArr2) {
        if (!(bArr == null || bArr.length == 0)) {
            try {
                return C8708b.decrypt(bArr, bArr2);
            } catch (Throwable th) {
                StringBuilder sb = new StringBuilder();
                sb.append("decrypt(), exception: ");
                sb.append(th.toString());
                C0849fg.m912e("ConverterUtil", sb.toString());
                bArr = null;
            }
        }
        return bArr;
    }

    public static byte[] encrypt(byte[] bArr, byte[] bArr2) {
        if (!(bArr == null || bArr.length == 0)) {
            try {
                return C8708b.encrypt(bArr, bArr2);
            } catch (Throwable th) {
                StringBuilder sb = new StringBuilder();
                sb.append("encrypt(), exception: ");
                sb.append(th.toString());
                C0849fg.m912e("ConverterUtil", sb.toString());
                bArr = null;
            }
        }
        return bArr;
    }

    /* renamed from: f */
    private static byte[] m261f(byte[] bArr) {
        if (bArr == null || bArr.length < 4) {
            StringBuilder sb = new StringBuilder();
            sb.append("[shark_v4]deleteIntHeader(), mixData is not valid, len: ");
            sb.append(bArr != null ? bArr.length : -1);
            C0849fg.m916w("ConverterUtil", sb.toString());
            return null;
        }
        byte[] bArr2 = new byte[(bArr.length - 4)];
        System.arraycopy(bArr, 4, bArr2, 0, bArr.length - 4);
        return bArr2;
    }

    /* renamed from: g */
    public static byte[] m262g(byte[] bArr) {
        if (bArr == null || bArr.length < 4) {
            StringBuilder sb = new StringBuilder();
            sb.append("[shark_v4]getIntHeader(), mixData is not valid, len: ");
            sb.append(bArr != null ? bArr.length : -1);
            C0849fg.m916w("ConverterUtil", sb.toString());
            return null;
        }
        byte[] bArr2 = new byte[4];
        System.arraycopy(bArr, 0, bArr2, 0, 4);
        return bArr2;
    }

    /* renamed from: h */
    private static byte[] m263h(byte[] bArr) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        DeflaterOutputStream deflaterOutputStream = new DeflaterOutputStream(byteArrayOutputStream);
        try {
            deflaterOutputStream.write(bArr);
            deflaterOutputStream.finish();
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            try {
            } catch (IOException e) {
                e.printStackTrace();
            }
            return byteArray;
        } catch (Throwable th) {
            String str = "ConverterUtil";
            StringBuilder sb = new StringBuilder();
            sb.append("deflater(), exception: ");
            sb.append(th);
            C0849fg.m916w(str, sb.toString());
            try {
            } catch (IOException e2) {
                e2.printStackTrace();
            }
            return null;
        } finally {
            try {
                byteArrayOutputStream.close();
                deflaterOutputStream.close();
            } catch (IOException e3) {
                e3.printStackTrace();
            }
        }
    }

    /* renamed from: i */
    private static byte[] m264i(byte[] bArr) {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        InflaterInputStream inflaterInputStream = new InflaterInputStream(byteArrayInputStream);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        while (true) {
            try {
                int read = inflaterInputStream.read();
                if (read == -1) {
                    break;
                }
                byteArrayOutputStream.write(read);
            } catch (Exception e) {
                String str = "ConverterUtil";
                StringBuilder sb = new StringBuilder();
                sb.append("inflater(), exception: ");
                sb.append(e);
                C0849fg.m916w(str, sb.toString());
                try {
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
                return null;
            } finally {
                try {
                    byteArrayInputStream.close();
                    inflaterInputStream.close();
                    byteArrayOutputStream.close();
                } catch (IOException e3) {
                    e3.printStackTrace();
                }
            }
        }
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        try {
        } catch (IOException e4) {
            e4.printStackTrace();
        }
        return byteArray;
    }

    /* renamed from: m */
    public static int m265m(Context context) {
        C0850fh.f989og = false;
        C0850fh.m921v(context);
        if (3 == C0850fh.f990oh) {
            return 1;
        }
        switch (C0850fh.f992oj) {
            case 0:
                return 2;
            case 1:
                return 3;
            case 2:
                return 4;
            case 3:
                return 5;
            case 4:
                return 6;
            case 5:
                return 7;
            case 6:
                return 8;
            case 7:
                return 9;
            case 8:
                return 10;
            default:
                return 0;
        }
    }
}
