package com.qiyukf.nim.uikit.session.p425a;

import android.content.Intent;
import com.qiyukf.basesdk.p412c.p416c.C5406d;
import com.qiyukf.nim.uikit.common.fragment.TFragment;
import com.qiyukf.nim.uikit.session.helper.C5557c;
import com.qiyukf.nim.uikit.session.helper.C5563d;
import com.qiyukf.nim.uikit.session.helper.C5563d.C5564a;
import com.qiyukf.nimlib.p488k.p491c.C5944b;
import com.qiyukf.nimlib.p488k.p491c.C5946c;
import com.qiyukf.unicorn.api.customization.action.BaseAction;
import java.io.File;
import java.io.Serializable;

/* renamed from: com.qiyukf.nim.uikit.session.a.a */
public abstract class C5491a extends BaseAction implements Serializable {
    private C5564a callback = new C5564a() {
        public final void sendImage(File file, String str, boolean z) {
            C5491a.this.onPicked(file);
        }
    };
    private boolean multiSelect;
    private C5557c pickImageAndVideoHelper;

    protected C5491a(int i, int i2, boolean z) {
        super(i, i2);
        this.multiSelect = z;
    }

    private String tempFile() {
        StringBuilder sb = new StringBuilder();
        sb.append(C5406d.m22120b());
        sb.append(".jpg");
        return C5946c.m23834a(sb.toString(), C5944b.TYPE_TEMP);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (i != 4) {
            if (i == 6) {
                C5563d.m22591a(getFragment(), intent, i, makeRequestCode(4), this.callback);
            }
            return;
        }
        C5563d.m22592a(getFragment(), intent, makeRequestCode(6), this.callback);
    }

    public void onClick() {
        C5557c.m22588a((TFragment) getFragment(), makeRequestCode(4), this.multiSelect, tempFile(), true);
    }

    public abstract void onPicked(File file);
}
