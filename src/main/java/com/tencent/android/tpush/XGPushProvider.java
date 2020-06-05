package com.tencent.android.tpush;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.UriMatcher;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build.VERSION;
import com.tencent.android.tpush.common.C6914l;
import com.tencent.android.tpush.common.Constants;
import com.tencent.android.tpush.data.RegisterEntity;
import com.tencent.android.tpush.encrypt.Rijndael;
import com.tencent.android.tpush.p580b.C6864a;
import com.tencent.android.tpush.p581c.C6876f;
import com.tencent.android.tpush.service.C6973b;
import com.tencent.android.tpush.service.cache.CacheManager;
import com.tencent.android.tpush.stat.p597b.C7075d;
import com.tencent.android.tpush.stat.p597b.C7080i;
import java.net.URISyntaxException;

/* compiled from: ProGuard */
public class XGPushProvider extends ContentProvider {
    public static final String AUTH_PRIX = ".AUTH_XGPUSH";
    public static final String TAG = XGPushProvider.class.getSimpleName();
    /* renamed from: a */
    private Context f22802a = null;
    /* renamed from: b */
    private String f22803b = null;
    /* renamed from: c */
    private UriMatcher f22804c = new UriMatcher(-1);

    /* renamed from: a */
    private void m29250a() {
        this.f22802a = getContext().getApplicationContext();
        C6914l.m29505a(this.f22802a);
        this.f22803b = this.f22802a.getPackageName();
        StringBuilder sb = new StringBuilder();
        sb.append(this.f22803b);
        sb.append(AUTH_PRIX);
        String sb2 = sb.toString();
        this.f22804c.addURI(sb2, TypeStr.config.getStr(), TypeStr.config.getType());
        this.f22804c.addURI(sb2, TypeStr.config_all.getStr(), TypeStr.config_all.getType());
        this.f22804c.addURI(sb2, TypeStr.msg.getStr(), TypeStr.msg.getType());
        this.f22804c.addURI(sb2, TypeStr.msg_all.getStr(), TypeStr.msg_all.getType());
        this.f22804c.addURI(sb2, TypeStr.hearbeat.getStr(), TypeStr.hearbeat.getType());
        this.f22804c.addURI(sb2, TypeStr.hearbeat_all.getStr(), TypeStr.hearbeat_all.getType());
        this.f22804c.addURI(sb2, TypeStr.feedback.getStr(), TypeStr.feedback.getType());
        this.f22804c.addURI(sb2, TypeStr.feedback_all.getStr(), TypeStr.feedback_all.getType());
        this.f22804c.addURI(sb2, TypeStr.token.getStr(), TypeStr.token.getType());
        this.f22804c.addURI(sb2, TypeStr.register.getStr(), TypeStr.register.getType());
        this.f22804c.addURI(sb2, TypeStr.insert_mid_new.getStr(), TypeStr.insert_mid_new.getType());
        this.f22804c.addURI(sb2, TypeStr.insert_mid_old.getStr(), TypeStr.insert_mid_old.getType());
        this.f22804c.addURI(sb2, TypeStr.pullupxg.getStr(), TypeStr.pullupxg.getType());
    }

