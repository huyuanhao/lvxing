package com.alibaba.mtl.appmonitor;

import android.app.Application;
import android.os.RemoteException;
import com.alibaba.mtl.appmonitor.AppMonitorDelegate.C1293a;
import com.alibaba.mtl.appmonitor.AppMonitorDelegate.C1294b;
import com.alibaba.mtl.appmonitor.AppMonitorDelegate.C1295c;
import com.alibaba.mtl.appmonitor.AppMonitorDelegate.C1296d;
import com.alibaba.mtl.appmonitor.IMonitor.C1297a;
import com.alibaba.mtl.appmonitor.model.DimensionSet;
import com.alibaba.mtl.appmonitor.model.DimensionValueSet;
import com.alibaba.mtl.appmonitor.model.MeasureSet;
import com.alibaba.mtl.appmonitor.model.MeasureValueSet;
import com.alibaba.mtl.appmonitor.p068a.EventType;
import com.alibaba.mtl.log.p077d.Logger;
import java.util.Map;

/* renamed from: com.alibaba.mtl.appmonitor.d */
public class Monitor extends C1297a {
    /* renamed from: a */
    private Application f3201a;

    Monitor(Application application) {
        this.f3201a = application;
    }

    /* renamed from: a */
    public void mo11583a() throws RemoteException {
        AppMonitorDelegate.m3367a(this.f3201a);
    }

    /* renamed from: d */
    public void mo11615d() throws RemoteException {
        AppMonitorDelegate.m3365a();
    }

    /* renamed from: b */
    public void mo11606b() throws RemoteException {
        AppMonitorDelegate.m3377b();
    }

    /* renamed from: a */
    public void mo11584a(int i) throws RemoteException {
        AppMonitorDelegate.m3378b(i);
    }

    /* renamed from: a */
    public void mo11603a(boolean z) throws RemoteException {
        AppMonitorDelegate.m3375a(z);
    }

    /* renamed from: a */
    public void mo11585a(int i, int i2) throws RemoteException {
        AppMonitorDelegate.m3368a(m3503k(i), i2);
    }

    /* renamed from: a */
    public void mo11604a(boolean z, String str, String str2, String str3) throws RemoteException {
        AppMonitorDelegate.m3376a(z, str, str2, str3);
    }

    /* renamed from: a */
    public void mo11587a(String str) throws RemoteException {
        AppMonitorDelegate.m3369a(str);
    }

    /* renamed from: a */
    public void mo11602a(Map map) throws RemoteException {
        AppMonitorDelegate.m3374a(map);
    }

    /* renamed from: c */
    public void mo11612c() throws RemoteException {
        AppMonitorDelegate.m3379c();
    }

    /* renamed from: c */
    public void mo11613c(int i) throws RemoteException {
        C1294b.m3387a(i);
    }

    /* renamed from: d */
    public void mo11616d(int i) throws RemoteException {
        C1294b.m3391b(i);
    }

    /* renamed from: a */
    public boolean mo11605a(String str, String str2) throws RemoteException {
        return C1294b.m3390a(str, str2);
    }

    /* renamed from: a */
    public void mo11589a(String str, String str2, double d, Map map) throws RemoteException {
        C1294b.m3388a(str, str2, d, map);
    }

    /* renamed from: a */
    public void mo11597a(String str, String str2, String str3, double d, Map map) throws RemoteException {
        C1294b.m3389a(str, str2, str3, d, map);
    }

    /* renamed from: g */
    public void mo11620g(int i) throws RemoteException {
        C1293a.m3380a(i);
    }

    /* renamed from: h */
    public void mo11621h(int i) throws RemoteException {
        C1293a.m3386b(i);
    }

    /* renamed from: c */
    public boolean mo11614c(String str, String str2) throws RemoteException {
        return C1293a.m3385a(str, str2);
    }

    /* renamed from: a */
    public void mo11601a(String str, String str2, Map map) throws RemoteException {
        C1293a.m3384a(str, str2, map);
    }

