package com.elvishew.xlog.formatter.p228b.p229a;

import com.elvishew.xlog.formatter.FormatException;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.elvishew.xlog.formatter.b.a.a */
public class DefaultJsonFormatter implements JsonFormatter {
    /* renamed from: a */
    public String mo17099a(String str) {
        if (str == null || str.trim().length() == 0) {
            throw new FormatException("JSON empty.");
        }
        try {
            if (str.startsWith("{")) {
                return new JSONObject(str).toString(4);
            }
            if (str.startsWith("[")) {
                return new JSONArray(str).toString(4);
            }
            StringBuilder sb = new StringBuilder();
            sb.append("JSON should start with { or [, but found ");
            sb.append(str);
            throw new FormatException(sb.toString());
        } catch (Exception e) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Parse JSON error. JSON string:");
            sb2.append(str);
            throw new FormatException(sb2.toString(), e);
        }
    }
}
