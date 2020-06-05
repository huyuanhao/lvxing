package com.yanzhenjie.album.mvp;

import android.content.Context;
import android.os.Build.VERSION;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.PermissionChecker;
import com.tencent.mid.core.Constants;
import com.yanzhenjie.album.Album;
import com.yanzhenjie.album.p629b.AlbumUtils;
import java.util.ArrayList;
import java.util.List;

public class BaseActivity extends AppCompatActivity implements Bye {
    /* renamed from: g */
    public static final String[] f26328g;
    /* renamed from: h */
    public static final String[] f26329h;
    /* renamed from: i */
    public static final String[] f26330i;

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo37613b(int i) {
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public void mo37615c(int i) {
    }

    static {
        String str = "android.permission.CAMERA";
        String str2 = Constants.PERMISSION_WRITE_EXTERNAL_STORAGE;
        String str3 = "android.permission.READ_EXTERNAL_STORAGE";
        f26328g = new String[]{str, str3, str2};
        f26329h = new String[]{str, "android.permission.RECORD_AUDIO", str3, str2};
        f26330i = new String[]{str3, str2};
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        AlbumUtils.m33535a((Context) this, Album.m33246a().mo37674b());
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo37679a(String[] strArr, int i) {
        if (VERSION.SDK_INT >= 23) {
            List a = m33574a((Context) this, strArr);
            if (a.isEmpty()) {
                mo37613b(i);
                return;
            }
            String[] strArr2 = new String[a.size()];
            a.toArray(strArr2);
            ActivityCompat.requestPermissions(this, strArr2, i);
            return;
        }
        mo37613b(i);
    }

    public final void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (m33575a(i)) {
            mo37613b(i);
        } else {
            mo37615c(i);
        }
    }

    /* renamed from: h */
    public void mo37680h() {
        onBackPressed();
    }

    /* renamed from: a */
    private static List<String> m33574a(Context context, String... strArr) {
        ArrayList arrayList = new ArrayList(2);
        for (String str : strArr) {
            if (PermissionChecker.checkSelfPermission(context, str) != 0) {
                arrayList.add(str);
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    private static boolean m33575a(int... iArr) {
        for (int i : iArr) {
            if (i == -1) {
                return false;
            }
        }
        return true;
    }
}
