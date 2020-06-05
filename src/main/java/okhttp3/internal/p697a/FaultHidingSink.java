package okhttp3.internal.p697a;

import java.io.IOException;
import okio.C8525c;
import okio.C8530f;
import okio.C8546q;

/* renamed from: okhttp3.internal.a.e */
class FaultHidingSink extends C8530f {
    /* renamed from: a */
    private boolean f28496a;

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo40220a(IOException iOException) {
    }

    FaultHidingSink(C8546q qVar) {
        super(qVar);
    }

    /* renamed from: a_ */
    public void mo40231a_(C8525c cVar, long j) throws IOException {
        if (this.f28496a) {
            cVar.mo40761h(j);
            return;
        }
        try {
            super.mo40231a_(cVar, j);
        } catch (IOException e) {
            this.f28496a = true;
            mo40220a(e);
        }
    }

    public void flush() throws IOException {
        if (!this.f28496a) {
            try {
                super.flush();
            } catch (IOException e) {
                this.f28496a = true;
                mo40220a(e);
            }
        }
    }

    public void close() throws IOException {
        if (!this.f28496a) {
            try {
                super.close();
            } catch (IOException e) {
                this.f28496a = true;
                mo40220a(e);
            }
        }
    }
}
