package com.tencent.android.tpush.p581c;

import android.content.Context;
import android.content.Intent;
import com.tencent.android.tpush.common.C6905e;
import com.tencent.android.tpush.common.C6907g;
import com.tencent.android.tpush.common.C6908h;
import com.tencent.android.tpush.common.Constants;
import com.tencent.android.tpush.common.MessageKey;
import com.tencent.android.tpush.data.CachedMessageIntent;
import com.tencent.android.tpush.data.MessageId;
import com.tencent.android.tpush.encrypt.Rijndael;
import com.tencent.android.tpush.p580b.C6864a;
import com.tencent.android.tpush.p586e.C6929a;
import com.tencent.android.tpush.service.cache.CacheManager;
import com.tencent.android.tpush.service.p595e.C7056i;
import com.tencent.mid.sotrage.StorageInterface;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* compiled from: ProGuard */
/* renamed from: com.tencent.android.tpush.c.c */
public class C6871c {
    /* renamed from: a */
    private static C6871c f22865a = new C6871c();
    /* renamed from: b */
    private static final byte[] f22866b = new byte[0];

    private C6871c() {
    }

    /* renamed from: a */
    public static C6871c m29327a() {
        return f22865a;
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0016  */
    /* renamed from: a */
    public java.util.ArrayList<com.tencent.android.tpush.data.MessageId> mo33007a(android.content.Context r2, java.lang.String r3) {
        /*
        r1 = this;
        if (r2 == 0) goto L_0x0013
        boolean r0 = com.tencent.android.tpush.service.p595e.C7056i.m30194b(r3)
        if (r0 != 0) goto L_0x0013
        java.lang.String r0 = ".tpns.msg.id"
        java.lang.Object r2 = r1.m29328a(r2, r3, r0)
        if (r2 == 0) goto L_0x0013
        java.util.ArrayList r2 = (java.util.ArrayList) r2
        goto L_0x0014
    L_0x0013:
        r2 = 0
    L_0x0014:
        if (r2 != 0) goto L_0x001b
        java.util.ArrayList r2 = new java.util.ArrayList
        r2.<init>()
    L_0x001b:
        return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.android.tpush.p581c.C6871c.mo33007a(android.content.Context, java.lang.String):java.util.ArrayList");
    }

    /* renamed from: a */
    public void mo33012a(Context context, String str, ArrayList<MessageId> arrayList) {
        synchronized (f22866b) {
            if (!(context == null || arrayList == null)) {
                m29329a(context, str, ".tpns.msg.id", arrayList);
            }
        }
    }

    /* renamed from: a */
    public ArrayList<Intent> mo33006a(Context context) {
        if (context != null) {
            return C6929a.m29590c(context);
        }
        return null;
    }

    /* renamed from: a */
    public void mo33009a(Context context, Intent intent) {
        if (context != null) {
            C6929a.m29587a(context, intent);
        }
    }

    /* renamed from: b */
    public void mo33014b(Context context) {
        if (context != null) {
            C6929a.m29584a(context);
        }
    }

    /* renamed from: a */
    public void mo33008a(Context context, long j) {
        if (context != null) {
            C6929a.m29596f(context, j);
        }
    }

    /* renamed from: b */
    public void mo33015b(Context context, long j) {
        if (context != null) {
            C6929a.m29595e(context, j);
        }
    }

    /* renamed from: c */
    public void mo33021c(Context context, long j) {
        if (context != null) {
            C6929a.m29585a(context, j);
        }
    }

    /* renamed from: d */
    public void mo33024d(Context context, long j) {
        if (context != null) {
            C6929a.m29589b(context, j);
        }
    }

    /* renamed from: e */
    public void mo33026e(Context context, long j) {
        if (context != null) {
            C6929a.m29591c(context, j);
        }
    }

    /* renamed from: f */
    public void mo33027f(Context context, long j) {
        if (context != null) {
            C6929a.m29593d(context, j);
        }
    }

    /* renamed from: c */
    public void mo33020c(Context context) {
        if (context != null) {
            C6929a.m29588b(context);
        }
    }

    /* renamed from: a */
    public void mo33011a(Context context, String str, MessageId messageId) {
        synchronized (f22866b) {
            if (context != null) {
                if (!C7056i.m30194b(str) && messageId != null) {
                    ArrayList a = mo33007a(context, str);
                    if (a == null) {
                        a = new ArrayList();
                    } else {
                        int i = 0;
                        while (true) {
                            if (i >= a.size()) {
                                break;
                            } else if (((MessageId) a.get(i)).f23015id == messageId.f23015id) {
                                a.remove(i);
                                break;
                            } else {
                                i++;
                            }
                        }
                    }
                    a.add(messageId);
                    mo33012a(context, str, a);
                }
            }
        }
    }

    /* renamed from: a */
    public MessageId mo33005a(Context context, String str, long j) {
        if (context != null && !C7056i.m30194b(str) && j > 0) {
            ArrayList<MessageId> a = mo33007a(context, str);
            if (a != null && a.size() > 0) {
                for (MessageId messageId : a) {
                    if (messageId.f23015id == j) {
                        return messageId;
                    }
                }
            }
        }
        return null;
    }

    /* renamed from: b */
    public boolean mo33018b(Context context, String str, long j) {
        if (context != null && !C7056i.m30194b(str) && j > 0) {
            ArrayList<MessageId> a = mo33007a(context, str);
            if (a != null && a.size() > 0) {
                for (MessageId messageId : a) {
                    if (messageId.f23015id == j) {
                        return messageId.isMsgAcked();
                    }
                }
            }
        }
        return false;
    }

    /* renamed from: b */
    public void mo33016b(Context context, String str) {
        String str2 = "MessageManager";
        try {
            JSONObject jSONObject = new JSONObject(str);
            int optInt = jSONObject.optInt("action", 2);
            if (optInt == 1) {
                for (String valueOf : jSONObject.optString("pushIdList", "").split(StorageInterface.KEY_SPLITER)) {
                    mo33008a(context, Long.valueOf(valueOf).longValue());
                }
            } else if (optInt == 2) {
                mo33014b(context);
            } else if (optInt == 3) {
                int optInt2 = jSONObject.optInt("enabled", -1);
                StringBuilder sb = new StringBuilder();
                sb.append("setLogToFile with cmd = ");
                sb.append(optInt2);
                C6864a.m29305f(str2, sb.toString());
                C6864a.m29282a(optInt2);
            }
        } catch (Exception e) {
            C6864a.m29302d(str2, "onCrtlMsgHandle", e);
        }
    }

    /* renamed from: g */
    public static String m29330g(Context context, long j) {
        StringBuilder sb = new StringBuilder();
        String str = "";
        sb.append(str);
        StringBuilder sb2 = new StringBuilder();
        String str2 = "tpush_msgId_";
        sb2.append(str2);
        sb2.append(j);
        sb.append(C6908h.m29483a(context, sb2.toString(), str));
        String sb3 = sb.toString();
        if (sb3 == null || sb3.trim().length() == 0) {
            StringBuilder sb4 = new StringBuilder();
            sb4.append(str2);
            sb4.append(j);
            sb3 = C6907g.m29475a(context, sb4.toString(), true);
        }
        String substring = (sb3 == null || sb3.length() <= 20480) ? sb3 : sb3.substring(0, sb3.indexOf("@@", 5120));
        return substring != null ? substring : str;
    }

    /* renamed from: a */
    private void m29329a(Context context, String str, String str2, ArrayList<?> arrayList) {
        try {
            if (arrayList.size() > 50) {
                arrayList.subList(0, 10).clear();
            }
            String encrypt = Rijndael.encrypt(C6905e.m29468a((Serializable) arrayList));
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append(str2);
            C6908h.m29487b(context, sb.toString(), encrypt);
        } catch (Exception e) {
            C6864a.m29302d("MessageManager", "putSettings", e);
        }
    }

    /* renamed from: a */
    private Object m29328a(Context context, String str, String str2) {
        try {
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append(str2);
            return C6905e.m29467a(Rijndael.decrypt(C6908h.m29483a(context, sb.toString(), (String) null)));
        } catch (Exception e) {
            C6864a.m29302d("MessageManager", "getSettings", e);
            return null;
        }
    }

    /* renamed from: d */
    public ArrayList<CachedMessageIntent> mo33023d(Context context) {
        if (context != null) {
            List<String> registerInfos = CacheManager.getRegisterInfos(context);
            if (registerInfos != null && registerInfos.size() > 0) {
                ArrayList<CachedMessageIntent> arrayList = new ArrayList<>();
                for (String c : registerInfos) {
                    ArrayList c2 = mo33019c(context, c);
                    if (c2 != null && c2.size() > 0) {
                        arrayList.addAll(c2);
                    }
                }
                return arrayList;
            }
        }
        return null;
    }

    /* renamed from: c */
    public ArrayList<CachedMessageIntent> mo33019c(Context context, String str) {
        ArrayList<CachedMessageIntent> arrayList = null;
        if (context != null) {
            try {
                if (!C7056i.m30194b(str)) {
                    Object a = m29328a(context, str, ".tpns.msg.id.cached");
                    if (a != null) {
                        arrayList = (ArrayList) a;
                    }
                }
            } catch (Throwable unused) {
                return new ArrayList<>();
            }
        }
        if (arrayList == null) {
            return new ArrayList<>();
        }
        return arrayList;
    }

    /* renamed from: a */
    public void mo33010a(Context context, String str, Intent intent) {
        synchronized (f22866b) {
            if (context != null) {
                if (!C7056i.m30194b(str) && intent != null) {
                    CachedMessageIntent cachedMessageIntent = new CachedMessageIntent();
                    cachedMessageIntent.pkgName = str;
                    cachedMessageIntent.msgId = intent.getLongExtra(MessageKey.MSG_ID, -1);
                    cachedMessageIntent.intent = Rijndael.encrypt(intent.toUri(1));
                    ArrayList c = mo33019c(context, str);
                    if (c == null) {
                        c = new ArrayList();
                    } else {
                        ArrayList arrayList = new ArrayList();
                        for (int i = 0; i < c.size(); i++) {
                            CachedMessageIntent cachedMessageIntent2 = (CachedMessageIntent) c.get(i);
                            if (cachedMessageIntent2.equals(cachedMessageIntent)) {
                                arrayList.add(cachedMessageIntent2);
                            }
                        }
                        c.removeAll(arrayList);
                    }
                    if (c != null && c.size() > 45) {
                        int size = c.size() - 45;
                        if (size >= 0) {
                            StringBuilder sb = new StringBuilder();
                            sb.append("too much cache msg, try to cut ");
                            sb.append(size);
                            sb.append(" list.size: ");
                            sb.append(c.size());
                            C6864a.m29306g("MessageManager", sb.toString());
                            c.subList(0, size).clear();
                        }
                    }
                    c.add(cachedMessageIntent);
                    mo33017b(context, str, c);
                }
            }
        }
    }

    /* renamed from: b */
    public void mo33017b(Context context, String str, ArrayList<CachedMessageIntent> arrayList) {
        synchronized (f22866b) {
            if (!(context == null || arrayList == null)) {
                String str2 = Constants.ServiceLogTag;
                StringBuilder sb = new StringBuilder();
                sb.append("updateCachedMsgIntentByPkgName, size: ");
                sb.append(arrayList.size());
                C6864a.m29286a(str2, sb.toString());
                m29329a(context, str, ".tpns.msg.id.cached", arrayList);
            }
        }
    }

    /* renamed from: d */
    public void mo33025d(Context context, String str) {
        synchronized (f22866b) {
            if (context != null) {
                mo33017b(context, str, new ArrayList<>());
            }
        }
    }

    /* renamed from: c */
    public void mo33022c(Context context, String str, long j) {
        synchronized (f22866b) {
            if (context != null) {
                ArrayList c = mo33019c(context, str);
                if (c != null && c.size() > 0) {
                    ArrayList arrayList = new ArrayList();
                    for (int i = 0; i < c.size(); i++) {
                        CachedMessageIntent cachedMessageIntent = (CachedMessageIntent) c.get(i);
                        if (cachedMessageIntent.msgId == j) {
                            arrayList.add(cachedMessageIntent);
                        }
                    }
                    if (arrayList.size() == 0) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("deleteCachedMsgIntentByPkgName do not have MessageId = ");
                        sb.append(j);
                        C6864a.m29308i("MessageManager", sb.toString());
                    }
                    c.removeAll(arrayList);
                }
                mo33017b(context, str, c);
            }
        }
    }

    /* renamed from: a */
    public void mo33013a(Context context, List<CachedMessageIntent> list, ArrayList<CachedMessageIntent> arrayList) {
        synchronized (f22866b) {
            if (!(context == null || list == null)) {
                if (list.size() > 0) {
                    try {
                        ArrayList arrayList2 = new ArrayList();
                        if (arrayList != null && arrayList.size() > 0) {
                            HashMap hashMap = new HashMap();
                            for (int i = 0; i < arrayList.size(); i++) {
                                CachedMessageIntent cachedMessageIntent = (CachedMessageIntent) arrayList.get(i);
                                for (CachedMessageIntent cachedMessageIntent2 : list) {
                                    if (cachedMessageIntent.equals(cachedMessageIntent2)) {
                                        arrayList2.add(cachedMessageIntent);
                                        ArrayList arrayList3 = (ArrayList) hashMap.get(cachedMessageIntent2.pkgName);
                                        if (arrayList3 == null) {
                                            arrayList3 = new ArrayList();
                                        }
                                        hashMap.put(cachedMessageIntent2.pkgName, arrayList3);
                                    }
                                }
                            }
                            arrayList.removeAll(arrayList2);
                            Iterator it = arrayList.iterator();
                            while (it.hasNext()) {
                                CachedMessageIntent cachedMessageIntent3 = (CachedMessageIntent) it.next();
                                ArrayList arrayList4 = (ArrayList) hashMap.get(cachedMessageIntent3.pkgName);
                                if (arrayList4 == null) {
                                    arrayList4 = new ArrayList();
                                }
                                arrayList4.add(cachedMessageIntent3);
                                hashMap.put(cachedMessageIntent3.pkgName, arrayList4);
                            }
                            for (String str : hashMap.keySet()) {
                                mo33017b(context, str, (ArrayList) hashMap.get(str));
                            }
                        }
                    } catch (Exception e) {
                        C6864a.m29302d("MessageManager", "deleteCachedMsgIntent", e);
                    }
                }
            }
        }
    }
}
