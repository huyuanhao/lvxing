package p681me.jessyan.retrofiturlmanager;

import android.text.TextUtils;
import android.util.Log;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import okhttp3.C8362ab;
import okhttp3.C8506t;
import okhttp3.C8508u;
import okhttp3.C8508u.C8509a;
import okhttp3.C8513x.C8515a;
import okhttp3.C8518z;
import okhttp3.C8518z.C8519a;
import p681me.jessyan.retrofiturlmanager.parser.DefaultUrlParser;
import p681me.jessyan.retrofiturlmanager.parser.UrlParser;

/* renamed from: me.jessyan.retrofiturlmanager.RetrofitUrlManager */
public class RetrofitUrlManager {
    private static final boolean DEPENDENCY_OKHTTP;
    private static final String DOMAIN_NAME = "Domain-Name";
    public static final String DOMAIN_NAME_HEADER = "Domain-Name: ";
    private static final String GLOBAL_DOMAIN_NAME = "me.jessyan.retrofiturlmanager.globalDomainName";
    public static final String IDENTIFICATION_IGNORE = "#url_ignore";
    public static final String IDENTIFICATION_PATH_SIZE = "#baseurl_path_size=";
    private static final String TAG = "RetrofitUrlManager";
    private C8506t baseUrl;
    private boolean debug;
    private boolean isRun;
    private final Map<String, C8506t> mDomainNameHub;
    private final C8508u mInterceptor;
    private final List<onUrlChangeListener> mListeners;
    private UrlParser mUrlParser;
    private int pathSize;

    /* renamed from: me.jessyan.retrofiturlmanager.RetrofitUrlManager$RetrofitUrlManagerHolder */
    private static class RetrofitUrlManagerHolder {
        /* access modifiers changed from: private|static|final */
        public static final RetrofitUrlManager INSTANCE = new RetrofitUrlManager();

        private RetrofitUrlManagerHolder() {
        }
    }

    static {
        boolean z;
        try {
            Class.forName("okhttp3.x");
            z = true;
        } catch (ClassNotFoundException unused) {
            z = false;
        }
        DEPENDENCY_OKHTTP = z;
    }

    private RetrofitUrlManager() {
        this.isRun = true;
        this.debug = false;
        this.mDomainNameHub = new HashMap();
        this.mListeners = new ArrayList();
        if (DEPENDENCY_OKHTTP) {
            DefaultUrlParser defaultUrlParser = new DefaultUrlParser();
            defaultUrlParser.init(this);
            setUrlParser(defaultUrlParser);
            this.mInterceptor = new C8508u() {
                public C8362ab intercept(C8509a aVar) throws IOException {
                    if (!RetrofitUrlManager.this.isRun()) {
                        return aVar.mo40244a(aVar.mo40246a());
                    }
                    return aVar.mo40244a(RetrofitUrlManager.this.processRequest(aVar.mo40246a()));
                }
            };
            return;
        }
        throw new IllegalStateException("Must be dependency Okhttp");
    }

    public static final RetrofitUrlManager getInstance() {
        return RetrofitUrlManagerHolder.INSTANCE;
    }

    public C8515a with(C8515a aVar) {
        Utils.checkNotNull(aVar, "builder cannot be null");
        return aVar.mo40630a(this.mInterceptor);
    }

    public C8518z processRequest(C8518z zVar) {
        C8506t tVar;
        if (zVar == null) {
            return zVar;
        }
        C8519a e = zVar.mo40650e();
        String tVar2 = zVar.mo40645a().toString();
        if (tVar2.contains(IDENTIFICATION_IGNORE)) {
            return pruneIdentification(e, tVar2);
        }
        String obtainDomainNameFromHeaders = obtainDomainNameFromHeaders(zVar);
        Object[] listenersToArray = listenersToArray();
        if (!TextUtils.isEmpty(obtainDomainNameFromHeaders)) {
            notifyListener(zVar, obtainDomainNameFromHeaders, listenersToArray);
            tVar = fetchDomain(obtainDomainNameFromHeaders);
            e.mo40661b(DOMAIN_NAME);
        } else {
            notifyListener(zVar, GLOBAL_DOMAIN_NAME, listenersToArray);
            tVar = getGlobalDomain();
        }
        if (tVar == null) {
            return e.mo40663b();
        }
        C8506t parseUrl = this.mUrlParser.parseUrl(tVar, zVar.mo40645a());
        if (this.debug) {
            StringBuilder sb = new StringBuilder();
            sb.append("The new url is { ");
            sb.append(parseUrl.toString());
            sb.append(" }, old url is { ");
            sb.append(zVar.mo40645a().toString());
            sb.append(" }");
            Log.d(TAG, sb.toString());
        }
        if (listenersToArray != null) {
            for (Object obj : listenersToArray) {
                ((onUrlChangeListener) obj).onUrlChanged(parseUrl, zVar.mo40645a());
            }
        }
        return e.mo40660a(parseUrl).mo40663b();
    }

