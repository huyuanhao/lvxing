package com.bytedance.sdk.openadsdk.core.nativeexpress;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import com.bytedance.sdk.openadsdk.TTAdDislike;
import com.bytedance.sdk.openadsdk.TTDislikeDialogAbstract;
import com.bytedance.sdk.openadsdk.core.p167a.ClickCreativeListener;
import com.bytedance.sdk.openadsdk.core.p167a.ClickListener;
import com.bytedance.sdk.openadsdk.core.p170d.DynamicClickInfo;
import com.bytedance.sdk.openadsdk.core.p170d.MaterialMeta;
import com.bytedance.sdk.openadsdk.dislike.TTAdDislikeImpl;
import com.bytedance.sdk.openadsdk.utils.ToolUtils;
import com.bytedance.sdk.openadsdk.utils.UIUtils;

public abstract class BackupView extends FrameLayout {
    /* renamed from: a */
    protected Context f7750a;
    /* renamed from: b */
    protected MaterialMeta f7751b;
    /* renamed from: c */
    protected TTAdDislikeImpl f7752c;
    /* renamed from: d */
    protected TTDislikeDialogAbstract f7753d;
    /* renamed from: e */
    protected String f7754e = "embeded_ad";
    /* renamed from: f */
    protected int f7755f;
    /* renamed from: g */
    protected int f7756g;

    /* renamed from: a */
    public abstract void mo15294a(int i, DynamicClickInfo iVar);

    public Object getTag() {
        return "tt_express_backup_fl_tag_26";
    }

    public BackupView(Context context) {
        super(context);
        setTag("tt_express_backup_fl_tag_26");
    }

    public void setTag(Object obj) {
        super.setTag("tt_express_backup_fl_tag_26");
    }

    public void setDislikeInner(TTAdDislike tTAdDislike) {
        if (tTAdDislike instanceof TTAdDislikeImpl) {
            MaterialMeta kVar = this.f7751b;
            if (kVar != null) {
                ((TTAdDislikeImpl) tTAdDislike).mo16453a(kVar);
            }
            this.f7752c = (TTAdDislikeImpl) tTAdDislike;
        }
    }

    public void setDislikeOuter(TTDislikeDialogAbstract tTDislikeDialogAbstract) {
        if (tTDislikeDialogAbstract != null) {
            MaterialMeta kVar = this.f7751b;
            if (kVar != null) {
                tTDislikeDialogAbstract.setMaterialMeta(kVar);
            }
        }
        this.f7753d = tTDislikeDialogAbstract;
    }

    /* renamed from: a */
    public void mo15843a() {
        TTDislikeDialogAbstract tTDislikeDialogAbstract = this.f7753d;
        if (tTDislikeDialogAbstract != null) {
            tTDislikeDialogAbstract.show();
            return;
        }
        TTAdDislikeImpl bVar = this.f7752c;
        if (bVar != null) {
            bVar.showDislikeDialog();
        }
    }

    /* access modifiers changed from: protected */
    public String getNameOrSource() {
        MaterialMeta kVar = this.f7751b;
        String str = "";
        if (kVar == null) {
            return str;
        }
        if (kVar.mo15426N() == null || TextUtils.isEmpty(this.f7751b.mo15426N().mo15345c())) {
            return !TextUtils.isEmpty(this.f7751b.mo15413A()) ? this.f7751b.mo15413A() : str;
        }
        return this.f7751b.mo15426N().mo15345c();
    }

    /* access modifiers changed from: protected */
    public String getTitle() {
        if (this.f7751b.mo15426N() != null && !TextUtils.isEmpty(this.f7751b.mo15426N().mo15345c())) {
            return this.f7751b.mo15426N().mo15345c();
        }
        if (!TextUtils.isEmpty(this.f7751b.mo15413A())) {
            return this.f7751b.mo15413A();
        }
        return !TextUtils.isEmpty(this.f7751b.mo15422J()) ? this.f7751b.mo15422J() : "";
    }

    /* access modifiers changed from: protected */
    public String getDescription() {
        if (!TextUtils.isEmpty(this.f7751b.mo15422J())) {
            return this.f7751b.mo15422J();
        }
        return !TextUtils.isEmpty(this.f7751b.mo15423K()) ? this.f7751b.mo15423K() : "";
    }

    public float getRealWidth() {
        return (float) UIUtils.m12068b(this.f7750a, (float) this.f7755f);
    }

    public float getRealHeight() {
        return (float) UIUtils.m12068b(this.f7750a, (float) this.f7756g);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo15844a(View view, boolean z) {
        ClickListener bVar;
        if (view != null) {
            if (z) {
                Context context = this.f7750a;
                MaterialMeta kVar = this.f7751b;
                String str = this.f7754e;
                bVar = new ClickCreativeListener(context, kVar, str, ToolUtils.m11991a(str));
            } else {
                Context context2 = this.f7750a;
                MaterialMeta kVar2 = this.f7751b;
                String str2 = this.f7754e;
                bVar = new ClickListener(context2, kVar2, str2, ToolUtils.m11991a(str2));
            }
            view.setOnTouchListener(bVar);
            view.setOnClickListener(bVar);
            bVar.mo15281a((BackupViewClickListener) new BackupViewClickListener() {
                /* renamed from: a */
                public void mo15854a(int i, DynamicClickInfo iVar) {
                    BackupView.this.mo15294a(i, iVar);
                }
            });
        }
    }
}
