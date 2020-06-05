package com.ksad.download;

import android.content.Intent;
import android.net.NetworkInfo;
import android.os.Environment;
import android.text.TextUtils;
import android.webkit.URLUtil;
import com.ksad.download.p297c.C3606a;
import com.ksad.download.p297c.C3607b;
import com.kwai.filedownloader.C4583a;
import com.kwai.filedownloader.C4669i;
import com.kwai.filedownloader.C4723q;
import com.kwai.filedownloader.exception.FileDownloadNetworkPolicyException;
import com.kwai.filedownloader.p356d.C4623d;
import java.io.File;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class DownloadTask implements Serializable {
    private static final long serialVersionUID = -7092669850073266500L;
    private int mAllowedNetworkTypes;
    protected transient C4583a mBaseDownloadTask;
    private String mDestinationDir;
    private String mDestinationFileName;
    private transient List<C3605c> mDownloadListeners = new ArrayList();
    private boolean mIsCanceled = false;
    private int mNotificationVisibility;
    private Map<String, String> mRequestHeaders;
    private Serializable mTag;
    private String mUrl;
    private boolean mUserPause;
    private boolean mWakeInstallApk;

    /* renamed from: com.ksad.download.DownloadTask$DownloadRequest */
    public static class DownloadRequest implements Serializable {
        private static final long serialVersionUID = -3638290207248829674L;
        /* access modifiers changed from: private */
        public int mAllowedNetworkTypes = 3;
        /* access modifiers changed from: private */
        public String mDestinationDir;
        /* access modifiers changed from: private */
        public String mDestinationFileName;
        /* access modifiers changed from: private */
        public String mDownloadUrl;
        /* access modifiers changed from: private */
        public boolean mInstallAfterDownload = true;
        @Deprecated
        private boolean mIsPhotoAdDownloadRequest = false;
        /* access modifiers changed from: private */
        public int mNotificationVisibility = 0;
        /* access modifiers changed from: private|final */
        public final Map<String, String> mRequestHeaders = new HashMap();
        /* access modifiers changed from: private */
        public Serializable mTag;

        public DownloadRequest(String str) {
            if (str == null) {
                throw new NullPointerException();
            } else if (URLUtil.isNetworkUrl(str)) {
                if (!C3603b.m15028b().exists()) {
                    C3603b.m15028b().mkdirs();
                }
                this.mDestinationDir = C3603b.m15028b().getPath();
                this.mDownloadUrl = str;
                NetworkInfo c = C3607b.m15047c(C3603b.m15023a());
                if (c == null || c.getType() != 0) {
                    this.mAllowedNetworkTypes = 2;
                } else {
                    this.mAllowedNetworkTypes = 3;
                }
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append("Can only download HTTP/HTTPS URIs: ");
                sb.append(str);
                throw new IllegalArgumentException(sb.toString());
            }
        }

        public DownloadRequest addRequestHeader(String str, String str2) {
            if (str == null) {
                throw new NullPointerException("header cannot be null");
            } else if (!str.contains(":")) {
                if (str2 == null) {
                    str2 = "";
                }
                this.mRequestHeaders.put(str, str2);
                return this;
            } else {
                throw new IllegalArgumentException("header may not contain ':'");
            }
        }

        public int getAllowedNetworkTypes() {
            return this.mAllowedNetworkTypes;
        }

        public String getDestinationDir() {
            return this.mDestinationDir;
        }

        public String getDestinationFileName() {
            return this.mDestinationFileName;
        }

        public String getDownloadUrl() {
            return this.mDownloadUrl;
        }

        public Serializable getTag() {
            return this.mTag;
        }

        public boolean isPhotoAdDownloadRequest() {
            return this.mIsPhotoAdDownloadRequest;
        }

        public DownloadRequest setAllowedNetworkTypes(int i) {
            this.mAllowedNetworkTypes = i;
            return this;
        }

        public DownloadRequest setDestinationDir(String str) {
            this.mDestinationDir = str;
            return this;
        }

        public DownloadRequest setDestinationFileName(String str) {
            this.mDestinationFileName = str;
            return this;
        }

        public DownloadRequest setInstallAfterDownload(boolean z) {
            this.mInstallAfterDownload = z;
            return this;
        }

        public void setIsPhotoAdDownloadRequest() {
            this.mIsPhotoAdDownloadRequest = true;
        }

        public DownloadRequest setNotificationVisibility(int i) {
            this.mNotificationVisibility = i;
            return this;
        }

        public DownloadRequest setTag(Serializable serializable) {
            this.mTag = serializable;
            return this;
        }
    }

    public DownloadTask(DownloadRequest downloadRequest) {
        initDownloadRequestParams(downloadRequest);
        instantiateDownloadTask();
        initDownloadTaskParams();
    }

    private void initDownloadRequestParams(DownloadRequest downloadRequest) {
        this.mWakeInstallApk = downloadRequest.mInstallAfterDownload;
        this.mUrl = downloadRequest.mDownloadUrl;
        this.mAllowedNetworkTypes = downloadRequest.mAllowedNetworkTypes;
        this.mNotificationVisibility = downloadRequest.mNotificationVisibility;
        this.mDestinationDir = downloadRequest.mDestinationDir;
        this.mDestinationFileName = downloadRequest.mDestinationFileName;
        this.mRequestHeaders = downloadRequest.mRequestHeaders;
        this.mTag = downloadRequest.mTag;
    }

    private void initDownloadTaskParams() {
        this.mBaseDownloadTask.mo24902a((Object) this.mTag);
        this.mBaseDownloadTask.mo24908b((this.mAllowedNetworkTypes ^ 2) == 0);
        for (Entry entry : this.mRequestHeaders.entrySet()) {
            this.mBaseDownloadTask.mo24907b((String) entry.getKey());
            this.mBaseDownloadTask.mo24904a((String) entry.getKey(), (String) entry.getValue());
        }
    }

    private void notifyDownloadCompleted(C4583a aVar) {
        if ((this.mNotificationVisibility & 2) != 0) {
            C3611e.m15066a().mo22734b(this);
        }
    }

    private void notifyDownloadPending(C4583a aVar) {
        if ((this.mNotificationVisibility & 2) != 0) {
            C3611e.m15066a().mo22731a(this);
        }
    }

    private void notifyDownloadProgress(C4583a aVar, boolean z) {
        if (!((aVar.mo24926s() == 0 && aVar.mo24924q() == 0) || TextUtils.isEmpty(aVar.mo24921n()) || (this.mNotificationVisibility & 1) == 0)) {
            C3611e.m15066a().mo22732a(this, z);
        }
    }

    /* access modifiers changed from: private */
    public void onBlockCompleted(C4583a aVar) {
        try {
            for (C3605c a : this.mDownloadListeners) {
                a.mo22703a(this);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void onCanceled(C4583a aVar) {
        try {
            this.mIsCanceled = true;
            for (C3605c e : this.mDownloadListeners) {
                e.mo22713e(this);
            }
            aVar.mo24914g();
            C3611e.m15066a().mo22730a(getId());
            C4723q.m19348a().mo25315a(getId(), this.mBaseDownloadTask.mo24922o());
            releaseDownloadTask();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* access modifiers changed from: private */
    public void onCompleted(C4583a aVar) {
        try {
            for (C3605c b : this.mDownloadListeners) {
                b.mo22707b(this);
            }
            notifyDownloadCompleted(aVar);
            if (this.mWakeInstallApk) {
                wakeInstallApk();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* access modifiers changed from: private */
    public void onConnected(C4583a aVar, String str, boolean z, int i, int i2) {
        long j;
        long j2 = (long) i2;
        try {
            j = C3606a.m15042a(new File(this.mDestinationDir).exists() ? this.mDestinationDir : Environment.getExternalStorageDirectory().getPath());
        } catch (Exception e) {
            e.printStackTrace();
            j = j2;
        }
        if (j < j2) {
            Intent intent = new Intent("download.intent.action.DOWNLOAD_CANCEL");
            intent.putExtra("download.intent.action.EXTRA_TASK_ID", aVar.mo24915h());
            C3603b.m15023a().sendBroadcast(intent);
            onLowStorage(aVar);
            return;
        }
        try {
            for (C3605c a : this.mDownloadListeners) {
                a.mo22705a(this, str, z, i, i2);
            }
            notifyDownloadProgress(aVar, false);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* access modifiers changed from: private */
    public void onDownloading(C4583a aVar, int i, int i2) {
        try {
            for (C3605c b : this.mDownloadListeners) {
                b.mo22708b(this, i, i2);
            }
            notifyDownloadProgress(this.mBaseDownloadTask, false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* access modifiers changed from: private */
    public void onError(C4583a aVar, Throwable th) {
        try {
            for (C3605c a : this.mDownloadListeners) {
                a.mo22706a(this, th);
            }
            notifyDownloadProgress(aVar, true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void onLowStorage(C4583a aVar) {
        try {
            for (C3605c f : this.mDownloadListeners) {
                f.mo22714f(this);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* access modifiers changed from: private */
    public void onPause(C4583a aVar, int i, int i2) {
        try {
            for (C3605c c : this.mDownloadListeners) {
                c.mo22710c(this, i, i2);
            }
            notifyDownloadProgress(aVar, true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* access modifiers changed from: private */
    public void onPending(C4583a aVar, int i, int i2) {
        try {
            for (C3605c a : this.mDownloadListeners) {
                a.mo22704a(this, i, i2);
            }
            notifyDownloadPending(aVar);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void onResume(C4583a aVar, int i, int i2) {
        try {
            for (C3605c d : this.mDownloadListeners) {
                d.mo22712d(this, i, i2);
            }
            notifyDownloadProgress(aVar, true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* access modifiers changed from: private */
    public void onStarted(C4583a aVar) {
        try {
            for (C3605c c : this.mDownloadListeners) {
                c.mo22709c(this);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* access modifiers changed from: private */
    public void onWarn(C4583a aVar) {
        try {
            for (C3605c d : this.mDownloadListeners) {
                d.mo22711d(this);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void readObject(ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        this.mDownloadListeners = new ArrayList();
    }

    private void releaseDownloadTask() {
        this.mBaseDownloadTask.mo24901a((C4669i) null);
        clearListener();
    }

    private void wakeInstallApk() {
        C3603b.m15027a(this.mBaseDownloadTask.mo24922o());
    }

    public void addListener(C3605c cVar) {
        if (cVar != null && !this.mDownloadListeners.contains(cVar)) {
            this.mDownloadListeners.add(cVar);
        }
    }

    /* access modifiers changed from: 0000 */
    public void cancel() {
        try {
            onCanceled(this.mBaseDownloadTask);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void clearListener() {
        this.mDownloadListeners.clear();
    }

    /* access modifiers changed from: 0000 */
    public int downLoadProgress() {
        long s = (long) this.mBaseDownloadTask.mo24926s();
        int q = s != 0 ? (int) ((((float) this.mBaseDownloadTask.mo24924q()) * 100.0f) / ((float) s)) : 0;
        if (q != 100 || C3606a.m15043a(new File(this.mBaseDownloadTask.mo24922o()))) {
            return q;
        }
        return 0;
    }

    public int getAllowedNetworkTypes() {
        return this.mAllowedNetworkTypes;
    }

    public String getDestinationDir() {
        return this.mDestinationDir;
    }

    public String getFilename() {
        return this.mBaseDownloadTask.mo24921n();
    }

    public int getId() {
        return this.mBaseDownloadTask.mo24915h();
    }

    public int getNotificationVisibility() {
        return this.mNotificationVisibility;
    }

    public String getPath() {
        return this.mBaseDownloadTask.mo24919l();
    }

    public int getSmallFileSoFarBytes() {
        return this.mBaseDownloadTask.mo24924q();
    }

    public int getSmallFileTotalBytes() {
        return this.mBaseDownloadTask.mo24926s();
    }

    public int getSpeed() {
        return this.mBaseDownloadTask.mo24928u();
    }

    public int getStatus() {
        return this.mBaseDownloadTask.mo24929v();
    }

    public long getStatusUpdateTime() {
        return this.mBaseDownloadTask.mo24930w();
    }

    public Object getTag() {
        return this.mBaseDownloadTask.mo24933z();
    }

    public String getTargetFilePath() {
        return this.mBaseDownloadTask.mo24922o();
    }

    public String getUrl() {
        return this.mUrl;
    }

    /* access modifiers changed from: 0000 */
    public void installApk() {
        try {
            wakeInstallApk();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* access modifiers changed from: 0000 */
    public void instantiateDownloadTask() {
        this.mBaseDownloadTask = C4723q.m19348a().mo25313a(this.mUrl).mo24906a(true).mo24900a(3).mo24905a(TextUtils.isEmpty(this.mDestinationFileName) ? this.mDestinationDir : new File(this.mDestinationDir, this.mDestinationFileName).getPath(), TextUtils.isEmpty(this.mDestinationFileName)).mo24901a((C4669i) new C4669i() {
            /* access modifiers changed from: protected */
            /* renamed from: a */
            public void mo22678a(C4583a aVar) {
                DownloadTask.this.onStarted(aVar);
            }

            /* access modifiers changed from: protected */
            /* renamed from: a */
            public void mo22679a(C4583a aVar, int i, int i2) {
                DownloadTask.this.onPending(aVar, i, i2);
            }

            /* access modifiers changed from: protected */
            /* renamed from: a */
            public void mo22680a(C4583a aVar, String str, boolean z, int i, int i2) {
                DownloadTask.this.onConnected(aVar, str, z, i, i2);
            }

            /* access modifiers changed from: protected */
            /* renamed from: a */
            public void mo22681a(C4583a aVar, Throwable th) {
                DownloadTask.this.onError(aVar, th);
            }

            /* access modifiers changed from: protected */
            /* renamed from: b */
            public void mo22682b(C4583a aVar) {
                DownloadTask.this.onBlockCompleted(aVar);
            }

            /* access modifiers changed from: protected */
            /* renamed from: b */
            public void mo22683b(C4583a aVar, int i, int i2) {
                DownloadTask.this.onDownloading(aVar, i, i2);
            }

            /* access modifiers changed from: protected */
            /* renamed from: c */
            public void mo22684c(C4583a aVar) {
                DownloadTask.this.onCompleted(aVar);
            }

            /* access modifiers changed from: protected */
            /* renamed from: c */
            public void mo22685c(C4583a aVar, int i, int i2) {
                DownloadTask.this.onPause(aVar, i, i2);
            }

            /* access modifiers changed from: protected */
            /* renamed from: d */
            public void mo22686d(C4583a aVar) {
                DownloadTask.this.onWarn(aVar);
            }
        });
    }

    public boolean isCanceled() {
        return this.mIsCanceled;
    }

    public boolean isCompleted() {
        return this.mBaseDownloadTask.mo24929v() == -3;
    }

    public boolean isError() {
        return this.mBaseDownloadTask.mo24929v() == -1;
    }

    public boolean isErrorBecauseWifiRequired() {
        return this.mBaseDownloadTask.mo24898E() && isError() && (this.mBaseDownloadTask.mo24932y() instanceof FileDownloadNetworkPolicyException);
    }

    public boolean isInvalid() {
        return this.mBaseDownloadTask.mo24929v() == 0;
    }

    public boolean isPaused() {
        return this.mBaseDownloadTask.mo24929v() == -2;
    }

    public boolean isRunning() {
        return this.mBaseDownloadTask.mo24910c();
    }

    /* access modifiers changed from: 0000 */
    public boolean isUserPause() {
        return this.mUserPause;
    }

    /* access modifiers changed from: 0000 */
    public void pause() {
        this.mBaseDownloadTask.mo24913f();
        notifyDownloadProgress(this.mBaseDownloadTask, true);
    }

    public void removeListener(C3605c cVar) {
        if (cVar != null) {
            this.mDownloadListeners.remove(cVar);
        }
    }

    /* access modifiers changed from: 0000 */
    public void resume(DownloadRequest downloadRequest) {
        if (C3607b.m15045a(C3603b.m15023a())) {
            if (downloadRequest != null) {
                initDownloadRequestParams(downloadRequest);
                initDownloadTaskParams();
            }
            this.mUserPause = false;
            if (!this.mBaseDownloadTask.mo24910c()) {
                try {
                    if (C4623d.m18946a((int) this.mBaseDownloadTask.mo24929v())) {
                        this.mBaseDownloadTask.mo24909b();
                    }
                    submit();
                    onResume(this.mBaseDownloadTask, this.mBaseDownloadTask.mo24924q(), this.mBaseDownloadTask.mo24926s());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void setAllowedNetworkTypes(int i) {
        this.mAllowedNetworkTypes = i;
        this.mBaseDownloadTask.mo24908b((this.mAllowedNetworkTypes ^ 2) == 0);
    }

    public void submit() {
        try {
            if (!this.mBaseDownloadTask.mo24910c()) {
                this.mBaseDownloadTask.mo24912e();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* access modifiers changed from: 0000 */
    public C4583a unwrap() {
        return this.mBaseDownloadTask;
    }

    /* access modifiers changed from: 0000 */
    public void userPause() {
        this.mUserPause = true;
        pause();
    }
}
