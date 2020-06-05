package com.alibaba.fastjson.serializer;

import com.tencent.p605ep.common.adapt.iservice.account.AccountConst.ArgKey;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.concurrent.atomic.DoubleAdder;
import java.util.concurrent.atomic.LongAdder;

/* renamed from: com.alibaba.fastjson.serializer.b */
public class AdderSerializer implements ObjectSerializer {
    /* renamed from: a */
    public static final AdderSerializer f2904a = new AdderSerializer();

    /* renamed from: a */
    public void mo11198a(JSONSerializer agVar, Object obj, Object obj2, Type type, int i) throws IOException {
        SerializeWriter baVar = agVar.f2846b;
        boolean z = obj instanceof LongAdder;
        String str = ArgKey.KEY_VALUE;
        if (z) {
            baVar.mo11376a('{', str, ((LongAdder) obj).longValue());
            baVar.write(125);
        } else if (obj instanceof DoubleAdder) {
            baVar.mo11374a('{', str, ((DoubleAdder) obj).doubleValue());
            baVar.write(125);
        }
    }
}
