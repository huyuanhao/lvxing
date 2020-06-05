package com.yanzhenjie.album.app.album.data;

import android.content.Context;
import android.database.Cursor;
import android.provider.MediaStore.Images.Media;
import android.provider.MediaStore.Video;
import com.yanzhenjie.album.AlbumFile;
import com.yanzhenjie.album.AlbumFolder;
import com.yanzhenjie.album.Filter;
import com.yanzhenjie.album.R;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/* renamed from: com.yanzhenjie.album.app.album.data.b */
public class MediaReader {
    /* renamed from: f */
    private static final String[] f26262f = {"_data", "bucket_display_name", "mime_type", "date_added", "latitude", "longitude", "_size"};
    /* renamed from: g */
    private static final String[] f26263g = {"_data", "bucket_display_name", "mime_type", "date_added", "latitude", "longitude", "_size", "duration"};
    /* renamed from: a */
    private Context f26264a;
    /* renamed from: b */
    private Filter<Long> f26265b;
    /* renamed from: c */
    private Filter<String> f26266c;
    /* renamed from: d */
    private Filter<Long> f26267d;
    /* renamed from: e */
    private boolean f26268e;

    public MediaReader(Context context, Filter<Long> dVar, Filter<String> dVar2, Filter<Long> dVar3, boolean z) {
        this.f26264a = context;
        this.f26265b = dVar;
        this.f26266c = dVar2;
        this.f26267d = dVar3;
        this.f26268e = z;
    }

    /* renamed from: a */
    private void m33475a(Map<String, AlbumFolder> map, AlbumFolder albumFolder) {
        Cursor query = this.f26264a.getContentResolver().query(Media.EXTERNAL_CONTENT_URI, f26262f, null, null, null);
        if (query != null) {
            while (query.moveToNext()) {
                String string = query.getString(0);
                String string2 = query.getString(1);
                String string3 = query.getString(2);
                long j = query.getLong(3);
                float f = query.getFloat(4);
                float f2 = query.getFloat(5);
                long j2 = query.getLong(6);
                AlbumFile albumFile = new AlbumFile();
                albumFile.mo37487a(1);
                albumFile.mo37489a(string);
                albumFile.mo37494b(string2);
                albumFile.mo37498c(string3);
                albumFile.mo37488a(j);
                albumFile.mo37486a(f);
                albumFile.mo37492b(f2);
                albumFile.mo37493b(j2);
                Filter<Long> dVar = this.f26265b;
                if (dVar != null && dVar.mo37677a(Long.valueOf(j2))) {
                    if (this.f26268e) {
                        albumFile.mo37495b(true);
                    }
                }
                Filter<String> dVar2 = this.f26266c;
                if (dVar2 != null && dVar2.mo37677a(string3)) {
                    if (this.f26268e) {
                        albumFile.mo37495b(true);
                    }
                }
                albumFolder.mo37513a(albumFile);
                AlbumFolder albumFolder2 = (AlbumFolder) map.get(string2);
                if (albumFolder2 != null) {
                    albumFolder2.mo37513a(albumFile);
                } else {
                    AlbumFolder albumFolder3 = new AlbumFolder();
                    albumFolder3.mo37514a(string2);
                    albumFolder3.mo37513a(albumFile);
                    map.put(string2, albumFolder3);
                }
            }
            query.close();
        }
    }

