package com.jiayouya.travel.common.p244b;

import android.app.Activity;
import android.os.Parcelable;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.android.tpush.SettingsContentProvider;
import java.io.Serializable;
import kotlin.C8182c;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.C8271i;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.p679a.C8246a;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000.\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\u001a+\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u0002H\u0002¢\u0006\u0002\u0010\u0007\u001a*\u0010\b\u001a\u00020\t\"\b\b\u0000\u0010\u0002*\u00020\t*\u00020\u00032\f\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0005\u001a\n\u0010\r\u001a\u00020\u000e*\u00020\u000f¨\u0006\u0010"}, mo39189d2 = {"argument", "Lkotlin/Lazy;", "T", "Landroidx/appcompat/app/AppCompatActivity;", "key", "", "default", "(Landroidx/appcompat/app/AppCompatActivity;Ljava/lang/String;Ljava/lang/Object;)Lkotlin/Lazy;", "getFragment", "Landroidx/fragment/app/Fragment;", "clazz", "Ljava/lang/Class;", "tag", "isAlive", "", "Landroid/app/Activity;", "app_grRelease"}, mo39190k = 2, mo39191mv = {1, 1, 15})
/* renamed from: com.jiayouya.travel.common.b.a */
public final class ActivityEx {

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u0004\n\u0002\b\u0004\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, mo39189d2 = {"<anonymous>", "T", "invoke", "()Ljava/lang/Object;"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: ActivityEx.kt */
    /* renamed from: com.jiayouya.travel.common.b.a$a */
    static final class C2858a extends Lambda implements C8246a<T> {
        final /* synthetic */ Object $default;
        final /* synthetic */ String $key;
        final /* synthetic */ AppCompatActivity $this_argument;

        C2858a(AppCompatActivity appCompatActivity, Object obj, String str) {
            this.$this_argument = appCompatActivity;
            this.$default = obj;
            this.$key = str;
            super(0);
        }

        public final T invoke() {
            if (this.$this_argument.getIntent() == null) {
                return this.$default;
            }
            Object obj = this.$default;
            if (obj instanceof String) {
                T stringExtra = this.$this_argument.getIntent().getStringExtra(this.$key);
                if (!(stringExtra instanceof Object)) {
                    stringExtra = null;
                }
                T t = (Object) stringExtra;
                if (t != null) {
                    return t;
                }
                return this.$default;
            } else if (obj instanceof Integer) {
                return Integer.valueOf(this.$this_argument.getIntent().getIntExtra(this.$key, ((Number) this.$default).intValue()));
            } else {
                if (obj instanceof Boolean) {
                    return Boolean.valueOf(this.$this_argument.getIntent().getBooleanExtra(this.$key, ((Boolean) this.$default).booleanValue()));
                }
                if (obj instanceof Short) {
                    return Short.valueOf(this.$this_argument.getIntent().getShortExtra(this.$key, ((Number) this.$default).shortValue()));
                }
                if (obj instanceof Long) {
                    return Long.valueOf(this.$this_argument.getIntent().getLongExtra(this.$key, ((Number) this.$default).longValue()));
                }
                if (obj instanceof Parcelable) {
                    T parcelableExtra = this.$this_argument.getIntent().getParcelableExtra(this.$key);
                    if (!(parcelableExtra instanceof Object)) {
                        parcelableExtra = null;
                    }
                    T t2 = (Object) parcelableExtra;
                    if (t2 != null) {
                        return t2;
                    }
                    return this.$default;
                } else if (obj instanceof Serializable) {
                    T serializableExtra = this.$this_argument.getIntent().getSerializableExtra(this.$key);
                    if (!(serializableExtra instanceof Object)) {
                        serializableExtra = null;
                    }
                    T t3 = (Object) serializableExtra;
                    return t3 != null ? t3 : this.$default;
                } else {
                    throw new RuntimeException("不支持获取该类型");
                }
            }
        }
    }

    /* renamed from: a */
    public static final <T> Lazy<T> m12803a(AppCompatActivity appCompatActivity, String str, T t) {
        C8271i.m35386b(appCompatActivity, "$this$argument");
        C8271i.m35386b(str, SettingsContentProvider.KEY);
        return C8182c.m35317a(new C2858a(appCompatActivity, t, str));
    }

    /* renamed from: a */
    public static final boolean m12804a(Activity activity) {
        C8271i.m35386b(activity, "$this$isAlive");
        return !activity.isFinishing() && !activity.isDestroyed();
    }
}
