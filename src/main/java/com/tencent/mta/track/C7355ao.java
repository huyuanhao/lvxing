package com.tencent.mta.track;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.JsonWriter;
import android.util.Log;
import android.util.Pair;
import androidx.core.app.NotificationCompat;
import com.tencent.mta.track.EditProtocol.BadInstructionsException;
import com.tencent.mta.track.EditProtocol.InapplicableInstructionsException;
import com.tencent.mta.track.util.C7462a;
import com.tencent.mta.track.util.C7466e;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.zip.GZIPOutputStream;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: ProGuard */
/* renamed from: com.tencent.mta.track.ao */
class C7355ao extends Handler {
    /* renamed from: a */
    final /* synthetic */ C7350aj f24893a;
    /* renamed from: b */
    private int f24894b = 0;
    /* access modifiers changed from: private */
    /* renamed from: c */
    public C7386q f24895c;
    /* renamed from: d */
    private C7358ar f24896d;
    /* access modifiers changed from: private|final */
    /* renamed from: e */
    public final Context f24897e;
    /* renamed from: f */
    private final Lock f24898f;
    /* renamed from: g */
    private final EditProtocol f24899g;
    /* access modifiers changed from: private */
    /* renamed from: h */
    public boolean f24900h;
    /* renamed from: i */
    private final List f24901i;
    /* renamed from: j */
    private final List f24902j;

    public C7355ao(C7350aj ajVar, Context context, Looper looper, String str) {
        this.f24893a = ajVar;
        super(looper);
        this.f24897e = context;
        this.f24896d = null;
        this.f24899g = new EditProtocol(new C7343ac(str, context));
        this.f24901i = new ArrayList();
        this.f24902j = new ArrayList();
        this.f24900h = false;
        this.f24898f = new ReentrantLock();
        this.f24898f.lock();
    }

    /* renamed from: a */
    public void mo35882a() {
        this.f24898f.unlock();
    }

    public void handleMessage(Message message) {
        this.f24898f.lock();
        try {
            int i = message.what;
            if (i == 0) {
                m31740b();
            } else if (i == 1) {
                m31743c();
            } else if (i == 2) {
                m31742b((JSONObject) message.obj, message.arg1);
            } else if (i != 13) {
                switch (i) {
                    case 4:
                        m31736a((JSONObject) message.obj, message.arg1);
                        break;
                    case 5:
                        m31734a((JSONArray) message.obj);
                        break;
                    case 6:
                        m31744c((JSONObject) message.obj, message.arg1);
                        break;
                    case 7:
                        m31741b((JSONObject) message.obj);
                        break;
                    case 8:
                        m31745d();
                        break;
                }
            } else {
                m31746e();
            }
        } finally {
            this.f24898f.unlock();
        }
    }

