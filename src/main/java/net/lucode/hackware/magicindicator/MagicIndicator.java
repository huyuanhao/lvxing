package net.lucode.hackware.magicindicator;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import net.lucode.hackware.magicindicator.p694a.IPagerNavigator;

public class MagicIndicator extends FrameLayout {
    /* renamed from: a */
    private IPagerNavigator f28070a;

    public MagicIndicator(Context context) {
        super(context);
    }

    public MagicIndicator(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* renamed from: a */
    public void mo39887a(int i, float f, int i2) {
        IPagerNavigator aVar = this.f28070a;
        if (aVar != null) {
            aVar.mo39893a(i, f, i2);
        }
    }

    /* renamed from: a */
    public void mo39886a(int i) {
        IPagerNavigator aVar = this.f28070a;
        if (aVar != null) {
            aVar.mo39892a(i);
        }
    }

    /* renamed from: b */
    public void mo39888b(int i) {
        IPagerNavigator aVar = this.f28070a;
        if (aVar != null) {
            aVar.mo39895b(i);
        }
    }

    public IPagerNavigator getNavigator() {
        return this.f28070a;
    }

    public void setNavigator(IPagerNavigator aVar) {
        IPagerNavigator aVar2 = this.f28070a;
        if (aVar2 != aVar) {
            if (aVar2 != null) {
                aVar2.mo39894b();
            }
            this.f28070a = aVar;
            removeAllViews();
            if (this.f28070a instanceof View) {
                addView((View) this.f28070a, new LayoutParams(-1, -1));
                this.f28070a.mo39891a();
            }
        }
    }
}
