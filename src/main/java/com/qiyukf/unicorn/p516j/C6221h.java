package com.qiyukf.unicorn.p516j;

import android.os.Handler;
import com.qiyukf.basesdk.p393a.C5264a;
import com.qiyukf.basesdk.p412c.C5366b;
import com.qiyukf.nim.uikit.C5433b;
import com.qiyukf.nimlib.p469e.C5808b;
import com.qiyukf.nimlib.p485i.C5912a;
import com.qiyukf.nimlib.p485i.C5922f;
import com.qiyukf.unicorn.C6029d;
import com.qiyukf.unicorn.p499b.C6014b;
import com.qiyukf.unicorn.p503f.p504a.p510d.C6142v;
import com.qiyukf.unicorn.p503f.p504a.p511e.C6156l;
import com.qiyukf.unicorn.p503f.p512b.C6166a;
import com.qiyukf.unicorn.p503f.p512b.C6167b;
import com.qiyukf.unicorn.p514h.C6185c;
import com.tencent.p605ep.common.adapt.iservice.account.AccountConst.ArgKey;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.qiyukf.unicorn.j.h */
public final class C6221h {

    /* renamed from: com.qiyukf.unicorn.j.h$a */
    public interface C6225a {
        /* renamed from: a */
        void mo29412a(int i);

