package com.taobao.tao.remotebusiness;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import mtopsdk.common.util.C8330d;

/* renamed from: com.taobao.tao.remotebusiness.g */
public class RequestPool {
    /* renamed from: a */
    public static String m29160a(Map<String, List<String>> map, String str) {
        List list;
        if (map != null && !map.isEmpty() && !C8330d.m35525b(str)) {
            Iterator it = map.entrySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Entry entry = (Entry) it.next();
                if (str.equalsIgnoreCase((String) entry.getKey())) {
                    list = (List) entry.getValue();
                    break;
                }
            }
            if (list != null || list.isEmpty()) {
                return null;
            }
            return (String) list.get(0);
        }
        list = null;
        if (list != null) {
        }
        return null;
    }
}
