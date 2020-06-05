package p681me.jessyan.retrofiturlmanager.parser;

import okhttp3.C8506t;
import p681me.jessyan.retrofiturlmanager.RetrofitUrlManager;

/* renamed from: me.jessyan.retrofiturlmanager.parser.DefaultUrlParser */
public class DefaultUrlParser implements UrlParser {
    private volatile UrlParser mAdvancedUrlParser;
    private UrlParser mDomainUrlParser;
    private RetrofitUrlManager mRetrofitUrlManager;
    private volatile UrlParser mSuperUrlParser;

    public void init(RetrofitUrlManager retrofitUrlManager) {
        this.mRetrofitUrlManager = retrofitUrlManager;
        this.mDomainUrlParser = new DomainUrlParser();
        this.mDomainUrlParser.init(retrofitUrlManager);
    }

    public C8506t parseUrl(C8506t tVar, C8506t tVar2) {
        if (tVar == null) {
            return tVar2;
        }
        if (tVar2.toString().contains(RetrofitUrlManager.IDENTIFICATION_PATH_SIZE)) {
            if (this.mSuperUrlParser == null) {
                synchronized (this) {
                    if (this.mSuperUrlParser == null) {
                        this.mSuperUrlParser = new SuperUrlParser();
                        this.mSuperUrlParser.init(this.mRetrofitUrlManager);
                    }
                }
            }
            return this.mSuperUrlParser.parseUrl(tVar, tVar2);
        } else if (!this.mRetrofitUrlManager.isAdvancedModel()) {
            return this.mDomainUrlParser.parseUrl(tVar, tVar2);
        } else {
            if (this.mAdvancedUrlParser == null) {
                synchronized (this) {
                    if (this.mAdvancedUrlParser == null) {
                        this.mAdvancedUrlParser = new AdvancedUrlParser();
                        this.mAdvancedUrlParser.init(this.mRetrofitUrlManager);
                    }
                }
            }
            return this.mAdvancedUrlParser.parseUrl(tVar, tVar2);
        }
    }
}
