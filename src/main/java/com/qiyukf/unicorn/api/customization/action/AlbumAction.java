package com.qiyukf.unicorn.api.customization.action;

import android.content.Intent;
import com.qiyukf.basesdk.p412c.C5399c;
import com.qiyukf.basesdk.p412c.C5399c.C5400a;
import com.qiyukf.basesdk.p412c.p416c.C5406d;
import com.qiyukf.basesdk.p412c.p417d.C5415g;
import com.qiyukf.nim.uikit.session.activity.PickImageActivity;
import com.qiyukf.nim.uikit.session.helper.C5563d;
import com.qiyukf.nim.uikit.session.helper.C5563d.C5564a;
import com.qiyukf.nimlib.p488k.p491c.C5944b;
import com.qiyukf.nimlib.p488k.p491c.C5946c;
import com.qiyukf.unicorn.C5961R;
import com.qiyukf.unicorn.api.msg.MessageService;
import com.tencent.mid.core.Constants;
import java.io.File;

public class AlbumAction extends BaseAction {
    int actionFontColor = 0;
    private C5564a callback = new C5564a() {
        public void sendImage(File file, String str, boolean z) {
            MessageService.sendMessage(AlbumAction.this.buidlImageMessage(file));
        }
    };

    public AlbumAction(int i, int i2) {
        super(i, i2);
    }

    /* access modifiers changed from: private */
    public String tempFile() {
        StringBuilder sb = new StringBuilder();
        sb.append(C5406d.m22120b());
        sb.append(".jpg");
        return C5946c.m23834a(sb.toString(), C5944b.TYPE_TEMP);
    }

    public int getActionFontColor() {
        int i = this.actionFontColor;
        return i == 0 ? super.getActionFontColor() : i;
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        C5563d.m22592a(getFragment(), intent, makeRequestCode(6), this.callback);
    }

    public void onClick() {
        final int makeRequestCode = makeRequestCode(4);
        C5399c.m22100a(getFragment()).mo27354a("android.permission.READ_EXTERNAL_STORAGE", Constants.PERMISSION_WRITE_EXTERNAL_STORAGE).mo27353a((C5400a) new C5400a() {
            public void onDenied() {
                C5415g.m22161a(C5961R.string.ysf_no_permission_photo);
            }

            public void onGranted() {
                PickImageActivity.start(AlbumAction.this.getFragment(), makeRequestCode, 1, AlbumAction.this.tempFile(), true, 9, false, false, 0, 0);
            }
        }).mo27355a();
    }

    public void setActionFontColor(int i) {
        this.actionFontColor = i;
    }
}
