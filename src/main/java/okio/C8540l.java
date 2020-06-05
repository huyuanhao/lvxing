package okio;

import android.support.p000v4.media.session.PlaybackStateCompat;
import java.io.IOException;
import java.nio.ByteBuffer;

/* compiled from: RealBufferedSink */
/* renamed from: okio.l */
final class C8540l implements C8528d {
    /* renamed from: a */
    public final C8525c f29039a = new C8525c();
    /* renamed from: b */
    public final C8546q f29040b;
    /* renamed from: c */
    boolean f29041c;

    C8540l(C8546q qVar) {
        if (qVar != null) {
            this.f29040b = qVar;
            return;
        }
        throw new NullPointerException("sink == null");
    }

    /* renamed from: c */
    public C8525c mo40741c() {
        return this.f29039a;
    }

    /* renamed from: a_ */
    public void mo40231a_(C8525c cVar, long j) throws IOException {
        if (!this.f29041c) {
            this.f29039a.mo40231a_(cVar, j);
            mo40787x();
            return;
        }
        throw new IllegalStateException("closed");
    }

    /* renamed from: b */
    public C8528d mo40739b(ByteString byteString) throws IOException {
        if (!this.f29041c) {
            this.f29039a.mo40739b(byteString);
            return mo40787x();
        }
        throw new IllegalStateException("closed");
    }

    /* renamed from: b */
    public C8528d mo40738b(String str) throws IOException {
        if (!this.f29041c) {
            this.f29039a.mo40738b(str);
            return mo40787x();
        }
        throw new IllegalStateException("closed");
    }

    /* renamed from: c */
    public C8528d mo40743c(byte[] bArr) throws IOException {
        if (!this.f29041c) {
            this.f29039a.mo40743c(bArr);
            return mo40787x();
        }
        throw new IllegalStateException("closed");
    }

    /* renamed from: c */
    public C8528d mo40744c(byte[] bArr, int i, int i2) throws IOException {
        if (!this.f29041c) {
            this.f29039a.mo40744c(bArr, i, i2);
            return mo40787x();
        }
        throw new IllegalStateException("closed");
    }

    public int write(ByteBuffer byteBuffer) throws IOException {
        if (!this.f29041c) {
            int write = this.f29039a.write(byteBuffer);
            mo40787x();
            return write;
        }
        throw new IllegalStateException("closed");
    }

    /* renamed from: a */
    public long mo40719a(C8547r rVar) throws IOException {
        if (rVar != null) {
            long j = 0;
            while (true) {
                long a = rVar.mo40202a(this.f29039a, PlaybackStateCompat.ACTION_PLAY_FROM_URI);
                if (a == -1) {
                    return j;
                }
                j += a;
                mo40787x();
            }
        } else {
            throw new IllegalArgumentException("source == null");
        }
    }

    /* renamed from: i */
    public C8528d mo40765i(int i) throws IOException {
        if (!this.f29041c) {
            this.f29039a.mo40765i(i);
            return mo40787x();
        }
        throw new IllegalStateException("closed");
    }

    /* renamed from: h */
    public C8528d mo40760h(int i) throws IOException {
        if (!this.f29041c) {
            this.f29039a.mo40760h(i);
            return mo40787x();
        }
        throw new IllegalStateException("closed");
    }

    /* renamed from: g */
    public C8528d mo40757g(int i) throws IOException {
        if (!this.f29041c) {
            this.f29039a.mo40757g(i);
            return mo40787x();
        }
        throw new IllegalStateException("closed");
    }

    /* renamed from: l */
    public C8528d mo40771l(long j) throws IOException {
        if (!this.f29041c) {
            this.f29039a.mo40771l(j);
            return mo40787x();
        }
        throw new IllegalStateException("closed");
    }

    /* renamed from: k */
    public C8528d mo40770k(long j) throws IOException {
        if (!this.f29041c) {
            this.f29039a.mo40770k(j);
            return mo40787x();
        }
        throw new IllegalStateException("closed");
    }

    /* renamed from: x */
    public C8528d mo40787x() throws IOException {
        if (!this.f29041c) {
            long h = this.f29039a.mo40759h();
            if (h > 0) {
                this.f29040b.mo40231a_(this.f29039a, h);
            }
            return this;
        }
        throw new IllegalStateException("closed");
    }

    public void flush() throws IOException {
        if (!this.f29041c) {
            if (this.f29039a.f29018b > 0) {
                C8546q qVar = this.f29040b;
                C8525c cVar = this.f29039a;
                qVar.mo40231a_(cVar, cVar.f29018b);
            }
            this.f29040b.flush();
            return;
        }
        throw new IllegalStateException("closed");
    }

    public boolean isOpen() {
        return !this.f29041c;
    }

    public void close() throws IOException {
        if (!this.f29041c) {
            Throwable th = null;
            try {
                if (this.f29039a.f29018b > 0) {
                    this.f29040b.mo40231a_(this.f29039a, this.f29039a.f29018b);
                }
            } catch (Throwable th2) {
                th = th2;
            }
            try {
                this.f29040b.close();
            } catch (Throwable th3) {
                if (th == null) {
                    th = th3;
                }
            }
            this.f29041c = true;
            if (th != null) {
                C8550t.m36939a(th);
            }
        }
    }

    /* renamed from: a */
    public C8548s mo40271a() {
        return this.f29040b.mo40271a();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("buffer(");
        sb.append(this.f29040b);
        sb.append(")");
        return sb.toString();
    }
}
