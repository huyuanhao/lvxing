package com.tencent.mta.track;

import android.content.Context;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import com.tencent.mta.track.exceptions.InvalidDataException;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: ProGuard */
/* renamed from: com.tencent.mta.track.i */
class C7378i implements C7370bc {
    /* renamed from: e */
    private static String f24956e = "DynamicEventTracker";
    /* access modifiers changed from: private|final */
    /* renamed from: a */
    public final Context f24957a;
    /* access modifiers changed from: private|final */
    /* renamed from: b */
    public final Handler f24958b;
    /* renamed from: c */
    private final Runnable f24959c = new C7380k(this);
    /* access modifiers changed from: private|final */
    /* renamed from: d */
    public final Map f24960d = new HashMap();

    public C7378i(Context context, Handler handler) {
        this.f24957a = context;
        this.f24958b = handler;
    }

    /* renamed from: a */
    public void mo35908a(View view, C7461u uVar, boolean z) {
        long currentTimeMillis = System.currentTimeMillis();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("from_vtrack", String.valueOf(uVar.f25001d));
            jSONObject.put("binding_trigger_id", uVar.f25001d);
            jSONObject.put("binding_event_id", uVar.f25003f);
            jSONObject.put("binding_reation", uVar.f25004g);
            jSONObject.put("binding_path", uVar.f25000c);
            jSONObject.put("binding_depolyed", uVar.f25002e);
        } catch (JSONException e) {
            Log.e(f24956e, "Can't format properties from view due to JSON issue", e);
        }
        if (z) {
            C7381l lVar = new C7381l(view, uVar);
            C7382m mVar = new C7382m(uVar, jSONObject, currentTimeMillis);
            synchronized (this.f24960d) {
                boolean isEmpty = this.f24960d.isEmpty();
                this.f24960d.put(lVar, mVar);
                if (isEmpty) {
                    this.f24958b.postDelayed(this.f24959c, 3000);
                }
            }
            return;
        }
        try {
            StatisticsDataAPI.sharedInstance(this.f24957a).track(uVar.f24999b, jSONObject);
        } catch (InvalidDataException e2) {
            Log.w("Unexpected exception", e2);
        }
    }
}
