package com.yanzhenjie.album.app.album.data;

import android.media.MediaPlayer;
import android.text.TextUtils;
import com.yanzhenjie.album.AlbumFile;
import com.yanzhenjie.album.Filter;
import com.yanzhenjie.album.p629b.AlbumUtils;
import java.io.File;

/* renamed from: com.yanzhenjie.album.app.album.data.c */
public class PathConversion {
    /* renamed from: a */
    private Filter<Long> f26269a;
    /* renamed from: b */
    private Filter<String> f26270b;
    /* renamed from: c */
    private Filter<Long> f26271c;

    public PathConversion(Filter<Long> dVar, Filter<String> dVar2, Filter<Long> dVar3) {
        this.f26269a = dVar;
        this.f26270b = dVar2;
        this.f26271c = dVar3;
    }

    /* renamed from: a */
    public AlbumFile mo37651a(String str) {
        File file = new File(str);
        AlbumFile albumFile = new AlbumFile();
        albumFile.mo37489a(str);
        albumFile.mo37494b(file.getParentFile().getName());
        String b = AlbumUtils.m33550b(str);
        albumFile.mo37498c(b);
        albumFile.mo37488a(System.currentTimeMillis());
        albumFile.mo37493b(file.length());
        int i = 0;
        if (!TextUtils.isEmpty(b)) {
            if (b.contains("video")) {
                i = 2;
            }
            if (b.contains("image")) {
                i = 1;
            }
        }
        albumFile.mo37487a(i);
        Filter<Long> dVar = this.f26269a;
        if (dVar != null && dVar.mo37677a(Long.valueOf(file.length()))) {
            albumFile.mo37495b(true);
        }
        Filter<String> dVar2 = this.f26270b;
        if (dVar2 != null && dVar2.mo37677a(b)) {
            albumFile.mo37495b(true);
        }
        if (i == 2) {
            MediaPlayer mediaPlayer = new MediaPlayer();
            try {
                mediaPlayer.setDataSource(str);
                mediaPlayer.prepare();
                albumFile.mo37497c((long) mediaPlayer.getDuration());
            } catch (Exception unused) {
            } catch (Throwable th) {
                mediaPlayer.release();
                throw th;
            }
            mediaPlayer.release();
            Filter<Long> dVar3 = this.f26271c;
            if (dVar3 != null && dVar3.mo37677a(Long.valueOf(albumFile.mo37496c()))) {
                albumFile.mo37495b(true);
            }
        }
        return albumFile;
    }
}
