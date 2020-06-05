package com.yanzhenjie.album.widget.divider;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.State;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

public class Api20ItemDivider extends Divider {
    /* renamed from: a */
    private final int f26348a;
    /* renamed from: b */
    private final int f26349b;
    /* renamed from: c */
    private final Drawer f26350c;

    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, State state) {
        LayoutManager layoutManager = recyclerView.getLayoutManager();
        if (layoutManager instanceof LinearLayoutManager) {
            int a = m33644a(layoutManager);
            int childLayoutPosition = recyclerView.getChildLayoutPosition(view);
            int b = m33648b(layoutManager);
            int itemCount = layoutManager.getItemCount();
            if (a == 1) {
                m33650b(rect, childLayoutPosition, b, itemCount);
            } else {
                m33646a(rect, childLayoutPosition, b, itemCount);
            }
        } else if (layoutManager instanceof StaggeredGridLayoutManager) {
            int i = this.f26348a;
            int i2 = this.f26349b;
            rect.set(i, i2, i, i2);
        }
    }

    /* renamed from: a */
    private void m33646a(Rect rect, int i, int i2, int i3) {
        boolean a = m33647a(0, i, i2, i3);
        boolean b = m33651b(0, i, i2, i3);
        boolean c = m33652c(0, i, i2, i3);
        boolean d = m33653d(0, i, i2, i3);
        if (i2 == 1) {
            if (c && d) {
                rect.set(0, 0, 0, 0);
            } else if (c) {
                rect.set(0, 0, this.f26348a, 0);
            } else if (d) {
                rect.set(this.f26348a, 0, 0, 0);
            } else {
                int i4 = this.f26348a;
                rect.set(i4, 0, i4, 0);
            }
        } else if (c && a) {
            rect.set(0, 0, this.f26348a, this.f26349b);
        } else if (c && b) {
            rect.set(0, this.f26349b, this.f26348a, 0);
        } else if (d && a) {
            rect.set(this.f26348a, 0, 0, this.f26349b);
        } else if (d && b) {
            rect.set(this.f26348a, this.f26349b, 0, 0);
        } else if (c) {
            int i5 = this.f26349b;
            rect.set(0, i5, this.f26348a, i5);
        } else if (d) {
            int i6 = this.f26348a;
            int i7 = this.f26349b;
            rect.set(i6, i7, 0, i7);
        } else if (a) {
            int i8 = this.f26348a;
            rect.set(i8, 0, i8, this.f26349b);
        } else if (b) {
            int i9 = this.f26348a;
            rect.set(i9, this.f26349b, i9, 0);
        } else {
            int i10 = this.f26348a;
            int i11 = this.f26349b;
            rect.set(i10, i11, i10, i11);
        }
    }

    /* renamed from: b */
    private void m33650b(Rect rect, int i, int i2, int i3) {
        boolean a = m33647a(1, i, i2, i3);
        boolean b = m33651b(1, i, i2, i3);
        boolean c = m33652c(1, i, i2, i3);
        boolean d = m33653d(1, i, i2, i3);
        if (i2 == 1) {
            if (a && b) {
                rect.set(0, 0, 0, 0);
            } else if (a) {
                rect.set(0, 0, 0, this.f26349b);
            } else if (b) {
                rect.set(0, this.f26349b, 0, 0);
            } else {
                int i4 = this.f26349b;
                rect.set(0, i4, 0, i4);
            }
        } else if (a && c) {
            rect.set(0, 0, this.f26348a, this.f26349b);
        } else if (a && d) {
            rect.set(this.f26348a, 0, 0, this.f26349b);
        } else if (b && c) {
            rect.set(0, this.f26349b, this.f26348a, 0);
        } else if (b && d) {
            rect.set(this.f26348a, this.f26349b, 0, 0);
        } else if (a) {
            int i5 = this.f26348a;
            rect.set(i5, 0, i5, this.f26349b);
        } else if (b) {
            int i6 = this.f26348a;
            rect.set(i6, this.f26349b, i6, 0);
        } else if (c) {
            int i7 = this.f26349b;
            rect.set(0, i7, this.f26348a, i7);
        } else if (d) {
            int i8 = this.f26348a;
            int i9 = this.f26349b;
            rect.set(i8, i9, 0, i9);
        } else {
            int i10 = this.f26348a;
            int i11 = this.f26349b;
            rect.set(i10, i11, i10, i11);
        }
    }

    /* renamed from: a */
    private int m33644a(LayoutManager layoutManager) {
        if (layoutManager instanceof LinearLayoutManager) {
            return ((LinearLayoutManager) layoutManager).getOrientation();
        }
        if (layoutManager instanceof StaggeredGridLayoutManager) {
            return ((StaggeredGridLayoutManager) layoutManager).getOrientation();
        }
        return 1;
    }

    /* renamed from: b */
    private int m33648b(LayoutManager layoutManager) {
        if (layoutManager instanceof GridLayoutManager) {
            return ((GridLayoutManager) layoutManager).getSpanCount();
        }
        if (layoutManager instanceof StaggeredGridLayoutManager) {
            return ((StaggeredGridLayoutManager) layoutManager).getSpanCount();
        }
        return 1;
    }

    /* renamed from: a */
    private boolean m33647a(int i, int i2, int i3, int i4) {
        boolean z = false;
        if (i == 1) {
            if (i2 < i3) {
                z = true;
            }
            return z;
        } else if (i3 == 1) {
            return true;
        } else {
            if (i2 % i3 == 0) {
                z = true;
            }
            return z;
        }
    }

    /* renamed from: b */
    private boolean m33651b(int i, int i2, int i3, int i4) {
        boolean z;
        boolean z2;
        boolean z3 = false;
        if (i == 1) {
            if (i3 == 1) {
                if (i2 + 1 == i4) {
                    z3 = true;
                }
                return z3;
            }
            int i5 = i4 % i3;
            int i6 = ((i4 - i5) / i3) + (i5 > 0 ? 1 : 0);
            int i7 = i2 + 1;
            int i8 = i7 % i3;
            if (i8 == 0) {
                if (i6 == i7 / i3) {
                    z3 = true;
                }
                return z3;
            }
            if (i6 == ((i7 - i8) / i3) + 1) {
                z2 = true;
            }
            return z2;
        } else if (i3 == 1) {
            return true;
        } else {
            if ((i2 + 1) % i3 == 0) {
                z = true;
            }
            return z;
        }
    }

    /* renamed from: c */
    private boolean m33652c(int i, int i2, int i3, int i4) {
        boolean z = false;
        if (i != 1) {
            if (i2 < i3) {
                z = true;
            }
            return z;
        } else if (i3 == 1) {
            return true;
        } else {
            if (i2 % i3 == 0) {
                z = true;
            }
            return z;
        }
    }

    /* renamed from: d */
    private boolean m33653d(int i, int i2, int i3, int i4) {
        boolean z;
        boolean z2;
        boolean z3 = false;
        if (i == 1) {
            if (i3 == 1) {
                return true;
            }
            if ((i2 + 1) % i3 == 0) {
                z3 = true;
            }
            return z3;
        } else if (i3 == 1) {
            if (i2 + 1 == i4) {
                z3 = true;
            }
            return z3;
        } else {
            int i5 = i4 % i3;
            int i6 = ((i4 - i5) / i3) + (i5 > 0 ? 1 : 0);
            int i7 = i2 + 1;
            int i8 = i7 % i3;
            if (i8 == 0) {
                if (i6 == i7 / i3) {
                    z2 = true;
                }
                return z2;
            }
            if (i6 == ((i7 - i8) / i3) + 1) {
                z = true;
            }
            return z;
        }
    }

    public void onDraw(Canvas canvas, RecyclerView recyclerView, State state) {
        LayoutManager layoutManager = recyclerView.getLayoutManager();
        int a = m33644a(layoutManager);
        int b = m33648b(layoutManager);
        int childCount = layoutManager.getChildCount();
        if (layoutManager instanceof LinearLayoutManager) {
            canvas.save();
            for (int i = 0; i < childCount; i++) {
                View childAt = layoutManager.getChildAt(i);
                int childLayoutPosition = recyclerView.getChildLayoutPosition(childAt);
                if (a == 1) {
                    m33649b(canvas, childAt, childLayoutPosition, b, childCount);
                } else {
                    m33645a(canvas, childAt, childLayoutPosition, b, childCount);
                }
            }
            canvas.restore();
        } else if (layoutManager instanceof StaggeredGridLayoutManager) {
            canvas.save();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt2 = layoutManager.getChildAt(i2);
                this.f26350c.mo37723a(childAt2, canvas);
                this.f26350c.mo37724b(childAt2, canvas);
                this.f26350c.mo37725c(childAt2, canvas);
                this.f26350c.mo37726d(childAt2, canvas);
            }
            canvas.restore();
        }
    }

    /* renamed from: a */
    private void m33645a(Canvas canvas, View view, int i, int i2, int i3) {
        boolean a = m33647a(0, i, i2, i3);
        boolean b = m33651b(0, i, i2, i3);
        boolean c = m33652c(0, i, i2, i3);
        boolean d = m33653d(0, i, i2, i3);
        if (i2 == 1) {
            if (a && d) {
                return;
            }
            if (c) {
                this.f26350c.mo37725c(view, canvas);
            } else if (d) {
                this.f26350c.mo37723a(view, canvas);
            } else {
                this.f26350c.mo37723a(view, canvas);
                this.f26350c.mo37725c(view, canvas);
            }
        } else if (c && a) {
            this.f26350c.mo37725c(view, canvas);
            this.f26350c.mo37726d(view, canvas);
        } else if (c && b) {
            this.f26350c.mo37724b(view, canvas);
            this.f26350c.mo37725c(view, canvas);
        } else if (d && a) {
            this.f26350c.mo37723a(view, canvas);
            this.f26350c.mo37726d(view, canvas);
        } else if (d && b) {
            this.f26350c.mo37723a(view, canvas);
            this.f26350c.mo37724b(view, canvas);
        } else if (c) {
            this.f26350c.mo37724b(view, canvas);
            this.f26350c.mo37725c(view, canvas);
            this.f26350c.mo37726d(view, canvas);
        } else if (d) {
            this.f26350c.mo37723a(view, canvas);
            this.f26350c.mo37724b(view, canvas);
            this.f26350c.mo37726d(view, canvas);
        } else if (a) {
            this.f26350c.mo37723a(view, canvas);
            this.f26350c.mo37725c(view, canvas);
            this.f26350c.mo37726d(view, canvas);
        } else if (b) {
            this.f26350c.mo37723a(view, canvas);
            this.f26350c.mo37724b(view, canvas);
            this.f26350c.mo37725c(view, canvas);
        } else {
            this.f26350c.mo37723a(view, canvas);
            this.f26350c.mo37724b(view, canvas);
            this.f26350c.mo37725c(view, canvas);
            this.f26350c.mo37726d(view, canvas);
        }
    }

    /* renamed from: b */
    private void m33649b(Canvas canvas, View view, int i, int i2, int i3) {
        boolean a = m33647a(1, i, i2, i3);
        boolean b = m33651b(1, i, i2, i3);
        boolean c = m33652c(1, i, i2, i3);
        boolean d = m33653d(1, i, i2, i3);
        if (i2 == 1) {
            if (a && b) {
                return;
            }
            if (a) {
                this.f26350c.mo37726d(view, canvas);
            } else if (b) {
                this.f26350c.mo37724b(view, canvas);
            } else {
                this.f26350c.mo37724b(view, canvas);
                this.f26350c.mo37726d(view, canvas);
            }
        } else if (a && c) {
            this.f26350c.mo37725c(view, canvas);
            this.f26350c.mo37726d(view, canvas);
        } else if (a && d) {
            this.f26350c.mo37723a(view, canvas);
            this.f26350c.mo37726d(view, canvas);
        } else if (b && c) {
            this.f26350c.mo37724b(view, canvas);
            this.f26350c.mo37725c(view, canvas);
        } else if (b && d) {
            this.f26350c.mo37723a(view, canvas);
            this.f26350c.mo37724b(view, canvas);
        } else if (a) {
            this.f26350c.mo37723a(view, canvas);
            this.f26350c.mo37725c(view, canvas);
            this.f26350c.mo37726d(view, canvas);
        } else if (b) {
            this.f26350c.mo37723a(view, canvas);
            this.f26350c.mo37724b(view, canvas);
            this.f26350c.mo37725c(view, canvas);
        } else if (c) {
            this.f26350c.mo37724b(view, canvas);
            this.f26350c.mo37725c(view, canvas);
            this.f26350c.mo37726d(view, canvas);
        } else if (d) {
            this.f26350c.mo37723a(view, canvas);
            this.f26350c.mo37724b(view, canvas);
            this.f26350c.mo37726d(view, canvas);
        } else {
            this.f26350c.mo37723a(view, canvas);
            this.f26350c.mo37724b(view, canvas);
            this.f26350c.mo37725c(view, canvas);
            this.f26350c.mo37726d(view, canvas);
        }
    }
}
