package com.tencent.bugly.crashreport.crash;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.os.Environment;
import android.os.Parcelable;
import android.text.TextUtils;
import com.tencent.bugly.BuglyStrategy.C7120a;
import com.tencent.bugly.C7121b;
import com.tencent.bugly.crashreport.common.info.C7174a;
import com.tencent.bugly.crashreport.common.info.PlugInBean;
import com.tencent.bugly.crashreport.common.strategy.C7177a;
import com.tencent.bugly.crashreport.common.strategy.StrategyBean;
import com.tencent.bugly.proguard.C7211ad;
import com.tencent.bugly.proguard.C7212ae;
import com.tencent.bugly.proguard.C7215ag;
import com.tencent.bugly.proguard.C7216ah;
import com.tencent.bugly.proguard.C7218aj;
import com.tencent.bugly.proguard.C7219ak;
import com.tencent.bugly.proguard.C7226an;
import com.tencent.bugly.proguard.C7232aq;
import com.tencent.bugly.proguard.C7245bc;
import com.tencent.bugly.proguard.C7247be;
import com.tencent.bugly.proguard.C7248bf;
import com.tencent.bugly.proguard.C7249bg;
import com.tencent.bugly.proguard.C7250bh;
import com.tencent.bugly.proguard.C7251bi;
import com.tencent.bugly.proguard.C7267m;
import com.tencent.mid.sotrage.StorageInterface;
import com.tencent.p605ep.commonbase.api.ConfigManager.SUB_PLATFORM;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.regex.Pattern;

/* compiled from: BUGLY */
/* renamed from: com.tencent.bugly.crashreport.crash.b */
public class C7190b {
    /* renamed from: a */
    public static int f24178a;
    /* renamed from: b */
    protected final Context f24179b;
    /* renamed from: c */
    protected final C7219ak f24180c;
    /* renamed from: d */
    protected final C7212ae f24181d;
    /* renamed from: e */
    protected final C7177a f24182e;
    /* renamed from: f */
    protected C7199f f24183f;
    /* renamed from: g */
    protected C7120a f24184g;

