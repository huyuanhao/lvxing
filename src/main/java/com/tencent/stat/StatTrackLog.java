package com.tencent.stat;

import android.util.Log;
import java.util.ArrayList;
import java.util.Iterator;

public class StatTrackLog {
    public static int MAX_FETCH_LIMIT = 50;
    public static int MAX_LIMIT = 100;
    /* renamed from: a */
    private static ArrayList<String> f25585a = new ArrayList<>();
    /* renamed from: b */
    private static boolean f25586b = true;
    /* renamed from: c */
    private static String f25587c = "track.mta";

    public static boolean isEnableLogcatOutput() {
        return f25586b;
    }

    public static void setEnableLogcatOutput(boolean z) {
        f25586b = z;
    }

    public static void log(Object obj) {
        if (obj != null) {
            String obj2 = obj.toString();
            if (f25586b) {
                Log.d(f25587c, obj2);
            }
            f25585a.add(obj2);
            int size = f25585a.size();
            int i = MAX_LIMIT;
            if (size > i) {
                f25585a = (ArrayList) f25585a.subList(size - (i / 2), size);
            }
        }
    }

    public static String fetchLog() {
        ArrayList arrayList;
        StringBuffer stringBuffer = new StringBuffer();
        if (f25585a.size() > MAX_FETCH_LIMIT) {
            ArrayList<String> arrayList2 = f25585a;
            arrayList = (ArrayList) arrayList2.subList(arrayList2.size() - MAX_FETCH_LIMIT, f25585a.size());
        } else {
            arrayList = (ArrayList) f25585a.clone();
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append("\n");
            stringBuffer.append(sb.toString());
        }
        return stringBuffer.toString();
    }
}
