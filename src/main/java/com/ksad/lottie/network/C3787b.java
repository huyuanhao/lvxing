package com.ksad.lottie.network;

import android.content.Context;
import androidx.core.util.Pair;
import com.ksad.lottie.C3665c;
import com.ksad.lottie.C3703d;
import com.ksad.lottie.C3710e;
import com.ksad.lottie.C3734j;
import com.ksad.lottie.C3735k;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.Callable;
import java.util.zip.ZipInputStream;

/* renamed from: com.ksad.lottie.network.b */
public class C3787b {
    /* renamed from: a */
    private final Context f12907a;
    /* renamed from: b */
    private final String f12908b;
    /* renamed from: c */
    private final C3786a f12909c;

    private C3787b(Context context, String str) {
        this.f12907a = context.getApplicationContext();
        this.f12908b = str;
        this.f12909c = new C3786a(this.f12907a, str);
    }

    /* renamed from: a */
    public static C3735k<C3703d> m15715a(Context context, String str) {
        return new C3787b(context, str).m15716b();
    }

    /* renamed from: b */
    private C3735k<C3703d> m15716b() {
        return new C3735k<>(new Callable<C3734j<C3703d>>() {
            /* renamed from: a */
            public C3734j<C3703d> call() {
                return C3787b.this.mo23181a();
            }
        });
    }

    /* renamed from: c */
    private C3703d m15717c() {
        Pair a = this.f12909c.mo23178a();
        if (a == null) {
            return null;
        }
        FileExtension fileExtension = (FileExtension) a.first;
        InputStream inputStream = (InputStream) a.second;
        C3734j a2 = fileExtension == FileExtension.Zip ? C3710e.m15398a(new ZipInputStream(inputStream), this.f12908b) : C3710e.m15396a(inputStream, this.f12908b);
        if (a2.mo23014a() != null) {
            return (C3703d) a2.mo23014a();
        }
        return null;
    }

    /* renamed from: d */
    private C3734j<C3703d> m15718d() {
        try {
            return m15719e();
        } catch (IOException e) {
            return new C3734j<>((Throwable) e);
        }
    }

    /* renamed from: e */
    private C3734j m15719e() {
        FileExtension fileExtension;
        C3734j jVar;
        StringBuilder sb = new StringBuilder();
        sb.append("Fetching ");
        sb.append(this.f12908b);
        C3665c.m15250a(sb.toString());
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(this.f12908b).openConnection();
        httpURLConnection.setRequestMethod("GET");
        httpURLConnection.connect();
        if (httpURLConnection.getErrorStream() == null && httpURLConnection.getResponseCode() == 200) {
            String contentType = httpURLConnection.getContentType();
            char c = 65535;
            int hashCode = contentType.hashCode();
            boolean z = true;
            if (hashCode != -1248325150) {
                if (hashCode == -43840953 && contentType.equals("application/json")) {
                    c = 1;
                }
            } else if (contentType.equals("application/zip")) {
                c = 0;
            }
            if (c != 0) {
                C3665c.m15250a("Received json response.");
                fileExtension = FileExtension.Json;
                jVar = C3710e.m15396a((InputStream) new FileInputStream(new File(this.f12909c.mo23179a(httpURLConnection.getInputStream(), fileExtension).getAbsolutePath())), this.f12908b);
            } else {
                C3665c.m15250a("Handling zip response.");
                fileExtension = FileExtension.Zip;
                jVar = C3710e.m15398a(new ZipInputStream(new FileInputStream(this.f12909c.mo23179a(httpURLConnection.getInputStream(), fileExtension))), this.f12908b);
            }
            if (jVar.mo23014a() != null) {
                this.f12909c.mo23180a(fileExtension);
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Completed fetch from network. Success: ");
            if (jVar.mo23014a() == null) {
                z = false;
            }
            sb2.append(z);
            C3665c.m15250a(sb2.toString());
            return jVar;
        }
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getErrorStream()));
        StringBuilder sb3 = new StringBuilder();
        while (true) {
            String readLine = bufferedReader.readLine();
            if (readLine != null) {
                sb3.append(readLine);
                sb3.append(10);
            } else {
                StringBuilder sb4 = new StringBuilder();
                sb4.append("Unable to fetch ");
                sb4.append(this.f12908b);
                sb4.append(". Failed with ");
                sb4.append(httpURLConnection.getResponseCode());
                sb4.append("\n");
                sb4.append(sb3);
                return new C3734j((Throwable) new IllegalArgumentException(sb4.toString()));
            }
        }
    }

    /* renamed from: a */
    public C3734j<C3703d> mo23181a() {
        C3703d c = m15717c();
        if (c != null) {
            return new C3734j<>(c);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Animation for ");
        sb.append(this.f12908b);
        sb.append(" not found in cache. Fetching from network.");
        C3665c.m15250a(sb.toString());
        return m15718d();
    }
}
