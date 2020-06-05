package com.qiyukf.nim.uikit.common.media.picker.fragment;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.qiyukf.basesdk.p412c.p417d.C5413e;
import com.qiyukf.nim.uikit.common.fragment.TFragment;
import com.qiyukf.nim.uikit.common.media.picker.model.C5468a;
import com.qiyukf.nim.uikit.common.media.picker.p422a.C5449a;
import com.qiyukf.unicorn.C5961R;
import java.util.ArrayList;
import java.util.List;

public class PickerAlbumFragment extends TFragment implements OnItemClickListener {
    /* renamed from: a */
    private C5466b f17546a;
    /* access modifiers changed from: private */
    /* renamed from: b */
    public LinearLayout f17547b;
    /* access modifiers changed from: private */
    /* renamed from: c */
    public TextView f17548c;
    /* access modifiers changed from: private */
    /* renamed from: d */
    public TextView f17549d;
    /* access modifiers changed from: private */
    /* renamed from: e */
    public ListView f17550e;
    /* access modifiers changed from: private */
    /* renamed from: f */
    public List<C5468a> f17551f = new ArrayList();

    /* renamed from: com.qiyukf.nim.uikit.common.media.picker.fragment.PickerAlbumFragment$a */
    private class C5465a extends AsyncTask<Void, Object, Object> {
        private C5465a() {
        }

        /* synthetic */ C5465a(PickerAlbumFragment pickerAlbumFragment, byte b) {
            this();
        }

        /* access modifiers changed from: protected|final|synthetic */
        public final /* synthetic */ Object doInBackground(Object[] objArr) {
            PickerAlbumFragment.m22279a(PickerAlbumFragment.this);
            PickerAlbumFragment.m22280b(PickerAlbumFragment.this);
            return null;
        }

        /* access modifiers changed from: protected|final */
        public final void onPostExecute(Object obj) {
            super.onPostExecute(obj);
            if (!(PickerAlbumFragment.this.getActivity() == null || PickerAlbumFragment.this.f17551f == null)) {
                PickerAlbumFragment.this.f17550e.setAdapter(new C5449a(PickerAlbumFragment.this.getActivity(), PickerAlbumFragment.this.f17551f));
                if (PickerAlbumFragment.this.f17551f.size() > 0) {
                    PickerAlbumFragment.this.f17547b.setVisibility(8);
                    return;
                }
                PickerAlbumFragment.this.f17547b.setVisibility(0);
                PickerAlbumFragment.this.f17548c.setVisibility(8);
                PickerAlbumFragment.this.f17549d.setVisibility(0);
            }
        }
    }

    /* renamed from: com.qiyukf.nim.uikit.common.media.picker.fragment.PickerAlbumFragment$b */
    public interface C5466b {
        void onAlbumItemClick(C5468a aVar);
    }

    public PickerAlbumFragment() {
        setContainerId(C5961R.C5963id.picker_album_fragment);
    }

