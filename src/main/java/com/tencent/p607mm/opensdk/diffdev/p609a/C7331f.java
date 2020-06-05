package com.tencent.p607mm.opensdk.diffdev.p609a;

import android.os.AsyncTask;
import com.tencent.p607mm.opensdk.diffdev.OAuthErrCode;
import com.tencent.p607mm.opensdk.diffdev.OAuthListener;
import com.tencent.p607mm.opensdk.utils.Log;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.opensdk.diffdev.a.f */
final class C7331f extends AsyncTask<Void, Void, C7332a> {
    /* renamed from: l */
    private OAuthListener f24816l;
    /* renamed from: o */
    private String f24817o;
    /* renamed from: u */
    private int f24818u;
    private String url;

    /* renamed from: com.tencent.mm.opensdk.diffdev.a.f$a */
    static class C7332a {
        /* renamed from: n */
        public OAuthErrCode f24819n;
        /* renamed from: v */
        public String f24820v;
        /* renamed from: w */
        public int f24821w;

        C7332a() {
        }

        /* renamed from: b */
        public static C7332a m31620b(byte[] bArr) {
            OAuthErrCode oAuthErrCode;
            String format;
            OAuthErrCode oAuthErrCode2;
            C7332a aVar = new C7332a();
            String str = "MicroMsg.SDK.NoopingResult";
            if (bArr == null || bArr.length == 0) {
                Log.m31627e(str, "parse fail, buf is null");
                oAuthErrCode = OAuthErrCode.WechatAuth_Err_NetworkErr;
            } else {
                try {
                    try {
                        JSONObject jSONObject = new JSONObject(new String(bArr, "utf-8"));
                        aVar.f24821w = jSONObject.getInt("wx_errcode");
                        Log.m31626d(str, String.format("nooping uuidStatusCode = %d", new Object[]{Integer.valueOf(aVar.f24821w)}));
                        int i = aVar.f24821w;
                        if (i == 408) {
                            oAuthErrCode2 = OAuthErrCode.WechatAuth_Err_OK;
                        } else if (i != 500) {
                            switch (i) {
                                case 402:
                                    oAuthErrCode2 = OAuthErrCode.WechatAuth_Err_Timeout;
                                    break;
                                case 403:
                                    oAuthErrCode2 = OAuthErrCode.WechatAuth_Err_Cancel;
                                    break;
                                case 404:
                                    oAuthErrCode2 = OAuthErrCode.WechatAuth_Err_OK;
                                    break;
                                case 405:
                                    aVar.f24819n = OAuthErrCode.WechatAuth_Err_OK;
                                    aVar.f24820v = jSONObject.getString("wx_code");
                                    break;
                                default:
                                    oAuthErrCode2 = OAuthErrCode.WechatAuth_Err_NormalErr;
                                    break;
                            }
                        } else {
                            oAuthErrCode2 = OAuthErrCode.WechatAuth_Err_NormalErr;
                        }
                        aVar.f24819n = oAuthErrCode2;
                        return aVar;
                    } catch (Exception e) {
                        format = String.format("parse json fail, ex = %s", new Object[]{e.getMessage()});
                        Log.m31627e(str, format);
                        oAuthErrCode = OAuthErrCode.WechatAuth_Err_NormalErr;
                        aVar.f24819n = oAuthErrCode;
                        return aVar;
                    }
                } catch (Exception e2) {
                    format = String.format("parse fail, build String fail, ex = %s", new Object[]{e2.getMessage()});
                    Log.m31627e(str, format);
                    oAuthErrCode = OAuthErrCode.WechatAuth_Err_NormalErr;
                    aVar.f24819n = oAuthErrCode;
                    return aVar;
                }
            }
            aVar.f24819n = oAuthErrCode;
            return aVar;
        }
    }

    public C7331f(String str, OAuthListener oAuthListener) {
        this.f24817o = str;
        this.f24816l = oAuthListener;
        this.url = String.format("https://long.open.weixin.qq.com/connect/l/qrconnect?f=json&uuid=%s", new Object[]{str});
    }

    /* access modifiers changed from: protected|final|synthetic */
    public final /* synthetic */ Object doInBackground(Object[] objArr) {
        C7332a aVar;
        OAuthErrCode oAuthErrCode;
        String str;
        String str2 = this.f24817o;
        String str3 = "MicroMsg.SDK.NoopingTask";
        if (str2 == null || str2.length() == 0) {
            Log.m31627e(str3, "run fail, uuid is null");
            aVar = new C7332a();
            oAuthErrCode = OAuthErrCode.WechatAuth_Err_NormalErr;
        } else {
            while (!isCancelled()) {
                StringBuilder sb = new StringBuilder();
                sb.append(this.url);
                if (this.f24818u == 0) {
                    str = "";
                } else {
                    StringBuilder sb2 = new StringBuilder("&last=");
                    sb2.append(this.f24818u);
                    str = sb2.toString();
                }
                sb.append(str);
                String sb3 = sb.toString();
                long currentTimeMillis = System.currentTimeMillis();
                byte[] a = C7330e.m31619a(sb3);
                long currentTimeMillis2 = System.currentTimeMillis();
                C7332a b = C7332a.m31620b(a);
                Log.m31626d(str3, String.format("nooping, url = %s, errCode = %s, uuidStatusCode = %d, time consumed = %d(ms)", new Object[]{sb3, b.f24819n.toString(), Integer.valueOf(b.f24821w), Long.valueOf(currentTimeMillis2 - currentTimeMillis)}));
                if (b.f24819n == OAuthErrCode.WechatAuth_Err_OK) {
                    this.f24818u = b.f24821w;
                    if (b.f24821w == C7333g.UUID_SCANED.getCode()) {
                        this.f24816l.onQrcodeScanned();
                    } else if (b.f24821w != C7333g.UUID_KEEP_CONNECT.getCode() && b.f24821w == C7333g.UUID_CONFIRM.getCode()) {
                        if (b.f24820v == null || b.f24820v.length() == 0) {
                            Log.m31627e(str3, "nooping fail, confirm with an empty code!!!");
                            b.f24819n = OAuthErrCode.WechatAuth_Err_NormalErr;
                        }
                        return b;
                    }
                } else {
                    Log.m31627e(str3, String.format("nooping fail, errCode = %s, uuidStatusCode = %d", new Object[]{b.f24819n.toString(), Integer.valueOf(b.f24821w)}));
                    return b;
                }
            }
            Log.m31628i(str3, "IDiffDevOAuth.stopAuth / detach invoked");
            aVar = new C7332a();
            oAuthErrCode = OAuthErrCode.WechatAuth_Err_Auth_Stopped;
        }
        aVar.f24819n = oAuthErrCode;
        return aVar;
    }

    /* access modifiers changed from: protected|final|synthetic */
    public final /* synthetic */ void onPostExecute(Object obj) {
        C7332a aVar = (C7332a) obj;
        this.f24816l.onAuthFinish(aVar.f24819n, aVar.f24820v);
    }
}
