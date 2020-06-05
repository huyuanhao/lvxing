package com.tencent.stat.app.channel;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.text.TextUtils;
import com.tencent.stat.apkreader.ChannelInfo;
import com.tencent.stat.apkreader.ChannelReader;
import java.io.File;
import java.util.Map;

public final class MtaChannelReader {
    private MtaChannelReader() {
    }

    public static String getChannel(Context context) {
        return getChannel(context, null);
    }

    public static String getChannel(Context context, String str) {
        ChannelInfo channelInfo = getChannelInfo(context);
        if (channelInfo == null) {
            return str;
        }
        return channelInfo.getChannel();
    }

    public static ChannelInfo getChannelInfo(Context context) {
        String a = m32708a(context);
        if (TextUtils.isEmpty(a)) {
            return null;
        }
        return ChannelReader.get(new File(a));
    }

    public static String get(Context context, String str) {
        Map channelInfoMap = getChannelInfoMap(context);
        if (channelInfoMap == null) {
            return null;
        }
        return (String) channelInfoMap.get(str);
    }

    public static Map<String, String> getChannelInfoMap(Context context) {
        String a = m32708a(context);
        if (TextUtils.isEmpty(a)) {
            return null;
        }
        return ChannelReader.getMap(new File(a));
    }

    /* renamed from: a */
    private static String m32708a(Context context) {
        String str = null;
        try {
            ApplicationInfo applicationInfo = context.getApplicationInfo();
            if (applicationInfo == null) {
                return null;
            }
            str = applicationInfo.sourceDir;
            return str;
        } catch (Throwable unused) {
        }
    }
}
