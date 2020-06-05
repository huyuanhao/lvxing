package com.p368pw.inner.appwall;

import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.p368pw.inner.C4817a;
import com.p368pw.inner.C5233e;
import com.p368pw.inner.C5237f;
import com.p368pw.inner.appwall.C4983ad.C4987b;
import com.p368pw.inner.appwall.C5041p.C5042a;
import com.p368pw.inner.base.C5114a.C5117a;
import com.p368pw.inner.base.p384a.C5125f;
import com.p368pw.inner.base.p385b.C5131a.C5134a;
import com.p368pw.inner.base.p385b.C5138c;
import com.p368pw.inner.base.p387d.C5187e;
import com.p368pw.inner.base.p387d.C5188f;
import com.p368pw.inner.base.p387d.C5189g;
import com.p368pw.inner.base.p387d.C5191i;
import com.p368pw.inner.base.p387d.C5204n;
import com.p368pw.inner.base.p387d.C5205o;
import com.p368pw.inner.base.p387d.C5206p;
import com.p368pw.inner.base.p387d.C5207q;
import com.p368pw.inner.base.p387d.C5208r;
import com.p368pw.inner.base.p387d.C5211s;
import com.p368pw.inner.base.p387d.p388a.C5153c;
import com.p368pw.inner.base.p387d.p388a.C5153c.C5158b;
import com.p368pw.inner.base.stat.C5224e;
import com.p368pw.inner.p369a.C4819a.C4820a;
import com.p368pw.inner.p369a.p379e.C4933e.C4940a;
import com.p368pw.p392us.Setting;
import com.p368pw.view.AppWallActivity;
import com.tencent.mid.core.Constants.ERROR;
import com.tencent.mid.sotrage.StorageInterface;
import com.tmsdk.module.coin.ErrorCode;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map.Entry;
import java.util.Set;

/* renamed from: com.pw.inner.appwall.aa */
public class C4970aa {
    /* renamed from: a */
    private List<C5047t> f16165a;
    /* renamed from: b */
    private Date f16166b;
    /* renamed from: c */
    private final Set<String> f16167c;
    /* renamed from: d */
    private HashMap<String, Long> f16168d;
    /* renamed from: e */
    private boolean f16169e;
    /* renamed from: f */
    private boolean f16170f;
    /* renamed from: g */
    private int f16171g;
    /* renamed from: h */
    private int f16172h;
    /* renamed from: i */
    private int f16173i;
    /* renamed from: j */
    private int f16174j;
    /* renamed from: k */
    private Setting f16175k;
    /* renamed from: l */
    private WeakReference<AppWallActivity> f16176l;
    /* access modifiers changed from: private */
    /* renamed from: m */
    public C4983ad f16177m;
    /* access modifiers changed from: private */
    /* renamed from: n */
    public C4978a f16178n;

    /* renamed from: com.pw.inner.appwall.aa$a */
    public interface C4978a {
        void onActivate(String str);

        void onInstallStart(C5047t tVar);

        void onInstalled();

        void onOfferDialogDismiss();

        void onRefresh();
    }

    /* renamed from: com.pw.inner.appwall.aa$b */
    private static class C4979b {
        /* access modifiers changed from: private|static */
        /* renamed from: a */
        public static C4970aa f16202a = new C4970aa();
    }

    private C4970aa() {
        this.f16167c = new HashSet();
        this.f16169e = false;
        this.f16170f = false;
        this.f16171g = 343;
    }

    /* renamed from: a */
    public static C4970aa m20784a() {
        return C4979b.f16202a;
    }

    /* renamed from: a */
    public static String m20787a(boolean z, double d) {
        if (z) {
            return String.format(Locale.getDefault(), "+%d", new Object[]{Integer.valueOf((int) d)});
        }
        return String.format(Locale.getDefault(), "+%.2f", new Object[]{Double.valueOf(d)});
    }

    /* renamed from: a */
    public static void m20788a(Context context, String str, String str2) {
        C5206p.m21471a(context, str, str2);
    }

    /* renamed from: a */
    public static boolean m20789a(Context context) {
        if (VERSION.SDK_INT >= 21) {
            return C5191i.m21422y(context.getApplicationContext()) && C5191i.m21423z(context.getApplicationContext());
        }
        return true;
    }

    /* renamed from: b */
    public static String m20791b(Context context, String str) {
        return C5206p.m21472b(context, str);
    }

