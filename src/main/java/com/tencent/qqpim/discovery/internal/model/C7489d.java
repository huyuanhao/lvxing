package com.tencent.qqpim.discovery.internal.model;

import com.tencent.qqpim.discovery.internal.protocol.C7501a;
import com.tencent.qqpim.discovery.internal.protocol.C7522v;
import java.util.ArrayList;
import java.util.Iterator;

/* renamed from: com.tencent.qqpim.discovery.internal.model.d */
public class C7489d {
    /* renamed from: we */
    public int f25068we;
    /* renamed from: xe */
    public C7501a f25069xe;
    /* renamed from: ye */
    public C7486a f25070ye;

    public C7489d(C7501a aVar, C7486a aVar2, int i) {
        this.f25069xe = aVar;
        this.f25070ye = aVar2;
        this.f25068we = i;
        m32386rb();
    }

    /* renamed from: a */
    public static String m32381a(String str, ClickDataModel clickDataModel) {
        if (clickDataModel == null) {
            clickDataModel = new ClickDataModel();
        }
        StringBuilder sb = new StringBuilder();
        sb.append((int) clickDataModel.view_w);
        String str2 = "";
        sb.append(str2);
        String replace = str.replace("__WIDTH__", sb.toString());
        StringBuilder sb2 = new StringBuilder();
        sb2.append((int) clickDataModel.view_h);
        sb2.append(str2);
        String replace2 = replace.replace("__HEIGHT__", sb2.toString());
        StringBuilder sb3 = new StringBuilder();
        sb3.append((int) clickDataModel.down_x);
        sb3.append(str2);
        String replace3 = replace2.replace("__DOWN_X__", sb3.toString());
        StringBuilder sb4 = new StringBuilder();
        sb4.append((int) clickDataModel.down_x);
        sb4.append(str2);
        String replace4 = replace3.replace("$dx$", sb4.toString());
        StringBuilder sb5 = new StringBuilder();
        sb5.append((int) clickDataModel.down_y);
        sb5.append(str2);
        String replace5 = replace4.replace("__DOWN_Y__", sb5.toString());
        StringBuilder sb6 = new StringBuilder();
        sb6.append((int) clickDataModel.down_y);
        sb6.append(str2);
        String replace6 = replace5.replace("$dy$", sb6.toString());
        StringBuilder sb7 = new StringBuilder();
        sb7.append((int) clickDataModel.up_x);
        sb7.append(str2);
        String replace7 = replace6.replace("__UP_X__", sb7.toString());
        StringBuilder sb8 = new StringBuilder();
        sb8.append((int) clickDataModel.up_x);
        sb8.append(str2);
        String replace8 = replace7.replace("$ux$", sb8.toString());
        StringBuilder sb9 = new StringBuilder();
        sb9.append((int) clickDataModel.up_y);
        sb9.append(str2);
        String replace9 = replace8.replace("__UP_Y__", sb9.toString());
        StringBuilder sb10 = new StringBuilder();
        sb10.append((int) clickDataModel.up_y);
        sb10.append(str2);
        return replace9.replace("$uy$", sb10.toString());
    }

    /* renamed from: m */
    public static ArrayList<String> m32382m(ArrayList<String> arrayList) {
        ArrayList<String> arrayList2 = new ArrayList<>();
        if (m32385r(arrayList)) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                arrayList2.add(((String) it.next()).replace("__ACTION__", "30"));
            }
        }
        return arrayList2;
    }

    /* renamed from: n */
    public static ArrayList<String> m32383n(ArrayList<String> arrayList) {
        ArrayList<String> arrayList2 = new ArrayList<>();
        if (m32385r(arrayList)) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                arrayList2.add(((String) it.next()).replace("__ACTION__", "31"));
            }
        }
        return arrayList2;
    }

    /* renamed from: o */
    public static ArrayList<String> m32384o(ArrayList<String> arrayList) {
        ArrayList<String> arrayList2 = new ArrayList<>();
        if (m32385r(arrayList)) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                arrayList2.add(((String) it.next()).replace("__ACTION__", "32"));
            }
        }
        return arrayList2;
    }

    /* renamed from: r */
    private static boolean m32385r(ArrayList<String> arrayList) {
        return arrayList != null && arrayList.size() > 0;
    }

    /* renamed from: rb */
    private void m32386rb() {
        C7522v vVar;
        ArrayList<String> arrayList;
        C7522v vVar2;
        ArrayList<String> arrayList2;
        this.f25069xe.f25136ca = new C7522v();
        this.f25069xe.f25136ca.f25283Db = new ArrayList<>();
        C7491f fVar = this.f25070ye.f25065te;
        if (!fVar.sdkADRequest) {
            C7501a aVar = this.f25069xe;
            int i = aVar.f25133W;
            if (i == 11) {
                String str = "__ACTION__";
                if (this.f25068we == 1 && m32385r(fVar.f25091Re)) {
                    Iterator it = this.f25070ye.f25065te.f25091Re.iterator();
                    while (it.hasNext()) {
                        this.f25069xe.f25136ca.f25283Db.add(((String) it.next()).replace(str, "399"));
                    }
                    return;
                } else if (this.f25068we == 2 && m32385r(this.f25070ye.f25065te.f25093Te)) {
                    vVar = this.f25069xe.f25136ca;
                    arrayList = this.f25070ye.f25065te.f25093Te;
                } else if (this.f25068we == 3 && m32385r(this.f25070ye.f25065te.f25094Ue)) {
                    vVar = this.f25069xe.f25136ca;
                    arrayList = this.f25070ye.f25065te.f25094Ue;
                } else if (this.f25068we == 4 && m32385r(this.f25070ye.f25065te.f25095Ve)) {
                    vVar = this.f25069xe.f25136ca;
                    arrayList = this.f25070ye.f25065te.f25095Ve;
                } else if (this.f25068we == 5 && m32385r(this.f25070ye.f25065te.f25092Se)) {
                    Iterator it2 = this.f25070ye.f25065te.f25092Se.iterator();
                    while (it2.hasNext()) {
                        this.f25069xe.f25136ca.f25283Db.add(((String) it2.next()).replace(str, "400"));
                    }
                    return;
                } else {
                    return;
                }
            } else if (i != 3) {
                if (i != 4) {
                    if (i == 5) {
                        vVar2 = aVar.f25136ca;
                        arrayList2 = m32382m(fVar.f25088Oe);
                    } else if (i == 6) {
                        vVar2 = aVar.f25136ca;
                        arrayList2 = m32383n(fVar.f25089Pe);
                    } else if (i == 7) {
                        vVar2 = aVar.f25136ca;
                        arrayList2 = m32384o(fVar.f25096We);
                    } else {
                        return;
                    }
                    vVar2.f25283Db = arrayList2;
                    return;
                } else if (m32385r(fVar.f25086Ne)) {
                    Iterator it3 = this.f25070ye.f25065te.f25086Ne.iterator();
                    while (it3.hasNext()) {
                        this.f25069xe.f25136ca.f25283Db.add(m32381a((String) it3.next(), this.f25070ye.f25065te.f25097Xe));
                    }
                    return;
                } else {
                    return;
                }
            } else if (m32385r(fVar.f25085Me)) {
                vVar = this.f25069xe.f25136ca;
                arrayList = this.f25070ye.f25065te.f25085Me;
            } else {
                return;
            }
            vVar.f25283Db = arrayList;
        }
    }
}
