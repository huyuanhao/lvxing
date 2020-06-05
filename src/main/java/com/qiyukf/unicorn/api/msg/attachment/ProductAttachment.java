package com.qiyukf.unicorn.api.msg.attachment;

import android.content.Context;
import android.text.TextUtils;
import com.qiyukf.basesdk.p412c.C5366b;
import com.qiyukf.unicorn.api.ProductDetail;
import com.qiyukf.unicorn.api.ProductDetail.Tag;
import com.qiyukf.unicorn.api.msg.ProductReslectOnclickListener;
import com.qiyukf.unicorn.p503f.p504a.C6144e;
import com.qiyukf.unicorn.p503f.p504a.p508b.C6110a;
import com.qiyukf.unicorn.p503f.p504a.p508b.C6111b;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

@C6111b(mo29052a = 121)
public class ProductAttachment extends C6144e implements Cloneable {
    @C6110a(mo29051a = "actionText")
    private String actionText;
    @C6110a(mo29051a = "actionTextColor")
    private int actionTextColor;
    @C6110a(mo29051a = "activity")
    private String activity;
    @C6110a(mo29051a = "activityHref")
    private String activityHref;
    @C6110a(mo29051a = "auto")
    private int auto;
    @C6110a(mo29051a = "desc")
    private String desc;
    @C6110a(mo29051a = "ext")
    private String ext;
    private String handlerTag;
    private boolean isOpenReselect;
    @C6110a(mo29051a = "note")
    private String note;
    @C6110a(mo29051a = "orderCount")
    private String orderCount;
    @C6110a(mo29051a = "orderId")
    private String orderID;
    @C6110a(mo29051a = "orderSku")
    private String orderSku;
    @C6110a(mo29051a = "orderStatus")
    private String orderStatus;
    @C6110a(mo29051a = "orderTime")
    private String orderTime;
    @C6110a(mo29051a = "payMoney")
    private String payMoney;
    @C6110a(mo29051a = "picture")
    private String picture;
    @C6110a(mo29051a = "price")
    private String price;
    private ProductReslectOnclickListener productReslectOnclickListener;
    private String reselectText;
    @C6110a(mo29051a = "sendByUser")
    private int sendByUser;
    @C6110a(mo29051a = "show")
    private int show;
    @C6110a(mo29051a = "tags")
    private JSONArray tags;
    @C6110a(mo29051a = "template")
    private String template;
    @C6110a(mo29051a = "title")
    private String title;
    @C6110a(mo29051a = "url")
    private String url;

    private static JSONArray fromTag(List<Tag> list) {
        JSONArray jSONArray = new JSONArray();
        for (Tag tag : list) {
            JSONObject jSONObject = new JSONObject();
            C5366b.m22032a(jSONObject, "label", tag.getLabel());
            C5366b.m22032a(jSONObject, "url", tag.getUrl());
            C5366b.m22032a(jSONObject, "focusIframe", tag.getFocusIframe());
            C5366b.m22032a(jSONObject, "data", tag.getData());
            C5366b.m22028a(jSONArray, (Object) jSONObject);
        }
        return jSONArray;
    }

