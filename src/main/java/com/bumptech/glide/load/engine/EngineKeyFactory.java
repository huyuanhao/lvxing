package com.bumptech.glide.load.engine;

import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.Transformation;
import java.util.Map;

/* renamed from: com.bumptech.glide.load.engine.o */
class EngineKeyFactory {
    EngineKeyFactory() {
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public EngineKey mo12896a(Object obj, Key cVar, int i, int i2, Map<Class<?>, Transformation<?>> map, Class<?> cls, Class<?> cls2, Options fVar) {
        EngineKey nVar = new EngineKey(obj, cVar, i, i2, map, cls, cls2, fVar);
        return nVar;
    }
}
