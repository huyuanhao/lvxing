package com.tencent.mid.core;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.LocalServerSocket;
import com.tencent.bigdata.dataacquisition.CustomDeviceInfos;
import com.tencent.mid.api.MidCallback;
import com.tencent.mid.api.MidConstants;
import com.tencent.mid.api.MidEntity;
import com.tencent.mid.api.MidPreference;
import com.tencent.mid.sotrage.UnifiedStorage;
import com.tencent.mid.util.AESHelper;
import com.tencent.mid.util.Logger;
import com.tencent.mid.util.Util;
import java.io.IOException;

public class HttpManager {
    private static final String LOCAL_SERVER_SOCKET_NAME_SUFFIX = "com.tencent.teg.mid.sock.lock";
    private static final long MAX_DURATION_FAILED_TIME = 1800000;
    private static final int MAX_FAILED_COUNT = 3;
    private static Context applicationContext = null;
    private static HttpManager instance = null;
    private static Logger logger = Util.getLogger();
    private AESHelper aesHelper = null;
    private AESHelper defaultAesHelper = null;
    private int httpFailedCount = 0;
    private long lastHttpFailedTime = 0;
    int limit = -1;
    LocalServerSocket mLocalServerSocket = null;
    private int seq = -1;

    private void resetFailedInfo() {
        this.lastHttpFailedTime = 0;
        this.httpFailedCount = 0;
    }

    private void incFailedCount() {
        this.httpFailedCount++;
        this.lastHttpFailedTime = System.currentTimeMillis();
    }

    private boolean checkFailedCountLimited() {
        if (this.httpFailedCount > 3) {
            if (System.currentTimeMillis() - this.lastHttpFailedTime < MAX_DURATION_FAILED_TIME) {
                return true;
            }
            resetFailedInfo();
        }
        return false;
    }

    private HttpManager(Context context) {
        try {
            applicationContext = context.getApplicationContext();
        } catch (Throwable th) {
            logger.mo35696e(th);
        }
    }

    /* access modifiers changed from: 0000 */
    public AESHelper getAesHelper(int i) {
        if (i == 1) {
            if (this.aesHelper == null) {
                this.aesHelper = new AESHelper();
                this.aesHelper.initKeyAndIV();
            }
            return this.aesHelper;
        }
        if (this.defaultAesHelper == null) {
            this.defaultAesHelper = new AESHelper();
            this.defaultAesHelper.setKeyAndIV("key-/.*$!xx", "vec-;*5@)&%(");
        }
        return this.defaultAesHelper;
    }

    public static synchronized HttpManager getInstance(Context context) {
        HttpManager httpManager;
        synchronized (HttpManager.class) {
            if (instance == null) {
                instance = new HttpManager(context);
            }
            httpManager = instance;
        }
        return httpManager;
    }

    static Context getApplicationContext() {
        return applicationContext;
    }

    /* access modifiers changed from: 0000 */
    public boolean checkSendLimit() {
        int i = this.limit;
        this.limit = i + 1;
        if (i > 1000) {
            Logger logger2 = logger;
            StringBuilder sb = new StringBuilder();
            sb.append("send count limit ");
            sb.append(this.limit);
            logger2.mo35696e((Object) sb.toString());
            return false;
        }
        SharedPreferences sharedPreferences = MidPreference.getInstance(applicationContext).getSharedPreferences();
        if (sharedPreferences != null) {
            String dateString = Util.getDateString(0);
            StringBuilder sb2 = new StringBuilder();
            sb2.append("SEND_LIMIT_");
            sb2.append(dateString);
            String sb3 = sb2.toString();
            if (this.limit == 0) {
                this.limit = sharedPreferences.getInt(sb3, 0);
            }
            sharedPreferences.edit().putInt(sb3, this.limit);
        }
        return true;
    }

    private boolean getSocket() {
        String str = LOCAL_SERVER_SOCKET_NAME_SUFFIX;
        try {
            this.mLocalServerSocket = new LocalServerSocket(str);
            Logger logger2 = logger;
            StringBuilder sb = new StringBuilder();
            sb.append("open socket mLocalServerSocket:");
            sb.append(this.mLocalServerSocket);
            logger2.mo35693d(sb.toString());
            return true;
        } catch (IOException unused) {
            Logger logger3 = logger;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("socket Name:");
            sb2.append(str);
            sb2.append(" is in use.");
            logger3.mo35708w(sb2.toString());
            return false;
        } catch (Throwable unused2) {
            logger.mo35708w("something wrong while create LocalServerSocket.");
            return false;
        }
    }

