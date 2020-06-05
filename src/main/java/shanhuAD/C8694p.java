package shanhuAD;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

/* renamed from: shanhuAD.p */
public abstract class C8694p extends View {
    public C8694p(Context context) {
        super(context);
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        mo41485wb();
        super.onDetachedFromWindow();
    }

    /* renamed from: vb */
    public abstract void mo41484vb();

    /* renamed from: wb */
    public abstract void mo41485wb();

    public C8694p(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