    /* JADX WARNING: Removed duplicated region for block: B:9:0x0049 A[SYNTHETIC, Splitter:B:9:0x0049] */
    /* renamed from: a */
    static /* synthetic */ void m22279a(com.qiyukf.nim.uikit.common.media.picker.fragment.PickerAlbumFragment r6) {
        /*
        java.lang.String r0 = "cursorThumb.close is error"
        java.lang.String r1 = ""
        com.qiyukf.nim.uikit.common.media.picker.p423b.C5464c.m22277a()
        r2 = 0
        androidx.fragment.app.FragmentActivity r6 = r6.getActivity()     // Catch:{ Exception -> 0x0054 }
        android.database.Cursor r2 = com.qiyukf.nim.uikit.common.media.p421b.C5448a.m22248a(r6)     // Catch:{ Exception -> 0x0054 }
        if (r2 == 0) goto L_0x0047
        boolean r6 = r2.moveToFirst()     // Catch:{ Exception -> 0x0054 }
        if (r6 == 0) goto L_0x0047
    L_0x0018:
        java.lang.String r6 = "image_id"
        int r6 = r2.getColumnIndex(r6)     // Catch:{ Exception -> 0x0054 }
        int r6 = r2.getInt(r6)     // Catch:{ Exception -> 0x0054 }
        java.lang.String r3 = "_data"
        int r3 = r2.getColumnIndex(r3)     // Catch:{ Exception -> 0x0054 }
        java.lang.String r3 = r2.getString(r3)     // Catch:{ Exception -> 0x0054 }
        java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch:{ Exception -> 0x0054 }
        java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0054 }
        java.lang.String r5 = "file://"
        r4.<init>(r5)     // Catch:{ Exception -> 0x0054 }
        r4.append(r3)     // Catch:{ Exception -> 0x0054 }
        java.lang.String r3 = r4.toString()     // Catch:{ Exception -> 0x0054 }
        com.qiyukf.nim.uikit.common.media.picker.p423b.C5464c.m22278a(r6, r3)     // Catch:{ Exception -> 0x0054 }
        boolean r6 = r2.moveToNext()     // Catch:{ Exception -> 0x0054 }
        if (r6 != 0) goto L_0x0018
    L_0x0047:
        if (r2 == 0) goto L_0x0051
        r2.close()     // Catch:{ Exception -> 0x004d }
        goto L_0x0051
    L_0x004d:
        r6 = move-exception
        com.qiyukf.basesdk.p393a.C5264a.m21621b(r0, r1, r6)
    L_0x0051:
        return
    L_0x0052:
        r6 = move-exception
        goto L_0x0065
    L_0x0054:
        r6 = move-exception
        java.lang.String r3 = "getAllMediaThumbnails is error"
        com.qiyukf.basesdk.p393a.C5264a.m21621b(r3, r1, r6)     // Catch:{ all -> 0x0052 }
        if (r2 == 0) goto L_0x0064
        r2.close()     // Catch:{ Exception -> 0x0060 }
        goto L_0x0064
    L_0x0060:
        r6 = move-exception
        com.qiyukf.basesdk.p393a.C5264a.m21621b(r0, r1, r6)
    L_0x0064:
        return
    L_0x0065:
        if (r2 == 0) goto L_0x006f
        r2.close()     // Catch:{ Exception -> 0x006b }
        goto L_0x006f
    L_0x006b:
        r2 = move-exception
        com.qiyukf.basesdk.p393a.C5264a.m21621b(r0, r1, r2)
    L_0x006f:
        throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qiyukf.nim.uikit.common.media.picker.fragment.PickerAlbumFragment.m22279a(com.qiyukf.nim.uikit.common.media.picker.fragment.PickerAlbumFragment):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:30:0x0119 A[SYNTHETIC, Splitter:B:30:0x0119] */
    /* renamed from: b */
    static /* synthetic */ void m22280b(com.qiyukf.nim.uikit.common.media.picker.fragment.PickerAlbumFragment r14) {
        /*
        java.lang.String r0 = "cursorPhotos close"
        java.lang.String r1 = ""
        java.util.List<com.qiyukf.nim.uikit.common.media.picker.model.a> r2 = r14.f17551f
        if (r2 != 0) goto L_0x0010
        java.util.ArrayList r2 = new java.util.ArrayList
        r2.<init>()
        r14.f17551f = r2
        goto L_0x0013
    L_0x0010:
        r2.clear()
    L_0x0013:
        r2 = 0
        androidx.fragment.app.FragmentActivity r3 = r14.getActivity()     // Catch:{ Exception -> 0x0124 }
        android.database.Cursor r2 = com.qiyukf.nim.uikit.common.media.p421b.C5448a.m22249b(r3)     // Catch:{ Exception -> 0x0124 }
        java.util.HashMap r3 = new java.util.HashMap     // Catch:{ Exception -> 0x0124 }
        r3.<init>()     // Catch:{ Exception -> 0x0124 }
        if (r2 == 0) goto L_0x0117
        boolean r4 = r2.moveToFirst()     // Catch:{ Exception -> 0x0124 }
        if (r4 == 0) goto L_0x0117
    L_0x0029:
        java.lang.String r4 = "_id"
        int r4 = r2.getColumnIndex(r4)     // Catch:{ Exception -> 0x0124 }
        int r4 = r2.getInt(r4)     // Catch:{ Exception -> 0x0124 }
        java.lang.String r5 = "_data"
        int r5 = r2.getColumnIndex(r5)     // Catch:{ Exception -> 0x0124 }
        java.lang.String r5 = r2.getString(r5)     // Catch:{ Exception -> 0x0124 }
        java.lang.String r6 = "bucket_display_name"
        int r6 = r2.getColumnIndex(r6)     // Catch:{ Exception -> 0x0124 }
        java.lang.String r6 = r2.getString(r6)     // Catch:{ Exception -> 0x0124 }
        java.lang.String r7 = "_size"
        int r7 = r2.getColumnIndex(r7)     // Catch:{ Exception -> 0x0124 }
        long r7 = r2.getLong(r7)     // Catch:{ Exception -> 0x0124 }
        boolean r9 = android.text.TextUtils.isEmpty(r5)     // Catch:{ Exception -> 0x0124 }
        r10 = 0
        if (r9 != 0) goto L_0x0065
        java.io.File r9 = new java.io.File     // Catch:{ Exception -> 0x0124 }
        r9.<init>(r5)     // Catch:{ Exception -> 0x0124 }
        boolean r9 = r9.exists()     // Catch:{ Exception -> 0x0124 }
        if (r9 == 0) goto L_0x0065
        r9 = 1
        goto L_0x0066
    L_0x0065:
        r9 = 0
    L_0x0066:
        if (r9 != 0) goto L_0x007d
        java.lang.String r4 = "PICKER"
        java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0124 }
        java.lang.String r7 = "it is not a valid path:"
        r6.<init>(r7)     // Catch:{ Exception -> 0x0124 }
        r6.append(r5)     // Catch:{ Exception -> 0x0124 }
        java.lang.String r5 = r6.toString()     // Catch:{ Exception -> 0x0124 }
        android.util.Log.d(r4, r5)     // Catch:{ Exception -> 0x0124 }
        goto L_0x0111
    L_0x007d:
        java.util.ArrayList r9 = new java.util.ArrayList     // Catch:{ Exception -> 0x0124 }
        r9.<init>()     // Catch:{ Exception -> 0x0124 }
        com.qiyukf.nim.uikit.common.media.picker.model.PhotoInfo r11 = new com.qiyukf.nim.uikit.common.media.picker.model.PhotoInfo     // Catch:{ Exception -> 0x0124 }
        r11.m49603init()     // Catch:{ Exception -> 0x0124 }
        boolean r12 = r3.containsKey(r6)     // Catch:{ Exception -> 0x0124 }
        java.lang.String r13 = "file://"
        if (r12 == 0) goto L_0x00cb
        java.lang.Object r9 = r3.remove(r6)     // Catch:{ Exception -> 0x0124 }
        com.qiyukf.nim.uikit.common.media.picker.model.a r9 = (com.qiyukf.nim.uikit.common.media.picker.model.C5468a) r9     // Catch:{ Exception -> 0x0124 }
        java.util.List<com.qiyukf.nim.uikit.common.media.picker.model.a> r12 = r14.f17551f     // Catch:{ Exception -> 0x0124 }
        boolean r12 = r12.contains(r9)     // Catch:{ Exception -> 0x0124 }
        if (r12 == 0) goto L_0x00a3
        java.util.List<com.qiyukf.nim.uikit.common.media.picker.model.a> r10 = r14.f17551f     // Catch:{ Exception -> 0x0124 }
        int r10 = r10.indexOf(r9)     // Catch:{ Exception -> 0x0124 }
    L_0x00a3:
        r11.setImageId(r4)     // Catch:{ Exception -> 0x0124 }
        java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0124 }
        r4.<init>(r13)     // Catch:{ Exception -> 0x0124 }
        r4.append(r5)     // Catch:{ Exception -> 0x0124 }
        java.lang.String r4 = r4.toString()     // Catch:{ Exception -> 0x0124 }
        r11.setFilePath(r4)     // Catch:{ Exception -> 0x0124 }
        r11.setAbsolutePath(r5)     // Catch:{ Exception -> 0x0124 }
        r11.setSize(r7)     // Catch:{ Exception -> 0x0124 }
        java.util.List r4 = r9.mo27504e()     // Catch:{ Exception -> 0x0124 }
        r4.add(r11)     // Catch:{ Exception -> 0x0124 }
        java.util.List<com.qiyukf.nim.uikit.common.media.picker.model.a> r4 = r14.f17551f     // Catch:{ Exception -> 0x0124 }
        r4.set(r10, r9)     // Catch:{ Exception -> 0x0124 }
        r3.put(r6, r9)     // Catch:{ Exception -> 0x0124 }
        goto L_0x0111
    L_0x00cb:
        com.qiyukf.nim.uikit.common.media.picker.model.a r10 = new com.qiyukf.nim.uikit.common.media.picker.model.a     // Catch:{ Exception -> 0x0124 }
        r10.m49604init()     // Catch:{ Exception -> 0x0124 }
        r9.clear()     // Catch:{ Exception -> 0x0124 }
        r11.setImageId(r4)     // Catch:{ Exception -> 0x0124 }
        java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0124 }
        r12.<init>(r13)     // Catch:{ Exception -> 0x0124 }
        r12.append(r5)     // Catch:{ Exception -> 0x0124 }
        java.lang.String r12 = r12.toString()     // Catch:{ Exception -> 0x0124 }
        r11.setFilePath(r12)     // Catch:{ Exception -> 0x0124 }
        r11.setAbsolutePath(r5)     // Catch:{ Exception -> 0x0124 }
        r11.setSize(r7)     // Catch:{ Exception -> 0x0124 }
        r9.add(r11)     // Catch:{ Exception -> 0x0124 }
        r10.mo27496a(r4)     // Catch:{ Exception -> 0x0124 }
        java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0124 }
        r4.<init>(r13)     // Catch:{ Exception -> 0x0124 }
        r4.append(r5)     // Catch:{ Exception -> 0x0124 }
        java.lang.String r4 = r4.toString()     // Catch:{ Exception -> 0x0124 }
        r10.mo27500b(r4)     // Catch:{ Exception -> 0x0124 }
        r10.mo27497a(r5)     // Catch:{ Exception -> 0x0124 }
        r10.mo27502c(r6)     // Catch:{ Exception -> 0x0124 }
        r10.mo27498a(r9)     // Catch:{ Exception -> 0x0124 }
        java.util.List<com.qiyukf.nim.uikit.common.media.picker.model.a> r4 = r14.f17551f     // Catch:{ Exception -> 0x0124 }
        r4.add(r10)     // Catch:{ Exception -> 0x0124 }
        r3.put(r6, r10)     // Catch:{ Exception -> 0x0124 }
    L_0x0111:
        boolean r4 = r2.moveToNext()     // Catch:{ Exception -> 0x0124 }
        if (r4 != 0) goto L_0x0029
    L_0x0117:
        if (r2 == 0) goto L_0x0121
        r2.close()     // Catch:{ Exception -> 0x011d }
        goto L_0x0121
    L_0x011d:
        r14 = move-exception
        com.qiyukf.basesdk.p393a.C5264a.m21621b(r0, r1, r14)
    L_0x0121:
        return
    L_0x0122:
        r14 = move-exception
        goto L_0x0135
    L_0x0124:
        r14 = move-exception
        java.lang.String r3 = "getAllMediaPhotos is error"
        com.qiyukf.basesdk.p393a.C5264a.m21621b(r3, r1, r14)     // Catch:{ all -> 0x0122 }
        if (r2 == 0) goto L_0x0134
        r2.close()     // Catch:{ Exception -> 0x0130 }
        goto L_0x0134
    L_0x0130:
        r14 = move-exception
        com.qiyukf.basesdk.p393a.C5264a.m21621b(r0, r1, r14)
    L_0x0134:
        return
    L_0x0135:
        if (r2 == 0) goto L_0x013f
        r2.close()     // Catch:{ Exception -> 0x013b }
        goto L_0x013f
    L_0x013b:
        r2 = move-exception
        com.qiyukf.basesdk.p393a.C5264a.m21621b(r0, r1, r2)
    L_0x013f:
        throw r14
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qiyukf.nim.uikit.common.media.picker.fragment.PickerAlbumFragment.m22280b(com.qiyukf.nim.uikit.common.media.picker.fragment.PickerAlbumFragment):void");
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.f17547b = (LinearLayout) getView().findViewById(C5961R.C5963id.picker_image_folder_loading);
        this.f17548c = (TextView) getView().findViewById(C5961R.C5963id.picker_image_folder_loading_tips);
        this.f17549d = (TextView) getView().findViewById(C5961R.C5963id.picker_image_folder_loading_empty);
        this.f17550e = (ListView) getView().findViewById(C5961R.C5963id.picker_image_folder_listView);
        this.f17550e.setOnItemClickListener(this);
        C5413e.m22154a((AsyncTask<Params, Progress, Result>) new C5465a<Params,Progress,Result>(this, 0), (Params[]) new Void[0]);
    }

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if (this.f17546a == null) {
            this.f17546a = (C5466b) activity;
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setRetainInstance(true);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(C5961R.C5964layout.ysf_picker_image_folder_activity, viewGroup, false);
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        this.f17546a.onAlbumItemClick((C5468a) this.f17551f.get(i));
    }
}
