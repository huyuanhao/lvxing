package com.tencent.android.tpush.horse;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.android.tpush.common.Constants;
import com.tencent.android.tpush.common.MobileType;
import com.tencent.android.tpush.horse.data.ServerItem;
import com.tencent.android.tpush.p580b.C6864a;
import com.tencent.android.tpush.service.C6973b;
import com.tencent.android.tpush.service.cache.CacheManager;
import com.tencent.android.tpush.service.channel.exception.NullReturnException;
import com.tencent.android.tpush.service.channel.protocol.ApList;
import com.tencent.android.tpush.service.p595e.C7056i;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;

/* compiled from: ProGuard */
public class DefaultServer {
    /* renamed from: a */
    public static String f23026a = "tpns.qq.com";
    /* renamed from: b */
    public static ArrayList<Integer> f23027b = new ArrayList<>(Arrays.asList(new Integer[]{Integer.valueOf(443), Integer.valueOf(8080), Integer.valueOf(80), Integer.valueOf(14000)}));
    /* renamed from: c */
    public static String[] f23028c;
    /* renamed from: d */
    public static String[] f23029d;
    /* renamed from: e */
    public static String[] f23030e;
    /* renamed from: f */
    public static final ENV f23031f = ENV.RELEASE;
    /* renamed from: g */
    public static final ArrayList<ServerItem> f23032g = new ArrayList<>();
    /* renamed from: h */
    private static ArrayList<Integer> f23033h = new ArrayList<>();

    /* compiled from: ProGuard */
    /* renamed from: com.tencent.android.tpush.horse.DefaultServer$ENV */
    public enum ENV {
        RELEASE
    }

    static {
        String str = "183.232.98.178";
        f23028c = new String[]{str};
        String str2 = "58.251.139.182";
        f23029d = new String[]{str2};
        String str3 = "183.61.46.193";
        f23030e = new String[]{str3};
        Collections.shuffle(f23027b);
        f23028c = new String[]{str, "111.30.131.23"};
        f23029d = new String[]{str2, "125.39.240.55"};
        f23030e = new String[]{str3, "123.151.152.50"};
        f23032g.add(new ServerItem(str3, 443, 0));
    }

    /* renamed from: a */
    public static int m29600a() {
        try {
            if (f23033h.isEmpty()) {
                f23033h.addAll(f23027b);
                Collections.shuffle(f23033h);
            }
            if (!f23033h.isEmpty()) {
                return ((Integer) f23033h.remove(0)).intValue();
            }
        } catch (Exception unused) {
        }
        return 80;
    }

    /* renamed from: a */
    public static ArrayList<ServerItem> m29601a(String str) {
        String str2;
        if (str != null) {
            ArrayList<ServerItem> arrayList = new ArrayList<>();
            if (str.equals(String.valueOf(MobileType.CHINAMOBILE.getType()))) {
                Iterator it = f23027b.iterator();
                while (it.hasNext()) {
                    int intValue = ((Integer) it.next()).intValue();
                    int i = 0;
                    while (true) {
                        String[] strArr = f23028c;
                        if (i < strArr.length) {
                            arrayList.add(new ServerItem(strArr[i], intValue, (int) MobileType.CHINAMOBILE.getType()));
                            i++;
                        }
                    }
                }
            } else if (str.equals(String.valueOf(MobileType.TELCOM.getType()))) {
                Iterator it2 = f23027b.iterator();
                while (it2.hasNext()) {
                    int intValue2 = ((Integer) it2.next()).intValue();
                    int i2 = 0;
                    while (true) {
                        String[] strArr2 = f23030e;
                        if (i2 < strArr2.length) {
                            arrayList.add(new ServerItem(strArr2[i2], intValue2, (int) MobileType.TELCOM.getType()));
                            i2++;
                        }
                    }
                }
            } else if (str.equals(String.valueOf(MobileType.UNICOM.getType()))) {
                Iterator it3 = f23027b.iterator();
                while (it3.hasNext()) {
                    int intValue3 = ((Integer) it3.next()).intValue();
                    int i3 = 0;
                    while (true) {
                        String[] strArr3 = f23029d;
                        if (i3 < strArr3.length) {
                            arrayList.add(new ServerItem(strArr3[i3], intValue3, (int) MobileType.UNICOM.getType()));
                            i3++;
                        }
                    }
                }
            } else {
                String domain = CacheManager.getDomain(C6973b.m29776f());
                if (TextUtils.isEmpty(domain)) {
                    domain = f23026a;
                }
                try {
                    str2 = InetAddress.getByName(domain).getHostAddress();
                } catch (Exception e) {
                    C6864a.m29302d(Constants.ServiceLogTag, "", e);
                    str2 = f23028c[0];
                }
                Iterator it4 = f23027b.iterator();
                while (it4.hasNext()) {
                    arrayList.add(new ServerItem(str2, ((Integer) it4.next()).intValue(), (int) MobileType.UNKNOWN.getType()));
                }
            }
            return arrayList;
        }
        throw new NullReturnException("createDefaultItems return null,because key is null");
    }

