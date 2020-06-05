package com.kwad.sdk.core.request.model;

import android.location.Location;
import com.kwad.sdk.KsAdSDK;
import com.kwad.sdk.core.response.p341a.C4321b;
import com.kwad.sdk.export.proxy.AdLocationProxy;
import com.kwad.sdk.p306a.C3797c;
import com.kwad.sdk.p306a.C3800e;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.core.request.model.d */
public class C4315d implements C4321b {
    /* renamed from: a */
    private double f14192a;
    /* renamed from: b */
    private double f14193b;

    /* renamed from: a */
    public static C4315d m17620a() {
        double longitude;
        C4315d dVar = new C4315d();
        AdLocationProxy proxyForAdLocation = KsAdSDK.getProxyForAdLocation();
        if (proxyForAdLocation != null) {
            dVar.f14192a = proxyForAdLocation.getLatitude();
            longitude = proxyForAdLocation.getLongitude();
        } else {
            Location a = C3797c.m15733a(KsAdSDK.getContext());
            if (a != null) {
                dVar.f14192a = a.getLatitude();
                longitude = a.getLongitude();
            }
            return dVar;
        }
        dVar.f14193b = longitude;
        return dVar;
    }

    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        C3800e.m15747a(jSONObject, "latitude", this.f14192a);
        C3800e.m15747a(jSONObject, "longitude", this.f14193b);
        return jSONObject;
    }
}
