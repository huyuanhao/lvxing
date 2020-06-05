package androidx.databinding.adapters;

import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import androidx.databinding.InverseBindingListener;

public class SeekBarBindingAdapter {

    /* renamed from: androidx.databinding.adapters.SeekBarBindingAdapter$OnProgressChanged */
    public interface OnProgressChanged {
        void onProgressChanged(SeekBar seekBar, int i, boolean z);
    }

    /* renamed from: androidx.databinding.adapters.SeekBarBindingAdapter$OnStartTrackingTouch */
    public interface OnStartTrackingTouch {
        void onStartTrackingTouch(SeekBar seekBar);
    }

    /* renamed from: androidx.databinding.adapters.SeekBarBindingAdapter$OnStopTrackingTouch */
    public interface OnStopTrackingTouch {
        void onStopTrackingTouch(SeekBar seekBar);
    }

    public static void setProgress(SeekBar seekBar, int i) {
        if (i != seekBar.getProgress()) {
            seekBar.setProgress(i);
        }
    }

    public static void setOnSeekBarChangeListener(SeekBar seekBar, final OnStartTrackingTouch onStartTrackingTouch, final OnStopTrackingTouch onStopTrackingTouch, final OnProgressChanged onProgressChanged, final InverseBindingListener inverseBindingListener) {
        if (onStartTrackingTouch == null && onStopTrackingTouch == null && onProgressChanged == null && inverseBindingListener == null) {
            seekBar.setOnSeekBarChangeListener(null);
        } else {
            seekBar.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
                public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                    OnProgressChanged onProgressChanged = onProgressChanged;
                    if (onProgressChanged != null) {
                        onProgressChanged.onProgressChanged(seekBar, i, z);
                    }
                    InverseBindingListener inverseBindingListener = inverseBindingListener;
                    if (inverseBindingListener != null) {
                        inverseBindingListener.onChange();
                    }
                }

                public void onStartTrackingTouch(SeekBar seekBar) {
                    OnStartTrackingTouch onStartTrackingTouch = onStartTrackingTouch;
                    if (onStartTrackingTouch != null) {
                        onStartTrackingTouch.onStartTrackingTouch(seekBar);
                    }
                }

                public void onStopTrackingTouch(SeekBar seekBar) {
                    OnStopTrackingTouch onStopTrackingTouch = onStopTrackingTouch;
                    if (onStopTrackingTouch != null) {
                        onStopTrackingTouch.onStopTrackingTouch(seekBar);
                    }
                }
            });
        }
    }
}
