package discoveryAD;

import com.tencent.p605ep.commonbase.api.Log;
import com.tencent.qqpim.discovery.internal.model.C7489d;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

/* renamed from: discoveryAD.ya */
public class C7941ya {
    /* access modifiers changed from: private|static */
    /* renamed from: Q */
    public static void m34359Q(String str) {
        String str2;
        String str3 = "extra report,error : ";
        String str4 = " , ";
        String str5 = "ExtraReport";
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            httpURLConnection.setRequestProperty("UA", C7935va.m34357mb());
            httpURLConnection.connect();
            if (httpURLConnection.getResponseCode() == 200) {
                httpURLConnection.disconnect();
            }
            StringBuilder sb = new StringBuilder();
            sb.append(httpURLConnection.getResponseCode());
            sb.append(str4);
            sb.append(str);
            Log.m31477d(str5, sb.toString());
            StringBuilder sb2 = new StringBuilder();
            sb2.append("extra report : ");
            sb2.append(httpURLConnection.getResponseCode());
            C7852Aa.m34150L(sb2.toString());
            return;
        } catch (MalformedURLException e) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append("HttpGetReport MalformedURLException error : ");
            sb3.append(e.getMessage());
            sb3.append(str4);
            sb3.append(str);
            Log.m31479e(str5, sb3.toString());
            StringBuilder sb4 = new StringBuilder();
            sb4.append(str3);
            sb4.append(e.getMessage());
            str2 = sb4.toString();
        } catch (IOException e2) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("HttpGetReport IOException error : ");
            sb5.append(e2.getMessage());
            Log.m31479e(str5, sb5.toString());
            StringBuilder sb6 = new StringBuilder();
            sb6.append(str3);
            sb6.append(e2.getMessage());
            str2 = sb6.toString();
        }
        C7852Aa.m34150L(str2);
    }

    /* renamed from: p */
    public static void m34360p(ArrayList<C7489d> arrayList) {
        if (arrayList != null && arrayList.size() != 0) {
            new C7937wa(arrayList).start();
        }
    }

    /* renamed from: q */
    public static void m34361q(ArrayList<String> arrayList) {
        if (arrayList != null && arrayList.size() != 0) {
            new C7939xa(arrayList).start();
        }
    }
}
