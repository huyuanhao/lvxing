package com.p522qq.p523e.comm;

import android.content.Context;
import com.p522qq.p523e.comm.managers.setting.GlobalSetting;
import com.p522qq.p523e.comm.p525pi.CustomLandingPageListener;
import com.p522qq.p523e.comm.util.SystemUtil;

/* renamed from: com.qq.e.comm.StubVisitor */
public class StubVisitor {
    /* renamed from: a */
    private static volatile StubVisitor f20159a;

    private StubVisitor() {
    }

    public static StubVisitor getInstance() {
        if (f20159a == null) {
            synchronized (StubVisitor.class) {
                if (f20159a == null) {
                    f20159a = new StubVisitor();
                }
            }
        }
        return f20159a;
    }

    public String appendPathName(String str) {
        return SystemUtil.buildNewPathByProcessName(str);
    }

    public boolean jumpToCustomLandingPage(Context context, String str, String str2) {
        CustomLandingPageListener customLandingPageListener = GlobalSetting.getCustomLandingPageListener();
        if (customLandingPageListener != null) {
            return customLandingPageListener.jumpToCustomLandingPage(context, str, str2);
        }
        return false;
    }
}
