package com.qiyukf.nimlib.sdk.msg.attachment;

import android.content.Context;
import com.qiyukf.basesdk.p412c.C5366b;
import com.qiyukf.unicorn.C5961R;
import com.qiyukf.unicorn.api.msg.attachment.MsgAttachment;
import org.json.JSONObject;

public class LocationAttachment implements MsgAttachment {
    private static final String KEY_DESC = "title";
    private static final String KEY_LATITUDE = "lat";
    private static final String KEY_LONGITUDE = "lng";
    private String address;
    private double latitude;
    private double longitude;

    public LocationAttachment() {
    }

    public LocationAttachment(String str) {
        fromJson(str);
    }

    private void fromJson(String str) {
        JSONObject a = C5366b.m22027a(str);
        this.latitude = C5366b.m22038d(a, KEY_LATITUDE);
        this.longitude = C5366b.m22038d(a, KEY_LONGITUDE);
        this.address = C5366b.m22039e(a, "title");
    }

    public boolean countToUnread() {
        return true;
    }

    public String getAddress() {
        return this.address;
    }

    public String getContent(Context context) {
        return context.getString(C5961R.string.ysf_msg_notify_location);
    }

    public double getLatitude() {
        return this.latitude;
    }

    public double getLongitude() {
        return this.longitude;
    }

    public void setAddress(String str) {
        this.address = str;
    }

    public void setLatitude(double d) {
        this.latitude = d;
    }

    public void setLongitude(double d) {
        this.longitude = d;
    }

    public String toJson(boolean z) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(KEY_LATITUDE, this.latitude);
            jSONObject.put(KEY_LONGITUDE, this.longitude);
            jSONObject.put("title", this.address);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }
}
