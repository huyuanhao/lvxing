package com.tencent.mid.util;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Build.VERSION;
import android.provider.Settings.System;
import com.tencent.mid.core.Constants;
import java.lang.reflect.Method;

public class SettingsHelper {
    private static volatile SettingsHelper instnce;
    private boolean canWrite = false;
    private Context context = null;
    private int cur = 0;
    private int logLimit = 10;

    public boolean putString(String str, String str2) {
        if (this.canWrite) {
            try {
                return System.putString(this.context.getContentResolver(), str, str2);
            } catch (Throwable th) {
                int i = this.cur;
                this.cur = i + 1;
                if (i < this.logLimit) {
                    th.printStackTrace();
                }
            }
        }
        return false;
    }

    public String getString(String str) {
        try {
            return System.getString(this.context.getContentResolver(), str);
        } catch (Throwable th) {
            int i = this.cur;
            this.cur = i + 1;
            if (i < this.logLimit) {
                th.printStackTrace();
            }
            return null;
        }
    }

    public boolean putInt(String str, int i) {
        if (this.canWrite) {
            try {
                return System.putInt(this.context.getContentResolver(), str, i);
            } catch (Throwable th) {
                int i2 = this.cur;
                this.cur = i2 + 1;
                if (i2 < this.logLimit) {
                    th.printStackTrace();
                }
            }
        }
        return false;
    }

    public int getInt(String str, int i) {
        try {
            return System.getInt(this.context.getContentResolver(), str, i);
        } catch (Throwable th) {
            int i2 = this.cur;
            this.cur = i2 + 1;
            if (i2 < this.logLimit) {
                th.printStackTrace();
            }
            return i;
        }
    }

    public boolean putLong(String str, long j) {
        if (this.canWrite) {
            try {
                return System.putLong(this.context.getContentResolver(), str, j);
            } catch (Throwable th) {
                int i = this.cur;
                this.cur = i + 1;
                if (i < this.logLimit) {
                    th.printStackTrace();
                }
            }
        }
        return false;
    }

    public long getLong(String str, long j) {
        try {
            return System.getLong(this.context.getContentResolver(), str, j);
        } catch (Throwable th) {
            int i = this.cur;
            this.cur = i + 1;
            if (i < this.logLimit) {
                th.printStackTrace();
            }
            return j;
        }
    }

    public boolean putFloat(String str, float f) {
        if (this.canWrite) {
            try {
                return System.putFloat(this.context.getContentResolver(), str, f);
            } catch (Throwable th) {
                int i = this.cur;
                this.cur = i + 1;
                if (i < this.logLimit) {
                    th.printStackTrace();
                }
            }
        }
        return false;
    }

    public float getFloat(String str, float f) {
        try {
            return System.getFloat(this.context.getContentResolver(), str, f);
        } catch (Throwable th) {
            int i = this.cur;
            this.cur = i + 1;
            if (i < this.logLimit) {
                th.printStackTrace();
            }
            return f;
        }
    }

    public boolean putConfiguration(Configuration configuration) {
        if (this.canWrite) {
            try {
                return System.putConfiguration(this.context.getContentResolver(), configuration);
            } catch (Throwable th) {
                int i = this.cur;
                this.cur = i + 1;
                if (i < this.logLimit) {
                    th.printStackTrace();
                }
            }
        }
        return false;
    }

    private SettingsHelper(Context context2) {
        this.context = context2.getApplicationContext();
        try {
            this.canWrite = Util.checkPermission(this.context, Constants.PERMISSION_WRITE_SETTINGS);
            if (this.canWrite && VERSION.SDK_INT >= 23) {
                Method declaredMethod = System.class.getDeclaredMethod("canWrite", new Class[]{Context.class});
                declaredMethod.setAccessible(true);
                this.canWrite = ((Boolean) declaredMethod.invoke(null, new Object[]{this.context})).booleanValue();
            }
        } catch (Throwable th) {
            int i = this.cur;
            this.cur = i + 1;
            if (i < this.logLimit) {
                th.printStackTrace();
            }
        }
    }

    public static SettingsHelper getInstance(Context context2) {
        if (instnce == null) {
            synchronized (SettingsHelper.class) {
                if (instnce == null) {
                    instnce = new SettingsHelper(context2);
                }
            }
        }
        return instnce;
    }
}