    /* renamed from: b */
    private void m20792b(Context context) {
        try {
            if (this.f16168d == null) {
                this.f16168d = new HashMap<>();
            }
            String b = m20791b(context, "waw_bn");
            if (!TextUtils.isEmpty(b)) {
                String[] split = b.split(";");
                boolean z = false;
                if (split.length > 0) {
                    boolean z2 = false;
                    for (String split2 : split) {
                        String[] split3 = split2.split(StorageInterface.KEY_SPLITER);
                        if (split3.length >= 2) {
                            long longValue = Long.valueOf(split3[1]).longValue();
                            if (C5187e.m21371a(longValue)) {
                                this.f16168d.put(split3[0], Long.valueOf(longValue));
                            } else {
                                z2 = true;
                            }
                        }
                    }
                    z = z2;
                }
                if (z) {
                    mo26317a(context, (String) null);
                }
            }
        } catch (Throwable th) {
            C5205o.m21464a(th);
        }
    }

    /* renamed from: i */
    private void m20793i() {
        try {
            if (!this.f16169e) {
                C5030k e = C5125f.m21216a().mo26728e();
                if (e != null) {
                    this.f16171g = 399;
                    this.f16172h = e.mo26434a();
                    this.f16173i = e.mo26435b();
                    this.f16174j = e.mo26436c();
                    this.f16169e = true;
                }
            }
        } catch (Throwable unused) {
        }
    }

    /* renamed from: j */
    private void m20794j() {
        Date time = Calendar.getInstance().getTime();
        if (!C5189g.m21380a(this.f16166b, time)) {
            this.f16167c.clear();
        }
        this.f16166b = time;
    }

    /* renamed from: a */
    public C5047t mo26311a(List<C5047t> list) {
        try {
            if (C5188f.m21377a((Collection) list)) {
                return null;
            }
            C5047t tVar = null;
            double d = 0.0d;
            C5047t tVar2 = null;
            C5047t tVar3 = null;
            for (int i = 0; i < list.size(); i++) {
                C5047t tVar4 = (C5047t) list.get(i);
                C5034m d2 = tVar4.mo26542d();
                if (d2 != null) {
                    if (tVar4.mo26540b() == 2) {
                        C5042a d3 = d2.mo26469d();
                        if (!d3.mo26488i()) {
                            double a = d3.mo26479a(m20784a().mo26333e());
                            if (a > d) {
                                tVar = tVar4;
                                d = a;
                            }
                        }
                    } else if (tVar4.mo26540b() == 3) {
                        if (tVar2 == null) {
                            tVar2 = tVar4;
                        }
                    } else if (tVar4.mo26540b() == 1 && tVar3 == null) {
                        tVar3 = tVar4;
                    }
                }
            }
            if (tVar2 == null) {
                tVar2 = tVar3;
            }
            if (tVar2 == null) {
                tVar2 = tVar;
            }
            return tVar2;
        } catch (Throwable th) {
            C5205o.m21464a(th);
            return null;
        }
    }

    /* renamed from: a */
    public List<C5047t> mo26312a(List<C5138c> list, List<C5034m> list2, List<C5034m> list3, List<C5034m> list4, boolean z) {
        int i;
        int i2;
        int i3;
        List<C5034m> list5 = list2;
        List<C5034m> list6 = list3;
        List<C5034m> list7 = list4;
        this.f16165a = new ArrayList();
        C5030k e = C5125f.m21216a().mo26728e();
        int u = e.mo26454u();
        int t = e.mo26453t();
        int v = e.mo26455v();
        if (C5188f.m21379b(list)) {
            C5047t tVar = new C5047t(ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, 4, 6, null, null);
            this.f16165a.add(tVar);
        } else {
            C5047t tVar2 = new C5047t(ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, -1, 0, null, new C5053v(e.mo26438e(), e.mo26439f()));
            this.f16165a.add(tVar2);
        }
        if (list7 != null && !list4.isEmpty()) {
            C5047t tVar3 = new C5047t(v, 2, 3, null, new C5053v(e.mo26447n(), e.mo26448o()));
            this.f16165a.add(tVar3);
            for (int i4 = 0; i4 < list4.size(); i4++) {
                C5047t tVar4 = r5;
                C5047t tVar5 = new C5047t(v, 2, 4, (C5034m) list7.get(i4), null);
                this.f16165a.add(tVar4);
            }
        }
        if (list5 != null && !list2.isEmpty()) {
            C5047t tVar6 = new C5047t(t, 3, 1, null, new C5053v(e.mo26440g(), e.mo26441h()));
            this.f16165a.add(tVar6);
            if (z) {
                i2 = list2.size();
                i3 = 0;
            } else {
                i3 = 0;
                i2 = 5;
            }
            while (i3 < list2.size() && i3 < i2) {
                C5047t tVar7 = new C5047t(t, 3, 2, (C5034m) list5.get(i3), null);
                this.f16165a.add(tVar7);
                i3++;
            }
            if (i2 < list2.size()) {
                C5047t tVar8 = new C5047t(t, -1, 5, null, null);
                this.f16165a.add(tVar8);
            }
        }
        if (list6 != null && !list3.isEmpty()) {
            C5047t tVar9 = new C5047t(u, 1, 1, null, new C5053v(e.mo26445l(), e.mo26446m()));
            this.f16165a.add(tVar9);
            for (int i5 = 0; i5 < list3.size(); i5++) {
                C5047t tVar10 = new C5047t(u, 1, 2, (C5034m) list6.get(i5), null);
                this.f16165a.add(tVar10);
            }
        }
        Collections.sort(this.f16165a, new Comparator<C5047t>() {
            /* renamed from: a */
            public int compare(C5047t tVar, C5047t tVar2) {
                return tVar2.mo26537a() - tVar.mo26537a();
            }
        });
        int size = this.f16165a.size();
        if (size > 0) {
            int b = ((C5047t) this.f16165a.get(0)).mo26540b();
            int i6 = 1;
            while (true) {
                i = size - 1;
                if (i6 >= i) {
                    break;
                }
                int b2 = ((C5047t) this.f16165a.get(i6)).mo26540b();
                if (b2 != b) {
                    ((C5047t) this.f16165a.get(i6 - 1)).mo26539a(true);
                } else {
                    ((C5047t) this.f16165a.get(i6 - 1)).mo26539a(false);
                }
                i6++;
                b = b2;
            }
            ((C5047t) this.f16165a.get(i)).mo26539a(true);
        }
        return this.f16165a;
    }

