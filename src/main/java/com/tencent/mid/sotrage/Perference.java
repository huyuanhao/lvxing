package com.tencent.mid.sotrage;

import android.content.Context;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;
import com.tencent.mid.util.Logger;

public class Perference extends StorageInterface {
    /* access modifiers changed from: protected */
    public boolean checkPermission() {
        return true;
    }

    public int getType() {
        return 4;
    }

    public Perference(Context context, int i) {
        super(context, i);
    }

    /* access modifiers changed from: protected */
    public String read() {
        return read(getStorageKey());
    }

    public String read(String str) {
        String string;
        synchronized (this) {
            Logger logger = logger;
            StringBuilder sb = new StringBuilder();
            sb.append("read mid from sharedPreferences， key=");
            sb.append(str);
            logger.mo35700i(sb.toString());
            string = PreferenceManager.getDefaultSharedPreferences(this.context).getString(str, null);
        }
        return string;
    }

    /* access modifiers changed from: protected */
    public void write(String str) {
        write(getStorageKey(), str);
    }

    public void write(String str, String str2) {
        synchronized (this) {
            logger.mo35700i("write mid to sharedPreferences");
            Editor edit = PreferenceManager.getDefaultSharedPreferences(this.context).edit();
            edit.putString(str, str2);
            edit.commit();
        }
    }

    /* access modifiers changed from: protected */
    public void clear() {
        synchronized (this) {
            Editor edit = PreferenceManager.getDefaultSharedPreferences(this.context).edit();
            edit.putString(getStorageKey(), "");
            edit.putString(getCheckEntityTag(), "");
            edit.commit();
        }
    }

    /* access modifiers changed from: protected */
    public CheckEntity readCheckEntityIner() {
        CheckEntity checkEntity;
        synchronized (this) {
            checkEntity = new CheckEntity(PreferenceManager.getDefaultSharedPreferences(this.context).getString(getCheckEntityTag(), null));
            Logger logger = logger;
            StringBuilder sb = new StringBuilder();
            sb.append("read CheckEntity from sharedPreferences:");
            sb.append(checkEntity.toString());
            logger.mo35700i(sb.toString());
        }
        return checkEntity;
    }

    /* access modifiers changed from: protected */
    public void writeCheckEntityIner(CheckEntity checkEntity) {
        synchronized (this) {
            Logger logger = logger;
            StringBuilder sb = new StringBuilder();
            sb.append("write CheckEntity to sharedPreferences:");
            sb.append(checkEntity.toString());
            logger.mo35700i(sb.toString());
            Editor edit = PreferenceManager.getDefaultSharedPreferences(this.context).edit();
            edit.putString(getCheckEntityTag(), checkEntity.toString());
            edit.commit();
        }
    }
}
