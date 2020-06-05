package com.jiayouya.travel.module.travel.widget.merge;

import android.view.View;
import androidx.customview.widget.ViewDragHelper.Callback;
import com.elvishew.xlog.XLog;
import com.jiayouya.travel.R;
import com.jiayouya.travel.module.travel.data.PositionItem;
import com.jiayouya.travel.module.travel.data.PositionItemKt;
import com.jiayouya.travel.module.travel.p287c.MergeUtil;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.C8271i;
import kotlin.jvm.p679a.C8246a;
import kotlin.jvm.p679a.C8247b;
import kotlin.jvm.p679a.C8258m;
import kotlin.jvm.p679a.C8262q;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u00001\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0003H\u0016J \u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u0003H\u0016J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J \u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0011H\u0016J\u0018\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u0003H\u0016¨\u0006\u0016"}, mo39189d2 = {"com/jiayouya/travel/module/travel/widget/merge/MergeLayout$viewDragHelper$2$1", "Landroidx/customview/widget/ViewDragHelper$Callback;", "clampViewPositionHorizontal", "", "child", "Landroid/view/View;", "left", "dx", "clampViewPositionVertical", "top", "dy", "getViewHorizontalDragRange", "getViewVerticalDragRange", "onViewReleased", "", "releasedChild", "xvel", "", "yvel", "tryCaptureView", "", "pointerId", "app_grRelease"}, mo39190k = 1, mo39191mv = {1, 1, 15})
/* compiled from: MergeLayout.kt */
public final class MergeLayout$viewDragHelper$2$1 extends Callback {
    /* renamed from: a */
    final /* synthetic */ C3582e f12317a;

    MergeLayout$viewDragHelper$2$1(C3582e eVar) {
        this.f12317a = eVar;
    }

    public boolean tryCaptureView(View view, int i) {
        C8271i.m35386b(view, "child");
        if (!(view instanceof MergeChild) || !PositionItemKt.validate(((MergeChild) view).getItem())) {
            return false;
        }
        view.bringToFront();
        return true;
    }

    public int getViewHorizontalDragRange(View view) {
        C8271i.m35386b(view, "child");
        return this.f12317a.this$0.getMeasuredWidth();
    }

    public int getViewVerticalDragRange(View view) {
        C8271i.m35386b(view, "child");
        return this.f12317a.this$0.getMeasuredHeight();
    }