    /* renamed from: a */
    public void mo26313a(int i, C5138c cVar) {
        int i2 = i;
        C5138c cVar2 = cVar;
        if (cVar2 != null) {
            if (i2 == 1) {
                try {
                    int i3 = cVar2.f16785n;
                    String str = cVar2.f16786o;
                    String placementId = this.f16175k.getPlacementId();
                    int i4 = this.f16171g;
                    int i5 = this.f16172h;
                    int i6 = this.f16173i;
                    int i7 = this.f16174j;
                    String str2 = cVar2.f16795x;
                    String str3 = str2;
                    C5224e.m21525a().mo26908a(1, 1, "", i3, str, placementId, i4, i5, i6, i7, 0, str3, cVar2.f16788q, cVar2.f16789r, 2, cVar2.f16790s, "", "", -2, 0.0d, cVar.mo26743a(), cVar2.f16772a, cVar2.f16783l, 0, cVar2.f16791t);
                } catch (Throwable th) {
                    C5205o.m21464a(th);
                }
            }
            if (i2 == 3) {
                int i8 = cVar2.f16785n;
                String str4 = cVar2.f16786o;
                String placementId2 = this.f16175k.getPlacementId();
                int i9 = this.f16171g;
                int i10 = this.f16172h;
                int i11 = this.f16173i;
                int i12 = this.f16174j;
                String str5 = cVar2.f16795x;
                String str6 = str5;
                C5224e.m21525a().mo26908a(3, 1, "", i8, str4, placementId2, i9, i10, i11, i12, 0, str6, cVar2.f16788q, cVar2.f16789r, 2, cVar2.f16790s, "", "", cVar2.f16792u, 0.0d, cVar.mo26743a(), cVar2.f16772a, cVar2.f16783l, cVar2.f16784m, cVar2.f16791t);
            }
            if (i2 == 4) {
                int i13 = cVar2.f16785n;
                String str7 = cVar2.f16786o;
                String placementId3 = this.f16175k.getPlacementId();
                int i14 = this.f16171g;
                int i15 = this.f16172h;
                int i16 = this.f16173i;
                int i17 = this.f16174j;
                String str8 = cVar2.f16795x;
                String str9 = str8;
                C5224e.m21525a().mo26908a(4, 1, "", i13, str7, placementId3, i14, i15, i16, i17, 0, str9, cVar2.f16788q, cVar2.f16789r, 2, cVar2.f16790s, "", "", cVar2.f16792u, 0.0d, cVar.mo26743a(), cVar2.f16772a, cVar2.f16783l, cVar2.f16784m, cVar2.f16791t);
            }
            if (i2 == 5) {
                int i18 = cVar2.f16785n;
                String str10 = cVar2.f16786o;
                String placementId4 = this.f16175k.getPlacementId();
                int i19 = this.f16171g;
                int i20 = this.f16172h;
                int i21 = this.f16173i;
                int i22 = this.f16174j;
                String str11 = cVar2.f16795x;
                String str12 = str11;
                C5224e.m21525a().mo26908a(5, 1, "", i18, str10, placementId4, i19, i20, i21, i22, 0, str12, cVar2.f16788q, cVar2.f16789r, 2, cVar2.f16790s, "", "", cVar2.f16792u, 0.0d, cVar.mo26743a(), cVar2.f16772a, cVar2.f16783l, cVar2.f16784m, cVar2.f16791t);
            }
            if (i2 == 6) {
                int i23 = cVar2.f16785n;
                String str13 = cVar2.f16786o;
                String placementId5 = this.f16175k.getPlacementId();
                int i24 = this.f16171g;
                int i25 = this.f16172h;
                int i26 = this.f16173i;
                int i27 = this.f16174j;
                String str14 = cVar2.f16795x;
                String str15 = str14;
                C5224e.m21525a().mo26908a(6, 1, "", i23, str13, placementId5, i24, i25, i26, i27, 0, str15, cVar2.f16788q, cVar2.f16789r, 2, cVar2.f16790s, "", "", cVar2.f16792u, 0.0d, cVar.mo26743a(), cVar2.f16772a, cVar2.f16783l, cVar2.f16784m, cVar2.f16791t);
            }
            if (i2 == 9) {
                int i28 = cVar2.f16785n;
                String str16 = cVar2.f16786o;
                String placementId6 = this.f16175k.getPlacementId();
                int i29 = this.f16171g;
                int i30 = this.f16172h;
                int i31 = this.f16173i;
                int i32 = this.f16174j;
                String str17 = cVar2.f16795x;
                String str18 = str17;
                C5224e.m21525a().mo26908a(9, 1, "", i28, str16, placementId6, i29, i30, i31, i32, 0, str18, cVar2.f16788q, cVar2.f16789r, 2, cVar2.f16790s, "", "", cVar2.f16792u, 0.0d, cVar.mo26743a(), cVar2.f16772a, cVar2.f16783l, cVar2.f16784m, cVar2.f16791t);
            }
            if (i2 == 7) {
                int i33 = cVar2.f16785n;
                String str19 = cVar2.f16786o;
                String placementId7 = this.f16175k.getPlacementId();
                int i34 = this.f16171g;
                int i35 = this.f16172h;
                int i36 = this.f16173i;
                int i37 = this.f16174j;
                String str20 = cVar2.f16795x;
                String str21 = str20;
                C5224e.m21525a().mo26908a(7, 1, "", i33, str19, placementId7, i34, i35, i36, i37, 0, str21, cVar2.f16788q, cVar2.f16789r, 2, cVar2.f16790s, "", "", cVar2.f16792u, 0.0d, cVar.mo26743a(), cVar2.f16772a, cVar2.f16783l, cVar2.f16784m, cVar2.f16791t);
            }
            if (i2 == 8) {
                C5224e a = C5224e.m21525a();
                int i38 = cVar2.f16785n;
                String str22 = cVar2.f16786o;
                String placementId8 = this.f16175k.getPlacementId();
                int i39 = this.f16171g;
                int i40 = this.f16172h;
                int i41 = this.f16173i;
                int i42 = this.f16174j;
                String str23 = cVar2.f16795x;
                String str24 = cVar2.f16788q;
                int i43 = cVar2.f16789r;
                String str25 = cVar2.f16790s;
                int i44 = cVar2.f16792u;
                String str26 = str23;
                a.mo26908a(8, 1, "", i38, str22, placementId8, i39, i40, i41, i42, 0, str26, str24, i43, 2, str25, "", "", i44, cVar2.f16775d, cVar.mo26743a(), cVar2.f16772a, cVar2.f16783l, cVar2.f16784m, cVar2.f16791t);
            }
            if (i2 == 3005) {
                int i45 = cVar2.f16785n;
                String str27 = cVar2.f16786o;
                String placementId9 = this.f16175k.getPlacementId();
                int i46 = this.f16171g;
                int i47 = this.f16172h;
                int i48 = this.f16173i;
                int i49 = this.f16174j;
                String str28 = cVar2.f16795x;
                String str29 = str28;
                C5224e.m21525a().mo26908a((int) ErrorCode.ERC_TASK_CHECK_FAIL, 1, "", i45, str27, placementId9, i46, i47, i48, i49, 0, str29, cVar2.f16788q, cVar2.f16789r, 2, cVar2.f16790s, "", "", cVar2.f16792u, 0.0d, cVar.mo26743a(), cVar2.f16772a, cVar2.f16783l, cVar2.f16784m, cVar2.f16791t);
            }
            if (i2 == 10) {
                int i50 = cVar2.f16785n;
                String str30 = cVar2.f16786o;
                String placementId10 = this.f16175k.getPlacementId();
                int i51 = this.f16171g;
                int i52 = this.f16172h;
                int i53 = this.f16173i;
                int i54 = this.f16174j;
                String str31 = cVar2.f16795x;
                String str32 = str31;
                C5224e.m21525a().mo26908a(10, 1, "", i50, str30, placementId10, i51, i52, i53, i54, 0, str32, cVar2.f16788q, cVar2.f16789r, 2, cVar2.f16790s, "", "", cVar2.f16792u, 0.0d, cVar.mo26743a(), cVar2.f16772a, cVar2.f16783l, cVar2.f16784m, cVar2.f16791t);
            }
            if (i2 == 12) {
                int i55 = cVar2.f16785n;
                String str33 = cVar2.f16786o;
                String placementId11 = this.f16175k.getPlacementId();
                int i56 = this.f16171g;
                int i57 = this.f16172h;
                int i58 = this.f16173i;
                int i59 = this.f16174j;
                String str34 = cVar2.f16795x;
                String str35 = cVar2.f16788q;
                int i60 = cVar2.f16789r;
                String str36 = cVar2.f16790s;
                int i61 = cVar2.f16792u;
                String a2 = cVar.mo26743a();
                int i62 = i61;
                String str37 = cVar2.f16772a;
                int i63 = cVar2.f16783l;
                String str38 = str37;
                int i64 = i63;
                String str39 = str36;
                int i65 = i62;
                int i66 = i60;
                String str40 = str34;
                String str41 = str35;
                C5224e.m21525a().mo26908a(12, 1, "", i55, str33, placementId11, i56, i57, i58, i59, 0, str40, str41, i66, 2, str39, "", "", i65, 0.0d, a2, str38, i64, cVar2.f16784m, cVar2.f16791t);
            }
        }
    }

