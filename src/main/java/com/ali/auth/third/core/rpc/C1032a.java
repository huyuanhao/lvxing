package com.ali.auth.third.core.rpc;

import com.ali.auth.third.core.p033j.C1018a;
import com.ali.auth.third.core.util.C1038c;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

/* renamed from: com.ali.auth.third.core.rpc.a */
public class C1032a extends C1033b {
    /* renamed from: a */
    private static final String f2077a = C1032a.class.getSimpleName();

    /* renamed from: a */
    public static String m1972a(String str) {
        HttpURLConnection httpURLConnection;
        OutputStreamWriter outputStreamWriter;
        Throwable th;
        String str2 = f2077a;
        StringBuilder sb = new StringBuilder();
        sb.append("get url = ");
        sb.append(str);
        C1018a.m1964b(str2, sb.toString());
        try {
            httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            try {
                httpURLConnection.setDoInput(true);
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setRequestMethod("GET");
                httpURLConnection.setUseCaches(false);
                httpURLConnection.setConnectTimeout(15000);
                httpURLConnection.setReadTimeout(15000);
                outputStreamWriter = new OutputStreamWriter(httpURLConnection.getOutputStream());
            } catch (Throwable th2) {
                Throwable th3 = th2;
                outputStreamWriter = null;
                th = th3;
                try {
                    throw new RuntimeException(th);
                } catch (Throwable th4) {
                    C1038c.m1988a(outputStreamWriter);
                    if (httpURLConnection != null) {
                        try {
                            httpURLConnection.disconnect();
                        } catch (Exception unused) {
                        }
                    }
                    throw th4;
                }
            }
            try {
                outputStreamWriter.flush();
                if (httpURLConnection.getResponseCode() == 200) {
                    String byteArrayOutputStream = m1973a(httpURLConnection.getInputStream()).toString(m1974b(httpURLConnection.getContentType()));
                    C1038c.m1988a(outputStreamWriter);
                    if (httpURLConnection != null) {
                        try {
                            httpURLConnection.disconnect();
                        } catch (Exception unused2) {
                        }
                    }
                    return byteArrayOutputStream;
                }
                StringBuilder sb2 = new StringBuilder();
                sb2.append("http request exception, response code: ");
                sb2.append(httpURLConnection.getResponseCode());
                throw new RuntimeException(sb2.toString());
            } catch (Throwable th5) {
                th = th5;
                throw new RuntimeException(th);
            }
        } catch (Throwable th6) {
            outputStreamWriter = null;
            th = th6;
            httpURLConnection = null;
            throw new RuntimeException(th);
        }
    }
}
