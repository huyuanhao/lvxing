package p681me.jessyan.retrofiturlmanager.parser;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;
import okhttp3.C8506t;
import okhttp3.C8506t.C8507a;
import p681me.jessyan.retrofiturlmanager.RetrofitUrlManager;
import p681me.jessyan.retrofiturlmanager.cache.Cache;
import p681me.jessyan.retrofiturlmanager.cache.LruCache;

/* renamed from: me.jessyan.retrofiturlmanager.parser.SuperUrlParser */
public class SuperUrlParser implements UrlParser {
    private Cache<String, String> mCache;
    private RetrofitUrlManager mRetrofitUrlManager;

    public void init(RetrofitUrlManager retrofitUrlManager) {
        this.mRetrofitUrlManager = retrofitUrlManager;
        this.mCache = new LruCache(100);
    }

    public C8506t parseUrl(C8506t tVar, C8506t tVar2) {
        if (tVar == null) {
            return tVar2;
        }
        C8507a q = tVar2.mo40568q();
        int resolvePathSize = resolvePathSize(tVar2, q);
        if (TextUtils.isEmpty((CharSequence) this.mCache.get(getKey(tVar, tVar2, resolvePathSize)))) {
            for (int i = 0; i < tVar2.mo40558h(); i++) {
                q.mo40576b(0);
            }
            ArrayList<String> arrayList = new ArrayList<>();
            arrayList.addAll(tVar.mo40561j());
            if (tVar2.mo40558h() > resolvePathSize) {
                List j = tVar2.mo40561j();
                for (int i2 = resolvePathSize; i2 < j.size(); i2++) {
                    arrayList.add(j.get(i2));
                }
            } else if (tVar2.mo40558h() < resolvePathSize) {
                StringBuilder sb = new StringBuilder();
                sb.append(tVar2.mo40549b());
                sb.append("://");
                sb.append(tVar2.mo40556f());
                sb.append(tVar2.mo40560i());
                throw new IllegalArgumentException(String.format("Your final path is %s, the pathSize = %d, but the #baseurl_path_size = %d, #baseurl_path_size must be less than or equal to pathSize of the final path", new Object[]{sb.toString(), Integer.valueOf(tVar2.mo40558h()), Integer.valueOf(resolvePathSize)}));
            }
            for (String e : arrayList) {
                q.mo40582e(e);
            }
        } else {
            q.mo40583f((String) this.mCache.get(getKey(tVar, tVar2, resolvePathSize)));
        }
        C8506t c = q.mo40572a(tVar.mo40549b()).mo40581d(tVar.mo40556f()).mo40571a(tVar.mo40557g()).mo40580c();
        if (TextUtils.isEmpty((CharSequence) this.mCache.get(getKey(tVar, tVar2, resolvePathSize)))) {
            this.mCache.put(getKey(tVar, tVar2, resolvePathSize), c.mo40560i());
        }
        return c;
    }

    private String getKey(C8506t tVar, C8506t tVar2, int i) {
        StringBuilder sb = new StringBuilder();
        sb.append(tVar.mo40560i());
        sb.append(tVar2.mo40560i());
        sb.append(i);
        return sb.toString();
    }

    private int resolvePathSize(C8506t tVar, C8507a aVar) {
        String o = tVar.mo40566o();
        StringBuffer stringBuffer = new StringBuffer();
        String str = "#";
        String str2 = "=";
        int i = 0;
        if (o.indexOf(str) == -1) {
            String[] split = o.split(str2);
            if (split.length > 1) {
                i = Integer.parseInt(split[1]);
            }
        } else {
            String str3 = RetrofitUrlManager.IDENTIFICATION_PATH_SIZE;
            if (o.indexOf(str3) == -1) {
                int indexOf = o.indexOf(str);
                stringBuffer.append(o.substring(indexOf + 1, o.length()));
                String[] split2 = o.substring(0, indexOf).split(str2);
                if (split2.length > 1) {
                    i = Integer.parseInt(split2[1]);
                }
            } else {
                String[] split3 = o.split(str3);
                stringBuffer.append(split3[0]);
                if (split3.length > 1) {
                    int indexOf2 = split3[1].indexOf(str);
                    if (indexOf2 != -1) {
                        stringBuffer.append(split3[1].substring(indexOf2, split3[1].length()));
                        String substring = split3[1].substring(0, indexOf2);
                        if (!TextUtils.isEmpty(substring)) {
                            i = Integer.parseInt(substring);
                        }
                    } else {
                        i = Integer.parseInt(split3[1]);
                    }
                }
            }
        }
        if (TextUtils.isEmpty(stringBuffer.toString())) {
            aVar.mo40585h(null);
        } else {
            aVar.mo40585h(stringBuffer.toString());
        }
        return i;
    }
}
