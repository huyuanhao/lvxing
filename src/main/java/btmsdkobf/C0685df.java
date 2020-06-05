package btmsdkobf;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import btmsdkobf.C0718dy.C0734b;
import com.p522qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Iterator;

/* renamed from: btmsdkobf.df */
public class C0685df {
    /* access modifiers changed from: private */
    /* renamed from: hA */
    public C0718dy f504hA;
    /* renamed from: hB */
    private volatile boolean f505hB = false;
    /* access modifiers changed from: private|volatile */
    /* renamed from: hC */
    public volatile String f506hC;
    /* renamed from: hD */
    private volatile long f507hD;
    /* renamed from: hd */
    private boolean f508hd;
    /* access modifiers changed from: private */
    public Context mContext;

    /* renamed from: btmsdkobf.df$a */
    public interface C0688a {
        /* renamed from: a */
        void mo9279a(int i, int i2, int i3, String str);
    }

    public C0685df(Context context, C0718dy dyVar, boolean z) {
        String str = "";
        this.f506hC = str;
        this.f507hD = 0;
        this.f508hd = false;
        this.mContext = context;
        this.f504hA = dyVar;
        this.f508hd = z;
        String av = this.f504hA.mo9338bF().mo9238av();
        boolean aE = this.f504hA.mo9338bF().mo9230aE();
        String str2 = "GuidCertifier";
        if (this.f508hd == aE || TextUtils.isEmpty(av)) {
            C0849fg.m914i(str2, "[cu_guid]GuidCertifier: no need to clean guid");
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append("[cu_guid]GuidCertifier, clean guid for server change(isTest?): ");
            sb.append(aE);
            sb.append(" -> ");
            sb.append(this.f508hd);
            C0849fg.m914i(str2, sb.toString());
            this.f504hA.mo9338bF().mo9248b(str, false);
            this.f504hA.mo9338bF().mo9249c(str, false);
        }
        mo9276aT();
    }

    /* renamed from: a */
    public static void m271a(Context context, int i, String str) {
        try {
            Intent intent = new Intent(String.format("action.guid.got:%s", new Object[]{context.getPackageName()}));
            intent.setPackage(context.getPackageName());
            intent.putExtra("k.rc", i);
            intent.putExtra("k.g", str);
            context.sendBroadcast(intent);
        } catch (Throwable th) {
            StringBuilder sb = new StringBuilder();
            sb.append("[cu_guid]sendBroadcast(): ");
            sb.append(th);
            C0849fg.m910a("GuidCertifier", sb.toString(), th);
        }
    }

