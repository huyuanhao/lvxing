package shanhuAD;

import com.tencent.p605ep.shanhuad.adpublic.ADError;
import java.util.HashMap;
import java.util.Map;

/* renamed from: shanhuAD.a */
public class C8675a {
    /* renamed from: ak */
    public static final int f29512ak = 100;
    /* renamed from: bk */
    public static final int f29513bk = 101;
    /* renamed from: ck */
    public static Map<Integer, ADError> f29514ck = new HashMap();

    static {
        f29514ck.put(Integer.valueOf(100), new ADError(100, "no AD data back"));
        f29514ck.put(Integer.valueOf(101), new ADError(101, "gdt error : "));
    }
}
