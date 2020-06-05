package androidx.core.util;

import android.util.LruCache;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.C8271i;
import kotlin.jvm.p679a.C8247b;
import kotlin.jvm.p679a.C8258m;
import kotlin.jvm.p679a.C8263r;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000:\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\u001aø\u0001\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0004\"\b\b\u0001\u0010\u0003*\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u000628\b\u0006\u0010\u0007\u001a2\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0013\u0012\u0011H\u0003¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\u00060\b2%\b\u0006\u0010\r\u001a\u001f\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0006\u0012\u0004\u0018\u0001H\u00030\u000e2d\b\u0006\u0010\u000f\u001a^\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u0012\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0013\u0012\u0011H\u0003¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u0013\u0012\u0015\u0012\u0013\u0018\u0001H\u0003¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\u00150\u0010H\b¨\u0006\u0016"}, mo39189d2 = {"lruCache", "Landroid/util/LruCache;", "K", "V", "", "maxSize", "", "sizeOf", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "key", "value", "create", "Lkotlin/Function1;", "onEntryRemoved", "Lkotlin/Function4;", "", "evicted", "oldValue", "newValue", "", "core-ktx_release"}, mo39190k = 2, mo39191mv = {1, 1, 15})
/* compiled from: LruCache.kt */
public final class LruCacheKt {
    public static /* synthetic */ LruCache lruCache$default(int i, C8258m mVar, C8247b bVar, C8263r rVar, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            mVar = LruCacheKt$lruCache$1.INSTANCE;
        }
        C8258m mVar2 = mVar;
        if ((i2 & 4) != 0) {
            bVar = LruCacheKt$lruCache$2.INSTANCE;
        }
        C8247b bVar2 = bVar;
        if ((i2 & 8) != 0) {
            rVar = LruCacheKt$lruCache$3.INSTANCE;
        }
        C8263r rVar2 = rVar;
        C8271i.m35386b(mVar2, "sizeOf");
        C8271i.m35386b(bVar2, "create");
        C8271i.m35386b(rVar2, "onEntryRemoved");
        LruCacheKt$lruCache$4 lruCacheKt$lruCache$4 = new LruCacheKt$lruCache$4(mVar2, bVar2, rVar2, i, i);
        return lruCacheKt$lruCache$4;
    }

    public static final <K, V> LruCache<K, V> lruCache(int i, C8258m<? super K, ? super V, Integer> mVar, C8247b<? super K, ? extends V> bVar, C8263r<? super Boolean, ? super K, ? super V, ? super V, Unit> rVar) {
        C8271i.m35386b(mVar, "sizeOf");
        C8271i.m35386b(bVar, "create");
        C8271i.m35386b(rVar, "onEntryRemoved");
        LruCacheKt$lruCache$4 lruCacheKt$lruCache$4 = new LruCacheKt$lruCache$4(mVar, bVar, rVar, i, i);
        return lruCacheKt$lruCache$4;
    }
}
