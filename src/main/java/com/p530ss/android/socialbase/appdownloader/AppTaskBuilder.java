package com.p530ss.android.socialbase.appdownloader;

import android.app.Activity;
import android.content.Context;
import com.p530ss.android.socialbase.appdownloader.p552c.IAppDownloadEventListener;
import com.p530ss.android.socialbase.downloader.downloader.IChunkAdjustCalculator;
import com.p530ss.android.socialbase.downloader.downloader.IChunkCntCalculator;
import com.p530ss.android.socialbase.downloader.downloader.IRetryDelayTimeCalculator;
import com.p530ss.android.socialbase.downloader.notification.AbsNotificationItem;
import com.p530ss.android.socialbase.downloader.p557b.EnqueueType;
import com.p530ss.android.socialbase.downloader.p559d.IDownloadDepend;
import com.p530ss.android.socialbase.downloader.p559d.IDownloadDiskSpaceHandler;
import com.p530ss.android.socialbase.downloader.p559d.IDownloadFileUriProvider;
import com.p530ss.android.socialbase.downloader.p559d.IDownloadListener;
import com.p530ss.android.socialbase.downloader.p559d.IDownloadMonitorDepend;
import com.p530ss.android.socialbase.downloader.p559d.INotificationClickCallback;
import com.p530ss.android.socialbase.downloader.p562g.HttpHeader;
import com.tencent.bugly.beta.tinker.TinkerReport;
import java.util.List;
import org.json.JSONObject;

/* renamed from: com.ss.android.socialbase.appdownloader.g */
public class AppTaskBuilder {
    /* renamed from: A */
    private int f21574A = 5;
    /* renamed from: B */
    private int f21575B;
    /* renamed from: C */
    private boolean f21576C;
    /* renamed from: D */
    private String f21577D;
    /* renamed from: E */
    private boolean f21578E;
    /* renamed from: F */
    private boolean f21579F;
    /* renamed from: G */
    private boolean f21580G;
    /* renamed from: H */
    private boolean f21581H;
    /* renamed from: I */
    private EnqueueType f21582I = EnqueueType.ENQUEUE_NONE;
    /* renamed from: J */
    private int f21583J = TinkerReport.KEY_APPLIED_PACKAGE_CHECK_SIGNATURE;
    /* renamed from: K */
    private int f21584K;
    /* renamed from: L */
    private boolean f21585L = true;
    /* renamed from: M */
    private IDownloadMonitorDepend f21586M;
    /* renamed from: N */
    private IDownloadDepend f21587N;
    /* renamed from: O */
    private IAppDownloadEventListener f21588O;
    /* renamed from: P */
    private IDownloadFileUriProvider f21589P;
    /* renamed from: Q */
    private IDownloadDiskSpaceHandler f21590Q;
    /* renamed from: R */
    private boolean f21591R;
    /* renamed from: S */
    private INotificationClickCallback f21592S;
    /* renamed from: T */
    private boolean f21593T;
    /* renamed from: U */
    private JSONObject f21594U;
    /* renamed from: a */
    private Activity f21595a;
    /* renamed from: b */
    private Context f21596b;
    /* renamed from: c */
    private String f21597c;
    /* renamed from: d */
    private List<String> f21598d;
    /* renamed from: e */
    private String f21599e;
    /* renamed from: f */
    private String f21600f;
    /* renamed from: g */
    private String f21601g;
    /* renamed from: h */
    private List<HttpHeader> f21602h;
    /* renamed from: i */
    private boolean f21603i = true;
    /* renamed from: j */
    private boolean f21604j = false;
    /* renamed from: k */
    private boolean f21605k = true;
    /* renamed from: l */
    private boolean f21606l = false;
    /* renamed from: m */
    private IDownloadListener f21607m;
    /* renamed from: n */
    private IDownloadListener f21608n;
    /* renamed from: o */
    private String f21609o;
    /* renamed from: p */
    private String f21610p = "application/vnd.android.package-archive";
    /* renamed from: q */
    private boolean f21611q;
    /* renamed from: r */
    private IChunkAdjustCalculator f21612r;
    /* renamed from: s */
    private IChunkCntCalculator f21613s;
    /* renamed from: t */
    private IRetryDelayTimeCalculator f21614t;
    /* renamed from: u */
    private AbsNotificationItem f21615u;
    /* renamed from: v */
    private boolean f21616v;
    /* renamed from: w */
    private boolean f21617w;
    /* renamed from: x */
    private String f21618x;
    /* renamed from: y */
    private String f21619y;
    /* renamed from: z */
    private boolean f21620z;

    public AppTaskBuilder(Context context, String str) {
        this.f21596b = context.getApplicationContext();
        this.f21597c = str;
    }

