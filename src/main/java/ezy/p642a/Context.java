package ezy.p642a;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.res.Resources;
import android.os.Process;
import android.util.TypedValue;
import android.widget.Toast;
import com.tencent.android.tpush.common.Constants;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.C8271i;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u00000\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0004\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004\u001a\n\u0010\u0005\u001a\u00020\u0006*\u00020\u0002\u001a\u0012\u0010\u0007\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\b\u001a\u00020\u0004\u001a\u0012\u0010\t\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\b\u001a\u00020\u0004\u001a\f\u0010\n\u001a\u0004\u0018\u00010\u000b*\u00020\u0002\u001a\u0012\u0010\f\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\r\u001a\u00020\u0004\u001a&\u0010\u000e\u001a\u00020\u000f*\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00012\b\b\u0002\u0010\u0013\u001a\u00020\u0001\u001a&\u0010\u000e\u001a\u00020\u000f*\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u00012\b\b\u0002\u0010\u0012\u001a\u00020\u00012\b\b\u0002\u0010\u0013\u001a\u00020\u0001¨\u0006\u0015"}, mo39189d2 = {"dp2px", "", "Landroid/content/Context;", "dp", "", "isInMainProcess", "", "px2dp", "px", "px2sp", "resolveCurrentProcessName", "", "sp2px", "sp", "toast", "", "text", "", "duration", "gravity", "resId", "lib.common_release"}, mo39190k = 2, mo39191mv = {1, 1, 15})
/* renamed from: ezy.a.b */
public final class Context {
    /* renamed from: a */
    public static /* synthetic */ void m34744a(android.content.Context context, CharSequence charSequence, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = 17;
        }
        m34743a(context, charSequence, i, i2);
    }

    /* renamed from: a */
    public static final void m34743a(android.content.Context context, CharSequence charSequence, int i, int i2) {
        C8271i.m35386b(context, "$this$toast");
        C8271i.m35386b(charSequence, "text");
        Toast makeText = Toast.makeText(context, charSequence, i);
        makeText.setGravity(i2, 0, 0);
        makeText.show();
    }

    /* renamed from: a */
    public static final int m34741a(android.content.Context context, float f) {
        C8271i.m35386b(context, "$this$dp2px");
        Resources resources = context.getResources();
        C8271i.m35382a((Object) resources, "resources");
        return (int) TypedValue.applyDimension(1, f, resources.getDisplayMetrics());
    }

    /* renamed from: b */
    public static final int m34745b(android.content.Context context, float f) {
        C8271i.m35386b(context, "$this$sp2px");
        Resources resources = context.getResources();
        C8271i.m35382a((Object) resources, "resources");
        return (int) TypedValue.applyDimension(2, f, resources.getDisplayMetrics());
    }

    /* renamed from: a */
    public static final String m34742a(android.content.Context context) {
        C8271i.m35386b(context, "$this$resolveCurrentProcessName");
        int myPid = Process.myPid();
        Object systemService = context.getSystemService(Constants.FLAG_ACTIVITY_NAME);
        if (systemService != null) {
            for (RunningAppProcessInfo runningAppProcessInfo : ((ActivityManager) systemService).getRunningAppProcesses()) {
                if (runningAppProcessInfo.pid == myPid) {
                    return runningAppProcessInfo.processName;
                }
            }
            return null;
        }
        throw new TypeCastException("null cannot be cast to non-null type android.app.ActivityManager");
    }

    /* renamed from: b */
    public static final boolean m34746b(android.content.Context context) {
        C8271i.m35386b(context, "$this$isInMainProcess");
        android.content.Context applicationContext = context.getApplicationContext();
        C8271i.m35382a((Object) applicationContext, "applicationContext");
        return C8271i.m35384a((Object) applicationContext.getPackageName(), (Object) m34742a(context));
    }
}
