package com.bumptech.glide.load.p135a.p136a;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.ImageHeaderParserUtils;
import com.bumptech.glide.load.engine.p137a.ArrayPool;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/* renamed from: com.bumptech.glide.load.a.a.e */
class ThumbnailStreamOpener {
    /* renamed from: a */
    private static final FileService f4392a = new FileService();
    /* renamed from: b */
    private final FileService f4393b;
    /* renamed from: c */
    private final ThumbnailQuery f4394c;
    /* renamed from: d */
    private final ArrayPool f4395d;
    /* renamed from: e */
    private final ContentResolver f4396e;
    /* renamed from: f */
    private final List<ImageHeaderParser> f4397f;

    ThumbnailStreamOpener(List<ImageHeaderParser> list, ThumbnailQuery dVar, ArrayPool bVar, ContentResolver contentResolver) {
        this(list, f4392a, dVar, bVar, contentResolver);
    }

    ThumbnailStreamOpener(List<ImageHeaderParser> list, FileService aVar, ThumbnailQuery dVar, ArrayPool bVar, ContentResolver contentResolver) {
        this.f4393b = aVar;
        this.f4394c = dVar;
        this.f4395d = bVar;
        this.f4396e = contentResolver;
        this.f4397f = list;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public int mo12631a(Uri uri) {
        String str = "ThumbStreamOpener";
        InputStream inputStream = null;
        try {
            r6 = uri;
            inputStream = this.f4396e.openInputStream(uri);
            r6 = ImageHeaderParserUtils.m5382b(this.f4397f, inputStream, this.f4395d);
            r6 = r6;
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException unused) {
                }
            }
            return r6;
        } catch (IOException | NullPointerException e) {
            inputStream = Log.isLoggable(str, 3);
            if (inputStream) {
                StringBuilder sb = new StringBuilder();
                sb.append("Failed to open uri: ");
                sb.append(r6);
                Log.d(str, sb.toString(), e);
            }
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException unused2) {
                }
            }
            return -1;
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException unused3) {
                }
            }
        }
    }

    /* renamed from: b */
    public InputStream mo12632b(Uri uri) throws FileNotFoundException {
        String c = m5318c(uri);
        if (TextUtils.isEmpty(c)) {
            return null;
        }
        File a = this.f4393b.mo12623a(c);
        if (!m5317a(a)) {
            return null;
        }
        Uri fromFile = Uri.fromFile(a);
        try {
            r6 = uri;
            r6 = this.f4396e.openInputStream(fromFile);
            r6 = r6;
            return r6;
        } catch (NullPointerException e) {
            StringBuilder sb = new StringBuilder();
            sb.append("NPE opening uri: ");
            sb.append(r6);
            sb.append(" -> ");
            sb.append(fromFile);
            throw ((FileNotFoundException) new FileNotFoundException(sb.toString()).initCause(e));
        }
    }

    /* JADX INFO: finally extract failed */
    /* renamed from: c */
    private String m5318c(Uri uri) {
        Cursor a = this.f4394c.mo12630a(uri);
        if (a != null) {
            try {
                if (a.moveToFirst()) {
                    String string = a.getString(0);
                    if (a != null) {
                        a.close();
                    }
                    return string;
                }
            } catch (Throwable th) {
                if (a != null) {
                    a.close();
                }
                throw th;
            }
        }
        if (a != null) {
            a.close();
        }
        return null;
    }

    /* renamed from: a */
    private boolean m5317a(File file) {
        return this.f4393b.mo12624a(file) && 0 < this.f4393b.mo12625b(file);
    }
}