    /* renamed from: a */
    public void mo11600a(String str, String str2, String str3, Map map) throws RemoteException {
        C1293a.m3383a(str, str2, str3, map);
    }

    /* renamed from: a */
    public void mo11599a(String str, String str2, String str3, String str4, Map map) throws RemoteException {
        C1293a.m3382a(str, str2, str3, str4, map);
    }

    /* renamed from: a */
    public void mo11598a(String str, String str2, String str3, String str4, String str5, Map map) throws RemoteException {
        C1293a.m3381a(str, str2, str3, str4, str5, map);
    }

    /* renamed from: e */
    public void mo11618e(int i) throws RemoteException {
        C1295c.m3392a(i);
    }

    /* renamed from: f */
    public void mo11619f(int i) throws RemoteException {
        C1295c.m3395b(i);
    }

    /* renamed from: b */
    public boolean mo11611b(String str, String str2) throws RemoteException {
        return C1295c.m3394a(str, str2);
    }

    /* renamed from: a */
    public void mo11588a(String str, String str2, double d) throws RemoteException {
        C1295c.m3393a(str, str2, d);
    }

    /* renamed from: b */
    public void mo11607b(int i) throws RemoteException {
        AppMonitorDelegate.m3366a(i);
    }

    /* renamed from: a */
    public void mo11592a(String str, String str2, MeasureSet measureSet) throws RemoteException {
        AppMonitorDelegate.m3370a(str, str2, measureSet);
    }

    /* renamed from: a */
    public void mo11595a(String str, String str2, MeasureSet measureSet, boolean z) throws RemoteException {
        AppMonitorDelegate.m3373a(str, str2, measureSet, z);
    }

    /* renamed from: a */
    public void mo11593a(String str, String str2, MeasureSet measureSet, DimensionSet dimensionSet) throws RemoteException {
        AppMonitorDelegate.m3371a(str, str2, measureSet, dimensionSet);
    }

    /* renamed from: a */
    public void mo11594a(String str, String str2, MeasureSet measureSet, DimensionSet dimensionSet, boolean z) throws RemoteException {
        AppMonitorDelegate.m3372a(str, str2, measureSet, dimensionSet, z);
    }

    /* renamed from: a */
    public void mo11596a(String str, String str2, String str3) throws RemoteException {
        C1296d.m3400a(str, str2, str3);
    }

    /* renamed from: b */
    public void mo11610b(String str, String str2, String str3) throws RemoteException {
        C1296d.m3403b(str, str2, str3);
    }

    /* renamed from: i */
    public void mo11622i(int i) throws RemoteException {
        C1296d.m3396a(i);
    }

    /* renamed from: j */
    public void mo11623j(int i) throws RemoteException {
        C1296d.m3402b(i);
    }

    /* renamed from: d */
    public boolean mo11617d(String str, String str2) throws RemoteException {
        return C1296d.m3401a(str, str2);
    }

    /* renamed from: b */
    public void mo11609b(String str, String str2, double d, Map map) throws RemoteException {
        C1296d.m3397a(str, str2, d, map);
    }

    /* renamed from: a */
    public void mo11590a(String str, String str2, DimensionValueSet dimensionValueSet, double d, Map map) throws RemoteException {
        C1296d.m3398a(str, str2, dimensionValueSet, d, map);
    }

    /* renamed from: a */
    public void mo11591a(String str, String str2, DimensionValueSet dimensionValueSet, MeasureValueSet measureValueSet, Map map) throws RemoteException {
        Logger.m3833a("Monitor", "[stat_commit3]");
        C1296d.m3399a(str, str2, dimensionValueSet, measureValueSet, map);
    }

    /* renamed from: k */
    private EventType m3503k(int i) {
        return EventType.m3341a(i);
    }

    /* renamed from: a */
    public void mo11586a(Transaction transaction, String str) throws RemoteException {
        TransactionDelegate.m3586a(transaction, str);
    }

    /* renamed from: b */
    public void mo11608b(Transaction transaction, String str) throws RemoteException {
        TransactionDelegate.m3587b(transaction, str);
    }
}
