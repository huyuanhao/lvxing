package epco;

import java.util.Date;

/* renamed from: epco.b */
public class C7949b {
    /* renamed from: a */
    public final String f26995a;
    /* renamed from: b */
    public final String f26996b;
    /* renamed from: c */
    public final Date f26997c;
    /* renamed from: d */
    public final Date f26998d;
    /* renamed from: e */
    public final byte[] f26999e;
    /* renamed from: f */
    public final String f27000f;
    /* renamed from: g */
    public final String f27001g;

    /* renamed from: epco.b$b */
    public static final class C7951b {
        /* access modifiers changed from: private */
        /* renamed from: a */
        public String f27002a;
        /* access modifiers changed from: private */
        /* renamed from: b */
        public String f27003b;
        /* access modifiers changed from: private */
        /* renamed from: c */
        public Date f27004c;
        /* access modifiers changed from: private */
        /* renamed from: d */
        public Date f27005d;
        /* access modifiers changed from: private */
        /* renamed from: e */
        public byte[] f27006e;
        /* access modifiers changed from: private */
        /* renamed from: f */
        public String f27007f;
        /* access modifiers changed from: private */
        /* renamed from: g */
        public String f27008g;

        private C7951b() {
        }

        /* renamed from: a */
        public C7951b mo38258a(String str) {
            this.f27007f = str;
            return this;
        }

        /* renamed from: a */
        public C7951b mo38259a(Date date) {
            this.f27005d = date;
            return this;
        }

        /* renamed from: a */
        public C7951b mo38260a(byte[] bArr) {
            this.f27006e = bArr;
            return this;
        }

        /* renamed from: a */
        public C7949b mo38261a() {
            return new C7949b(this);
        }

        /* renamed from: b */
        public C7951b mo38262b(String str) {
            this.f27008g = str;
            return this;
        }

        /* renamed from: b */
        public C7951b mo38263b(Date date) {
            this.f27004c = date;
            return this;
        }

        /* renamed from: c */
        public C7951b mo38264c(String str) {
            this.f27002a = str;
            return this;
        }

        /* renamed from: d */
        public C7951b mo38265d(String str) {
            this.f27003b = str;
            return this;
        }
    }

    private C7949b(C7951b bVar) {
        this.f26995a = bVar.f27002a;
        this.f26996b = bVar.f27003b;
        this.f26997c = bVar.f27004c;
        this.f26998d = bVar.f27005d;
        this.f26999e = bVar.f27006e;
        this.f27000f = bVar.f27007f;
        this.f27001g = bVar.f27008g;
    }

    /* renamed from: a */
    public static C7951b m34382a() {
        return new C7951b();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("signAlgorithm:\t");
        sb.append(this.f26995a);
        sb.append(10);
        sb.append("certBase64Md5:\t");
        sb.append(this.f27000f);
        sb.append(10);
        sb.append("certMd5:\t");
        sb.append(this.f27001g);
        return sb.toString();
    }
}