    /* renamed from: a */
    public void mo26314a(Context context, C5034m mVar, int i) {
        final C5138c a = mVar.mo26466a();
        final Setting d = m20784a().mo26332d();
        if (a != null && d != null) {
            C5002e eVar = new C5002e(context, a.f16795x, d.getPlacementId(), a.f16785n, a.mo26743a(), i, d.getRewardType());
            final int i2 = i;
            final C5034m mVar2 = mVar;
            C49765 r0 = new C5117a<C5001d>() {
                /* renamed from: a */
                public void mo26344a(C5001d dVar) {
                    C4970aa.this.mo26326a(a.mo26743a());
                    int i = i2 == 1 ? 2 : 3;
                    int i2 = 0;
                    double appWallOpenCoin = d.getAppWallOpenCoin();
                    C5042a d = mVar2.mo26469d();
                    if (i2 == 2 && d != null) {
                        int g = d.mo26486g();
                        i2 = 7;
                        if (g <= 7) {
                            i2 = g;
                        }
                        appWallOpenCoin = d.mo26479a(C4970aa.m20784a().mo26333e());
                    }
                    a.f16775d = appWallOpenCoin;
                    if (dVar.mo26389a() == 1 || dVar.mo26390b() == 1) {
                        C5205o.m21462a("ag active suc");
                        C4970aa.this.mo26321a(a);
                    } else {
                        appWallOpenCoin = 0.0d;
                    }
                    C4970aa aaVar = C4970aa.this;
                    C5138c cVar = a;
                    aaVar.mo26322a(cVar, cVar.f16795x, appWallOpenCoin);
                    d.getAppwallListener().onReward(i, i2, appWallOpenCoin);
                    if (C4970aa.this.f16178n != null) {
                        C4970aa.this.f16178n.onRefresh();
                    }
                }
            };
            eVar.mo26658a(r0);
        }
    }

