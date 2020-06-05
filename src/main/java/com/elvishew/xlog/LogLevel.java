package com.elvishew.xlog;

/* renamed from: com.elvishew.xlog.c */
public class LogLevel {
    /* renamed from: a */
    public static String m12651a(int i) {
        if (i == 2) {
            return "V";
        }
        if (i == 3) {
            return "D";
        }
        if (i == 4) {
            return "I";
        }
        if (i == 5) {
            return "W";
        }
        if (i == 6) {
            return "E";
        }
        if (i < 2) {
            StringBuilder sb = new StringBuilder();
            sb.append("V-");
            sb.append(2 - i);
            return sb.toString();
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("E+");
        sb2.append(i - 6);
        return sb2.toString();
    }
}
