package com.p620ut.mini.p621a;

import com.p620ut.mini.p627e.UTMI1010_2001Event;

/* renamed from: com.ut.mini.a.a */
public class UTMIVariables {
    /* renamed from: a */
    private static UTMIVariables f26003a = new UTMIVariables();
    /* renamed from: b */
    private String f26004b = null;
    /* renamed from: c */
    private String f26005c = null;
    /* renamed from: d */
    private String f26006d = null;
    /* renamed from: e */
    private UTMI1010_2001Event f26007e = null;
    /* renamed from: f */
    private boolean f26008f = false;

    /* renamed from: a */
    public synchronized boolean mo37393a() {
        return this.f26008f;
    }

    /* renamed from: a */
    public synchronized void mo37391a(UTMI1010_2001Event aVar) {
        this.f26007e = aVar;
    }

    /* renamed from: b */
    public static UTMIVariables m33112b() {
        return f26003a;
    }

    /* renamed from: c */
    public String mo37395c() {
        return this.f26006d;
    }

    /* renamed from: a */
    public void mo37392a(String str) {
        this.f26006d = str;
    }

    /* renamed from: d */
    public String mo37396d() {
        return this.f26005c;
    }

    /* renamed from: b */
    public void mo37394b(String str) {
        this.f26005c = str;
    }
}
