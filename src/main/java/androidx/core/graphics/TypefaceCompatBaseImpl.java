package androidx.core.graphics;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.CancellationSignal;
import androidx.core.content.res.FontResourcesParserCompat.FontFamilyFilesResourceEntry;
import androidx.core.content.res.FontResourcesParserCompat.FontFileResourceEntry;
import androidx.core.provider.FontsContractCompat.FontInfo;
import com.p522qq.p523e.comm.constants.ErrorCode.OtherError;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.ConcurrentHashMap;

class TypefaceCompatBaseImpl {
    private static final int INVALID_KEY = 0;
    private static final String TAG = "TypefaceCompatBaseImpl";
    private ConcurrentHashMap<Long, FontFamilyFilesResourceEntry> mFontFamilies = new ConcurrentHashMap<>();

    /* renamed from: androidx.core.graphics.TypefaceCompatBaseImpl$StyleExtractor */
    private interface StyleExtractor<T> {
        int getWeight(T t);

        boolean isItalic(T t);
    }

    TypefaceCompatBaseImpl() {
    }

    private static <T> T findBestFont(T[] tArr, int i, StyleExtractor<T> styleExtractor) {
        int i2 = (i & 1) == 0 ? 400 : OtherError.VIDEO_DOWNLOAD_ERROR;
        boolean z = (i & 2) != 0;
        T t = null;
        int i3 = ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        for (T t2 : tArr) {
            int abs = (Math.abs(styleExtractor.getWeight(t2) - i2) * 2) + (styleExtractor.isItalic(t2) == z ? 0 : 1);
            if (t == null || i3 > abs) {
                t = t2;
                i3 = abs;
            }
        }
        return t;
    }

    /* JADX WARNING: type inference failed for: r0v0, types: [java.lang.String] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    private static long getUniqueKey(android.graphics.Typeface r6) {
        /*
        java.lang.String r0 = "Could not retrieve font from family."
        java.lang.String r1 = "TypefaceCompatBaseImpl"
        r2 = 0
        if (r6 != 0) goto L_0x0009
        return r2
    L_0x0009:
        java.lang.Class<android.graphics.Typeface> r4 = android.graphics.Typeface.class
        java.lang.String r5 = "native_instance"
        java.lang.reflect.Field r4 = r4.getDeclaredField(r5)     // Catch:{ NoSuchFieldException -> 0x0025, IllegalAccessException -> 0x0020 }
        r5 = 1
        r4.setAccessible(r5)     // Catch:{ NoSuchFieldException -> 0x0025, IllegalAccessException -> 0x0020 }
        java.lang.Object r6 = r4.get(r6)     // Catch:{ NoSuchFieldException -> 0x0025, IllegalAccessException -> 0x0020 }
        java.lang.Number r6 = (java.lang.Number) r6     // Catch:{ NoSuchFieldException -> 0x0025, IllegalAccessException -> 0x0020 }
        long r0 = r6.longValue()     // Catch:{ NoSuchFieldException -> 0x0025, IllegalAccessException -> 0x0020 }
        return r0
    L_0x0020:
        r6 = move-exception
        android.util.Log.e(r1, r0, r6)
        return r2
    L_0x0025:
        r6 = move-exception
        android.util.Log.e(r1, r0, r6)
        return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.graphics.TypefaceCompatBaseImpl.getUniqueKey(android.graphics.Typeface):long");
    }

    /* access modifiers changed from: protected */
    public FontInfo findBestInfo(FontInfo[] fontInfoArr, int i) {
        return (FontInfo) findBestFont(fontInfoArr, i, new StyleExtractor<FontInfo>() {
            public int getWeight(FontInfo fontInfo) {
                return fontInfo.getWeight();
            }

            public boolean isItalic(FontInfo fontInfo) {
                return fontInfo.isItalic();
            }
        });
    }

