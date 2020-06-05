package com.kwai.filedownloader.services;

import android.content.Intent;
import com.kwai.filedownloader.p356d.C4621c;
import com.kwai.filedownloader.p358f.C4654c;

/* renamed from: com.kwai.filedownloader.services.f */
public class C4736f {
    /* renamed from: a */
    public static void m19445a(C4621c cVar) {
        if (cVar == null) {
            throw new IllegalArgumentException();
        } else if (cVar.mo25088f() == -3) {
            Intent intent = new Intent("filedownloader.intent.action.completed");
            intent.putExtra("model", cVar);
            C4654c.m19105a().sendBroadcast(intent);
        } else {
            throw new IllegalStateException();
        }
    }
}