    public final ProductAttachment clone() {
        try {
            return (ProductAttachment) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void fromProductDetail(ProductDetail productDetail, boolean z) {
        JSONArray fromTag;
        setTitle(productDetail.getTitle());
        setDesc(productDetail.getDesc());
        setPicture(productDetail.getPicture());
        setUrl(productDetail.getUrl());
        setNote(productDetail.getNote());
        setShow(productDetail.getShow());
        setExt(productDetail.getExt());
        setActionText(productDetail.getActionText());
        setActionTextColor(productDetail.getActionTextColor());
        setSendByUser(productDetail.isSendByUser());
        setHandlerTag(productDetail.getHandlerTag());
        setReselectText(productDetail.getReselectText());
        setOpenReselect(productDetail.isOpenReselect());
        setProductReslectOnclickListener(productDetail.getProductReslectOnclickListener());
        if (productDetail.isOpenTemplate()) {
            setTemplate("pictureLink");
        }
        if (!TextUtils.isEmpty(productDetail.getTagString())) {
            fromTag = C5366b.m22035b(productDetail.getTagString());
        } else {
            if (productDetail.getTags() != null && productDetail.getTags().size() > 0) {
                fromTag = fromTag(productDetail.getTags());
            }
            this.auto = z;
        }
        this.tags = fromTag;
        this.auto = z;
    }

    public String getActionText() {
        return this.actionText;
    }

    public int getActionTextColor() {
        return this.actionTextColor;
    }

    public String getActivity() {
        return this.activity;
    }

    public String getActivityHref() {
        return this.activityHref;
    }

    public int getAuto() {
        return this.auto;
    }

    public String getContent(Context context) {
        return this.url;
    }

    public String getDesc() {
        return this.desc;
    }

    public String getExt() {
        return this.ext;
    }

    public String getHandlerTag() {
        return this.handlerTag;
    }

    public String getNote() {
        return this.note;
    }

    public String getOrderCount() {
        return this.orderCount;
    }

    public String getOrderID() {
        return this.orderID;
    }

    public String getOrderSku() {
        return this.orderSku;
    }

    public String getOrderStatus() {
        return this.orderStatus;
    }

    public String getOrderTime() {
        return this.orderTime;
    }

    public String getPayMoney() {
        return this.payMoney;
    }

    public String getPicture() {
        return this.picture;
    }

    public String getPrice() {
        return this.price;
    }

    public ProductReslectOnclickListener getProductReslectOnclickListener() {
        return this.productReslectOnclickListener;
    }

    public String getReselectText() {
        return this.reselectText;
    }

    public int getSendByUser() {
        return this.sendByUser;
    }

    public int getShow() {
        return this.show;
    }

    public JSONArray getTags() {
        return this.tags;
    }

    public String getTemplate() {
        return this.template;
    }

    public String getTitle() {
        return this.title;
    }

    public String getUrl() {
        return this.url;
    }

    public boolean isOpenReselect() {
        return this.isOpenReselect;
    }

    public void setActionText(String str) {
        this.actionText = str;
    }

    public void setActionTextColor(int i) {
        this.actionTextColor = i;
    }

    public void setActivity(String str) {
        this.activity = str;
    }

    public void setActivityHref(String str) {
        this.activityHref = str;
    }

    public void setAuto(int i) {
        this.auto = i;
    }

    public void setDesc(String str) {
        this.desc = str;
    }

    public void setExt(String str) {
        this.ext = str;
    }

    public void setHandlerTag(String str) {
        this.handlerTag = str;
    }

    public void setNote(String str) {
        this.note = str;
    }

    public void setOpenReselect(boolean z) {
        this.isOpenReselect = z;
    }

    public void setOrderCount(String str) {
        this.orderCount = str;
    }

    public void setOrderID(String str) {
        this.orderID = str;
    }

    public void setOrderSku(String str) {
        this.orderSku = str;
    }

    public void setOrderStatus(String str) {
        this.orderStatus = str;
    }

    public void setOrderTime(String str) {
        this.orderTime = str;
    }

    public void setPayMoney(String str) {
        this.payMoney = str;
    }

    public void setPicture(String str) {
        this.picture = str;
    }

    public void setPrice(String str) {
        this.price = str;
    }

    public void setProductReslectOnclickListener(ProductReslectOnclickListener productReslectOnclickListener2) {
        this.productReslectOnclickListener = productReslectOnclickListener2;
    }

    public void setReselectText(String str) {
        this.reselectText = str;
    }

    public void setSendByUser(int i) {
        this.sendByUser = i;
    }

    public void setShow(int i) {
        this.show = i;
    }

    public void setTags(JSONArray jSONArray) {
        this.tags = jSONArray;
    }

    public void setTemplate(String str) {
        this.template = str;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public void setUrl(String str) {
        this.url = str;
    }
}
