package com.qiyukf.nim.uikit.session.helper;

import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import androidx.fragment.app.Fragment;
import com.qiyukf.basesdk.p394b.p395a.p404c.C5312a;
import com.qiyukf.basesdk.p412c.C5399c;
import com.qiyukf.basesdk.p412c.C5399c.C5400a;
import com.qiyukf.basesdk.p412c.p416c.C5405c;
import com.qiyukf.basesdk.p412c.p416c.C5406d;
import com.qiyukf.basesdk.p412c.p417d.C5409b;
import com.qiyukf.basesdk.p412c.p417d.C5415g;
import com.qiyukf.nim.uikit.common.fragment.TFragment;
import com.qiyukf.nim.uikit.session.activity.CaptureVideoActivity;
import com.qiyukf.nim.uikit.session.activity.PickImageActivity;
import com.qiyukf.nimlib.p488k.p491c.C5944b;
import com.qiyukf.nimlib.p488k.p491c.C5946c;
import com.qiyukf.unicorn.C5961R;
import com.qiyukf.unicorn.widget.p521a.C6364g;
import com.qiyukf.unicorn.widget.p521a.C6364g.C6365a;
import com.tencent.mid.core.Constants;
import java.io.File;

/* renamed from: com.qiyukf.nim.uikit.session.helper.c */
public final class C5557c {
    /* renamed from: a */
    private static String f17908a;
    /* renamed from: b */
    private static File f17909b;

    /* renamed from: com.qiyukf.nim.uikit.session.helper.c$a */
    public interface C5562a {
        /* renamed from: a */
        void mo27696a(File file);
    }

    /* renamed from: a */
    public static void m22586a(Intent intent, C5562a aVar) {
        File file = f17909b;
        if (file == null || !file.exists()) {
            String stringExtra = intent.getStringExtra("EXTRA_DATA_FILE_NAME");
            if (!TextUtils.isEmpty(stringExtra)) {
                f17909b = new File(stringExtra);
            }
        }
        File file2 = f17909b;
        if (file2 != null && file2.exists()) {
            if (f17909b.length() <= 0) {
                f17909b.delete();
                return;
            }
            String path = f17909b.getPath();
            String b = C5405c.m22115b(path);
            StringBuilder sb = new StringBuilder();
            sb.append(b);
            sb.append(".mp4");
            String a = C5946c.m23834a(sb.toString(), C5944b.TYPE_VIDEO);
            if (C5312a.m21839b(path, a) && aVar != null) {
                aVar.mo27696a(new File(a));
            }
        }
    }

    /* renamed from: a */
    protected static void m22587a(TFragment tFragment) {
        if (C5946c.m23839a(C5944b.TYPE_VIDEO)) {
            StringBuilder sb = new StringBuilder();
            sb.append(C5406d.m22116a());
            sb.append(".mp4");
            String a = C5946c.m23834a(sb.toString(), C5944b.TYPE_TEMP);
            f17908a = a;
            String str = "this is ";
            String str2 = "TAG";
            if (a == null) {
                StringBuilder sb2 = new StringBuilder("videoFilePath = ");
                sb2.append(f17908a);
                sb2.append(str);
                Log.e(str2, sb2.toString());
                return;
            }
            f17909b = new File(f17908a);
            StringBuilder sb3 = new StringBuilder("videoFile = ");
            sb3.append(f17909b);
            sb3.append(str);
            Log.e(str2, sb3.toString());
            CaptureVideoActivity.start(tFragment, f17908a, 1);
        }
    }

    /* renamed from: a */
    public static void m22588a(final TFragment tFragment, final int i, final boolean z, final String str, boolean z2) {
        if (tFragment.isAdded()) {
            C5409b.m22132a((Fragment) tFragment);
            CharSequence[] charSequenceArr = new CharSequence[3];
            charSequenceArr[0] = tFragment.getString(C5961R.string.ysf_input_panel_take);
            if (z2) {
                charSequenceArr[1] = tFragment.getString(C5961R.string.ysf_pick_video_record);
                charSequenceArr[2] = tFragment.getString(C5961R.string.ysf_picker_image_choose_from_photo_album);
            } else {
                charSequenceArr[1] = tFragment.getString(C5961R.string.ysf_picker_image_choose_from_photo_album);
            }
            C6364g.m25003a(tFragment.getContext(), (CharSequence) null, charSequenceArr, (C6365a) new C6365a() {
                /* renamed from: a */
                public final void mo27603a(int i) {
                    C5399c a;
                    C5400a r0;
                    String str = "android.permission.CAMERA";
                    String str2 = Constants.PERMISSION_WRITE_EXTERNAL_STORAGE;
                    String str3 = "android.permission.READ_EXTERNAL_STORAGE";
                    if (i == 0) {
                        a = C5399c.m22100a((Fragment) tFragment).mo27354a(str3, str2, str);
                        r0 = new C5400a() {
                            public final void onDenied() {
                                C5415g.m22161a(C5961R.string.ysf_no_permission_camera);
                            }

                            public final void onGranted() {
                                PickImageActivity.start(tFragment, i, 2, str, z, 1, false, false, 0, 0);
                            }
                        };
                    } else if (i == 1) {
                        a = C5399c.m22100a((Fragment) tFragment).mo27354a(str3, str2, str, "android.permission.RECORD_AUDIO");
                        r0 = new C5400a() {
                            public final void onDenied() {
                                C5415g.m22161a(C5961R.string.ysf_no_permission_video);
                            }

                            public final void onGranted() {
                                C5557c.m22587a(tFragment);
                            }
                        };
                    } else {
                        if (i == 2) {
                            C5399c.m22100a((Fragment) tFragment).mo27354a(str3, str2).mo27353a((C5400a) new C5400a() {
                                public final void onDenied() {
                                    C5415g.m22161a(C5961R.string.ysf_no_permission_photo);
                                }

                                public final void onGranted() {
                                    PickImageActivity.start(tFragment, i, 1, str, z, 9, false, false, 0, 0);
                                }
                            }).mo27355a();
                        }
                        return;
                    }
                    a.mo27353a(r0).mo27355a();
                }
            });
        }
    }
}