    private C8518z pruneIdentification(C8519a aVar, String str) {
        String[] split = str.split(IDENTIFICATION_IGNORE);
        StringBuffer stringBuffer = new StringBuffer();
        for (String append : split) {
            stringBuffer.append(append);
        }
        return aVar.mo40655a(stringBuffer.toString()).mo40663b();
    }

    private void notifyListener(C8518z zVar, String str, Object[] objArr) {
        if (objArr != null) {
            for (int i = 0; i < objArr.length; i++) {
                objArr[i].onUrlChangeBefore(zVar.mo40645a(), str);
            }
        }
    }

    public boolean isRun() {
        return this.isRun;
    }

    public void setRun(boolean z) {
        this.isRun = z;
    }

    public void setDebug(boolean z) {
        this.debug = z;
    }

    public void startAdvancedModel(String str) {
        Utils.checkNotNull(str, "baseUrl cannot be null");
        startAdvancedModel(Utils.checkUrl(str));
    }

    public synchronized void startAdvancedModel(C8506t tVar) {
        Utils.checkNotNull(tVar, "baseUrl cannot be null");
        this.baseUrl = tVar;
        this.pathSize = tVar.mo40558h();
        List k = tVar.mo40562k();
        if ("".equals(k.get(k.size() - 1))) {
            this.pathSize--;
        }
    }

    public int getPathSize() {
        return this.pathSize;
    }

    public boolean isAdvancedModel() {
        return this.baseUrl != null;
    }

    public C8506t getBaseUrl() {
        return this.baseUrl;
    }

    public String setUrlNotChange(String str) {
        Utils.checkNotNull(str, "url cannot be null");
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(IDENTIFICATION_IGNORE);
        return sb.toString();
    }

    public String setPathSizeOfUrl(String str, int i) {
        Utils.checkNotNull(str, "url cannot be null");
        if (i >= 0) {
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append(IDENTIFICATION_PATH_SIZE);
            sb.append(i);
            return sb.toString();
        }
        throw new IllegalArgumentException("pathSize must be >= 0");
    }

    public void setGlobalDomain(String str) {
        Utils.checkNotNull(str, "globalDomain cannot be null");
        synchronized (this.mDomainNameHub) {
            this.mDomainNameHub.put(GLOBAL_DOMAIN_NAME, Utils.checkUrl(str));
        }
    }

    public synchronized C8506t getGlobalDomain() {
        return (C8506t) this.mDomainNameHub.get(GLOBAL_DOMAIN_NAME);
    }

    public void removeGlobalDomain() {
        synchronized (this.mDomainNameHub) {
            this.mDomainNameHub.remove(GLOBAL_DOMAIN_NAME);
        }
    }

    public void putDomain(String str, String str2) {
        Utils.checkNotNull(str, "domainName cannot be null");
        Utils.checkNotNull(str2, "domainUrl cannot be null");
        synchronized (this.mDomainNameHub) {
            this.mDomainNameHub.put(str, Utils.checkUrl(str2));
        }
    }

    public synchronized C8506t fetchDomain(String str) {
        Utils.checkNotNull(str, "domainName cannot be null");
        return (C8506t) this.mDomainNameHub.get(str);
    }

    public void removeDomain(String str) {
        Utils.checkNotNull(str, "domainName cannot be null");
        synchronized (this.mDomainNameHub) {
            this.mDomainNameHub.remove(str);
        }
    }

    public void clearAllDomain() {
        this.mDomainNameHub.clear();
    }

    public synchronized boolean haveDomain(String str) {
        return this.mDomainNameHub.containsKey(str);
    }

    public synchronized int domainSize() {
        return this.mDomainNameHub.size();
    }

    public void setUrlParser(UrlParser urlParser) {
        Utils.checkNotNull(urlParser, "parser cannot be null");
        this.mUrlParser = urlParser;
    }

    public void registerUrlChangeListener(onUrlChangeListener onurlchangelistener) {
        Utils.checkNotNull(onurlchangelistener, "listener cannot be null");
        synchronized (this.mListeners) {
            this.mListeners.add(onurlchangelistener);
        }
    }

    public void unregisterUrlChangeListener(onUrlChangeListener onurlchangelistener) {
        Utils.checkNotNull(onurlchangelistener, "listener cannot be null");
        synchronized (this.mListeners) {
            this.mListeners.remove(onurlchangelistener);
        }
    }

    private Object[] listenersToArray() {
        Object[] array;
        synchronized (this.mListeners) {
            array = this.mListeners.size() > 0 ? this.mListeners.toArray() : null;
        }
        return array;
    }

    private String obtainDomainNameFromHeaders(C8518z zVar) {
        String str = DOMAIN_NAME;
        List b = zVar.mo40647b(str);
        if (b == null || b.size() == 0) {
            return null;
        }
        if (b.size() <= 1) {
            return zVar.mo40644a(str);
        }
        throw new IllegalArgumentException("Only one Domain-Name in the headers");
    }
}
