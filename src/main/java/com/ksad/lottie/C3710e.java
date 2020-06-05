package com.ksad.lottie;

import android.content.Context;
import android.content.res.Resources.NotFoundException;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.JsonReader;
import android.util.Log;
import com.ksad.lottie.model.C3772e;
import com.ksad.lottie.network.C3787b;
import com.ksad.lottie.p302c.C3670ad;
import com.ksad.lottie.p303d.C3709f;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.Callable;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/* renamed from: com.ksad.lottie.e */
public class C3710e {
    /* access modifiers changed from: private|static|final */
    /* renamed from: a */
    public static final Map<String, C3735k<C3703d>> f12619a = new HashMap();

    /* renamed from: a */
    private static C3731g m15395a(C3703d dVar, String str) {
        for (C3731g gVar : dVar.mo22887j().values()) {
            if (gVar.mo23011b().equals(str)) {
                return gVar;
            }
        }
        return null;
    }

    /* renamed from: a */
    public static C3734j<C3703d> m15396a(InputStream inputStream, String str) {
        return m15397a(inputStream, str, true);
    }

    /* renamed from: a */
    private static C3734j<C3703d> m15397a(InputStream inputStream, String str, boolean z) {
        try {
            return m15406b(new JsonReader(new InputStreamReader(inputStream)), str);
        } finally {
            if (z) {
                C3709f.m15393a((Closeable) inputStream);
            }
        }
    }

    /* renamed from: a */
    public static C3734j<C3703d> m15398a(ZipInputStream zipInputStream, String str) {
        try {
            return m15407b(zipInputStream, str);
        } finally {
            C3709f.m15393a((Closeable) zipInputStream);
        }
    }

    /* renamed from: a */
    public static C3735k<C3703d> m15399a(Context context, final int i) {
        final Context applicationContext = context.getApplicationContext();
        return m15402a(m15403a(i), (Callable<C3734j<C3703d>>) new Callable<C3734j<C3703d>>() {
            /* renamed from: a */
            public C3734j<C3703d> call() {
                return C3710e.m15405b(applicationContext, i);
            }
        });
    }

    /* renamed from: a */
    public static C3735k<C3703d> m15400a(Context context, String str) {
        return C3787b.m15715a(context, str);
    }

    /* renamed from: a */
    public static C3735k<C3703d> m15401a(final JsonReader jsonReader, final String str) {
        return m15402a(str, (Callable<C3734j<C3703d>>) new Callable<C3734j<C3703d>>() {
            /* renamed from: a */
            public C3734j<C3703d> call() {
                return C3710e.m15406b(jsonReader, str);
            }
        });
    }

    /* renamed from: a */
    private static C3735k<C3703d> m15402a(final String str, Callable<C3734j<C3703d>> callable) {
        final C3703d a = C3772e.m15637a().mo23139a(str);
        if (a != null) {
            return new C3735k<>(new Callable<C3734j<C3703d>>() {
                /* renamed from: a */
                public C3734j<C3703d> call() {
                    Log.d("Gabe", "call\treturning from cache");
                    return new C3734j<>(a);
                }
            });
        }
        if (f12619a.containsKey(str)) {
            return (C3735k) f12619a.get(str);
        }
        C3735k<C3703d> kVar = new C3735k<>(callable);
        kVar.mo23018a((C3732h<T>) new C3732h<C3703d>() {
            /* renamed from: a */
            public void mo22802a(C3703d dVar) {
                if (str != null) {
                    C3772e.m15637a().mo23140a(str, dVar);
                }
                C3710e.f12619a.remove(str);
            }
        });
        kVar.mo23020c((C3732h<Throwable>) new C3732h<Throwable>() {
            /* renamed from: a */
            public void mo22802a(Throwable th) {
                C3710e.f12619a.remove(str);
            }
        });
        f12619a.put(str, kVar);
        return kVar;
    }

    /* renamed from: a */
    private static String m15403a(int i) {
        StringBuilder sb = new StringBuilder();
        sb.append("rawRes_");
        sb.append(i);
        return sb.toString();
    }

    /* renamed from: b */
    public static C3734j<C3703d> m15405b(Context context, int i) {
        try {
            return m15396a(context.getResources().openRawResource(i), m15403a(i));
        } catch (NotFoundException e) {
            return new C3734j<>((Throwable) e);
        }
    }

    /* renamed from: b */
    public static C3734j<C3703d> m15406b(JsonReader jsonReader, String str) {
        try {
            C3703d a = C3670ad.m15266a(jsonReader);
            C3772e.m15637a().mo23140a(str, a);
            return new C3734j<>(a);
        } catch (Exception e) {
            return new C3734j<>((Throwable) e);
        }
    }

    /* renamed from: b */
    private static C3734j<C3703d> m15407b(ZipInputStream zipInputStream, String str) {
        HashMap hashMap = new HashMap();
        try {
            ZipEntry nextEntry = zipInputStream.getNextEntry();
            C3703d dVar = null;
            while (nextEntry != null) {
                if (!nextEntry.getName().contains("__MACOSX")) {
                    if (nextEntry.getName().contains(".json")) {
                        dVar = (C3703d) m15397a(zipInputStream, str, false).mo23014a();
                    } else if (nextEntry.getName().contains(".png")) {
                        String[] split = nextEntry.getName().split("/");
                        hashMap.put(split[split.length - 1], BitmapFactory.decodeStream(zipInputStream));
                    }
                    nextEntry = zipInputStream.getNextEntry();
                }
                zipInputStream.closeEntry();
                nextEntry = zipInputStream.getNextEntry();
            }
            if (dVar == null) {
                return new C3734j<>((Throwable) new IllegalArgumentException("Unable to parse composition"));
            }
            for (Entry entry : hashMap.entrySet()) {
                C3731g a = m15395a(dVar, (String) entry.getKey());
                if (a != null) {
                    a.mo23010a((Bitmap) entry.getValue());
                }
            }
            for (Entry entry2 : dVar.mo22887j().entrySet()) {
                if (((C3731g) entry2.getValue()).mo23012c() == null) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("There is no image for ");
                    sb.append(((C3731g) entry2.getValue()).mo23011b());
                    return new C3734j<>((Throwable) new IllegalStateException(sb.toString()));
                }
            }
            C3772e.m15637a().mo23140a(str, dVar);
            return new C3734j<>(dVar);
        } catch (IOException e) {
            return new C3734j<>((Throwable) e);
        }
    }

    /* renamed from: b */
    public static C3735k<C3703d> m15408b(Context context, final String str) {
        final Context applicationContext = context.getApplicationContext();
        return m15402a(str, (Callable<C3734j<C3703d>>) new Callable<C3734j<C3703d>>() {
            /* renamed from: a */
            public C3734j<C3703d> call() {
                return C3710e.m15409c(applicationContext, str);
            }
        });
    }

    /* renamed from: c */
    public static C3734j<C3703d> m15409c(Context context, String str) {
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("asset_");
            sb.append(str);
            String sb2 = sb.toString();
            return str.endsWith(".zip") ? m15398a(new ZipInputStream(context.getAssets().open(str)), sb2) : m15396a(context.getAssets().open(str), sb2);
        } catch (IOException e) {
            return new C3734j<>((Throwable) e);
        }
    }
}
