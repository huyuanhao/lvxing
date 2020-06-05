package com.tencent.p605ep.commonbase.api;

import java.io.File;

/* renamed from: com.tencent.ep.commonbase.api.AbstractLog */
abstract class AbstractLog {
    AbstractLog() {
    }

    /* renamed from: d */
    public void mo35332d(String str, String str2) {
        println(3, str, str2);
    }

    /* renamed from: d */
    public void mo35333d(String str, String str2, Throwable th) {
        StringBuilder sb = new StringBuilder();
        sb.append(str2);
        sb.append(10);
        sb.append(Log.getStackTraceString(th));
        println(3, str, sb.toString());
    }

    /* renamed from: e */
    public void mo35334e(String str, String str2) {
        println(6, str, str2);
    }

    /* renamed from: e */
    public void mo35335e(String str, String str2, Throwable th) {
        StringBuilder sb = new StringBuilder();
        sb.append(str2);
        sb.append(10);
        sb.append(Log.getStackTraceString(th));
        println(6, str, sb.toString());
    }

    /* renamed from: f */
    public void mo35336f(String str, String str2) {
        println(10, str, str2);
    }

    /* renamed from: f */
    public void mo35337f(String str, String str2, Throwable th) {
        StringBuilder sb = new StringBuilder();
        sb.append(str2);
        sb.append(10);
        sb.append(Log.getStackTraceString(th));
        println(10, str, sb.toString());
    }

    /* renamed from: i */
    public void mo35338i(String str, String str2) {
        println(4, str, str2);
    }

    /* renamed from: i */
    public void mo35339i(String str, String str2, Throwable th) {
        StringBuilder sb = new StringBuilder();
        sb.append(str2);
        sb.append(10);
        sb.append(Log.getStackTraceString(th));
        println(4, str, sb.toString());
    }

    public abstract void println(int i, String str, String str2);

    /* renamed from: v */
    public void mo35341v(String str, String str2) {
        println(2, str, str2);
    }

    /* renamed from: v */
    public void mo35342v(String str, String str2, Throwable th) {
        StringBuilder sb = new StringBuilder();
        sb.append(str2);
        sb.append(10);
        sb.append(Log.getStackTraceString(th));
        println(2, str, sb.toString());
    }

    /* renamed from: w */
    public void mo35343w(String str, String str2) {
        println(5, str, str2);
    }

    /* renamed from: w */
    public void mo35344w(String str, String str2, Throwable th) {
        StringBuilder sb = new StringBuilder();
        sb.append(str2);
        sb.append(10);
        sb.append(Log.getStackTraceString(th));
        println(5, str, sb.toString());
    }

    public abstract void writeLog(File file, String str);

    public void wtf(String str, String str2) {
        println(7, str, str2);
    }

    public void wtf(String str, String str2, Throwable th) {
        StringBuilder sb = new StringBuilder();
        sb.append(str2);
        sb.append(10);
        sb.append(Log.getStackTraceString(th));
        println(7, str, sb.toString());
    }
}
