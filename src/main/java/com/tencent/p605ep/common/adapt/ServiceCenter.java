package com.tencent.p605ep.common.adapt;

import com.tencent.p605ep.common.adapt.iservice.IServiceCenterImpl;
import java.util.HashMap;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* renamed from: com.tencent.ep.common.adapt.ServiceCenter */
public class ServiceCenter {
    static ReentrantReadWriteLock mRWLock = new ReentrantReadWriteLock();
    private static IServiceCenterImpl mServiceCenterImpl;
    private static HashMap<String, Object> sCache = new HashMap<>();

    public static <T> T get(Class<T> cls) {
        String name = cls.getName();
        mRWLock.readLock().lock();
        T t = sCache.get(name);
        mRWLock.readLock().unlock();
        if (t != null) {
            return t;
        }
        IServiceCenterImpl iServiceCenterImpl = mServiceCenterImpl;
        return iServiceCenterImpl != null ? iServiceCenterImpl.createImplObject(cls) : t;
    }

    public static IServiceCenterImpl getServiceCenterImpl() {
        return mServiceCenterImpl;
    }

    public static void remove(Class cls) {
        mRWLock.writeLock().lock();
        try {
            if (!(mServiceCenterImpl == null || sCache.get(cls.getName()) == null || !mServiceCenterImpl.isSupport(cls))) {
                sCache.remove(cls.getName());
            }
        } finally {
            mRWLock.writeLock().unlock();
        }
    }

    public static <T> void set(Class<T> cls, Object obj) {
        if (obj == null) {
            throw new RuntimeException("serviceImpl == null");
        } else if (cls.isInstance(obj)) {
            String name = cls.getName();
            mRWLock.writeLock().lock();
            try {
                if (sCache.get(name) == null) {
                    sCache.put(name, obj);
                }
            } finally {
                mRWLock.writeLock().unlock();
            }
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append("");
            sb.append(obj.getClass());
            sb.append(" is not Instance ");
            sb.append(cls.getName());
            throw new RuntimeException(sb.toString());
        }
    }

    public static void setServiceCenterImpl(IServiceCenterImpl iServiceCenterImpl) {
        mServiceCenterImpl = iServiceCenterImpl;
    }
}
