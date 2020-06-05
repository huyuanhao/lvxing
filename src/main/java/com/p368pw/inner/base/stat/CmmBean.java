package com.p368pw.inner.base.stat;

import iko.dmaz.lloq.Schema;
import iko.dmaz.lloq.SyncField;

@Schema(mo38797a = "ods_publish", mo38798b = "ods_publish_domestic_sdk_adv_action", mo38799c = 13)
/* renamed from: com.pw.inner.base.stat.CmmBean */
public class CmmBean {
    @SyncField(mo38800a = true, mo38801b = 44)
    private String ad_package;
    @SyncField(mo38800a = true, mo38801b = 45)
    private String ad_package_name;
    @SyncField(mo38800a = true, mo38801b = 36)
    private Integer ad_template_type;
    @SyncField(mo38800a = true, mo38801b = 52)
    private String ad_template_url;
    @SyncField(mo38800a = true, mo38801b = 37)
    private String ads_purpose;
    @SyncField(mo38800a = true, mo38801b = 25)
    private Integer ads_source;
    @SyncField(mo38801b = 3)
    private String android_id;
    @SyncField(mo38801b = 5)
    private String appkey;
    @SyncField(mo38801b = 43)
    private Double award_amount;
    @SyncField(mo38800a = true, mo38801b = 28)
    private Integer business_id;
    @SyncField(mo38800a = true, mo38801b = 6)
    private String channel_code;
    @SyncField(mo38800a = true, mo38801b = 18)
    private String city;
    @SyncField(mo38800a = true, mo38801b = 31)
    private Integer conf_id;
    @SyncField(mo38800a = true, mo38801b = 7)
    private String country_code_client;
    @SyncField(mo38801b = 2)
    private String create_date;
    @SyncField(mo38801b = 1)
    private Integer data_version;
    @SyncField(mo38800a = true, mo38801b = 15)
    private String dynamic_info;
    @SyncField(mo38800a = true, mo38801b = 40)
    private String end_template_type;
    @SyncField(mo38800a = true, mo38801b = 23)
    private String error_msg;
    @SyncField(mo38801b = 51)
    private String event_info;
    @SyncField(mo38801b = 21)
    private Integer event_type;
    @SyncField(mo38800a = true, mo38801b = 29)
    private Integer group_id;
    @SyncField(mo38800a = true, mo38801b = 46)
    private String image_url;
    @SyncField(mo38800a = true, mo38801b = 16)
    private String imei_id;
    @SyncField(mo38800a = true, mo38801b = 47)
    private String install_source_name;
    @SyncField(mo38800a = true, mo38801b = 48)
    private Integer install_source_type;
    @SyncField(mo38800a = true, mo38801b = 27)
    private String inter_placement_id;
    @SyncField(mo38800a = true, mo38801b = 8)
    private String language;
    @SyncField(mo38800a = true, mo38801b = 20)
    private String latitude;
    @SyncField(mo38801b = 4)
    private String log_time;
    @SyncField(mo38800a = true, mo38801b = 19)
    private String longitude;
    @SyncField(mo38800a = true, mo38801b = 38)
    private String oa_id;
    @SyncField(mo38800a = true, mo38801b = 39)
    private String order_id;
    @SyncField(mo38800a = true, mo38801b = 9)
    private String os_version_code;
    @SyncField(mo38800a = true, mo38801b = 10)
    private String os_version_name;
    @SyncField(mo38800a = true, mo38801b = 26)
    private String placement_id;
    @SyncField(mo38801b = 35)
    private String placement_type;
    @SyncField(mo38800a = true, mo38801b = 30)
    private Integer plan_id;
    @SyncField(mo38800a = true, mo38801b = 11)
    private String product_version_code;
    @SyncField(mo38800a = true, mo38801b = 12)
    private String product_version_name;
    @SyncField(mo38800a = true, mo38801b = 17)
    private String province;
    @SyncField(mo38800a = true, mo38801b = 24)
    private String remark;
    @SyncField(mo38801b = 34)
    private String request_id;
    @SyncField(mo38800a = true, mo38801b = 22)
    private Integer result;
    @SyncField(mo38800a = true, mo38801b = 50)
    private Integer retention_status;
    @SyncField(mo38800a = true, mo38801b = 41)
    private String retention_template_type;
    @SyncField(mo38800a = true, mo38801b = 13)
    private String sdk_version_code;
    @SyncField(mo38800a = true, mo38801b = 14)
    private String sdk_version_name;
    @SyncField(mo38801b = 0)
    private Integer service_version;
    @SyncField(mo38801b = 42)
    private Integer task_source;
    @SyncField(mo38800a = true, mo38801b = 49)
    private Integer task_type;
    @SyncField(mo38801b = 32)
    /* renamed from: uk */
    private String f16940uk;
    @SyncField(mo38800a = true, mo38801b = 33)
    private Integer vf_time;

