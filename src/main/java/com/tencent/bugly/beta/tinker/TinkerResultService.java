package com.tencent.bugly.beta.tinker;

import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import com.tencent.bugly.beta.tinker.TinkerUtils.ScreenState;
import com.tencent.tinker.lib.service.DefaultTinkerResultService;
import com.tencent.tinker.lib.service.PatchResult;
import com.tencent.tinker.lib.util.TinkerLog;
import com.tencent.tinker.lib.util.TinkerServiceInternals;
import java.io.File;

/* compiled from: BUGLY */
public class TinkerResultService extends DefaultTinkerResultService {
    private static final String TAG = "Tinker.TinkerResultService";

    public void onPatchResult(final PatchResult patchResult) {
        if (TinkerManager.patchResultListener != null) {
            TinkerManager.patchResultListener.onPatchResult(patchResult);
        }
        String str = TAG;
        if (patchResult == null) {
            TinkerLog.e(str, "TinkerResultService received null result!!!!", new Object[0]);
            return;
        }
        TinkerLog.i(str, "TinkerResultService receive result: %s", new Object[]{patchResult.toString()});
        TinkerServiceInternals.killTinkerPatchServiceProcess(getApplicationContext());
        new Handler(Looper.getMainLooper()).post(new Runnable() {
            public void run() {
                if (patchResult.isSuccess) {
                    TinkerManager.getInstance().onApplySuccess(patchResult.toString());
                } else {
                    TinkerManager.getInstance().onApplyFailure(patchResult.toString());
                }
            }
        });
        if (patchResult.isSuccess) {
            deleteRawPatchFile(new File(patchResult.rawPatchFilePath));
            if (!checkIfNeedKill(patchResult)) {
                TinkerLog.i(str, "I have already install the newly patch version!", new Object[0]);
            } else if (TinkerManager.isPatchRestartOnScreenOff()) {
                if (TinkerUtils.isBackground()) {
                    TinkerLog.i(str, "it is in background, just restart process", new Object[0]);
                    restartProcess();
                } else {
                    TinkerLog.i(str, "tinker wait screen to restart process", new Object[0]);
                    new ScreenState(getApplicationContext(), new IOnScreenOff() {
                        public void onScreenOff() {
                            TinkerResultService.this.restartProcess();
                        }
                    });
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public void restartProcess() {
        TinkerLog.i(TAG, "app is background now, i can kill quietly", new Object[0]);
        Process.killProcess(Process.myPid());
    }
}
