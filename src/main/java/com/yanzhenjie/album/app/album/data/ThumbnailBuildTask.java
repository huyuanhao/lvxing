package com.yanzhenjie.album.app.album.data;

import android.content.Context;
import android.os.AsyncTask;
import com.yanzhenjie.album.AlbumFile;
import java.util.ArrayList;
import java.util.Iterator;

/* renamed from: com.yanzhenjie.album.app.album.data.e */
public class ThumbnailBuildTask extends AsyncTask<Void, Void, ArrayList<AlbumFile>> {
    /* renamed from: a */
    private ArrayList<AlbumFile> f26274a;
    /* renamed from: b */
    private C7753a f26275b;
    /* renamed from: c */
    private ThumbnailBuilder f26276c;

    /* compiled from: ThumbnailBuildTask */
    /* renamed from: com.yanzhenjie.album.app.album.data.e$a */
    public interface C7753a {
        /* renamed from: a */
        void mo37611a(ArrayList<AlbumFile> arrayList);

        /* renamed from: f */
        void mo37618f();
    }

    public ThumbnailBuildTask(Context context, ArrayList<AlbumFile> arrayList, C7753a aVar) {
        this.f26274a = arrayList;
        this.f26275b = aVar;
        this.f26276c = new ThumbnailBuilder(context);
    }

    /* access modifiers changed from: protected */
    public void onPreExecute() {
        this.f26275b.mo37618f();
    }

    /* access modifiers changed from: protected|varargs */
    /* renamed from: a */
    public ArrayList<AlbumFile> doInBackground(Void... voidArr) {
        Iterator it = this.f26274a.iterator();
        while (it.hasNext()) {
            AlbumFile albumFile = (AlbumFile) it.next();
            int d = albumFile.mo37500d();
            if (d == 1) {
                albumFile.mo37501d(this.f26276c.mo37642a(albumFile.mo37485a()));
            } else if (d == 2) {
                albumFile.mo37501d(this.f26276c.mo37643b(albumFile.mo37485a()));
            }
        }
        return this.f26274a;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void onPostExecute(ArrayList<AlbumFile> arrayList) {
        this.f26275b.mo37611a(arrayList);
    }
}
