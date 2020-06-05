package com.kwai.filedownloader;

import android.os.IBinder;
import android.os.RemoteException;
import com.kwai.filedownloader.message.C4698e;
import com.kwai.filedownloader.message.MessageSnapshot;
import com.kwai.filedownloader.p355c.C4610a;
import com.kwai.filedownloader.p355c.C4610a.C4611a;
import com.kwai.filedownloader.p355c.C4613b;
import com.kwai.filedownloader.p355c.C4613b.C4614a;
import com.kwai.filedownloader.p356d.C4619b;
import com.kwai.filedownloader.p358f.C4651a;
import com.kwai.filedownloader.services.C4729a;
import com.kwai.filedownloader.services.FileDownloadService.SeparateProcessService;

/* renamed from: com.kwai.filedownloader.o */
class C4717o extends C4729a<C4718a, C4613b> {

    /* renamed from: com.kwai.filedownloader.o$a */
    protected static class C4718a extends C4611a {
        protected C4718a() {
        }

        /* renamed from: a */
        public void mo25008a(MessageSnapshot messageSnapshot) {
            C4698e.m19280a().mo25288a(messageSnapshot);
        }
    }

    C4717o() {
        super(SeparateProcessService.class);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public C4613b mo25303b(IBinder iBinder) {
        return C4614a.m18853a(iBinder);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public C4718a mo25302b() {
        return new C4718a();
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo25304b(C4613b bVar, C4718a aVar) {
        bVar.mo25014a((C4610a) aVar);
    }

    /* renamed from: a */
    public boolean mo25262a(int i) {
        if (!mo25265c()) {
            return C4651a.m19098a(i);
        }
        try {
            return ((C4613b) mo25325d()).mo25017a(i);
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    /* renamed from: a */
    public boolean mo25263a(String str, String str2, boolean z, int i, int i2, int i3, boolean z2, C4619b bVar, boolean z3) {
        if (!mo25265c()) {
            return C4651a.m19099a(str, str2, z);
        }
        try {
            ((C4613b) mo25325d()).mo25015a(str, str2, z, i, i2, i3, z2, bVar, z3);
            return true;
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    /* renamed from: b */
    public byte mo25264b(int i) {
        if (!mo25265c()) {
            return C4651a.m19100b(i);
        }
        byte b = 0;
        try {
            b = ((C4613b) mo25325d()).mo25025e(i);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return b;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo25300a(C4613b bVar, C4718a aVar) {
        bVar.mo25019b((C4610a) aVar);
    }

    /* renamed from: c */
    public boolean mo25266c(int i) {
        if (!mo25265c()) {
            return C4651a.m19101c(i);
        }
        try {
            return ((C4613b) mo25325d()).mo25026f(i);
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }
}
