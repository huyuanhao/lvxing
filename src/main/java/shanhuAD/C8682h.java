package shanhuAD;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/* renamed from: shanhuAD.h */
public class C8682h {

    /* renamed from: shanhuAD.h$a */
    public interface C8683a {
        void onLoaded(Bitmap bitmap);
    }

    /* renamed from: b */
    public static void m37695b(String str, C8683a aVar) {
        new C8681g(str, aVar).start();
    }

    /* access modifiers changed from: private|static */
    /* renamed from: c */
    public static void m37696c(String str, C8683a aVar) {
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            httpURLConnection.setConnectTimeout(6000);
            httpURLConnection.setDoInput(true);
            httpURLConnection.setUseCaches(false);
            httpURLConnection.connect();
            InputStream inputStream = httpURLConnection.getInputStream();
            Bitmap decodeStream = BitmapFactory.decodeStream(inputStream);
            inputStream.close();
            aVar.onLoaded(decodeStream);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