    /* renamed from: a */
    public Activity mo31558a() {
        return this.f21595a;
    }

    /* renamed from: b */
    public Context mo31570b() {
        return this.f21596b;
    }

    /* renamed from: c */
    public String mo31578c() {
        return this.f21597c;
    }

    /* renamed from: d */
    public String mo31582d() {
        return this.f21599e;
    }

    /* renamed from: e */
    public String mo31585e() {
        return this.f21601g;
    }

    /* renamed from: f */
    public List<HttpHeader> mo31588f() {
        return this.f21602h;
    }

    /* renamed from: g */
    public boolean mo31591g() {
        return this.f21603i;
    }

    /* renamed from: h */
    public boolean mo31594h() {
        return this.f21604j;
    }

    /* renamed from: i */
    public boolean mo31596i() {
        return this.f21605k;
    }

    /* renamed from: j */
    public boolean mo31598j() {
        return this.f21606l;
    }

    /* renamed from: k */
    public IDownloadListener mo31600k() {
        return this.f21607m;
    }

    /* renamed from: l */
    public IDownloadListener mo31602l() {
        return this.f21608n;
    }

    /* renamed from: m */
    public String mo31604m() {
        return this.f21609o;
    }

    /* renamed from: n */
    public String mo31606n() {
        return this.f21610p;
    }

    /* renamed from: o */
    public boolean mo31607o() {
        return this.f21611q;
    }

    /* renamed from: p */
    public AbsNotificationItem mo31608p() {
        return this.f21615u;
    }

    /* renamed from: q */
    public IChunkCntCalculator mo31609q() {
        return this.f21613s;
    }

    /* renamed from: r */
    public IChunkAdjustCalculator mo31610r() {
        return this.f21612r;
    }

    /* renamed from: s */
    public boolean mo31611s() {
        return this.f21616v;
    }

    /* renamed from: t */
    public boolean mo31612t() {
        return this.f21617w;
    }

    /* renamed from: u */
    public String mo31613u() {
        return this.f21618x;
    }

    /* renamed from: v */
    public String mo31614v() {
        return this.f21619y;
    }

    /* renamed from: w */
    public int mo31615w() {
        return this.f21574A;
    }

    /* renamed from: x */
    public int mo31616x() {
        return this.f21575B;
    }

    /* renamed from: y */
    public boolean mo31617y() {
        return this.f21576C;
    }

    /* renamed from: z */
    public String mo31618z() {
        return this.f21577D;
    }

    /* renamed from: A */
    public boolean mo31537A() {
        return this.f21578E;
    }

    /* renamed from: B */
    public boolean mo31538B() {
        return this.f21579F;
    }

    /* renamed from: C */
    public IRetryDelayTimeCalculator mo31539C() {
        return this.f21614t;
    }

    /* renamed from: D */
    public int mo31540D() {
        return this.f21583J;
    }

    /* renamed from: E */
    public int mo31541E() {
        return this.f21584K;
    }

    /* renamed from: F */
    public boolean mo31542F() {
        return this.f21580G;
    }

    /* renamed from: G */
    public boolean mo31543G() {
        return this.f21581H;
    }

    /* renamed from: H */
    public boolean mo31544H() {
        return this.f21585L;
    }

    /* renamed from: I */
    public boolean mo31545I() {
        return this.f21591R;
    }

    /* renamed from: J */
    public EnqueueType mo31546J() {
        return this.f21582I;
    }

    /* renamed from: K */
    public boolean mo31547K() {
        return this.f21620z;
    }

    /* renamed from: L */
    public String mo31548L() {
        return this.f21600f;
    }

    /* renamed from: M */
    public IDownloadMonitorDepend mo31549M() {
        return this.f21586M;
    }

    /* renamed from: N */
    public IDownloadDepend mo31550N() {
        return this.f21587N;
    }

    /* renamed from: O */
    public IAppDownloadEventListener mo31551O() {
        return this.f21588O;
    }

    /* renamed from: P */
    public IDownloadFileUriProvider mo31552P() {
        return this.f21589P;
    }

    /* renamed from: Q */
    public INotificationClickCallback mo31553Q() {
        return this.f21592S;
    }

    /* renamed from: R */
    public boolean mo31554R() {
        return this.f21593T;
    }

    /* renamed from: a */
    public AppTaskBuilder mo31566a(String str) {
        this.f21599e = str;
        return this;
    }

    /* renamed from: b */
    public AppTaskBuilder mo31572b(String str) {
        this.f21600f = str;
        return this;
    }

    /* renamed from: c */
    public AppTaskBuilder mo31576c(String str) {
        this.f21601g = str;
        return this;
    }

    /* renamed from: a */
    public AppTaskBuilder mo31567a(List<HttpHeader> list) {
        this.f21602h = list;
        return this;
    }

