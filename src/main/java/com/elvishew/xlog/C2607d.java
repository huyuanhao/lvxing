package com.elvishew.xlog;

import com.elvishew.xlog.p223b.C2604a;
import com.elvishew.xlog.p224c.SystemCompat;
import com.elvishew.xlog.p224c.p225a.StackTraceUtil;
import com.elvishew.xlog.p226d.Printer;

/* compiled from: Logger */
/* renamed from: com.elvishew.xlog.d */
public class C2607d {
    /* renamed from: a */
    private LogConfiguration f9457a;
    /* renamed from: b */
    private Printer f9458b;

    C2607d(LogConfiguration aVar, Printer cVar) {
        this.f9457a = aVar;
        this.f9458b = cVar;
    }

    /* renamed from: a */
    public void mo17095a(String str) {
        mo17094a(3, str);
    }

    /* renamed from: b */
    public void mo17096b(String str) {
        mo17094a(6, str);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo17094a(int i, String str) {
        if (i >= this.f9457a.f9418a) {
            m12678b(i, str);
        }
    }

    /* renamed from: b */
    private void m12678b(int i, String str) {
        String str2;
        String str3;
        String str4 = this.f9457a.f9419b;
        String a = this.f9457a.f9420c ? this.f9457a.f9428k.mo17099a(Thread.currentThread()) : null;
        String a2 = this.f9457a.f9421d ? this.f9457a.f9429l.mo17099a(StackTraceUtil.m12669a(new Throwable().getStackTrace(), this.f9457a.f9422e, this.f9457a.f9423f)) : null;
        if (this.f9457a.f9431n != null) {
            LogItem bVar = new LogItem(i, str4, a, a2, str);
            for (C2604a aVar : this.f9457a.f9431n) {
                bVar = aVar.mo17090a(bVar);
                if (bVar != null) {
                    if (bVar.f9449b == null || bVar.f9450c == null) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("Interceptor ");
                        sb.append(aVar);
                        sb.append(" should not remove the tag or message of a log, if you don't want to print this log, just return a null when intercept.");
                        throw new IllegalStateException(sb.toString());
                    }
                } else {
                    return;
                }
            }
            i = bVar.f9448a;
            str4 = bVar.f9449b;
            a = bVar.f9451d;
            a2 = bVar.f9452e;
            str = bVar.f9450c;
        }
        Printer cVar = this.f9458b;
        if (this.f9457a.f9424g) {
            str2 = this.f9457a.f9430m.mo17099a(new String[]{a, a2, str});
        } else {
            StringBuilder sb2 = new StringBuilder();
            String str5 = "";
            if (a != null) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append(a);
                sb3.append(SystemCompat.f9456a);
                str3 = sb3.toString();
            } else {
                str3 = str5;
            }
            sb2.append(str3);
            if (a2 != null) {
                StringBuilder sb4 = new StringBuilder();
                sb4.append(a2);
                sb4.append(SystemCompat.f9456a);
                str5 = sb4.toString();
            }
            sb2.append(str5);
            sb2.append(str);
            str2 = sb2.toString();
        }
        cVar.mo17097a(i, str4, str2);
    }
}
