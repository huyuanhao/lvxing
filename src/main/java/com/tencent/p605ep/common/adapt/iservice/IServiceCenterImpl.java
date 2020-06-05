package com.tencent.p605ep.common.adapt.iservice;

/* renamed from: com.tencent.ep.common.adapt.iservice.IServiceCenterImpl */
public interface IServiceCenterImpl {
    Object createImplObject(Class cls);

    boolean isSupport(Class cls);
}
