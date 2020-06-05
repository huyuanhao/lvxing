package com.bumptech.glide.load.p135a.p136a;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore.Images.Thumbnails;
import android.provider.MediaStore.Video;
import android.util.Log;
import com.bumptech.glide.Glide;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.p135a.DataFetcher;
import com.bumptech.glide.load.p135a.DataFetcher.C1623a;
import com.bumptech.glide.load.p135a.ExifOrientationStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/* renamed from: com.bumptech.glide.load.a.a.c */
public class ThumbFetcher implements DataFetcher<InputStream> {
    /* renamed from: a */
    private final Uri f4385a;
    /* renamed from: b */
    private final ThumbnailStreamOpener f4386b;
    /* renamed from: c */
    private InputStream f4387c;

    /* compiled from: ThumbFetcher */
    /* renamed from: com.bumptech.glide.load.a.a.c$a */
    static class C1621a implements ThumbnailQuery {
        /* renamed from: b */
        private static final String[] f4388b = {"_data"};
        /* renamed from: a */
        private final ContentResolver f4389a;

        C1621a(ContentResolver contentResolver) {
            this.f4389a = contentResolver;
        }

        /* renamed from: a */
        public Cursor mo12630a(Uri uri) {
            String lastPathSegment = uri.getLastPathSegment();
            return this.f4389a.query(Thumbnails.EXTERNAL_CONTENT_URI, f4388b, "kind = 1 AND image_id = ?", new String[]{lastPathSegment}, null);
        }
    }

    /* compiled from: ThumbFetcher */
    /* renamed from: com.bumptech.glide.load.a.a.c$b */
    static class C1622b implements ThumbnailQuery {
        /* renamed from: b */
        private static final String[] f4390b = {"_data"};
        /* renamed from: a */
        private final ContentResolver f4391a;

        C1622b(ContentResolver contentResolver) {
            this.f4391a = contentResolver;
        }

        /* renamed from: a */
        public Cursor mo12630a(Uri uri) {
            String lastPathSegment = uri.getLastPathSegment();
            return this.f4391a.query(Video.Thumbnails.EXTERNAL_CONTENT_URI, f4390b, "kind = 1 AND video_id = ?", new String[]{lastPathSegment}, null);
        }
    }

    /* renamed from: c */
    public void mo12628c() {
    }

    /* renamed from: a */
    public static ThumbFetcher m5305a(Context context, Uri uri) {
        return m5306a(context, uri, new C1621a(context.getContentResolver()));
    }

    /* renamed from: b */
    public static ThumbFetcher m5307b(Context context, Uri uri) {
        return m5306a(context, uri, new C1622b(context.getContentResolver()));
    }

    /* renamed from: a */
    private static ThumbFetcher m5306a(Context context, Uri uri, ThumbnailQuery dVar) {
        return new ThumbFetcher(uri, new ThumbnailStreamOpener(Glide.m5169a(context).mo12539h().mo12353a(), dVar, Glide.m5169a(context).mo12532b(), context.getContentResolver()));
    }

    ThumbFetcher(Uri uri, ThumbnailStreamOpener eVar) {
        this.f4385a = uri;
        this.f4386b = eVar;
    }

    /* renamed from: a */
    public void mo12626a(Priority priority, C1623a<? super InputStream> aVar) {
        try {
            this.f4387c = m5308e();
            aVar.mo12641a(this.f4387c);
        } catch (FileNotFoundException e) {
            String str = "MediaStoreThumbFetcher";
            if (Log.isLoggable(str, 3)) {
                Log.d(str, "Failed to find thumbnail file", e);
            }
            aVar.mo12640a((Exception) e);
        }
    }

    /* renamed from: e */
    private InputStream m5308e() throws FileNotFoundException {
        InputStream b = this.f4386b.mo12632b(this.f4385a);
        int a = b != null ? this.f4386b.mo12631a(this.f4385a) : -1;
        return a != -1 ? new ExifOrientationStream(b, a) : b;
    }

    /* renamed from: b */
    public void mo12627b() {
        InputStream inputStream = this.f4387c;
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException unused) {
            }
        }
    }

    /* renamed from: a */
    public Class<InputStream> mo12619a() {
        return InputStream.class;
    }

    /* renamed from: d */
    public DataSource mo12629d() {
        return DataSource.LOCAL;
    }
}
