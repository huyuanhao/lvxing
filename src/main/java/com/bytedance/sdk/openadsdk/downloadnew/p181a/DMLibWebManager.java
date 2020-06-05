package com.bytedance.sdk.openadsdk.downloadnew.p181a;

import android.app.Activity;
import android.content.Context;
import android.os.Environment;
import android.view.View;
import com.bytedance.sdk.openadsdk.TTAppDownloadListener;
import com.bytedance.sdk.openadsdk.TTCustomController;
import com.bytedance.sdk.openadsdk.core.GlobalInfo;
import com.bytedance.sdk.openadsdk.core.InternalContainer;
import com.bytedance.sdk.openadsdk.downloadnew.core.ITTDownloadAdapter;
import com.bytedance.sdk.openadsdk.downloadnew.core.ITTDownloadAdapter.C2417a;
import com.bytedance.sdk.openadsdk.downloadnew.p181a.p183b.LibModelFactory;
import com.p530ss.android.p531a.p532a.p534b.C6507c;
import java.lang.ref.WeakReference;
import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: com.bytedance.sdk.openadsdk.downloadnew.a.c */
public class DMLibWebManager implements ITTDownloadAdapter {
    /* renamed from: a */
    private WeakReference<Context> f8613a;
    /* renamed from: b */
    private String f8614b;
    /* renamed from: c */
    private String f8615c;
    /* renamed from: d */
    private AtomicBoolean f8616d = new AtomicBoolean(false);
    /* renamed from: e */
    private C6507c f8617e;

    /* renamed from: a */
    public void mo16505a(int i, C2417a aVar) {
    }

    /* renamed from: a */
    public void mo16507a(Activity activity) {
    }

    /* renamed from: a */
    public void mo16508a(View view) {
    }

    /* renamed from: a */
    public void mo16509a(TTAppDownloadListener tTAppDownloadListener) {
    }

    /* renamed from: a */
    public void mo16510a(TTAppDownloadListener tTAppDownloadListener, boolean z) {
    }

    /* renamed from: a */
    public boolean mo16512a(boolean z) {
        return false;
    }

    /* renamed from: b */
    public boolean mo16515b(boolean z) {
        return false;
    }

    /* renamed from: c */
    public void mo16516c() {
    }

    /* renamed from: e */
    public boolean mo16519e() {
        return false;
    }

    /* renamed from: h */
    public void mo16522h() {
    }

    /* renamed from: i */
    public boolean mo16523i() {
        return false;
    }

    /* renamed from: j */
    public boolean mo16524j() {
        return false;
    }

    /* renamed from: k */
    public boolean mo16525k() {
        return false;
    }

    public DMLibWebManager(Context context, String str, String str2) {
        this.f8613a = new WeakReference<>(context);
        this.f8614b = str;
        this.f8615c = str2;
        this.f8617e = LibModelFactory.m11197a(str, str2).mo31090a();
        mo16504a();
    }

    /* renamed from: l */
    private Context m11202l() {
        WeakReference<Context> weakReference = this.f8613a;
        return (weakReference == null || weakReference.get() == null) ? InternalContainer.m10059a() : (Context) this.f8613a.get();
    }

    /* renamed from: a */
    public void mo16504a() {
        m11204n();
    }

    /* renamed from: m */
    private synchronized void m11203m() {
        if (this.f8616d.get()) {
            this.f8616d.set(false);
            LibHolder.m11234d().mo31432a(this.f8614b, hashCode());
        }
    }

    /* renamed from: n */
    private synchronized void m11204n() {
        this.f8616d.get();
        this.f8616d.set(true);
        LibHolder.m11234d().mo31430a(m11202l(), hashCode(), null, this.f8617e);
    }

    /* renamed from: b */
    public void mo16513b() {
        m11204n();
    }

    /* renamed from: d */
    public void mo16518d() {
        m11203m();
        WeakReference<Context> weakReference = this.f8613a;
        if (weakReference != null) {
            weakReference.clear();
            this.f8613a = null;
        }
    }

    /* renamed from: f */
    public void mo16520f() {
        TTCustomController d = GlobalInfo.m9616c().mo15672d();
        if (d != null && !d.isCanUseWriteExternal()) {
            try {
                String str = LibHolder.f8618a;
                String absolutePath = Environment.getDataDirectory().getAbsolutePath();
                if (str != null && !str.startsWith(absolutePath)) {
                    return;
                }
            } catch (Throwable unused) {
            }
        }
        LibHolder.m11234d().mo31433a(this.f8614b, this.f8617e.mo31064d(), 2);
    }

    /* renamed from: g */
    public void mo16521g() {
        mo16551a(0);
    }

    /* renamed from: a */
    public void mo16551a(long j) {
        LibHolder.m11234d().mo31435a(this.f8614b, true);
    }
}
