package com.kwai.filedownloader.services;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.kwai.filedownloader.C4648f;
import com.kwai.filedownloader.C4740t;
import com.kwai.filedownloader.event.DownloadServiceConnectChangedEvent;
import com.kwai.filedownloader.event.DownloadServiceConnectChangedEvent.ConnectStatus;
import com.kwai.filedownloader.p358f.C4660d;
import com.kwai.filedownloader.p358f.C4664f;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* renamed from: com.kwai.filedownloader.services.a */
public abstract class C4729a<CALLBACK extends Binder, INTERFACE extends IInterface> implements ServiceConnection, C4740t {
    /* renamed from: a */
    private final CALLBACK f15265a;
    /* renamed from: b */
    private volatile INTERFACE f15266b;
    /* renamed from: c */
    private final Class<?> f15267c;
    /* renamed from: d */
    private final HashMap<String, Object> f15268d = new HashMap<>();
    /* renamed from: e */
    private final List<Context> f15269e = new ArrayList();
    /* renamed from: f */
    private final ArrayList<Runnable> f15270f = new ArrayList<>();

    protected C4729a(Class<?> cls) {
        this.f15267c = cls;
        this.f15265a = mo25302b();
    }

    /* renamed from: a */
    private void m19380a(boolean z) {
        if (!z && this.f15266b != null) {
            try {
                mo25300a(this.f15266b, this.f15265a);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
        if (C4660d.f15179a) {
            C4660d.m19123c(this, "release connect resources %s", this.f15266b);
        }
        this.f15266b = null;
        C4648f.m19095a().mo25204b(new DownloadServiceConnectChangedEvent(z ? ConnectStatus.lost : ConnectStatus.disconnected, this.f15267c));
    }

    /* renamed from: a */
    public void mo25261a(Context context) {
        mo25324a(context, (Runnable) null);
    }

    /* renamed from: a */
    public void mo25324a(Context context, Runnable runnable) {
        if (!C4664f.m19142a(context)) {
            if (C4660d.f15179a) {
                C4660d.m19123c(this, "bindStartByContext %s", context.getClass().getSimpleName());
            }
            Intent intent = new Intent(context, this.f15267c);
            if (runnable != null && !this.f15270f.contains(runnable)) {
                this.f15270f.add(runnable);
            }
            if (!this.f15269e.contains(context)) {
                this.f15269e.add(context);
            }
            context.bindService(intent, this, 1);
            context.startService(intent);
            return;
        }
        throw new IllegalStateException("Fatal-Exception: You can't bind the FileDownloadService in :filedownloader process.\n It's the invalid operation and is likely to cause unexpected problems.\n Maybe you want to use non-separate process mode for FileDownloader, More detail about non-separate mode, please move to wiki manually: https://github.com/lingochamp/FileDownloader/wiki/filedownloader.properties");
    }

    /* renamed from: a */
    public abstract void mo25300a(INTERFACE interfaceR, CALLBACK callback);

    /* renamed from: b */
    public abstract CALLBACK mo25302b();

    /* renamed from: b */
    public abstract INTERFACE mo25303b(IBinder iBinder);

    /* renamed from: b */
    public abstract void mo25304b(INTERFACE interfaceR, CALLBACK callback);

    /* renamed from: c */
    public boolean mo25265c() {
        return mo25325d() != null;
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public INTERFACE mo25325d() {
        return this.f15266b;
    }

    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        this.f15266b = mo25303b(iBinder);
        if (C4660d.f15179a) {
            C4660d.m19123c(this, "onServiceConnected %s %s", componentName, this.f15266b);
        }
        try {
            mo25304b(this.f15266b, this.f15265a);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        List<Runnable> list = (List) this.f15270f.clone();
        this.f15270f.clear();
        for (Runnable run : list) {
            run.run();
        }
        C4648f.m19095a().mo25204b(new DownloadServiceConnectChangedEvent(ConnectStatus.connected, this.f15267c));
    }

    public void onServiceDisconnected(ComponentName componentName) {
        if (C4660d.f15179a) {
            C4660d.m19123c(this, "onServiceDisconnected %s %s", componentName, this.f15266b);
        }
        m19380a(true);
    }
}