    /* renamed from: a */
    public void mo26315a(Context context, C5047t tVar) {
        final C5034m d = tVar.mo26542d();
        try {
            if (this.f16175k != null) {
                this.f16175k.getAppwallListener().onClicked();
            }
            m20793i();
            final C5138c a = d.mo26466a();
            if (tVar.mo26540b() == 1) {
                C4990b.m20867a().mo26377a(context, tVar, this.f16178n);
                return;
            }
            final String x = C5125f.m21216a().mo26728e().mo26457x();
            if (tVar.mo26540b() == 3) {
                if (a.f16781j != 2) {
                    String str = a.f16777f;
                    if (TextUtils.isEmpty(str) && d.mo26467b() != null) {
                        str = d.mo26467b().getDownLoadUrl();
                    }
                    String str2 = str;
                    C5153c a2 = C5153c.m21275a();
                    final C5138c cVar = a;
                    final Context context2 = context;
                    final C5047t tVar2 = tVar;
                    C49754 r1 = new C5158b() {
                        /* renamed from: a */
                        public void mo26340a() {
                            C4970aa.m20784a().mo26313a(6, cVar);
                        }

                        /* renamed from: b */
                        public void mo26341b() {
                            C4970aa.this.mo26313a(9, cVar);
                            C5211s.m21484a(context2.getApplicationContext(), C5207q.m21474a(x, "应用下载成功，官方已验证，请放心安装"), 1);
                            if (C4970aa.this.f16178n != null) {
                                C4970aa.this.f16178n.onInstallStart(tVar2);
                            }
                        }

                        /* renamed from: c */
                        public void mo26342c() {
                        }
                    };
                    a2.mo26761a(context, a, str2, (C5158b) r1);
                    C4817a.m19686a(a.mo26743a());
                    C5035n.m21025a().mo26472a(d);
                } else if (C5191i.m21390a(context, a.mo26743a())) {
                    C5187e.m21376c(context, a.mo26743a());
                    C5004g.m20946a().mo26395a(d, 1);
                } else {
                    C5153c a3 = C5153c.m21275a();
                    String str3 = a.f16777f;
                    final C5138c cVar2 = a;
                    final Context context3 = context;
                    final C5047t tVar3 = tVar;
                    C49732 r12 = new C5158b() {
                        /* renamed from: a */
                        public void mo26340a() {
                            C4970aa.m20784a().mo26313a(6, cVar2);
                        }

                        /* renamed from: b */
                        public void mo26341b() {
                            C5211s.m21484a(context3.getApplicationContext(), C5207q.m21474a(x, "应用下载成功，官方已验证，请放心安装"), 1);
                            if (C4970aa.this.f16178n != null) {
                                C4970aa.this.f16178n.onInstallStart(tVar3);
                            }
                            C4970aa.this.mo26313a(9, cVar2);
                        }

                        /* renamed from: c */
                        public void mo26342c() {
                        }
                    };
                    a3.mo26761a(context, a, str3, (C5158b) r12);
                    C4817a.m19685a(context, a.mo26743a(), C4990b.m20866a(a), null, new C4940a() {
                        /* renamed from: a */
                        public void mo26162a(int i) {
                        }

                        /* renamed from: a */
                        public void mo26163a(String str, String str2) {
                            if (C4970aa.this.f16178n != null) {
                                C4970aa.this.f16178n.onInstalled();
                            }
                            C4970aa.this.mo26313a(7, a);
                            C5004g.m20946a().mo26397b(d, 1);
                        }

                        /* renamed from: b */
                        public void mo26164b(String str, String str2) {
                        }
                    });
                }
            }
        } catch (Throwable th) {
            C5205o.m21464a(th);
        }
    }

