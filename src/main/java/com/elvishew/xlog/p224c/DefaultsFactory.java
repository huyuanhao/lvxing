package com.elvishew.xlog.p224c;

import android.content.Intent;
import android.os.Bundle;
import com.elvishew.xlog.formatter.p227a.BorderFormatter;
import com.elvishew.xlog.formatter.p227a.DefaultBorderFormatter;
import com.elvishew.xlog.formatter.p228b.p229a.DefaultJsonFormatter;
import com.elvishew.xlog.formatter.p228b.p229a.JsonFormatter;
import com.elvishew.xlog.formatter.p228b.p230b.BundleFormatter;
import com.elvishew.xlog.formatter.p228b.p230b.C2608c;
import com.elvishew.xlog.formatter.p228b.p230b.IntentFormatter;
import com.elvishew.xlog.formatter.p228b.p231c.DefaultThrowableFormatter;
import com.elvishew.xlog.formatter.p228b.p231c.ThrowableFormatter;
import com.elvishew.xlog.formatter.p228b.p232d.DefaultXmlFormatter;
import com.elvishew.xlog.formatter.p228b.p232d.XmlFormatter;
import com.elvishew.xlog.formatter.p233c.DefaultStackTraceFormatter;
import com.elvishew.xlog.formatter.p233c.StackTraceFormatter;
import com.elvishew.xlog.formatter.p234d.DefaultThreadFormatter;
import com.elvishew.xlog.formatter.p234d.ThreadFormatter;
import com.elvishew.xlog.p222a.DefaultFlattener;
import com.elvishew.xlog.p222a.Flattener;
import com.elvishew.xlog.p226d.Printer;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.elvishew.xlog.c.a */
public class DefaultsFactory {
    /* renamed from: a */
    private static final Map<Class<?>, C2608c<?>> f9453a;

    static {
        HashMap hashMap = new HashMap();
        hashMap.put(Bundle.class, new BundleFormatter());
        hashMap.put(Intent.class, new IntentFormatter());
        f9453a = Collections.unmodifiableMap(hashMap);
    }

    /* renamed from: a */
    public static JsonFormatter m12652a() {
        return new DefaultJsonFormatter();
    }

    /* renamed from: b */
    public static XmlFormatter m12653b() {
        return new DefaultXmlFormatter();
    }

    /* renamed from: c */
    public static ThrowableFormatter m12654c() {
        return new DefaultThrowableFormatter();
    }

    /* renamed from: d */
    public static ThreadFormatter m12655d() {
        return new DefaultThreadFormatter();
    }

    /* renamed from: e */
    public static StackTraceFormatter m12656e() {
        return new DefaultStackTraceFormatter();
    }

    /* renamed from: f */
    public static BorderFormatter m12657f() {
        return new DefaultBorderFormatter();
    }

    /* renamed from: g */
    public static Flattener m12658g() {
        return new DefaultFlattener();
    }

    /* renamed from: h */
    public static Printer m12659h() {
        return C2605b.m12670a().mo17093c();
    }

    /* renamed from: i */
    public static Map<Class<?>, C2608c<?>> m12660i() {
        return f9453a;
    }
}
