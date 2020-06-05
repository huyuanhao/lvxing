package btmsdkobf;

import java.io.InputStream;

/* renamed from: btmsdkobf.eq */
public abstract class C0815eq {

    /* renamed from: btmsdkobf.eq$a */
    public interface C0816a {
        /* renamed from: a */
        void mo9498a(boolean z, int i, int i2);
    }

    /* renamed from: btmsdkobf.eq$b */
    public static class C0817b {
        /* renamed from: nc */
        private int f911nc;
        /* renamed from: nd */
        private int f912nd;
        /* renamed from: ne */
        private String f913ne;

        public C0817b() {
        }

        public C0817b(String str, int i) {
            this.f913ne = str;
            this.f912nd = i;
        }

        public C0817b(String str, int i, int i2) {
            this.f911nc = i2;
            this.f913ne = str;
            this.f912nd = i;
        }

        /* access modifiers changed from: protected */
        public Object clone() {
            return new C0817b(this.f913ne, this.f912nd, this.f911nc);
        }

        /* renamed from: cu */
        public String mo9500cu() {
            return this.f913ne;
        }

        public boolean equals(Object obj) {
            if (obj == null) {
                return false;
            }
            C0817b bVar = (C0817b) obj;
            return bVar.f913ne.equals(this.f913ne) && bVar.f912nd == this.f912nd;
        }

        public int getPort() {
            return this.f912nd;
        }

        public int hashCode() {
            return super.hashCode();
        }

        public String toString() {
            if (this.f912nd < 0) {
                return this.f913ne;
            }
            StringBuilder sb = new StringBuilder();
            sb.append(this.f913ne);
            sb.append(":");
            sb.append(this.f912nd);
            return sb.toString();
        }
    }

    /* renamed from: a */
    public static byte[] m821a(InputStream inputStream, int i, int i2, C0816a aVar) {
        byte[] bArr = new byte[i2];
        int i3 = i;
        int i4 = i2;
        int i5 = 0;
        while (true) {
            if (i5 >= i2 || i4 <= 0) {
                break;
            }
            int read = inputStream.read(bArr, i3, i4);
            if (read > 0) {
                i5 += read;
                i3 += read;
                i4 -= read;
                if (aVar != null) {
                    aVar.mo9498a(false, i5, i2);
                }
            } else if (aVar != null) {
                aVar.mo9498a(true, i5, i2);
            }
        }
        if (i5 != i2) {
            return null;
        }
        return bArr;
    }
}
