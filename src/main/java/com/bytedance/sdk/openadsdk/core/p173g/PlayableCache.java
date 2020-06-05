package com.bytedance.sdk.openadsdk.core.p173g;

import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.bytedance.sdk.adnet.core.C1982p;
import com.bytedance.sdk.adnet.p159b.C1948b.C1950a;
import com.bytedance.sdk.openadsdk.core.AES;
import com.bytedance.sdk.openadsdk.core.AESKey;
import com.bytedance.sdk.openadsdk.core.GlobalInfo;
import com.bytedance.sdk.openadsdk.core.InternalContainer;
import com.bytedance.sdk.openadsdk.core.p170d.MaterialMeta;
import com.bytedance.sdk.openadsdk.p188g.TTNetClient;
import com.bytedance.sdk.openadsdk.p198i.TTExecutor;
import com.bytedance.sdk.openadsdk.utils.C2564t;
import com.bytedance.sdk.openadsdk.utils.DigestUtils;
import com.bytedance.sdk.openadsdk.utils.FileUtils;
import java.io.File;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* renamed from: com.bytedance.sdk.openadsdk.core.g.a */
public class PlayableCache {
    /* renamed from: a */
    private static volatile PlayableCache f7539a;
    /* renamed from: b */
    private String f7540b;
    /* access modifiers changed from: private */
    /* renamed from: c */
    public Map<MaterialMeta, C2246b> f7541c = Collections.synchronizedMap(new HashMap());
    /* renamed from: d */
    private Map<String, JSONObject> f7542d = Collections.synchronizedMap(new HashMap());
    /* access modifiers changed from: private */
    /* renamed from: e */
    public AtomicBoolean f7543e = new AtomicBoolean(false);
    /* access modifiers changed from: private */
    /* renamed from: f */
    public Set<String> f7544f = Collections.synchronizedSet(new HashSet());
    /* renamed from: g */
    private Handler f7545g = new Handler(Looper.getMainLooper());

    /* compiled from: PlayableCache */
    /* renamed from: com.bytedance.sdk.openadsdk.core.g.a$a */
    public interface C2245a {
        /* renamed from: a */
        void mo15121a(boolean z);
    }

    /* compiled from: PlayableCache */
    /* renamed from: com.bytedance.sdk.openadsdk.core.g.a$b */
    private static class C2246b {
        /* renamed from: a */
        long f7559a;
        /* renamed from: b */
        long f7560b;
        /* renamed from: c */
        long f7561c;
        /* renamed from: d */
        long f7562d;

        private C2246b() {
        }

        /* renamed from: a */
        public long mo15648a() {
            return this.f7560b - this.f7559a;
        }

        /* renamed from: b */
        public long mo15650b() {
            return this.f7562d - this.f7561c;
        }

        /* renamed from: a */
        public C2246b mo15649a(long j) {
            this.f7559a = j;
            return this;
        }

        /* renamed from: b */
        public C2246b mo15651b(long j) {
            this.f7560b = j;
            return this;
        }

        /* renamed from: c */
        public C2246b mo15652c(long j) {
            this.f7561c = j;
            return this;
        }

        /* renamed from: d */
        public C2246b mo15653d(long j) {
            this.f7562d = j;
            return this;
        }
    }

    /* renamed from: a */
    public static PlayableCache m9577a() {
        if (f7539a == null) {
            synchronized (PlayableCache.class) {
                if (f7539a == null) {
                    f7539a = new PlayableCache();
                }
            }
        }
        return f7539a;
    }

    private PlayableCache() {
    }

    /* renamed from: a */
    public boolean mo15643a(MaterialMeta kVar) {
        if (!(!this.f7543e.get() || kVar == null || kVar.mo15512z() == null || kVar.mo15512z().mo15605i() == null)) {
            try {
                String a = DigestUtils.m12169a(kVar.mo15512z().mo15605i());
                if (((JSONObject) this.f7542d.get(a)) == null) {
                    return false;
                }
                return m9591c(new File(m9589c(), a));
            } catch (Throwable unused) {
            }
        }
        return false;
    }