    /* renamed from: b */
    private void m33476b(Map<String, AlbumFolder> map, AlbumFolder albumFolder) {
        boolean z;
        Map<String, AlbumFolder> map2 = map;
        Cursor query = this.f26264a.getContentResolver().query(Video.Media.EXTERNAL_CONTENT_URI, f26263g, null, null, null);
        if (query != null) {
            while (query.moveToNext()) {
                String string = query.getString(0);
                String string2 = query.getString(1);
                String string3 = query.getString(2);
                long j = query.getLong(3);
                float f = query.getFloat(4);
                float f2 = query.getFloat(5);
                long j2 = query.getLong(6);
                long j3 = query.getLong(7);
                AlbumFile albumFile = new AlbumFile();
                albumFile.mo37487a(2);
                albumFile.mo37489a(string);
                albumFile.mo37494b(string2);
                albumFile.mo37498c(string3);
                albumFile.mo37488a(j);
                albumFile.mo37486a(f);
                albumFile.mo37492b(f2);
                albumFile.mo37493b(j2);
                albumFile.mo37497c(j3);
                Filter<Long> dVar = this.f26265b;
                if (dVar == null || !dVar.mo37677a(Long.valueOf(j2))) {
                    z = true;
                } else if (this.f26268e) {
                    z = true;
                    albumFile.mo37495b(true);
                }
                Filter<String> dVar2 = this.f26266c;
                if (dVar2 != null && dVar2.mo37677a(string3)) {
                    if (this.f26268e) {
                        albumFile.mo37495b(z);
                    }
                }
                Filter<Long> dVar3 = this.f26267d;
                if (dVar3 != null && dVar3.mo37677a(Long.valueOf(j3))) {
                    if (this.f26268e) {
                        albumFile.mo37495b(true);
                    }
                }
                albumFolder.mo37513a(albumFile);
                AlbumFolder albumFolder2 = (AlbumFolder) map2.get(string2);
                if (albumFolder2 != null) {
                    albumFolder2.mo37513a(albumFile);
                } else {
                    AlbumFolder albumFolder3 = new AlbumFolder();
                    albumFolder3.mo37514a(string2);
                    albumFolder3.mo37513a(albumFile);
                    map2.put(string2, albumFolder3);
                }
            }
            query.close();
        }
    }

    /* renamed from: a */
    public ArrayList<AlbumFolder> mo37648a() {
        HashMap hashMap = new HashMap();
        AlbumFolder albumFolder = new AlbumFolder();
        albumFolder.mo37515a(true);
        albumFolder.mo37514a(this.f26264a.getString(R.string.album_all_images));
        m33475a(hashMap, albumFolder);
        ArrayList<AlbumFolder> arrayList = new ArrayList<>();
        Collections.sort(albumFolder.mo37516b());
        arrayList.add(albumFolder);
        for (Entry value : hashMap.entrySet()) {
            AlbumFolder albumFolder2 = (AlbumFolder) value.getValue();
            Collections.sort(albumFolder2.mo37516b());
            arrayList.add(albumFolder2);
        }
        return arrayList;
    }

    /* renamed from: b */
    public ArrayList<AlbumFolder> mo37649b() {
        HashMap hashMap = new HashMap();
        AlbumFolder albumFolder = new AlbumFolder();
        albumFolder.mo37515a(true);
        albumFolder.mo37514a(this.f26264a.getString(R.string.album_all_videos));
        m33476b(hashMap, albumFolder);
        ArrayList<AlbumFolder> arrayList = new ArrayList<>();
        Collections.sort(albumFolder.mo37516b());
        arrayList.add(albumFolder);
        for (Entry value : hashMap.entrySet()) {
            AlbumFolder albumFolder2 = (AlbumFolder) value.getValue();
            Collections.sort(albumFolder2.mo37516b());
            arrayList.add(albumFolder2);
        }
        return arrayList;
    }

    /* renamed from: c */
    public ArrayList<AlbumFolder> mo37650c() {
        HashMap hashMap = new HashMap();
        AlbumFolder albumFolder = new AlbumFolder();
        albumFolder.mo37515a(true);
        albumFolder.mo37514a(this.f26264a.getString(R.string.album_all_images_videos));
        m33475a(hashMap, albumFolder);
        m33476b(hashMap, albumFolder);
        ArrayList<AlbumFolder> arrayList = new ArrayList<>();
        Collections.sort(albumFolder.mo37516b());
        arrayList.add(albumFolder);
        for (Entry value : hashMap.entrySet()) {
            AlbumFolder albumFolder2 = (AlbumFolder) value.getValue();
            Collections.sort(albumFolder2.mo37516b());
            arrayList.add(albumFolder2);
        }
        return arrayList;
    }
}
