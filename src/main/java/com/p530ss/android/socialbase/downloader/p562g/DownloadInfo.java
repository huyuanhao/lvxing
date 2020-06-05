package com.p530ss.android.socialbase.downloader.p562g;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.SystemClock;
import android.support.p000v4.media.session.PlaybackStateCompat;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.p530ss.android.socialbase.downloader.downloader.C6694b;
import com.p530ss.android.socialbase.downloader.downloader.IDownloadCache;
import com.p530ss.android.socialbase.downloader.p557b.AsyncHandleStatus;
import com.p530ss.android.socialbase.downloader.p557b.ByteInvalidRetryStatus;
import com.p530ss.android.socialbase.downloader.p557b.DownloadStatus;
import com.p530ss.android.socialbase.downloader.p557b.EnqueueType;
import com.p530ss.android.socialbase.downloader.p557b.Md5CheckStatus;
import com.p530ss.android.socialbase.downloader.p557b.RetryDelayStatus;
import com.p530ss.android.socialbase.downloader.p559d.ITempFileSaveCompleteCallback;
import com.p530ss.android.socialbase.downloader.p560e.BaseException;
import com.p530ss.android.socialbase.downloader.p561f.C6704a;
import com.p530ss.android.socialbase.downloader.p569m.DownloadUtils;
import com.tencent.android.tpush.common.Constants;
import com.tencent.p605ep.common.adapt.iservice.account.AccountConst.ArgKey;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.ss.android.socialbase.downloader.g.c */
public class DownloadInfo implements Parcelable {
    public static final Creator<DownloadInfo> CREATOR = new Creator<DownloadInfo>() {
        /* renamed from: a */
        public DownloadInfo createFromParcel(Parcel parcel) {
            return new DownloadInfo(parcel);
        }

        /* renamed from: a */
        public DownloadInfo[] newArray(int i) {
            return new DownloadInfo[i];
        }
    };
    /* renamed from: A */
    private boolean f21975A;
    /* renamed from: B */
    private boolean f21976B;
    /* renamed from: C */
    private String f21977C;
    /* renamed from: D */
    private int f21978D;
    /* renamed from: E */
    private RetryDelayStatus f21979E;
    /* renamed from: F */
    private boolean f21980F;
    /* renamed from: G */
    private AsyncHandleStatus f21981G;
    /* renamed from: H */
    private boolean f21982H;
    /* renamed from: I */
    private boolean f21983I;
    /* renamed from: J */
    private boolean f21984J;
    /* renamed from: K */
    private String f21985K;
    /* renamed from: L */
    private int f21986L;
    /* renamed from: M */
    private int f21987M;
    /* renamed from: N */
    private int f21988N;
    /* renamed from: O */
    private AtomicLong f21989O;
    /* renamed from: P */
    private long f21990P;
    /* renamed from: Q */
    private AtomicInteger f21991Q;
    /* renamed from: R */
    private boolean f21992R;
    /* renamed from: S */
    private boolean f21993S;
    /* renamed from: T */
    private long f21994T;
    /* renamed from: U */
    private long f21995U;
    /* renamed from: V */
    private boolean f21996V;
    /* renamed from: W */
    private boolean f21997W;
    /* renamed from: X */
    private long f21998X;
    /* renamed from: Y */
    private long f21999Y;
    /* renamed from: Z */
    private StringBuffer f22000Z;
    /* renamed from: a */
    private int f22001a;
    /* renamed from: aA */
    private Bundle f22002aA;
    /* renamed from: aa */
    private int f22003aa;
    /* renamed from: ab */
    private boolean f22004ab;
    /* renamed from: ac */
    private boolean f22005ac;
    /* renamed from: ad */
    private boolean f22006ad;
    /* renamed from: ae */
    private List<String> f22007ae;
    /* renamed from: af */
    private ByteInvalidRetryStatus f22008af;
    /* renamed from: ag */
    private boolean f22009ag;
    /* renamed from: ah */
    private EnqueueType f22010ah;
    /* renamed from: ai */
    private String f22011ai;
    /* renamed from: aj */
    private int f22012aj;
    /* renamed from: ak */
    private String f22013ak;
    /* renamed from: al */
    private AtomicLong f22014al;
    /* renamed from: am */
    private volatile boolean f22015am;
    /* renamed from: an */
    private volatile List<ITempFileSaveCompleteCallback> f22016an;
    /* renamed from: ao */
    private boolean f22017ao;
    /* renamed from: ap */
    private boolean f22018ap;
    /* renamed from: aq */
    private boolean f22019aq;
    /* renamed from: ar */
    private boolean f22020ar;
    /* renamed from: as */
    private boolean f22021as;
    /* renamed from: at */
    private boolean f22022at;
    /* renamed from: au */
    private String f22023au;
    /* renamed from: av */
    private BaseException f22024av;
    @Deprecated
    /* renamed from: aw */
    private int f22025aw;
    /* renamed from: ax */
    private JSONObject f22026ax;
    /* renamed from: ay */
    private JSONObject f22027ay;
    /* renamed from: az */
    private String f22028az;
    /* renamed from: b */
    private String f22029b;
    /* renamed from: c */
    private String f22030c;
    /* renamed from: d */
    private String f22031d;
    /* renamed from: e */
    private String f22032e;
    /* renamed from: f */
    private String f22033f;
    /* renamed from: g */
    private boolean f22034g;
    /* renamed from: h */
    private String f22035h;
    /* renamed from: i */
    private List<HttpHeader> f22036i;
    /* renamed from: j */
    private int f22037j;
    /* renamed from: k */
    private String[] f22038k;
    /* renamed from: l */
    private int[] f22039l;
    /* renamed from: m */
    private int f22040m;
    /* renamed from: n */
    private int f22041n;
    /* renamed from: o */
    private boolean f22042o;
    /* renamed from: p */
    private boolean f22043p;
    /* renamed from: q */
    private int f22044q;
    /* renamed from: r */
    private int f22045r;
    /* renamed from: s */
    private List<String> f22046s;
    /* renamed from: t */
    private boolean f22047t;
    /* renamed from: u */
    private String f22048u;
    /* renamed from: v */
    private boolean f22049v;
    /* renamed from: w */
    private String f22050w;
    /* renamed from: x */
    private String f22051x;
    /* renamed from: y */
    private boolean f22052y;
    /* renamed from: z */
    private String f22053z;

    /* compiled from: DownloadInfo */
    /* renamed from: com.ss.android.socialbase.downloader.g.c$a */
    public static class C6711a {
        /* access modifiers changed from: private */
        /* renamed from: A */
        public String f22054A;
        /* access modifiers changed from: private */
        /* renamed from: B */
        public boolean f22055B;
        /* access modifiers changed from: private */
        /* renamed from: C */
        public String f22056C;
        /* access modifiers changed from: private */
        /* renamed from: D */
        public boolean f22057D;
        /* access modifiers changed from: private */
        /* renamed from: E */
        public boolean f22058E;
        /* access modifiers changed from: private */
        /* renamed from: F */
        public EnqueueType f22059F = EnqueueType.ENQUEUE_NONE;
        /* access modifiers changed from: private */
        /* renamed from: G */
        public boolean f22060G;
        /* access modifiers changed from: private */
        /* renamed from: H */
        public boolean f22061H;
        /* access modifiers changed from: private */
        /* renamed from: I */
        public boolean f22062I;
        /* access modifiers changed from: private */
        /* renamed from: J */
        public boolean f22063J = true;
        /* access modifiers changed from: private */
        /* renamed from: K */
        public boolean f22064K;
        /* access modifiers changed from: private */
        /* renamed from: L */
        public JSONObject f22065L;
        /* access modifiers changed from: private */
        /* renamed from: a */
        public String f22066a;
        /* access modifiers changed from: private */
        /* renamed from: b */
        public String f22067b;
        /* access modifiers changed from: private */
        /* renamed from: c */
        public String f22068c;
        /* access modifiers changed from: private */
        /* renamed from: d */
        public String f22069d;
        /* access modifiers changed from: private */
        /* renamed from: e */
        public String f22070e;
        /* access modifiers changed from: private */
        /* renamed from: f */
        public boolean f22071f;
        /* access modifiers changed from: private */
        /* renamed from: g */
        public String f22072g;
        /* access modifiers changed from: private */
        /* renamed from: h */
        public List<HttpHeader> f22073h;
        /* access modifiers changed from: private */
        /* renamed from: i */
        public int f22074i;
        /* access modifiers changed from: private */
        /* renamed from: j */
        public String[] f22075j;
        /* access modifiers changed from: private */
        /* renamed from: k */
        public int[] f22076k;
        /* access modifiers changed from: private */
        /* renamed from: l */
        public int f22077l;
        /* access modifiers changed from: private */
        /* renamed from: m */
        public int f22078m;
        /* access modifiers changed from: private */
        /* renamed from: n */
        public boolean f22079n;
        /* access modifiers changed from: private */
        /* renamed from: o */
        public boolean f22080o = true;
        /* access modifiers changed from: private */
        /* renamed from: p */
        public int f22081p;
        /* access modifiers changed from: private */
        /* renamed from: q */
        public int f22082q;
        /* access modifiers changed from: private */
        /* renamed from: r */
        public List<String> f22083r;
        /* access modifiers changed from: private */
        /* renamed from: s */
        public boolean f22084s;
        /* access modifiers changed from: private */
        /* renamed from: t */
        public String f22085t;
        /* access modifiers changed from: private */
        /* renamed from: u */
        public boolean f22086u;
        /* access modifiers changed from: private */
        /* renamed from: v */
        public boolean f22087v;
        /* access modifiers changed from: private */
        /* renamed from: w */
        public boolean f22088w;
        /* access modifiers changed from: private */
        /* renamed from: x */
        public boolean f22089x;
        /* access modifiers changed from: private */
        /* renamed from: y */
        public boolean f22090y;
        /* access modifiers changed from: private */
        /* renamed from: z */
        public String f22091z;

