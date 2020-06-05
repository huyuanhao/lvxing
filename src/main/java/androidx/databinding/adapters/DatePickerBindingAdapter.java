package androidx.databinding.adapters;

import android.widget.DatePicker;
import android.widget.DatePicker.OnDateChangedListener;
import androidx.databinding.InverseBindingListener;
import androidx.databinding.library.baseAdapters.C0269R;

public class DatePickerBindingAdapter {

    /* renamed from: androidx.databinding.adapters.DatePickerBindingAdapter$DateChangedListener */
    private static class DateChangedListener implements OnDateChangedListener {
        InverseBindingListener mDayChanged;
        OnDateChangedListener mListener;
        InverseBindingListener mMonthChanged;
        InverseBindingListener mYearChanged;

        private DateChangedListener() {
        }

        public void setListeners(OnDateChangedListener onDateChangedListener, InverseBindingListener inverseBindingListener, InverseBindingListener inverseBindingListener2, InverseBindingListener inverseBindingListener3) {
            this.mListener = onDateChangedListener;
            this.mYearChanged = inverseBindingListener;
            this.mMonthChanged = inverseBindingListener2;
            this.mDayChanged = inverseBindingListener3;
        }

        public void onDateChanged(DatePicker datePicker, int i, int i2, int i3) {
            OnDateChangedListener onDateChangedListener = this.mListener;
            if (onDateChangedListener != null) {
                onDateChangedListener.onDateChanged(datePicker, i, i2, i3);
            }
            InverseBindingListener inverseBindingListener = this.mYearChanged;
            if (inverseBindingListener != null) {
                inverseBindingListener.onChange();
            }
            InverseBindingListener inverseBindingListener2 = this.mMonthChanged;
            if (inverseBindingListener2 != null) {
                inverseBindingListener2.onChange();
            }
            InverseBindingListener inverseBindingListener3 = this.mDayChanged;
            if (inverseBindingListener3 != null) {
                inverseBindingListener3.onChange();
            }
        }
    }

    public static void setListeners(DatePicker datePicker, int i, int i2, int i3, OnDateChangedListener onDateChangedListener, InverseBindingListener inverseBindingListener, InverseBindingListener inverseBindingListener2, InverseBindingListener inverseBindingListener3) {
        if (i == 0) {
            i = datePicker.getYear();
        }
        if (i3 == 0) {
            i3 = datePicker.getDayOfMonth();
        }
        if (inverseBindingListener == null && inverseBindingListener2 == null && inverseBindingListener3 == null) {
            datePicker.init(i, i2, i3, onDateChangedListener);
            return;
        }
        DateChangedListener dateChangedListener = (DateChangedListener) ListenerUtil.getListener(datePicker, C0269R.C0270id.onDateChanged);
        if (dateChangedListener == null) {
            dateChangedListener = new DateChangedListener();
            ListenerUtil.trackListener(datePicker, dateChangedListener, C0269R.C0270id.onDateChanged);
        }
        dateChangedListener.setListeners(onDateChangedListener, inverseBindingListener, inverseBindingListener2, inverseBindingListener3);
        datePicker.init(i, i2, i3, dateChangedListener);
    }
}
