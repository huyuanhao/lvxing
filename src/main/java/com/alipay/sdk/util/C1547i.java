package com.alipay.sdk.util;

import android.content.Intent;
import android.os.Bundle;
import android.os.RemoteException;
import com.alipay.android.app.IRemoteServiceCallback.Stub;

/* renamed from: com.alipay.sdk.util.i */
class C1547i extends Stub {
    /* renamed from: a */
    final /* synthetic */ C1543f f3963a;

    public boolean isHideLoadingScreen() throws RemoteException {
        return false;
    }

    public void payEnd(boolean z, String str) throws RemoteException {
    }

    C1547i(C1543f fVar) {
        this.f3963a = fVar;
    }

    public void startActivity(String str, String str2, int i, Bundle bundle) throws RemoteException {
        Intent intent = new Intent("android.intent.action.MAIN", null);
        if (bundle == null) {
            bundle = new Bundle();
        }
        try {
            bundle.putInt("CallingPid", i);
            intent.putExtras(bundle);
        } catch (Exception unused) {
        }
        intent.setClassName(str, str2);
        if (this.f3963a.f3952a != null) {
            this.f3963a.f3952a.startActivity(intent);
        }
        this.f3963a.f3956e.mo12128b();
    }
}
