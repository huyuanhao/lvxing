package com.kwai.filedownloader;

import android.content.Context;
import android.content.Intent;
import com.kwai.filedownloader.event.DownloadServiceConnectChangedEvent;
import com.kwai.filedownloader.event.DownloadServiceConnectChangedEvent.ConnectStatus;
import com.kwai.filedownloader.p356d.C4619b;
import com.kwai.filedownloader.p358f.C4651a;
import com.kwai.filedownloader.services.C4734e;
import com.kwai.filedownloader.services.C4734e.C4735a;
import com.kwai.filedownloader.services.FileDownloadService.SharedMainProcessService;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.kwai.filedownloader.n */
class C4716n implements C4735a, C4740t {
    /* renamed from: a */
    private static final Class<?> f15250a = SharedMainProcessService.class;
    /* renamed from: b */
    private final ArrayList<Runnable> f15251b = new ArrayList<>();
    /* renamed from: c */
    private C4734e f15252c;

    C4716n() {
    }

    /* renamed from: a */
    public void mo25295a() {
        this.f15252c = null;
        C4648f.m19095a().mo25204b(new DownloadServiceConnectChangedEvent(ConnectStatus.disconnected, f15250a));
    }

    /* renamed from: a */
    public void mo25261a(Context context) {
        mo25296a(context, null);
    }

    /* renamed from: a */
    public void mo25296a(Context context, Runnable runnable) {
        if (runnable != null && !this.f15251b.contains(runnable)) {
            this.f15251b.add(runnable);
        }
        context.startService(new Intent(context, f15250a));
    }

    /* renamed from: a */
    public void mo25297a(C4734e eVar) {
        this.f15252c = eVar;
        List<Runnable> list = (List) this.f15251b.clone();
        this.f15251b.clear();
        for (Runnable run : list) {
            run.run();
        }
        C4648f.m19095a().mo25204b(new DownloadServiceConnectChangedEvent(ConnectStatus.connected, f15250a));
    }

    /* renamed from: a */
    public boolean mo25262a(int i) {
        return !mo25265c() ? C4651a.m19098a(i) : this.f15252c.mo25017a(i);
    }

    /* renamed from: a */
    public boolean mo25263a(String str, String str2, boolean z, int i, int i2, int i3, boolean z2, C4619b bVar, boolean z3) {
        if (!mo25265c()) {
            return C4651a.m19099a(str, str2, z);
        }
        this.f15252c.mo25015a(str, str2, z, i, i2, i3, z2, bVar, z3);
        return true;
    }

    /* renamed from: b */
    public byte mo25264b(int i) {
        return !mo25265c() ? C4651a.m19100b(i) : this.f15252c.mo25025e(i);
    }

    /* renamed from: c */
    public boolean mo25265c() {
        return this.f15252c != null;
    }

    /* renamed from: c */
    public boolean mo25266c(int i) {
        return !mo25265c() ? C4651a.m19101c(i) : this.f15252c.mo25026f(i);
    }
}
