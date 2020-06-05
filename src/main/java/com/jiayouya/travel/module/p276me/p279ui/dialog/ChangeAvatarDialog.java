package com.jiayouya.travel.module.p276me.p279ui.dialog;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import com.elvishew.xlog.XLog;
import com.jiayouya.travel.R;
import com.jiayouya.travel.common.DefaultPermissionSetting;
import com.jiayouya.travel.common.DefaultRationale;
import com.jiayouya.travel.databinding.DialogChangeAvatarBinding;
import com.tencent.mid.core.Constants;
import com.yanzhenjie.album.Album;
import com.yanzhenjie.album.api.ImageSingleWrapper;
import com.yanzhenjie.permission.AndPermission;
import com.yanzhenjie.permission.C7822a;
import com.yanzhenjie.permission.Rationale;
import ezy.p653ui.widget.dialog.BottomDialog;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.C8271i;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.p679a.C8247b;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\b\u001a\u00020\tH\u0002R\u0016\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, mo39189d2 = {"Lcom/jiayouya/travel/module/me/ui/dialog/ChangeAvatarDialog;", "Lezy/ui/widget/dialog/BottomDialog;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "binding", "Lcom/jiayouya/travel/databinding/DialogChangeAvatarBinding;", "kotlin.jvm.PlatformType", "setupClick", "", "app_grRelease"}, mo39190k = 1, mo39191mv = {1, 1, 15})
/* compiled from: ChangeAvatarDialog.kt */
/* renamed from: com.jiayouya.travel.module.me.ui.dialog.ChangeAvatarDialog */
public final class ChangeAvatarDialog extends BottomDialog {
    /* renamed from: a */
    private final DialogChangeAvatarBinding f11653a = ((DialogChangeAvatarBinding) DataBindingUtil.inflate(getLayoutInflater(), R.layout.dialog_change_avatar, null, false));

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, mo39189d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "invoke"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: ChangeAvatarDialog.kt */
    /* renamed from: com.jiayouya.travel.module.me.ui.dialog.ChangeAvatarDialog$a */
    static final class C3197a extends Lambda implements C8247b<View, Unit> {
        final /* synthetic */ ChangeAvatarDialog this$0;

        C3197a(ChangeAvatarDialog changeAvatarDialog) {
            this.this$0 = changeAvatarDialog;
            super(1);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((View) obj);
            return Unit.f27778a;
        }

        public final void invoke(View view) {
            C8271i.m35386b(view, "it");
            AndPermission.m33993a(this.this$0.getContext()).mo38048a().mo38061a(Constants.PERMISSION_WRITE_EXTERNAL_STORAGE).mo38054a((Rationale<List<String>>) new DefaultRationale<List<String>>(null, 1, null)).mo38053a((C7822a<List<String>>) new C7822a<List<String>>(this) {
                /* renamed from: a */
                final /* synthetic */ C3197a f11654a;

                {
                    this.f11654a = r1;
                }

                /* renamed from: a */
                public final void mo20720a(List<String> list) {
                    ((ImageSingleWrapper) ((ImageSingleWrapper) ((ImageSingleWrapper) Album.m33245a(this.f11654a.this$0.getContext()).mo37541b()).mo37544a(4)).mo37535a(C31991.f11655a)).mo37530a();
                }
            }).mo38057b(new C7822a<List<String>>(this) {
                /* renamed from: a */
                final /* synthetic */ C3197a f11656a;

                {
                    this.f11656a = r1;
                }

                /* renamed from: a */
                public final void mo20720a(List<String> list) {
                    XLog.m12692b("onDenied");
                    if (AndPermission.m33996a(this.f11656a.this$0.getContext(), list)) {
                        Context context = this.f11656a.this$0.getContext();
                        C8271i.m35382a((Object) context, "context");
                        DefaultPermissionSetting defaultPermissionSetting = new DefaultPermissionSetting(context);
                        C8271i.m35382a((Object) list, "it");
                        DefaultPermissionSetting.m12774a(defaultPermissionSetting, list, null, 2, null);
                    }
                }
            }).mo38064l_();
            this.this$0.dismiss();
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, mo39189d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "invoke"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: ChangeAvatarDialog.kt */
    /* renamed from: com.jiayouya.travel.module.me.ui.dialog.ChangeAvatarDialog$b */
    static final class C3201b extends Lambda implements C8247b<View, Unit> {
        final /* synthetic */ ChangeAvatarDialog this$0;

        C3201b(ChangeAvatarDialog changeAvatarDialog) {
            this.this$0 = changeAvatarDialog;
            super(1);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((View) obj);
            return Unit.f27778a;
        }

        public final void invoke(View view) {
            C8271i.m35386b(view, "it");
            this.this$0.dismiss();
        }
    }

    public ChangeAvatarDialog(Context context) {
        C8271i.m35386b(context, "context");
        super(context);
        setDimAmount(0.7f);
        DialogChangeAvatarBinding dialogChangeAvatarBinding = this.f11653a;
        C8271i.m35382a((Object) dialogChangeAvatarBinding, "binding");
        setView(dialogChangeAvatarBinding.getRoot());
        m14130a();
    }

    /* renamed from: a */
    private final void m14130a() {
        TextView textView = this.f11653a.f10298b;
        C8271i.m35382a((Object) textView, "binding.txtPhotoAlbum");
        ezy.p642a.View.m34750a(textView, 0, new C3197a(this), 1, null);
        TextView textView2 = this.f11653a.f10297a;
        C8271i.m35382a((Object) textView2, "binding.txtCancel");
        ezy.p642a.View.m34750a(textView2, 0, new C3201b(this), 1, null);
    }
}
