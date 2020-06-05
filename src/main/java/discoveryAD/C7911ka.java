package discoveryAD;

import android.content.Context;
import android.os.Environment;
import com.tencent.mid.core.Constants;
import com.tencent.p605ep.commonbase.api.Log;
import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;
import org.apache.http.client.methods.HttpGet;

/* renamed from: discoveryAD.ka */
public class C7911ka extends C7908ja {
    private boolean isContinue = false;
    private long mCompletedSize = 0;
    private Context mContext;
    private int mFileMode = 0;
    private boolean mIsCanceled = false;
    private String mSaveName = null;
    private String mSavePath = null;
    private String mTempName = null;
    private String mTempPath = null;
    private long mTotalSize = 0;
    /* renamed from: ne */
    private HttpGet f26910ne = null;
    /* renamed from: oe */
    private boolean f26911oe = false;

    /* renamed from: discoveryAD.ka$a */
    public interface C7912a {
        boolean isMatch(String str);
    }

    public C7911ka(Context context) {
        String str;
        this.mContext = context;
        if (C7916ma.m34329a(this.mContext, Constants.PERMISSION_WRITE_EXTERNAL_STORAGE) == 1) {
            this.f26911oe = "mounted".equals(Environment.getExternalStorageState());
            if (this.f26911oe) {
                this.mTempPath = C7918na.getExternalStorageDirectory().getAbsolutePath();
                str = this.mTempPath;
                this.mSavePath = str;
                this.f26910ne = new HttpGet();
            }
        }
        this.mTempPath = context.getCacheDir().getAbsolutePath();
        str = context.getFilesDir().getAbsolutePath();
        this.mSavePath = str;
        this.f26910ne = new HttpGet();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:123:0x018a, code lost:
            com.tencent.p605ep.commonbase.api.Log.m31483i(r6, r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:125:?, code lost:
            r16.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:126:0x0191, code lost:
            r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:127:0x0192, code lost:
            r2 = r0;
            com.tencent.p605ep.commonbase.api.Log.m31479e(r6, r3);
            r2.printStackTrace();
            r9 = -7000;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:129:0x019d, code lost:
            com.tencent.p605ep.commonbase.api.Log.m31483i(r6, r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:131:?, code lost:
            r8.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:139:0x01b6, code lost:
            com.tencent.p605ep.commonbase.api.Log.m31483i(r6, r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:141:?, code lost:
            r16.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:142:0x01bd, code lost:
            r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:143:0x01be, code lost:
            r2 = r0;
            com.tencent.p605ep.commonbase.api.Log.m31479e(r6, r3);
            r2.printStackTrace();
            r9 = -7000;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:145:0x01c9, code lost:
            com.tencent.p605ep.commonbase.api.Log.m31483i(r6, r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:148:0x01d1, code lost:
            r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:149:0x01d2, code lost:
            r2 = r14;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:160:0x01f9, code lost:
            com.tencent.p605ep.commonbase.api.Log.m31483i(r6, r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:162:?, code lost:
            r16.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:163:0x0200, code lost:
            r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:164:0x0201, code lost:
            r2 = r0;
            com.tencent.p605ep.commonbase.api.Log.m31479e(r6, r3);
            r2.printStackTrace();
            r9 = -7000;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:166:0x020c, code lost:
            com.tencent.p605ep.commonbase.api.Log.m31483i(r6, r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:177:0x0234, code lost:
            com.tencent.p605ep.commonbase.api.Log.m31483i(r6, r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:179:?, code lost:
            r16.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:180:0x023b, code lost:
            r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:181:0x023c, code lost:
            r2 = r0;
            com.tencent.p605ep.commonbase.api.Log.m31479e(r6, r3);
            r2.printStackTrace();
            r9 = -7000;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:183:0x0247, code lost:
            com.tencent.p605ep.commonbase.api.Log.m31483i(r6, r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:193:0x025f, code lost:
            com.tencent.p605ep.commonbase.api.Log.m31483i(r6, r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:195:?, code lost:
            r16.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:196:0x0266, code lost:
            r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:197:0x0267, code lost:
            r5 = r0;
            com.tencent.p605ep.commonbase.api.Log.m31479e(r6, r3);
            r5.printStackTrace();
            r9 = -7000;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:199:0x0272, code lost:
            com.tencent.p605ep.commonbase.api.Log.m31483i(r6, r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:201:?, code lost:
            r8.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:202:0x0279, code lost:
            r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:209:0x028b, code lost:
            com.tencent.p605ep.commonbase.api.Log.m31483i(r6, r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:211:?, code lost:
            r16.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:212:0x0292, code lost:
            r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:213:0x0293, code lost:
            r5 = r0;
            com.tencent.p605ep.commonbase.api.Log.m31479e(r6, r3);
            r5.printStackTrace();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:215:0x029c, code lost:
            com.tencent.p605ep.commonbase.api.Log.m31483i(r6, r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:217:?, code lost:
            r8.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:218:0x02a3, code lost:
            r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:219:0x02a4, code lost:
            r3 = r0;
            com.tencent.p605ep.commonbase.api.Log.m31479e(r6, r2);
            r3.printStackTrace();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x00bb, code lost:
            r14 = r2;
            r17 = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:?, code lost:
            r8.flush();
            r0 = new java.lang.StringBuilder();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:?, code lost:
            r0.append("mTotalSize: ");
            r0.append(r1.mTotalSize);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:?, code lost:
            r0.append(", mCompletedSize: ");
            r0.append(r1.mCompletedSize);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:?, code lost:
            r0.append(", httpEntity.getContentLength(): ");
            r0.append(r19.getContentLength());
            com.tencent.p605ep.commonbase.api.Log.m31483i(r6, r0.toString());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x00f5, code lost:
            if (((long) r11) != r19.getContentLength()) goto L_0x00f9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x00f7, code lost:
            r0 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x00f9, code lost:
            r0 = -7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x00fa, code lost:
            if (r10 == null) goto L_0x0110;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x00fc, code lost:
            com.tencent.p605ep.commonbase.api.Log.m31483i(r6, r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:?, code lost:
            r10.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x0103, code lost:
            r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x0104, code lost:
            r2 = r0;
            com.tencent.p605ep.commonbase.api.Log.m31479e(r6, r17);
            r2.printStackTrace();
            r9 = -7000;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x0110, code lost:
            r9 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x0116, code lost:
            r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x0117, code lost:
            r3 = r17;
            r2 = r14;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:0x011c, code lost:
            r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x011d, code lost:
            r3 = r17;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x0120, code lost:
            r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:0x0121, code lost:
            r3 = r17;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:0x0124, code lost:
            r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:77:0x0125, code lost:
            r3 = r17;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x0128, code lost:
            r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:79:0x0129, code lost:
            r3 = r17;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:80:0x012c, code lost:
            r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:81:0x012d, code lost:
            r3 = r17;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:123:0x018a  */
    /* JADX WARNING: Removed duplicated region for block: B:129:0x019d  */
    /* JADX WARNING: Removed duplicated region for block: B:139:0x01b6  */
    /* JADX WARNING: Removed duplicated region for block: B:145:0x01c9  */
    /* JADX WARNING: Removed duplicated region for block: B:160:0x01f9  */
    /* JADX WARNING: Removed duplicated region for block: B:166:0x020c  */
    /* JADX WARNING: Removed duplicated region for block: B:177:0x0234  */
    /* JADX WARNING: Removed duplicated region for block: B:183:0x0247  */
    /* JADX WARNING: Removed duplicated region for block: B:193:0x025f  */
    /* JADX WARNING: Removed duplicated region for block: B:199:0x0272  */
    /* JADX WARNING: Removed duplicated region for block: B:209:0x028b  */
    /* JADX WARNING: Removed duplicated region for block: B:215:0x029c  */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x011c A[ExcHandler: Exception (e java.lang.Exception), PHI: r14 r17 
  PHI: (r14v35 java.lang.String) = (r14v30 java.lang.String), (r14v30 java.lang.String), (r14v30 java.lang.String), (r14v30 java.lang.String), (r14v30 java.lang.String), (r14v30 java.lang.String), (r14v30 java.lang.String), (r14v30 java.lang.String), (r14v37 java.lang.String), (r14v37 java.lang.String), (r14v37 java.lang.String) binds: {(r14v30 java.lang.String)=B:47:0x00bf, (r14v30 java.lang.String)=B:48:?, (r14v30 java.lang.String)=B:50:0x00c9, (r14v30 java.lang.String)=B:51:?, (r14v30 java.lang.String)=B:53:0x00d3, (r14v30 java.lang.String)=B:54:?, (r14v30 java.lang.String)=B:56:0x00dd, (r14v30 java.lang.String)=B:57:?, (r14v37 java.lang.String)=B:35:0x0091, (r14v37 java.lang.String)=B:36:?, (r14v37 java.lang.String)=B:40:0x00a2} A[DONT_GENERATE, DONT_INLINE]
  PHI: (r17v5 java.lang.String) = (r17v0 java.lang.String), (r17v0 java.lang.String), (r17v0 java.lang.String), (r17v0 java.lang.String), (r17v0 java.lang.String), (r17v0 java.lang.String), (r17v0 java.lang.String), (r17v0 java.lang.String), (r17v6 java.lang.String), (r17v6 java.lang.String), (r17v6 java.lang.String) binds: {(r17v0 java.lang.String)=B:47:0x00bf, (r17v0 java.lang.String)=B:48:?, (r17v0 java.lang.String)=B:50:0x00c9, (r17v0 java.lang.String)=B:51:?, (r17v0 java.lang.String)=B:53:0x00d3, (r17v0 java.lang.String)=B:54:?, (r17v0 java.lang.String)=B:56:0x00dd, (r17v0 java.lang.String)=B:57:?, (r17v6 java.lang.String)=B:35:0x0091, (r17v6 java.lang.String)=B:36:?, (r17v6 java.lang.String)=B:40:0x00a2} A[DONT_GENERATE, DONT_INLINE], Splitter:B:35:0x0091] */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x0120 A[ExcHandler: IOException (e java.io.IOException), PHI: r14 r17 
  PHI: (r14v34 java.lang.String) = (r14v30 java.lang.String), (r14v30 java.lang.String), (r14v30 java.lang.String), (r14v30 java.lang.String), (r14v30 java.lang.String), (r14v30 java.lang.String), (r14v30 java.lang.String), (r14v30 java.lang.String), (r14v37 java.lang.String), (r14v37 java.lang.String), (r14v37 java.lang.String) binds: {(r14v30 java.lang.String)=B:47:0x00bf, (r14v30 java.lang.String)=B:48:?, (r14v30 java.lang.String)=B:50:0x00c9, (r14v30 java.lang.String)=B:51:?, (r14v30 java.lang.String)=B:53:0x00d3, (r14v30 java.lang.String)=B:54:?, (r14v30 java.lang.String)=B:56:0x00dd, (r14v30 java.lang.String)=B:57:?, (r14v37 java.lang.String)=B:35:0x0091, (r14v37 java.lang.String)=B:36:?, (r14v37 java.lang.String)=B:40:0x00a2} A[DONT_GENERATE, DONT_INLINE]
  PHI: (r17v4 java.lang.String) = (r17v0 java.lang.String), (r17v0 java.lang.String), (r17v0 java.lang.String), (r17v0 java.lang.String), (r17v0 java.lang.String), (r17v0 java.lang.String), (r17v0 java.lang.String), (r17v0 java.lang.String), (r17v6 java.lang.String), (r17v6 java.lang.String), (r17v6 java.lang.String) binds: {(r17v0 java.lang.String)=B:47:0x00bf, (r17v0 java.lang.String)=B:48:?, (r17v0 java.lang.String)=B:50:0x00c9, (r17v0 java.lang.String)=B:51:?, (r17v0 java.lang.String)=B:53:0x00d3, (r17v0 java.lang.String)=B:54:?, (r17v0 java.lang.String)=B:56:0x00dd, (r17v0 java.lang.String)=B:57:?, (r17v6 java.lang.String)=B:35:0x0091, (r17v6 java.lang.String)=B:36:?, (r17v6 java.lang.String)=B:40:0x00a2} A[DONT_GENERATE, DONT_INLINE], Splitter:B:35:0x0091] */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x0124 A[ExcHandler: SocketTimeoutException (e java.net.SocketTimeoutException), PHI: r14 r17 
  PHI: (r14v33 java.lang.String) = (r14v30 java.lang.String), (r14v30 java.lang.String), (r14v30 java.lang.String), (r14v30 java.lang.String), (r14v30 java.lang.String), (r14v30 java.lang.String), (r14v30 java.lang.String), (r14v30 java.lang.String), (r14v37 java.lang.String), (r14v37 java.lang.String), (r14v37 java.lang.String) binds: {(r14v30 java.lang.String)=B:47:0x00bf, (r14v30 java.lang.String)=B:48:?, (r14v30 java.lang.String)=B:50:0x00c9, (r14v30 java.lang.String)=B:51:?, (r14v30 java.lang.String)=B:53:0x00d3, (r14v30 java.lang.String)=B:54:?, (r14v30 java.lang.String)=B:56:0x00dd, (r14v30 java.lang.String)=B:57:?, (r14v37 java.lang.String)=B:35:0x0091, (r14v37 java.lang.String)=B:36:?, (r14v37 java.lang.String)=B:40:0x00a2} A[DONT_GENERATE, DONT_INLINE]
  PHI: (r17v3 java.lang.String) = (r17v0 java.lang.String), (r17v0 java.lang.String), (r17v0 java.lang.String), (r17v0 java.lang.String), (r17v0 java.lang.String), (r17v0 java.lang.String), (r17v0 java.lang.String), (r17v0 java.lang.String), (r17v6 java.lang.String), (r17v6 java.lang.String), (r17v6 java.lang.String) binds: {(r17v0 java.lang.String)=B:47:0x00bf, (r17v0 java.lang.String)=B:48:?, (r17v0 java.lang.String)=B:50:0x00c9, (r17v0 java.lang.String)=B:51:?, (r17v0 java.lang.String)=B:53:0x00d3, (r17v0 java.lang.String)=B:54:?, (r17v0 java.lang.String)=B:56:0x00dd, (r17v0 java.lang.String)=B:57:?, (r17v6 java.lang.String)=B:35:0x0091, (r17v6 java.lang.String)=B:36:?, (r17v6 java.lang.String)=B:40:0x00a2} A[DONT_GENERATE, DONT_INLINE], Splitter:B:35:0x0091] */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x0128 A[ExcHandler: SocketException (e java.net.SocketException), PHI: r14 r17 
  PHI: (r14v32 java.lang.String) = (r14v30 java.lang.String), (r14v30 java.lang.String), (r14v30 java.lang.String), (r14v30 java.lang.String), (r14v30 java.lang.String), (r14v30 java.lang.String), (r14v30 java.lang.String), (r14v30 java.lang.String), (r14v37 java.lang.String), (r14v37 java.lang.String), (r14v37 java.lang.String) binds: {(r14v30 java.lang.String)=B:47:0x00bf, (r14v30 java.lang.String)=B:48:?, (r14v30 java.lang.String)=B:50:0x00c9, (r14v30 java.lang.String)=B:51:?, (r14v30 java.lang.String)=B:53:0x00d3, (r14v30 java.lang.String)=B:54:?, (r14v30 java.lang.String)=B:56:0x00dd, (r14v30 java.lang.String)=B:57:?, (r14v37 java.lang.String)=B:35:0x0091, (r14v37 java.lang.String)=B:36:?, (r14v37 java.lang.String)=B:40:0x00a2} A[DONT_GENERATE, DONT_INLINE]
  PHI: (r17v2 java.lang.String) = (r17v0 java.lang.String), (r17v0 java.lang.String), (r17v0 java.lang.String), (r17v0 java.lang.String), (r17v0 java.lang.String), (r17v0 java.lang.String), (r17v0 java.lang.String), (r17v0 java.lang.String), (r17v6 java.lang.String), (r17v6 java.lang.String), (r17v6 java.lang.String) binds: {(r17v0 java.lang.String)=B:47:0x00bf, (r17v0 java.lang.String)=B:48:?, (r17v0 java.lang.String)=B:50:0x00c9, (r17v0 java.lang.String)=B:51:?, (r17v0 java.lang.String)=B:53:0x00d3, (r17v0 java.lang.String)=B:54:?, (r17v0 java.lang.String)=B:56:0x00dd, (r17v0 java.lang.String)=B:57:?, (r17v6 java.lang.String)=B:35:0x0091, (r17v6 java.lang.String)=B:36:?, (r17v6 java.lang.String)=B:40:0x00a2} A[DONT_GENERATE, DONT_INLINE], Splitter:B:35:0x0091] */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x012c A[ExcHandler: FileNotFoundException (e java.io.FileNotFoundException), PHI: r14 r17 
  PHI: (r14v31 java.lang.String) = (r14v30 java.lang.String), (r14v30 java.lang.String), (r14v30 java.lang.String), (r14v30 java.lang.String), (r14v30 java.lang.String), (r14v30 java.lang.String), (r14v30 java.lang.String), (r14v30 java.lang.String), (r14v37 java.lang.String), (r14v37 java.lang.String), (r14v37 java.lang.String) binds: {(r14v30 java.lang.String)=B:47:0x00bf, (r14v30 java.lang.String)=B:48:?, (r14v30 java.lang.String)=B:50:0x00c9, (r14v30 java.lang.String)=B:51:?, (r14v30 java.lang.String)=B:53:0x00d3, (r14v30 java.lang.String)=B:54:?, (r14v30 java.lang.String)=B:56:0x00dd, (r14v30 java.lang.String)=B:57:?, (r14v37 java.lang.String)=B:35:0x0091, (r14v37 java.lang.String)=B:36:?, (r14v37 java.lang.String)=B:40:0x00a2} A[DONT_GENERATE, DONT_INLINE]
  PHI: (r17v1 java.lang.String) = (r17v0 java.lang.String), (r17v0 java.lang.String), (r17v0 java.lang.String), (r17v0 java.lang.String), (r17v0 java.lang.String), (r17v0 java.lang.String), (r17v0 java.lang.String), (r17v0 java.lang.String), (r17v6 java.lang.String), (r17v6 java.lang.String), (r17v6 java.lang.String) binds: {(r17v0 java.lang.String)=B:47:0x00bf, (r17v0 java.lang.String)=B:48:?, (r17v0 java.lang.String)=B:50:0x00c9, (r17v0 java.lang.String)=B:51:?, (r17v0 java.lang.String)=B:53:0x00d3, (r17v0 java.lang.String)=B:54:?, (r17v0 java.lang.String)=B:56:0x00dd, (r17v0 java.lang.String)=B:57:?, (r17v6 java.lang.String)=B:35:0x0091, (r17v6 java.lang.String)=B:36:?, (r17v6 java.lang.String)=B:40:0x00a2} A[DONT_GENERATE, DONT_INLINE], Splitter:B:35:0x0091] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:130:0x01a0=Splitter:B:130:0x01a0, B:146:0x01cc=Splitter:B:146:0x01cc} */
    /* renamed from: a */
    private int m34325a(org.apache.http.HttpEntity r19, android.os.Bundle r20, boolean r21) {
        /*
        r18 = this;
        r1 = r18
        r0 = r20
        java.lang.String r2 = "fos close file error"
        java.lang.String r3 = "is close file error"
        java.lang.String r4 = "fos closing file"
        java.lang.String r5 = "is closing file"
        java.lang.String r6 = "HttpBase"
        r7 = 8192(0x2000, float:1.14794E-41)
        byte[] r7 = new byte[r7]
        long r10 = r19.getContentLength()     // Catch:{ FileNotFoundException -> 0x024f, SocketException -> 0x0210, SocketTimeoutException -> 0x01d5, IOException -> 0x01a5, Exception -> 0x0172, all -> 0x0169 }
        long r12 = r1.mCompletedSize     // Catch:{ FileNotFoundException -> 0x024f, SocketException -> 0x0210, SocketTimeoutException -> 0x01d5, IOException -> 0x01a5, Exception -> 0x0172, all -> 0x0169 }
        long r10 = r10 + r12
        r1.mTotalSize = r10     // Catch:{ FileNotFoundException -> 0x024f, SocketException -> 0x0210, SocketTimeoutException -> 0x01d5, IOException -> 0x01a5, Exception -> 0x0172, all -> 0x0169 }
        long r10 = r1.mCompletedSize     // Catch:{ FileNotFoundException -> 0x024f, SocketException -> 0x0210, SocketTimeoutException -> 0x01d5, IOException -> 0x01a5, Exception -> 0x0172, all -> 0x0169 }
        r12 = 100
        long r10 = r10 * r12
        long r14 = r1.mTotalSize     // Catch:{ FileNotFoundException -> 0x024f, SocketException -> 0x0210, SocketTimeoutException -> 0x01d5, IOException -> 0x01a5, Exception -> 0x0172, all -> 0x0169 }
        long r10 = r10 / r14
        int r11 = (int) r10     // Catch:{ FileNotFoundException -> 0x024f, SocketException -> 0x0210, SocketTimeoutException -> 0x01d5, IOException -> 0x01a5, Exception -> 0x0172, all -> 0x0169 }
        r10 = 100
        r14 = 0
        if (r11 != r10) goto L_0x002b
        return r14
    L_0x002b:
        java.io.File r10 = new java.io.File     // Catch:{ FileNotFoundException -> 0x024f, SocketException -> 0x0210, SocketTimeoutException -> 0x01d5, IOException -> 0x01a5, Exception -> 0x0172, all -> 0x0169 }
        java.lang.String r15 = r1.mTempPath     // Catch:{ FileNotFoundException -> 0x024f, SocketException -> 0x0210, SocketTimeoutException -> 0x01d5, IOException -> 0x01a5, Exception -> 0x0172, all -> 0x0169 }
        java.lang.String r8 = r1.mTempName     // Catch:{ FileNotFoundException -> 0x024f, SocketException -> 0x0210, SocketTimeoutException -> 0x01d5, IOException -> 0x01a5, Exception -> 0x0172, all -> 0x0169 }
        r10.<init>(r15, r8)     // Catch:{ FileNotFoundException -> 0x024f, SocketException -> 0x0210, SocketTimeoutException -> 0x01d5, IOException -> 0x01a5, Exception -> 0x0172, all -> 0x0169 }
        boolean r8 = r10.exists()     // Catch:{ FileNotFoundException -> 0x024f, SocketException -> 0x0210, SocketTimeoutException -> 0x01d5, IOException -> 0x01a5, Exception -> 0x0172, all -> 0x0169 }
        if (r8 != 0) goto L_0x0044
        java.io.File r8 = r10.getParentFile()     // Catch:{ FileNotFoundException -> 0x024f, SocketException -> 0x0210, SocketTimeoutException -> 0x01d5, IOException -> 0x01a5, Exception -> 0x0172, all -> 0x0169 }
        r8.mkdirs()     // Catch:{ FileNotFoundException -> 0x024f, SocketException -> 0x0210, SocketTimeoutException -> 0x01d5, IOException -> 0x01a5, Exception -> 0x0172, all -> 0x0169 }
        r10.createNewFile()     // Catch:{ FileNotFoundException -> 0x024f, SocketException -> 0x0210, SocketTimeoutException -> 0x01d5, IOException -> 0x01a5, Exception -> 0x0172, all -> 0x0169 }
    L_0x0044:
        java.io.FileOutputStream r8 = new java.io.FileOutputStream     // Catch:{ FileNotFoundException -> 0x024f, SocketException -> 0x0210, SocketTimeoutException -> 0x01d5, IOException -> 0x01a5, Exception -> 0x0172, all -> 0x0169 }
        r15 = 1
        r8.<init>(r10, r15)     // Catch:{ FileNotFoundException -> 0x024f, SocketException -> 0x0210, SocketTimeoutException -> 0x01d5, IOException -> 0x01a5, Exception -> 0x0172, all -> 0x0169 }
        if (r21 == 0) goto L_0x0056
        java.util.zip.InflaterInputStream r10 = new java.util.zip.InflaterInputStream     // Catch:{ FileNotFoundException -> 0x0164, SocketException -> 0x0160, SocketTimeoutException -> 0x015c, IOException -> 0x0159, Exception -> 0x0156, all -> 0x0151 }
        java.io.InputStream r15 = r19.getContent()     // Catch:{ FileNotFoundException -> 0x0164, SocketException -> 0x0160, SocketTimeoutException -> 0x015c, IOException -> 0x0159, Exception -> 0x0156, all -> 0x0151 }
        r10.<init>(r15)     // Catch:{ FileNotFoundException -> 0x0164, SocketException -> 0x0160, SocketTimeoutException -> 0x015c, IOException -> 0x0159, Exception -> 0x0156, all -> 0x0151 }
        goto L_0x005a
    L_0x0056:
        java.io.InputStream r10 = r19.getContent()     // Catch:{ FileNotFoundException -> 0x0164, SocketException -> 0x0160, SocketTimeoutException -> 0x015c, IOException -> 0x0159, Exception -> 0x0156, all -> 0x0151 }
    L_0x005a:
        r15 = r11
        r11 = 0
    L_0x005c:
        int r9 = r10.read(r7)     // Catch:{ FileNotFoundException -> 0x014a, SocketException -> 0x0144, SocketTimeoutException -> 0x013e, IOException -> 0x0138, Exception -> 0x0133, all -> 0x0130 }
        r14 = -1
        if (r9 == r14) goto L_0x00bb
        boolean r14 = r1.mIsCanceled     // Catch:{ FileNotFoundException -> 0x014a, SocketException -> 0x0144, SocketTimeoutException -> 0x013e, IOException -> 0x0138, Exception -> 0x0133, all -> 0x0130 }
        if (r14 == 0) goto L_0x008a
        r7 = -5003(0xffffffffffffec75, float:NaN)
        if (r10 == 0) goto L_0x007a
        com.tencent.p605ep.commonbase.api.Log.m31483i(r6, r5)
        r10.close()     // Catch:{ IOException -> 0x0072 }
        goto L_0x007a
    L_0x0072:
        r0 = move-exception
        r5 = r0
        com.tencent.p605ep.commonbase.api.Log.m31479e(r6, r3)
        r5.printStackTrace()
    L_0x007a:
        com.tencent.p605ep.commonbase.api.Log.m31483i(r6, r4)
        r8.close()     // Catch:{ IOException -> 0x0081 }
        goto L_0x0089
    L_0x0081:
        r0 = move-exception
        r3 = r0
        com.tencent.p605ep.commonbase.api.Log.m31479e(r6, r2)
        r3.printStackTrace()
    L_0x0089:
        return r7
    L_0x008a:
        long r12 = r1.mCompletedSize     // Catch:{ FileNotFoundException -> 0x014a, SocketException -> 0x0144, SocketTimeoutException -> 0x013e, IOException -> 0x0138, Exception -> 0x0133, all -> 0x0130 }
        r14 = r2
        r17 = r3
        long r2 = (long) r9
        long r12 = r12 + r2
        r1.mCompletedSize = r12     // Catch:{ FileNotFoundException -> 0x012c, SocketException -> 0x0128, SocketTimeoutException -> 0x0124, IOException -> 0x0120, Exception -> 0x011c, all -> 0x00b5 }
        int r11 = r11 + r9
        long r2 = r1.mCompletedSize     // Catch:{ FileNotFoundException -> 0x012c, SocketException -> 0x0128, SocketTimeoutException -> 0x0124, IOException -> 0x0120, Exception -> 0x011c, all -> 0x00b5 }
        r12 = 100
        long r2 = r2 * r12
        long r12 = r1.mTotalSize     // Catch:{ FileNotFoundException -> 0x012c, SocketException -> 0x0128, SocketTimeoutException -> 0x0124, IOException -> 0x0120, Exception -> 0x011c, all -> 0x00b5 }
        long r2 = r2 / r12
        int r3 = (int) r2
        if (r3 == r15) goto L_0x00aa
        java.lang.String r2 = "key_progress"
        r0.putInt(r2, r3)     // Catch:{ FileNotFoundException -> 0x012c, SocketException -> 0x0128, SocketTimeoutException -> 0x0124, IOException -> 0x0120, Exception -> 0x011c, all -> 0x00b5 }
        r2 = 2
        r1.doCallback(r2, r0)     // Catch:{ FileNotFoundException -> 0x012c, SocketException -> 0x0128, SocketTimeoutException -> 0x0124, IOException -> 0x0120, Exception -> 0x011c, all -> 0x00b5 }
        r15 = r3
    L_0x00aa:
        r2 = 0
        r8.write(r7, r2, r9)     // Catch:{ FileNotFoundException -> 0x012c, SocketException -> 0x0128, SocketTimeoutException -> 0x0124, IOException -> 0x0120, Exception -> 0x011c, all -> 0x00b5 }
        r2 = r14
        r3 = r17
        r12 = 100
        r14 = 0
        goto L_0x005c
    L_0x00b5:
        r0 = move-exception
        r2 = r14
        r3 = r17
        goto L_0x0286
    L_0x00bb:
        r14 = r2
        r17 = r3
        r2 = 0
        r8.flush()     // Catch:{ FileNotFoundException -> 0x012c, SocketException -> 0x0128, SocketTimeoutException -> 0x0124, IOException -> 0x0120, Exception -> 0x011c, all -> 0x0116 }
        java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ FileNotFoundException -> 0x012c, SocketException -> 0x0128, SocketTimeoutException -> 0x0124, IOException -> 0x0120, Exception -> 0x011c, all -> 0x0116 }
        r0.<init>()     // Catch:{ FileNotFoundException -> 0x012c, SocketException -> 0x0128, SocketTimeoutException -> 0x0124, IOException -> 0x0120, Exception -> 0x011c, all -> 0x0116 }
        java.lang.String r3 = "mTotalSize: "
        r0.append(r3)     // Catch:{ FileNotFoundException -> 0x012c, SocketException -> 0x0128, SocketTimeoutException -> 0x0124, IOException -> 0x0120, Exception -> 0x011c, all -> 0x0116 }
        long r12 = r1.mTotalSize     // Catch:{ FileNotFoundException -> 0x012c, SocketException -> 0x0128, SocketTimeoutException -> 0x0124, IOException -> 0x0120, Exception -> 0x011c, all -> 0x0116 }
        r0.append(r12)     // Catch:{ FileNotFoundException -> 0x012c, SocketException -> 0x0128, SocketTimeoutException -> 0x0124, IOException -> 0x0120, Exception -> 0x011c, all -> 0x0116 }
        java.lang.String r3 = ", mCompletedSize: "
        r0.append(r3)     // Catch:{ FileNotFoundException -> 0x012c, SocketException -> 0x0128, SocketTimeoutException -> 0x0124, IOException -> 0x0120, Exception -> 0x011c, all -> 0x0116 }
        long r12 = r1.mCompletedSize     // Catch:{ FileNotFoundException -> 0x012c, SocketException -> 0x0128, SocketTimeoutException -> 0x0124, IOException -> 0x0120, Exception -> 0x011c, all -> 0x0116 }
        r0.append(r12)     // Catch:{ FileNotFoundException -> 0x012c, SocketException -> 0x0128, SocketTimeoutException -> 0x0124, IOException -> 0x0120, Exception -> 0x011c, all -> 0x0116 }
        java.lang.String r3 = ", httpEntity.getContentLength(): "
        r0.append(r3)     // Catch:{ FileNotFoundException -> 0x012c, SocketException -> 0x0128, SocketTimeoutException -> 0x0124, IOException -> 0x0120, Exception -> 0x011c, all -> 0x0116 }
        long r12 = r19.getContentLength()     // Catch:{ FileNotFoundException -> 0x012c, SocketException -> 0x0128, SocketTimeoutException -> 0x0124, IOException -> 0x0120, Exception -> 0x011c, all -> 0x0116 }
        r0.append(r12)     // Catch:{ FileNotFoundException -> 0x012c, SocketException -> 0x0128, SocketTimeoutException -> 0x0124, IOException -> 0x0120, Exception -> 0x011c, all -> 0x0116 }
        java.lang.String r0 = r0.toString()     // Catch:{ FileNotFoundException -> 0x012c, SocketException -> 0x0128, SocketTimeoutException -> 0x0124, IOException -> 0x0120, Exception -> 0x011c, all -> 0x0116 }
        com.tencent.p605ep.commonbase.api.Log.m31483i(r6, r0)     // Catch:{ FileNotFoundException -> 0x012c, SocketException -> 0x0128, SocketTimeoutException -> 0x0124, IOException -> 0x0120, Exception -> 0x011c, all -> 0x0116 }
        long r11 = (long) r11     // Catch:{ FileNotFoundException -> 0x012c, SocketException -> 0x0128, SocketTimeoutException -> 0x0124, IOException -> 0x0120, Exception -> 0x011c, all -> 0x0116 }
        long r15 = r19.getContentLength()     // Catch:{ FileNotFoundException -> 0x012c, SocketException -> 0x0128, SocketTimeoutException -> 0x0124, IOException -> 0x0120, Exception -> 0x011c, all -> 0x0116 }
        int r0 = (r11 > r15 ? 1 : (r11 == r15 ? 0 : -1))
        if (r0 != 0) goto L_0x00f9
        r0 = 0
        goto L_0x00fa
    L_0x00f9:
        r0 = -7
    L_0x00fa:
        if (r10 == 0) goto L_0x0110
        com.tencent.p605ep.commonbase.api.Log.m31483i(r6, r5)
        r10.close()     // Catch:{ IOException -> 0x0103 }
        goto L_0x0110
    L_0x0103:
        r0 = move-exception
        r2 = r0
        r3 = r17
        com.tencent.p605ep.commonbase.api.Log.m31479e(r6, r3)
        r2.printStackTrace()
        r9 = -7000(0xffffffffffffe4a8, float:NaN)
        goto L_0x0111
    L_0x0110:
        r9 = r0
    L_0x0111:
        com.tencent.p605ep.commonbase.api.Log.m31483i(r6, r4)
        goto L_0x01cc
    L_0x0116:
        r0 = move-exception
        r3 = r17
        r2 = r14
        goto L_0x0286
    L_0x011c:
        r0 = move-exception
        r3 = r17
        goto L_0x0135
    L_0x0120:
        r0 = move-exception
        r3 = r17
        goto L_0x013a
    L_0x0124:
        r0 = move-exception
        r3 = r17
        goto L_0x0140
    L_0x0128:
        r0 = move-exception
        r3 = r17
        goto L_0x0146
    L_0x012c:
        r0 = move-exception
        r3 = r17
        goto L_0x014c
    L_0x0130:
        r0 = move-exception
        goto L_0x0286
    L_0x0133:
        r0 = move-exception
        r14 = r2
    L_0x0135:
        r16 = r10
        goto L_0x0177
    L_0x0138:
        r0 = move-exception
        r14 = r2
    L_0x013a:
        r16 = r10
        goto L_0x01aa
    L_0x013e:
        r0 = move-exception
        r14 = r2
    L_0x0140:
        r16 = r10
        goto L_0x01da
    L_0x0144:
        r0 = move-exception
        r14 = r2
    L_0x0146:
        r16 = r10
        goto L_0x0215
    L_0x014a:
        r0 = move-exception
        r14 = r2
    L_0x014c:
        r16 = r10
        r2 = r14
        goto L_0x0253
    L_0x0151:
        r0 = move-exception
        r14 = r2
        r7 = r0
        r2 = r14
        goto L_0x016e
    L_0x0156:
        r0 = move-exception
        r14 = r2
        goto L_0x0175
    L_0x0159:
        r0 = move-exception
        r14 = r2
        goto L_0x01a8
    L_0x015c:
        r0 = move-exception
        r14 = r2
        goto L_0x01d8
    L_0x0160:
        r0 = move-exception
        r14 = r2
        goto L_0x0213
    L_0x0164:
        r0 = move-exception
        r14 = r2
        r2 = r14
        goto L_0x0251
    L_0x0169:
        r0 = move-exception
        r14 = r2
        r7 = r0
        r2 = r14
        r8 = 0
    L_0x016e:
        r16 = 0
        goto L_0x0289
    L_0x0172:
        r0 = move-exception
        r14 = r2
        r8 = 0
    L_0x0175:
        r16 = 0
    L_0x0177:
        r9 = -5000(0xffffffffffffec78, float:NaN)
        java.lang.String r2 = r0.toString()     // Catch:{ all -> 0x024c }
        com.tencent.p605ep.commonbase.api.Log.m31479e(r6, r2)     // Catch:{ all -> 0x024c }
        java.lang.String r2 = "receive data error"
        com.tencent.p605ep.commonbase.api.Log.m31479e(r6, r2)     // Catch:{ all -> 0x024c }
        r0.printStackTrace()     // Catch:{ all -> 0x024c }
        if (r16 == 0) goto L_0x019b
        com.tencent.p605ep.commonbase.api.Log.m31483i(r6, r5)
        r16.close()     // Catch:{ IOException -> 0x0191 }
        goto L_0x019b
    L_0x0191:
        r0 = move-exception
        r2 = r0
        com.tencent.p605ep.commonbase.api.Log.m31479e(r6, r3)
        r2.printStackTrace()
        r9 = -7000(0xffffffffffffe4a8, float:NaN)
    L_0x019b:
        if (r8 == 0) goto L_0x0282
        com.tencent.p605ep.commonbase.api.Log.m31483i(r6, r4)
    L_0x01a0:
        r8.close()     // Catch:{ IOException -> 0x01d1 }
        goto L_0x0282
    L_0x01a5:
        r0 = move-exception
        r14 = r2
        r8 = 0
    L_0x01a8:
        r16 = 0
    L_0x01aa:
        r9 = -5056(0xffffffffffffec40, float:NaN)
        java.lang.String r2 = "socket or file io error"
        com.tencent.p605ep.commonbase.api.Log.m31479e(r6, r2)     // Catch:{ all -> 0x024c }
        r0.printStackTrace()     // Catch:{ all -> 0x024c }
        if (r16 == 0) goto L_0x01c7
        com.tencent.p605ep.commonbase.api.Log.m31483i(r6, r5)
        r16.close()     // Catch:{ IOException -> 0x01bd }
        goto L_0x01c7
    L_0x01bd:
        r0 = move-exception
        r2 = r0
        com.tencent.p605ep.commonbase.api.Log.m31479e(r6, r3)
        r2.printStackTrace()
        r9 = -7000(0xffffffffffffe4a8, float:NaN)
    L_0x01c7:
        if (r8 == 0) goto L_0x0282
        com.tencent.p605ep.commonbase.api.Log.m31483i(r6, r4)
    L_0x01cc:
        r8.close()     // Catch:{ IOException -> 0x01d1 }
        goto L_0x0282
    L_0x01d1:
        r0 = move-exception
        r2 = r14
        goto L_0x027a
    L_0x01d5:
        r0 = move-exception
        r14 = r2
        r8 = 0
    L_0x01d8:
        r16 = 0
    L_0x01da:
        r9 = -5055(0xffffffffffffec41, float:NaN)
        java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x024c }
        r2.<init>()     // Catch:{ all -> 0x024c }
        java.lang.String r7 = "socket timeout error:"
        r2.append(r7)     // Catch:{ all -> 0x024c }
        java.lang.String r7 = r0.getMessage()     // Catch:{ all -> 0x024c }
        r2.append(r7)     // Catch:{ all -> 0x024c }
        java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x024c }
        com.tencent.p605ep.commonbase.api.Log.m31479e(r6, r2)     // Catch:{ all -> 0x024c }
        r0.printStackTrace()     // Catch:{ all -> 0x024c }
        if (r16 == 0) goto L_0x020a
        com.tencent.p605ep.commonbase.api.Log.m31483i(r6, r5)
        r16.close()     // Catch:{ IOException -> 0x0200 }
        goto L_0x020a
    L_0x0200:
        r0 = move-exception
        r2 = r0
        com.tencent.p605ep.commonbase.api.Log.m31479e(r6, r3)
        r2.printStackTrace()
        r9 = -7000(0xffffffffffffe4a8, float:NaN)
    L_0x020a:
        if (r8 == 0) goto L_0x0282
        com.tencent.p605ep.commonbase.api.Log.m31483i(r6, r4)
        goto L_0x01a0
    L_0x0210:
        r0 = move-exception
        r14 = r2
        r8 = 0
    L_0x0213:
        r16 = 0
    L_0x0215:
        r9 = -5054(0xffffffffffffec42, float:NaN)
        java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x024c }
        r2.<init>()     // Catch:{ all -> 0x024c }
        java.lang.String r7 = "socket error:"
        r2.append(r7)     // Catch:{ all -> 0x024c }
        java.lang.String r7 = r0.getMessage()     // Catch:{ all -> 0x024c }
        r2.append(r7)     // Catch:{ all -> 0x024c }
        java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x024c }
        com.tencent.p605ep.commonbase.api.Log.m31479e(r6, r2)     // Catch:{ all -> 0x024c }
        r0.printStackTrace()     // Catch:{ all -> 0x024c }
        if (r16 == 0) goto L_0x0245
        com.tencent.p605ep.commonbase.api.Log.m31483i(r6, r5)
        r16.close()     // Catch:{ IOException -> 0x023b }
        goto L_0x0245
    L_0x023b:
        r0 = move-exception
        r2 = r0
        com.tencent.p605ep.commonbase.api.Log.m31479e(r6, r3)
        r2.printStackTrace()
        r9 = -7000(0xffffffffffffe4a8, float:NaN)
    L_0x0245:
        if (r8 == 0) goto L_0x0282
        com.tencent.p605ep.commonbase.api.Log.m31483i(r6, r4)
        goto L_0x01a0
    L_0x024c:
        r0 = move-exception
        r2 = r14
        goto L_0x0284
    L_0x024f:
        r0 = move-exception
        r8 = 0
    L_0x0251:
        r16 = 0
    L_0x0253:
        r9 = -7001(0xffffffffffffe4a7, float:NaN)
        java.lang.String r7 = "file not found"
        com.tencent.p605ep.commonbase.api.Log.m31479e(r6, r7)     // Catch:{ all -> 0x0283 }
        r0.printStackTrace()     // Catch:{ all -> 0x0283 }
        if (r16 == 0) goto L_0x0270
        com.tencent.p605ep.commonbase.api.Log.m31483i(r6, r5)
        r16.close()     // Catch:{ IOException -> 0x0266 }
        goto L_0x0270
    L_0x0266:
        r0 = move-exception
        r5 = r0
        com.tencent.p605ep.commonbase.api.Log.m31479e(r6, r3)
        r5.printStackTrace()
        r9 = -7000(0xffffffffffffe4a8, float:NaN)
    L_0x0270:
        if (r8 == 0) goto L_0x0282
        com.tencent.p605ep.commonbase.api.Log.m31483i(r6, r4)
        r8.close()     // Catch:{ IOException -> 0x0279 }
        goto L_0x0282
    L_0x0279:
        r0 = move-exception
    L_0x027a:
        com.tencent.p605ep.commonbase.api.Log.m31479e(r6, r2)
        r0.printStackTrace()
        r9 = -7000(0xffffffffffffe4a8, float:NaN)
    L_0x0282:
        return r9
    L_0x0283:
        r0 = move-exception
    L_0x0284:
        r10 = r16
    L_0x0286:
        r7 = r0
        r16 = r10
    L_0x0289:
        if (r16 == 0) goto L_0x029a
        com.tencent.p605ep.commonbase.api.Log.m31483i(r6, r5)
        r16.close()     // Catch:{ IOException -> 0x0292 }
        goto L_0x029a
    L_0x0292:
        r0 = move-exception
        r5 = r0
        com.tencent.p605ep.commonbase.api.Log.m31479e(r6, r3)
        r5.printStackTrace()
    L_0x029a:
        if (r8 == 0) goto L_0x02ab
        com.tencent.p605ep.commonbase.api.Log.m31483i(r6, r4)
        r8.close()     // Catch:{ IOException -> 0x02a3 }
        goto L_0x02ab
    L_0x02a3:
        r0 = move-exception
        r3 = r0
        com.tencent.p605ep.commonbase.api.Log.m31479e(r6, r2)
        r3.printStackTrace()
    L_0x02ab:
        throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: discoveryAD.C7911ka.m34325a(org.apache.http.HttpEntity, android.os.Bundle, boolean):int");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:100:0x016e, code lost:
            if (r6.exists() != false) goto L_0x01a5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:120:0x01a3, code lost:
            if (r6.exists() != false) goto L_0x01a5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:121:0x01a5, code lost:
            r6.delete();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x00f4, code lost:
            if (r6.exists() != false) goto L_0x01a5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:80:0x0137, code lost:
            if (r6.exists() != false) goto L_0x01a5;
     */
    /* JADX WARNING: Removed duplicated region for block: B:107:0x017f A[SYNTHETIC, Splitter:B:107:0x017f] */
    /* JADX WARNING: Removed duplicated region for block: B:112:0x018e A[SYNTHETIC, Splitter:B:112:0x018e] */
    /* JADX WARNING: Removed duplicated region for block: B:118:0x019d  */
    /* JADX WARNING: Removed duplicated region for block: B:124:0x01ab A[SYNTHETIC, Splitter:B:124:0x01ab] */
    /* JADX WARNING: Removed duplicated region for block: B:129:0x01b8 A[SYNTHETIC, Splitter:B:129:0x01b8] */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x0117 A[SYNTHETIC, Splitter:B:68:0x0117] */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x0124 A[SYNTHETIC, Splitter:B:73:0x0124] */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x0131  */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x014a A[SYNTHETIC, Splitter:B:87:0x014a] */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x0159 A[SYNTHETIC, Splitter:B:92:0x0159] */
    /* JADX WARNING: Removed duplicated region for block: B:98:0x0168  */
    private int copyTempFile(boolean r14) {
        /*
        r13 = this;
        java.lang.String r0 = "fosclose file error"
        java.lang.String r1 = "fis close file error"
        java.lang.String r2 = "HttpBase"
        java.lang.StringBuilder r3 = new java.lang.StringBuilder
        r3.<init>()
        java.lang.String r4 = r13.mTempPath
        r3.append(r4)
        java.lang.String r4 = java.io.File.separator
        r3.append(r4)
        java.lang.String r4 = r13.mTempName
        r3.append(r4)
        java.lang.String r3 = r3.toString()
        java.lang.String r4 = "HttpGetFile"
        com.tencent.p605ep.commonbase.api.Log.m31483i(r4, r3)
        java.lang.StringBuilder r3 = new java.lang.StringBuilder
        r3.<init>()
        java.lang.String r5 = r13.mSavePath
        r3.append(r5)
        java.lang.String r5 = java.io.File.separator
        r3.append(r5)
        java.lang.String r5 = r13.mSaveName
        r3.append(r5)
        java.lang.String r3 = r3.toString()
        com.tencent.p605ep.commonbase.api.Log.m31483i(r4, r3)
        r3 = -7001(0xffffffffffffe4a7, float:NaN)
        r4 = 0
        r5 = -7000(0xffffffffffffe4a8, float:NaN)
        java.io.File r6 = new java.io.File     // Catch:{ FileNotFoundException -> 0x0171, IOException -> 0x013b, Exception -> 0x010a, all -> 0x0105 }
        java.lang.String r7 = r13.mTempPath     // Catch:{ FileNotFoundException -> 0x0171, IOException -> 0x013b, Exception -> 0x010a, all -> 0x0105 }
        java.lang.String r8 = r13.mTempName     // Catch:{ FileNotFoundException -> 0x0171, IOException -> 0x013b, Exception -> 0x010a, all -> 0x0105 }
        r6.<init>(r7, r8)     // Catch:{ FileNotFoundException -> 0x0171, IOException -> 0x013b, Exception -> 0x010a, all -> 0x0105 }
        boolean r7 = r6.exists()     // Catch:{ FileNotFoundException -> 0x0101, IOException -> 0x00fe, Exception -> 0x00fb, all -> 0x00f7 }
        r8 = 0
        if (r7 == 0) goto L_0x00cf
        int r7 = r13.mFileMode     // Catch:{ FileNotFoundException -> 0x0101, IOException -> 0x00fe, Exception -> 0x00fb, all -> 0x00f7 }
        r9 = 1
        if (r7 != r9) goto L_0x0074
        android.content.Context r7 = r13.mContext     // Catch:{ FileNotFoundException -> 0x0101, IOException -> 0x00fe, Exception -> 0x00fb, all -> 0x00f7 }
        java.io.File r7 = r7.getFilesDir()     // Catch:{ FileNotFoundException -> 0x0101, IOException -> 0x00fe, Exception -> 0x00fb, all -> 0x00f7 }
        java.lang.String r7 = r7.getAbsolutePath()     // Catch:{ FileNotFoundException -> 0x0101, IOException -> 0x00fe, Exception -> 0x00fb, all -> 0x00f7 }
        java.lang.String r10 = r13.mSavePath     // Catch:{ FileNotFoundException -> 0x0101, IOException -> 0x00fe, Exception -> 0x00fb, all -> 0x00f7 }
        boolean r7 = r7.equals(r10)     // Catch:{ FileNotFoundException -> 0x0101, IOException -> 0x00fe, Exception -> 0x00fb, all -> 0x00f7 }
        if (r7 == 0) goto L_0x0074
        android.content.Context r7 = r13.mContext     // Catch:{ FileNotFoundException -> 0x0101, IOException -> 0x00fe, Exception -> 0x00fb, all -> 0x00f7 }
        java.lang.String r10 = r13.mSaveName     // Catch:{ FileNotFoundException -> 0x0101, IOException -> 0x00fe, Exception -> 0x00fb, all -> 0x00f7 }
        java.io.FileOutputStream r7 = r7.openFileOutput(r10, r9)     // Catch:{ FileNotFoundException -> 0x0101, IOException -> 0x00fe, Exception -> 0x00fb, all -> 0x00f7 }
        r9 = r7
        goto L_0x009b
    L_0x0074:
        java.io.File r7 = new java.io.File     // Catch:{ FileNotFoundException -> 0x0101, IOException -> 0x00fe, Exception -> 0x00fb, all -> 0x00f7 }
        java.lang.String r9 = r13.getFullPathSaveName()     // Catch:{ FileNotFoundException -> 0x0101, IOException -> 0x00fe, Exception -> 0x00fb, all -> 0x00f7 }
        r7.<init>(r9)     // Catch:{ FileNotFoundException -> 0x0101, IOException -> 0x00fe, Exception -> 0x00fb, all -> 0x00f7 }
        boolean r9 = r7.exists()     // Catch:{ FileNotFoundException -> 0x0101, IOException -> 0x00fe, Exception -> 0x00fb, all -> 0x00f7 }
        if (r9 == 0) goto L_0x008c
        r7.delete()     // Catch:{ FileNotFoundException -> 0x0101, IOException -> 0x00fe, Exception -> 0x00fb, all -> 0x00f7 }
        java.io.FileOutputStream r9 = new java.io.FileOutputStream     // Catch:{ FileNotFoundException -> 0x0101, IOException -> 0x00fe, Exception -> 0x00fb, all -> 0x00f7 }
        r9.<init>(r7)     // Catch:{ FileNotFoundException -> 0x0101, IOException -> 0x00fe, Exception -> 0x00fb, all -> 0x00f7 }
        goto L_0x009b
    L_0x008c:
        java.io.File r9 = r7.getParentFile()     // Catch:{ FileNotFoundException -> 0x0101, IOException -> 0x00fe, Exception -> 0x00fb, all -> 0x00f7 }
        r9.mkdirs()     // Catch:{ FileNotFoundException -> 0x0101, IOException -> 0x00fe, Exception -> 0x00fb, all -> 0x00f7 }
        r7.createNewFile()     // Catch:{ FileNotFoundException -> 0x0101, IOException -> 0x00fe, Exception -> 0x00fb, all -> 0x00f7 }
        java.io.FileOutputStream r9 = new java.io.FileOutputStream     // Catch:{ FileNotFoundException -> 0x0101, IOException -> 0x00fe, Exception -> 0x00fb, all -> 0x00f7 }
        r9.<init>(r7)     // Catch:{ FileNotFoundException -> 0x0101, IOException -> 0x00fe, Exception -> 0x00fb, all -> 0x00f7 }
    L_0x009b:
        java.io.FileInputStream r7 = new java.io.FileInputStream     // Catch:{ FileNotFoundException -> 0x00cc, IOException -> 0x00c9, Exception -> 0x00c7 }
        r7.<init>(r6)     // Catch:{ FileNotFoundException -> 0x00cc, IOException -> 0x00c9, Exception -> 0x00c7 }
        r4 = 1024(0x400, float:1.435E-42)
        byte[] r4 = new byte[r4]     // Catch:{ FileNotFoundException -> 0x00be, IOException -> 0x00ba, Exception -> 0x00b6, all -> 0x00b2 }
    L_0x00a4:
        int r10 = r7.read(r4)     // Catch:{ FileNotFoundException -> 0x00be, IOException -> 0x00ba, Exception -> 0x00b6, all -> 0x00b2 }
        r11 = -1
        if (r10 == r11) goto L_0x00af
        r9.write(r4, r8, r10)     // Catch:{ FileNotFoundException -> 0x00be, IOException -> 0x00ba, Exception -> 0x00b6, all -> 0x00b2 }
        goto L_0x00a4
    L_0x00af:
        r4 = r7
        r3 = 0
        goto L_0x00d0
    L_0x00b2:
        r3 = move-exception
        r4 = r7
        goto L_0x01a9
    L_0x00b6:
        r3 = move-exception
        r4 = r7
        goto L_0x010d
    L_0x00ba:
        r3 = move-exception
        r4 = r7
        goto L_0x013e
    L_0x00be:
        r4 = move-exception
        r12 = r7
        r7 = r4
        r4 = r12
        goto L_0x0175
    L_0x00c4:
        r3 = move-exception
        goto L_0x01a9
    L_0x00c7:
        r3 = move-exception
        goto L_0x010d
    L_0x00c9:
        r3 = move-exception
        goto L_0x013e
    L_0x00cc:
        r7 = move-exception
        goto L_0x0175
    L_0x00cf:
        r9 = r4
    L_0x00d0:
        if (r4 == 0) goto L_0x00df
        r4.close()     // Catch:{ IOException -> 0x00d6 }
        goto L_0x00df
    L_0x00d6:
        r3 = move-exception
        com.tencent.p605ep.commonbase.api.Log.m31479e(r2, r1)
        r3.printStackTrace()
        r3 = -7000(0xffffffffffffe4a8, float:NaN)
    L_0x00df:
        if (r9 == 0) goto L_0x00ed
        r9.close()     // Catch:{ IOException -> 0x00e5 }
        goto L_0x00ed
    L_0x00e5:
        r1 = move-exception
        com.tencent.p605ep.commonbase.api.Log.m31479e(r2, r0)
        r1.printStackTrace()
        goto L_0x00ee
    L_0x00ed:
        r5 = r3
    L_0x00ee:
        if (r14 == 0) goto L_0x01a8
        boolean r14 = r6.exists()
        if (r14 == 0) goto L_0x01a8
        goto L_0x0139
    L_0x00f7:
        r3 = move-exception
        r9 = r4
        goto L_0x01a9
    L_0x00fb:
        r3 = move-exception
        r9 = r4
        goto L_0x010d
    L_0x00fe:
        r3 = move-exception
        r9 = r4
        goto L_0x013e
    L_0x0101:
        r7 = move-exception
        r9 = r4
        goto L_0x0175
    L_0x0105:
        r3 = move-exception
        r6 = r4
        r9 = r6
        goto L_0x01a9
    L_0x010a:
        r3 = move-exception
        r6 = r4
        r9 = r6
    L_0x010d:
        java.lang.String r7 = "file op error"
        com.tencent.p605ep.commonbase.api.Log.m31479e(r2, r7)     // Catch:{ all -> 0x00c4 }
        r3.printStackTrace()     // Catch:{ all -> 0x00c4 }
        if (r4 == 0) goto L_0x0122
        r4.close()     // Catch:{ IOException -> 0x011b }
        goto L_0x0122
    L_0x011b:
        r3 = move-exception
        com.tencent.p605ep.commonbase.api.Log.m31479e(r2, r1)
        r3.printStackTrace()
    L_0x0122:
        if (r9 == 0) goto L_0x012f
        r9.close()     // Catch:{ IOException -> 0x0128 }
        goto L_0x012f
    L_0x0128:
        r1 = move-exception
        com.tencent.p605ep.commonbase.api.Log.m31479e(r2, r0)
        r1.printStackTrace()
    L_0x012f:
        if (r14 == 0) goto L_0x01a8
        if (r6 == 0) goto L_0x01a8
        boolean r14 = r6.exists()
        if (r14 == 0) goto L_0x01a8
    L_0x0139:
        goto L_0x01a5
    L_0x013b:
        r3 = move-exception
        r6 = r4
        r9 = r6
    L_0x013e:
        r7 = -7056(0xffffffffffffe470, float:NaN)
        java.lang.String r8 = "file io error"
        com.tencent.p605ep.commonbase.api.Log.m31479e(r2, r8)     // Catch:{ all -> 0x00c4 }
        r3.printStackTrace()     // Catch:{ all -> 0x00c4 }
        if (r4 == 0) goto L_0x0157
        r4.close()     // Catch:{ IOException -> 0x014e }
        goto L_0x0157
    L_0x014e:
        r3 = move-exception
        com.tencent.p605ep.commonbase.api.Log.m31479e(r2, r1)
        r3.printStackTrace()
        r7 = -7000(0xffffffffffffe4a8, float:NaN)
    L_0x0157:
        if (r9 == 0) goto L_0x0165
        r9.close()     // Catch:{ IOException -> 0x015d }
        goto L_0x0165
    L_0x015d:
        r1 = move-exception
        com.tencent.p605ep.commonbase.api.Log.m31479e(r2, r0)
        r1.printStackTrace()
        goto L_0x0166
    L_0x0165:
        r5 = r7
    L_0x0166:
        if (r14 == 0) goto L_0x01a8
        if (r6 == 0) goto L_0x01a8
        boolean r14 = r6.exists()
        if (r14 == 0) goto L_0x01a8
        goto L_0x01a5
    L_0x0171:
        r6 = move-exception
        r9 = r4
        r7 = r6
        r6 = r9
    L_0x0175:
        java.lang.String r8 = "file not found"
        com.tencent.p605ep.commonbase.api.Log.m31479e(r2, r8)     // Catch:{ all -> 0x00c4 }
        r7.printStackTrace()     // Catch:{ all -> 0x00c4 }
        if (r4 == 0) goto L_0x018c
        r4.close()     // Catch:{ IOException -> 0x0183 }
        goto L_0x018c
    L_0x0183:
        r3 = move-exception
        com.tencent.p605ep.commonbase.api.Log.m31479e(r2, r1)
        r3.printStackTrace()
        r3 = -7000(0xffffffffffffe4a8, float:NaN)
    L_0x018c:
        if (r9 == 0) goto L_0x019a
        r9.close()     // Catch:{ IOException -> 0x0192 }
        goto L_0x019a
    L_0x0192:
        r1 = move-exception
        com.tencent.p605ep.commonbase.api.Log.m31479e(r2, r0)
        r1.printStackTrace()
        goto L_0x019b
    L_0x019a:
        r5 = r3
    L_0x019b:
        if (r14 == 0) goto L_0x01a8
        if (r6 == 0) goto L_0x01a8
        boolean r14 = r6.exists()
        if (r14 == 0) goto L_0x01a8
    L_0x01a5:
        r6.delete()
    L_0x01a8:
        return r5
    L_0x01a9:
        if (r4 == 0) goto L_0x01b6
        r4.close()     // Catch:{ IOException -> 0x01af }
        goto L_0x01b6
    L_0x01af:
        r4 = move-exception
        com.tencent.p605ep.commonbase.api.Log.m31479e(r2, r1)
        r4.printStackTrace()
    L_0x01b6:
        if (r9 == 0) goto L_0x01c3
        r9.close()     // Catch:{ IOException -> 0x01bc }
        goto L_0x01c3
    L_0x01bc:
        r1 = move-exception
        com.tencent.p605ep.commonbase.api.Log.m31479e(r2, r0)
        r1.printStackTrace()
    L_0x01c3:
        if (r14 == 0) goto L_0x01d0
        if (r6 == 0) goto L_0x01d0
        boolean r14 = r6.exists()
        if (r14 == 0) goto L_0x01d0
        r6.delete()
    L_0x01d0:
        throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: discoveryAD.C7911ka.copyTempFile(boolean):int");
    }

    private int setUri(String str) {
        int i;
        URI uri;
        try {
            uri = new URI(str);
            i = -1000;
        } catch (URISyntaxException e) {
            StringBuilder sb = new StringBuilder();
            sb.append("url error: ");
            sb.append(e.getMessage());
            Log.m31479e("HttpBase", sb.toString());
            e.printStackTrace();
            i = -1053;
            uri = null;
        }
        if (uri == null) {
            return i;
        }
        this.f26910ne.setURI(uri);
        return 0;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:101:0x015f, code lost:
            r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:102:0x0160, code lost:
            r4 = r15;
            r2 = r18;
            r14 = -4000;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:112:0x0195, code lost:
            r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:113:0x0196, code lost:
            r2 = r18;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:123:0x01d7, code lost:
            r14 = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:124:0x01da, code lost:
            r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:125:0x01db, code lost:
            r2 = r18;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:126:0x01df, code lost:
            r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:127:0x01e0, code lost:
            r2 = r18;
            r14 = r16;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:128:0x01e5, code lost:
            r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:129:0x01e6, code lost:
            r2 = r18;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:130:0x01e8, code lost:
            r14 = -3000;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:131:0x01ec, code lost:
            r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:132:0x01ef, code lost:
            r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:133:0x01f2, code lost:
            r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:134:0x01f5, code lost:
            r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:135:0x01f8, code lost:
            r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:136:0x01f9, code lost:
            r2 = r18;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:140:0x0204, code lost:
            r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:141:0x0205, code lost:
            r15 = r3;
            r2 = r4;
            r14 = -3000;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:142:0x020a, code lost:
            r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:143:0x020b, code lost:
            r15 = r3;
            r2 = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:144:0x020e, code lost:
            r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:145:0x020f, code lost:
            r15 = r3;
            r2 = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:146:0x0212, code lost:
            r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:147:0x0213, code lost:
            r15 = r3;
            r2 = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:148:0x0217, code lost:
            r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:149:0x0218, code lost:
            r15 = r3;
            r2 = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:150:0x021c, code lost:
            r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:151:0x021d, code lost:
            r15 = r3;
            r2 = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:164:0x024f, code lost:
            if (r12 == null) goto L_0x0303;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:165:0x0251, code lost:
            r12.getConnectionManager().shutdown();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:176:0x027f, code lost:
            if (r12 != null) goto L_0x0251;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:187:0x02a7, code lost:
            if (r12 != null) goto L_0x0251;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:198:0x02cf, code lost:
            if (r12 != null) goto L_0x0251;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:213:0x02ff, code lost:
            if (r12 != null) goto L_0x0251;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:214:0x0303, code lost:
            r11.putInt(r8, r14);
            r11.putString(r7, r3);
            r11.putInt(r6, (int) r1.mCompletedSize);
            r11.putInt(r5, (int) r1.mTotalSize);
            r11.putInt(r2, discoveryAD.C7906ia.getSdcardStatus(r1.mTotalSize - r1.mCompletedSize));
            r0 = r1.isContinue;
            r3 = r14;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:224:0x0338, code lost:
            r12.getConnectionManager().shutdown();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0056, code lost:
            r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0057, code lost:
            r15 = r3;
            r18 = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x005c, code lost:
            r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x005d, code lost:
            r15 = r3;
            r18 = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0062, code lost:
            r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0063, code lost:
            r15 = r3;
            r18 = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0068, code lost:
            r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0069, code lost:
            r15 = r3;
            r18 = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x006e, code lost:
            r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x006f, code lost:
            r15 = r3;
            r18 = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x00b1, code lost:
            r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x00b2, code lost:
            r15 = r3;
            r18 = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x00b5, code lost:
            r14 = r16;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x00f3, code lost:
            r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x00fa, code lost:
            r2 = r18;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x00fe, code lost:
            r2 = r18;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:0x0102, code lost:
            r2 = r18;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x0106, code lost:
            r2 = r18;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [B:16:0x0042, B:46:0x00ae] */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:118:0x01a7  */
    /* JADX WARNING: Removed duplicated region for block: B:124:0x01da A[ExcHandler: Exception (e java.lang.Exception), Splitter:B:91:0x0148] */
    /* JADX WARNING: Removed duplicated region for block: B:126:0x01df A[ExcHandler: all (th java.lang.Throwable), PHI: r16 
  PHI: (r16v1 int) = (r16v0 int), (r16v0 int), (r16v0 int), (r16v0 int), (r16v2 int), (r16v2 int), (r16v2 int) binds: {(r16v0 int)=B:77:0x0113, (r16v0 int)=B:78:?, (r16v0 int)=B:80:0x0122, (r16v0 int)=B:81:?, (r16v2 int)=B:91:0x0148, (r16v2 int)=B:104:0x0169, (r16v2 int)=B:105:?} A[DONT_GENERATE, DONT_INLINE], Splitter:B:77:0x0113] */
    /* JADX WARNING: Removed duplicated region for block: B:128:0x01e5 A[ExcHandler: Exception (e java.lang.Exception), PHI: r15 r18 
  PHI: (r15v40 java.lang.String) = (r15v41 java.lang.String), (r15v41 java.lang.String), (r15v41 java.lang.String), (r15v41 java.lang.String), (r15v41 java.lang.String), (r15v41 java.lang.String), (r15v44 java.lang.String), (r15v44 java.lang.String), (r15v44 java.lang.String), (r15v44 java.lang.String) binds: {(r15v41 java.lang.String)=B:75:0x010d, (r15v41 java.lang.String)=B:76:?, (r15v41 java.lang.String)=B:77:0x0113, (r15v41 java.lang.String)=B:78:?, (r15v41 java.lang.String)=B:80:0x0122, (r15v41 java.lang.String)=B:81:?, (r15v44 java.lang.String)=B:63:0x00de, (r15v44 java.lang.String)=B:64:?, (r15v44 java.lang.String)=B:66:0x00e5, (r15v44 java.lang.String)=B:67:?} A[DONT_GENERATE, DONT_INLINE]
  PHI: (r18v13 java.lang.String) = (r18v14 java.lang.String), (r18v14 java.lang.String), (r18v14 java.lang.String), (r18v14 java.lang.String), (r18v14 java.lang.String), (r18v14 java.lang.String), (r18v16 java.lang.String), (r18v16 java.lang.String), (r18v16 java.lang.String), (r18v16 java.lang.String) binds: {(r18v14 java.lang.String)=B:75:0x010d, (r18v14 java.lang.String)=B:76:?, (r18v14 java.lang.String)=B:77:0x0113, (r18v14 java.lang.String)=B:78:?, (r18v14 java.lang.String)=B:80:0x0122, (r18v14 java.lang.String)=B:81:?, (r18v16 java.lang.String)=B:63:0x00de, (r18v16 java.lang.String)=B:64:?, (r18v16 java.lang.String)=B:66:0x00e5, (r18v16 java.lang.String)=B:67:?} A[DONT_GENERATE, DONT_INLINE], Splitter:B:63:0x00de] */
    /* JADX WARNING: Removed duplicated region for block: B:131:0x01ec A[ExcHandler: IOException (e java.io.IOException), PHI: r15 r18 
  PHI: (r15v39 java.lang.String) = (r15v41 java.lang.String), (r15v41 java.lang.String), (r15v41 java.lang.String), (r15v41 java.lang.String), (r15v41 java.lang.String), (r15v41 java.lang.String), (r15v41 java.lang.String), (r15v41 java.lang.String), (r15v41 java.lang.String), (r15v41 java.lang.String), (r15v41 java.lang.String), (r15v41 java.lang.String), (r15v44 java.lang.String), (r15v44 java.lang.String), (r15v44 java.lang.String), (r15v44 java.lang.String) binds: {(r15v41 java.lang.String)=B:75:0x010d, (r15v41 java.lang.String)=B:76:?, (r15v41 java.lang.String)=B:77:0x0113, (r15v41 java.lang.String)=B:78:?, (r15v41 java.lang.String)=B:80:0x0122, (r15v41 java.lang.String)=B:81:?, (r15v41 java.lang.String)=B:91:0x0148, (r15v41 java.lang.String)=B:104:0x0169, (r15v41 java.lang.String)=B:105:?, (r15v41 java.lang.String)=B:108:0x0172, (r15v41 java.lang.String)=B:98:0x0158, (r15v41 java.lang.String)=B:99:?, (r15v44 java.lang.String)=B:63:0x00de, (r15v44 java.lang.String)=B:64:?, (r15v44 java.lang.String)=B:66:0x00e5, (r15v44 java.lang.String)=B:67:?} A[DONT_GENERATE, DONT_INLINE]
  PHI: (r18v12 java.lang.String) = (r18v14 java.lang.String), (r18v14 java.lang.String), (r18v14 java.lang.String), (r18v14 java.lang.String), (r18v14 java.lang.String), (r18v14 java.lang.String), (r18v14 java.lang.String), (r18v14 java.lang.String), (r18v14 java.lang.String), (r18v14 java.lang.String), (r18v14 java.lang.String), (r18v14 java.lang.String), (r18v16 java.lang.String), (r18v16 java.lang.String), (r18v16 java.lang.String), (r18v16 java.lang.String) binds: {(r18v14 java.lang.String)=B:75:0x010d, (r18v14 java.lang.String)=B:76:?, (r18v14 java.lang.String)=B:77:0x0113, (r18v14 java.lang.String)=B:78:?, (r18v14 java.lang.String)=B:80:0x0122, (r18v14 java.lang.String)=B:81:?, (r18v14 java.lang.String)=B:91:0x0148, (r18v14 java.lang.String)=B:104:0x0169, (r18v14 java.lang.String)=B:105:?, (r18v14 java.lang.String)=B:108:0x0172, (r18v14 java.lang.String)=B:98:0x0158, (r18v14 java.lang.String)=B:99:?, (r18v16 java.lang.String)=B:63:0x00de, (r18v16 java.lang.String)=B:64:?, (r18v16 java.lang.String)=B:66:0x00e5, (r18v16 java.lang.String)=B:67:?} A[DONT_GENERATE, DONT_INLINE], Splitter:B:75:0x010d] */
    /* JADX WARNING: Removed duplicated region for block: B:132:0x01ef A[ExcHandler: SocketTimeoutException (e java.net.SocketTimeoutException), PHI: r15 r18 
  PHI: (r15v38 java.lang.String) = (r15v41 java.lang.String), (r15v41 java.lang.String), (r15v41 java.lang.String), (r15v41 java.lang.String), (r15v41 java.lang.String), (r15v41 java.lang.String), (r15v41 java.lang.String), (r15v41 java.lang.String), (r15v41 java.lang.String), (r15v41 java.lang.String), (r15v41 java.lang.String), (r15v41 java.lang.String), (r15v44 java.lang.String), (r15v44 java.lang.String), (r15v44 java.lang.String), (r15v44 java.lang.String) binds: {(r15v41 java.lang.String)=B:75:0x010d, (r15v41 java.lang.String)=B:76:?, (r15v41 java.lang.String)=B:77:0x0113, (r15v41 java.lang.String)=B:78:?, (r15v41 java.lang.String)=B:80:0x0122, (r15v41 java.lang.String)=B:81:?, (r15v41 java.lang.String)=B:91:0x0148, (r15v41 java.lang.String)=B:104:0x0169, (r15v41 java.lang.String)=B:105:?, (r15v41 java.lang.String)=B:108:0x0172, (r15v41 java.lang.String)=B:98:0x0158, (r15v41 java.lang.String)=B:99:?, (r15v44 java.lang.String)=B:63:0x00de, (r15v44 java.lang.String)=B:64:?, (r15v44 java.lang.String)=B:66:0x00e5, (r15v44 java.lang.String)=B:67:?} A[DONT_GENERATE, DONT_INLINE]
  PHI: (r18v11 java.lang.String) = (r18v14 java.lang.String), (r18v14 java.lang.String), (r18v14 java.lang.String), (r18v14 java.lang.String), (r18v14 java.lang.String), (r18v14 java.lang.String), (r18v14 java.lang.String), (r18v14 java.lang.String), (r18v14 java.lang.String), (r18v14 java.lang.String), (r18v14 java.lang.String), (r18v14 java.lang.String), (r18v16 java.lang.String), (r18v16 java.lang.String), (r18v16 java.lang.String), (r18v16 java.lang.String) binds: {(r18v14 java.lang.String)=B:75:0x010d, (r18v14 java.lang.String)=B:76:?, (r18v14 java.lang.String)=B:77:0x0113, (r18v14 java.lang.String)=B:78:?, (r18v14 java.lang.String)=B:80:0x0122, (r18v14 java.lang.String)=B:81:?, (r18v14 java.lang.String)=B:91:0x0148, (r18v14 java.lang.String)=B:104:0x0169, (r18v14 java.lang.String)=B:105:?, (r18v14 java.lang.String)=B:108:0x0172, (r18v14 java.lang.String)=B:98:0x0158, (r18v14 java.lang.String)=B:99:?, (r18v16 java.lang.String)=B:63:0x00de, (r18v16 java.lang.String)=B:64:?, (r18v16 java.lang.String)=B:66:0x00e5, (r18v16 java.lang.String)=B:67:?} A[DONT_GENERATE, DONT_INLINE], Splitter:B:63:0x00de] */
    /* JADX WARNING: Removed duplicated region for block: B:133:0x01f2 A[ExcHandler: SocketException (e java.net.SocketException), PHI: r15 r18 
  PHI: (r15v37 java.lang.String) = (r15v41 java.lang.String), (r15v41 java.lang.String), (r15v41 java.lang.String), (r15v41 java.lang.String), (r15v41 java.lang.String), (r15v41 java.lang.String), (r15v41 java.lang.String), (r15v41 java.lang.String), (r15v41 java.lang.String), (r15v41 java.lang.String), (r15v41 java.lang.String), (r15v41 java.lang.String), (r15v44 java.lang.String), (r15v44 java.lang.String), (r15v44 java.lang.String), (r15v44 java.lang.String) binds: {(r15v41 java.lang.String)=B:75:0x010d, (r15v41 java.lang.String)=B:76:?, (r15v41 java.lang.String)=B:77:0x0113, (r15v41 java.lang.String)=B:78:?, (r15v41 java.lang.String)=B:80:0x0122, (r15v41 java.lang.String)=B:81:?, (r15v41 java.lang.String)=B:91:0x0148, (r15v41 java.lang.String)=B:104:0x0169, (r15v41 java.lang.String)=B:105:?, (r15v41 java.lang.String)=B:108:0x0172, (r15v41 java.lang.String)=B:98:0x0158, (r15v41 java.lang.String)=B:99:?, (r15v44 java.lang.String)=B:63:0x00de, (r15v44 java.lang.String)=B:64:?, (r15v44 java.lang.String)=B:66:0x00e5, (r15v44 java.lang.String)=B:67:?} A[DONT_GENERATE, DONT_INLINE]
  PHI: (r18v10 java.lang.String) = (r18v14 java.lang.String), (r18v14 java.lang.String), (r18v14 java.lang.String), (r18v14 java.lang.String), (r18v14 java.lang.String), (r18v14 java.lang.String), (r18v14 java.lang.String), (r18v14 java.lang.String), (r18v14 java.lang.String), (r18v14 java.lang.String), (r18v14 java.lang.String), (r18v14 java.lang.String), (r18v16 java.lang.String), (r18v16 java.lang.String), (r18v16 java.lang.String), (r18v16 java.lang.String) binds: {(r18v14 java.lang.String)=B:75:0x010d, (r18v14 java.lang.String)=B:76:?, (r18v14 java.lang.String)=B:77:0x0113, (r18v14 java.lang.String)=B:78:?, (r18v14 java.lang.String)=B:80:0x0122, (r18v14 java.lang.String)=B:81:?, (r18v14 java.lang.String)=B:91:0x0148, (r18v14 java.lang.String)=B:104:0x0169, (r18v14 java.lang.String)=B:105:?, (r18v14 java.lang.String)=B:108:0x0172, (r18v14 java.lang.String)=B:98:0x0158, (r18v14 java.lang.String)=B:99:?, (r18v16 java.lang.String)=B:63:0x00de, (r18v16 java.lang.String)=B:64:?, (r18v16 java.lang.String)=B:66:0x00e5, (r18v16 java.lang.String)=B:67:?} A[DONT_GENERATE, DONT_INLINE], Splitter:B:63:0x00de] */
    /* JADX WARNING: Removed duplicated region for block: B:134:0x01f5 A[ExcHandler: ClientProtocolException (e org.apache.http.client.ClientProtocolException), PHI: r15 r18 
  PHI: (r15v36 java.lang.String) = (r15v41 java.lang.String), (r15v41 java.lang.String), (r15v41 java.lang.String), (r15v41 java.lang.String), (r15v41 java.lang.String), (r15v41 java.lang.String), (r15v41 java.lang.String), (r15v41 java.lang.String), (r15v41 java.lang.String), (r15v41 java.lang.String), (r15v41 java.lang.String), (r15v41 java.lang.String), (r15v44 java.lang.String), (r15v44 java.lang.String), (r15v44 java.lang.String), (r15v44 java.lang.String) binds: {(r15v41 java.lang.String)=B:75:0x010d, (r15v41 java.lang.String)=B:76:?, (r15v41 java.lang.String)=B:77:0x0113, (r15v41 java.lang.String)=B:78:?, (r15v41 java.lang.String)=B:80:0x0122, (r15v41 java.lang.String)=B:81:?, (r15v41 java.lang.String)=B:91:0x0148, (r15v41 java.lang.String)=B:104:0x0169, (r15v41 java.lang.String)=B:105:?, (r15v41 java.lang.String)=B:108:0x0172, (r15v41 java.lang.String)=B:98:0x0158, (r15v41 java.lang.String)=B:99:?, (r15v44 java.lang.String)=B:63:0x00de, (r15v44 java.lang.String)=B:64:?, (r15v44 java.lang.String)=B:66:0x00e5, (r15v44 java.lang.String)=B:67:?} A[DONT_GENERATE, DONT_INLINE]
  PHI: (r18v9 java.lang.String) = (r18v14 java.lang.String), (r18v14 java.lang.String), (r18v14 java.lang.String), (r18v14 java.lang.String), (r18v14 java.lang.String), (r18v14 java.lang.String), (r18v14 java.lang.String), (r18v14 java.lang.String), (r18v14 java.lang.String), (r18v14 java.lang.String), (r18v14 java.lang.String), (r18v14 java.lang.String), (r18v16 java.lang.String), (r18v16 java.lang.String), (r18v16 java.lang.String), (r18v16 java.lang.String) binds: {(r18v14 java.lang.String)=B:75:0x010d, (r18v14 java.lang.String)=B:76:?, (r18v14 java.lang.String)=B:77:0x0113, (r18v14 java.lang.String)=B:78:?, (r18v14 java.lang.String)=B:80:0x0122, (r18v14 java.lang.String)=B:81:?, (r18v14 java.lang.String)=B:91:0x0148, (r18v14 java.lang.String)=B:104:0x0169, (r18v14 java.lang.String)=B:105:?, (r18v14 java.lang.String)=B:108:0x0172, (r18v14 java.lang.String)=B:98:0x0158, (r18v14 java.lang.String)=B:99:?, (r18v16 java.lang.String)=B:63:0x00de, (r18v16 java.lang.String)=B:64:?, (r18v16 java.lang.String)=B:66:0x00e5, (r18v16 java.lang.String)=B:67:?} A[DONT_GENERATE, DONT_INLINE], Splitter:B:63:0x00de] */
    /* JADX WARNING: Removed duplicated region for block: B:142:0x020a A[ExcHandler: Exception (e java.lang.Exception), Splitter:B:3:0x0020] */
    /* JADX WARNING: Removed duplicated region for block: B:144:0x020e A[ExcHandler: IOException (e java.io.IOException), Splitter:B:3:0x0020] */
    /* JADX WARNING: Removed duplicated region for block: B:146:0x0212 A[ExcHandler: SocketTimeoutException (e java.net.SocketTimeoutException), Splitter:B:3:0x0020] */
    /* JADX WARNING: Removed duplicated region for block: B:148:0x0217 A[ExcHandler: SocketException (e java.net.SocketException), Splitter:B:3:0x0020] */
    /* JADX WARNING: Removed duplicated region for block: B:150:0x021c A[ExcHandler: ClientProtocolException (e org.apache.http.client.ClientProtocolException), Splitter:B:3:0x0020] */
    /* JADX WARNING: Removed duplicated region for block: B:224:0x0338  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0056 A[ExcHandler: Exception (e java.lang.Exception), Splitter:B:16:0x0042] */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x005c A[ExcHandler: IOException (e java.io.IOException), Splitter:B:16:0x0042] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0062 A[ExcHandler: SocketTimeoutException (e java.net.SocketTimeoutException), Splitter:B:16:0x0042] */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0068 A[ExcHandler: SocketException (e java.net.SocketException), Splitter:B:16:0x0042] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x006e A[ExcHandler: ClientProtocolException (e org.apache.http.client.ClientProtocolException), Splitter:B:16:0x0042] */
    /* renamed from: a */
    public int mo38226a(java.lang.String r20, java.lang.String r21, boolean r22, discoveryAD.C7911ka.C7912a r23) {
        /*
        r19 = this;
        r1 = r19
        r0 = r21
        r2 = r23
        java.lang.String r3 = "key_downType"
        java.lang.String r4 = "key_sdcardstatus"
        java.lang.String r5 = "key_total"
        java.lang.String r6 = "key_downSize"
        java.lang.String r7 = "key_errorMsg"
        java.lang.String r8 = "key_errcode"
        java.lang.String r9 = "HttpBase"
        java.lang.String r10 = ""
        android.os.Bundle r11 = new android.os.Bundle
        r11.<init>()
        r13 = 0
        org.apache.http.client.HttpClient r12 = r19.mo38220ib()     // Catch:{ ClientProtocolException -> 0x02da, SocketException -> 0x02aa, SocketTimeoutException -> 0x0282, IOException -> 0x025a, Exception -> 0x022a, all -> 0x0221 }
        int r16 = r1.setUri(r0)     // Catch:{ ClientProtocolException -> 0x021c, SocketException -> 0x0217, SocketTimeoutException -> 0x0212, IOException -> 0x020e, Exception -> 0x020a, all -> 0x0204 }
        r17 = -3003(0xfffffffffffff445, float:NaN)
        if (r16 == 0) goto L_0x002b
        r17 = r16
        goto L_0x0047
    L_0x002b:
        boolean r14 = r1.mIsCanceled     // Catch:{ ClientProtocolException -> 0x021c, SocketException -> 0x0217, SocketTimeoutException -> 0x0212, IOException -> 0x020e, Exception -> 0x020a, all -> 0x01fc }
        if (r14 == 0) goto L_0x0036
        r15 = r3
        r18 = r4
    L_0x0032:
        r3 = -3003(0xfffffffffffff445, float:NaN)
        goto L_0x01a5
    L_0x0036:
        org.apache.http.client.methods.HttpGet r14 = r1.f26910ne     // Catch:{ ClientProtocolException -> 0x021c, SocketException -> 0x0217, SocketTimeoutException -> 0x0212, IOException -> 0x020e, Exception -> 0x020a, all -> 0x01fc }
        java.net.URI r14 = r14.getURI()     // Catch:{ ClientProtocolException -> 0x021c, SocketException -> 0x0217, SocketTimeoutException -> 0x0212, IOException -> 0x020e, Exception -> 0x020a, all -> 0x01fc }
        if (r14 != 0) goto L_0x0074
        r16 = -3053(0xfffffffffffff413, float:NaN)
        java.lang.String r0 = "url == null"
        com.tencent.p605ep.commonbase.api.Log.m31479e(r9, r0)     // Catch:{ ClientProtocolException -> 0x006e, SocketException -> 0x0068, SocketTimeoutException -> 0x0062, IOException -> 0x005c, Exception -> 0x0056, all -> 0x004e }
        r17 = -3053(0xfffffffffffff413, float:NaN)
    L_0x0047:
        r15 = r3
        r18 = r4
    L_0x004a:
        r3 = r17
        goto L_0x01a5
    L_0x004e:
        r0 = move-exception
        r15 = r3
        r18 = r4
        r14 = -3053(0xfffffffffffff413, float:NaN)
        goto L_0x00f5
    L_0x0056:
        r0 = move-exception
        r15 = r3
        r18 = r4
        goto L_0x01e6
    L_0x005c:
        r0 = move-exception
        r15 = r3
        r18 = r4
        goto L_0x00fa
    L_0x0062:
        r0 = move-exception
        r15 = r3
        r18 = r4
        goto L_0x00fe
    L_0x0068:
        r0 = move-exception
        r15 = r3
        r18 = r4
        goto L_0x0102
    L_0x006e:
        r0 = move-exception
        r15 = r3
        r18 = r4
        goto L_0x0106
    L_0x0074:
        boolean r14 = android.text.TextUtils.isEmpty(r20)     // Catch:{ ClientProtocolException -> 0x021c, SocketException -> 0x0217, SocketTimeoutException -> 0x0212, IOException -> 0x020e, Exception -> 0x020a, all -> 0x01fc }
        if (r14 != 0) goto L_0x007d
        r0 = r20
        goto L_0x0081
    L_0x007d:
        java.lang.String r0 = discoveryAD.C7906ia.guessFileName(r0, r13)     // Catch:{ ClientProtocolException -> 0x021c, SocketException -> 0x0217, SocketTimeoutException -> 0x0212, IOException -> 0x020e, Exception -> 0x020a, all -> 0x01fc }
    L_0x0081:
        java.lang.StringBuilder r13 = new java.lang.StringBuilder     // Catch:{ ClientProtocolException -> 0x021c, SocketException -> 0x0217, SocketTimeoutException -> 0x0212, IOException -> 0x020e, Exception -> 0x020a, all -> 0x01fc }
        r13.<init>()     // Catch:{ ClientProtocolException -> 0x021c, SocketException -> 0x0217, SocketTimeoutException -> 0x0212, IOException -> 0x020e, Exception -> 0x020a, all -> 0x01fc }
        r13.append(r0)     // Catch:{ ClientProtocolException -> 0x021c, SocketException -> 0x0217, SocketTimeoutException -> 0x0212, IOException -> 0x020e, Exception -> 0x020a, all -> 0x01fc }
        java.lang.String r14 = ".tmp"
        r13.append(r14)     // Catch:{ ClientProtocolException -> 0x021c, SocketException -> 0x0217, SocketTimeoutException -> 0x0212, IOException -> 0x020e, Exception -> 0x020a, all -> 0x01fc }
        java.lang.String r13 = r13.toString()     // Catch:{ ClientProtocolException -> 0x021c, SocketException -> 0x0217, SocketTimeoutException -> 0x0212, IOException -> 0x020e, Exception -> 0x020a, all -> 0x01fc }
        r1.mTempName = r13     // Catch:{ ClientProtocolException -> 0x021c, SocketException -> 0x0217, SocketTimeoutException -> 0x0212, IOException -> 0x020e, Exception -> 0x020a, all -> 0x01fc }
        java.lang.StringBuilder r13 = new java.lang.StringBuilder     // Catch:{ ClientProtocolException -> 0x021c, SocketException -> 0x0217, SocketTimeoutException -> 0x0212, IOException -> 0x020e, Exception -> 0x020a, all -> 0x01fc }
        r13.<init>()     // Catch:{ ClientProtocolException -> 0x021c, SocketException -> 0x0217, SocketTimeoutException -> 0x0212, IOException -> 0x020e, Exception -> 0x020a, all -> 0x01fc }
        java.lang.String r14 = "mTempName: "
        r13.append(r14)     // Catch:{ ClientProtocolException -> 0x021c, SocketException -> 0x0217, SocketTimeoutException -> 0x0212, IOException -> 0x020e, Exception -> 0x020a, all -> 0x01fc }
        java.lang.String r14 = r1.mTempName     // Catch:{ ClientProtocolException -> 0x021c, SocketException -> 0x0217, SocketTimeoutException -> 0x0212, IOException -> 0x020e, Exception -> 0x020a, all -> 0x01fc }
        r13.append(r14)     // Catch:{ ClientProtocolException -> 0x021c, SocketException -> 0x0217, SocketTimeoutException -> 0x0212, IOException -> 0x020e, Exception -> 0x020a, all -> 0x01fc }
        java.lang.String r13 = r13.toString()     // Catch:{ ClientProtocolException -> 0x021c, SocketException -> 0x0217, SocketTimeoutException -> 0x0212, IOException -> 0x020e, Exception -> 0x020a, all -> 0x01fc }
        com.tencent.p605ep.commonbase.api.Log.m31483i(r9, r13)     // Catch:{ ClientProtocolException -> 0x021c, SocketException -> 0x0217, SocketTimeoutException -> 0x0212, IOException -> 0x020e, Exception -> 0x020a, all -> 0x01fc }
        java.lang.String r13 = r1.mSaveName     // Catch:{ ClientProtocolException -> 0x021c, SocketException -> 0x0217, SocketTimeoutException -> 0x0212, IOException -> 0x020e, Exception -> 0x020a, all -> 0x01fc }
        if (r13 != 0) goto L_0x00b8
        r1.mSaveName = r0     // Catch:{ ClientProtocolException -> 0x006e, SocketException -> 0x0068, SocketTimeoutException -> 0x0062, IOException -> 0x005c, Exception -> 0x0056, all -> 0x00b1 }
        goto L_0x00b8
    L_0x00b1:
        r0 = move-exception
        r15 = r3
        r18 = r4
    L_0x00b5:
        r14 = r16
        goto L_0x00f5
    L_0x00b8:
        java.io.File r0 = new java.io.File     // Catch:{ ClientProtocolException -> 0x021c, SocketException -> 0x0217, SocketTimeoutException -> 0x0212, IOException -> 0x020e, Exception -> 0x020a, all -> 0x01fc }
        java.lang.String r13 = r1.mTempPath     // Catch:{ ClientProtocolException -> 0x021c, SocketException -> 0x0217, SocketTimeoutException -> 0x0212, IOException -> 0x020e, Exception -> 0x020a, all -> 0x01fc }
        java.lang.String r14 = r1.mTempName     // Catch:{ ClientProtocolException -> 0x021c, SocketException -> 0x0217, SocketTimeoutException -> 0x0212, IOException -> 0x020e, Exception -> 0x020a, all -> 0x01fc }
        r0.<init>(r13, r14)     // Catch:{ ClientProtocolException -> 0x021c, SocketException -> 0x0217, SocketTimeoutException -> 0x0212, IOException -> 0x020e, Exception -> 0x020a, all -> 0x01fc }
        boolean r13 = r0.exists()     // Catch:{ ClientProtocolException -> 0x021c, SocketException -> 0x0217, SocketTimeoutException -> 0x0212, IOException -> 0x020e, Exception -> 0x020a, all -> 0x01fc }
        if (r13 == 0) goto L_0x010a
        long r13 = r0.length()     // Catch:{ ClientProtocolException -> 0x006e, SocketException -> 0x0068, SocketTimeoutException -> 0x0062, IOException -> 0x005c, Exception -> 0x0056, all -> 0x00b1 }
        r1.mCompletedSize = r13     // Catch:{ ClientProtocolException -> 0x006e, SocketException -> 0x0068, SocketTimeoutException -> 0x0062, IOException -> 0x005c, Exception -> 0x0056, all -> 0x00b1 }
        org.apache.http.client.methods.HttpGet r0 = r1.f26910ne     // Catch:{ ClientProtocolException -> 0x006e, SocketException -> 0x0068, SocketTimeoutException -> 0x0062, IOException -> 0x005c, Exception -> 0x0056, all -> 0x00b1 }
        java.lang.String r13 = "RANGE"
        java.lang.StringBuilder r14 = new java.lang.StringBuilder     // Catch:{ ClientProtocolException -> 0x006e, SocketException -> 0x0068, SocketTimeoutException -> 0x0062, IOException -> 0x005c, Exception -> 0x0056, all -> 0x00b1 }
        r14.<init>()     // Catch:{ ClientProtocolException -> 0x006e, SocketException -> 0x0068, SocketTimeoutException -> 0x0062, IOException -> 0x005c, Exception -> 0x0056, all -> 0x00b1 }
        java.lang.String r15 = "bytes="
        r14.append(r15)     // Catch:{ ClientProtocolException -> 0x006e, SocketException -> 0x0068, SocketTimeoutException -> 0x0062, IOException -> 0x005c, Exception -> 0x0056, all -> 0x00b1 }
        r15 = r3
        r18 = r4
        long r3 = r1.mCompletedSize     // Catch:{ ClientProtocolException -> 0x01f5, SocketException -> 0x01f2, SocketTimeoutException -> 0x01ef, IOException -> 0x01ec, Exception -> 0x01e5, all -> 0x00f3 }
        r14.append(r3)     // Catch:{ ClientProtocolException -> 0x01f5, SocketException -> 0x01f2, SocketTimeoutException -> 0x01ef, IOException -> 0x01ec, Exception -> 0x01e5, all -> 0x00f3 }
        java.lang.String r3 = "-"
        r14.append(r3)     // Catch:{ ClientProtocolException -> 0x01f5, SocketException -> 0x01f2, SocketTimeoutException -> 0x01ef, IOException -> 0x01ec, Exception -> 0x01e5, all -> 0x00f3 }
        java.lang.String r3 = r14.toString()     // Catch:{ ClientProtocolException -> 0x01f5, SocketException -> 0x01f2, SocketTimeoutException -> 0x01ef, IOException -> 0x01ec, Exception -> 0x01e5, all -> 0x00f3 }
        r0.setHeader(r13, r3)     // Catch:{ ClientProtocolException -> 0x01f5, SocketException -> 0x01f2, SocketTimeoutException -> 0x01ef, IOException -> 0x01ec, Exception -> 0x01e5, all -> 0x00f3 }
        r3 = 1
        r1.isContinue = r3     // Catch:{ ClientProtocolException -> 0x01f5, SocketException -> 0x01f2, SocketTimeoutException -> 0x01ef, IOException -> 0x01ec, Exception -> 0x01e5, all -> 0x00f3 }
        goto L_0x010d
    L_0x00f3:
        r0 = move-exception
        goto L_0x00b5
    L_0x00f5:
        r4 = r15
        r2 = r18
        goto L_0x0336
    L_0x00fa:
        r2 = r18
        goto L_0x025e
    L_0x00fe:
        r2 = r18
        goto L_0x0286
    L_0x0102:
        r2 = r18
        goto L_0x02ae
    L_0x0106:
        r2 = r18
        goto L_0x02de
    L_0x010a:
        r15 = r3
        r18 = r4
    L_0x010d:
        org.apache.http.client.methods.HttpGet r0 = r1.f26910ne     // Catch:{ ClientProtocolException -> 0x01f5, SocketException -> 0x01f2, SocketTimeoutException -> 0x01ef, IOException -> 0x01ec, Exception -> 0x01e5, all -> 0x01f8 }
        org.apache.http.HttpResponse r0 = r12.execute(r0)     // Catch:{ ClientProtocolException -> 0x01f5, SocketException -> 0x01f2, SocketTimeoutException -> 0x01ef, IOException -> 0x01ec, Exception -> 0x01e5, all -> 0x01f8 }
        org.apache.http.StatusLine r3 = r0.getStatusLine()     // Catch:{ ClientProtocolException -> 0x01f5, SocketException -> 0x01f2, SocketTimeoutException -> 0x01ef, IOException -> 0x01ec, Exception -> 0x01e5, all -> 0x01df }
        int r3 = r3.getStatusCode()     // Catch:{ ClientProtocolException -> 0x01f5, SocketException -> 0x01f2, SocketTimeoutException -> 0x01ef, IOException -> 0x01ec, Exception -> 0x01e5, all -> 0x01df }
        java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ ClientProtocolException -> 0x01f5, SocketException -> 0x01f2, SocketTimeoutException -> 0x01ef, IOException -> 0x01ec, Exception -> 0x01e5, all -> 0x01df }
        r4.<init>()     // Catch:{ ClientProtocolException -> 0x01f5, SocketException -> 0x01f2, SocketTimeoutException -> 0x01ef, IOException -> 0x01ec, Exception -> 0x01e5, all -> 0x01df }
        java.lang.String r13 = "statusCode == "
        r4.append(r13)     // Catch:{ ClientProtocolException -> 0x01f5, SocketException -> 0x01f2, SocketTimeoutException -> 0x01ef, IOException -> 0x01ec, Exception -> 0x01e5, all -> 0x01df }
        r4.append(r3)     // Catch:{ ClientProtocolException -> 0x01f5, SocketException -> 0x01f2, SocketTimeoutException -> 0x01ef, IOException -> 0x01ec, Exception -> 0x01e5, all -> 0x01df }
        java.lang.String r4 = r4.toString()     // Catch:{ ClientProtocolException -> 0x01f5, SocketException -> 0x01f2, SocketTimeoutException -> 0x01ef, IOException -> 0x01ec, Exception -> 0x01e5, all -> 0x01df }
        com.tencent.p605ep.commonbase.api.Log.m31483i(r9, r4)     // Catch:{ ClientProtocolException -> 0x01f5, SocketException -> 0x01f2, SocketTimeoutException -> 0x01ef, IOException -> 0x01ec, Exception -> 0x01e5, all -> 0x01df }
        r4 = 200(0xc8, float:2.8E-43)
        if (r3 == r4) goto L_0x0146
        r4 = 206(0xce, float:2.89E-43)
        if (r3 == r4) goto L_0x0146
        r14 = -3000(0xfffffffffffff448, float:NaN)
        int r4 = -3000 - r3
        r13 = 416(0x1a0, float:5.83E-43)
        if (r3 == r13) goto L_0x0143
        r17 = r4
        goto L_0x004a
    L_0x0143:
        r16 = r4
        goto L_0x0148
    L_0x0146:
        r14 = -3000(0xfffffffffffff448, float:NaN)
    L_0x0148:
        boolean r3 = r1.mIsCanceled     // Catch:{ ClientProtocolException -> 0x01f5, SocketException -> 0x01f2, SocketTimeoutException -> 0x01ef, IOException -> 0x01ec, Exception -> 0x01da, all -> 0x01df }
        if (r3 == 0) goto L_0x014e
        goto L_0x0032
    L_0x014e:
        org.apache.http.HttpEntity r0 = r0.getEntity()     // Catch:{ ClientProtocolException -> 0x01f5, SocketException -> 0x01f2, SocketTimeoutException -> 0x01ef, IOException -> 0x01ec, Exception -> 0x01da, all -> 0x01df }
        if (r0 != 0) goto L_0x0167
        r2 = -4000(0xfffffffffffff060, float:NaN)
        java.lang.String r0 = "httpEntity == null"
        com.tencent.p605ep.commonbase.api.Log.m31479e(r9, r0)     // Catch:{ ClientProtocolException -> 0x01f5, SocketException -> 0x01f2, SocketTimeoutException -> 0x01ef, IOException -> 0x01ec, Exception -> 0x01da, all -> 0x015f }
        r17 = -4000(0xfffffffffffff060, float:NaN)
        goto L_0x004a
    L_0x015f:
        r0 = move-exception
        r4 = r15
        r2 = r18
        r14 = -4000(0xfffffffffffff060, float:NaN)
        goto L_0x0336
    L_0x0167:
        r3 = r22
        int r3 = r1.m34325a(r0, r11, r3)     // Catch:{ ClientProtocolException -> 0x01f5, SocketException -> 0x01f2, SocketTimeoutException -> 0x01ef, IOException -> 0x01ec, Exception -> 0x01da, all -> 0x01df }
        if (r3 == 0) goto L_0x0170
        goto L_0x01a5
    L_0x0170:
        if (r2 == 0) goto L_0x0199
        java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ ClientProtocolException -> 0x01f5, SocketException -> 0x01f2, SocketTimeoutException -> 0x01ef, IOException -> 0x01ec, Exception -> 0x01da, all -> 0x0195 }
        r0.<init>()     // Catch:{ ClientProtocolException -> 0x01f5, SocketException -> 0x01f2, SocketTimeoutException -> 0x01ef, IOException -> 0x01ec, Exception -> 0x01da, all -> 0x0195 }
        java.lang.String r4 = r1.mTempPath     // Catch:{ ClientProtocolException -> 0x01f5, SocketException -> 0x01f2, SocketTimeoutException -> 0x01ef, IOException -> 0x01ec, Exception -> 0x01da, all -> 0x0195 }
        r0.append(r4)     // Catch:{ ClientProtocolException -> 0x01f5, SocketException -> 0x01f2, SocketTimeoutException -> 0x01ef, IOException -> 0x01ec, Exception -> 0x01da, all -> 0x0195 }
        java.lang.String r4 = java.io.File.separator     // Catch:{ ClientProtocolException -> 0x01f5, SocketException -> 0x01f2, SocketTimeoutException -> 0x01ef, IOException -> 0x01ec, Exception -> 0x01da, all -> 0x0195 }
        r0.append(r4)     // Catch:{ ClientProtocolException -> 0x01f5, SocketException -> 0x01f2, SocketTimeoutException -> 0x01ef, IOException -> 0x01ec, Exception -> 0x01da, all -> 0x0195 }
        java.lang.String r4 = r1.mTempName     // Catch:{ ClientProtocolException -> 0x01f5, SocketException -> 0x01f2, SocketTimeoutException -> 0x01ef, IOException -> 0x01ec, Exception -> 0x01da, all -> 0x0195 }
        r0.append(r4)     // Catch:{ ClientProtocolException -> 0x01f5, SocketException -> 0x01f2, SocketTimeoutException -> 0x01ef, IOException -> 0x01ec, Exception -> 0x01da, all -> 0x0195 }
        java.lang.String r0 = r0.toString()     // Catch:{ ClientProtocolException -> 0x01f5, SocketException -> 0x01f2, SocketTimeoutException -> 0x01ef, IOException -> 0x01ec, Exception -> 0x01da, all -> 0x0195 }
        boolean r0 = r2.isMatch(r0)     // Catch:{ ClientProtocolException -> 0x01f5, SocketException -> 0x01f2, SocketTimeoutException -> 0x01ef, IOException -> 0x01ec, Exception -> 0x01da, all -> 0x0195 }
        if (r0 != 0) goto L_0x0199
        r17 = -7000(0xffffffffffffe4a8, float:NaN)
        r3 = -7000(0xffffffffffffe4a8, float:NaN)
        goto L_0x01a5
    L_0x0195:
        r0 = move-exception
        r2 = r18
        goto L_0x01d7
    L_0x0199:
        r2 = 1
        int r17 = r1.copyTempFile(r2)     // Catch:{ ClientProtocolException -> 0x01f5, SocketException -> 0x01f2, SocketTimeoutException -> 0x01ef, IOException -> 0x01ec, Exception -> 0x01da, all -> 0x0195 }
        if (r17 == 0) goto L_0x01a2
        goto L_0x004a
    L_0x01a2:
        r17 = 0
        r3 = 0
    L_0x01a5:
        if (r12 == 0) goto L_0x01ae
        org.apache.http.conn.ClientConnectionManager r0 = r12.getConnectionManager()
        r0.shutdown()
    L_0x01ae:
        if (r3 == 0) goto L_0x032d
        r2 = -7
        if (r3 == r2) goto L_0x032d
        r11.putInt(r8, r3)
        r11.putString(r7, r10)
        long r7 = r1.mCompletedSize
        int r0 = (int) r7
        r11.putInt(r6, r0)
        long r6 = r1.mTotalSize
        int r0 = (int) r6
        r11.putInt(r5, r0)
        long r4 = r1.mTotalSize
        long r6 = r1.mCompletedSize
        long r4 = r4 - r6
        int r0 = discoveryAD.C7906ia.getSdcardStatus(r4)
        r2 = r18
        r11.putInt(r2, r0)
        boolean r0 = r1.isContinue
        goto L_0x0324
    L_0x01d7:
        r14 = r3
        goto L_0x0227
    L_0x01da:
        r0 = move-exception
        r2 = r18
        goto L_0x0230
    L_0x01df:
        r0 = move-exception
        r2 = r18
        r14 = r16
        goto L_0x0227
    L_0x01e5:
        r0 = move-exception
    L_0x01e6:
        r2 = r18
    L_0x01e8:
        r14 = -3000(0xfffffffffffff448, float:NaN)
        goto L_0x0230
    L_0x01ec:
        r0 = move-exception
        goto L_0x00fa
    L_0x01ef:
        r0 = move-exception
        goto L_0x00fe
    L_0x01f2:
        r0 = move-exception
        goto L_0x0102
    L_0x01f5:
        r0 = move-exception
        goto L_0x0106
    L_0x01f8:
        r0 = move-exception
        r2 = r18
        goto L_0x01ff
    L_0x01fc:
        r0 = move-exception
        r15 = r3
        r2 = r4
    L_0x01ff:
        r4 = r15
        r14 = r16
        goto L_0x0336
    L_0x0204:
        r0 = move-exception
        r15 = r3
        r2 = r4
        r14 = -3000(0xfffffffffffff448, float:NaN)
        goto L_0x0227
    L_0x020a:
        r0 = move-exception
        r15 = r3
        r2 = r4
        goto L_0x01e8
    L_0x020e:
        r0 = move-exception
        r15 = r3
        r2 = r4
        goto L_0x025e
    L_0x0212:
        r0 = move-exception
        r15 = r3
        r2 = r4
        goto L_0x0286
    L_0x0217:
        r0 = move-exception
        r15 = r3
        r2 = r4
        goto L_0x02ae
    L_0x021c:
        r0 = move-exception
        r15 = r3
        r2 = r4
        goto L_0x02de
    L_0x0221:
        r0 = move-exception
        r15 = r3
        r2 = r4
        r14 = -3000(0xfffffffffffff448, float:NaN)
        r12 = r13
    L_0x0227:
        r4 = r15
        goto L_0x0336
    L_0x022a:
        r0 = move-exception
        r15 = r3
        r2 = r4
        r14 = -3000(0xfffffffffffff448, float:NaN)
        r12 = r13
    L_0x0230:
        java.lang.String r3 = r0.getMessage()     // Catch:{ all -> 0x02d6 }
        java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x02d3 }
        r4.<init>()     // Catch:{ all -> 0x02d3 }
        java.lang.String r10 = "get error:"
        r4.append(r10)     // Catch:{ all -> 0x02d3 }
        java.lang.String r10 = r0.getMessage()     // Catch:{ all -> 0x02d3 }
        r4.append(r10)     // Catch:{ all -> 0x02d3 }
        java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x02d3 }
        com.tencent.p605ep.commonbase.api.Log.m31479e(r9, r4)     // Catch:{ all -> 0x02d3 }
        r0.printStackTrace()     // Catch:{ all -> 0x02d3 }
        if (r12 == 0) goto L_0x0303
    L_0x0251:
        org.apache.http.conn.ClientConnectionManager r0 = r12.getConnectionManager()
        r0.shutdown()
        goto L_0x0303
    L_0x025a:
        r0 = move-exception
        r15 = r3
        r2 = r4
        r12 = r13
    L_0x025e:
        r14 = -3056(0xfffffffffffff410, float:NaN)
        java.lang.String r3 = r0.getMessage()     // Catch:{ all -> 0x02d6 }
        java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x02d3 }
        r4.<init>()     // Catch:{ all -> 0x02d3 }
        java.lang.String r10 = "io error:"
        r4.append(r10)     // Catch:{ all -> 0x02d3 }
        java.lang.String r10 = r0.getMessage()     // Catch:{ all -> 0x02d3 }
        r4.append(r10)     // Catch:{ all -> 0x02d3 }
        java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x02d3 }
        com.tencent.p605ep.commonbase.api.Log.m31479e(r9, r4)     // Catch:{ all -> 0x02d3 }
        r0.printStackTrace()     // Catch:{ all -> 0x02d3 }
        if (r12 == 0) goto L_0x0303
        goto L_0x0251
    L_0x0282:
        r0 = move-exception
        r15 = r3
        r2 = r4
        r12 = r13
    L_0x0286:
        r14 = -3055(0xfffffffffffff411, float:NaN)
        java.lang.String r3 = r0.getMessage()     // Catch:{ all -> 0x02d6 }
        java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x02d3 }
        r4.<init>()     // Catch:{ all -> 0x02d3 }
        java.lang.String r10 = "socket timeout error:"
        r4.append(r10)     // Catch:{ all -> 0x02d3 }
        java.lang.String r10 = r0.getMessage()     // Catch:{ all -> 0x02d3 }
        r4.append(r10)     // Catch:{ all -> 0x02d3 }
        java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x02d3 }
        com.tencent.p605ep.commonbase.api.Log.m31479e(r9, r4)     // Catch:{ all -> 0x02d3 }
        r0.printStackTrace()     // Catch:{ all -> 0x02d3 }
        if (r12 == 0) goto L_0x0303
        goto L_0x0251
    L_0x02aa:
        r0 = move-exception
        r15 = r3
        r2 = r4
        r12 = r13
    L_0x02ae:
        r14 = -3054(0xfffffffffffff412, float:NaN)
        java.lang.String r3 = r0.getMessage()     // Catch:{ all -> 0x02d6 }
        java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x02d3 }
        r4.<init>()     // Catch:{ all -> 0x02d3 }
        java.lang.String r10 = "socket error:"
        r4.append(r10)     // Catch:{ all -> 0x02d3 }
        java.lang.String r10 = r0.getMessage()     // Catch:{ all -> 0x02d3 }
        r4.append(r10)     // Catch:{ all -> 0x02d3 }
        java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x02d3 }
        com.tencent.p605ep.commonbase.api.Log.m31479e(r9, r4)     // Catch:{ all -> 0x02d3 }
        r0.printStackTrace()     // Catch:{ all -> 0x02d3 }
        if (r12 == 0) goto L_0x0303
        goto L_0x0251
    L_0x02d3:
        r0 = move-exception
        r10 = r3
        goto L_0x02d7
    L_0x02d6:
        r0 = move-exception
    L_0x02d7:
        r13 = r12
        r4 = r15
        goto L_0x0335
    L_0x02da:
        r0 = move-exception
        r15 = r3
        r2 = r4
        r12 = r13
    L_0x02de:
        r14 = -3051(0xfffffffffffff415, float:NaN)
        java.lang.String r3 = r0.getMessage()     // Catch:{ all -> 0x0332 }
        java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x032e }
        r4.<init>()     // Catch:{ all -> 0x032e }
        java.lang.String r10 = "protocol error:"
        r4.append(r10)     // Catch:{ all -> 0x032e }
        java.lang.String r10 = r0.getMessage()     // Catch:{ all -> 0x032e }
        r4.append(r10)     // Catch:{ all -> 0x032e }
        java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x032e }
        com.tencent.p605ep.commonbase.api.Log.m31479e(r9, r4)     // Catch:{ all -> 0x032e }
        r0.printStackTrace()     // Catch:{ all -> 0x032e }
        if (r12 == 0) goto L_0x0303
        goto L_0x0251
    L_0x0303:
        r11.putInt(r8, r14)
        r11.putString(r7, r3)
        long r3 = r1.mCompletedSize
        int r0 = (int) r3
        r11.putInt(r6, r0)
        long r3 = r1.mTotalSize
        int r0 = (int) r3
        r11.putInt(r5, r0)
        long r3 = r1.mTotalSize
        long r5 = r1.mCompletedSize
        long r3 = r3 - r5
        int r0 = discoveryAD.C7906ia.getSdcardStatus(r3)
        r11.putInt(r2, r0)
        boolean r0 = r1.isContinue
        r3 = r14
    L_0x0324:
        byte r0 = (byte) r0
        r4 = r15
        r11.putByte(r4, r0)
        r2 = 1
        r1.doCallback(r2, r11)
    L_0x032d:
        return r3
    L_0x032e:
        r0 = move-exception
        r4 = r15
        r10 = r3
        goto L_0x0334
    L_0x0332:
        r0 = move-exception
        r4 = r15
    L_0x0334:
        r13 = r12
    L_0x0335:
        r12 = r13
    L_0x0336:
        if (r12 == 0) goto L_0x033f
        org.apache.http.conn.ClientConnectionManager r3 = r12.getConnectionManager()
        r3.shutdown()
    L_0x033f:
        if (r14 == 0) goto L_0x036c
        r3 = -7
        if (r14 == r3) goto L_0x036c
        r11.putInt(r8, r14)
        r11.putString(r7, r10)
        long r7 = r1.mCompletedSize
        int r3 = (int) r7
        r11.putInt(r6, r3)
        long r6 = r1.mTotalSize
        int r3 = (int) r6
        r11.putInt(r5, r3)
        long r5 = r1.mTotalSize
        long r7 = r1.mCompletedSize
        long r5 = r5 - r7
        int r3 = discoveryAD.C7906ia.getSdcardStatus(r5)
        r11.putInt(r2, r3)
        boolean r2 = r1.isContinue
        byte r2 = (byte) r2
        r11.putByte(r4, r2)
        r2 = 1
        r1.doCallback(r2, r11)
    L_0x036c:
        throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: discoveryAD.C7911ka.mo38226a(java.lang.String, java.lang.String, boolean, discoveryAD.ka$a):int");
    }

    public synchronized void cancelGet() {
        this.mIsCanceled = true;
    }

    public String getAbsoluteDownFileName() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.mSavePath);
        sb.append(File.separator);
        sb.append(this.mSaveName);
        return sb.toString();
    }

    public String getFullPathSaveName() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.mSavePath);
        sb.append(File.separator);
        sb.append(this.mSaveName);
        return sb.toString();
    }

    public synchronized boolean isCanceled() {
        return this.mIsCanceled;
    }

    public void setFileMode(int i) {
        this.mFileMode = i;
    }

    public void setSaveName(String str) {
        this.mSaveName = str;
    }

    public void setSavePath(String str) {
        this.mSavePath = str;
    }
}
