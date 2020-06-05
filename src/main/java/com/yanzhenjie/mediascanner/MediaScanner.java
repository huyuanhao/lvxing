package com.yanzhenjie.mediascanner;

import android.content.Context;
import android.media.MediaScannerConnection;
import android.media.MediaScannerConnection.MediaScannerConnectionClient;
import android.net.Uri;
import android.webkit.MimeTypeMap;
import java.util.LinkedList;

public class MediaScanner implements MediaScannerConnectionClient {
    /* renamed from: a */
    private MediaScannerConnection f26600a;
    /* renamed from: b */
    private ScannerListener f26601b;
    /* renamed from: c */
    private LinkedList<String[]> f26602c = new LinkedList<>();
    /* renamed from: d */
    private String[] f26603d;
    /* renamed from: e */
    private int f26604e = 0;

    public MediaScanner(Context context) {
        this.f26600a = new MediaScannerConnection(context.getApplicationContext(), this);
    }

    /* renamed from: a */
    public boolean mo37992a() {
        return this.f26600a.isConnected();
    }

    /* renamed from: a */
    public void mo37990a(String str) {
        mo37991a(new String[]{str});
    }

    /* renamed from: a */
    public void mo37991a(String[] strArr) {
        this.f26602c.add(strArr);
        if (!mo37992a()) {
            m33928b();
        }
    }

    /* renamed from: b */
    private void m33928b() {
        this.f26603d = (String[]) this.f26602c.get(0);
        String[] strArr = this.f26603d;
        if (strArr != null && strArr.length > 0) {
            this.f26600a.connect();
        }
    }

    public void onMediaScannerConnected() {
        String[] strArr = this.f26603d;
        if (strArr != null && strArr.length > 0) {
            for (String str : strArr) {
                this.f26600a.scanFile(str, MimeTypeMap.getSingleton().getMimeTypeFromExtension(MimeTypeMap.getFileExtensionFromUrl(str)));
            }
        }
    }

    public void onScanCompleted(String str, Uri uri) {
        ScannerListener aVar = this.f26601b;
        if (aVar != null) {
            aVar.mo37995a(str, uri);
        }
        this.f26604e++;
        if (this.f26604e == this.f26603d.length) {
            this.f26600a.disconnect();
            this.f26604e = 0;
            ScannerListener aVar2 = this.f26601b;
            if (aVar2 != null) {
                aVar2.mo37996a(this.f26603d);
            }
            m33928b();
        }
    }
}