    public boolean onCreate() {
        m29250a();
        C6864a.m29303e(Constants.LogTag, "XGPushProvider onCreate");
        return true;
    }

    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        StringBuilder sb = new StringBuilder();
        sb.append("query uri:");
        sb.append(uri);
        sb.append(",projection:");
        sb.append(strArr);
        sb.append(",selection:");
        sb.append(str);
        sb.append(",selectionArgs:");
        sb.append(strArr2);
        sb.append(",sortOrder:");
        sb.append(str2);
        C6864a.m29303e(Constants.LogTag, sb.toString());
        return null;
    }

    public String getType(Uri uri) {
        int match = this.f22804c.match(uri);
        StringBuilder sb = new StringBuilder();
        sb.append("getType uri:");
        sb.append(uri);
        sb.append(",match:");
        sb.append(match);
        String sb2 = sb.toString();
        String str = Constants.LogTag;
        C6864a.m29303e(str, sb2);
        TypeStr typeStr = TypeStr.getTypeStr(match);
        if (typeStr == null) {
            return null;
        }
        switch (typeStr) {
            case config:
                return "CONFIG";
            case config_all:
                return "CONFIG_ALL";
            case hearbeat:
                C6876f.m29376a(this.f22802a).mo33045a(false);
                return null;
            case pullupxg:
                C6864a.m29303e(str, "Start XGService by provider");
                C6973b.m29765a(this.f22802a);
                return null;
            case hearbeat_all:
                return "HEARTBEAT_ALL";
            case token:
                return Rijndael.encrypt(C7080i.m30362a(this.f22802a).mo34210c());
            case register:
                RegisterEntity currentAppRegisterEntity = CacheManager.getCurrentAppRegisterEntity(this.f22802a);
                StringBuilder sb3 = new StringBuilder();
                sb3.append("get RegisterEntity:");
                sb3.append(currentAppRegisterEntity);
                C6864a.m29303e(str, sb3.toString());
                return Rijndael.encrypt(RegisterEntity.encode(currentAppRegisterEntity));
            default:
                return null;
        }
    }

    public Uri insert(Uri uri, ContentValues contentValues) {
        int match = this.f22804c.match(uri);
        TypeStr typeStr = TypeStr.getTypeStr(match);
        if (typeStr == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("insert uri:");
        sb.append(uri);
        sb.append(",match:");
        sb.append(match);
        sb.append(",values:");
        sb.append(contentValues);
        String sb2 = sb.toString();
        String str = Constants.LogTag;
        C6864a.m29303e(str, sb2);
        int i = C68591.f22805a[typeStr.ordinal()];
        String str2 = "mid";
        switch (i) {
            case 8:
                try {
                    Intent parseUri = Intent.parseUri(contentValues.getAsString(SettingsContentProvider.KEY), 0);
                    parseUri.addCategory("android.intent.category.BROWSABLE");
                    parseUri.setComponent(null);
                    if (VERSION.SDK_INT >= 15) {
                        try {
                            parseUri.getClass().getMethod("setSelector", new Class[]{Intent.class}).invoke(parseUri, new Object[]{null});
                        } catch (Exception e) {
                            C6864a.m29299c(str, "invoke intent.setComponent error.", e);
                        }
                    }
                    C6876f.m29376a(this.f22802a).mo33046b(parseUri);
                    break;
                } catch (URISyntaxException e2) {
                    e2.printStackTrace();
                    break;
                }
            case 9:
                C7080i.m30362a(this.f22802a).mo34206a(C7075d.m30322a(contentValues.getAsString(str2)), false);
                break;
            case 10:
                try {
                    C7080i.m30362a(this.f22802a).mo34209b(C7075d.m30322a(contentValues.getAsString(str2)), false);
                    break;
                } catch (Throwable unused) {
                    break;
                }
            case 11:
                break;
            default:
                return null;
        }
        return null;
    }

    public int delete(Uri uri, String str, String[] strArr) {
        String str2 = TAG;
        StringBuilder sb = new StringBuilder();
        sb.append("delete uri:");
        sb.append(uri);
        sb.append(",selection:");
        sb.append(str);
        sb.append(",selectionArgs:");
        sb.append(strArr);
        C6864a.m29306g(str2, sb.toString());
        return 0;
    }

    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        int match = this.f22804c.match(uri);
        TypeStr typeStr = TypeStr.getTypeStr(match);
        if (typeStr == null) {
            return 0;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("update uri:");
        sb.append(uri);
        sb.append(",values:");
        sb.append(contentValues);
        sb.append(",selection:");
        sb.append(str);
        sb.append(",selectionArgs:");
        sb.append(strArr);
        sb.append(",match:");
        sb.append(match);
        String sb2 = sb.toString();
        String str2 = Constants.LogTag;
        C6864a.m29303e(str2, sb2);
        int i = C68591.f22805a[typeStr.ordinal()];
        if (i == 12) {
            String decrypt = Rijndael.decrypt(contentValues.getAsString("feedback"));
            StringBuilder sb3 = new StringBuilder();
            sb3.append("feeback: ");
            sb3.append(decrypt);
            C6864a.m29303e(str2, sb3.toString());
        } else if (i != 13) {
            return 0;
        }
        return 0;
    }
}
