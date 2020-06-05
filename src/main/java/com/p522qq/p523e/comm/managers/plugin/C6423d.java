package com.p522qq.p523e.comm.managers.plugin;

import android.content.Context;
import com.p522qq.p523e.comm.util.SystemUtil;
import java.io.File;

/* renamed from: com.qq.e.comm.managers.plugin.d */
final class C6423d {
    /* renamed from: a */
    private static String f20214a = SystemUtil.buildNewPathByProcessName("e_qq_com_plugin");
    /* renamed from: b */
    private static String f20215b = SystemUtil.buildNewPathByProcessName("e_qq_com_dex");

    /* renamed from: a */
    static File m25207a(Context context) {
        return context.getDir(f20215b, 0);
    }

    /* renamed from: b */
    static File m25208b(Context context) {
        return new File(m25215i(context), "gdt_plugin.jar");
    }

    /* renamed from: c */
    static File m25209c(Context context) {
        return new File(m25215i(context), "gdt_plugin.tmp");
    }

    /* renamed from: d */
    static File m25210d(Context context) {
        return new File(m25215i(context), "gdt_plugin.next");
    }

    /* renamed from: e */
    static File m25211e(Context context) {
        return new File(m25215i(context), "gdt_plugin.jar.sig");
    }

    /* renamed from: f */
    static File m25212f(Context context) {
        return new File(m25215i(context), "gdt_plugin.tmp.sig");
    }

    /* renamed from: g */
    static File m25213g(Context context) {
        return new File(m25215i(context), "gdt_plugin.next.sig");
    }

    /* renamed from: h */
    static File m25214h(Context context) {
        return new File(m25215i(context), "update_lc");
    }

    /* renamed from: i */
    private static File m25215i(Context context) {
        return context.getDir(f20214a, 0);
    }
}