    /* renamed from: a */
    private void m272a(final C0631bt btVar, String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("[cu_guid]updateGuid(), for: ");
        sb.append(this.f506hC);
        String str2 = "GuidCertifier";
        C0849fg.m914i(str2, sb.toString());
        final int bf = C0709du.m406bn().mo9293bf();
        C0633bv b = m277b(btVar, str);
        C0636by byVar = new C0636by();
        byVar.f358fm = bf;
        byVar.f357dO = 2;
        byVar.f360fo = C0683dd.m252a(this.mContext, (JceStruct) b, 2, byVar);
        if (byVar.f360fo == null) {
            C0849fg.m916w(str2, "[cu_guid]updateGuid(), jceStruct2DataForSend failed");
            return;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("[cu_guid]updateGuid(), cur info: ");
        sb2.append(m280c(btVar));
        C0849fg.m914i(str2, sb2.toString());
        ArrayList arrayList = new ArrayList();
        arrayList.add(byVar);
        C0712dv.m412br().mo9315a(byVar.f358fm, -1, null);
        this.f504hA.mo9329a(0, 0, false, arrayList, (C0734b) new C0734b() {
            /* renamed from: a */
            public void mo9278a(boolean z, int i, int i2, ArrayList<C0647cg> arrayList) {
                int i3;
                C0712dv br;
                int i4;
                int i5;
                C0647cg cgVar;
                int i6;
                String str;
                StringBuilder sb = new StringBuilder();
                sb.append("updateGuid() retCode: ");
                sb.append(i);
                String str2 = "GuidCertifier";
                C0849fg.m911d(str2, sb.toString());
                if (i != 0) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("[cu_guid]updateGuid() ESharkCode.ERR_NONE != retCode, retCode: ");
                    sb2.append(i);
                    C0849fg.m912e(str2, sb2.toString());
                    br = C0712dv.m412br();
                    i4 = 10002;
                    i5 = bf;
                    cgVar = null;
                    i6 = 30;
                    str = "GuidCertifier";
                    i3 = i;
                } else {
                    if (arrayList != null && arrayList.size() > 0) {
                        Iterator it = arrayList.iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                break;
                            }
                            C0647cg cgVar2 = (C0647cg) it.next();
                            if (cgVar2 != null) {
                                if (10002 == cgVar2.f383dO) {
                                    if (cgVar2.f388fq != 0) {
                                        StringBuilder sb3 = new StringBuilder();
                                        sb3.append("[cu_guid]updateGuid(), mazu error: ");
                                        sb3.append(cgVar2.f388fq);
                                        C0849fg.m912e(str2, sb3.toString());
                                        i3 = cgVar2.f388fq;
                                    } else if (cgVar2.f389fr != 0) {
                                        StringBuilder sb4 = new StringBuilder();
                                        sb4.append("[cu_guid]updateGuid(), dataRetCode: ");
                                        sb4.append(cgVar2.f389fr);
                                        C0849fg.m912e(str2, sb4.toString());
                                        i3 = -21300000;
                                    } else {
                                        StringBuilder sb5 = new StringBuilder();
                                        sb5.append("[cu_guid]updateGuid(), succ, save info to db, mGuid: ");
                                        sb5.append(C0685df.this.f506hC);
                                        C0849fg.m911d(str2, sb5.toString());
                                        C0685df dfVar = C0685df.this;
                                        dfVar.m274a(dfVar.f506hC, btVar, false);
                                        i3 = 0;
                                    }
                                }
                            }
                        }
                    } else {
                        StringBuilder sb6 = new StringBuilder();
                        sb6.append("[cu_guid]updateGuid(), no sashimi, serverSashimis: ");
                        sb6.append(arrayList);
                        C0849fg.m912e(str2, sb6.toString());
                    }
                    i3 = -21250000;
                    br = C0712dv.m412br();
                    i4 = 10002;
                    i5 = bf;
                    cgVar = null;
                    i6 = 30;
                    str = "GuidCertifier";
                }
                br.mo9318a(str, i4, i5, cgVar, i6, i3);
                C0712dv.m412br().mo9324t(bf);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m274a(String str, C0631bt btVar, boolean z) {
        if (!TextUtils.isEmpty(str)) {
            this.f506hC = str != null ? str : "";
            this.f505hB = true;
            this.f504hA.mo9338bF().mo9254f(this.f508hd);
            this.f504hA.mo9338bF().mo9248b(str, true);
            this.f504hA.mo9338bF().mo9249c(str, true);
            this.f504hA.mo9338bF().mo9245b(btVar);
        }
    }

    /* renamed from: a */
    private boolean m275a(boolean z, boolean z2) {
        return z != z2;
    }

    /* renamed from: b */
    private C0631bt m276b(boolean z, String str) {
        String str2 = "GuidCertifier";
        if (mo9274aR()) {
            StringBuilder sb = new StringBuilder();
            sb.append("[cu_guid]getCurInfoOfGuidIfNeed(), should register, donnot update, mGuid: ");
            sb.append(this.f506hC);
            sb.append(" fromPhone: ");
            sb.append(this.f505hB);
            C0849fg.m914i(str2, sb.toString());
            return null;
        } else if (!m283g(z)) {
            return null;
        } else {
            boolean z2 = true;
            boolean z3 = !TextUtils.isEmpty(str) && str.compareTo("yunzhiling_realinfo") == 0;
            C0631bt h = m284h(z3);
            if (h == null) {
                C0849fg.m916w(str2, "[cu_guid]getCurInfoOfGuidIfNeed(), null == realInfo");
                return null;
            } else if (!TextUtils.isEmpty(str)) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("[cu_guid_p]getCurInfoOfGuidIfNeed(), refreshKey is not empty, server requires update guid: ");
                sb2.append(str);
                C0849fg.m916w(str2, sb2.toString());
                return h;
            } else {
                C0631bt aB = this.f504hA.mo9338bF().mo9227aB();
                if (aB == null) {
                    C0849fg.m916w(str2, "[cu_guid]getCurInfoOfGuidIfNeed(), null == savedInfo");
                    return null;
                }
                boolean g = m282g(h.f279at, aB.f279at) | false | m282g(h.f283dT, aB.f283dT) | m282g(h.f290eA, aB.f290eA) | m282g(h.f284dU, aB.f284dU) | m282g(h.f285dV, aB.f285dV) | m282g(h.f286dW, aB.f286dW) | m285j(h.f287dX, aB.f287dX) | m282g(h.f280cv, aB.f280cv) | m285j(h.f281cw, aB.f281cw) | m282g(h.f282cx, aB.f282cx) | m285j(h.f288dY, aB.f288dY) | m285j(h.f289dZ, aB.f289dZ) | m275a(h.f316ea, aB.f316ea) | m282g(h.f317eb, aB.f317eb) | m282g(h.f318ec, aB.f318ec) | m285j(h.f319ed, aB.f319ed) | m282g(h.f320ee, aB.f320ee) | m285j(h.f321ef, aB.f321ef) | m285j(h.f322eg, aB.f322eg) | m282g(h.f323eh, aB.f323eh) | m282g(h.f299eJ, aB.f299eJ) | m282g(h.f324ei, aB.f324ei) | m285j(h.f325ej, aB.f325ej) | m282g(h.f326ek, aB.f326ek) | m279b(h.f327el, aB.f327el) | m279b(h.f328em, aB.f328em) | m279b(h.f329en, aB.f329en) | m279b(h.f304eO, aB.f304eO) | m282g(h.f330eo, aB.f330eo) | m282g(h.version, aB.version) | m285j(h.f294eE, aB.f294eE) | m282g(h.f295eF, aB.f295eF) | m282g(h.f335et, aB.f335et) | m282g(h.f300eK, aB.f300eK) | m282g(h.f301eL, aB.f301eL) | m282g(h.f302eM, aB.f302eM) | m282g(h.f305eP, aB.f305eP) | m282g(h.f337ev, aB.f337ev) | m282g(h.f333er, aB.f333er) | m282g(h.f334es, aB.f334es) | m282g(h.f306eQ, aB.f306eQ) | m275a(h.f340ey, aB.f340ey) | m285j(h.f307eR, aB.f307eR) | m282g(h.f308eS, aB.f308eS) | m282g(h.f309eT, aB.f309eT) | m282g(h.f310eU, aB.f310eU) | m282g(h.f312eW, aB.f312eW) | m282g(h.f313eX, aB.f313eX) | m282g(h.f314eY, aB.f314eY) | m282g(h.f315eZ, aB.f315eZ) | m282g(h.f342fa, aB.f342fa) | m282g(h.f343fb, aB.f343fb) | m282g(h.f344fc, aB.f344fc);
                String aw = this.f504hA.mo9338bF().mo9239aw();
                String guid = getGuid();
                if (TextUtils.isEmpty(aw) || aw.equals(guid)) {
                    z2 = false;
                }
                if (!z2 && !g) {
                    C0849fg.m914i(str2, "[cu_guid]getCurInfoOfGuidIfNeed(), info not changed, no need");
                    return null;
                }
                StringBuilder sb3 = new StringBuilder();
                sb3.append("[cu_guid]getCurInfoOfGuidIfNeed(), yes, |savedInfo|");
                sb3.append(m280c(aB));
                C0849fg.m915v(str2, sb3.toString());
                StringBuilder sb4 = new StringBuilder();
                sb4.append("[cu_guid]getCurInfoOfGuidIfNeed(), yes, |realInfo|");
                sb4.append(m280c(h));
                C0849fg.m915v(str2, sb4.toString());
                return h;
            }
        }
    }

    /* renamed from: b */
    private C0633bv m277b(C0631bt btVar, String str) {
        C0633bv bvVar = new C0633bv();
        bvVar.f347fe = btVar;
        bvVar.f348ff = getGuid();
        bvVar.f349fg = this.f504hA.mo9338bF().mo9239aw();
        bvVar.f350fh = str;
        StringBuilder sb = new StringBuilder();
        sb.append("[cu_guid_p]getCSUpdateRegist(), sdGuid: ");
        sb.append(bvVar.f349fg);
        sb.append(" curGuid: ");
        sb.append(bvVar.f348ff);
        sb.append(" refreshKey: ");
        sb.append(str);
        C0849fg.m914i("GuidCertifier", sb.toString());
        return bvVar;
    }

    /* renamed from: b */
    private boolean m279b(long j, long j2) {
        return j != j2;
    }

    /* renamed from: c */
    private String m280c(C0631bt btVar) {
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        sb2.append("|imei|");
        sb2.append(btVar.f279at);
        sb.append(sb2.toString());
        StringBuilder sb3 = new StringBuilder();
        sb3.append("|imsi|");
        sb3.append(btVar.f283dT);
        sb.append(sb3.toString());
        StringBuilder sb4 = new StringBuilder();
        sb4.append("|imsi_2|");
        sb4.append(btVar.f290eA);
        sb.append(sb4.toString());
        StringBuilder sb5 = new StringBuilder();
        sb5.append("|mac|");
        sb5.append(btVar.f284dU);
        sb.append(sb5.toString());
        StringBuilder sb6 = new StringBuilder();
        sb6.append("|qq|");
        sb6.append(btVar.f285dV);
        sb.append(sb6.toString());
        StringBuilder sb7 = new StringBuilder();
        sb7.append("|phone|");
        sb7.append(btVar.f286dW);
        sb.append(sb7.toString());
        StringBuilder sb8 = new StringBuilder();
        sb8.append("|product|");
        sb8.append(btVar.f287dX);
        sb.append(sb8.toString());
        StringBuilder sb9 = new StringBuilder();
        sb9.append("|lc|");
        sb9.append(btVar.f280cv);
        sb.append(sb9.toString());
        StringBuilder sb10 = new StringBuilder();
        sb10.append("|buildno|");
        sb10.append(btVar.f281cw);
        sb.append(sb10.toString());
        StringBuilder sb11 = new StringBuilder();
        sb11.append("|channelid|");
        sb11.append(btVar.f282cx);
        sb.append(sb11.toString());
        StringBuilder sb12 = new StringBuilder();
        sb12.append("|platform|");
        sb12.append(btVar.f288dY);
        sb.append(sb12.toString());
        StringBuilder sb13 = new StringBuilder();
        sb13.append("|subplatform|");
        sb13.append(btVar.f289dZ);
        sb.append(sb13.toString());
        StringBuilder sb14 = new StringBuilder();
        sb14.append("|isbuildin|");
        sb14.append(btVar.f316ea);
        sb.append(sb14.toString());
        StringBuilder sb15 = new StringBuilder();
        sb15.append("|pkgname|");
        sb15.append(btVar.f317eb);
        sb.append(sb15.toString());
        StringBuilder sb16 = new StringBuilder();
        sb16.append("|ua|");
        sb16.append(btVar.f318ec);
        sb.append(sb16.toString());
        StringBuilder sb17 = new StringBuilder();
        sb17.append("|sdkver|");
        sb17.append(btVar.f319ed);
        sb.append(sb17.toString());
        StringBuilder sb18 = new StringBuilder();
        sb18.append("|androidid|");
        sb18.append(btVar.f320ee);
        sb.append(sb18.toString());
        StringBuilder sb19 = new StringBuilder();
        sb19.append("|lang|");
        sb19.append(btVar.f321ef);
        sb.append(sb19.toString());
        StringBuilder sb20 = new StringBuilder();
        sb20.append("|simnum|");
        sb20.append(btVar.f322eg);
        sb.append(sb20.toString());
        StringBuilder sb21 = new StringBuilder();
        sb21.append("|cpu|");
        sb21.append(btVar.f323eh);
        sb.append(sb21.toString());
        StringBuilder sb22 = new StringBuilder();
        sb22.append("|cpu_abi2|");
        sb22.append(btVar.f299eJ);
        sb.append(sb22.toString());
        StringBuilder sb23 = new StringBuilder();
        sb23.append("|cpufreq|");
        sb23.append(btVar.f324ei);
        sb.append(sb23.toString());
        StringBuilder sb24 = new StringBuilder();
        sb24.append("|cpunum|");
        sb24.append(btVar.f325ej);
        sb.append(sb24.toString());
        StringBuilder sb25 = new StringBuilder();
        sb25.append("|resolution|");
        sb25.append(btVar.f326ek);
        sb.append(sb25.toString());
        StringBuilder sb26 = new StringBuilder();
        sb26.append("|ram|");
        sb26.append(btVar.f327el);
        sb.append(sb26.toString());
        StringBuilder sb27 = new StringBuilder();
        sb27.append("|rom|");
        sb27.append(btVar.f328em);
        sb.append(sb27.toString());
        StringBuilder sb28 = new StringBuilder();
        sb28.append("|sdcard|");
        sb28.append(btVar.f329en);
        sb.append(sb28.toString());
        StringBuilder sb29 = new StringBuilder();
        sb29.append("|inner_storage|");
        sb29.append(btVar.f304eO);
        sb.append(sb29.toString());
        StringBuilder sb30 = new StringBuilder();
        sb30.append("|build_brand|");
        sb30.append(btVar.f330eo);
        sb.append(sb30.toString());
        StringBuilder sb31 = new StringBuilder();
        sb31.append("|build_version_incremental|");
        sb31.append(btVar.f331ep);
        sb.append(sb31.toString());
        StringBuilder sb32 = new StringBuilder();
        sb32.append("|build_version_release|");
        sb32.append(btVar.f332eq);
        sb.append(sb32.toString());
        StringBuilder sb33 = new StringBuilder();
        sb33.append("|version|");
        sb33.append(btVar.version);
        sb.append(sb33.toString());
        StringBuilder sb34 = new StringBuilder();
        sb34.append("|extSdkVer|");
        sb34.append(btVar.f294eE);
        sb.append(sb34.toString());
        StringBuilder sb35 = new StringBuilder();
        sb35.append("|pkgkey|");
        sb35.append(btVar.f295eF);
        sb.append(sb35.toString());
        StringBuilder sb36 = new StringBuilder();
        sb36.append("|manufactory|");
        sb36.append(btVar.f335et);
        sb.append(sb36.toString());
        StringBuilder sb37 = new StringBuilder();
        sb37.append("|cam_pix|");
        sb37.append(btVar.f338ew);
        sb.append(sb37.toString());
        StringBuilder sb38 = new StringBuilder();
        sb38.append("|front_cam_pix|");
        sb38.append(btVar.f339ex);
        sb.append(sb38.toString());
        StringBuilder sb39 = new StringBuilder();
        sb39.append("|product_device|");
        sb39.append(btVar.f296eG);
        sb.append(sb39.toString());
        StringBuilder sb40 = new StringBuilder();
        sb40.append("|product_board|");
        sb40.append(btVar.f297eH);
        sb.append(sb40.toString());
        StringBuilder sb41 = new StringBuilder();
        sb41.append("|build_product|");
        sb41.append(btVar.f298eI);
        sb.append(sb41.toString());
        StringBuilder sb42 = new StringBuilder();
        sb42.append("|rom_fingerprint|");
        sb42.append(btVar.f300eK);
        sb.append(sb42.toString());
        StringBuilder sb43 = new StringBuilder();
        sb43.append("|product_lanuage|");
        sb43.append(btVar.f301eL);
        sb.append(sb43.toString());
        StringBuilder sb44 = new StringBuilder();
        sb44.append("|product_region|");
        sb44.append(btVar.f302eM);
        sb.append(sb44.toString());
        StringBuilder sb45 = new StringBuilder();
        sb45.append("|build_radiover|");
        sb45.append(btVar.f303eN);
        sb.append(sb45.toString());
        StringBuilder sb46 = new StringBuilder();
        sb46.append("|board_platform|");
        sb46.append(btVar.f336eu);
        sb.append(sb46.toString());
        StringBuilder sb47 = new StringBuilder();
        sb47.append("|board_platform_mtk|");
        sb47.append(btVar.f305eP);
        sb.append(sb47.toString());
        StringBuilder sb48 = new StringBuilder();
        sb48.append("|screen_pdi|");
        sb48.append(btVar.f337ev);
        sb.append(sb48.toString());
        StringBuilder sb49 = new StringBuilder();
        sb49.append("|romname|");
        sb49.append(btVar.f333er);
        sb.append(sb49.toString());
        StringBuilder sb50 = new StringBuilder();
        sb50.append("|romversion|");
        sb50.append(btVar.f334es);
        sb.append(sb50.toString());
        StringBuilder sb51 = new StringBuilder();
        sb51.append("|kernel_ver|");
        sb51.append(btVar.f306eQ);
        sb.append(sb51.toString());
        StringBuilder sb52 = new StringBuilder();
        sb52.append("|isdual|");
        sb52.append(btVar.f340ey);
        sb.append(sb52.toString());
        StringBuilder sb53 = new StringBuilder();
        sb53.append("|rom_manufactory_version|");
        sb53.append(btVar.f308eS);
        sb.append(sb53.toString());
        StringBuilder sb54 = new StringBuilder();
        sb54.append("|insideCid|");
        sb54.append(btVar.f309eT);
        sb.append(sb54.toString());
        StringBuilder sb55 = new StringBuilder();
        sb55.append("|outsideCid|");
        sb55.append(btVar.f310eU);
        sb.append(sb55.toString());
        StringBuilder sb56 = new StringBuilder();
        sb56.append("|registCount|");
        sb56.append(btVar.f311eV);
        sb.append(sb56.toString());
        StringBuilder sb57 = new StringBuilder();
        sb57.append("|imei1|");
        sb57.append(btVar.f312eW);
        sb.append(sb57.toString());
        StringBuilder sb58 = new StringBuilder();
        sb58.append("|imei2|");
        sb58.append(btVar.f313eX);
        sb.append(sb58.toString());
        StringBuilder sb59 = new StringBuilder();
        sb59.append("|meid|");
        sb59.append(btVar.f314eY);
        sb.append(sb59.toString());
        StringBuilder sb60 = new StringBuilder();
        sb60.append("|deviceId1|");
        sb60.append(btVar.f315eZ);
        sb.append(sb60.toString());
        StringBuilder sb61 = new StringBuilder();
        sb61.append("|deviceId2|");
        sb61.append(btVar.f342fa);
        sb.append(sb61.toString());
        StringBuilder sb62 = new StringBuilder();
        sb62.append("|deviceId3|");
        sb62.append(btVar.f343fb);
        sb.append(sb62.toString());
        StringBuilder sb63 = new StringBuilder();
        sb63.append("|deviceId4|");
        sb63.append(btVar.f344fc);
        sb.append(sb63.toString());
        return sb.toString();
    }

    /* renamed from: g */
    private boolean m282g(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (TextUtils.isEmpty(str2)) {
            return true;
        }
        return !str.equals(str2);
    }

    /* renamed from: g */
    private boolean m283g(boolean z) {
        String str;
        long currentTimeMillis = System.currentTimeMillis();
        String str2 = "GuidCertifier";
        if (z) {
            C0849fg.m914i(str2, "[cu_guid]shouldCheckUpdate(), forceCheck, true");
            this.f507hD = currentTimeMillis;
            this.f504hA.mo9338bF().mo9243b(currentTimeMillis);
            return true;
        }
        boolean z2 = false;
        if (this.f507hD <= 0) {
            str = "[cu_guid]shouldCheckUpdate(), [mem] first check after boot, continue check...";
        } else {
            if (C0833ex.m868a(currentTimeMillis, this.f507hD, 60)) {
                str = "[cu_guid]shouldCheckUpdate(), [mem] more than 1h, continue check...";
            }
            return z2;
        }
        C0849fg.m914i(str2, str);
        this.f507hD = currentTimeMillis;
        long aD = this.f504hA.mo9338bF().mo9229aD();
        if (aD <= 0) {
            C0849fg.m914i(str2, "[cu_guid]shouldCheckUpdate(), [file] first check, just record the time");
            this.f504hA.mo9338bF().mo9243b(currentTimeMillis);
        } else if (C0833ex.m868a(currentTimeMillis, aD, 720)) {
            C0849fg.m914i(str2, "[cu_guid]shouldCheckUpdate(), [file] more than 12h, should check");
            this.f504hA.mo9338bF().mo9243b(currentTimeMillis);
            z2 = true;
        } else {
            C0849fg.m914i(str2, "[cu_guid]shouldCheckUpdate(), [file] less than 12h, donnot check");
        }
        return z2;
    }

    /* renamed from: h */
    private C0631bt m284h(boolean z) {
        C0631bt e = this.f504hA.mo9338bF().mo9251e(z);
        if (e != null) {
            if (e.f279at == null) {
                e.f279at = "";
            }
            return e;
        }
        throw new RuntimeException("onGetRealInfoOfGuid() return null");
    }

    /* renamed from: j */
    private boolean m285j(int i, int i2) {
        return i != i2;
    }

    /* renamed from: n */
    static void m286n(Context context) {
        try {
            Intent intent = new Intent(String.format("action.reg.guid:%s", new Object[]{context.getPackageName()}));
            intent.setPackage(context.getPackageName());
            context.sendBroadcast(intent);
        } catch (Throwable th) {
            StringBuilder sb = new StringBuilder();
            sb.append("[cu_guid]requestSendProcessRegisterGuid(): ");
            sb.append(th);
            C0849fg.m913e("GuidCertifier", sb.toString(), th);
        }
    }

    /* renamed from: a */
    public void mo9272a(final C0688a aVar) {
        String str = "GuidCertifier";
        C0849fg.m914i(str, "[cu_guid]registerGuid()");
        if (!mo9274aR()) {
            StringBuilder sb = new StringBuilder();
            sb.append("[cu_guid]registerGuid(), not necessary, mGuid: ");
            sb.append(this.f506hC);
            C0849fg.m911d(str, sb.toString());
            return;
        }
        this.f504hA.mo9338bF().mo9233aH();
        final C0631bt h = m284h(false);
        C0636by byVar = new C0636by();
        final int bf = C0709du.m406bn().mo9293bf();
        byVar.f358fm = bf;
        byVar.f357dO = 1;
        byVar.f360fo = C0683dd.m252a(this.mContext, (JceStruct) h, 1, byVar);
        if (byVar.f360fo == null) {
            C0849fg.m916w(str, "[cu_guid]registerGuid(), jceStruct2DataForSend failed");
            aVar.mo9279a(bf, 1, -20001500, null);
            return;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("[cu_guid]registerGuid(), cur info: ");
        sb2.append(m280c(h));
        C0849fg.m914i(str, sb2.toString());
        ArrayList arrayList = new ArrayList();
        arrayList.add(byVar);
        C0712dv.m412br().mo9315a(byVar.f358fm, -1, null);
        this.f504hA.mo9334b(arrayList, (C0734b) new C0734b() {
            /* renamed from: a */
            public void mo9278a(boolean z, int i, int i2, ArrayList<C0647cg> arrayList) {
                String str = "GuidCertifier";
                if (i != 0) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("[cu_guid]registerGuid(), retCode: ");
                    sb.append(i);
                    C0849fg.m912e(str, sb.toString());
                    aVar.mo9279a(bf, 1, i, null);
                } else if (arrayList == null) {
                    C0849fg.m912e(str, "[cu_guid]registerGuid(), null == serverSashimis");
                    aVar.mo9279a(bf, 1, -21250000, null);
                } else if (arrayList.size() <= 0) {
                    C0849fg.m912e(str, "[cu_guid]registerGuid(), serverSashimis.size() <= 0");
                    aVar.mo9279a(bf, 1, -21250000, null);
                } else {
                    C0647cg cgVar = (C0647cg) arrayList.get(0);
                    if (cgVar == null) {
                        C0849fg.m912e(str, "[cu_guid]registerGuid(), serverSashimi is null");
                        aVar.mo9279a(bf, 1, -21250000, null);
                    } else if (cgVar.f388fq != 0) {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("[cu_guid]registerGuid(), mazu error: ");
                        sb2.append(cgVar.f388fq);
                        C0849fg.m912e(str, sb2.toString());
                        aVar.mo9279a(bf, 1, cgVar.f388fq, null);
                    } else if (cgVar.f389fr != 0) {
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append("[cu_guid]registerGuid(), dataRetCode: ");
                        sb3.append(cgVar.f389fr);
                        C0849fg.m912e(str, sb3.toString());
                        aVar.mo9279a(bf, 1, -21300000, null);
                    } else {
                        byte[] bArr = cgVar.f387fo;
                        if (bArr == null) {
                            C0849fg.m912e(str, "[cu_guid]registerGuid(), null == respData");
                            aVar.mo9279a(bf, 1, -21000005, null);
                            return;
                        }
                        StringBuilder sb4 = new StringBuilder();
                        sb4.append("[cu_guid]registerGuid() rs.data.length: ");
                        sb4.append(cgVar.f387fo.length);
                        C0849fg.m911d(str, sb4.toString());
                        try {
                            JceStruct a = C0683dd.m248a(C0685df.this.mContext, C0685df.this.f504hA.mo9333ac().f551im.getBytes(), bArr, new C0643cc(), false, cgVar.f390ft);
                            if (a == null) {
                                C0849fg.m912e(str, "[cu_guid]registerGuid(), decode jce failed: null");
                                aVar.mo9279a(bf, 1, -21000400, null);
                                return;
                            }
                            C0643cc ccVar = (C0643cc) a;
                            StringBuilder sb5 = new StringBuilder();
                            sb5.append("[cu_guid]registerGuid(), guid got: ");
                            sb5.append(ccVar.f377as);
                            C0849fg.m911d(str, sb5.toString());
                            C0685df.this.m274a(ccVar.f377as, h, true);
                            aVar.mo9279a(bf, 1, 0, ccVar.f377as);
                        } catch (Exception e) {
                            StringBuilder sb6 = new StringBuilder();
                            sb6.append("[cu_guid]registerGuid(), decode jce exception: ");
                            sb6.append(e);
                            C0849fg.m912e(str, sb6.toString());
                            aVar.mo9279a(bf, 1, -21000400, null);
                        }
                    }
                }
            }
        });
    }

    /* renamed from: a */
    public void mo9273a(boolean z, String str) {
        if (!C0716dx.m428ar()) {
            C0849fg.m914i("GuidCertifier", "[cu_guid] checUpdateGuid(), not send process, ignore!");
            return;
        }
        C0631bt b = m276b(z, str);
        if (b != null) {
            m272a(b, str);
        }
    }

    /* renamed from: aR */
    public boolean mo9274aR() {
        if (!C0716dx.m428ar()) {
            return false;
        }
        return TextUtils.isEmpty(getGuid()) || !this.f505hB;
    }

    /* renamed from: aS */
    public boolean mo9275aS() {
        return TextUtils.isEmpty(getGuid()) || !this.f505hB;
    }

    /* renamed from: aT */
    public void mo9276aT() {
        this.f506hC = this.f504hA.mo9338bF().mo9238av();
        if (TextUtils.isEmpty(this.f506hC)) {
            this.f505hB = false;
            this.f506hC = this.f504hA.mo9338bF().mo9239aw();
            if (this.f506hC == null) {
                this.f506hC = "";
            }
        } else {
            this.f505hB = true;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("[cu_guid]refreshGuid(), mGuid: ");
        sb.append(this.f506hC);
        sb.append(" fromPhone: ");
        sb.append(this.f505hB);
        C0849fg.m914i("GuidCertifier", sb.toString());
    }

    public String getGuid() {
        return this.f506hC != null ? this.f506hC : "";
    }
}