    public void onViewReleased(View view, float f, float f2) {
        C8271i.m35386b(view, "releasedChild");
        if (view instanceof MergeChild) {
            C8247b onReleaseListener = this.f12317a.this$0.getOnReleaseListener();
            if (C8271i.m35384a(onReleaseListener != null ? (Boolean) onReleaseListener.invoke(view) : null, (Object) Boolean.valueOf(true))) {
                this.f12317a.this$0.requestLayout();
                return;
            }
            View a = MergeUtil.m14453a(view, this.f12317a.this$0.f12292e);
            if (a == null) {
                XLog.m12692b("回到原来位置");
            } else if (C8271i.m35384a((Object) a, (Object) this.f12317a.this$0.getGarbageCanView())) {
                XLog.m12692b("回收");
                PositionItem item = ((MergeChild) view).getItem();
                C8258m onRecycleStartListener = this.f12317a.this$0.getOnRecycleStartListener();
                if (onRecycleStartListener != null) {
                    Unit jVar = (Unit) onRecycleStartListener.invoke(Integer.valueOf(item.getPosition()), Integer.valueOf(item.getDogId()));
                }
            } else if (a instanceof MergeChild) {
                MergeChild mergeChild = (MergeChild) a;
                int level = mergeChild.getItem().getLevel();
                Iterator it = this.f12317a.this$0.f12290c.iterator();
                int i = 0;
                while (true) {
                    if (!it.hasNext()) {
                        i = -1;
                        break;
                    }
                    if (((Number) it.next()).intValue() == ((MergeChild) view).getItem().getDogId()) {
                        break;
                    }
                    i++;
                }
                boolean z = i != -1;
                Iterator it2 = this.f12317a.this$0.f12290c.iterator();
                int i2 = 0;
                while (true) {
                    if (!it2.hasNext()) {
                        i2 = -1;
                        break;
                    }
                    if (((Number) it2.next()).intValue() == mergeChild.getItem().getDogId()) {
                        break;
                    }
                    i2++;
                }
                boolean z2 = i2 != -1;
                MergeChild mergeChild2 = (MergeChild) view;
                boolean z3 = level == mergeChild2.getItem().getLevel() && !PositionItemKt.isTemp(mergeChild2.getItem()) && !PositionItemKt.isTemp(mergeChild.getItem()) && (level != 38 || ((z && z2) || MergeUtil.m14454a(mergeChild2.getItem().getDogId(), mergeChild.getItem().getDogId())));
                if (z3) {
                    int position = mergeChild2.getItem().getPosition();
                    int position2 = mergeChild.getItem().getPosition();
                    boolean z4 = z && z2;
                    if (z4) {
                        C8246a onSuperMergeListener = this.f12317a.this$0.getOnSuperMergeListener();
                        if (onSuperMergeListener != null) {
                            Unit jVar2 = (Unit) onSuperMergeListener.invoke();
                        }
                    } else if (MergeUtil.m14454a(mergeChild2.getItem().getDogId(), mergeChild.getItem().getDogId())) {
                        C8258m onLoversMergeListener = this.f12317a.this$0.getOnLoversMergeListener();
                        if (onLoversMergeListener != null) {
                            Unit jVar3 = (Unit) onLoversMergeListener.invoke(Integer.valueOf(position), Integer.valueOf(position2));
                        }
                    } else {
                        int level2 = mergeChild.getItem().getLevel() + 1;
                        if (level2 > this.f12317a.this$0.getMaxLevel()) {
                            C8262q onMaxLevelChangeListener = this.f12317a.this$0.getOnMaxLevelChangeListener();
                            if (onMaxLevelChangeListener != null) {
                                Unit jVar4 = (Unit) onMaxLevelChangeListener.invoke(Integer.valueOf(position), Integer.valueOf(position2), Integer.valueOf(level2));
                            }
                        }
                        if (level2 < 38) {
                            PositionItem item2 = mergeChild.getItem();
                            item2.setDogId(item2.getDogId() + 1);
                        }
                        mergeChild.getItem().setLevel(level2);
                        if (level2 == 38) {
                            a.setTag(R.id.tag, mergeChild2.getItem());
                        }
                        C8262q onMergeListener = this.f12317a.this$0.getOnMergeListener();
                        if (onMergeListener != null) {
                            Unit jVar5 = (Unit) onMergeListener.invoke(a, Integer.valueOf(position), Integer.valueOf(position2));
                        }
                        mergeChild2.setItem(PositionItemKt.createEmptyPosition(position));
                    }
                    this.f12317a.this$0.m14949e();
                } else {
                    XLog.m12692b("交换位置");
                    int position3 = mergeChild2.getItem().getPosition();
                    mergeChild2.getItem().setPosition(mergeChild.getItem().getPosition());
                    mergeChild.getItem().setPosition(position3);
                    PositionItem item3 = mergeChild2.getItem();
                    mergeChild2.setItem(mergeChild.getItem());
                    mergeChild.setItem(item3);
                    C8258m onMoveChangeListener = this.f12317a.this$0.getOnMoveChangeListener();
                    if (onMoveChangeListener != null) {
                        Unit jVar6 = (Unit) onMoveChangeListener.invoke(Integer.valueOf(mergeChild2.getItem().getPosition()), Integer.valueOf(mergeChild.getItem().getPosition()));
                    }
                }
                MergeLayout.m14943a(this.f12317a.this$0, mergeChild2, false, 2, null);
                this.f12317a.this$0.mo22522a(mergeChild, z3);
            } else {
                XLog.m12692b("------");
            }
            this.f12317a.this$0.requestLayout();
        }
    }

    public int clampViewPositionHorizontal(View view, int i, int i2) {
        C8271i.m35386b(view, "child");
        if (i < 0) {
            return 0;
        }
        return i > this.f12317a.this$0.getMeasuredWidth() - view.getMeasuredWidth() ? this.f12317a.this$0.getMeasuredWidth() - view.getMeasuredWidth() : i;
    }

    public int clampViewPositionVertical(View view, int i, int i2) {
        C8271i.m35386b(view, "child");
        if (i < 0) {
            return 0;
        }
        return i > this.f12317a.this$0.getMeasuredHeight() - view.getMeasuredHeight() ? this.f12317a.this$0.getMeasuredHeight() - view.getMeasuredHeight() : i;
    }
}
