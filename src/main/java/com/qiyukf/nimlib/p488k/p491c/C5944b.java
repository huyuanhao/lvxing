package com.qiyukf.nimlib.p488k.p491c;

/* renamed from: com.qiyukf.nimlib.k.c.b */
public enum C5944b {
    TYPE_LOG(C5945a.f18774c),
    TYPE_TEMP(C5945a.f18775d),
    TYPE_FILE(C5945a.f18773b),
    TYPE_AUDIO(C5945a.f18772a),
    TYPE_IMAGE(C5945a.f18776e),
    TYPE_VIDEO(C5945a.f18778g),
    TYPE_THUMB_IMAGE(C5945a.f18777f);
    
    /* renamed from: h */
    private C5945a f18770h;
    /* renamed from: i */
    private long f18771i;

    /* renamed from: com.qiyukf.nimlib.k.c.b$a */
    enum C5945a {
        /* renamed from: a */
        public static final C5945a f18772a = null;
        /* renamed from: b */
        public static final C5945a f18773b = null;
        /* renamed from: c */
        public static final C5945a f18774c = null;
        /* renamed from: d */
        public static final C5945a f18775d = null;
        /* renamed from: e */
        public static final C5945a f18776e = null;
        /* renamed from: f */
        public static final C5945a f18777f = null;
        /* renamed from: g */
        public static final C5945a f18778g = null;
        /* renamed from: i */
        private static final /* synthetic */ C5945a[] f18779i = null;
        /* renamed from: h */
        private final String f18780h;

        static {
            f18772a = new C5945a("AUDIO_DIRECTORY_NAME", 0, "audio/");
            f18773b = new C5945a("FILE_DIRECTORY_NAME", 1, "file/");
            f18774c = new C5945a("LOG_DIRECTORY_NAME", 2, "log/");
            f18775d = new C5945a("TEMP_DIRECTORY_NAME", 3, "temp/");
            f18776e = new C5945a("IMAGE_DIRECTORY_NAME", 4, "image/");
            f18777f = new C5945a("THUMB_DIRECTORY_NAME", 5, "thumb/");
            f18778g = new C5945a("VIDEO_DIRECTORY_NAME", 6, "video/");
            f18779i = new C5945a[]{f18772a, f18773b, f18774c, f18775d, f18776e, f18777f, f18778g};
        }

        private C5945a(String str, int i, String str2) {
            this.f18780h = str2;
        }

        public static C5945a valueOf(String str) {
            return (C5945a) Enum.valueOf(C5945a.class, str);
        }

        public static C5945a[] values() {
            return (C5945a[]) f18779i.clone();
        }

        /* renamed from: a */
        public final String mo28382a() {
            return this.f18780h;
        }
    }

    private C5944b(C5945a aVar) {
        this(r2, r3, aVar, 0);
    }

    private C5944b(C5945a aVar, byte b) {
        this.f18770h = aVar;
        this.f18771i = 20971520;
    }

    /* renamed from: a */
    public final String mo28380a() {
        return this.f18770h.mo28382a();
    }

    /* renamed from: b */
    public final long mo28381b() {
        return this.f18771i;
    }
}
