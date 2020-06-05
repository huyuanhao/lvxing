package com.p368pw.inner.base.p387d.p388a;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Environment;
import android.text.TextUtils;
import androidx.core.content.FileProvider;
import com.p368pw.inner.base.C5114a.C5117a;
import com.p368pw.inner.base.p385b.C5138c;
import com.p368pw.inner.base.p387d.C5205o;
import com.p368pw.inner.base.p387d.p388a.C5149a.C5151a;
import com.p368pw.inner.p369a.p370a.p371a.C4827e;
import com.p368pw.p392us.DownloadNotifyManager;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

/* renamed from: com.pw.inner.base.d.a.c */
public class C5153c {
    /* renamed from: a */
    private volatile HashMap<String, C5152b> f16817a = new HashMap<>();
    /* renamed from: b */
    private HashMap<String, ArrayList<C5157a>> f16818b = new HashMap<>();

    /* renamed from: com.pw.inner.base.d.a.c$a */
    public interface C5157a {
        void onComplete(String str, String str2);

        void onProgress(int i);
    }

    /* renamed from: com.pw.inner.base.d.a.c$b */
    public interface C5158b {
        /* renamed from: a */
        void mo26340a();

        /* renamed from: b */
        void mo26341b();

        /* renamed from: c */
        void mo26342c();
    }

    /* renamed from: com.pw.inner.base.d.a.c$c */
    private static class C5159c {
        /* access modifiers changed from: private|static */
        /* renamed from: a */
        public static C5153c f16837a = new C5153c();
    }

