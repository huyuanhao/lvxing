package com.bytedance.sdk.p145a.p147b.p148a.p153e;

import com.bytedance.sdk.p145a.p146a.BufferedSource;
import java.io.IOException;
import java.util.List;

/* renamed from: com.bytedance.sdk.a.b.a.e.m */
public interface PushObserver {
    /* renamed from: a */
    public static final PushObserver f5649a = new PushObserver() {
        /* renamed from: a */
        public void mo13851a(int i, ErrorCode bVar) {
        }

        /* renamed from: a */
        public boolean mo13853a(int i, List<Header> list) {
            return true;
        }

        /* renamed from: a */
        public boolean mo13854a(int i, List<Header> list, boolean z) {
            return true;
        }

        /* renamed from: a */
        public boolean mo13852a(int i, BufferedSource eVar, int i2, boolean z) throws IOException {
            eVar.mo13556h((long) i2);
            return true;
        }
    };

    /* renamed from: a */
    void mo13851a(int i, ErrorCode bVar);

    /* renamed from: a */
    boolean mo13852a(int i, BufferedSource eVar, int i2, boolean z) throws IOException;

    /* renamed from: a */
    boolean mo13853a(int i, List<Header> list);

    /* renamed from: a */
    boolean mo13854a(int i, List<Header> list, boolean z);
}
