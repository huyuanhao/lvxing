package com.tencent.bugly.beta.tinker;

import android.app.ActivityManager;
import android.content.Context;
import com.tencent.android.tpush.common.Constants;
import com.tencent.tinker.lib.listener.DefaultPatchListener;
import com.tencent.tinker.lib.listener.PatchListener;
import com.tencent.tinker.lib.util.TinkerLog;
import com.tencent.tinker.loader.shareutil.SharePatchFileUtil;
import com.tencent.tinker.loader.shareutil.ShareTinkerInternals;
import java.io.File;
import java.util.Properties;

/* compiled from: BUGLY */
public class TinkerPatchListener extends DefaultPatchListener {
    protected static final long NEW_PATCH_RESTRICTION_SPACE_SIZE_MIN = 62914560;
    private static final String TAG = "Tinker.TinkerPatchListener";
    private final int maxMemory;
    private final PatchListener userPatchListener = TinkerManager.userPatchListener;

    public TinkerPatchListener(Context context) {
        super(context);
        this.maxMemory = ((ActivityManager) context.getSystemService(Constants.FLAG_ACTIVITY_NAME)).getMemoryClass();
        StringBuilder sb = new StringBuilder();
        sb.append("application maxMemory:");
        sb.append(this.maxMemory);
        TinkerLog.i(TAG, sb.toString(), new Object[0]);
    }

    public int patchCheck(String str, String str2) {
        PatchListener patchListener = this.userPatchListener;
        if (patchListener != null) {
            patchListener.onPatchReceived(str);
            return TinkerPatchListener.super.patchCheck(str, str2);
        }
        File file = new File(str);
        boolean z = false;
        Object[] objArr = {str, Long.valueOf(SharePatchFileUtil.getFileOrDirectorySize(file))};
        String str3 = TAG;
        TinkerLog.i(str3, "receive a patch file: %s, file size:%d", objArr);
        int patchCheck = TinkerPatchListener.super.patchCheck(str, str2);
        if (patchCheck == 0) {
            patchCheck = TinkerUtils.checkForPatchRecover(NEW_PATCH_RESTRICTION_SPACE_SIZE_MIN, this.maxMemory);
        }
        if (patchCheck == 0 && this.context.getSharedPreferences("tinker_share_config", 0).getInt(str2, 0) >= 3) {
            patchCheck = -23;
        }
        if (patchCheck == 0) {
            Properties fastGetPatchPackageMeta = ShareTinkerInternals.fastGetPatchPackageMeta(file);
            if (fastGetPatchPackageMeta == null) {
                patchCheck = -24;
            } else {
                String property = fastGetPatchPackageMeta.getProperty(TinkerUtils.PLATFORM);
                StringBuilder sb = new StringBuilder();
                sb.append("get platform:");
                sb.append(property);
                TinkerLog.i(str3, sb.toString(), new Object[0]);
            }
        }
        if (patchCheck == 0) {
            z = true;
        }
        TinkerReport.onTryApply(z);
        return patchCheck;
    }
}
