package com.p368pw.inner.base.p387d;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import android.widget.ImageView;
import java.io.File;
import java.io.InputStream;
import java.lang.ref.SoftReference;

/* renamed from: com.pw.inner.base.d.m */
public class C5196m {
    /* renamed from: a */
    private Context f16910a;
    /* renamed from: b */
    private String f16911b;
    /* access modifiers changed from: private */
    /* renamed from: c */
    public SoftReference<ImageView> f16912c;
    /* renamed from: d */
    private C5202b f16913d;
    /* renamed from: e */
    private String f16914e;

    /* renamed from: com.pw.inner.base.d.m$a */
    private static class C5201a {
        /* renamed from: a */
        static File m21453a(Context context, String str) {
            File file = new File(context.getCacheDir(), String.format("%d", new Object[]{Integer.valueOf(str.hashCode())}));
            if (file.exists()) {
                return file;
            }
            return null;
        }

        /* renamed from: a */
        static File m21454a(Context context, String str, InputStream inputStream) {
            try {
                File file = new File(context.getCacheDir(), String.format("%d", new Object[]{Integer.valueOf(str.hashCode())}));
                C5193k.m21426a(file, inputStream, false);
                return file;
            } catch (Exception e) {
                C5205o.m21464a((Throwable) e);
                return null;
            }
        }
    }

    /* renamed from: com.pw.inner.base.d.m$b */
    public interface C5202b {
        void onBitmapLoadFailed(String str);

        void onBitmapLoadSuccess(Bitmap bitmap);
    }

    /* renamed from: com.pw.inner.base.d.m$c */
    public static final class C5203c {
        /* renamed from: a */
        Context f16923a;
        /* renamed from: b */
        String f16924b;
        /* renamed from: c */
        SoftReference<ImageView> f16925c;
        /* renamed from: d */
        C5202b f16926d;

        public C5203c(Context context) {
            if (context != null) {
                this.f16923a = context.getApplicationContext();
                return;
            }
            throw new IllegalStateException("context can't be null.");
        }

        /* renamed from: a */
        public C5203c mo26826a(ImageView imageView) {
            this.f16925c = new SoftReference<>(imageView);
            return this;
        }

        /* renamed from: a */
        public C5203c mo26827a(C5202b bVar) {
            this.f16926d = bVar;
            return this;
        }

        /* renamed from: a */
        public C5203c mo26828a(String str) {
            this.f16924b = str;
            return this;
        }

        /* renamed from: a */
        public C5196m mo26829a() {
            return new C5196m(this);
        }
    }

    public C5196m(C5203c cVar) {
        this.f16910a = cVar.f16923a;
        this.f16911b = cVar.f16924b;
        this.f16912c = cVar.f16925c;
        this.f16913d = cVar.f16926d;
    }

