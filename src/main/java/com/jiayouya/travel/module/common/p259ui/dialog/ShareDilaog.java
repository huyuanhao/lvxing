package com.jiayouya.travel.module.common.p259ui.dialog;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import com.jiayouya.travel.C2914d;
import com.jiayouya.travel.R;
import com.jiayouya.travel.common.DefaultPermissionSetting;
import com.jiayouya.travel.common.DefaultRationale;
import com.jiayouya.travel.common.binding.BindingType;
import com.jiayouya.travel.common.binding.ClickableBindingHolder;
import com.jiayouya.travel.common.binding.OnBindListener;
import com.jiayouya.travel.common.p244b.GloblaEx;
import com.jiayouya.travel.common.p244b.ViewEx;
import com.jiayouya.travel.common.p246d.FileUtil;
import com.jiayouya.travel.common.p246d.ImageUtil;
import com.jiayouya.travel.databinding.DialogShareBinding;
import com.jiayouya.travel.databinding.ItemShareBinding;
import com.jiayouya.travel.module.common.data.ShareItem;
import com.jiayouya.travel.module.common.data.User;
import com.jiayouya.travel.module.common.p260vm.ResidentMemoryModel;
import com.jiayouya.travel.module.travel.data.ShareInfo;
import com.jiayouya.travel.module.travel.p285a.C3324d;
import com.tencent.android.tpush.common.Constants;
import com.yanzhenjie.permission.AndPermission;
import com.yanzhenjie.permission.C7822a;
import com.yanzhenjie.permission.Rationale;
import com.yanzhenjie.permission.runtime.Permission.C7844a;
import ezy.app.p643a.API;
import ezy.app.p645rx.C8019a;
import ezy.p653ui.widget.dialog.BottomDialog;
import ezy.p653ui.widget.recyclerview.adapter.SingleTypeAdapter;
import ezy.sdk3rd.social.ShareSDK;
import ezy.sdk3rd.social.sdk.OnCallback;
import ezy.sdk3rd.social.share.p652b.IMediaObject;
import ezy.sdk3rd.social.share.p652b.MoImage;
import java.io.File;
import java.util.List;
import kotlin.C8182c;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.collections.C8187k;
import kotlin.jvm.internal.C8271i;
import kotlin.jvm.internal.C8272k;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.PropertyReference1;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.p679a.C8246a;
import kotlin.jvm.p679a.C8247b;
import kotlin.p674b.Thread;
import kotlin.reflect.C8280j;
import p655io.reactivex.Observable;
import p655io.reactivex.p664d.Consumer;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000A\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\b\f\n\u0002\u0010\u000e\n\u0000*\u0001\u0013\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\u0002\u0010\u0007J\b\u0010\u0018\u001a\u00020\u0006H\u0002J\u0016\u0010\u0019\u001a\u00020\u00062\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0002J\b\u0010\u001b\u001a\u00020\u0006H\u0002J\b\u0010\u001c\u001a\u00020\u0006H\u0002J\u0010\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020\u001fH\u0002R\u0019\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\r\u001a\n \u000f*\u0004\u0018\u00010\u000e0\u000eX\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0010\u001a\n \u000f*\u0004\u0018\u00010\u00110\u0011X\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0012\u001a\u00020\u00138BX\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0014\u0010\u0015¨\u0006 "}, mo39189d2 = {"Lcom/jiayouya/travel/module/common/ui/dialog/ShareDialog;", "Lezy/ui/widget/dialog/BottomDialog;", "activity", "Landroid/app/Activity;", "action", "Lkotlin/Function0;", "", "(Landroid/app/Activity;Lkotlin/jvm/functions/Function0;)V", "getAction", "()Lkotlin/jvm/functions/Function0;", "adapter", "Lezy/ui/widget/recyclerview/adapter/SingleTypeAdapter;", "Lcom/jiayouya/travel/module/common/data/ShareItem;", "bindType", "Lcom/jiayouya/travel/common/binding/BindingType;", "kotlin.jvm.PlatformType", "binding", "Lcom/jiayouya/travel/databinding/DialogShareBinding;", "shareCallback", "com/jiayouya/travel/module/common/ui/dialog/ShareDialog$shareCallback$2$1", "getShareCallback", "()Lcom/jiayouya/travel/module/common/ui/dialog/ShareDialog$shareCallback$2$1;", "shareCallback$delegate", "Lkotlin/Lazy;", "fetchInfo", "requestPermission", "granted", "setupClick", "setupView", "shareImage", "platform", "", "app_grRelease"}, mo39190k = 1, mo39191mv = {1, 1, 15})
/* renamed from: com.jiayouya.travel.module.common.ui.dialog.c */
public final class ShareDilaog extends BottomDialog {
    /* renamed from: a */
    static final /* synthetic */ C8280j[] f11308a = {C8272k.m35400a((PropertyReference1) new PropertyReference1Impl(C8272k.m35394a(ShareDilaog.class), "shareCallback", "getShareCallback()Lcom/jiayouya/travel/module/common/ui/dialog/ShareDialog$shareCallback$2$1;"))};
    /* access modifiers changed from: private|final */
    /* renamed from: b */
    public final DialogShareBinding f11309b;
    /* renamed from: c */
    private final BindingType f11310c;
    /* access modifiers changed from: private|final */
    /* renamed from: d */
    public final SingleTypeAdapter<ShareItem> f11311d;
    /* renamed from: e */
    private final Lazy f11312e;
    /* access modifiers changed from: private|final */
    /* renamed from: f */
    public final Activity f11313f;
    /* renamed from: g */
    private final C8246a<Unit> f11314g;

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo39189d2 = {"<anonymous>", "", "it", "Lcom/jiayouya/travel/module/travel/data/ShareInfo;", "kotlin.jvm.PlatformType", "accept"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: ShareDilaog.kt */
    /* renamed from: com.jiayouya.travel.module.common.ui.dialog.c$a */
    static final class C2968a<T> implements Consumer<ShareInfo> {
        /* renamed from: a */
        final /* synthetic */ ShareDilaog f11315a;
        /* renamed from: b */
        final /* synthetic */ User f11316b;

        C2968a(ShareDilaog cVar, User user) {
            this.f11315a = cVar;
            this.f11316b = user;
        }

        /* renamed from: a */
        public final void accept(ShareInfo shareInfo) {
            C8271i.m35382a((Object) shareInfo, "it");
            ShareItem shareItem = new ShareItem(R.mipmap.bg_share_green, shareInfo);
            shareItem.setUser(this.f11316b);
            shareItem.setStart(true);
            shareItem.setSelected(true);
            ShareItem shareItem2 = new ShareItem(R.mipmap.bg_share_red, shareInfo);
            shareItem2.setUser(this.f11316b);
            shareItem2.setEnd(true);
            this.f11315a.f11311d.setItems(C8187k.m35271b(shareItem, shareItem2));
            this.f11315a.f11311d.notifyDataSetChanged();
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\u0010\u0000\u001a\u00020\u00012*\u0010\u0002\u001a&\u0012\f\u0012\n \u0005*\u0004\u0018\u00010\u00040\u0004 \u0005*\u0012\u0012\f\u0012\n \u0005*\u0004\u0018\u00010\u00040\u0004\u0018\u00010\u00060\u0003H\n¢\u0006\u0002\b\u0007"}, mo39189d2 = {"<anonymous>", "", "it", "", "", "kotlin.jvm.PlatformType", "", "onAction"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: ShareDilaog.kt */
    /* renamed from: com.jiayouya.travel.module.common.ui.dialog.c$b */
    static final class C2969b<T> implements C7822a<List<String>> {
        /* renamed from: a */
        final /* synthetic */ ShareDilaog f11317a;

        C2969b(ShareDilaog cVar) {
            this.f11317a = cVar;
        }

        /* renamed from: a */
        public final void mo20720a(List<String> list) {
            if (AndPermission.m33995a(this.f11317a.f11313f, list)) {
                DefaultPermissionSetting defaultPermissionSetting = new DefaultPermissionSetting(this.f11317a.f11313f);
                C8271i.m35382a((Object) list, "it");
                defaultPermissionSetting.mo19838a(list, C29701.INSTANCE);
            }
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\u0010\u0000\u001a\u00020\u00012*\u0010\u0002\u001a&\u0012\f\u0012\n \u0005*\u0004\u0018\u00010\u00040\u0004 \u0005*\u0012\u0012\f\u0012\n \u0005*\u0004\u0018\u00010\u00040\u0004\u0018\u00010\u00060\u0003H\n¢\u0006\u0002\b\u0007"}, mo39189d2 = {"<anonymous>", "", "it", "", "", "kotlin.jvm.PlatformType", "", "onAction"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: ShareDilaog.kt */
    /* renamed from: com.jiayouya.travel.module.common.ui.dialog.c$c */
    static final class C2971c<T> implements C7822a<List<String>> {
        /* renamed from: a */
        final /* synthetic */ C8246a f11318a;

        C2971c(C8246a aVar) {
            this.f11318a = aVar;
        }

        /* renamed from: a */
        public final void mo20720a(List<String> list) {
            this.f11318a.invoke();
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, mo39189d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "invoke"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: ShareDilaog.kt */
    /* renamed from: com.jiayouya.travel.module.common.ui.dialog.c$d */
    static final class C2972d extends Lambda implements C8247b<View, Unit> {
        final /* synthetic */ ShareDilaog this$0;

        C2972d(ShareDilaog cVar) {
            this.this$0 = cVar;
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

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, mo39189d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "invoke"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: ShareDilaog.kt */
    /* renamed from: com.jiayouya.travel.module.common.ui.dialog.c$e */
    static final class C2973e extends Lambda implements C8247b<View, Unit> {
        final /* synthetic */ ShareDilaog this$0;

        C2973e(ShareDilaog cVar) {
            this.this$0 = cVar;
            super(1);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((View) obj);
            return Unit.f27778a;
        }

        public final void invoke(View view) {
            C8271i.m35386b(view, "it");
            if (!this.this$0.f11311d.getItems().isEmpty()) {
                this.this$0.dismiss();
                this.this$0.m13575a("wxsession");
            }
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, mo39189d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "invoke"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: ShareDilaog.kt */
    /* renamed from: com.jiayouya.travel.module.common.ui.dialog.c$f */
    static final class C2974f extends Lambda implements C8247b<View, Unit> {
        final /* synthetic */ ShareDilaog this$0;

        C2974f(ShareDilaog cVar) {
            this.this$0 = cVar;
            super(1);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((View) obj);
            return Unit.f27778a;
        }

        public final void invoke(View view) {
            C8271i.m35386b(view, "it");
            if (!this.this$0.f11311d.getItems().isEmpty()) {
                this.this$0.dismiss();
                this.this$0.m13575a("towxtimeline");
            }
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\u00020\u00012&\u0010\u0002\u001a\"\u0012\f\u0012\n \u0005*\u0004\u0018\u00010\u00040\u0004 \u0005*\u000b\u0012\u0002\b\u0003\u0018\u00010\u0003¨\u0006\u00010\u0003¨\u0006\u00012\u000e\u0010\u0006\u001a\n \u0005*\u0004\u0018\u00010\u00070\u0007H\n¢\u0006\u0002\b\b"}, mo39189d2 = {"<anonymous>", "", "holder", "Lcom/jiayouya/travel/common/binding/ClickableBindingHolder;", "Landroidx/databinding/ViewDataBinding;", "kotlin.jvm.PlatformType", "item", "", "onBind"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: ShareDilaog.kt */
    /* renamed from: com.jiayouya.travel.module.common.ui.dialog.c$g */
    static final class C2975g implements OnBindListener {
        /* renamed from: a */
        public static final C2975g f11319a = new C2975g();

        C2975g() {
        }

        /* renamed from: a */
        public final void mo19911a(ClickableBindingHolder<ViewDataBinding> clickableBindingHolder, final Object obj) {
            if (obj != null) {
                ShareItem shareItem = (ShareItem) obj;
                final ItemShareBinding itemShareBinding = (ItemShareBinding) DataBindingUtil.getBinding(clickableBindingHolder.itemView);
                if (itemShareBinding != null) {
                    C8271i.m35382a((Object) itemShareBinding, "DataBindingUtil.getBindi…  ?: return@setOnItemBind");
                    if (shareItem.getQrBitmap() == null) {
                        Thread.m35249a(false, false, null, null, 0, new C8246a<Unit>() {
                            public final void invoke() {
                                Object obj = obj;
                                ((ShareItem) obj).setQrBitmap(((ShareItem) obj).getQrImage());
                                C2914d.m13179a((Runnable) new Runnable(this) {
                                    /* renamed from: a */
                                    final /* synthetic */ C29761 f11321a;

                                    {
                                        this.f11321a = r1;
                                    }

                                    public final void run() {
                                        if (itemShareBinding.f11163a != null) {
                                            itemShareBinding.f11163a.setImageBitmap(((ShareItem) obj).getQrBitmap());
                                        }
                                    }
                                });
                            }
                        }, 31, null);
                    } else {
                        itemShareBinding.f11163a.setImageBitmap(shareItem.getQrBitmap());
                    }
                }
            } else {
                throw new TypeCastException("null cannot be cast to non-null type com.jiayouya.travel.module.common.data.ShareItem");
            }
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\t\n\u0000\n\u0002\b\u0003*\u0001\u0001\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, mo39189d2 = {"<anonymous>", "com/jiayouya/travel/module/common/ui/dialog/ShareDialog$shareCallback$2$1", "invoke", "()Lcom/jiayouya/travel/module/common/ui/dialog/ShareDialog$shareCallback$2$1;"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: ShareDilaog.kt */
    /* renamed from: com.jiayouya.travel.module.common.ui.dialog.c$h */
    static final class C2978h extends Lambda implements C8246a<C29791> {
        final /* synthetic */ ShareDilaog this$0;

        C2978h(ShareDilaog cVar) {
            this.this$0 = cVar;
            super(0);
        }

        public final C29791 invoke() {
            return new OnCallback<String>(this) {
                /* renamed from: a */
                final /* synthetic */ C2978h f11322a;

                /* renamed from: a */
                public void mo20727a(Activity activity) {
                }

                {
                    this.f11322a = r1;
                }

                /* renamed from: a */
                public void mo20729a(Activity activity, String str) {
                    GloblaEx.m12816a("分享成功", 0, 0, 6, null);
                    C8246a a = this.f11322a.this$0.mo20718a();
                    if (a != null) {
                        Unit jVar = (Unit) a.invoke();
                    }
                }

                /* renamed from: a */
                public void mo20728a(Activity activity, int i, String str) {
                    GloblaEx.m12816a("分享失败", 0, 0, 6, null);
                }

                /* renamed from: b */
                public void mo20731b(Activity activity) {
                    if (this.f11322a.this$0.isShowing()) {
                        this.f11322a.this$0.dismiss();
                    }
                }
            };
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo39189d2 = {"<anonymous>", "", "invoke"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: ShareDilaog.kt */
    /* renamed from: com.jiayouya.travel.module.common.ui.dialog.c$i */
    static final class C2980i extends Lambda implements C8246a<Unit> {
        final /* synthetic */ String $platform;
        final /* synthetic */ ShareDilaog this$0;

        C2980i(ShareDilaog cVar, String str) {
            this.this$0 = cVar;
            this.$platform = str;
            super(0);
        }

        public final void invoke() {
            Context context = this.this$0.getContext();
            C8271i.m35382a((Object) context, "context");
            File file = new File(FileUtil.m12957a(context), "lxsj-share.jpeg");
            if (file.exists()) {
                file.delete();
            }
            file.createNewFile();
            RecyclerView recyclerView = this.this$0.f11309b.f10619d;
            C8271i.m35382a((Object) recyclerView, "binding.list");
            LayoutManager layoutManager = recyclerView.getLayoutManager();
            if (layoutManager == null) {
                return;
            }
            if (layoutManager != null) {
                View findViewByPosition = layoutManager.findViewByPosition(((LinearLayoutManager) layoutManager).findFirstCompletelyVisibleItemPosition());
                if (findViewByPosition != null) {
                    C8271i.m35382a((Object) findViewByPosition, "it.findViewByPosition(position) ?: return@let");
                    if (findViewByPosition instanceof ViewGroup) {
                        ViewGroup viewGroup = (ViewGroup) findViewByPosition;
                        if (viewGroup.getChildCount() > 0) {
                            View childAt = viewGroup.getChildAt(0);
                            C8271i.m35382a((Object) childAt, "view.getChildAt(0)");
                            Bitmap a = ViewEx.m12839a(childAt);
                            if (a != null) {
                                ImageUtil.m12961a(a, file, 307200);
                            }
                            Bitmap decodeFile = BitmapFactory.decodeFile(file.getPath());
                            if (decodeFile != null) {
                                ShareSDK.m34817a(this.this$0.f11313f, (IMediaObject) new MoImage(decodeFile)).mo38575a(this.$platform, (OnCallback<String>) this.this$0.m13583e());
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    return;
                }
                return;
            }
            throw new TypeCastException("null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
        }
    }

    /* access modifiers changed from: private|final */
    /* renamed from: e */
    public final C29791 m13583e() {
        Lazy bVar = this.f11312e;
        C8280j jVar = f11308a[0];
        return (C29791) bVar.getValue();
    }

    public /* synthetic */ ShareDilaog(Activity activity, C8246a aVar, int i, DefaultConstructorMarker fVar) {
        if ((i & 2) != 0) {
            aVar = null;
        }
        this(activity, aVar);
    }

    /* renamed from: a */
    public final C8246a<Unit> mo20718a() {
        return this.f11314g;
    }

    public ShareDilaog(Activity activity, C8246a<Unit> aVar) {
        C8271i.m35386b(activity, Constants.FLAG_ACTIVITY_NAME);
        super(activity);
        this.f11313f = activity;
        this.f11314g = aVar;
        this.f11309b = (DialogShareBinding) DataBindingUtil.inflate(getLayoutInflater(), R.layout.dialog_share, null, false);
        this.f11310c = BindingType.create(ShareItem.class, (int) R.layout.item_share);
        this.f11311d = new SingleTypeAdapter<>(this.f11310c);
        DialogShareBinding dialogShareBinding = this.f11309b;
        C8271i.m35382a((Object) dialogShareBinding, "binding");
        setView(dialogShareBinding.getRoot());
        m13582d();
        m13580c();
        m13578b();
        this.f11312e = C8182c.m35317a(new C2978h(this));
    }

    /* renamed from: b */
    private final void m13578b() {
        User user = (User) ResidentMemoryModel.f11323a.mo20737b().getValue();
        if (user == null) {
            ResidentMemoryModel.m13597a(ResidentMemoryModel.f11323a, null, null, null, 7, null);
        }
        Observable k = C3324d.m14443a(API.f27251a).mo21647k();
        DialogShareBinding dialogShareBinding = this.f11309b;
        C8271i.m35382a((Object) dialogShareBinding, "binding");
        View root = dialogShareBinding.getRoot();
        C8271i.m35382a((Object) root, "binding.root");
        C8019a.m34776a(k, root).mo37374a(new C2968a(this, user));
    }

    /* renamed from: c */
    private final void m13580c() {
        setDimAmount(0.7f);
        DialogShareBinding dialogShareBinding = this.f11309b;
        C8271i.m35382a((Object) dialogShareBinding, "binding");
        View root = dialogShareBinding.getRoot();
        C8271i.m35382a((Object) root, "binding.root");
        root.getLayoutParams().width = GloblaEx.m12809a();
        RecyclerView recyclerView = this.f11309b.f10619d;
        C8271i.m35382a((Object) recyclerView, "binding.list");
        recyclerView.setAdapter(this.f11311d);
        this.f11309b.f10619d.addOnScrollListener(new ShareDialog$setupView$1(this));
        new PagerSnapHelper().attachToRecyclerView(this.f11309b.f10619d);
        this.f11310c.setOnItemBind(C2975g.f11319a);
    }

    /* renamed from: d */
    private final void m13582d() {
        ImageView imageView = this.f11309b.f10616a;
        C8271i.m35382a((Object) imageView, "binding.ivClose");
        ezy.p642a.View.m34750a(imageView, 0, new C2972d(this), 1, null);
        TextView textView = this.f11309b.f10617b;
        C8271i.m35382a((Object) textView, "binding.ivWx");
        ezy.p642a.View.m34750a(textView, 0, new C2973e(this), 1, null);
        TextView textView2 = this.f11309b.f10618c;
        C8271i.m35382a((Object) textView2, "binding.ivWxCircle");
        ezy.p642a.View.m34750a(textView2, 0, new C2974f(this), 1, null);
    }

    /* access modifiers changed from: private|final */
    /* renamed from: a */
    public final void m13575a(String str) {
        m13576a((C8246a<Unit>) new C2980i<Unit>(this, str));
    }

    /* renamed from: a */
    private final void m13576a(C8246a<Unit> aVar) {
        AndPermission.m33992a(this.f11313f).mo38048a().mo38062a(C7844a.f26692k).mo38054a((Rationale<List<String>>) new DefaultRationale<List<String>>(null, 1, null)).mo38057b(new C2969b(this)).mo38053a((C7822a<List<String>>) new C2971c<List<String>>(aVar)).mo38064l_();
    }
}