    /* renamed from: a */
    public static void m29602a(ApList apList) {
        String str;
        String str2;
        ApList apList2 = apList;
        Map<Byte, Long> map = apList2.primary;
        Map<Byte, Long> map2 = apList2.secondary;
        ArrayList<Integer> arrayList = apList2.portList;
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        Iterator it = map.keySet().iterator();
        while (true) {
            boolean hasNext = it.hasNext();
            str = ",port:";
            str2 = Constants.LogTag;
            if (!hasNext) {
                break;
            }
            Byte b = (Byte) it.next();
            String a = C7056i.m30176a(((Long) map.get(b)).longValue());
            if (!TextUtils.isEmpty(a)) {
                Iterator it2 = arrayList.iterator();
                while (it2.hasNext()) {
                    Integer num = (Integer) it2.next();
                    Map<Byte, Long> map3 = map;
                    ServerItem serverItem = new ServerItem(a, num.intValue(), b.intValue());
                    StringBuilder sb = new StringBuilder();
                    sb.append("apList.primary serverItem ip:");
                    sb.append(a);
                    sb.append(str);
                    sb.append(num);
                    C6864a.m29298c(str2, sb.toString());
                    if (b.byteValue() == MobileType.CHINAMOBILE.getType()) {
                        arrayList2.add(serverItem);
                    }
                    if (b.byteValue() == MobileType.TELCOM.getType()) {
                        arrayList3.add(serverItem);
                    }
                    if (b.byteValue() == MobileType.UNICOM.getType()) {
                        arrayList4.add(serverItem);
                    }
                    map = map3;
                }
            }
        }
        for (Byte b2 : map2.keySet()) {
            String a2 = C7056i.m30176a(((Long) map2.get(b2)).longValue());
            if (!TextUtils.isEmpty(a2)) {
                Iterator it3 = arrayList.iterator();
                while (it3.hasNext()) {
                    Integer num2 = (Integer) it3.next();
                    ServerItem serverItem2 = new ServerItem(a2, num2.intValue(), b2.intValue());
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("apList.secondary serverItem ip:");
                    sb2.append(a2);
                    sb2.append(str);
                    sb2.append(num2);
                    C6864a.m29298c(str2, sb2.toString());
                    if (b2.byteValue() == MobileType.CHINAMOBILE.getType()) {
                        arrayList2.add(serverItem2);
                    }
                    if (b2.byteValue() == MobileType.TELCOM.getType()) {
                        arrayList3.add(serverItem2);
                    }
                    if (b2.byteValue() == MobileType.UNICOM.getType()) {
                        arrayList4.add(serverItem2);
                    }
                }
            }
        }
        String str3 = "";
        if (!arrayList2.isEmpty()) {
            Context f = C6973b.m29776f();
            StringBuilder sb3 = new StringBuilder();
            sb3.append(str3);
            sb3.append(MobileType.CHINAMOBILE.getType());
            CacheManager.addServerItems(f, sb3.toString(), arrayList2);
        }
        if (!arrayList3.isEmpty()) {
            Context f2 = C6973b.m29776f();
            StringBuilder sb4 = new StringBuilder();
            sb4.append(str3);
            sb4.append(MobileType.TELCOM.getType());
            CacheManager.addServerItems(f2, sb4.toString(), arrayList3);
        }
        if (!arrayList4.isEmpty()) {
            Context f3 = C6973b.m29776f();
            StringBuilder sb5 = new StringBuilder();
            sb5.append(str3);
            sb5.append(MobileType.UNICOM.getType());
            CacheManager.addServerItems(f3, sb5.toString(), arrayList4);
        }
        ArrayList<Long> arrayList5 = apList2.speedTestIpList;
        ArrayList arrayList6 = new ArrayList();
        Iterator it4 = arrayList5.iterator();
        while (it4.hasNext()) {
            Long l = (Long) it4.next();
            Iterator it5 = arrayList.iterator();
            while (it5.hasNext()) {
                Integer num3 = (Integer) it5.next();
                StringBuilder sb6 = new StringBuilder();
                sb6.append("apList.speedTestIpList serverItem ip:");
                sb6.append(l);
                sb6.append(str);
                sb6.append(num3);
                C6864a.m29298c(str2, sb6.toString());
                arrayList6.add(new ServerItem(l.longValue(), num3.intValue(), 0));
            }
        }
        CacheManager.saveSpeedTestList(C6973b.m29776f(), arrayList6);
        String str4 = apList2.domain;
        if (!TextUtils.isEmpty(str4) && !str4.equals(CacheManager.getDomain(C6973b.m29776f()))) {
            CacheManager.clearDomainServerItem(C6973b.m29776f());
            CacheManager.saveDomain(C6973b.m29776f(), str4);
        }
    }

