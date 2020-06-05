package discoveryAD;

import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import com.tencent.p605ep.commonbase.api.Log;
import com.tencent.qqpim.discovery.DiscoverySdk;
import com.tmsdk.module.coin.TMSDKContext;
import java.io.File;

/* renamed from: discoveryAD.ha */
public class C7903ha {
    private static final String TAG = "FileDownloaderImpl";
    /* renamed from: je */
    public static final String f26900je = "QQSecureDownload/discovery";
    /* renamed from: ke */
    private static Handler f26901ke;
    private static C7903ha sInstance;
    /* renamed from: le */
    private C7911ka f26902le;

    /* renamed from: discoveryAD.ha$a */
    public interface C7904a {
        /* renamed from: g */
        void mo38215g(int i);
    }

    public C7903ha() {
        if (DiscoverySdk.isDownLoadSupport()) {
            HandlerThread handlerThread = new HandlerThread(C7903ha.class.getName());
            handlerThread.start();
            f26901ke = new Handler(handlerThread.getLooper());
            this.f26902le = new C7911ka(DiscoverySdk.getInstance().getApplicationContext());
        }
    }

    public static C7903ha getInstance() {
        if (sInstance == null) {
            synchronized (C7903ha.class) {
                if (sInstance == null) {
                    sInstance = new C7903ha();
                }
            }
        }
        return sInstance;
    }

    /* renamed from: a */
    public void mo38213a(String str, String str2, String str3, String str4, boolean z, C7904a aVar) {
        if (!DiscoverySdk.isDownLoadSupport()) {
            if (aVar != null) {
                aVar.mo38215g(TMSDKContext.S_ERR_UNKNOWN);
            }
            return;
        }
        try {
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append(File.separator);
            sb.append(str2);
            if (!new File(sb.toString()).exists()) {
                this.f26902le.setSavePath(str);
                if (!TextUtils.isEmpty(str2)) {
                    this.f26902le.setSaveName(str2);
                } else if (!TextUtils.isEmpty(str4)) {
                    this.f26902le.setSaveName(str4);
                }
                C7901ga gaVar = null;
                if (!TextUtils.isEmpty(str4)) {
                    gaVar = new C7901ga(this, str4);
                }
                int a = this.f26902le.mo38226a(str4, str3, z, gaVar);
                if (aVar != null) {
                    aVar.mo38215g(a);
                }
            }
        } catch (Throwable th) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("[downloadSplashImage]");
            sb2.append(th.getMessage());
            Log.m31479e(TAG, sb2.toString());
        }
    }

    /* renamed from: b */
    public void mo38214b(String str, String str2, String str3, String str4, boolean z, C7904a aVar) {
        if (!DiscoverySdk.isDownLoadSupport()) {
            if (aVar != null) {
                aVar.mo38215g(TMSDKContext.S_ERR_UNKNOWN);
            }
            return;
        }
        C7899fa faVar = new C7899fa(this, str, str2, str3, str4, z, aVar);
        f26901ke.post(faVar);
    }
}