    /* access modifiers changed from: protected */
    public Typeface createFromInputStream(Context context, InputStream inputStream) {
        File tempFile = TypefaceCompatUtil.getTempFile(context);
        if (tempFile == null) {
            return null;
        }
        try {
            if (!TypefaceCompatUtil.copyToFile(tempFile, inputStream)) {
                return null;
            }
            Typeface createFromFile = Typeface.createFromFile(tempFile.getPath());
            tempFile.delete();
            return createFromFile;
        } catch (RuntimeException unused) {
            return null;
        } finally {
            tempFile.delete();
        }
    }

    public Typeface createFromFontInfo(Context context, CancellationSignal cancellationSignal, FontInfo[] fontInfoArr, int i) {
        InputStream inputStream;
        InputStream inputStream2 = null;
        if (fontInfoArr.length < 1) {
            return null;
        }
        try {
            inputStream = context.getContentResolver().openInputStream(findBestInfo(fontInfoArr, i).getUri());
            try {
                Typeface createFromInputStream = createFromInputStream(context, inputStream);
                TypefaceCompatUtil.closeQuietly(inputStream);
                return createFromInputStream;
            } catch (IOException unused) {
                TypefaceCompatUtil.closeQuietly(inputStream);
                return null;
            } catch (Throwable th) {
                th = th;
                inputStream2 = inputStream;
                TypefaceCompatUtil.closeQuietly(inputStream2);
                throw th;
            }
        } catch (IOException unused2) {
            inputStream = null;
            TypefaceCompatUtil.closeQuietly(inputStream);
            return null;
        } catch (Throwable th2) {
            th = th2;
            TypefaceCompatUtil.closeQuietly(inputStream2);
            throw th;
        }
    }

    private FontFileResourceEntry findBestEntry(FontFamilyFilesResourceEntry fontFamilyFilesResourceEntry, int i) {
        return (FontFileResourceEntry) findBestFont(fontFamilyFilesResourceEntry.getEntries(), i, new StyleExtractor<FontFileResourceEntry>() {
            public int getWeight(FontFileResourceEntry fontFileResourceEntry) {
                return fontFileResourceEntry.getWeight();
            }

            public boolean isItalic(FontFileResourceEntry fontFileResourceEntry) {
                return fontFileResourceEntry.isItalic();
            }
        });
    }

    public Typeface createFromFontFamilyFilesResourceEntry(Context context, FontFamilyFilesResourceEntry fontFamilyFilesResourceEntry, Resources resources, int i) {
        FontFileResourceEntry findBestEntry = findBestEntry(fontFamilyFilesResourceEntry, i);
        if (findBestEntry == null) {
            return null;
        }
        Typeface createFromResourcesFontFile = TypefaceCompat.createFromResourcesFontFile(context, resources, findBestEntry.getResourceId(), findBestEntry.getFileName(), i);
        addFontFamily(createFromResourcesFontFile, fontFamilyFilesResourceEntry);
        return createFromResourcesFontFile;
    }

    public Typeface createFromResourcesFontFile(Context context, Resources resources, int i, String str, int i2) {
        File tempFile = TypefaceCompatUtil.getTempFile(context);
        if (tempFile == null) {
            return null;
        }
        try {
            if (!TypefaceCompatUtil.copyToFile(tempFile, resources, i)) {
                return null;
            }
            Typeface createFromFile = Typeface.createFromFile(tempFile.getPath());
            tempFile.delete();
            return createFromFile;
        } catch (RuntimeException unused) {
            return null;
        } finally {
            tempFile.delete();
        }
    }

    /* access modifiers changed from: 0000 */
    public FontFamilyFilesResourceEntry getFontFamily(Typeface typeface) {
        long uniqueKey = getUniqueKey(typeface);
        if (uniqueKey == 0) {
            return null;
        }
        return (FontFamilyFilesResourceEntry) this.mFontFamilies.get(Long.valueOf(uniqueKey));
    }

    private void addFontFamily(Typeface typeface, FontFamilyFilesResourceEntry fontFamilyFilesResourceEntry) {
        long uniqueKey = getUniqueKey(typeface);
        if (uniqueKey != 0) {
            this.mFontFamilies.put(Long.valueOf(uniqueKey), fontFamilyFilesResourceEntry);
        }
    }
}
