package com.ksad.download.p295a;

import android.content.Context;
import android.content.Intent;
import com.ksad.download.DownloadTask.DownloadRequest;
import com.ksad.download.service.DownloadService;
import com.kwad.sdk.core.p319c.C4065b;

/* renamed from: com.ksad.download.a.a */
public class C3602a {
    /* renamed from: a */
    public static void m15020a(Context context, String str) {
        C4065b.m16863a("DownloadClient", "pauseDownload");
        try {
            Intent intent = new Intent(context, DownloadService.class);
            intent.putExtra("download_service_type_tag", 2);
            intent.putExtra("download_service_id_tag", str);
            context.startService(intent);
        } catch (Exception unused) {
        }
    }

    /* renamed from: a */
    public static void m15021a(Context context, String str, DownloadRequest downloadRequest) {
        try {
            Intent intent = new Intent(context, DownloadService.class);
            intent.putExtra("download_service_type_tag", 1);
            intent.putExtra("download_service_id_tag", str);
            intent.putExtra("download_service_args_tag", downloadRequest);
            context.startService(intent);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: b */
    public static void m15022b(Context context, String str) {
        C4065b.m16863a("DownloadClient", "cancelDownload");
        try {
            Intent intent = new Intent(context, DownloadService.class);
            intent.putExtra("download_service_type_tag", 4);
            intent.putExtra("download_service_id_tag", str);
            context.startService(intent);
        } catch (Exception unused) {
        }
    }
}
