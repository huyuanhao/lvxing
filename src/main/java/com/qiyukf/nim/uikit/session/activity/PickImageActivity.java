package com.qiyukf.nim.uikit.session.activity;

import android.content.ActivityNotFoundException;
import android.content.ContentResolver;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore.Images.Media;
import android.text.TextUtils;
import androidx.fragment.app.Fragment;
import com.qiyukf.basesdk.p393a.C5264a;
import com.qiyukf.basesdk.p412c.p417d.C5415g;
import com.qiyukf.nim.uikit.common.activity.BaseFragmentActivity;
import com.qiyukf.nim.uikit.common.media.picker.activity.PickerAlbumActivity;
import com.qiyukf.nim.uikit.provider.UnicornProvider;
import com.qiyukf.unicorn.C5961R;
import com.tencent.p605ep.common.adapt.iservice.account.AccountConst.ArgKey;
import java.io.File;

public class PickImageActivity extends BaseFragmentActivity {
    /* renamed from: b */
    private boolean f17718b = false;

    /* renamed from: a */
    private static void m22400a(Cursor cursor) {
        if (cursor != null && !cursor.isClosed()) {
            cursor.close();
        }
    }

    public static void start(Fragment fragment, int i, int i2, String str) {
        Intent intent = new Intent(fragment.getActivity(), PickImageActivity.class);
        intent.putExtra("from", i2);
        intent.putExtra("file_path", str);
        fragment.startActivityForResult(intent, i);
    }

    public static void start(Fragment fragment, int i, int i2, String str, boolean z, int i3, boolean z2, boolean z3, int i4, int i5) {
        Intent intent = new Intent(fragment.getActivity(), PickImageActivity.class);
        intent.putExtra("from", i2);
        intent.putExtra("file_path", str);
        intent.putExtra("multi_select_mode", z);
        intent.putExtra("multi_select_size_limit", i3);
        intent.putExtra("support_original", z2);
        intent.putExtra("need-crop", z3);
        intent.putExtra("outputX", i4);
        intent.putExtra("outputY", i5);
        fragment.startActivityForResult(intent, i);
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        String str = "file_path";
        super.onActivityResult(i, i2, intent);
        if (i2 != -1) {
            setResult(i2);
        } else {
            String str2 = "from_local";
            String str3 = "";
            if (i != 1) {
                if (i == 2) {
                    try {
                        String stringExtra = getIntent().getStringExtra(str);
                        if (intent != null) {
                            if (intent.getData() != null) {
                                Uri data = intent.getData();
                                Cursor query = getContentResolver().query(data, null, null, null, null);
                                if (query != null) {
                                    if (data.toString().contains("content://com.android.providers.media.documents/document/image")) {
                                        String decode = Uri.decode(data.toString());
                                        String substring = decode.substring(decode.lastIndexOf(":") + 1);
                                        m22400a(query);
                                        ContentResolver contentResolver = getContentResolver();
                                        Uri uri = Media.EXTERNAL_CONTENT_URI;
                                        StringBuilder sb = new StringBuilder(" _id = ");
                                        sb.append(substring);
                                        query = contentResolver.query(uri, null, sb.toString(), null, null);
                                    }
                                    if (query != null) {
                                        query.moveToFirst();
                                        int columnIndex = query.getColumnIndex("_data");
                                        if (columnIndex >= 0) {
                                            stringExtra = query.getString(columnIndex);
                                        }
                                        m22400a(query);
                                    }
                                }
                            }
                        }
                        if (!TextUtils.isEmpty(stringExtra)) {
                            Intent intent2 = new Intent();
                            intent2.putExtra(str2, false);
                            intent2.putExtra(str, stringExtra);
                            setResult(-1, intent2);
                        }
                        finish();
                        return;
                    } catch (Exception e) {
                        C5415g.m22165b(C5961R.string.ysf_picker_image_error);
                        C5264a.m21621b("onPickedCamera is error", str3, e);
                        finish();
                    }
                }
                return;
            }
            if (intent != null) {
                try {
                    Intent intent3 = new Intent(intent);
                    intent3.putExtra(str2, true);
                    setResult(-1, intent3);
                    finish();
                } catch (Exception e2) {
                    C5415g.m22165b(C5961R.string.ysf_picker_image_error);
                    C5264a.m21621b("onPickedLocal is error", str3, e2);
                }
            }
            return;
        }
        finish();
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(C5961R.C5964layout.ysf_pick_image_activity);
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        if (bundle != null) {
            this.f17718b = bundle.getBoolean(ArgKey.KEY_STATE);
        }
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        String str = "support_original";
        String str2 = "multi_select_size_limit";
        String str3 = "pickFromCamera is error";
        String str4 = "multi_select_mode";
        super.onResume();
        if (!this.f17718b) {
            String str5 = "";
            if (getIntent().getIntExtra("from", 1) == 1) {
                try {
                    boolean booleanExtra = getIntent().getBooleanExtra(str4, false);
                    int intExtra = getIntent().getIntExtra(str2, 9);
                    boolean booleanExtra2 = getIntent().getBooleanExtra(str, false);
                    Intent intent = new Intent();
                    intent.setClass(this, PickerAlbumActivity.class);
                    intent.putExtra(str4, booleanExtra);
                    intent.putExtra(str2, intExtra);
                    intent.putExtra(str, booleanExtra2);
                    startActivityForResult(intent, 1);
                } catch (Exception e) {
                    C5264a.m21621b("pickFromLocal is error", str5, e);
                    C5415g.m22165b(C5961R.string.ysf_picker_image_sdcard_not_enough_error);
                    finish();
                }
            } else {
                try {
                    String stringExtra = getIntent().getStringExtra("file_path");
                    if (TextUtils.isEmpty(stringExtra)) {
                        C5415g.m22165b(C5961R.string.ysf_picker_image_sdcard_not_enough_error);
                        finish();
                    } else {
                        File file = new File(stringExtra);
                        Intent intent2 = new Intent("android.media.action.IMAGE_CAPTURE");
                        intent2.addFlags(1);
                        intent2.putExtra("output", UnicornProvider.m22379a(this) ? UnicornProvider.m22378a(this, file) : Uri.fromFile(file));
                        startActivityForResult(intent2, 2);
                    }
                } catch (ActivityNotFoundException e2) {
                    e = e2;
                    finish();
                    C5264a.m21621b(str3, str5, e);
                    this.f17718b = true;
                } catch (Exception e3) {
                    e = e3;
                    C5415g.m22165b(C5961R.string.ysf_picker_image_sdcard_not_enough_error);
                    C5264a.m21621b(str3, str5, e);
                    this.f17718b = true;
                }
            }
            this.f17718b = true;
        }
    }

    /* access modifiers changed from: protected */
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean(ArgKey.KEY_STATE, this.f17718b);
    }
}
