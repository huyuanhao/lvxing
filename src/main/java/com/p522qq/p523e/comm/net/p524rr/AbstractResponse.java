package com.p522qq.p523e.comm.net.p524rr;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;

/* renamed from: com.qq.e.comm.net.rr.AbstractResponse */
public abstract class AbstractResponse implements Response {
    /* renamed from: a */
    private final HttpURLConnection f20288a;
    /* renamed from: b */
    private int f20289b = 0;

    public AbstractResponse(HttpURLConnection httpURLConnection) {
        if (httpURLConnection != null) {
            this.f20288a = httpURLConnection;
            try {
                this.f20289b = this.f20288a.getResponseCode();
            } catch (IOException e) {
                throw new AssertionError(e);
            }
        } else {
            throw new AssertionError("AbstractResponse parameter is null");
        }
    }

    public void close() throws IllegalStateException, IOException {
        this.f20288a.disconnect();
    }

    public byte[] getBytesContent() throws IllegalStateException, IOException {
        if (200 != getStatusCode()) {
            return null;
        }
        InputStream streamContent = getStreamContent();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[1024];
        while (true) {
            int read = streamContent.read(bArr);
            if (read > 0) {
                byteArrayOutputStream.write(bArr, 0, read);
            } else {
                streamContent.close();
                return byteArrayOutputStream.toByteArray();
            }
        }
    }

    public int getStatusCode() {
        return this.f20289b;
    }

    public InputStream getStreamContent() throws IllegalStateException, IOException {
        return this.f20288a.getInputStream();
    }

    public String getStringContent() throws IOException {
        return getStringContent("UTF-8");
    }

    public String getStringContent(String str) throws IOException {
        byte[] bytesContent = getBytesContent();
        String str2 = null;
        if (bytesContent == null) {
            return null;
        }
        if (bytesContent.length == 0) {
            return "";
        }
        try {
            str2 = this.f20288a.getContentEncoding();
        } catch (Throwable unused) {
        }
        if (str2 != null) {
            str = str2;
        }
        return new String(bytesContent, str);
    }
}
