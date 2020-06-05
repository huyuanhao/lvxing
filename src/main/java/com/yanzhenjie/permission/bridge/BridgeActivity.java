package com.yanzhenjie.permission.bridge;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.KeyEvent;
import com.yanzhenjie.permission.p636d.p637a.LSettingPage;
import com.yanzhenjie.permission.p636d.p637a.MSettingPage;
import com.yanzhenjie.permission.source.C7846a;
import com.yanzhenjie.permission.source.C7847b;

public final class BridgeActivity extends Activity {
    /* renamed from: a */
    private String f26638a;

    /* renamed from: a */
    static void m33999a(C7847b bVar, String str) {
        Intent intent = new Intent(bVar.mo38075a(), BridgeActivity.class);
        intent.putExtra("KEY_TYPE", 1);
        intent.putExtra("KEY_ACTION_SUFFIX", str);
        bVar.mo38076a(intent);
    }

    /* renamed from: a */
    static void m34000a(C7847b bVar, String str, String[] strArr) {
        Intent intent = new Intent(bVar.mo38075a(), BridgeActivity.class);
        intent.putExtra("KEY_TYPE", 2);
        intent.putExtra("KEY_PERMISSIONS", strArr);
        intent.putExtra("KEY_ACTION_SUFFIX", str);
        bVar.mo38076a(intent);
    }

    /* renamed from: b */
    static void m34001b(C7847b bVar, String str) {
        Intent intent = new Intent(bVar.mo38075a(), BridgeActivity.class);
        intent.putExtra("KEY_TYPE", 3);
        intent.putExtra("KEY_ACTION_SUFFIX", str);
        bVar.mo38076a(intent);
    }

    /* renamed from: c */
    static void m34002c(C7847b bVar, String str) {
        Intent intent = new Intent(bVar.mo38075a(), BridgeActivity.class);
        intent.putExtra("KEY_TYPE", 4);
        intent.putExtra("KEY_ACTION_SUFFIX", str);
        bVar.mo38076a(intent);
    }

    /* renamed from: d */
    static void m34003d(C7847b bVar, String str) {
        Intent intent = new Intent(bVar.mo38075a(), BridgeActivity.class);
        intent.putExtra("KEY_TYPE", 5);
        intent.putExtra("KEY_ACTION_SUFFIX", str);
        bVar.mo38076a(intent);
    }

    /* renamed from: e */
    static void m34004e(C7847b bVar, String str) {
        Intent intent = new Intent(bVar.mo38075a(), BridgeActivity.class);
        intent.putExtra("KEY_TYPE", 6);
        intent.putExtra("KEY_ACTION_SUFFIX", str);
        bVar.mo38076a(intent);
    }

    /* renamed from: f */
    static void m34005f(C7847b bVar, String str) {
        Intent intent = new Intent(bVar.mo38075a(), BridgeActivity.class);
        intent.putExtra("KEY_TYPE", 7);
        intent.putExtra("KEY_ACTION_SUFFIX", str);
        bVar.mo38076a(intent);
    }

    /* renamed from: g */
    static void m34006g(C7847b bVar, String str) {
        Intent intent = new Intent(bVar.mo38075a(), BridgeActivity.class);
        intent.putExtra("KEY_TYPE", 8);
        intent.putExtra("KEY_ACTION_SUFFIX", str);
        bVar.mo38076a(intent);
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle == null) {
            Intent intent = getIntent();
            int intExtra = intent.getIntExtra("KEY_TYPE", -1);
            this.f26638a = intent.getStringExtra("KEY_ACTION_SUFFIX");
            String str = "package";
            switch (intExtra) {
                case 1:
                    Intent intent2 = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
                    intent2.setData(Uri.fromParts(str, getPackageName(), null));
                    startActivityForResult(intent2, 1);
                    break;
                case 2:
                    requestPermissions(intent.getStringArrayExtra("KEY_PERMISSIONS"), 2);
                    break;
                case 3:
                    Intent intent3 = new Intent("android.settings.MANAGE_UNKNOWN_APP_SOURCES");
                    intent3.setData(Uri.fromParts(str, getPackageName(), null));
                    startActivityForResult(intent3, 3);
                    break;
                case 4:
                    new MSettingPage(new C7846a(this)).mo38050a(4);
                    break;
                case 5:
                    new LSettingPage(new C7846a(this)).mo38049a(5);
                    break;
                case 6:
                    Intent intent4 = new Intent("android.settings.APP_NOTIFICATION_SETTINGS");
                    intent4.putExtra("android.provider.extra.APP_PACKAGE", getPackageName());
                    intent4.setData(Uri.fromParts(str, getPackageName(), null));
                    startActivityForResult(intent4, 6);
                    break;
                case 7:
                    Intent intent5 = new Intent("android.settings.ACTION_NOTIFICATION_LISTENER_SETTINGS");
                    intent5.setData(Uri.fromParts(str, getPackageName(), null));
                    startActivityForResult(intent5, 7);
                    break;
                case 8:
                    Intent intent6 = new Intent("android.settings.action.MANAGE_WRITE_SETTINGS");
                    intent6.setData(Uri.fromParts(str, getPackageName(), null));
                    startActivityForResult(intent6, 8);
                    break;
            }
        }
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        Messenger.m34041a(this, this.f26638a);
        finish();
    }

    public void startActivityForResult(Intent intent, int i) {
        super.startActivityForResult(intent, i);
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        Messenger.m34041a(this, this.f26638a);
        finish();
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }
}