        /* renamed from: a */
        void mo29413a(JSONArray jSONArray);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:50:0x00ba, code lost:
            r4 = com.qiyukf.unicorn.api.msg.MsgTypeEnum.custom;
     */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x014d A[Catch:{ JSONException -> 0x0181 }] */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x0150 A[Catch:{ JSONException -> 0x0181 }] */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x0167 A[Catch:{ JSONException -> 0x0181 }] */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x017b A[Catch:{ JSONException -> 0x0181 }] */
    /* renamed from: a */
    public static com.qiyukf.nimlib.p485i.C5912a m24655a(org.json.JSONObject r7) {
        /*
        java.lang.String r0 = "imid"
        java.lang.String r1 = "tt"
        java.lang.String r2 = "content"
        com.qiyukf.nimlib.i.a r3 = new com.qiyukf.nimlib.i.a     // Catch:{ JSONException -> 0x0181 }
        r3.m50087init()     // Catch:{ JSONException -> 0x0181 }
        java.lang.String r4 = "id"
        long r4 = com.qiyukf.basesdk.p412c.C5366b.m22037c(r7, r4)     // Catch:{ JSONException -> 0x0181 }
        r3.mo28298b(r4)     // Catch:{ JSONException -> 0x0181 }
        java.lang.String r4 = "type"
        java.lang.String r4 = com.qiyukf.basesdk.p412c.C5366b.m22039e(r7, r4)     // Catch:{ JSONException -> 0x0181 }
        if (r4 != 0) goto L_0x0020
    L_0x001c:
        com.qiyukf.unicorn.api.msg.MsgTypeEnum r4 = com.qiyukf.unicorn.api.msg.MsgTypeEnum.text     // Catch:{ JSONException -> 0x0181 }
        goto L_0x00cb
    L_0x0020:
        r5 = -1
        int r6 = r4.hashCode()     // Catch:{ JSONException -> 0x0181 }
        switch(r6) {
            case -1550589943: goto L_0x00a9;
            case -1349088399: goto L_0x009e;
            case -786304394: goto L_0x0093;
            case 3600: goto L_0x0089;
            case 102264: goto L_0x007e;
            case 114843: goto L_0x0074;
            case 3143036: goto L_0x006a;
            case 3556653: goto L_0x0060;
            case 35379135: goto L_0x0056;
            case 93166550: goto L_0x004c;
            case 100313435: goto L_0x0041;
            case 112202875: goto L_0x0036;
            case 923828588: goto L_0x002a;
            default: goto L_0x0028;
        }     // Catch:{ JSONException -> 0x0181 }
    L_0x0028:
        goto L_0x00b3
    L_0x002a:
        java.lang.String r6 = "cnotify"
        boolean r4 = r4.equals(r6)     // Catch:{ JSONException -> 0x0181 }
        if (r4 == 0) goto L_0x00b3
        r5 = 12
        goto L_0x00b3
    L_0x0036:
        java.lang.String r6 = "video"
        boolean r4 = r4.equals(r6)     // Catch:{ JSONException -> 0x0181 }
        if (r4 == 0) goto L_0x00b3
        r5 = 5
        goto L_0x00b3
    L_0x0041:
        java.lang.String r6 = "image"
        boolean r4 = r4.equals(r6)     // Catch:{ JSONException -> 0x0181 }
        if (r4 == 0) goto L_0x00b3
        r5 = 1
        goto L_0x00b3
    L_0x004c:
        java.lang.String r6 = "audio"
        boolean r4 = r4.equals(r6)     // Catch:{ JSONException -> 0x0181 }
        if (r4 == 0) goto L_0x00b3
        r5 = 2
        goto L_0x00b3
    L_0x0056:
        java.lang.String r6 = "workflow"
        boolean r4 = r4.equals(r6)     // Catch:{ JSONException -> 0x0181 }
        if (r4 == 0) goto L_0x00b3
        r5 = 7
        goto L_0x00b3
    L_0x0060:
        java.lang.String r6 = "text"
        boolean r4 = r4.equals(r6)     // Catch:{ JSONException -> 0x0181 }
        if (r4 == 0) goto L_0x00b3
        r5 = 0
        goto L_0x00b3
    L_0x006a:
        java.lang.String r6 = "file"
        boolean r4 = r4.equals(r6)     // Catch:{ JSONException -> 0x0181 }
        if (r4 == 0) goto L_0x00b3
        r5 = 3
        goto L_0x00b3
    L_0x0074:
        java.lang.String r6 = "tip"
        boolean r4 = r4.equals(r6)     // Catch:{ JSONException -> 0x0181 }
        if (r4 == 0) goto L_0x00b3
        r5 = 4
        goto L_0x00b3
    L_0x007e:
        java.lang.String r6 = "gfw"
        boolean r4 = r4.equals(r6)     // Catch:{ JSONException -> 0x0181 }
        if (r4 == 0) goto L_0x00b3
        r5 = 10
        goto L_0x00b3
    L_0x0089:
        java.lang.String r6 = "qa"
        boolean r4 = r4.equals(r6)     // Catch:{ JSONException -> 0x0181 }
        if (r4 == 0) goto L_0x00b3
        r5 = 6
        goto L_0x00b3
    L_0x0093:
        java.lang.String r6 = "ainvalid"
        boolean r4 = r4.equals(r6)     // Catch:{ JSONException -> 0x0181 }
        if (r4 == 0) goto L_0x00b3
        r5 = 11
        goto L_0x00b3
    L_0x009e:
        java.lang.String r6 = "custom"
        boolean r4 = r4.equals(r6)     // Catch:{ JSONException -> 0x0181 }
        if (r4 == 0) goto L_0x00b3
        r5 = 8
        goto L_0x00b3
    L_0x00a9:
        java.lang.String r6 = "richtext"
        boolean r4 = r4.equals(r6)     // Catch:{ JSONException -> 0x0181 }
        if (r4 == 0) goto L_0x00b3
        r5 = 9
    L_0x00b3:
        switch(r5) {
            case 0: goto L_0x001c;
            case 1: goto L_0x00c9;
            case 2: goto L_0x00c6;
            case 3: goto L_0x00c3;
            case 4: goto L_0x00c0;
            case 5: goto L_0x00bd;
            case 6: goto L_0x00ba;
            case 7: goto L_0x00ba;
            case 8: goto L_0x00ba;
            case 9: goto L_0x00ba;
            case 10: goto L_0x00ba;
            case 11: goto L_0x00b7;
            case 12: goto L_0x00b7;
            default: goto L_0x00b6;
        }     // Catch:{ JSONException -> 0x0181 }
    L_0x00b6:
        goto L_0x00ba
    L_0x00b7:
        com.qiyukf.unicorn.api.msg.MsgTypeEnum r4 = com.qiyukf.unicorn.api.msg.MsgTypeEnum.notification     // Catch:{ JSONException -> 0x0181 }
        goto L_0x00cb
    L_0x00ba:
        com.qiyukf.unicorn.api.msg.MsgTypeEnum r4 = com.qiyukf.unicorn.api.msg.MsgTypeEnum.custom     // Catch:{ JSONException -> 0x0181 }
        goto L_0x00cb
    L_0x00bd:
        com.qiyukf.unicorn.api.msg.MsgTypeEnum r4 = com.qiyukf.unicorn.api.msg.MsgTypeEnum.video     // Catch:{ JSONException -> 0x0181 }
        goto L_0x00cb
    L_0x00c0:
        com.qiyukf.unicorn.api.msg.MsgTypeEnum r4 = com.qiyukf.unicorn.api.msg.MsgTypeEnum.tips     // Catch:{ JSONException -> 0x0181 }
        goto L_0x00cb
    L_0x00c3:
        com.qiyukf.unicorn.api.msg.MsgTypeEnum r4 = com.qiyukf.unicorn.api.msg.MsgTypeEnum.file     // Catch:{ JSONException -> 0x0181 }
        goto L_0x00cb
    L_0x00c6:
        com.qiyukf.unicorn.api.msg.MsgTypeEnum r4 = com.qiyukf.unicorn.api.msg.MsgTypeEnum.audio     // Catch:{ JSONException -> 0x0181 }
        goto L_0x00cb
    L_0x00c9:
        com.qiyukf.unicorn.api.msg.MsgTypeEnum r4 = com.qiyukf.unicorn.api.msg.MsgTypeEnum.image     // Catch:{ JSONException -> 0x0181 }
    L_0x00cb:
        int r4 = r4.getValue()     // Catch:{ JSONException -> 0x0181 }
        r3.mo28292a(r4)     // Catch:{ JSONException -> 0x0181 }
        com.qiyukf.unicorn.api.msg.MsgStatusEnum r4 = com.qiyukf.unicorn.api.msg.MsgStatusEnum.success     // Catch:{ JSONException -> 0x0181 }
        r3.setStatus(r4)     // Catch:{ JSONException -> 0x0181 }
        java.lang.String r4 = "ext"
        java.lang.String r4 = com.qiyukf.basesdk.p412c.C5366b.m22039e(r7, r4)     // Catch:{ JSONException -> 0x0181 }
        r3.setExt(r4)     // Catch:{ JSONException -> 0x0181 }
        java.lang.String r4 = com.qiyukf.basesdk.p412c.C5366b.m22039e(r7, r2)     // Catch:{ JSONException -> 0x0181 }
        com.qiyukf.unicorn.api.msg.MsgTypeEnum r5 = r3.getMsgType()     // Catch:{ JSONException -> 0x0181 }
        com.qiyukf.unicorn.api.msg.MsgTypeEnum r6 = com.qiyukf.unicorn.api.msg.MsgTypeEnum.text     // Catch:{ JSONException -> 0x0181 }
        if (r5 == r6) goto L_0x0130
        com.qiyukf.unicorn.api.msg.MsgTypeEnum r5 = r3.getMsgType()     // Catch:{ JSONException -> 0x0181 }
        com.qiyukf.unicorn.api.msg.MsgTypeEnum r6 = com.qiyukf.unicorn.api.msg.MsgTypeEnum.notification     // Catch:{ JSONException -> 0x0181 }
        if (r5 == r6) goto L_0x0130
        com.qiyukf.unicorn.api.msg.MsgTypeEnum r5 = r3.getMsgType()     // Catch:{ JSONException -> 0x0181 }
        com.qiyukf.unicorn.api.msg.MsgTypeEnum r6 = com.qiyukf.unicorn.api.msg.MsgTypeEnum.tips     // Catch:{ JSONException -> 0x0181 }
        if (r5 != r6) goto L_0x00fd
        goto L_0x0130
    L_0x00fd:
        r3.mo28301c(r4)     // Catch:{ JSONException -> 0x0181 }
        com.qiyukf.nimlib.sdk.msg.constant.AttachStatusEnum r5 = com.qiyukf.nimlib.sdk.msg.constant.AttachStatusEnum.def     // Catch:{ JSONException -> 0x0181 }
        r3.setAttachStatus(r5)     // Catch:{ JSONException -> 0x0181 }
        com.qiyukf.unicorn.api.msg.MsgTypeEnum r5 = r3.getMsgType()     // Catch:{ JSONException -> 0x0181 }
        com.qiyukf.unicorn.api.msg.MsgTypeEnum r6 = com.qiyukf.unicorn.api.msg.MsgTypeEnum.audio     // Catch:{ JSONException -> 0x0181 }
        if (r5 != r6) goto L_0x0133
        com.qiyukf.unicorn.api.msg.MsgStatusEnum r5 = com.qiyukf.unicorn.api.msg.MsgStatusEnum.read     // Catch:{ JSONException -> 0x0181 }
        r3.setStatus(r5)     // Catch:{ JSONException -> 0x0181 }
        org.json.JSONObject r4 = com.qiyukf.basesdk.p412c.C5366b.m22027a(r4)     // Catch:{ JSONException -> 0x0181 }
        boolean r5 = r4.has(r1)     // Catch:{ JSONException -> 0x0181 }
        if (r5 == 0) goto L_0x0133
        org.json.JSONObject r5 = new org.json.JSONObject     // Catch:{ JSONException -> 0x0181 }
        r5.<init>()     // Catch:{ JSONException -> 0x0181 }
        java.lang.Object r1 = r4.get(r1)     // Catch:{ JSONException -> 0x0181 }
        r5.put(r2, r1)     // Catch:{ JSONException -> 0x0181 }
        java.lang.String r1 = r5.toString()     // Catch:{ JSONException -> 0x0181 }
        r3.setExt(r1)     // Catch:{ JSONException -> 0x0181 }
        goto L_0x0133
    L_0x0130:
        r3.setContent(r4)     // Catch:{ JSONException -> 0x0181 }
    L_0x0133:
        java.lang.String r1 = "time"
        long r1 = com.qiyukf.basesdk.p412c.C5366b.m22037c(r7, r1)     // Catch:{ JSONException -> 0x0181 }
        r3.setTime(r1)     // Catch:{ JSONException -> 0x0181 }
        java.lang.String r1 = "msgIdClient"
        java.lang.String r1 = com.qiyukf.basesdk.p412c.C5366b.m22039e(r7, r1)     // Catch:{ JSONException -> 0x0181 }
        r3.mo28296a(r1)     // Catch:{ JSONException -> 0x0181 }
        java.lang.String r1 = "fromUser"
        int r1 = com.qiyukf.basesdk.p412c.C5366b.m22034b(r7, r1)     // Catch:{ JSONException -> 0x0181 }
        if (r1 != 0) goto L_0x0150
        com.qiyukf.nimlib.sdk.msg.constant.MsgDirectionEnum r1 = com.qiyukf.nimlib.sdk.msg.constant.MsgDirectionEnum.In     // Catch:{ JSONException -> 0x0181 }
        goto L_0x0152
    L_0x0150:
        com.qiyukf.nimlib.sdk.msg.constant.MsgDirectionEnum r1 = com.qiyukf.nimlib.sdk.msg.constant.MsgDirectionEnum.Out     // Catch:{ JSONException -> 0x0181 }
    L_0x0152:
        r3.setDirect(r1)     // Catch:{ JSONException -> 0x0181 }
        java.lang.String r1 = "-1"
        r3.mo28299b(r1)     // Catch:{ JSONException -> 0x0181 }
        com.qiyukf.nimlib.sdk.msg.constant.SessionTypeEnum r1 = com.qiyukf.nimlib.sdk.msg.constant.SessionTypeEnum.Ysf     // Catch:{ JSONException -> 0x0181 }
        r3.mo28294a(r1)     // Catch:{ JSONException -> 0x0181 }
        com.qiyukf.nimlib.sdk.msg.constant.MsgDirectionEnum r1 = r3.getDirect()     // Catch:{ JSONException -> 0x0181 }
        com.qiyukf.nimlib.sdk.msg.constant.MsgDirectionEnum r2 = com.qiyukf.nimlib.sdk.msg.constant.MsgDirectionEnum.In     // Catch:{ JSONException -> 0x0181 }
        if (r1 != r2) goto L_0x017b
        java.lang.String r1 = "kefu"
        org.json.JSONObject r7 = com.qiyukf.basesdk.p412c.C5366b.m22040f(r7, r1)     // Catch:{ JSONException -> 0x0181 }
        java.lang.String r1 = com.qiyukf.basesdk.p412c.C5366b.m22039e(r7, r0)     // Catch:{ JSONException -> 0x0181 }
        if (r1 == 0) goto L_0x0180
        java.lang.String r7 = com.qiyukf.basesdk.p412c.C5366b.m22039e(r7, r0)     // Catch:{ JSONException -> 0x0181 }
    L_0x0177:
        r3.setFromAccount(r7)     // Catch:{ JSONException -> 0x0181 }
        goto L_0x0180
    L_0x017b:
        java.lang.String r7 = com.qiyukf.nimlib.C5718b.m23015b()     // Catch:{ JSONException -> 0x0181 }
        goto L_0x0177
    L_0x0180:
        return r3
    L_0x0181:
        r7 = 0
        return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qiyukf.unicorn.p516j.C6221h.m24655a(org.json.JSONObject):com.qiyukf.nimlib.i.a");
    }

    /* renamed from: a */
    public static void m24656a() {
        C6185c.m24532a(new C6156l(), C6185c.m24533a(), false);
    }

    /* renamed from: a */
    public static void m24657a(final C6142v vVar) {
        new Thread(new Runnable() {
            public final void run() {
                String sb;
                String str;
                String str2 = "code";
                String str3 = "请求 url 为";
                String str4 = "/webapi/sdk/user/message/history";
                C6142v vVar = vVar;
                HashMap hashMap = new HashMap();
                hashMap.put("appKey", C6029d.m24043d());
                hashMap.put("fromAccount", C5433b.m22192b());
                hashMap.put("accessToken", vVar.mo29172a());
                hashMap.put("beginTime", String.valueOf(System.currentTimeMillis() - 604800000));
                hashMap.put("endTime", String.valueOf(System.currentTimeMillis()));
                hashMap.put("limit", "20");
                C62241 r3 = new C6225a() {
                    /* renamed from: a */
                    public final void mo29412a(int i) {
                        C5264a.m21617a("请求未读消息接口失败 code 为：", String.valueOf(i));
                    }

                    /* renamed from: a */
                    public final void mo29413a(JSONArray jSONArray) {
                        C6014b.m23925a(Boolean.valueOf(true));
                        ArrayList arrayList = new ArrayList();
                        for (int i = 0; i < jSONArray.length(); i++) {
                            arrayList.add(C6221h.m24655a(C5366b.m22036b(jSONArray, i)));
                        }
                        Iterator it = arrayList.iterator();
                        while (it.hasNext()) {
                            C5912a aVar = (C5912a) it.next();
                            if (C5922f.m23754b(aVar.getUuid()) == 0) {
                                String str = "#";
                                if (aVar.getUuid().contains(str)) {
                                    if (C5922f.m23754b(aVar.getUuid().substring(aVar.getUuid().indexOf(str) + 1)) == 0) {
                                    }
                                }
                            }
                            it.remove();
                        }
                        if (arrayList.size() != 0) {
                            C5922f.m23753a((List<C5912a>) arrayList);
                            C5808b.m23323a((List<C5912a>) arrayList);
                        }
                    }
                };
                try {
                    String a = C6166a.m24467a(str4, hashMap);
                    C5264a.m21617a("服务端返回未读消息的 json", a);
                    JSONObject a2 = C5366b.m22027a(a);
                    if (a2.getInt(str2) == 200) {
                        r3.mo29413a(a2.getJSONArray(ArgKey.KEY_RESULT));
                    } else {
                        r3.mo29412a(a2.getInt(str2));
                    }
                } catch (C6167b e) {
                    e = e;
                    StringBuilder sb2 = new StringBuilder(str3);
                    sb2.append(str4);
                    sb = sb2.toString();
                    str = "YSFHttpClient.httpGet失败";
                    C5264a.m21619a(str, sb, e);
                } catch (JSONException e2) {
                    e = e2;
                    StringBuilder sb3 = new StringBuilder(str3);
                    sb3.append(str4);
                    sb = sb3.toString();
                    str = "解析未读消息 json 失败";
                    C5264a.m21619a(str, sb, e);
                }
            }
        }).start();
    }

    /* renamed from: a */
    public static synchronized void m24658a(Boolean bool) {
        synchronized (C6221h.class) {
            C6014b.m23925a(Boolean.valueOf(false));
            m24656a();
            if (bool.booleanValue()) {
                new Handler().postDelayed(new Runnable() {
                    public final void run() {
                        if (!C6014b.m23967k().booleanValue()) {
                            C6221h.m24656a();
                        }
                    }
                }, 5000);
            }
        }
    }
}
