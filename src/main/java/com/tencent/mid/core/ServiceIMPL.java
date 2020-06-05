package com.tencent.mid.core;

import android.content.Context;
import com.tencent.mid.api.MidCallback;
import com.tencent.mid.api.MidEntity;
import com.tencent.mid.sotrage.UnifiedStorage;
import com.tencent.mid.util.Logger;
import com.tencent.mid.util.Util;

public class ServiceIMPL {
    /* access modifiers changed from: private|static */
    public static Logger logger = Util.getLogger();

    private static boolean checkPermissions(Context context, MidCallback midCallback) {
        return true;
    }

    private ServiceIMPL() {
    }

    public static MidEntity getLocalMidEntity(Context context) {
        return UnifiedStorage.getInstance(context).readMidEntity();
    }

    public static void clear(Context context) {
        if (context != null) {
            UnifiedStorage.getInstance(context).clear();
        }
    }

    public static void requestMid(Context context, final MidCallback midCallback) {
        Logger logger2 = logger;
        StringBuilder sb = new StringBuilder();
        sb.append("requestMid, callback=");
        sb.append(midCallback);
        logger2.mo35700i(sb.toString());
        requestMidEntity(context, new MidCallback() {
            public void onSuccess(Object obj) {
                if (obj != null) {
                    MidEntity parse = MidEntity.parse(obj.toString());
                    Logger access$000 = ServiceIMPL.logger;
                    StringBuilder sb = new StringBuilder();
                    sb.append("success to get mid:");
                    sb.append(parse.getMid());
                    access$000.mo35693d(sb.toString());
                    midCallback.onSuccess(parse.getMid());
                }
            }

            public void onFail(int i, String str) {
                Logger access$000 = ServiceIMPL.logger;
                StringBuilder sb = new StringBuilder();
                sb.append("failed to get mid, errorcode:");
                sb.append(i);
                sb.append(" ,msg:");
                sb.append(str);
                access$000.mo35696e((Object) sb.toString());
                midCallback.onFail(i, str);
            }
        });
    }

    public static void requestMidEntity(Context context, MidCallback midCallback) {
        if (checkPermissions(context, midCallback)) {
            MidEntity localMidEntity = getLocalMidEntity(context);
            if (localMidEntity == null || !localMidEntity.isMidValid()) {
                logger.mo35700i("requestMidEntity -> request new mid entity.");
                WorkThread.getInstance().doWork(new ServiceRunnable(context, 1, midCallback));
            } else {
                Logger logger2 = logger;
                StringBuilder sb = new StringBuilder();
                sb.append("requestMidEntity -> get local mid entity:");
                sb.append(localMidEntity.toString());
                logger2.mo35700i(sb.toString());
                midCallback.onSuccess(localMidEntity.toString());
                WorkThread.getInstance().doWork(new ServiceRunnable(context, 2, midCallback));
            }
        }
    }

    public static String getMid(Context context) {
        if (context == null) {
            logger.mo35696e((Object) "context==null in getMid()");
            return null;
        }
        String readMidString = UnifiedStorage.getInstance(context).readMidString();
        if (!Util.isMidValid(readMidString)) {
            C73182 r1 = new MidCallback() {
                public void onSuccess(Object obj) {
                    if (obj != null) {
                        MidEntity parse = MidEntity.parse(obj.toString());
                        Logger access$000 = ServiceIMPL.logger;
                        StringBuilder sb = new StringBuilder();
                        sb.append("success to get mid:");
                        sb.append(parse.getMid());
                        access$000.mo35693d(sb.toString());
                    }
                }

                public void onFail(int i, String str) {
                    Logger access$000 = ServiceIMPL.logger;
                    StringBuilder sb = new StringBuilder();
                    sb.append("failed to get mid, errorcode:");
                    sb.append(i);
                    sb.append(" ,msg:");
                    sb.append(str);
                    access$000.mo35696e((Object) sb.toString());
                }
            };
            logger.mo35693d("getMid -> request new mid entity.");
            WorkThread.getInstance().doWork(new ServiceRunnable(context, 1, r1));
        }
        return readMidString;
    }

    public static long getGuid(Context context) {
        if (context != null) {
            return UnifiedStorage.getInstance(context).readGuid();
        }
        logger.mo35696e((Object) "context==null in getGuid()");
        return 0;
    }

    public static String getLocalMid(Context context) {
        if (context != null) {
            return UnifiedStorage.getInstance(context).readMidString();
        }
        logger.mo35696e((Object) "context==null in getMid()");
        return null;
    }

    public static boolean isMidValid(String str) {
        return Util.isMidValid(str);
    }

    public static void enableDebug(boolean z) {
        Util.getLogger().setDebugEnable(z);
    }

    public static boolean isEnableDebug() {
        return Util.getLogger().isDebugEnable();
    }
}
