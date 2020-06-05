package com.p530ss.android.socialbase.appdownloader.p554e.p555a;

import java.io.PrintStream;

/* renamed from: com.ss.android.socialbase.appdownloader.e.a.h */
public class XmlPullParserException extends Exception {
    /* renamed from: a */
    protected Throwable f21571a;
    /* renamed from: b */
    protected int f21572b;
    /* renamed from: c */
    protected int f21573c;

    public XmlPullParserException(String str, XmlPullParser gVar, Throwable th) {
        String str2;
        String str3;
        StringBuilder sb = new StringBuilder();
        String str4 = "";
        if (str == null) {
            str2 = str4;
        } else {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(str);
            sb2.append(" ");
            str2 = sb2.toString();
        }
        sb.append(str2);
        if (gVar == null) {
            str3 = str4;
        } else {
            StringBuilder sb3 = new StringBuilder();
            sb3.append("(position:");
            sb3.append(gVar.mo31516d());
            sb3.append(") ");
            str3 = sb3.toString();
        }
        sb.append(str3);
        if (th != null) {
            StringBuilder sb4 = new StringBuilder();
            sb4.append("caused by: ");
            sb4.append(th);
            str4 = sb4.toString();
        }
        sb.append(str4);
        super(sb.toString());
        this.f21572b = -1;
        this.f21573c = -1;
        if (gVar != null) {
            this.f21572b = gVar.mo31514c();
            this.f21573c = gVar.mo31519f();
        }
        this.f21571a = th;
    }

    public void printStackTrace() {
        if (this.f21571a == null) {
            super.printStackTrace();
            return;
        }
        synchronized (System.err) {
            PrintStream printStream = System.err;
            StringBuilder sb = new StringBuilder();
            sb.append(super.getMessage());
            sb.append("; nested exception is:");
            printStream.println(sb.toString());
            this.f21571a.printStackTrace();
        }
    }
}
