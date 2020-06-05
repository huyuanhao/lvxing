package btmsdkobf;

import com.p522qq.taf.jce.JceStruct;
import com.tmsdk.module.coin.CoinTask;
import com.tmsdk.module.coin.ErrorCode;
import com.tmsdk.module.coin.TmsLog;
import java.util.ArrayList;
import java.util.Iterator;

/* renamed from: btmsdkobf.ao */
public class C0588ao {
    /* renamed from: a */
    public static void m40a(C0887v vVar, long j, final C0601aq aqVar) {
        if (aqVar == null) {
            aqVar.mo9148a(ErrorCode.EC_FAIL, null);
        } else if (vVar == null) {
            aqVar.mo9148a(ErrorCode.EC_PARAM_INVALID, null);
        } else {
            C0564ab abVar = new C0564ab();
            abVar.f49ae = vVar.f1075ap.f1055ae;
            abVar.f50ay = j;
            C0638c.m75a(4156, abVar, new C0890y(), 0, new C0611b() {
                /* renamed from: a */
                public void mo9158a(int i, int i2, int i3, int i4, JceStruct jceStruct) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("[Shark]onFinish-getMallItemList cmdId:[");
                    sb.append(i2);
                    sb.append("]retCode:[");
                    sb.append(i3);
                    sb.append("]dataRetCode: ");
                    sb.append(i4);
                    String str = "CoinNetService";
                    TmsLog.m32943i(str, sb.toString());
                    if (i3 != 0 || i4 != 0) {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("onFinish-getMallItemList fail");
                        sb2.append(i);
                        sb2.append(" cmdId: ");
                        sb2.append(i2);
                        sb2.append(" retCode: ");
                        sb2.append(i3);
                        sb2.append(" dataRetCode: ");
                        sb2.append(i4);
                        TmsLog.m32945w(str, sb2.toString());
                        aqVar.mo9148a(i3, null);
                    } else if (jceStruct != null) {
                        C0890y yVar = (C0890y) jceStruct;
                        aqVar.mo9148a(yVar.f1098W, yVar.f1099aH);
                    } else {
                        TmsLog.m32945w(str, "getMallItemList is null!");
                        aqVar.mo9148a(ErrorCode.EC_FAIL, null);
                    }
                }
            }, 8000);
        }
    }

    /* renamed from: a */
    public static void m41a(C0887v vVar, long j, final C0602ar arVar) {
        if (arVar == null) {
            arVar.mo9157a(ErrorCode.EC_FAIL, null);
        } else if (vVar == null) {
            arVar.mo9157a(ErrorCode.EC_PARAM_INVALID, null);
        } else {
            C0564ab abVar = new C0564ab();
            abVar.f49ae = vVar.f1075ap.f1055ae;
            abVar.f50ay = j;
            C0638c.m75a(4156, abVar, new C0563aa(), 0, new C0611b() {
                /* renamed from: a */
                public void mo9158a(int i, int i2, int i3, int i4, JceStruct jceStruct) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("[Shark]onFinish-getMallItemList cmdId:[");
                    sb.append(i2);
                    sb.append("]retCode:[");
                    sb.append(i3);
                    sb.append("]dataRetCode: ");
                    sb.append(i4);
                    String str = "CoinNetService";
                    TmsLog.m32943i(str, sb.toString());
                    if (i3 != 0 || i4 != 0) {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("onFinish-getMallItemList fail");
                        sb2.append(i);
                        sb2.append(" cmdId: ");
                        sb2.append(i2);
                        sb2.append(" retCode: ");
                        sb2.append(i3);
                        sb2.append(" dataRetCode: ");
                        sb2.append(i4);
                        TmsLog.m32945w(str, sb2.toString());
                        arVar.mo9157a(i3, null);
                    } else if (jceStruct != null) {
                        C0563aa aaVar = (C0563aa) jceStruct;
                        arVar.mo9157a(aaVar.f46W, aaVar.f47aN);
                    } else {
                        TmsLog.m32945w(str, "getMallItemList is null!");
                        arVar.mo9157a(ErrorCode.EC_FAIL, null);
                    }
                }
            }, 8000);
        }
    }

    /* renamed from: a */
    public static void m42a(C0887v vVar, long j, final C0603as asVar) {
        if (asVar == null) {
            asVar.mo9154a(ErrorCode.EC_FAIL, -1, null, null);
        } else if (vVar == null) {
            asVar.mo9154a(ErrorCode.EC_PARAM_INVALID, -1, null, null);
        } else {
            C0575am amVar = new C0575am();
            amVar.f113aq = vVar.f1076aq;
            amVar.f114as = vVar.f1078as;
            amVar.f115at = vVar.f1079at;
            amVar.f112ae = vVar.f1075ap.f1055ae;
            amVar.f116bu = j;
            C0638c.m75a(4156, amVar, new C0574al(), 0, new C0611b() {
                /* renamed from: a */
                public void mo9158a(int i, int i2, int i3, int i4, JceStruct jceStruct) {
                    String str;
                    String str2;
                    long j;
                    int i5;
                    C0603as asVar;
                    StringBuilder sb = new StringBuilder();
                    sb.append("[Shark]onFinish-Cmd_CSGetTasks cmdId:[");
                    sb.append(i2);
                    sb.append("]retCode:[");
                    sb.append(i3);
                    sb.append("]dataRetCode: ");
                    sb.append(i4);
                    String str3 = "CoinNetService";
                    TmsLog.m32943i(str3, sb.toString());
                    if (i3 != 0 || i4 != 0) {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("onFinish-Cmd_CSFeatureCheck fail");
                        sb2.append(i);
                        sb2.append(" cmdId: ");
                        sb2.append(i2);
                        sb2.append(" retCode: ");
                        sb2.append(i3);
                        sb2.append(" dataRetCode: ");
                        sb2.append(i4);
                        TmsLog.m32945w(str3, sb2.toString());
                        asVar = asVar;
                        j = -1;
                        str2 = null;
                        str = null;
                        i5 = i3;
                    } else if (jceStruct != null) {
                        C0574al alVar = (C0574al) jceStruct;
                        asVar.mo9154a(alVar.f108W, alVar.f109bu, alVar.resource, alVar.stock);
                        return;
                    } else {
                        TmsLog.m32945w(str3, "Cmd_CSGetTasks is null!");
                        asVar = asVar;
                        i5 = ErrorCode.EC_FAIL;
                        j = -1;
                        str2 = null;
                        str = null;
                    }
                    asVar.mo9154a(i5, j, str2, str);
                }
            }, 8000);
        }
    }

    /* renamed from: a */
    public static void m43a(C0887v vVar, long j, final C0604at atVar) {
        if (atVar == null) {
            atVar.mo9150a(ErrorCode.EC_FAIL, null);
        } else if (vVar == null) {
            atVar.mo9150a(ErrorCode.EC_PARAM_INVALID, null);
        } else {
            C0564ab abVar = new C0564ab();
            abVar.f49ae = vVar.f1075ap.f1055ae;
            abVar.f50ay = j;
            C0638c.m75a(4156, abVar, new C0565ac(), 0, new C0611b() {
                /* renamed from: a */
                public void mo9158a(int i, int i2, int i3, int i4, JceStruct jceStruct) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("[Shark]onFinish-getMallItemList cmdId:[");
                    sb.append(i2);
                    sb.append("]retCode:[");
                    sb.append(i3);
                    sb.append("]dataRetCode: ");
                    sb.append(i4);
                    String str = "CoinNetService";
                    TmsLog.m32943i(str, sb.toString());
                    if (i3 != 0 || i4 != 0) {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("onFinish-getMallItemList fail");
                        sb2.append(i);
                        sb2.append(" cmdId: ");
                        sb2.append(i2);
                        sb2.append(" retCode: ");
                        sb2.append(i3);
                        sb2.append(" dataRetCode: ");
                        sb2.append(i4);
                        TmsLog.m32945w(str, sb2.toString());
                        atVar.mo9150a(i3, null);
                    } else if (jceStruct != null) {
                        C0565ac acVar = (C0565ac) jceStruct;
                        atVar.mo9150a(acVar.f53W, acVar.f54aP);
                    } else {
                        TmsLog.m32945w(str, "getMallItemList is null!");
                        atVar.mo9150a(ErrorCode.EC_FAIL, null);
                    }
                }
            }, 8000);
        }
    }

    /* renamed from: a */
    public static void m44a(C0887v vVar, long j, final C0605au auVar) {
        if (auVar == null) {
            auVar.mo9156a(ErrorCode.EC_FAIL, null);
        } else if (vVar == null) {
            auVar.mo9156a(ErrorCode.EC_PARAM_INVALID, null);
        } else {
            C0569ag agVar = new C0569ag();
            agVar.f85aq = vVar.f1076aq;
            agVar.f86as = vVar.f1078as;
            agVar.f84ae = vVar.f1075ap.f1055ae;
            agVar.f87ay = j;
            C0638c.m75a(4156, agVar, new C0570ah(), 0, new C0611b() {
                /* renamed from: a */
                public void mo9158a(int i, int i2, int i3, int i4, JceStruct jceStruct) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("[Shark]onFinish-getMallItemList cmdId:[");
                    sb.append(i2);
                    sb.append("]retCode:[");
                    sb.append(i3);
                    sb.append("]dataRetCode: ");
                    sb.append(i4);
                    String str = "CoinNetService";
                    TmsLog.m32943i(str, sb.toString());
                    if (i3 != 0 || i4 != 0) {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("onFinish-getMallItemList fail");
                        sb2.append(i);
                        sb2.append(" cmdId: ");
                        sb2.append(i2);
                        sb2.append(" retCode: ");
                        sb2.append(i3);
                        sb2.append(" dataRetCode: ");
                        sb2.append(i4);
                        TmsLog.m32945w(str, sb2.toString());
                        auVar.mo9156a(i3, null);
                    } else if (jceStruct != null) {
                        C0570ah ahVar = (C0570ah) jceStruct;
                        auVar.mo9156a(ahVar.f90W, ahVar.f91bk);
                    } else {
                        TmsLog.m32945w(str, "getMallItemList is null!");
                        auVar.mo9156a(ErrorCode.EC_FAIL, null);
                    }
                }
            }, 8000);
        }
    }

    /* renamed from: a */
    public static void m45a(C0887v vVar, long j, final C0606av avVar) {
        if (avVar == null) {
            avVar.mo9149a(ErrorCode.EC_FAIL, 0, 0);
        } else if (vVar == null) {
            avVar.mo9149a(ErrorCode.EC_PARAM_INVALID, 0, 0);
        } else {
            C0564ab abVar = new C0564ab();
            abVar.f49ae = vVar.f1075ap.f1055ae;
            abVar.f50ay = j;
            C0638c.m75a(4156, abVar, new C0567ae(), 0, new C0611b() {
                /* renamed from: a */
                public void mo9158a(int i, int i2, int i3, int i4, JceStruct jceStruct) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("[Shark]onFinish-getMallItemList cmdId:[");
                    sb.append(i2);
                    sb.append("]retCode:[");
                    sb.append(i3);
                    sb.append("]dataRetCode: ");
                    sb.append(i4);
                    String str = "CoinNetService";
                    TmsLog.m32943i(str, sb.toString());
                    if (i3 != 0 || i4 != 0) {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("onFinish-getMallItemList fail");
                        sb2.append(i);
                        sb2.append(" cmdId: ");
                        sb2.append(i2);
                        sb2.append(" retCode: ");
                        sb2.append(i3);
                        sb2.append(" dataRetCode: ");
                        sb2.append(i4);
                        TmsLog.m32945w(str, sb2.toString());
                        avVar.mo9149a(i3, 0, 0);
                    } else if (jceStruct != null) {
                        C0567ae aeVar = (C0567ae) jceStruct;
                        avVar.mo9149a(aeVar.f62W, aeVar.f63aV, aeVar.f64aW);
                    } else {
                        TmsLog.m32945w(str, "getMallItemList is null!");
                        avVar.mo9149a(ErrorCode.EC_FAIL, 0, 1);
                    }
                }
            }, 8000);
        }
    }

    /* renamed from: a */
    public static void m46a(C0887v vVar, long j, final C0607aw awVar) {
        if (awVar == null) {
            awVar.mo9155a(ErrorCode.EC_FAIL, null);
        } else if (vVar == null) {
            awVar.mo9155a(ErrorCode.EC_PARAM_INVALID, null);
        } else {
            C0888w wVar = new C0888w();
            wVar.f1082aq = vVar.f1076aq;
            wVar.f1083as = vVar.f1078as;
            wVar.f1081ae = vVar.f1075ap.f1055ae;
            wVar.f1087ay = j;
            wVar.f1084av = 0;
            wVar.f1085aw = 20;
            wVar.f1086ax = 0;
            C0638c.m75a(4156, wVar, new C0571ai(), 0, new C0611b() {
                /* renamed from: a */
                public void mo9158a(int i, int i2, int i3, int i4, JceStruct jceStruct) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("[Shark]onFinish-getMallItemList cmdId:[");
                    sb.append(i2);
                    sb.append("]retCode:[");
                    sb.append(i3);
                    sb.append("]dataRetCode: ");
                    sb.append(i4);
                    String str = "CoinNetService";
                    TmsLog.m32943i(str, sb.toString());
                    if (i3 != 0 || i4 != 0) {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("onFinish-getMallItemList fail");
                        sb2.append(i);
                        sb2.append(" cmdId: ");
                        sb2.append(i2);
                        sb2.append(" retCode: ");
                        sb2.append(i3);
                        sb2.append(" dataRetCode: ");
                        sb2.append(i4);
                        TmsLog.m32945w(str, sb2.toString());
                        awVar.mo9155a(i3, null);
                    } else if (jceStruct != null) {
                        C0571ai aiVar = (C0571ai) jceStruct;
                        awVar.mo9155a(aiVar.f94W, aiVar.f95bm);
                    } else {
                        TmsLog.m32945w(str, "getMallItemList is null!");
                        awVar.mo9155a(ErrorCode.EC_FAIL, null);
                    }
                }
            }, 8000);
        }
    }

    /* renamed from: a */
    public static void m47a(C0887v vVar, long j, final C0609ay ayVar) {
        if (ayVar == null) {
            ayVar.mo9151a(ErrorCode.EC_FAIL, 0, 0, 0, "");
        } else if (vVar == null) {
            ayVar.mo9151a(ErrorCode.EC_PARAM_INVALID, 0, 0, 0, "");
        } else {
            C0564ab abVar = new C0564ab();
            abVar.f49ae = vVar.f1075ap.f1055ae;
            abVar.f50ay = j;
            C0638c.m75a(4156, abVar, new C0566ad(), 0, new C0611b() {
                /* renamed from: a */
                public void mo9158a(int i, int i2, int i3, int i4, JceStruct jceStruct) {
                    String str;
                    int i5;
                    int i6;
                    int i7;
                    int i8;
                    C0609ay ayVar;
                    StringBuilder sb = new StringBuilder();
                    sb.append("[Shark]onFinish-getMallItemList cmdId:[");
                    sb.append(i2);
                    sb.append("]retCode:[");
                    sb.append(i3);
                    sb.append("]dataRetCode: ");
                    sb.append(i4);
                    String str2 = "CoinNetService";
                    TmsLog.m32943i(str2, sb.toString());
                    if (i3 != 0 || i4 != 0) {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("onFinish-getMallItemList fail");
                        sb2.append(i);
                        sb2.append(" cmdId: ");
                        sb2.append(i2);
                        sb2.append(" retCode: ");
                        sb2.append(i3);
                        sb2.append(" dataRetCode: ");
                        sb2.append(i4);
                        TmsLog.m32945w(str2, sb2.toString());
                        ayVar = ayVar;
                        i7 = 0;
                        i6 = 0;
                        i5 = 0;
                        str = "";
                        i8 = i3;
                    } else if (jceStruct != null) {
                        C0566ad adVar = (C0566ad) jceStruct;
                        ayVar.mo9151a(adVar.f56W, adVar.f57aR, adVar.f58aS, adVar.f59aT, adVar.f60aU);
                        return;
                    } else {
                        TmsLog.m32945w(str2, "getMallItemList is null!");
                        ayVar = ayVar;
                        i8 = ErrorCode.EC_FAIL;
                        i7 = 0;
                        i6 = 0;
                        i5 = 0;
                        str = "";
                    }
                    ayVar.mo9151a(i8, i7, i6, i5, str);
                }
            }, 8000);
        }
    }

    /* renamed from: a */
    public static void m48a(C0887v vVar, ArrayList<CoinTask> arrayList, final C0600ap apVar) {
        if (apVar == null) {
            apVar.mo9152a(ErrorCode.EC_FAIL, null);
        } else if (vVar == null || arrayList == null || arrayList.size() <= 0) {
            apVar.mo9152a(ErrorCode.EC_PARAM_INVALID, null);
        } else {
            C0876k kVar = new C0876k();
            kVar.f1041S = vVar;
            kVar.f1042T = new ArrayList<>();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                kVar.f1042T.add(((CoinTask) it.next()).order_data);
            }
            C0638c.m75a(5111, kVar, new C0877l(), 0, new C0611b() {
                /* renamed from: a */
                public void mo9158a(int i, int i2, int i3, int i4, JceStruct jceStruct) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("[Shark]onFinish-Cmd_CSGetTasks cmdId:[");
                    sb.append(i2);
                    sb.append("]retCode:[");
                    sb.append(i3);
                    sb.append("]dataRetCode: ");
                    sb.append(i4);
                    String str = "CoinNetService";
                    TmsLog.m32943i(str, sb.toString());
                    if (i3 != 0 || i4 != 0) {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("onFinish-Cmd_CSFeatureCheck fail");
                        sb2.append(i);
                        sb2.append(" cmdId: ");
                        sb2.append(i2);
                        sb2.append(" retCode: ");
                        sb2.append(i3);
                        sb2.append(" dataRetCode: ");
                        sb2.append(i4);
                        TmsLog.m32945w(str, sb2.toString());
                        apVar.mo9152a(i3, null);
                    } else if (jceStruct != null) {
                        C0877l lVar = (C0877l) jceStruct;
                        apVar.mo9152a(lVar.f1044W, lVar.f1045X);
                    } else {
                        TmsLog.m32945w(str, "Cmd_CSGetTasks is null!");
                        apVar.mo9152a(ErrorCode.EC_FAIL, null);
                    }
                }
            }, 8000);
        }
    }

    /* renamed from: a */
    public static void m49a(C0887v vVar, ArrayList<Integer> arrayList, final C0608ax axVar) {
        if (axVar == null) {
            axVar.mo9147a(ErrorCode.EC_FAIL, -1, null);
        } else if (vVar == null) {
            axVar.mo9147a(ErrorCode.EC_PARAM_INVALID, -1, null);
        } else {
            C0879n nVar = new C0879n();
            nVar.f1049S = vVar;
            nVar.f1050Z = arrayList;
            C0638c.m75a(5110, nVar, new C0880o(), 0, new C0611b() {
                /* renamed from: a */
                public void mo9158a(int i, int i2, int i3, int i4, JceStruct jceStruct) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("[Shark]onFinish-Cmd_CSGetTasks cmdId:[");
                    sb.append(i2);
                    sb.append("]retCode:[");
                    sb.append(i3);
                    sb.append("]dataRetCode: ");
                    sb.append(i4);
                    String str = "CoinNetService";
                    TmsLog.m32943i(str, sb.toString());
                    if (i3 != 0 || i4 != 0) {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("onFinish-Cmd_CSFeatureCheck fail");
                        sb2.append(i);
                        sb2.append(" cmdId: ");
                        sb2.append(i2);
                        sb2.append(" retCode: ");
                        sb2.append(i3);
                        sb2.append(" dataRetCode: ");
                        sb2.append(i4);
                        TmsLog.m32945w(str, sb2.toString());
                        axVar.mo9147a(i3, -1, null);
                    } else if (jceStruct != null) {
                        C0880o oVar = (C0880o) jceStruct;
                        axVar.mo9147a(oVar.f1052W, oVar.f1054ac, oVar.f1053ab);
                    } else {
                        TmsLog.m32945w(str, "Cmd_CSGetTasks is null!");
                        axVar.mo9147a(ErrorCode.EC_FAIL, -1, null);
                    }
                }
            }, 8000);
        }
    }

    /* renamed from: a */
    public static void m50a(C0887v vVar, ArrayList<CoinTask> arrayList, final C0610az azVar) {
        if (azVar == null) {
            azVar.mo9153a(ErrorCode.EC_FAIL, -1, null);
        } else if (vVar == null || arrayList == null || arrayList.size() <= 0) {
            azVar.mo9153a(ErrorCode.EC_PARAM_INVALID, -1, null);
        } else {
            C0882q qVar = new C0882q();
            qVar.f1059S = vVar;
            qVar.f1060T = new ArrayList<>();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                qVar.f1060T.add(((CoinTask) it.next()).order_data);
            }
            C0638c.m75a(5112, qVar, new C0883r(), 0, new C0611b() {
                /* renamed from: a */
                public void mo9158a(int i, int i2, int i3, int i4, JceStruct jceStruct) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("[Shark]onFinish-Cmd_CSGetTasks cmdId:[");
                    sb.append(i2);
                    sb.append("]retCode:[");
                    sb.append(i3);
                    sb.append("]dataRetCode: ");
                    sb.append(i4);
                    String str = "CoinNetService";
                    TmsLog.m32943i(str, sb.toString());
                    if (i3 != 0 || i4 != 0) {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("onFinish-Cmd_CSFeatureCheck fail");
                        sb2.append(i);
                        sb2.append(" cmdId: ");
                        sb2.append(i2);
                        sb2.append(" retCode: ");
                        sb2.append(i3);
                        sb2.append(" dataRetCode: ");
                        sb2.append(i4);
                        TmsLog.m32945w(str, sb2.toString());
                        azVar.mo9153a(i3, -1, null);
                    } else if (jceStruct != null) {
                        C0883r rVar = (C0883r) jceStruct;
                        azVar.mo9153a(rVar.f1062W, rVar.f1064ac, rVar.f1063X);
                    } else {
                        TmsLog.m32945w(str, "Cmd_CSGetTasks is null!");
                        azVar.mo9153a(ErrorCode.EC_FAIL, -1, null);
                    }
                }
            }, 8000);
        }
    }
}
