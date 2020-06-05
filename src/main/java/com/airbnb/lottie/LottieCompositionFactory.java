package com.airbnb.lottie;

import android.content.Context;
import android.content.res.Resources.NotFoundException;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.JsonReader;
import com.airbnb.lottie.model.LottieCompositionCache;
import com.airbnb.lottie.network.NetworkFetcher;
import com.airbnb.lottie.p012c.LottieCompositionParser;
import com.airbnb.lottie.p013d.Utils;
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

/* renamed from: com.airbnb.lottie.e */
public class LottieCompositionFactory {
    /* access modifiers changed from: private|static|final */
    /* renamed from: a */
    public static final Map<String, LottieTask<LottieComposition>> f1487a = new HashMap();

    /* renamed from: a */
    public static LottieTask<LottieComposition> m1464a(Context context, String str) {
        return NetworkFetcher.m1744a(context, str);
    }

    /* renamed from: b */
    public static LottieTask<LottieComposition> m1472b(Context context, final String str) {
        final Context applicationContext = context.getApplicationContext();
        return m1466a(str, (Callable<LottieResult<LottieComposition>>) new Callable<LottieResult<LottieComposition>>() {
            /* renamed from: a */
            public LottieResult<LottieComposition> call() {
                return LottieCompositionFactory.m1473c(applicationContext, str);
            }
        });
    }

    /* renamed from: c */
    public static LottieResult<LottieComposition> m1473c(Context context, String str) {
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("asset_");
            sb.append(str);
            String sb2 = sb.toString();
            if (str.endsWith(".zip")) {
                return m1462a(new ZipInputStream(context.getAssets().open(str)), sb2);
            }
            return m1460a(context.getAssets().open(str), sb2);
        } catch (IOException e) {
            return new LottieResult<>((Throwable) e);
        }
    }

    /* renamed from: a */
    public static LottieTask<LottieComposition> m1463a(Context context, final int i) {
        final Context applicationContext = context.getApplicationContext();
        return m1466a(m1467a(i), (Callable<LottieResult<LottieComposition>>) new Callable<LottieResult<LottieComposition>>() {
            /* renamed from: a */
            public LottieResult<LottieComposition> call() throws Exception {
                return LottieCompositionFactory.m1469b(applicationContext, i);
            }
        });
    }

    /* renamed from: b */
    public static LottieResult<LottieComposition> m1469b(Context context, int i) {
        try {
            return m1460a(context.getResources().openRawResource(i), m1467a(i));
        } catch (NotFoundException e) {
            return new LottieResult<>((Throwable) e);
        }
    }

    /* renamed from: a */
    private static String m1467a(int i) {
        StringBuilder sb = new StringBuilder();
        sb.append("rawRes_");
        sb.append(i);
        return sb.toString();
    }

    /* renamed from: a */
    public static LottieResult<LottieComposition> m1460a(InputStream inputStream, String str) {
        return m1461a(inputStream, str, true);
    }

    /* renamed from: a */
    private static LottieResult<LottieComposition> m1461a(InputStream inputStream, String str, boolean z) {
        try {
            return m1470b(new JsonReader(new InputStreamReader(inputStream)), str);
        } finally {
            if (z) {
                Utils.m1457a((Closeable) inputStream);
            }
        }
    }

    /* renamed from: a */
    public static LottieTask<LottieComposition> m1465a(final JsonReader jsonReader, final String str) {
        return m1466a(str, (Callable<LottieResult<LottieComposition>>) new Callable<LottieResult<LottieComposition>>() {
            /* renamed from: a */
            public LottieResult<LottieComposition> call() throws Exception {
                return LottieCompositionFactory.m1470b(jsonReader, str);
            }
        });
    }

    /* renamed from: b */
    public static LottieResult<LottieComposition> m1470b(JsonReader jsonReader, String str) {
        try {
            LottieComposition a = LottieCompositionParser.m1380a(jsonReader);
            LottieCompositionCache.m1654a().mo10131a(str, a);
            return new LottieResult<>(a);
        } catch (Exception e) {
            return new LottieResult<>((Throwable) e);
        }
    }

    /* renamed from: a */
    public static LottieResult<LottieComposition> m1462a(ZipInputStream zipInputStream, String str) {
        try {
            return m1471b(zipInputStream, str);
        } finally {
            Utils.m1457a((Closeable) zipInputStream);
        }
    }

    /* renamed from: b */
    private static LottieResult<LottieComposition> m1471b(ZipInputStream zipInputStream, String str) {
        HashMap hashMap = new HashMap();
        try {
            ZipEntry nextEntry = zipInputStream.getNextEntry();
            LottieComposition dVar = null;
            while (nextEntry != null) {
                if (nextEntry.getName().contains("__MACOSX")) {
                    zipInputStream.closeEntry();
                } else if (nextEntry.getName().contains(".json")) {
                    dVar = (LottieComposition) m1461a(zipInputStream, str, false).mo9995a();
                } else if (nextEntry.getName().contains(".png")) {
                    String[] split = nextEntry.getName().split("/");
                    hashMap.put(split[split.length - 1], BitmapFactory.decodeStream(zipInputStream));
                } else {
                    zipInputStream.closeEntry();
                }
                nextEntry = zipInputStream.getNextEntry();
            }
            if (dVar == null) {
                return new LottieResult<>((Throwable) new IllegalArgumentException("Unable to parse composition"));
            }
            for (Entry entry : hashMap.entrySet()) {
                LottieImageAsset a = m1459a(dVar, (String) entry.getKey());
                if (a != null) {
                    a.mo9992a((Bitmap) entry.getValue());
                }
            }
            for (Entry entry2 : dVar.mo9927j().entrySet()) {
                if (((LottieImageAsset) entry2.getValue()).mo9994c() == null) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("There is no image for ");
                    sb.append(((LottieImageAsset) entry2.getValue()).mo9993b());
                    return new LottieResult<>((Throwable) new IllegalStateException(sb.toString()));
                }
            }
            LottieCompositionCache.m1654a().mo10131a(str, dVar);
            return new LottieResult<>(dVar);
        } catch (IOException e) {
            return new LottieResult<>((Throwable) e);
        }
    }

    /* renamed from: a */
    private static LottieImageAsset m1459a(LottieComposition dVar, String str) {
        for (LottieImageAsset fVar : dVar.mo9927j().values()) {
            if (fVar.mo9993b().equals(str)) {
                return fVar;
            }
        }
        return null;
    }

    /* renamed from: a */
    private static LottieTask<LottieComposition> m1466a(final String str, Callable<LottieResult<LottieComposition>> callable) {
        if (f1487a.containsKey(str)) {
            return (LottieTask) f1487a.get(str);
        }
        LottieTask<LottieComposition> jVar = new LottieTask<>(callable);
        jVar.mo9999a((LottieListener<T>) new LottieListener<LottieComposition>() {
            /* renamed from: a */
            public void mo9777a(LottieComposition dVar) {
                LottieCompositionFactory.f1487a.remove(str);
            }
        });
        jVar.mo10001c((LottieListener<Throwable>) new LottieListener<Throwable>() {
            /* renamed from: a */
            public void mo9777a(Throwable th) {
                LottieCompositionFactory.f1487a.remove(str);
            }
        });
        f1487a.put(str, jVar);
        return jVar;
    }
}