    /* renamed from: a */
    public AppTaskBuilder mo31569a(boolean z) {
        this.f21603i = z;
        return this;
    }

    /* renamed from: b */
    public AppTaskBuilder mo31574b(boolean z) {
        this.f21604j = z;
        return this;
    }

    /* renamed from: c */
    public AppTaskBuilder mo31577c(boolean z) {
        this.f21606l = z;
        return this;
    }

    /* renamed from: a */
    public AppTaskBuilder mo31561a(IDownloadListener adVar) {
        this.f21607m = adVar;
        return this;
    }

    /* renamed from: d */
    public AppTaskBuilder mo31580d(String str) {
        this.f21609o = str;
        return this;
    }

    /* renamed from: e */
    public AppTaskBuilder mo31583e(String str) {
        this.f21610p = str;
        return this;
    }

    /* renamed from: d */
    public AppTaskBuilder mo31581d(boolean z) {
        this.f21611q = z;
        return this;
    }

    /* renamed from: a */
    public AppTaskBuilder mo31565a(IChunkCntCalculator iVar) {
        this.f21613s = iVar;
        return this;
    }

    /* renamed from: a */
    public AppTaskBuilder mo31564a(IChunkAdjustCalculator hVar) {
        this.f21612r = hVar;
        return this;
    }

    /* renamed from: e */
    public AppTaskBuilder mo31584e(boolean z) {
        this.f21616v = z;
        return this;
    }

    /* renamed from: f */
    public AppTaskBuilder mo31587f(boolean z) {
        this.f21617w = z;
        return this;
    }

    /* renamed from: f */
    public AppTaskBuilder mo31586f(String str) {
        this.f21618x = str;
        return this;
    }

    /* renamed from: g */
    public AppTaskBuilder mo31589g(String str) {
        this.f21619y = str;
        return this;
    }

    /* renamed from: a */
    public AppTaskBuilder mo31559a(int i) {
        this.f21574A = i;
        return this;
    }

    /* renamed from: b */
    public AppTaskBuilder mo31571b(int i) {
        this.f21575B = i;
        return this;
    }

    /* renamed from: g */
    public AppTaskBuilder mo31590g(boolean z) {
        this.f21576C = z;
        return this;
    }

    /* renamed from: h */
    public AppTaskBuilder mo31592h(String str) {
        this.f21577D = str;
        return this;
    }

    /* renamed from: h */
    public AppTaskBuilder mo31593h(boolean z) {
        this.f21591R = z;
        return this;
    }

    /* renamed from: i */
    public AppTaskBuilder mo31595i(boolean z) {
        this.f21578E = z;
        return this;
    }

    /* renamed from: j */
    public AppTaskBuilder mo31597j(boolean z) {
        this.f21579F = z;
        return this;
    }

    /* renamed from: k */
    public AppTaskBuilder mo31599k(boolean z) {
        this.f21580G = z;
        return this;
    }

    /* renamed from: l */
    public AppTaskBuilder mo31601l(boolean z) {
        this.f21581H = z;
        return this;
    }

    /* renamed from: c */
    public AppTaskBuilder mo31575c(int i) {
        this.f21583J = i;
        return this;
    }

    /* renamed from: d */
    public AppTaskBuilder mo31579d(int i) {
        this.f21584K = i;
        return this;
    }

    /* renamed from: m */
    public AppTaskBuilder mo31603m(boolean z) {
        this.f21585L = z;
        return this;
    }

    /* renamed from: a */
    public AppTaskBuilder mo31560a(EnqueueType gVar) {
        this.f21582I = gVar;
        return this;
    }

    /* renamed from: n */
    public AppTaskBuilder mo31605n(boolean z) {
        this.f21620z = z;
        return this;
    }

    /* renamed from: a */
    public AppTaskBuilder mo31563a(IDownloadFileUriProvider xVar) {
        this.f21589P = xVar;
        return this;
    }

    /* renamed from: S */
    public List<String> mo31555S() {
        return this.f21598d;
    }

    /* renamed from: b */
    public AppTaskBuilder mo31573b(List<String> list) {
        this.f21598d = list;
        return this;
    }

    /* renamed from: T */
    public IDownloadDiskSpaceHandler mo31556T() {
        return this.f21590Q;
    }

    /* renamed from: a */
    public AppTaskBuilder mo31562a(IDownloadDiskSpaceHandler wVar) {
        this.f21590Q = wVar;
        return this;
    }

    /* renamed from: U */
    public JSONObject mo31557U() {
        return this.f21594U;
    }

    /* renamed from: a */
    public AppTaskBuilder mo31568a(JSONObject jSONObject) {
        this.f21594U = jSONObject;
        return this;
    }
}
