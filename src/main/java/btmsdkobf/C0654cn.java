package btmsdkobf;

import android.content.Context;
import com.p522qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

/* renamed from: btmsdkobf.cn */
public class C0654cn {
    /* renamed from: gh */
    static C0654cn f424gh;
    /* access modifiers changed from: private */
    /* renamed from: gi */
    public C0843fb f425gi = new C0843fb("actionStats");
    /* renamed from: gj */
    public C0843fb f426gj = new C0843fb("stringStats");

    C0654cn(Context context) {
    }

    /* renamed from: G */
    public static C0654cn m91G() {
        if (f424gh == null) {
            synchronized (C0654cn.class) {
                if (f424gh == null) {
                    f424gh = new C0654cn(C0652cl.m85D());
                }
            }
        }
        return f424gh;
    }

    /* renamed from: L */
    public static void m92L() {
        int i;
        String str = "ActionStats";
        C0848ff.m907i(str, "tryReportDataByShark");
        C0654cn G = m91G();
        if (!m93M()) {
            G.mo9168H();
            G.mo9169I();
            return;
        }
        int i2 = 0;
        C0612ba baVar = new C0612ba();
        baVar.f177ci = new ArrayList<>();
        ArrayList J = G.mo9170J();
        String str2 = "]";
        if (J != null) {
            Iterator it = J.iterator();
            while (it.hasNext()) {
                C0613bb bbVar = (C0613bb) it.next();
                int length = bbVar.toByteArray().length;
                if (length > 1024000) {
                    m99c(bbVar.f181cm);
                }
                int i3 = length + i2;
                if (i3 < 1024000) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("ActionData:[");
                    sb.append(bbVar.f181cm);
                    sb.append(str2);
                    C0848ff.m907i(str, sb.toString());
                    baVar.f177ci.add(bbVar);
                    i2 = i3;
                } else {
                    it.remove();
                }
            }
        }
        ArrayList K = G.mo9171K();
        if (K != null) {
            Iterator it2 = K.iterator();
            while (it2.hasNext()) {
                C0613bb bbVar2 = (C0613bb) it2.next();
                int length2 = bbVar2.toByteArray().length;
                if (length2 > 1024000) {
                    m100d(bbVar2.f181cm);
                }
                int i4 = length2 + i;
                if (i4 < 1024000) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("StringData:[");
                    sb2.append(bbVar2.f181cm);
                    sb2.append("][");
                    sb2.append(bbVar2.f184cp);
                    sb2.append(str2);
                    C0848ff.m907i(str, sb2.toString());
                    baVar.f177ci.add(bbVar2);
                    i = i4;
                } else {
                    it2.remove();
                }
            }
        }
        if (baVar.f177ci == null || baVar.f177ci.size() <= 0) {
            C0848ff.m905d(str, "vecFeature is null");
            return;
        }
        C0670cx al = C0670cx.m165al();
        C0848ff.m905d(str, "sendShark, ECmd.Cmd_CSFeature");
        al.mo9214a(3651, baVar, null, 2, new C0693dj(G) {
            /* renamed from: gq */
            final /* synthetic */ C0654cn f435gq;

            {
                this.f435gq = r1;
            }

            /* renamed from: a */
            public void mo9159a(int i, int i2, int i3, int i4, JceStruct jceStruct) {
                StringBuilder sb = new StringBuilder();
                sb.append("sendShark, ECmd.Cmd_CSFeature, retCode:[");
                sb.append(i3);
                sb.append("]dataRetCode:[");
                sb.append(i4);
                sb.append("]");
                C0848ff.m905d("ActionStats", sb.toString());
                if (i3 == 0) {
                    this.f435gq.mo9168H();
                    this.f435gq.mo9169I();
                }
            }
        }, 0);
    }

    /* renamed from: M */
    public static boolean m93M() {
        return C0843fb.m895cM().getBoolean("id", true);
    }

    /* renamed from: a */
    public static String m95a(ArrayList<C0653cm> arrayList) {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < arrayList.size(); i++) {
            stringBuffer.append(((C0653cm) arrayList.get(i)).f421ge);
            String str = "&";
            stringBuffer.append(str);
            stringBuffer.append(((C0653cm) arrayList.get(i)).f420gd);
            if (((C0653cm) arrayList.get(i)).errorCode != 0) {
                stringBuffer.append(str);
                stringBuffer.append(((C0653cm) arrayList.get(i)).errorCode);
            }
            stringBuffer.append(";");
        }
        return stringBuffer.toString();
    }

    /* renamed from: a */
    public static void m96a(int i, int i2) {
        m91G().mo9176b(i, i2);
    }

    /* renamed from: a */
    public static void m97a(int i, String str) {
        m91G().mo9174a(m91G().f426gj, i, str, false);
    }

    /* renamed from: b */
    static String m98b(int i) {
        StringBuilder sb = new StringBuilder();
        sb.append("");
        sb.append(i);
        return sb.toString();
    }

    /* renamed from: c */
    public static void m99c(int i) {
        m91G().f425gi.remove(m98b(i));
    }

    /* renamed from: d */
    public static void m100d(int i) {
        m91G().f426gj.remove(m98b(i));
    }

    public static void saveActionData(int i) {
        m91G().mo9176b(i, 0);
    }

    /* renamed from: H */
    public void mo9168H() {
        this.f425gi.clear();
    }

    /* renamed from: I */
    public void mo9169I() {
        m91G().f426gj.clear();
    }

    /* renamed from: J */
    public ArrayList<C0613bb> mo9170J() {
        return mo9173a(this.f425gi, "Action");
    }

    /* renamed from: K */
    public ArrayList<C0613bb> mo9171K() {
        return mo9172a(m91G().f426gj);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public ArrayList<C0613bb> mo9172a(C0843fb fbVar) {
        ArrayList<C0613bb> arrayList = new ArrayList<>();
        Map all = fbVar.getAll();
        if (all != null) {
            for (Entry entry : all.entrySet()) {
                try {
                    String str = (String) entry.getKey();
                    Object value = entry.getValue();
                    if (value != null && (value instanceof String)) {
                        String str2 = (String) value;
                        if (str2.indexOf("$") > 0) {
                            int intValue = Integer.valueOf(str).intValue();
                            String[] split = str2.split("\\$");
                            if (split != null) {
                                if (split.length > 0) {
                                    for (String split2 : split) {
                                        String[] split3 = split2.split("\\|");
                                        if (split3 != null) {
                                            if (split3.length == 2) {
                                                long longValue = Long.valueOf(split3[0]).longValue();
                                                String str3 = split3[1];
                                                C0613bb bbVar = new C0613bb();
                                                bbVar.f181cm = intValue;
                                                bbVar.f182cn = (int) (longValue / 1000);
                                                bbVar.f184cp = new ArrayList<>();
                                                bbVar.f184cp.add(str3);
                                                arrayList.add(bbVar);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                } catch (Exception unused) {
                }
            }
        }
        return arrayList;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public ArrayList<C0613bb> mo9173a(C0843fb fbVar, String str) {
        Map map = null;
        if (fbVar == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        try {
            map = fbVar.getAll();
        } catch (Exception unused) {
        }
        if (map != null) {
            for (Entry entry : map.entrySet()) {
                try {
                    String str2 = (String) entry.getKey();
                    Object value = entry.getValue();
                    if (value instanceof String) {
                        arrayList.addAll(mo9177c(Integer.valueOf(str2).intValue(), (String) value));
                    }
                } catch (Exception unused2) {
                }
            }
        }
        return mo9175b(arrayList);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo9174a(C0843fb fbVar, int i, String str, boolean z) {
        C0845fd cN = C0845fd.m898cN();
        final String str2 = str;
        final int i2 = i;
        final C0843fb fbVar2 = fbVar;
        final boolean z2 = z;
        C06562 r1 = new Runnable() {
            public void run() {
                String str = str2;
                if (str != null && str.length() > 0) {
                    String b = C0654cn.m98b(i2);
                    String string = fbVar2.getString(b, null);
                    if (string == null || z2) {
                        string = "";
                    }
                    StringBuilder sb = new StringBuilder();
                    sb.append(string);
                    sb.append(System.currentTimeMillis());
                    sb.append("|");
                    sb.append(str2);
                    sb.append("$");
                    if (sb.length() <= 16384) {
                        fbVar2.putString(b, sb.toString());
                    }
                }
            }
        };
        cN.addTask(r1, "doxxx");
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public ArrayList<C0613bb> mo9175b(ArrayList<C0653cm> arrayList) {
        if (arrayList == null) {
            return null;
        }
        ArrayList<C0613bb> arrayList2 = new ArrayList<>();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            C0653cm cmVar = (C0653cm) it.next();
            if (cmVar.f420gd > 0) {
                C0613bb bbVar = new C0613bb();
                bbVar.f181cm = cmVar.f419gc;
                bbVar.f182cn = (int) (cmVar.f421ge / 1000);
                bbVar.count = cmVar.f420gd;
                if (cmVar.errorCode != 0) {
                    bbVar.f183co = new ArrayList<>();
                    bbVar.f183co.add(Integer.valueOf(cmVar.errorCode));
                }
                arrayList2.add(bbVar);
            }
        }
        return arrayList2;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public void mo9176b(final int i, final int i2) {
        C0845fd.m898cN().addTask(new Runnable() {
            public void run() {
                String b = C0654cn.m98b(i);
                long currentTimeMillis = System.currentTimeMillis();
                String string = C0654cn.this.f425gi.getString(b, null);
                if (string == null || string.length() <= 8192) {
                    ArrayList arrayList = new ArrayList();
                    C0653cm cmVar = new C0653cm();
                    cmVar.f419gc = i;
                    cmVar.f421ge = currentTimeMillis;
                    cmVar.f420gd = 1;
                    cmVar.errorCode = i2;
                    arrayList.add(cmVar);
                    String a = C0654cn.m95a(arrayList);
                    if (a != null) {
                        StringBuilder sb = new StringBuilder();
                        if (string != null) {
                            sb.append(string);
                        }
                        sb.append(a);
                        C0654cn.this.f425gi.putString(b, sb.toString());
                    }
                }
            }
        }, "doxxx");
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public ArrayList<C0653cm> mo9177c(int i, String str) {
        String str2 = "&";
        ArrayList<C0653cm> arrayList = new ArrayList<>();
        if (str == null) {
            return arrayList;
        }
        while (true) {
            try {
                int indexOf = str.indexOf(";");
                if (indexOf == -1) {
                    break;
                }
                C0653cm cmVar = new C0653cm();
                String substring = str.substring(0, indexOf);
                if (substring.indexOf(str2) != -1) {
                    cmVar.f419gc = i;
                    cmVar.f421ge = Long.parseLong(substring.substring(0, substring.indexOf(str2)));
                    if (cmVar.f421ge == 0) {
                        cmVar.f421ge = System.currentTimeMillis();
                    }
                    String substring2 = substring.substring(substring.indexOf(str2) + 1);
                    if (substring2.indexOf(str2) != -1) {
                        cmVar.f420gd = Integer.parseInt(substring2.substring(0, substring2.indexOf(str2)));
                        cmVar.errorCode = Integer.parseInt(substring2.substring(substring2.indexOf(str2) + 1));
                    } else {
                        cmVar.f420gd = Integer.parseInt(substring2);
                    }
                    arrayList.add(cmVar);
                }
                if (indexOf == str.length()) {
                    break;
                }
                str = str.substring(indexOf + 1);
            } catch (Exception unused) {
            }
        }
        return arrayList;
    }
}
