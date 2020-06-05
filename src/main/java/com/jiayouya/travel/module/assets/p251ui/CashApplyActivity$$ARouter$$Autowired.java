package com.jiayouya.travel.module.assets.p251ui;

import com.alibaba.android.arouter.facade.service.SerializationService;
import com.alibaba.android.arouter.facade.template.ISyringe;
import com.alibaba.android.arouter.p043a.ARouter;
import com.jiayouya.travel.module.assets.data.CashApplyRsp;

/* renamed from: com.jiayouya.travel.module.assets.ui.CashApplyActivity$$ARouter$$Autowired */
public class CashApplyActivity$$ARouter$$Autowired implements ISyringe {
    private SerializationService serializationService;

    public void inject(Object obj) {
        this.serializationService = (SerializationService) ARouter.m2127a().mo10488a(SerializationService.class);
        CashApplyActivity cashApplyActivity = (CashApplyActivity) obj;
        cashApplyActivity.f11256c = (CashApplyRsp) cashApplyActivity.getIntent().getParcelableExtra("item");
    }
}
