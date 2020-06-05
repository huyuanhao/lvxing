package btmsdkobf;

import android.content.Context;
import android.os.HandlerThread;

/* renamed from: btmsdkobf.fl */
public class C0855fl implements C0866fr {
    /* renamed from: op */
    private C0856fm f999op;

    public C0855fl(Context context) {
        this.f999op = new C0856fm(context);
    }

    /* renamed from: a */
    public HandlerThread mo9574a(String str, int i, long j) {
        return this.f999op.mo9577a(str, i, j);
    }

    /* renamed from: a */
    public void mo9575a(Runnable runnable, String str, long j) {
        this.f999op.mo9579a(runnable, str, j, false, null);
    }

    /* renamed from: b */
    public void mo9576b(Runnable runnable, String str, long j) {
        this.f999op.mo9580b(runnable, str, j, false, null);
    }
}
