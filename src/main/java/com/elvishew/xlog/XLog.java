package com.elvishew.xlog;

import com.elvishew.xlog.p224c.C2605b;
import com.elvishew.xlog.p224c.DefaultsFactory;
import com.elvishew.xlog.p226d.Printer;
import com.elvishew.xlog.p226d.PrinterSet;

/* renamed from: com.elvishew.xlog.e */
public class XLog {
    /* renamed from: a */
    static LogConfiguration f9462a;
    /* renamed from: b */
    static Printer f9463b;
    /* renamed from: c */
    static boolean f9464c;
    /* renamed from: d */
    private static C2607d f9465d;

    private XLog() {
    }

    /* renamed from: a */
    public static void m12689a(LogConfiguration aVar) {
        m12690a(aVar, DefaultsFactory.m12659h());
    }

    /* renamed from: a */
    public static void m12690a(LogConfiguration aVar, Printer... cVarArr) {
        if (f9464c) {
            C2605b.m12670a().mo17091a("XLog is already initialized, do not initialize again");
        }
        f9464c = true;
        if (aVar != null) {
            f9462a = aVar;
            f9463b = new PrinterSet(cVarArr);
            f9465d = new C2607d(f9462a, f9463b);
            return;
        }
        throw new IllegalArgumentException("Please specify a LogConfiguration");
    }

    /* renamed from: a */
    static void m12688a() {
        if (!f9464c) {
            throw new IllegalStateException("Do you forget to initialize XLog?");
        }
    }

    /* renamed from: a */
    public static void m12691a(String str) {
        m12688a();
        f9465d.mo17095a(str);
    }

    /* renamed from: b */
    public static void m12692b(String str) {
        m12688a();
        f9465d.mo17096b(str);
    }
}
