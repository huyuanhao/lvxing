package com.jiayouya.travel.module.answer.p248ui;

import com.alibaba.android.arouter.facade.service.SerializationService;
import com.alibaba.android.arouter.facade.template.ISyringe;
import com.alibaba.android.arouter.p043a.ARouter;
import com.jiayouya.travel.module.answer.data.AnswerResult;
import com.tencent.p605ep.common.adapt.iservice.account.AccountConst.ArgKey;

/* renamed from: com.jiayouya.travel.module.answer.ui.AnswerResultActivity$$ARouter$$Autowired */
public class AnswerResultActivity$$ARouter$$Autowired implements ISyringe {
    private SerializationService serializationService;

    public void inject(Object obj) {
        this.serializationService = (SerializationService) ARouter.m2127a().mo10488a(SerializationService.class);
        AnswerResultActivity answerResultActivity = (AnswerResultActivity) obj;
        answerResultActivity.f11232c = (AnswerResult) answerResultActivity.getIntent().getParcelableExtra(ArgKey.KEY_RESULT);
    }
}
