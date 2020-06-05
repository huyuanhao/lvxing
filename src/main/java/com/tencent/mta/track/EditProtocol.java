package com.tencent.mta.track;

import android.util.Log;
import com.tencent.mta.track.util.C7466e;
import com.tencent.p605ep.common.adapt.iservice.account.AccountConst.ArgKey;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: ProGuard */
public class EditProtocol {
    /* renamed from: b */
    private static final Class[] f24836b = new Class[0];
    /* renamed from: c */
    private static final List f24837c = Collections.emptyList();
    /* renamed from: a */
    private final C7341aa f24838a;

    /* compiled from: ProGuard */
    /* renamed from: com.tencent.mta.track.EditProtocol$BadInstructionsException */
    public class BadInstructionsException extends Exception {
        private static final long serialVersionUID = 3203327992924262295L;

        public BadInstructionsException(String str) {
            super(str);
        }

        public BadInstructionsException(String str, Throwable th) {
            super(str, th);
        }
    }

    /* compiled from: ProGuard */
    /* renamed from: com.tencent.mta.track.EditProtocol$InapplicableInstructionsException */
    public class InapplicableInstructionsException extends BadInstructionsException {
        private static final long serialVersionUID = -503655474732873266L;

        public InapplicableInstructionsException(String str) {
            super(str);
        }
    }

    public EditProtocol(C7341aa aaVar) {
        this.f24838a = aaVar;
    }

    /* renamed from: a */
    public C7363aw mo35808a(JSONObject jSONObject, C7370bc bcVar) {
        String str = "relation";
        try {
            String string = jSONObject.getString("event_name");
            String string2 = jSONObject.getString("event_type");
            int optInt = jSONObject.optInt("trigger_id", -1);
            String string3 = jSONObject.getString("event_id");
            boolean optBoolean = jSONObject.optBoolean("deployed", false);
            JSONArray jSONArray = jSONObject.getJSONArray("path");
            C7461u uVar = new C7461u(string, string2, jSONArray.toString(), !jSONObject.isNull(str) ? jSONObject.getJSONArray(str).toString() : "", optInt, string3, optBoolean);
            List a = m31645a(jSONArray, this.f24838a);
            if (a.size() == 0) {
                StringBuilder sb = new StringBuilder();
                sb.append("event '");
                sb.append(uVar);
                sb.append("' will not be bound to any element in the UI.");
                throw new InapplicableInstructionsException(sb.toString());
            } else if ("click".equals(string2)) {
                return new C7364ax(a, 1, uVar, bcVar);
            } else {
                if ("selected".equals(string2)) {
                    return new C7364ax(a, 4, uVar, bcVar);
                }
                if ("text_changed".equals(string2)) {
                    return new C7366az(a, uVar, bcVar);
                }
                if ("detected".equals(string2)) {
                    return new C7371bd(a, uVar, bcVar);
                }
                StringBuilder sb2 = new StringBuilder();
                sb2.append("StatisticsData can't track event type \"");
                sb2.append(string2);
                sb2.append("\"");
                throw new BadInstructionsException(sb2.toString());
            }
        } catch (JSONException e) {
            throw new BadInstructionsException("Can't interpret instructions due to JSONException", e);
        }
    }

    /* renamed from: a */
    public C7358ar mo35807a(JSONObject jSONObject) {
        ArrayList arrayList = new ArrayList();
        try {
            JSONArray jSONArray = jSONObject.getJSONObject("config").getJSONArray("classes");
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                Class cls = Class.forName(jSONObject2.getString(ArgKey.KEY_NAME));
                JSONArray jSONArray2 = jSONObject2.getJSONArray("properties");
                for (int i2 = 0; i2 < jSONArray2.length(); i2++) {
                    arrayList.add(m31643a(cls, jSONArray2.getJSONObject(i2)));
                }
            }
            return new C7358ar(arrayList, this.f24838a);
        } catch (JSONException e) {
            throw new BadInstructionsException("Can't read snapshot configuration", e);
        } catch (ClassNotFoundException e2) {
            throw new BadInstructionsException("Can't resolve types for snapshot configuration", e2);
        }
    }

    /* renamed from: a */
    private List m31645a(JSONArray jSONArray, C7341aa aaVar) {
        int i;
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            JSONObject jSONObject = jSONArray.getJSONObject(i2);
            String a = C7466e.m32334a(jSONObject, "prefix");
            String a2 = C7466e.m32334a(jSONObject, "view_class");
            int optInt = jSONObject.optInt("index", -1);
            int optInt2 = jSONObject.optInt("id", -1);
            String a3 = C7466e.m32334a(jSONObject, "sa_id_name");
            if ("shortest".equals(a)) {
                i = 1;
            } else if (a == null) {
                i = 0;
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append("Unrecognized prefix type \"");
                sb.append(a);
                sb.append("\". No views will be matched");
                Log.w("EProtocol", sb.toString());
                return f24837c;
            }
            Integer a4 = m31644a(optInt2, a3, aaVar);
            if (a4 == null) {
                return f24837c;
            }
            arrayList.add(new C7476y(i, a2, optInt, a4.intValue()));
        }
        return arrayList;
    }

    /* renamed from: a */
    private Integer m31644a(int i, String str, C7341aa aaVar) {
        int i2;
        String str2 = "EProtocol";
        if (str == null || str.length() <= 0) {
            i2 = -1;
        } else if (aaVar.mo35837a(str)) {
            i2 = aaVar.mo35838b(str);
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append("Path element contains an id name not known to the system. No views will be matched.\nMake sure that you're not stripping your packages R class out with proguard.\nid name was \"");
            sb.append(str);
            sb.append("\"");
            Log.w(str2, sb.toString());
            return null;
        }
        if (-1 != i2 && -1 != i && i2 != i) {
            Log.e(str2, "Path contains both a named and an explicit id, and they don't match. No views will be matched.");
            return null;
        } else if (-1 != i2) {
            return Integer.valueOf(i2);
        } else {
            return Integer.valueOf(i);
        }
    }

    /* renamed from: a */
    private C7477z m31643a(Class cls, JSONObject jSONObject) {
        C7373d dVar;
        String str = "set";
        String str2 = "get";
        try {
            String string = jSONObject.getString(ArgKey.KEY_NAME);
            String str3 = "selector";
            String str4 = null;
            if (jSONObject.has(str2)) {
                JSONObject jSONObject2 = jSONObject.getJSONObject(str2);
                dVar = new C7373d(cls, jSONObject2.getString(str3), f24836b, Class.forName(jSONObject2.getJSONObject(ArgKey.KEY_RESULT).getString("type")));
            } else {
                dVar = null;
            }
            if (jSONObject.has(str)) {
                str4 = jSONObject.getJSONObject(str).getString(str3);
            }
            return new C7477z(string, cls, dVar, str4);
        } catch (NoSuchMethodException e) {
            throw new BadInstructionsException("Can't create property reader", e);
        } catch (JSONException e2) {
            throw new BadInstructionsException("Can't read property JSON", e2);
        } catch (ClassNotFoundException e3) {
            throw new BadInstructionsException("Can't read property JSON, relevant arg/return class not found", e3);
        }
    }
}
