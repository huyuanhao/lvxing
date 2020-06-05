package com.tencent.p607mm.opensdk.diffdev.p609a;

import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.os.Environment;
import android.util.Base64;
import com.tencent.p607mm.opensdk.diffdev.OAuthErrCode;
import com.tencent.p607mm.opensdk.diffdev.OAuthListener;
import com.tencent.p607mm.opensdk.utils.Log;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.opensdk.diffdev.a.d */
public final class C7328d extends AsyncTask<Void, Void, C7329a> {
    /* renamed from: h */
    private static final String f24803h;
    /* renamed from: i */
    private static String f24804i;
    private String appId;
    /* renamed from: j */
    private String f24805j;
    /* renamed from: k */
    private String f24806k;
    /* renamed from: l */
    private OAuthListener f24807l;
    /* renamed from: m */
    private C7331f f24808m;
    private String scope;
    private String signature;

    /* renamed from: com.tencent.mm.opensdk.diffdev.a.d$a */
    static class C7329a {
        /* renamed from: n */
        public OAuthErrCode f24809n;
        /* renamed from: o */
        public String f24810o;
        /* renamed from: p */
        public String f24811p;
        /* renamed from: q */
        public String f24812q;
        /* renamed from: r */
        public int f24813r;
        /* renamed from: s */
        public String f24814s;
        /* renamed from: t */
        public byte[] f24815t;

        private C7329a() {
        }

        /* renamed from: a */
        public static C7329a m31618a(byte[] bArr) {
            OAuthErrCode oAuthErrCode;
            String format;
            C7329a aVar = new C7329a();
            String str = "MicroMsg.SDK.GetQRCodeResult";
            if (bArr == null || bArr.length == 0) {
                Log.m31627e(str, "parse fail, buf is null");
                oAuthErrCode = OAuthErrCode.WechatAuth_Err_NetworkErr;
            } else {
                try {
                    try {
                        JSONObject jSONObject = new JSONObject(new String(bArr, "utf-8"));
                        int i = jSONObject.getInt("errcode");
                        if (i != 0) {
                            Log.m31627e(str, String.format("resp errcode = %d", new Object[]{Integer.valueOf(i)}));
                            aVar.f24809n = OAuthErrCode.WechatAuth_Err_NormalErr;
                            aVar.f24813r = i;
                            aVar.f24814s = jSONObject.optString("errmsg");
                            return aVar;
                        }
                        String string = jSONObject.getJSONObject("qrcode").getString("qrcodebase64");
                        if (string != null) {
                            if (string.length() != 0) {
                                byte[] decode = Base64.decode(string, 0);
                                if (decode != null) {
                                    if (decode.length != 0) {
                                        aVar.f24809n = OAuthErrCode.WechatAuth_Err_OK;
                                        aVar.f24815t = decode;
                                        aVar.f24810o = jSONObject.getString("uuid");
                                        aVar.f24811p = jSONObject.getString("appname");
                                        Log.m31626d(str, String.format("parse succ, save in memory, uuid = %s, appname = %s, imgBufLength = %d", new Object[]{aVar.f24810o, aVar.f24811p, Integer.valueOf(aVar.f24815t.length)}));
                                        return aVar;
                                    }
                                }
                                Log.m31627e(str, "parse fail, qrcodeBuf is null");
                                aVar.f24809n = OAuthErrCode.WechatAuth_Err_JsonDecodeErr;
                                return aVar;
                            }
                        }
                        Log.m31627e(str, "parse fail, qrcodeBase64 is null");
                        aVar.f24809n = OAuthErrCode.WechatAuth_Err_JsonDecodeErr;
                        return aVar;
                    } catch (Exception e) {
                        format = String.format("parse json fail, ex = %s", new Object[]{e.getMessage()});
                        Log.m31627e(str, format);
                        oAuthErrCode = OAuthErrCode.WechatAuth_Err_NormalErr;
                        aVar.f24809n = oAuthErrCode;
                        return aVar;
                    }
                } catch (Exception e2) {
                    format = String.format("parse fail, build String fail, ex = %s", new Object[]{e2.getMessage()});
                    Log.m31627e(str, format);
                    oAuthErrCode = OAuthErrCode.WechatAuth_Err_NormalErr;
                    aVar.f24809n = oAuthErrCode;
                    return aVar;
                }
            }
            aVar.f24809n = oAuthErrCode;
            return aVar;
        }
    }

    static {
        StringBuilder sb = new StringBuilder();
        sb.append(Environment.getExternalStorageDirectory().getAbsolutePath());
        sb.append("/tencent/MicroMsg/oauth_qrcode.png");
        f24803h = sb.toString();
        f24804i = null;
        f24804i = "https://open.weixin.qq.com/connect/sdk/qrconnect?appid=%s&noncestr=%s&timestamp=%s&scope=%s&signature=%s";
    }

    public C7328d(String str, String str2, String str3, String str4, String str5, OAuthListener oAuthListener) {
        this.appId = str;
        this.scope = str2;
        this.f24805j = str3;
        this.f24806k = str4;
        this.signature = str5;
        this.f24807l = oAuthListener;
    }

    /* renamed from: a */
    public final boolean mo35735a() {
        Log.m31628i("MicroMsg.SDK.GetQRCodeTask", "cancelTask");
        C7331f fVar = this.f24808m;
        return fVar == null ? cancel(true) : fVar.cancel(true);
    }

    /* access modifiers changed from: protected|final|synthetic */
    public final /* synthetic */ Object doInBackground(Object[] objArr) {
        String str = "MicroMsg.SDK.GetQRCodeTask";
        Log.m31628i(str, "external storage available = false");
        String format = String.format(f24804i, new Object[]{this.appId, this.f24805j, this.f24806k, this.scope, this.signature});
        long currentTimeMillis = System.currentTimeMillis();
        byte[] a = C7330e.m31619a(format);
        Log.m31626d(str, String.format("doInBackground, url = %s, time consumed = %d(ms)", new Object[]{format, Long.valueOf(System.currentTimeMillis() - currentTimeMillis)}));
        return C7329a.m31618a(a);
    }

    /* access modifiers changed from: protected|final|synthetic */
    public final /* synthetic */ void onPostExecute(Object obj) {
        C7329a aVar = (C7329a) obj;
        String str = "MicroMsg.SDK.GetQRCodeTask";
        if (aVar.f24809n == OAuthErrCode.WechatAuth_Err_OK) {
            Log.m31626d(str, "onPostExecute, get qrcode success");
            this.f24807l.onAuthGotQrcode(aVar.f24812q, aVar.f24815t);
            this.f24808m = new C7331f(aVar.f24810o, this.f24807l);
            C7331f fVar = this.f24808m;
            if (VERSION.SDK_INT >= 11) {
                fVar.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
            } else {
                fVar.execute(new Void[0]);
            }
        } else {
            Log.m31627e(str, String.format("onPostExecute, get qrcode fail, OAuthErrCode = %s", new Object[]{aVar.f24809n}));
            this.f24807l.onAuthFinish(aVar.f24809n, null);
        }
    }
}