        public C6711a() {
        }

        public C6711a(String str) {
            this.f22068c = str;
        }

        /* renamed from: a */
        public C6711a mo32326a(String str) {
            this.f22066a = str;
            return this;
        }

        /* renamed from: b */
        public C6711a mo32332b(String str) {
            this.f22067b = str;
            return this;
        }

        /* renamed from: c */
        public C6711a mo32336c(String str) {
            this.f22068c = str;
            return this;
        }

        /* renamed from: d */
        public C6711a mo32339d(String str) {
            this.f22069d = str;
            return this;
        }

        /* renamed from: e */
        public C6711a mo32341e(String str) {
            this.f22072g = str;
            return this;
        }

        /* renamed from: a */
        public C6711a mo32329a(boolean z) {
            this.f22071f = z;
            return this;
        }

        /* renamed from: a */
        public C6711a mo32327a(List<HttpHeader> list) {
            this.f22073h = list;
            return this;
        }

        /* renamed from: a */
        public C6711a mo32324a(int i) {
            this.f22077l = i;
            return this;
        }

        /* renamed from: b */
        public C6711a mo32331b(int i) {
            this.f22078m = i;
            return this;
        }

        /* renamed from: b */
        public C6711a mo32334b(boolean z) {
            this.f22079n = z;
            return this;
        }

        /* renamed from: c */
        public C6711a mo32335c(int i) {
            this.f22081p = i;
            return this;
        }

        /* renamed from: d */
        public C6711a mo32338d(int i) {
            this.f22082q = i;
            return this;
        }

        /* renamed from: b */
        public C6711a mo32333b(List<String> list) {
            this.f22083r = list;
            return this;
        }

        /* renamed from: f */
        public C6711a mo32343f(String str) {
            this.f22085t = str;
            return this;
        }

        /* renamed from: c */
        public C6711a mo32337c(boolean z) {
            this.f22086u = z;
            return this;
        }

        /* renamed from: d */
        public C6711a mo32340d(boolean z) {
            this.f22084s = z;
            return this;
        }

        /* renamed from: e */
        public C6711a mo32342e(boolean z) {
            this.f22087v = z;
            return this;
        }

        /* renamed from: f */
        public C6711a mo32344f(boolean z) {
            this.f22088w = z;
            return this;
        }

        /* renamed from: g */
        public C6711a mo32346g(boolean z) {
            this.f22089x = z;
            return this;
        }

        /* renamed from: h */
        public C6711a mo32348h(boolean z) {
            this.f22090y = z;
            return this;
        }

        /* renamed from: g */
        public C6711a mo32345g(String str) {
            this.f22091z = str;
            return this;
        }

        /* renamed from: h */
        public C6711a mo32347h(String str) {
            this.f22054A = str;
            return this;
        }

        /* renamed from: i */
        public C6711a mo32350i(boolean z) {
            this.f22055B = z;
            return this;
        }

        /* renamed from: i */
        public C6711a mo32349i(String str) {
            this.f22056C = str;
            return this;
        }

        /* renamed from: j */
        public C6711a mo32351j(boolean z) {
            this.f22057D = z;
            return this;
        }

        /* renamed from: k */
        public C6711a mo32352k(boolean z) {
            this.f22058E = z;
            return this;
        }

        /* renamed from: a */
        public C6711a mo32325a(EnqueueType gVar) {
            this.f22059F = gVar;
            return this;
        }

        /* renamed from: l */
        public C6711a mo32353l(boolean z) {
            this.f22060G = z;
            return this;
        }

        /* renamed from: m */
        public C6711a mo32354m(boolean z) {
            this.f22062I = z;
            return this;
        }

        /* renamed from: a */
        public C6711a mo32328a(JSONObject jSONObject) {
            this.f22065L = jSONObject;
            return this;
        }

        /* renamed from: a */
        public DownloadInfo mo32330a() {
            return new DownloadInfo(this);
        }
    }

    public int describeContents() {
        return 0;
    }

    public DownloadInfo() {
        this.f21979E = RetryDelayStatus.DELAY_RETRY_NONE;
        this.f21980F = false;
        this.f21981G = AsyncHandleStatus.ASYNC_HANDLE_NONE;
        this.f21988N = 1;
        this.f21992R = true;
        this.f21993S = true;
        this.f22008af = ByteInvalidRetryStatus.BYTE_INVALID_RETRY_STATUS_NONE;
        this.f22010ah = EnqueueType.ENQUEUE_NONE;
        this.f22014al = new AtomicLong(0);
        this.f22018ap = true;
        this.f22019aq = true;
    }

    private DownloadInfo(C6711a aVar) {
        this.f21979E = RetryDelayStatus.DELAY_RETRY_NONE;
        this.f21980F = false;
        this.f21981G = AsyncHandleStatus.ASYNC_HANDLE_NONE;
        this.f21988N = 1;
        this.f21992R = true;
        this.f21993S = true;
        this.f22008af = ByteInvalidRetryStatus.BYTE_INVALID_RETRY_STATUS_NONE;
        this.f22010ah = EnqueueType.ENQUEUE_NONE;
        this.f22014al = new AtomicLong(0);
        this.f22018ap = true;
        this.f22019aq = true;
        if (aVar != null) {
            this.f22029b = aVar.f22066a;
            this.f22030c = aVar.f22067b;
            this.f22031d = aVar.f22068c;
            this.f22032e = aVar.f22069d;
            this.f22033f = aVar.f22070e;
            this.f21991Q = new AtomicInteger(0);
            this.f21989O = new AtomicLong(0);
            this.f22035h = aVar.f22072g;
            this.f22034g = aVar.f22071f;
            this.f22036i = aVar.f22073h;
            this.f22037j = aVar.f22074i;
            this.f22040m = aVar.f22077l;
            this.f22041n = aVar.f22078m;
            this.f22042o = aVar.f22079n;
            this.f22038k = aVar.f22075j;
            this.f22039l = aVar.f22076k;
            this.f22043p = aVar.f22080o;
            this.f22044q = aVar.f22081p;
            this.f22045r = aVar.f22082q;
            this.f22046s = aVar.f22083r;
            this.f22047t = aVar.f22084s;
            this.f22048u = aVar.f22085t;
            this.f22049v = aVar.f22086u;
            this.f22052y = aVar.f22055B;
            this.f22053z = aVar.f22056C;
            this.f22004ab = aVar.f22087v;
            this.f22005ac = aVar.f22088w;
            this.f21975A = aVar.f22089x;
            this.f21976B = aVar.f22090y;
            this.f22050w = aVar.f22091z;
            this.f22051x = aVar.f22054A;
            this.f21980F = aVar.f22057D;
            this.f22009ag = aVar.f22058E;
            this.f22010ah = aVar.f22059F;
            this.f21982H = aVar.f22060G;
            this.f21983I = aVar.f22061H;
            this.f22019aq = aVar.f22063J;
            this.f22020ar = aVar.f22064K;
            this.f22021as = aVar.f22062I;
            JSONObject L = aVar.f22065L;
            if (L != null) {
                m27846a("download_setting", (Object) L.toString());
            }
        }
    }

