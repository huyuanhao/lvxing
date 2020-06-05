package com.kwad.sdk.export.proxy;

import com.kwad.sdk.core.response.p341a.C4320a;
import java.util.Map;
import org.json.JSONObject;

public interface AdHttpProxy<Response> {
    C4320a doGet(String str, Map<String, String> map);

    C4320a doPost(String str, Map<String, String> map, Map<String, String> map2);

    C4320a doPost(String str, Map<String, String> map, JSONObject jSONObject);

    C4320a parseResponse(Response response);
}
