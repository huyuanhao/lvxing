package com.elvishew.xlog.p226d;

/* renamed from: com.elvishew.xlog.d.d */
public class PrinterSet implements Printer {
    /* renamed from: a */
    private Printer[] f9461a;

    public PrinterSet(Printer... cVarArr) {
        this.f9461a = cVarArr;
    }

    /* renamed from: a */
    public void mo17097a(int i, String str, String str2) {
        for (Printer a : this.f9461a) {
            a.mo17097a(i, str, str2);
        }
    }
}
