package com.tencent.mid.sotrage;

import android.content.Context;
import com.tencent.mid.core.Constants;
import com.tencent.mid.util.Logger;
import com.tencent.mid.util.SettingsHelper;
import com.tencent.mid.util.Util;

public class SettingSystem extends StorageInterface {
    protected static Logger logger = Util.getLogger();

    public int getType() {
        return 1;
    }

    public SettingSystem(Context context, int i) {
        super(context, i);
    }

    /* access modifiers changed from: protected */
    public boolean checkPermission() {
        return Util.checkPermission(this.context, Constants.PERMISSION_WRITE_SETTINGS);
    }

    /* access modifiers changed from: protected */
    public String read() {
        String string;
        synchronized (this) {
            logger.mo35700i("read mid from Settings.System");
            string = SettingsHelper.getInstance(this.context).getString(getStorageKey());
        }
        return string;
    }

    /* access modifiers changed from: protected */
    public void write(String str) {
        synchronized (this) {
            logger.mo35700i("write mid to Settings.System");
            SettingsHelper.getInstance(this.context).putString(getStorageKey(), str);
        }
    }

    /* access modifiers changed from: protected */
    public void clear() {
        synchronized (this) {
            SettingsHelper.getInstance(this.context).putString(getStorageKey(), "");
            SettingsHelper.getInstance(this.context).putString(getCheckEntityTag(), "");
        }
    }

    /* access modifiers changed from: protected */
    public CheckEntity readCheckEntityIner() {
        CheckEntity checkEntity;
        synchronized (this) {
            checkEntity = new CheckEntity(SettingsHelper.getInstance(this.context).getString(getCheckEntityTag()));
            Logger logger2 = logger;
            StringBuilder sb = new StringBuilder();
            sb.append("read readCheckEntity from Settings.System:");
            sb.append(checkEntity.toString());
            logger2.mo35700i(sb.toString());
        }
        return checkEntity;
    }

    /* access modifiers changed from: protected */
    public void writeCheckEntityIner(CheckEntity checkEntity) {
        synchronized (this) {
            Logger logger2 = logger;
            StringBuilder sb = new StringBuilder();
            sb.append("write CheckEntity to Settings.System:");
            sb.append(checkEntity.toString());
            logger2.mo35700i(sb.toString());
            SettingsHelper.getInstance(this.context).putString(getCheckEntityTag(), checkEntity.toString());
        }
    }
}
