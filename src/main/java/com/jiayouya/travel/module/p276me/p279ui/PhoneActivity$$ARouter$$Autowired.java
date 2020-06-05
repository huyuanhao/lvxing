package com.jiayouya.travel.module.p276me.p279ui;

import com.alibaba.android.arouter.facade.service.SerializationService;
import com.alibaba.android.arouter.facade.template.ISyringe;
import com.alibaba.android.arouter.p043a.ARouter;

/* renamed from: com.jiayouya.travel.module.me.ui.PhoneActivity$$ARouter$$Autowired */
public class PhoneActivity$$ARouter$$Autowired implements ISyringe {
    private SerializationService serializationService;

    public void inject(Object obj) {
        this.serializationService = (SerializationService) ARouter.m2127a().mo10488a(SerializationService.class);
        PhoneActivity phoneActivity = (PhoneActivity) obj;
        phoneActivity.f11622c = phoneActivity.getIntent().getBooleanExtra("isMustBind", phoneActivity.f11622c);
    }
}
