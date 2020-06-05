package com.tencent.qqpim.discovery;

import android.content.Context;
import com.tencent.p605ep.common.adapt.ServiceCenter;
import com.tencent.p605ep.common.adapt.iservice.IReportService;
import com.tencent.p605ep.common.adapt.iservice.net.ISharkService;
import com.tencent.qqpim.discovery.internal.protocol.GDTSDKReportItem;
import discoveryAD.C7852Aa;
import discoveryAD.C7855C;
import discoveryAD.C7855C.C7856a;
import discoveryAD.C7875Q;
import discoveryAD.C7929sa;
import discoveryAD.C7935va;
import java.util.List;

public class DiscoverySdk {
    public static String TAG = "DiscoverySdk";
    /* renamed from: dc */
    private static DiscoverySdk f25047dc = null;
    /* renamed from: ec */
    private static boolean f25048ec = true;
    public static boolean sForbidAd = false;
    /* renamed from: fc */
    private int f25049fc;
    /* renamed from: gc */
    private Context f25050gc;
    /* renamed from: hc */
    private C7855C f25051hc;
    /* renamed from: ic */
    private C7875Q f25052ic;

    private DiscoverySdk(Context context, int i) {
        StringBuilder sb = new StringBuilder();
        sb.append("init sdk : ");
        sb.append(i);
        C7852Aa.m34150L(sb.toString());
        this.f25049fc = i;
        this.f25050gc = context;
        this.f25051hc = new C7855C(context);
        this.f25052ic = new C7875Q(context);
    }

    public static DiscoverySdk getInstance() {
        if (f25047dc == null) {
            throw new NullPointerException("please call sdkInitialize() firstly!!");
        } else if (ServiceCenter.get(ISharkService.class) == null) {
            throw new NullPointerException("please instantiate ep-adapt ISharkService  firstly!!");
        } else if (ServiceCenter.get(IReportService.class) != null) {
            return f25047dc;
        } else {
            throw new NullPointerException("please instantiate ep-adapt IReportService  firstly!!");
        }
    }

    public static boolean isDownLoadSupport() {
        return f25048ec;
    }

    public static boolean isInitialized() {
        return f25047dc != null;
    }

    public static boolean isVipMode() {
        return false;
    }

    public static synchronized void sdkInitialize(Context context, int i) {
        synchronized (DiscoverySdk.class) {
            if (f25047dc == null) {
                f25047dc = new DiscoverySdk(context, i);
                C7935va.m34357mb();
            }
        }
    }

    public static void setDownLoadSupport(boolean z) {
        f25048ec = z;
    }

    public int getAPPID() {
        return this.f25049fc;
    }

    public Context getApplicationContext() {
        return this.f25050gc;
    }

    public C7855C getCacheMgr() {
        return this.f25051hc;
    }

    public Context getContext() {
        return this.f25050gc;
    }

    public IH5Browser getIH5Manager() {
        return this.f25052ic;
    }

    public void reportGDTSDK(GDTSDKReportItem gDTSDKReportItem) {
        C7929sa.m34338a(gDTSDKReportItem);
    }

    public void setIConchService(IConch iConch) {
    }

    public void setIH5Browser(IH5Browser iH5Browser) {
        this.f25052ic.mo38150a(iH5Browser);
    }

    public void testAdRequestlist(List<AdRequestData> list, AbsAdCallback absAdCallback) {
        getCacheMgr().mo38114a(list, 0, (C7856a) absAdCallback);
    }
}