    /* renamed from: a */
    public static C5153c m21275a() {
        return C5159c.f16837a;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m21276a(Context context, File file, C4827e eVar, C5158b bVar) {
        Uri fromFile;
        Uri fromFile2;
        String str = ".us.fileprovider";
        String str2 = "android.intent.action.VIEW";
        String str3 = "application/vnd.android.package-archive";
        try {
            Intent intent = new Intent(str2);
            intent.setFlags(268435456);
            if (VERSION.SDK_INT >= 24) {
                intent.addFlags(1);
                StringBuilder sb = new StringBuilder();
                sb.append(context.getPackageName());
                sb.append(str);
                fromFile2 = FileProvider.getUriForFile(context, sb.toString(), file);
            } else {
                fromFile2 = Uri.fromFile(file);
            }
            intent.setDataAndType(fromFile2, str3);
            context.startActivity(intent);
            if (eVar != null) {
                eVar.mo25798d();
            }
        } catch (Throwable unused) {
            if (bVar != null) {
                bVar.mo26342c();
            }
            if (eVar != null) {
                eVar.mo25800e();
            }
            C5205o.m21464a(th);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m21281a(String str) {
        if (str != null) {
            try {
                if (this.f16817a != null) {
                    this.f16817a.remove(str);
                }
            } catch (Throwable unused) {
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m21282a(String str, int i) {
        if (this.f16817a != null) {
            ((C5152b) this.f16817a.get(str)).f16814a = i;
        }
    }

    /* renamed from: a */
    private void m21283a(String str, C5152b bVar) {
        if (!(bVar == null || this.f16817a == null)) {
            this.f16817a.put(str, bVar);
        }
    }

    /* access modifiers changed from: private|declared_synchronized */
    /* renamed from: a */
    public synchronized void m21284a(String str, String str2, int i, boolean z) {
        try {
            ArrayList arrayList = (ArrayList) this.f16818b.get(str);
            if (arrayList != null) {
                for (int i2 = 0; i2 < arrayList.size(); i2++) {
                    C5157a aVar = (C5157a) arrayList.get(i2);
                    if (z) {
                        aVar.onComplete(str, str2);
                    } else {
                        aVar.onProgress(i);
                    }
                }
            }
        } catch (Throwable unused) {
        }
    }

    /* renamed from: b */
    private String m21285b(Context context, String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(Environment.getExternalStorageDirectory());
        sb.append("/windir/");
        sb.append(context.getPackageName());
        sb.append("/");
        sb.append(str);
        sb.append(".apk");
        return sb.toString();
    }

    /* renamed from: b */
    private boolean m21286b(String str) {
        if (this.f16817a != null) {
            C5152b bVar = (C5152b) this.f16817a.get(str);
            if (bVar != null && bVar.f16814a < 100) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: c */
    private boolean m21287c(String str) {
        if (this.f16817a != null) {
            C5152b bVar = (C5152b) this.f16817a.get(str);
            if (bVar != null && bVar.f16814a == 100) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: a */
    public int mo26759a(Context context, String str) {
        if (m21286b(str)) {
            return 2;
        }
        return m21287c(str) ? 1 : 3;
    }

    /* renamed from: a */
    public int mo26760a(Context context, String str, String str2, C5157a aVar, C4827e eVar) {
        int i;
        String str3 = str;
        String str4 = str2;
        StringBuilder sb = new StringBuilder();
        sb.append("downloadurl = ");
        sb.append(str3);
        sb.append(", pkgname = ");
        sb.append(str4);
        C5205o.m21462a(sb.toString());
        Context context2 = context;
        try {
            String b = m21285b(context, str4);
            if (m21286b(str4)) {
                return 2;
            }
            File file = new File(b);
            if (m21287c(str4) && file.exists() && file.isFile()) {
                return 1;
            }
            C5152b bVar = new C5152b();
            bVar.f16814a = 0;
            bVar.f16816c = b;
            bVar.f16815b = str4;
            m21283a(str4, bVar);
            StringBuilder sb2 = new StringBuilder();
            sb2.append(b);
            sb2.append(".temp");
            String sb3 = sb2.toString();
            final int[] iArr = {-1};
            final String str5 = str2;
            final String str6 = sb3;
            final C5157a aVar2 = aVar;
            C51552 r1 = new C5151a() {
                /* renamed from: a */
                public void mo26758a(int i) {
                    C5153c.this.m21282a(str5, i);
                    if (i > iArr[0]) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("download apk[");
                        sb.append(str5);
                        sb.append("] progress = ");
                        sb.append(i);
                        sb.append(",path:");
                        sb.append(str6);
                        C5205o.m21462a(sb.toString());
                    }
                    C5157a aVar = aVar2;
                    if (aVar != null) {
                        aVar.onProgress(i);
                    }
                    C5153c.this.m21284a(str5, (String) null, i, false);
                    iArr[0] = i;
                }
            };
            C5149a aVar3 = new C5149a(str3, sb3, r1);
            final String str7 = sb3;
            final String str8 = b;
            final String str9 = str2;
            final C5157a aVar4 = aVar;
            final Context context3 = context;
            final C4827e eVar2 = eVar;
            C51541 r12 = new C5117a<String>() {
                /* renamed from: a */
                public void mo26344a(String str) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("download apk result ");
                    sb.append(str);
                    C5205o.m21462a(sb.toString());
                    if ("success".equals(str)) {
                        File file = new File(str7);
                        File file2 = new File(str8);
                        if (file.renameTo(file2)) {
                            C5153c.this.m21284a(str9, str8, 100, true);
                            C5157a aVar = aVar4;
                            if (aVar != null) {
                                aVar.onComplete(str9, str8);
                            }
                            C5153c.this.m21276a(context3, file2, eVar2, (C5158b) null);
                            return;
                        }
                        return;
                    }
                    C5153c.this.m21281a(str9);
                }
            };
            aVar3.mo26658a(r12);
            i = 4;
            return i;
        } catch (Throwable th) {
            C5205o.m21464a(th);
            i = 3;
            m21281a(str4);
        }
    }

    /* renamed from: a */
    public void mo26761a(Context context, C5138c cVar, String str, C5158b bVar) {
        String a = cVar.mo26743a();
        String str2 = cVar.f16776e;
        try {
            if (TextUtils.isEmpty(str2)) {
                str2 = m21285b(context, a);
            }
            File file = new File(str2);
            if (!file.exists() || !file.isFile()) {
                final C5158b bVar2 = bVar;
                final Context context2 = context;
                final File file2 = file;
                final C5138c cVar2 = cVar;
                final String str3 = a;
                C51563 r0 = new C5157a() {
                    public void onComplete(String str, String str2) {
                        bVar2.mo26340a();
                        bVar2.mo26341b();
                        C5153c.this.m21276a(context2, file2, (C4827e) null, bVar2);
                        DownloadNotifyManager.showNotify(context2.getApplicationContext(), str, cVar2.f16774c, cVar2.f16772a, 100, true);
                    }

                    public void onProgress(int i) {
                        DownloadNotifyManager.showNotify(context2.getApplicationContext(), str3, cVar2.f16774c, cVar2.f16772a, i, false);
                    }
                };
                int a2 = mo26760a(context, str, a, (C5157a) r0, (C4827e) null);
                if (!(a2 == 2 || a2 == 4 || a2 != 1)) {
                    bVar.mo26341b();
                    m21276a(context, file, (C4827e) null, bVar);
                }
                return;
            }
            bVar.mo26341b();
            m21276a(context, file, (C4827e) null, bVar);
        } catch (Throwable th) {
            StringBuilder sb = new StringBuilder();
            sb.append("install apk es: ");
            sb.append(th.toString());
            C5205o.m21462a(sb.toString());
        }
    }

    /* renamed from: a */
    public void mo26762a(Context context, String str, C4827e eVar) {
        try {
            if (this.f16817a != null) {
                m21276a(context, new File(((C5152b) this.f16817a.get(str)).f16816c), eVar, (C5158b) null);
            }
        } catch (Throwable th) {
            C5205o.m21464a(th);
        }
    }

    /* renamed from: a */
    public synchronized void mo26763a(String str, C5157a aVar) {
        ArrayList arrayList = (ArrayList) this.f16818b.get(str);
        if (arrayList == null) {
            arrayList = new ArrayList();
            this.f16818b.put(str, arrayList);
        }
        arrayList.add(aVar);
    }

    /* renamed from: b */
    public synchronized void mo26764b(String str, C5157a aVar) {
        ArrayList arrayList = (ArrayList) this.f16818b.get(str);
        if (arrayList != null) {
            arrayList.remove(aVar);
        }
    }
}
