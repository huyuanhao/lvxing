package com.p620ut.mini;

import android.text.TextUtils;
import com.alibaba.mtl.log.model.LogField;
import com.alibaba.mtl.log.p077d.C1328p;
import com.alibaba.mtl.log.p077d.Logger;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.ut.mini.c */
public class UTHitBuilders {

    /* compiled from: UTHitBuilders */
    /* renamed from: com.ut.mini.c$a */
    public static class C7712a extends C7713b {
        public C7712a(String str) {
            if (!TextUtils.isEmpty(str)) {
                super.mo37427a("_field_arg1", str);
            }
            super.mo37427a("_field_event_id", "19999");
            super.mo37427a("_field_arg3", "0");
        }

        /* renamed from: a */
        public C7712a mo37424a(long j) {
            if (j < 0) {
                j = 0;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("");
            sb.append(j);
            super.mo37427a("_field_arg3", sb.toString());
            return this;
        }

        /* renamed from: a */
        public C7712a mo37425a(String str) {
            if (!TextUtils.isEmpty(str)) {
                super.mo37427a("_field_page", str);
            }
            return this;
        }

        /* renamed from: a */
        public Map<String, String> mo37426a() {
            Map<String, String> a = super.mo37426a();
            if (a == null) {
                return a;
            }
            String str = (String) a.get(LogField.PAGE.toString());
            String str2 = (String) a.get(LogField.ARG1.toString());
            if (str2 == null) {
                return a;
            }
            a.remove(LogField.ARG1.toString());
            a.remove(LogField.PAGE.toString());
            Map<String, String> a2 = C1328p.m3863a(a);
            a2.put(LogField.ARG1.toString(), str2);
            a2.put(LogField.PAGE.toString(), str);
            return a2;
        }
    }

    /* compiled from: UTHitBuilders */
    /* renamed from: com.ut.mini.c$b */
    public static class C7713b {
        /* renamed from: a */
        private Map<String, String> f26035a = new HashMap();

        public C7713b() {
            String str = "_field_page";
            if (!this.f26035a.containsKey(str)) {
                this.f26035a.put(str, "UT");
            }
        }

        /* renamed from: a */
        public C7713b mo37427a(String str, String str2) {
            if (TextUtils.isEmpty(str) || str2 == null) {
                Logger.m3831a("setProperty", (Object) "key is null or key is empty or value is null,please check it!");
            } else {
                if (this.f26035a.containsKey(str)) {
                    this.f26035a.remove(str);
                }
                this.f26035a.put(str, str2);
            }
            return this;
        }

        /* renamed from: a */
        public C7713b mo37428a(Map<String, String> map) {
            if (map != null) {
                this.f26035a.putAll(map);
            }
            return this;
        }

        /* renamed from: a */
        public Map<String, String> mo37426a() {
            HashMap hashMap = new HashMap();
            hashMap.putAll(this.f26035a);
            if (!m33151b(hashMap)) {
                return null;
            }
            m33153d(hashMap);
            m33152c(hashMap);
            if (!hashMap.containsKey(LogField.EVENTID.toString())) {
                return null;
            }
            return hashMap;
        }

