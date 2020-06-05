package tech.linjiang.android.drawable;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;

/* renamed from: tech.linjiang.android.drawable.a */
public class ProxyDrawable extends StateListDrawable {
    /* renamed from: a */
    private Drawable f29577a;

    public void addState(int[] iArr, Drawable drawable) {
        if (iArr != null && iArr.length == 1 && iArr[0] == 0) {
            this.f29577a = drawable;
        }
        super.addState(iArr, drawable);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public Drawable mo41501a() {
        return this.f29577a;
    }
}
