package com.kwai.filedownloader.p353a;

import android.support.p000v4.media.session.PlaybackStateCompat;
import com.kwai.filedownloader.p358f.C4654c.C4655a;

/* renamed from: com.kwai.filedownloader.a.a */
public class C4588a implements C4655a {
    /* renamed from: a */
    public int mo24950a(int i, String str, String str2, long j) {
        if (j < PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED) {
            return 1;
        }
        if (j < 5242880) {
            return 2;
        }
        if (j < 52428800) {
            return 3;
        }
        return j < 104857600 ? 4 : 5;
    }
}
