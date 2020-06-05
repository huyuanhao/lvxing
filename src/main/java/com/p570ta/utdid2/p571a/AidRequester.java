package com.p570ta.utdid2.p571a;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.app.NotificationCompat;
import androidx.core.view.PointerIconCompat;
import androidx.vectordrawable.graphics.drawable.PathInterpolatorCompat;
import com.p570ta.utdid2.p572b.p573a.C6802f;
import com.p570ta.utdid2.p572b.p573a.DebugUtils;
import com.p620ut.device.AidCallback;
import com.tencent.stat.common.DeviceInfo;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.ta.utdid2.a.b */
public class AidRequester {
    /* access modifiers changed from: private|static|final */
    public static final String TAG = AidRequester.class.getName();
    /* renamed from: a */
    private static AidRequester f22474a = null;
    /* renamed from: a */
    private Object f22475a = new Object();
    private Context mContext;

    /* compiled from: AidRequester */
    /* renamed from: com.ta.utdid2.a.b$a */
    class C6796a extends Thread {
        /* renamed from: a */
        AidCallback f22476a;
        /* renamed from: a */
        String f22477a;
        /* renamed from: a */
        HttpPost f22478a;
        /* renamed from: b */
        String f22480b;
        /* renamed from: c */
        String f22481c;
        /* renamed from: d */
        String f22482d;

        public C6796a(HttpPost httpPost) {
            String str = "";
            this.f22477a = str;
            this.f22482d = str;
            this.f22478a = httpPost;
        }

        public C6796a(HttpPost httpPost, AidCallback aVar, String str, String str2, String str3) {
            String str4 = "";
            this.f22477a = str4;
            this.f22482d = str4;
            this.f22478a = httpPost;
            this.f22476a = aVar;
            this.f22480b = str;
            this.f22481c = str2;
            this.f22482d = str3;
        }

