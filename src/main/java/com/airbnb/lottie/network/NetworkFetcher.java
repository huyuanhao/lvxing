package com.airbnb.lottie.network;

import android.content.Context;
import androidx.core.util.Pair;
import com.airbnb.lottie.L;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieCompositionFactory;
import com.airbnb.lottie.LottieResult;
import com.airbnb.lottie.LottieTask;
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

/* renamed from: com.airbnb.lottie.network.b */
public class NetworkFetcher {
    /* renamed from: a */
    private final Context f1770a;
    /* renamed from: b */
    private final String f1771b;
    /* renamed from: c */
    private final NetworkCache f1772c;

    /* renamed from: a */
    public static LottieTask<LottieComposition> m1744a(Context context, String str) {
        return new NetworkFetcher(context, str).m1745b();
    }

    private NetworkFetcher(Context context, String str) {
        this.f1770a = context.getApplicationContext();
        this.f1771b = str;
        this.f1772c = new NetworkCache(this.f1770a, str);
    }

    /* renamed from: b */
    private LottieTask<LottieComposition> m1745b() {
        return new LottieTask<>(new Callable<LottieResult<LottieComposition>>() {
            /* renamed from: a */
            public LottieResult<LottieComposition> call() throws Exception {
                return NetworkFetcher.this.mo10173a();
            }
        });
    }

    /* renamed from: a */
    public LottieResult<LottieComposition> mo10173a() {
        LottieComposition c = m1746c();
        if (c != null) {
            return new LottieResult<>(c);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Animation for ");
        sb.append(this.f1771b);
        sb.append(" not found in cache. Fetching from network.");
        L.m1313a(sb.toString());
        return m1747d();
    }

    /* renamed from: c */
    private LottieComposition m1746c() {
        LottieResult iVar;
        Pair a = this.f1772c.mo10170a();
        if (a == null) {
            return null;
        }
        FileExtension fileExtension = (FileExtension) a.first;
        InputStream inputStream = (InputStream) a.second;
        if (fileExtension == FileExtension.Zip) {
            iVar = LottieCompositionFactory.m1462a(new ZipInputStream(inputStream), this.f1771b);
        } else {
            iVar = LottieCompositionFactory.m1460a(inputStream, this.f1771b);
        }
        if (iVar.mo9995a() != null) {
            return (LottieComposition) iVar.mo9995a();
        }
        return null;
    }

    /* renamed from: d */
    private LottieResult<LottieComposition> m1747d() {
        try {
            return m1748e();
        } catch (IOException e) {
            return new LottieResult<>((Throwable) e);
        }
    }

    /* renamed from: e */
    private LottieResult m1748e() throws IOException {
        FileExtension fileExtension;
        LottieResult iVar;
        StringBuilder sb = new StringBuilder();
        sb.append("Fetching ");
        sb.append(this.f1771b);
        L.m1313a(sb.toString());
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(this.f1771b).openConnection();
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
                L.m1313a("Received json response.");
                fileExtension = FileExtension.Json;
                iVar = LottieCompositionFactory.m1460a((InputStream) new FileInputStream(new File(this.f1772c.mo10171a(httpURLConnection.getInputStream(), fileExtension).getAbsolutePath())), this.f1771b);
            } else {
                L.m1313a("Handling zip response.");
                fileExtension = FileExtension.Zip;
                iVar = LottieCompositionFactory.m1462a(new ZipInputStream(new FileInputStream(this.f1772c.mo10171a(httpURLConnection.getInputStream(), fileExtension))), this.f1771b);
            }
            if (iVar.mo9995a() != null) {
                this.f1772c.mo10172a(fileExtension);
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Completed fetch from network. Success: ");
            if (iVar.mo9995a() == null) {
                z = false;
            }
            sb2.append(z);
            L.m1313a(sb2.toString());
            return iVar;
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
                sb4.append(this.f1771b);
                sb4.append(". Failed with ");
                sb4.append(httpURLConnection.getResponseCode());
                sb4.append("\n");
                sb4.append(sb3);
                return new LottieResult((Throwable) new IllegalArgumentException(sb4.toString()));
            }
        }
    }
}
