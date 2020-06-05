package com.yanzhenjie.album.app.album.data;

import android.os.AsyncTask;
import com.yanzhenjie.album.AlbumFile;
import com.yanzhenjie.album.AlbumFolder;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.yanzhenjie.album.app.album.data.a */
public class MediaReadTask extends AsyncTask<Void, Void, C7751b> {
    /* renamed from: a */
    private int f26256a;
    /* renamed from: b */
    private List<AlbumFile> f26257b;
    /* renamed from: c */
    private MediaReader f26258c;
    /* renamed from: d */
    private C7750a f26259d;

    /* compiled from: MediaReadTask */
    /* renamed from: com.yanzhenjie.album.app.album.data.a$a */
    public interface C7750a {
        /* renamed from: a */
        void mo37612a(ArrayList<AlbumFolder> arrayList, ArrayList<AlbumFile> arrayList2);
    }

    /* compiled from: MediaReadTask */
    /* renamed from: com.yanzhenjie.album.app.album.data.a$b */
    static class C7751b {
        /* access modifiers changed from: private */
        /* renamed from: a */
        public ArrayList<AlbumFolder> f26260a;
        /* access modifiers changed from: private */
        /* renamed from: b */
        public ArrayList<AlbumFile> f26261b;

        C7751b() {
        }
    }

    public MediaReadTask(int i, List<AlbumFile> list, MediaReader bVar, C7750a aVar) {
        this.f26256a = i;
        this.f26257b = list;
        this.f26258c = bVar;
        this.f26259d = aVar;
    }

    /* access modifiers changed from: protected|varargs */
    /* renamed from: a */
    public C7751b doInBackground(Void... voidArr) {
        ArrayList arrayList;
        int i = this.f26256a;
        if (i == 0) {
            arrayList = this.f26258c.mo37648a();
        } else if (i == 1) {
            arrayList = this.f26258c.mo37649b();
        } else if (i == 2) {
            arrayList = this.f26258c.mo37650c();
        } else {
            throw new AssertionError("This should not be the case.");
        }
        ArrayList arrayList2 = new ArrayList();
        List<AlbumFile> list = this.f26257b;
        if (list != null && !list.isEmpty()) {
            ArrayList b = ((AlbumFolder) arrayList.get(0)).mo37516b();
            for (AlbumFile albumFile : this.f26257b) {
                for (int i2 = 0; i2 < b.size(); i2++) {
                    AlbumFile albumFile2 = (AlbumFile) b.get(i2);
                    if (albumFile.equals(albumFile2)) {
                        albumFile2.mo37490a(true);
                        arrayList2.add(albumFile2);
                    }
                }
            }
        }
        C7751b bVar = new C7751b();
        bVar.f26260a = arrayList;
        bVar.f26261b = arrayList2;
        return bVar;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void onPostExecute(C7751b bVar) {
        this.f26259d.mo37612a(bVar.f26260a, bVar.f26261b);
    }
}
