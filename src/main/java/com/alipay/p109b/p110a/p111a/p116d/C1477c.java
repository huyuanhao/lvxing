package com.alipay.p109b.p110a.p111a.p116d;

import java.io.File;
import java.io.FileFilter;
import java.util.regex.Pattern;

/* renamed from: com.alipay.b.a.a.d.c */
class C1477c implements FileFilter {
    /* renamed from: a */
    final /* synthetic */ C1476b f3754a;

    C1477c(C1476b bVar) {
        this.f3754a = bVar;
    }

    public boolean accept(File file) {
        return Pattern.matches("cpu[0-9]+", file.getName());
    }
}
