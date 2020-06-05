package com.qiyukf.nim.uikit.session.helper;

import android.content.Intent;
import android.os.AsyncTask;
import android.text.TextUtils;
import androidx.fragment.app.Fragment;
import com.qiyukf.basesdk.p412c.p413a.C5362a;
import com.qiyukf.basesdk.p412c.p413a.C5363b;
import com.qiyukf.basesdk.p412c.p416c.C5405c;
import com.qiyukf.basesdk.p412c.p416c.C5406d;
import com.qiyukf.basesdk.p412c.p417d.C5415g;
import com.qiyukf.nim.uikit.common.media.picker.model.PhotoInfo;
import com.qiyukf.nim.uikit.session.activity.PickImageActivity;
import com.qiyukf.nimlib.p488k.p490b.C5940b;
import com.qiyukf.nimlib.p488k.p491c.C5944b;
import com.qiyukf.nimlib.p488k.p491c.C5946c;
import com.qiyukf.unicorn.C5961R;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;

/* renamed from: com.qiyukf.nim.uikit.session.helper.d */
public final class C5563d implements Serializable {

    /* renamed from: com.qiyukf.nim.uikit.session.helper.d$a */
    public interface C5564a {
        void sendImage(File file, String str, boolean z);
    }

    /* renamed from: com.qiyukf.nim.uikit.session.helper.d$b */
    private static class C5565b extends AsyncTask<Void, Void, File> {
        /* renamed from: a */
        private boolean f17917a;
        /* renamed from: b */
        private PhotoInfo f17918b;
        /* renamed from: c */
        private C5564a f17919c;

        public C5565b(boolean z, PhotoInfo photoInfo, C5564a aVar) {
            this.f17917a = z;
            this.f17918b = photoInfo;
            this.f17919c = aVar;
        }

        /* access modifiers changed from: protected|final|synthetic */
        public final /* synthetic */ Object doInBackground(Object[] objArr) {
            String absolutePath = this.f17918b.getAbsolutePath();
            if (TextUtils.isEmpty(absolutePath)) {
                return null;
            }
            if (this.f17917a) {
                String b = C5405c.m22115b(absolutePath);
                String a = C5363b.m22023a(absolutePath);
                StringBuilder sb = new StringBuilder();
                sb.append(b);
                sb.append(".");
                sb.append(a);
                String a2 = C5946c.m23834a(sb.toString(), C5944b.TYPE_IMAGE);
                C5362a.m22018a(absolutePath, a2);
                C5940b.m23817a(new File(a2));
                return new File(a2);
            }
            File a3 = C5940b.m23814a(new File(absolutePath), C5363b.m22023a(absolutePath));
            if (a3 == null) {
                return null;
            }
            C5940b.m23817a(a3);
            return a3;
        }

        /* access modifiers changed from: protected|final|synthetic */
        public final /* synthetic */ void onPostExecute(Object obj) {
            File file = (File) obj;
            if (file == null) {
                C5415g.m22165b(C5961R.string.ysf_picker_image_error);
            } else if (this.f17919c != null) {
                this.f17919c.sendImage(file, C5363b.m22024b(this.f17918b.getAbsolutePath()), this.f17917a);
            }
        }

        /* access modifiers changed from: protected|final */
        public final void onPreExecute() {
            super.onPreExecute();
        }
    }

