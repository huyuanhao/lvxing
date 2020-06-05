package com.tencent.mid.core;

import android.content.Context;
import com.tencent.mid.api.MidCallback;
import com.tencent.mid.api.MidConstants;
import com.tencent.mid.api.MidEntity;
import com.tencent.mid.sotrage.CheckEntity;
import com.tencent.mid.sotrage.UnifiedStorage;
import com.tencent.mid.util.Logger;
import com.tencent.mid.util.SettingsHelper;
import com.tencent.mid.util.Util;
import java.util.ArrayList;
import java.util.Arrays;

public class ServiceRunnable implements Runnable {
    public static final int CHECK_TYPE = 2;
    public static final int REQUEST_NEW_TYPE = 3;
    public static final int REQUEST_TYPE = 1;
    private MidCallback callback = null;
    private Context context = null;
    /* access modifiers changed from: private */
    public Logger logger = null;
    private int type = 0;

    public ServiceRunnable(Context context2, int i, MidCallback midCallback) {
        this.context = context2;
        this.type = i;
        this.callback = midCallback;
        this.logger = Util.getLogger();
    }

    public void run() {
        synchronized (ServiceRunnable.class) {
            Logger logger2 = this.logger;
            StringBuilder sb = new StringBuilder();
            sb.append("ServiceRunnable begin, type:");
            sb.append(this.type);
            sb.append(",ver:");
            sb.append(4.07f);
            logger2.mo35708w(sb.toString());
            try {
                int i = this.type;
                if (i == 1) {
                    MidEntity localMidEntity = ServiceIMPL.getLocalMidEntity(this.context);
                    if (Util.isMidValid(localMidEntity)) {
                        this.callback.onSuccess(localMidEntity);
                    } else if (Util.isNetworkAvailable(this.context)) {
                        HttpManager.getInstance(this.context).send(1, new RequestPacket(this.context), this.callback);
                    } else {
                        this.callback.onFail(MidConstants.ERROR_NETWORK, "network not available.");
                    }
                } else if (i != 2) {
                    Logger logger3 = this.logger;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("wrong type:");
                    sb2.append(this.type);
                    logger3.mo35708w(sb2.toString());
                } else {
                    autoCheck();
                }
            } catch (Throwable th) {
                this.logger.mo35696e(th);
            }
            this.logger.mo35708w("ServiceRunnable end");
        }
    }

    private void checkLocalConsistency() {
        MidEntity readMidEntity = UnifiedStorage.getInstance(this.context).readMidEntity(new ArrayList(Arrays.asList(new Integer[]{Integer.valueOf(2)})));
        MidEntity readMidEntity2 = UnifiedStorage.getInstance(this.context).readMidEntity(new ArrayList(Arrays.asList(new Integer[]{Integer.valueOf(4)})));
        if (Util.equal(readMidEntity2, readMidEntity)) {
            this.logger.mo35708w("local mid check passed.");
            return;
        }
        MidEntity newerMidEntity = Util.getNewerMidEntity(readMidEntity2, readMidEntity);
        Logger logger2 = this.logger;
        StringBuilder sb = new StringBuilder();
        sb.append("local mid check failed, redress with mid:");
        sb.append(newerMidEntity.toString());
        logger2.mo35708w(sb.toString());
        if (SettingsHelper.getInstance(this.context).getInt("ten.mid.allowCheckAndRewriteLocal.bool", 0) == 1) {
            UnifiedStorage.getInstance(this.context).writeMidEntity(newerMidEntity);
        }
    }

    private void autoCheck() {
        CheckEntity readCheckEntity = UnifiedStorage.getInstance(this.context).readCheckEntity();
        if (readCheckEntity == null) {
            this.logger.mo35708w("CheckEntity is null");
            return;
        }
        int lastCheckTimes = readCheckEntity.getLastCheckTimes() + 1;
        long currentTimeMillis = System.currentTimeMillis() - readCheckEntity.getLastCheckTimestamps();
        if (currentTimeMillis < 0) {
            currentTimeMillis = -currentTimeMillis;
        }
        Logger logger2 = this.logger;
        StringBuilder sb = new StringBuilder();
        sb.append("check entity: ");
        sb.append(readCheckEntity.toString());
        sb.append(",duration:");
        sb.append(currentTimeMillis);
        logger2.mo35700i(sb.toString());
        if ((lastCheckTimes > readCheckEntity.getMaxFreq() && currentTimeMillis > Constants.DAY_TIMESTAMPS) || currentTimeMillis > ((long) readCheckEntity.getMaxDays()) * Constants.DAY_TIMESTAMPS) {
            checkLocalConsistency();
            checkServer();
            readCheckEntity.setLastCheckTimes(lastCheckTimes);
            readCheckEntity.setLastCheckTimestamps(System.currentTimeMillis());
            UnifiedStorage.getInstance(this.context).writeCheckEntity(readCheckEntity);
        }
        MidEntity readNewVersionMidEntity = UnifiedStorage.getInstance(this.context).readNewVersionMidEntity();
        Logger logger3 = this.logger;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("midNewEntity:");
        sb2.append(readNewVersionMidEntity);
        logger3.mo35700i(sb2.toString());
        if (!Util.isMidValid(readNewVersionMidEntity)) {
            this.logger.mo35700i("request mid_new ");
            HttpManager.getInstance(this.context).send(3, new RequestPacket(this.context), new MidCallback() {
                public void onSuccess(Object obj) {
                    Logger access$000 = ServiceRunnable.this.logger;
                    StringBuilder sb = new StringBuilder();
                    sb.append("request new mid success:");
                    sb.append(obj);
                    access$000.mo35700i(sb.toString());
                }

                public void onFail(int i, String str) {
                    Logger access$000 = ServiceRunnable.this.logger;
                    StringBuilder sb = new StringBuilder();
                    sb.append("request new mid failed, errCode:");
                    sb.append(i);
                    sb.append(",msg:");
                    sb.append(str);
                    access$000.mo35700i(sb.toString());
                }
            });
        }
    }

    private void checkServer() {
        this.logger.mo35700i("checkServer");
        HttpManager.getInstance(this.context).send(2, new RequestPacket(this.context), new MidCallback() {
            public void onSuccess(Object obj) {
                Logger access$000 = ServiceRunnable.this.logger;
                StringBuilder sb = new StringBuilder();
                sb.append("checkServer success:");
                sb.append(obj);
                access$000.mo35700i(sb.toString());
            }

            public void onFail(int i, String str) {
                Logger access$000 = ServiceRunnable.this.logger;
                StringBuilder sb = new StringBuilder();
                sb.append("checkServer failed, errCode:");
                sb.append(i);
                sb.append(",msg:");
                sb.append(str);
                access$000.mo35700i(sb.toString());
            }
        });
    }
}
