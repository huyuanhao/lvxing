package discoveryAD;

import android.os.Environment;
import com.tencent.qqpim.discovery.DiscoverySdk;
import java.io.File;

/* renamed from: discoveryAD.na */
public final class C7918na {
    public static File getExternalStorageDirectory() {
        C7916ma.m34329a(DiscoverySdk.getInstance().getApplicationContext(), "android.permission.READ_EXTERNAL_STORAGE");
        return Environment.getExternalStorageDirectory();
    }
}
