package com.alibaba.fastjson;

import com.alibaba.fastjson.serializer.SerializeWriter;
import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;

/* renamed from: com.alibaba.fastjson.g */
public class JSONWriter implements Closeable, Flushable {
    /* renamed from: a */
    private SerializeWriter f2681a;

    public void flush() throws IOException {
        this.f2681a.flush();
    }

    public void close() throws IOException {
        this.f2681a.close();
    }
}
