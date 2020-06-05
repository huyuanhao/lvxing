package com.tencent.p607mm.opensdk.modelbiz;

import android.os.Bundle;
import com.tencent.p607mm.opensdk.modelbase.BaseReq;
import com.tencent.p607mm.opensdk.modelbase.BaseResp;
import com.tencent.p607mm.opensdk.utils.Log;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONStringer;
import org.json.JSONTokener;

/* renamed from: com.tencent.mm.opensdk.modelbiz.AddCardToWXCardPackage */
public class AddCardToWXCardPackage {
    private static final String TAG = "MicroMsg.AddCardToWXCardPackage";

    /* renamed from: com.tencent.mm.opensdk.modelbiz.AddCardToWXCardPackage$Req */
    public static class Req extends BaseReq {
        public List<WXCardItem> cardArrary;

        public boolean checkArgs() {
            List<WXCardItem> list = this.cardArrary;
            if (list == null || list.size() == 0 || this.cardArrary.size() > 40) {
                return false;
            }
            for (WXCardItem wXCardItem : this.cardArrary) {
                if (wXCardItem == null || wXCardItem.cardId == null || wXCardItem.cardId.length() > 1024 || (wXCardItem.cardExtMsg != null && wXCardItem.cardExtMsg.length() > 1024)) {
                    return false;
                }
            }
            return true;
        }

        public int getType() {
            return 9;
        }

        public void toBundle(Bundle bundle) {
            super.toBundle(bundle);
            JSONStringer jSONStringer = new JSONStringer();
            try {
                jSONStringer.object();
                jSONStringer.key("card_list");
                jSONStringer.array();
                for (WXCardItem wXCardItem : this.cardArrary) {
                    jSONStringer.object();
                    jSONStringer.key("card_id");
                    jSONStringer.value(wXCardItem.cardId);
                    jSONStringer.key("card_ext");
                    jSONStringer.value(wXCardItem.cardExtMsg == null ? "" : wXCardItem.cardExtMsg);
                    jSONStringer.endObject();
                }
                jSONStringer.endArray();
                jSONStringer.endObject();
            } catch (Exception e) {
                StringBuilder sb = new StringBuilder("Req.toBundle exception:");
                sb.append(e.getMessage());
                Log.m31627e(AddCardToWXCardPackage.TAG, sb.toString());
            }
            bundle.putString("_wxapi_add_card_to_wx_card_list", jSONStringer.toString());
        }
    }

    /* renamed from: com.tencent.mm.opensdk.modelbiz.AddCardToWXCardPackage$Resp */
    public static class Resp extends BaseResp {
        public List<WXCardItem> cardArrary;

        public Resp() {
        }

        public Resp(Bundle bundle) {
            fromBundle(bundle);
        }

        public boolean checkArgs() {
            List<WXCardItem> list = this.cardArrary;
            return (list == null || list.size() == 0) ? false : true;
        }

        public void fromBundle(Bundle bundle) {
            super.fromBundle(bundle);
            if (this.cardArrary == null) {
                this.cardArrary = new LinkedList();
            }
            String string = bundle.getString("_wxapi_add_card_to_wx_card_list");
            if (string != null && string.length() > 0) {
                try {
                    JSONArray jSONArray = ((JSONObject) new JSONTokener(string).nextValue()).getJSONArray("card_list");
                    for (int i = 0; i < jSONArray.length(); i++) {
                        JSONObject jSONObject = jSONArray.getJSONObject(i);
                        WXCardItem wXCardItem = new WXCardItem();
                        wXCardItem.cardId = jSONObject.optString("card_id");
                        wXCardItem.cardExtMsg = jSONObject.optString("card_ext");
                        wXCardItem.cardState = jSONObject.optInt("is_succ");
                        this.cardArrary.add(wXCardItem);
                    }
                } catch (Exception unused) {
                }
            }
        }

        public int getType() {
            return 9;
        }

        public void toBundle(Bundle bundle) {
            super.toBundle(bundle);
            JSONStringer jSONStringer = new JSONStringer();
            try {
                jSONStringer.object();
                jSONStringer.key("card_list");
                jSONStringer.array();
                for (WXCardItem wXCardItem : this.cardArrary) {
                    jSONStringer.object();
                    jSONStringer.key("card_id");
                    jSONStringer.value(wXCardItem.cardId);
                    jSONStringer.key("card_ext");
                    jSONStringer.value(wXCardItem.cardExtMsg == null ? "" : wXCardItem.cardExtMsg);
                    jSONStringer.key("is_succ");
                    jSONStringer.value((long) wXCardItem.cardState);
                    jSONStringer.endObject();
                }
                jSONStringer.endArray();
                jSONStringer.endObject();
            } catch (Exception e) {
                StringBuilder sb = new StringBuilder("Resp.toBundle exception:");
                sb.append(e.getMessage());
                Log.m31627e(AddCardToWXCardPackage.TAG, sb.toString());
            }
            bundle.putString("_wxapi_add_card_to_wx_card_list", jSONStringer.toString());
        }
    }

    /* renamed from: com.tencent.mm.opensdk.modelbiz.AddCardToWXCardPackage$WXCardItem */
    public static final class WXCardItem {
        public String cardExtMsg;
        public String cardId;
        public int cardState;
    }
}
