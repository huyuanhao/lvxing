package com.bytedance.embedapplog.p142b;

import android.content.Context;
import android.util.DisplayMetrics;
import com.tencent.p605ep.commonbase.network.HttpStatus;
import com.tencent.p605ep.commonbase.utils.ScreenUtil;
import epco.C7990p;
import org.json.JSONObject;

/* renamed from: com.bytedance.embedapplog.b.j */
class C1823j extends C1816c {
    /* renamed from: e */
    private final Context f5119e;

    C1823j(Context context) {
        super(true, false);
        this.f5119e = context;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public boolean mo13364a(JSONObject jSONObject) {
        String str;
        DisplayMetrics displayMetrics = this.f5119e.getResources().getDisplayMetrics();
        int i = displayMetrics.densityDpi;
        switch (i) {
            case 120:
                str = "ldpi";
                break;
            case ScreenUtil.G8_WIDTH /*240*/:
                str = "hdpi";
                break;
            case C7990p.f27145j /*260*/:
            case 280:
            case 300:
            case 320:
                str = "xhdpi";
                break;
            case 340:
            case 360:
            case 400:
            case HttpStatus.SC_METHOD_FAILURE /*420*/:
            case 440:
            case 480:
                str = "xxhdpi";
                break;
            case 560:
            case ScreenUtil.M9_WIDTH /*640*/:
                str = "xxxhdpi";
                break;
            default:
                str = "mdpi";
                break;
        }
        jSONObject.put("density_dpi", i);
        jSONObject.put("display_density", str);
        StringBuilder sb = new StringBuilder();
        sb.append(displayMetrics.heightPixels);
        sb.append("x");
        sb.append(displayMetrics.widthPixels);
        jSONObject.put("resolution", sb.toString());
        return true;
    }
}
