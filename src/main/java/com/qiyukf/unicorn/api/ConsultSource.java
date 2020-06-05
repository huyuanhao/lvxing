package com.qiyukf.unicorn.api;

import com.qiyukf.unicorn.api.lifecycle.SessionLifeCycleOptions;
import com.qiyukf.unicorn.api.pop.SessionListEntrance;
import com.qiyukf.unicorn.api.pop.ShopEntrance;
import java.io.Serializable;
import java.util.ArrayList;

public class ConsultSource implements Serializable {
    public String VIPStaffAvatarUrl;
    public String custom;
    public long faqGroupId;
    public long groupId;
    public boolean isSendProductonRobot;
    public ProductDetail productDetail;
    public String prompt;
    public ArrayList<QuickEntry> quickEntryList;
    public boolean robotFirst;
    public long robotId;
    public SessionLifeCycleOptions sessionLifeCycleOptions;
    public SessionListEntrance sessionListEntrance;
    public ShopEntrance shopEntrance;
    public String shopId;
    public long staffId;
    public String title;
    public String uri;
    public int vipLevel;
    public String vipStaffName;
    public String vipStaffWelcomeMsg;
    public String vipStaffid;

    public ConsultSource(String str, String str2, String str3) {
        this.uri = str;
        this.title = str2;
        this.custom = str3;
    }
}
