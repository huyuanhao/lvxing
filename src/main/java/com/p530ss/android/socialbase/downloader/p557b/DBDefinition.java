package com.p530ss.android.socialbase.downloader.p557b;

import androidx.core.app.NotificationCompat;
import com.tencent.android.tpush.common.Constants;
import com.tencent.p605ep.common.adapt.iservice.account.AccountConst.ArgKey;

/* renamed from: com.ss.android.socialbase.downloader.b.c */
public interface DBDefinition {
    /* renamed from: a */
    public static final String[] f21685a = {C7887a.f26833ID, "url", "savePath", "tempPath", ArgKey.KEY_NAME, "chunkCount", NotificationCompat.CATEGORY_STATUS, "curBytes", "totalBytes", "eTag", "onlyWifi", ArgKey.KEY_FORCE, "retryCount", "extra", "mimeType", "title", "notificationEnable", "notificationVisibility", "isFirstDownload", "isFirstSuccess", "needHttpsToHttpRetry", "downloadTime", Constants.FLAG_PACKAGE_NAME, "md5", "retryDelay", "curRetryTime", "retryDelayStatus", "defaultHttpServiceBackUp", "chunkRunnableReuse", "retryDelayTimeArray", "chunkDowngradeRetry", "backUpUrlsStr", "backUpUrlRetryCount", "realDownloadTime", "retryScheduleMinutes", "independentProcess", "auxiliaryJsonobjectString"};
    /* renamed from: b */
    public static final String[] f21686b;
    /* renamed from: c */
    public static final String[] f21687c = {C7887a.f26833ID, "chunkIndex", "startOffset", "curOffset", "endOffset", "chunkContentLen", "hostChunkIndex"};
    /* renamed from: d */
    public static final String[] f21688d;

    static {
        String str = C7887a.f26833ID;
        f21686b = new String[]{str};
        f21688d = new String[]{str};
    }
}