    /* renamed from: b */
    private void m31740b() {
        String str = "ViewCrawler";
        SharedPreferences g = m31748g();
        String str2 = "StatisticsData.viewcrawler.bindings";
        String string = g.getString(str2, null);
        if (string != null) {
            try {
                if (StatisticsDataAPI.sharedInstance(this.f24897e).isDebugMode()) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Initialize event bindings: ");
                    sb.append(string);
                    Log.i(str, sb.toString());
                }
                JSONArray jSONArray = new JSONArray(string);
                this.f24902j.clear();
                for (int i = 0; i < jSONArray.length(); i++) {
                    JSONObject jSONObject = jSONArray.getJSONObject(i);
                    this.f24902j.add(new Pair(C7466e.m32334a(jSONObject, "target_activity"), jSONObject));
                }
            } catch (JSONException e) {
                Log.w(str, "JSON error when initializing saved changes, clearing persistent memory", e);
                Editor edit = g.edit();
                edit.remove(str2);
                edit.apply();
            }
        }
        m31747f();
    }

    /* renamed from: a */
    private void m31735a(JSONObject jSONObject) {
        int i = this.f24894b;
        if (i < 3) {
            this.f24894b = i + 1;
            Message obtainMessage = this.f24893a.f24883g.obtainMessage(4);
            obtainMessage.obj = jSONObject;
            this.f24893a.f24883g.sendMessageDelayed(obtainMessage, 3000);
        }
    }

    /* renamed from: c */
    private void m31743c() {
        C7386q qVar = this.f24895c;
        String str = "ViewCrawler";
        if (qVar == null || !qVar.mo35930a()) {
            if (this.f24893a.f24884h != null) {
                if (StatisticsDataAPI.f24839a.booleanValue()) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Connecting to the VTrack server with ");
                    sb.append(this.f24893a.f24884h);
                    Log.i(str, sb.toString());
                }
                try {
                    this.f24895c = new C7386q(new URI(this.f24893a.f24884h), new C7352al(this.f24893a), this.f24897e);
                } catch (Throwable th) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("Error connecting to URI ");
                    sb2.append(this.f24893a.f24884h);
                    Log.e(str, sb2.toString(), th);
                }
            }
            return;
        }
        if (StatisticsDataAPI.f24839a.booleanValue()) {
            Log.i(str, "The VTrack server has been connected.");
        }
    }

    /* renamed from: a */
    private void m31736a(JSONObject jSONObject, int i) {
        C7386q qVar = this.f24895c;
        if (qVar != null && qVar.mo35930a()) {
            Iterator it = this.f24893a.f24885i.iterator();
            if (!it.hasNext()) {
                m31735a(jSONObject);
                return;
            }
            Activity activity = (Activity) it.next();
            if (activity == null) {
                C7386q qVar2 = this.f24895c;
                if (qVar2 != null) {
                    qVar2.mo35929a(true);
                }
                return;
            }
            try {
                new Builder(activity).setMessage("正在连接到可视化埋点管理界面").setTitle("Connecting").setPositiveButton("继续", new C7357aq(this, jSONObject, i)).setNegativeButton("取消", new C7356ap(this)).show();
            } catch (RuntimeException e) {
                Log.w("ViewCrawler", "Failed to show dialog of VTrack connector", e);
            }
        }
    }

    /* renamed from: b */
    private void m31742b(JSONObject jSONObject, int i) {
        String str = "last_image_hash";
        String str2 = "Can't close writer.";
        String str3 = "ViewCrawler";
        C7386q qVar = this.f24895c;
        if (qVar != null && qVar.mo35930a()) {
            long currentTimeMillis = System.currentTimeMillis();
            try {
                if (jSONObject.has("config")) {
                    this.f24896d = this.f24899g.mo35807a(jSONObject);
                }
                if (this.f24896d == null) {
                    Log.w(str3, "Snapshot should be initialize at first callsing.");
                    return;
                }
                if (jSONObject.has(str)) {
                    this.f24896d.mo35887a(jSONObject.getString(str));
                }
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                OutputStreamWriter outputStreamWriter = new OutputStreamWriter(byteArrayOutputStream);
                try {
                    outputStreamWriter.write("{");
                    outputStreamWriter.write("\"type\": \"snapshot_response\",");
                    String str4 = "}";
                    if (this.f24900h) {
                        ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
                        OutputStreamWriter outputStreamWriter2 = new OutputStreamWriter(byteArrayOutputStream2);
                        outputStreamWriter2.write("{\"activities\":");
                        outputStreamWriter2.flush();
                        this.f24896d.mo35886a((C7348ah) this.f24893a.f24882f, (OutputStream) byteArrayOutputStream2);
                        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                        outputStreamWriter2.write(",\"snapshot_time_millis\": ");
                        outputStreamWriter2.write(Long.toString(currentTimeMillis2));
                        outputStreamWriter2.write(str4);
                        outputStreamWriter2.flush();
                        byteArrayOutputStream2.close();
                        byte[] bytes = byteArrayOutputStream2.toString().getBytes();
                        ByteArrayOutputStream byteArrayOutputStream3 = new ByteArrayOutputStream(bytes.length);
                        GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream3);
                        gZIPOutputStream.write(bytes);
                        gZIPOutputStream.close();
                        byte[] byteArray = byteArrayOutputStream3.toByteArray();
                        byteArrayOutputStream3.close();
                        StringBuilder sb = new StringBuilder();
                        sb.append("\"gzip_payload\": \"");
                        sb.append(new String(C7462a.m32329a(byteArray)));
                        sb.append("\"");
                        outputStreamWriter.write(sb.toString());
                    } else {
                        outputStreamWriter.flush();
                        this.f24896d.mo35886a((C7348ah) this.f24893a.f24882f, (OutputStream) byteArrayOutputStream);
                        long currentTimeMillis3 = System.currentTimeMillis() - currentTimeMillis;
                        outputStreamWriter.write("\"snapshot_time_millis\": ");
                        outputStreamWriter.write(Long.toString(currentTimeMillis3));
                    }
                    outputStreamWriter.write(str4);
                    outputStreamWriter.flush();
                    try {
                    } catch (IOException e) {
                        Log.e(str3, str2, e);
                    }
                } catch (IOException e2) {
                    Log.e(str3, "Can't write snapshot request to server", e2);
                } finally {
                    try {
                        outputStreamWriter.close();
                    } catch (IOException e3) {
                        Log.e(str3, str2, e3);
                    }
                }
                if (StatisticsDataAPI.sharedInstance(this.f24897e).isDebugMode()) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("end Snapshot seq : ");
                    sb2.append(i);
                    Log.i("track", sb2.toString());
                }
                C7386q qVar2 = this.f24895c;
                if (qVar2 != null && qVar2.mo35930a()) {
                    this.f24895c.mo35928a(byteArrayOutputStream.toString(), i, 0);
                }
            } catch (JSONException e4) {
                Log.e(str3, "Payload with snapshot config required with snapshot request", e4);
            } catch (BadInstructionsException e5) {
                Log.e(str3, "VTrack server sent malformed message with snapshot request", e5);
            }
        }
    }

    /* renamed from: a */
    private void m31737a(boolean z, int i) {
        String str = "Can't close websocket writer";
        String str2 = "ViewCrawler";
        C7386q qVar = this.f24895c;
        if (qVar != null && qVar.mo35930a()) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            JsonWriter jsonWriter = new JsonWriter(new OutputStreamWriter(byteArrayOutputStream));
            try {
                jsonWriter.beginObject();
                jsonWriter.name("type").value("event_binding_response");
                jsonWriter.name("payload").beginObject();
                jsonWriter.name(NotificationCompat.CATEGORY_STATUS).value("OK");
                jsonWriter.endObject();
                jsonWriter.endObject();
                try {
                } catch (IOException e) {
                    Log.e(str2, str, e);
                }
            } catch (IOException e2) {
                Log.e(str2, "Can't write event_binding_response to server", e2);
            } finally {
                try {
                    jsonWriter.close();
                } catch (IOException e3) {
                    Log.e(str2, str, e3);
                }
            }
            C7386q qVar2 = this.f24895c;
            if (qVar2 != null && qVar2.mo35930a()) {
                this.f24895c.mo35928a(byteArrayOutputStream.toString(), i, 2);
            }
        }
    }

    /* renamed from: b */
    private void m31741b(JSONObject jSONObject) {
        String str = "binding_trigger_id";
        C7386q qVar = this.f24895c;
        if (qVar != null && qVar.mo35930a() && jSONObject != null) {
            String str2 = "properties";
            JSONObject optJSONObject = jSONObject.optJSONObject(str2);
            if (optJSONObject != null) {
                String str3 = "ViewCrawler";
                if (StatisticsDataAPI.f24839a.booleanValue()) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Sending debug track to vtrack. original event: ");
                    sb.append(jSONObject.toString());
                    Log.i(str3, sb.toString());
                }
                if (optJSONObject.optString("from_vtrack", "").length() >= 1) {
                    try {
                        JSONArray jSONArray = new JSONArray();
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("time", System.currentTimeMillis() / 1000);
                        jSONObject2.put("event_id", optJSONObject.getString("binding_event_id"));
                        jSONObject2.put(str2, jSONObject.optJSONObject("parameter"));
                        jSONObject2.put("trigger_id", optJSONObject.getString(str));
                        optJSONObject.remove("binding_path");
                        optJSONObject.remove("binding_depolyed");
                        optJSONObject.remove(str);
                        jSONObject.put(str2, optJSONObject);
                        JSONObject jSONObject3 = new JSONObject();
                        jSONObject3.put("type", "debug_track");
                        jSONObject3.put("payload", jSONObject2);
                        jSONArray.put(jSONObject3);
                        if (this.f24895c != null && this.f24895c.mo35930a()) {
                            this.f24895c.mo35928a(jSONArray.toString(), -1, 2);
                        }
                    } catch (JSONException e) {
                        Log.e(str3, "Invalied proprties", e);
                    }
                    return;
                }
                return;
            }
            return;
        }
        return;
    }

    /* renamed from: a */
    private void m31734a(JSONArray jSONArray) {
        Editor edit = m31748g().edit();
        edit.putString("StatisticsData.viewcrawler.bindings", jSONArray.toString());
        edit.apply();
        m31740b();
    }

    /* renamed from: c */
    private void m31744c(JSONObject jSONObject, int i) {
        String str = "ViewCrawler";
        if (StatisticsDataAPI.f24839a.booleanValue()) {
            Log.i(str, String.format("Received event bindings from VTrack editor: %s", new Object[]{jSONObject.toString()}));
        }
        m31737a(true, i);
        try {
            JSONArray jSONArray = jSONObject.getJSONObject("payload").getJSONArray("events");
            int length = jSONArray.length();
            this.f24901i.clear();
            for (int i2 = 0; i2 < length; i2++) {
                try {
                    JSONObject jSONObject2 = jSONArray.getJSONObject(i2);
                    this.f24901i.add(new Pair(C7466e.m32334a(jSONObject2, "target_activity"), jSONObject2));
                } catch (JSONException e) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Bad event binding received from VTrack server in ");
                    sb.append(jSONArray.toString());
                    Log.e(str, sb.toString(), e);
                }
            }
            m31747f();
        } catch (JSONException e2) {
            Log.e(str, "Bad event bindings received", e2);
        }
    }

    /* renamed from: d */
    private void m31745d() {
        if (StatisticsDataAPI.f24839a.booleanValue()) {
            Log.i("ViewCrawler", "VTrack server connection closed.");
        }
        this.f24896d = null;
        this.f24901i.clear();
        m31747f();
    }

    /* renamed from: e */
    private void m31746e() {
        if (this.f24895c != null) {
            this.f24893a.f24880d.mo35874b();
            this.f24895c.mo35929a(true);
        }
    }

    /* renamed from: f */
    private void m31747f() {
        List list;
        ArrayList arrayList = new ArrayList();
        String str = "ViewCrawler";
        if (StatisticsDataAPI.f24839a.booleanValue()) {
            Log.i(str, String.format("Event bindings are loaded. %d events from VTrack editor ，%d events from VTrack configure", new Object[]{Integer.valueOf(this.f24901i.size()), Integer.valueOf(this.f24902j.size())}));
        }
        if (this.f24901i.size() > 0) {
            for (Pair pair : this.f24901i) {
                try {
                    arrayList.add(new Pair(pair.first, this.f24899g.mo35808a((JSONObject) pair.second, (C7370bc) this.f24893a.f24881e)));
                } catch (InapplicableInstructionsException e) {
                    Log.w(str, e.getMessage());
                } catch (BadInstructionsException e2) {
                    Log.e(str, "Bad editor event binding cannot be applied.", e2);
                }
            }
        } else {
            for (Pair pair2 : this.f24902j) {
                try {
                    arrayList.add(new Pair(pair2.first, this.f24899g.mo35808a((JSONObject) pair2.second, (C7370bc) this.f24893a.f24881e)));
                } catch (InapplicableInstructionsException e3) {
                    Log.w(str, e3.getMessage());
                } catch (BadInstructionsException e4) {
                    Log.e(str, "Bad persistent event binding cannot be applied.", e4);
                }
            }
        }
        HashMap hashMap = new HashMap();
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            Pair pair3 = (Pair) arrayList.get(i);
            if (hashMap.containsKey(pair3.first)) {
                list = (List) hashMap.get(pair3.first);
            } else {
                list = new ArrayList();
                hashMap.put(pair3.first, list);
            }
            list.add(pair3.second);
        }
        this.f24893a.f24882f.mo35922a((Map) hashMap);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public JSONObject m31733a(String str, JSONObject jSONObject) {
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("type", str);
            if (this.f24900h) {
                byte[] bytes = jSONObject.toString().getBytes();
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(bytes.length);
                GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
                gZIPOutputStream.write(bytes);
                gZIPOutputStream.close();
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                byteArrayOutputStream.close();
                jSONObject2.put("gzip_payload", new String(C7462a.m32329a(byteArray)));
            } else {
                jSONObject2.put("payload", jSONObject);
            }
            return jSONObject2;
        } catch (Throwable unused) {
            return null;
        }
    }

    /* renamed from: g */
    private SharedPreferences m31748g() {
        return this.f24897e.getSharedPreferences("StatisticsData", 0);
    }
}