        public void run() {
            HttpResponse httpResponse;
            AidCallback aVar = this.f22476a;
            if (aVar != null) {
                aVar.mo37387a(1000, this.f22480b);
            }
            BufferedReader bufferedReader = null;
            try {
                httpResponse = new DefaultHttpClient().execute(this.f22478a);
            } catch (Exception e) {
                AidCallback aVar2 = this.f22476a;
                if (aVar2 != null) {
                    aVar2.mo37387a(PointerIconCompat.TYPE_HAND, this.f22480b);
                }
                Log.e(AidRequester.TAG, e.toString());
                httpResponse = null;
            }
            if (httpResponse != null) {
                try {
                    bufferedReader = new BufferedReader(new InputStreamReader(httpResponse.getEntity().getContent(), Charset.forName("UTF-8")));
                } catch (Exception e2) {
                    AidCallback aVar3 = this.f22476a;
                    if (aVar3 != null) {
                        aVar3.mo37387a(PointerIconCompat.TYPE_HAND, this.f22480b);
                    }
                    Log.e(AidRequester.TAG, e2.toString());
                }
            } else {
                Log.e(AidRequester.TAG, "response is null!");
            }
            if (bufferedReader != null) {
                while (true) {
                    try {
                        String readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            break;
                        }
                        if (DebugUtils.f22504e) {
                            Log.d(AidRequester.TAG, readLine);
                        }
                        this.f22477a = readLine;
                    } catch (Exception e3) {
                        AidCallback aVar4 = this.f22476a;
                        if (aVar4 != null) {
                            aVar4.mo37387a(PointerIconCompat.TYPE_HAND, this.f22480b);
                        }
                        Log.e(AidRequester.TAG, e3.toString());
                    }
                }
            } else {
                Log.e(AidRequester.TAG, "BufferredReader is null!");
            }
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                    if (DebugUtils.f22504e) {
                        Log.d(AidRequester.TAG, "close the bufferreader");
                    }
                } catch (IOException e4) {
                    Log.e(AidRequester.TAG, e4.toString());
                }
            }
            if (this.f22476a == null) {
                synchronized (AidRequester.m29001a(AidRequester.this)) {
                    AidRequester.m29001a(AidRequester.this).notifyAll();
                }
                return;
            }
            String b = AidRequester.m29005a(this.f22477a, this.f22480b);
            this.f22476a.mo37387a(1001, b);
            AidStorageController.m29013a(AidRequester.m29001a(AidRequester.this), this.f22481c, b, this.f22482d);
        }

        /* renamed from: b */
        public String mo32653b() {
            return this.f22477a;
        }
    }

    /* renamed from: a */
    public static synchronized AidRequester m29002a(Context context) {
        AidRequester bVar;
        synchronized (AidRequester.class) {
            if (f22474a == null) {
                f22474a = new AidRequester(context);
            }
            bVar = f22474a;
        }
        return bVar;
    }

    public AidRequester(Context context) {
        this.mContext = context;
    }

    /* renamed from: a */
    public void mo32652a(String str, String str2, String str3, String str4, AidCallback aVar) {
        String b = m29007b(str, str2, str3, str4);
        if (DebugUtils.f22504e) {
            String str5 = TAG;
            StringBuilder sb = new StringBuilder("url:");
            sb.append(b);
            sb.append("; len:");
            sb.append(b.length());
            Log.d(str5, sb.toString());
        }
        C6796a aVar2 = new C6796a(new HttpPost(b), aVar, str4, str, str2);
        aVar2.start();
    }

    /* renamed from: a */
    public String mo32651a(String str, String str2, String str3, String str4) {
        String b = m29007b(str, str2, str3, str4);
        int i = C6802f.m29028b(this.mContext) ? PathInterpolatorCompat.MAX_NUM_POINTS : 1000;
        if (DebugUtils.f22504e) {
            String str5 = TAG;
            StringBuilder sb = new StringBuilder("url:");
            sb.append(b);
            sb.append("; timeout:");
            sb.append(i);
            Log.d(str5, sb.toString());
        }
        C6796a aVar = new C6796a(new HttpPost(b));
        aVar.start();
        try {
            synchronized (this.f22475a) {
                this.f22475a.wait((long) i);
            }
        } catch (Exception e) {
            Log.e(TAG, e.toString());
        }
        String b2 = aVar.mo32653b();
        if (DebugUtils.f22504e) {
            String str6 = TAG;
            StringBuilder sb2 = new StringBuilder("mLine:");
            sb2.append(b2);
            Log.d(str6, sb2.toString());
        }
        return m29005a(b2, str4);
    }

    /* access modifiers changed from: private|static */
    /* renamed from: a */
    public static String m29005a(String str, String str2) {
        String str3 = DeviceInfo.TAG_ANDROID_ID;
        String str4 = NotificationCompat.CATEGORY_STATUS;
        String str5 = "action";
        String str6 = "isError";
        String str7 = "data";
        if (TextUtils.isEmpty(str)) {
            return str2;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has(str7)) {
                JSONObject jSONObject2 = jSONObject.getJSONObject(str7);
                if (!jSONObject2.has(str5) || !jSONObject2.has(str3)) {
                    return str2;
                }
                String string = jSONObject2.getString(str5);
                if (string.equalsIgnoreCase("new") || string.equalsIgnoreCase("changed")) {
                    return jSONObject2.getString(str3);
                }
                return str2;
            } else if (!jSONObject.has(str6) || !jSONObject.has(str4)) {
                return str2;
            } else {
                String string2 = jSONObject.getString(str6);
                String string3 = jSONObject.getString(str4);
                if (!string2.equalsIgnoreCase("true")) {
                    return str2;
                }
                if (!string3.equalsIgnoreCase("404") && !string3.equalsIgnoreCase("401")) {
                    return str2;
                }
                if (DebugUtils.f22504e) {
                    String str8 = TAG;
                    StringBuilder sb = new StringBuilder("remove the AID, status:");
                    sb.append(string3);
                    Log.d(str8, sb.toString());
                }
                return "";
            }
        } catch (JSONException e) {
            Log.e(TAG, e.toString());
            return str2;
        } catch (Exception e2) {
            Log.e(TAG, e2.toString());
            return str2;
        }
    }

    /* renamed from: b */
    private static String m29007b(String str, String str2, String str3, String str4) {
        StringBuilder sb = new StringBuilder();
        try {
            str3 = URLEncoder.encode(str3, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        sb.append("http://hydra.alibaba.com/");
        sb.append(str);
        sb.append("/get_aid/");
        sb.append("?");
        sb.append("auth[token]=");
        sb.append(str2);
        sb.append("&type=");
        sb.append("utdid");
        sb.append("&id=");
        sb.append(str3);
        sb.append("&aid=");
        sb.append(str4);
        return sb.toString();
    }
}
