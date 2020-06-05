package com.alibaba.fastjson.util;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Set;

/* renamed from: com.alibaba.fastjson.util.h */
public class ServiceLoader {
    /* renamed from: a */
    private static final Set<String> f3055a = new HashSet();

    /* renamed from: a */
    public static <T> Set<T> m3214a(Class<T> cls, ClassLoader classLoader) {
        if (classLoader == null) {
            return Collections.emptySet();
        }
        HashSet hashSet = new HashSet();
        String name = cls.getName();
        StringBuilder sb = new StringBuilder();
        sb.append("META-INF/services/");
        sb.append(name);
        String sb2 = sb.toString();
        HashSet<String> hashSet2 = new HashSet<>();
        try {
            Enumeration resources = classLoader.getResources(sb2);
            while (resources.hasMoreElements()) {
                URL url = (URL) resources.nextElement();
                if (!f3055a.contains(url.toString())) {
                    m3215a(url, (Set<String>) hashSet2);
                    f3055a.add(url.toString());
                }
            }
        } catch (IOException unused) {
        }
        for (String loadClass : hashSet2) {
            try {
                hashSet.add(classLoader.loadClass(loadClass).newInstance());
            } catch (Exception unused2) {
            }
        }
        return hashSet;
    }

    /* renamed from: a */
    public static void m3215a(URL url, Set<String> set) throws IOException {
        InputStream inputStream;
        BufferedReader bufferedReader = null;
        try {
            inputStream = url.openStream();
            try {
                BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(inputStream, "utf-8"));
                while (true) {
                    try {
                        String readLine = bufferedReader2.readLine();
                        if (readLine == null) {
                            IOUtils.m3194a((Closeable) bufferedReader2);
                            IOUtils.m3194a((Closeable) inputStream);
                            return;
                        }
                        int indexOf = readLine.indexOf(35);
                        if (indexOf >= 0) {
                            readLine = readLine.substring(0, indexOf);
                        }
                        String trim = readLine.trim();
                        if (trim.length() != 0) {
                            set.add(trim);
                        }
                    } catch (Throwable th) {
                        th = th;
                        bufferedReader = bufferedReader2;
                        IOUtils.m3194a((Closeable) bufferedReader);
                        IOUtils.m3194a((Closeable) inputStream);
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                IOUtils.m3194a((Closeable) bufferedReader);
                IOUtils.m3194a((Closeable) inputStream);
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            inputStream = null;
            IOUtils.m3194a((Closeable) bufferedReader);
            IOUtils.m3194a((Closeable) inputStream);
            throw th;
        }
    }
}
