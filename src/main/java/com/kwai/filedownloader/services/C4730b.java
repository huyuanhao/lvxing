package com.kwai.filedownloader.services;

import com.kwai.filedownloader.p358f.C4654c.C4658d;
import com.kwai.filedownloader.p358f.C4664f;

/* renamed from: com.kwai.filedownloader.services.b */
public class C4730b implements C4658d {
    /* renamed from: a */
    public int mo25218a(int i, String str, String str2, boolean z) {
        return mo25219a(str, str2, z);
    }

    /* renamed from: a */
    public int mo25219a(String str, String str2, boolean z) {
        String a;
        if (z) {
            a = C4664f.m19135a("%sp%s@dir", str, str2);
        } else {
            a = C4664f.m19135a("%sp%s", str, str2);
        }
        return C4664f.m19156e(a).hashCode();
    }
}