    /* renamed from: b */
    public void mo15644b() {
        if (!this.f7543e.get()) {
            TTExecutor.m11692a().mo16808c(new Runnable() {
                public void run() {
                    try {
                        String a = PlayableCache.this.m9589c();
                        if (!TextUtils.isEmpty(a)) {
                            File file = new File(a);
                            if (file.exists() && file.isDirectory()) {
                                File[] listFiles = file.listFiles();
                                if (listFiles != null) {
                                    for (File file2 : listFiles) {
                                        try {
                                            PlayableCache.this.m9581a(new File(file2, "tt_open_ad_sdk_check_res.dat"), true);
                                        } catch (Throwable unused) {
                                        }
                                    }
                                }
                            }
                        }
                    } catch (Throwable unused2) {
                    }
                    PlayableCache.this.f7543e.set(true);
                }
            }, 5);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public JSONObject m9581a(File file, boolean z) {
        if (file != null) {
            try {
                if (file.exists() && file.isFile() && file.canRead()) {
                    byte[] d = FileUtils.m12177d(file);
                    if (d != null && d.length > 0) {
                        String b = AES.m9052b(new String(d), AESKey.m9089d());
                        if (!TextUtils.isEmpty(b)) {
                            JSONObject jSONObject = new JSONObject(b);
                            if (z && jSONObject.length() > 0) {
                                this.f7542d.put(file.getParentFile().getName(), jSONObject);
                            }
                            return jSONObject;
                        }
                    }
                }
            } catch (Throwable unused) {
            }
        }
        return null;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(7:11|12|13|(2:17|(1:19))|20|21|(1:23)(2:24|(1:26)(3:27|(2:29|(1:31)(2:32|(1:34)(2:35|(2:37|38))))|42))) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:20:0x0049 */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0057 A[Catch:{ all -> 0x00a3 }, RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0058 A[Catch:{ all -> 0x00a3 }] */
    /* renamed from: a */
    public android.webkit.WebResourceResponse mo15641a(java.lang.String r5, java.lang.String r6, java.lang.String r7) {
        /*
        r4 = this;
        r0 = 0
        java.util.concurrent.atomic.AtomicBoolean r1 = r4.f7543e     // Catch:{ all -> 0x00a3 }
        boolean r1 = r1.get()     // Catch:{ all -> 0x00a3 }
        if (r1 != 0) goto L_0x000a
        return r0
    L_0x000a:
        boolean r1 = android.text.TextUtils.isEmpty(r5)     // Catch:{ all -> 0x00a3 }
        if (r1 != 0) goto L_0x00a2
        boolean r1 = android.text.TextUtils.isEmpty(r6)     // Catch:{ all -> 0x00a3 }
        if (r1 != 0) goto L_0x00a2
        boolean r1 = android.text.TextUtils.isEmpty(r7)     // Catch:{ all -> 0x00a3 }
        if (r1 == 0) goto L_0x001e
        goto L_0x00a2
    L_0x001e:
        java.lang.String r1 = "http"
        boolean r1 = r7.startsWith(r1)     // Catch:{ all -> 0x0049 }
        if (r1 == 0) goto L_0x0049
        java.lang.String r1 = "?"
        boolean r1 = r7.contains(r1)     // Catch:{ all -> 0x0049 }
        if (r1 == 0) goto L_0x0049
        java.lang.String r1 = "\\?"
        java.lang.String[] r1 = r7.split(r1)     // Catch:{ all -> 0x0049 }
        r2 = 0
        r7 = r1[r2]     // Catch:{ all -> 0x0049 }
        java.lang.String r1 = "/"
        boolean r1 = r7.endsWith(r1)     // Catch:{ all -> 0x0049 }
        if (r1 == 0) goto L_0x0049
        int r1 = r7.length()     // Catch:{ all -> 0x0049 }
        int r1 = r1 + -1
        java.lang.String r7 = r7.substring(r2, r1)     // Catch:{ all -> 0x0049 }
    L_0x0049:
        android.content.Context r1 = com.bytedance.sdk.openadsdk.core.InternalContainer.m10059a()     // Catch:{ all -> 0x00a3 }
        java.lang.String r1 = com.bytedance.sdk.openadsdk.utils.MimeDetector.m12230a(r1, r7)     // Catch:{ all -> 0x00a3 }
        boolean r2 = android.text.TextUtils.isEmpty(r1)     // Catch:{ all -> 0x00a3 }
        if (r2 == 0) goto L_0x0058
        return r0
    L_0x0058:
        java.lang.String r5 = com.bytedance.sdk.openadsdk.utils.DigestUtils.m12169a(r5)     // Catch:{ all -> 0x00a3 }
        boolean r2 = android.text.TextUtils.isEmpty(r5)     // Catch:{ all -> 0x00a3 }
        if (r2 == 0) goto L_0x0063
        return r0
    L_0x0063:
        java.io.File r2 = new java.io.File     // Catch:{ all -> 0x00a3 }
        java.lang.String r3 = r4.m9589c()     // Catch:{ all -> 0x00a3 }
        r2.<init>(r3, r5)     // Catch:{ all -> 0x00a3 }
        boolean r3 = r4.m9591c(r2)     // Catch:{ all -> 0x00a3 }
        if (r3 == 0) goto L_0x00ab
        java.lang.String r6 = r4.m9579a(r6)     // Catch:{ all -> 0x00a3 }
        boolean r3 = android.text.TextUtils.isEmpty(r6)     // Catch:{ all -> 0x00a3 }
        if (r3 == 0) goto L_0x007d
        return r0
    L_0x007d:
        java.lang.String r3 = ""
        java.lang.String r6 = r7.replace(r6, r3)     // Catch:{ all -> 0x00a3 }
        boolean r7 = android.text.TextUtils.isEmpty(r6)     // Catch:{ all -> 0x00a3 }
        if (r7 == 0) goto L_0x008a
        return r0
    L_0x008a:
        java.io.File r7 = new java.io.File     // Catch:{ all -> 0x00a3 }
        r7.<init>(r2, r6)     // Catch:{ all -> 0x00a3 }
        boolean r5 = r4.m9586a(r5, r6, r7)     // Catch:{ all -> 0x00a3 }
        if (r5 == 0) goto L_0x00ab
        android.webkit.WebResourceResponse r5 = new android.webkit.WebResourceResponse     // Catch:{ all -> 0x00a3 }
        java.lang.String r6 = "utf-8"
        java.io.FileInputStream r2 = new java.io.FileInputStream     // Catch:{ all -> 0x00a3 }
        r2.<init>(r7)     // Catch:{ all -> 0x00a3 }
        r5.<init>(r1, r6, r2)     // Catch:{ all -> 0x00a3 }
        return r5
    L_0x00a2:
        return r0
    L_0x00a3:
        r5 = move-exception
        java.lang.String r6 = "PlayableCache"
        java.lang.String r7 = "playable intercept error: "
        com.bytedance.sdk.openadsdk.utils.C2564t.m12223c(r6, r7, r5)
    L_0x00ab:
        return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.p173g.PlayableCache.mo15641a(java.lang.String, java.lang.String, java.lang.String):android.webkit.WebResourceResponse");
    }

    /* renamed from: a */
    private String m9579a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String[] split = str.split("\\?");
        String str2 = "index.html";
        if (split != null && split.length == 2) {
            if (split[0] != null && split[0].endsWith("/")) {
                str = str.substring(0, split.length - 1);
            }
            if (split[0] != null && split[0].endsWith(str2)) {
                str = split[0];
            }
        }
        return str.replace(str2, "");
    }

    /* renamed from: a */
    private boolean m9586a(String str, String str2, File file) {
        if (file != null && file.exists()) {
            JSONObject jSONObject = (JSONObject) this.f7542d.get(str);
            if (jSONObject == null) {
                return false;
            }
            String optString = jSONObject.optString(str2);
            if (optString != null && optString.equalsIgnoreCase(DigestUtils.m12168a(file))) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: a */
    public void mo15642a(MaterialMeta kVar, C2245a aVar) {
        if (kVar == null || kVar.mo15512z() == null || TextUtils.isEmpty(kVar.mo15512z().mo15605i())) {
            PlayableEvent.m9613a(InternalContainer.m10059a(), kVar, -701, (String) null);
            m9582a(aVar, false);
            return;
        }
        String i = kVar.mo15512z().mo15605i();
        if (!this.f7544f.contains(i)) {
            this.f7541c.put(kVar, new C2246b().mo15649a(System.currentTimeMillis()));
            PlayableEvent.m9612a(InternalContainer.m10059a(), kVar);
            final String a = DigestUtils.m12169a(i);
            final File file = new File(m9589c(), a);
            if (m9591c(file)) {
                PlayableEvent.m9613a(InternalContainer.m10059a(), kVar, -702, (String) null);
                m9588b(file);
                this.f7541c.remove(kVar);
                m9582a(aVar, true);
                return;
            }
            try {
                FileUtils.m12176c(file);
            } catch (Throwable unused) {
            }
            this.f7544f.add(i);
            TTNetClient a2 = TTNetClient.m11428a(InternalContainer.m10059a());
            final String str = i;
            final MaterialMeta kVar2 = kVar;
            final C2245a aVar2 = aVar;
            C22422 r2 = new C1950a() {
                /* renamed from: a */
                public File mo14181a(String str) {
                    return null;
                }

                /* renamed from: a */
                public void mo14187a(long j, long j2) {
                }

                /* renamed from: a */
                public void mo14182a(String str, File file) {
                }

                /* renamed from: b */
                public File mo14183b(String str) {
                    String c = PlayableCache.this.m9592d();
                    StringBuilder sb = new StringBuilder();
                    sb.append(a);
                    sb.append(".zip");
                    return new File(c, sb.toString());
                }

                /* renamed from: a */
                public void mo14171a(final C1982p<File> pVar) {
                    PlayableCache.this.f7544f.remove(str);
                    final C2246b bVar = (C2246b) PlayableCache.this.f7541c.remove(kVar2);
                    if (bVar != null) {
                        bVar.mo15651b(System.currentTimeMillis());
                    }
                    if (pVar == null || pVar.f6293a == null) {
                        int i = -700;
                        if (!(pVar == null || pVar.f6300h == 0)) {
                            i = Long.valueOf(pVar.f6300h).intValue();
                        }
                        PlayableEvent.m9613a(InternalContainer.m10059a(), kVar2, i, (String) null);
                        PlayableCache.this.m9582a(aVar2, false);
                        return;
                    }
                    TTExecutor.m11692a().mo16808c(new Runnable() {
                        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|(10:1|2|(1:4)|5|(1:7)|8|(1:10)(1:11)|12|13|14)|17|18|19|21) */
                        /* JADX WARNING: Failed to process nested try/catch */
                        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x008a */
                        public void run() {
                            /*
                            r7 = this;
                            r0 = 1
                            com.bytedance.sdk.openadsdk.core.g.a$b r1 = r0     // Catch:{ all -> 0x0070 }
                            if (r1 == 0) goto L_0x000e
                            com.bytedance.sdk.openadsdk.core.g.a$b r1 = r0     // Catch:{ all -> 0x0070 }
                            long r2 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x0070 }
                            r1.mo15652c(r2)     // Catch:{ all -> 0x0070 }
                        L_0x000e:
                            com.bytedance.sdk.adnet.core.p r1 = r7     // Catch:{ all -> 0x0070 }
                            T r1 = r1.f6293a     // Catch:{ all -> 0x0070 }
                            java.io.File r1 = (java.io.File) r1     // Catch:{ all -> 0x0070 }
                            java.lang.String r1 = r1.getAbsolutePath()     // Catch:{ all -> 0x0070 }
                            com.bytedance.sdk.openadsdk.core.g.a$2 r2 = com.bytedance.sdk.openadsdk.core.p173g.PlayableCache.C22422.this     // Catch:{ all -> 0x0070 }
                            com.bytedance.sdk.openadsdk.core.g.a r2 = com.bytedance.sdk.openadsdk.core.p173g.PlayableCache.this     // Catch:{ all -> 0x0070 }
                            java.lang.String r2 = r2.m9589c()     // Catch:{ all -> 0x0070 }
                            com.bytedance.sdk.openadsdk.utils.ZipUtils.m12102a(r1, r2)     // Catch:{ all -> 0x0070 }
                            com.bytedance.sdk.openadsdk.core.g.a$b r1 = r0     // Catch:{ all -> 0x0070 }
                            if (r1 == 0) goto L_0x0030
                            com.bytedance.sdk.openadsdk.core.g.a$b r1 = r0     // Catch:{ all -> 0x0070 }
                            long r2 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x0070 }
                            r1.mo15653d(r2)     // Catch:{ all -> 0x0070 }
                        L_0x0030:
                            com.bytedance.sdk.openadsdk.core.g.a$b r1 = r0     // Catch:{ all -> 0x0070 }
                            r2 = 0
                            if (r1 == 0) goto L_0x0045
                            com.bytedance.sdk.openadsdk.core.g.a$b r1 = r0     // Catch:{ all -> 0x0070 }
                            long r2 = r1.mo15648a()     // Catch:{ all -> 0x0070 }
                            com.bytedance.sdk.openadsdk.core.g.a$b r1 = r0     // Catch:{ all -> 0x0070 }
                            long r4 = r1.mo15650b()     // Catch:{ all -> 0x0070 }
                            r5 = r4
                            r3 = r2
                            goto L_0x0047
                        L_0x0045:
                            r5 = r2
                            r3 = r5
                        L_0x0047:
                            android.content.Context r1 = com.bytedance.sdk.openadsdk.core.InternalContainer.m10059a()     // Catch:{ all -> 0x0070 }
                            com.bytedance.sdk.openadsdk.core.g.a$2 r2 = com.bytedance.sdk.openadsdk.core.p173g.PlayableCache.C22422.this     // Catch:{ all -> 0x0070 }
                            com.bytedance.sdk.openadsdk.core.d.k r2 = r6     // Catch:{ all -> 0x0070 }
                            com.bytedance.sdk.openadsdk.core.p173g.PlayableEvent.m9614a(r1, r2, r3, r5)     // Catch:{ all -> 0x0070 }
                            com.bytedance.sdk.openadsdk.core.g.a$2 r1 = com.bytedance.sdk.openadsdk.core.p173g.PlayableCache.C22422.this     // Catch:{ all -> 0x0070 }
                            com.bytedance.sdk.openadsdk.core.g.a r1 = com.bytedance.sdk.openadsdk.core.p173g.PlayableCache.this     // Catch:{ all -> 0x0070 }
                            com.bytedance.sdk.openadsdk.core.g.a$2 r2 = com.bytedance.sdk.openadsdk.core.p173g.PlayableCache.C22422.this     // Catch:{ all -> 0x0070 }
                            java.io.File r2 = r7     // Catch:{ all -> 0x0070 }
                            r1.m9585a(r2)     // Catch:{ all -> 0x0070 }
                            java.io.File r1 = new java.io.File     // Catch:{ all -> 0x008a }
                            com.bytedance.sdk.openadsdk.core.g.a$2 r2 = com.bytedance.sdk.openadsdk.core.p173g.PlayableCache.C22422.this     // Catch:{ all -> 0x008a }
                            java.io.File r2 = r7     // Catch:{ all -> 0x008a }
                            java.lang.String r3 = "tt_open_ad_sdk_check_res.dat"
                            r1.<init>(r2, r3)     // Catch:{ all -> 0x008a }
                            com.bytedance.sdk.openadsdk.core.g.a$2 r2 = com.bytedance.sdk.openadsdk.core.p173g.PlayableCache.C22422.this     // Catch:{ all -> 0x008a }
                            com.bytedance.sdk.openadsdk.core.g.a r2 = com.bytedance.sdk.openadsdk.core.p173g.PlayableCache.this     // Catch:{ all -> 0x008a }
                            r2.m9581a(r1, r0)     // Catch:{ all -> 0x008a }
                            goto L_0x008a
                        L_0x0070:
                            r0 = move-exception
                            java.lang.String r1 = "PlayableCache"
                            java.lang.String r2 = "unzip error: "
                            com.bytedance.sdk.openadsdk.utils.C2564t.m12223c(r1, r2, r0)
                            android.content.Context r1 = com.bytedance.sdk.openadsdk.core.InternalContainer.m10059a()
                            com.bytedance.sdk.openadsdk.core.g.a$2 r2 = com.bytedance.sdk.openadsdk.core.p173g.PlayableCache.C22422.this
                            com.bytedance.sdk.openadsdk.core.d.k r2 = r6
                            r3 = -704(0xfffffffffffffd40, float:NaN)
                            java.lang.String r0 = r0.getMessage()
                            com.bytedance.sdk.openadsdk.core.p173g.PlayableEvent.m9613a(r1, r2, r3, r0)
                            r0 = 0
                        L_0x008a:
                            com.bytedance.sdk.adnet.core.p r1 = r7     // Catch:{ all -> 0x0093 }
                            T r1 = r1.f6293a     // Catch:{ all -> 0x0093 }
                            java.io.File r1 = (java.io.File) r1     // Catch:{ all -> 0x0093 }
                            r1.delete()     // Catch:{ all -> 0x0093 }
                        L_0x0093:
                            com.bytedance.sdk.openadsdk.core.g.a$2 r1 = com.bytedance.sdk.openadsdk.core.p173g.PlayableCache.C22422.this
                            com.bytedance.sdk.openadsdk.core.g.a r1 = com.bytedance.sdk.openadsdk.core.p173g.PlayableCache.this
                            com.bytedance.sdk.openadsdk.core.g.a$2 r2 = com.bytedance.sdk.openadsdk.core.p173g.PlayableCache.C22422.this
                            com.bytedance.sdk.openadsdk.core.g.a$a r2 = r8
                            r1.m9582a(r2, r0)
                            return
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.p173g.PlayableCache.C22422.C22431.run():void");
                        }
                    }, 5);
                }

                /* renamed from: b */
                public void mo14172b(C1982p<File> pVar) {
                    PlayableCache.this.f7544f.remove(str);
                    PlayableCache.this.f7541c.remove(kVar2);
                    int i = -700;
                    String str = null;
                    if (pVar != null) {
                        if (pVar.f6300h != 0) {
                            i = Long.valueOf(pVar.f6300h).intValue();
                        } else if (!(pVar.f6295c == null || pVar.f6295c.networkResponse == null || pVar.f6295c.networkResponse.f6274a == 0)) {
                            i = pVar.f6295c.networkResponse.f6274a;
                        }
                        if (pVar.f6295c != null) {
                            str = pVar.f6295c.getMessage();
                        }
                    }
                    PlayableEvent.m9613a(InternalContainer.m10059a(), kVar2, i, str);
                    PlayableCache.this.m9582a(aVar2, false);
                }
            };
            a2.mo16655a(i, (C1950a) r2);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m9582a(final C2245a aVar, final boolean z) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            if (aVar != null) {
                aVar.mo15121a(z);
            }
        } else if (aVar != null) {
            this.f7545g.post(new Runnable() {
                public void run() {
                    C2245a aVar = aVar;
                    if (aVar != null) {
                        aVar.mo15121a(z);
                    }
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m9585a(File file) {
        m9588b(file);
        try {
            GlobalInfo.m9616c().mo15687q().mo14986a(file);
        } catch (Throwable unused) {
        }
    }

    /* renamed from: b */
    private void m9588b(File file) {
        try {
            if (file.exists()) {
                long currentTimeMillis = System.currentTimeMillis();
                if (!file.setLastModified(currentTimeMillis)) {
                    file.renameTo(file);
                    if (file.lastModified() < currentTimeMillis) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("Last modified date ");
                        sb.append(new Date(file.lastModified()));
                        sb.append(" is not set for file ");
                        sb.append(file.getAbsolutePath());
                        C2564t.m12225d("PlayableCache", sb.toString());
                    }
                }
            }
        } catch (Throwable unused) {
        }
    }

    /* renamed from: c */
    private boolean m9591c(File file) {
        if (file != null && file.isDirectory()) {
            String[] list = file.list();
            if (list != null && list.length > 0) {
                return Arrays.asList(list).contains("index.html");
            }
        }
        return false;
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public String m9589c() {
        File file = new File(m9592d(), "games");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file.getAbsolutePath();
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public String m9592d() {
        File file;
        if (TextUtils.isEmpty(this.f7540b)) {
            try {
                if (("mounted".equals(Environment.getExternalStorageState()) || !Environment.isExternalStorageRemovable()) && InternalContainer.m10059a().getExternalCacheDir() != null) {
                    file = InternalContainer.m10059a().getExternalCacheDir();
                } else {
                    file = InternalContainer.m10059a().getCacheDir();
                }
                File file2 = new File(file, "playable");
                if (!file2.exists()) {
                    file2.mkdirs();
                }
                this.f7540b = file2.getAbsolutePath();
            } catch (Throwable th) {
                StringBuilder sb = new StringBuilder();
                sb.append("init root path error: ");
                sb.append(th);
                C2564t.m12226e("PlayableCache", sb.toString());
            }
        }
        return this.f7540b;
    }
}
