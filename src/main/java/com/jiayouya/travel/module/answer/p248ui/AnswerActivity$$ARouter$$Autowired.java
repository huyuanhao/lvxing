package com.jiayouya.travel.module.answer.p248ui;

import com.alibaba.android.arouter.facade.service.SerializationService;
import com.alibaba.android.arouter.facade.template.ISyringe;
import com.alibaba.android.arouter.p043a.ARouter;

/* renamed from: com.jiayouya.travel.module.answer.ui.AnswerActivity$$ARouter$$Autowired */
public class AnswerActivity$$ARouter$$Autowired implements ISyringe {
    private SerializationService serializationService;

    public void inject(Object obj) {
        this.serializationService = (SerializationService) ARouter.m2127a().mo10488a(SerializationService.class);
        AnswerActivity answerActivity = (AnswerActivity) obj;
        answerActivity.f11224c = answerActivity.getIntent().getBooleanExtra("isAnswerAgain", answerActivity.f11224c);
    }
}