    /* renamed from: a */
    public void mo26316a(Context context, C5138c cVar, C5034m mVar, String str) {
        cVar.f16781j = 2;
        cVar.f16782k = 1;
        C5005h.m20951a().mo26404a(cVar, mVar.mo26467b(), mVar.mo26468c(), (C5134a) null);
        C5005h.m20951a().mo26401a(context, 2, mVar.mo26467b(), mVar.mo26468c(), "");
        mo26314a(context, mVar, 1);
        m20784a().mo26317a(context, cVar.mo26743a());
    }

    /* renamed from: a */
    public void mo26317a(Context context, String str) {
        try {
            if (this.f16168d == null) {
                this.f16168d = new HashMap<>();
            }
            if (!TextUtils.isEmpty(str)) {
                this.f16168d.put(str, Long.valueOf(System.currentTimeMillis()));
            }
            StringBuilder sb = new StringBuilder();
            for (Entry entry : this.f16168d.entrySet()) {
                sb.append((String) entry.getKey());
                sb.append(StorageInterface.KEY_SPLITER);
                sb.append(entry.getValue());
                sb.append(";");
            }
            m20788a(context, "waw_bn", sb.toString());
        } catch (Throwable th) {
            C5205o.m21464a(th);
        }
    }

    /* renamed from: a */
    public void mo26318a(C4978a aVar) {
        this.f16178n = aVar;
    }

    /* renamed from: a */
    public void mo26319a(C5034m mVar, int i) {
        C5138c a = mVar.mo26466a();
        Context b = C5233e.m21559b();
        C4978a aVar = this.f16178n;
        if (aVar != null) {
            aVar.onActivate(a.mo26743a());
        }
        if (i == 1) {
            C5205o.m21462a("aw active like");
            m20784a().mo26316a(b, a, mVar, a.f16795x);
        }
        if (i == 2) {
            C5205o.m21462a("aw active hot");
            C4990b.m20867a().mo26376a(b, mVar, a);
        }
        if (i == 3) {
            C5205o.m21462a("aw active sign in");
            C4996c.m20913a().mo26385a(b, mVar, a);
        }
    }

