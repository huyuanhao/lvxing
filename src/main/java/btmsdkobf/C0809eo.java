package btmsdkobf;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;

/* renamed from: btmsdkobf.eo */
public class C0809eo {
    private Context mContext = null;
    private Handler mHandler = new Handler(C0716dx.getLooper()) {
        public void handleMessage(Message message) {
            C0849fg.m911d("HeartBeatPlot", "[h_b]handleMessage(), nodifyOnHeartBeat()");
        }
    };
    /* renamed from: mW */
    private boolean f905mW = false;
    /* renamed from: mX */
    private C0811a f906mX = null;
    /* renamed from: mY */
    private long f907mY = 0;
    /* renamed from: mZ */
    private C0813c f908mZ = null;
    /* renamed from: na */
    private C0812b f909na = null;

    /* renamed from: btmsdkobf.eo$a */
    private class C0811a extends BroadcastReceiver {
        public void onReceive(Context context, Intent intent) {
        }
    }

    /* renamed from: btmsdkobf.eo$b */
    public interface C0812b {
    }

    /* renamed from: btmsdkobf.eo$c */
    public interface C0813c {
    }

    public C0809eo(Context context, C0813c cVar, C0812b bVar) {
        this.mContext = context;
        this.f908mZ = cVar;
        this.f909na = bVar;
    }

    public synchronized void reset() {
        C0849fg.m911d("HeartBeatPlot", "[h_b]reset()");
    }

    public synchronized void start() {
    }

    public synchronized void stop() {
        C0849fg.m911d("HeartBeatPlot", "[h_b]stop()");
    }
}
