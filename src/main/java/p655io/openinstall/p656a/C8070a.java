package p655io.openinstall.p656a;

import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import com.p235fm.openinstall.p239d.C2621b;

/* renamed from: io.openinstall.a.a */
public abstract class C8070a extends Handler {
    /* renamed from: a */
    public void mo38815a(Uri uri, C2621b bVar) {
        Message obtain = Message.obtain();
        obtain.what = 2;
        obtain.obj = new C8071b(uri, null, bVar);
        sendMessage(obtain);
    }
}
