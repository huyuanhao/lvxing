package okhttp3.internal.http2;

import java.io.IOException;
import java.util.List;
import okio.C8529e;

/* compiled from: PushObserver */
/* renamed from: okhttp3.internal.http2.j */
public interface C8485j {
    /* renamed from: a */
    public static final C8485j f28817a = new C8485j() {
        /* renamed from: a */
        public void mo40445a(int i, ErrorCode errorCode) {
        }

        /* renamed from: a */
        public boolean mo40446a(int i, List<C8453a> list) {
            return true;
        }

        /* renamed from: a */
        public boolean mo40447a(int i, List<C8453a> list, boolean z) {
            return true;
        }

        /* renamed from: a */
        public boolean mo40448a(int i, C8529e eVar, int i2, boolean z) throws IOException {
            eVar.mo40761h((long) i2);
            return true;
        }
    };

    /* renamed from: a */
    void mo40445a(int i, ErrorCode errorCode);

    /* renamed from: a */
    boolean mo40446a(int i, List<C8453a> list);

    /* renamed from: a */
    boolean mo40447a(int i, List<C8453a> list, boolean z);

    /* renamed from: a */
    boolean mo40448a(int i, C8529e eVar, int i2, boolean z) throws IOException;
}
