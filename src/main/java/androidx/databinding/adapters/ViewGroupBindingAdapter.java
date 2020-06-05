package androidx.databinding.adapters;

import android.animation.LayoutTransition;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.OnHierarchyChangeListener;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

public class ViewGroupBindingAdapter {

    /* renamed from: androidx.databinding.adapters.ViewGroupBindingAdapter$OnAnimationEnd */
    public interface OnAnimationEnd {
        void onAnimationEnd(Animation animation);
    }

    /* renamed from: androidx.databinding.adapters.ViewGroupBindingAdapter$OnAnimationRepeat */
    public interface OnAnimationRepeat {
        void onAnimationRepeat(Animation animation);
    }

    /* renamed from: androidx.databinding.adapters.ViewGroupBindingAdapter$OnAnimationStart */
    public interface OnAnimationStart {
        void onAnimationStart(Animation animation);
    }

    /* renamed from: androidx.databinding.adapters.ViewGroupBindingAdapter$OnChildViewAdded */
    public interface OnChildViewAdded {
        void onChildViewAdded(View view, View view2);
    }

    /* renamed from: androidx.databinding.adapters.ViewGroupBindingAdapter$OnChildViewRemoved */
    public interface OnChildViewRemoved {
        void onChildViewRemoved(View view, View view2);
    }

    public static void setAnimateLayoutChanges(ViewGroup viewGroup, boolean z) {
        if (z) {
            viewGroup.setLayoutTransition(new LayoutTransition());
        } else {
            viewGroup.setLayoutTransition(null);
        }
    }

    public static void setListener(ViewGroup viewGroup, final OnChildViewAdded onChildViewAdded, final OnChildViewRemoved onChildViewRemoved) {
        if (onChildViewAdded == null && onChildViewRemoved == null) {
            viewGroup.setOnHierarchyChangeListener(null);
        } else {
            viewGroup.setOnHierarchyChangeListener(new OnHierarchyChangeListener() {
                public void onChildViewAdded(View view, View view2) {
                    OnChildViewAdded onChildViewAdded = onChildViewAdded;
                    if (onChildViewAdded != null) {
                        onChildViewAdded.onChildViewAdded(view, view2);
                    }
                }

                public void onChildViewRemoved(View view, View view2) {
                    OnChildViewRemoved onChildViewRemoved = onChildViewRemoved;
                    if (onChildViewRemoved != null) {
                        onChildViewRemoved.onChildViewRemoved(view, view2);
                    }
                }
            });
        }
    }

    public static void setListener(ViewGroup viewGroup, final OnAnimationStart onAnimationStart, final OnAnimationEnd onAnimationEnd, final OnAnimationRepeat onAnimationRepeat) {
        if (onAnimationStart == null && onAnimationEnd == null && onAnimationRepeat == null) {
            viewGroup.setLayoutAnimationListener(null);
        } else {
            viewGroup.setLayoutAnimationListener(new AnimationListener() {
                public void onAnimationStart(Animation animation) {
                    OnAnimationStart onAnimationStart = onAnimationStart;
                    if (onAnimationStart != null) {
                        onAnimationStart.onAnimationStart(animation);
                    }
                }

                public void onAnimationEnd(Animation animation) {
                    OnAnimationEnd onAnimationEnd = onAnimationEnd;
                    if (onAnimationEnd != null) {
                        onAnimationEnd.onAnimationEnd(animation);
                    }
                }

                public void onAnimationRepeat(Animation animation) {
                    OnAnimationRepeat onAnimationRepeat = onAnimationRepeat;
                    if (onAnimationRepeat != null) {
                        onAnimationRepeat.onAnimationRepeat(animation);
                    }
                }
            });
        }
    }
}