    /* renamed from: a */
    public static void m21445a(Context context, String str, ImageView imageView) {
        new C5203c(context).mo26828a(C5194l.m21428a(str)).mo26826a(imageView).mo26829a().mo26818a();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m21446a(final ImageView imageView, final String str) {
        C5208r.m21482b(new Runnable() {
            public void run() {
                final Bitmap decodeFile = BitmapFactory.decodeFile(str);
                C5208r.m21479a(new Runnable() {
                    public void run() {
                        imageView.setImageBitmap(decodeFile);
                    }
                });
            }
        });
    }

    /* renamed from: a */
    private void m21448a(final File file) {
        SoftReference<ImageView> softReference = this.f16912c;
        if (softReference != null && softReference.get() != null) {
            C5208r.m21479a(new Runnable() {
                public void run() {
                    if (C5196m.this.f16912c != null) {
                        ImageView imageView = (ImageView) C5196m.this.f16912c.get();
                        if (imageView != null) {
                            C5196m.this.m21446a(imageView, file.getAbsolutePath());
                        }
                    }
                }
            });
        }
    }

    /* renamed from: c */
    private File m21449c() {
        return C5201a.m21453a(this.f16910a, this.f16911b);
    }

    /* JADX WARNING: type inference failed for: r0v0 */
    /* JADX WARNING: type inference failed for: r2v0, types: [java.io.Closeable] */
    /* JADX WARNING: type inference failed for: r0v1, types: [java.io.File] */
    /* JADX WARNING: type inference failed for: r2v1 */
    /* JADX WARNING: type inference failed for: r1v8, types: [java.io.File] */
    /* JADX WARNING: type inference failed for: r0v3, types: [java.io.Closeable] */
    /* JADX WARNING: type inference failed for: r1v9 */
    /* JADX WARNING: type inference failed for: r1v10, types: [java.io.InputStream] */
    /* JADX WARNING: type inference failed for: r0v4 */
    /* JADX WARNING: type inference failed for: r2v7 */
    /* JADX WARNING: type inference failed for: r0v5, types: [java.io.File] */
    /* JADX WARNING: type inference failed for: r4v1 */
    /* JADX WARNING: type inference failed for: r1v12 */
    /* JADX WARNING: type inference failed for: r0v6 */
    /* JADX WARNING: type inference failed for: r0v7 */
    /* JADX WARNING: type inference failed for: r0v8 */
    /* JADX WARNING: type inference failed for: r0v9 */
    /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r0v0
  assigns: [?[int, float, boolean, short, byte, char, OBJECT, ARRAY], ?[OBJECT, ARRAY], java.io.File]
  uses: [java.io.Closeable, ?[OBJECT, ARRAY]]
	at jadx.core.dex.visitors.typeinference.TypeSearch.fillTypeCandidates(TypeSearch.java:231)
	at java.util.ArrayList.forEach(ArrayList.java:1249)
	at jadx.core.dex.visitors.typeinference.TypeSearch.run(TypeSearch.java:53)
	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runMultiVariableSearch(TypeInferenceVisitor.java:95)
	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:88)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:27)
	at jadx.core.dex.visitors.DepthTraversal.lambda$visit$1(DepthTraversal.java:14)
	at java.util.ArrayList.forEach(ArrayList.java:1249)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:30)
	at jadx.core.ProcessClass.lambda$processDependencies$0(ProcessClass.java:49)
	at java.util.ArrayList.forEach(ArrayList.java:1249)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:49)
	at jadx.core.ProcessClass.process(ProcessClass.java:35)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:290)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
 */
    /* JADX WARNING: Unknown variable types count: 7 */
    /* renamed from: d */
    private java.io.File m21450d() {
        /*
        r5 = this;
        r0 = 0
        java.lang.String r1 = r5.f16911b     // Catch:{ all -> 0x0048 }
        boolean r1 = com.p368pw.inner.base.p387d.C5194l.m21433c(r1)     // Catch:{ all -> 0x0048 }
        if (r1 == 0) goto L_0x000c
        com.p368pw.inner.base.p387d.p389b.C5165a.m21319a()     // Catch:{ all -> 0x0048 }
    L_0x000c:
        java.net.URL r1 = new java.net.URL     // Catch:{ all -> 0x0048 }
        java.lang.String r2 = r5.f16911b     // Catch:{ all -> 0x0048 }
        r1.<init>(r2)     // Catch:{ all -> 0x0048 }
        java.net.URLConnection r1 = r1.openConnection()     // Catch:{ all -> 0x0048 }
        java.net.HttpURLConnection r1 = (java.net.HttpURLConnection) r1     // Catch:{ all -> 0x0048 }
        java.lang.String r2 = "GET"
        r1.setRequestMethod(r2)     // Catch:{ all -> 0x0048 }
        r2 = 8000(0x1f40, float:1.121E-41)
        r1.setConnectTimeout(r2)     // Catch:{ all -> 0x0048 }
        r1.setReadTimeout(r2)     // Catch:{ all -> 0x0048 }
        int r2 = r1.getResponseCode()     // Catch:{ all -> 0x0048 }
        r3 = 200(0xc8, float:2.8E-43)
        if (r2 != r3) goto L_0x0043
        java.io.InputStream r1 = r1.getInputStream()     // Catch:{ all -> 0x0048 }
        android.content.Context r2 = r5.f16910a     // Catch:{ all -> 0x003e }
        java.lang.String r3 = r5.f16911b     // Catch:{ all -> 0x003e }
        java.io.File r0 = com.p368pw.inner.base.p387d.C5196m.C5201a.m21454a(r2, r3, r1)     // Catch:{ all -> 0x003e }
        r4 = r1
        r1 = r0
        r0 = r4
        goto L_0x0044
    L_0x003e:
        r2 = move-exception
        r4 = r2
        r2 = r1
        r1 = r4
        goto L_0x004a
    L_0x0043:
        r1 = r0
    L_0x0044:
        com.p368pw.inner.base.p387d.C5175d.m21353a(r0)
        return r1
    L_0x0048:
        r1 = move-exception
        r2 = r0
    L_0x004a:
        com.p368pw.inner.base.p387d.C5205o.m21464a(r1)     // Catch:{ all -> 0x0057 }
        java.lang.String r1 = r1.getMessage()     // Catch:{ all -> 0x0057 }
        r5.f16914e = r1     // Catch:{ all -> 0x0057 }
        com.p368pw.inner.base.p387d.C5175d.m21353a(r2)
        return r0
    L_0x0057:
        r0 = move-exception
        com.p368pw.inner.base.p387d.C5175d.m21353a(r2)
        throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.p368pw.inner.base.p387d.C5196m.m21450d():java.io.File");
    }

    /* renamed from: a */
    public void mo26818a() {
        C5208r.m21482b(new Runnable() {
            public void run() {
                C5196m.this.mo26819b();
            }
        });
    }

    /* renamed from: b */
    public void mo26819b() {
        if (TextUtils.isEmpty(this.f16911b)) {
            C5202b bVar = this.f16913d;
            if (bVar != null) {
                bVar.onBitmapLoadFailed("url is empty.");
            }
            return;
        }
        File c = m21449c();
        if (c == null) {
            c = m21450d();
        }
        if (c == null) {
            C5202b bVar2 = this.f16913d;
            if (bVar2 != null) {
                bVar2.onBitmapLoadFailed(this.f16914e);
            }
        } else {
            m21448a(c);
            if (this.f16913d != null) {
                this.f16913d.onBitmapLoadSuccess(BitmapFactory.decodeFile(c.getAbsolutePath()));
            }
        }
    }
}