    public String getAd_template_url() {
        return this.ad_template_url;
    }

    public void setAd_package(String str) {
        this.ad_package = str;
    }

    public void setAd_package_name(String str) {
        this.ad_package_name = str;
    }

    public void setAd_template_type(Integer num) {
        this.ad_template_type = num;
    }

    public CmmBean setAd_template_url(String str) {
        this.ad_template_url = str;
        return this;
    }

    public void setAds_purpose(String str) {
        this.ads_purpose = str;
    }

    public void setAds_source(Integer num) {
        this.ads_source = num;
    }

    public void setAndroid_id(String str) {
        this.android_id = str;
    }

    public void setAppkey(String str) {
        this.appkey = str;
    }

    public void setAward_amount(Double d) {
        this.award_amount = d;
    }

    public void setBusiness_id(Integer num) {
        this.business_id = num;
    }

    public void setChannel_code(String str) {
        this.channel_code = str;
    }

    public void setCity(String str) {
        this.city = str;
    }

    public void setConf_id(Integer num) {
        this.conf_id = num;
    }

    public void setCountry_code_client(String str) {
        this.country_code_client = str;
    }

    public void setCreate_date(String str) {
        this.create_date = str;
    }

    public void setData_version(Integer num) {
        this.data_version = num;
    }

    public void setDynamic_info(String str) {
        this.dynamic_info = str;
    }

    public void setEnd_template_type(String str) {
        this.end_template_type = str;
    }

    public void setError_msg(String str) {
        this.error_msg = str;
    }

    public void setEvent_info(String str) {
        this.event_info = str;
    }

    public void setEvent_type(Integer num) {
        this.event_type = num;
    }

    public void setGroup_id(Integer num) {
        this.group_id = num;
    }

    public void setImage_url(String str) {
        this.image_url = str;
    }

    public void setImei_id(String str) {
        this.imei_id = str;
    }

    public void setInstall_source_name(String str) {
        this.install_source_name = str;
    }

    public void setInstall_source_type(Integer num) {
        this.install_source_type = num;
    }

    public void setInter_placement_id(String str) {
        this.inter_placement_id = str;
    }

    public void setLanguage(String str) {
        this.language = str;
    }

    public void setLatitude(String str) {
        this.latitude = str;
    }

    public void setLog_time(String str) {
        this.log_time = str;
    }

    public void setLongitude(String str) {
        this.longitude = str;
    }

    public void setOa_id(String str) {
        this.oa_id = str;
    }

    public void setOrder_id(String str) {
        this.order_id = str;
    }

    public void setOs_version_code(String str) {
        this.os_version_code = str;
    }

    public void setOs_version_name(String str) {
        this.os_version_name = str;
    }

    public void setPlacement_id(String str) {
        this.placement_id = str;
    }

    public void setPlacement_type(String str) {
        this.placement_type = str;
    }

    public void setPlan_id(Integer num) {
        this.plan_id = num;
    }

    public void setProduct_version_code(String str) {
        this.product_version_code = str;
    }

    public void setProduct_version_name(String str) {
        this.product_version_name = str;
    }

    public void setProvince(String str) {
        this.province = str;
    }

    public void setRemark(String str) {
        this.remark = str;
    }

    public void setRequest_id(String str) {
        this.request_id = str;
    }

    public void setResult(Integer num) {
        this.result = num;
    }

    public void setRetention_status(Integer num) {
        this.retention_status = num;
    }

    public void setRetention_template_type(String str) {
        this.retention_template_type = str;
    }

    public void setSdk_version_code(String str) {
        this.sdk_version_code = str;
    }

    public void setSdk_version_name(String str) {
        this.sdk_version_name = str;
    }

    public void setService_version(Integer num) {
        this.service_version = num;
    }

    public void setTask_source(Integer num) {
        this.task_source = num;
    }

    public void setTask_type(Integer num) {
        this.task_type = num;
    }

    public void setUk(String str) {
        this.f16940uk = str;
    }

    public void setVf_time(Integer num) {
        this.vf_time = num;
    }
}