    /* renamed from: b */
    public static ArrayList<ServerItem> m29603b() {
        ArrayList<ServerItem> arrayList = new ArrayList<>();
        Iterator it = f23027b.iterator();
        while (it.hasNext()) {
            int intValue = ((Integer) it.next()).intValue();
            int i = 0;
            int i2 = 0;
            while (true) {
                String[] strArr = f23028c;
                if (i2 >= strArr.length) {
                    break;
                }
                arrayList.add(new ServerItem(strArr[i2], intValue, (int) MobileType.CHINAMOBILE.getType()));
                i2++;
            }
            int i3 = 0;
            while (true) {
                String[] strArr2 = f23030e;
                if (i3 >= strArr2.length) {
                    break;
                }
                arrayList.add(new ServerItem(strArr2[i3], intValue, (int) MobileType.TELCOM.getType()));
                i3++;
            }
            while (true) {
                String[] strArr3 = f23029d;
                if (i < strArr3.length) {
                    arrayList.add(new ServerItem(strArr3[i], intValue, (int) MobileType.UNICOM.getType()));
                    i++;
                }
            }
        }
        String domain = CacheManager.getDomain(C6973b.m29776f());
        if (TextUtils.isEmpty(domain)) {
            domain = f23026a;
        }
        try {
            String hostAddress = InetAddress.getByName(domain).getHostAddress();
            Iterator it2 = f23027b.iterator();
            while (it2.hasNext()) {
                arrayList.add(new ServerItem(hostAddress, ((Integer) it2.next()).intValue(), (int) MobileType.UNKNOWN.getType()));
            }
        } catch (Exception e) {
            StringBuilder sb = new StringBuilder();
            sb.append(">> Dns resolve err : ");
            sb.append(e.getMessage());
            C6864a.m29308i(Constants.ServiceLogTag, sb.toString());
        }
        return arrayList;
    }
}
