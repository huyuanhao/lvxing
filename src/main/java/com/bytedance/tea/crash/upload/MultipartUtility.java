package com.bytedance.tea.crash.upload;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.zip.GZIPOutputStream;

/* renamed from: com.bytedance.tea.crash.upload.e */
public class MultipartUtility {
    /* renamed from: a */
    private final String f9409a;
    /* renamed from: b */
    private HttpURLConnection f9410b;
    /* renamed from: c */
    private String f9411c;
    /* renamed from: d */
    private boolean f9412d;
    /* renamed from: e */
    private DataOutputStream f9413e;
    /* renamed from: f */
    private GZIPOutputStream f9414f;

    MultipartUtility(String str, String str2, boolean z) throws IOException {
        this.f9411c = str2;
        this.f9412d = z;
        StringBuilder sb = new StringBuilder();
        String str3 = "AAA";
        sb.append(str3);
        sb.append(System.currentTimeMillis());
        sb.append(str3);
        this.f9409a = sb.toString();
        this.f9410b = (HttpURLConnection) new URL(str).openConnection();
        this.f9410b.setUseCaches(false);
        this.f9410b.setDoOutput(true);
        this.f9410b.setDoInput(true);
        this.f9410b.setRequestMethod("POST");
        HttpURLConnection httpURLConnection = this.f9410b;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("multipart/form-data; boundary=");
        sb2.append(this.f9409a);
        httpURLConnection.setRequestProperty("Content-Type", sb2.toString());
        if (z) {
            this.f9410b.setRequestProperty("Content-Encoding", "gzip");
            this.f9414f = new GZIPOutputStream(this.f9410b.getOutputStream());
            return;
        }
        this.f9413e = new DataOutputStream(this.f9410b.getOutputStream());
    }

    /* renamed from: a */
    public void mo17082a(String str, String str2) {
        StringBuilder sb = new StringBuilder();
        sb.append("--");
        sb.append(this.f9409a);
        String str3 = "\r\n";
        sb.append(str3);
        sb.append("Content-Disposition: form-data; name=\"");
        sb.append(str);
        sb.append("\"");
        sb.append(str3);
        sb.append("Content-Type: text/plain; charset=");
        sb.append(this.f9411c);
        sb.append(str3);
        sb.append(str3);
        sb.append(str2);
        sb.append(str3);
        try {
            if (this.f9412d) {
                this.f9414f.write(sb.toString().getBytes());
            } else {
                this.f9413e.write(sb.toString().getBytes());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /* renamed from: a */
    public void mo17081a(String str, File file) throws IOException {
        String name = file.getName();
        StringBuilder sb = new StringBuilder();
        sb.append("--");
        sb.append(this.f9409a);
        String str2 = "\r\n";
        sb.append(str2);
        sb.append("Content-Disposition: form-data; name=\"");
        sb.append(str);
        sb.append("\"; filename=\"");
        sb.append(name);
        sb.append("\"");
        sb.append(str2);
        sb.append("Content-Transfer-Encoding: binary");
        sb.append(str2);
        sb.append(str2);
        if (this.f9412d) {
            this.f9414f.write(sb.toString().getBytes());
        } else {
            this.f9413e.write(sb.toString().getBytes());
        }
        FileInputStream fileInputStream = new FileInputStream(file);
        byte[] bArr = new byte[8192];
        while (true) {
            int read = fileInputStream.read(bArr);
            if (read == -1) {
                break;
            } else if (this.f9412d) {
                this.f9414f.write(bArr, 0, read);
            } else {
                this.f9413e.write(bArr, 0, read);
            }
        }
        fileInputStream.close();
        if (this.f9412d) {
            this.f9414f.write(str2.getBytes());
            return;
        }
        this.f9413e.write(sb.toString().getBytes());
        this.f9413e.flush();
    }

    /* renamed from: a */
    public String mo17080a() throws IOException {
        ArrayList<String> arrayList = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        sb.append("\r\n--");
        sb.append(this.f9409a);
        sb.append("--");
        sb.append("\r\n");
        byte[] bytes = sb.toString().getBytes();
        if (this.f9412d) {
            this.f9414f.write(bytes);
            this.f9414f.finish();
            this.f9414f.close();
        } else {
            this.f9413e.write(bytes);
            this.f9413e.flush();
            this.f9413e.close();
        }
        int responseCode = this.f9410b.getResponseCode();
        if (responseCode == 200) {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(this.f9410b.getInputStream()));
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                }
                arrayList.add(readLine);
            }
            bufferedReader.close();
            this.f9410b.disconnect();
            StringBuilder sb2 = new StringBuilder();
            for (String append : arrayList) {
                sb2.append(append);
            }
            return sb2.toString();
        }
        StringBuilder sb3 = new StringBuilder();
        sb3.append("Server returned non-OK status: ");
        sb3.append(responseCode);
        throw new IOException(sb3.toString());
    }
}
