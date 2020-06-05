package com.jiayouya.travel.module.login.p270ui;

import com.alibaba.android.arouter.facade.service.SerializationService;
import com.alibaba.android.arouter.facade.template.ISyringe;
import com.alibaba.android.arouter.p043a.ARouter;

/* renamed from: com.jiayouya.travel.module.login.ui.LoginActivity$$ARouter$$Autowired */
public class LoginActivity$$ARouter$$Autowired implements ISyringe {
    private SerializationService serializationService;

    public void inject(Object obj) {
        this.serializationService = (SerializationService) ARouter.m2127a().mo10488a(SerializationService.class);
        LoginActivity loginActivity = (LoginActivity) obj;
        loginActivity.f11514c = loginActivity.getIntent().getBooleanExtra("isAuth", loginActivity.f11514c);
    }
}
