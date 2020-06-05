package com.tencent.bugly.beta.tinker;

import android.content.Context;
import android.content.Intent;
import com.tencent.tinker.lib.reporter.DefaultPatchReporter;
import com.tencent.tinker.lib.reporter.PatchReporter;
import com.tencent.tinker.lib.util.UpgradePatchRetry;
import com.tencent.tinker.loader.shareutil.SharePatchInfo;
import java.io.File;
import java.util.List;

/* compiled from: BUGLY */
public class TinkerPatchReporter extends DefaultPatchReporter {
    private final PatchReporter userPatchReporter = TinkerManager.userPatchReporter;

    public TinkerPatchReporter(Context context) {
        super(context);
    }

    public void onPatchServiceStart(Intent intent) {
        TinkerPatchReporter.super.onPatchServiceStart(intent);
        PatchReporter patchReporter = this.userPatchReporter;
        if (patchReporter != null) {
            patchReporter.onPatchServiceStart(intent);
            return;
        }
        TinkerReport.onApplyPatchServiceStart();
        UpgradePatchRetry.getInstance(this.context).onPatchServiceStart(intent);
    }

    public void onPatchDexOptFail(File file, List<File> list, Throwable th) {
        TinkerPatchReporter.super.onPatchDexOptFail(file, list, th);
        PatchReporter patchReporter = this.userPatchReporter;
        if (patchReporter != null) {
            patchReporter.onPatchDexOptFail(file, list, th);
        } else {
            TinkerReport.onApplyDexOptFail(th);
        }
    }

    public void onPatchException(File file, Throwable th) {
        TinkerPatchReporter.super.onPatchException(file, th);
        PatchReporter patchReporter = this.userPatchReporter;
        if (patchReporter != null) {
            patchReporter.onPatchException(file, th);
        } else {
            TinkerReport.onApplyCrash(th);
        }
    }

    public void onPatchInfoCorrupted(File file, String str, String str2) {
        TinkerPatchReporter.super.onPatchInfoCorrupted(file, str, str2);
        PatchReporter patchReporter = this.userPatchReporter;
        if (patchReporter != null) {
            patchReporter.onPatchInfoCorrupted(file, str, str2);
        } else {
            TinkerReport.onApplyInfoCorrupted();
        }
    }

    public void onPatchPackageCheckFail(File file, int i) {
        TinkerPatchReporter.super.onPatchPackageCheckFail(file, i);
        PatchReporter patchReporter = this.userPatchReporter;
        if (patchReporter != null) {
            patchReporter.onPatchPackageCheckFail(file, i);
        } else {
            TinkerReport.onApplyPackageCheckFail(i);
        }
    }

    public void onPatchResult(File file, boolean z, long j) {
        TinkerPatchReporter.super.onPatchResult(file, z, j);
        PatchReporter patchReporter = this.userPatchReporter;
        if (patchReporter != null) {
            patchReporter.onPatchResult(file, z, j);
            return;
        }
        TinkerReport.onApplied(j, z);
        UpgradePatchRetry.getInstance(this.context).onPatchServiceResult();
    }

    public void onPatchTypeExtractFail(File file, File file2, String str, int i) {
        TinkerPatchReporter.super.onPatchTypeExtractFail(file, file2, str, i);
        PatchReporter patchReporter = this.userPatchReporter;
        if (patchReporter != null) {
            patchReporter.onPatchTypeExtractFail(file, file2, str, i);
        } else {
            TinkerReport.onApplyExtractFail(i);
        }
    }

    public void onPatchVersionCheckFail(File file, SharePatchInfo sharePatchInfo, String str) {
        TinkerPatchReporter.super.onPatchVersionCheckFail(file, sharePatchInfo, str);
        PatchReporter patchReporter = this.userPatchReporter;
        if (patchReporter != null) {
            patchReporter.onPatchVersionCheckFail(file, sharePatchInfo, str);
        } else {
            TinkerReport.onApplyVersionCheckFail();
        }
    }
}
