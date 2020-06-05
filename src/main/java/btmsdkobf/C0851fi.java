package btmsdkobf;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import java.util.Map;

/* renamed from: btmsdkobf.fi */
public class C0851fi {
    /* renamed from: N */
    private SharedPreferences f994N;

    public C0851fi(Context context, String str) {
        if (context != null && !TextUtils.isEmpty(str)) {
            this.f994N = context.getSharedPreferences(str, 0);
        }
    }

    public void clear() {
        SharedPreferences sharedPreferences = this.f994N;
        if (sharedPreferences != null) {
            sharedPreferences.edit().clear().commit();
        }
    }

    public Map<String, ?> getAll() {
        SharedPreferences sharedPreferences = this.f994N;
        if (sharedPreferences == null) {
            return null;
        }
        return sharedPreferences.getAll();
    }

    public boolean getBoolean(String str, boolean z) {
        SharedPreferences sharedPreferences = this.f994N;
        return sharedPreferences == null ? z : sharedPreferences.getBoolean(str, z);
    }

    public int getInt(String str, int i) {
        SharedPreferences sharedPreferences = this.f994N;
        return sharedPreferences == null ? i : sharedPreferences.getInt(str, i);
    }

    public long getLong(String str, long j) {
        SharedPreferences sharedPreferences = this.f994N;
        return sharedPreferences == null ? j : sharedPreferences.getLong(str, j);
    }

    public String getString(String str, String str2) {
        SharedPreferences sharedPreferences = this.f994N;
        return sharedPreferences == null ? str2 : sharedPreferences.getString(str, str2);
    }

    public void putBoolean(String str, boolean z) {
        SharedPreferences sharedPreferences = this.f994N;
        if (sharedPreferences != null) {
            Editor edit = sharedPreferences.edit();
            edit.putBoolean(str, z);
            edit.commit();
        }
    }

    public void putInt(String str, int i) {
        SharedPreferences sharedPreferences = this.f994N;
        if (sharedPreferences != null) {
            Editor edit = sharedPreferences.edit();
            edit.putInt(str, i);
            edit.commit();
        }
    }

    public void putLong(String str, long j) {
        SharedPreferences sharedPreferences = this.f994N;
        if (sharedPreferences != null) {
            Editor edit = sharedPreferences.edit();
            edit.putLong(str, j);
            edit.commit();
        }
    }

    public void putString(String str, String str2) {
        SharedPreferences sharedPreferences = this.f994N;
        if (sharedPreferences != null) {
            Editor edit = sharedPreferences.edit();
            edit.putString(str, str2);
            edit.commit();
        }
    }

    public void remove(String str) {
        SharedPreferences sharedPreferences = this.f994N;
        if (sharedPreferences != null) {
            sharedPreferences.edit().remove(str).commit();
        }
    }
}
