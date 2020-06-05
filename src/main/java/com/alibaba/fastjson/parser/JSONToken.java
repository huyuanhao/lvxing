package com.alibaba.fastjson.parser;

import com.tencent.android.tpush.SettingsContentProvider;
import com.tencent.mid.sotrage.StorageInterface;

/* renamed from: com.alibaba.fastjson.parser.f */
public class JSONToken {
    /* renamed from: a */
    public static String m2903a(int i) {
        switch (i) {
            case 1:
                return "error";
            case 2:
                return "int";
            case 3:
                return SettingsContentProvider.FLOAT_TYPE;
            case 4:
                return SettingsContentProvider.STRING_TYPE;
            case 5:
                return "iso8601";
            case 6:
                return "true";
            case 7:
                return "false";
            case 8:
                return "null";
            case 9:
                return "new";
            case 10:
                return "(";
            case 11:
                return ")";
            case 12:
                return "{";
            case 13:
                return "}";
            case 14:
                return "[";
            case 15:
                return "]";
            case 16:
                return StorageInterface.KEY_SPLITER;
            case 17:
                return ":";
            case 18:
                return "ident";
            case 19:
                return "fieldName";
            case 20:
                return "EOF";
            case 21:
                return "Set";
            case 22:
                return "TreeSet";
            case 23:
                return "undefined";
            case 24:
                return ";";
            case 25:
                return ".";
            case 26:
                return "hex";
            default:
                return "Unknown";
        }
    }
}
