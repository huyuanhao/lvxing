package com.tencent.p607mm.opensdk.diffdev.p609a;

import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import com.tencent.p607mm.opensdk.diffdev.IDiffDevOAuth;
import com.tencent.p607mm.opensdk.diffdev.OAuthListener;
import com.tencent.p607mm.opensdk.utils.Log;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.tencent.mm.opensdk.diffdev.a.a */
public final class C7325a implements IDiffDevOAuth {
    /* access modifiers changed from: private */
    /* renamed from: c */
    public List<OAuthListener> f24798c = new ArrayList();
    /* access modifiers changed from: private */
    /* renamed from: d */
    public C7328d f24799d;
    /* renamed from: e */
    private OAuthListener f24800e = new C7326b(this);
    /* access modifiers changed from: private */
    public Handler handler = null;

    public final void addListener(OAuthListener oAuthListener) {
        if (!this.f24798c.contains(oAuthListener)) {
            this.f24798c.add(oAuthListener);
        }
    }

    public final boolean auth(String str, String str2, String str3, String str4, String str5, OAuthListener oAuthListener) {
        String str6 = str;
        StringBuilder sb = new StringBuilder("start auth, appId = ");
        sb.append(str);
        String str7 = "MicroMsg.SDK.DiffDevOAuth";
        Log.m31628i(str7, sb.toString());
        if (str6 == null || str.length() <= 0 || str2 == null || str2.length() <= 0) {
            Log.m31626d(str7, String.format("auth fail, invalid argument, appId = %s, scope = %s", new Object[]{str6, str2}));
            return false;
        }
        if (this.handler == null) {
            this.handler = new Handler(Looper.getMainLooper());
        }
        addListener(oAuthListener);
        if (this.f24799d != null) {
            Log.m31626d(str7, "auth, already running, no need to start auth again");
            return true;
        }
        C7328d dVar = new C7328d(str, str2, str3, str4, str5, this.f24800e);
        this.f24799d = dVar;
        C7328d dVar2 = this.f24799d;
        if (VERSION.SDK_INT >= 11) {
            dVar2.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
        } else {
            dVar2.execute(new Void[0]);
        }
        return true;
    }

    public final void detach() {
        Log.m31628i("MicroMsg.SDK.DiffDevOAuth", "detach");
        this.f24798c.clear();
        stopAuth();
    }

    public final void removeAllListeners() {
        this.f24798c.clear();
    }

    public final void removeListener(OAuthListener oAuthListener) {
        this.f24798c.remove(oAuthListener);
    }

    public final boolean stopAuth() {
        boolean z;
        String str = "MicroMsg.SDK.DiffDevOAuth";
        Log.m31628i(str, "stopAuth");
        try {
            z = this.f24799d == null ? true : this.f24799d.mo35735a();
        } catch (Exception e) {
            StringBuilder sb = new StringBuilder("stopAuth fail, ex = ");
            sb.append(e.getMessage());
            Log.m31630w(str, sb.toString());
            z = false;
        }
        this.f24799d = null;
        return z;
    }
}
