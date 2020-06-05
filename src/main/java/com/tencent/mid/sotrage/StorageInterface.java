package com.tencent.mid.sotrage;

import android.content.Context;
import com.tencent.mid.api.MidEntity;
import com.tencent.mid.api.MidPreference;
import com.tencent.mid.util.Logger;
import com.tencent.mid.util.Util;

public abstract class StorageInterface {
    private static final String CHECK_ENTITY_TAG = "4kU71lN96TJUomD1vOU9lgj9U+kKmxDPLVM+zzjst5U=";
    public static final String KEY_SPLITER = ",";
    private static final String MID_DIR = "6X8Y4XdM2Vhvn0I=";
    private static final String MID_FILE_PATH = "6X8Y4XdM2Vhvn0KfzcEatGnWaNU=";
    private static final String STORAGE_TAG = "4kU71lN96TJUomD1vOU9lgj9Tw==";
    public static final int TYPE_STOREAGE_INTERNAL = 2;
    public static final int TYPE_STOREAGE_PERFERENCE = 4;
    public static final int TYPE_STOREAGE_SETTING = 1;
    public static final int VER_CURRENT = 3;
    public static final int VER_NEW = 1000001;
    public static final int VER_OLD = 0;
    protected static Logger logger = Util.getLogger();
    protected Context context = null;
    protected int version = 0;

    public abstract boolean checkPermission();

    public abstract void clear();

    public abstract int getType();

    public abstract String read();

    public abstract CheckEntity readCheckEntityIner();

    public abstract void write(String str);

    public abstract void writeCheckEntityIner(CheckEntity checkEntity);

    public String getStoreageTag() {
        int i = this.version;
        String str = STORAGE_TAG;
        if (i == 0) {
            return Util.decode(str);
        }
        StringBuilder sb = new StringBuilder();
        sb.append(Util.decode(str));
        sb.append(this.version);
        return sb.toString();
    }

    public String getMidDir() {
        int i = this.version;
        String str = MID_DIR;
        if (i == 0) {
            return Util.decode(str);
        }
        StringBuilder sb = new StringBuilder();
        sb.append(Util.decode(str));
        sb.append(this.version);
        return sb.toString();
    }

    public String getMidFilePath() {
        int i = this.version;
        String str = MID_FILE_PATH;
        if (i == 0) {
            return Util.decode(str);
        }
        StringBuilder sb = new StringBuilder();
        sb.append(Util.decode(str));
        sb.append(this.version);
        return sb.toString();
    }

    public String getCheckEntityTag() {
        int i = this.version;
        String str = CHECK_ENTITY_TAG;
        if (i == 0) {
            return Util.decode(str);
        }
        StringBuilder sb = new StringBuilder();
        sb.append(Util.decode(str));
        sb.append(this.version);
        return sb.toString();
    }

    /* access modifiers changed from: protected */
    public String getStorageKey() {
        int i = this.version;
        String str = STORAGE_TAG;
        if (i == 0) {
            return Util.decode(str);
        }
        StringBuilder sb = new StringBuilder();
        sb.append(Util.decode(str));
        sb.append(this.version);
        return sb.toString();
    }

    protected StorageInterface(Context context2, int i) {
        this.context = context2;
        this.version = i;
    }

    private String readMid() {
        if (checkPermission()) {
            return decrypt(read());
        }
        return null;
    }

    public MidEntity readMidEntity() {
        String readMid = readMid();
        if (readMid != null) {
            return MidEntity.parse(readMid);
        }
        return null;
    }

    private void writeMid(String str) {
        if (checkPermission()) {
            write(encrypt(str));
        }
    }

    public void writeMidEntity(MidEntity midEntity) {
        if (midEntity != null) {
            if (getType() == 4) {
                MidPreference.getInstance(this.context).writeMid(midEntity.getMid());
            }
            writeMid(midEntity.toString());
        }
    }

    /* access modifiers changed from: 0000 */
    public void doClear() {
        if (checkPermission()) {
            Logger logger2 = logger;
            StringBuilder sb = new StringBuilder();
            sb.append("clear mid:");
            sb.append(getType());
            logger2.mo35693d(sb.toString());
            clear();
        }
    }

    public CheckEntity readCheckEntity() {
        if (checkPermission()) {
            return readCheckEntityIner();
        }
        return null;
    }

    public void writeCheckEntity(CheckEntity checkEntity) {
        if (checkEntity != null && checkPermission()) {
            writeCheckEntityIner(checkEntity);
        }
    }

    /* access modifiers changed from: protected */
    public String encrypt(String str) {
        return Util.encode(str);
    }

    /* access modifiers changed from: protected */
    public String decrypt(String str) {
        return Util.decode(str);
    }
}
