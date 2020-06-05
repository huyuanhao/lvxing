package com.p530ss.android.socialbase.downloader.p559d;

import com.p530ss.android.socialbase.downloader.p560e.BaseException;
import com.p530ss.android.socialbase.downloader.p561f.C6704a;
import com.p530ss.android.socialbase.downloader.p562g.DownloadInfo;

/* renamed from: com.ss.android.socialbase.downloader.d.i */
public abstract class AbsDownloadListener implements IDownloadListener {
    /* renamed from: a */
    private static final String f21794a = AbsDownloadListener.class.getSimpleName();

    /* renamed from: a */
    public void mo31350a(DownloadInfo cVar) {
        if (C6704a.m27756a() && cVar != null) {
            String str = f21794a;
            StringBuilder sb = new StringBuilder();
            sb.append(" onPrepare -- ");
            sb.append(cVar.mo32287h());
            C6704a.m27758b(str, sb.toString());
        }
    }

    /* renamed from: b */
    public void mo31352b(DownloadInfo cVar) {
        if (C6704a.m27756a() && cVar != null) {
            String str = f21794a;
            StringBuilder sb = new StringBuilder();
            sb.append(" onStart -- ");
            sb.append(cVar.mo32287h());
            C6704a.m27758b(str, sb.toString());
        }
    }

    /* renamed from: c */
    public void mo31353c(DownloadInfo cVar) {
        if (C6704a.m27756a() && cVar != null && cVar.mo32225ab() != 0) {
            int Z = (int) ((((float) cVar.mo32180Z()) / ((float) cVar.mo32225ab())) * 100.0f);
            String str = f21794a;
            StringBuilder sb = new StringBuilder();
            sb.append(cVar.mo32287h());
            sb.append(" onProgress -- %");
            sb.append(Z);
            C6704a.m27758b(str, sb.toString());
        }
    }

    /* renamed from: d */
    public void mo31354d(DownloadInfo cVar) {
        if (C6704a.m27756a() && cVar != null) {
            String str = f21794a;
            StringBuilder sb = new StringBuilder();
            sb.append(" onPause -- ");
            sb.append(cVar.mo32287h());
            C6704a.m27758b(str, sb.toString());
        }
    }

    /* renamed from: e */
    public void mo31355e(DownloadInfo cVar) {
        if (C6704a.m27756a() && cVar != null) {
            String str = f21794a;
            StringBuilder sb = new StringBuilder();
            sb.append(" onSuccessed -- ");
            sb.append(cVar.mo32287h());
            C6704a.m27758b(str, sb.toString());
        }
    }

    /* renamed from: a */
    public void mo31351a(DownloadInfo cVar, BaseException aVar) {
        if (C6704a.m27756a() && cVar != null) {
            String str = f21794a;
            Object[] objArr = new Object[2];
            objArr[0] = cVar.mo32287h();
            objArr[1] = aVar != null ? aVar.mo32076b() : "unkown";
            C6704a.m27758b(str, String.format("onFailed on %s because of : %s", objArr));
        }
    }

    /* renamed from: f */
    public void mo31356f(DownloadInfo cVar) {
        if (C6704a.m27756a() && cVar != null) {
            String str = f21794a;
            StringBuilder sb = new StringBuilder();
            sb.append(" onCanceled -- ");
            sb.append(cVar.mo32287h());
            C6704a.m27758b(str, sb.toString());
        }
    }

    /* renamed from: g */
    public void mo31735g(DownloadInfo cVar) {
        if (C6704a.m27756a() && cVar != null) {
            String str = f21794a;
            StringBuilder sb = new StringBuilder();
            sb.append(" onFirstStart -- ");
            sb.append(cVar.mo32287h());
            C6704a.m27758b(str, sb.toString());
        }
    }

    /* renamed from: h */
    public void mo31736h(DownloadInfo cVar) {
        if (C6704a.m27756a() && cVar != null) {
            String str = f21794a;
            StringBuilder sb = new StringBuilder();
            sb.append(" onFirstSuccess -- ");
            sb.append(cVar.mo32287h());
            C6704a.m27758b(str, sb.toString());
        }
    }

    /* renamed from: b */
    public void mo31733b(DownloadInfo cVar, BaseException aVar) {
        if (C6704a.m27756a() && cVar != null) {
            String str = f21794a;
            Object[] objArr = new Object[2];
            objArr[0] = cVar.mo32287h();
            objArr[1] = aVar != null ? aVar.mo32076b() : "unkown";
            C6704a.m27758b(str, String.format("onRetry on %s because of : %s", objArr));
        }
    }

    /* renamed from: c */
    public void mo31734c(DownloadInfo cVar, BaseException aVar) {
        if (C6704a.m27756a() && cVar != null) {
            String str = f21794a;
            Object[] objArr = new Object[2];
            objArr[0] = cVar.mo32287h();
            objArr[1] = aVar != null ? aVar.mo32076b() : "unkown";
            C6704a.m27758b(str, String.format("onRetryDelay on %s because of : %s", objArr));
        }
    }

    /* renamed from: i */
    public void mo31764i(DownloadInfo cVar) {
        if (C6704a.m27756a() && cVar != null) {
            String str = f21794a;
            StringBuilder sb = new StringBuilder();
            sb.append(" onIntercept -- ");
            sb.append(cVar.mo32287h());
            C6704a.m27758b(str, sb.toString());
        }
    }
}
