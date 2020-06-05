package com.tencent.android.tpush.stat.p597b;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

/* compiled from: ProGuard */
/* renamed from: com.tencent.android.tpush.stat.b.a */
public class C7072a {
    /* renamed from: a */
    public static List<String> m30310a(File file) {
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        ArrayList arrayList = new ArrayList();
        while (true) {
            String readLine = bufferedReader.readLine();
            if (readLine == null) {
                fileReader.close();
                bufferedReader.close();
                return arrayList;
            }
            arrayList.add(readLine.trim());
        }
    }

    /* renamed from: a */
    static File m30309a(String str) {
        File file = new File(str);
        if (file.exists()) {
            return file;
        }
        if (!file.getParentFile().exists()) {
            m30309a(file.getParentFile().getAbsolutePath());
        }
        file.mkdir();
        return file;
    }
}
