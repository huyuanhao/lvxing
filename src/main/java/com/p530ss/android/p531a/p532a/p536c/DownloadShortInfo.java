package com.p530ss.android.p531a.p532a.p536c;

import android.text.TextUtils;
import com.p530ss.android.socialbase.downloader.p560e.BaseException;
import com.p530ss.android.socialbase.downloader.p562g.DownloadInfo;
import java.util.Arrays;

/* renamed from: com.ss.android.a.a.c.e */
public class DownloadShortInfo {
    /* renamed from: a */
    public long f21105a = -1;
    /* renamed from: b */
    public int f21106b = -1;
    /* renamed from: c */
    public long f21107c = -1;
    /* renamed from: d */
    public long f21108d = -1;
    /* renamed from: e */
    public String f21109e;
    /* renamed from: f */
    public int f21110f = 0;
    /* renamed from: g */
    public boolean f21111g;

    public boolean equals(Object obj) {
        if (!(obj instanceof DownloadShortInfo) || obj == null) {
            return super.equals(obj);
        }
        DownloadShortInfo eVar = (DownloadShortInfo) obj;
        boolean z = true;
        boolean z2 = this.f21105a == eVar.f21105a;
        boolean z3 = this.f21106b == eVar.f21106b;
        boolean z4 = this.f21107c == eVar.f21107c;
        boolean z5 = (TextUtils.isEmpty(this.f21109e) && TextUtils.isEmpty(eVar.f21109e)) || (!TextUtils.isEmpty(this.f21109e) && !TextUtils.isEmpty(eVar.f21109e) && this.f21109e.equals(eVar.f21109e));
        if (!z2 || !z3 || !z4 || !z5) {
            z = false;
        }
        return z;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Long.valueOf(this.f21105a), Integer.valueOf(this.f21106b), Long.valueOf(this.f21107c), this.f21109e});
    }

    /* renamed from: a */
    public void mo31138a(DownloadInfo cVar) {
        if (cVar != null) {
            this.f21105a = (long) cVar.mo32283g();
            this.f21106b = cVar.mo32308q();
            this.f21108d = cVar.mo32180Z();
            this.f21107c = cVar.mo32225ab();
            this.f21109e = cVar.mo32305n();
            BaseException aW = cVar.mo32220aW();
            if (aW != null) {
                this.f21110f = aW.mo32073a();
            } else {
                this.f21110f = 0;
            }
            this.f21111g = cVar.mo32317x();
        }
    }
}
