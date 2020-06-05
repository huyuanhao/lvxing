package com.tencent.p607mm.opensdk.channel.p608a;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.p607mm.opensdk.constants.ConstantsAPI;
import com.tencent.p607mm.opensdk.utils.C7339d;
import com.tencent.p607mm.opensdk.utils.Log;

/* renamed from: com.tencent.mm.opensdk.channel.a.a */
public final class C7322a {

    /* renamed from: com.tencent.mm.opensdk.channel.a.a$a */
    public static class C7323a {
        /* renamed from: a */
        public String f24796a;
        public String action;
        /* renamed from: b */
        public long f24797b;
        public Bundle bundle;
        public String content;
    }

    /* renamed from: a */
    public static boolean m31612a(Context context, C7323a aVar) {
        String str;
        String str2 = "MicroMsg.SDK.MMessage";
        if (context == null) {
            str = "send fail, invalid argument";
        } else if (C7339d.m31636b(aVar.action)) {
            str = "send fail, action is null";
        } else {
            String str3 = null;
            if (!C7339d.m31636b(aVar.f24796a)) {
                StringBuilder sb = new StringBuilder();
                sb.append(aVar.f24796a);
                sb.append(".permission.MM_MESSAGE");
                str3 = sb.toString();
            }
            Intent intent = new Intent(aVar.action);
            if (aVar.bundle != null) {
                intent.putExtras(aVar.bundle);
            }
            String packageName = context.getPackageName();
            intent.putExtra(ConstantsAPI.SDK_VERSION, 620953856);
            intent.putExtra(ConstantsAPI.APP_PACKAGE, packageName);
            intent.putExtra(ConstantsAPI.CONTENT, aVar.content);
            intent.putExtra(ConstantsAPI.APP_SUPORT_CONTENT_TYPE, aVar.f24797b);
            intent.putExtra(ConstantsAPI.CHECK_SUM, C7324b.m31613a(aVar.content, 620953856, packageName));
            context.sendBroadcast(intent, str3);
            StringBuilder sb2 = new StringBuilder("send mm message, intent=");
            sb2.append(intent);
            sb2.append(", perm=");
            sb2.append(str3);
            Log.m31626d(str2, sb2.toString());
            return true;
        }
        Log.m31627e(str2, str);
        return false;
    }
}
