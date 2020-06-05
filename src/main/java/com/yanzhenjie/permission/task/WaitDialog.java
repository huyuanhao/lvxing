package com.yanzhenjie.permission.task;

import android.content.Context;
import androidx.appcompat.app.AppCompatDialog;
import com.yanzhenjie.permission.R;

public class WaitDialog extends AppCompatDialog {
    public WaitDialog(Context context) {
        super(context, R.style.Permission_Theme_Dialog_Wait);
        setContentView(R.layout.permission_dialog_wait);
    }
}
