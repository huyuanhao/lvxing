package mtopsdk.common.util;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IInterface;
import android.text.TextUtils;
import mtopsdk.common.util.TBSdkLog.LogEnable;

/* renamed from: mtopsdk.common.util.a */
public abstract class AsyncServiceBinder<T extends IInterface> {
    /* renamed from: a */
    protected volatile T f27834a;
    /* renamed from: b */
    Class<? extends IInterface> f27835b;
    /* renamed from: c */
    Class<? extends Service> f27836c;
    /* renamed from: d */
    String f27837d;
    /* renamed from: e */
    volatile boolean f27838e;
    /* renamed from: f */
    volatile boolean f27839f;
    /* renamed from: g */
    private ServiceConnection f27840g;

    /* renamed from: a */
    public void mo39743a(Context context) {
        if (this.f27834a == null && context != null && !this.f27838e && !this.f27839f) {
            String str = "mtopsdk.AsyncServiceBinder";
            if (TBSdkLog.m35509b(LogEnable.InfoEnable)) {
                StringBuilder sb = new StringBuilder("[asyncBind] mContext=");
                sb.append(context);
                sb.append(",mBindFailed= ");
                sb.append(this.f27838e);
                sb.append(",mBinding=");
                sb.append(this.f27839f);
                TBSdkLog.m35506b(str, sb.toString());
            }
            this.f27839f = true;
            try {
                if (TextUtils.isEmpty(this.f27837d)) {
                    this.f27837d = this.f27835b.getSimpleName();
                }
                if (TBSdkLog.m35509b(LogEnable.InfoEnable)) {
                    StringBuilder sb2 = new StringBuilder("[asyncBind]try to bind service for ");
                    sb2.append(this.f27837d);
                    TBSdkLog.m35506b(str, sb2.toString());
                }
                Intent intent = new Intent(context.getApplicationContext(), this.f27836c);
                intent.setAction(this.f27835b.getName());
                intent.setPackage(context.getPackageName());
                intent.addCategory("android.intent.category.DEFAULT");
                boolean bindService = context.bindService(intent, this.f27840g, 1);
                if (TBSdkLog.m35509b(LogEnable.InfoEnable)) {
                    StringBuilder sb3 = new StringBuilder("[asyncBind]use intent bind service ret=");
                    sb3.append(bindService);
                    sb3.append(" for interfaceName=");
                    sb3.append(this.f27837d);
                    TBSdkLog.m35506b(str, sb3.toString());
                }
                this.f27838e = !bindService;
            } catch (Throwable th) {
                this.f27838e = true;
                StringBuilder sb4 = new StringBuilder("[asyncBind] use intent bind service failed. mBindFailed=");
                sb4.append(this.f27838e);
                sb4.append(",interfaceName = ");
                sb4.append(this.f27837d);
                TBSdkLog.m35504a(str, sb4.toString(), th);
            }
            if (this.f27838e) {
                this.f27839f = false;
            }
        }
    }

    /* renamed from: a */
    public T mo39742a() {
        return this.f27834a;
    }
}
