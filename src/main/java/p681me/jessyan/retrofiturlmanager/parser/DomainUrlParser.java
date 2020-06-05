package p681me.jessyan.retrofiturlmanager.parser;

import android.text.TextUtils;
import java.util.ArrayList;
import okhttp3.C8506t;
import okhttp3.C8506t.C8507a;
import p681me.jessyan.retrofiturlmanager.RetrofitUrlManager;
import p681me.jessyan.retrofiturlmanager.cache.Cache;
import p681me.jessyan.retrofiturlmanager.cache.LruCache;

/* renamed from: me.jessyan.retrofiturlmanager.parser.DomainUrlParser */
public class DomainUrlParser implements UrlParser {
    private Cache<String, String> mCache;

    public void init(RetrofitUrlManager retrofitUrlManager) {
        this.mCache = new LruCache(100);
    }

    public C8506t parseUrl(C8506t tVar, C8506t tVar2) {
        if (tVar == null) {
            return tVar2;
        }
        C8507a q = tVar2.mo40568q();
        if (TextUtils.isEmpty((CharSequence) this.mCache.get(getKey(tVar, tVar2)))) {
            for (int i = 0; i < tVar2.mo40558h(); i++) {
                q.mo40576b(0);
            }
            ArrayList<String> arrayList = new ArrayList<>();
            arrayList.addAll(tVar.mo40561j());
            arrayList.addAll(tVar2.mo40561j());
            for (String e : arrayList) {
                q.mo40582e(e);
            }
        } else {
            q.mo40583f((String) this.mCache.get(getKey(tVar, tVar2)));
        }
        C8506t c = q.mo40572a(tVar.mo40549b()).mo40581d(tVar.mo40556f()).mo40571a(tVar.mo40557g()).mo40580c();
        if (TextUtils.isEmpty((CharSequence) this.mCache.get(getKey(tVar, tVar2)))) {
            this.mCache.put(getKey(tVar, tVar2), c.mo40560i());
        }
        return c;
    }

    private String getKey(C8506t tVar, C8506t tVar2) {
        StringBuilder sb = new StringBuilder();
        sb.append(tVar.mo40560i());
        sb.append(tVar2.mo40560i());
        return sb.toString();
    }
}
