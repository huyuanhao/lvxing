package com.kwad.sdk.core.p337i.p339b;

import androidx.core.app.NotificationCompat;
import com.kwad.sdk.core.p319c.C4065b;
import com.kwad.sdk.core.p337i.p338a.C4201a;
import com.kwad.sdk.core.p337i.p338a.C4203c;
import com.kwad.sdk.core.response.p341a.C4321b;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.core.i.b.h */
public class C4224h implements C4201a {
    /* renamed from: a */
    private C4226b f14022a;

    /* renamed from: com.kwad.sdk.core.i.b.h$a */
    public static final class C4225a implements C4321b {
        /* renamed from: a */
        public int f14023a;

        /* renamed from: a */
        public void mo23986a(JSONObject jSONObject) {
            if (jSONObject != null) {
                this.f14023a = jSONObject.optInt(NotificationCompat.CATEGORY_STATUS);
            }
        }

        public JSONObject toJson() {
            return null;
        }
    }

    /* renamed from: com.kwad.sdk.core.i.b.h$b */
    public interface C4226b {
        /* renamed from: a */
        void mo23224a(int i);
    }

    public C4224h(C4226b bVar) {
        this.f14022a = bVar;
    }

    /* renamed from: a */
    private void m17458a(int i) {
        C4226b bVar = this.f14022a;
        if (bVar != null) {
            bVar.mo23224a(i);
        }
    }

    /* renamed from: a */
    public String mo23976a() {
        return "pageStatus";
    }

    /* renamed from: a */
    public void mo23977a(String str, C4203c cVar) {
        try {
            C4225a aVar = new C4225a();
            aVar.mo23986a(new JSONObject(str));
            m17458a(aVar.f14023a);
            cVar.mo23981a(null);
        } catch (JSONException e) {
            StringBuilder sb = new StringBuilder();
            sb.append("handleJsCall error: ");
            sb.append(e);
            C4065b.m16869d("WebCardPageStatusHandler", sb.toString());
            cVar.mo23980a(-1, e.getMessage());
        }
    }

    /* renamed from: b */
    public void mo23978b() {
        this.f14022a = null;
    }
}
