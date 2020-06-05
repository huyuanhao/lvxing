package btmsdkobf;

/* renamed from: btmsdkobf.du */
public class C0709du {
    /* renamed from: io */
    private static C0692di f553io;
    /* renamed from: ip */
    private static C0692di f554ip;
    /* renamed from: iq */
    private static C0711b f555iq;

    /* renamed from: btmsdkobf.du$a */
    public static class C0710a implements C0692di {
        /* renamed from: R */
        private Object f556R = new Object();
        /* renamed from: ir */
        private int f557ir = 1;

        /* renamed from: bf */
        public int mo9293bf() {
            int i;
            synchronized (this.f556R) {
                i = this.f557ir;
                this.f557ir++;
            }
            return i;
        }
    }

    /* renamed from: btmsdkobf.du$b */
    public static class C0711b {
        /* renamed from: R */
        private final Object f558R = new Object();
        /* renamed from: is */
        private byte f559is = 0;

        /* renamed from: bq */
        public byte mo9312bq() {
            byte b;
            synchronized (this.f558R) {
                if (this.f559is + 1 == 127) {
                    this.f559is = 0;
                }
                b = (byte) (this.f559is + 1);
                this.f559is = b;
            }
            return b;
        }
    }

    /* renamed from: bn */
    public static C0692di m406bn() {
        if (f553io == null) {
            synchronized (C0709du.class) {
                if (f553io == null) {
                    f553io = new C0710a();
                }
            }
        }
        return f553io;
    }

    /* renamed from: bo */
    public static C0692di m407bo() {
        if (f554ip == null) {
            synchronized (C0709du.class) {
                if (f554ip == null) {
                    f554ip = new C0710a();
                }
            }
        }
        return f554ip;
    }

    /* renamed from: bp */
    public static C0711b m408bp() {
        if (f555iq == null) {
            synchronized (C0709du.class) {
                if (f555iq == null) {
                    f555iq = new C0711b();
                }
            }
        }
        return f555iq;
    }
}
