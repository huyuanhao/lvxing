package mtopsdk.common.util;

/* renamed from: mtopsdk.common.util.e */
public class LocalConfig {
    /* renamed from: g */
    private static LocalConfig f27873g;
    /* renamed from: a */
    public boolean f27874a = true;
    /* renamed from: b */
    public boolean f27875b = true;
    /* renamed from: c */
    public boolean f27876c = true;
    @Deprecated
    /* renamed from: d */
    public boolean f27877d = true;
    /* renamed from: e */
    public boolean f27878e = true;
    /* renamed from: f */
    public boolean f27879f = true;

    /* renamed from: a */
    public static LocalConfig m35526a() {
        if (f27873g == null) {
            synchronized (LocalConfig.class) {
                if (f27873g == null) {
                    f27873g = new LocalConfig();
                }
            }
        }
        return f27873g;
    }
}