    public C7190b(int i, Context context, C7219ak akVar, C7212ae aeVar, C7177a aVar, C7120a aVar2, C7199f fVar) {
        f24178a = i;
        this.f24179b = context;
        this.f24180c = akVar;
        this.f24181d = aeVar;
        this.f24182e = aVar;
        this.f24184g = aVar2;
        this.f24183f = fVar;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public List<C7181a> mo34671a(List<C7181a> list) {
        if (list == null || list.size() == 0) {
            return null;
        }
        long currentTimeMillis = System.currentTimeMillis();
        ArrayList arrayList = new ArrayList();
        for (C7181a aVar : list) {
            if (aVar.f24145d && aVar.f24143b <= currentTimeMillis - 86400000) {
                arrayList.add(aVar);
            }
        }
        return arrayList;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public CrashDetailBean mo34669a(List<C7181a> list, CrashDetailBean crashDetailBean) {
        if (list == null || list.size() == 0) {
            return crashDetailBean;
        }
        CrashDetailBean crashDetailBean2 = null;
        ArrayList arrayList = new ArrayList(10);
        for (C7181a aVar : list) {
            if (aVar.f24146e) {
                arrayList.add(aVar);
            }
        }
        String str = "\n";
        String str2 = "";
        if (arrayList.size() > 0) {
            List b = mo34680b((List<C7181a>) arrayList);
            if (b != null && b.size() > 0) {
                Collections.sort(b);
                CrashDetailBean crashDetailBean3 = null;
                for (int i = 0; i < b.size(); i++) {
                    CrashDetailBean crashDetailBean4 = (CrashDetailBean) b.get(i);
                    if (i == 0) {
                        crashDetailBean3 = crashDetailBean4;
                    } else if (crashDetailBean4.f24134s != null) {
                        String[] split = crashDetailBean4.f24134s.split(str);
                        if (split != null) {
                            for (String str3 : split) {
                                String str4 = crashDetailBean3.f24134s;
                                StringBuilder sb = new StringBuilder();
                                sb.append(str2);
                                sb.append(str3);
                                if (!str4.contains(sb.toString())) {
                                    crashDetailBean3.f24135t++;
                                    StringBuilder sb2 = new StringBuilder();
                                    sb2.append(crashDetailBean3.f24134s);
                                    sb2.append(str3);
                                    sb2.append(str);
                                    crashDetailBean3.f24134s = sb2.toString();
                                }
                            }
                        }
                    }
                }
                crashDetailBean2 = crashDetailBean3;
            }
        }
        if (crashDetailBean2 == null) {
            crashDetailBean.f24125j = true;
            crashDetailBean.f24135t = 0;
            crashDetailBean.f24134s = str2;
            crashDetailBean2 = crashDetailBean;
        }
        for (C7181a aVar2 : list) {
            if (!aVar2.f24146e && !aVar2.f24145d) {
                String str5 = crashDetailBean2.f24134s;
                StringBuilder sb3 = new StringBuilder();
                sb3.append(str2);
                sb3.append(aVar2.f24143b);
                if (!str5.contains(sb3.toString())) {
                    crashDetailBean2.f24135t++;
                    StringBuilder sb4 = new StringBuilder();
                    sb4.append(crashDetailBean2.f24134s);
                    sb4.append(aVar2.f24143b);
                    sb4.append(str);
                    crashDetailBean2.f24134s = sb4.toString();
                }
            }
        }
        if (crashDetailBean2.f24133r != crashDetailBean.f24133r) {
            String str6 = crashDetailBean2.f24134s;
            StringBuilder sb5 = new StringBuilder();
            sb5.append(str2);
            sb5.append(crashDetailBean.f24133r);
            if (!str6.contains(sb5.toString())) {
                crashDetailBean2.f24135t++;
                StringBuilder sb6 = new StringBuilder();
                sb6.append(crashDetailBean2.f24134s);
                sb6.append(crashDetailBean.f24133r);
                sb6.append(str);
                crashDetailBean2.f24134s = sb6.toString();
            }
        }
        return crashDetailBean2;
    }

    /* renamed from: a */
    public boolean mo34676a(CrashDetailBean crashDetailBean) {
        return mo34677a(crashDetailBean, -123456789);
    }

    /* renamed from: a */
    public boolean mo34677a(CrashDetailBean crashDetailBean, int i) {
        CrashDetailBean crashDetailBean2 = crashDetailBean;
        if (crashDetailBean2 == null) {
            return true;
        }
        if (C7192c.f24200n != null && !C7192c.f24200n.isEmpty()) {
            C7226an.m31147c("Crash filter for crash stack is: %s", C7192c.f24200n);
            if (crashDetailBean2.f24132q.contains(C7192c.f24200n)) {
                C7226an.m31148d("This crash contains the filter string set. It will not be record and upload.", new Object[0]);
                return true;
            }
        }
        if (C7192c.f24201o != null && !C7192c.f24201o.isEmpty()) {
            C7226an.m31147c("Crash regular filter for crash stack is: %s", C7192c.f24201o);
            if (Pattern.compile(C7192c.f24201o).matcher(crashDetailBean2.f24132q).find()) {
                C7226an.m31148d("This crash matches the regular filter string set. It will not be record and upload.", new Object[0]);
                return true;
            }
        }
        boolean z = crashDetailBean2.f24117b == 1;
        String str = crashDetailBean2.f24129n;
        String str2 = crashDetailBean2.f24130o;
        String str3 = crashDetailBean2.f24131p;
        String str4 = crashDetailBean2.f24132q;
        long j = crashDetailBean2.f24133r;
        String str5 = crashDetailBean2.f24128m;
        String str6 = crashDetailBean2.f24120e;
        String str7 = crashDetailBean2.f24118c;
        String str8 = crashDetailBean2.f24093A;
        String str9 = crashDetailBean2.f24094B;
        if (this.f24183f != null) {
            C7226an.m31147c("Calling 'onCrashSaving' of RQD crash listener.", new Object[0]);
            if (!this.f24183f.mo34717a(z, str, str2, str3, str4, i, j, str5, str6, str7, str8, str9)) {
                C7226an.m31148d("Crash listener 'onCrashSaving' return 'false' thus will not handle this crash.", new Object[0]);
                return true;
            }
        }
        if (crashDetailBean2.f24117b != 2) {
            C7215ag agVar = new C7215ag();
            agVar.f24331b = 1;
            agVar.f24332c = crashDetailBean2.f24093A;
            agVar.f24333d = crashDetailBean2.f24094B;
            agVar.f24334e = crashDetailBean2.f24133r;
            this.f24181d.mo34786b(1);
            this.f24181d.mo34783a(agVar);
            C7226an.m31144b("[crash] a crash occur, handling...", new Object[0]);
        } else {
            C7226an.m31144b("[crash] a caught exception occur, handling...", new Object[0]);
        }
        List<C7181a> b = mo34679b();
        ArrayList arrayList = null;
        if (b != null && b.size() > 0) {
            arrayList = new ArrayList(10);
            ArrayList<C7181a> arrayList2 = new ArrayList<>(10);
            arrayList.addAll(mo34671a(b));
            b.removeAll(arrayList);
            if (((long) b.size()) > 20) {
                mo34672a(5);
            }
            if (!C7121b.f23665c && C7192c.f24190d) {
                boolean z2 = false;
                for (C7181a aVar : b) {
                    if (crashDetailBean2.f24136u.equals(aVar.f24144c)) {
                        if (aVar.f24146e) {
                            z2 = true;
                        }
                        arrayList2.add(aVar);
                    }
                }
                if (z2 || arrayList2.size() >= C7192c.f24189c) {
                    C7226an.m31141a("same crash occur too much do merged!", new Object[0]);
                    CrashDetailBean a = mo34669a((List<C7181a>) arrayList2, crashDetailBean2);
                    for (C7181a aVar2 : arrayList2) {
                        if (aVar2.f24142a != a.f24116a) {
                            arrayList.add(aVar2);
                        }
                    }
                    mo34686e(a);
                    mo34683c((List<C7181a>) arrayList);
                    C7226an.m31144b("[crash] save crash success. For this device crash many times, it will not upload crashes immediately", new Object[0]);
                    return true;
                }
            }
        }
        mo34686e(crashDetailBean);
        if (arrayList != null && !arrayList.isEmpty()) {
            mo34683c((List<C7181a>) arrayList);
        }
        C7226an.m31144b("[crash] save crash success", new Object[0]);
        return false;
    }

    /* renamed from: a */
    public List<CrashDetailBean> mo34670a() {
        StrategyBean c = C7177a.m30857a().mo34624c();
        if (c == null) {
            C7226an.m31148d("have not synced remote!", new Object[0]);
            return null;
        } else if (!c.f24057g) {
            C7226an.m31148d("Crashreport remote closed, please check your APP ID correct and Version available, then uninstall and reinstall your app.", new Object[0]);
            C7226an.m31144b("[init] WARNING! Crashreport closed by server, please check your APP ID correct and Version available, then uninstall and reinstall your app.", new Object[0]);
            return null;
        } else {
            long currentTimeMillis = System.currentTimeMillis();
            long b = C7232aq.m31204b();
            List b2 = mo34679b();
            C7226an.m31147c("Size of crash list loaded from DB: %s", Integer.valueOf(b2.size()));
            if (b2 == null || b2.size() <= 0) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(mo34671a(b2));
            b2.removeAll(arrayList);
            Iterator it = b2.iterator();
            while (it.hasNext()) {
                C7181a aVar = (C7181a) it.next();
                if (aVar.f24143b < b - C7192c.f24193g) {
                    it.remove();
                    arrayList.add(aVar);
                } else if (aVar.f24145d) {
                    if (aVar.f24143b >= currentTimeMillis - 86400000) {
                        it.remove();
                    } else if (!aVar.f24146e) {
                        it.remove();
                        arrayList.add(aVar);
                    }
                } else if (((long) aVar.f24147f) >= 3 && aVar.f24143b < currentTimeMillis - 86400000) {
                    it.remove();
                    arrayList.add(aVar);
                }
            }
            if (arrayList.size() > 0) {
                mo34683c((List<C7181a>) arrayList);
            }
            ArrayList arrayList2 = new ArrayList();
            List<CrashDetailBean> b3 = mo34680b(b2);
            if (b3 != null && b3.size() > 0) {
                String str = C7174a.m30754b().f24035p;
                Iterator it2 = b3.iterator();
                while (it2.hasNext()) {
                    CrashDetailBean crashDetailBean = (CrashDetailBean) it2.next();
                    if (!str.equals(crashDetailBean.f24121f)) {
                        it2.remove();
                        arrayList2.add(crashDetailBean);
                    }
                }
            }
            if (arrayList2.size() > 0) {
                mo34685d((List<CrashDetailBean>) arrayList2);
            }
            return b3;
        }
    }

    /* renamed from: b */
    public void mo34681b(CrashDetailBean crashDetailBean) {
        if (this.f24183f != null) {
            boolean z = false;
            C7226an.m31147c("Calling 'onCrashHandleEnd' of RQD crash listener.", new Object[0]);
            C7199f fVar = this.f24183f;
            if (crashDetailBean.f24117b == 1) {
                z = true;
            }
            fVar.mo34720b(z);
        }
    }

    /* renamed from: a */
    public void mo34673a(CrashDetailBean crashDetailBean, long j, boolean z) {
        if (C7192c.f24198l) {
            C7226an.m31141a("try to upload right now", new Object[0]);
            ArrayList arrayList = new ArrayList();
            arrayList.add(crashDetailBean);
            mo34674a(arrayList, j, z, crashDetailBean.f24117b == 7, z);
        }
    }

    /* renamed from: a */
    public void mo34674a(final List<CrashDetailBean> list, long j, boolean z, boolean z2, boolean z3) {
        List<CrashDetailBean> list2 = list;
        if (C7174a.m30753a(this.f24179b).f24027h) {
            C7219ak akVar = this.f24180c;
            if (akVar != null) {
                if (z3 || akVar.mo34820b(C7192c.f24187a)) {
                    StrategyBean c = this.f24182e.mo34624c();
                    if (!c.f24057g) {
                        C7226an.m31148d("remote report is disable!", new Object[0]);
                        C7226an.m31144b("[crash] server closed bugly in this app. please check your appid if is correct, and re-install it", new Object[0]);
                        return;
                    }
                    if (!(list2 == null || list.size() == 0)) {
                        try {
                            String str = this.f24180c.f24342b ? c.f24069s : c.f24070t;
                            String str2 = this.f24180c.f24342b ? StrategyBean.f24053c : StrategyBean.f24051a;
                            int i = this.f24180c.f24342b ? 830 : 630;
                            C7249bg a = m30913a(this.f24179b, list, C7174a.m30754b());
                            if (a == null) {
                                C7226an.m31148d("create eupPkg fail!", new Object[0]);
                                return;
                            }
                            byte[] a2 = C7216ah.m31078a((C7267m) a);
                            if (a2 == null) {
                                C7226an.m31148d("send encode fail!", new Object[0]);
                                return;
                            }
                            C7250bh a3 = C7216ah.m31073a(this.f24179b, i, a2);
                            if (a3 == null) {
                                C7226an.m31148d("request package is null.", new Object[0]);
                                return;
                            }
                            C71911 r10 = new C7218aj() {
                                /* renamed from: a */
                                public void mo34468a(int i) {
                                }

                                /* renamed from: a */
                                public void mo34469a(int i, C7251bi biVar, long j, long j2, boolean z, String str) {
                                    C7190b.this.mo34675a(z, list);
                                }
                            };
                            if (z) {
                                this.f24180c.mo34812a(f24178a, a3, str, str2, r10, j, z2);
                            } else {
                                this.f24180c.mo34813a(f24178a, a3, str, str2, r10, false);
                            }
                        } catch (Throwable th) {
                            C7226an.m31149e("req cr error %s", th.toString());
                            if (!C7226an.m31145b(th)) {
                                th.printStackTrace();
                            }
                        }
                    }
                }
            }
        }
    }

    /* renamed from: a */
    public void mo34675a(boolean z, List<CrashDetailBean> list) {
        if (list != null && list.size() > 0) {
            C7226an.m31147c("up finish update state %b", Boolean.valueOf(z));
            for (CrashDetailBean crashDetailBean : list) {
                C7226an.m31147c("pre uid:%s uc:%d re:%b me:%b", crashDetailBean.f24118c, Integer.valueOf(crashDetailBean.f24127l), Boolean.valueOf(crashDetailBean.f24119d), Boolean.valueOf(crashDetailBean.f24125j));
                crashDetailBean.f24127l++;
                crashDetailBean.f24119d = z;
                C7226an.m31147c("set uid:%s uc:%d re:%b me:%b", crashDetailBean.f24118c, Integer.valueOf(crashDetailBean.f24127l), Boolean.valueOf(crashDetailBean.f24119d), Boolean.valueOf(crashDetailBean.f24125j));
            }
            for (CrashDetailBean a : list) {
                C7192c.m30937a().mo34689a(a);
            }
            C7226an.m31147c("update state size %d", Integer.valueOf(list.size()));
        }
        if (!z) {
            C7226an.m31144b("[crash] upload fail.", new Object[0]);
        }
    }

    /* renamed from: c */
    public void mo34682c(CrashDetailBean crashDetailBean) {
        int i;
        String str;
        long j;
        String str2;
        Map map;
        int i2;
        String str3;
        Map map2;
        CrashDetailBean crashDetailBean2 = crashDetailBean;
        if (crashDetailBean2 != null) {
            if (this.f24184g != null || this.f24183f != null) {
                try {
                    C7226an.m31141a("[crash callback] start user's callback:onCrashHandleStart()", new Object[0]);
                    switch (crashDetailBean2.f24117b) {
                        case 0:
                            i = 0;
                            break;
                        case 1:
                            i = 2;
                            break;
                        case 2:
                            i = 1;
                            break;
                        case 3:
                            i = 4;
                            break;
                        case 4:
                            i = 3;
                            break;
                        case 5:
                            i = 5;
                            break;
                        case 6:
                            i = 6;
                            break;
                        case 7:
                            i = 7;
                            break;
                        default:
                            return;
                    }
                    boolean z = crashDetailBean2.f24117b == 1;
                    String str4 = crashDetailBean2.f24129n;
                    String str5 = crashDetailBean2.f24131p;
                    String str6 = crashDetailBean2.f24132q;
                    long j2 = crashDetailBean2.f24133r;
                    byte[] bArr = null;
                    if (this.f24183f != null) {
                        C7226an.m31147c("Calling 'onCrashHandleStart' of RQD crash listener.", new Object[0]);
                        this.f24183f.mo34716a(z);
                        C7226an.m31147c("Calling 'getCrashExtraMessage' of RQD crash listener.", new Object[0]);
                        j = j2;
                        str2 = str5;
                        str = str6;
                        String b = this.f24183f.mo34719b(z, str4, str5, str6, -1234567890, j);
                        if (b != null) {
                            map2 = new HashMap(1);
                            map2.put("userData", b);
                        } else {
                            map2 = null;
                        }
                        map = map2;
                    } else {
                        j = j2;
                        str2 = str5;
                        str = str6;
                        if (this.f24184g != null) {
                            C7226an.m31147c("Calling 'onCrashHandleStart' of Bugly crash listener.", new Object[0]);
                            map = this.f24184g.onCrashHandleStart(i, crashDetailBean2.f24129n, crashDetailBean2.f24130o, crashDetailBean2.f24132q);
                        } else {
                            map = null;
                        }
                    }
                    if (map != null && map.size() > 0) {
                        crashDetailBean2.f24108P = new LinkedHashMap(map.size());
                        for (Entry entry : map.entrySet()) {
                            if (!C7232aq.m31196a((String) entry.getKey())) {
                                String str7 = (String) entry.getKey();
                                if (str7.length() > 100) {
                                    str7 = str7.substring(0, 100);
                                    C7226an.m31148d("setted key length is over limit %d substring to %s", Integer.valueOf(100), str7);
                                }
                                if (C7232aq.m31196a((String) entry.getValue()) || ((String) entry.getValue()).length() <= 30000) {
                                    StringBuilder sb = new StringBuilder();
                                    sb.append("");
                                    sb.append((String) entry.getValue());
                                    str3 = sb.toString();
                                } else {
                                    str3 = ((String) entry.getValue()).substring(((String) entry.getValue()).length() - C7120a.MAX_USERDATA_VALUE_LENGTH);
                                    C7226an.m31148d("setted %s value length is over limit %d substring", str7, Integer.valueOf(C7120a.MAX_USERDATA_VALUE_LENGTH));
                                }
                                crashDetailBean2.f24108P.put(str7, str3);
                                C7226an.m31141a("add setted key %s value size:%d", str7, Integer.valueOf(str3.length()));
                            }
                        }
                    }
                    C7226an.m31141a("[crash callback] start user's callback:onCrashHandleStart2GetExtraDatas()", new Object[0]);
                    if (this.f24183f != null) {
                        C7226an.m31147c("Calling 'getCrashExtraData' of RQD crash listener.", new Object[0]);
                        C7199f fVar = this.f24183f;
                        boolean z2 = z;
                        String str8 = str4;
                        String str9 = str2;
                        String str10 = str;
                        i2 = C7120a.MAX_USERDATA_VALUE_LENGTH;
                        bArr = fVar.mo34718a(z2, str8, str9, str10, -1234567890, j);
                    } else {
                        i2 = C7120a.MAX_USERDATA_VALUE_LENGTH;
                        if (this.f24184g != null) {
                            C7226an.m31147c("Calling 'onCrashHandleStart2GetExtraDatas' of Bugly crash listener.", new Object[0]);
                            bArr = this.f24184g.onCrashHandleStart2GetExtraDatas(i, crashDetailBean2.f24129n, crashDetailBean2.f24130o, crashDetailBean2.f24132q);
                        }
                    }
                    byte[] bArr2 = bArr;
                    crashDetailBean2.f24113U = bArr2;
                    if (bArr2 != null) {
                        if (bArr2.length > i2) {
                            C7226an.m31148d("extra bytes size %d is over limit %d will drop over part", Integer.valueOf(bArr2.length), Integer.valueOf(i2));
                            crashDetailBean2.f24113U = Arrays.copyOf(bArr2, i2);
                        }
                        C7226an.m31141a("add extra bytes %d ", Integer.valueOf(bArr2.length));
                    }
                } catch (Throwable th) {
                    C7226an.m31148d("crash handle callback something wrong! %s", th.getClass().getName());
                    if (!C7226an.m31142a(th)) {
                        th.printStackTrace();
                    }
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public ContentValues mo34684d(CrashDetailBean crashDetailBean) {
        if (crashDetailBean == null) {
            return null;
        }
        try {
            ContentValues contentValues = new ContentValues();
            if (crashDetailBean.f24116a > 0) {
                contentValues.put(C7887a.f26833ID, Long.valueOf(crashDetailBean.f24116a));
            }
            contentValues.put("_tm", Long.valueOf(crashDetailBean.f24133r));
            contentValues.put("_s1", crashDetailBean.f24136u);
            int i = 1;
            contentValues.put("_up", Integer.valueOf(crashDetailBean.f24119d ? 1 : 0));
            String str = "_me";
            if (!crashDetailBean.f24125j) {
                i = 0;
            }
            contentValues.put(str, Integer.valueOf(i));
            contentValues.put("_uc", Integer.valueOf(crashDetailBean.f24127l));
            contentValues.put("_dt", C7232aq.m31199a((Parcelable) crashDetailBean));
            return contentValues;
        } catch (Throwable th) {
            if (!C7226an.m31142a(th)) {
                th.printStackTrace();
            }
            return null;
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public CrashDetailBean mo34668a(Cursor cursor) {
        if (cursor == null) {
            return null;
        }
        try {
            byte[] blob = cursor.getBlob(cursor.getColumnIndex("_dt"));
            if (blob == null) {
                return null;
            }
            long j = cursor.getLong(cursor.getColumnIndex(C7887a.f26833ID));
            CrashDetailBean crashDetailBean = (CrashDetailBean) C7232aq.m31177a(blob, CrashDetailBean.CREATOR);
            if (crashDetailBean != null) {
                crashDetailBean.f24116a = j;
            }
            return crashDetailBean;
        } catch (Throwable th) {
            if (!C7226an.m31142a(th)) {
                th.printStackTrace();
            }
            return null;
        }
    }

    /* renamed from: e */
    public void mo34686e(CrashDetailBean crashDetailBean) {
        if (crashDetailBean != null) {
            ContentValues d = mo34684d(crashDetailBean);
            if (d != null) {
                String str = "t_cr";
                long a = C7212ae.m31041a().mo34774a(str, d, (C7211ad) null, true);
                if (a >= 0) {
                    C7226an.m31147c("insert %s success!", str);
                    crashDetailBean.f24116a = a;
                }
            }
            if (C7192c.f24195i) {
                m30915f(crashDetailBean);
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:52:0x0108 A[Catch:{ all -> 0x0111 }] */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x010d A[DONT_GENERATE] */
    /* renamed from: b */
    public java.util.List<com.tencent.bugly.crashreport.crash.CrashDetailBean> mo34680b(java.util.List<com.tencent.bugly.crashreport.crash.C7181a> r17) {
        /*
        r16 = this;
        r1 = 0
        if (r17 == 0) goto L_0x0118
        int r0 = r17.size()
        if (r0 != 0) goto L_0x000b
        goto L_0x0118
    L_0x000b:
        java.lang.StringBuilder r0 = new java.lang.StringBuilder
        r0.<init>()
        java.lang.String r2 = "_id"
        r0.append(r2)
        java.lang.String r3 = " in "
        r0.append(r3)
        java.lang.String r4 = "("
        r0.append(r4)
        java.util.Iterator r5 = r17.iterator()
    L_0x0023:
        boolean r6 = r5.hasNext()
        java.lang.String r7 = ","
        if (r6 == 0) goto L_0x003a
        java.lang.Object r6 = r5.next()
        com.tencent.bugly.crashreport.crash.a r6 = (com.tencent.bugly.crashreport.crash.C7181a) r6
        long r8 = r6.f24142a
        r0.append(r8)
        r0.append(r7)
        goto L_0x0023
    L_0x003a:
        java.lang.String r5 = r0.toString()
        boolean r5 = r5.contains(r7)
        r6 = 0
        if (r5 == 0) goto L_0x0053
        java.lang.StringBuilder r5 = new java.lang.StringBuilder
        int r8 = r0.lastIndexOf(r7)
        java.lang.String r0 = r0.substring(r6, r8)
        r5.<init>(r0)
        r0 = r5
    L_0x0053:
        java.lang.String r5 = ")"
        r0.append(r5)
        java.lang.String r11 = r0.toString()
        r0.setLength(r6)
        com.tencent.bugly.proguard.ae r8 = com.tencent.bugly.proguard.C7212ae.m31041a()     // Catch:{ all -> 0x00fe }
        java.lang.String r9 = "t_cr"
        r10 = 0
        r12 = 0
        r13 = 0
        r14 = 1
        android.database.Cursor r8 = r8.mo34775a(r9, r10, r11, r12, r13, r14)     // Catch:{ all -> 0x00fe }
        if (r8 != 0) goto L_0x0075
        if (r8 == 0) goto L_0x0074
        r8.close()
    L_0x0074:
        return r1
    L_0x0075:
        java.util.ArrayList r9 = new java.util.ArrayList     // Catch:{ all -> 0x00fa }
        r9.<init>()     // Catch:{ all -> 0x00fa }
        r0.append(r2)     // Catch:{ all -> 0x00fa }
        r0.append(r3)     // Catch:{ all -> 0x00fa }
        r0.append(r4)     // Catch:{ all -> 0x00fa }
        r3 = 0
    L_0x0084:
        boolean r4 = r8.moveToNext()     // Catch:{ all -> 0x00fa }
        if (r4 == 0) goto L_0x00af
        r4 = r16
        com.tencent.bugly.crashreport.crash.CrashDetailBean r10 = r4.mo34668a(r8)     // Catch:{ all -> 0x00f8 }
        if (r10 == 0) goto L_0x0096
        r9.add(r10)     // Catch:{ all -> 0x00f8 }
        goto L_0x0084
    L_0x0096:
        int r10 = r8.getColumnIndex(r2)     // Catch:{ all -> 0x00a7 }
        long r10 = r8.getLong(r10)     // Catch:{ all -> 0x00a7 }
        r0.append(r10)     // Catch:{ all -> 0x00a7 }
        r0.append(r7)     // Catch:{ all -> 0x00a7 }
        int r3 = r3 + 1
        goto L_0x0084
    L_0x00a7:
        java.lang.String r10 = "unknown id!"
        java.lang.Object[] r11 = new java.lang.Object[r6]     // Catch:{ all -> 0x00f8 }
        com.tencent.bugly.proguard.C7226an.m31148d(r10, r11)     // Catch:{ all -> 0x00f8 }
        goto L_0x0084
    L_0x00af:
        r4 = r16
        java.lang.String r2 = r0.toString()     // Catch:{ all -> 0x00f8 }
        boolean r2 = r2.contains(r7)     // Catch:{ all -> 0x00f8 }
        if (r2 == 0) goto L_0x00c9
        java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x00f8 }
        int r7 = r0.lastIndexOf(r7)     // Catch:{ all -> 0x00f8 }
        java.lang.String r0 = r0.substring(r6, r7)     // Catch:{ all -> 0x00f8 }
        r2.<init>(r0)     // Catch:{ all -> 0x00f8 }
        r0 = r2
    L_0x00c9:
        r0.append(r5)     // Catch:{ all -> 0x00f8 }
        java.lang.String r12 = r0.toString()     // Catch:{ all -> 0x00f8 }
        if (r3 <= 0) goto L_0x00f2
        com.tencent.bugly.proguard.ae r10 = com.tencent.bugly.proguard.C7212ae.m31041a()     // Catch:{ all -> 0x00f8 }
        java.lang.String r11 = "t_cr"
        r13 = 0
        r14 = 0
        r15 = 1
        int r0 = r10.mo34773a(r11, r12, r13, r14, r15)     // Catch:{ all -> 0x00f8 }
        java.lang.String r2 = "deleted %s illegal data %d"
        r3 = 2
        java.lang.Object[] r3 = new java.lang.Object[r3]     // Catch:{ all -> 0x00f8 }
        java.lang.String r5 = "t_cr"
        r3[r6] = r5     // Catch:{ all -> 0x00f8 }
        java.lang.Integer r0 = java.lang.Integer.valueOf(r0)     // Catch:{ all -> 0x00f8 }
        r5 = 1
        r3[r5] = r0     // Catch:{ all -> 0x00f8 }
        com.tencent.bugly.proguard.C7226an.m31148d(r2, r3)     // Catch:{ all -> 0x00f8 }
    L_0x00f2:
        if (r8 == 0) goto L_0x00f7
        r8.close()
    L_0x00f7:
        return r9
    L_0x00f8:
        r0 = move-exception
        goto L_0x0102
    L_0x00fa:
        r0 = move-exception
        r4 = r16
        goto L_0x0102
    L_0x00fe:
        r0 = move-exception
        r4 = r16
        r8 = r1
    L_0x0102:
        boolean r2 = com.tencent.bugly.proguard.C7226an.m31142a(r0)     // Catch:{ all -> 0x0111 }
        if (r2 != 0) goto L_0x010b
        r0.printStackTrace()     // Catch:{ all -> 0x0111 }
    L_0x010b:
        if (r8 == 0) goto L_0x0110
        r8.close()
    L_0x0110:
        return r1
    L_0x0111:
        r0 = move-exception
        if (r8 == 0) goto L_0x0117
        r8.close()
    L_0x0117:
        throw r0
    L_0x0118:
        r4 = r16
        return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.crashreport.crash.C7190b.mo34680b(java.util.List):java.util.List");
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public C7181a mo34678b(Cursor cursor) {
        if (cursor == null) {
            return null;
        }
        try {
            C7181a aVar = new C7181a();
            aVar.f24142a = cursor.getLong(cursor.getColumnIndex(C7887a.f26833ID));
            aVar.f24143b = cursor.getLong(cursor.getColumnIndex("_tm"));
            aVar.f24144c = cursor.getString(cursor.getColumnIndex("_s1"));
            boolean z = false;
            aVar.f24145d = cursor.getInt(cursor.getColumnIndex("_up")) == 1;
            if (cursor.getInt(cursor.getColumnIndex("_me")) == 1) {
                z = true;
            }
            aVar.f24146e = z;
            aVar.f24147f = cursor.getInt(cursor.getColumnIndex("_uc"));
            return aVar;
        } catch (Throwable th) {
            if (!C7226an.m31142a(th)) {
                th.printStackTrace();
            }
            return null;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:43:0x00ce A[Catch:{ all -> 0x00d7 }] */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00d3 A[DONT_GENERATE] */
    /* renamed from: b */
    public java.util.List<com.tencent.bugly.crashreport.crash.C7181a> mo34679b() {
        /*
        r16 = this;
        java.lang.String r0 = "_id"
        java.util.ArrayList r1 = new java.util.ArrayList
        r1.<init>()
        r2 = 0
        java.lang.String r3 = "_id"
        java.lang.String r4 = "_tm"
        java.lang.String r5 = "_s1"
        java.lang.String r6 = "_up"
        java.lang.String r7 = "_me"
        java.lang.String r8 = "_uc"
        java.lang.String[] r11 = new java.lang.String[]{r3, r4, r5, r6, r7, r8}     // Catch:{ all -> 0x00c4 }
        com.tencent.bugly.proguard.ae r9 = com.tencent.bugly.proguard.C7212ae.m31041a()     // Catch:{ all -> 0x00c4 }
        java.lang.String r10 = "t_cr"
        r12 = 0
        r13 = 0
        r14 = 0
        r15 = 1
        android.database.Cursor r3 = r9.mo34775a(r10, r11, r12, r13, r14, r15)     // Catch:{ all -> 0x00c4 }
        if (r3 != 0) goto L_0x002e
        if (r3 == 0) goto L_0x002d
        r3.close()
    L_0x002d:
        return r2
    L_0x002e:
        java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x00c0 }
        r2.<init>()     // Catch:{ all -> 0x00c0 }
        r2.append(r0)     // Catch:{ all -> 0x00c0 }
        java.lang.String r4 = " in "
        r2.append(r4)     // Catch:{ all -> 0x00c0 }
        java.lang.String r4 = "("
        r2.append(r4)     // Catch:{ all -> 0x00c0 }
        r4 = 0
        r5 = 0
    L_0x0042:
        boolean r6 = r3.moveToNext()     // Catch:{ all -> 0x00c0 }
        java.lang.String r7 = ","
        if (r6 == 0) goto L_0x006f
        r6 = r16
        com.tencent.bugly.crashreport.crash.a r8 = r6.mo34678b(r3)     // Catch:{ all -> 0x00be }
        if (r8 == 0) goto L_0x0056
        r1.add(r8)     // Catch:{ all -> 0x00be }
        goto L_0x0042
    L_0x0056:
        int r8 = r3.getColumnIndex(r0)     // Catch:{ all -> 0x0067 }
        long r8 = r3.getLong(r8)     // Catch:{ all -> 0x0067 }
        r2.append(r8)     // Catch:{ all -> 0x0067 }
        r2.append(r7)     // Catch:{ all -> 0x0067 }
        int r5 = r5 + 1
        goto L_0x0042
    L_0x0067:
        java.lang.String r7 = "unknown id!"
        java.lang.Object[] r8 = new java.lang.Object[r4]     // Catch:{ all -> 0x00be }
        com.tencent.bugly.proguard.C7226an.m31148d(r7, r8)     // Catch:{ all -> 0x00be }
        goto L_0x0042
    L_0x006f:
        r6 = r16
        java.lang.String r0 = r2.toString()     // Catch:{ all -> 0x00be }
        boolean r0 = r0.contains(r7)     // Catch:{ all -> 0x00be }
        if (r0 == 0) goto L_0x0089
        java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x00be }
        int r7 = r2.lastIndexOf(r7)     // Catch:{ all -> 0x00be }
        java.lang.String r2 = r2.substring(r4, r7)     // Catch:{ all -> 0x00be }
        r0.<init>(r2)     // Catch:{ all -> 0x00be }
        goto L_0x008a
    L_0x0089:
        r0 = r2
    L_0x008a:
        java.lang.String r2 = ")"
        r0.append(r2)     // Catch:{ all -> 0x00be }
        java.lang.String r9 = r0.toString()     // Catch:{ all -> 0x00be }
        r0.setLength(r4)     // Catch:{ all -> 0x00be }
        if (r5 <= 0) goto L_0x00b8
        com.tencent.bugly.proguard.ae r7 = com.tencent.bugly.proguard.C7212ae.m31041a()     // Catch:{ all -> 0x00be }
        java.lang.String r8 = "t_cr"
        r10 = 0
        r11 = 0
        r12 = 1
        int r0 = r7.mo34773a(r8, r9, r10, r11, r12)     // Catch:{ all -> 0x00be }
        java.lang.String r2 = "deleted %s illegal data %d"
        r5 = 2
        java.lang.Object[] r5 = new java.lang.Object[r5]     // Catch:{ all -> 0x00be }
        java.lang.String r7 = "t_cr"
        r5[r4] = r7     // Catch:{ all -> 0x00be }
        java.lang.Integer r0 = java.lang.Integer.valueOf(r0)     // Catch:{ all -> 0x00be }
        r4 = 1
        r5[r4] = r0     // Catch:{ all -> 0x00be }
        com.tencent.bugly.proguard.C7226an.m31148d(r2, r5)     // Catch:{ all -> 0x00be }
    L_0x00b8:
        if (r3 == 0) goto L_0x00bd
        r3.close()
    L_0x00bd:
        return r1
    L_0x00be:
        r0 = move-exception
        goto L_0x00c8
    L_0x00c0:
        r0 = move-exception
        r6 = r16
        goto L_0x00c8
    L_0x00c4:
        r0 = move-exception
        r6 = r16
        r3 = r2
    L_0x00c8:
        boolean r2 = com.tencent.bugly.proguard.C7226an.m31142a(r0)     // Catch:{ all -> 0x00d7 }
        if (r2 != 0) goto L_0x00d1
        r0.printStackTrace()     // Catch:{ all -> 0x00d7 }
    L_0x00d1:
        if (r3 == 0) goto L_0x00d6
        r3.close()
    L_0x00d6:
        return r1
    L_0x00d7:
        r0 = move-exception
        if (r3 == 0) goto L_0x00dd
        r3.close()
    L_0x00dd:
        throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.crashreport.crash.C7190b.mo34679b():java.util.List");
    }

    /* renamed from: c */
    public void mo34683c(List<C7181a> list) {
        if (list != null && list.size() != 0) {
            StringBuilder sb = new StringBuilder();
            sb.append(C7887a.f26833ID);
            sb.append(" in ");
            sb.append("(");
            Iterator it = list.iterator();
            while (true) {
                boolean hasNext = it.hasNext();
                String str = StorageInterface.KEY_SPLITER;
                if (hasNext) {
                    sb.append(((C7181a) it.next()).f24142a);
                    sb.append(str);
                } else {
                    StringBuilder sb2 = new StringBuilder(sb.substring(0, sb.lastIndexOf(str)));
                    sb2.append(")");
                    String sb3 = sb2.toString();
                    sb2.setLength(0);
                    try {
                        C7226an.m31147c("deleted %s data %d", "t_cr", Integer.valueOf(C7212ae.m31041a().mo34773a("t_cr", sb3, (String[]) null, (C7211ad) null, true)));
                        return;
                    } catch (Throwable th) {
                        if (!C7226an.m31142a(th)) {
                            th.printStackTrace();
                            return;
                        }
                        return;
                    }
                }
            }
        }
    }

    /* renamed from: a */
    public void mo34672a(int i) {
        if (i > 0) {
            StringBuilder sb = new StringBuilder();
            String str = C7887a.f26833ID;
            sb.append(str);
            sb.append(" in ");
            sb.append("(");
            sb.append("SELECT ");
            sb.append(str);
            sb.append(" FROM ");
            String str2 = "t_cr";
            sb.append(str2);
            sb.append(" order by ");
            sb.append(str);
            sb.append(" limit ");
            sb.append(i);
            sb.append(")");
            String sb2 = sb.toString();
            sb.setLength(0);
            try {
                C7226an.m31147c("deleted first record %s data %d", str2, Integer.valueOf(C7212ae.m31041a().mo34773a("t_cr", sb2, (String[]) null, (C7211ad) null, true)));
            } catch (Throwable th) {
                if (!C7226an.m31142a(th)) {
                    th.printStackTrace();
                }
            }
        }
    }

    /* renamed from: d */
    public void mo34685d(List<CrashDetailBean> list) {
        if (list != null) {
            try {
                if (list.size() != 0) {
                    StringBuilder sb = new StringBuilder();
                    for (CrashDetailBean crashDetailBean : list) {
                        sb.append(" or ");
                        sb.append(C7887a.f26833ID);
                        sb.append(" = ");
                        sb.append(crashDetailBean.f24116a);
                    }
                    String sb2 = sb.toString();
                    if (sb2.length() > 0) {
                        sb2 = sb2.substring(4);
                    }
                    String str = sb2;
                    sb.setLength(0);
                    C7226an.m31147c("deleted %s data %d", "t_cr", Integer.valueOf(C7212ae.m31041a().mo34773a("t_cr", str, (String[]) null, (C7211ad) null, true)));
                }
            } catch (Throwable th) {
                if (!C7226an.m31142a(th)) {
                    th.printStackTrace();
                }
            }
        }
    }

    /* renamed from: a */
    public static C7248bf m30912a(Context context, CrashDetailBean crashDetailBean, C7174a aVar) {
        Object obj;
        boolean z = false;
        if (context == null || crashDetailBean == null || aVar == null) {
            C7226an.m31148d("enExp args == null", new Object[0]);
            return null;
        }
        C7248bf bfVar = new C7248bf();
        switch (crashDetailBean.f24117b) {
            case 0:
                bfVar.f24461a = crashDetailBean.f24125j ? "200" : "100";
                break;
            case 1:
                bfVar.f24461a = crashDetailBean.f24125j ? SUB_PLATFORM.PHONE : "101";
                break;
            case 2:
                bfVar.f24461a = crashDetailBean.f24125j ? SUB_PLATFORM.PAD : "102";
                break;
            case 3:
                bfVar.f24461a = crashDetailBean.f24125j ? "203" : "103";
                break;
            case 4:
                bfVar.f24461a = crashDetailBean.f24125j ? "204" : "104";
                break;
            case 5:
                bfVar.f24461a = crashDetailBean.f24125j ? "207" : "107";
                break;
            case 6:
                bfVar.f24461a = crashDetailBean.f24125j ? "206" : "106";
                break;
            case 7:
                bfVar.f24461a = crashDetailBean.f24125j ? "208" : "108";
                break;
            default:
                C7226an.m31149e("crash type error! %d", Integer.valueOf(crashDetailBean.f24117b));
                break;
        }
        bfVar.f24462b = crashDetailBean.f24133r;
        bfVar.f24463c = crashDetailBean.f24129n;
        bfVar.f24464d = crashDetailBean.f24130o;
        bfVar.f24465e = crashDetailBean.f24131p;
        bfVar.f24467g = crashDetailBean.f24132q;
        bfVar.f24468h = crashDetailBean.f24141z;
        bfVar.f24469i = crashDetailBean.f24118c;
        bfVar.f24470j = null;
        bfVar.f24472l = crashDetailBean.f24128m;
        bfVar.f24473m = crashDetailBean.f24120e;
        bfVar.f24466f = crashDetailBean.f24094B;
        bfVar.f24480t = C7174a.m30754b().mo34596i();
        bfVar.f24474n = null;
        if (crashDetailBean.f24124i != null && crashDetailBean.f24124i.size() > 0) {
            bfVar.f24475o = new ArrayList<>();
            for (Entry entry : crashDetailBean.f24124i.entrySet()) {
                C7245bc bcVar = new C7245bc();
                bcVar.f24441a = ((PlugInBean) entry.getValue()).f23959a;
                bcVar.f24443c = ((PlugInBean) entry.getValue()).f23961c;
                bcVar.f24445e = ((PlugInBean) entry.getValue()).f23960b;
                bcVar.f24442b = aVar.mo34605r();
                bfVar.f24475o.add(bcVar);
            }
        }
        if (crashDetailBean.f24123h != null && crashDetailBean.f24123h.size() > 0) {
            bfVar.f24476p = new ArrayList<>();
            for (Entry entry2 : crashDetailBean.f24123h.entrySet()) {
                C7245bc bcVar2 = new C7245bc();
                bcVar2.f24441a = ((PlugInBean) entry2.getValue()).f23959a;
                bcVar2.f24443c = ((PlugInBean) entry2.getValue()).f23961c;
                bcVar2.f24445e = ((PlugInBean) entry2.getValue()).f23960b;
                bfVar.f24476p.add(bcVar2);
            }
        }
        String str = "utf-8";
        if (crashDetailBean.f24125j) {
            bfVar.f24471k = crashDetailBean.f24135t;
            if (crashDetailBean.f24134s != null && crashDetailBean.f24134s.length() > 0) {
                if (bfVar.f24477q == null) {
                    bfVar.f24477q = new ArrayList<>();
                }
                try {
                    bfVar.f24477q.add(new C7247be(1, "alltimes.txt", crashDetailBean.f24134s.getBytes(str)));
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                    bfVar.f24477q = null;
                }
            }
            Object[] objArr = new Object[2];
            objArr[0] = Integer.valueOf(bfVar.f24471k);
            objArr[1] = Integer.valueOf(bfVar.f24477q != null ? bfVar.f24477q.size() : 0);
            C7226an.m31147c("crashcount:%d sz:%d", objArr);
        }
        if (crashDetailBean.f24138w != null) {
            if (bfVar.f24477q == null) {
                bfVar.f24477q = new ArrayList<>();
            }
            try {
                bfVar.f24477q.add(new C7247be(1, "log.txt", crashDetailBean.f24138w.getBytes(str)));
            } catch (UnsupportedEncodingException e2) {
                e2.printStackTrace();
                bfVar.f24477q = null;
            }
        }
        if (crashDetailBean.f24139x != null) {
            if (bfVar.f24477q == null) {
                bfVar.f24477q = new ArrayList<>();
            }
            try {
                bfVar.f24477q.add(new C7247be(1, "jniLog.txt", crashDetailBean.f24139x.getBytes(str)));
            } catch (UnsupportedEncodingException e3) {
                e3.printStackTrace();
                bfVar.f24477q = null;
            }
        }
        if (!C7232aq.m31196a(crashDetailBean.f24114V)) {
            if (bfVar.f24477q == null) {
                bfVar.f24477q = new ArrayList<>();
            }
            try {
                obj = new C7247be(1, "crashInfos.txt", crashDetailBean.f24114V.getBytes(str));
            } catch (UnsupportedEncodingException e4) {
                e4.printStackTrace();
                obj = null;
            }
            if (obj != null) {
                C7226an.m31147c("attach crash infos", new Object[0]);
                bfVar.f24477q.add(obj);
            }
        }
        if (crashDetailBean.f24115W != null) {
            if (bfVar.f24477q == null) {
                bfVar.f24477q = new ArrayList<>();
            }
            C7247be a = m30911a("backupRecord.zip", context, crashDetailBean.f24115W);
            if (a != null) {
                C7226an.m31147c("attach backup record", new Object[0]);
                bfVar.f24477q.add(a);
            }
        }
        if (crashDetailBean.f24140y != null && crashDetailBean.f24140y.length > 0) {
            C7247be beVar = new C7247be(2, "buglylog.zip", crashDetailBean.f24140y);
            C7226an.m31147c("attach user log", new Object[0]);
            if (bfVar.f24477q == null) {
                bfVar.f24477q = new ArrayList<>();
            }
            bfVar.f24477q.add(beVar);
        }
        if (crashDetailBean.f24117b == 3) {
            if (bfVar.f24477q == null) {
                bfVar.f24477q = new ArrayList<>();
            }
            C7226an.m31147c("crashBean.userDatas:%s", crashDetailBean.f24108P);
            if (crashDetailBean.f24108P != null) {
                String str2 = "BUGLY_CR_01";
                if (crashDetailBean.f24108P.containsKey(str2)) {
                    try {
                        if (!TextUtils.isEmpty((CharSequence) crashDetailBean.f24108P.get(str2))) {
                            bfVar.f24477q.add(new C7247be(1, "anrMessage.txt", ((String) crashDetailBean.f24108P.get(str2)).getBytes(str)));
                            C7226an.m31147c("attach anr message", new Object[0]);
                        }
                    } catch (UnsupportedEncodingException e5) {
                        e5.printStackTrace();
                        bfVar.f24477q = null;
                    }
                    crashDetailBean.f24108P.remove(str2);
                }
            }
            if (crashDetailBean.f24137v != null) {
                C7247be a2 = m30911a("trace.zip", context, crashDetailBean.f24137v);
                if (a2 != null) {
                    C7226an.m31147c("attach traces", new Object[0]);
                    bfVar.f24477q.add(a2);
                }
            }
        }
        if (crashDetailBean.f24117b == 1) {
            if (bfVar.f24477q == null) {
                bfVar.f24477q = new ArrayList<>();
            }
            if (crashDetailBean.f24137v != null) {
                C7247be a3 = m30911a("tomb.zip", context, crashDetailBean.f24137v);
                if (a3 != null) {
                    C7226an.m31147c("attach tombs", new Object[0]);
                    bfVar.f24477q.add(a3);
                }
            }
        }
        if (aVar.f23973K != null && !aVar.f23973K.isEmpty()) {
            if (bfVar.f24477q == null) {
                bfVar.f24477q = new ArrayList<>();
            }
            StringBuilder sb = new StringBuilder();
            for (String append : aVar.f23973K) {
                sb.append(append);
            }
            try {
                bfVar.f24477q.add(new C7247be(1, "martianlog.txt", sb.toString().getBytes(str)));
                C7226an.m31147c("attach pageTracingList", new Object[0]);
            } catch (UnsupportedEncodingException e6) {
                e6.printStackTrace();
            }
        }
        if (crashDetailBean.f24113U != null && crashDetailBean.f24113U.length > 0) {
            if (bfVar.f24477q == null) {
                bfVar.f24477q = new ArrayList<>();
            }
            bfVar.f24477q.add(new C7247be(1, "userExtraByteData", crashDetailBean.f24113U));
            C7226an.m31147c("attach extraData", new Object[0]);
        }
        bfVar.f24478r = new HashMap();
        Map<String, String> map = bfVar.f24478r;
        StringBuilder sb2 = new StringBuilder();
        String str3 = "";
        sb2.append(str3);
        sb2.append(crashDetailBean.f24095C);
        map.put("A9", sb2.toString());
        Map<String, String> map2 = bfVar.f24478r;
        StringBuilder sb3 = new StringBuilder();
        sb3.append(str3);
        sb3.append(crashDetailBean.f24096D);
        map2.put("A11", sb3.toString());
        Map<String, String> map3 = bfVar.f24478r;
        StringBuilder sb4 = new StringBuilder();
        sb4.append(str3);
        sb4.append(crashDetailBean.f24097E);
        map3.put("A10", sb4.toString());
        Map<String, String> map4 = bfVar.f24478r;
        StringBuilder sb5 = new StringBuilder();
        sb5.append(str3);
        sb5.append(crashDetailBean.f24121f);
        map4.put("A23", sb5.toString());
        Map<String, String> map5 = bfVar.f24478r;
        StringBuilder sb6 = new StringBuilder();
        sb6.append(str3);
        sb6.append(aVar.f24031l);
        map5.put("A7", sb6.toString());
        Map<String, String> map6 = bfVar.f24478r;
        StringBuilder sb7 = new StringBuilder();
        sb7.append(str3);
        sb7.append(aVar.mo34606s());
        map6.put("A6", sb7.toString());
        Map<String, String> map7 = bfVar.f24478r;
        StringBuilder sb8 = new StringBuilder();
        sb8.append(str3);
        sb8.append(aVar.mo34605r());
        map7.put("A5", sb8.toString());
        Map<String, String> map8 = bfVar.f24478r;
        StringBuilder sb9 = new StringBuilder();
        sb9.append(str3);
        sb9.append(aVar.mo34595h());
        map8.put("A22", sb9.toString());
        Map<String, String> map9 = bfVar.f24478r;
        StringBuilder sb10 = new StringBuilder();
        sb10.append(str3);
        sb10.append(crashDetailBean.f24099G);
        map9.put("A2", sb10.toString());
        Map<String, String> map10 = bfVar.f24478r;
        StringBuilder sb11 = new StringBuilder();
        sb11.append(str3);
        sb11.append(crashDetailBean.f24098F);
        map10.put("A1", sb11.toString());
        Map<String, String> map11 = bfVar.f24478r;
        StringBuilder sb12 = new StringBuilder();
        sb12.append(str3);
        sb12.append(aVar.f24033n);
        map11.put("A24", sb12.toString());
        Map<String, String> map12 = bfVar.f24478r;
        StringBuilder sb13 = new StringBuilder();
        sb13.append(str3);
        sb13.append(crashDetailBean.f24100H);
        map12.put("A17", sb13.toString());
        Map<String, String> map13 = bfVar.f24478r;
        StringBuilder sb14 = new StringBuilder();
        sb14.append(str3);
        sb14.append(aVar.mo34598k());
        map13.put("A3", sb14.toString());
        Map<String, String> map14 = bfVar.f24478r;
        StringBuilder sb15 = new StringBuilder();
        sb15.append(str3);
        sb15.append(aVar.mo34600m());
        map14.put("A16", sb15.toString());
        Map<String, String> map15 = bfVar.f24478r;
        StringBuilder sb16 = new StringBuilder();
        sb16.append(str3);
        sb16.append(aVar.mo34601n());
        map15.put("A25", sb16.toString());
        Map<String, String> map16 = bfVar.f24478r;
        StringBuilder sb17 = new StringBuilder();
        sb17.append(str3);
        sb17.append(aVar.mo34599l());
        map16.put("A14", sb17.toString());
        Map<String, String> map17 = bfVar.f24478r;
        StringBuilder sb18 = new StringBuilder();
        sb18.append(str3);
        sb18.append(aVar.mo34610w());
        map17.put("A15", sb18.toString());
        Map<String, String> map18 = bfVar.f24478r;
        StringBuilder sb19 = new StringBuilder();
        sb19.append(str3);
        sb19.append(aVar.mo34611x());
        map18.put("A13", sb19.toString());
        Map<String, String> map19 = bfVar.f24478r;
        StringBuilder sb20 = new StringBuilder();
        sb20.append(str3);
        sb20.append(crashDetailBean.f24093A);
        map19.put("A34", sb20.toString());
        if (aVar.f23966D != null) {
            Map<String, String> map20 = bfVar.f24478r;
            StringBuilder sb21 = new StringBuilder();
            sb21.append(str3);
            sb21.append(aVar.f23966D);
            map20.put("productIdentify", sb21.toString());
        }
        try {
            StringBuilder sb22 = new StringBuilder();
            sb22.append(str3);
            sb22.append(URLEncoder.encode(crashDetailBean.f24101I, str));
            bfVar.f24478r.put("A26", sb22.toString());
        } catch (UnsupportedEncodingException e7) {
            e7.printStackTrace();
        }
        if (crashDetailBean.f24117b == 1) {
            Map<String, String> map21 = bfVar.f24478r;
            StringBuilder sb23 = new StringBuilder();
            sb23.append(str3);
            sb23.append(crashDetailBean.f24104L);
            map21.put("A27", sb23.toString());
            Map<String, String> map22 = bfVar.f24478r;
            StringBuilder sb24 = new StringBuilder();
            sb24.append(str3);
            sb24.append(crashDetailBean.f24103K);
            map22.put("A28", sb24.toString());
            Map<String, String> map23 = bfVar.f24478r;
            StringBuilder sb25 = new StringBuilder();
            sb25.append(str3);
            sb25.append(crashDetailBean.f24126k);
            map23.put("A29", sb25.toString());
        }
        Map<String, String> map24 = bfVar.f24478r;
        StringBuilder sb26 = new StringBuilder();
        sb26.append(str3);
        sb26.append(crashDetailBean.f24105M);
        map24.put("A30", sb26.toString());
        Map<String, String> map25 = bfVar.f24478r;
        StringBuilder sb27 = new StringBuilder();
        sb27.append(str3);
        sb27.append(crashDetailBean.f24106N);
        map25.put("A18", sb27.toString());
        Map<String, String> map26 = bfVar.f24478r;
        StringBuilder sb28 = new StringBuilder();
        sb28.append(str3);
        sb28.append(!crashDetailBean.f24107O);
        map26.put("A36", sb28.toString());
        Map<String, String> map27 = bfVar.f24478r;
        StringBuilder sb29 = new StringBuilder();
        sb29.append(str3);
        sb29.append(aVar.f24042w);
        map27.put("F02", sb29.toString());
        Map<String, String> map28 = bfVar.f24478r;
        StringBuilder sb30 = new StringBuilder();
        sb30.append(str3);
        sb30.append(aVar.f24043x);
        map28.put("F03", sb30.toString());
        Map<String, String> map29 = bfVar.f24478r;
        StringBuilder sb31 = new StringBuilder();
        sb31.append(str3);
        sb31.append(aVar.mo34589e());
        map29.put("F04", sb31.toString());
        Map<String, String> map30 = bfVar.f24478r;
        StringBuilder sb32 = new StringBuilder();
        sb32.append(str3);
        sb32.append(aVar.f24044y);
        map30.put("F05", sb32.toString());
        Map<String, String> map31 = bfVar.f24478r;
        StringBuilder sb33 = new StringBuilder();
        sb33.append(str3);
        sb33.append(aVar.f24041v);
        map31.put("F06", sb33.toString());
        Map<String, String> map32 = bfVar.f24478r;
        StringBuilder sb34 = new StringBuilder();
        sb34.append(str3);
        sb34.append(aVar.f23964B);
        map32.put("F08", sb34.toString());
        Map<String, String> map33 = bfVar.f24478r;
        StringBuilder sb35 = new StringBuilder();
        sb35.append(str3);
        sb35.append(aVar.f23965C);
        map33.put("F09", sb35.toString());
        Map<String, String> map34 = bfVar.f24478r;
        StringBuilder sb36 = new StringBuilder();
        sb36.append(str3);
        sb36.append(aVar.f24045z);
        map34.put("F10", sb36.toString());
        if (crashDetailBean.f24109Q >= 0) {
            Map<String, String> map35 = bfVar.f24478r;
            StringBuilder sb37 = new StringBuilder();
            sb37.append(str3);
            sb37.append(crashDetailBean.f24109Q);
            map35.put("C01", sb37.toString());
        }
        if (crashDetailBean.f24110R >= 0) {
            Map<String, String> map36 = bfVar.f24478r;
            StringBuilder sb38 = new StringBuilder();
            sb38.append(str3);
            sb38.append(crashDetailBean.f24110R);
            map36.put("C02", sb38.toString());
        }
        if (crashDetailBean.f24111S != null && crashDetailBean.f24111S.size() > 0) {
            for (Entry entry3 : crashDetailBean.f24111S.entrySet()) {
                Map<String, String> map37 = bfVar.f24478r;
                StringBuilder sb39 = new StringBuilder();
                sb39.append("C03_");
                sb39.append((String) entry3.getKey());
                map37.put(sb39.toString(), entry3.getValue());
            }
        }
        if (crashDetailBean.f24112T != null && crashDetailBean.f24112T.size() > 0) {
            for (Entry entry4 : crashDetailBean.f24112T.entrySet()) {
                Map<String, String> map38 = bfVar.f24478r;
                StringBuilder sb40 = new StringBuilder();
                sb40.append("C04_");
                sb40.append((String) entry4.getKey());
                map38.put(sb40.toString(), entry4.getValue());
            }
        }
        bfVar.f24479s = null;
        if (crashDetailBean.f24108P != null && crashDetailBean.f24108P.size() > 0) {
            bfVar.f24479s = crashDetailBean.f24108P;
            C7226an.m31141a("setted message size %d", Integer.valueOf(bfVar.f24479s.size()));
        }
        Object[] objArr2 = new Object[12];
        objArr2[0] = crashDetailBean.f24129n;
        objArr2[1] = crashDetailBean.f24118c;
        objArr2[2] = aVar.mo34589e();
        objArr2[3] = Long.valueOf((crashDetailBean.f24133r - crashDetailBean.f24106N) / 1000);
        objArr2[4] = Boolean.valueOf(crashDetailBean.f24126k);
        objArr2[5] = Boolean.valueOf(crashDetailBean.f24107O);
        objArr2[6] = Boolean.valueOf(crashDetailBean.f24125j);
        if (crashDetailBean.f24117b == 1) {
            z = true;
        }
        objArr2[7] = Boolean.valueOf(z);
        objArr2[8] = Integer.valueOf(crashDetailBean.f24135t);
        objArr2[9] = crashDetailBean.f24134s;
        objArr2[10] = Boolean.valueOf(crashDetailBean.f24119d);
        objArr2[11] = Integer.valueOf(bfVar.f24478r.size());
        C7226an.m31147c("%s rid:%s sess:%s ls:%ds isR:%b isF:%b isM:%b isN:%b mc:%d ,%s ,isUp:%b ,vm:%d", objArr2);
        return bfVar;
    }

    /* renamed from: a */
    public static C7249bg m30913a(Context context, List<CrashDetailBean> list, C7174a aVar) {
        if (context == null || list == null || list.size() == 0 || aVar == null) {
            C7226an.m31148d("enEXPPkg args == null!", new Object[0]);
            return null;
        }
        C7249bg bgVar = new C7249bg();
        bgVar.f24483a = new ArrayList<>();
        for (CrashDetailBean a : list) {
            bgVar.f24483a.add(m30912a(context, a, aVar));
        }
        return bgVar;
    }

    /* JADX WARNING: Removed duplicated region for block: B:33:0x0090 A[Catch:{ all -> 0x00b2 }] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0095 A[SYNTHETIC, Splitter:B:35:0x0095] */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00a9  */
    /* renamed from: a */
    public static com.tencent.bugly.proguard.C7247be m30911a(java.lang.String r6, android.content.Context r7, java.lang.String r8) {
        /*
        java.lang.String r0 = "del tmp"
        r1 = 0
        r2 = 0
        if (r8 == 0) goto L_0x00d2
        if (r7 != 0) goto L_0x000a
        goto L_0x00d2
    L_0x000a:
        r3 = 1
        java.lang.Object[] r4 = new java.lang.Object[r3]
        r4[r2] = r8
        java.lang.String r5 = "zip %s"
        com.tencent.bugly.proguard.C7226an.m31147c(r5, r4)
        java.io.File r4 = new java.io.File
        r4.<init>(r8)
        java.io.File r8 = new java.io.File
        java.io.File r7 = r7.getCacheDir()
        r8.<init>(r7, r6)
        r6 = 5000(0x1388, float:7.006E-42)
        boolean r6 = com.tencent.bugly.proguard.C7232aq.m31194a(r4, r8, r6)
        if (r6 != 0) goto L_0x0032
        java.lang.Object[] r6 = new java.lang.Object[r2]
        java.lang.String r7 = "zip fail!"
        com.tencent.bugly.proguard.C7226an.m31148d(r7, r6)
        return r1
    L_0x0032:
        java.io.ByteArrayOutputStream r6 = new java.io.ByteArrayOutputStream
        r6.<init>()
        java.io.FileInputStream r7 = new java.io.FileInputStream     // Catch:{ all -> 0x0088 }
        r7.<init>(r8)     // Catch:{ all -> 0x0088 }
        r4 = 4096(0x1000, float:5.74E-42)
        byte[] r4 = new byte[r4]     // Catch:{ all -> 0x0086 }
    L_0x0040:
        int r5 = r7.read(r4)     // Catch:{ all -> 0x0086 }
        if (r5 <= 0) goto L_0x004d
        r6.write(r4, r2, r5)     // Catch:{ all -> 0x0086 }
        r6.flush()     // Catch:{ all -> 0x0086 }
        goto L_0x0040
    L_0x004d:
        byte[] r6 = r6.toByteArray()     // Catch:{ all -> 0x0086 }
        java.lang.String r4 = "read bytes :%d"
        java.lang.Object[] r3 = new java.lang.Object[r3]     // Catch:{ all -> 0x0086 }
        int r5 = r6.length     // Catch:{ all -> 0x0086 }
        java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ all -> 0x0086 }
        r3[r2] = r5     // Catch:{ all -> 0x0086 }
        com.tencent.bugly.proguard.C7226an.m31147c(r4, r3)     // Catch:{ all -> 0x0086 }
        com.tencent.bugly.proguard.be r3 = new com.tencent.bugly.proguard.be     // Catch:{ all -> 0x0086 }
        r4 = 2
        java.lang.String r5 = r8.getName()     // Catch:{ all -> 0x0086 }
        r3.m52576init(r4, r5, r6)     // Catch:{ all -> 0x0086 }
        r7.close()     // Catch:{ IOException -> 0x006d }
        goto L_0x0077
    L_0x006d:
        r6 = move-exception
        boolean r7 = com.tencent.bugly.proguard.C7226an.m31142a(r6)
        if (r7 != 0) goto L_0x0077
        r6.printStackTrace()
    L_0x0077:
        boolean r6 = r8.exists()
        if (r6 == 0) goto L_0x0085
        java.lang.Object[] r6 = new java.lang.Object[r2]
        com.tencent.bugly.proguard.C7226an.m31147c(r0, r6)
        r8.delete()
    L_0x0085:
        return r3
    L_0x0086:
        r6 = move-exception
        goto L_0x008a
    L_0x0088:
        r6 = move-exception
        r7 = r1
    L_0x008a:
        boolean r3 = com.tencent.bugly.proguard.C7226an.m31142a(r6)     // Catch:{ all -> 0x00b2 }
        if (r3 != 0) goto L_0x0093
        r6.printStackTrace()     // Catch:{ all -> 0x00b2 }
    L_0x0093:
        if (r7 == 0) goto L_0x00a3
        r7.close()     // Catch:{ IOException -> 0x0099 }
        goto L_0x00a3
    L_0x0099:
        r6 = move-exception
        boolean r7 = com.tencent.bugly.proguard.C7226an.m31142a(r6)
        if (r7 != 0) goto L_0x00a3
        r6.printStackTrace()
    L_0x00a3:
        boolean r6 = r8.exists()
        if (r6 == 0) goto L_0x00b1
        java.lang.Object[] r6 = new java.lang.Object[r2]
        com.tencent.bugly.proguard.C7226an.m31147c(r0, r6)
        r8.delete()
    L_0x00b1:
        return r1
    L_0x00b2:
        r6 = move-exception
        if (r7 == 0) goto L_0x00c3
        r7.close()     // Catch:{ IOException -> 0x00b9 }
        goto L_0x00c3
    L_0x00b9:
        r7 = move-exception
        boolean r1 = com.tencent.bugly.proguard.C7226an.m31142a(r7)
        if (r1 != 0) goto L_0x00c3
        r7.printStackTrace()
    L_0x00c3:
        boolean r7 = r8.exists()
        if (r7 == 0) goto L_0x00d1
        java.lang.Object[] r7 = new java.lang.Object[r2]
        com.tencent.bugly.proguard.C7226an.m31147c(r0, r7)
        r8.delete()
    L_0x00d1:
        throw r6
    L_0x00d2:
        java.lang.Object[] r6 = new java.lang.Object[r2]
        java.lang.String r7 = "rqdp{  createZipAttachment sourcePath == null || context == null ,pls check}"
        com.tencent.bugly.proguard.C7226an.m31148d(r7, r6)
        return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.crashreport.crash.C7190b.m30911a(java.lang.String, android.content.Context, java.lang.String):com.tencent.bugly.proguard.be");
    }

    /* renamed from: f */
    private boolean m30915f(CrashDetailBean crashDetailBean) {
        try {
            C7226an.m31147c("save eup logs", new Object[0]);
            C7174a b = C7174a.m30754b();
            String f = b.mo34591f();
            String str = b.f24035p;
            String str2 = crashDetailBean.f24093A;
            b.getClass();
            String format = String.format(Locale.US, "#--------\npackage:%s\nversion:%s\nsdk:%s\nprocess:%s\ndate:%s\ntype:%s\nmessage:%s\nstack:\n%s\neupID:%s\n", new Object[]{f, str, "3.1.0", str2, C7232aq.m31184a(new Date(crashDetailBean.f24133r)), crashDetailBean.f24129n, crashDetailBean.f24130o, crashDetailBean.f24132q, crashDetailBean.f24118c});
            String str3 = null;
            if (C7192c.f24196j != null) {
                File file = new File(C7192c.f24196j);
                if (file.isFile()) {
                    file = file.getParentFile();
                }
                str3 = file.getAbsolutePath();
            } else if (Environment.getExternalStorageState().equals("mounted")) {
                String absolutePath = Environment.getExternalStorageDirectory().getAbsolutePath();
                StringBuilder sb = new StringBuilder();
                sb.append(absolutePath);
                sb.append("/Tencent/");
                sb.append(this.f24179b.getPackageName());
                str3 = sb.toString();
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append(str3);
            sb2.append("/euplog.txt");
            C7232aq.m31190a(this.f24179b, sb2.toString(), format, C7192c.f24197k);
            return true;
        } catch (Throwable th) {
            C7226an.m31148d("rqdp{  save error} %s", th.toString());
            if (!C7226an.m31142a(th)) {
                th.printStackTrace();
            }
            return false;
        }
    }

    /* renamed from: a */
    public static void m30914a(String str, String str2, String str3, String str4, String str5, CrashDetailBean crashDetailBean) {
        String str6;
        C7174a b = C7174a.m30754b();
        if (b != null) {
            C7226an.m31149e("#++++++++++Record By Bugly++++++++++#", new Object[0]);
            C7226an.m31149e("# You can use Bugly(http:\\\\bugly.qq.com) to get more Crash Detail!", new Object[0]);
            C7226an.m31149e("# PKG NAME: %s", b.f24023d);
            C7226an.m31149e("# APP VER: %s", b.f24035p);
            C7226an.m31149e("# LAUNCH TIME: %s", C7232aq.m31184a(new Date(C7174a.m30754b().f23989a)));
            C7226an.m31149e("# CRASH TYPE: %s", str);
            C7226an.m31149e("# CRASH TIME: %s", str2);
            C7226an.m31149e("# CRASH PROCESS: %s", str3);
            C7226an.m31149e("# CRASH THREAD: %s", str4);
            if (crashDetailBean != null) {
                C7226an.m31149e("# REPORT ID: %s", crashDetailBean.f24118c);
                Object[] objArr = new Object[2];
                objArr[0] = b.f24032m;
                objArr[1] = b.mo34611x().booleanValue() ? "ROOTED" : "UNROOT";
                C7226an.m31149e("# CRASH DEVICE: %s %s", objArr);
                C7226an.m31149e("# RUNTIME AVAIL RAM:%d ROM:%d SD:%d", Long.valueOf(crashDetailBean.f24095C), Long.valueOf(crashDetailBean.f24096D), Long.valueOf(crashDetailBean.f24097E));
                C7226an.m31149e("# RUNTIME TOTAL RAM:%d ROM:%d SD:%d", Long.valueOf(crashDetailBean.f24098F), Long.valueOf(crashDetailBean.f24099G), Long.valueOf(crashDetailBean.f24100H));
                if (!C7232aq.m31196a(crashDetailBean.f24104L)) {
                    C7226an.m31149e("# EXCEPTION FIRED BY %s %s", crashDetailBean.f24104L, crashDetailBean.f24103K);
                } else if (crashDetailBean.f24117b == 3) {
                    Object[] objArr2 = new Object[1];
                    if (crashDetailBean.f24108P == null) {
                        str6 = "null";
                    } else {
                        StringBuilder sb = new StringBuilder();
                        sb.append("");
                        sb.append((String) crashDetailBean.f24108P.get("BUGLY_CR_01"));
                        str6 = sb.toString();
                    }
                    objArr2[0] = str6;
                    C7226an.m31149e("# EXCEPTION ANR MESSAGE:\n %s", objArr2);
                }
            }
            if (!C7232aq.m31196a(str5)) {
                C7226an.m31149e("# CRASH STACK: ", new Object[0]);
                C7226an.m31149e(str5, new Object[0]);
            }
            C7226an.m31149e("#++++++++++++++++++++++++++++++++++++++++++#", new Object[0]);
        }
    }
}
