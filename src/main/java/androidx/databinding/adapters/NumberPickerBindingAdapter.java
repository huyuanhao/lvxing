package androidx.databinding.adapters;

import android.widget.NumberPicker;
import android.widget.NumberPicker.OnValueChangeListener;
import androidx.databinding.InverseBindingListener;

public class NumberPickerBindingAdapter {
    public static void setValue(NumberPicker numberPicker, int i) {
        if (numberPicker.getValue() != i) {
            numberPicker.setValue(i);
        }
    }

    public static void setListeners(NumberPicker numberPicker, final OnValueChangeListener onValueChangeListener, final InverseBindingListener inverseBindingListener) {
        if (inverseBindingListener == null) {
            numberPicker.setOnValueChangedListener(onValueChangeListener);
        } else {
            numberPicker.setOnValueChangedListener(new OnValueChangeListener() {
                public void onValueChange(NumberPicker numberPicker, int i, int i2) {
                    OnValueChangeListener onValueChangeListener = onValueChangeListener;
                    if (onValueChangeListener != null) {
                        onValueChangeListener.onValueChange(numberPicker, i, i2);
                    }
                    inverseBindingListener.onChange();
                }
            });
        }
    }
}
