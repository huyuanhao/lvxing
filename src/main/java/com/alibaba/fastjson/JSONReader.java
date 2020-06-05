package com.alibaba.fastjson;

import com.alibaba.fastjson.parser.DefaultJSONParser;
import java.io.Closeable;

/* renamed from: com.alibaba.fastjson.e */
public class JSONReader implements Closeable {
    /* renamed from: a */
    private final DefaultJSONParser f2680a;

    public void close() {
        this.f2680a.close();
    }
}
