package androidx.databinding.adapters;

import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import androidx.databinding.InverseBindingListener;

public class CompoundButtonBindingAdapter {
    public static void setChecked(CompoundButton compoundButton, boolean z) {
        if (compoundButton.isChecked() != z) {
            compoundButton.setChecked(z);
        }
    }

    public static void setListeners(CompoundButton compoundButton, final OnCheckedChangeListener onCheckedChangeListener, final InverseBindingListener inverseBindingListener) {
        if (inverseBindingListener == null) {
            compoundButton.setOnCheckedChangeListener(onCheckedChangeListener);
        } else {
            compoundButton.setOnCheckedChangeListener(new OnCheckedChangeListener() {
                public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    OnCheckedChangeListener onCheckedChangeListener = onCheckedChangeListener;
                    if (onCheckedChangeListener != null) {
                        onCheckedChangeListener.onCheckedChanged(compoundButton, z);
                    }
                    inverseBindingListener.onChange();
                }
            });
        }
    }
}
