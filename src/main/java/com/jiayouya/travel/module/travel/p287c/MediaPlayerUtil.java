package com.jiayouya.travel.module.travel.p287c;

import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;
import com.elvishew.xlog.XLog;
import com.jiayouya.travel.C2835b;
import com.jiayouya.travel.common.p245c.PreferenceRes;
import kotlin.Metadata;
import kotlin.jvm.internal.C8271i;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u001a\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003\u001a\n\u0010\u0004\u001a\u00020\u0005*\u00020\u0001\u001a\n\u0010\u0006\u001a\u00020\u0005*\u00020\u0001¨\u0006\u0007"}, mo39189d2 = {"createMediaPlayer", "Landroid/media/MediaPlayer;", "fileName", "", "play", "", "releasePlayer", "app_grRelease"}, mo39190k = 2, mo39191mv = {1, 1, 15})
/* renamed from: com.jiayouya.travel.module.travel.c.b */
public final class MediaPlayerUtil {
    /* renamed from: a */
    public static final MediaPlayer m14448a(String str) {
        C8271i.m35386b(str, "fileName");
        MediaPlayer mediaPlayer = new MediaPlayer();
        try {
            XLog.m12691a("initPlayer");
            mediaPlayer.setAudioStreamType(3);
            AssetFileDescriptor openFd = C2835b.f9544a.getAssets().openFd(str);
            C8271i.m35382a((Object) openFd, "fileDescriptor");
            mediaPlayer.setDataSource(openFd.getFileDescriptor(), openFd.getStartOffset(), openFd.getLength());
            mediaPlayer.prepareAsync();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mediaPlayer;
    }

    /* renamed from: a */
    public static final void m14449a(MediaPlayer mediaPlayer) {
        C8271i.m35386b(mediaPlayer, "$this$play");
        if (PreferenceRes.f9605b.mo19927c()) {
            try {
                mediaPlayer.start();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* renamed from: b */
    public static final void m14450b(MediaPlayer mediaPlayer) {
        C8271i.m35386b(mediaPlayer, "$this$releasePlayer");
        try {
            mediaPlayer.release();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
