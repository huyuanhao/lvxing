package com.yanzhenjie.album.app.album;

import android.content.Context;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.Window;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.yanzhenjie.album.AlbumFolder;
import com.yanzhenjie.album.R;
import com.yanzhenjie.album.api.widget.Widget;
import com.yanzhenjie.album.p628a.C7726c;
import java.util.List;

public class FolderDialog extends BottomSheetDialog {
    /* renamed from: a */
    static final /* synthetic */ boolean f26203a = (!FolderDialog.class.desiredAssertionStatus());
    /* renamed from: b */
    private Widget f26204b;
    /* access modifiers changed from: private */
    /* renamed from: c */
    public FolderAdapter f26205c;
    /* access modifiers changed from: private */
    /* renamed from: d */
    public List<AlbumFolder> f26206d;
    /* access modifiers changed from: private */
    /* renamed from: e */
    public int f26207e = 0;
    /* access modifiers changed from: private */
    /* renamed from: f */
    public C7726c f26208f;

    public FolderDialog(Context context, Widget widget, List<AlbumFolder> list, C7726c cVar) {
        super(context, R.style.Album_Dialog_Folder);
        setContentView(R.layout.album_dialog_floder);
        this.f26204b = widget;
        this.f26206d = list;
        this.f26208f = cVar;
        RecyclerView recyclerView = (RecyclerView) getDelegate().findViewById(R.id.rv_content_list);
        if (f26203a || recyclerView != null) {
            recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
            this.f26205c = new FolderAdapter(context, this.f26206d, widget.mo37552g());
            this.f26205c.mo37637a((C7726c) new C7726c() {
                /* renamed from: a */
                public void mo37526a(View view, int i) {
                    if (FolderDialog.this.f26207e != i) {
                        ((AlbumFolder) FolderDialog.this.f26206d.get(FolderDialog.this.f26207e)).mo37515a(false);
                        FolderDialog.this.f26205c.notifyItemChanged(FolderDialog.this.f26207e);
                        FolderDialog.this.f26207e = i;
                        ((AlbumFolder) FolderDialog.this.f26206d.get(FolderDialog.this.f26207e)).mo37515a(true);
                        FolderDialog.this.f26205c.notifyItemChanged(FolderDialog.this.f26207e);
                        if (FolderDialog.this.f26208f != null) {
                            FolderDialog.this.f26208f.mo37526a(view, i);
                        }
                    }
                    FolderDialog.this.dismiss();
                }
            });
            recyclerView.setAdapter(this.f26205c);
            return;
        }
        throw new AssertionError();
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Window window = getWindow();
        if (window != null) {
            Display defaultDisplay = window.getWindowManager().getDefaultDisplay();
            DisplayMetrics displayMetrics = new DisplayMetrics();
            if (VERSION.SDK_INT >= 17) {
                defaultDisplay.getRealMetrics(displayMetrics);
            } else {
                defaultDisplay.getMetrics(displayMetrics);
            }
            window.setLayout(Math.min(displayMetrics.widthPixels, displayMetrics.heightPixels), -1);
            if (VERSION.SDK_INT >= 21) {
                window.setStatusBarColor(0);
                window.setNavigationBarColor(this.f26204b.mo37548d());
            }
        }
    }
}
