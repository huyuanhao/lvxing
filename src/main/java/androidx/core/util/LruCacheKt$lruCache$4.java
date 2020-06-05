package androidx.core.util;

import android.util.LruCache;
import com.tencent.android.tpush.SettingsContentProvider;
import com.tencent.p605ep.common.adapt.iservice.account.AccountConst.ArgKey;
import kotlin.Metadata;
import kotlin.jvm.internal.C8271i;
import kotlin.jvm.p679a.C8247b;
import kotlin.jvm.p679a.C8258m;
import kotlin.jvm.p679a.C8263r;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0001J\u0017\u0010\u0002\u001a\u0004\u0018\u00018\u00012\u0006\u0010\u0003\u001a\u00028\u0000H\u0014¢\u0006\u0002\u0010\u0004J/\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00028\u00002\u0006\u0010\t\u001a\u00028\u00012\b\u0010\n\u001a\u0004\u0018\u00018\u0001H\u0014¢\u0006\u0002\u0010\u000bJ\u001d\u0010\f\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00028\u00002\u0006\u0010\u000e\u001a\u00028\u0001H\u0014¢\u0006\u0002\u0010\u000f¨\u0006\u0010"}, mo39189d2 = {"androidx/core/util/LruCacheKt$lruCache$4", "Landroid/util/LruCache;", "create", "key", "(Ljava/lang/Object;)Ljava/lang/Object;", "entryRemoved", "", "evicted", "", "oldValue", "newValue", "(ZLjava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V", "sizeOf", "", "value", "(Ljava/lang/Object;Ljava/lang/Object;)I", "core-ktx_release"}, mo39190k = 1, mo39191mv = {1, 1, 15})
/* compiled from: LruCache.kt */
public final class LruCacheKt$lruCache$4 extends LruCache<K, V> {
    final /* synthetic */ C8247b $create;
    final /* synthetic */ int $maxSize;
    final /* synthetic */ C8263r $onEntryRemoved;
    final /* synthetic */ C8258m $sizeOf;

    public LruCacheKt$lruCache$4(C8258m mVar, C8247b bVar, C8263r rVar, int i, int i2) {
        this.$sizeOf = mVar;
        this.$create = bVar;
        this.$onEntryRemoved = rVar;
        this.$maxSize = i;
        super(i2);
    }

    /* access modifiers changed from: protected */
    public int sizeOf(K k, V v) {
        C8271i.m35386b(k, SettingsContentProvider.KEY);
        C8271i.m35386b(v, ArgKey.KEY_VALUE);
        return ((Number) this.$sizeOf.invoke(k, v)).intValue();
    }

    /* access modifiers changed from: protected */
    public V create(K k) {
        C8271i.m35386b(k, SettingsContentProvider.KEY);
        return this.$create.invoke(k);
    }

    /* access modifiers changed from: protected */
    public void entryRemoved(boolean z, K k, V v, V v2) {
        C8271i.m35386b(k, SettingsContentProvider.KEY);
        C8271i.m35386b(v, "oldValue");
        this.$onEntryRemoved.invoke(Boolean.valueOf(z), k, v, v2);
    }
}
