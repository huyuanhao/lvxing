package androidx.databinding.adapters;

import android.widget.CalendarView;
import android.widget.CalendarView.OnDateChangeListener;
import androidx.databinding.InverseBindingListener;

public class CalendarViewBindingAdapter {
    public static void setDate(CalendarView calendarView, long j) {
        if (calendarView.getDate() != j) {
            calendarView.setDate(j);
        }
    }

    public static void setListeners(CalendarView calendarView, final OnDateChangeListener onDateChangeListener, final InverseBindingListener inverseBindingListener) {
        if (inverseBindingListener == null) {
            calendarView.setOnDateChangeListener(onDateChangeListener);
        } else {
            calendarView.setOnDateChangeListener(new OnDateChangeListener() {
                public void onSelectedDayChange(CalendarView calendarView, int i, int i2, int i3) {
                    OnDateChangeListener onDateChangeListener = onDateChangeListener;
                    if (onDateChangeListener != null) {
                        onDateChangeListener.onSelectedDayChange(calendarView, i, i2, i3);
                    }
                    inverseBindingListener.onChange();
                }
            });
        }
    }
}