        /* renamed from: b */
        private static boolean m33151b(Map<String, String> map) {
            if (map != null) {
                if (map.containsKey(null)) {
                    map.remove(null);
                }
                String str = "";
                if (map.containsKey(str)) {
                    map.remove(str);
                }
                String str2 = "checkIlleagleProperty";
                if (map.containsKey(LogField.PAGE.toString())) {
                    Logger.m3831a(str2, (Object) "IlleaglePropertyKey(PAGE) is setted when you call the method setProperty or setProperties ,please use another key to replace it!");
                    return false;
                } else if (map.containsKey(LogField.EVENTID.toString())) {
                    Logger.m3831a(str2, (Object) "IlleaglePropertyKey(EVENTID) is setted when you call the method setProperty or setProperties ,please use another key to replace it!");
                    return false;
                } else if (map.containsKey(LogField.ARG1.toString())) {
                    Logger.m3831a(str2, (Object) "IlleaglePropertyKey(ARG1) is setted when you call the method setProperty or setProperties ,please use another key to replace it!");
                    return false;
                } else if (map.containsKey(LogField.ARG2.toString())) {
                    Logger.m3831a(str2, (Object) "IlleaglePropertyKey(ARG2) is setted when you call the method setProperty or setProperties ,please use another key to replace it!");
                    return false;
                } else if (map.containsKey(LogField.ARG3.toString())) {
                    Logger.m3831a(str2, (Object) "IlleaglePropertyKey(ARG3) is setted when you call the method setProperty or setProperties ,please use another key to replace it!");
                    return false;
                }
            }
            return true;
        }

        /* renamed from: c */
        private static void m33152c(Map<String, String> map) {
            if (map != null) {
                String str = "_field_page";
                if (map.containsKey(str)) {
                    String str2 = (String) map.get(str);
                    map.remove(str);
                    map.put(LogField.PAGE.toString(), str2);
                }
                String str3 = "_field_arg1";
                if (map.containsKey(str3)) {
                    String str4 = (String) map.get(str3);
                    map.remove(str3);
                    map.put(LogField.ARG1.toString(), str4);
                }
                String str5 = "_field_arg2";
                if (map.containsKey(str5)) {
                    String str6 = (String) map.get(str5);
                    map.remove(str5);
                    map.put(LogField.ARG2.toString(), str6);
                }
                String str7 = "_field_arg3";
                if (map.containsKey(str7)) {
                    String str8 = (String) map.get(str7);
                    map.remove(str7);
                    map.put(LogField.ARG3.toString(), str8);
                }
                String str9 = "_field_args";
                if (map.containsKey(str9)) {
                    String str10 = (String) map.get(str9);
                    map.remove(str9);
                    map.put(LogField.ARGS.toString(), str10);
                }
                String str11 = "_field_event_id";
                if (map.containsKey(str11)) {
                    String str12 = (String) map.get(str11);
                    map.remove(str11);
                    map.put(LogField.EVENTID.toString(), str12);
                }
            }
        }

        /* renamed from: d */
        private static void m33153d(Map<String, String> map) {
            if (map != null) {
                if (map.containsKey(LogField.PAGE.toString())) {
                    map.remove(LogField.PAGE.toString());
                }
                if (map.containsKey(LogField.EVENTID.toString())) {
                    map.remove(LogField.EVENTID.toString());
                }
                if (map.containsKey(LogField.ARG1.toString())) {
                    map.remove(LogField.ARG1.toString());
                }
                if (map.containsKey(LogField.ARG2.toString())) {
                    map.remove(LogField.ARG2.toString());
                }
                if (map.containsKey(LogField.ARG3.toString())) {
                    map.remove(LogField.ARG3.toString());
                }
                if (map.containsKey(LogField.ARGS.toString())) {
                    map.remove(LogField.ARGS.toString());
                }
            }
        }
    }

    /* compiled from: UTHitBuilders */
    /* renamed from: com.ut.mini.c$c */
    public static class C7714c extends C7713b {
        public C7714c(String str) {
            if (!TextUtils.isEmpty(str)) {
                super.mo37427a("_field_page", str);
            }
            super.mo37427a("_field_event_id", "2001");
            super.mo37427a("_field_arg3", "0");
        }

        /* renamed from: a */
        public C7714c mo37430a(String str) {
            if (!TextUtils.isEmpty(str)) {
                super.mo37427a("_field_arg1", str);
            }
            return this;
        }

        /* renamed from: a */
        public C7714c mo37429a(long j) {
            if (j < 0) {
                j = 0;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("");
            sb.append(j);
            super.mo37427a("_field_arg3", sb.toString());
            return this;
        }
    }
}
