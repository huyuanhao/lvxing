package com.bytedance.sdk.adnet.p159b;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Base64;
import com.bytedance.sdk.adnet.AdNetSdk;
import com.bytedance.sdk.adnet.core.C1982p;
import com.bytedance.sdk.adnet.core.RequestQueue;
import com.bytedance.sdk.adnet.core.VNetLog;
import com.bytedance.sdk.adnet.p159b.FileRequest.C1953a;
import com.bytedance.sdk.adnet.p162e.ICache.C1994a;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* compiled from: FileLoader */
/* renamed from: com.bytedance.sdk.adnet.b.b */
public class C1948b {
    /* access modifiers changed from: private|final */
    /* renamed from: a */
    public final Map<String, C1951b> f6077a;
    /* renamed from: b */
    private final Handler f6078b = new Handler(Looper.getMainLooper());
    /* access modifiers changed from: private|final */
    /* renamed from: c */
    public final RequestQueue f6079c;
    /* renamed from: d */
    private Context f6080d;

    /* compiled from: FileLoader */
    /* renamed from: com.bytedance.sdk.adnet.b.b$a */
    public interface C1950a extends C1953a {
        /* renamed from: a */
        File mo14181a(String str);

        /* renamed from: a */
        void mo14182a(String str, File file);

        /* renamed from: b */
        File mo14183b(String str);
    }

    /* compiled from: FileLoader */
    /* renamed from: com.bytedance.sdk.adnet.b.b$b */
    class C1951b {
        /* renamed from: a */
        String f6084a;
        /* renamed from: b */
        String f6085b;
        /* renamed from: c */
        List<C1950a> f6086c;
        /* renamed from: d */
        boolean f6087d;
        /* renamed from: e */
        FileRequest f6088e;

        C1951b(String str, String str2, C1950a aVar, boolean z) {
            this.f6084a = str;
            this.f6085b = str2;
            this.f6087d = z;
            mo14185a(aVar);
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo14185a(C1950a aVar) {
            if (aVar != null) {
                if (this.f6086c == null) {
                    this.f6086c = Collections.synchronizedList(new ArrayList());
                }
                this.f6086c.add(aVar);
            }
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo14184a() {
            this.f6088e = new FileRequest(this.f6085b, this.f6084a, new C1953a() {
                /* renamed from: a */
                public void mo14187a(long j, long j2) {
                    if (C1951b.this.f6086c != null) {
                        for (C1953a a : C1951b.this.f6086c) {
                            try {
                                a.mo14187a(j, j2);
                            } catch (Throwable th) {
                                VNetLog.m7927a(th, "file loader onDownloadProgress error", new Object[0]);
                            }
                        }
                    }
                }

                /* renamed from: a */
                public void mo14171a(C1982p<File> pVar) {
                    if (C1951b.this.f6086c != null) {
                        for (C1950a aVar : C1951b.this.f6086c) {
                            try {
                                aVar.mo14171a(pVar);
                            } catch (Throwable th) {
                                VNetLog.m7927a(th, "file loader onResponse error", new Object[0]);
                            }
                            try {
                                aVar.mo14182a(C1951b.this.f6084a, (File) pVar.f6293a);
                            } catch (Throwable th2) {
                                VNetLog.m7927a(th2, "file loader putFile error", new Object[0]);
                            }
                        }
                        C1951b.this.f6086c.clear();
                    }
                    C1948b.this.f6077a.remove(C1951b.this.f6084a);
                }

                /* renamed from: b */
                public void mo14172b(C1982p<File> pVar) {
                    if (C1951b.this.f6086c != null) {
                        for (C1953a b : C1951b.this.f6086c) {
                            try {
                                b.mo14172b(pVar);
                            } catch (Throwable th) {
                                VNetLog.m7927a(th, "file loader onErrorResponse error", new Object[0]);
                            }
                        }
                        C1951b.this.f6086c.clear();
                    }
                    C1948b.this.f6077a.remove(C1951b.this.f6084a);
                }
            });
            FileRequest cVar = this.f6088e;
            StringBuilder sb = new StringBuilder();
            sb.append("FileLoader#");
            sb.append(this.f6084a);
            cVar.setTag(sb.toString());
            C1948b.this.f6079c.mo14361a(this.f6088e);
        }

        public boolean equals(Object obj) {
            if (obj instanceof C1951b) {
                return ((C1951b) obj).f6084a.equals(this.f6084a);
            }
            return super.equals(obj);
        }
    }

    public C1948b(Context context, RequestQueue oVar) {
        this.f6080d = context;
        this.f6079c = oVar;
        this.f6077a = Collections.synchronizedMap(new LinkedHashMap());
    }

    /* renamed from: a */
    public void mo14178a(String str, C1950a aVar) {
        mo14179a(str, aVar, true);
    }

    /* renamed from: a */
    public void mo14179a(String str, final C1950a aVar, boolean z) {
        if (!TextUtils.isEmpty(str)) {
            if (m7682a(str)) {
                C1951b bVar = (C1951b) this.f6077a.get(str);
                if (bVar != null) {
                    bVar.mo14185a(aVar);
                    return;
                }
            }
            final File a = aVar.mo14181a(str);
            if (a == null || aVar == null) {
                m7681a(m7683b(str, aVar, z));
            } else {
                this.f6078b.post(new Runnable() {
                    public void run() {
                        aVar.mo14187a(a.length(), a.length());
                        aVar.mo14171a(C1982p.m7917a(a, (C1994a) null));
                    }
                });
            }
        }
    }

    /* renamed from: a */
    private void m7681a(C1951b bVar) {
        if (bVar != null) {
            bVar.mo14184a();
            this.f6077a.put(bVar.f6084a, bVar);
        }
    }

    /* renamed from: a */
    private boolean m7682a(String str) {
        return this.f6077a.containsKey(str);
    }

    /* renamed from: b */
    private C1951b m7683b(String str, C1950a aVar, boolean z) {
        String str2;
        File b = aVar != null ? aVar.mo14183b(str) : null;
        if (b == null) {
            str2 = new File(m7679a(), new String(Base64.encode(str.getBytes(), 0))).getAbsolutePath();
        } else {
            str2 = b.getAbsolutePath();
        }
        C1951b bVar = new C1951b(str, str2, aVar, z);
        return bVar;
    }

    /* renamed from: a */
    private String m7679a() {
        File file = new File(AdNetSdk.m7649b(this.f6080d), "fileLoader");
        file.mkdirs();
        return file.getAbsolutePath();
    }
}