    /* renamed from: a */
    public void mo32185a(Parcel parcel) {
        this.f22001a = parcel.readInt();
        this.f22029b = parcel.readString();
        this.f22030c = parcel.readString();
        this.f22031d = parcel.readString();
        this.f22032e = parcel.readString();
        this.f22033f = parcel.readString();
        boolean z = true;
        this.f22034g = parcel.readByte() != 0;
        this.f22035h = parcel.readString();
        this.f22036i = parcel.createTypedArrayList(HttpHeader.CREATOR);
        this.f22037j = parcel.readInt();
        this.f22038k = parcel.createStringArray();
        this.f22039l = parcel.createIntArray();
        this.f22040m = parcel.readInt();
        this.f22041n = parcel.readInt();
        this.f22042o = parcel.readByte() != 0;
        this.f22043p = parcel.readByte() != 0;
        this.f22044q = parcel.readInt();
        this.f22045r = parcel.readInt();
        this.f22046s = parcel.createStringArrayList();
        this.f22047t = parcel.readByte() != 0;
        this.f22048u = parcel.readString();
        this.f22049v = parcel.readByte() != 0;
        this.f22050w = parcel.readString();
        this.f22051x = parcel.readString();
        this.f22052y = parcel.readByte() != 0;
        this.f21975A = parcel.readByte() != 0;
        this.f21976B = parcel.readByte() != 0;
        this.f22053z = parcel.readString();
        this.f21977C = parcel.readString();
        this.f21978D = parcel.readInt();
        m27854n(parcel.readInt());
        this.f21980F = parcel.readByte() != 0;
        this.f21984J = parcel.readByte() != 0;
        this.f21985K = parcel.readString();
        this.f21986L = parcel.readInt();
        this.f21987M = parcel.readInt();
        this.f21988N = parcel.readInt();
        mo32182a(parcel.readLong());
        this.f21990P = parcel.readLong();
        mo32251b(parcel.readInt());
        this.f21994T = parcel.readLong();
        this.f21995U = parcel.readLong();
        this.f21996V = parcel.readByte() != 0;
        this.f21997W = parcel.readByte() != 0;
        try {
            if (this.f22000Z == null) {
                this.f22000Z = new StringBuffer(parcel.readString());
            } else {
                this.f22000Z.delete(0, this.f22000Z.length()).append(parcel.readString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.f22004ab = parcel.readByte() != 0;
        this.f22005ac = parcel.readByte() != 0;
        this.f22006ad = parcel.readByte() != 0;
        this.f22007ae = parcel.createStringArrayList();
        this.f22009ag = parcel.readByte() != 0;
        m27853m(parcel.readInt());
        this.f21982H = parcel.readByte() != 0;
        this.f22012aj = parcel.readInt();
        this.f22013ak = parcel.readString();
        this.f22015am = parcel.readByte() != 0;
        this.f22017ao = parcel.readByte() != 0;
        this.f22019aq = parcel.readByte() != 0;
        this.f22020ar = parcel.readByte() != 0;
        this.f22021as = parcel.readByte() != 0;
        this.f22022at = parcel.readByte() != 0;
        this.f22024av = (BaseException) parcel.readParcelable(BaseException.class.getClassLoader());
        this.f22025aw = parcel.readInt();
        this.f22028az = parcel.readString();
        if (parcel.readByte() == 0) {
            z = false;
        }
        this.f22018ap = z;
    }

    /* renamed from: bh */
    private String m27848bh() {
        if (this.f22023au == null) {
            List<String> list = this.f22046s;
            if (list != null && !list.isEmpty()) {
                try {
                    JSONArray jSONArray = new JSONArray();
                    for (String str : this.f22046s) {
                        if (!TextUtils.isEmpty(str)) {
                            jSONArray.put(str);
                        }
                    }
                    this.f22023au = jSONArray.toString();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        if (this.f22023au == null) {
            this.f22023au = "";
        }
        return this.f22023au;
    }

    /* renamed from: i */
    private void m27852i(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.f22023au = str;
            try {
                JSONArray jSONArray = new JSONArray(str);
                if (jSONArray.length() > 0) {
                    ArrayList arrayList = new ArrayList();
                    for (int i = 0; i < jSONArray.length(); i++) {
                        String optString = jSONArray.optString(i);
                        if (!TextUtils.isEmpty(optString)) {
                            arrayList.add(optString);
                        }
                    }
                    this.f22046s = arrayList;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* renamed from: a */
    public boolean mo32196a() {
        long j = this.f22014al.get();
        return j == 0 || SystemClock.uptimeMillis() - j > 20;
    }

    /* renamed from: b */
    public void mo32250b() {
        this.f22014al.set(SystemClock.uptimeMillis());
    }

    /* renamed from: c */
    public String mo32262c() {
        return this.f22011ai;
    }

    /* renamed from: a */
    public void mo32192a(String str) {
        this.f22011ai = str;
    }

    protected DownloadInfo(Parcel parcel) {
        this.f21979E = RetryDelayStatus.DELAY_RETRY_NONE;
        this.f21980F = false;
        this.f21981G = AsyncHandleStatus.ASYNC_HANDLE_NONE;
        this.f21988N = 1;
        this.f21992R = true;
        this.f21993S = true;
        this.f22008af = ByteInvalidRetryStatus.BYTE_INVALID_RETRY_STATUS_NONE;
        this.f22010ah = EnqueueType.ENQUEUE_NONE;
        this.f22014al = new AtomicLong(0);
        this.f22018ap = true;
        this.f22019aq = true;
        mo32185a(parcel);
    }

    /* renamed from: m */
    private void m27853m(int i) {
        if (i == EnqueueType.ENQUEUE_HEAD.ordinal()) {
            this.f22010ah = EnqueueType.ENQUEUE_HEAD;
        } else if (i == EnqueueType.ENQUEUE_TAIL.ordinal()) {
            this.f22010ah = EnqueueType.ENQUEUE_TAIL;
        } else {
            this.f22010ah = EnqueueType.ENQUEUE_NONE;
        }
    }

    /* renamed from: n */
    private void m27854n(int i) {
        if (i == RetryDelayStatus.DELAY_RETRY_WAITING.ordinal()) {
            this.f21979E = RetryDelayStatus.DELAY_RETRY_WAITING;
        } else if (i == RetryDelayStatus.DELAY_RETRY_DOWNLOADING.ordinal()) {
            this.f21979E = RetryDelayStatus.DELAY_RETRY_DOWNLOADING;
        } else if (i == RetryDelayStatus.DELAY_RETRY_DOWNLOADED.ordinal()) {
            this.f21979E = RetryDelayStatus.DELAY_RETRY_DOWNLOADED;
        } else {
            this.f21979E = RetryDelayStatus.DELAY_RETRY_NONE;
        }
    }

    /* renamed from: d */
    public String mo32268d() {
        StringBuffer stringBuffer = this.f22000Z;
        return (stringBuffer == null || stringBuffer.length() == 0) ? "" : this.f22000Z.toString();
    }

    public DownloadInfo(Cursor cursor) {
        this.f21979E = RetryDelayStatus.DELAY_RETRY_NONE;
        boolean z = false;
        this.f21980F = false;
        this.f21981G = AsyncHandleStatus.ASYNC_HANDLE_NONE;
        this.f21988N = 1;
        this.f21992R = true;
        this.f21993S = true;
        this.f22008af = ByteInvalidRetryStatus.BYTE_INVALID_RETRY_STATUS_NONE;
        this.f22010ah = EnqueueType.ENQUEUE_NONE;
        this.f22014al = new AtomicLong(0);
        this.f22018ap = true;
        this.f22019aq = true;
        if (cursor != null) {
            try {
                int columnIndex = cursor.getColumnIndex(C7887a.f26833ID);
                if (columnIndex != -1) {
                    this.f22001a = cursor.getInt(columnIndex);
                }
                int columnIndex2 = cursor.getColumnIndex(ArgKey.KEY_NAME);
                if (columnIndex2 != -1) {
                    this.f22029b = cursor.getString(columnIndex2);
                }
                int columnIndex3 = cursor.getColumnIndex("title");
                if (columnIndex3 != -1) {
                    this.f22030c = cursor.getString(columnIndex3);
                }
                int columnIndex4 = cursor.getColumnIndex("url");
                if (columnIndex4 != -1) {
                    this.f22031d = cursor.getString(columnIndex4);
                }
                int columnIndex5 = cursor.getColumnIndex("savePath");
                if (columnIndex5 != -1) {
                    this.f22032e = cursor.getString(columnIndex5);
                }
                int columnIndex6 = cursor.getColumnIndex("tempPath");
                if (columnIndex6 != -1) {
                    this.f22033f = cursor.getString(columnIndex6);
                }
                int columnIndex7 = cursor.getColumnIndex("chunkCount");
                if (columnIndex7 != -1) {
                    this.f21988N = cursor.getInt(columnIndex7);
                }
                int columnIndex8 = cursor.getColumnIndex(NotificationCompat.CATEGORY_STATUS);
                if (columnIndex8 != -1) {
                    this.f21991Q = new AtomicInteger(cursor.getInt(columnIndex8));
                } else {
                    this.f21991Q = new AtomicInteger(0);
                }
                int columnIndex9 = cursor.getColumnIndex("curBytes");
                if (columnIndex9 != -1) {
                    this.f21989O = new AtomicLong(cursor.getLong(columnIndex9));
                } else {
                    this.f21989O = new AtomicLong(0);
                }
                int columnIndex10 = cursor.getColumnIndex("totalBytes");
                if (columnIndex10 != -1) {
                    this.f21990P = cursor.getLong(columnIndex10);
                }
                int columnIndex11 = cursor.getColumnIndex("eTag");
                if (columnIndex11 != -1) {
                    this.f21977C = cursor.getString(columnIndex11);
                }
                int columnIndex12 = cursor.getColumnIndex("onlyWifi");
                if (columnIndex12 != -1) {
                    this.f22034g = cursor.getInt(columnIndex12) != 0;
                }
                int columnIndex13 = cursor.getColumnIndex(ArgKey.KEY_FORCE);
                if (columnIndex13 != -1) {
                    this.f22042o = cursor.getInt(columnIndex13) != 0;
                }
                int columnIndex14 = cursor.getColumnIndex("retryCount");
                if (columnIndex14 != -1) {
                    this.f22040m = cursor.getInt(columnIndex14);
                }
                int columnIndex15 = cursor.getColumnIndex("extra");
                if (columnIndex15 != -1) {
                    this.f22035h = cursor.getString(columnIndex15);
                }
                int columnIndex16 = cursor.getColumnIndex("mimeType");
                if (columnIndex16 != -1) {
                    this.f22048u = cursor.getString(columnIndex16);
                }
                int columnIndex17 = cursor.getColumnIndex("notificationEnable");
                if (columnIndex17 != -1) {
                    this.f22047t = cursor.getInt(columnIndex17) != 0;
                }
                int columnIndex18 = cursor.getColumnIndex("notificationVisibility");
                if (columnIndex18 != -1) {
                    this.f21987M = cursor.getInt(columnIndex18);
                }
                int columnIndex19 = cursor.getColumnIndex("isFirstDownload");
                if (columnIndex19 != -1) {
                    this.f21992R = cursor.getInt(columnIndex19) == 1;
                }
                int columnIndex20 = cursor.getColumnIndex("isFirstSuccess");
                if (columnIndex20 != -1) {
                    this.f21993S = cursor.getInt(columnIndex20) == 1;
                }
                int columnIndex21 = cursor.getColumnIndex("needHttpsToHttpRetry");
                if (columnIndex21 != -1) {
                    this.f22049v = cursor.getInt(columnIndex21) == 1;
                }
                int columnIndex22 = cursor.getColumnIndex("downloadTime");
                if (columnIndex22 != -1) {
                    this.f21994T = cursor.getLong(columnIndex22);
                }
                int columnIndex23 = cursor.getColumnIndex(Constants.FLAG_PACKAGE_NAME);
                if (columnIndex23 != -1) {
                    this.f22050w = cursor.getString(columnIndex23);
                }
                int columnIndex24 = cursor.getColumnIndex("md5");
                if (columnIndex24 != -1) {
                    this.f22051x = cursor.getString(columnIndex24);
                }
                int columnIndex25 = cursor.getColumnIndex("retryDelay");
                if (columnIndex25 != -1) {
                    this.f22052y = cursor.getInt(columnIndex25) == 1;
                }
                int columnIndex26 = cursor.getColumnIndex("curRetryTime");
                if (columnIndex26 != -1) {
                    this.f21978D = cursor.getInt(columnIndex26);
                }
                int columnIndex27 = cursor.getColumnIndex("retryDelayStatus");
                if (columnIndex27 != -1) {
                    int i = cursor.getInt(columnIndex27);
                    if (i == RetryDelayStatus.DELAY_RETRY_WAITING.ordinal()) {
                        this.f21979E = RetryDelayStatus.DELAY_RETRY_WAITING;
                    } else if (i == RetryDelayStatus.DELAY_RETRY_DOWNLOADING.ordinal()) {
                        this.f21979E = RetryDelayStatus.DELAY_RETRY_DOWNLOADING;
                    } else if (i == RetryDelayStatus.DELAY_RETRY_DOWNLOADED.ordinal()) {
                        this.f21979E = RetryDelayStatus.DELAY_RETRY_DOWNLOADED;
                    } else {
                        this.f21979E = RetryDelayStatus.DELAY_RETRY_NONE;
                    }
                }
                int columnIndex28 = cursor.getColumnIndex("defaultHttpServiceBackUp");
                if (columnIndex28 != -1) {
                    this.f21975A = cursor.getInt(columnIndex28) == 1;
                }
                int columnIndex29 = cursor.getColumnIndex("chunkRunnableReuse");
                if (columnIndex29 != -1) {
                    this.f21976B = cursor.getInt(columnIndex29) == 1;
                }
                int columnIndex30 = cursor.getColumnIndex("retryDelayTimeArray");
                if (columnIndex30 != -1) {
                    this.f22053z = cursor.getString(columnIndex30);
                }
                int columnIndex31 = cursor.getColumnIndex("chunkDowngradeRetry");
                if (columnIndex31 != -1) {
                    this.f22021as = cursor.getInt(columnIndex31) == 1;
                }
                int columnIndex32 = cursor.getColumnIndex("backUpUrlsStr");
                if (columnIndex32 != -1) {
                    m27852i(cursor.getString(columnIndex32));
                }
                int columnIndex33 = cursor.getColumnIndex("backUpUrlRetryCount");
                if (columnIndex33 != -1) {
                    this.f22041n = cursor.getInt(columnIndex33);
                }
                int columnIndex34 = cursor.getColumnIndex("realDownloadTime");
                if (columnIndex34 != -1) {
                    this.f21995U = cursor.getLong(columnIndex34);
                }
                int columnIndex35 = cursor.getColumnIndex("retryScheduleMinutes");
                if (columnIndex35 != -1) {
                    this.f22025aw = cursor.getInt(columnIndex35);
                }
                int columnIndex36 = cursor.getColumnIndex("independentProcess");
                if (columnIndex36 != -1) {
                    if (cursor.getInt(columnIndex36) == 1) {
                        z = true;
                    }
                    this.f22009ag = z;
                }
                int columnIndex37 = cursor.getColumnIndex("auxiliaryJsonobjectString");
                if (columnIndex37 != -1) {
                    this.f22028az = cursor.getString(columnIndex37);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* renamed from: e */
    public ContentValues mo32273e() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(C7887a.f26833ID, Integer.valueOf(this.f22001a));
        contentValues.put("url", this.f22031d);
        contentValues.put("savePath", this.f22032e);
        contentValues.put("tempPath", this.f22033f);
        contentValues.put(ArgKey.KEY_NAME, this.f22029b);
        contentValues.put("chunkCount", Integer.valueOf(this.f21988N));
        contentValues.put(NotificationCompat.CATEGORY_STATUS, Integer.valueOf(mo32308q()));
        contentValues.put("curBytes", Long.valueOf(mo32180Z()));
        contentValues.put("totalBytes", Long.valueOf(this.f21990P));
        contentValues.put("eTag", this.f21977C);
        contentValues.put("onlyWifi", Integer.valueOf(this.f22034g));
        contentValues.put(ArgKey.KEY_FORCE, Integer.valueOf(this.f22042o));
        contentValues.put("retryCount", Integer.valueOf(this.f22040m));
        contentValues.put("extra", this.f22035h);
        contentValues.put("mimeType", this.f22048u);
        contentValues.put("title", this.f22030c);
        contentValues.put("notificationEnable", Integer.valueOf(this.f22047t));
        contentValues.put("notificationVisibility", Integer.valueOf(this.f21987M));
        contentValues.put("isFirstDownload", Integer.valueOf(this.f21992R));
        contentValues.put("isFirstSuccess", Integer.valueOf(this.f21993S));
        contentValues.put("needHttpsToHttpRetry", Integer.valueOf(this.f22049v));
        contentValues.put("downloadTime", Long.valueOf(this.f21994T));
        contentValues.put(Constants.FLAG_PACKAGE_NAME, this.f22050w);
        contentValues.put("md5", this.f22051x);
        contentValues.put("retryDelay", Integer.valueOf(this.f22052y));
        contentValues.put("curRetryTime", Integer.valueOf(this.f21978D));
        contentValues.put("retryDelayStatus", Integer.valueOf(this.f21979E.ordinal()));
        contentValues.put("defaultHttpServiceBackUp", Integer.valueOf(this.f21975A));
        contentValues.put("chunkRunnableReuse", Integer.valueOf(this.f21976B));
        contentValues.put("retryDelayTimeArray", this.f22053z);
        contentValues.put("chunkDowngradeRetry", Integer.valueOf(this.f22021as));
        contentValues.put("backUpUrlsStr", m27848bh());
        contentValues.put("backUpUrlRetryCount", Integer.valueOf(this.f22041n));
        contentValues.put("realDownloadTime", Long.valueOf(this.f21995U));
        contentValues.put("retryScheduleMinutes", Integer.valueOf(this.f22025aw));
        contentValues.put("independentProcess", Integer.valueOf(this.f22009ag));
        JSONObject jSONObject = this.f22027ay;
        contentValues.put("auxiliaryJsonobjectString", jSONObject == null ? this.f22028az : jSONObject.toString());
        return contentValues;
    }

    /* renamed from: a */
    public void mo32184a(SQLiteStatement sQLiteStatement) {
        if (sQLiteStatement != null) {
            this.f22003aa = 0;
            sQLiteStatement.clearBindings();
            int i = this.f22003aa + 1;
            this.f22003aa = i;
            sQLiteStatement.bindLong(i, (long) this.f22001a);
            int i2 = this.f22003aa + 1;
            this.f22003aa = i2;
            String str = this.f22031d;
            String str2 = "";
            if (str == null) {
                str = str2;
            }
            sQLiteStatement.bindString(i2, str);
            int i3 = this.f22003aa + 1;
            this.f22003aa = i3;
            String str3 = this.f22032e;
            if (str3 == null) {
                str3 = str2;
            }
            sQLiteStatement.bindString(i3, str3);
            int i4 = this.f22003aa + 1;
            this.f22003aa = i4;
            String str4 = this.f22033f;
            if (str4 == null) {
                str4 = str2;
            }
            sQLiteStatement.bindString(i4, str4);
            int i5 = this.f22003aa + 1;
            this.f22003aa = i5;
            String str5 = this.f22029b;
            if (str5 == null) {
                str5 = str2;
            }
            sQLiteStatement.bindString(i5, str5);
            int i6 = this.f22003aa + 1;
            this.f22003aa = i6;
            sQLiteStatement.bindLong(i6, (long) this.f21988N);
            int i7 = this.f22003aa + 1;
            this.f22003aa = i7;
            sQLiteStatement.bindLong(i7, (long) mo32308q());
            int i8 = this.f22003aa + 1;
            this.f22003aa = i8;
            sQLiteStatement.bindLong(i8, mo32180Z());
            int i9 = this.f22003aa + 1;
            this.f22003aa = i9;
            sQLiteStatement.bindLong(i9, this.f21990P);
            int i10 = this.f22003aa + 1;
            this.f22003aa = i10;
            String str6 = this.f21977C;
            if (str6 == null) {
                str6 = str2;
            }
            sQLiteStatement.bindString(i10, str6);
            int i11 = this.f22003aa + 1;
            this.f22003aa = i11;
            long j = 1;
            sQLiteStatement.bindLong(i11, this.f22034g ? 1 : 0);
            int i12 = this.f22003aa + 1;
            this.f22003aa = i12;
            sQLiteStatement.bindLong(i12, this.f22042o ? 1 : 0);
            int i13 = this.f22003aa + 1;
            this.f22003aa = i13;
            sQLiteStatement.bindLong(i13, (long) this.f22040m);
            int i14 = this.f22003aa + 1;
            this.f22003aa = i14;
            String str7 = this.f22035h;
            if (str7 == null) {
                str7 = str2;
            }
            sQLiteStatement.bindString(i14, str7);
            int i15 = this.f22003aa + 1;
            this.f22003aa = i15;
            String str8 = this.f22048u;
            if (str8 == null) {
                str8 = str2;
            }
            sQLiteStatement.bindString(i15, str8);
            int i16 = this.f22003aa + 1;
            this.f22003aa = i16;
            String str9 = this.f22030c;
            if (str9 == null) {
                str9 = str2;
            }
            sQLiteStatement.bindString(i16, str9);
            int i17 = this.f22003aa + 1;
            this.f22003aa = i17;
            sQLiteStatement.bindLong(i17, this.f22047t ? 1 : 0);
            int i18 = this.f22003aa + 1;
            this.f22003aa = i18;
            sQLiteStatement.bindLong(i18, (long) this.f21987M);
            int i19 = this.f22003aa + 1;
            this.f22003aa = i19;
            sQLiteStatement.bindLong(i19, this.f21992R ? 1 : 0);
            int i20 = this.f22003aa + 1;
            this.f22003aa = i20;
            sQLiteStatement.bindLong(i20, this.f21993S ? 1 : 0);
            int i21 = this.f22003aa + 1;
            this.f22003aa = i21;
            sQLiteStatement.bindLong(i21, this.f22049v ? 1 : 0);
            int i22 = this.f22003aa + 1;
            this.f22003aa = i22;
            sQLiteStatement.bindLong(i22, this.f21994T);
            int i23 = this.f22003aa + 1;
            this.f22003aa = i23;
            String str10 = this.f22050w;
            if (str10 == null) {
                str10 = str2;
            }
            sQLiteStatement.bindString(i23, str10);
            int i24 = this.f22003aa + 1;
            this.f22003aa = i24;
            String str11 = this.f22051x;
            if (str11 == null) {
                str11 = str2;
            }
            sQLiteStatement.bindString(i24, str11);
            int i25 = this.f22003aa + 1;
            this.f22003aa = i25;
            sQLiteStatement.bindLong(i25, this.f22052y ? 1 : 0);
            int i26 = this.f22003aa + 1;
            this.f22003aa = i26;
            sQLiteStatement.bindLong(i26, (long) this.f21978D);
            int i27 = this.f22003aa + 1;
            this.f22003aa = i27;
            sQLiteStatement.bindLong(i27, (long) this.f21979E.ordinal());
            int i28 = this.f22003aa + 1;
            this.f22003aa = i28;
            sQLiteStatement.bindLong(i28, this.f21975A ? 1 : 0);
            int i29 = this.f22003aa + 1;
            this.f22003aa = i29;
            sQLiteStatement.bindLong(i29, this.f21976B ? 1 : 0);
            int i30 = this.f22003aa + 1;
            this.f22003aa = i30;
            String str12 = this.f22053z;
            if (str12 == null) {
                str12 = str2;
            }
            sQLiteStatement.bindString(i30, str12);
            int i31 = this.f22003aa + 1;
            this.f22003aa = i31;
            sQLiteStatement.bindLong(i31, this.f22021as ? 1 : 0);
            int i32 = this.f22003aa + 1;
            this.f22003aa = i32;
            sQLiteStatement.bindString(i32, m27848bh());
            int i33 = this.f22003aa + 1;
            this.f22003aa = i33;
            sQLiteStatement.bindLong(i33, (long) this.f22041n);
            int i34 = this.f22003aa + 1;
            this.f22003aa = i34;
            sQLiteStatement.bindLong(i34, this.f21995U);
            int i35 = this.f22003aa + 1;
            this.f22003aa = i35;
            sQLiteStatement.bindLong(i35, (long) this.f22025aw);
            int i36 = this.f22003aa + 1;
            this.f22003aa = i36;
            if (!this.f22009ag) {
                j = 0;
            }
            sQLiteStatement.bindLong(i36, j);
            int i37 = this.f22003aa + 1;
            this.f22003aa = i37;
            JSONObject jSONObject = this.f22027ay;
            sQLiteStatement.bindString(i37, jSONObject == null ? this.f22028az : jSONObject.toString());
        }
    }

    /* renamed from: f */
    public int mo32278f() {
        return this.f22003aa;
    }

    /* renamed from: g */
    public int mo32283g() {
        if (this.f22001a == 0) {
            this.f22001a = C6694b.m27347a(this);
        }
        return this.f22001a;
    }

    /* renamed from: h */
    public String mo32287h() {
        return this.f22029b;
    }

    /* renamed from: i */
    public String mo32291i() {
        if (TextUtils.isEmpty(this.f22030c)) {
            return this.f22029b;
        }
        return this.f22030c;
    }

    /* renamed from: j */
    public String mo32295j() {
        return this.f22031d;
    }

    /* renamed from: k */
    public String mo32297k() {
        return this.f22032e;
    }

    /* renamed from: l */
    public String mo32300l() {
        return DownloadUtils.m28785b(this.f22032e, this.f22033f);
    }

    /* renamed from: m */
    public String mo32303m() {
        return DownloadUtils.m28784b(this.f22029b);
    }

    /* renamed from: n */
    public String mo32305n() {
        return DownloadUtils.m28754a(this.f22032e, this.f22029b);
    }

    /* renamed from: o */
    public boolean mo32306o() {
        return this.f21975A;
    }

    /* renamed from: p */
    public boolean mo32307p() {
        return this.f21976B;
    }

    /* renamed from: q */
    public int mo32308q() {
        AtomicInteger atomicInteger = this.f21991Q;
        if (atomicInteger == null) {
            return 0;
        }
        int i = atomicInteger.get();
        if (i == -5) {
            i = -2;
        }
        return i;
    }

    /* renamed from: r */
    public EnqueueType mo32309r() {
        return this.f22010ah;
    }

    /* renamed from: s */
    public int mo32310s() {
        return this.f21986L;
    }

    /* renamed from: t */
    public boolean mo32311t() {
        return this.f21997W;
    }

    /* renamed from: u */
    public boolean mo32313u() {
        return this.f22004ab;
    }

    /* renamed from: a */
    public void mo32194a(boolean z) {
        this.f22004ab = z;
    }

    /* renamed from: v */
    public boolean mo32314v() {
        return this.f22006ad;
    }

    /* renamed from: b */
    public void mo32254b(boolean z) {
        this.f22006ad = z;
    }

    /* renamed from: w */
    public int mo32315w() {
        AtomicInteger atomicInteger = this.f21991Q;
        if (atomicInteger != null) {
            return atomicInteger.get();
        }
        return 0;
    }

    /* renamed from: x */
    public boolean mo32317x() {
        return this.f22034g;
    }

    /* renamed from: c */
    public void mo32266c(boolean z) {
        this.f22034g = z;
    }

    /* renamed from: y */
    public String mo32318y() {
        return this.f22035h;
    }

    /* renamed from: z */
    public String mo32319z() {
        return this.f22050w;
    }

    /* renamed from: A */
    public String mo32155A() {
        return this.f22051x;
    }

    /* renamed from: B */
    public List<HttpHeader> mo32156B() {
        return this.f22036i;
    }

    /* renamed from: C */
    public int mo32157C() {
        return this.f22037j;
    }

    /* renamed from: D */
    public int mo32158D() {
        return this.f22040m;
    }

    /* renamed from: E */
    public int mo32159E() {
        return this.f22041n;
    }

    /* renamed from: F */
    public int mo32160F() {
        int i = this.f22040m;
        List<String> list = this.f22046s;
        return (list == null || list.isEmpty()) ? i : i + (this.f22041n * this.f22046s.size());
    }

    /* renamed from: G */
    public int mo32161G() {
        int i = this.f21978D;
        if (!this.f21996V) {
            return i;
        }
        int i2 = i + this.f22040m;
        int i3 = this.f21986L;
        return i3 > 0 ? i2 + (i3 * this.f22041n) : i2;
    }

    /* renamed from: H */
    public List<String> mo32162H() {
        return this.f22007ae;
    }

    /* renamed from: a */
    public void mo32193a(List<String> list, boolean z) {
        this.f22007ae = list;
        m27855n(z);
    }

    /* JADX WARNING: Incorrect type for immutable var: ssa=boolean, code=int, for r3v0, types: [int, boolean] */
    /* renamed from: n */
    private void m27855n(int r3) {
        /*
        r2 = this;
        java.util.List<java.lang.String> r0 = r2.f22007ae
        if (r0 == 0) goto L_0x0034
        int r0 = r0.size()
        if (r0 <= r3) goto L_0x0034
        java.util.List<java.lang.String> r0 = r2.f22046s
        if (r0 != 0) goto L_0x0016
        java.util.ArrayList r0 = new java.util.ArrayList
        r0.<init>()
        r2.f22046s = r0
        goto L_0x0019
    L_0x0016:
        r0.clear()
    L_0x0019:
        r0 = 0
        r2.f21996V = r0
        r2.f21986L = r0
    L_0x001e:
        java.util.List<java.lang.String> r0 = r2.f22007ae
        int r0 = r0.size()
        if (r3 >= r0) goto L_0x0034
        java.util.List<java.lang.String> r0 = r2.f22046s
        java.util.List<java.lang.String> r1 = r2.f22007ae
        java.lang.Object r1 = r1.get(r3)
        r0.add(r1)
        int r3 = r3 + 1
        goto L_0x001e
    L_0x0034:
        return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.p530ss.android.socialbase.downloader.p562g.DownloadInfo.m27855n(boolean):void");
    }

    /* renamed from: I */
    public String mo32163I() {
        String str = this.f22031d;
        if (mo32308q() == 8) {
            List<String> list = this.f22007ae;
            if (list != null && !list.isEmpty() && !this.f21996V) {
                return (String) this.f22007ae.get(0);
            }
        }
        if (this.f21996V) {
            List<String> list2 = this.f22046s;
            if (list2 != null && list2.size() > 0) {
                int i = this.f21986L;
                if (i >= 0 && i < this.f22046s.size()) {
                    String str2 = (String) this.f22046s.get(this.f21986L);
                    if (!TextUtils.isEmpty(str2)) {
                        return str2;
                    }
                    return str;
                }
            }
        }
        if (TextUtils.isEmpty(this.f22031d)) {
            return str;
        }
        String str3 = "https";
        return (!this.f22031d.startsWith(str3) || !this.f22049v || !this.f21997W) ? str : this.f22031d.replaceFirst(str3, "http");
    }

    /* renamed from: J */
    public boolean mo32164J() {
        return this.f21996V;
    }

    /* renamed from: K */
    public String mo32165K() {
        if (this.f21996V) {
            List<String> list = this.f22046s;
            if (list != null && list.size() > 0) {
                int i = this.f21986L;
                if (i >= 0 && i < this.f22046s.size()) {
                    String str = (String) this.f22046s.get(this.f21986L);
                    if (!TextUtils.isEmpty(str)) {
                        return str;
                    }
                }
            }
        }
        return "";
    }

    /* renamed from: L */
    public void mo32166L() {
        this.f21998X = SystemClock.uptimeMillis();
        m27846a("dbjson_last_start_download_time", (Object) Long.valueOf(System.currentTimeMillis()));
    }

    /* renamed from: a */
    private void m27846a(String str, Object obj) {
        m27849bi();
        try {
            this.f22027ay.put(str, obj);
        } catch (Exception unused) {
        }
    }

    /* renamed from: M */
    public String mo32167M() {
        m27849bi();
        return this.f22027ay.optString("download_setting");
    }

    /* renamed from: N */
    public int mo32168N() {
        m27849bi();
        return this.f22027ay.optInt("retry_schedule_count", 0);
    }

    /* renamed from: a */
    public void mo32181a(int i) {
        m27849bi();
        try {
            this.f22027ay.put("retry_schedule_count", i);
        } catch (Exception unused) {
        }
    }

    /* renamed from: d */
    public void mo32271d(boolean z) {
        m27849bi();
        try {
            this.f22027ay.put("rw_concurrent", z ? 1 : 0);
        } catch (Exception unused) {
        }
    }

    /* renamed from: O */
    public boolean mo32169O() {
        m27849bi();
        return this.f22027ay.optInt("rw_concurrent", 0) == 1;
    }

    /* renamed from: P */
    public void mo32170P() {
        if (this.f21998X != 0) {
            long uptimeMillis = SystemClock.uptimeMillis() - this.f21998X;
            if (this.f21994T < 0) {
                this.f21994T = 0;
            }
            if (uptimeMillis > 0) {
                this.f21994T = uptimeMillis;
            }
        }
    }

    /* renamed from: Q */
    public void mo32171Q() {
        if (this.f21999Y == 0) {
            this.f21999Y = System.nanoTime();
        }
    }

    /* renamed from: R */
    public void mo32172R() {
        this.f21999Y = 0;
    }

    /* renamed from: e */
    public void mo32277e(boolean z) {
        long nanoTime = System.nanoTime();
        long j = this.f21999Y;
        if (j <= 0) {
            if (z) {
                this.f21999Y = nanoTime;
            }
            return;
        }
        long j2 = nanoTime - j;
        if (z) {
            this.f21999Y = nanoTime;
        } else {
            this.f21999Y = 0;
        }
        if (j2 > 0) {
            this.f21995U += j2;
        }
    }

    /* renamed from: S */
    public boolean mo32173S() {
        return this.f21980F;
    }

    /* renamed from: T */
    public boolean mo32174T() {
        return this.f22009ag;
    }

    /* renamed from: U */
    public boolean mo32175U() {
        return this.f21982H;
    }

    /* renamed from: V */
    public boolean mo32176V() {
        return this.f21983I;
    }

    /* renamed from: W */
    public boolean mo32177W() {
        return this.f22019aq;
    }

    /* renamed from: X */
    public boolean mo32178X() {
        return this.f22020ar;
    }

    /* renamed from: Y */
    public boolean mo32179Y() {
        return this.f22042o;
    }

    /* renamed from: Z */
    public long mo32180Z() {
        AtomicLong atomicLong = this.f21989O;
        if (atomicLong != null) {
            return atomicLong.get();
        }
        return 0;
    }

    /* renamed from: a */
    public void mo32182a(long j) {
        AtomicLong atomicLong = this.f21989O;
        if (atomicLong != null) {
            atomicLong.set(j);
        } else {
            this.f21989O = new AtomicLong(j);
        }
    }

    /* renamed from: a */
    public void mo32183a(long j, boolean z) {
        if (z) {
            mo32182a(j);
        } else if (j > mo32180Z()) {
            mo32182a(j);
        }
    }

    /* renamed from: aa */
    public ByteInvalidRetryStatus mo32224aa() {
        return this.f22008af;
    }

    /* renamed from: a */
    public void mo32187a(ByteInvalidRetryStatus bVar) {
        this.f22008af = bVar;
    }

    /* renamed from: f */
    public void mo32282f(boolean z) {
        this.f21992R = z;
    }

    /* renamed from: g */
    public void mo32286g(boolean z) {
        this.f21993S = z;
    }

    /* renamed from: b */
    public void mo32252b(long j) {
        this.f21989O.addAndGet(j);
    }

    /* renamed from: b */
    public void mo32253b(String str) {
        this.f21977C = str;
    }

    /* renamed from: c */
    public void mo32265c(String str) {
        this.f22029b = str;
    }

    /* renamed from: c */
    public void mo32264c(long j) {
        this.f21990P = j;
    }

    /* renamed from: b */
    public void mo32251b(int i) {
        AtomicInteger atomicInteger = this.f21991Q;
        if (atomicInteger != null) {
            atomicInteger.set(i);
        } else {
            this.f21991Q = new AtomicInteger(i);
        }
    }

    /* renamed from: h */
    public void mo32290h(boolean z) {
        this.f22018ap = z;
    }

    /* renamed from: d */
    public void mo32270d(String str) {
        this.f22050w = str;
    }

    /* renamed from: ab */
    public long mo32225ab() {
        return this.f21990P;
    }

    /* renamed from: ac */
    public String mo32226ac() {
        return this.f21977C;
    }

    /* renamed from: ad */
    public String mo32227ad() {
        return this.f21985K;
    }

    /* renamed from: e */
    public void mo32276e(String str) {
        this.f21985K = str;
    }

    /* renamed from: c */
    public void mo32263c(int i) {
        this.f21988N = i;
    }

    /* renamed from: ae */
    public int mo32228ae() {
        return this.f21987M;
    }

    /* renamed from: d */
    public void mo32269d(int i) {
        this.f21987M = i;
    }

    /* renamed from: i */
    public void mo32293i(boolean z) {
        this.f21984J = z;
    }

    /* renamed from: e */
    public void mo32274e(int i) {
        this.f22012aj = i;
    }

    /* renamed from: f */
    public void mo32281f(String str) {
        this.f22013ak = str;
    }

    /* renamed from: af */
    public boolean mo32229af() {
        return (!this.f22004ab && this.f22047t) || (this.f22004ab && (this.f22005ac || this.f22006ad));
    }

    /* renamed from: g */
    public void mo32285g(String str) {
        this.f22048u = str;
    }

    /* renamed from: ag */
    public boolean mo32230ag() {
        return this.f22047t;
    }

    /* renamed from: ah */
    public String mo32231ah() {
        return this.f22048u;
    }

    /* renamed from: ai */
    public boolean mo32232ai() {
        return this.f22049v;
    }

    /* renamed from: aj */
    public boolean mo32233aj() {
        return this.f22052y;
    }

    /* renamed from: ak */
    public String mo32234ak() {
        return this.f22053z;
    }

    /* renamed from: al */
    public int mo32235al() {
        return this.f21978D;
    }

    /* renamed from: am */
    public boolean mo32236am() {
        return this.f22017ao;
    }

    /* renamed from: an */
    public void mo32237an() {
        this.f22017ao = true;
    }

    /* renamed from: ao */
    public boolean mo32238ao() {
        return this.f22021as;
    }

    /* renamed from: ap */
    public boolean mo32239ap() {
        return this.f22022at;
    }

    /* renamed from: aq */
    public RetryDelayStatus mo32240aq() {
        return this.f21979E;
    }

    /* renamed from: ar */
    public AsyncHandleStatus mo32241ar() {
        return this.f21981G;
    }

    /* renamed from: as */
    public boolean mo32242as() {
        int q = mo32308q();
        return q == 7 || this.f21979E == RetryDelayStatus.DELAY_RETRY_WAITING || q == 8 || this.f21981G == AsyncHandleStatus.ASYNC_HANDLE_WAITING || this.f21981G == AsyncHandleStatus.ASYNC_HANDLE_RESTART || this.f22008af == ByteInvalidRetryStatus.BYTE_INVALID_RETRY_STATUS_RESTART;
    }

    /* renamed from: at */
    public void mo32243at() {
        int q = mo32308q();
        if (q == 7 || this.f21979E == RetryDelayStatus.DELAY_RETRY_WAITING) {
            mo32188a(RetryDelayStatus.DELAY_RETRY_DOWNLOADING);
        }
        if (q == 8 || this.f21981G == AsyncHandleStatus.ASYNC_HANDLE_WAITING || this.f21981G == AsyncHandleStatus.ASYNC_HANDLE_RESTART) {
            mo32186a(AsyncHandleStatus.ASYNC_HANDLE_DOWNLOADING);
        }
        if (this.f22008af == ByteInvalidRetryStatus.BYTE_INVALID_RETRY_STATUS_RESTART) {
            mo32187a(ByteInvalidRetryStatus.BYTE_INVALID_RETRY_STATUS_DOWNLOADING);
        }
    }

    /* renamed from: au */
    public boolean mo32244au() {
        return this.f22052y && mo32308q() != -3 && this.f21979E == RetryDelayStatus.DELAY_RETRY_WAITING;
    }

    /* renamed from: a */
    public void mo32188a(RetryDelayStatus jVar) {
        this.f21979E = jVar;
    }

    /* renamed from: av */
    public boolean mo32245av() {
        return mo32308q() != -3 && this.f21981G == AsyncHandleStatus.ASYNC_HANDLE_WAITING;
    }

    /* renamed from: a */
    public void mo32186a(AsyncHandleStatus aVar) {
        this.f21981G = aVar;
    }

    /* renamed from: f */
    public void mo32279f(int i) {
        this.f21978D = (this.f21996V ? this.f22041n : this.f22040m) - i;
        if (this.f21978D < 0) {
            this.f21978D = 0;
        }
    }

    /* renamed from: aw */
    public long mo32246aw() {
        return this.f21994T;
    }

    /* renamed from: ax */
    public long mo32247ax() {
        return TimeUnit.NANOSECONDS.toMillis(this.f21995U);
    }

    /* renamed from: a */
    public void mo32191a(DownloadInfo cVar, boolean z) {
        if (cVar != null) {
            mo32263c(cVar.mo32219aV());
            mo32264c(cVar.mo32225ab());
            mo32183a(cVar.mo32180Z(), true);
            this.f21995U = cVar.f21995U;
            if (cVar.mo32242as() || mo32242as()) {
                this.f21978D = cVar.mo32235al();
            } else {
                this.f21978D = 0;
                this.f22017ao = false;
                this.f21996V = false;
                this.f21986L = 0;
                this.f21997W = false;
            }
            mo32253b(cVar.mo32226ac());
            if (z) {
                mo32251b(cVar.mo32308q());
            }
            this.f21992R = cVar.mo32248ay();
            this.f21993S = cVar.mo32249az();
            this.f21979E = cVar.mo32240aq();
            m27847a(cVar.f22027ay);
        }
    }

    /* renamed from: bi */
    private void m27849bi() {
        if (this.f22027ay == null) {
            try {
                if (!TextUtils.isEmpty(this.f22028az)) {
                    this.f22027ay = new JSONObject(this.f22028az);
                } else {
                    this.f22027ay = new JSONObject();
                }
            } catch (Exception unused) {
                this.f22027ay = new JSONObject();
            }
        }
    }

    /* renamed from: a */
    private void m27847a(JSONObject jSONObject) {
        if (jSONObject != null) {
            m27849bi();
            try {
                Iterator keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String str = (String) keys.next();
                    Object opt = jSONObject.opt(str);
                    if (!this.f22027ay.has(str)) {
                        if (opt != null) {
                            this.f22027ay.put(str, opt);
                        }
                    }
                }
            } catch (Exception unused) {
            }
        }
    }

    /* renamed from: ay */
    public boolean mo32248ay() {
        return this.f21992R;
    }

    /* renamed from: az */
    public boolean mo32249az() {
        return this.f21993S;
    }

    /* renamed from: a */
    public boolean mo32197a(DownloadInfo cVar) {
        boolean z = false;
        if (cVar == null) {
            return false;
        }
        String str = this.f22031d;
        if (str != null && str.equals(cVar.mo32295j())) {
            String str2 = this.f22032e;
            if (str2 != null && str2.equals(cVar.mo32297k())) {
                z = true;
            }
        }
        return z;
    }

    /* renamed from: g */
    public void mo32284g(int i) {
        this.f22001a = i;
    }

    /* renamed from: aA */
    public boolean mo32198aA() {
        return !mo32317x() || DownloadUtils.m28773a(C6694b.m27342B());
    }

    /* renamed from: aB */
    public boolean mo32199aB() {
        return DownloadStatus.m26981a(mo32308q());
    }

    /* renamed from: aC */
    public List<String> mo32200aC() {
        return this.f22046s;
    }

    /* renamed from: aD */
    public boolean mo32201aD() {
        return DownloadUtils.m28791b(this.f21990P);
    }

    /* renamed from: aE */
    public boolean mo32202aE() {
        return this.f22043p;
    }

    /* renamed from: aF */
    public int mo32203aF() {
        return this.f22044q;
    }

    /* renamed from: d */
    public long mo32267d(long j) {
        int i = this.f22044q;
        if (i <= 0) {
            i = 100;
        }
        long j2 = j / ((long) (i + 1));
        return j2 <= 0 ? PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED : j2;
    }

    /* renamed from: aG */
    public int mo32204aG() {
        int i = this.f22045r;
        if (i < 1000) {
            return 1000;
        }
        return i;
    }

    /* renamed from: aH */
    public boolean mo32205aH() {
        return TextUtils.isEmpty(this.f22031d) || TextUtils.isEmpty(this.f22029b) || TextUtils.isEmpty(this.f22032e);
    }

    /* renamed from: aI */
    public boolean mo32206aI() {
        return DownloadUtils.m28802c(this);
    }

    /* renamed from: aJ */
    public boolean mo32207aJ() {
        if (this.f21996V) {
            this.f21986L++;
        }
        List<String> list = this.f22046s;
        if (!(list == null || list.size() == 0 || this.f21986L < 0)) {
            while (this.f21986L < this.f22046s.size()) {
                if (!TextUtils.isEmpty((String) this.f22046s.get(this.f21986L))) {
                    this.f21996V = true;
                    return true;
                }
                this.f21986L++;
            }
        }
        return false;
    }

    /* renamed from: aK */
    public boolean mo32208aK() {
        List<String> list = this.f22046s;
        if (list != null && list.size() > 0) {
            if (!this.f21996V) {
                return true;
            }
            int i = this.f21986L;
            if (i >= 0 && i < this.f22046s.size() - 1) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: aL */
    public boolean mo32209aL() {
        return !TextUtils.isEmpty(this.f22031d) && this.f22031d.startsWith("https") && this.f22049v && !this.f21997W;
    }

    /* renamed from: j */
    public void mo32296j(boolean z) {
        this.f21997W = z;
    }

    /* renamed from: a */
    public synchronized void mo32189a(ITempFileSaveCompleteCallback fVar) {
        if (fVar != null) {
            try {
                C6704a.m27758b("DownloadInfo", "registerTempFileSaveCallback");
                if (this.f22016an == null) {
                    this.f22016an = new ArrayList();
                }
                if (!this.f22016an.contains(fVar)) {
                    this.f22016an.add(fVar);
                }
            } catch (Throwable th) {
                th.printStackTrace();
                fVar.mo31758a(new BaseException(1038, DownloadUtils.m28786b(th, "registerTempFileSaveCallback")));
            }
        } else {
            return;
        }
        return;
    }

    /* renamed from: h */
    public void mo32289h(String str) {
        mo32183a(0, true);
        mo32264c(0);
        mo32253b(str);
        mo32263c(1);
        this.f21994T = 0;
        this.f21999Y = 0;
        this.f21995U = 0;
    }

    /* renamed from: aM */
    public void mo32210aM() {
        mo32183a(0, true);
        this.f21990P = 0;
        this.f21988N = 1;
        this.f21994T = 0;
        this.f21999Y = 0;
        this.f21995U = 0;
    }

    /* renamed from: aN */
    public boolean mo32211aN() {
        if (mo32205aH()) {
            return false;
        }
        File file = new File(mo32300l(), mo32303m());
        boolean exists = file.exists();
        boolean isDirectory = file.isDirectory();
        if (exists && !isDirectory) {
            long length = file.length();
            long Z = mo32180Z();
            if (length > 0 && Z > 0) {
                long j = this.f21990P;
                if (j > 0 && this.f21988N > 0 && length >= Z && length <= j && Z < j) {
                    return true;
                }
            }
        }
        return false;
    }

    /* renamed from: aO */
    public boolean mo32212aO() {
        if (this.f21988N > 1) {
            IDownloadCache p = C6694b.m27384p();
            if (p != null) {
                List<DownloadChunk> c = p.mo31685c(mo32283g());
                if (c == null || c.size() != this.f21988N) {
                    return false;
                }
                long j = 0;
                for (DownloadChunk bVar : c) {
                    if (bVar != null) {
                        j += bVar.mo32137o();
                    }
                }
                if (j != mo32180Z()) {
                    mo32182a(j);
                }
            }
        }
        return true;
    }

    /* renamed from: aP */
    public synchronized boolean mo32213aP() {
        return this.f22015am;
    }

    /* renamed from: k */
    public synchronized void mo32299k(boolean z) {
        this.f22015am = z;
    }

    /* renamed from: a */
    public synchronized void mo32195a(boolean z, BaseException aVar) {
        this.f22015am = false;
        if (this.f22016an != null) {
            String str = "DownloadInfo";
            StringBuilder sb = new StringBuilder();
            sb.append("handleTempSaveCallback isSuccess ");
            sb.append(z);
            sb.append(" callback size:");
            sb.append(this.f22016an.size());
            C6704a.m27758b(str, sb.toString());
            for (ITempFileSaveCompleteCallback fVar : this.f22016an) {
                if (fVar != null) {
                    if (z) {
                        fVar.mo31757a();
                    } else {
                        fVar.mo31758a(aVar);
                    }
                }
            }
        }
    }

    /* renamed from: l */
    public void mo32302l(boolean z) {
        this.f22022at = z;
    }

    /* renamed from: aQ */
    public boolean mo32214aQ() {
        if (!mo32211aN()) {
            return false;
        }
        return mo32212aO();
    }

    /* renamed from: aR */
    public boolean mo32215aR() {
        if (this.f21992R && !TextUtils.isEmpty(mo32300l()) && !TextUtils.isEmpty(mo32303m())) {
            return !new File(mo32300l(), mo32303m()).exists();
        }
        return false;
    }

    /* renamed from: aS */
    public Md5CheckStatus mo32216aS() {
        return DownloadUtils.m28751a(mo32297k(), mo32287h(), this.f22051x);
    }

    /* renamed from: aT */
    public boolean mo32217aT() {
        int q = mo32308q();
        if (q == 4 || q == 3 || q == -1 || q == 5 || q == 8) {
            return true;
        }
        if ((q == 1 || q == 2) && mo32180Z() > 0) {
            return true;
        }
        return false;
    }

    /* renamed from: aU */
    public boolean mo32218aU() {
        return mo32308q() == 0;
    }

    /* renamed from: aV */
    public int mo32219aV() {
        return this.f21988N;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f22001a);
        parcel.writeString(this.f22029b);
        parcel.writeString(this.f22030c);
        parcel.writeString(this.f22031d);
        parcel.writeString(this.f22032e);
        parcel.writeString(this.f22033f);
        parcel.writeByte(this.f22034g ? (byte) 1 : 0);
        parcel.writeString(this.f22035h);
        parcel.writeTypedList(this.f22036i);
        parcel.writeInt(this.f22037j);
        parcel.writeStringArray(this.f22038k);
        parcel.writeIntArray(this.f22039l);
        parcel.writeInt(this.f22040m);
        parcel.writeInt(this.f22041n);
        parcel.writeByte(this.f22042o ? (byte) 1 : 0);
        parcel.writeByte(this.f22043p ? (byte) 1 : 0);
        parcel.writeInt(this.f22044q);
        parcel.writeInt(this.f22045r);
        parcel.writeStringList(this.f22046s);
        parcel.writeByte(this.f22047t ? (byte) 1 : 0);
        parcel.writeString(this.f22048u);
        parcel.writeByte(this.f22049v ? (byte) 1 : 0);
        parcel.writeString(this.f22050w);
        parcel.writeString(this.f22051x);
        parcel.writeByte(this.f22052y ? (byte) 1 : 0);
        parcel.writeByte(this.f21975A ? (byte) 1 : 0);
        parcel.writeByte(this.f21976B ? (byte) 1 : 0);
        parcel.writeString(this.f22053z);
        parcel.writeString(this.f21977C);
        parcel.writeInt(this.f21978D);
        parcel.writeInt(this.f21979E.ordinal());
        parcel.writeByte(this.f21980F ? (byte) 1 : 0);
        parcel.writeByte(this.f21984J ? (byte) 1 : 0);
        parcel.writeString(this.f21985K);
        parcel.writeInt(this.f21986L);
        parcel.writeInt(this.f21987M);
        parcel.writeInt(this.f21988N);
        parcel.writeLong(mo32180Z());
        parcel.writeLong(this.f21990P);
        parcel.writeInt(mo32315w());
        parcel.writeLong(this.f21994T);
        parcel.writeLong(this.f21995U);
        parcel.writeByte(this.f21996V ? (byte) 1 : 0);
        parcel.writeByte(this.f21997W ? (byte) 1 : 0);
        StringBuffer stringBuffer = this.f22000Z;
        parcel.writeString(stringBuffer != null ? stringBuffer.toString() : "");
        parcel.writeByte(this.f22004ab ? (byte) 1 : 0);
        parcel.writeByte(this.f22005ac ? (byte) 1 : 0);
        parcel.writeByte(this.f22006ad ? (byte) 1 : 0);
        parcel.writeStringList(this.f22007ae);
        parcel.writeByte(this.f22009ag ? (byte) 1 : 0);
        parcel.writeInt(this.f22010ah.ordinal());
        parcel.writeByte(this.f21982H ? (byte) 1 : 0);
        parcel.writeInt(this.f22012aj);
        parcel.writeString(this.f22013ak);
        parcel.writeByte(this.f22015am ? (byte) 1 : 0);
        parcel.writeByte(this.f22017ao ? (byte) 1 : 0);
        parcel.writeByte(this.f22019aq ? (byte) 1 : 0);
        parcel.writeByte(this.f22020ar ? (byte) 1 : 0);
        parcel.writeByte(this.f22021as ? (byte) 1 : 0);
        parcel.writeByte(this.f22022at ? (byte) 1 : 0);
        parcel.writeParcelable(this.f22024av, i);
        parcel.writeInt(this.f22025aw);
        JSONObject jSONObject = this.f22027ay;
        parcel.writeString(jSONObject == null ? this.f22028az : jSONObject.toString());
        parcel.writeByte(this.f22018ap ? (byte) 1 : 0);
    }

    /* renamed from: aW */
    public BaseException mo32220aW() {
        return this.f22024av;
    }

    /* renamed from: a */
    public void mo32190a(BaseException aVar) {
        this.f22024av = aVar;
    }

    /* renamed from: bj */
    private void m27850bj() {
        if (this.f22026ax == null) {
            Context B = C6694b.m27342B();
            if (B != null) {
                String string = B.getSharedPreferences("sp_download_info", 0).getString(Long.toString((long) mo32283g()), "");
                if (!TextUtils.isEmpty(string)) {
                    try {
                        this.f22026ax = new JSONObject(string);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
            if (this.f22026ax == null) {
                this.f22026ax = new JSONObject();
            }
        }
    }

    /* renamed from: aX */
    public void mo32221aX() {
        if (this.f22026ax != null) {
            Context B = C6694b.m27342B();
            if (B != null) {
                B.getSharedPreferences("sp_download_info", 0).edit().putString(Integer.toString(mo32283g()), this.f22026ax.toString()).apply();
            }
        }
    }

    /* renamed from: aY */
    public void mo32222aY() {
        Context B = C6694b.m27342B();
        if (B != null) {
            try {
                B.getSharedPreferences("sp_download_info", 0).edit().remove(Integer.toString(mo32283g())).apply();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    /* renamed from: aZ */
    public int mo32223aZ() {
        m27850bj();
        return this.f22026ax.optInt("failed_resume_count", 0);
    }

    /* renamed from: h */
    public void mo32288h(int i) {
        m27850bj();
        try {
            this.f22026ax.put("failed_resume_count", i);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: ba */
    public long mo32255ba() {
        m27850bj();
        return this.f22026ax.optLong("last_failed_resume_time", 0);
    }

    /* renamed from: e */
    public void mo32275e(long j) {
        m27850bj();
        try {
            this.f22026ax.put("last_failed_resume_time", j);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: bb */
    public int mo32256bb() {
        m27850bj();
        return this.f22026ax.optInt("uninstall_resume_count", 0);
    }

    /* renamed from: i */
    public void mo32292i(int i) {
        m27850bj();
        try {
            this.f22026ax.put("uninstall_resume_count", i);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: bc */
    public long mo32257bc() {
        m27850bj();
        return this.f22026ax.optLong("last_uninstall_resume_time", 0);
    }

    /* renamed from: f */
    public void mo32280f(long j) {
        m27850bj();
        try {
            this.f22026ax.put("last_uninstall_resume_time", j);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: bd */
    public long mo32258bd() {
        m27849bi();
        return this.f22027ay.optLong("dbjson_last_start_download_time", 0);
    }

    /* renamed from: j */
    public int mo32294j(int i) {
        m27849bi();
        return this.f22027ay.optInt("anti_hijack_error_code", i);
    }

    /* renamed from: k */
    public void mo32298k(int i) {
        m27849bi();
        try {
            this.f22027ay.put("anti_hijack_error_code", i);
        } catch (Exception unused) {
        }
    }

    /* renamed from: be */
    public boolean mo32259be() {
        m27849bi();
        return this.f22027ay.optBoolean("is_save_path_redirected", false);
    }

    /* renamed from: m */
    public void mo32304m(boolean z) {
        m27849bi();
        try {
            this.f22027ay.put("is_save_path_redirected", z);
        } catch (Exception unused) {
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("DownloadInfo{id=");
        sb.append(this.f22001a);
        sb.append(", name='");
        sb.append(this.f22029b);
        sb.append('\'');
        sb.append(", title='");
        sb.append(this.f22030c);
        sb.append('\'');
        sb.append(", url='");
        sb.append(this.f22031d);
        sb.append('\'');
        sb.append(", savePath='");
        sb.append(this.f22032e);
        sb.append('\'');
        sb.append('}');
        return sb.toString();
    }

    /* renamed from: bf */
    public int mo32260bf() {
        m27849bi();
        return this.f22027ay.optInt("dbjson_key_preconnect_level", 0);
    }

    /* renamed from: l */
    public void mo32301l(int i) {
        m27849bi();
        m27846a("dbjson_key_preconnect_level", (Object) Integer.valueOf(i));
    }

    /* renamed from: bk */
    private void m27851bk() {
        if (this.f22002aA == null) {
            synchronized (this) {
                if (this.f22002aA == null) {
                    this.f22002aA = new Bundle();
                }
            }
        }
    }

    /* renamed from: bg */
    public Bundle mo32261bg() {
        m27851bk();
        return this.f22002aA;
    }
}