    /* renamed from: a */
    public static void m22591a(Fragment fragment, Intent intent, int i, int i2, C5564a aVar) {
        if (intent.getBooleanExtra("RESULT_SEND", false)) {
            ArrayList stringArrayListExtra = intent.getStringArrayListExtra("scaled_image_list");
            ArrayList stringArrayListExtra2 = intent.getStringArrayListExtra("orig_image_list");
            boolean booleanExtra = intent.getBooleanExtra("is_original", false);
            for (int i3 = 0; i3 < stringArrayListExtra.size(); i3++) {
                String str = (String) stringArrayListExtra.get(i3);
                File file = new File(str);
                String str2 = (String) stringArrayListExtra2.get(i3);
                if (booleanExtra) {
                    String b = C5405c.m22115b(str2);
                    String a = C5363b.m22023a(str2);
                    StringBuilder sb = new StringBuilder();
                    sb.append(b);
                    String str3 = ".";
                    sb.append(str3);
                    sb.append(a);
                    String a2 = C5946c.m23834a(sb.toString(), C5944b.TYPE_IMAGE);
                    C5362a.m22018a(str2, a2);
                    String b2 = C5946c.m23842b(C5363b.m22024b(str), C5944b.TYPE_THUMB_IMAGE);
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(b);
                    sb2.append(str3);
                    sb2.append(a);
                    String a3 = C5946c.m23834a(sb2.toString(), C5944b.TYPE_THUMB_IMAGE);
                    if (!TextUtils.isEmpty(b2) && !TextUtils.isEmpty(a3)) {
                        File file2 = new File(b2);
                        if (file2.exists() && file2.isFile()) {
                            File file3 = new File(a3);
                            if (file3.getParentFile() != null) {
                                if (!file3.getParentFile().exists()) {
                                    file3.getParentFile().mkdirs();
                                }
                                file2.renameTo(file3);
                            }
                        }
                    }
                    if (aVar != null) {
                        File file4 = new File(a2);
                        aVar.sendImage(file4, file4.getName(), true);
                    }
                } else if (aVar != null) {
                    aVar.sendImage(file, file.getName(), false);
                }
            }
            return;
        }
        if (intent.getBooleanExtra("RESULT_RETAKE", false)) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append(C5406d.m22120b());
            sb3.append(".jpg");
            String a4 = C5946c.m23834a(sb3.toString(), C5944b.TYPE_TEMP);
            if (i == 6) {
                PickImageActivity.start(fragment, i2, 2, a4);
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x0086 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0087  */
    /* renamed from: a */
    public static void m22592a(androidx.fragment.app.Fragment r6, android.content.Intent r7, int r8, com.qiyukf.nim.uikit.session.helper.C5563d.C5564a r9) {
        /*
        if (r7 != 0) goto L_0x0008
        int r6 = com.qiyukf.unicorn.C5961R.string.ysf_picker_image_error
        com.qiyukf.basesdk.p412c.p417d.C5415g.m22165b(r6)
        return
    L_0x0008:
        java.lang.String r0 = "from_local"
        r1 = 0
        boolean r2 = r7.getBooleanExtra(r0, r1)
        if (r2 == 0) goto L_0x003f
        java.lang.String r6 = "is_original"
        boolean r6 = r7.getBooleanExtra(r6, r1)
        java.util.List r7 = com.qiyukf.nim.uikit.common.media.picker.model.C5469b.m22298a(r7)
        if (r7 != 0) goto L_0x0023
        int r6 = com.qiyukf.unicorn.C5961R.string.ysf_picker_image_error
        com.qiyukf.basesdk.p412c.p417d.C5415g.m22165b(r6)
        return
    L_0x0023:
        java.util.Iterator r7 = r7.iterator()
    L_0x0027:
        boolean r8 = r7.hasNext()
        if (r8 == 0) goto L_0x003e
        java.lang.Object r8 = r7.next()
        com.qiyukf.nim.uikit.common.media.picker.model.PhotoInfo r8 = (com.qiyukf.nim.uikit.common.media.picker.model.PhotoInfo) r8
        com.qiyukf.nim.uikit.session.helper.d$b r0 = new com.qiyukf.nim.uikit.session.helper.d$b
        r0.m49737init(r6, r8, r9)
        java.lang.Void[] r8 = new java.lang.Void[r1]
        com.qiyukf.basesdk.p412c.p417d.C5413e.m22154a(r0, (Params[]) r8)
        goto L_0x0027
    L_0x003e:
        return
    L_0x003f:
        android.content.Intent r9 = new android.content.Intent
        r9.<init>()
        java.lang.String r2 = "file_path"
        java.lang.String r2 = r7.getStringExtra(r2)
        boolean r3 = android.text.TextUtils.isEmpty(r2)
        r4 = 1
        if (r3 == 0) goto L_0x0057
    L_0x0051:
        int r7 = com.qiyukf.unicorn.C5961R.string.ysf_picker_image_error
        com.qiyukf.basesdk.p412c.p417d.C5415g.m22165b(r7)
        goto L_0x0084
    L_0x0057:
        java.io.File r3 = new java.io.File
        r3.<init>(r2)
        java.lang.String r5 = "orig_image_file_path"
        r9.putExtra(r5, r2)
        java.lang.String r5 = "image/jpeg"
        java.io.File r3 = com.qiyukf.nimlib.p488k.p490b.C5940b.m23814a(r3, r5)
        android.os.Bundle r7 = r7.getExtras()
        boolean r7 = r7.getBoolean(r0, r4)
        if (r7 != 0) goto L_0x0074
        com.qiyukf.basesdk.p412c.p413a.C5362a.m22021b(r2)
    L_0x0074:
        if (r3 != 0) goto L_0x0077
        goto L_0x0051
    L_0x0077:
        com.qiyukf.nimlib.p488k.p490b.C5940b.m23817a(r3)
        java.lang.String r7 = r3.getAbsolutePath()
        java.lang.String r0 = "image_file_path"
        r9.putExtra(r0, r7)
        r1 = 1
    L_0x0084:
        if (r1 != 0) goto L_0x0087
        return
    L_0x0087:
        android.content.Context r7 = r6.getContext()
        java.lang.Class<com.qiyukf.nim.uikit.common.media.picker.activity.PreviewImageFromCameraActivity> r0 = com.qiyukf.nim.uikit.common.media.picker.activity.PreviewImageFromCameraActivity.class
        r9.setClass(r7, r0)
        r6.startActivityForResult(r9, r8)
        return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qiyukf.nim.uikit.session.helper.C5563d.m22592a(androidx.fragment.app.Fragment, android.content.Intent, int, com.qiyukf.nim.uikit.session.helper.d$a):void");
    }
}
