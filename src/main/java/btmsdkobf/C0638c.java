package btmsdkobf;

import android.content.Context;
import com.p522qq.taf.jce.JceStruct;
import com.tmsdk.module.coin.TMSDKContext;

/* renamed from: btmsdkobf.c */
public class C0638c {
    /* renamed from: a */
    private static boolean f373a = false;

    /* renamed from: btmsdkobf.c$a */
    public interface C0640a {
        /* renamed from: i */
        void mo9160i();
    }

    /* renamed from: a */
    public static void m74a(int i, int i2) {
        StringBuilder sb = new StringBuilder();
        sb.append("saveActionData, modelId:[");
        sb.append(i);
        sb.append("]errorCode:[");
        sb.append(i2);
        sb.append("]");
        C0848ff.m905d("TMSDKBaseContext", sb.toString());
        C0654cn.m96a(i, i2);
    }

    /* renamed from: a */
    public static void m75a(int i, JceStruct jceStruct, JceStruct jceStruct2, int i2, final C0611b bVar, long j) {
        StringBuilder sb = new StringBuilder();
        sb.append("guid:[");
        sb.append(C0670cx.m165al().getGuid());
        sb.append("]sendShark, cmdId:[");
        int i3 = i;
        sb.append(i);
        sb.append("]timeout:[");
        sb.append(j);
        sb.append("]");
        String str = "TMSDKBaseContext";
        C0848ff.m905d(str, sb.toString());
        if (jceStruct == null) {
            C0848ff.m908w(str, "req == null");
            return;
        }
        C0611b bVar2 = bVar;
        C0670cx.m165al().mo9214a(i, jceStruct, jceStruct2, i2, new C0693dj() {
            /* renamed from: a */
            public void mo9159a(int i, int i2, int i3, int i4, JceStruct jceStruct) {
                StringBuilder sb = new StringBuilder();
                sb.append("onFinish, cmdId:[");
                sb.append(i2);
                sb.append("]retCode:[");
                sb.append(i3);
                sb.append("]dataRetCode:[");
                sb.append(i4);
                sb.append("]");
                C0848ff.m908w("TMSDKBaseContext", sb.toString());
                if (i3 == 0 && i4 == 0) {
                    i3 = 0;
                }
                int i5 = i3 % 20 == -4 ? -102 : i3 != 0 ? TMSDKContext.S_ERR_UNKNOWN : i4 != 0 ? -101 : i3;
                C0611b bVar = bVar;
                if (bVar != null) {
                    bVar.mo9158a(i, i2, i5, i4, jceStruct);
                }
            }
        }, j);
    }

    /* renamed from: a */
    public static void m76a(int i, String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("SaveStringData, modelId:[");
        sb.append(i);
        sb.append("]msg:[");
        sb.append(str);
        sb.append("]");
        C0848ff.m905d("TMSDKBaseContext", sb.toString());
        C0654cn.m97a(i, str);
    }

    /* renamed from: a */
    public static void m77a(Context context) {
        C0652cl.m88a(context);
    }

    /* renamed from: a */
    public static synchronized boolean m78a(Context context, C0562a aVar) {
        synchronized (C0638c.class) {
            if (f373a) {
                C0848ff.m905d("TMSDKBaseContext", "has initialized, return true");
                return true;
            }
            f373a = C0652cl.m89a(context, aVar);
            StringBuilder sb = new StringBuilder();
            sb.append("init, aContext:[");
            sb.append(context);
            sb.append("]aTMSConfig:[");
            sb.append(aVar);
            sb.append("]ret:[");
            sb.append(f373a);
            sb.append("]");
            C0848ff.m905d("TMSDKBaseContext", sb.toString());
            boolean z = f373a;
            return z;
        }
    }

    public static void addUrgentTask(Runnable runnable, String str) {
        C0845fd.m898cN().addUrgentTask(runnable, str);
    }

    /* renamed from: c */
    public static String m79c() {
        return C0652cl.m90c();
    }

    public static boolean checkLicence() {
        return C0652cl.checkLicence();
    }

    /* renamed from: g */
    public static void m80g() {
    }

    public static Context getApplicationContext() {
        return C0652cl.m85D();
    }

    public static String getGuid() {
        return C0670cx.m165al().getGuid();
    }

    /* renamed from: h */
    public static void m81h() {
    }

    public static boolean isInitialized() {
        return f373a;
    }

    public static void saveActionData(int i) {
        StringBuilder sb = new StringBuilder();
        sb.append("saveActionData, modelId:[");
        sb.append(i);
        sb.append("]");
        C0848ff.m905d("TMSDKBaseContext", sb.toString());
        C0654cn.saveActionData(i);
    }

    public static void setAutoConnectionSwitch(Context context, boolean z) {
        StringBuilder sb = new StringBuilder();
        sb.append("setAutoConnectionSwitch, aContext:[");
        sb.append(context);
        sb.append("]aAutoConnection:[");
        sb.append(z);
        sb.append("]");
        C0848ff.m905d("TMSDKBaseContext", sb.toString());
        C0652cl.setAutoConnectionSwitch(context, z);
    }

    public static void setCurrentLang(int i) {
        C0843fb.m895cM().putInt("c_l", i);
    }

    public static void setLogEnable(boolean z) {
        C0848ff.setLogEnable(z);
    }
}
