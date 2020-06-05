package com.kwai.filedownloader.p353a;

import com.kwai.filedownloader.download.C4629b;
import com.kwai.filedownloader.p358f.C4660d;
import com.kwai.filedownloader.p358f.C4664f;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/* renamed from: com.kwai.filedownloader.a.d */
public class C4593d {
    /* renamed from: a */
    public static C4589b m18655a(Map<String, List<String>> map, C4589b bVar, List<String> list) {
        int e = bVar.mo22746e();
        String str = "Location";
        String a = bVar.mo22740a(str);
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (m18657a(e)) {
            if (a != null) {
                if (C4660d.f15179a) {
                    C4660d.m19123c(C4593d.class, "redirect to %s with %d, %s", a, Integer.valueOf(e), arrayList);
                }
                bVar.mo22747f();
                bVar = m18656a(map, a);
                arrayList.add(a);
                bVar.mo22745d();
                e = bVar.mo22746e();
                a = bVar.mo22740a(str);
                i++;
                if (i >= 10) {
                    throw new IllegalAccessException(C4664f.m19135a("redirect too many times! %s", arrayList));
                }
            } else {
                throw new IllegalAccessException(C4664f.m19135a("receive %d (redirect) but the location is null with response [%s]", Integer.valueOf(e), bVar.mo22744c()));
            }
        }
        if (list != null) {
            list.addAll(arrayList);
        }
        return bVar;
    }

    /* renamed from: a */
    private static C4589b m18656a(Map<String, List<String>> map, String str) {
        C4589b a = C4629b.m18995a().mo25140a(str);
        for (Entry entry : map.entrySet()) {
            String str2 = (String) entry.getKey();
            List<String> list = (List) entry.getValue();
            if (list != null) {
                for (String a2 : list) {
                    a.mo22741a(str2, a2);
                }
            }
        }
        return a;
    }

    /* renamed from: a */
    private static boolean m18657a(int i) {
        return i == 301 || i == 302 || i == 303 || i == 300 || i == 307 || i == 308;
    }
}
