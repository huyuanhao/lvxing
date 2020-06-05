package com.yanzhenjie.album.app.album.data;

import android.os.AsyncTask;
import com.yanzhenjie.album.AlbumFile;

/* renamed from: com.yanzhenjie.album.app.album.data.d */
public class PathConvertTask extends AsyncTask<String, Void, AlbumFile> {
    /* renamed from: a */
    private PathConversion f26272a;
    /* renamed from: b */
    private C7752a f26273b;

    /* compiled from: PathConvertTask */
    /* renamed from: com.yanzhenjie.album.app.album.data.d$a */
    public interface C7752a {
        /* renamed from: a */
        void mo37610a(AlbumFile albumFile);

        /* renamed from: d */
        void mo37616d();
    }

    public PathConvertTask(PathConversion cVar, C7752a aVar) {
        this.f26272a = cVar;
        this.f26273b = aVar;
    }

    /* access modifiers changed from: protected */
    public void onPreExecute() {
        this.f26273b.mo37616d();
    }

    /* access modifiers changed from: protected|varargs */
    /* renamed from: a */
    public AlbumFile doInBackground(String... strArr) {
        return this.f26272a.mo37651a(strArr[0]);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void onPostExecute(AlbumFile albumFile) {
        this.f26273b.mo37610a(albumFile);
    }
}
