package com.bytedance.sdk.openadsdk.downloadnew.core;

import com.bytedance.sdk.openadsdk.TTAppDownloadListener;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* renamed from: com.bytedance.sdk.openadsdk.downloadnew.core.c */
public class TTAppDownloadListenerGroup implements TTAppDownloadListener {
    /* renamed from: a */
    private final List<TTAppDownloadListener> f8625a = Collections.synchronizedList(new LinkedList());

    /* renamed from: a */
    public void mo16559a(TTAppDownloadListener tTAppDownloadListener) {
        if (tTAppDownloadListener != null) {
            for (TTAppDownloadListener tTAppDownloadListener2 : this.f8625a) {
                if (tTAppDownloadListener2 != null && tTAppDownloadListener2 == tTAppDownloadListener) {
                    return;
                }
            }
            this.f8625a.add(tTAppDownloadListener);
        }
    }

    /* renamed from: a */
    public void mo16558a() {
        if (!this.f8625a.isEmpty()) {
            this.f8625a.clear();
        }
    }

    public void onIdle() {
        Iterator it = this.f8625a.iterator();
        while (it.hasNext()) {
            TTAppDownloadListener tTAppDownloadListener = (TTAppDownloadListener) it.next();
            if (tTAppDownloadListener == null) {
                it.remove();
            } else {
                tTAppDownloadListener.onIdle();
            }
        }
    }

    public void onDownloadActive(long j, long j2, String str, String str2) {
        Iterator it = this.f8625a.iterator();
        while (it.hasNext()) {
            TTAppDownloadListener tTAppDownloadListener = (TTAppDownloadListener) it.next();
            if (tTAppDownloadListener == null) {
                it.remove();
            } else {
                tTAppDownloadListener.onDownloadActive(j, j2, str, str2);
            }
        }
    }

    public void onDownloadPaused(long j, long j2, String str, String str2) {
        Iterator it = this.f8625a.iterator();
        while (it.hasNext()) {
            TTAppDownloadListener tTAppDownloadListener = (TTAppDownloadListener) it.next();
            if (tTAppDownloadListener == null) {
                it.remove();
            } else {
                tTAppDownloadListener.onDownloadPaused(j, j2, str, str2);
            }
        }
    }

    public void onDownloadFailed(long j, long j2, String str, String str2) {
        Iterator it = this.f8625a.iterator();
        while (it.hasNext()) {
            TTAppDownloadListener tTAppDownloadListener = (TTAppDownloadListener) it.next();
            if (tTAppDownloadListener == null) {
                it.remove();
            } else {
                tTAppDownloadListener.onDownloadFailed(j, j2, str, str2);
            }
        }
    }

    public void onInstalled(String str, String str2) {
        Iterator it = this.f8625a.iterator();
        while (it.hasNext()) {
            TTAppDownloadListener tTAppDownloadListener = (TTAppDownloadListener) it.next();
            if (tTAppDownloadListener == null) {
                it.remove();
            } else {
                tTAppDownloadListener.onInstalled(str, str2);
            }
        }
    }

    public void onDownloadFinished(long j, String str, String str2) {
        Iterator it = this.f8625a.iterator();
        while (it.hasNext()) {
            TTAppDownloadListener tTAppDownloadListener = (TTAppDownloadListener) it.next();
            if (tTAppDownloadListener == null) {
                it.remove();
            } else {
                tTAppDownloadListener.onDownloadFinished(j, str, str2);
            }
        }
    }
}
