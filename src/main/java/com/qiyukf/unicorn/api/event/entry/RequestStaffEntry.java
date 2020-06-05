package com.qiyukf.unicorn.api.event.entry;

import com.qiyukf.unicorn.api.ProductDetail;

public class RequestStaffEntry {
    private String custom;
    private long entryId;
    private long faqGroupId;
    private long groupId;
    private boolean isHumanOnly;
    private boolean isRobot;
    private boolean isTransfar;
    private String label;
    private ProductDetail productDetail;
    private boolean robotFirst;
    private long robotId;
    private int scenes;
    private String shopId;
    private long staffId;
    private String title;
    private String uri;
    public int vipLevel;

    public String getCustom() {
        return this.custom;
    }

    public long getEntryId() {
        return this.entryId;
    }

    public long getFaqGroupId() {
        return this.faqGroupId;
    }

    public long getGroupId() {
        return this.groupId;
    }

    public String getLabel() {
        return this.label;
    }

    public ProductDetail getProductDetail() {
        return this.productDetail;
    }

    public long getRobotId() {
        return this.robotId;
    }

    public int getScenes() {
        return this.scenes;
    }

    public String getShopId() {
        return this.shopId;
    }

    public long getStaffId() {
        return this.staffId;
    }

    public String getTitle() {
        return this.title;
    }

    public String getUri() {
        return this.uri;
    }

    public int getVipLevel() {
        return this.vipLevel;
    }

    public boolean isHumanOnly() {
        return this.isHumanOnly;
    }

    public boolean isRobot() {
        return this.isRobot;
    }

    public boolean isRobotFirst() {
        return this.robotFirst;
    }

    public boolean isTransfar() {
        return this.isTransfar;
    }

    public void setCustom(String str) {
        this.custom = str;
    }

    public void setEntryId(long j) {
        this.entryId = j;
    }

    public void setFaqGroupId(long j) {
        this.faqGroupId = j;
    }

    public void setGroupId(long j) {
        this.groupId = j;
    }

    public void setHumanOnly(boolean z) {
        this.isHumanOnly = z;
    }

    public void setLabel(String str) {
        this.label = str;
    }

    public void setProductDetail(ProductDetail productDetail2) {
        this.productDetail = productDetail2;
    }

    public void setRobot(boolean z) {
        this.isRobot = z;
    }

    public void setRobotFirst(boolean z) {
        this.robotFirst = z;
    }

    public void setRobotId(long j) {
        this.robotId = j;
    }

    public void setScenes(int i) {
        this.scenes = i;
    }

    public void setShopId(String str) {
        this.shopId = str;
    }

    public void setStaffId(long j) {
        this.staffId = j;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public void setTransfar(boolean z) {
        this.isTransfar = z;
    }

    public void setUri(String str) {
        this.uri = str;
    }

    public void setVipLevel(int i) {
        this.vipLevel = i;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("scenes:");
        sb.append(getScenes());
        sb.append("isHumanOnly:");
        sb.append(isHumanOnly());
        sb.append("isRobot:");
        sb.append(this.isRobot);
        sb.append("label");
        sb.append(getLabel());
        sb.append("entryId:");
        sb.append(getEntryId());
        sb.append("shopId:");
        sb.append(getShopId());
        sb.append("uri:");
        sb.append(getUri());
        sb.append("title:");
        sb.append(getTitle());
        sb.append("custom:");
        sb.append(getCustom());
        sb.append("groupId:");
        sb.append(getGroupId());
        sb.append("staffId:");
        sb.append(getStaffId());
        sb.append("robotFirst:");
        sb.append(isRobotFirst());
        sb.append("robotId:");
        sb.append(getRobotId());
        sb.append("faqGroupId:");
        sb.append(getFaqGroupId());
        sb.append("isTransfa");
        sb.append(this.isTransfar);
        return sb.toString();
    }
}
