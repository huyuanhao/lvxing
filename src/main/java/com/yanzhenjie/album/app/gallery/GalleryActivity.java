package com.yanzhenjie.album.app.gallery;

import android.os.Bundle;
import android.view.View;
import com.yanzhenjie.album.Action;
import com.yanzhenjie.album.ItemAction;
import com.yanzhenjie.album.R;
import com.yanzhenjie.album.api.widget.Widget;
import com.yanzhenjie.album.app.Contract.C7732b;
import com.yanzhenjie.album.app.Contract.GalleryPresenter;
import com.yanzhenjie.album.mvp.BaseActivity;
import com.yanzhenjie.album.p628a.C7726c;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class GalleryActivity extends BaseActivity implements GalleryPresenter {
    /* renamed from: a */
    public static Action<ArrayList<String>> f26286a;
    /* renamed from: b */
    public static Action<String> f26287b;
    /* renamed from: c */
    public static ItemAction<String> f26288c;
    /* renamed from: d */
    public static ItemAction<String> f26289d;
    /* renamed from: e */
    static final /* synthetic */ boolean f26290e = (!GalleryActivity.class.desiredAssertionStatus());
    /* renamed from: f */
    private Widget f26291f;
    /* access modifiers changed from: private */
    /* renamed from: j */
    public ArrayList<String> f26292j;
    /* access modifiers changed from: private */
    /* renamed from: k */
    public int f26293k;
    /* renamed from: l */
    private boolean f26294l;
    /* renamed from: m */
    private Map<String, Boolean> f26295m;
    /* renamed from: n */
    private C7732b<String> f26296n;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.album_activity_gallery);
        this.f26296n = new GalleryView(this, this);
        Bundle extras = getIntent().getExtras();
        if (f26290e || extras != null) {
            this.f26291f = (Widget) extras.getParcelable("KEY_INPUT_WIDGET");
            this.f26292j = extras.getStringArrayList("KEY_INPUT_CHECKED_LIST");
            this.f26293k = extras.getInt("KEY_INPUT_CURRENT_POSITION");
            this.f26294l = extras.getBoolean("KEY_INPUT_GALLERY_CHECKABLE");
            this.f26295m = new HashMap();
            Iterator it = this.f26292j.iterator();
            while (it.hasNext()) {
                this.f26295m.put((String) it.next(), Boolean.valueOf(true));
            }
            this.f26296n.mo37698c(this.f26291f.mo37550e());
            this.f26296n.mo37598a(this.f26291f, this.f26294l);
            if (!this.f26294l) {
                this.f26296n.mo37604c(false);
            }
            this.f26296n.mo37605d(false);
            this.f26296n.mo37601a(false);
            PreviewPathAdapter previewPathAdapter = new PreviewPathAdapter(this, this.f26292j);
            if (f26288c != null) {
                previewPathAdapter.mo37666a(new C7726c() {
                    /* renamed from: a */
                    public void mo37526a(View view, int i) {
                        ItemAction<String> eVar = GalleryActivity.f26288c;
                        GalleryActivity galleryActivity = GalleryActivity.this;
                        eVar.mo37678a(galleryActivity, galleryActivity.f26292j.get(GalleryActivity.this.f26293k));
                    }
                });
            }
            if (f26289d != null) {
                previewPathAdapter.mo37667b(new C7726c() {
                    /* renamed from: a */
                    public void mo37526a(View view, int i) {
                        ItemAction<String> eVar = GalleryActivity.f26289d;
                        GalleryActivity galleryActivity = GalleryActivity.this;
                        eVar.mo37678a(galleryActivity, galleryActivity.f26292j.get(GalleryActivity.this.f26293k));
                    }
                });
            }
            this.f26296n.mo37599a((PreviewAdapter<Data>) previewPathAdapter);
            int i = this.f26293k;
            if (i == 0) {
                mo37585a(i);
            } else {
                this.f26296n.mo37597a(i);
            }
            m33496c();
            return;
        }
        throw new AssertionError();
    }

    /* renamed from: c */
    private void m33496c() {
        int i = 0;
        for (Entry value : this.f26295m.entrySet()) {
            if (((Boolean) value.getValue()).booleanValue()) {
                i++;
            }
        }
        String string = getString(R.string.album_menu_finish);
        StringBuilder sb = new StringBuilder();
        sb.append(string);
        sb.append("(");
        sb.append(i);
        sb.append(" / ");
        sb.append(this.f26292j.size());
        sb.append(")");
        this.f26296n.mo37602b(sb.toString());
    }

    /* renamed from: a */
    public void mo37585a(int i) {
        this.f26293k = i;
        C7732b<String> bVar = this.f26296n;
        StringBuilder sb = new StringBuilder();
        sb.append(i + 1);
        sb.append(" / ");
        sb.append(this.f26292j.size());
        bVar.mo37701d(sb.toString());
        if (this.f26294l) {
            this.f26296n.mo37603b(((Boolean) this.f26295m.get(this.f26292j.get(i))).booleanValue());
        }
    }

    /* renamed from: a */
    public void mo37584a() {
        String str = (String) this.f26292j.get(this.f26293k);
        Map<String, Boolean> map = this.f26295m;
        map.put(str, Boolean.valueOf(!((Boolean) map.get(str)).booleanValue()));
        m33496c();
    }

    /* renamed from: b */
    public void mo37586b() {
        if (f26286a != null) {
            ArrayList arrayList = new ArrayList();
            for (Entry entry : this.f26295m.entrySet()) {
                if (((Boolean) entry.getValue()).booleanValue()) {
                    arrayList.add(entry.getKey());
                }
            }
            f26286a.mo21403a(arrayList);
        }
        finish();
    }

    public void onBackPressed() {
        Action<String> aVar = f26287b;
        if (aVar != null) {
            aVar.mo21403a("User canceled.");
        }
        finish();
    }

    public void finish() {
        f26286a = null;
        f26287b = null;
        f26288c = null;
        f26289d = null;
        super.finish();
    }
}