    /* renamed from: a */
    public void mo26320a(C5047t tVar) {
        AppWallActivity c = mo26331c();
        if (c != null && !c.isFinishing()) {
            c.handlerItemClick(tVar, true);
        }
    }

    /* renamed from: a */
    public void mo26321a(final C5138c cVar) {
        C5208r.m21479a(new Runnable() {
            public void run() {
                AppWallActivity c = C4970aa.this.mo26331c();
                if (c != null && !c.isFinishing()) {
                    Setting d = C4970aa.m20784a().mo26332d();
                    int appWallCoinResId = d != null ? d.getAppWallCoinResId() : 0;
                    final C5047t h = C4970aa.this.mo26336h();
                    if (!(h == null || h.mo26542d() == null)) {
                        C4970aa.m20784a().mo26313a(3, h.mo26542d().mo26466a());
                        C4970aa.m20784a().mo26313a(4, h.mo26542d().mo26466a());
                    }
                    double d2 = 0.0d;
                    if (C4970aa.this.f16177m != null && C4970aa.this.f16177m.isShowing()) {
                        d2 = C4970aa.this.f16177m.mo26357a();
                        C4970aa.this.f16177m.dismiss();
                    }
                    C4970aa.this.f16177m = C5046s.m21063a(c, d2 + cVar.f16775d, appWallCoinResId, false, h);
                    C4970aa.this.f16177m.mo26358a((C4987b) new C4987b() {
                        /* renamed from: a */
                        public void mo26338a() {
                            C4970aa.this.f16177m = null;
                            C5047t tVar = h;
                            if (!(tVar == null || tVar.mo26542d() == null)) {
                                C4970aa.m20784a().mo26313a(12, h.mo26542d().mo26466a());
                            }
                            if (C4970aa.this.f16178n != null) {
                                C4970aa.this.f16178n.onOfferDialogDismiss();
                            }
                        }

                        /* renamed from: a */
                        public void mo26339a(int i) {
                            if (i == 2) {
                                C4970aa.this.mo26320a(h);
                            }
                        }
                    });
                    C4970aa.this.f16177m.show();
                }
            }
        });
    }

    /* renamed from: a */
    public void mo26322a(C5138c cVar, String str, double d) {
        C5138c cVar2 = cVar;
        if (cVar2 != null) {
            String str2 = str;
            C5224e.m21525a().mo26908a(8, 1, "", cVar2.f16785n, cVar2.f16786o, cVar2.f16787p, this.f16171g, this.f16172h, this.f16173i, this.f16174j, 0, str2, cVar2.f16788q, cVar2.f16789r, 2, cVar2.f16790s, "", "", cVar2.f16792u, d, cVar.mo26743a(), cVar2.f16772a, cVar2.f16783l, cVar2.f16784m, cVar2.f16791t);
        }
    }

