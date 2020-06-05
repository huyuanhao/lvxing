package com.bytedance.sdk.openadsdk.core.video.p178d;

import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.os.AsyncTask;
import com.bytedance.sdk.openadsdk.utils.C2564t;
import java.util.HashMap;

/* renamed from: com.bytedance.sdk.openadsdk.core.video.d.b */
public class MediaUtils {

    /* compiled from: MediaUtils */
    /* renamed from: com.bytedance.sdk.openadsdk.core.video.d.b$a */
    public static class C2319a extends AsyncTask<String, Integer, Bitmap> {
        /* renamed from: a */
        private C2320b f8030a;
        /* renamed from: b */
        private long f8031b = 0;

        public C2319a(C2320b bVar, long j) {
            this.f8030a = bVar;
            this.f8031b = j;
        }

        /* access modifiers changed from: protected|varargs */
        /* renamed from: a */
        public Bitmap doInBackground(String... strArr) {
            try {
                MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
                String str = strArr[0];
                if (str.startsWith("http")) {
                    mediaMetadataRetriever.setDataSource(str, new HashMap());
                } else {
                    mediaMetadataRetriever.setDataSource(str);
                }
                Bitmap frameAtTime = mediaMetadataRetriever.getFrameAtTime(this.f8031b * 1000, 3);
                mediaMetadataRetriever.release();
                return frameAtTime;
            } catch (Throwable th) {
                C2564t.m12223c("MediaUtils", "MediaUtils doInBackground : ", th);
                return null;
            }
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void onPostExecute(Bitmap bitmap) {
            super.onPostExecute(bitmap);
            C2320b bVar = this.f8030a;
            if (bVar != null) {
                bVar.mo16089a(bitmap);
            }
        }
    }

    /* compiled from: MediaUtils */
    /* renamed from: com.bytedance.sdk.openadsdk.core.video.d.b$b */
    public interface C2320b {
        /* renamed from: a */
        void mo16089a(Bitmap bitmap);
    }

    /* renamed from: a */
    public static void m10405a(long j, String str, C2320b bVar) {
        new C2319a(bVar, j).execute(new String[]{str});
    }
}
