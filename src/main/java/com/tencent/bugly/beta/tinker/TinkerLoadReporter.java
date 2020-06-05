package com.tencent.bugly.beta.tinker;

import android.content.Context;
import android.os.Looper;
import android.os.MessageQueue.IdleHandler;
import com.tencent.tinker.lib.reporter.DefaultLoadReporter;
import com.tencent.tinker.lib.reporter.LoadReporter;
import com.tencent.tinker.lib.tinker.Tinker;
import com.tencent.tinker.lib.tinker.TinkerInstaller;
import com.tencent.tinker.lib.util.TinkerLog;
import com.tencent.tinker.lib.util.UpgradePatchRetry;
import com.tencent.tinker.loader.shareutil.SharePatchFileUtil;
import java.io.File;

/* compiled from: BUGLY */
public class TinkerLoadReporter extends DefaultLoadReporter {
    private static final String TAG = "Tinker.TinkerLoadReporter";
    private final LoadReporter userLoadReporter = TinkerManager.userLoadReporter;

    public TinkerLoadReporter(Context context) {
        super(context);
    }

    public void onLoadPatchListenerReceiveFail(File file, int i) {
        TinkerLoadReporter.super.onLoadPatchListenerReceiveFail(file, i);
        LoadReporter loadReporter = this.userLoadReporter;
        if (loadReporter != null) {
            loadReporter.onLoadPatchListenerReceiveFail(file, i);
        } else {
            TinkerReport.onTryApplyFail(i);
        }
    }

    public void onLoadResult(File file, int i, long j) {
        TinkerLoadReporter.super.onLoadResult(file, i, j);
        LoadReporter loadReporter = this.userLoadReporter;
        if (loadReporter != null) {
            loadReporter.onLoadResult(file, i, j);
            return;
        }
        if (i == 0) {
            TinkerReport.onLoaded(j);
        }
        Looper.getMainLooper();
        Looper.myQueue().addIdleHandler(new IdleHandler() {
            public boolean queueIdle() {
                if (UpgradePatchRetry.getInstance(TinkerLoadReporter.this.context).onPatchRetryLoad()) {
                    TinkerReport.onReportRetryPatch();
                }
                return false;
            }
        });
    }

    public void onLoadException(Throwable th, int i) {
        TinkerLoadReporter.super.onLoadException(th, i);
        LoadReporter loadReporter = this.userLoadReporter;
        if (loadReporter != null) {
            loadReporter.onLoadException(th, i);
        } else {
            TinkerReport.onLoadException(th, i);
        }
    }

    public void onLoadFileMd5Mismatch(File file, int i) {
        TinkerLoadReporter.super.onLoadFileMd5Mismatch(file, i);
        LoadReporter loadReporter = this.userLoadReporter;
        if (loadReporter != null) {
            loadReporter.onLoadFileMd5Mismatch(file, i);
        } else {
            TinkerReport.onLoadFileMisMatch(i);
        }
    }

    public void onLoadFileNotFound(File file, int i, boolean z) {
        TinkerLoadReporter.super.onLoadFileNotFound(file, i, z);
        LoadReporter loadReporter = this.userLoadReporter;
        if (loadReporter != null) {
            loadReporter.onLoadFileNotFound(file, i, z);
            return;
        }
        Object[] objArr = {file.getAbsolutePath(), Integer.valueOf(i), Boolean.valueOf(z)};
        String str = TAG;
        TinkerLog.i(str, "patch loadReporter onLoadFileNotFound: patch file not found: %s, fileType:%d, isDirectory:%b", objArr);
        if (i == 4) {
            Tinker with = Tinker.with(this.context);
            if (with.isMainProcess()) {
                File file2 = with.getTinkerLoadResultIfPresent().patchVersionFile;
                if (file2 != null) {
                    if (UpgradePatchRetry.getInstance(this.context).onPatchListenerCheck(SharePatchFileUtil.getMD5(file2))) {
                        TinkerLog.i(str, "try to repair oat file on patch process", new Object[0]);
                        TinkerInstaller.onReceiveUpgradePatch(this.context, file2.getAbsolutePath());
                    } else {
                        TinkerLog.i(str, "repair retry exceed must max time, just clean", new Object[0]);
                        checkAndCleanPatch();
                    }
                }
            }
        } else {
            checkAndCleanPatch();
        }
        TinkerReport.onLoadFileNotFound(i);
    }

    public void onLoadPackageCheckFail(File file, int i) {
        TinkerLoadReporter.super.onLoadPackageCheckFail(file, i);
        LoadReporter loadReporter = this.userLoadReporter;
        if (loadReporter != null) {
            loadReporter.onLoadPackageCheckFail(file, i);
        } else {
            TinkerReport.onLoadPackageCheckFail(i);
        }
    }

    public void onLoadPatchInfoCorrupted(String str, String str2, File file) {
        TinkerLoadReporter.super.onLoadPatchInfoCorrupted(str, str2, file);
        LoadReporter loadReporter = this.userLoadReporter;
        if (loadReporter != null) {
            loadReporter.onLoadPatchInfoCorrupted(str, str2, file);
        } else {
            TinkerReport.onLoadInfoCorrupted();
        }
    }

    public void onLoadInterpret(int i, Throwable th) {
        TinkerLoadReporter.super.onLoadInterpret(i, th);
        LoadReporter loadReporter = this.userLoadReporter;
        if (loadReporter != null) {
            loadReporter.onLoadInterpret(i, th);
        } else {
            TinkerReport.onLoadInterpretReport(i, th);
        }
    }

    public void onLoadPatchVersionChanged(String str, String str2, File file, String str3) {
        TinkerLoadReporter.super.onLoadPatchVersionChanged(str, str2, file, str3);
        LoadReporter loadReporter = this.userLoadReporter;
        if (loadReporter != null) {
            loadReporter.onLoadPatchVersionChanged(str, str2, file, str3);
        }
    }
}
