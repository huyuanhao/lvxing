package btmsdkobf;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import btmsdkobf.C0675da.C0676a;
import btmsdkobf.C0718dy.C0738f;
import com.tencent.p605ep.common.adapt.iservice.net.ESharkCode;
import java.util.LinkedList;
import java.util.concurrent.atomic.AtomicReference;

/* renamed from: btmsdkobf.db */
public class C0677db {
    /* access modifiers changed from: private|static */
    public static String TAG = "HttpNetworkManager";
    /* access modifiers changed from: private|final */
    /* renamed from: R */
    public final Object f475R = new Object();
    /* access modifiers changed from: private */
    /* renamed from: gZ */
    public C0695dl f476gZ;
    /* access modifiers changed from: private */
    /* renamed from: ha */
    public C0814ep f477ha;
    /* access modifiers changed from: private */
    /* renamed from: hd */
    public boolean f478hd = false;
    /* access modifiers changed from: private */
    /* renamed from: he */
    public int f479he = 0;
    /* access modifiers changed from: private */
    /* renamed from: hf */
    public LinkedList<C0681a> f480hf = new LinkedList<>();
    /* access modifiers changed from: private */
    public Context mContext;
    /* access modifiers changed from: private */
    public Handler mHandler = new Handler(C0716dx.getLooper()) {
        public void handleMessage(Message message) {
            if (message.what == 1) {
                synchronized (C0677db.this.f475R) {
                    if (C0677db.this.f479he < 4) {
                        C0681a aVar = (C0681a) C0677db.this.f480hf.poll();
                        if (aVar != null) {
                            String aL = C0677db.TAG;
                            StringBuilder sb = new StringBuilder();
                            sb.append("[http_control]handleMessage(), allow start, running tasks: ");
                            sb.append(C0677db.this.f479he);
                            C0849fg.m914i(aL, sb.toString());
                            C0677db.this.f479he = C0677db.this.f479he + 1;
                            C0677db.this.m234b(aVar.f491hn, aVar.f489fo, aVar.f492ho);
                        } else {
                            String aL2 = C0677db.TAG;
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append("[http_control]handleMessage(), allow start but no data to send, running tasks: ");
                            sb2.append(C0677db.this.f479he);
                            C0849fg.m911d(aL2, sb2.toString());
                        }
                    } else {
                        String aL3 = C0677db.TAG;
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append("[http_control]handleMessage(), not allow start, running tasks(>=4): ");
                        sb3.append(C0677db.this.f479he);
                        C0849fg.m916w(aL3, sb3.toString());
                    }
                }
            }
        }
    };

    /* renamed from: btmsdkobf.db$a */
    private class C0681a {
        /* renamed from: fo */
        public byte[] f489fo = null;
        /* renamed from: hn */
        public C0738f f491hn = null;
        /* renamed from: ho */
        public C0676a f492ho = null;

        public C0681a(byte[] bArr, C0738f fVar, C0676a aVar) {
            this.f489fo = bArr;
            this.f491hn = fVar;
            this.f492ho = aVar;
        }
    }

    public C0677db(Context context, C0695dl dlVar, C0814ep epVar, boolean z) {
        this.mContext = context;
        this.f476gZ = dlVar;
        this.f477ha = epVar;
        this.f478hd = z;
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m234b(final C0738f fVar, final byte[] bArr, final C0676a aVar) {
        C06792 r0 = new Runnable() {
            public void run() {
                final int i;
                AtomicReference atomicReference = new AtomicReference();
                try {
                    i = new C0675da(C0677db.this.mContext, C0677db.this.f476gZ, C0677db.this.f477ha, C0677db.this.f478hd).mo9259a(fVar, bArr, atomicReference);
                } catch (Throwable th) {
                    C0849fg.m913e(C0677db.TAG, "sendDataAsyn(), exception:", th);
                    i = ESharkCode.ERR_SHARK_SEND_EXCEPTION;
                }
                final byte[] bArr = (byte[]) atomicReference.get();
                C06801 r2 = new Runnable() {
                    public void run() {
                        if (aVar != null) {
                            aVar.mo9260a(i, bArr);
                        }
                    }
                };
                C0845fd cN = C0845fd.m898cN();
                if (C0716dx.m429as()) {
                    cN.addUrgentTask(r2, "shark-http-callback");
                } else {
                    cN.addTask(r2, "shark-http-callback");
                }
                synchronized (C0677db.this.f475R) {
                    C0677db.this.f479he = C0677db.this.f479he - 1;
                    if (C0677db.this.f480hf.size() > 0) {
                        C0677db.this.mHandler.sendEmptyMessage(1);
                    }
                    String aL = C0677db.TAG;
                    StringBuilder sb = new StringBuilder();
                    sb.append("[http_control]-------- send finish, running tasks: ");
                    sb.append(C0677db.this.f479he);
                    sb.append(", waiting tasks: ");
                    sb.append(C0677db.this.f480hf.size());
                    C0849fg.m911d(aL, sb.toString());
                }
            }
        };
        C0845fd cN = C0845fd.m898cN();
        String str = "shark-http-send";
        if (C0716dx.m429as()) {
            cN.addUrgentTask(r0, str);
        } else {
            cN.addTask(r0, str);
        }
    }

    /* renamed from: a */
    public void mo9261a(C0738f fVar, byte[] bArr, C0676a aVar) {
        synchronized (this.f475R) {
            this.f480hf.add(new C0681a(bArr, fVar, aVar));
            String str = TAG;
            StringBuilder sb = new StringBuilder();
            sb.append("[http_control]sendDataAsyn(), waiting tasks: ");
            sb.append(this.f480hf.size());
            C0849fg.m915v(str, sb.toString());
        }
        this.mHandler.sendEmptyMessage(1);
    }
}
