package discoveryAD;

import android.content.Context;
import android.view.View;

/* renamed from: discoveryAD.N */
public class C7872N extends View {
    private C7871M mListener;

    public C7872N(Context context, C7871M m) {
        super(context);
        this.mListener = m;
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        this.mListener.mo38140b(this);
        super.onDetachedFromWindow();
    }

    /* access modifiers changed from: protected */
    public void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (i == 0) {
            this.mListener.mo38138a(this);
        } else {
            this.mListener.mo38140b(this);
        }
    }
}
