package com.p530ss.android.socialbase.downloader.p569m;

import android.util.SparseArray;
import com.p530ss.android.socialbase.downloader.p559d.AbsDownloadListener;
import com.p530ss.android.socialbase.downloader.p559d.IDownloadListener;
import com.p530ss.android.socialbase.downloader.p560e.BaseException;
import com.p530ss.android.socialbase.downloader.p562g.DownloadInfo;

/* renamed from: com.ss.android.socialbase.downloader.m.e */
public class DownloadListenerUtils {
    /* renamed from: a */
    public static void m28746a(int i, SparseArray<IDownloadListener> sparseArray, boolean z, DownloadInfo cVar, BaseException aVar) {
        SparseArray clone;
        if (z && sparseArray != null) {
            try {
                if (sparseArray.size() > 0) {
                    synchronized (sparseArray) {
                        clone = sparseArray.clone();
                    }
                    for (int i2 = 0; i2 < clone.size(); i2++) {
                        IDownloadListener adVar = (IDownloadListener) clone.get(clone.keyAt(i2));
                        if (adVar != null) {
                            switch (i) {
                                case -7:
                                    if (!(adVar instanceof AbsDownloadListener)) {
                                        break;
                                    } else {
                                        ((AbsDownloadListener) adVar).mo31764i(cVar);
                                        break;
                                    }
                                case -6:
                                    adVar.mo31736h(cVar);
                                    break;
                                case -5:
                                case -2:
                                    adVar.mo31354d(cVar);
                                    break;
                                case -4:
                                    adVar.mo31356f(cVar);
                                    break;
                                case -3:
                                    adVar.mo31355e(cVar);
                                    break;
                                case -1:
                                    adVar.mo31351a(cVar, aVar);
                                    break;
                                case 1:
                                    adVar.mo31350a(cVar);
                                    break;
                                case 2:
                                    adVar.mo31352b(cVar);
                                    break;
                                case 4:
                                    adVar.mo31353c(cVar);
                                    break;
                                case 5:
                                    adVar.mo31733b(cVar, aVar);
                                    break;
                                case 6:
                                    adVar.mo31735g(cVar);
                                    break;
                                case 7:
                                    adVar.mo31734c(cVar, aVar);
                                    break;
                            }
                        }
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }
}
