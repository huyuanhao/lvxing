package com.tencent.mta.track;

import android.app.Application;
import android.content.Context;
import android.net.Uri;
import android.os.HandlerThread;
import android.os.Message;
import android.util.Log;
import java.util.HashSet;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: ProGuard */
/* renamed from: com.tencent.mta.track.aj */
public class C7350aj implements C7349ai, C7376g {
    /* access modifiers changed from: private|static */
    /* renamed from: a */
    public static boolean f24877a = true;
    /* renamed from: b */
    private static int f24878b;
    /* access modifiers changed from: private|final */
    /* renamed from: c */
    public final Context f24879c;
    /* access modifiers changed from: private|final */
    /* renamed from: d */
    public final C7354an f24880d;
    /* access modifiers changed from: private|final */
    /* renamed from: e */
    public final C7378i f24881e;
    /* access modifiers changed from: private|final */
    /* renamed from: f */
    public final C7383n f24882f;
    /* access modifiers changed from: private|final */
    /* renamed from: g */
    public final C7355ao f24883g;
    /* access modifiers changed from: private */
    /* renamed from: h */
    public String f24884h = null;
    /* access modifiers changed from: private|final */
    /* renamed from: i */
    public final HashSet f24885i = new HashSet();
    /* access modifiers changed from: private|final */
    /* renamed from: j */
    public final HashSet f24886j = new HashSet();

    public C7350aj(Context context, String str) {
        this.f24879c = context;
        this.f24882f = new C7383n();
        this.f24880d = new C7354an(this);
        ((Application) context.getApplicationContext()).registerActivityLifecycleCallbacks(this.f24880d);
        HandlerThread handlerThread = new HandlerThread(C7350aj.class.getCanonicalName(), 10);
        handlerThread.start();
        this.f24883g = new C7355ao(this, context, handlerThread.getLooper(), str);
        this.f24881e = new C7378i(context, this.f24883g);
    }

    /* renamed from: a */
    public void mo35856a() {
        this.f24883g.mo35882a();
        C7355ao aoVar = this.f24883g;
        aoVar.sendMessage(aoVar.obtainMessage(0));
    }

    /* renamed from: b */
    public void mo35860b() {
        this.f24880d.mo35873a();
    }

    /* renamed from: b */
    public void mo35861b(String str) {
        this.f24886j.add(str);
    }

    /* renamed from: a */
    public void mo35858a(JSONArray jSONArray) {
        Message obtainMessage = this.f24883g.obtainMessage(5);
        obtainMessage.obj = jSONArray;
        this.f24883g.sendMessage(obtainMessage);
    }

    /* renamed from: a */
    public void mo35857a(String str) {
        String str2 = "ViewCrawler";
        if (this.f24884h == null && str != null && str.length() > 0) {
            this.f24884h = str;
            if (StatisticsDataAPI.f24839a.booleanValue()) {
                StringBuilder sb = new StringBuilder();
                sb.append("Gets VTrack server URL '");
                sb.append(this.f24884h);
                sb.append("' from configure.");
                Log.i(str2, sb.toString());
            }
        }
        if (this.f24884h == null) {
            this.f24884h = Uri.parse(StatisticsDataAPI.sharedInstance(this.f24879c).mo35812c()).buildUpon().path("/api/ws").scheme("ws").build().toString();
            if (StatisticsDataAPI.f24839a.booleanValue()) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Generates VTrack server URL '");
                sb2.append(this.f24884h);
                sb2.append("' with configure URL.");
                Log.i(str2, sb2.toString());
            }
        }
        if (this.f24884h == null) {
            Log.w(str2, "Unknown VTrack server URL.");
        }
    }

    /* renamed from: a */
    public void mo35859a(JSONObject jSONObject) {
        Message obtainMessage = this.f24883g.obtainMessage();
        obtainMessage.what = 7;
        obtainMessage.obj = jSONObject;
        this.f24883g.sendMessage(obtainMessage);
    }
}
