package com.tencent.mid.sotrage;

import android.content.Context;
import com.tencent.mid.api.MidEntity;
import com.tencent.mid.util.Logger;
import com.tencent.mid.util.Util;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class UnifiedStorage {
    private static UnifiedStorage instance;
    private MidEntity cachedMid = null;
    private Context context = null;
    boolean firstRead = true;
    private Logger logger = Util.getLogger();
    MidEntity newVersionMidEntity = null;
    Map<Integer, StorageInterface> newVersionMidStorageMap = null;
    Map<Integer, StorageInterface> oldMidStorageMap = null;
    private Map<Integer, StorageInterface> storageMap = null;

    private UnifiedStorage(Context context2) {
        this.context = context2.getApplicationContext();
        this.storageMap = new HashMap(3);
        this.storageMap.put(Integer.valueOf(1), new SettingSystem(context2, 3));
        this.storageMap.put(Integer.valueOf(2), new InternalStorage(context2, 3));
        this.storageMap.put(Integer.valueOf(4), new Perference(context2, 3));
    }

    public static synchronized UnifiedStorage getInstance(Context context2) {
        UnifiedStorage unifiedStorage;
        synchronized (UnifiedStorage.class) {
            if (instance == null) {
                instance = new UnifiedStorage(context2);
            }
            unifiedStorage = instance;
        }
        return unifiedStorage;
    }

    private Map<Integer, StorageInterface> getNewVersionMidStorageMap() {
        if (this.newVersionMidStorageMap == null) {
            this.newVersionMidStorageMap = new HashMap(3);
            this.newVersionMidStorageMap.put(Integer.valueOf(1), new SettingSystem(this.context, StorageInterface.VER_NEW));
            this.newVersionMidStorageMap.put(Integer.valueOf(2), new InternalStorage(this.context, StorageInterface.VER_NEW));
            this.newVersionMidStorageMap.put(Integer.valueOf(4), new Perference(this.context, StorageInterface.VER_NEW));
        }
        return this.newVersionMidStorageMap;
    }

    public MidEntity readNewVersionMidEntity() {
        getNewVersionMidStorageMap();
        if (!Util.isMidValid(this.newVersionMidEntity)) {
            this.newVersionMidEntity = readMidEntity(new ArrayList(Arrays.asList(new Integer[]{Integer.valueOf(4), Integer.valueOf(1), Integer.valueOf(2)})), this.newVersionMidStorageMap);
        }
        Logger logger2 = this.logger;
        StringBuilder sb = new StringBuilder();
        sb.append("readNewVersionMidEntity:");
        sb.append(this.newVersionMidEntity);
        logger2.mo35693d(sb.toString());
        return this.newVersionMidEntity;
    }

    public String readNewVersionMidStr() {
        readNewVersionMidEntity();
        return Util.isMidValid(this.newVersionMidEntity) ? this.newVersionMidEntity.getMid() : "";
    }

    public void writeNewVersionMidEntity(MidEntity midEntity) {
        writeNewVersionMidEntityWithProvider(midEntity, true);
    }

    public void writeNewVersionMidEntityWithProvider(MidEntity midEntity, boolean z) {
        if (midEntity.getTimestamps() <= 0) {
            midEntity.setTimestamps(System.currentTimeMillis());
        }
        Logger logger2 = this.logger;
        StringBuilder sb = new StringBuilder();
        sb.append("writeNewVersionMidEntity midEntity:");
        sb.append(midEntity);
        logger2.mo35693d(sb.toString());
        for (Entry value : getNewVersionMidStorageMap().entrySet()) {
            ((StorageInterface) value.getValue()).writeMidEntity(midEntity);
        }
        if (z) {
            Context context2 = this.context;
            if (context2 != null) {
                Util.insertMid2Provider(context2, context2.getPackageName(), midEntity.toString());
            }
        }
    }

    public MidEntity readPrivateNewVersionMidEntity() {
        return readSpecialTypeMidEntity(4, getNewVersionMidStorageMap());
    }

    public MidEntity readSettingNewVersionMidEntity() {
        return readSpecialTypeMidEntity(1, getNewVersionMidStorageMap());
    }

    public MidEntity readSdCarkNewVersionMidEntity() {
        return readSpecialTypeMidEntity(2, getNewVersionMidStorageMap());
    }

    public void writePrivateNewVersionMidEntity(MidEntity midEntity) {
        getNewVersionMidStorageMap();
        StorageInterface storageInterface = (StorageInterface) this.newVersionMidStorageMap.get(Integer.valueOf(4));
        if (storageInterface != null) {
            storageInterface.writeMidEntity(midEntity);
        }
    }

    public void writePublicNewVersionMidEntity(MidEntity midEntity) {
        getNewVersionMidStorageMap();
        StorageInterface storageInterface = (StorageInterface) this.newVersionMidStorageMap.get(Integer.valueOf(1));
        if (storageInterface != null) {
            storageInterface.writeMidEntity(midEntity);
        }
        StorageInterface storageInterface2 = (StorageInterface) this.newVersionMidStorageMap.get(Integer.valueOf(2));
        if (storageInterface2 != null) {
            storageInterface2.writeMidEntity(midEntity);
        }
    }

    private Map<Integer, StorageInterface> getOldMidStorageMap() {
        if (this.oldMidStorageMap == null) {
            this.oldMidStorageMap = new HashMap(3);
            this.oldMidStorageMap.put(Integer.valueOf(1), new SettingSystem(this.context, 0));
            this.oldMidStorageMap.put(Integer.valueOf(2), new InternalStorage(this.context, 0));
            this.oldMidStorageMap.put(Integer.valueOf(4), new Perference(this.context, 0));
        }
        return this.oldMidStorageMap;
    }

    private MidEntity readOldMid() {
        MidEntity readMidEntity = new SettingSystem(this.context, 0).readMidEntity();
        if (!Util.isMidValid(readMidEntity)) {
            readMidEntity = new InternalStorage(this.context, 0).readMidEntity();
        }
        if (!Util.isMidValid(readMidEntity)) {
            readMidEntity = new Perference(this.context, 0).readMidEntity();
        }
        if (!Util.isMidValid(readMidEntity)) {
            return null;
        }
        return readMidEntity;
    }

    public String readMidString() {
        try {
            readMidEntity();
            if (this.cachedMid != null) {
                return this.cachedMid.getMid();
            }
        } catch (Throwable th) {
            Logger logger2 = this.logger;
            StringBuilder sb = new StringBuilder();
            sb.append("readMidString ");
            sb.append(th);
            logger2.mo35696e((Object) sb.toString());
        }
        return "0";
    }

    public long readGuid() {
        try {
            readMidEntity();
            if (this.cachedMid != null) {
                return this.cachedMid.getGuid();
            }
        } catch (Throwable th) {
            Logger logger2 = this.logger;
            StringBuilder sb = new StringBuilder();
            sb.append("readMidString ");
            sb.append(th);
            logger2.mo35696e((Object) sb.toString());
        }
        return 0;
    }

    public MidEntity readMidEntity() {
        boolean isMidValid = Util.isMidValid(this.cachedMid);
        String str = "read the new one";
        Integer valueOf = Integer.valueOf(4);
        Integer valueOf2 = Integer.valueOf(1);
        if (!isMidValid) {
            this.logger.mo35693d(str);
            this.cachedMid = readMidEntity(new ArrayList(Arrays.asList(new Integer[]{valueOf})), this.storageMap);
        }
        String str2 = " to new version.";
        String str3 = "copy old mid:";
        String str4 = "load from the old one";
        if (!Util.isMidValid(this.cachedMid)) {
            this.logger.mo35693d(str4);
            MidEntity readMidEntity = readMidEntity(new ArrayList(Arrays.asList(new Integer[]{valueOf})), getOldMidStorageMap());
            if (Util.isMidValid(readMidEntity)) {
                Logger logger2 = this.logger;
                StringBuilder sb = new StringBuilder();
                sb.append(str3);
                sb.append(readMidEntity.getMid());
                sb.append(str2);
                logger2.mo35708w(sb.toString());
                this.cachedMid = readMidEntity;
                writeMidEntity(this.cachedMid);
            }
        }
        if (!Util.isMidValid(this.cachedMid)) {
            this.logger.mo35693d("mid query other app");
            Map midsByApps = Util.getMidsByApps(this.context, 2);
            if (midsByApps != null && midsByApps.size() > 0) {
                Iterator it = midsByApps.entrySet().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    MidEntity midEntity = (MidEntity) ((Entry) it.next()).getValue();
                    if (midEntity != null && midEntity.isMidValid()) {
                        this.cachedMid = midEntity;
                        break;
                    }
                }
            }
        }
        if (!Util.isMidValid(this.cachedMid)) {
            this.logger.mo35693d(str);
            this.cachedMid = readMidEntity(new ArrayList(Arrays.asList(new Integer[]{valueOf, valueOf2, Integer.valueOf(2)})), this.storageMap);
        }
        if (!Util.isMidValid(this.cachedMid)) {
            this.logger.mo35693d(str4);
            MidEntity readMidEntity2 = readMidEntity(new ArrayList(Arrays.asList(new Integer[]{valueOf2, Integer.valueOf(2), valueOf})), getOldMidStorageMap());
            if (Util.isMidValid(readMidEntity2)) {
                Logger logger3 = this.logger;
                StringBuilder sb2 = new StringBuilder();
                sb2.append(str3);
                sb2.append(readMidEntity2.getMid());
                sb2.append(str2);
                logger3.mo35708w(sb2.toString());
                this.cachedMid = readMidEntity2;
                writeMidEntity(this.cachedMid);
            }
        }
        if (this.firstRead) {
            this.logger.mo35693d("firstRead");
            MidEntity readPrivateMidEntity = readPrivateMidEntity();
            if (readPrivateMidEntity == null || !readPrivateMidEntity.isMidValid()) {
                writePrivateMidEntity(this.cachedMid);
            }
            this.firstRead = false;
        }
        MidEntity midEntity2 = this.cachedMid;
        return midEntity2 != null ? midEntity2 : new MidEntity();
    }

    public MidEntity readMidEntity(List<Integer> list) {
        return readMidEntity(list, this.storageMap);
    }

    public void writePrivateMidEntity(MidEntity midEntity) {
        StorageInterface storageInterface = (StorageInterface) this.storageMap.get(Integer.valueOf(4));
        if (storageInterface != null) {
            storageInterface.writeMidEntity(midEntity);
        }
    }

    public void writePublicMidEntity(MidEntity midEntity) {
        StorageInterface storageInterface = (StorageInterface) this.storageMap.get(Integer.valueOf(1));
        if (storageInterface != null) {
            storageInterface.writeMidEntity(midEntity);
        }
        StorageInterface storageInterface2 = (StorageInterface) this.storageMap.get(Integer.valueOf(2));
        if (storageInterface2 != null) {
            storageInterface2.writeMidEntity(midEntity);
        }
    }

    public MidEntity readPrivateMidEntity() {
        return readSpecialTypeMidEntity(4, this.storageMap);
    }

    public MidEntity readSettingMidEntity() {
        return readSpecialTypeMidEntity(1, this.storageMap);
    }

    public MidEntity readSdCarkMidEntity() {
        return readSpecialTypeMidEntity(2, this.storageMap);
    }

    private MidEntity readSpecialTypeMidEntity(int i, Map<Integer, StorageInterface> map) {
        if (this.storageMap != null) {
            StorageInterface storageInterface = (StorageInterface) map.get(Integer.valueOf(i));
            if (storageInterface != null) {
                return storageInterface.readMidEntity();
            }
        }
        return null;
    }

    public MidEntity readMidEntity(List<Integer> list, Map<Integer, StorageInterface> map) {
        if (!(list == null || list.size() == 0 || map == null || map.size() == 0)) {
            for (Integer num : list) {
                StorageInterface storageInterface = (StorageInterface) map.get(num);
                if (storageInterface != null) {
                    MidEntity readMidEntity = storageInterface.readMidEntity();
                    if (readMidEntity != null && readMidEntity.isMidValid()) {
                        return readMidEntity;
                    }
                }
            }
        }
        return null;
    }

    public void resetCheckEntity(int i, int i2) {
        CheckEntity readCheckEntity = readCheckEntity();
        if (i > 0) {
            readCheckEntity.setMaxFreq(i);
        }
        if (i2 > 0) {
            readCheckEntity.setMaxDays(i2);
        }
        readCheckEntity.setLastCheckTimestamps(System.currentTimeMillis());
        readCheckEntity.setLastCheckTimes(0);
        writeCheckEntity(readCheckEntity);
    }

    public CheckEntity readCheckEntity() {
        return readCheckEntity(new ArrayList(Arrays.asList(new Integer[]{Integer.valueOf(1), Integer.valueOf(4)})));
    }

    public CheckEntity readCheckEntity(List<Integer> list) {
        if (!(list == null || list.size() == 0)) {
            for (Integer num : list) {
                StorageInterface storageInterface = (StorageInterface) this.storageMap.get(num);
                if (storageInterface != null) {
                    CheckEntity readCheckEntity = storageInterface.readCheckEntity();
                    if (readCheckEntity != null) {
                        return readCheckEntity;
                    }
                }
            }
        }
        return null;
    }

    public void clear() {
        for (Entry value : this.storageMap.entrySet()) {
            ((StorageInterface) value.getValue()).doClear();
        }
        this.cachedMid = null;
    }

    public void clearOldMid() {
        getOldMidStorageMap();
        for (Entry value : this.oldMidStorageMap.entrySet()) {
            ((StorageInterface) value.getValue()).doClear();
        }
    }

    public void clearNewVersionMid() {
        getNewVersionMidStorageMap();
        for (Entry value : this.newVersionMidStorageMap.entrySet()) {
            ((StorageInterface) value.getValue()).doClear();
        }
        this.newVersionMidEntity = null;
    }

    public void writeCheckEntity(CheckEntity checkEntity) {
        if (checkEntity.getLastCheckTimestamps() <= 0) {
            checkEntity.setLastCheckTimestamps(System.currentTimeMillis());
        }
        for (Entry value : this.storageMap.entrySet()) {
            ((StorageInterface) value.getValue()).writeCheckEntity(checkEntity);
        }
    }

    public void writeMidEntity(MidEntity midEntity) {
        if (midEntity.getTimestamps() <= 0) {
            midEntity.setTimestamps(System.currentTimeMillis());
        }
        for (Entry value : this.storageMap.entrySet()) {
            ((StorageInterface) value.getValue()).writeMidEntity(midEntity);
        }
    }

    public void writeMidEntityWithProvide(MidEntity midEntity, boolean z) {
        if (midEntity.getTimestamps() <= 0) {
            midEntity.setTimestamps(System.currentTimeMillis());
        }
        for (Entry value : this.storageMap.entrySet()) {
            ((StorageInterface) value.getValue()).writeMidEntity(midEntity);
        }
        if (z) {
            Context context2 = this.context;
            if (context2 != null) {
                Util.insertMid2OldProvider(context2, context2.getPackageName(), midEntity.toString());
            }
        }
    }

    public void writeOldMidEntity(MidEntity midEntity) {
        if (midEntity.getTimestamps() <= 0) {
            midEntity.setTimestamps(System.currentTimeMillis());
        }
        for (Entry value : getOldMidStorageMap().entrySet()) {
            ((StorageInterface) value.getValue()).writeMidEntity(midEntity);
        }
    }
}