    /* renamed from: a */
    public void mo26323a(C5138c cVar, List<C5034m> list) {
        C5138c cVar2 = cVar;
        List<C5034m> list2 = list;
        if (cVar2 != null) {
            String str = cVar2.f16791t;
            if (list2 != null && list.size() > 0) {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < list.size(); i++) {
                    sb.append(((C5034m) list2.get(i)).mo26466a().f16791t);
                    sb.append(StorageInterface.KEY_SPLITER);
                }
                sb.deleteCharAt(sb.length() - 1);
                str = sb.toString();
            }
            String str2 = "";
            String str3 = "";
            String str4 = "";
            C5224e.m21525a().mo26908a(2, 1, str2, cVar2.f16785n, cVar2.f16786o, this.f16175k.getPlacementId(), this.f16171g, this.f16172h, this.f16173i, this.f16174j, 0, cVar2.f16795x, cVar2.f16788q, cVar2.f16789r, 2, cVar2.f16790s, str3, str4, -2, 0.0d, cVar.mo26743a(), cVar2.f16772a, cVar2.f16783l, cVar2.f16784m, str);
        }
    }

    /* renamed from: a */
    public void mo26324a(Setting setting, int i, String str, int i2, C4820a aVar) {
        String str2 = "";
        try {
            C5237f.m21602k(C5233e.m21559b(), setting.getPlacementId());
            m20793i();
            m20792b(C5233e.m21559b());
            C4990b.m20867a().mo26378a(C5233e.m21559b(), setting);
            this.f16175k = setting;
            this.f16166b = Calendar.getInstance().getTime();
            C5138c cVar = new C5138c();
            cVar.f16785n = 8;
            cVar.f16786o = str2;
            cVar.f16787p = setting.getPlacementId();
            cVar.f16788q = String.valueOf(setting.getAdType());
            cVar.f16789r = 0;
            cVar.f16790s = str2;
            cVar.f16791t = ERROR.CMD_FORMAT_ERROR;
            StringBuilder sb = new StringBuilder();
            sb.append("aw mng set id = ");
            sb.append(setting.getUuid());
            C5205o.m21462a(sb.toString());
            cVar.f16795x = setting.getUuid();
            cVar.f16796y = setting.getAppWallOpenCoin();
            cVar.f16797z = setting.getAppWallInstallCoin();
            cVar.f16766A = setting.getAppWallTitle();
            cVar.f16767B = setting.getAppWallBackIconResId();
            cVar.f16768C = setting.getAppWallColor();
            cVar.f16769D = setting.getAppWallCoinResId();
            cVar.f16792u = -1;
            Intent intent = new Intent(C5233e.m21559b(), AppWallActivity.class);
            intent.putExtra(AppWallActivity.AD_DATA, cVar);
            intent.addFlags(268435456);
            C5233e.m21559b().startActivity(intent);
            setting.getAppwallListener().onLoaded(setting);
        } catch (Throwable th) {
            C5205o.m21464a(th);
        }
    }

    /* renamed from: a */
    public void mo26325a(AppWallActivity appWallActivity) {
        this.f16176l = new WeakReference<>(appWallActivity);
    }

    /* renamed from: a */
    public synchronized void mo26326a(String str) {
        m20794j();
        this.f16167c.add(str);
    }

    /* renamed from: a */
    public void mo26327a(boolean z) {
        this.f16170f = z;
    }

    /* renamed from: b */
    public String mo26328b(C5047t tVar) {
        double d;
        String str = "";
        if (tVar == null || tVar.mo26542d() == null) {
            return str;
        }
        boolean e = mo26333e();
        if (tVar.mo26540b() == 2) {
            C5042a d2 = tVar.mo26542d().mo26469d();
            if (d2 == null) {
                return str;
            }
            d = d2.mo26479a(e);
        } else {
            d = mo26332d().getAppWallOpenCoin();
        }
        return m20787a(e, d);
    }

    /* renamed from: b */
    public boolean mo26329b() {
        return this.f16170f;
    }

    /* renamed from: b */
    public synchronized boolean mo26330b(String str) {
        m20794j();
        return this.f16167c.contains(str);
    }

    /* renamed from: c */
    public AppWallActivity mo26331c() {
        WeakReference<AppWallActivity> weakReference = this.f16176l;
        if (weakReference != null) {
            return (AppWallActivity) weakReference.get();
        }
        return null;
    }

    /* renamed from: d */
    public Setting mo26332d() {
        return this.f16175k;
    }

    /* renamed from: e */
    public boolean mo26333e() {
        Setting setting = this.f16175k;
        return setting == null || setting.getRewardType() == 1;
    }

    /* renamed from: f */
    public C4978a mo26334f() {
        return this.f16178n;
    }

    /* renamed from: g */
    public void mo26335g() {
        this.f16178n = null;
        this.f16177m = null;
    }

    /* renamed from: h */
    public C5047t mo26336h() {
        try {
            if (C5188f.m21377a((Collection) this.f16165a)) {
                return null;
            }
            C5047t tVar = null;
            double d = 0.0d;
            C5047t tVar2 = null;
            C5047t tVar3 = null;
            for (int i = 0; i < this.f16165a.size(); i++) {
                C5047t tVar4 = (C5047t) this.f16165a.get(i);
                C5034m d2 = tVar4.mo26542d();
                if (d2 != null) {
                    if (!mo26330b(d2.mo26466a().mo26743a())) {
                        if (tVar4.mo26540b() == 2) {
                            C5042a d3 = d2.mo26469d();
                            if (!d3.mo26488i()) {
                                double a = d3.mo26479a(m20784a().mo26333e());
                                if (a > d) {
                                    tVar2 = tVar4;
                                    d = a;
                                }
                            }
                        } else if (tVar4.mo26540b() == 3) {
                            if (tVar3 != null) {
                                if (d2.mo26466a().f16781j == 2) {
                                    if (tVar3.mo26542d().mo26466a().f16781j == 2) {
                                    }
                                }
                            }
                            tVar3 = tVar4;
                        } else if (tVar4.mo26540b() == 1 && tVar == null) {
                            tVar = tVar4;
                        }
                    }
                }
            }
            if (tVar2 == null) {
                tVar2 = tVar3;
            }
            if (tVar2 == null) {
                tVar2 = tVar;
            }
            if (tVar2 != null) {
                tVar2 = (C5047t) C5204n.m21459a(C5204n.m21460a(tVar2), C5047t.class);
                tVar2.mo26542d().mo26466a().f16783l = 4;
            }
            return tVar2;
        } catch (Throwable th) {
            C5205o.m21464a(th);
            return null;
        }
    }
}
