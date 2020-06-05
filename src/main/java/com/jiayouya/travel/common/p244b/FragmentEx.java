package com.jiayouya.travel.common.p244b;

import android.os.Bundle;
import android.os.Parcelable;
import androidx.fragment.app.Fragment;
import com.tencent.android.tpush.SettingsContentProvider;
import java.io.Serializable;
import kotlin.C8182c;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.C8271i;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.p679a.C8246a;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u001a+\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u0002H\u0002¢\u0006\u0002\u0010\u0007¨\u0006\b"}, mo39189d2 = {"argument", "Lkotlin/Lazy;", "T", "Landroidx/fragment/app/Fragment;", "key", "", "default", "(Landroidx/fragment/app/Fragment;Ljava/lang/String;Ljava/lang/Object;)Lkotlin/Lazy;", "app_grRelease"}, mo39190k = 2, mo39191mv = {1, 1, 15})
/* renamed from: com.jiayouya.travel.common.b.c */
public final class FragmentEx {

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u0004\n\u0002\b\u0004\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, mo39189d2 = {"<anonymous>", "T", "invoke", "()Ljava/lang/Object;"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: FragmentEx.kt */
    /* renamed from: com.jiayouya.travel.common.b.c$a */
    static final class C2859a extends Lambda implements C8246a<T> {
        final /* synthetic */ Object $default;
        final /* synthetic */ String $key;
        final /* synthetic */ Fragment $this_argument;

        C2859a(Fragment fragment, Object obj, String str) {
            this.$this_argument = fragment;
            this.$default = obj;
            this.$key = str;
            super(0);
        }

        public final T invoke() {
            if (this.$this_argument.getArguments() == null) {
                return this.$default;
            }
            Object obj = this.$default;
            if (obj instanceof String) {
                Bundle arguments = this.$this_argument.getArguments();
                if (arguments == null) {
                    C8271i.m35380a();
                }
                return arguments.getString(this.$key, (String) this.$default);
            } else if (obj instanceof Integer) {
                Bundle arguments2 = this.$this_argument.getArguments();
                if (arguments2 == null) {
                    C8271i.m35380a();
                }
                return Integer.valueOf(arguments2.getInt(this.$key, ((Number) this.$default).intValue()));
            } else if (obj instanceof Boolean) {
                Bundle arguments3 = this.$this_argument.getArguments();
                if (arguments3 == null) {
                    C8271i.m35380a();
                }
                return Boolean.valueOf(arguments3.getBoolean(this.$key, ((Boolean) this.$default).booleanValue()));
            } else if (obj instanceof Short) {
                Bundle arguments4 = this.$this_argument.getArguments();
                if (arguments4 == null) {
                    C8271i.m35380a();
                }
                return Short.valueOf(arguments4.getShort(this.$key, ((Number) this.$default).shortValue()));
            } else if (obj instanceof Long) {
                Bundle arguments5 = this.$this_argument.getArguments();
                if (arguments5 == null) {
                    C8271i.m35380a();
                }
                return Long.valueOf(arguments5.getLong(this.$key, ((Number) this.$default).longValue()));
            } else if (obj instanceof Parcelable) {
                Bundle arguments6 = this.$this_argument.getArguments();
                if (arguments6 == null) {
                    C8271i.m35380a();
                }
                T parcelable = arguments6.getParcelable(this.$key);
                if (!(parcelable instanceof Object)) {
                    parcelable = null;
                }
                T t = (Object) parcelable;
                if (t != null) {
                    return t;
                }
                return this.$default;
            } else if (obj instanceof Serializable) {
                Bundle arguments7 = this.$this_argument.getArguments();
                if (arguments7 == null) {
                    C8271i.m35380a();
                }
                T serializable = arguments7.getSerializable(this.$key);
                if (!(serializable instanceof Object)) {
                    serializable = null;
                }
                T t2 = (Object) serializable;
                return t2 != null ? t2 : this.$default;
            } else {
                throw new RuntimeException("不支持获取该类型");
            }
        }
    }

    /* renamed from: a */
    public static final <T> Lazy<T> m12808a(Fragment fragment, String str, T t) {
        C8271i.m35386b(fragment, "$this$argument");
        C8271i.m35386b(str, SettingsContentProvider.KEY);
        return C8182c.m35317a(new C2859a(fragment, t, str));
    }
}