    private void closeSocket() {
        LocalServerSocket localServerSocket = this.mLocalServerSocket;
        if (localServerSocket != null) {
            try {
                localServerSocket.close();
                Logger logger2 = logger;
                StringBuilder sb = new StringBuilder();
                sb.append("close socket  mLocalServerSocket:");
                sb.append(this.mLocalServerSocket);
                logger2.mo35700i(sb.toString());
                this.mLocalServerSocket = null;
            } catch (Throwable unused) {
            }
        }
    }

    /* access modifiers changed from: 0000 */
    public void send(int i, PacketInterface packetInterface, MidCallback midCallback) {
        if (packetInterface == null || midCallback == null) {
            if (midCallback != null) {
                midCallback.onFail(-10000, "packet == null || handler == null");
            }
            logger.mo35696e((Object) "packet == null || handler == null || cb == null");
        } else if (!Util.isNetworkAvailable(applicationContext)) {
            midCallback.onFail(MidConstants.ERROR_NETWORK, "network not available.");
        } else {
            int i2 = 0;
            while (!getSocket()) {
                int i3 = i2 + 1;
                if (i2 >= 10) {
                    break;
                }
                try {
                    Thread.sleep(500);
                } catch (InterruptedException unused) {
                }
                i2 = i3;
            }
            if (i == 1) {
                MidEntity localMidEntity = ServiceIMPL.getLocalMidEntity(applicationContext);
                if (Util.isMidValid(localMidEntity)) {
                    midCallback.onSuccess(localMidEntity);
                    closeSocket();
                    return;
                }
            }
            if (i == 3) {
                MidEntity readNewVersionMidEntity = UnifiedStorage.getInstance(applicationContext).readNewVersionMidEntity();
                if (Util.isMidValid(readNewVersionMidEntity)) {
                    midCallback.onSuccess(readNewVersionMidEntity);
                    closeSocket();
                    return;
                }
            }
            if (!checkSendLimit()) {
                closeSocket();
                return;
            }
            request(i, packetInterface, midCallback);
            closeSocket();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:37:0x0165, code lost:
            if (r12.has(r2) != false) goto L_0x0167;
     */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x0215 A[SYNTHETIC, Splitter:B:69:0x0215] */
    private void request(int r12, com.tencent.mid.core.PacketInterface r13, com.tencent.mid.api.MidCallback r14) {
        /*
        r11 = this;
        java.lang.String r0 = "mid"
        java.lang.String r1 = "ret_code"
        com.tencent.mid.util.Logger r2 = logger
        java.lang.StringBuilder r3 = new java.lang.StringBuilder
        r3.<init>()
        java.lang.String r4 = " enter http request, type:"
        r3.append(r4)
        r3.append(r12)
        java.lang.String r3 = r3.toString()
        r2.mo35700i(r3)
        r2 = 0
        boolean r3 = r11.checkFailedCountLimited()     // Catch:{ all -> 0x01f6 }
        if (r3 == 0) goto L_0x0030
        java.lang.String r12 = "Http request failed too much, please check the network."
        com.tencent.mid.util.Logger r13 = logger     // Catch:{ all -> 0x01f6 }
        r13.mo35696e(r12)     // Catch:{ all -> 0x01f6 }
        if (r14 == 0) goto L_0x002f
        r13 = -10050(0xffffffffffffd8be, float:NaN)
        r14.onFail(r13, r12)     // Catch:{ all -> 0x01f6 }
    L_0x002f:
        return
    L_0x0030:
        android.content.Context r3 = applicationContext     // Catch:{ all -> 0x01f6 }
        com.tencent.mid.util.ConstantUtil r3 = com.tencent.mid.util.ConstantUtil.getInstance(r3)     // Catch:{ all -> 0x01f6 }
        com.tencent.mid.core.HttpConnectClient r4 = new com.tencent.mid.core.HttpConnectClient     // Catch:{ all -> 0x01f6 }
        android.content.Context r5 = applicationContext     // Catch:{ all -> 0x01f6 }
        java.lang.String r5 = com.tencent.mid.util.Util.getHttpAddr(r5)     // Catch:{ all -> 0x01f6 }
        r4.m52860init(r5, r2)     // Catch:{ all -> 0x01f6 }
        org.json.JSONObject r2 = new org.json.JSONObject     // Catch:{ all -> 0x01f4 }
        r2.<init>()     // Catch:{ all -> 0x01f4 }
        r13.encode(r2)     // Catch:{ all -> 0x01f4 }
        java.lang.String r13 = "rty"
        r2.put(r13, r12)     // Catch:{ all -> 0x01f4 }
        int r13 = r11.seq     // Catch:{ all -> 0x01f4 }
        java.lang.String r5 = "seq"
        if (r13 <= 0) goto L_0x0059
        int r13 = r11.seq     // Catch:{ all -> 0x01f4 }
        r2.put(r5, r13)     // Catch:{ all -> 0x01f4 }
    L_0x0059:
        org.json.JSONObject r13 = new org.json.JSONObject     // Catch:{ all -> 0x01f4 }
        r13.<init>()     // Catch:{ all -> 0x01f4 }
        java.lang.String r6 = "android"
        r13.put(r6, r2)     // Catch:{ all -> 0x01f4 }
        java.lang.String r2 = "mid_list"
        android.content.Context r6 = applicationContext     // Catch:{ all -> 0x01f4 }
        r7 = 1
        org.json.JSONArray r6 = com.tencent.mid.util.Util.queryMids(r6, r7)     // Catch:{ all -> 0x01f4 }
        r13.put(r2, r6)     // Catch:{ all -> 0x01f4 }
        java.lang.String r2 = "mid_list_new"
        android.content.Context r6 = applicationContext     // Catch:{ all -> 0x01f4 }
        r8 = 2
        org.json.JSONArray r6 = com.tencent.mid.util.Util.queryMids(r6, r8)     // Catch:{ all -> 0x01f4 }
        r13.put(r2, r6)     // Catch:{ all -> 0x01f4 }
        java.lang.String r13 = r13.toString()     // Catch:{ all -> 0x01f4 }
        com.tencent.mid.util.Logger r2 = logger     // Catch:{ all -> 0x01f4 }
        java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x01f4 }
        r6.<init>()     // Catch:{ all -> 0x01f4 }
        java.lang.String r8 = "jsonBodyStr:"
        r6.append(r8)     // Catch:{ all -> 0x01f4 }
        r6.append(r13)     // Catch:{ all -> 0x01f4 }
        java.lang.String r6 = r6.toString()     // Catch:{ all -> 0x01f4 }
        r2.mo35700i(r6)     // Catch:{ all -> 0x01f4 }
        java.io.ByteArrayOutputStream r2 = new java.io.ByteArrayOutputStream     // Catch:{ all -> 0x01f4 }
        int r6 = r13.length()     // Catch:{ all -> 0x01f4 }
        r2.<init>(r6)     // Catch:{ all -> 0x01f4 }
        java.util.zip.GZIPOutputStream r6 = new java.util.zip.GZIPOutputStream     // Catch:{ all -> 0x01f4 }
        r6.<init>(r2)     // Catch:{ all -> 0x01f4 }
        java.lang.String r8 = "UTF-8"
        byte[] r13 = r13.getBytes(r8)     // Catch:{ all -> 0x01f4 }
        r6.write(r13)     // Catch:{ all -> 0x01f4 }
        r6.close()     // Catch:{ all -> 0x01f4 }
        r2.flush()     // Catch:{ all -> 0x01f4 }
        byte[] r13 = r2.toByteArray()     // Catch:{ all -> 0x01f4 }
        com.tencent.mid.util.AESHelper r6 = r11.getAesHelper(r12)     // Catch:{ all -> 0x01f4 }
        r2.reset()     // Catch:{ all -> 0x01f4 }
        java.io.DataOutputStream r8 = new java.io.DataOutputStream     // Catch:{ all -> 0x01f4 }
        r8.<init>(r2)     // Catch:{ all -> 0x01f4 }
        java.lang.String r9 = r3.getVerifyMidUrl()     // Catch:{ all -> 0x01f4 }
        if (r12 == r7) goto L_0x00cb
        r10 = 3
        if (r12 != r10) goto L_0x010c
    L_0x00cb:
        if (r12 != r7) goto L_0x00d2
        java.lang.String r7 = r3.getRequestMidUrl()     // Catch:{ all -> 0x01f4 }
        goto L_0x00d6
    L_0x00d2:
        java.lang.String r7 = r3.getRequestMidNewUrl()     // Catch:{ all -> 0x01f4 }
    L_0x00d6:
        r9 = r7
        java.io.ByteArrayOutputStream r7 = new java.io.ByteArrayOutputStream     // Catch:{ all -> 0x01f4 }
        r10 = 64
        r7.<init>(r10)     // Catch:{ all -> 0x01f4 }
        byte[] r10 = r6.getKeyBytes()     // Catch:{ all -> 0x01f4 }
        r7.write(r10)     // Catch:{ all -> 0x01f4 }
        byte[] r10 = r6.getIvBytes()     // Catch:{ all -> 0x01f4 }
        r7.write(r10)     // Catch:{ all -> 0x01f4 }
        r7.close()     // Catch:{ all -> 0x01f4 }
        byte[] r7 = r7.toByteArray()     // Catch:{ all -> 0x01f4 }
        java.lang.String r10 = r3.getRSAPK()     // Catch:{ all -> 0x01f4 }
        com.tencent.mid.util.RSAHelper.createPublicKey(r10)     // Catch:{ all -> 0x01f4 }
        byte[] r7 = com.tencent.mid.util.RSAHelper.encrypt(r7)     // Catch:{ all -> 0x01f4 }
        int r3 = r3.getRSAKeyVersion()     // Catch:{ all -> 0x01f4 }
        r8.writeShort(r3)     // Catch:{ all -> 0x01f4 }
        int r3 = r7.length     // Catch:{ all -> 0x01f4 }
        r8.writeShort(r3)     // Catch:{ all -> 0x01f4 }
        r8.write(r7)     // Catch:{ all -> 0x01f4 }
    L_0x010c:
        byte[] r13 = r6.encrypt(r13)     // Catch:{ all -> 0x01f4 }
        r8.write(r13)     // Catch:{ all -> 0x01f4 }
        r8.close()     // Catch:{ all -> 0x01f4 }
        r2.close()     // Catch:{ all -> 0x01f4 }
        byte[] r13 = r2.toByteArray()     // Catch:{ all -> 0x01f4 }
        java.lang.String r2 = "gzip"
        com.tencent.mid.core.HttpResponseResult r12 = r4.httpPost(r9, r13, r2, r12)     // Catch:{ all -> 0x01f4 }
        int r13 = r12.getCode()     // Catch:{ all -> 0x01f4 }
        r2 = 200(0xc8, float:2.8E-43)
        if (r13 == r2) goto L_0x0155
        java.lang.StringBuilder r13 = new java.lang.StringBuilder     // Catch:{ all -> 0x01f4 }
        r13.<init>()     // Catch:{ all -> 0x01f4 }
        java.lang.String r0 = "response code invalid:"
        r13.append(r0)     // Catch:{ all -> 0x01f4 }
        int r0 = r12.getCode()     // Catch:{ all -> 0x01f4 }
        r13.append(r0)     // Catch:{ all -> 0x01f4 }
        java.lang.String r13 = r13.toString()     // Catch:{ all -> 0x01f4 }
        com.tencent.mid.util.Logger r0 = logger     // Catch:{ all -> 0x01f4 }
        r0.mo35708w(r13)     // Catch:{ all -> 0x01f4 }
        int r12 = r12.getCode()     // Catch:{ all -> 0x01f4 }
        r14.onFail(r12, r13)     // Catch:{ all -> 0x01f4 }
        r4.shutdown()     // Catch:{ all -> 0x0150 }
        goto L_0x0154
    L_0x0150:
        r12 = move-exception
        r12.printStackTrace()
    L_0x0154:
        return
    L_0x0155:
        org.json.JSONObject r12 = r12.getData()     // Catch:{ all -> 0x01f4 }
        boolean r13 = r12.has(r1)     // Catch:{ all -> 0x01f4 }
        java.lang.String r2 = "ret_msg"
        if (r13 != 0) goto L_0x0167
        boolean r13 = r12.has(r2)     // Catch:{ all -> 0x01f4 }
        if (r13 == 0) goto L_0x019b
    L_0x0167:
        int r13 = r12.getInt(r1)     // Catch:{ all -> 0x01f4 }
        java.lang.String r1 = r12.getString(r2)     // Catch:{ all -> 0x01f4 }
        java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x01f4 }
        r2.<init>()     // Catch:{ all -> 0x01f4 }
        java.lang.String r3 = "response code:"
        r2.append(r3)     // Catch:{ all -> 0x01f4 }
        r2.append(r13)     // Catch:{ all -> 0x01f4 }
        java.lang.String r3 = ",msg:"
        r2.append(r3)     // Catch:{ all -> 0x01f4 }
        r2.append(r1)     // Catch:{ all -> 0x01f4 }
        java.lang.String r1 = r2.toString()     // Catch:{ all -> 0x01f4 }
        com.tencent.mid.util.Logger r2 = logger     // Catch:{ all -> 0x01f4 }
        r2.mo35708w(r1)     // Catch:{ all -> 0x01f4 }
        if (r13 == 0) goto L_0x019b
        r14.onFail(r13, r1)     // Catch:{ all -> 0x01f4 }
        r4.shutdown()     // Catch:{ all -> 0x0196 }
        goto L_0x019a
    L_0x0196:
        r12 = move-exception
        r12.printStackTrace()
    L_0x019a:
        return
    L_0x019b:
        boolean r13 = r12.isNull(r5)     // Catch:{ all -> 0x01f4 }
        if (r13 != 0) goto L_0x01a7
        int r13 = r12.getInt(r5)     // Catch:{ all -> 0x01f4 }
        r11.seq = r13     // Catch:{ all -> 0x01f4 }
    L_0x01a7:
        boolean r13 = r12.isNull(r0)     // Catch:{ all -> 0x01f4 }
        r1 = 0
        r2 = 0
        java.lang.String r5 = "guid"
        if (r13 != 0) goto L_0x01c9
        java.lang.String r13 = r12.getString(r0)     // Catch:{ all -> 0x01f4 }
        boolean r0 = r12.has(r5)     // Catch:{ all -> 0x01f4 }
        if (r0 == 0) goto L_0x01c9
        long r6 = r12.optLong(r5, r2)     // Catch:{ all -> 0x01f4 }
        java.lang.String r0 = "reset"
        int r0 = r12.optInt(r0, r1)     // Catch:{ all -> 0x01f4 }
        updateMidEntity(r13, r6, r0, r14)     // Catch:{ all -> 0x01f4 }
    L_0x01c9:
        java.lang.String r13 = "locW"
        r0 = -1
        int r13 = r12.optInt(r13, r0)     // Catch:{ all -> 0x01f4 }
        if (r13 <= r0) goto L_0x01dd
        android.content.Context r0 = applicationContext     // Catch:{ all -> 0x01f4 }
        com.tencent.mid.util.SettingsHelper r0 = com.tencent.mid.util.SettingsHelper.getInstance(r0)     // Catch:{ all -> 0x01f4 }
        java.lang.String r6 = "ten.mid.allowCheckAndRewriteLocal.bool"
        r0.putInt(r6, r13)     // Catch:{ all -> 0x01f4 }
    L_0x01dd:
        java.lang.String r13 = "mid_new"
        java.lang.String r13 = r12.optString(r13)     // Catch:{ all -> 0x01f4 }
        long r2 = r12.optLong(r5, r2)     // Catch:{ all -> 0x01f4 }
        java.lang.String r0 = "reset_new"
        int r12 = r12.optInt(r0, r1)     // Catch:{ all -> 0x01f4 }
        updateNewVersionMidEntity(r13, r2, r12)     // Catch:{ all -> 0x01f4 }
        r4.shutdown()     // Catch:{ all -> 0x0219 }
        goto L_0x021d
    L_0x01f4:
        r12 = move-exception
        goto L_0x01f8
    L_0x01f6:
        r12 = move-exception
        r4 = r2
    L_0x01f8:
        r11.incFailedCount()     // Catch:{ all -> 0x021e }
        r12.printStackTrace()     // Catch:{ all -> 0x021e }
        r13 = -10030(0xffffffffffffd8d2, float:NaN)
        java.lang.String r0 = r12.toString()     // Catch:{ all -> 0x021e }
        r14.onFail(r13, r0)     // Catch:{ all -> 0x021e }
        com.tencent.mid.util.Logger r13 = logger     // Catch:{ all -> 0x021e }
        java.lang.String r14 = r12.toString()     // Catch:{ all -> 0x021e }
        r13.mo35708w(r14)     // Catch:{ all -> 0x021e }
        r12.printStackTrace()     // Catch:{ all -> 0x021e }
        if (r4 == 0) goto L_0x021d
        r4.shutdown()     // Catch:{ all -> 0x0219 }
        goto L_0x021d
    L_0x0219:
        r12 = move-exception
        r12.printStackTrace()
    L_0x021d:
        return
    L_0x021e:
        r12 = move-exception
        if (r4 == 0) goto L_0x0229
        r4.shutdown()     // Catch:{ all -> 0x0225 }
        goto L_0x0229
    L_0x0225:
        r13 = move-exception
        r13.printStackTrace()
    L_0x0229:
        throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mid.core.HttpManager.request(int, com.tencent.mid.core.PacketInterface, com.tencent.mid.api.MidCallback):void");
    }

    private static void updateNewVersionMidEntity(String str, long j, int i) {
        if (Util.isMidValid(str)) {
            if (!Util.isMidValid(UnifiedStorage.getInstance(applicationContext).readNewVersionMidStr())) {
                i = 3;
            }
            Logger logger2 = logger;
            StringBuilder sb = new StringBuilder();
            sb.append("updateNewVersionMidEntity reset:");
            sb.append(i);
            logger2.mo35700i(sb.toString());
            if (i > 0) {
                MidEntity midEntity = new MidEntity();
                midEntity.setMid(str);
                midEntity.setGuid(j);
                midEntity.setMac(CustomDeviceInfos.getMacAddress(applicationContext));
                midEntity.setImei(CustomDeviceInfos.getDeviceId(applicationContext));
                midEntity.setImsi(CustomDeviceInfos.getImsi(applicationContext));
                midEntity.setTimestamps(System.currentTimeMillis());
                midEntity.setVersion(3);
                Logger logger3 = logger;
                StringBuilder sb2 = new StringBuilder();
                sb2.append("server return new version mid midEntity:");
                sb2.append(midEntity.toString());
                logger3.mo35700i(sb2.toString());
                if (i == 1) {
                    UnifiedStorage.getInstance(applicationContext).writePrivateNewVersionMidEntity(midEntity);
                } else if (i == 2) {
                    UnifiedStorage.getInstance(applicationContext).writePublicNewVersionMidEntity(midEntity);
                } else if (i == 3) {
                    UnifiedStorage.getInstance(applicationContext).writeNewVersionMidEntity(midEntity);
                } else if (i == 4) {
                    UnifiedStorage.getInstance(applicationContext).writeMidEntity(midEntity);
                    UnifiedStorage.getInstance(applicationContext).writeNewVersionMidEntity(midEntity);
                } else if (i == 8) {
                    UnifiedStorage.getInstance(applicationContext).writeMidEntity(midEntity);
                    UnifiedStorage.getInstance(applicationContext).writeNewVersionMidEntity(midEntity);
                    UnifiedStorage.getInstance(applicationContext).writeOldMidEntity(midEntity);
                }
                UnifiedStorage.getInstance(applicationContext).resetCheckEntity(-1, -1);
            }
        }
    }

    private static void updateMidEntity(String str, long j, int i, MidCallback midCallback) {
        if (Util.isMidValid(str)) {
            if (!Util.isMidValid(ServiceIMPL.getLocalMid(applicationContext))) {
                i = 4;
            }
            Logger logger2 = logger;
            StringBuilder sb = new StringBuilder();
            sb.append("updateMidEntity reset:");
            sb.append(i);
            logger2.mo35700i(sb.toString());
            if (i > 0) {
                MidEntity midEntity = new MidEntity();
                midEntity.setMid(str);
                midEntity.setGuid(j);
                midEntity.setMac(CustomDeviceInfos.getMacAddress(applicationContext));
                midEntity.setImei(CustomDeviceInfos.getDeviceId(applicationContext));
                midEntity.setImsi(CustomDeviceInfos.getImsi(applicationContext));
                midEntity.setTimestamps(System.currentTimeMillis());
                midEntity.setVersion(3);
                Logger logger3 = logger;
                StringBuilder sb2 = new StringBuilder();
                sb2.append("server return new mid midEntity:");
                sb2.append(midEntity.toString());
                logger3.mo35700i(sb2.toString());
                midCallback.onSuccess(midEntity.toString());
                if (i == 1) {
                    UnifiedStorage.getInstance(applicationContext).writePrivateMidEntity(midEntity);
                } else if (i == 2) {
                    UnifiedStorage.getInstance(applicationContext).writePublicMidEntity(midEntity);
                } else if (i == 3) {
                    UnifiedStorage.getInstance(applicationContext).writeMidEntity(midEntity);
                } else if (i == 4) {
                    UnifiedStorage.getInstance(applicationContext).writeMidEntity(midEntity);
                    UnifiedStorage.getInstance(applicationContext).writeOldMidEntity(midEntity);
                }
                UnifiedStorage.getInstance(applicationContext).resetCheckEntity(-1, -1);
            }
        }
    }
}
